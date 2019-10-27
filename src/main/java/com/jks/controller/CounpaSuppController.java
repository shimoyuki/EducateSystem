package com.jks.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageInfo;
import com.jks.entity.CounDTO;
import com.jks.entity.CounpaSupp;
import com.jks.entity.Poor;
import com.jks.service.LoginService;
import com.jks.service.CounpaSuppService;
import com.jks.utils.ExcelUtil;
import com.jks.utils.ZipUtil;

@Controller
@Transactional
@RequestMapping("/coun")
public class CounpaSuppController {
	@Resource
	private CounpaSuppService counService;
	@Resource
	private LoginService loginService;

	/**
	 * 获取指定市州的所有学校的<编号,名称>map
	 * 
	 * @param city
	 * @return
	 */
	public Map<String, String> getAdmMap(String city) {
		List<String> adms = counService.getAdmcodeByCity("%" + city + "%");
		Map<String, String> admMap = new HashMap<String, String>();
		Iterator<String> iterator = adms.iterator();
		while (iterator.hasNext()) {
			String admcode = iterator.next();
			String name = loginService.getSchoolInfo(admcode).getSchoolname();
			// System.out.println(admcode+";"+name);
			admMap.put(admcode, name);
		}
		return admMap;
	}

	/**
	 * 分页查询对口支援信息，并判断是否条件查询
	 * 
	 * @param request
	 *            param 包含pageNum，pageSize，admcode，year，city五个参数的map
	 * @param model
	 * @return
	 */
	@RequestMapping("/showCounInfo")
	public String showCounInfo(HttpServletRequest request, Model model) {
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
		PageInfo<CounpaSupp> counPage = null;
		try {
			counPage = counService.getCounpaSuppPage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		List<CounpaSupp> counList = counPage.getList();
		model.addAttribute("counList", counList);// 查询结果列表
		model.addAttribute("counPage", counPage);// 分页信息
		if (param.get("year") != null) {// 供再次查询使用
			model.addAttribute("year", param.get("year"));
		}
		if (param.get("admcode") != null) {
			model.addAttribute("admcode", param.get("admcode"));
		}
		model.addAttribute("level", level);
		return "social/coun";
	}

	/**
	 * 返回添加对口支援信息的页面并设置年份选项
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addCoun")
	public String addCounInfo(Model model) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("curYear", curYear);
		return "social/counAdd";
	}

	/**
	 * 执行插入对口支援信息的数据库操作
	 * 
	 * @param counDTO
	 *            包含一个CounpaSupp对象和一个Poor对象的List的包装类
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveCoun", method = RequestMethod.POST)
	@ResponseBody
	public String saveCounInfo(@RequestBody CounDTO counDTO, HttpServletRequest request) {
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
		params.put("year", counDTO.getMain().getYear());
		if (this.counService.getCounpaSuppPage(params).getList().size() > 0) {
			result = "{\"result\":\"该年份数据已存在\"}";
			return result;
		}
		counDTO.getMain().setAdmcode(admcode);
		counDTO.getMain().setCity(city);
		if (counDTO.getList() != null) {
			Iterator<Poor> iterator = counDTO.getList().iterator();
			while (iterator.hasNext()) {
				Poor poor = iterator.next();
				poor.setYear(counDTO.getMain().getYear());
				poor.setAdmcode(admcode);
				poor.setCity(city);
			}
		}
		try {
			if (!counService.addCounpaSupp(counDTO)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 返回更新对口支援信息的页面并根据相应ip填充初始内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateCoun")
	public String updateCounInfo(HttpServletRequest request, Model model,String detailFlag) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int id = Integer.parseInt(request.getParameter("id"));
		CounDTO counDTO = null;
		try {
			counDTO = counService.getCounpaSuppById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("curYear", curYear);
		model.addAttribute("coun", counDTO.getMain());
		model.addAttribute("poorList", counDTO.getList());
		model.addAttribute("detailFlag", detailFlag);
		return "social/counUpd";
	}

	/**
	 * 执行更新对口支援信息的数据库操作
	 * 
	 * @param counDTO
	 *            包含一个CounpaSupp对象和一个Poor对象的List的包装类
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifyCoun")
	@ResponseBody
	public String modifyCounInfo(@RequestBody CounDTO counDTO, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		counDTO.getMain().setId(id);

		String admcode = null, city = null, result = "{\"result\":\"success\"}";
		HttpSession session = request.getSession();
		admcode = (String) session.getAttribute("username");
		city = (String) session.getAttribute("city");
		if (admcode == null || city == null) {
			result = "{\"result\":\"error\"}";
			return result;
		}
		counDTO.getMain().setAdmcode(admcode);
		counDTO.getMain().setCity(city);
		if (counDTO.getList() != null) {
			Iterator<Poor> iterator = counDTO.getList().iterator();
			while (iterator.hasNext()) {
				Poor poor = iterator.next();
				poor.setYear(counDTO.getMain().getYear());
				poor.setAdmcode(admcode);
				poor.setCity(city);
			}
		}
		try {
			if (!counService.modifyCounpaSupp(counDTO)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 查询单条对口支援信息的详细内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showCounDetail")
	public String showCounDetail(HttpServletRequest request, Model model,String detailFlag) {
		int id = Integer.parseInt(request.getParameter("id"));
		CounDTO counDTO = null;
		try {
			counDTO = counService.getCounpaSuppById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("coun", counDTO.getMain());
		model.addAttribute("poorList", counDTO.getList());
		model.addAttribute("detailFlag", detailFlag);
		return "social/counUpd";
	}

	/**
	 * 删除选中id的对口支援信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteCoun")
	public void deleteCounInfo(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (counService.deleteCounpaSupp(id)) {
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
	 * 删除选中id的扶贫技术信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deletePoor")
	public void deletePoorInfo(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (counService.deletePoor(id)) {
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
	 * 修改id对应的对口支援信息状态为审核通过
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("audit")
	public void audit(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		CounDTO counDTO = counService.getCounpaSuppById(id);
		counDTO.getMain().setAudit(1);
		Iterator<Poor> iterator = counDTO.getList().iterator();
		while (iterator.hasNext()) {
			Poor poor = (Poor) iterator.next();
			poor.setAudit(1);
		}
		if (counService.modifyCounpaSupp(counDTO)) {
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
		PageInfo<CounpaSupp> counPage = null;
		List<Poor> poorList = null;
		try {
			counPage = counService.getCounpaSuppPage(param);
			poorList = counService.getPoorList(param);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		List<CounpaSupp> counList = counPage.getList();
		String fileName = "", path = this.getClass().getClassLoader().getResource(File.separator).getPath(),
				upload = URLDecoder.decode(new File(path).getParentFile().getParent(), "UTF-8") + File.separator
						+ "upload" + File.separator + (String) session.getAttribute("username");
		if (!"".equals(year)) {// 对应"&year="的链接
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
				"attachment;fileName=" + new String((fileName + "对口支援汇总.zip").getBytes("gbk"), "iso-8859-1"));

		try {
			// 激活下载操作
			// System.out.println(upload);
			File fileUpload = new File(upload),
					fileMain = new File(upload + File.separator + fileName + "对口支援汇总表.xlsx"),
					fileAttach = new File(upload + File.separator + fileName + "扶贫技术或项目汇总表.xlsx");
			if (!fileUpload.exists() || !fileUpload.isDirectory()) {
				fileUpload.mkdir();
			}
			ZipOutputStream os = new ZipOutputStream(response.getOutputStream());
			ExcelUtil excelUtil = new ExcelUtil(fileMain);
			String[] titleMain = { "招生代码", "年份", "地区", "对口帮扶对象单位数", "扶贫对象数", "资金扶贫（万元）", "服务人数" };
			excelUtil.writeTitle(titleMain);
			Iterator<CounpaSupp> iteCoun = counList.iterator();
			while (iteCoun.hasNext()) {
				CounpaSupp coun = (CounpaSupp) iteCoun.next();
				if (coun.getAudit() == 1) {
					excelUtil.write(coun);
				}
			}
			excelUtil.close();

			excelUtil = new ExcelUtil(fileAttach);
			String[] titleAttach = { "招生代码", "年份", "地区", "扶贫技术名称", "扶贫项目名称" };
			excelUtil.writeTitle(titleAttach);
			Iterator<Poor> itePoor = poorList.iterator();
			while (itePoor.hasNext()) {
				Poor poor = (Poor) itePoor.next();
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
