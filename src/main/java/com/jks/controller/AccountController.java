package com.jks.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jks.entity.Size;
import com.jks.entity.User;
import com.jks.service.InfoService;
import com.jks.service.UserService;
import com.jks.utils.MD5Util;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Resource
	private UserService us;
	@Resource
	private InfoService is;

	@RequestMapping("/getAccountList")
	public String getAccountList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum,
			HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String level = (String) session.getAttribute("level");
		Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
		String account = (String) param.get("account");
		String accounts = (String) param.get("accounts");
		param.remove("account");
		param.remove("accounts");
		
		int userCount=us.getSum();
		int infoCount=is.getSum();
		int loginCount=is.getLoginCount();
		model.addAttribute("userCount", userCount);
		model.addAttribute("infoCount", infoCount);
		model.addAttribute("loginCount", loginCount);
		DecimalFormat df = new DecimalFormat("######0.00");   
		double totalSize = getDirSize(new File("D:Education"));
		model.addAttribute("totalsize", df.format(totalSize)+"MB");
		
		long totalSpace = new File("d:").getTotalSpace()/1024/1024; 
		
		model.addAttribute("totalspace", df.format(totalSpace)+"MB");
		
		if (!"4".equals(level)) {
			return "redirect:/login";
		} else {
			PageHelper.startPage(pagenum, 12);
			if(""==account||null==account) {
				List<User> user = us.getAllUserByAccount(accounts);
				PageInfo pageInfo = new PageInfo(user, 5);
				model.addAttribute("pageInfo", pageInfo);
				model.addAttribute("account", accounts);
			}else {
				List<User> user = us.getAllUserByAccount(account);
				PageInfo pageInfo = new PageInfo(user, 5);
				model.addAttribute("pageInfo", pageInfo);
				model.addAttribute("account", account);
			}
			return "/admin/account";
		}
	}
	public double getDirSize(File file) {    
		//判断文件是否存在     
        if (file.exists()) {     
            //如果是目录则递归计算其内容的总大小    
            if (file.isDirectory()) {     
                File[] children = file.listFiles();     
                double size = 0;     
                for (File f : children)     
                    size += getDirSize(f);     
                return size;     
            } else {//如果是文件则直接返回其大小,以“兆”为单位   
            	double size = (double) file.length() / 1024 / 1024;        
                return size;     
            }     
        } else {     
            System.out.println("文件或者文件夹不存在，请检查路径是否正确！");     
            return 0.0;     
        }     
	}
	@RequestMapping("/toAddAccount")
	public String toAddAccount() {
		return "/admin/accountAdd";
	}

	@RequestMapping("/saveAccount")
	public String saveAccount(Model model, HttpServletRequest request,User user) {		
		String newPW = MD5Util.getMD5(user.getPassword());
		user.setPassword(newPW);
		String[] sname=user.getSchoolname().split("\\,");
		
		if("3".equals(user.getLevel())){
			user.setSchoolname(sname[1]);
		}else{
			user.setSchoolname(sname[0]);
		}
		us.saveUser(user);
		return "redirect:/account/getAccountList";
	}

	@RequestMapping("/delAccount")
	public void delSize(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (us.deleteAccount(id)) {
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

	@RequestMapping("/getAccount")
	public String getAccount(int id, String detailFlag, HttpServletRequest request, Model model) {
		User user = us.findById(id);
		model.addAttribute("detailFlag", detailFlag);
		model.addAttribute("user", user);
		return "/admin/accountUpd";
	}

	@RequestMapping("/updateAccount")
	public String updateAccount(HttpServletRequest request, Model model) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String usercode = request.getParameter("usercode");
		String password = request.getParameter("password");
		String realPW=request.getParameter("realPW");
		String level = request.getParameter("level");
		String sn = request.getParameter("schoolname");
		User user=null;
		if("******".equals(password))
			user = new User(id,usercode, realPW, level, sn);
		else{
			String newPW=MD5Util.getMD5(password);
			user = new User(id,usercode, newPW, level, sn);
		}
		
		if (us.updateAccount(user)) {
			user = us.findById(user.getId());
			request.setAttribute("user", user);
			model.addAttribute("user", user);
			return "redirect:/account/getAccountList";
		} else {
			return "/error";
		}
	}
}
