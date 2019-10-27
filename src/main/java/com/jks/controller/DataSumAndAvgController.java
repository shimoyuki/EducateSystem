package com.jks.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import com.jks.entity.Funds;
import com.jks.entity.Groupschool;
import com.jks.entity.Information;
import com.jks.entity.Internship;
import com.jks.entity.MajorLayout;
import com.jks.entity.MajorNum;
import com.jks.entity.Partybulid;
import com.jks.entity.Policy;
import com.jks.entity.QualityAssurance;
import com.jks.entity.Schoolenterprise;
import com.jks.entity.Size;
import com.jks.entity.SkillTrain;
import com.jks.entity.SocialService;
import com.jks.entity.StudentQuality;
import com.jks.entity.Teachers;
import com.jks.service.DataSumAndAvgService;
import com.jks.service.DataSumAndAvgService;

@Controller
@RequestMapping("/dataSumAndAvg")
public class DataSumAndAvgController {
	@Autowired
	private DataSumAndAvgService dataSumAndAvgService;
	
	@RequestMapping("/getDataSumAndAvg")
	public String getDataSumAndAvg(Model model,HttpServletRequest request,
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
				@RequestParam(value="pnSizeAvg",defaultValue="1")Integer pnSizeAvg,
				@RequestParam(value="pnEquitmentAvg",defaultValue="1")Integer pnEquitmentAvg,
				@RequestParam(value="pnTeachersAvg",defaultValue="1")Integer pnTeachersAvg,
				@RequestParam(value="pnInformationAvg",defaultValue="1")Integer pnInformationAvg,
				@RequestParam(value="pnStudentQualityAvg",defaultValue="1")Integer pnStudentQualityAvg,
				@RequestParam(value="pnExperienceAvg",defaultValue="1")Integer pnExperienceAvg,
				@RequestParam(value="pnEmployQualityAvg",defaultValue="1")Integer pnEmployQualityAvg,
				@RequestParam(value="pnMajorLayoutAvg",defaultValue="1")Integer pnMajorLayoutAvg,
				@RequestParam(value="pnMajorNumAvg",defaultValue="1")Integer pnMajorNumAvg,
				@RequestParam(value="pnQualityAssuranceAvg",defaultValue="1")Integer pnQualityAssuranceAvg,
				@RequestParam(value="pnEducationTrainAvg",defaultValue="1")Integer pnEducationTrainAvg,
				@RequestParam(value="pnSchoolenterpriseAvg",defaultValue="1")Integer pnSchoolenterpriseAvg,
				@RequestParam(value="pnInternshipAvg",defaultValue="1")Integer pnInternshipAvg,
				@RequestParam(value="pnGroupschoolAvg",defaultValue="1")Integer pnGroupschoolAvg,
				@RequestParam(value="pnSkillTrainAvg",defaultValue="1")Integer pnSkillTrainAvg,
				@RequestParam(value="pnSocialServiceAvg",defaultValue="1")Integer pnSocialServiceAvg,
				@RequestParam(value="pnCounpaSuppAvg",defaultValue="1")Integer pnCounpaSuppAvg,
				@RequestParam(value="pnFundsAvg",defaultValue="1")Integer pnFundsAvg,
				@RequestParam(value="pnPolicyAvg",defaultValue="1")Integer pnPolicyAvg,
				@RequestParam(value="pnPartybulidAvg",defaultValue="1")Integer pnPartybulidAvg){
		HttpSession session = request.getSession();
		Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);    							
		String type = (String)param.get("type");
		String year = (String)param.get("year");						
		String types = (String)param.get("types");
		String years = (String)param.get("years");	
		String tn = (String)param.get("tn");
		
		String x,y;
		
		param.remove("year");
		param.remove("type");
		param.remove("years");
		param.remove("types");			
		param.remove("tn");
		
		if(tn!=null&&tn!=""){
			session.setAttribute("tn", tn);	
		}
		
		if(year==null&&type==null){	    			 	    			    			
			x = types;		
			y = years;			    			
		}else{	    				    					    			 
			x = type;			
			y = year;					    			
		}
		
		if(x==null||x==""){
			x="1";
		}
		
		if(y==null||y.equals("")){
			Date date = new Date();
			DateFormat format=new SimpleDateFormat("yyyy");
			y = format.format(date);
		}
		
		System.out.println(dataSumAndAvgService.getAreaList().toString());
		List<String> city = new ArrayList<String>();
		city.add(0, null);
		city.addAll(dataSumAndAvgService.getAreaList());
		for(int i=1;i<city.size();i++){
			city.set(i, city.get(i).substring(0, 2));
		}
		System.out.println(city.toString());
		
		if(x.equals("1")){ 
			List<Size> sizeSumList = new ArrayList<Size>();		
			List<Equitment> equitmentSumList = new ArrayList<Equitment>();	
			List<Teachers> teachersSumList = new ArrayList<Teachers>();	
			List<Information> informationSumList = new ArrayList<Information>();
			List<Size> sizeAvgList = new ArrayList<Size>();
			List<Equitment> equitmentAvgList = new ArrayList<Equitment>();
			List<Teachers> teachersAvgList = new ArrayList<Teachers>();
			List<Information> informationAvgList = new ArrayList<Information>();
			
			if(pnSize.equals(1)){
			for(int i=0;i<city.size()/2;i++){			
				sizeSumList.addAll(dataSumAndAvgService.getSumSize(y, city.get(i))); 			
				}
				if(sizeSumList.size()>0){
					sizeSumList.get(0).setAdmcode("全省");
					}
			}else if(pnSize.equals(2)){
				for(int i=city.size()/2;i<city.size();i++){			
					sizeSumList.addAll(dataSumAndAvgService.getSumSize(y, city.get(i))); 			
				}
			}
			
			PageHelper.startPage(pnSize,11); 
	    	PageInfo sizeSumListPageInfo = new PageInfo(sizeSumList,5);	    	
	        model.addAttribute("sizeSumListPageInfo", sizeSumListPageInfo);
	        
			if(pnSizeAvg.equals(1)){
				for(int i=0;i<city.size()/2;i++){
					sizeAvgList.addAll(dataSumAndAvgService.getAvgSize(y, city.get(i)));
					}
				if(sizeAvgList.size()>0){
					sizeAvgList.get(0).setAdmcode("全省平均值");
				}				
				}else if(pnSizeAvg.equals(2)){
					for(int i=city.size()/2;i<city.size();i++){
					sizeAvgList.addAll(dataSumAndAvgService.getAvgSize(y, city.get(i)));
					}
				}
				        
	        PageHelper.startPage(pnSizeAvg,11); 
	    	PageInfo sizeAvgListPageInfo = new PageInfo(sizeAvgList,5);
	        model.addAttribute("sizeAvgListPageInfo", sizeAvgListPageInfo);
	        
	        if(pnEquitment.equals(1)){
				for(int i=0;i<city.size()/2;i++){			
					equitmentSumList.addAll(dataSumAndAvgService.getSumEquitment(y, city.get(i))); 			
					}
					if(equitmentSumList.size()>0){
						equitmentSumList.get(0).setAdmcode("全省");
					}					
					
				}else if(pnEquitment.equals(2)){
					for(int i=city.size()/2;i<city.size();i++){			
						equitmentSumList.addAll(dataSumAndAvgService.getSumEquitment(y, city.get(i))); 			
					}
				}
	        
	        PageHelper.startPage(pnEquitment,11);
	    	PageInfo equitmentSumListPageInfo = new PageInfo(equitmentSumList,5);
	        model.addAttribute("equitmentSumListPageInfo", equitmentSumListPageInfo);
	        
				if(pnEquitmentAvg.equals(1)){
					for(int i=0;i<city.size()/2;i++){
						equitmentAvgList.addAll(dataSumAndAvgService.getAvgEquitment(y, city.get(i)));
						}
					if(equitmentAvgList.size()>0){
						equitmentAvgList.get(0).setAdmcode("全省平均值");
					}				
					}else if(pnEquitmentAvg.equals(2)){
						for(int i=city.size()/2;i<city.size();i++){
							equitmentAvgList.addAll(dataSumAndAvgService.getAvgEquitment(y, city.get(i)));
						}
					}
	        
		    PageHelper.startPage(pnEquitmentAvg,11);
	    	PageInfo equitmentAvgListPageInfo = new PageInfo(equitmentAvgList,5);
	        model.addAttribute("equitmentAvgListPageInfo", equitmentAvgListPageInfo);
	        
	        if(pnTeachers.equals(1)){
				for(int i=0;i<city.size()/2;i++){			
					teachersSumList.addAll(dataSumAndAvgService.getSumTeachers(y, city.get(i))); 			
					}
				if(teachersSumList.size()>0){
					teachersSumList.get(0).setAdmcode("全省");
				}	
					
				}else if(pnTeachers.equals(2)){
					for(int i=city.size()/2;i<city.size();i++){			
						teachersSumList.addAll(dataSumAndAvgService.getSumTeachers(y, city.get(i))); 			
					}
				}
				
	        PageHelper.startPage(pnTeachers,11);
	    	PageInfo teachersSumListPageInfo = new PageInfo(teachersSumList,5);
	        model.addAttribute("teachersSumListPageInfo", teachersSumListPageInfo);
	        
				if(pnTeachersAvg.equals(1)){
					for(int i=0;i<city.size()/2;i++){
						teachersAvgList.addAll(dataSumAndAvgService.getAvgTeachers(y, city.get(i)));
						}
					if(teachersAvgList.size()>0){
						teachersAvgList.get(0).setAdmcode("全省平均值");
					}
					
					}else if(pnTeachersAvg.equals(2)){
						for(int i=city.size()/2;i<city.size();i++){
						  teachersAvgList.addAll(dataSumAndAvgService.getAvgTeachers(y, city.get(i)));
						}
					}
	        	      
	        PageHelper.startPage(pnTeachersAvg,11);
	    	PageInfo teachersAvgListPageInfo = new PageInfo(teachersAvgList,5);
	        model.addAttribute("teachersAvgListPageInfo", teachersAvgListPageInfo);
	        
	        if(pnInformation.equals(1)){
				for(int i=0;i<city.size()/2;i++){			
					informationSumList.addAll(dataSumAndAvgService.getSumInformation(y, city.get(i))); 			
					}
				if(informationSumList.size()>0){
					informationSumList.get(0).setAdmcode("全省");
				}
									
				}else if(pnInformation.equals(2)){
					for(int i=city.size()/2;i<city.size();i++){			
						informationSumList.addAll(dataSumAndAvgService.getSumInformation(y, city.get(i))); 			
					}
				}
				
	        PageHelper.startPage(pnInformation,11);  
	    	PageInfo informationSumListPageInfo = new PageInfo(informationSumList,5);
	        model.addAttribute("informationSumListPageInfo", informationSumListPageInfo);
	      
				if(pnInformationAvg.equals(1)){
					for(int i=0;i<city.size()/2;i++){
						informationAvgList.addAll(dataSumAndAvgService.getAvgInformation(y, city.get(i)));
						}
					if(informationAvgList.size()>0){
						informationAvgList.get(0).setAdmcode("全省平均值");
					}
					
					}else if(pnInformationAvg.equals(2)){
						for(int i=city.size()/2;i<city.size();i++){
							informationAvgList.addAll(dataSumAndAvgService.getAvgInformation(y, city.get(i)));
						}
					}	        
	          
	        PageHelper.startPage(pnInformationAvg,11);  
	    	PageInfo informationAvgListPageInfo = new PageInfo(informationAvgList,5);
	        model.addAttribute("informationAvgListPageInfo", informationAvgListPageInfo);
	        
	        model.addAttribute("typeCode", x);
    	    model.addAttribute("yearCode", y);
	        return "/admin/dataSumAndAvg/basic";
	        
    		}else if(x.equals("2")){
    		List<StudentQuality> studentQualitySumList = new ArrayList<StudentQuality>();		
    		List<Experience> experienceSumList = new ArrayList<Experience>();		
    		List<EmployQuality> employQualitySumList = new ArrayList<EmployQuality>();
    		List<StudentQuality> studentQualityAvgList = new ArrayList<StudentQuality>();
    		List<Experience> experienceAvgList = new ArrayList<Experience>();
    		List<EmployQuality> employQualityAvgList = new ArrayList<EmployQuality>();
    		
    		if(pnStudentQuality.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				studentQualitySumList.addAll(dataSumAndAvgService.getSumStudentQuality(y, city.get(i))); 			
    				}
    			if(studentQualitySumList.size()>0){
    				studentQualitySumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnStudentQuality.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					studentQualitySumList.addAll(dataSumAndAvgService.getSumStudentQuality(y, city.get(i))); 			
    				}
    			}
    		
    		PageHelper.startPage(pnStudentQuality,11);
	    	PageInfo studentQualitySumListPageInfo = new PageInfo(studentQualitySumList,5);
	        model.addAttribute("studentQualitySumListPageInfo", studentQualitySumListPageInfo);
	        
	        if(pnStudentQualityAvg.equals(1)){
				for(int i=0;i<city.size()/2;i++){
					studentQualityAvgList.addAll(dataSumAndAvgService.getAvgStudentQuality(y, city.get(i)));
					}
				if(studentQualityAvgList.size()>0){
					studentQualityAvgList.get(0).setAdmcode("全省平均值");
				}
					
				}else if(pnStudentQualityAvg.equals(2)){
					for(int i=city.size()/2;i<city.size();i++){
					studentQualityAvgList.addAll(dataSumAndAvgService.getAvgStudentQuality(y, city.get(i)));
					}
				}
	        
	        PageHelper.startPage(pnStudentQualityAvg,12);
	    	PageInfo studentQualityAvgListPageInfo = new PageInfo(studentQualityAvgList,5);
	        model.addAttribute("studentQualityAvgListPageInfo", studentQualityAvgListPageInfo);
	        
	        if(pnExperience.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				experienceSumList.addAll(dataSumAndAvgService.getSumExperience(y, city.get(i)));			
    				}
    			if(experienceSumList.size()>0){
    				experienceSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnExperience.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					experienceSumList.addAll(dataSumAndAvgService.getSumExperience(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnExperience,11);
	    	PageInfo experienceSumListPageInfo = new PageInfo(experienceSumList,5);
	        model.addAttribute("experienceSumListPageInfo", experienceSumListPageInfo);
	        
	        if(pnExperienceAvg.equals(1)){
				for(int i=0;i<city.size()/2;i++){
					experienceAvgList.addAll(dataSumAndAvgService.getAvgExperience(y, city.get(i)));
					}
				if(experienceAvgList.size()>0){
					experienceAvgList.get(0).setAdmcode("全省平均值");
				}
				
				}else if(pnExperienceAvg.equals(2)){
					for(int i=city.size()/2;i<city.size();i++){
						experienceAvgList.addAll(dataSumAndAvgService.getAvgExperience(y, city.get(i)));
					}
				}
	        
	        PageHelper.startPage(pnExperienceAvg,11);
	    	PageInfo experienceAvgListPageInfo = new PageInfo(experienceAvgList,5);
	        model.addAttribute("experienceAvgListPageInfo", experienceAvgListPageInfo);
	        
	        if(pnEmployQuality.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				employQualitySumList.addAll(dataSumAndAvgService.getSumEmployQuality(y, city.get(i)));			
    				}
    			if(employQualitySumList.size()>0){
    				employQualitySumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnEmployQuality.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					employQualitySumList.addAll(dataSumAndAvgService.getSumEmployQuality(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnEmployQuality,11); 
	    	PageInfo employQualitySumListPageInfo = new PageInfo(employQualitySumList,5);
	        model.addAttribute("employQualitySumListPageInfo", employQualitySumListPageInfo);
    		
	        if(pnEmployQualityAvg.equals(1)){
				for(int i=0;i<city.size()/2;i++){
					employQualityAvgList.addAll(dataSumAndAvgService.getAvgEmployQuality(y, city.get(i)));
					}
				if(employQualityAvgList.size()>0){
					employQualityAvgList.get(0).setAdmcode("全省平均值");
				}
				
				}else if(pnEmployQualityAvg.equals(2)){
					for(int i=city.size()/2;i<city.size();i++){
						employQualityAvgList.addAll(dataSumAndAvgService.getAvgEmployQuality(y, city.get(i)));
					}
				}	
	               
	        PageHelper.startPage(pnEmployQualityAvg,12); 
	    	PageInfo employQualityAvgListPageInfo = new PageInfo(employQualityAvgList,5);
	        model.addAttribute("employQualityAvgListPageInfo", employQualityAvgListPageInfo);
	        
	        model.addAttribute("typeCode", x);
    	    model.addAttribute("yearCode", y);
	        return "/admin/dataSumAndAvg/student";
    		
    		}else if(x.equals("3")){
    		List<MajorLayout> majorLayoutSumList = new ArrayList<MajorLayout>();
    		List<MajorLayout> majorLayoutAvgList = new ArrayList<MajorLayout>();
    		List<MajorNum> majorNumSumList = new ArrayList<MajorNum>();
    		List<MajorNum> majorNumAvgList = new ArrayList<MajorNum>();
    		List<QualityAssurance> qualityAssuranceSumList = new ArrayList<QualityAssurance>();
    		List<QualityAssurance> qualityAssuranceAvgList = new ArrayList<QualityAssurance>();
    		List<EducationTrain> educationTrainSumList = new ArrayList<EducationTrain>();
    		List<EducationTrain> educationTrainAvgList = new ArrayList<EducationTrain>();
    		
    		if(pnMajorLayout.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				majorLayoutSumList.addAll(dataSumAndAvgService.getSumMajorLayout(y, city.get(i))); 			
    				}
    			if(majorLayoutSumList.size()>0){
    				majorLayoutSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnMajorLayout.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					majorLayoutSumList.addAll(dataSumAndAvgService.getSumMajorLayout(y, city.get(i))); 			
    				}
    			}
    				
	        PageHelper.startPage(pnMajorLayout,11);  
	    	PageInfo majorLayoutSumListPageInfo = new PageInfo(majorLayoutSumList,5);
	        model.addAttribute("majorLayoutSumListPageInfo", majorLayoutSumListPageInfo);
	        
	        if(pnMajorLayoutAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				majorLayoutAvgList.addAll(dataSumAndAvgService.getAvgMajorLayout(y, city.get(i))); 			
    				}
    			if(majorLayoutAvgList.size()>0){
    				majorLayoutAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnMajorLayoutAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					majorLayoutAvgList.addAll(dataSumAndAvgService.getAvgMajorLayout(y, city.get(i))); 			
    				}
    			}
    				
	        PageHelper.startPage(pnMajorLayoutAvg,11);  
	    	PageInfo majorLayoutAvgListPageInfo = new PageInfo(majorLayoutAvgList,5);
	        model.addAttribute("majorLayoutAvgListPageInfo", majorLayoutAvgListPageInfo);
	        
	        if(pnMajorNum.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				majorNumSumList.addAll(dataSumAndAvgService.getSumMajorNum(y, city.get(i))); 			
    				}
    			if(majorNumSumList.size()>0){
    				majorNumSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnMajorNum.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					majorNumSumList.addAll(dataSumAndAvgService.getSumMajorNum(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnMajorNum,11);
	    	PageInfo majorNumSumListPageInfo = new PageInfo(majorNumSumList,5);
	        model.addAttribute("majorNumSumListPageInfo", majorNumSumListPageInfo);
	        
	        if(pnMajorNumAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				majorNumAvgList.addAll(dataSumAndAvgService.getAvgMajorNum(y, city.get(i))); 			
    				}
    			if(majorNumAvgList.size()>0){
    				majorNumAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnMajorNumAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					majorNumAvgList.addAll(dataSumAndAvgService.getAvgMajorNum(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnMajorNumAvg,11);
	    	PageInfo majorNumAvgListPageInfo = new PageInfo(majorNumAvgList,5);
	        model.addAttribute("majorNumAvgListPageInfo", majorNumAvgListPageInfo);
	        
	        if(pnQualityAssurance.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				qualityAssuranceSumList.addAll(dataSumAndAvgService.getSumQualityAssurance(y, city.get(i))); 			
    				}
    			if(qualityAssuranceSumList.size()>0){
    				qualityAssuranceSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnQualityAssurance.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					qualityAssuranceSumList.addAll(dataSumAndAvgService.getSumQualityAssurance(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnQualityAssurance,11);
	    	PageInfo qualityAssuranceSumListPageInfo = new PageInfo(qualityAssuranceSumList,5);
	        model.addAttribute("qualityAssuranceSumListPageInfo", qualityAssuranceSumListPageInfo);
	        
	        if(pnQualityAssuranceAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				qualityAssuranceAvgList.addAll(dataSumAndAvgService.getAvgQualityAssurance(y, city.get(i))); 			
    				}
    			if(qualityAssuranceAvgList.size()>0){
    				qualityAssuranceAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnQualityAssuranceAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					qualityAssuranceAvgList.addAll(dataSumAndAvgService.getAvgQualityAssurance(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnQualityAssuranceAvg,11);
	    	PageInfo qualityAssuranceAvgListPageInfo = new PageInfo(qualityAssuranceAvgList,5);
	        model.addAttribute("qualityAssuranceAvgListPageInfo", qualityAssuranceAvgListPageInfo);
	        
	        if(pnEducationTrain.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				educationTrainSumList.addAll(dataSumAndAvgService.getSumEducationTrain(y, city.get(i))); 			
    				}
    			if(educationTrainSumList.size()>0){
    				educationTrainSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnEducationTrain.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					educationTrainSumList.addAll(dataSumAndAvgService.getSumEducationTrain(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnEducationTrain,11);
	    	PageInfo educationTrainSumListPageInfo = new PageInfo(educationTrainSumList,5);
	        model.addAttribute("educationTrainSumListPageInfo", educationTrainSumListPageInfo);
	        
	        if(pnEducationTrainAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				educationTrainAvgList.addAll(dataSumAndAvgService.getAvgEducationTrain(y, city.get(i))); 			
    				}
    			if(educationTrainAvgList.size()>0){
    				educationTrainAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnEducationTrainAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					educationTrainAvgList.addAll(dataSumAndAvgService.getAvgEducationTrain(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnEducationTrainAvg,11);
	    	PageInfo educationTrainAvgListPageInfo = new PageInfo(educationTrainAvgList,5);
	        model.addAttribute("educationTrainAvgListPageInfo", educationTrainAvgListPageInfo);
    		
	        model.addAttribute("typeCode", x);
    	    model.addAttribute("yearCode", y);
	        return "/admin/dataSumAndAvg/qualityAssurance";
	        
    		}else if(x.equals("4")){
    		List<Schoolenterprise> schoolenterpriseSumList = new ArrayList<Schoolenterprise>();
    		List<Schoolenterprise> schoolenterpriseAvgList = new ArrayList<Schoolenterprise>();
    		List<Internship> internshipSumList = new ArrayList<Internship>();
    		List<Internship> internshipAvgList = new ArrayList<Internship>();
    		List<Groupschool> groupschoolSumList = new ArrayList<Groupschool>();
    		List<Groupschool> groupschoolAvgList = new ArrayList<Groupschool>();
    		
    		if(pnSchoolenterprise.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				schoolenterpriseSumList.addAll(dataSumAndAvgService.getSumSchoolenterprise(y, city.get(i))); 			
    				}
    			if(schoolenterpriseSumList.size()>0){
    				schoolenterpriseSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnSchoolenterprise.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					schoolenterpriseSumList.addAll(dataSumAndAvgService.getSumSchoolenterprise(y, city.get(i))); 			
    				}
    			}
    		
	        PageHelper.startPage(pnSchoolenterprise,11);
	    	PageInfo schoolenterpriseSumListPageInfo = new PageInfo(schoolenterpriseSumList,5);
	        model.addAttribute("schoolenterpriseSumListPageInfo", schoolenterpriseSumListPageInfo);
	        
	        if(pnSchoolenterpriseAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				schoolenterpriseAvgList.addAll(dataSumAndAvgService.getAvgSchoolenterprise(y, city.get(i))); 			
    				}
    			if(schoolenterpriseAvgList.size()>0){
    				schoolenterpriseAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnSchoolenterpriseAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					schoolenterpriseAvgList.addAll(dataSumAndAvgService.getAvgSchoolenterprise(y, city.get(i))); 			
    				}
    			}
    		
	        PageHelper.startPage(pnSchoolenterpriseAvg,11);
	    	PageInfo schoolenterpriseAvgListPageInfo = new PageInfo(schoolenterpriseAvgList,5);
	        model.addAttribute("schoolenterpriseAvgListPageInfo", schoolenterpriseAvgListPageInfo);
	        
	        if(pnInternship.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				internshipSumList.addAll(dataSumAndAvgService.getSumInternship(y, city.get(i))); 			
    				}
    			if(internshipSumList.size()>0){
    				internshipSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnInternship.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					internshipSumList.addAll(dataSumAndAvgService.getSumInternship(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnInternship,11); 
	    	PageInfo internshipSumListPageInfo = new PageInfo(internshipSumList,5);
	        model.addAttribute("internshipSumListPageInfo", internshipSumListPageInfo);
	        
	        if(pnInternshipAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				internshipAvgList.addAll(dataSumAndAvgService.getAvgInternship(y, city.get(i))); 			
    				}
    			if(internshipAvgList.size()>0){
    				internshipAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnInternshipAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					internshipAvgList.addAll(dataSumAndAvgService.getAvgInternship(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnInternshipAvg,11); 
	    	PageInfo internshipAvgListPageInfo = new PageInfo(internshipAvgList,5);
	        model.addAttribute("internshipAvgListPageInfo", internshipAvgListPageInfo);
	        
	        if(pnGroupschool.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				groupschoolSumList.addAll(dataSumAndAvgService.getSumGroupschool(y, city.get(i))); 			
    				}
    			if(groupschoolSumList.size()>0){
    				groupschoolSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnGroupschool.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					groupschoolSumList.addAll(dataSumAndAvgService.getSumGroupschool(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnGroupschool,11);
	    	PageInfo groupschoolSumListPageInfo = new PageInfo(groupschoolSumList,5);
	        model.addAttribute("groupschoolSumListPageInfo", groupschoolSumListPageInfo);
	        
	        if(pnGroupschoolAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				groupschoolAvgList.addAll(dataSumAndAvgService.getAvgGroupschool(y, city.get(i))); 			
    				}
    			if(groupschoolAvgList.size()>0){
    				groupschoolAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnGroupschoolAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					groupschoolAvgList.addAll(dataSumAndAvgService.getAvgGroupschool(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnGroupschoolAvg,11);
	    	PageInfo groupschoolAvgListPageInfo = new PageInfo(groupschoolAvgList,5);
	        model.addAttribute("groupschoolAvgListPageInfo", groupschoolAvgListPageInfo);
    		
	        model.addAttribute("typeCode", x);
    	    model.addAttribute("yearCode", y);
	        return "/admin/dataSumAndAvg/school";
	        
    		}else if(x.equals("5")){
    		List<SkillTrain> skillTrainSumList = new ArrayList<SkillTrain>();
    		List<SkillTrain> skillTrainAvgList = new ArrayList<SkillTrain>();
    		List<SocialService> socialServiceSumList = new ArrayList<SocialService>();
    		List<SocialService> socialServiceAvgList = new ArrayList<SocialService>();
    		List<CounpaSupp> counpaSuppSumList = new ArrayList<CounpaSupp>();
    		List<CounpaSupp> counpaSuppAvgList = new ArrayList<CounpaSupp>();
    		
    		if(pnSkillTrain.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				skillTrainSumList.addAll(dataSumAndAvgService.getSumSkillTrain(y, city.get(i))); 			
    				}
    			if(skillTrainSumList.size()>0){
    				skillTrainSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnSkillTrain.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					skillTrainSumList.addAll(dataSumAndAvgService.getSumSkillTrain(y, city.get(i))); 			
    				}
    			}
    		
	        PageHelper.startPage(pnSkillTrain,11); 
	    	PageInfo skillTrainSumListPageInfo = new PageInfo(skillTrainSumList,5);
	        model.addAttribute("skillTrainSumListPageInfo", skillTrainSumListPageInfo);
	        
	        if(pnSkillTrainAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				skillTrainAvgList.addAll(dataSumAndAvgService.getAvgSkillTrain(y, city.get(i))); 			
    				}
    			if(skillTrainAvgList.size()>0){
    				skillTrainAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnSkillTrainAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					skillTrainAvgList.addAll(dataSumAndAvgService.getAvgSkillTrain(y, city.get(i))); 			
    				}
    			}
    		
	        PageHelper.startPage(pnSkillTrainAvg,11); 
	    	PageInfo skillTrainAvgListPageInfo = new PageInfo(skillTrainAvgList,5);
	        model.addAttribute("skillTrainAvgListPageInfo", skillTrainAvgListPageInfo);
	        
	        if(pnSocialService.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				socialServiceSumList.addAll(dataSumAndAvgService.getSumSocialService(y, city.get(i))); 			
    				}
    			if(socialServiceSumList.size()>0){
    				socialServiceSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnSocialService.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					socialServiceSumList.addAll(dataSumAndAvgService.getSumSocialService(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnSocialService,11); 
	    	PageInfo socialServiceSumListPageInfo = new PageInfo(socialServiceSumList,5);
	        model.addAttribute("socialServiceSumListPageInfo", socialServiceSumListPageInfo);
	        
	        if(pnSocialServiceAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				socialServiceAvgList.addAll(dataSumAndAvgService.getAvgSocialService(y, city.get(i))); 			
    				}
    			if(socialServiceAvgList.size()>0){
    				socialServiceAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnSocialServiceAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					socialServiceAvgList.addAll(dataSumAndAvgService.getAvgSocialService(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnSocialServiceAvg,11); 
	    	PageInfo socialServiceAvgListPageInfo = new PageInfo(socialServiceAvgList,5);
	        model.addAttribute("socialServiceAvgListPageInfo", socialServiceAvgListPageInfo);
	        
	        if(pnCounpaSupp.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				counpaSuppSumList.addAll(dataSumAndAvgService.getSumCounpaSupp(y, city.get(i))); 			
    				}
    			if(counpaSuppSumList.size()>0){
    				counpaSuppSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnCounpaSupp.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					counpaSuppSumList.addAll(dataSumAndAvgService.getSumCounpaSupp(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnCounpaSupp,11);
	    	PageInfo counpaSuppSumListPageInfo = new PageInfo(counpaSuppSumList,5);
	        model.addAttribute("counpaSuppSumListPageInfo", counpaSuppSumListPageInfo);
	        
	        if(pnCounpaSuppAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				counpaSuppAvgList.addAll(dataSumAndAvgService.getAvgCounpaSupp(y, city.get(i))); 			
    				}
    			if(counpaSuppAvgList.size()>0){
    				counpaSuppAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnCounpaSuppAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					counpaSuppAvgList.addAll(dataSumAndAvgService.getAvgCounpaSupp(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnCounpaSuppAvg,11);
	    	PageInfo counpaSuppAvgListPageInfo = new PageInfo(counpaSuppAvgList,5);
	        model.addAttribute("counpaSuppAvgListPageInfo", counpaSuppAvgListPageInfo);
    		
	        model.addAttribute("typeCode", x);
    	    model.addAttribute("yearCode", y);
	        return "/admin/dataSumAndAvg/social";
	        
    		}else if(x.equals("6")){
    			
    		List<Funds> fundsSumList = new ArrayList<Funds>();
    		List<Funds> fundsAvgList = new ArrayList<Funds>();	
    		List<Policy> policySumList = new ArrayList<Policy>();
    		List<Policy> policyAvgList = new ArrayList<Policy>();
    		
    		if(pnFunds.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				fundsSumList.addAll(dataSumAndAvgService.getSumFunds(y, city.get(i))); 			
    				}
    			if(fundsSumList.size()>0){
    				fundsSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnFunds.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					fundsSumList.addAll(dataSumAndAvgService.getSumFunds(y, city.get(i))); 			
    				}
    			}
    		
    		PageHelper.startPage(pnFunds,12);			 
	    	PageInfo fundsSumListPageInfo = new PageInfo(fundsSumList,5);
	        model.addAttribute("fundsSumListPageInfo", fundsSumListPageInfo);
	        
	        if(pnFundsAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				fundsAvgList.addAll(dataSumAndAvgService.getAvgFunds(y, city.get(i))); 			
    				}
    			if(fundsAvgList.size()>0){
    				fundsAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnFundsAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					fundsAvgList.addAll(dataSumAndAvgService.getAvgFunds(y, city.get(i))); 			
    				}
    			}
    		
    		PageHelper.startPage(pnFundsAvg,12);			 
	    	PageInfo fundsAvgListPageInfo = new PageInfo(fundsAvgList,5);
	        model.addAttribute("fundsAvgListPageInfo", fundsAvgListPageInfo);
	        
	        if(pnPolicy.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				policySumList.addAll(dataSumAndAvgService.getSumPolicy(y, city.get(i))); 			
    				}
    			if(policySumList.size()>0){
    				policySumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnPolicy.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					policySumList.addAll(dataSumAndAvgService.getSumPolicy(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnPolicy,12);
	    	PageInfo policySumListPageInfo = new PageInfo(policySumList,5);
	        model.addAttribute("policySumListPageInfo", policySumListPageInfo);
	        
	        if(pnPolicyAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				policyAvgList.addAll(dataSumAndAvgService.getAvgPolicy(y, city.get(i))); 			
    				}
    			if(policySumList.size()>0){
    				policyAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnPolicyAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					policyAvgList.addAll(dataSumAndAvgService.getAvgPolicy(y, city.get(i))); 			
    				}
    			}
	        
	        PageHelper.startPage(pnPolicyAvg,12);
	    	PageInfo policyAvgListPageInfo = new PageInfo(policyAvgList,5);
	        model.addAttribute("policyAvgListPageInfo", policyAvgListPageInfo);
    		
	        model.addAttribute("typeCode", x);
    	    model.addAttribute("yearCode", y);
	        return "/admin/dataSumAndAvg/organizer";
	        
    		}else if(x.equals("7")){
    		
    		List<Partybulid> partybulidSumList = new ArrayList<Partybulid>();
    		List<Partybulid> partybulidAvgList = new ArrayList<Partybulid>();
    		
    		if(pnPartybulid.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				partybulidSumList.addAll(dataSumAndAvgService.getSumPartybulid(y, city.get(i))); 			
    				}
    			if(partybulidSumList.size()>0){
    				partybulidSumList.get(0).setAdmcode("全省");
				}
    			
    				
    			}else if(pnPartybulid.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					partybulidSumList.addAll(dataSumAndAvgService.getSumPartybulid(y, city.get(i))); 			
    				}
    			}
    		
	        PageHelper.startPage(pnPartybulid,12);
	    	PageInfo partybulidSumListPageInfo = new PageInfo(partybulidSumList,5);
	        model.addAttribute("partybulidSumListPageInfo", partybulidSumListPageInfo);
	        
	        if(pnPartybulidAvg.equals(1)){
    			for(int i=0;i<city.size()/2;i++){			
    				partybulidAvgList.addAll(dataSumAndAvgService.getAvgPartybulid(y, city.get(i))); 			
    				}
    			if(partybulidAvgList.size()>0){
    				partybulidAvgList.get(0).setAdmcode("全省平均值");
				}
    			
    				
    			}else if(pnPartybulidAvg.equals(2)){
    				for(int i=city.size()/2;i<city.size();i++){			
    					partybulidAvgList.addAll(dataSumAndAvgService.getAvgPartybulid(y, city.get(i))); 			
    				}
    			}
    		
	        PageHelper.startPage(pnPartybulidAvg,12);
	    	PageInfo partybulidAvgListPageInfo = new PageInfo(partybulidAvgList,5);
	        model.addAttribute("partybulidAvgListPageInfo", partybulidAvgListPageInfo);
    		
	        model.addAttribute("typeCode", x);
    	    model.addAttribute("yearCode", y);
	        return "/admin/dataSumAndAvg/partyBuild";
    		}
		
		return "redirect:/dataSumAndAvg/getDataSumAndAvg";
		
	}

}
