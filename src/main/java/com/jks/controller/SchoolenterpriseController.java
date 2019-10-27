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
import com.jks.entity.Partybulid;
import com.jks.entity.SchoolInfo;
import com.jks.entity.Schoolenterprise;
import com.jks.service.LoginService;
import com.jks.service.QuerySchoolInfoService;
import com.jks.service.SchoolenterpriseService;
import com.jks.service.SizeService;
import com.jks.utils.ExcelUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/schoolenterprise")
public class SchoolenterpriseController {

	@Autowired
	private SchoolenterpriseService schoolenterpriseService;
	@Autowired
	private SizeService sizeservice;
	@Autowired
	private QuerySchoolInfoService querySchoolInfoService;
	@Autowired
	private LoginService loginService;

	@RequestMapping("/getSchoolenterpriseList")
	public String getSchoolenterpriseList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum,
			HttpSession session, HttpServletRequest request, Model model) {
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
					List<Schoolenterprise> schoolenterprise = schoolenterpriseService.adminFindByCity(city, years);
					PageInfo pageInfo = new PageInfo(schoolenterprise, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<Schoolenterprise> schoolenterprise = schoolenterpriseService.getSchoolenterpriseListByAdmin(admcode,
							years);
					PageInfo pageInfo = new PageInfo(schoolenterprise, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<Schoolenterprise> schoolenterprise = schoolenterpriseService.findByCity(city, year);
					PageInfo pageInfo = new PageInfo(schoolenterprise, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<Schoolenterprise> schoolenterprise = schoolenterpriseService.getSchoolenterpriseList(admcode,
							year);
					PageInfo pageInfo = new PageInfo(schoolenterprise, 5);
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
			List<Schoolenterprise> schoolenterprise = schoolenterpriseService.getSchoolenterpriseList(admcode, year);
			PageInfo pageInfo = new PageInfo(schoolenterprise, 5);
			model.addAttribute("pageInfo", pageInfo);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<Schoolenterprise> schoolenterprise = schoolenterpriseService.getSchoolenterpriseList(admcode, year);
			PageInfo pageInfo = new PageInfo(schoolenterprise);
			model.addAttribute("pageInfo", pageInfo);
		}

		return "/school/situation";
	}

	@RequestMapping("/toAddSchoolenterprise")
	public String toAddSchoolenterprise(Model model) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("curYear", curYear);
		return "/school/situationAdd";
	}

	@RequestMapping("/saveSchoolenterprise")
	@ResponseBody
	public String saveschoolenterprise(Schoolenterprise schoolenterprise, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");
		schoolenterprise.setAdmcode(admcode);
		schoolenterprise.setCity(city);
		String result;
		Integer count=schoolenterpriseService.checkYear(schoolenterprise);		
		if(count>0) {
			result = "{\"result\":\"该年份数据已存在!\"}";
		} else {
			schoolenterpriseService.saveSchoolenterprise(schoolenterprise);
			result = "{\"result\":\"success\"}";
		}		
		return result;		
	}

	@RequestMapping("/delSchoolenterprise")
	public void delSize(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (schoolenterpriseService.deleteSchoolenterprise(id)) {
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

	@RequestMapping("/getSchoolenterprise")
	public String getschoolenterprise(int id, String detailFlag, HttpServletRequest request, Model model) {
		Schoolenterprise schoolenterprise = new Schoolenterprise();
		
		schoolenterprise = schoolenterpriseService.findById(id);
		HttpSession session=request.getSession();
		String admcode=(String) session.getAttribute("uesrname");
		String year=schoolenterprise.getYear();
		Integer majors=sizeservice.checkMajor(admcode, year);
		int majornum=majors==null?0:majors.intValue();
		
		request.setAttribute("schoolenterprise", schoolenterprise);
		model.addAttribute("schoolenterprise", schoolenterprise);
		model.addAttribute("majornum", majornum);
		model.addAttribute("detailFlag", detailFlag);
		return "/school/situationUpd";
	}

	@RequestMapping("/updateschoolenterprise")
	@ResponseBody
	public String updateschoolenterprise(Schoolenterprise schoolenterprise, HttpServletRequest request, Model model) {
		String result = "{\"result\":\"success\"}";
		if (schoolenterpriseService.updateSchoolenterprise(schoolenterprise)) {
			schoolenterprise = schoolenterpriseService.findById(schoolenterprise.getId());			
			request.setAttribute("schoolenterprise", schoolenterprise);
			model.addAttribute("schoolenterprise", schoolenterprise);
			model.addAttribute("schoolenterprise", schoolenterprise);
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
		if (schoolenterpriseService.updateAudit(id)) {
			return "redirect:/schoolenterprise/getSchoolenterpriseList";
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
	@RequestMapping("/checkmajor")
	@ResponseBody
	public String checkmajor(HttpServletRequest request,HttpServletResponse response){					
		HttpSession session=request.getSession();
		String admcode=(String) session.getAttribute("username");
		String year=request.getParameter("year");
		Integer majors=sizeservice.checkMajor(admcode, year);	
		int majornum=(majors==null?-1:majors.intValue());		
		String result = "{\"result\":\""+majornum+"\"}";		
		return result;		
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
		List<Schoolenterprise> schoolenterprise = new ArrayList<Schoolenterprise>();

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					schoolenterprise = schoolenterpriseService.findByCity(city, years);
				} else {
					admcode = schoolNames;
					schoolenterprise = schoolenterpriseService.getSchoolenterpriseList(admcode, years);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					schoolenterprise = schoolenterpriseService.findByCity(city, year);
				} else {
					admcode = schoolName;
					schoolenterprise = schoolenterpriseService.getSchoolenterpriseList(admcode, year);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			schoolenterprise = schoolenterpriseService.getSchoolenterpriseList(admcode, year);

		} else {
			admcode = (String) session.getAttribute("username");
			schoolenterprise = schoolenterpriseService.getSchoolenterpriseList(admcode, year);
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
		
		fileName += "校企合作汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));
		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份","地区", "校企合作覆盖专业数", "签订合作协议的企业数", "签订合作协议的专业数", "合作企业参与教学的专业数", "合作企业参与教学的教师数",
					"合作企业参与教学课时数", "合作企业投入资金总额（万元）",
					"合作企业投入到账资金（万元）", "合作企业投入设备总值（万元）", "与企业共建研发中心数", "校外教师培训基地数", "生产性实训基地产值（元）",
					"校企合作订单班人数", "校企合作开发课程数", "专任教师人均企业实习实践人次", "专任教师人均企业实习实践时间（天）", "企业兼职教师专业课课时占比"};
			excelUtil.writeTitle(title);
			Iterator<Schoolenterprise> ite = schoolenterprise.iterator();
			while (ite.hasNext()) {
				Schoolenterprise coun = (Schoolenterprise) ite.next();
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
