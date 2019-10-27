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
import com.jks.entity.SchoolInfo;
import com.jks.entity.Size;
import com.jks.service.GroupschoolService;
import com.jks.service.LoginService;
import com.jks.service.QuerySchoolInfoService;
import com.jks.utils.ExcelUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/group")
public class GroupSchoolController {

	@Autowired
	private GroupschoolService groupService;
	@Autowired
	private QuerySchoolInfoService querySchoolInfoService;
	@Autowired
	private LoginService loginService;

	@RequestMapping("/getGroupSchoolList")
	public String getGroupSchoolList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum,
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
					List<Groupschool> groupschool = groupService.adminFindByCity(city, years);
					PageInfo pageInfo = new PageInfo(groupschool, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<Groupschool> groupschool = groupService.getGroupschoolListByAdmin(admcode, years);
					PageInfo pageInfo = new PageInfo(groupschool, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<Groupschool> groupschool = groupService.findByCity(city, year);
					PageInfo pageInfo = new PageInfo(groupschool, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<Groupschool> groupschool = groupService.getGroupschoolList(admcode, year);
					PageInfo pageInfo = new PageInfo(groupschool, 5);
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
			List<Groupschool> groupschool = groupService.getGroupschoolList(admcode, year);
			PageInfo pageInfo = new PageInfo(groupschool, 5);
			model.addAttribute("pageInfo", pageInfo);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<Groupschool> groupschool = groupService.getGroupschoolList(admcode, year);
			PageInfo pageInfo = new PageInfo(groupschool);
			model.addAttribute("pageInfo", pageInfo);
		}

		return "/school/grouprun";
	}

	@RequestMapping("/toAddGroupSchool")
	public String toAddGroupSchool(Model model) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("curYear", curYear);

		return "/school/grouprunAdd";
	}

	@RequestMapping("/saveGroupSchool")
	@ResponseBody
	public String saveGroupSchool(Groupschool groupschool, Model model, HttpServletRequest request) {
		// System.out.println(equitment.getAdmcode());
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");
		groupschool.setAdmcode(admcode);
		groupschool.setCity(city);
		String result;
		Integer count=groupService.checkYear(groupschool);		
		if(count>0) {
			result = "{\"result\":\"该年份数据已存在!\"}";
		} else {
			groupService.saveGroupschool(groupschool);
			result = "{\"result\":\"success\"}";
		}		
		return result;
	}

	@RequestMapping("/delGroupSchool")
	public void delGroupSchool(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (groupService.deleteGroupschool(id)) {
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

	@RequestMapping("/getGroupSchool")
	public String getGroupSchool(int id, String detailFlag, HttpServletRequest request, Model model) {
		Groupschool groupschool = new Groupschool();
		groupschool = groupService.findById(id);
		request.setAttribute("groupschool", groupschool);
		model.addAttribute("groupschool", groupschool);
		model.addAttribute("detailFlag", detailFlag);
		return "/school/grouprunUpd";
	}

	@RequestMapping("/updateGroupschool")
	@ResponseBody
	public String updateEquitment(Groupschool groupschool, HttpServletRequest request, Model model) {
		String result = "{\"result\":\"success\"}";
		if (groupService.updateGroupschool(groupschool)) {
			groupschool = groupService.findById(groupschool.getId());
			request.setAttribute("groupschool", groupschool);
			model.addAttribute("groupschool", groupschool);
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
		if (groupService.updateAudit(id)) {
			return "redirect:/group/getGroupSchoolList";
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
		List<Groupschool> groupschool = new ArrayList<Groupschool>();

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					groupschool = groupService.findByCity(city, years);
				} else {
					admcode = schoolNames;
					groupschool = groupService.getGroupschoolList(admcode, years);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					groupschool = groupService.findByCity(city, year);
				} else {
					admcode = schoolName;
					groupschool = groupService.getGroupschoolList(admcode, year);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			groupschool = groupService.getGroupschoolList(admcode, year);

		} else {
			admcode = (String) session.getAttribute("username");
			groupschool = groupService.getGroupschoolList(admcode, year);
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
		fileName += "集团化办学汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));
		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份","地区", "本校牵头组织的职教集团数", "本校参与的职教集团数", "参加本校牵头的职教集团学校数", "参加本校牵头的职教集团企业数",
					"参加本校牵头的职教集团专业数" };
			excelUtil.writeTitle(title);
			Iterator<Groupschool> ite = groupschool.iterator();
			while (ite.hasNext()) {
				Groupschool coun = (Groupschool) ite.next();
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
