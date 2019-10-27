package com.jks.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
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
import com.jks.entity.CounpaSupp;
import com.jks.entity.EducationTrain;
import com.jks.entity.EmployQuality;
import com.jks.entity.Equitment;
import com.jks.entity.Experience;
import com.jks.entity.FileInfo;
import com.jks.entity.Funds;
import com.jks.entity.Groupschool;
import com.jks.entity.Information;
import com.jks.entity.Internship;
import com.jks.entity.MajorLayout;
import com.jks.entity.MajorNum;
import com.jks.entity.MajorStu;
import com.jks.entity.Partybulid;
import com.jks.entity.Policy;
import com.jks.entity.PolicyMeasure;
import com.jks.entity.Poor;
import com.jks.entity.ProjectInput;
import com.jks.entity.ProjectInputDIO;
import com.jks.entity.QualityAssurance;
import com.jks.entity.Schoolenterprise;
import com.jks.entity.Size;
import com.jks.entity.Skill;
import com.jks.entity.SkillTrain;
import com.jks.entity.SocialService;
import com.jks.entity.StudentQuality;
import com.jks.entity.StudentQualityDIO;
import com.jks.entity.Teachers;
import com.jks.service.DataQueryService;
import com.jks.service.MajorStuService;
import com.jks.service.PolicyMeasureService;
import com.jks.service.ProjectInputService;
import com.jks.utils.ExcelUtil;
import com.jks.utils.ZipUtil;

@Controller
@RequestMapping("/provinceDataStatistics")
public class provinceDataStatisticsController {
	@Autowired  
	 private DataQueryService dataQueryService;
	@Autowired  
	 private ProjectInputService projectInputService;
	@Autowired  
	 private PolicyMeasureService policyMeasureService;
	@Autowired 
	 private MajorStuService majorStuService;
	
	 @RequestMapping("/getProvinceDataStatisticsList")  
	 public String getCityDataStatisticsList(Model model,HttpServletRequest request,
			   						@RequestParam(value="pnSize",defaultValue="1")Integer pnSize,
			   						@RequestParam(value="pnEquitment",defaultValue="1")Integer pnEquitment,
			   						@RequestParam(value="pnTeachers",defaultValue="1")Integer pnTeachers,
			   						@RequestParam(value="pnInformation",defaultValue="1")Integer pnInformation,
			   						@RequestParam(value="pnStudentQuality",defaultValue="1")Integer pnStudentQuality,
			   						@RequestParam(value="pnExperience",defaultValue="1")Integer pnExperience,
			   						@RequestParam(value="pnEmployQuality",defaultValue="1")Integer pnEmployQuality,
			   						@RequestParam(value="pnMajorLayout",defaultValue="1")Integer pnMajorLayout,
			   						@RequestParam(value="pnMajorNum",defaultValue="1")Integer pnMajorNum,
			   						@RequestParam(value="pnQualityAssurance",defaultValue="1")Integer pnQualityAssurance,
			   						@RequestParam(value="pnEducationTrain",defaultValue="1")Integer pnEducationTrain,
			   						@RequestParam(value="pnSchoolenterprise",defaultValue="1")Integer pnSchoolenterprise,
			   						@RequestParam(value="pnInternship",defaultValue="1")Integer pnInternship,
			   						@RequestParam(value="pnGroupschool",defaultValue="1")Integer pnGroupschool,
			   						@RequestParam(value="pnSkillTrain",defaultValue="1")Integer pnSkillTrain,
			   						@RequestParam(value="pnSocialService",defaultValue="1")Integer pnSocialService,
			   						@RequestParam(value="pnCounpaSupp",defaultValue="1")Integer pnCounpaSupp,
			   						@RequestParam(value="pnFunds",defaultValue="1")Integer pnFunds,
			   						@RequestParam(value="pnPolicy",defaultValue="1")Integer pnPolicy,
			   						@RequestParam(value="pnPartybulid",defaultValue="1")Integer pnPartybulid,
			   						@RequestParam(value="pnFileInfo",defaultValue="1")Integer pnFileInfo){  	    	
	    	HttpSession session = request.getSession();
	    	
	    	Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
	    	String admcode = null;	    							
	    	String city = null;	    	
	    	String type = (String)param.get("type");	  
			String types = (String)param.get("types");						
			String tn = (String)param.get("tn");
		
			
			String x;
			
			param.remove("type");
			param.remove("types");		
			param.remove("tn");
			
			if(tn!=null&&tn!=""){
				session.setAttribute("tn", tn);	
			}
			
			
    		if(type==null){	    			 	    				    			
	    			x = types;	    				    			
	    	}else{	    				    				    			 	    			
	    			x = type;	    			    				    				    				
	    		}
    		
    		if(x==null||x==""){
    			x="1";
    		}
    		
    		if(x.equals("1")){   	
    		PageHelper.startPage(pnSize,12);
			List<Size> size = dataQueryService.getSizeList(admcode,city);  
	    	PageInfo sizePageInfo = new PageInfo(size,5);
	        model.addAttribute("sizePageInfo", sizePageInfo);
	        
	        PageHelper.startPage(pnEquitment,12);
			List<Equitment> equitment = dataQueryService.getEquitmentList(admcode,city);  
	    	PageInfo equitmentPageInfo = new PageInfo(equitment,5);
	        model.addAttribute("equitmentPageInfo", equitmentPageInfo);
	        
	        PageHelper.startPage(pnTeachers,12);
			List<Teachers> teachers = dataQueryService.getTeachersList(admcode,city);
	    	PageInfo teachersPageInfo = new PageInfo(teachers,5);
	        model.addAttribute("teachersPageInfo", teachersPageInfo);
	        
	        PageHelper.startPage(pnInformation,12);
			List<Information> information = dataQueryService.getInformationList(admcode,city);  
	    	PageInfo informationPageInfo = new PageInfo(information,5);
	        model.addAttribute("informationPageInfo", informationPageInfo);
    		
    		}else if(x.equals("2")){
    			
	        PageHelper.startPage(pnStudentQuality,12);
			List<StudentQuality> studentQuality = dataQueryService.getStudentQualityList(admcode,city);  
	    	PageInfo studentQualityPageInfo = new PageInfo(studentQuality,5);
	        model.addAttribute("studentQualityPageInfo", studentQualityPageInfo);
	        
	        PageHelper.startPage(pnExperience,12);
			List<Experience> experience = dataQueryService.getExperienceList(admcode,city);  
	    	PageInfo experiencePageInfo = new PageInfo(experience,5);
	        model.addAttribute("experiencePageInfo", experiencePageInfo);
	        
	        PageHelper.startPage(pnEmployQuality,12);
			List<EmployQuality> employQuality = dataQueryService.getEmployQualityList(admcode,city);  
	    	PageInfo employQualityPageInfo = new PageInfo(employQuality,5);
	        model.addAttribute("employQualityPageInfo", employQualityPageInfo);
    		
    		}else if(x.equals("3")){
    			
	        PageHelper.startPage(pnMajorLayout,12);
			List<MajorLayout> majorLayout = dataQueryService.getMajorLayoutList(admcode,city);  
	    	PageInfo majorLayoutPageInfo = new PageInfo(majorLayout,5);
	        model.addAttribute("majorLayoutPageInfo", majorLayoutPageInfo);
	        
	        PageHelper.startPage(pnMajorNum,12);
			List<MajorNum> majorNum = dataQueryService.getMajorNumList(admcode,city);  
	    	PageInfo MajorNumPageInfo = new PageInfo(majorNum,5);
	        model.addAttribute("MajorNumPageInfo", MajorNumPageInfo);
	        
	        PageHelper.startPage(pnQualityAssurance,12);
			List<QualityAssurance> qualityAssurance = dataQueryService.getQualityAssuranceList(admcode,city);  
	    	PageInfo qualityAssurancePageInfo = new PageInfo(qualityAssurance,5);
	        model.addAttribute("qualityAssurancePageInfo", qualityAssurancePageInfo);
	        
	        PageHelper.startPage(pnEducationTrain,12);
			List<EducationTrain> educationTrain = dataQueryService.getEducationTrainList(admcode,city);  
	    	PageInfo educationTrainPageInfo = new PageInfo(educationTrain,5);
	        model.addAttribute("educationTrainPageInfo", educationTrainPageInfo);
    		
    		}else if(x.equals("4")){
    			
	        PageHelper.startPage(pnSchoolenterprise,12);
			List<Schoolenterprise> schoolenterprise = dataQueryService.getSchoolenterpriseList(admcode,city);  
	    	PageInfo schoolenterprisePageInfo = new PageInfo(schoolenterprise,5);
	        model.addAttribute("schoolenterprisePageInfo", schoolenterprisePageInfo);
	        
	        PageHelper.startPage(pnInternship,12);
			List<Internship> internship = dataQueryService.getInternshipList(admcode,city);  
	    	PageInfo internshipPageInfo = new PageInfo(internship,5);
	        model.addAttribute("internshipPageInfo", internshipPageInfo);
	        
	        PageHelper.startPage(pnGroupschool,12);
			List<Groupschool> groupschool = dataQueryService.getGroupschoolList(admcode,city);  
	    	PageInfo groupschoolPageInfo = new PageInfo(groupschool,5);
	        model.addAttribute("groupschoolPageInfo", groupschoolPageInfo);
    		
    		}else if(x.equals("5")){
    			
	        PageHelper.startPage(pnSkillTrain,12);
			List<SkillTrain> skillTrain = dataQueryService.getSkillTrainList(admcode,city);  
	    	PageInfo skillTrainPageInfo = new PageInfo(skillTrain,5);
	        model.addAttribute("skillTrainPageInfo", skillTrainPageInfo);
	        
	        PageHelper.startPage(pnSocialService,12);
			List<SocialService> socialService = dataQueryService.getSocialServiceList(admcode,city);  
	    	PageInfo socialServicePageInfo = new PageInfo(socialService,5);
	        model.addAttribute("socialServicePageInfo", socialServicePageInfo);
	        
	        PageHelper.startPage(pnCounpaSupp,12);
			List<CounpaSupp> counpaSupp = dataQueryService.getCounpaSuppList(admcode,city);  
	    	PageInfo counpaSuppPageInfo = new PageInfo(counpaSupp,5);
	        model.addAttribute("counpaSuppPageInfo", counpaSuppPageInfo);
    		
    		}else if(x.equals("6")){
    			
	        PageHelper.startPage(pnFunds,12);
			List<Funds> funds = dataQueryService.getFundsList(admcode,city);  
	    	PageInfo fundsPageInfo = new PageInfo(funds,5);
	        model.addAttribute("fundsPageInfo", fundsPageInfo);
	        
	        PageHelper.startPage(pnPolicy,12);
			List<Policy> policy = dataQueryService.getPolicyList(admcode,city);  
	    	PageInfo policyPageInfo = new PageInfo(policy,5);
	        model.addAttribute("policyPageInfo", policyPageInfo);
    		
    		}else if(x.equals("7")){
    			
	        PageHelper.startPage(pnPartybulid,12);
			List<Partybulid> partybulid = dataQueryService.getPartybuildList(admcode,city);  
	    	PageInfo partybulidPageInfo = new PageInfo(partybulid,5);
	        model.addAttribute("partybulidPageInfo", partybulidPageInfo);
    		
    		}else if(x.equals("8")){
    			
	        PageHelper.startPage(pnFileInfo,12);
			List<FileInfo> fileInfo = dataQueryService.getFileInfoList(admcode,city);
			for(int i=0;i<fileInfo.size();i++){
				String source = fileInfo.get(i).getSource();
				if(source.equals("culture")){
					fileInfo.get(i).setSource("传统文化（地方特色）教育活动开展情况");
				}else if(source.equals("grouprun")){
					fileInfo.get(i).setSource("学校集团化办学");
				}else if(source.equals("help")){
					fileInfo.get(i).setSource("对口帮扶（扶贫）情况");
				}else if(source.equals("innovation")){
					fileInfo.get(i).setSource("特色创新");
				}else if(source.equals("moralwork")){
					fileInfo.get(i).setSource("德育工作经验措施");
				}else if(source.equals("outstanding")){
					fileInfo.get(i).setSource("优秀毕业生典型案例");
				}else if(source.equals("partybuild")){
					fileInfo.get(i).setSource("党建工作");
				}else if(source.equals("problem")){
					fileInfo.get(i).setSource("主要问题和改进措施");
				}else if(source.equals("quality")){
					fileInfo.get(i).setSource("质量监控体系建设");
				}else if(source.equals("student")){
					fileInfo.get(i).setSource("学生思想政治状况");
				}else{
					fileInfo.get(i).setSource("未知");
				}
			}
	    	PageInfo fileInfoPageInfo = new PageInfo(fileInfo,5);
	        model.addAttribute("fileInfoPageInfo", fileInfoPageInfo);
    		}
	        
    	    model.addAttribute("typeCode", x);   	   
    	    model.addAttribute("tn", tn);
    	   
	    	 	
	    	  
	        return "/admin/provinceDataStatistics"; 
	     }
	 
	 @RequestMapping("/download")  
	 public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws IOException{  	    	
	    	HttpSession session = request.getSession();
	    	
	    	Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
	    	String admcode = null;	    							
	    	String city = null;	    	
	    	String type = (String)param.get("type");	  
			String types = (String)param.get("types");						
			String tn = (String)param.get("tn");
		
			
			String x;
			
			param.remove("type");
			param.remove("types");		
			param.remove("tn");
			
			if(tn!=null&&tn!=""){
				session.setAttribute("tn", tn);	
			}
			
			
    		if(type==null){	    			 	    				    			
	    			x = types;	    				    			
	    	}else{	    				    				    			 	    			
	    			x = type;	    			    				    				    				
	    		}
    		
    		if(x==null||x==""){
    			x="1";
    		}
    		
    		if(x.equals("1")){
    			
			List<Size> size = dataQueryService.getSizeList(admcode,city);
			for(int i=0;i<size.size();i++){
	    		String schoolRun = size.get(i).getSchoolRun();
	    		String schoolLevel = size.get(i).getSchoolLevel();
	    		String schoolSubject = size.get(i).getSchoolSubject();
	    		
	    		if(schoolRun.equals("0")){
	    			size.get(i).setSchoolRun("公办");
	    		}else if(schoolRun.equals("1")){
	    			size.get(i).setSchoolRun("民办");
	    		}else if(schoolRun.equals("2")){
	    			size.get(i).setSchoolRun("混合制");
	    		}
	    		
	    		if(schoolLevel.equals("0")){
	    			size.get(i).setSchoolLevel("一般");
	    		}else if(schoolLevel.equals("1")){
	    			size.get(i).setSchoolLevel("国示校");
	    		}else if(schoolLevel.equals("2")){
	    			size.get(i).setSchoolLevel("国重校");
	    		}else if(schoolLevel.equals("3")){
	    			size.get(i).setSchoolLevel("省重校");
	    		}
	    		
	    		if(schoolSubject.equals("0")){
	    			size.get(i).setSchoolSubject("教育行政部");
	    		}else if(schoolSubject.equals("1")){
	    			size.get(i).setSchoolSubject("人社部门");
	    		}else if(schoolSubject.equals("2")){
	    			size.get(i).setSchoolSubject("行业");
	    		}
	    	}
			List<Object> sizeList = new ArrayList<>();
			sizeList.addAll(size);
			
			List<Equitment> equitment = dataQueryService.getEquitmentList(admcode,city);  	    		        
			List<Object> equitmentList = new ArrayList<>();
			equitmentList.addAll(equitment);
			
			List<Teachers> teachers = dataQueryService.getTeachersList(admcode,city);	    	
			List<Object> teachersList = new ArrayList<>();
			teachersList.addAll(teachers);
			
			List<Information> information = dataQueryService.getInformationList(admcode,city);
			List<Object> informationList = new ArrayList<>();
			informationList.addAll(information);
									
			String fileName = "", path = this.getClass().getClassLoader().getResource(File.separator).getPath(),
					upload = URLDecoder.decode(new File(path).getParentFile().getParent(), "UTF-8")+File.separator+"upload"+File.separator+(String)session.getAttribute("username");
			
		    //设置响应头和客户端保存文件名
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("multipart/form-data");
		    response.setHeader("Content-Disposition", "attachment;fileName=" + new String((fileName+"基本情况汇总.zip").getBytes("gbk"),"iso-8859-1"));
		    
		    try {
		        //激活下载操作
		    	//System.out.println(upload);
		    	File fileUpload = new File(upload),
		    			fileMain = new File(upload+File.separator+fileName+"规模汇总表.xlsx"),
		    			fileAt = new File(upload+File.separator+fileName+"教师队伍汇总表.xlsx"),
		    			fileAtta = new File(upload+File.separator+fileName+"设施设备汇总表.xlsx"),
		    			fileAttach = new File(upload+File.separator+fileName+"信息化建设汇总表.xlsx");
		    	if (!fileUpload.exists() || !fileUpload.isDirectory()) {
		    		fileUpload.mkdir();
				}
		    	ZipOutputStream os = new ZipOutputStream(response.getOutputStream());
		    	
		        ExcelUtil excelUtil = new ExcelUtil(fileMain);
		        String[] titleMain = {"招生代码","办学性质","办学水平", "办学主体", "学校占地面积（㎡）", "自有产权占地面积（㎡）", "总建筑面积（㎡）", 
		        					  "学校自有产权建筑面积（㎡）","生均建筑面积（㎡）","教学及辅助用房面积（㎡）","校内实训用房面积（㎡）","心理咨询室建筑面积（㎡）",
		        					  "学生宿舍面积（㎡）","生均宿舍面积（㎡）","当年招生总数","毕业生数","在校生数","专业数","巩固率"};
		        List<String> SizeYearList = dataQueryService.getSizeYearList();				
				excelUtil.writeListTitle(titleMain, SizeYearList);
				excelUtil.writeList(sizeList, SizeYearList);				
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAt);
				String[] titleAt = { "招生代码","固定资产总值", "教学设备资产值",
						   			 "实训设备资产值", "年新增教学设备资产值", "年新增实训设备资产值", "生均教学设备资产值",
						   			 "生均实训设备资产值", "生均实训实习工位数", "校内实训基地数",
						   			 "校外实训基地数", "图书馆纸质图书藏书量（册）", "图书馆电子图书藏书量（册）", "年度新增图书（册）",
						   			 "阅览室座位数", "生均图书（册）", "期刊订阅种类数", "电子图书数（册）","电子阅览室座位数（个）"};						   			 		
				List<String> equitmentYearList = dataQueryService.getEquitmentYearList();				
				excelUtil.writeListTitle(titleAt, equitmentYearList);
				excelUtil.writeList(equitmentList, equitmentYearList);	
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAtta);
				String[] titleAtta = { "招生代码","教职工总人数", "教职工编制数",
									   "在编教职工数", "专任教师数", "其中公共基础课专任教师数", "其中专业课专任教师数",
									   "行业企业兼职教师数", "本科以下学历专任教师数", "本科学历专任教师数",
									   "具有研究生学历或学位的专任教师数", "高级职称专任教师数", "中级职称专任教师数", "初级职称专任教师数",
									   "未评职称专任教师数", "35岁及以下专任教师数", "36～45岁专任教师数", "46～55岁专任教师数",
									   "56岁及以上专任教师数", "男教师数", "女教师数", "双师型教师数", "公共基础课教师平均每周课时数",
									   "专业课教师平均每周课时数", "行业企业兼职教师课时总量", "持有心理咨询证书的教师数",
									   "专职心理咨询教师数", "市（州）级以上学科带头人教师数", "省特级教师数" };				
				List<String> teachersYearList = dataQueryService.getTeachersYearList();				
				excelUtil.writeListTitle(titleAtta, teachersYearList);
				excelUtil.writeList(teachersList, teachersYearList);	
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAttach);
				String[] titleAttach = {"招生代码","是否设立教育信息化技术中心", 
						   			 	"校园网络出口总带宽（bps）", "校园网主干带宽(bps)", "生均数字教学视频资源量（小时/生）",
						   			 	"生均电子图书总量（册/生）","教学用计算机台数",
						   			 	"生均教学用计算机台数", "是否建立协同办公系统", "是否建立学校门户网站", "是否建立教务管理系统",
						   			 	"是否建立课程资源库储存教案、讲义等材料", "是否建立课程直播、录播平台", 
						   			 	"是否建立学生和教师的互动学习应用", "是否建立课程资源共享应用"};			
				List<String> informationYearList = dataQueryService.getInformationYearList();				
				excelUtil.writeListTitle(titleAttach, informationYearList);
				excelUtil.writeList(informationList, informationYearList);
				excelUtil.close();
				
				ZipUtil.doCompress(fileMain, os);
				ZipUtil.doCompress(fileAt, os);
				ZipUtil.doCompress(fileAtta, os);
				ZipUtil.doCompress(fileAttach, os);
				
				response.flushBuffer();
				os.close();
				ZipUtil.deleteDir(fileUpload);
		    } catch (Exception e){
		        e.printStackTrace();
		        return;
		    }
    		
    		}else if(x.equals("2")){
    			
			List<StudentQuality> studentQuality = dataQueryService.getStudentQualityList(admcode,city);
			for(int i=0;i<studentQuality.size();i++){
	    		String otherHonor = studentQuality.get(i).getOtherhonor();
	    		String provOther = studentQuality.get(i).getProvother();	    		
	    		if(otherHonor==null){
	    			studentQuality.get(i).setOtherhonor("");
	    		}
	    		if(provOther==null){
	    			studentQuality.get(i).setProvother("");
	    		}	    		
	    	}
			List<StudentQualityDIO> studentQualityDIO = new ArrayList<StudentQualityDIO>();
			for(int i=0;i<studentQuality.size();i++){								
				studentQualityDIO.add(new StudentQualityDIO(studentQuality.get(i)));
			}
			List<Object> studentQualityList = new ArrayList<>();
			studentQualityList.addAll(studentQualityDIO);
			
			List<Experience> experience = dataQueryService.getExperienceList(admcode,city);  
			List<Object> experienceList = new ArrayList<>();
			experienceList.addAll(experience);
			
			List<EmployQuality> employQuality = dataQueryService.getEmployQualityList(admcode,city); 					
			for(int i=0;i<employQuality.size();i++){
	    		String oneYearInner = employQuality.get(i).getOneyearinner();
	    		String oneYearOuter = employQuality.get(i).getOneyearouter();
	    		
	    		if(oneYearInner==null){
	    			employQuality.get(i).setOneyearinner("");
	    		}
	    		if(oneYearOuter==null){
	    			employQuality.get(i).setOneyearouter("");
	    		}	    		
	    	}
			List<Object> employQualityList = new ArrayList<>();
			employQualityList.addAll(employQuality);
			
			String fileName = "", path = this.getClass().getClassLoader().getResource(File.separator).getPath(),
					upload = URLDecoder.decode(new File(path).getParentFile().getParent(), "UTF-8")+File.separator+"upload"+File.separator+(String)session.getAttribute("username");
			
		    //设置响应头和客户端保存文件名
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("multipart/form-data");
		    response.setHeader("Content-Disposition", "attachment;fileName=" + new String((fileName+"学生发展汇总.zip").getBytes("gbk"),"iso-8859-1"));
		    
		    try {
		        //激活下载操作
		    	//System.out.println(upload);
		    	File fileUpload = new File(upload),
		    			fileMain = new File(upload+File.separator+fileName+"学生素质汇总表.xlsx"),
		    			fileAt = new File(upload+File.separator+fileName+"在校体验汇总表.xlsx"),
		    			fileAtta = new File(upload+File.separator+fileName+"就业质量汇总表汇总表.xlsx");		    		
		    	if (!fileUpload.exists() || !fileUpload.isDirectory()) {
		    		fileUpload.mkdir();
				}
		    	ZipOutputStream os = new ZipOutputStream(response.getOutputStream());
		    	
		        ExcelUtil excelUtil = new ExcelUtil(fileMain);
		        String[] titleMain = { "招生代码","德育教材配备是否使用国家规化教材",
						"是否设立了心理辅导中心或心理咨询室", "德育先进单位", "教育部德育实验基地", "四川省校风示范校",
						"四川省中等职业学校内务管理示范校", "青年志愿者先进集体", "红旗团委",
						" 其他德育相关荣誉(市级及以上)", "省级以上优秀班级数", "专职德育工作人员数", "各级德育课题立项数",
						"德育课教师数量", "德育课教师专业对口率", "德育校本教材开发数",
						"学生操行考核优的比例", "学生操行考核良的比例", "学生操行考核中的比例", "学生操行考核差的比例",
						"接受心理咨询的学生占比", "省级优秀毕业生数", "省级优秀干部数", "省级优秀三好学生数",
						"其他（省级以上）", "年度校园暴力事件次数", "学生犯罪人次", "严重违纪学生数", "积极申请入团学生数",
						"积极申请入党学生数", "社会志愿服务活动人次", "社会实践活动参与次数（生/年）", "学生社团数量",
						" 学生参与社团人数", "学生参加文明风采大赛获奖人数（国家级）", " 学生参加文明风采大赛获奖人数（省级）",
						"学生参加文明风采大赛获奖人数（市级）", "参与国家级技能竞赛获得一等奖人数",
						"参与国家级技能竞赛获得二等奖人数", "参与国家级技能竞赛获得三等奖人数", "参与省级技能竞赛获得一等奖人数",
						"参与省级技能竞赛获得二等奖人数", "参与省级技能竞赛获得三等奖人数", "参与市级技能竞赛获得一等奖人数",
						"参与市级技能竞赛获得二等奖人数", "参与市级技能竞赛获得三等奖人数", "一年级巩固率", "二年级巩固率",
						"三年级巩固率", "文化课合格率", "体质测评合格率", "专业技能合格率", "职业资格证书数",
						"双证书获取率", "毕业率"  };				
				List<String> studentQualityYearList = dataQueryService.getStudentQualityYearList();				
				excelUtil.writeListTitle(titleMain, studentQualityYearList);
				excelUtil.writeList(studentQualityList, studentQualityYearList);	
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAt);
				String[] titleAt = { "招生代码","理论学习满意度-非常满意",
						"理论学习满意度-基本满意", "理论学习满意度-不满意", "专业学习满意度-非常满意",
						"专业学习满意度-基本满意", "专业学习满意度-不满意", "实习实训满意度-非常满意",
						"实习实训满意度-基本满意", "实习实训满意度-不满意", "校园文化与社团活动满意度-非常满意",
						"校园文化与社团活动满意度-基本满意", "校园文化与社团活动满意度-不满意", "生活满意度-非常满意",
						"生活满意度-基本满意", "生活满意度-不满意", "校园安全满意度-非常满意", "校园安全满意度-基本满意",
						"校园安全满意度-不满意", "毕业生对学校满意度-非常满意", "毕业生对学校满意度-基本满意",
						"毕业生对学校满意度-不满意" };						   			 				
				List<String> experienceYearList = dataQueryService.getExperienceYearList();				
				excelUtil.writeListTitle(titleAt, experienceYearList);
				excelUtil.writeList(experienceList, experienceYearList);	
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAtta);
				String[] titleAtta = { "招生代码","毕业生初次就业率", "专业对口就业率",
						"顶岗实习半年以上稳定率", " 初次就业月平均收入", "自主创业率", "到国有企业事业单位服务比例",
						"到民营企业服务比例", "到外资企业服务比例", "到第一产业就业比例", "到第二产业就业比例",
						"到第三产业就业比例", "参军人数", "高考统招升学学生数占毕业生总数比例",
						"对口单招升学学生数占毕业生总数比例", "签订一年及以内就业合同比例", "签订一年以上就业合同比例" };				
				List<String> employQualityYearList = dataQueryService.getEmployQualityYearList();				
				excelUtil.writeListTitle(titleAtta, employQualityYearList);
				excelUtil.writeList(employQualityList, employQualityYearList);
				excelUtil.close();
												
				ZipUtil.doCompress(fileMain, os);
				ZipUtil.doCompress(fileAt, os);
				ZipUtil.doCompress(fileAtta, os);				
				
				response.flushBuffer();
				os.close();
				ZipUtil.deleteDir(fileUpload);
		    } catch (Exception e){
		        e.printStackTrace();
		        return;
		    }
	    	
    		}else if(x.equals("3")){
    				    
			List<MajorLayout> majorLayout = dataQueryService.getMajorLayoutList(admcode,city);  
			List<Object> majorLayoutList = new ArrayList<>();
			majorLayoutList.addAll(majorLayout);
			
			List<MajorNum> majorNum = dataQueryService.getMajorNumList(admcode,city);  
			List<Object> majorNumList = new ArrayList<>();
			majorNumList.addAll(majorNum);
			
			List<QualityAssurance> qualityAssurance = dataQueryService.getQualityAssuranceList(admcode,city);
			for(int i=0;i<qualityAssurance.size();i++){
	    		String Chinese = qualityAssurance.get(i).getChinese();
	    		String Math = qualityAssurance.get(i).getMath();
	    		String English = qualityAssurance.get(i).getEnglish();
	    		
	    		if(Chinese==null){
	    			qualityAssurance.get(i).setChinese("");
	    		}
	    		if(Math==null){
	    			qualityAssurance.get(i).setMath("");
	    		}
	    		if(English==null){
	    			qualityAssurance.get(i).setEnglish("");
	    		}
	    	}
			List<Object> qualityAssuranceList = new ArrayList<>();
			qualityAssuranceList.addAll(qualityAssurance);
			
			List<EducationTrain> educationTrain = dataQueryService.getEducationTrainList(admcode,city); 
			List<Object> educationTrainList = new ArrayList<>();
			educationTrainList.addAll(educationTrain);
			
			List<MajorStu> majorStu = new ArrayList<MajorStu>();			
			for(int i=0;i<majorLayout.size();i++){
	    		List<MajorStu> temp = majorStuService.getMajorStuList(majorLayout.get(i).getId());
	    		majorStu.addAll(temp);
	    	}
			List<Object> majorStuList = new ArrayList<>();
			majorStuList.addAll(majorStu);
						
			String fileName = "", path = this.getClass().getClassLoader().getResource(File.separator).getPath(),
					upload = URLDecoder.decode(new File(path).getParentFile().getParent(), "UTF-8")+File.separator+"upload"+File.separator+(String)session.getAttribute("username");
			
		    //设置响应头和客户端保存文件名
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("multipart/form-data");
		    response.setHeader("Content-Disposition", "attachment;fileName=" + new String((fileName+"质量保障措施汇总.zip").getBytes("gbk"),"iso-8859-1"));
		    
		    try {
		        //激活下载操作
		    	//System.out.println(upload);
		    	File fileUpload = new File(upload),
		    			fileMain = new File(upload+File.separator+fileName+"专业布局汇总表.xlsx"),
		    			fileA = new File(upload+File.separator+fileName+"专业人数汇总表.xlsx"),
		    			fileAt = new File(upload+File.separator+fileName+"课程开设汇总表.xlsx"),
		    			fileAtta = new File(upload+File.separator+fileName+"质量保证汇总表.xlsx"),
		    			fileAttach = new File(upload+File.separator+fileName+"教师培养培训汇总表.xlsx");
		    	if (!fileUpload.exists() || !fileUpload.isDirectory()) {
		    		fileUpload.mkdir();
				}
		    	ZipOutputStream os = new ZipOutputStream(response.getOutputStream());
		    	
		    	ExcelUtil excelUtil = new ExcelUtil(fileMain);
		        String[] titleMain = {"招生代码","一产类专业数", "二产类专业数", "三产类专业数", "围绕地方支柱产业的专业开设数","新增专业数","停办专业数"};				
				List<String> majorLayoutYearList = dataQueryService.getMajorLayoutYearList();				
				excelUtil.writeListTitle(titleMain, majorLayoutYearList);
				excelUtil.writeList(majorLayoutList, majorLayoutYearList);	
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileA);
				String[] titleA = {"招生代码","专业类名", "专业名","一年级人数","二年级人数","三年级人数"};				
				List<String> majorStuYearList = dataQueryService.getMajorStuYearList();				
				excelUtil.writeListTitle(titleA, majorStuYearList);
				excelUtil.writeList(majorStuList, majorStuYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAt);
				String[] titleAt = { "招生代码","已制定课程标准数", "牵头开发国家共建共享计划课程数",  "教师参编公开出版的教材数",
									 "规划教材使用比", "校本教材开发数量" };				
					
				List<String> majorNumYearList = dataQueryService.getMajorNumYearList();				
				excelUtil.writeListTitle(titleAt, majorNumYearList);
				excelUtil.writeList(majorNumList, majorNumYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAtta);
				String[] titleAtta = {"招生代码","校领导人均听课课时数","校领导人均上课课时数","教师教学质量考核-优秀比例", 
       				  					"教师教学质量考核-合格比例","教师教学质量考核-不合格比例","国家级课题立项数","省级课题立项数",
       				  					"市级课题立项数","市级文化课检测语文合格率","市级文化课检测数学合格率","市级文化课检测英语合格率",
       				  					"学生参加国家级技能大赛人数","其中一等奖获得人数","其中二等奖获得人数","其中三等奖获得人数",
       				  					"学生参加省级技能大赛人数","其中一等奖获得人数","其中二等奖获得人数","其中三等奖获得人数",
       				  					"学生参加市级技能大赛人数","其中一等奖获得人数","其中二等奖获得人数","其中三等奖获得人数",};				 
			    List<String> qualityAssuranceYearList = dataQueryService.getQualityAssuranceYearList();				
				excelUtil.writeListTitle(titleAtta, qualityAssuranceYearList);
				excelUtil.writeList(qualityAssuranceList, qualityAssuranceYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAttach);
				String[] titleAttach = {"招生代码","参加区县级培训专任教师数","参加区县级培训人均课时数","参加市级培训专任教师数", 
								  		"参加市级培训人均课时数","参加省级培训专任教师数","参加省级培训人均课时数","参加国家级培训专任教师数",
								  		"参加国家级培训人均课时数","参加国外培训专任教师数","参加国外培训人均课时数","参加境外培训专任教师数",
								  		"参加境外培训人均课时数","教师参加学历提升获得毕业证书人数","用于教师培养培训经费占学校公用经费的比例",
								  		"教师参加国家级教学或技能大赛人数","其中一等奖获得人数","其中二等奖获得人数","其中三等奖获得人数",
								  		"教师参加省级教学或技能大赛人数","其中一等奖获得人数","其中二等奖获得人数","其中三等奖获得人数",
								  		"教师参加市级教学或技能大赛人数","其中一等奖获得人数","其中二等奖获得人数","其中三等奖获得人数",};				
				List<String> educationTrainYearList = dataQueryService.getEducationTrainYearList();				
				excelUtil.writeListTitle(titleAttach, educationTrainYearList);
				excelUtil.writeList(educationTrainList, educationTrainYearList);
				excelUtil.close();
				
				ZipUtil.doCompress(fileMain, os);
				ZipUtil.doCompress(fileA, os);
				ZipUtil.doCompress(fileAt, os);
				ZipUtil.doCompress(fileAtta, os);
				ZipUtil.doCompress(fileAttach, os);
				
				response.flushBuffer();
				os.close();
				ZipUtil.deleteDir(fileUpload);
		    } catch (Exception e){
		        e.printStackTrace();
		        return;
		    }
	    	
    		}else if(x.equals("4")){

			List<Schoolenterprise> schoolenterprise = dataQueryService.getSchoolenterpriseList(admcode,city);  
			List<Object> schoolenterpriseList = new ArrayList<>();
			schoolenterpriseList.addAll(schoolenterprise);
			
			List<Internship> internship = dataQueryService.getInternshipList(admcode,city);  
			List<Object> internshipList = new ArrayList<>();
			internshipList.addAll(internship);
			
			List<Groupschool> groupschool = dataQueryService.getGroupschoolList(admcode,city);  	  
			List<Object> groupschoolList = new ArrayList<>();
			groupschoolList.addAll(groupschool);
			
			String fileName = "", path = this.getClass().getClassLoader().getResource(File.separator).getPath(),
					upload = URLDecoder.decode(new File(path).getParentFile().getParent(), "UTF-8")+File.separator+"upload"+File.separator+(String)session.getAttribute("username");
			
		    //设置响应头和客户端保存文件名
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("multipart/form-data");
		    response.setHeader("Content-Disposition", "attachment;fileName=" + new String((fileName+"校企合作汇总.zip").getBytes("gbk"),"iso-8859-1"));
		    
		    try {
		        //激活下载操作
		    	//System.out.println(upload);
		    	File fileUpload = new File(upload),
		    			fileMain = new File(upload+File.separator+fileName+"合作情况汇总表.xlsx"),
		    			fileA = new File(upload+File.separator+fileName+"集团化办学情况汇总表.xlsx"),
		    			fileAt = new File(upload+File.separator+fileName+"学生实习情况汇总表.xlsx");
		    			
		    	if (!fileUpload.exists() || !fileUpload.isDirectory()) {
		    		fileUpload.mkdir();
				}
		    	ZipOutputStream os = new ZipOutputStream(response.getOutputStream());
		    	
		    	ExcelUtil excelUtil = new ExcelUtil(fileMain);
		        String[] titleMain = {"招生代码","校企合作覆盖专业数","签订合作协议的企业数","签订合作协议的专业数" ,
  					  				  "合作企业参与教学的专业数", "合作企业参与的教学教师数","合作企业参与教学课时数",
  					  				  "合作企业投入资金总额（万元）","合作企业投入到账资金",
  					  				  "合作企业投入设备总值","与企业共建研发中心数","校外教师培训基地数",
  					  				 "生产性实训基地产值", "校企合作订单班","校企合作开发课程数","专任教师企业实习实践人次",
  					  				 "专任教师人均企业实习实践时间（天）","企业兼职教师专业课课时占比",
  					  					};				
				List<String> schoolenterpriseYearList = dataQueryService.getSchoolenterpriseYearList();				
				excelUtil.writeListTitle(titleMain, schoolenterpriseYearList);
				excelUtil.writeList(schoolenterpriseList, schoolenterpriseYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileA);
				String[] titleA = {"招生代码", "本校牵头组织的职教集团数", "本校参与的职教集团数",
						 		   "参加本校牵头的职教集团学校数", "参加本校牵头的职教集团企业数", "参加本校牵头的职教集团专业数" };
				List<String> groupschoolYearList = dataQueryService.getGroupschoolYearList();				
				excelUtil.writeListTitle(titleA, groupschoolYearList);
				excelUtil.writeList(groupschoolList, groupschoolYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAt);
				String[] titleAt = { "招生代码","校外学生实训基地数","生均认识实习时长（天）","生均跟岗实习时长（天）",
									 "生均顶岗实习时长（天）", "学生跟岗实习对口率", "学生顶岗实习对口率",
									 "企业对学生顶岗实习考核结果（优秀）比例", "企业对学生顶岗实习考核结果（良好）比例", 
									 "企业对学生顶岗实习考核结果（合格）比例","企业对学生顶岗实习考核结果（不合格）比例" ,"合作企业接收学生就业比例"};					
				List<String> internshipYearList = dataQueryService.getInternshipYearList();				
				excelUtil.writeListTitle(titleAt, internshipYearList);
				excelUtil.writeList(internshipList, internshipYearList);
				excelUtil.close();
												
				ZipUtil.doCompress(fileMain, os);
				ZipUtil.doCompress(fileA, os);
				ZipUtil.doCompress(fileAt, os);				
				
				response.flushBuffer();
				os.close();
				ZipUtil.deleteDir(fileUpload);
		    } catch (Exception e){
		        e.printStackTrace();
		        return;
		    }
			
    		}else if(x.equals("5")){

			List<SkillTrain> skillTrain = dataQueryService.getSkillTrainList(admcode,city);  
			List<Object> skillTrainList = new ArrayList<>();
			skillTrainList.addAll(skillTrain);
			
			List<SocialService> socialService = dataQueryService.getSocialServiceList(admcode,city);  
			List<Object> socialServiceList = new ArrayList<>();
			socialServiceList.addAll(socialService);
			
			List<CounpaSupp> counpaSupp = dataQueryService.getCounpaSuppList(admcode,city);
			List<Object> counpaSuppList = new ArrayList<>();
			counpaSuppList.addAll(counpaSupp);
			
			List<Skill> skill = new ArrayList<Skill>();
			for(int i=0;i<skillTrain.size();i++){
	    		List<Skill> temp = dataQueryService.getSkillList(skillTrain.get(i).getId());
	    		skill.addAll(temp);
	    	}
			List<Object> skillList = new ArrayList<>();
			skillList.addAll(skill);
			
			List<Poor> poor = new ArrayList<Poor>();
			for(int i=0;i<counpaSupp.size();i++){
	    		List<Poor> temp = dataQueryService.getPoorList(counpaSupp.get(i).getId());
	    		poor.addAll(temp);
	    	}
			List<Object> poorList = new ArrayList<>();
			poorList.addAll(poor);
								
			String fileName = "", path = this.getClass().getClassLoader().getResource(File.separator).getPath(),
					upload = URLDecoder.decode(new File(path).getParentFile().getParent(), "UTF-8")+File.separator+"upload"+File.separator+(String)session.getAttribute("username");
			
		    //设置响应头和客户端保存文件名
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("multipart/form-data");
		    response.setHeader("Content-Disposition", "attachment;fileName=" + new String((fileName+"社会贡献汇总.zip").getBytes("gbk"),"iso-8859-1"));
		    
		    try {
		        //激活下载操作
		    	//System.out.println(upload);
		    	File fileUpload = new File(upload),
		    			fileMain = new File(upload+File.separator+fileName+"技术技能人才培养汇总表.xlsx"),
		    			fileA = new File(upload+File.separator+fileName+"学校承担、参与改进或推广技术名称汇总表.xlsx"),
		    			fileAt = new File(upload+File.separator+fileName+"社会服务汇总表.xlsx"),
		    			fileAtta = new File(upload+File.separator+fileName+"对口支援汇总表.xlsx"),
		    			fileAttach = new File(upload+File.separator+fileName+"扶贫技术或项目汇总表.xlsx");
		    	if (!fileUpload.exists() || !fileUpload.isDirectory()) {
		    		fileUpload.mkdir();
				}
		    	ZipOutputStream os = new ZipOutputStream(response.getOutputStream());
		    	
		    	ExcelUtil excelUtil = new ExcelUtil(fileMain);
		        String[] titleMain = {"招生代码","为当地主要产业培养技术技能人才数", "为当地培训技术技能人才数", 
		        					  "产生的经济效益和社会效益（万元）", "学校师生参与当地产业发展或结构调整技术攻关人数"};				
				List<String> skillTrainYearList = dataQueryService.getSkillTrainYearList();				
				excelUtil.writeListTitle(titleMain, skillTrainYearList);
				excelUtil.writeList(skillTrainList, skillTrainYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileA);
				String[] titleA = {"招生代码","技术名称"};
				List<String> skillYearList = dataQueryService.getSkillYearList();				
				excelUtil.writeListTitle(titleA, skillYearList);
				excelUtil.writeList(skillList, skillYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAt);
				String[] titleAt = { "招生代码","培训企业员工数",
									 "培训残疾人人数", "培训失业人员人数", "培训农民工人数",
									 "培训退役士兵人数", "技能鉴定项目人次", "师生参与当地技术服务人次" };					
				List<String> socialServiceYearList = dataQueryService.getSocialServiceYearList();				
				excelUtil.writeListTitle(titleAt, socialServiceYearList);
				excelUtil.writeList(socialServiceList, socialServiceYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAtta);
				String[] titleAtta = {"招生代码","对口帮扶对象单位数", "扶贫对象数", "资金扶贫（万元）", "服务人数"};				 
				List<String> counpaSuppYearList = dataQueryService.getCounpaSuppYearList();				
				excelUtil.writeListTitle(titleAtta, counpaSuppYearList);
				excelUtil.writeList(counpaSuppList, counpaSuppYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAttach);
				String[] titleAttach = {"招生代码","扶贫技术名称", "扶贫项目名称"};				
				List<String> poorYearList = dataQueryService.getPoorYearList();				
				excelUtil.writeListTitle(titleAttach, poorYearList);
				excelUtil.writeList(poorList, poorYearList);
				excelUtil.close();
				
				ZipUtil.doCompress(fileMain, os);
				ZipUtil.doCompress(fileA, os);
				ZipUtil.doCompress(fileAt, os);
				ZipUtil.doCompress(fileAtta, os);
				ZipUtil.doCompress(fileAttach, os);
				
				response.flushBuffer();
				os.close();
				ZipUtil.deleteDir(fileUpload);
		    } catch (Exception e){
		        e.printStackTrace();
		        return;
		    }
	    	
    		}else if(x.equals("6")){

			List<Funds> funds = dataQueryService.getFundsList(admcode,city);  
			List<Object> fundsList = new ArrayList<>();
			fundsList.addAll(funds);
			
			List<Policy> policy = dataQueryService.getPolicyList(admcode,city);
			List<Object> policyList = new ArrayList<>();
			policyList.addAll(policy);
			
			List<ProjectInput> projectInput = new ArrayList<ProjectInput>();
			for(int i=0;i<funds.size();i++){
	    		List<ProjectInput> temp = projectInputService.getProjectInputList(funds.get(i).getId()); 	    		
	    		if(temp!=null){
	    			projectInput.addAll(temp);
	    		}	    		
	    	}
			List<ProjectInputDIO> projectInputDIO = new ArrayList<ProjectInputDIO>();
			for(int i=0;i<projectInput.size();i++){
				projectInputDIO.add(new ProjectInputDIO(projectInput.get(i)));
			}
			List<Object> projectInputList = new ArrayList<>();
			projectInputList.addAll(projectInputDIO);
			
			
			List<PolicyMeasure> policyMeasure = new ArrayList<PolicyMeasure>();
			for(int i=0;i<policy.size();i++){
	    		List<PolicyMeasure> temp = policyMeasureService.getPolicyMeasureList(policy.get(i).getId());
	    		if(temp!=null){
	    			policyMeasure.addAll(temp);
	    		}	    		
	    	}
			List<Object> policyMeasureList = new ArrayList<>();
			policyMeasureList.addAll(policyMeasure);
			
			String fileName = "", path = this.getClass().getClassLoader().getResource(File.separator).getPath(),
					upload = URLDecoder.decode(new File(path).getParentFile().getParent(), "UTF-8")+File.separator+"upload"+File.separator+(String)session.getAttribute("username");
			
		    //设置响应头和客户端保存文件名
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("multipart/form-data");
		    response.setHeader("Content-Disposition", "attachment;fileName=" + new String((fileName+"举办者履职汇总.zip").getBytes("gbk"),"iso-8859-1"));
		    
		    try {
		        //激活下载操作		    	
		    	File fileUpload = new File(upload),
		    			fileMain = new File(upload+File.separator+fileName+"经费汇总表.xlsx"),
		    			fileAttach = new File(upload+File.separator+fileName+"项目投入汇总表.xlsx"),
		    			fileMains = new File(upload+File.separator+fileName+"政策汇总表.xlsx"),
		    			fileAttachs = new File(upload+File.separator+fileName+"政策措施汇总表.xlsx");
		    	if (!fileUpload.exists() || !fileUpload.isDirectory()) {
		    		fileUpload.mkdir();
				}
		    	ZipOutputStream os = new ZipOutputStream(response.getOutputStream());
		    	
		    	ExcelUtil excelUtil = new ExcelUtil(fileMain);		    	
		        String[] titleMain = {"招生代码","中央财政投入经费", "地方财政投入经费", "学校负债总额", "贷款总额"
		        					 ,"生均拨款","日常教学经费投入比例","教学改革经费","教科研经费"};				
				List<String> fundsYearList = dataQueryService.getFundsYearList();				
				excelUtil.writeListTitle(titleMain, fundsYearList);
				excelUtil.writeList(fundsList, fundsYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAttach);
				String[] titleAttach = {"招生代码","资金项目类型","项目名称","项目金额（万元）"};				
				List<String> projectInputYearList = dataQueryService.getProjectInputYearList();				
				excelUtil.writeListTitle(titleAttach, projectInputYearList);
				excelUtil.writeList(projectInputList, projectInputYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileMains);
		        String[] titleMains = {"招生代码","年度新增教师编制数"};				
				List<String> policyYearList = dataQueryService.getPolicyYearList();				
				excelUtil.writeListTitle(titleMains, policyYearList);
				excelUtil.writeList(policyList, policyYearList);
				excelUtil.close();
				
				excelUtil = new ExcelUtil(fileAttachs);
				String[] titleAttachs = {"招生代码","区域落实办学自主权政策名称", "提升学校办学水平的政策和制度名称"};				
				List<String> policyMeasureYearList = dataQueryService.getPolicyMeasureYearList();				
				excelUtil.writeListTitle(titleAttachs, policyMeasureYearList);
				excelUtil.writeList(policyMeasureList, policyMeasureYearList);
				excelUtil.close();
				
				ZipUtil.doCompress(fileMain, os);				
				ZipUtil.doCompress(fileAttach, os);
				ZipUtil.doCompress(fileMains, os);				
				ZipUtil.doCompress(fileAttachs, os);
				
				response.flushBuffer();
				os.close();
				ZipUtil.deleteDir(fileUpload);
		    } catch (Exception e){
		        e.printStackTrace();
		        return;
		    }
	    	
    		}else if(x.equals("7")){
    				        
			List<Partybulid> partybulid = dataQueryService.getPartybuildList(admcode,city);
			List<Object> partybulidList = new ArrayList<>();
			partybulidList.addAll(partybulid);
			
			String fileName = "党建工作汇总表.xlsx";
		
		    //设置响应头和客户端保存文件名
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("multipart/form-data");
		    response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("gbk"),"iso-8859-1"));
		    try {
		    	//激活下载操作
		        OutputStream os = response.getOutputStream();
		        ExcelUtil excelUtil = new ExcelUtil(os);
		        String[] title = {"招生代码", "学校党员总数","党支部数", "学生党员数","党务工作人员培训人次", "党组织开展党员教育培训次数", 
		        				  "入党积极分子培训人数","入党积极分子培训次数","发展党员人数","党报党刊订阅数","受党纪政治处分党员数",
		        				  "获国家级优秀表彰的人数","获省级优秀表彰的人数","获市级优秀表彰的人数","获国家级优秀表彰的党组织数",
		        				  "获省级优秀表彰的党组织数","获市级优秀表彰的党组织数"};
		        List<String> partybulidYearList = dataQueryService.getPartybulidYearList();				
				excelUtil.writeListTitle(title, partybulidYearList);
				excelUtil.writeList(partybulidList, partybulidYearList);				
				excelUtil.close();					
				
		    } catch (Exception e){
		        e.printStackTrace();
		        return;
		    }
			    	
    	}
	            	            
	  }
	     
}
