package com.jks.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jks.entity.Groupschool;
import com.jks.entity.Internship;
import com.jks.entity.SchoolInfo;
import com.jks.service.InternshipService;
import com.jks.service.LoginService;
import com.jks.service.QuerySchoolInfoService;
import com.jks.utils.ExcelUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/internship")
public class InternshipController {
	@Autowired
	private InternshipService intern;
	@Autowired
	private QuerySchoolInfoService querySchoolInfoService;
	@Autowired
	private LoginService loginService;

	/**
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/getInternshipList")
	public String getInternshipList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum,
			HttpSession session, Model model, HttpServletRequest request) {
		String level = (String) session.getAttribute("level");

		Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
		String year = (String) param.get("year");
		String schoolName = (String) param.get("schoolName");
		String years = (String) param.get("years");
		String schoolNames = (String) param.get("schoolNames");
		String sn = (String) param.get("sn");

		param.remove("year");
		param.remove("schoolName");
		param.remove("years");
		param.remove("schoolNames");
		param.remove("sn");

		if (sn != null && sn != "") {
			session.setAttribute("sn", sn);
		}
		String admcode;

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<Internship> internship = intern.adminFindByCity(city, years);
					PageInfo pageInfo = new PageInfo(internship, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<Internship> internship = intern.getInternshipListByAdmin(admcode, years);
					PageInfo pageInfo = new PageInfo(internship, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<Internship> internship = intern.findByCity(city, year);
					PageInfo pageInfo = new PageInfo(internship, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<Internship> internship = intern.getInternshipList(admcode, year);
					PageInfo pageInfo = new PageInfo(internship, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			PageHelper.startPage(pagenum, 12);
			List<Internship> internship = intern.getInternshipList(admcode, year);
			PageInfo pageInfo = new PageInfo(internship, 5);
			model.addAttribute("pageInfo", pageInfo);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<Internship> internship = intern.getInternshipList(admcode, year);
			PageInfo pageInfo = new PageInfo(internship);
			model.addAttribute("pageInfo", pageInfo);
		}

		return "/school/internship";
	}

	/** 
	 * @return
	 */
	@RequestMapping("/toAddInternship")
	public String toAddInternship(Model model) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("curYear", curYear);

		return "/school/internshipAdd";
	}

	@RequestMapping("/saveInternship")
	@ResponseBody
	public String saveInternship(Internship internship, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");
		internship.setAdmcode(admcode);
		internship.setCity(city);
		String result;
		Integer count=intern.checkYear(internship);		
		if(count>0) {
			result = "{\"result\":\"该年份数据已存在!\"}";
		} else {
			intern.saveInternship(internship);
			result = "{\"result\":\"success\"}";
		}		
		return result;
	}

	@RequestMapping("/delInternship")
	public void delSize(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (intern.deleteInternship(id)) {
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/getInternship")
	public String getInternship(int id, String detailFlag, HttpServletRequest request, Model model) {
		Internship internship = intern.findById(id);
		request.setAttribute("internship", internship);
		model.addAttribute("internship", internship);
		model.addAttribute("detailFlag", detailFlag);
		return "/school/internshipUpd";
	}

	@RequestMapping("/updateInternship")
	@ResponseBody
	public String updateInternship(Internship internship, HttpServletRequest request, Model model) {
		String result = "{\"result\":\"success\"}";
		if (intern.updateInternship(internship)) {
			internship = intern.findById(internship.getId());
			request.setAttribute("internship", internship);
			model.addAttribute("internship", internship);
		} else {
			result = "{\"result\":\"error!\"}";			
		}
		return result;
	}

	/**
	 * 通过审核
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateAudit")
	public String updateAudit(int id) {
		if (intern.updateAudit(id)) {
			return "redirect:/internship/getInternshipList";
		} else {
			return "/error";
		}
	}

	/**
	 * 查找学校名称
	 * 
	 * @param request,response
	 */
	@RequestMapping("/getSchoolNameList")
	public void getSchoolNameList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String area = (String) session.getAttribute("schoolname");

		response.setContentType("application/json; charset=utf-8");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");

		List<SchoolInfo> schoolInfo = querySchoolInfoService.findByArea(area);

		JSONArray jsonArray = JSONArray.fromObject(schoolInfo);
		String jsonString = jsonArray.toString();

		try {

			response.getWriter().write(jsonString);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping("/download")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String level = (String) session.getAttribute("level");

		Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
		String year = (String) param.get("year");
		String schoolName = (String) param.get("schoolName");
		String years = (String) param.get("years");
		String schoolNames = (String) param.get("schoolNames");
		String sn = (String) param.get("sn");

		param.remove("year");
		param.remove("schoolName");
		param.remove("years");
		param.remove("schoolNames");
		param.remove("sn");

		if (sn != null && sn != "") {
			session.setAttribute("sn", sn);
		}

		String admcode = new String();
		List<Internship> internship = new ArrayList<Internship>();

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					internship = intern.findByCity(city, years);
				} else {
					admcode = schoolNames;
					internship = intern.getInternshipList(admcode, years);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					internship = intern.findByCity(city, year);
				} else {
					admcode = schoolName;
					internship = intern.getInternshipList(admcode, year);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			internship = intern.getInternshipList(admcode, year);

		} else {
			admcode = (String) session.getAttribute("username");
			internship = intern.getInternshipList(admcode, year);
		}

		String fileName = "";
		if (!"".equals(year) && year != null) {// 对应"&year="的链接
			fileName += year;
			if (!"".equals(admcode)) {// 对应"&admcode="的链接
				fileName += ("-" + loginService.getSchoolInfo(admcode).getSchoolname());
			}
		} else if (!"".equals(admcode)) {// 对应"&admcode="的链接
			fileName += loginService.getSchoolInfo(admcode).getSchoolname();
		}
		fileName += "学生实习情况汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));
		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份", "地区","校外学生实训基地数", "生均认识实习时长（天）", "生均跟岗实习时长（天）", "生均顶岗实习时长（天）", "学生跟岗实习对口率",
					"学生顶岗实习对口率", "企业对学生跟岗实习考核结果（优秀）比例", "企业对学生顶岗实习考核结果（良好）比例", "企业对学生顶岗实习考核结果（合格）比例",
					"企业对学生顶岗实习考核结果（不合格）比例", "合作企业接收学生就业比例" };
			excelUtil.writeTitle(title);
			Iterator<Internship> ite = internship.iterator();
			while (ite.hasNext()) {
				Internship coun = (Internship) ite.next();
				if (coun.getAudit() == 1) {
					excelUtil.write(coun);
				}
			}
			excelUtil.close();

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
