package com.jks.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
import com.jks.entity.ProjectInput;
import com.jks.entity.ProjectInputDIO;
import com.jks.service.FundsService;
import com.jks.service.LoginService;
import com.jks.service.ProjectInputService;
import com.jks.utils.ExcelUtil;
import com.jks.utils.ZipUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/funds")
public class FundsController {
	@Autowired
	private FundsService fundsService;
	@Autowired
	private ProjectInputService projectInputService;
	@Autowired
	private LoginService loginService;

	/**
	 * 获取所有经费列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getFundsList")
	public String getFundsList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum, Model model,
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
					List<Funds> funds = fundsService.findByCity(city, years);
					PageInfo pageInfo = new PageInfo(funds, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<Funds> funds = fundsService.getFundsList(admcode, years);
					PageInfo pageInfo = new PageInfo(funds, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<Funds> funds = fundsService.findByCity(city, year);
					PageInfo pageInfo = new PageInfo(funds, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<Funds> funds = fundsService.getFundsList(admcode, year);
					PageInfo pageInfo = new PageInfo(funds, 5);
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
			List<Funds> funds = fundsService.getFundsList(admcode, year);
			PageInfo pageInfo = new PageInfo(funds, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<Funds> funds = fundsService.getFundsList(admcode, year);
			PageInfo pageInfo = new PageInfo(funds, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		}

		return "/organizer/funds";
	}

	/**
	 * 跳转到添加经费界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAddFunds")
	public String toAddMajorNum() {
		return "/organizer/fundsAdd";
	}

	/**
	 * 添加项目和项目投入
	 */
	@RequestMapping("/saveFundsTable")
	public void saveFundsTable(HttpServletRequest request, HttpServletResponse response, String params, String year,
			String centerFund, String localFund, String debt, String loan, String appropriation, String teacInputRadio,
			String teachChange, String fundBudget) {

		System.out.println(params);
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");

		Funds fundsObj = new Funds();
		fundsObj.setAdmcode(admcode);
		fundsObj.setCity(city);
		fundsObj.setYear(year);
		BigDecimal centerFunds = new BigDecimal(centerFund);
		fundsObj.setCenterFund(centerFunds);
		BigDecimal localFunds = new BigDecimal(localFund);
		fundsObj.setLocalFund(localFunds);
		BigDecimal debts = new BigDecimal(debt);
		fundsObj.setDebt(debts);
		BigDecimal loans = new BigDecimal(loan);
		fundsObj.setLoan(loans);
		BigDecimal appropriations = new BigDecimal(appropriation);
		fundsObj.setAppropriation(appropriations);
		fundsObj.setTeacInputRadio(teacInputRadio);
		BigDecimal teachChanges = new BigDecimal(teachChange);
		fundsObj.setTeachChange(teachChanges);
		BigDecimal fundBudgets = new BigDecimal(fundBudget);
		fundsObj.setFundBudget(fundBudgets);

		String result = "{\"result\":\"保存失败！\"}";
		
		Integer ct = fundsService.checkYear(fundsObj);
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

		if (fundsService.saveFunds(fundsObj)) {
			if (params != null) {
				String param = params.toString();

				JSONObject json = JSONObject.fromObject(param);
				@SuppressWarnings("unchecked")
				List<Map<String, String>> tableList = json.getJSONArray("data");

				int flag = tableList.size();
				int count = 0;

				for (int i = 0; i < flag; i++) {

					String name = tableList.get(i).get("name");
					BigDecimal funds = new BigDecimal(tableList.get(i).get("funds"));
					int type = Integer.parseInt(tableList.get(i).get("type"));

					ProjectInput projectInput = new ProjectInput();
					projectInput.setAdmcode(admcode);
					projectInput.setYear(year);
					projectInput.setCity(city);
					projectInput.setName(name);
					projectInput.setFunds(funds);
					projectInput.setType(type);

					if (projectInputService.saveProjectInput(projectInput)) {
						count++;
					}
				}
				if (flag == count) {
					result = "{\"result\":\"success\"}";
				} else {
					// 失败则删除已经保存内容
					List<Funds> f = fundsService.getFundsList(admcode, year);
					if (f.size() != 0) {
						int size = f.size() - 1;
						if (fundsService.deleteFunds(f.get(size).getId())) {
						}
					}
					if (projectInputService.deleteProjectInput(admcode, year)) {
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
	 * 删除经费和项目投入
	 */
	@RequestMapping("/delFunds")
	public void delFunds(int id, String admcode, String year, HttpServletRequest request,
			HttpServletResponse response) {
		List<ProjectInput> projectInput = projectInputService.getProjectInputList(id);
		String result = "{\"result\":\"error\"}";

		if (projectInput.size() != 0) {
			if (projectInputService.deleteProjectInput(admcode, year)) {
				if (fundsService.deleteFunds(id)) {
					result = "{\"result\":\"success\"}";
				} else {
					for (int j = 0; j < projectInput.size(); j++) {
						if (projectInputService.saveProjectInput(projectInput.get(j))) {
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
				response.setContentType("application/json");
				try {
					PrintWriter out = response.getWriter();
					out.write(result);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			if (fundsService.deleteFunds(id)) {
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
	 * 根据id查询单个经费
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getFunds")
	public String getFunds(int id, String detailFlag, HttpServletRequest request, Model model) {
		Funds funds = fundsService.findById(id);
		request.setAttribute("funds", funds);
		model.addAttribute("funds", funds);
		model.addAttribute("detailFlag", detailFlag);
		
		return "/organizer/fundsUpd";
	}

	/**
	 * 根据id查询单个经费详情
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getFundsDetail")
	public String getFundsDetail(int id, String detailFlag, HttpServletRequest request, Model model) {
		Funds funds = fundsService.findById(id);
		request.setAttribute("funds", funds);
		model.addAttribute("funds", funds);
		model.addAttribute("detailFlag", detailFlag);
		return "/organizer/fundsDet";
	}

	/**
	 * 根据id获取所有项目投入列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getProjectInputtList")
	public void getMajorStutList(HttpServletRequest request, HttpServletResponse response, int id) {

		response.setContentType("application/json; charset=utf-8");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");

		List<ProjectInput> projectInput = projectInputService.getProjectInputList(id);

		for (int i = 0; i < projectInput.size(); i++) {
			if (projectInput.get(i).getType() == 0) {
				projectInput.get(i).setTypeName("中央专项资金");
			} else if (projectInput.get(i).getType() == 1) {
				projectInput.get(i).setTypeName("省级专项资金");
			} else {
				projectInput.get(i).setTypeName("市级专项资金");
			}
		}

		JSONArray jsonArray = JSONArray.fromObject(projectInput);

		String jsonString = jsonArray.toString();

		try {

			response.getWriter().write(jsonString);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 修改经费和项目投入
	 */
	@RequestMapping("/updateFundsTable")
	public void updateFundsTable(HttpServletRequest request, HttpServletResponse response, String params, String year,
			String centerFund, String localFund, String debt, String loan, String appropriation, String teacInputRadio,
			String teachChange, String fundBudget, String idform) {

		System.out.println(params);
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");

		Funds funds = fundsService.findById(Integer.parseInt(idform));
		Funds fundsStart = funds;
		funds.setAdmcode(admcode);
		funds.setCity(city);
		funds.setYear(year);
		BigDecimal centerFunds = new BigDecimal(centerFund);
		funds.setCenterFund(centerFunds);
		BigDecimal localFunds = new BigDecimal(localFund);
		funds.setLocalFund(localFunds);
		BigDecimal debts = new BigDecimal(debt);
		funds.setDebt(debts);
		BigDecimal loans = new BigDecimal(loan);
		funds.setLoan(loans);
		BigDecimal appropriations = new BigDecimal(appropriation);
		funds.setAppropriation(appropriations);
		funds.setTeacInputRadio(teacInputRadio);
		BigDecimal teachChanges = new BigDecimal(teachChange);
		funds.setTeachChange(teachChanges);
		BigDecimal fundBudgets = new BigDecimal(fundBudget);
		funds.setFundBudget(fundBudgets);

		List<ProjectInput> projectInputList = projectInputService.getProjectInputList(Integer.parseInt(idform));
		int size = projectInputList.size();

		String result = "{\"result\":\"error\"}";

		if (fundsService.updateFunds(funds)) {
			if (params != null) {
				String param = params.toString();

				JSONObject json = JSONObject.fromObject(param);
				@SuppressWarnings("unchecked")
				List<Map<String, String>> tableList = json.getJSONArray("data");

				int flag = tableList.size();
				int count = 0;

				for (int i = 0; i < flag; i++) {
					String ids = tableList.get(i).get("id");
					int type = Integer.parseInt(tableList.get(i).get("type"));
					String name = tableList.get(i).get("name");
					BigDecimal fund = new BigDecimal(tableList.get(i).get("funds"));

					ProjectInput projectInput = new ProjectInput();
					projectInput.setAdmcode(admcode);
					projectInput.setYear(year);
					projectInput.setCity(city);
					projectInput.setType(type);
					projectInput.setName(name);
					projectInput.setFunds(fund);

					if (ids.equals("isNull")) {
						if (projectInputService.saveProjectInput(projectInput)) {
							count++;
						}
					} else {
						int id = Integer.parseInt(ids);
						projectInput.setId(id);
						if (projectInputService.updateProjectInput(projectInput)) {
							count++;
						}
					}
				}
				if (flag == count) {
					result = "{\"result\":\"success\"}";
				} else {
					// 恢复起始状态
					if (fundsService.updateFunds(fundsStart)) {
					}
					if (projectInputService.deleteProjectInput(admcode, year)) {
						for (int j = 0; j < size; j++) {
							if (projectInputService.saveProjectInput(projectInputList.get(j))) {
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
	 * 删除单条项目投入
	 * 
	 * @param id
	 * @param request
	 */
	@RequestMapping("/deleteFundsTable")
	public void deleteFundsTable(HttpServletRequest request, HttpServletResponse response, String id) {
		int ids = Integer.parseInt(id);
		projectInputService.deleteFundsTable(ids);
	}

	/**
	 * 通过审核
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateAudit")
	public String updateAudit(int id) {
		if (fundsService.updateAudit(id) && projectInputService.updateAudit(id)) {
			return "redirect:/funds/getFundsList";
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
		List<Funds> funds = new ArrayList<Funds>();
		List<ProjectInput> projectInput = new ArrayList<ProjectInput>();

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					funds = fundsService.findByCity(city, years);
				} else {
					admcode = schoolNames;
					funds = fundsService.getFundsList(admcode, year);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					funds = fundsService.findByCity(city, year);
				} else {
					admcode = schoolName;
					funds = fundsService.getFundsList(admcode, year);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			funds = fundsService.getFundsList(admcode, year);
		} else {
			admcode = (String) session.getAttribute("username");
			funds = fundsService.getFundsList(admcode, year);
		}

		for (int i = 0; i < funds.size(); i++) {
			List<ProjectInput> temp = projectInputService.getProjectInputList(funds.get(i).getId());
			projectInput.addAll(temp);
		}
		
		List<ProjectInputDIO> projectInputDIO = new ArrayList<ProjectInputDIO>();
		for(int i=0;i<projectInput.size();i++){
			projectInputDIO.add(new ProjectInputDIO(projectInput.get(i)));
		}

		for (int i = 0; i < projectInput.size(); i++) {
			int type = projectInput.get(i).getType();

			if (type == 0) {
				projectInput.get(i).setTypeName("中央专项资金");
			} else if (type == 1) {
				projectInput.get(i).setTypeName("省级专项资金");
				;
			} else if (type == 2) {
				projectInput.get(i).setTypeName("市级专项资金");
			}

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
				"attachment;fileName=" + new String((fileName + "经费汇总.zip").getBytes("gbk"), "iso-8859-1"));

		try {
			// 激活下载操作
			// System.out.println(upload);
			File fileUpload = new File(upload), fileMain = new File(upload + File.separator + fileName + "经费汇总表.xlsx"),
					fileAttach = new File(upload + File.separator + fileName + "项目投入汇总表.xlsx");
			if (!fileUpload.exists() || !fileUpload.isDirectory()) {
				fileUpload.mkdir();
			}
			ZipOutputStream os = new ZipOutputStream(response.getOutputStream());
			ExcelUtil excelUtil = new ExcelUtil(fileMain);
			String[] titleMain = {"招生代码", "年份", "城市", "中央财政投入经费", "地方财政投入经费", "学校负债总额", 
								  "贷款总额", "生均拨款", "日常教学经费投入比例","教学改革经费", "教科研经费" };
			excelUtil.writeTitle(titleMain);
			Iterator<Funds> iteFunds = funds.iterator();
			while (iteFunds.hasNext()) {
				Funds coun = (Funds) iteFunds.next();
				if (coun.getAudit() == 1) {
					excelUtil.write(coun);
				}
			}
			excelUtil.close();

			excelUtil = new ExcelUtil(fileAttach);
			String[] titleAttach = { "招生代码", "年份", "地区", "资金项目类型", "项目名称", "项目金额（万元）" };
			excelUtil.writeTitle(titleAttach);
			Iterator<ProjectInputDIO> iteProjectInputDIO = projectInputDIO.iterator();
			while (iteProjectInputDIO.hasNext()) {
				ProjectInputDIO poor = (ProjectInputDIO) iteProjectInputDIO.next();
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
