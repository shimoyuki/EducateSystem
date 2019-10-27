package com.jks.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jks.entity.SchoolInfo;
import com.jks.entity.Size;
import com.jks.service.LoginService;
import com.jks.service.QuerySchoolInfoService;
import com.jks.service.SizeService;
import com.jks.utils.ExcelUtil;

@Controller
@RequestMapping("/size")
public class SizeController {
	@Autowired
	private SizeService sizeService;
	@Autowired
	private QuerySchoolInfoService querySchoolInfoService;
	@Autowired
	private LoginService loginService;

	/**
	 * 获取所有规模列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getSizeList")
	public String getSizeList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum,
			HttpServletRequest request, Model model) {
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
					List<Size> size = sizeService.findByCity(city, years);
					PageInfo pageInfo = new PageInfo(size, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<Size> size = sizeService.getSizeList(admcode, years);
					PageInfo pageInfo = new PageInfo(size, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<Size> size = sizeService.findByCity(city, year);
					PageInfo pageInfo = new PageInfo(size, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<Size> size = sizeService.getSizeList(admcode, year);
					PageInfo pageInfo = new PageInfo(size, 5);
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
			List<Size> size = sizeService.getSizeList(admcode, year);
			PageInfo pageInfo = new PageInfo(size, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<Size> size = sizeService.getSizeList(admcode, year);
			PageInfo pageInfo = new PageInfo(size, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		}

		return "/basic/size";
	}

	/**
	 * 跳转到添加规模界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAddSize")
	public String toAddSize() {
		return "/basic/sizeAdd";
	}

	/**
	 * 添加规模
	 * 
	 * @param size
	 * @param request
	 * @return 
	 */
	@RequestMapping("/saveSize")
	@ResponseBody
	public String saveSize(Size size, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String admcode = (String) session.getAttribute("username");
		String city = (String) session.getAttribute("city");
		size.setAdmcode(admcode);
		size.setCity(city);
		String result;
		Integer count=sizeService.checkYear(size);		
		if(count>0) {
			result = "{\"result\":\"该年份数据已存在!\"}";
		} else {
			sizeService.saveSize(size);
			result = "{\"result\":\"success\"}";
		}		
		return result;
	}
		

	/**
	 * 删除规模
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delSize")
	public void delSize(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (sizeService.deleteSize(id)) {
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

	/**
	 * 根据id查询单个规模
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getSize")
	public String getSize(int id, String detailFlag, HttpServletRequest request, Model model) {
		Size size = sizeService.findById(id);
		model.addAttribute("detailFlag", detailFlag);
		model.addAttribute("size", size);
		return "/basic/sizeUpd";
	}

	/**
	 * 修改规模
	 * 
	 * @param size
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateSize")
	@ResponseBody
	public String updateSize(Size size, HttpServletRequest request, Model model) {
		String result = "{\"result\":\"success\"}";
		if (sizeService.updateSize(size)) {
			size = sizeService.findById(size.getId());
			request.setAttribute("size", size);
			model.addAttribute("size", size);
		} else {
			result = "{\"result\":\"error!\"}";			
		}
		return result;
	}

	/**
	 * 通过审核
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateAudit")
	public String updateAudit(int id) {
		if (sizeService.updateAudit(id)) {
			return "redirect:/size/getSizeList";
		} else {
			return "/error";
		}
	}

	/**
	 * 查找学校名称
	 * 
	 * @param request,response
	 */
	@RequestMapping("/getSchoolNameList")
	public void getSchoolNameList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String area = (String) session.getAttribute("schoolname");

		response.setContentType("application/json; charset=utf-8");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");

		List<SchoolInfo> schoolInfo = querySchoolInfoService.findByArea(area);

		JSONArray jsonArray = JSONArray.fromObject(schoolInfo);
		String jsonString = jsonArray.toString();

		try {

			response.getWriter().write(jsonString);

		} catch (IOException e) {

			e.printStackTrace();
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
		List<Size> size = new ArrayList<Size>();

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					size = sizeService.findByCity(city, years);
				} else {
					admcode = schoolNames;
					size = sizeService.getSizeList(admcode, years);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					size = sizeService.findByCity(city, year);
				} else {
					admcode = schoolName;
					size = sizeService.getSizeList(admcode, year);
				}
			}
		} else if (level.equals("2")) {
			String username = (String) session.getAttribute("username");
			admcode = username.substring(0, username.length() - 1);
			size = sizeService.getSizeList(admcode, year);

		} else {
			admcode = (String) session.getAttribute("username");
			size = sizeService.getSizeList(admcode, year);
		}

		for (int i = 0; i < size.size(); i++) {
			String schoolRun = size.get(i).getSchoolRun();
			String schoolLevel = size.get(i).getSchoolLevel();
			String schoolSubject = size.get(i).getSchoolSubject();

			if (schoolRun.equals("0")) {
				size.get(i).setSchoolRun("公办");
			} else if (schoolRun.equals("1")) {
				size.get(i).setSchoolRun("民办");
			} else if (schoolRun.equals("2")) {
				size.get(i).setSchoolRun("混合制");
			}

			if (schoolLevel.equals("0")) {
				size.get(i).setSchoolLevel("一般");
			} else if (schoolLevel.equals("1")) {
				size.get(i).setSchoolLevel("国示校");
			} else if (schoolLevel.equals("2")) {
				size.get(i).setSchoolLevel("国重校");
			} else if (schoolLevel.equals("3")) {
				size.get(i).setSchoolLevel("省重校");
			}

			if (schoolSubject.equals("0")) {
				size.get(i).setSchoolSubject("教育行政部");
			} else if (schoolSubject.equals("1")) {
				size.get(i).setSchoolSubject("人社部门");
			} else if (schoolSubject.equals("2")) {
				size.get(i).setSchoolSubject("行业");
			}
		}

		String fileName = "";
		if (!"".equals(year) && year != null) {// 对应"&year="的链接
			fileName += year;
			if (!"".equals(admcode)) {// 对应"&admcode="的链接
				fileName += ("-" + loginService.getSchoolInfo(admcode).getSchoolname());
			}
		} else if (!"".equals(admcode)) {// 对应"&admcode="的链接
			fileName += loginService.getSchoolInfo(admcode).getSchoolname();
		}
		fileName += "规模汇总表.xlsx";
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));
		try {
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			ExcelUtil excelUtil = new ExcelUtil(os);
			String[] title = { "招生代码", "年份", "地区", "办学性质", "办学水平", "办学主体", "学校占地面积（㎡）", "自有产权占地面积（㎡）", "总建筑面积（㎡）",
					"学校自有产权建筑面积（㎡）", "生均建筑面积（㎡）", "教学及辅助用房面积（㎡）", "校内实训用房面积（㎡）", "心理咨询室建筑面积（㎡）", 
					"学生宿舍面积（㎡）", "生均宿舍面积（㎡）", "当年招生总数", "毕业生数", "在校生数", "专业数", "巩固率" };
			excelUtil.writeTitle(title);
			Iterator<Size> iteSize = size.iterator();
			while (iteSize.hasNext()) {
				Size coun = (Size) iteSize.next();
				if (coun.getAudit() == 1) {
					excelUtil.write(coun);
				}
			}
			excelUtil.close();

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
}
