package com.jks.interceptor;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jks.dao.UserMapper;
import com.jks.entity.User;
import com.jks.utils.CookieUtil;

public class LoginInterceptor implements HandlerInterceptor {

	@Resource
	private UserMapper um;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		/*
		 * Object user = request.getSession().getAttribute("username");
		 * 
		 * if(user==null){ response.sendRedirect("/login"); return false; }
		 * return true;
		 */
		String uri = request.getRequestURI();
		
		 //设置不拦截的对象  
        String[] noFilters = new String[] {"login","logout"};  //对登录本身的页面以及业务不拦截  
        boolean beFilter = true;   
        for (String s : noFilters) {    
            if (uri.indexOf(s) != -1) {    
                beFilter = false;    
                break;    
            }    
        }  
        if(beFilter){
        	String path = request.getContextPath();
    		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
    				+ "/";
    		Cookie cokLoginName = CookieUtil.getCookieByName(request, "loginName");
    		Cookie cokLoginPwd = CookieUtil.getCookieByName(request, "loginPwd");
    		if (cokLoginName != null && cokLoginPwd != null && cokLoginName.getValue() != ""
    				&& cokLoginPwd.getValue() != "") {
    			String loginName = cokLoginName.getValue();
    			String loginPwd = cokLoginPwd.getValue();
    			User user = um.selectByNameAndPW(loginName, loginPwd);
    			if (user == null) {
    				CookieUtil.addCookie(response, "loginName", null, 0); // 清除Cookie
    				CookieUtil.addCookie(response, "loginPwd", null, 0); // 清除Cookie
    				try {
    					response.sendRedirect(basePath + "login");
    					return false;
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    				// request.getSession().setAttribute("errorInfo", "请登录！");
    			} else {
    				String name = (String) request.getSession().getAttribute("username");

    				if (name == null) {
    					// request.getSession().setAttribute("user", usersession);
    					request.getSession().setAttribute("username", name);

    				} else {
    					if (name.equals(user.getUsercode())) {
    						request.getSession().setAttribute("username", user.getUsercode());
    					} else {
    						request.getSession().setAttribute("username", name);
    					}
    				}
    			}
    		} else {
    			String name = (String) request.getSession().getAttribute("username");
    			if (name == null) {
    				response.sendRedirect(basePath + "login");
    				return false;
    			} else {

    			}

    		}
        }
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
