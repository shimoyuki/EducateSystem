package com.jks.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageInfo;
import com.jks.entity.Major;
import com.jks.service.LoginService;
import com.jks.service.MajorService;
import com.jks.utils.ExcelUtil;

@Controller
@RequestMapping("/major")
public class MajorController {
	@Resource
	private MajorService majorService;
	@Resource
	private LoginService loginService;
	
	/**
	 * 分页查询专业信息，并判断是否条件查询
	 * @param request param 包含pageNum，pageSize，majorcode三个参数的map
	 * @return
	 */
	@RequestMapping("/showMajorInfo")
	public String showMajorInfo(HttpServletRequest request,Model model){
		HttpSession session = request.getSession();
		String level = (String)session.getAttribute("level");//权限为空返回登录界面
		if (level == null) {
			return "redirect:/";
		}
		Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
		String majorcode = (String) param.get("majorcode");
		if ("".equals(majorcode)) {//对应"&majorcode="的链接
			param.remove("majorcode");
		}
		PageInfo<Major> majorPage = null;
		try {
			majorPage = majorService.getMajorPage(param);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		List<Major> majorList = majorPage.getList();
		model.addAttribute("majorList",majorList);//查询结果列表
		model.addAttribute("majorPage",majorPage);//分页信息
		if (param.get("majorcode") != null) {//供再次查询使用
			model.addAttribute("majorcode",param.get("majorcode"));
		}
		model.addAttribute("level", level);
		return "admin/major";
	}
	
	/**
	 * 返回添加专业信息的页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/addMajor")
	public String addMajorInfo(Model model){
		return "admin/majorAdd";
	}
	
	/**
	 * 执行插入专业信息的数据库操作
	 * @param major
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveMajor")
	@ResponseBody
	public String saveMajorInfo(Major major, HttpServletRequest request){
		String result = "{\"result\":\"success\"}";
		try {
			if (majorService.getMajorById(major.getMajorcode()) != null) {
				result = "{\"result\":\"添加失败，请检查专业代码是否重复！\"}";
				return result;
			}
			if(!majorService.addMajor(major)){
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}
	
	/**
	 * 返回更新专业信息的页面并根据相应ip填充初始内容
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateMajor")
	public String updateMajorInfo(HttpServletRequest request,Model model){
		String majorcode = request.getParameter("majorcode");
		Major major = null;
		try {
			major = majorService.getMajorById(majorcode);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("major",major);
		model.addAttribute("detailFlg", false);
		return "admin/majorUpd";
	}
	
	/**
	 * 执行更新专业信息的数据库操作
	 * @param major
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifyMajor")
	@ResponseBody
	public String modifyMajorInfo(Major major, HttpServletRequest request){
		String result = "{\"result\":\"success\"}";
		try {
			if(!majorService.modifyMajor(major)){
				result = "{\"result\":\"error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"error\"}";
		}
		return result;
	}
	
	/**
	 * 查询单条专业信息的详细内容
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showMajorDetail")
	public String showMajorDetail(HttpServletRequest request,Model model){
		String majorcode = request.getParameter("majorcode");
		Major major =null;
		try {
			major = majorService.getMajorById(majorcode);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("major",major);
		model.addAttribute("detailFlg", true);
		return "admin/majorUpd";
	}
	
	/**
	 *  删除选中id的专业信息
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteMajor")
	public void deleteMajorInfo(String majorcode, HttpServletRequest request, HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if (majorService.deleteMajor(majorcode)) {
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
		//String result = "{\"result\":\"success\"}";
		//System.out.println(uploadFile.getOriginalFilename());
		try {
			Map<String, Object> params = new TreeMap<String, Object>();
			if (majorService.getMajorPage(params).getList().size() > 0) {
				//result = "{\"result\":\"数据库已存在！\"}";
				return "redirect:/major/showMajorInfo";
			}
			List<Object> majorList = ExcelUtil.read(uploadFile, Major.class);
			Iterator<Object> iterator = majorList.iterator();
			while (iterator.hasNext()) {
				Major object = (Major) iterator.next();
				System.out.println(object);
				if (!majorService.addMajor(object)) {
					//result = "{\"result\":\"error\"}";
					return "error";
				}
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//result = "{\"result\":\"error\"}";
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//result = "{\"result\":\"error\"}";
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//result = "{\"result\":\"error\"}";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//result = "{\"result\":\"error\"}";
		}
		return "redirect:/major/showMajorInfo";
	}
}
