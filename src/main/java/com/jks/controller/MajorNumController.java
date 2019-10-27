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
import com.jks.entity.MajorNum;
import com.jks.entity.Size;
import com.jks.service.LoginService;
import com.jks.service.MajorNumService;
import com.jks.utils.ExcelUtil;

@Controller
@RequestMapping("/majorNum")
public class MajorNumController {
	@Autowired
	private MajorNumService majorNumService;
	@Autowired
	private LoginService loginService;

	/**
	 * 获取所有课程开设列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getMajorNumList")
	public String getMajorNumList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum, Model model,
			HttpServletRequest request) {

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
					List<MajorNum> majorNum = majorNumService.findByCity(city, years);
					PageInfo pageInfo = new PageInfo(majorNum, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<MajorNum> majorNum = majorNumService.getMajorNumList(admcode, year);
					PageInfo pageInfo = new PageInfo(majorNum, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<MajorNum> majorNum = majorNumService.findByCity(city, year);
					PageInfo pageInfo = new PageInfo(majorNum, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<MajorNum> majorNum = majorNumService.getMajorNumList(admcode, year);
					PageInfo pageInfo = new PageInfo(majorNum, 5);
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
			List<MajorNum> majorNum = majorNumService.getMajorNumList(admcode, year);
			PageInfo pageInfo = new PageInfo(majorNum, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<MajorNum> majorNum = majorNumService.getMajorNumList(admcode, year);
			PageInfo pageInfo = new PageInfo(majorNum, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		}
		return "/qualityAssurance/majorNum";
	}

	/**
	 * 跳转到添加课程开设界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAddMajorNum")
	public String toAddMajorNum() {
		return "/qualityAssurance/majorNumAdd";
	}

	/**
	 * 添加课程开设并重定向
	 * 
	 * @param majorNum
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveMajorNum")
	@ResponseBody
	public String saveMajorNum(MajorNum majorNum, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");
		majorNum.setAdmcode(admcode);
		majorNum.setCity(city);	
		String result;
		Integer count=majorNumService.checkYear(majorNum);		
		if(count>0) {
			result = "{\"result\":\"该年份数据已存在!\"}";
		} else {
			majorNumService.saveMajorNum(majorNum);
			result = "{\"result\":\"success\"}";
		}		
		return result;
	}

	/**
	 * 删除课程开设
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delMajorNum")
	public void delMajorNum(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (majorNumService.deleteMajorNum(id)) {
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

	/**
	 * 根据id查询单个课程开设
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getMajorNum")
	public String getMajorNum(int id, String detailFlag, HttpServletRequest request, Model model) {
		MajorNum majorNum = majorNumService.findById(id);
		request.setAttribute("majorNum", majorNum);
		model.addAttribute("majorNum", majorNum);
		model.addAttribute("detailFlag", detailFlag);
		return "/qualityAssurance/majorNumUpd";
	}

	/**
	 * 修改课程开设
	 * 
	 * @param majorNum
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateMajorNum")
	@ResponseBody
	public String updateMajorNum(MajorNum majorNum, HttpServletRequest request, Model model) {
		String result = "{\"result\":\"success\"}";
		if (majorNumService.updateMajorNum(majorNum)) {
			majorNum = majorNumService.findById(majorNum.getId());
			request.setAttribute("majorNum", majorNum);
			model.addAttribute("majorNum", majorNum);
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
		if (majorNumService.updateAudit(id)) {
			return "redirect:/majorNum/getMajorNumList";
		} else {
			return "/error";
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
		List<MajorNum> majorNum = new ArrayList<MajorNum>();

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					majorNum = majorNumService.findByCity(city, years);
				} else {
					admcode = schoolNames;
					majorNum = majorNumService.getMajorNumList(admcode, years);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					majorNum = majorNumService.findByCity(city, year);
				} else {
					admcode = schoolName;
					majorNum = majorNumService.getMajorNumList(admcode, year);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			majorNum = majorNumService.getMajorNumList(admcode, year);

		} else {
			admcode = (String) session.getAttribute("username");
			majorNum = majorNumService.getMajorNumList(admcode, year);
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
		fileName += "课程开设汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));
		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份", "地区", "已制定课程标准数", "牵头开发国家共建共享计划课程数",  "教师参编公开出版的教材数",
								"规划教材使用比", "校本教材开发数量" };
			excelUtil.writeTitle(title);
			Iterator<MajorNum> iteMajorNum = majorNum.iterator();
			while (iteMajorNum.hasNext()) {
				MajorNum coun = (MajorNum) iteMajorNum.next();
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
