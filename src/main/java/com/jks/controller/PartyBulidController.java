package com.jks.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.jks.entity.Equitment;
import com.jks.entity.Partybulid;
import com.jks.entity.SchoolInfo;
import com.jks.service.LoginService;
import com.jks.service.PartyBulidService;
import com.jks.service.QuerySchoolInfoService;
import com.jks.utils.ExcelUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/partybulid")
public class PartyBulidController {
	@Autowired
	private PartyBulidService pbs;
	@Autowired
	private QuerySchoolInfoService querySchoolInfoService;
	@Autowired
	private LoginService loginService;

	@RequestMapping("/getPartyBulidList")
	public String getPartyBulidList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum,
			HttpServletRequest request, Model model) {
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

		String admcode;

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<Partybulid> partybulid = pbs.adminFindByCity(city, years);
					PageInfo pageInfo = new PageInfo(partybulid, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<Partybulid> partybulid = pbs.getPartyBulidListByAdmin(admcode, years);
					PageInfo pageInfo = new PageInfo(partybulid, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<Partybulid> partybulid = pbs.findByCity(city, year);
					PageInfo pageInfo = new PageInfo(partybulid, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<Partybulid> partybulid = pbs.getPartyBulidList(admcode, year);
					PageInfo pageInfo = new PageInfo(partybulid, 5);
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
			List<Partybulid> partybulid = pbs.getPartyBulidList(admcode, year);
			PageInfo pageInfo = new PageInfo(partybulid, 5);
			model.addAttribute("pageInfo", pageInfo);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<Partybulid> partybulid = pbs.getPartyBulidList(admcode, year);
			PageInfo pageInfo = new PageInfo(partybulid, 5);
			model.addAttribute("pageInfo", pageInfo);
		}

		return "/partybulid/partybulid";
	}

	@RequestMapping("/toAddPartybulid")
	public String toAddPartyBulid() {
		return "/partybulid/partybulidAdd";
	}

	@RequestMapping("/savePartyBulid")
	@ResponseBody
	public String savePartyBulid(Partybulid partybulid, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");
		partybulid.setAdmcode(admcode);
		partybulid.setCity(city);	
		String result;
		Integer count=pbs.checkYear(partybulid);		
		if(count>0) {
			result = "{\"result\":\"该年份数据已存在!\"}";
		} else {
			pbs.savePartyBulid(partybulid);
			result = "{\"result\":\"success\"}";
		}		
		return result;
	}


	@RequestMapping("/delPartyBulid")
	public void delPartyBulid(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (pbs.deletePartyBulid(id)) {
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

	@RequestMapping("/getPartyBulid")
	public String getPartyBulid(int id, String detailFlag, HttpServletRequest request, Model model) {
		Partybulid partybulid = pbs.findById(id);
		request.setAttribute("partybulid", partybulid);
		model.addAttribute("partybulid", partybulid);
		model.addAttribute("detailFlag", detailFlag);
		return "/partybulid/partybulidUpd";
	}

	@RequestMapping("/updatePartyBulid")
	@ResponseBody
	public String updatePartyBulid(Partybulid partybulid, HttpServletRequest request, Model model) {
		String result = "{\"result\":\"success\"}";
		if (pbs.updatePartyBulid(partybulid)) {
			partybulid = pbs.findById(partybulid.getId());
			request.setAttribute("partybulid", partybulid);
			model.addAttribute("partybulid", partybulid);
		} else {
			result = "{\"result\":\"error!\"}";
		}
		return result;
		
	}

	@RequestMapping("/updateAudit")
	public String updateAudit(int id) {
		if (pbs.updateAudit(id)) {
			return "redirect:/partybulid/getPartyBulidList";
		} else {
			return "/error";
		}
	}

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
		List<Partybulid> partybulid = new ArrayList<Partybulid>();

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					partybulid = pbs.findByCity(city, years);
				} else {
					admcode = schoolNames;
					partybulid = pbs.getPartyBulidList(admcode, years);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					partybulid = pbs.findByCity(city, year);
				} else {
					admcode = schoolName;
					partybulid = pbs.getPartyBulidList(admcode, year);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			partybulid = pbs.getPartyBulidList(admcode, year);

		} else {
			admcode = (String) session.getAttribute("username");
			partybulid = pbs.getPartyBulidList(admcode, year);
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
		fileName += "党建工作汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));
		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份", "地区","学校党员总数", "党支部数", "学生党员数", "党务工作人员培训人次", "党组织开展党员教育培训人次", "入党积极分子培训人数",
					"入党积极分子培训次数", "发展党员人数", "党报党刊订阅数", "受党纪政治处分党员数", "获国家级优秀表彰的党员数", "获省级优秀表彰的党员数", "获市级优秀表彰的党员数",
					"获国家级优秀表彰的党组织数", "获省级优秀表彰的党组织数", "获市级优秀表彰的党组织数" };
			excelUtil.writeTitle(title);
			Iterator<Partybulid> ite = partybulid.iterator();
			while (ite.hasNext()) {
				Partybulid coun = (Partybulid) ite.next();
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
