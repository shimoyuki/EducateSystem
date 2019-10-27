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
import com.jks.entity.Skill;
import com.jks.entity.SkillTrain;
import com.jks.entity.SkiTraDTO;
import com.jks.service.LoginService;
import com.jks.service.SkillTrainService;
import com.jks.utils.ExcelUtil;
import com.jks.utils.ZipUtil;

@Controller
@Transactional
@RequestMapping("/skiTra")
public class SkillTrainController {
	@Resource
	private SkillTrainService skiTraService;
	@Resource
	private LoginService loginService;

	/**
	 * 获取指定市州的所有学校的<编号,名称>map
	 * 
	 * @param city
	 * @return
	 */
	public Map<String, String> getAdmMap(String city) {
		List<String> adms = skiTraService.getAdmcodeByCity("%" + city + "%");
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
	 * 分页查询技术培养信息，并判断是否条件查询
	 * 
	 * @param request
	 *            param 包含pageNum，pageSize，admcode，year，city五个参数的map
	 * @param model
	 * @return
	 */
	@RequestMapping("/showSkiTraInfo")
	public String showSkiTraInfo(HttpServletRequest request, Model model) {
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
			param.put("audit", 1);
			param.put("city", "%" + city + "%");
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
		PageInfo<SkillTrain> skiTraPage = null;
		try {
			skiTraPage = skiTraService.getSkillTrainPage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		List<SkillTrain> skiTraList = skiTraPage.getList();
		model.addAttribute("skiTraList", skiTraList);// 查询结果列表
		model.addAttribute("skiTraPage", skiTraPage);// 分页信息
		if (param.get("year") != null) {// 供再次查询使用
			model.addAttribute("year", param.get("year"));
		}
		if (param.get("admcode") != null) {
			model.addAttribute("admcode", param.get("admcode"));
		}
		model.addAttribute("level", level);
		return "social/skiTra";
	}

	/**
	 * 返回添加技术培养信息的页面并设置年份选项
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addSkiTra")
	public String addSkiTraInfo(Model model) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("curYear", curYear);
		return "social/skiTraAdd";
	}

	/**
	 * 执行插入技术培养信息的数据库操作
	 * 
	 * @param skiTraDTO
	 *            包含一个SkillTrain对象和一个Skill对象的List的包装类
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveSkiTra", method = RequestMethod.POST)
	@ResponseBody
	public String saveSkiTraInfo(@RequestBody SkiTraDTO skiTraDTO, HttpServletRequest request) {
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
		params.put("year", skiTraDTO.getMain().getYear());
		if (this.skiTraService.getSkillTrainPage(params).getList().size() > 0) {
			result = "{\"result\":\"该年份数据已存在\"}";
			return result;
		}
		skiTraDTO.getMain().setAdmcode(admcode);
		skiTraDTO.getMain().setCity(city);
		if (skiTraDTO.getList() != null) {
			Iterator<Skill> iterator = skiTraDTO.getList().iterator();
			while (iterator.hasNext()) {
				Skill skill = iterator.next();
				skill.setYear(skiTraDTO.getMain().getYear());
				skill.setAdmcode(admcode);
				skill.setCity(city);
			}
		}
		try {
			if (!skiTraService.addSkillTrain(skiTraDTO)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 返回更新技术培养信息的页面并根据相应ip填充初始内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateSkiTra")
	public String updateSkiTraInfo(HttpServletRequest request, Model model,String detailFlag) {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int id = Integer.parseInt(request.getParameter("id"));
		SkiTraDTO skiTraDTO = null;
		try {
			skiTraDTO = skiTraService.getSkillTrainById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("curYear", curYear);
		model.addAttribute("skiTra", skiTraDTO.getMain());
		model.addAttribute("skillList", skiTraDTO.getList());
		model.addAttribute("detailFlag", detailFlag);
		return "social/skiTraUpd";
	}

	/**
	 * 执行更新技术培养信息的数据库操作
	 * 
	 * @param skiTraDTO
	 *            包含一个SkillTrain对象和一个Skill对象的List的包装类
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifySkiTra")
	@ResponseBody
	public String modifySkiTraInfo(@RequestBody SkiTraDTO skiTraDTO, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		skiTraDTO.getMain().setId(id);

		String admcode = null, city = null, result = "{\"result\":\"success\"}";
		HttpSession session = request.getSession();
		admcode = (String) session.getAttribute("username");
		city = (String) session.getAttribute("city");
		if (admcode == null || city == null) {
			result = "{\"result\":\"error\"}";
			return result;
		}
		skiTraDTO.getMain().setAdmcode(admcode);
		skiTraDTO.getMain().setCity(city);
		if (skiTraDTO.getList() != null) {
			Iterator<Skill> iterator = skiTraDTO.getList().iterator();
			while (iterator.hasNext()) {
				Skill skill = iterator.next();
				skill.setYear(skiTraDTO.getMain().getYear());
				skill.setAdmcode(admcode);
				skill.setCity(city);
			}
		}
		try {
			if (!skiTraService.modifySkillTrain(skiTraDTO)) {
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}

	/**
	 * 查询单条技术培养信息的详细内容
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showSkiTraDetail")
	public String showSkiTraDetail(HttpServletRequest request, Model model,String detailFlag) {
		int id = Integer.parseInt(request.getParameter("id"));
		SkiTraDTO skiTraDTO = null;
		try {
			skiTraDTO = skiTraService.getSkillTrainById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("skiTra", skiTraDTO.getMain());
		model.addAttribute("skillList", skiTraDTO.getList());
		model.addAttribute("detailFlag", detailFlag);
		return "social/skiTraUpd";
	}

	/**
	 * 删除选中id的技术培养信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteSkiTra")
	public void deleteSkiTraInfo(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (skiTraService.deleteSkillTrain(id)) {
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
	 * 删除选中id的技术培养信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteSkill")
	public void deleteSkillInfo(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (skiTraService.deleteSkill(id)) {
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
	 * 修改id对应的技术培养信息状态为审核通过
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("audit")
	public void audit(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		SkiTraDTO skiTraDTO = skiTraService.getSkillTrainById(id);
		skiTraDTO.getMain().setAudit(1);
		Iterator<Skill> iterator = skiTraDTO.getList().iterator();
		while (iterator.hasNext()) {
			Skill skill = (Skill) iterator.next();
			skill.setAudit(1);
		}
		if (skiTraService.modifySkillTrain(skiTraDTO)) {
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
		PageInfo<SkillTrain> skiTraPage = null;
		List<Skill> skillList = null;
		try {
			skiTraPage = skiTraService.getSkillTrainPage(param);
			skillList = skiTraService.getSkillList(param);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		List<SkillTrain> skiTraList = skiTraPage.getList();
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
				"attachment;fileName=" + new String((fileName + "技术技能人才培养汇总.zip").getBytes("gbk"), "iso-8859-1"));

		try {
			// 激活下载操作
			// System.out.println(upload);
			File fileUpload = new File(upload),
					fileMain = new File(upload + File.separator + fileName + "技术技能人才培养汇总表.xlsx"),
					fileAttach = new File(upload + File.separator + fileName + "学校承担、参与改进或推广技术名称汇总表.xlsx");
			if (!fileUpload.exists() || !fileUpload.isDirectory()) {
				fileUpload.mkdir();
			}
			ZipOutputStream os = new ZipOutputStream(response.getOutputStream());
			ExcelUtil excelUtil = new ExcelUtil(fileMain);
			String[] titleMain = { "招生代码", "年份", "地区", "为当地主要产业培养技术技能人才数", "为当地培训技术技能人才数", "产生的经济效益和社会效益（万元）",
					"学校师生参与当地产业发展或结构调整技术攻关人数" };
			excelUtil.writeTitle(titleMain);
			Iterator<SkillTrain> iteSkiTra = skiTraList.iterator();
			while (iteSkiTra.hasNext()) {
				SkillTrain skiTra = (SkillTrain) iteSkiTra.next();
				if (skiTra.getAudit() == 1) {
					excelUtil.write(skiTra);
				}
			}
			excelUtil.close();

			excelUtil = new ExcelUtil(fileAttach);
			String[] titleAttach = { "招生代码", "年份", "地区", "技术名称" };
			excelUtil.writeTitle(titleAttach);
			Iterator<Skill> iteSkill = skillList.iterator();
			while (iteSkill.hasNext()) {
				Skill skill = (Skill) iteSkill.next();
				if (skill.getAudit() == 1) {
					excelUtil.write(skill);
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
