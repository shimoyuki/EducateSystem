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
import com.jks.entity.QualityAssurance;
import com.jks.entity.Size;
import com.jks.service.LoginService;
import com.jks.service.QualityAssuranceService;
import com.jks.utils.ExcelUtil;

@Controller
@RequestMapping("/qualityAssurance")
public class QualityAssuranceController {
	@Autowired
	private QualityAssuranceService qualityAssuranceService;
	@Autowired
	private LoginService loginService;

	/**
	 * 获取所有质量保证列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getQualityAssuranceList")
	public String getQualityAssuranceList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum, Model model,
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
					List<QualityAssurance> qualityAssurance = qualityAssuranceService.findByCity(city, years);
					PageInfo pageInfo = new PageInfo(qualityAssurance, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<QualityAssurance> qualityAssurance = qualityAssuranceService.getQualityAssuranceList(admcode,
							year);
					PageInfo pageInfo = new PageInfo(qualityAssurance, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<QualityAssurance> qualityAssurance = qualityAssuranceService.findByCity(city, year);
					PageInfo pageInfo = new PageInfo(qualityAssurance, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<QualityAssurance> qualityAssurance = qualityAssuranceService.getQualityAssuranceList(admcode,
							year);
					PageInfo pageInfo = new PageInfo(qualityAssurance, 5);
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
			List<QualityAssurance> qualityAssurance = qualityAssuranceService.getQualityAssuranceList(admcode, year);
			PageInfo pageInfo = new PageInfo(qualityAssurance, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<QualityAssurance> qualityAssurance = qualityAssuranceService.getQualityAssuranceList(admcode, year);
			PageInfo pageInfo = new PageInfo(qualityAssurance, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		}

		return "/qualityAssurance/qualityAssurance";
	}

	/**
	 * 跳转到添加质量保证界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAddQualityAssurance")
	public String toAddQualityAssurance() {
		return "/qualityAssurance/qualityAssuranceAdd";
	}

	/**
	 * 添加质量保证并重定向
	 * 
	 * @param qualityAssurance
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveQualityAssurance")
	@ResponseBody
	public String saveQualityAssurance(QualityAssurance qualityAssurance, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");
		qualityAssurance.setAdmcode(admcode);
		qualityAssurance.setCity(city);		
		String result;
		Integer count=qualityAssuranceService.checkYear(qualityAssurance);		
		if(count>0) {
			result = "{\"result\":\"该年份数据已存在!\"}";
		} else {
			qualityAssuranceService.saveQualityAssurance(qualityAssurance);
			result = "{\"result\":\"success\"}";
		}		
		return result;
	}

	/**
	 * 删除质量保证
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delQualityAssurance")
	public void delQualityAssurance(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (qualityAssuranceService.deleteQualityAssurance(id)) {
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
	 * 根据id查询单个质量保证
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getQualityAssurance")
	public String getQualityAssurance(int id, String detailFlag, HttpServletRequest request, Model model) {
		QualityAssurance qualityAssurance = qualityAssuranceService.findById(id);
		request.setAttribute("qualityAssurance", qualityAssurance);
		model.addAttribute("qualityAssurance", qualityAssurance);
		model.addAttribute("detailFlag", detailFlag);
		return "/qualityAssurance/qualityAssuranceUpd";
	}

	/**
	 * 修改质量保证
	 * 
	 * @param qualityAssurance
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateQualityAssurance")
	@ResponseBody
	public String updateQualityAssurance(QualityAssurance qualityAssurance, HttpServletRequest request, Model model) {
				
		String result = "{\"result\":\"success\"}";
		if (qualityAssuranceService.updateQualityAssurance(qualityAssurance)) {
			qualityAssurance = qualityAssuranceService.findById(qualityAssurance.getId());
			request.setAttribute("qualityAssurance", qualityAssurance);
			model.addAttribute("qualityAssurance", qualityAssurance);			
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
		if (qualityAssuranceService.updateAudit(id)) {
			return "redirect:/qualityAssurance/getQualityAssuranceList";
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
		List<QualityAssurance> qualityAssurance = new ArrayList<QualityAssurance>();

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					qualityAssurance = qualityAssuranceService.findByCity(city, years);
				} else {
					admcode = schoolNames;
					qualityAssurance = qualityAssuranceService.getQualityAssuranceList(admcode, years);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					qualityAssurance = qualityAssuranceService.findByCity(city, year);
				} else {
					admcode = schoolName;
					qualityAssurance = qualityAssuranceService.getQualityAssuranceList(admcode, year);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			qualityAssurance = qualityAssuranceService.getQualityAssuranceList(admcode, year);

		} else {
			admcode = (String) session.getAttribute("username");
			qualityAssurance = qualityAssuranceService.getQualityAssuranceList(admcode, year);
		}

		for (int i = 0; i < qualityAssurance.size(); i++) {
			String Chinese = qualityAssurance.get(i).getChinese();
			String Math = qualityAssurance.get(i).getMath();
			String English = qualityAssurance.get(i).getEnglish();

			if (Chinese == null) {
				qualityAssurance.get(i).setChinese("");
			}
			if (Math == null) {
				qualityAssurance.get(i).setMath("");
			}
			if (English == null) {
				qualityAssurance.get(i).setEnglish("");
			}
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
		fileName += "质量保证汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));
		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份", "地区", "校领导人均听课课时数", "校领导人均上课课时数", "教师教学质量考核-优秀比例", "教师教学质量考核-合格比例",
					"教师教学质量考核-不合格比例", "国家级课题立项数", "省级课题立项数", "市级课题立项数", "市级文化课检测语文合格率", "市级文化课检测数学合格率",
					"市级文化课检测英语合格率", "学生参加国家级技能大赛人数", "其中一等奖获得人数", "其中二等奖获得人数", "其中三等奖获得人数", "学生参加省级技能大赛人数", "其中一等奖获得人数",
					"其中二等奖获得人数", "其中三等奖获得人数", "学生参加市级技能大赛人数", "其中一等奖获得人数", "其中二等奖获得人数", "其中三等奖获得人数", };
			excelUtil.writeTitle(title);
			Iterator<QualityAssurance> iteQualityAssurance = qualityAssurance.iterator();
			while (iteQualityAssurance.hasNext()) {
				QualityAssurance coun = (QualityAssurance) iteQualityAssurance.next();
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
