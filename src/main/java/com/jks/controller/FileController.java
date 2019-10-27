package com.jks.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jks.entity.FileInfo;
import com.jks.entity.SchoolInfo;
import com.jks.service.FileInfoService;
import com.jks.service.QuerySchoolInfoService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/file")
public class FileController {
	@Resource
	FileInfoService fs;
	private String source;
	@Autowired
	private QuerySchoolInfoService querySchoolInfoService;

	@RequestMapping("/getFileList")
	public String getFileList(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum, Model model, String year,
			String area, HttpServletRequest req, HttpSession session) {
		source = req.getParameter("source");

		Map<String, Object> param = WebUtils.getParametersStartingWith(req, null);

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

		String level = (String) session.getAttribute("level");
		String usercode = (String) session.getAttribute("username");

		String admcode;

		if (level.equals("3")) {
			if (year == null && schoolName == null) {
				if (schoolNames == null || schoolNames == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<FileInfo> fileInfo = fs.findByCity(city, years, source);
					PageInfo pageInfo = new PageInfo(fileInfo, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolNames;
					PageHelper.startPage(pagenum, 12);
					List<FileInfo> fileInfo = fs.getFileList(admcode, years, source);
					PageInfo pageInfo = new PageInfo(fileInfo, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", years);
					model.addAttribute("schoolName", schoolNames);
					model.addAttribute("sn", sn);
				}
			} else {
				if (schoolName == null || schoolName == "") {
					String city = (String) session.getAttribute("schoolname");
					PageHelper.startPage(pagenum, 12);
					List<FileInfo> fileInfo = fs.findByCity(city, year, source);
					PageInfo pageInfo = new PageInfo(fileInfo, 5);
					model.addAttribute("pageInfo", pageInfo);
					model.addAttribute("year", year);
					model.addAttribute("schoolName", schoolName);
					model.addAttribute("sn", sn);
				} else {
					admcode = schoolName;
					PageHelper.startPage(pagenum, 12);
					List<FileInfo> fileInfo = fs.getFileList(admcode, year, source);
					PageInfo pageInfo = new PageInfo(fileInfo, 5);
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
			List<FileInfo> fileInfo = fs.getFileList(admcode, year, source);
			PageInfo pageInfo = new PageInfo(fileInfo, 5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		} else {
			admcode = (String) session.getAttribute("username");
			PageHelper.startPage(pagenum, 12);
			List<FileInfo> fileInfo = fs.getFileList(admcode, year, source);
			PageInfo pageInfo = new PageInfo(fileInfo);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("year", year);
		}
		// PageHelper.startPage(pagenum, 12);
		// HttpSession session=req.getSession();

		List<FileInfo> fileinfo = null;

		/*
		 * if ("1".equals(level)) { fileinfo = fs.getFileList(usercode, year,
		 * source, area); PageInfo pageInfo = new PageInfo(fileinfo, 10);
		 * model.addAttribute("pageInfo", pageInfo); model.addAttribute("level",
		 * level); model.addAttribute("year", years);
		 * model.addAttribute("schoolName", schoolNames);
		 * model.addAttribute("sn", sn); } else if ("2".equals(level)) {
		 * usercode = fs.getAdmByAudit(usercode); fileinfo =
		 * fs.getFileList(usercode, year, source, area); } else if
		 * ("3".equals(level)) { //System.out.println(area); usercode = ""; }
		 * else { usercode = ""; }
		 */

		return "/file/" + source;
	}

	@RequestMapping("/upload")
	public String filesUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req, RedirectAttributes attr,
			HttpSession session) {
		String source = req.getParameter("source");
		attr.addAttribute("source", source);

		if (file.getSize() > 0 && file.getSize() < 20971520) {
			// String path = req.getContextPath()+"/upload/file";
			String path = "D:/Education/upload/file";
			String filename = file.getOriginalFilename();
			String usercode = (String) session.getAttribute("username");
			String filetype = file.getContentType();
			if (filetype.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
					|| filetype.equals("application/msword") || filetype.equals("application/octet-stream")) {
				path += "/" + usercode + "/" + source;
				File dirname = new File(path);
				if (!dirname.exists()) {
					dirname.mkdirs();
				}
				Calendar time = Calendar.getInstance();
				int year = time.get(Calendar.YEAR);
				if (filetype.equals("application/msword")) {
					filename = filename.substring(0, filename.length() - 4) + year + ".doc";
				} else {
					filename = filename.substring(0, filename.length() - 5) + year + ".docx";
				}
				File target = new File(path, filename);
				try {
					String city = (String) session.getAttribute("city");
					int count = fs.getCountByNameAndCode(usercode, filename);
					if (count == 0) {
						int id = fs.insertAndGet(new FileInfo(filename, path + "/" + filename, String.valueOf(year),
								usercode, source, city, 0));
						if (id > 0) {
							file.transferTo(target);
						}
					}else if (count > 0){
						attr.addFlashAttribute("FileExsited", "文件已存在！");
					}else{
						attr.addFlashAttribute("FileLess", "上传文件为空！");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} else if (file.getSize() >= 20971520) {
			attr.addFlashAttribute("FileMore", "上传文件大小不能超过20M！");
		} else {
			attr.addFlashAttribute("FileLess", "上传文件为空！");
		}

		return "redirect:getFileList";
	}

	@RequestMapping("/download")
	public ResponseEntity<byte[]> fileDownload(HttpServletRequest req) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		FileInfo file = fs.getFileInfoByID(id);
		String path = "D:/Education/upload/file";
		String filename = file.getName();
		String usercode = file.getWriter();
		String source = file.getSource();
		path += "/" + usercode + "/" + source;
		File dfile = new File(path, filename);
		HttpHeaders headers = new HttpHeaders();
		//String dFileName=new String(filename.getBytes("UTF-8"), "ISO-8859-1");
		String dFileName = processFileName(req,filename);
	
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dFileName + "\"");
		/*
		 * headers.setContentDispositionFormData("attachment", dFileName);
		 * headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		 */
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(dfile), headers, HttpStatus.OK);

	}

	public static String processFileName(HttpServletRequest request, String fileNames) {
		String codedfilename = null;
		try {
			String agent = request.getHeader("USER-AGENT");
			if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie

				String name = java.net.URLEncoder.encode(fileNames, "UTF-8");

				codedfilename = name;
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等

				codedfilename = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codedfilename;
	}

	@RequestMapping("/del")
	public void del(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		FileInfo file = fs.getFileInfoByID(id);
		String filename = file.getName();
		String usercode = file.getWriter();
		String source = file.getSource();
		String path = "D:/Education/upload/file" + "/" + usercode + "/" + source;
		File deletefile = new File(path, filename);
		if (fs.delete(id)) {
			if (!deletefile.exists()) {
				result = "{\"result\":\"error\"}";
			} else {
				deletefile.delete();
				result = "{\"result\":\"success\"}";
			}
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
	 * 修改id对应的状态为审核通过
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("audit")
	public void audit(Integer id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		FileInfo file = new FileInfo();
		file.setId(id);
		file.setAudit(1);
		if (fs.modifyFile(file)) {
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
}
