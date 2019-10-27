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
import com.jks.entity.Experience;
import com.jks.service.LoginService;
import com.jks.service.ExperienceService;
import com.jks.utils.ExcelUtil;

@Controller
@RequestMapping("/exp")
public class ExperienceController {
	@Resource
	private ExperienceService expService;
	@Resource
	private LoginService loginService;

	/**
	 * 获取指定市州的所有学校的<编号,名称>map
	 * 
	 * @param city
	 * @return
	 */
	public Map<String, String> getAdmMap(String city) {
		List<String> adms = expService.getAdmcodeByCity("%" + city + "%");
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
	 * 分页查询在校体验信息，并判断是否条件查询
	 * 
	 * @param request
	 *            param 包含pageNum，pageSize，admcode，year，city五个参数的map
	 * @return
	 */
	@RequestMapping("/showExpInfo")
	public String showExpInfo(HttpServletRequest request, Model model) {
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
		PageInfo<Experience> expPage = null;
		try {
			expPage = expService.getExperiencePage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		List<Experience> expList = expPage.getList();
		model.addAttribute("expList", expList);// 查询结果列表
		model.addAttribute("expPage", expPage);// 分页信息
		if (param.get("year") != null) {// 供再次查询使用
			model.addAttribute("year", param.get("year"));
		}
		if (param.get("admcode") != null) {
			model.addAttribute("admcode", param.get("admcode"));
		}
		model.addAttribute("level", level);
		return "student/exp";
	}

	/**
	 * 返回添加在校体验信息的页面并设置年份选项
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addExp")
	public String addExpInfo(Model model) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("curYear", curYear);
		return "student/expAdd";
	}

	/**
	 * 执行插入在校体验信息的数据库操作
	 * 
	 * @param exp
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveExp")
	@ResponseBody
	public String saveExpInfo(Experience exp, HttpServletRequest request) {
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
		params.put("year", exp.getYear());
		if (this.expService.getExperiencePage(params).getList().size() > 0) {
			result = "{\"result\":\"该年份数据已存在\"}";
			return result;
		}
		exp.setAdmcode(admcode);
		exp.setCity(city);
		try {
			if (!expService.addExperience(exp)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 返回更新在校体验信息的页面并根据相应ip填充初始内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateExp")
	public String updateExpInfo(HttpServletRequest request, Model model,String detailFlag) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int id = Integer.parseInt(request.getParameter("id"));
		Experience exp = null;
		try {
			exp = expService.getExperienceById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("curYear", curYear);
		model.addAttribute("exp", exp);
		model.addAttribute("detailFlag", detailFlag);
		return "student/expUpd";
	}

	/**
	 * 执行更新在校体验信息的数据库操作
	 * 
	 * @param exp
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifyExp")
	@ResponseBody
	public String modifyExpInfo(Experience exp, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		exp.setId(id);
		String result = "{\"result\":\"success\"}";
		try {
			if (!expService.modifyExperience(exp)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 查询单条在校体验信息的详细内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showExpDetail")
	public String showExpDetail(HttpServletRequest request, Model model,String detailFlag) {
		int id = Integer.parseInt(request.getParameter("id"));
		Experience exp = null;
		try {
			exp = expService.getExperienceById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("exp", exp);
		model.addAttribute("detailFlag", detailFlag);
		return "student/expUpd";
	}

	/**
	 * 删除选中id的在校体验信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteExp")
	public void deleteExpInfo(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (expService.deleteExperience(id)) {
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
	 * 修改id对应的在校体验信息状态为审核通过
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("audit")
	public void audit(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		Experience exp = new Experience();
		exp.setId(id);
		exp.setAudit(1);
		if (expService.modifyExperience(exp)) {
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
		PageInfo<Experience> expPage = null;
		try {
			expPage = expService.getExperiencePage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		List<Experience> expList = expPage.getList();
		String fileName = "";
		if (!"".equals(year)) {// 对应"&year="的链接
			fileName += year;
			if (!"".equals(admcode)) {// 对应"&admcode="的链接
				fileName += ("-" + loginService.getSchoolInfo(admcode).getSchoolname());
			}
		} else if (!"".equals(admcode)) {// 对应"&admcode="的链接
			fileName += loginService.getSchoolInfo(admcode).getSchoolname();
		}
		fileName += "在校体验汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));

		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份", "地区", "理论学习满意度-非常满意", "理论学习满意度-基本满意", "理论学习满意度-不满意", "专业学习满意度-非常满意",
					"专业学习满意度-基本满意", "专业学习满意度-不满意", "实习实训满意度-非常满意", "实习实训满意度-基本满意", "实习实训满意度-不满意", "校园文化与社团活动满意度-非常满意",
					"校园文化与社团活动满意度-基本满意", "校园文化与社团活动满意度-不满意", "生活满意度-非常满意", "生活满意度-基本满意", "生活满意度-不满意", "校园安全满意度-非常满意",
					"校园安全满意度-基本满意", "校园安全满意度-不满意", "毕业生对学校满意度-非常满意", "毕业生对学校满意度-基本满意", "毕业生对学校满意度-不满意" };
			excelUtil.writeTitle(title);
			Iterator<Experience> iterator = expList.iterator();
			while (iterator.hasNext()) {
				Experience exp = (Experience) iterator.next();
				if (exp.getAudit() == 1) {
					excelUtil.write(exp);
				}
			}
			excelUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
