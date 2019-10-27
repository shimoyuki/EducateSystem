package com.jks.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageInfo;
import com.jks.entity.Major;
import com.jks.entity.SchoolDIO;
import com.jks.entity.SchoolDTO;
import com.jks.entity.SchoolInfo;
import com.jks.entity.MajorSchool;
import com.jks.entity.User;
import com.jks.service.GetCityListService;
import com.jks.service.LoginService;
import com.jks.service.MajorService;
import com.jks.service.SchoolInfoService;
import com.jks.utils.ExcelUtil;

@Controller
@Transactional
@RequestMapping("/school")
public class SchoolInfoController {
	@Resource
	private SchoolInfoService schoolService;
	@Resource
	private MajorService majorService;
	@Resource
	private LoginService loginService;
	@Resource
	private GetCityListService getCityListService;
	
	/**
	 * 获取所有专业的<专业代码,专业名称>的map
	 * @return
	 */
	public Map<String, String> getMajorMap(){
		Map<String, Object> params = new TreeMap<String, Object>();
		Map<String, String> majorMap = new HashMap<String, String>();
		params.put("pageSize", 0);
		List<Major> majorList = majorService.getMajorPage(params).getList(); 
		Iterator<Major> iterator = majorList.iterator();
		while (iterator.hasNext()) {
			Major major = (Major) iterator.next();
			majorMap.put(major.getMajorcode(), major.getName());
		}
		return majorMap;
	}
	
	/**
	 * 处理使用ajax获取专业信息map的请求
	 * @param response
	 */
	@RequestMapping("getMajorMap")
	public void getAjaxMajorMap(HttpServletResponse response){
		JSONObject jsonobject=JSONObject.fromObject(this.getMajorMap());
		try {
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().print(jsonobject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 分页查询对口支援信息，并判断是否条件查询
	 * @param request param 包含pageNum，pageSize，admcode三个参数的map
	 * @param model
	 * @return
	 */
	@RequestMapping("/showSchoolInfo")
	public String showSchoolInfo(HttpServletRequest request,Model model){
		HttpSession session = request.getSession();
		String level = (String)session.getAttribute("level");//权限为空返回登录界面
		if (level == null) {
			return "redirect:/";
		}
		Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
		String admcode = (String)param.get("admcode");
		if ("".equals(admcode)) {//对应"&admcode="的链接
			param.remove("admcode");
		}
		PageInfo<SchoolInfo> schoolPage = null;
		try {
			schoolPage = schoolService.getSchoolInfoPage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		List<SchoolInfo> schoolList = schoolPage.getList();
		model.addAttribute("schoolList",schoolList);//查询结果列表
		model.addAttribute("schoolPage",schoolPage);//分页信息
		if (param.get("admcode") != null) {//供再次查询使用
			model.addAttribute("admcode",param.get("admcode"));
		}
		model.addAttribute("level", level);
		return "admin/school";
	}
	
	/**
	 * 返回添加对口支援信息的页面并设置年份选项
	 * @param model
	 * @return
	 */
	@RequestMapping("/addSchool")
	public String addSchoolInfo(Model model){
		List<User> userList = getCityListService.getCityList();
		List<String> cityList = new ArrayList<String>();
		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			cityList.add(iterator.next().getSchoolname());
		}
		model.addAttribute("cityList",cityList);
		return "admin/schoolAdd";
	}
	
	/**
	 * 执行插入对口支援信息的数据库操作
	 * @param schoolDTO 包含一个SchoolInfo对象和一个MajorSchool对象的List的包装类
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveSchool", method=RequestMethod.POST )
	@ResponseBody
    public String saveSchoolInfo(@RequestBody SchoolDTO schoolDTO, HttpServletRequest request){
		String result = "{\"result\":\"success\"}";
		Map<String, String> majorMap = this.getMajorMap();
		Map<String, Object> params = new TreeMap<String, Object>();
		SchoolInfo schoolInfo = schoolDTO.getMain();
		params.put("admcode", schoolInfo.getAdmcode());
		if (schoolService.getSchoolInfoPage(params).getList().size() > 0) {
			result = "{\"result\":\"该学校数据已存在\"}";
			return result;
		}
		if (schoolDTO.getList() != null) {
			Iterator<MajorSchool> iterator = schoolDTO.getList().iterator();
			while (iterator.hasNext()) {
				MajorSchool majorSchool = iterator.next();
				params.put("majorcode",  majorSchool.getMajorcode());
				if (this.schoolService.getMajorSchoolList(params).size() > 0) {
					result = "{\"result\":\"专业数据已存在\"}";
					return result;
				}
				majorSchool.setAdmcode(schoolInfo.getAdmcode());
				majorSchool.setSchoolname(schoolInfo.getSchoolname());
				majorSchool.setMajorname(majorMap.get(majorSchool.getMajorcode()));
			}
		}
		try {
			if(!schoolService.addSchoolInfo(schoolDTO)){
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			result = "{\"result\":\"error\"}";
		}
		return result;
    }
	
	/**
	 * 返回更新对口支援信息的页面并根据相应ip填充初始内容
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateSchool")
	public String updateSchoolInfo(HttpServletRequest request,Model model){
		String admcode = request.getParameter("admcode");
		SchoolDTO schoolDTO = null;
		try {
			schoolDTO = schoolService.getSchoolInfoById(admcode);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		List<User> userList = getCityListService.getCityList();
		List<String> cityList = new ArrayList<String>();
		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			cityList.add(iterator.next().getSchoolname());
		}
		model.addAttribute("school",schoolDTO.getMain());
		model.addAttribute("majSchList",schoolDTO.getList());
		model.addAttribute("cityList",cityList);
		model.addAttribute("majorMap", this.getMajorMap());
		model.addAttribute("detailFlg", false);
		return "admin/schoolUpd";
	}
	
	/**
	 * 执行更新对口支援信息的数据库操作
	 * @param schoolDTO 包含一个SchoolInfo对象和一个MajorSchool对象的List的包装类
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifySchool")
	@ResponseBody
	public String modifySchoolInfo(@RequestBody SchoolDTO schoolDTO, HttpServletRequest request){
		String result = "{\"result\":\"success\"}";
		Map<String, String> majorMap = this.getMajorMap();
		Map<String, Object> params = new TreeMap<String, Object>();
		SchoolInfo schoolInfo = schoolDTO.getMain();
		params.put("admcode", schoolInfo.getAdmcode());
		if (schoolDTO.getList() != null) {
			Iterator<MajorSchool> iterator = schoolDTO.getList().iterator();
			while (iterator.hasNext()) {
				MajorSchool majorSchool = iterator.next();
				params.put("majorcode",  majorSchool.getMajorcode());
				if (this.schoolService.getMajorSchoolList(params).size() > 0 && majorSchool.getId().equals("-1")) {
					result = "{\"result\":\"专业数据已存在\"}";
					return result;
				}
				majorSchool.setAdmcode(schoolInfo.getAdmcode());
				majorSchool.setSchoolname(schoolInfo.getSchoolname());
				majorSchool.setMajorname(majorMap.get(majorSchool.getMajorcode()));
			}
		}
		try {
			if(!schoolService.modifySchoolInfo(schoolDTO)){
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
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showSchoolDetail")
	public String showSchoolDetail(HttpServletRequest request,Model model){
		String admcode = request.getParameter("admcode");
		SchoolDTO schoolDTO = null;
		try {
			schoolDTO = schoolService.getSchoolInfoById(admcode);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("school",schoolDTO.getMain());
		model.addAttribute("majSchList",schoolDTO.getList());
		model.addAttribute("detailFlg", true);
		return "admin/schoolUpd";
	}
	
	/**
	 * 删除选中admcode的对口支援信息
	 * @param admcode
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteSchool")
	public void deleteSchoolInfo(String admcode, HttpServletRequest request, HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if (schoolService.deleteSchoolInfo(admcode)) {
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
	 * @param admcode
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteMajorSchool")
	public void deleteMajorSchoolInfo(Integer id, HttpServletRequest request, HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if (schoolService.deleteMajorSchool(id)) {
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
	
	@RequestMapping("/upload")
	public String uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile){
		try {
			String majorcode, majorname;
			Map<String, Object> params = new TreeMap<String, Object>();
			if (schoolService.getSchoolInfoPage(params).getList().size() > 0) {
				return "redirect:/school/showSchoolInfo";
			}
			List<Object> schoolList = ExcelUtil.read(uploadFile, SchoolDIO.class);
			Iterator<Object> iterator = schoolList.iterator();
			while (iterator.hasNext()) {
				SchoolDIO object = (SchoolDIO) iterator.next();
				SchoolInfo schoolInfo = object.getSchoolInfo();
				//System.out.println(schoolInfo);
				List<MajorSchool> msList = object.getMajorSchool();
				Iterator<MajorSchool> iterator2 = msList.iterator();
				while (iterator2.hasNext()) {
					MajorSchool majorSchool = (MajorSchool) iterator2.next();
					majorname = majorSchool.getMajorname().replaceAll("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "");
					majorcode = majorService.getMajorCode(majorname);
					if (majorcode != null) {
						majorSchool.setMajorcode(majorcode);
						//System.out.println(majorSchool);
					}else {
						iterator2.remove();
						//System.out.println(majorSchool.getMajorname()+"专业不存在");
					}
				}
				SchoolDTO schoolDTO = new SchoolDTO(msList, schoolInfo);
				//System.out.println(schoolDTO);
				if (!schoolService.addSchoolInfo(schoolDTO)) {
					return "error";
				}
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/school/showSchoolInfo";
	}
	
}
