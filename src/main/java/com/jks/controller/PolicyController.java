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
import com.jks.entity.Funds;
import com.jks.entity.Policy;
import com.jks.entity.PolicyMeasure;
import com.jks.entity.ProjectInput;
import com.jks.entity.Size;
import com.jks.service.LoginService;
import com.jks.service.PolicyService;
import com.jks.service.PolicyMeasureService;
import com.jks.utils.ExcelUtil;
import com.jks.utils.ZipUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/policy")
public class PolicyController {
	@Autowired
	private PolicyService policyService;
	@Autowired
	private PolicyMeasureService policyMeasureService;
	@Autowired
	private LoginService loginService;

	/**
	 * 获取所有政策列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPolicyList")
	public String getPolicyList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum, Model model,
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
					List<Policy> policy = policyService.findByCity(city, years);
					PageInfo pageInfo = new PageInfo(policy, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<Policy> policy = policyService.getPolicyList(admcode, year);
					PageInfo pageInfo = new PageInfo(policy, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<Policy> policy = policyService.findByCity(city, year);
					PageInfo pageInfo = new PageInfo(policy, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<Policy> policy = policyService.getPolicyList(admcode, year);
					PageInfo pageInfo = new PageInfo(policy, 5);
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
			List<Policy> policy = policyService.getPolicyList(admcode, year);
			PageInfo pageInfo = new PageInfo(policy, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<Policy> policy = policyService.getPolicyList(admcode, year);
			PageInfo pageInfo = new PageInfo(policy, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		}
		return "/organizer/policy";
	}

	/**
	 * 跳转到添加政策界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAddPolicy")
	public String toAddMajorNum() {
		return "/organizer/policyAdd";
	}

	/**
	 * 添加政策和政策措施
	 */
	@RequestMapping("/savePolicyTable")
	public void savePolicyTable(HttpServletRequest request, HttpServletResponse response, String params, String year,
			String teacher) {
		System.out.println(params);
		// 从session中获取招生代码和城市
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");
		// 将要保存的政策信息存入policy实体
		Policy policy = new Policy();
		policy.setAdmcode(admcode);
		policy.setYear(year);
		policy.setCity(city);
		policy.setTeacher(Integer.parseInt(teacher));
		// 申明一个返回信息
		String result = "{\"result\":\"保存失败！\"}";
		//判断该年份信息是否存在
		Integer ct = policyService.checkYear(policy);
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
		// 判断政策信息保存是否成功，成功则开始执行政策措施信息保存
		if (policyService.savePolicy(policy)) {
			if (params != null) {
				String param = params.toString();
				// 将政策措施信息转换为json格式
				JSONObject json = JSONObject.fromObject(param);
				// 将所有政策措施信息存入List
				@SuppressWarnings("unchecked")
				List<Map<String, String>> tableList = json.getJSONArray("data");
				// 获取政策措施信息条数
				int flag = tableList.size();
				// 申明计数器
				int count = 0;
				// 遍历每条政策措施信息
				for (int i = 0; i < flag; i++) {
					// 取出每条政策措施信息里面的内容
					String autoRight = tableList.get(i).get("autoRight");
					String level = tableList.get(i).get("level");
					// 将每条政策措施信息存入policyMeasure实体
					PolicyMeasure policyMeasure = new PolicyMeasure();
					policyMeasure.setAdmcode(admcode);
					policyMeasure.setYear(year);
					policyMeasure.setCity(city);
					policyMeasure.setAutoRight(autoRight);
					policyMeasure.setLevel(level);
					// 执行政策措施信息保存，如果成功则计数器加一
					if (policyMeasureService.savePolicyMeasure(policyMeasure)) {
						count++;
					}
				}
				// 判断是否每条政策措施信息都保存成功，成功则修改返回信息
				if (flag == count) {
					result = "{\"result\":\"success\"}";
				} else {
					// 失败则删除已经保存内容
					List<Policy> p = policyService.getPolicyList(admcode, year);
					if (p.size() != 0) {
						int size = p.size() - 1;
						if (policyService.deletePolicy(p.get(size).getId())) {
						}
					}
					if (policyMeasureService.deletePolicyMeasure(admcode, year)) {
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
	 * 删除政策 和政策措施
	 */
	@RequestMapping("/delPolicy")
	public void delPolicy(int id, String admcode, String year, HttpServletRequest request,
			HttpServletResponse response) {
		List<PolicyMeasure> policyMeasure = policyMeasureService.getPolicyMeasureList(id);
		String result = "{\"result\":\"error\"}";

		if (policyMeasure.size() != 0) {
			if (policyMeasureService.deletePolicyMeasure(admcode, year)) {
				if (policyService.deletePolicy(id)) {
					result = "{\"result\":\"success\"}";
				} else {
					for (int j = 0; j < policyMeasure.size(); j++) {
						if (policyMeasureService.savePolicyMeasure(policyMeasure.get(j))) {
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
			if (policyService.deletePolicy(id)) {
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
	 * 根据id查询单个政策
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPolicy")
	public String getPolicy(int id, String detailFlag, HttpServletRequest request, Model model) {
		Policy policy = policyService.findById(id);
		request.setAttribute("policy", policy);
		model.addAttribute("policy", policy);
		model.addAttribute("detailFlag", detailFlag);
		return "/organizer/policyUpd";
	}

	/**
	 * 根据id查询单个政策详情
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPolicyDetail")
	public String getPolicyDetail(int id, String detailFlag, HttpServletRequest request, Model model) {
		Policy policy = policyService.findById(id);
		request.setAttribute("policy", policy);
		model.addAttribute("policy", policy);
		model.addAttribute("detailFlag", detailFlag);
		return "/organizer/policyDet";
	}

	/**
	 * 根据id获取所有政策措施列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPolicyMeasure")
	public void getPolicyMeasure(HttpServletRequest request, HttpServletResponse response, int id) {

		response.setContentType("application/json; charset=utf-8");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");

		List<PolicyMeasure> policyMeasure = policyMeasureService.getPolicyMeasureList(id);
		JSONArray jsonArray = JSONArray.fromObject(policyMeasure);
		String jsonString = jsonArray.toString();

		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改政策和政策措施
	 */
	@RequestMapping("/updatePolicyTable")
	public void updatePolicyTable(HttpServletRequest request, HttpServletResponse response, String params,
			String idform, String year, String teacher) {

		System.out.println(params);
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");

		Policy policy = policyService.findById(Integer.parseInt(idform));
		Policy policyStart = policy;
		policy.setTeacher(Integer.parseInt(teacher));
		policy.setYear(year);

		List<PolicyMeasure> policyMeasureList = policyMeasureService.getPolicyMeasureList(Integer.parseInt(idform));
		int size = policyMeasureList.size();

		String result = "{\"result\":\"error\"}";

		if (policyService.updatePolicy(policy)) {
			if (params != null) {
				String param = params.toString();

				JSONObject json = JSONObject.fromObject(param);
				@SuppressWarnings("unchecked")
				List<Map<String, String>> tableList = json.getJSONArray("data");

				int flag = tableList.size();
				int count = 0;

				for (int i = 0; i < flag; i++) {
					String ids = tableList.get(i).get("id");
					String autoRight = tableList.get(i).get("autoRight");
					String level = tableList.get(i).get("level");

					PolicyMeasure policyMeasure = new PolicyMeasure();
					policyMeasure.setAdmcode(admcode);
					policyMeasure.setYear(year);
					policyMeasure.setCity(city);
					policyMeasure.setAutoRight(autoRight);
					policyMeasure.setLevel(level);

					if (ids.equals("isNull")) {
						if (policyMeasureService.savePolicyMeasure(policyMeasure)) {
							count++;
						}
					} else {
						int id = Integer.parseInt(ids);
						policyMeasure.setId(id);
						if (policyMeasureService.updateProjectInput(policyMeasure)) {
							count++;
						}
					}
				}
				if (flag == count) {
					result = "{\"result\":\"success\"}";
				} else {
					// 恢复起始状态
					if (policyService.updatePolicy(policyStart)) {
					}
					if (policyMeasureService.deletePolicyMeasure(admcode, year)) {
						for (int j = 0; j < size; j++) {
							if (policyMeasureService.savePolicyMeasure(policyMeasureList.get(j))) {
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
	 * 删除单条政策措施
	 * 
	 * @param id
	 * @param request
	 */
	@RequestMapping("/deletePolicyTable")
	public void deletePolicyTable(HttpServletRequest request, HttpServletResponse response, String id) {
		int ids = Integer.parseInt(id);
		policyMeasureService.deletePolicyTable(ids);
	}

	/**
	 * 通过审核
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateAudit")
	public String updateAudit(int id) {
		if (policyService.updateAudit(id) && policyMeasureService.updateAudit(id)) {
			return "redirect:/policy/getPolicyList";
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
		List<Policy> policy = new ArrayList<Policy>();
		List<PolicyMeasure> policyMeasure = new ArrayList<PolicyMeasure>();

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					policy = policyService.findByCity(city, years);
				} else {
					admcode = schoolNames;
					policy = policyService.getPolicyList(admcode, year);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					policy = policyService.findByCity(city, year);
				} else {
					admcode = schoolName;
					policy = policyService.getPolicyList(admcode, year);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			policy = policyService.getPolicyList(admcode, year);
		} else {
			admcode = (String) session.getAttribute("username");
			policy = policyService.getPolicyList(admcode, year);
		}

		for (int i = 0; i < policy.size(); i++) {
			List<PolicyMeasure> temp = policyMeasureService.getPolicyMeasureList(policy.get(i).getId());
			policyMeasure.addAll(temp);
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
				"attachment;fileName=" + new String((fileName + "政策汇总.zip").getBytes("gbk"), "iso-8859-1"));

		try {
			// 激活下载操作
			// System.out.println(upload);
			File fileUpload = new File(upload), fileMain = new File(upload + File.separator + fileName + "政策汇总表.xlsx"),
					fileAttach = new File(upload + File.separator + fileName + "政策措施汇总表.xlsx");
			if (!fileUpload.exists() || !fileUpload.isDirectory()) {
				fileUpload.mkdir();
			}
			ZipOutputStream os = new ZipOutputStream(response.getOutputStream());
			ExcelUtil excelUtil = new ExcelUtil(fileMain);
			String[] titleMain = { "招生代码", "年份", "城市", "年度新增教师编制数" };
			excelUtil.writeTitle(titleMain);
			Iterator<Policy> itePolicy = policy.iterator();
			while (itePolicy.hasNext()) {
				Policy coun = (Policy) itePolicy.next();
				if (coun.getAudit() == 1) {
					excelUtil.write(coun);
				}
			}
			excelUtil.close();

			excelUtil = new ExcelUtil(fileAttach);
			String[] titleAttach = { "招生代码", "年份", "地区", "区域落实办学自主权政策名称", "提升学校办学水平的政策和制度名称" };
			excelUtil.writeTitle(titleAttach);
			Iterator<PolicyMeasure> itePolicyMeasure = policyMeasure.iterator();
			while (itePolicyMeasure.hasNext()) {
				PolicyMeasure poor = (PolicyMeasure) itePolicyMeasure.next();
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
