package com.jks.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jks.entity.Major;
import com.jks.entity.MajorLayout;
import com.jks.entity.MajorStu;
import com.jks.service.LoginService;
import com.jks.service.MajorLayoutService;
import com.jks.service.MajorQueryService;
import com.jks.service.MajorStuService;
import com.jks.utils.ExcelUtil;
import com.jks.utils.ZipUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/majorLayout")
public class MajorLayoutController {
	@Autowired
	private MajorLayoutService majorLayoutService;
	@Autowired
	private MajorStuService majorStuService;
	@Autowired
	private MajorQueryService majorQueryService;
	@Autowired
	private LoginService loginService;

	/**
	 * 获取所有专业布局列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getMajorLayoutList")
	public String getMajorLayoutList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum, Model model,
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
					List<MajorLayout> majorLayout = majorLayoutService.findByCity(city, years);
					PageInfo pageInfo = new PageInfo(majorLayout, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<MajorLayout> majorLayout = majorLayoutService.getMajorLayoutList(admcode, year);
					PageInfo pageInfo = new PageInfo(majorLayout, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<MajorLayout> majorLayout = majorLayoutService.findByCity(city, year);
					PageInfo pageInfo = new PageInfo(majorLayout, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<MajorLayout> majorLayout = majorLayoutService.getMajorLayoutList(admcode, year);
					PageInfo pageInfo = new PageInfo(majorLayout, 5);
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
			List<MajorLayout> majorLayout = majorLayoutService.getMajorLayoutList(admcode, year);
			PageInfo pageInfo = new PageInfo(majorLayout, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<MajorLayout> majorLayout = majorLayoutService.getMajorLayoutList(admcode, year);
			PageInfo pageInfo = new PageInfo(majorLayout, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		}

		return "/qualityAssurance/majorLayout";
	}

	/**
	 * 跳转到添加专业布局界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAddMajorLayout")
	public String toAddMajorLayout() {

		return "/qualityAssurance/majorLayoutAdd";
	}

	/**
	 * 查找专业类
	 * 
	 * @param response
	 */
	@RequestMapping("/majorQueryInduName")
	public void majorQueryInduName(HttpServletResponse response) {		
		response.setContentType("application/json; charset=utf-8");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		List<Major> induName = majorQueryService.getMajorQueryList();
		
		JSONArray jsonArray = JSONArray.fromObject(induName);
		
		String jsonString = jsonArray.toString();
		
		try {

			response.getWriter().write(jsonString);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 查找专业名称
	 * 
	 * @param response
	 */
	@RequestMapping("/majorQueryName")
	public void majorQueryName(HttpServletRequest request, HttpServletResponse response, String induName) {

		response.setContentType("application/json; charset=utf-8");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		List<Major> name = majorQueryService.findByInduName(induName);

		JSONArray jsonArray = JSONArray.fromObject(name);

		String jsonString = jsonArray.toString();

		try {

			response.getWriter().write(jsonString);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 添加专业布局和专业人数
	 */
	@RequestMapping("/saveMajorLayoutTable")
	public void saveMajorLayoutTable(HttpServletRequest request, HttpServletResponse response, String params,
			String year, String oneIndu, String twoIndu, String threeIndu, String localPillar, String newMajor, 
			String stopMajor) {

		System.out.println(params);
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");

		MajorLayout majorLayout = new MajorLayout();
		majorLayout.setAdmcode(admcode);
		majorLayout.setCity(city);
		majorLayout.setYear(year);
		majorLayout.setOneIndu(Integer.parseInt(oneIndu));
		majorLayout.setTwoIndu(Integer.parseInt(twoIndu));
		majorLayout.setThreeIndu(Integer.parseInt(threeIndu));
		majorLayout.setLocalPillar(Integer.parseInt(localPillar));
		/*majorLayout.setProvinceMore(Integer.parseInt(provinceMore));
		majorLayout.setStaUniKeyMajor(Integer.parseInt(staUniKeyMajor));*/
		majorLayout.setNewMajor(Integer.parseInt(newMajor));
		majorLayout.setStopMajor(Integer.parseInt(stopMajor));
		
		String result = "{\"result\":\"保存失败！\"}";
		
		Integer ct = majorLayoutService.checkYear(majorLayout);
		if(ct>0){
			result = "{\"result\":\"该年份数据已存在!\"}";
			response.setContentType("application/json; charset=utf-8");
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			try {
				PrintWriter out = response.getWriter();
				out.write(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{		
		if (majorLayoutService.saveMajorLayout(majorLayout)) {
			if (params != null) {
				String param = params.toString();

				JSONObject json = JSONObject.fromObject(param);
				@SuppressWarnings("unchecked")
				List<Map<String, String>> tableList = json.getJSONArray("data");

				int flag = tableList.size();
				int count = 0;

				for (int i = 0; i < flag; i++) {
					String induName = tableList.get(i).get("induName");
					String name = tableList.get(i).get("name");
					int firstGradeSum = Integer.parseInt(tableList.get(i).get("firstGradeSum"));
					int secGradeSum = Integer.parseInt(tableList.get(i).get("secGradeSum"));
					int thirdGradeSum = Integer.parseInt(tableList.get(i).get("thirdGradeSum"));

					MajorStu majorStu = new MajorStu();
					majorStu.setAdmcode(admcode);
					majorStu.setYear(year);
					majorStu.setCity(city);
					majorStu.setInduName(induName);
					majorStu.setName(name);
					majorStu.setFirstGradeSum(firstGradeSum);
					majorStu.setSecGradeSum(secGradeSum);
					majorStu.setThirdGradeSum(thirdGradeSum);

					if (majorStuService.saveMajorStu(majorStu)) {
						count++;
					}
				}
				if (flag == count) {
					result = "{\"result\":\"success\"}";
				} else {
					// 失败则删除已经保存内容
					List<MajorLayout> m = majorLayoutService.getMajorLayoutList(admcode, year);
					if (m.size() != 0) {
						int size = m.size() - 1;
						if (majorLayoutService.deleteMajorLayout(m.get(size).getId())) {
						}
					}
					if (majorStuService.deleteMajorStu(admcode, year)) {
					}
				}
				response.setContentType("application/json");
				try {
					PrintWriter out = response.getWriter();
					out.write(result);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				result = "{\"result\":\"success\"}";
				response.setContentType("application/json");
				try {
					PrintWriter out = response.getWriter();
					out.write(result);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			response.setContentType("application/json");
			try {
				PrintWriter out = response.getWriter();
				out.write(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
	/**
	 * 删除专业布局和专业人数
	 */
	@RequestMapping("/delMajorLayout")
	public void delMajorLayout(int id, String admcode, String year, HttpServletRequest request,
			HttpServletResponse response) {
		List<MajorStu> majorStu = majorStuService.getMajorStuList(id);
		String result = "{\"result\":\"error\"}";
		System.out.println(id);
		System.out.println(admcode);
		System.out.println(year);
		if (majorStu.size() != 0) {
			if (majorStuService.deleteMajorStu(admcode, year)) {
				if (majorLayoutService.deleteMajorLayout(id)) {
					result = "{\"result\":\"success\"}";
				} else {
					for (int j = 0; j < majorStu.size(); j++) {
						if (majorStuService.saveMajorStu(majorStu.get(j))) {
						}
					}
				}
				response.setContentType("application/json");
				try {
					PrintWriter out = response.getWriter();
					out.write(result);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			if (majorLayoutService.deleteMajorLayout(id)) {
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
	}

	/**
	 * 删除单条专业人数
	 * 
	 * @param id
	 * @param request
	 */
	@RequestMapping("/deleteMajorStuTable")
	public void deleteMajorStuTable(HttpServletRequest request, HttpServletResponse response, String id) {
		int ids = Integer.parseInt(id);
		majorStuService.deleteMajorStuTable(ids);
	}

	/**
	 * 根据id查询单个专业布局详情
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getMajorLayoutDetail")
	public String getMajorLayoutDetail(int id, String detailFlag, HttpServletRequest request, Model model) {
		MajorLayout majorLayout = majorLayoutService.findById(id);
		request.setAttribute("majorLayout", majorLayout);
		model.addAttribute("majorLayout", majorLayout);
		model.addAttribute("detailFlag", detailFlag);
		return "/qualityAssurance/majorLayoutDet";
	}

	/**
	 * 根据id查询单个专业布局
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getMajorLayout")
	public String getMajorLayout(int id, String detailFlag,HttpServletRequest request, Model model) {
		MajorLayout majorLayout = majorLayoutService.findById(id);
		request.setAttribute("majorLayout", majorLayout);
		model.addAttribute("majorLayout", majorLayout);
		model.addAttribute("detailFlag", detailFlag);
		return "/qualityAssurance/majorLayoutUpd";
	}

	/**
	 * 根据id获取所有专业人数列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getMajorStutList")
	public void getMajorStutList(HttpServletRequest request, HttpServletResponse response, int id) {

		response.setContentType("application/json; charset=utf-8");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");

		List<MajorStu> majorStu = majorStuService.getMajorStuList(id);

		JSONArray jsonArray = JSONArray.fromObject(majorStu);

		String jsonString = jsonArray.toString();

		try {

			response.getWriter().write(jsonString);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 修改专业人数
	 * 
	 * @param majorStu
	 */
	@RequestMapping("/updateMajorLayoutTable")
	public void updateMajorLayoutTable(HttpServletRequest request, HttpServletResponse response, String params,
			String idform, String year, String oneIndu, String twoIndu, String threeIndu, String localPillar,
			String newMajor, String stopMajor) {

		System.out.println(params);
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");		
					
		MajorLayout majorLayout = majorLayoutService.findById(Integer.parseInt(idform));
		MajorLayout majorLayoutStart = majorLayout;
		majorLayout.setAdmcode(admcode);
		majorLayout.setCity(city);
		majorLayout.setYear(year);
		majorLayout.setOneIndu(Integer.parseInt(oneIndu));
		majorLayout.setTwoIndu(Integer.parseInt(twoIndu));
		majorLayout.setThreeIndu(Integer.parseInt(threeIndu));
		majorLayout.setLocalPillar(Integer.parseInt(localPillar));
		/*majorLayout.setProvinceMore(Integer.parseInt(provinceMore));
		majorLayout.setStaUniKeyMajor(Integer.parseInt(staUniKeyMajor));*/
		majorLayout.setNewMajor(Integer.parseInt(newMajor));
		majorLayout.setStopMajor(Integer.parseInt(stopMajor));

		List<MajorStu> majorStuList = majorStuService.getMajorStuList(Integer.parseInt(idform));
		int size = majorStuList.size();

		String result = "{\"result\":\"error\"}";

		if (majorLayoutService.updateMajorLayout(majorLayout)) {
			if (params != null) {
				String param = params.toString();

				JSONObject json = JSONObject.fromObject(param);
				@SuppressWarnings("unchecked")
				List<Map<String, String>> tableList = json.getJSONArray("data");

				int flag = tableList.size();
				int count = 0;

				for (int i = 0; i < flag; i++) {
					String ids = tableList.get(i).get("id");
					String induName = tableList.get(i).get("induName");
					String name = tableList.get(i).get("name");
					int firstGradeSum = Integer.parseInt(tableList.get(i).get("firstGradeSum"));
					int secGradeSum = Integer.parseInt(tableList.get(i).get("secGradeSum"));
					int thirdGradeSum = Integer.parseInt(tableList.get(i).get("thirdGradeSum"));

					MajorStu majorStu = new MajorStu();
					majorStu.setAdmcode(admcode);
					majorStu.setYear(year);
					majorStu.setCity(city);
					majorStu.setInduName(induName);
					majorStu.setName(name);
					majorStu.setFirstGradeSum(firstGradeSum);
					majorStu.setSecGradeSum(secGradeSum);
					majorStu.setThirdGradeSum(thirdGradeSum);
					if (ids.equals("isNull")) {
						if (majorStuService.saveMajorStu(majorStu)) {
							count++;
						}
					} else {
						int id = Integer.parseInt(ids);
						majorStu.setId(id);
						if (majorStuService.updateMajorStu(majorStu)) {
							count++;
						}
					}
				}
				if (flag == count) {
					result = "{\"result\":\"success\"}";
				} else {
					// 恢复起始状态
					if (majorLayoutService.updateMajorLayout(majorLayoutStart)) {
					}
					if (majorStuService.deleteMajorStu(admcode, year)) {
						for (int j = 0; j < size; j++) {
							if (majorStuService.saveMajorStu(majorStuList.get(j))) {
							}
						}
					}
				}
				response.setContentType("application/json");
				try {
					PrintWriter out = response.getWriter();
					out.write(result);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				result = "{\"result\":\"success\"}";
				response.setContentType("application/json");
				try {
					PrintWriter out = response.getWriter();
					out.write(result);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			response.setContentType("application/json");
			try {
				PrintWriter out = response.getWriter();
				out.write(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 通过审核
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateAudit")
	public String updateAudit(int id) {
		if (majorLayoutService.updateAudit(id) && majorStuService.updateAudit(id)) {
			return "redirect:/majorLayout/getMajorLayoutList";
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
		List<MajorLayout> majorLayout = new ArrayList<MajorLayout>();
		List<MajorStu> majorStu = new ArrayList<MajorStu>();

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					majorLayout = majorLayoutService.findByCity(city, years);
				} else {
					admcode = schoolNames;
					majorLayout = majorLayoutService.getMajorLayoutList(admcode, year);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					majorLayout = majorLayoutService.findByCity(city, year);
				} else {
					admcode = schoolName;
					majorLayout = majorLayoutService.getMajorLayoutList(admcode, year);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			majorLayout = majorLayoutService.getMajorLayoutList(admcode, year);
		} else {
			admcode = (String) session.getAttribute("username");
			majorLayout = majorLayoutService.getMajorLayoutList(admcode, year);
		}

		for (int i = 0; i < majorLayout.size(); i++) {
			List<MajorStu> temp = majorStuService.getMajorStuList(majorLayout.get(i).getId());
			majorStu.addAll(temp);
		}

		String fileName = "", path = this.getClass().getClassLoader().getResource(File.separator).getPath(),
				upload = URLDecoder.decode(new File(path).getParentFile().getParent(), "UTF-8") + File.separator
						+ "upload" + File.separator + (String) session.getAttribute("username");
		if (!"".equals(year) && year != null) {// 对应"&year="的链接
			fileName += year;
			if (!"".equals(admcode)) {// 对应"&admcode="的链接
				fileName += ("-" + loginService.getSchoolInfo(admcode).getSchoolname());
			}
		} else if (!"".equals(admcode)) {// 对应"&admcode="的链接
			fileName += loginService.getSchoolInfo(admcode).getSchoolname();
		}

		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String((fileName + "专业布局汇总.zip").getBytes("gbk"), "iso-8859-1"));

		try {
			// 激活下载操作
			// System.out.println(upload);
			File fileUpload = new File(upload),
					fileMain = new File(upload + File.separator + fileName + "专业布局汇总表.xlsx"),
					fileAttach = new File(upload + File.separator + fileName + "专业人数汇总表.xlsx");
			if (!fileUpload.exists() || !fileUpload.isDirectory()) {
				fileUpload.mkdir();
			}
			ZipOutputStream os = new ZipOutputStream(response.getOutputStream());
			ExcelUtil excelUtil = new ExcelUtil(fileMain);
			String[] titleMain = { "招生代码", "年份", "地区", "一产类专业数", "二产类专业数", "三产类专业数", "围绕地方支柱产业的专业开设数", "新增专业数", "停办专业数" };
			excelUtil.writeTitle(titleMain);
			Iterator<MajorLayout> iteMajorLayout = majorLayout.iterator();
			while (iteMajorLayout.hasNext()) {
				MajorLayout coun = (MajorLayout) iteMajorLayout.next();
				if (coun.getAudit() == 1) {
					excelUtil.write(coun);
				}
			}
			excelUtil.close();

			excelUtil = new ExcelUtil(fileAttach);
			String[] titleAttach = { "招生代码", "年份", "城市", "专业类名", "专业名", "一年级人数", "二年级人数", "三年级人数" };
			excelUtil.writeTitle(titleAttach);
			Iterator<MajorStu> iteMajorStu = majorStu.iterator();
			while (iteMajorStu.hasNext()) {
				MajorStu poor = (MajorStu) iteMajorStu.next();
				if (poor.getAudit() == 1) {
					excelUtil.write(poor);
				}
			}
			excelUtil.close();

			ZipUtil.doCompress(fileMain, os);
			ZipUtil.doCompress(fileAttach, os);
			response.flushBuffer();
			os.close();
			ZipUtil.deleteDir(fileUpload);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
