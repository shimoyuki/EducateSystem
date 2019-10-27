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
import com.jks.entity.EmployQuality;
import com.jks.service.LoginService;
import com.jks.service.EmployQualityService;
import com.jks.utils.ExcelUtil;

@Controller
@RequestMapping("/emp")
public class EmployQualityController {
	@Resource
	private EmployQualityService empService;
	@Resource
	private LoginService loginService;

	/**
	 * 获取指定市州的所有学校的<编号,名称>map
	 * 
	 * @param city
	 * @return
	 */
	public Map<String, String> getAdmMap(String city) {
		List<String> adms = empService.getAdmcodeByCity("%" + city + "%");
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
	 * 分页查询就业质量信息，并判断是否条件查询
	 * 
	 * @param request
	 *            param 包含pageNum，pageSize，admcode，year，city五个参数的map
	 * @param model
	 * @return
	 */
	@RequestMapping("/showEmpInfo")
	public String showEmpInfo(HttpServletRequest request, Model model) {
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
		PageInfo<EmployQuality> empPage = null;
		try {
			empPage = empService.getEmployQualityPage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		List<EmployQuality> empList = empPage.getList();
		model.addAttribute("empList", empList);// 查询结果列表
		model.addAttribute("empPage", empPage);// 分页信息
		if (param.get("year") != null) {// 供再次查询使用
			model.addAttribute("year", param.get("year"));
		}
		if (param.get("admcode") != null) {
			model.addAttribute("admcode", param.get("admcode"));
		}
		model.addAttribute("level", level);
		return "student/emp";
	}

	/**
	 * 返回添加就业质量信息的页面并设置年份选项
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addEmp")
	public String addEmpInfo(Model model) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("curYear", curYear);
		return "student/empAdd";
	}

	/**
	 * 执行插入就业质量信息的数据库操作
	 * 
	 * @param emp
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveEmp")
	@ResponseBody
	public String saveEmpInfo(EmployQuality emp, HttpServletRequest request) {
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
		params.put("year", emp.getYear());
		if (this.empService.getEmployQualityPage(params).getList().size() > 0) {
			result = "{\"result\":\"该年份数据已存在\"}";
			return result;
		}
		emp.setAdmcode(admcode);
		emp.setCity(city);
		try {
			if (!empService.addEmployQuality(emp)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 返回更新就业质量信息的页面并根据相应ip填充初始内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateEmp")
	public String updateEmpInfo(HttpServletRequest request, Model model,String detailFlag) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int id = Integer.parseInt(request.getParameter("id"));
		EmployQuality emp = null;
		try {
			emp = empService.getEmployQualityById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("curYear", curYear);
		model.addAttribute("emp", emp);
		model.addAttribute("detailFlag", detailFlag);
		return "student/empUpd";
	}

	/**
	 * 执行更新就业质量信息的数据库操作
	 * 
	 * @param emp
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifyEmp")
	@ResponseBody
	public String modifyEmpInfo(EmployQuality emp, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		emp.setId(id);
		String result = "{\"result\":\"success\"}";
		try {
			if (!empService.modifyEmployQuality(emp)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 查询单条就业质量信息的详细内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showEmpDetail")
	public String showEmpDetail(HttpServletRequest request, Model model,String detailFlag) {
		int id = Integer.parseInt(request.getParameter("id"));
		EmployQuality emp = null;
		try {
			emp = empService.getEmployQualityById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("emp", emp);
		model.addAttribute("detailFlag", detailFlag);
		return "student/empUpd";
	}

	/**
	 * 删除选中id的就业质量信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteEmp")
	public void deleteEmpInfo(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (empService.deleteEmployQuality(id)) {
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
	 * 修改id对应的就业质量信息状态为审核通过
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("audit")
	public void audit(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		EmployQuality emp = new EmployQuality();
		emp.setId(id);
		emp.setAudit(1);
		if (empService.modifyEmployQuality(emp)) {
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
		PageInfo<EmployQuality> empPage = null;
		try {
			empPage = empService.getEmployQualityPage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		List<EmployQuality> empList = empPage.getList();
		String fileName = "";
		if (!"".equals(year)) {// 对应"&year="的链接
			fileName += year;
			if (!"".equals(admcode)) {// 对应"&admcode="的链接
				fileName += ("-" + loginService.getSchoolInfo(admcode).getSchoolname());
			}
		} else if (!"".equals(admcode)) {// 对应"&admcode="的链接
			fileName += loginService.getSchoolInfo(admcode).getSchoolname();
		}
		fileName += "就业质量汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));

		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份", "地区", "毕业生初次就业率", "专业对口就业率", "顶岗实习半年以上稳定率", " 初次就业月平均收入", "自主创业率",
					"到国有企业事业单位服务比例", "到民营企业服务比例", "到外资企业服务比例", "到第一产业就业比例", "到第二产业就业比例", "到第三产业就业比例", "参军人数",
					"高考统招升学学生数占毕业生总数比例", "对口单招升学学生数占毕业生总数比例", "签订一年及以内就业合同比例", "签订一年以上就业合同比例" };
			excelUtil.writeTitle(title);
			Iterator<EmployQuality> iterator = empList.iterator();
			while (iterator.hasNext()) {
				EmployQuality emp = (EmployQuality) iterator.next();
				if (emp.getAudit() == 1) {
					excelUtil.write(emp);
				}
			}
			excelUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
