package com.jks.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

@Controller
@RequestMapping("/dataSumAndAvgDetail")
public class DataSumAndAvgDetailController {
	@Autowired
	private DataSumAndAvgService dataSumAndAvgService;
	
	@RequestMapping("/getSizeSum")
	public String getSizeSum(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<Size> sizeSum = new ArrayList<Size>();
			if(admcode.equals("全省")){
				admcode = "";
				sizeSum = dataSumAndAvgService.getSumSize(year, admcode);
				sizeSum.get(0).setAdmcode("全省");
			}else{
				sizeSum = dataSumAndAvgService.getSumSize(year, admcode);
			}
						
			model.addAttribute("size", sizeSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/basic/sizeSum";		
	}
	
	@RequestMapping("/getSizeAvg")
	public String getSizeAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<Size> sizeAvg = new ArrayList<Size>();
			if(admcode.equals("全省")){
				admcode = "";
				sizeAvg = dataSumAndAvgService.getAvgSize(year, admcode);
				sizeAvg.get(0).setAdmcode("全省平均值");
			}else{
				sizeAvg = dataSumAndAvgService.getAvgSize(year, admcode);
			}
						
			model.addAttribute("size", sizeAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
						
		return "/admin/dataSumAndAvgDetail/basic/sizeAvg";		
	}
	
	@RequestMapping("/getEquitmentSum")
	public String getEquitmentSum(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<Equitment> equitmentSum = new ArrayList<Equitment>();
			if(admcode.equals("全省")){
				admcode = "";
				equitmentSum = dataSumAndAvgService.getSumEquitment(year, admcode);
				equitmentSum.get(0).setAdmcode("全省");
			}else{
				equitmentSum = dataSumAndAvgService.getSumEquitment(year, admcode);
			}
						
			model.addAttribute("equitment", equitmentSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/basic/equitmentSum";		
	}
	
	@RequestMapping("/getEquitmentAvg")
	public String getEquitmentAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<Equitment> equitmentAvg = new ArrayList<Equitment>();
			if(admcode.equals("全省")){
				admcode = "";
				equitmentAvg = dataSumAndAvgService.getAvgEquitment(year, admcode);
				equitmentAvg.get(0).setAdmcode("全省平均值");
			}else{
				equitmentAvg = dataSumAndAvgService.getAvgEquitment(year, admcode);
			}
						
			model.addAttribute("equitment", equitmentAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/basic/equitmentAvg";		
	}
	
	@RequestMapping("/getTeachersSum")
	public String getTeachersSum(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<Teachers> teachersSum = new ArrayList<Teachers>();
			if(admcode.equals("全省")){
				admcode = "";
				teachersSum = dataSumAndAvgService.getSumTeachers(year, admcode);
				teachersSum.get(0).setAdmcode("全省");
			}else{
				teachersSum = dataSumAndAvgService.getSumTeachers(year, admcode);
			}
						
			model.addAttribute("teac", teachersSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/basic/teacSum";		
	}
	
	@RequestMapping("/getTeachersAvg")
	public String getTeachersAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<Teachers> teachersAvg = new ArrayList<Teachers>();
			if(admcode.equals("全省")){
				admcode = "";
				teachersAvg = dataSumAndAvgService.getAvgTeachers(year, admcode);
				teachersAvg.get(0).setAdmcode("全省平均值省");
			}else{
				teachersAvg = dataSumAndAvgService.getAvgTeachers(year, admcode);
			}
						
			model.addAttribute("teac", teachersAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/basic/teacAvg";		
	}
	
	@RequestMapping("/getInformationSum")
	public String getInformationSum(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<Information> informationSum = new ArrayList<Information>();
			if(admcode.equals("全省")){
				admcode = "";
				informationSum = dataSumAndAvgService.getSumInformation(year, admcode);
				informationSum.get(0).setAdmcode("全省");
			}else{
				informationSum = dataSumAndAvgService.getSumInformation(year, admcode);
			}
						
			model.addAttribute("info", informationSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/basic/infoSum";		
	}
	
	@RequestMapping("/getInformationAvg")
	public String getInformationAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<Information> informationAvg = new ArrayList<Information>();
			if(admcode.equals("全省")){
				admcode = "";
				informationAvg = dataSumAndAvgService.getAvgInformation(year, admcode);
				informationAvg.get(0).setAdmcode("全省平均值");
			}else{
				informationAvg = dataSumAndAvgService.getAvgInformation(year, admcode);
			}
						
			model.addAttribute("info", informationAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/basic/infoAvg";		
	}
	
	@RequestMapping("/getMajorLayoutSum")
	public String getMajorLayoutSum(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<MajorLayout> majorLayoutSum = new ArrayList<MajorLayout>();
			if(admcode.equals("全省")){
				admcode = "";
				majorLayoutSum = dataSumAndAvgService.getSumMajorLayout(year, admcode);
				majorLayoutSum.get(0).setAdmcode("全省");
			}else{
				majorLayoutSum = dataSumAndAvgService.getSumMajorLayout(year, admcode);
			}
						
			model.addAttribute("majorLayout", majorLayoutSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/qualityAssurance/majorLayoutSum";		
	}
	
	@RequestMapping("/getMajorLayoutAvg")
	public String getMajorLayoutAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<MajorLayout> majorLayoutAvg = new ArrayList<MajorLayout>();
			if(admcode.equals("全省")){
				admcode = "";
				majorLayoutAvg = dataSumAndAvgService.getAvgMajorLayout(year, admcode);
				majorLayoutAvg.get(0).setAdmcode("全省平均值");
			}else{
				majorLayoutAvg = dataSumAndAvgService.getAvgMajorLayout(year, admcode);
			}
						
			model.addAttribute("majorLayout", majorLayoutAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/qualityAssurance/majorLayoutAvg";		
	}
	
	@RequestMapping("/getMajorNumSum")
	public String getMajorNumSum(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<MajorNum> majorNumSum = new ArrayList<MajorNum>();
			if(admcode.equals("全省")){
				admcode = "";
				majorNumSum = dataSumAndAvgService.getSumMajorNum(year, admcode);
				majorNumSum.get(0).setAdmcode("全省");
			}else{
				majorNumSum = dataSumAndAvgService.getSumMajorNum(year, admcode);
			}
						
			model.addAttribute("majorNum", majorNumSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/qualityAssurance/majorNumSum";		
	}
	
	@RequestMapping("/getMajorNumAvg")
	public String getMajorNumAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<MajorNum> majorNumAvg = new ArrayList<MajorNum>();
			if(admcode.equals("全省")){
				admcode = "";
				majorNumAvg = dataSumAndAvgService.getAvgMajorNum(year, admcode);
				majorNumAvg.get(0).setAdmcode("全省平均值");
			}else{
				majorNumAvg = dataSumAndAvgService.getAvgMajorNum(year, admcode);
			}
						
			model.addAttribute("majorNum", majorNumAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/qualityAssurance/majorNumAvg";		
	}
	
	@RequestMapping("/getQualityAssuranceSum")
	public String getQualityAssuranceSum(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<QualityAssurance> qualityAssurance = new ArrayList<QualityAssurance>();
			if(admcode.equals("全省")){
				admcode = "";
				qualityAssurance = dataSumAndAvgService.getSumQualityAssurance(year, admcode);
				qualityAssurance.get(0).setAdmcode("全省");
			}else{
				qualityAssurance = dataSumAndAvgService.getSumQualityAssurance(year, admcode);
			}
						
			model.addAttribute("qualityAssurance", qualityAssurance.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/qualityAssurance/qualityAssuranceSum";		
	}
	
	@RequestMapping("/getQualityAssuranceAvg")
	public String getQualityAssuranceAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<QualityAssurance> qualityAssurance = new ArrayList<QualityAssurance>();
			if(admcode.equals("全省")){
				admcode = "";
				qualityAssurance = dataSumAndAvgService.getAvgQualityAssurance(year, admcode);
				qualityAssurance.get(0).setAdmcode("全省平均值");
			}else{
				qualityAssurance = dataSumAndAvgService.getAvgQualityAssurance(year, admcode);
			}
						
			model.addAttribute("qualityAssurance", qualityAssurance.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/qualityAssurance/qualityAssuranceAvg";		
	}
	
	@RequestMapping("/getEducationTrainSum")
	public String getEducationTrainSum(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<EducationTrain> educationTrainSum = new ArrayList<EducationTrain>();
			if(admcode.equals("全省")){
				admcode = "";
				educationTrainSum = dataSumAndAvgService.getSumEducationTrain(year, admcode);
				educationTrainSum.get(0).setAdmcode("全省");
			}else{
				educationTrainSum = dataSumAndAvgService.getSumEducationTrain(year, admcode);
			}
						
			model.addAttribute("educationTrain", educationTrainSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/qualityAssurance/educationTrainSum";		
	}
	
	@RequestMapping("/getEducationTrainAvg")
	public String getEducationTrainAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<EducationTrain> educationTrainAvg = new ArrayList<EducationTrain>();
			if(admcode.equals("全省")){
				admcode = "";
				educationTrainAvg = dataSumAndAvgService.getAvgEducationTrain(year, admcode);
				educationTrainAvg.get(0).setAdmcode("全省平均值");
			}else{
				educationTrainAvg = dataSumAndAvgService.getAvgEducationTrain(year, admcode);
			}
						
			model.addAttribute("educationTrain", educationTrainAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/qualityAssurance/educationTrainAvg";		
	}
	
	@RequestMapping("/getStudSum")
	public String getStudentQualitySum(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<StudentQuality> studSum = new ArrayList<StudentQuality>();
			if(admcode.equals("全省")){
				admcode = "";
				studSum = dataSumAndAvgService.getSumStudentQuality(year, admcode);
				studSum.get(0).setAdmcode("全省");
			}else{
				studSum = dataSumAndAvgService.getSumStudentQuality(year, admcode);
			}
						
			model.addAttribute("stud", studSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/student/studSum";		
	}
	
	@RequestMapping("/getStudAvg")
	public String getStudentQualityAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<StudentQuality> studAvg = new ArrayList<StudentQuality>();
			if(admcode.equals("全省")){
				admcode = "";
				studAvg = dataSumAndAvgService.getAvgStudentQuality(year, admcode);
				studAvg.get(0).setAdmcode("全省平均值");
			}else{
				studAvg = dataSumAndAvgService.getAvgStudentQuality(year, admcode);
			}
						
			model.addAttribute("stud", studAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
						
		return "/admin/dataSumAndAvgDetail/student/studAvg";		
	}
	
	@RequestMapping("/getExpAvg")
	public String getExperienceAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<Experience> expAvg = new ArrayList<Experience>();
			if(admcode.equals("全省")){
				admcode = "";
				expAvg = dataSumAndAvgService.getAvgExperience(year, admcode);
				expAvg.get(0).setAdmcode("全省平均值");
			}else{
				expAvg = dataSumAndAvgService.getAvgExperience(year, admcode);
			}
						
			model.addAttribute("exp", expAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
						
		return "/admin/dataSumAndAvgDetail/student/expAvg";		
	}
	
	@RequestMapping("/getEmpAvg")
	public String getEmployQualityAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<EmployQuality> empAvg = new ArrayList<EmployQuality>();
			if(admcode.equals("全省")){
				admcode = "";
				empAvg = dataSumAndAvgService.getAvgEmployQuality(year, admcode);
				empAvg.get(0).setAdmcode("全省平均值");
			}else{
				empAvg = dataSumAndAvgService.getAvgEmployQuality(year, admcode);
			}
						
			model.addAttribute("emp", empAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
						
		return "/admin/dataSumAndAvgDetail/student/empAvg";		
	}
	
	@RequestMapping("/getSkiTraSum")
	public String getSkillTrainSum(Model model,String year,String admcode){
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<SkillTrain> skiTraSum = new ArrayList<SkillTrain>();
			if(admcode.equals("全省")){
				admcode = "";
				skiTraSum = dataSumAndAvgService.getSumSkillTrain(year, admcode);
				skiTraSum.get(0).setAdmcode("全省");
			}else{
				skiTraSum = dataSumAndAvgService.getSumSkillTrain(year, admcode);
			}
						
			model.addAttribute("skiTra", skiTraSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/social/skiTraSum";		
	}
	
	@RequestMapping("/getSkiTraAvg")
	public String getSkillTrainAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<SkillTrain> skiTraAvg = new ArrayList<SkillTrain>();
			if(admcode.equals("全省")){
				admcode = "";
				skiTraAvg = dataSumAndAvgService.getAvgSkillTrain(year, admcode);
				skiTraAvg.get(0).setAdmcode("全省平均值");
			}else{
				skiTraAvg = dataSumAndAvgService.getAvgSkillTrain(year, admcode);
			}
						
			model.addAttribute("skiTra", skiTraAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
						
		return "/admin/dataSumAndAvgDetail/social/skiTraAvg";		
	}
	
	@RequestMapping("/getSocialSum")
	public String getSocialServiceSum(Model model,String year,String admcode){
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<SocialService> socialSum = new ArrayList<SocialService>();
			if(admcode.equals("全省")){
				admcode = "";
				socialSum = dataSumAndAvgService.getSumSocialService(year, admcode);
				socialSum.get(0).setAdmcode("全省");
			}else{
				socialSum = dataSumAndAvgService.getSumSocialService(year, admcode);
			}
						
			model.addAttribute("social", socialSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/social/socialSum";		
	}
	
	@RequestMapping("/getSocialAvg")
	public String getSocialServiceAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<SocialService> socialAvg = new ArrayList<SocialService>();
			if(admcode.equals("全省")){
				admcode = "";
				socialAvg = dataSumAndAvgService.getAvgSocialService(year, admcode);
				socialAvg.get(0).setAdmcode("全省平均值");
			}else{
				socialAvg = dataSumAndAvgService.getAvgSocialService(year, admcode);
			}
						
			model.addAttribute("social", socialAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
						
		return "/admin/dataSumAndAvgDetail/social/socialAvg";		
	}
	
	@RequestMapping("/getCounSum")
	public String getCounpaSuppSum(Model model,String year,String admcode){
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<CounpaSupp> counSum = new ArrayList<CounpaSupp>();
			if(admcode.equals("全省")){
				admcode = "";
				counSum = dataSumAndAvgService.getSumCounpaSupp(year, admcode);
				counSum.get(0).setAdmcode("全省");
			}else{
				counSum = dataSumAndAvgService.getSumCounpaSupp(year, admcode);
			}
						
			model.addAttribute("coun", counSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/social/counSum";		
	}
	
	@RequestMapping("/getCounAvg")
	public String getCounpaSuppAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<CounpaSupp> counAvg = new ArrayList<CounpaSupp>();
			if(admcode.equals("全省")){
				admcode = "";
				counAvg = dataSumAndAvgService.getAvgCounpaSupp(year, admcode);
				counAvg.get(0).setAdmcode("全省平均值");
			}else{
				counAvg = dataSumAndAvgService.getAvgCounpaSupp(year, admcode);
			}
						
			model.addAttribute("coun", counAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
						
		return "/admin/dataSumAndAvgDetail/social/counAvg";		
	}
	
	@RequestMapping("/getSchoolEnterpriseSum")
	public String getSchoolenterpriseSum(Model model,String year,String admcode){
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<Schoolenterprise> schoolSum = new ArrayList<Schoolenterprise>();
			if(admcode.equals("全省")){
				admcode = "";
				schoolSum = dataSumAndAvgService.getSumSchoolenterprise(year, admcode);
				schoolSum.get(0).setAdmcode("全省");
			}else{
				schoolSum = dataSumAndAvgService.getSumSchoolenterprise(year, admcode);
			}
						
			model.addAttribute("schoolenterprise", schoolSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/school/schoolSum";		
	}
	
	@RequestMapping("/getSchoolEnterpriseAvg")
	public String getSchoolenterpriseAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<Schoolenterprise> schoolAvg = new ArrayList<Schoolenterprise>();
			if(admcode.equals("全省")){
				admcode = "";
				schoolAvg = dataSumAndAvgService.getAvgSchoolenterprise(year, admcode);
				schoolAvg.get(0).setAdmcode("全省平均值");
			}else{
				schoolAvg = dataSumAndAvgService.getAvgSchoolenterprise(year, admcode);
			}
						
			model.addAttribute("schoolenterprise", schoolAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
						
		return "/admin/dataSumAndAvgDetail/school/schoolAvg";		
	}
	
	@RequestMapping("/getInternshipSum")
	public String getInternshipSum(Model model,String year,String admcode){
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<Internship> internshipSum = new ArrayList<Internship>();
			if(admcode.equals("全省")){
				admcode = "";
				internshipSum = dataSumAndAvgService.getSumInternship(year, admcode);
				internshipSum.get(0).setAdmcode("全省");
			}else{
				internshipSum = dataSumAndAvgService.getSumInternship(year, admcode);
			}
						
			model.addAttribute("internship", internshipSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/school/internshipSum";		
	}
	
	@RequestMapping("/getInternshipAvg")
	public String getInternshipAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<Internship> internshipAvg = new ArrayList<Internship>();
			if(admcode.equals("全省")){
				admcode = "";
				internshipAvg = dataSumAndAvgService.getAvgInternship(year, admcode);
				internshipAvg.get(0).setAdmcode("全省平均值");
			}else{
				internshipAvg = dataSumAndAvgService.getAvgInternship(year, admcode);
			}
						
			model.addAttribute("internship", internshipAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
						
		return "/admin/dataSumAndAvgDetail/school/internshipAvg";		
	}
	
	@RequestMapping("/getGroupSchoolSum")
	public String getGroupschoolSum(Model model,String year,String admcode){
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<Groupschool> groupSum = new ArrayList<Groupschool>();
			if(admcode.equals("全省")){
				admcode = "";
				groupSum = dataSumAndAvgService.getSumGroupschool(year, admcode);
				groupSum.get(0).setAdmcode("全省");
			}else{
				groupSum = dataSumAndAvgService.getSumGroupschool(year, admcode);
			}
						
			model.addAttribute("groupschool", groupSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/school/groupSum";		
	}
	
	@RequestMapping("/getGroupSchoolAvg")
	public String getGroupschoolAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<Groupschool> groupAvg = new ArrayList<Groupschool>();
			if(admcode.equals("全省")){
				admcode = "";
				groupAvg = dataSumAndAvgService.getAvgGroupschool(year, admcode);
				groupAvg.get(0).setAdmcode("全省平均值");
			}else{
				groupAvg = dataSumAndAvgService.getAvgGroupschool(year, admcode);
			}
						
			model.addAttribute("groupschool", groupAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
						
		return "/admin/dataSumAndAvgDetail/school/groupAvg";		
	}
	
	@RequestMapping("/getFundsSum")
	public String getFundsSum(Model model,String year,String admcode){
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<Funds> fundsSum = new ArrayList<Funds>();
			if(admcode.equals("全省")){
				admcode = "";
				fundsSum = dataSumAndAvgService.getSumFunds(year, admcode);
				fundsSum.get(0).setAdmcode("全省");
			}else{
				fundsSum = dataSumAndAvgService.getSumFunds(year, admcode);
			}
						
			model.addAttribute("funds", fundsSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/organizer/fundsSum";		
	}
	
	@RequestMapping("/getFundsAvg")
	public String getFundsAvg(Model model,String year,String admcode){
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<Funds> fundsAvg = new ArrayList<Funds>();
			if(admcode.equals("全省")){
				admcode = "";
				fundsAvg = dataSumAndAvgService.getAvgFunds(year, admcode);
				fundsAvg.get(0).setAdmcode("全省平均值");
			}else{
				fundsAvg = dataSumAndAvgService.getAvgFunds(year, admcode);
			}
						
			model.addAttribute("funds", fundsAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/organizer/fundsAvg";		
	}
	
	@RequestMapping("/getPartySum")
	public String getPartybulidSum(Model model,String year,String admcode){
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			List<Partybulid> groupSum = new ArrayList<Partybulid>();
			if(admcode.equals("全省")){
				admcode = "";
				groupSum = dataSumAndAvgService.getSumPartybulid(year, admcode);
				groupSum.get(0).setAdmcode("全省");
			}else{
				groupSum = dataSumAndAvgService.getSumPartybulid(year, admcode);
			}
						
			model.addAttribute("partybulid", groupSum.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
						
		return "/admin/dataSumAndAvgDetail/partyBuild/partySum";		
	}
	
	@RequestMapping("/getPartyAvg")
	public String getPartybulidAvg(Model model,String year,String admcode){	
		try {
			admcode = new String(admcode.getBytes("iso-8859-1"),"utf-8");
			admcode = admcode.substring(0,2);
			List<Partybulid> groupAvg = new ArrayList<Partybulid>();
			if(admcode.equals("全省")){
				admcode = "";
				groupAvg = dataSumAndAvgService.getAvgPartybulid(year, admcode);
				groupAvg.get(0).setAdmcode("全省平均值");
			}else{
				groupAvg = dataSumAndAvgService.getAvgPartybulid(year, admcode);
			}
						
			model.addAttribute("partybulid", groupAvg.get(0));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
						
		return "/admin/dataSumAndAvgDetail/partyBuild/partyAvg";		
	}

}
