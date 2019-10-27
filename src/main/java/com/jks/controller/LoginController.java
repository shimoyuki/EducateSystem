package com.jks.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jks.entity.Informant;
import com.jks.entity.SchoolInfo;
import com.jks.entity.User;
import com.jks.service.LoginService;
import com.jks.utils.CookieUtil;
import com.jks.utils.MD5Util;

@Controller
public class LoginController {
	@Resource
	private LoginService ls;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, HttpServletResponse response,
			@RequestParam(value = "chk", required = false) String chk, Model model, RedirectAttributes ra) {

		String name = req.getParameter("username");
		String password = req.getParameter("password");
		String md5pw = MD5Util.getMD5(password);
		
		User user = ls.getUserByCode(name);
	
		if (user == null) {
			model.addAttribute("isNull", "0");
			return "/login";
		}

		String pw = user.getPassword();

		if (!md5pw.equals(pw)) {
			model.addAttribute("isError", "0");
			return "/login";
		}
		int loginMaxAge = 7 * 24 * 60 * 60;
		String rememberPwd = chk == null ? "" : chk;
		if ("on".equals(rememberPwd)) {
			CookieUtil.addCookie(response, "loginName", name, loginMaxAge); // 将姓名加入到cookie中
			CookieUtil.addCookie(response, "loginPwd", password, loginMaxAge); // 将密码加入到cookie中
		}
		HttpSession session = req.getSession();
		// 用户
		session.setAttribute("username", name);

		String base = req.getContextPath();
		
		// 基础路径
		session.setAttribute("base", base);

		String level = user.getLevel();
		// 账号等级
		session.setAttribute("level", level);

		if ("1".equals(level)) {
			SchoolInfo school = ls.getSchoolInfo(name);
			// 城市
			session.setAttribute("city", school.getArea());
		}
		if ("3".equals(level)) {
			session.setAttribute("city", user.getSchoolname());
		}

		// 学校、地区管理员和管理员共有一个字段
		session.setAttribute("schoolname", user.getSchoolname());

		int count = ls.getInforByUser(name);
		if (count == 0) {
			ra.addFlashAttribute("usercode", name);
			ra.addFlashAttribute("level", level);
			return "redirect:/page/informant";
		} else {
			
			int id = ls.updateLoginCount(name);
		
			if (!"4".equals(level))
				return "redirect:/size/getSizeList";
			else
				return "redirect:/account/getAccountList";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		session.invalidate();
		return "/login";

	}

	@RequestMapping(value = "/page/info", method = RequestMethod.POST)
	public String addInfo(Informant info, HttpServletRequest req) {	
		
		int id = ls.insertAndGet(info);
		
		String level = req.getParameter("level");
		if (!"4".equals(level))
			return "redirect:/size/getSizeList";
		else
			return "";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "/login";
	}

	@RequestMapping(value = "/page/index", method = RequestMethod.GET)
	public String index() {
		return "/index";
	}

	@RequestMapping(value = "/page/informant", method = RequestMethod.GET)
	public String info(Informant info) {
		return "/informant";
	}

}
