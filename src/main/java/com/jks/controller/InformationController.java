package com.jks.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageInfo;
import com.jks.entity.EmployQuality;
import com.jks.entity.Information;
import com.jks.entity.InformationDTO;
import com.jks.service.InformationService;
import com.jks.service.LoginService;
import com.jks.utils.ExcelUtil;

@Controller
@RequestMapping("/info")
public class InformationController {
	@Resource
	private InformationService infoService;
	@Resource
	private LoginService loginService;

	/**
	 * 分页查询信息化建设，并判断是否条件查询
	 * 
	 * @param request
	 *            param 包含pageNum，pageSize，admcode，year，city五个参数的map
	 * @param model
	 * @return
	 */
	@RequestMapping("/getInformation")
	public String getInfoList(HttpServletRequest request, Model model) {
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
			city = (String) session.getAttribute("city");
			param.put("city", "%" + city + "%");
			param.put("audit", 1);
			admcode = (String) param.get("admcode");
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

		PageInfo<Information> infoPage = null;
		try {
			infoPage = infoService.getInformationPage(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

		List<Information> infoList = infoPage.getList();
		model.addAttribute("infoList", infoList);// 查询结果列表
		model.addAttribute("infoPage", infoPage);// 分页信息
		if (param.get("year") != null) {// 供再次查询使用
			model.addAttribute("year", param.get("year"));
		}
		if (param.get("admcode") != null) {
			model.addAttribute("admcode", param.get("admcode"));
		}
		model.addAttribute("level", level);
		return "basic/info";
	}

	/**
	 * 获取指定市州的所有学校的<编号,名称>map
	 * 
	 * @param city
	 * @return
	 */
	public Map<String, String> getAdmMap(String city) {
		List<String> adms = infoService.getAdmcodeByCity("%" + city + "%");
		Map<String, String> admMap = new HashMap<String, String>();
		Iterator<String> iterator = adms.iterator();
		while (iterator.hasNext()) {
			String admcode = iterator.next();
			String name = loginService.getSchoolInfo(admcode).getSchoolname();
			// System.out.println(admcode+";"+name);
			admMap.put(admcode, name);
		}
		return admMap;
	}

	/**
	 * 返回添加教师队伍信息的页面并设置年份选项
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addInfo")
	public String addTeacInfo(Model model) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("curYear", curYear);
		return "basic/infoAdd";
	}

	/**
	 * 执行插入信息化的数据库操作
	 * 
	 * @param teac
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addInfo", method = RequestMethod.POST)
	@ResponseBody
	public String addInfo(Information info, HttpServletRequest request) {
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
		params.put("year", info.getYear());
		if (infoService.getInformationPage(params).getList().size() > 0) {
			result = "{\"result\":\"该年份数据已存在\"}";
			return result;
		}
		info.setAdmcode(admcode);
		info.setCity(city);
		try {
			if (!infoService.addInformation(info)) {
				// System.out.println("Add data of admcode:
				// "+teac.getAdmcode()+" success!");
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 返回更新信息化的页面并根据相应id填充初始内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateInfo")
	public String updateInfo(HttpServletRequest request, Model model,String detailFlag) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int id = Integer.parseInt(request.getParameter("id"));
		Information info = null;
		try {
			info = infoService.getInformationById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("curYear", curYear);
		model.addAttribute("info", info);
		model.addAttribute("detailFlag", detailFlag);
		return "basic/infoUpd";
	}

	/**
	 * 执行更新信息化的数据库操作
	 * 
	 * @param teac
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifyInfo")
	@ResponseBody
	public String modifyTeacInfo(Information info, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		info.setId(id);
		String result = "{\"result\":\"success\"}";
		try {
			if (!infoService.modifyInfo(info)) {
				// System.out.println("Update data of id: "+id+ " success!");
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 删除选中id的信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteInfo")
	public void deleteTeacInfo(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (infoService.deleteInfo(id)) {
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
	 * 查询单条信息的详细内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showInfoDetail")
	public String showTeacDetail(HttpServletRequest request, Model model,String detailFlag) {
		int id = Integer.parseInt(request.getParameter("id"));
		Information info = null;
		try {
			info = infoService.getInformationById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("info", info);
		model.addAttribute("detailFlag", detailFlag);
		return "basic/infoUpd";
	}

	/**
	 * 修改id对应的信息状态为审核通过
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("audit")
	public void audit(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		Information info = new Information();
		info.setId(id);
		info.setAudit(1);
		if (infoService.modifyInfo(info)) {
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
		PageInfo<Information> infoPage = null;
		try {
			infoPage = infoService.getInformationPage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		List<Information> infoList = infoPage.getList();
		
		String fileName = "";
		if (!"".equals(year)) {// 对应"&year="的链接
			fileName += year;
			if (!"".equals(admcode)) {// 对应"&admcode="的链接
				fileName += ("-" + loginService.getSchoolInfo(admcode).getSchoolname());
			}
		} else if (!"".equals(admcode)) {// 对应"&admcode="的链接
			fileName += loginService.getSchoolInfo(admcode).getSchoolname();
		}
		fileName += "信息化建设汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));

		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份", "地区","是否设立教育信息化技术中心", "校园网络出口总带宽(Mbps)", "校园网主干带宽(Mbps)",
					"生均数字教学视频资源量（小时/生）","生均电子图书总量（册/生）", "教学用计算机台数", "生均教学用计算机台数", "是否建立协同办公系统",
					"是否建立学校门户网站", "是否建立教务管理系统", "是否建立课程资源库储存教案、讲义等材料", "是否建立课程直播、录播平台", "是否建立学生和教师的互动学习应用",
					"是否建立课程资源共享应用" };
			excelUtil.writeTitle(title);
			Iterator<Information> iterator = infoList.iterator();
			
			while (iterator.hasNext()) {
				Information info = (Information) iterator.next();
				if (info.getAudit() == 1) {
					
					excelUtil.write(new InformationDTO(info));
				}
			}
			excelUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
