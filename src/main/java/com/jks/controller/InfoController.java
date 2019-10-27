package com.jks.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jks.entity.Informant;
import com.jks.service.InfoService;
import com.jks.utils.MD5Util;

@Controller
public class InfoController {
	@Resource
	InfoService is;
	@RequestMapping(value="/information",method=RequestMethod.GET)
	public @ResponseBody Informant getInfo(HttpServletRequest request,HttpServletResponse response){
		String usercode=request.getParameter("id");
		Informant info=is.getInfoByUserCode(usercode);
		return info;
	}
	@RequestMapping(value="/change",method=RequestMethod.POST)
	public @ResponseBody String changePW(HttpServletRequest request,HttpServletResponse response){
		String usercode=request.getParameter("id");
		String oPass=request.getParameter("oPass");
		String nPass=request.getParameter("nPass");
		
		String md5pw=MD5Util.getMD5(oPass);
		String pw=is.getPWByUserCode(usercode);
		
		if(!md5pw.equals(pw)){
			return "error";
		}
		String nPW=MD5Util.getMD5(nPass);
		int count=is.updatePWByUserCode(nPW, usercode);
		return "success";
	}
}
