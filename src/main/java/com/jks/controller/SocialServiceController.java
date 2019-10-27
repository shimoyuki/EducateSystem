package com.jks.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageInfo;
import com.jks.entity.SocialService;
import com.jks.service.LoginService;
import com.jks.service.SocialServiceService;
import com.jks.utils.ExcelUtil;

@Controller
@RequestMapping("/social")
public class SocialServiceController {
	@Resource
	private SocialServiceService socialService;
	@Resource
	private LoginService loginService;

	/**
	 * 获取指定市州的所有学校的<编号,名称>map
	 * 
	 * @param city
	 * @return
	 */
	public Map<String, String> getAdmMap(String city) {
		List<String> adms = socialService.getAdmcodeByCity("%" + city + "%");
		Map<String, String> admMap = new HashMap<String, String>();
		Iterator<String> iterator = adms.iterator();
		while (iterator.hasNext()) {
			String admcode = iterator.next();
			String name = loginService.getSchoolInfo(admcode).getSchoolname();
			//System.out.println(admcode + ";" + name);
			admMap.put(admcode, name);
		}
		return admMap;
	}

	/**
	 * 分页查询社会服务信息，并判断是否条件查询
	 * 
	 * @param request
	 *            param 包含pageNum，pageSize，admcode，year，city五个参数的map
	 * @param model
	 * @return
	 */
	@RequestMapping("/showSocialInfo")
	public String showSocialInfo(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String level = (String) session.getAttribute("level");// 权限为空返回登录界面
		if (level == null) {
			return "redirect:/";
		}
		Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
		String year = (String) param.get("year"), admcode = "", city = "";
		if ("".equals(year)) {// 对应"&year="的链接
			param.remove("year");
		}
		if (level.equals("3")) {// 市州账号admcode为查询条件
			admcode = (String) param.get("admcode");
			city = (String) session.getAttribute("city");
			param.put("city", "%" + city + "%");
			param.put("audit", 1);
			if ("".equals(admcode)) {// 对应"&admcode="的链接
				param.remove("admcode");
			}
			// 用于市州级账号查询
			model.addAttribute("admMap", this.getAdmMap(city));
			model.addAttribute("curYear", Calendar.getInstance().get(Calendar.YEAR));
		} else {// 录入、审查账号获取默认admcode值
			admcode = (String) session.getAttribute("username");
			if (level.equals("2")) {
				admcode = admcode.substring(0, admcode.length() - 1);// 去除审查员usercode最后的"s"
			}
			param.put("admcode", admcode);
		}
		PageInfo<SocialService> socialPage = null;
		try {
			socialPage = socialService.getSocialServicePage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		List<SocialService> socialList = socialPage.getList();
		model.addAttribute("socialList", socialList);// 查询结果列表
		model.addAttribute("socialPage", socialPage);// 分页信息
		if (param.get("year") != null) {// 供再次查询使用
			model.addAttribute("year", param.get("year"));
		}
		if (param.get("admcode") != null) {
			model.addAttribute("admcode", param.get("admcode"));
		}
		model.addAttribute("level", level);
		return "social/social";
	}

	/**
	 * 返回添加社会服务信息的页面并设置年份选项
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addSocial")
	public String addSocialInfo(Model model) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("curYear", curYear);
		return "social/socialAdd";
	}

	/**
	 * 执行插入社会服务信息的数据库操作
	 * 
	 * @param social
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveSocial")
	@ResponseBody
	public String saveSocialInfo(SocialService social, HttpServletRequest request) {
		String admcode = null, city = null, result = "{\"result\":\"success\"}";
		HttpSession session = request.getSession();
		admcode = (String) session.getAttribute("username");
		city = (String) session.getAttribute("city");
		if (admcode == null || city == null) {
			result = "{\"result\":\"error\"}";
			return result;
		}
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("admcode", admcode);
		params.put("year", social.getYear());
		if (this.socialService.getSocialServicePage(params).getList().size() > 0) {
			result = "{\"result\":\"该年份数据已存在\"}";
			return result;
		}
		social.setAdmcode(admcode);
		social.setCity(city);
		try {
			if (!socialService.addSocialService(social)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 返回更新社会服务信息的页面并根据相应ip填充初始内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateSocial")
	public String updateSocialInfo(HttpServletRequest request, Model model,String detailFlag) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int id = Integer.parseInt(request.getParameter("id"));
		SocialService social = null;
		try {
			social = socialService.getSocialServiceById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("curYear", curYear);
		model.addAttribute("social", social);
		model.addAttribute("detailFlag", detailFlag);
		return "social/socialUpd";
	}

	/**
	 * 执行更新社会服务信息的数据库操作
	 * 
	 * @param social
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifySocial")
	@ResponseBody
	public String modifySocialInfo(SocialService social, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		social.setId(id);
		String result = "{\"result\":\"success\"}";
		try {
			if (!socialService.modifySocialService(social)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 查询单条社会服务信息的详细内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showSocialDetail")
	public String showSocialDetail(HttpServletRequest request, Model model,String detailFlag) {
		int id = Integer.parseInt(request.getParameter("id"));
		SocialService social = null;
		try {
			social = socialService.getSocialServiceById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("social", social);
		model.addAttribute("detailFlag", detailFlag);
		return "social/socialUpd";
	}

	/**
	 * 删除选中id的社会服务信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteSocial")
	public void deleteSocialInfo(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (socialService.deleteSocialService(id)) {
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改id对应的社会服务信息状态为审核通过
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("audit")
	public void audit(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		SocialService social = new SocialService();
		social.setId(id);
		social.setAudit(1);
		if (socialService.modifySocialService(social)) {
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/download")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String level = (String) session.getAttribute("level");// 权限为空
		if (level == null) {
			return;
		}
		Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
		String year = (String) param.get("year"), admcode = "", city = "";
		if ("".equals(year)) {// 对应"&year="的链接
			param.remove("year");
		}
		if (level.equals("3")) {// 市州账号admcode为查询条件
			admcode = (String) param.get("admcode");
			city = (String) session.getAttribute("city");
			param.put("city", "%" + city + "%");
			if ("".equals(admcode)) {// 对应"&admcode="的链接
				param.remove("admcode");
			}
		} else {// 录入、审查账号获取默认admcode值
			admcode = (String) session.getAttribute("username");
			if (level.equals("2")) {
				admcode = admcode.substring(0, admcode.length() - 1);// 去除审查员usercode最后的"s"
			}
			param.put("admcode", admcode);
		}
		param.put("pageSize", 0);
		PageInfo<SocialService> socialPage = null;
		try {
			socialPage = socialService.getSocialServicePage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		List<SocialService> socialList = socialPage.getList();
		String fileName = "";
		if (!"".equals(year)) {// 对应"&year="的链接
			fileName += year;
			if (!"".equals(admcode)) {// 对应"&admcode="的链接
				fileName += ("-" + loginService.getSchoolInfo(admcode).getSchoolname());
			}
		} else if (!"".equals(admcode)) {// 对应"&admcode="的链接
			fileName += loginService.getSchoolInfo(admcode).getSchoolname();
		}
		fileName += "社会服务汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));

		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份", "地区", "培训企业员工数", "培训残疾人人数", "培训失业人员人数", "培训农民工人数", "培训退役士兵人数", "技能鉴定项目人次",
					"师生参与当地技术服务人次" };
			excelUtil.writeTitle(title);
			Iterator<SocialService> iterator = socialList.iterator();
			while (iterator.hasNext()) {
				SocialService social = (SocialService) iterator.next();
				if (social.getAudit() == 1) {
					excelUtil.write(social);
				}
			}
			excelUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
