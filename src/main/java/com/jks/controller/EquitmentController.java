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
import com.jks.entity.Equitment;
import com.jks.entity.SchoolInfo;
import com.jks.entity.Size;
import com.jks.service.EquitmentService;
import com.jks.service.LoginService;
import com.jks.service.QuerySchoolInfoService;
import com.jks.utils.ExcelUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/Equitment")
public class EquitmentController {

	@Autowired
	private EquitmentService equitmentService;
	@Autowired
	private QuerySchoolInfoService querySchoolInfoService;
	@Autowired
	private LoginService loginService;

	/**
	 * 锟斤拷取list
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/getEquitmentList")
	public String getEquitmentList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum,
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
					List<Equitment> equitment = equitmentService.adminFindByCity(city, years);
					PageInfo pageInfo = new PageInfo(equitment, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<Equitment> equitment = equitmentService.getEquitmentListByAdmin(admcode, years);
					PageInfo pageInfo = new PageInfo(equitment, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<Equitment> equitment = equitmentService.findByCity(city, year);
					PageInfo pageInfo = new PageInfo(equitment, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<Equitment> equitment = equitmentService.getEquitmentList(admcode, year);
					PageInfo pageInfo = new PageInfo(equitment, 5);
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
			List<Equitment> equitment = equitmentService.getEquitmentList(admcode, year);
			PageInfo pageInfo = new PageInfo(equitment, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<Equitment> equitment = equitmentService.getEquitmentList(admcode, year);
			PageInfo pageInfo = new PageInfo(equitment, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		}

		return "/basic/equipment";
	}

	@RequestMapping("/toAddEquitment")
	public String toAddEquitment(Model model) {

		return "/basic/equitmentAdd";
	}

	@RequestMapping("/saveEquitment")
	@ResponseBody
	public String saveEquitment(Equitment equitment,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");
		equitment.setAdmcode(admcode);
		equitment.setCity(city);
		String result;
		Integer count=equitmentService.checkYear(equitment);		
		if(count>0) {
			result = "{\"result\":\"该年份数据已存在!\"}";
		} else {
			equitmentService.saveEquitment(equitment);
			result = "{\"result\":\"success\"}";
		}		
		return result;
		
	}

	@RequestMapping("/delEquitment")
	public void delSize(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (equitmentService.deleteEquitment(id)) {
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

	@RequestMapping("/getEquitment")
	public String getEquitment(int id, String detailFlag, HttpServletRequest request, Model model) {

		Equitment equitment = equitmentService.findById(id);
		model.addAttribute("detailFlag", detailFlag);
		model.addAttribute("equitment", equitment);
		return "/basic/equitmentUpd";
	}

	@RequestMapping("/updateEquitment")
	@ResponseBody
	public String updateEquitment(Equitment equitment, HttpServletRequest request, Model model) {
		String result = "{\"result\":\"success\"}";
		if (equitmentService.updateEquitment(equitment)) {
			equitment = equitmentService.findById(equitment.getId());
			request.setAttribute("equitment", equitment);
			model.addAttribute("equitment", equitment);
		} else {
			result = "{\"result\":\"error!\"}";
		}
		return result;
	}

	@RequestMapping("/updateAudit")
	public String updateAudit(int id) {
		if (equitmentService.updateAudit(id)) {
			return "redirect:/Equitment/getEquitmentList";
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
		List<Equitment> equitment = new ArrayList<Equitment>();

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					equitment = equitmentService.findByCity(city, years);
				} else {
					admcode = schoolNames;
					equitment = equitmentService.getEquitmentList(admcode, years);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					equitment = equitmentService.findByCity(city, year);
				} else {
					admcode = schoolName;
					equitment = equitmentService.getEquitmentList(admcode, year);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			equitment = equitmentService.getEquitmentList(admcode, year);

		} else {
			admcode = (String) session.getAttribute("username");
			equitment = equitmentService.getEquitmentList(admcode, year);
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
		fileName += "设施设备汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));
		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份","地区", "固定资产总值（万元）", "教学设备资产值（万元）", "实训设备资产值（万元）", "年新增教学设备资产值（万元）",
					"年新增实训设备资产值（万元）", "生均教学设备资产值（万元）", "生均实训设备资产值（万元）", "生均实训实习工位数", "校内实训基地数", "校外实训基地数",
					"图书馆纸质图书藏书量（册）", "图书馆电子图书藏书量（册）", "年度新增图书（册）", "阅览室座位数", "生均图书（册）", "期刊订阅种类数", "电子图书数（册）",
					"电子阅览室座位数（个）" };
			excelUtil.writeTitle(title);
			Iterator<Equitment> ite = equitment.iterator();
			while (ite.hasNext()) {
				Equitment coun = (Equitment) ite.next();
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
