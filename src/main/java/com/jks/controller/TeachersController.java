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
import com.jks.entity.Teachers;
import com.jks.service.LoginService;
import com.jks.service.TeachersService;
import com.jks.utils.ExcelUtil;

@Controller
@RequestMapping("/teac")
public class TeachersController {
	@Resource
	private TeachersService teacService;
	@Resource
	private LoginService loginService;

	/**
	 * 获取指定市州的所有学校的<编号,名称>map
	 * 
	 * @param city
	 * @return
	 */
	public Map<String, String> getAdmMap(String city) {
		List<String> adms = teacService.getAdmcodeByCity("%" + city + "%");
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
	 * 分页查询教师队伍信息，并判断是否条件查询
	 * 
	 * @param request
	 *            param 包含pageNum，pageSize，admcode，year，city五个参数的map
	 * @param model
	 * @return
	 */
	@RequestMapping("/showTeacInfo")
	public String showTeacInfo(HttpServletRequest request, Model model) {
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
		PageInfo<Teachers> teacPage = null;
		try {
			teacPage = teacService.getTeachersPage(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		List<Teachers> teacList = teacPage.getList();
		model.addAttribute("teacList", teacList);// 查询结果列表
		model.addAttribute("teacPage", teacPage);// 分页信息
		if (param.get("year") != null) {// 供再次查询使用
			model.addAttribute("year", param.get("year"));
		}
		if (param.get("admcode") != null) {
			model.addAttribute("admcode", param.get("admcode"));
		}
		model.addAttribute("level", level);
		return "basic/teac";
	}

	/**
	 * 返回添加教师队伍信息的页面并设置年份选项
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addTeac")
	public String addTeacInfo(Model model) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("curYear", curYear);
		return "basic/teacAdd";
	}

	/**
	 * 执行插入教师队伍信息的数据库操作
	 * 
	 * @param teac
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveTeac")
	@ResponseBody
	public String saveTeacInfo(Teachers teac, HttpServletRequest request) {
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
		params.put("year", teac.getYear());
		if (this.teacService.getTeachersPage(params).getList().size() > 0) {
			result = "{\"result\":\"该年份数据已存在\"}";
			return result;
		}
		teac.setAdmcode(admcode);
		teac.setCity(city);
		try {
			if (!teacService.addTeachers(teac)) {
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
	 * 返回更新教师队伍信息的页面并根据相应ip填充初始内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateTeac")
	public String updateTeacInfo(HttpServletRequest request, Model model,String detailFlag) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int id = Integer.parseInt(request.getParameter("id"));
		Teachers teac = null;
		try {
			teac = teacService.getTeachersById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("curYear", curYear);
		model.addAttribute("teac", teac);
		model.addAttribute("detailFlag",detailFlag);
		return "basic/teacUpd";
	}

	/**
	 * 执行更新教师队伍信息的数据库操作
	 * 
	 * @param teac
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifyTeac")
	@ResponseBody
	public String modifyTeacInfo(Teachers teac, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		teac.setId(id);
		String result = "{\"result\":\"success\"}";
		try {
			if (!teacService.modifyTeachers(teac)) {
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
	 * 查询单条教师队伍信息的详细内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showTeacDetail")
	public String showTeacDetail(HttpServletRequest request, Model model,String detailFlag) {
		int id = Integer.parseInt(request.getParameter("id"));
		Teachers teac = null;
		try {
			teac = teacService.getTeachersById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("teac", teac);
		model.addAttribute("detailFlag", detailFlag);
		return "basic/teacUpd";
	}

	/**
	 * 删除选中id的教师队伍信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteTeac")
	public void deleteTeacInfo(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (teacService.deleteTeachers(id)) {
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
	 * 修改id对应的教师队伍信息状态为审核通过
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("audit")
	public void audit(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		Teachers teac = new Teachers();
		teac.setId(id);
		teac.setAudit(1);
		if (teacService.modifyTeachers(teac)) {
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
		PageInfo<Teachers> teacPage = null;
		try {
			teacPage = teacService.getTeachersPage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		List<Teachers> teacList = teacPage.getList();
		String fileName = "";
		if (!"".equals(year)) {// 对应"&year="的链接
			fileName += year;
			if (!"".equals(admcode)) {// 对应"&admcode="的链接
				fileName += ("-" + loginService.getSchoolInfo(admcode).getSchoolname());
			}
		} else if (!"".equals(admcode)) {// 对应"&admcode="的链接
			fileName += loginService.getSchoolInfo(admcode).getSchoolname();
		}
		fileName += "教师队伍汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));

		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份", "地区", "教职工总人数", "教职工编制数", "在编教职工数", "专任教师数", "其中公共基础课专任教师数", "其中专业课专任教师数",
					"行业企业兼职教师数", "本科以下学历专任教师数", "本科学历专任教师数", "具有研究生学历或学位的专任教师数", "高级职称专任教师数", "中级职称专任教师数", "初级职称专任教师数",
					"未评职称专任教师数", "35 岁及以下专任教师数", "36～45岁专任教师数", "46～55岁专任教师数", "56岁及以上专任教师数", "男教师数", "女教师数", "双师型教师数",
					"专任教师课平均每周课时数", "专业课教师平均每周课时数", "行业企业兼职教师课时总量", "持有心理咨询证书的教师数", "专职心理咨询教师数", "市（州）级以上学科带头人教师数",
					"省特级教师数" };
			excelUtil.writeTitle(title);
			Iterator<Teachers> iterator = teacList.iterator();
			while (iterator.hasNext()) {
				Teachers teac = (Teachers) iterator.next();
				if (teac.getAudit() == 1) {
					excelUtil.write(teac);
				}
			}
			excelUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
