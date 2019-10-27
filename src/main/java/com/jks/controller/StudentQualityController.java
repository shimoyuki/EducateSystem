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
import com.jks.entity.StudentQuality;
import com.jks.entity.StudentQualityDIO;
import com.jks.service.LoginService;
import com.jks.service.StudentQualityService;
import com.jks.utils.ExcelUtil;

@Controller
@RequestMapping("/stud")
public class StudentQualityController {
	@Resource
	private StudentQualityService studService;
	@Resource
	private LoginService loginService;

	/**
	 * 获取指定市州的所有学校的<编号,名称>map
	 * 
	 * @param city
	 * @return
	 */
	public Map<String, String> getAdmMap(String city) {
		List<String> adms = studService.getAdmcodeByCity("%" + city + "%");
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
	 * 分页查询学生质量信息，并判断是否条件查询
	 * 
	 * @param request
	 *            param 包含pageNum，pageSize，admcode，year，city五个参数的map
	 * @param model
	 * @return
	 */
	@RequestMapping("/showStudInfo")
	public String showStudInfo(HttpServletRequest request, Model model) {
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
		PageInfo<StudentQuality> studPage = null;
		try {
			studPage = studService.getStudentQualityPage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		List<StudentQuality> studList = studPage.getList();
		model.addAttribute("studList", studList);// 查询结果列表
		model.addAttribute("studPage", studPage);// 分页信息
		if (param.get("year") != null) {// 供再次查询使用
			model.addAttribute("year", param.get("year"));
		}
		if (param.get("admcode") != null) {
			model.addAttribute("admcode", param.get("admcode"));
		}
		model.addAttribute("level", level);
		return "student/stud";
	}

	/**
	 * 返回添加学生质量信息的页面并设置年份选项
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addStud")
	public String addStudInfo(Model model) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("curYear", curYear);
		return "student/studAdd";
	}

	/**
	 * 执行插入学生质量信息的数据库操作
	 * 
	 * @param stud
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveStud")
	@ResponseBody
	public String saveStudInfo(StudentQuality stud, HttpServletRequest request) {
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
		params.put("year", stud.getYear());
		if (this.studService.getStudentQualityPage(params).getList().size() > 0) {
			result = "{\"result\":\"该年份数据已存在\"}";
			return result;
		}
		stud.setAdmcode(admcode);
		stud.setCity(city);
		try {
			if (!studService.addStudentQuality(stud)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 返回更新学生质量信息的页面并根据相应ip填充初始内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateStud")
	public String updateStudInfo(HttpServletRequest request, Model model,String detailFlag) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int id = Integer.parseInt(request.getParameter("id"));
		StudentQuality stud = null;
		try {
			stud = studService.getStudentQualityById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("curYear", curYear);
		model.addAttribute("stud", stud);
		model.addAttribute("detailFlag", detailFlag);
		return "student/studUpd";
	}

	/**
	 * 执行更新学生质量信息的数据库操作
	 * 
	 * @param stud
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifyStud")
	@ResponseBody
	public String modifyStudInfo(StudentQuality stud, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		stud.setId(id);
		String result = "{\"result\":\"success\"}";
		try {
			if (!studService.modifyStudentQuality(stud)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 查询单条学生质量信息的详细内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showStudDetail")
	public String showStudDetail(HttpServletRequest request, Model model,String detailFlag) {
		int id = Integer.parseInt(request.getParameter("id"));
		StudentQuality stud = null;
		try {
			stud = studService.getStudentQualityById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("stud", stud);
		model.addAttribute("detailFlag", detailFlag);
		return "student/studUpd";
	}

	/**
	 * 删除选中id的学生质量信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteStud")
	public void deleteStudInfo(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (studService.deleteStudentQuality(id)) {
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
	 * 修改id对应的学生质量信息状态为审核通过
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("audit")
	public void audit(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		StudentQuality stud = new StudentQuality();
		stud.setId(id);
		stud.setAudit(1);
		if (studService.modifyStudentQuality(stud)) {
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
		PageInfo<StudentQuality> studPage = null;
		try {
			studPage = studService.getStudentQualityPage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		List<StudentQuality> studList = studPage.getList();
		String fileName = "";
		if (!"".equals(year)) {// 对应"&year="的链接
			fileName += year;
			if (!"".equals(admcode)) {// 对应"&admcode="的链接
				fileName += ("-" + loginService.getSchoolInfo(admcode).getSchoolname());
			}
		} else if (!"".equals(admcode)) {// 对应"&admcode="的链接
			fileName += loginService.getSchoolInfo(admcode).getSchoolname();
		}
		fileName += "学生素质汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));

		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份", "地区", "德育教材配备是否使用国家规化教材", "是否设立了心理辅导中心或心理咨询室", "德育先进单位", "教育部德育实验基地",
					"四川省校风示范校", "四川省中等职业学校内务管理示范校", "青年志愿者先进集体", "红旗团委", " 其他德育相关荣誉(市级及以上)", "省级以上优秀班级数", "专职德育工作人员数",
					"各级德育课题立项数", "德育课教师数量", "德育课教师专业对口率", "德育校本教材开发数", "学生操行考核优的比例", "学生操行考核良的比例",
					"学生操行考核中的比例", "学生操行考核差的比例", "接受心理咨询的学生占比", "省级优秀毕业生数", "省级优秀干部数", "省级优秀三好学生数", "其他（省级以上）",
					"年度校园暴力事件次数", "学生犯罪人次", "严重违纪学生数", "积极申请入团学生数", "积极申请入党学生数", "社会志愿服务活动人次", "社会实践活动参与次数（生/年）",
					"学生社团数量", " 学生参与社团人数", "学生参加文明风采大赛获奖人数（国家级）", " 学生参加文明风采大赛获奖人数（省级）", "学生参加文明风采大赛获奖人数（市级）",
					"参与国家级技能竞赛获得一等奖人数", "参与国家级技能竞赛获得二等奖人数", "参与国家级技能竞赛获得三等奖人数", "参与省级技能竞赛获得一等奖人数", "参与省级技能竞赛获得二等奖人数",
					"参与省级技能竞赛获得三等奖人数", "参与市级技能竞赛获得一等奖人数", "参与市级技能竞赛获得二等奖人数", "参与市级技能竞赛获得三等奖人数", "一年级巩固率", "二年级巩固率",
					"三年级巩固率", "文化课合格率", "体质测评合格率", "专业技能合格率", "职业资格证书数", "双证书获取率", "毕业率" };
			excelUtil.writeTitle(title);
			Iterator<StudentQuality> iterator = studList.iterator();
			while (iterator.hasNext()) {
				StudentQuality stud = (StudentQuality) iterator.next();
				if (stud.getAudit() == 1) {
					excelUtil.write(new StudentQualityDIO(stud));
				}
			}
			excelUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
