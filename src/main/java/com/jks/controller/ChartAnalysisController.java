package com.jks.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

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
import com.jks.entity.Standard;
import com.jks.entity.StudentQuality;
import com.jks.entity.TargetName;
import com.jks.entity.Teachers;
import com.jks.entity.User;
import com.jks.service.ChartAnalysisService;
import com.jks.service.GetCityListService;

@Controller
@RequestMapping("/chartAnalysis")
public class ChartAnalysisController {
	@Resource
	private GetCityListService getCityListService;
	@Autowired
	private ChartAnalysisService chartAnalysisService;
	
	@RequestMapping("/basic")
	public String toBasicChart(){
		return "/admin/basicChart";
	}
	
	@RequestMapping("/students")
	public String toStudentsChart(){
		return "/admin/studentsChart";
	}
	
	@RequestMapping("/quality")
	public String toQualityChart(){
		return "/admin/qualityChart";
	}
	
	@RequestMapping("/enterprise")
	public String toEnterpriseChart(){
		return "/admin/enterpriseChart";
	}
	
	@RequestMapping("/social")
	public String toSocialChart(){
		return "/admin/socialChart";
	}
	
	@RequestMapping("/organizer")
	public String toOrganizerChart(){
		return "/admin/organizerChart";
	}
	
	@RequestMapping("/partybuild")
	public String toPartyBuildChart(){
		return "/admin/partybuildChart";
	}
	
	@RequestMapping("/standard")
	public String toStandardChart(){
		return "/admin/standardChart";
	}
	
	@RequestMapping("/getBasicChart")
	public String getBasicChart(Model model,HttpServletRequest request,HttpServletResponse response){
		String content = request.getParameter("content"),
				yearlist = request.getParameter("year"),
				targetlist = request.getParameter("target"),
				arealist = request.getParameter("area"),
				schoollist = request.getParameter("school"),
				average = request.getParameter("average");
		if (yearlist == null || targetlist == null || arealist == null) {
			return "/admin/basicChart";
		}
		String[] year = yearlist.trim().split(",");
		String[] target = this.expandTarget(content, targetlist).trim().split(",");
		String[] targetField = this.chartAnalysisService.getTargetFields(target, content);
		String[] area = arealist.trim().split(",");
		/*System.out.println("查找条件————————————");
		for (int i = 0; i < year.length; i++) {
			System.out.print(year[i]);
		}
		System.out.println();
		for (int i = 0; i < target.length; i++) {
			System.out.print(target[i]);
		}
		System.out.println();
		for (int i = 0; i < area.length; i++) {
			System.out.print(area[i]);
		}
		System.out.println();*/
		switch (content) {
		case "size":
			List<List<Size>> sizeList = new ArrayList<List<Size>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<Size> areaSumSize = chartAnalysisService.getAreaSumSize(year, area[i]);
						if (areaSumSize != null && areaSumSize.size() > 0) {
							sizeList.add(areaSumSize);
						}
					}
					List<Size> provSumSize = chartAnalysisService.getAreaSumSize(year, null);
					if (provSumSize != null && provSumSize.size() > 0) {
						Iterator<Size> iterator = provSumSize.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						sizeList.add(provSumSize);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					//System.out.println(this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					List<Size> schoolSize = chartAnalysisService.getSchoolSize(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolSize != null && schoolSize.size() > 0) {
						Iterator<Size> iterator = schoolSize.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						sizeList.add(schoolSize);
					}
				}
			}
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<Size> areaAvgSize = chartAnalysisService.getAreaAvgSize(year, area[i]);
					if (areaAvgSize != null && areaAvgSize.size() > 0) {
						sizeList.add(areaAvgSize);
					}
				}
				List<Size> provSize = chartAnalysisService.getAreaAvgSize(year, null);
				if (provSize != null && provSize.size() > 0) {
					Iterator<Size> iterator = provSize.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					sizeList.add(provSize);
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(sizeList);	
		    String jsonString = jsonArray.toString(); 	            	        
		    //System.out.println(jsonString);
			model.addAttribute("dataList", jsonString);
			break;
		case "equitment":
			List<List<Equitment>> equitList = new ArrayList<List<Equitment>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<Equitment> areaSumEquitment = chartAnalysisService.getAreaSumEquitment(year, area[i]);
						if (areaSumEquitment != null && areaSumEquitment.size() > 0) {
							equitList.add(areaSumEquitment);
						}
					}
					List<Equitment> provSumEquitment = chartAnalysisService.getAreaSumEquitment(year, null);
					if (provSumEquitment != null && provSumEquitment.size() > 0) {
						Iterator<Equitment> iterator = provSumEquitment.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						equitList.add(provSumEquitment);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<Equitment> schoolEquitment = chartAnalysisService.getSchoolEquitment(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolEquitment != null && schoolEquitment.size() > 0) {
						Iterator<Equitment> iterator = schoolEquitment.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						equitList.add(schoolEquitment);
					}
				}
			}         	   
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<Equitment> areaAvgEquitment = chartAnalysisService.getAreaAvgEquitment(year, area[i]);
					if (areaAvgEquitment != null && areaAvgEquitment.size() > 0) {
						equitList.add(areaAvgEquitment);
					}
				}
				List<Equitment> provEquitment = chartAnalysisService.getAreaAvgEquitment(year, null);
				if (provEquitment != null && provEquitment.size() > 0) {
					Iterator<Equitment> iterator = provEquitment.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					equitList.add(provEquitment);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(equitList).toString());
			break;
		case "teachers":
			List<List<Teachers>> teachersList = new ArrayList<List<Teachers>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<Teachers> areaSumTeachers = chartAnalysisService.getAreaSumTeachers(year, area[i]);
						if (areaSumTeachers != null && areaSumTeachers.size() > 0) {
							teachersList.add(areaSumTeachers);
						}
					}
					List<Teachers> provTeachers = chartAnalysisService.getAreaSumTeachers(year, null);
					if (provTeachers != null && provTeachers.size() > 0) {
						Iterator<Teachers> iterator = provTeachers.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						teachersList.add(provTeachers);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<Teachers> schoolTeachers = chartAnalysisService.getSchoolTeachers(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolTeachers != null && schoolTeachers.size() > 0) {
						Iterator<Teachers> iterator = schoolTeachers.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						teachersList.add(schoolTeachers);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<Teachers> areaAvgTeachers = chartAnalysisService.getAreaAvgTeachers(year, area[i]);
					if (areaAvgTeachers != null && areaAvgTeachers.size() > 0) {
						teachersList.add(areaAvgTeachers);
					}
				}
				List<Teachers> provTeachers = chartAnalysisService.getAreaAvgTeachers(year, null);
				if (provTeachers != null && provTeachers.size() > 0) {
					Iterator<Teachers> iterator = provTeachers.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					teachersList.add(provTeachers);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(teachersList).toString());
			break;
		case "information":
			List<List<Information>> informationList = new ArrayList<List<Information>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<Information> areaSumInformation = chartAnalysisService.getAreaSumInformation(year, area[i]);
						if (areaSumInformation != null && areaSumInformation.size() > 0) {
							informationList.add(areaSumInformation);
						}
					}
					List<Information> provInformation = chartAnalysisService.getAreaSumInformation(year, null);
					if (provInformation != null && provInformation.size() > 0) {
						Iterator<Information> iterator = provInformation.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						informationList.add(provInformation);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<Information> schoolInformation = chartAnalysisService.getSchoolInformation(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolInformation != null && schoolInformation.size() > 0) {
						Iterator<Information> iterator = schoolInformation.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						informationList.add(schoolInformation);
					}
				}
			}      
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<Information> areaAvgInformation = chartAnalysisService.getAreaAvgInformation(year, area[i]);
					if (areaAvgInformation != null && areaAvgInformation.size() > 0) {
						informationList.add(areaAvgInformation);
					}
				}
				List<Information> provInformation = chartAnalysisService.getAreaAvgInformation(year, null);
				if (provInformation != null && provInformation.size() > 0) {
					Iterator<Information> iterator = provInformation.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					informationList.add(provInformation);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(informationList).toString());
			break;
		default:
			break;
		}

		model.addAttribute("year", JSONArray.fromObject(year).toString());
		model.addAttribute("content", content);
		model.addAttribute("target", JSONArray.fromObject(this.chartAnalysisService.getTargetNamesWithMeasure(target, content)).toString());
		model.addAttribute("targetField", JSONArray.fromObject(targetField).toString());
		
		model.addAttribute("yearlist", yearlist);
		model.addAttribute("targetlist", targetlist);
		model.addAttribute("arealist", arealist);
		model.addAttribute("schoollist", schoollist);
		model.addAttribute("average", average);
		
		return "/admin/basicChart";
	}
	
	@RequestMapping("/getStudentsChart")
	public String getStudentsChart(Model model,HttpServletRequest request,HttpServletResponse response){
		String content = request.getParameter("content"),
				yearlist = request.getParameter("year"),
				targetlist = request.getParameter("target"),
				arealist = request.getParameter("area"),
				schoollist = request.getParameter("school"),
				average = request.getParameter("average");
		if (yearlist == null || targetlist == null || arealist == null) {
			return "/admin/studentChart";
		}
		String[] year = yearlist.trim().split(",");
		String[] target = this.expandTarget(content, targetlist).trim().split(",");
		String[] targetField = this.chartAnalysisService.getTargetFields(target, content);
		String[] area = arealist.trim().split(",");
		
		switch (content) {
		case "studentquality":
			List<List<StudentQuality>> studentqualityList = new ArrayList<List<StudentQuality>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<StudentQuality> areaSumStudentQuality = chartAnalysisService.getAreaSumStudentQuality(year, area[i]);
						if (areaSumStudentQuality != null && areaSumStudentQuality.size() > 0) {
							studentqualityList.add(areaSumStudentQuality);
						}
					}
					List<StudentQuality> provStudentQuality = chartAnalysisService.getAreaSumStudentQuality(year, null);
					if (provStudentQuality != null && provStudentQuality.size() > 0) {
						Iterator<StudentQuality> iterator = provStudentQuality.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						studentqualityList.add(provStudentQuality);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<StudentQuality> schoolStudentQuality = chartAnalysisService.getSchoolStudentQuality(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolStudentQuality != null && schoolStudentQuality.size() > 0) {
						Iterator<StudentQuality> iterator = schoolStudentQuality.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						studentqualityList.add(schoolStudentQuality);
					}
				}
			}      
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<StudentQuality> areaAvgStudentQuality = chartAnalysisService.getAreaAvgStudentQuality(year, area[i]);
					if (areaAvgStudentQuality != null && areaAvgStudentQuality.size() > 0) {
						studentqualityList.add(areaAvgStudentQuality);
					}
				}
				List<StudentQuality> provStudentQuality = chartAnalysisService.getAreaAvgStudentQuality(year, null);
				if (provStudentQuality != null && provStudentQuality.size() > 0) {
					Iterator<StudentQuality> iterator = provStudentQuality.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					studentqualityList.add(provStudentQuality);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(studentqualityList).toString());
			break;
		case "experience":
			List<List<Experience>> experienceList = new ArrayList<List<Experience>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<Experience> areaSumExperience = chartAnalysisService.getAreaSumExperience(year, area[i]);
						if (areaSumExperience != null && areaSumExperience.size() > 0) {
							experienceList.add(areaSumExperience);
						}
					}
					List<Experience> provExperience = chartAnalysisService.getAreaSumExperience(year, null);
					if (provExperience != null && provExperience.size() > 0) {
						Iterator<Experience> iterator = provExperience.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						experienceList.add(provExperience);
					}
				}	
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<Experience> schoolExperience = chartAnalysisService.getSchoolExperience(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolExperience != null && schoolExperience.size() > 0) {
						Iterator<Experience> iterator = schoolExperience.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						experienceList.add(schoolExperience);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<Experience> areaAvgExperience = chartAnalysisService.getAreaAvgExperience(year, area[i]);
					if (areaAvgExperience != null && areaAvgExperience.size() > 0) {
						experienceList.add(areaAvgExperience);
					}
				}
				List<Experience> provExperience = chartAnalysisService.getAreaAvgExperience(year, null);
				if (provExperience != null && provExperience.size() > 0) {
					Iterator<Experience> iterator = provExperience.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					experienceList.add(provExperience);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(experienceList).toString());
			break;
		case "employquality":
			List<List<EmployQuality>> employqualityList = new ArrayList<List<EmployQuality>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<EmployQuality> areaSumEmployQuality = chartAnalysisService.getAreaSumEmployQuality(year, area[i]);
						if (areaSumEmployQuality != null && areaSumEmployQuality.size() > 0) {
							employqualityList.add(areaSumEmployQuality);
						}
					}
					List<EmployQuality> provEmployQuality = chartAnalysisService.getAreaSumEmployQuality(year, null);
					if (provEmployQuality != null && provEmployQuality.size() > 0) {
						Iterator<EmployQuality> iterator = provEmployQuality.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						employqualityList.add(provEmployQuality);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<EmployQuality> schoolEmployQuality = chartAnalysisService.getSchoolEmployQuality(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolEmployQuality != null && schoolEmployQuality.size() > 0) {
						Iterator<EmployQuality> iterator = schoolEmployQuality.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						employqualityList.add(schoolEmployQuality);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<EmployQuality> areaAvgEmployQuality = chartAnalysisService.getAreaAvgEmployQuality(year, area[i]);
					if (areaAvgEmployQuality != null && areaAvgEmployQuality.size() > 0) {
						employqualityList.add(areaAvgEmployQuality);
					}
				}
				List<EmployQuality> provEmployQuality = chartAnalysisService.getAreaAvgEmployQuality(year, null);
				if (provEmployQuality != null && provEmployQuality.size() > 0) {
					Iterator<EmployQuality> iterator = provEmployQuality.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					employqualityList.add(provEmployQuality);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(employqualityList).toString());
			break;
		default:
			break;
		}

		model.addAttribute("year", JSONArray.fromObject(year).toString());
		model.addAttribute("content", content);
		model.addAttribute("target", JSONArray.fromObject(this.chartAnalysisService.getTargetNamesWithMeasure(target, content)).toString());
		model.addAttribute("targetField", JSONArray.fromObject(targetField).toString());
		
		model.addAttribute("yearlist", yearlist);
		model.addAttribute("targetlist", targetlist);
		model.addAttribute("arealist", arealist);
		model.addAttribute("schoollist", schoollist);
		model.addAttribute("average", average);
		
		return "/admin/studentsChart";
	}
	
	@RequestMapping("/getQualityChart")
	public String getQualityChart(Model model,HttpServletRequest request,HttpServletResponse response){
		String content = request.getParameter("content"),
				yearlist = request.getParameter("year"),
				targetlist = request.getParameter("target"),
				arealist = request.getParameter("area"),
				schoollist = request.getParameter("school"),
				average = request.getParameter("average");
		if (yearlist == null || targetlist == null || arealist == null) {
			return "/admin/qualityChart";
		}
		String[] year = yearlist.trim().split(",");
		String[] target = this.expandTarget(content, targetlist).trim().split(",");
		String[] targetField = this.chartAnalysisService.getTargetFields(target, content);
		String[] area = arealist.trim().split(",");
		
		switch (content) {
		case "majorlayout":
			List<List<MajorLayout>> majorlayoutList = new ArrayList<List<MajorLayout>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<MajorLayout> areaSumMajorLayout = chartAnalysisService.getAreaSumMajorLayout(year, area[i]);
						if (areaSumMajorLayout != null && areaSumMajorLayout.size() > 0) {
							majorlayoutList.add(areaSumMajorLayout);
						}
					}
					List<MajorLayout> provMajorLayout = chartAnalysisService.getAreaSumMajorLayout(year, null);
					if (provMajorLayout != null && provMajorLayout.size() > 0) {
						Iterator<MajorLayout> iterator = provMajorLayout.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						majorlayoutList.add(provMajorLayout);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<MajorLayout> schoolMajorLayout = chartAnalysisService.getSchoolMajorLayout(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolMajorLayout != null && schoolMajorLayout.size() > 0) {
						Iterator<MajorLayout> iterator = schoolMajorLayout.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						majorlayoutList.add(schoolMajorLayout);
					}
				}
			}      
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<MajorLayout> areaAvgMajorLayout = chartAnalysisService.getAreaAvgMajorLayout(year, area[i]);
					if (areaAvgMajorLayout != null && areaAvgMajorLayout.size() > 0) {
						majorlayoutList.add(areaAvgMajorLayout);
					}
				}
				List<MajorLayout> provMajorLayout = chartAnalysisService.getAreaAvgMajorLayout(year, null);
				if (provMajorLayout != null && provMajorLayout.size() > 0) {
					Iterator<MajorLayout> iterator = provMajorLayout.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					majorlayoutList.add(provMajorLayout);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(majorlayoutList).toString());
			break;
		case "majornum":
			List<List<MajorNum>> majornumList = new ArrayList<List<MajorNum>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<MajorNum> areaSumMajorNum = chartAnalysisService.getAreaSumMajorNum(year, area[i]);
						if (areaSumMajorNum != null && areaSumMajorNum.size() > 0) {
							majornumList.add(areaSumMajorNum);
						}
					}
					List<MajorNum> provMajorNum = chartAnalysisService.getAreaSumMajorNum(year, null);
					if (provMajorNum != null && provMajorNum.size() > 0) {
						Iterator<MajorNum> iterator = provMajorNum.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						majornumList.add(provMajorNum);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<MajorNum> schoolMajorNum = chartAnalysisService.getSchoolMajorNum(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolMajorNum != null && schoolMajorNum.size() > 0) {
						Iterator<MajorNum> iterator = schoolMajorNum.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						majornumList.add(schoolMajorNum);
					}
				}
			}        
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<MajorNum> areaAvgMajorNum = chartAnalysisService.getAreaAvgMajorNum(year, area[i]);
					if (areaAvgMajorNum != null && areaAvgMajorNum.size() > 0) {
						majornumList.add(areaAvgMajorNum);
					}
				}
				List<MajorNum> provMajorNum = chartAnalysisService.getAreaAvgMajorNum(year, null);
				if (provMajorNum != null && provMajorNum.size() > 0) {
					Iterator<MajorNum> iterator = provMajorNum.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					majornumList.add(provMajorNum);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(majornumList).toString());
			break;
		case "qualityassure":
			List<List<QualityAssurance>> qualityassureList = new ArrayList<List<QualityAssurance>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<QualityAssurance> areaSumQualityAssurance = chartAnalysisService.getAreaSumQualityAssurance(year, area[i]);
						if (areaSumQualityAssurance != null && areaSumQualityAssurance.size() > 0) {
							qualityassureList.add(areaSumQualityAssurance);
						}
					}
					List<QualityAssurance> provQualityAssurance = chartAnalysisService.getAreaSumQualityAssurance(year, null);
					if (provQualityAssurance != null && provQualityAssurance.size() > 0) {
						Iterator<QualityAssurance> iterator = provQualityAssurance.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						qualityassureList.add(provQualityAssurance);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<QualityAssurance> schoolQualityAssurance = chartAnalysisService.getSchoolQualityAssurance(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolQualityAssurance != null && schoolQualityAssurance.size() > 0) {
						Iterator<QualityAssurance> iterator = schoolQualityAssurance.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						qualityassureList.add(schoolQualityAssurance);
					}
				}
			}       
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<QualityAssurance> areaAvgQualityAssurance = chartAnalysisService.getAreaAvgQualityAssurance(year, area[i]);
					if (areaAvgQualityAssurance != null && areaAvgQualityAssurance.size() > 0) {
						qualityassureList.add(areaAvgQualityAssurance);
					}
				}
				List<QualityAssurance> provQualityAssurance = chartAnalysisService.getAreaAvgQualityAssurance(year, null);
				if (provQualityAssurance != null && provQualityAssurance.size() > 0) {
					Iterator<QualityAssurance> iterator = provQualityAssurance.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					qualityassureList.add(provQualityAssurance);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(qualityassureList).toString());
			break;
		case "educationtrain":
			List<List<EducationTrain>> educationtrainList = new ArrayList<List<EducationTrain>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<EducationTrain> areaSumEducationTrain = chartAnalysisService.getAreaSumEducationTrain(year, area[i]);
						if (areaSumEducationTrain != null && areaSumEducationTrain.size() > 0) {
							educationtrainList.add(areaSumEducationTrain);
						}
					}
					List<EducationTrain> provEducationTrain = chartAnalysisService.getAreaSumEducationTrain(year, null);
					if (provEducationTrain != null && provEducationTrain.size() > 0) {
						Iterator<EducationTrain> iterator = provEducationTrain.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						educationtrainList.add(provEducationTrain);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<EducationTrain> schoolEducationTrain = chartAnalysisService.getSchoolEducationTrain(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolEducationTrain != null && schoolEducationTrain.size() > 0) {
						Iterator<EducationTrain> iterator = schoolEducationTrain.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						educationtrainList.add(schoolEducationTrain);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<EducationTrain> areaAvgEducationTrain = chartAnalysisService.getAreaAvgEducationTrain(year, area[i]);
					if (areaAvgEducationTrain != null && areaAvgEducationTrain.size() > 0) {
						educationtrainList.add(areaAvgEducationTrain);
					}
				}
				List<EducationTrain> provEducationTrain = chartAnalysisService.getAreaAvgEducationTrain(year, null);
				if (provEducationTrain != null && provEducationTrain.size() > 0) {
					Iterator<EducationTrain> iterator = provEducationTrain.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					educationtrainList.add(provEducationTrain);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(educationtrainList).toString());
			break;
		default:
			break;
		}

		model.addAttribute("year", JSONArray.fromObject(year).toString());
		model.addAttribute("content", content);
		model.addAttribute("target", JSONArray.fromObject(this.chartAnalysisService.getTargetNamesWithMeasure(target, content)).toString());
		model.addAttribute("targetField", JSONArray.fromObject(targetField).toString());
		
		model.addAttribute("yearlist", yearlist);
		model.addAttribute("targetlist", targetlist);
		model.addAttribute("arealist", arealist);
		model.addAttribute("schoollist", schoollist);
		model.addAttribute("average", average);
		
		return "/admin/qualityChart";
	}
	
	@RequestMapping("/getEnterpriseChart")
	public String getEnterpriseChart(Model model,HttpServletRequest request,HttpServletResponse response){
		String content = request.getParameter("content"),
				yearlist = request.getParameter("year"),
				targetlist = request.getParameter("target"),
				arealist = request.getParameter("area"),
				schoollist = request.getParameter("school"),
				average = request.getParameter("average");
		if (yearlist == null || targetlist == null || arealist == null) {
			return "/admin/enterpriseChart";
		}
		String[] year = yearlist.trim().split(",");
		String[] target = this.expandTarget(content, targetlist).trim().split(",");
		String[] targetField = this.chartAnalysisService.getTargetFields(target, content);
		String[] area = arealist.trim().split(",");
		
		switch (content) {
		case "schoolenterprise":
			List<List<Schoolenterprise>> schoolenterpriseList = new ArrayList<List<Schoolenterprise>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<Schoolenterprise> areaSumSchoolenterprise = chartAnalysisService.getAreaSumSchoolenterprise(year, area[i]);
						if (areaSumSchoolenterprise != null && areaSumSchoolenterprise.size() > 0) {
							schoolenterpriseList.add(areaSumSchoolenterprise);
						}
					}
					List<Schoolenterprise> provSchoolenterprise = chartAnalysisService.getAreaSumSchoolenterprise(year, null);
					if (provSchoolenterprise != null && provSchoolenterprise.size() > 0) {
						Iterator<Schoolenterprise> iterator = provSchoolenterprise.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						schoolenterpriseList.add(provSchoolenterprise);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<Schoolenterprise> schoolSchoolenterprise = chartAnalysisService.getSchoolSchoolenterprise(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolSchoolenterprise != null && schoolSchoolenterprise.size() > 0) {
						Iterator<Schoolenterprise> iterator = schoolSchoolenterprise.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						schoolenterpriseList.add(schoolSchoolenterprise);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<Schoolenterprise> areaAvgSchoolenterprise = chartAnalysisService.getAreaAvgSchoolenterprise(year, area[i]);
					if (areaAvgSchoolenterprise != null && areaAvgSchoolenterprise.size() > 0) {
						schoolenterpriseList.add(areaAvgSchoolenterprise);
					}
				}
				List<Schoolenterprise> provSchoolenterprise = chartAnalysisService.getAreaAvgSchoolenterprise(year, null);
				if (provSchoolenterprise != null && provSchoolenterprise.size() > 0) {
					Iterator<Schoolenterprise> iterator = provSchoolenterprise.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					schoolenterpriseList.add(provSchoolenterprise);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(schoolenterpriseList).toString());
			break;
		case "internship":
			List<List<Internship>> internshipList = new ArrayList<List<Internship>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<Internship> areaSumInternship = chartAnalysisService.getAreaSumInternship(year, area[i]);
						if (areaSumInternship != null && areaSumInternship.size() > 0) {
							internshipList.add(areaSumInternship);
						}
					}
					List<Internship> provInternship = chartAnalysisService.getAreaSumInternship(year, null);
					if (provInternship != null && provInternship.size() > 0) {
						Iterator<Internship> iterator = provInternship.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						internshipList.add(provInternship);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<Internship> schoolInternship = chartAnalysisService.getSchoolInternship(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolInternship != null && schoolInternship.size() > 0) {
						Iterator<Internship> iterator = schoolInternship.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						internshipList.add(schoolInternship);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<Internship> areaAvgInternship = chartAnalysisService.getAreaAvgInternship(year, area[i]);
					if (areaAvgInternship != null && areaAvgInternship.size() > 0) {
						internshipList.add(areaAvgInternship);
					}
				}
				List<Internship> provInternship = chartAnalysisService.getAreaAvgInternship(year, null);
				if (provInternship != null && provInternship.size() > 0) {
					Iterator<Internship> iterator = provInternship.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					internshipList.add(provInternship);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(internshipList).toString());
			break;
		case "groupschool":
			List<List<Groupschool>> groupschoolList = new ArrayList<List<Groupschool>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<Groupschool> areaSumGroupschool = chartAnalysisService.getAreaSumGroupschool(year, area[i]);
						if (areaSumGroupschool != null && areaSumGroupschool.size() > 0) {
							groupschoolList.add(areaSumGroupschool);
						}
					}
					List<Groupschool> provGroupschool = chartAnalysisService.getAreaSumGroupschool(year, null);
					if (provGroupschool != null && provGroupschool.size() > 0) {
						Iterator<Groupschool> iterator = provGroupschool.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						groupschoolList.add(provGroupschool);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<Groupschool> schoolGroupschool = chartAnalysisService.getSchoolGroupschool(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolGroupschool != null && schoolGroupschool.size() > 0) {
						Iterator<Groupschool> iterator = schoolGroupschool.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						groupschoolList.add(schoolGroupschool);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<Groupschool> areaAvgGroupschool = chartAnalysisService.getAreaAvgGroupschool(year, area[i]);
					if (areaAvgGroupschool != null && areaAvgGroupschool.size() > 0) {
						groupschoolList.add(areaAvgGroupschool);
					}
				}
				List<Groupschool> provGroupschool = chartAnalysisService.getAreaAvgGroupschool(year, null);
				if (provGroupschool != null && provGroupschool.size() > 0) {
					Iterator<Groupschool> iterator = provGroupschool.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					groupschoolList.add(provGroupschool);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(groupschoolList).toString());
			break;
		default:
			break;
		}

		model.addAttribute("year", JSONArray.fromObject(year).toString());
		model.addAttribute("content", content);
		model.addAttribute("target", JSONArray.fromObject(this.chartAnalysisService.getTargetNamesWithMeasure(target, content)).toString());
		model.addAttribute("targetField", JSONArray.fromObject(targetField).toString());
		
		model.addAttribute("yearlist", yearlist);
		model.addAttribute("targetlist", targetlist);
		model.addAttribute("arealist", arealist);
		model.addAttribute("schoollist", schoollist);
		model.addAttribute("average", average);
		
		return "/admin/enterpriseChart";
	}
	
	@RequestMapping("/getSocialChart")
	public String getSocialChart(Model model,HttpServletRequest request,HttpServletResponse response){
		String content = request.getParameter("content"),
				yearlist = request.getParameter("year"),
				targetlist = request.getParameter("target"),
				arealist = request.getParameter("area"),
				schoollist = request.getParameter("school"),
				average = request.getParameter("average");
		if (yearlist == null || targetlist == null || arealist == null) {
			return "/admin/socialChart";
		}
		String[] year = yearlist.trim().split(",");
		String[] target = this.expandTarget(content, targetlist).trim().split(",");
		String[] targetField = this.chartAnalysisService.getTargetFields(target, content);
		String[] area = arealist.trim().split(",");
		
		switch (content) {
		case "skilltrain":
			List<List<SkillTrain>> skilltrainList = new ArrayList<List<SkillTrain>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<SkillTrain> areaSumSkillTrain = chartAnalysisService.getAreaSumSkillTrain(year, area[i]);
						if (areaSumSkillTrain != null && areaSumSkillTrain.size() > 0) {
							skilltrainList.add(areaSumSkillTrain);
						}
					}
					List<SkillTrain> provSkillTrain = chartAnalysisService.getAreaSumSkillTrain(year, null);
					if (provSkillTrain != null && provSkillTrain.size() > 0) {
						Iterator<SkillTrain> iterator = provSkillTrain.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						skilltrainList.add(provSkillTrain);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<SkillTrain> schoolSkillTrain = chartAnalysisService.getSchoolSkillTrain(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolSkillTrain != null && schoolSkillTrain.size() > 0) {
						Iterator<SkillTrain> iterator = schoolSkillTrain.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						skilltrainList.add(schoolSkillTrain);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<SkillTrain> areaAvgSkillTrain = chartAnalysisService.getAreaAvgSkillTrain(year, area[i]);
					if (areaAvgSkillTrain != null && areaAvgSkillTrain.size() > 0) {
						skilltrainList.add(areaAvgSkillTrain);
					}
				}
				List<SkillTrain> provSkillTrain = chartAnalysisService.getAreaAvgSkillTrain(year, null);
				if (provSkillTrain != null && provSkillTrain.size() > 0) {
					Iterator<SkillTrain> iterator = provSkillTrain.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					skilltrainList.add(provSkillTrain);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(skilltrainList).toString());
			break;
		case "socialservice":
			List<List<SocialService>> socialserviceList = new ArrayList<List<SocialService>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<SocialService> areaSumSocialService = chartAnalysisService.getAreaSumSocialService(year, area[i]);
						if (areaSumSocialService != null && areaSumSocialService.size() > 0) {
							socialserviceList.add(areaSumSocialService);
						}
					}
					List<SocialService> provSocialService = chartAnalysisService.getAreaSumSocialService(year, null);
					if (provSocialService != null && provSocialService.size() > 0) {
						Iterator<SocialService> iterator = provSocialService.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						socialserviceList.add(provSocialService);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<SocialService> schoolSocialService = chartAnalysisService.getSchoolSocialService(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolSocialService != null && schoolSocialService.size() > 0) {
						Iterator<SocialService> iterator = schoolSocialService.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						socialserviceList.add(schoolSocialService);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<SocialService> areaAvgSocialService = chartAnalysisService.getAreaAvgSocialService(year, area[i]);
					if (areaAvgSocialService != null && areaAvgSocialService.size() > 0) {
						socialserviceList.add(areaAvgSocialService);
					}
				}
				List<SocialService> provSocialService = chartAnalysisService.getAreaAvgSocialService(year, null);
				if (provSocialService != null && provSocialService.size() > 0) {
					Iterator<SocialService> iterator = provSocialService.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					socialserviceList.add(provSocialService);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(socialserviceList).toString());
			break;
		case "counpasupp":
			List<List<CounpaSupp>> counpasuppList = new ArrayList<List<CounpaSupp>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<CounpaSupp> areaSumCounpaSupp = chartAnalysisService.getAreaSumCounpaSupp(year, area[i]);
						if (areaSumCounpaSupp != null && areaSumCounpaSupp.size() > 0) {
							counpasuppList.add(areaSumCounpaSupp);
						}
					}
					List<CounpaSupp> provCounpaSupp = chartAnalysisService.getAreaSumCounpaSupp(year, null);
					if (provCounpaSupp != null && provCounpaSupp.size() > 0) {
						Iterator<CounpaSupp> iterator = provCounpaSupp.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						counpasuppList.add(provCounpaSupp);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<CounpaSupp> schoolCounpaSupp = chartAnalysisService.getSchoolCounpaSupp(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolCounpaSupp != null && schoolCounpaSupp.size() > 0) {
						Iterator<CounpaSupp> iterator = schoolCounpaSupp.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						counpasuppList.add(schoolCounpaSupp);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<CounpaSupp> areaAvgCounpaSupp = chartAnalysisService.getAreaAvgCounpaSupp(year, area[i]);
					if (areaAvgCounpaSupp != null && areaAvgCounpaSupp.size() > 0) {
						counpasuppList.add(areaAvgCounpaSupp);
					}
				}
				List<CounpaSupp> provCounpaSupp = chartAnalysisService.getAreaAvgCounpaSupp(year, null);
				if (provCounpaSupp != null && provCounpaSupp.size() > 0) {
					Iterator<CounpaSupp> iterator = provCounpaSupp.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					counpasuppList.add(provCounpaSupp);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(counpasuppList).toString());
			break;
		default:
			break;
		}

		model.addAttribute("year", JSONArray.fromObject(year).toString());
		model.addAttribute("content", content);
		model.addAttribute("target", JSONArray.fromObject(this.chartAnalysisService.getTargetNamesWithMeasure(target, content)).toString());
		model.addAttribute("targetField", JSONArray.fromObject(targetField).toString());
		
		model.addAttribute("yearlist", yearlist);
		model.addAttribute("targetlist", targetlist);
		model.addAttribute("arealist", arealist);
		model.addAttribute("schoollist", schoollist);
		model.addAttribute("average", average);
		
		return "/admin/socialChart";
	}
	
	@RequestMapping("/getOrganizerChart")
	public String getOrganizerChart(Model model,HttpServletRequest request,HttpServletResponse response){
		String content = request.getParameter("content"),
				yearlist = request.getParameter("year"),
				targetlist = request.getParameter("target"),
				arealist = request.getParameter("area"),
				schoollist = request.getParameter("school"),
				average = request.getParameter("average");
		if (yearlist == null || targetlist == null || arealist == null) {
			return "/admin/organizerChart";
		}
		String[] year = yearlist.trim().split(",");
		String[] target = this.expandTarget(content, targetlist).trim().split(",");
		String[] targetField = this.chartAnalysisService.getTargetFields(target, content);
		String[] area = arealist.trim().split(",");
		
		switch (content) {
		case "funds":
			List<List<Funds>> fundsList = new ArrayList<List<Funds>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<Funds> areaSumFunds = chartAnalysisService.getAreaSumFunds(year, area[i]);
						if (areaSumFunds != null && areaSumFunds.size() > 0) {
							fundsList.add(areaSumFunds);
						}
					}
					List<Funds> provFunds = chartAnalysisService.getAreaSumFunds(year, null);
					if (provFunds != null && provFunds.size() > 0) {
						Iterator<Funds> iterator = provFunds.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						fundsList.add(provFunds);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<Funds> schoolFunds = chartAnalysisService.getSchoolFunds(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolFunds != null && schoolFunds.size() > 0) {
						Iterator<Funds> iterator = schoolFunds.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						fundsList.add(schoolFunds);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<Funds> areaAvgFunds = chartAnalysisService.getAreaAvgFunds(year, area[i]);
					if (areaAvgFunds != null && areaAvgFunds.size() > 0) {
						fundsList.add(areaAvgFunds);
					}
				}
				List<Funds> provFunds = chartAnalysisService.getAreaAvgFunds(year, null);
				if (provFunds != null && provFunds.size() > 0) {
					Iterator<Funds> iterator = provFunds.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					fundsList.add(provFunds);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(fundsList).toString());
			break;
		case "policy":
			List<List<Policy>> policyList = new ArrayList<List<Policy>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<Policy> areaSumPolicy = chartAnalysisService.getAreaSumPolicy(year, area[i]);
						if (areaSumPolicy != null && areaSumPolicy.size() > 0) {
							policyList.add(areaSumPolicy);
						}
					}
					List<Policy> provPolicy = chartAnalysisService.getAreaSumPolicy(year, null);
					if (provPolicy != null && provPolicy.size() > 0) {
						Iterator<Policy> iterator = provPolicy.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						policyList.add(provPolicy);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<Policy> schoolPolicy = chartAnalysisService.getSchoolPolicy(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolPolicy != null && schoolPolicy.size() > 0) {
						Iterator<Policy> iterator = schoolPolicy.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						policyList.add(schoolPolicy);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<Policy> areaAvgPolicy = chartAnalysisService.getAreaAvgPolicy(year, area[i]);
					if (areaAvgPolicy != null && areaAvgPolicy.size() > 0) {
						policyList.add(areaAvgPolicy);
					}
				}
				List<Policy> provPolicy = chartAnalysisService.getAreaAvgPolicy(year, null);
				if (provPolicy != null && provPolicy.size() > 0) {
					Iterator<Policy> iterator = provPolicy.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					policyList.add(provPolicy);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(policyList).toString());
			break;
		default:
			break;
		}

		model.addAttribute("year", JSONArray.fromObject(year).toString());
		model.addAttribute("content", content);
		model.addAttribute("target", JSONArray.fromObject(this.chartAnalysisService.getTargetNamesWithMeasure(target, content)).toString());
		model.addAttribute("targetField", JSONArray.fromObject(targetField).toString());
		
		model.addAttribute("yearlist", yearlist);
		model.addAttribute("targetlist", targetlist);
		model.addAttribute("arealist", arealist);
		model.addAttribute("schoollist", schoollist);
		model.addAttribute("average", average);
		
		return "/admin/organizerChart";
	}
	
	@RequestMapping("/getPartyBuildChart")
	public String getPartyBuildChart(Model model,HttpServletRequest request,HttpServletResponse response){
		String content = request.getParameter("content"),
				yearlist = request.getParameter("year"),
				targetlist = request.getParameter("target"),
				arealist = request.getParameter("area"),
				schoollist = request.getParameter("school"),
				average = request.getParameter("average");
		if (yearlist == null || targetlist == null || arealist == null) {
			return "/admin/partybuildChart";
		}
		String[] year = yearlist.trim().split(",");
		String[] target = this.expandTarget(content, targetlist).trim().split(",");
		String[] targetField = this.chartAnalysisService.getTargetFields(target, content);
		String[] area = arealist.trim().split(",");
		
		switch (content) {
		case "partybulid":
			List<List<Partybulid>> partybulidList = new ArrayList<List<Partybulid>>();
			if (schoollist == null || schoollist.equals("")) {
				if (average == null) {
					for (int i = 0; i < area.length; i++) {
						List<Partybulid> areaSumPartybulid = chartAnalysisService.getAreaSumPartybulid(year, area[i]);
						if (areaSumPartybulid != null && areaSumPartybulid.size() > 0) {
							partybulidList.add(areaSumPartybulid);
						}
					}
					List<Partybulid> provPartybulid = chartAnalysisService.getAreaSumPartybulid(year, null);
					if (provPartybulid != null && provPartybulid.size() > 0) {
						Iterator<Partybulid> iterator = provPartybulid.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode("省汇总值");
						}
						partybulidList.add(provPartybulid);
					}
				}
			}else {
				String[] school = schoollist.trim().split(",");
				for (int i = 0; i < school.length; i++) {
					//System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", ""));
					List<Partybulid> schoolPartybulid = chartAnalysisService.getSchoolPartybulid(year, this.chartAnalysisService.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));
					if (schoolPartybulid != null && schoolPartybulid.size() > 0) {
						Iterator<Partybulid> iterator = schoolPartybulid.iterator();
						while (iterator.hasNext()) {
							iterator.next().setAdmcode(school[i]);
						}
						partybulidList.add(schoolPartybulid);
					}
				}
			}    
			if (average != null) {
				for (int i = 0; i < area.length; i++) {
					List<Partybulid> areaAvgPartybulid = chartAnalysisService.getAreaAvgPartybulid(year, area[i]);
					if (areaAvgPartybulid != null && areaAvgPartybulid.size() > 0) {
						partybulidList.add(areaAvgPartybulid);
					}
				}
				List<Partybulid> provPartybulid = chartAnalysisService.getAreaAvgPartybulid(year, null);
				if (provPartybulid != null && provPartybulid.size() > 0) {
					Iterator<Partybulid> iterator = provPartybulid.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省平均值");
					}
					partybulidList.add(provPartybulid);
				}
			}
			model.addAttribute("dataList", JSONArray.fromObject(partybulidList).toString());
			break;
		default:
			break;
		}

		model.addAttribute("year", JSONArray.fromObject(year).toString());
		model.addAttribute("content", content);
		model.addAttribute("target", JSONArray.fromObject(this.chartAnalysisService.getTargetNamesWithMeasure(target, content)).toString());
		model.addAttribute("targetField", JSONArray.fromObject(targetField).toString());
		
		model.addAttribute("yearlist", yearlist);
		model.addAttribute("targetlist", targetlist);
		model.addAttribute("arealist", arealist);
		model.addAttribute("schoollist", schoollist);
		model.addAttribute("average", average);
		
		return "/admin/partybuildChart";
	}
	
	@RequestMapping("/getStandardChart")
	public String getStandardChart(Model model, HttpServletRequest request, HttpServletResponse response) {
		String content = request.getParameter("content"), yearlist = request.getParameter("year"),
				targetlist = request.getParameter("target"), arealist = request.getParameter("area"),
				schoollist = request.getParameter("school"), average = request.getParameter("average");
		if (yearlist == null || targetlist == null || arealist == null) {
			return "/admin/standardChart";
		}
		String[] year = yearlist.trim().split(",");
		String[] target = this.expandTarget(content, targetlist).trim().split(",");
		String[] targetField = this.chartAnalysisService.getTargetFields(target, content);
		String[] area = arealist.trim().split(",");

		List<List<Standard>> standardList = new ArrayList<List<Standard>>();
		List<Standard> stateStandard = new ArrayList<>();//国家标准
		for (int i = 0; i < year.length; i++) {
			Standard temp = new Standard();
			temp.setAdmcode("国家标准值");
			temp.setYear(year[i]);
			temp.setStudent(1200);
			temp.setTeacher(60);
			temp.setTsRatio(new BigDecimal(0.05));
			temp.setDoubleTeacher(new BigDecimal(0.3));
			temp.setPartTimeTeacher(new BigDecimal(0.2));
			temp.setArea(new BigDecimal(40000));
			temp.setStuArea(new BigDecimal(33));
			temp.setBuildArea(new BigDecimal(24000));
			temp.setStuBuildArea(new BigDecimal(20));
			temp.setStuBook(new BigDecimal(30));
			temp.setComputer(new BigDecimal(15));
			stateStandard.add(temp);
		}
		if (schoollist == null || schoollist.equals("")) {
			if (average == null) {
				for (int i = 0; i < area.length; i++) {
					List<Standard> areaSumStandard = chartAnalysisService.getAreaSumStandard(year, area[i]);//各市汇总值
					if (areaSumStandard != null && areaSumStandard.size() > 0) {
						standardList.add(areaSumStandard);
					}
				}
				List<Standard> provStandard = chartAnalysisService.getAreaSumStandard(year, null);//省汇总值
				if (provStandard != null && provStandard.size() > 0) {
					Iterator<Standard> iterator = provStandard.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode("省汇总值");
					}
					standardList.add(provStandard);
				}
			}else {
				standardList.add(stateStandard);
			}
		} else {
			standardList.add(stateStandard);
			String[] school = schoollist.trim().split(",");
			for (int i = 0; i < school.length; i++) {
				// System.out.println(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)",
				// ""));
				List<Standard> schoolStandard = chartAnalysisService.getSchoolStandard(year, this.chartAnalysisService
						.getSchoolCode(school[i].replaceFirst("(\\(|（)[\u0391-\uFFE5]+(\\)|）)", "")));//各校指标值
				if (schoolStandard != null && schoolStandard.size() > 0) {
					Iterator<Standard> iterator = schoolStandard.iterator();
					while (iterator.hasNext()) {
						iterator.next().setAdmcode(school[i]);
					}
					standardList.add(schoolStandard);
				}
			}
		}
		if (average != null) {
			for (int i = 0; i < area.length; i++) {
				List<Standard> areaAvgStandard = chartAnalysisService.getAreaAvgStandard(year, area[i]);//各市平均值
				if (areaAvgStandard != null && areaAvgStandard.size() > 0) {
					standardList.add(areaAvgStandard);
				}
			}
			List<Standard> provStandard = chartAnalysisService.getAreaAvgStandard(year, null);//省平均值
			if (provStandard != null && provStandard.size() > 0) {
				Iterator<Standard> iterator = provStandard.iterator();
				while (iterator.hasNext()) {
					iterator.next().setAdmcode("省平均值");
				}
				standardList.add(provStandard);
			}
		}
		model.addAttribute("dataList", JSONArray.fromObject(standardList).toString());

		model.addAttribute("year", JSONArray.fromObject(year).toString());
		model.addAttribute("target", JSONArray.fromObject(this.chartAnalysisService.getTargetNamesWithMeasure(target, content)).toString());
		model.addAttribute("targetField", JSONArray.fromObject(targetField).toString());

		model.addAttribute("yearlist", yearlist);
		model.addAttribute("targetlist", targetlist);
		model.addAttribute("arealist", arealist);
		model.addAttribute("schoollist", schoollist);
		model.addAttribute("average", average);

		return "/admin/standardChart";
	}
	
	@RequestMapping("getArea")
	public void getArea(HttpServletResponse response) {
		List<User> userList = getCityListService.getCityList();
		List<String> cityList = new ArrayList<String>();
		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			cityList.add(iterator.next().getSchoolname());
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(JSONArray.fromObject(cityList).toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("getTarget")
	public void getTarget(String name, HttpServletResponse response) {
		List<TargetName> targetList = chartAnalysisService.getTargetList(name);
		List<String> nameList = new ArrayList<String>();
		Iterator<TargetName> iterator = targetList.iterator();
		while (iterator.hasNext()) {
			TargetName target = (TargetName) iterator.next();
			if (!target.getField().equals("admcode") && !target.getField().equals("schoolRun") &&
					!target.getField().equals("schoolLevel") && !target.getField().equals("schoolSubject")) {
				nameList.add(target.getName());	
			}
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = null;
		try {
			out = response.getWriter();
			//System.out.println(JSONArray.fromObject(nameList).toString());
			out.write(this.conpressTarget(name, JSONArray.fromObject(nameList).toString()));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String expandTarget(String source, String target) {
		String dest = target;
		switch (source) {
		case "size":
			if (dest.indexOf("建筑面积") == 0) {
				dest = dest.replaceFirst("建筑面积", "总建筑面积,教学及辅助用房面积,校内实训用房面积,心理咨询室建筑面积,学生宿舍面积");
			}else {
				dest = dest.replaceFirst(",建筑面积", ",总建筑面积,教学及辅助用房面积,校内实训用房面积,心理咨询室建筑面积,学生宿舍面积");
			}
			break;
		case "equitment":
			if (dest.indexOf("资产值") == 0) {
				dest = dest.replaceFirst("资产值", "固定资产总值,教学设备资产值,实训设备资产值");
			}else {
				dest = dest.replace("资产值", "固定资产总值,教学设备资产值,实训设备资产值");
			}
			dest = dest.replaceFirst(",资产值", ",固定资产总值,教学设备资产值,实训设备资产值");
			break;
		case "teachers":
			dest = dest.replace("专任教师数", "专任教师数,公共基础课专任教师数,专业课专任教师数,本科以下学历专任教师数,本科学历专任教师数,"
					+ "具有研究生学历或学位的专任教师数,高级职称专任教师数,中级职称专任教师数,初级职称专任教师数,未评职称专任教师数,"
					+ "35岁及以下专任教师数,36～45岁专任教师数,46～55岁专任教师数,56岁及以上专任教师数");
            break;
		case "studentquality":
			dest = dest.replace("学生操行考核比例", "学生操行考核优的比例,学生操行考核良的比例,学生操行考核中的比例,学生操行考核差的比例");
			dest = dest.replace("学生参加文明风采大赛获奖人数", "学生参加文明风采大赛获奖人数(国家级),学生参加文明风采大赛获奖人数(省级),学生参加文明风采大赛获奖人数(市级)");
			dest = dest.replace("参与国家级技能竞赛获奖人数", "参与国家级技能竞赛获得一等奖人数,参与国家级技能竞赛获得二等奖人数,参与国家级技能竞赛获得三等奖人数");
			dest = dest.replace("参与省级技能竞赛获奖人数", "参与省级技能竞赛获得一等奖人数,参与省级技能竞赛获得二等奖人数,参与省级技能竞赛获得三等奖人数");
			dest = dest.replace("参与市级技能竞赛获奖人数", "参与市级技能竞赛获得一等奖人数,参与市级技能竞赛获得二等奖人数,参与市级技能竞赛获得三等奖人数");
			break;
		case "experience":
			dest = dest.replace("理论学习满意度", "理论学习满意度-非常满意,理论学习满意度-基本满意,理论学习满意度-不满意");
			dest = dest.replace("专业学习满意度", "专业学习满意度-非常满意,专业学习满意度-基本满意,专业学习满意度-不满意");
			dest = dest.replace("实习实训满意度", "实习实训满意度-非常满意,实习实训满意度-基本满意,实习实训满意度-不满意");
			dest = dest.replace("校园文化与社团活动满意度", "校园文化与社团活动满意度-非常满意,校园文化与社团活动满意度-基本满意,校园文化与社团活动满意度-不满意");
			dest = dest.replace("生活满意度", "生活满意度-非常满意,生活满意度-基本满意,生活满意度-不满意");
			dest = dest.replace("校园安全满意度", "校园安全满意度-非常满意,校园安全满意度-基本满意,校园安全满意度-不满意");
			dest = dest.replace("毕业生对学校满意度", "毕业生对学校满意度-非常满意,毕业生对学校满意度-基本满意,毕业生对学校满意度-不满意");
			break;
		case "employquality":
			dest = dest.replace("企业服务比例", "到国有企业事业单位服务比例,到民营企业服务比例,到外资企业服务比例");
			dest = dest.replace("产业就业比例", "到第一产业就业比例,到第二产业就业比例,到第三产业就业比例");
			dest = dest.replace("签订就业合同比例", "签订一年及以内就业合同比例,签订一年以上就业合同比例");
			break;
		case "majorlayout":
			dest = dest.replace("产业专业数", "一产类专业数,二产类专业数,三产类专业数");
			break;
		case "qualityassure":
			dest = dest.replace("教师教学质量考核比例", "教师教学质量考核-优秀比例,教师教学质量考核-合格比例,教师教学质量考核-不合格比例");
			dest = dest.replace("学生参加国家级技能大赛人数", "学生参加国家级技能大赛人数,国家级技能大赛一等奖获得人数,国家级技能大赛二等奖获得人数,国家级技能大赛三等奖获得人数");
			dest = dest.replace("学生参加省级技能大赛人数", "学生参加省级技能大赛人数,省级技能大赛一等奖获得人数,省级技能大赛二等奖获得人数,省级技能大赛三等奖获得人数");
			dest = dest.replace("学生参加市级技能大赛人数", "学生参加市级技能大赛人数,市级技能大赛一等奖获得人数,市级技能大赛二等奖获得人数,市级技能大赛三等奖获得人数");
			break;
		case "educationtrain":
			dest = dest.replace("教师参加国家级教学或技能大赛人数", "教师参加国家级教学或技能大赛人数,国家级技能大赛一等奖获得人数,国家级技能大赛二等奖获得人数,国家级技能大赛三等奖获得人数");
			dest = dest.replace("教师参加省级教学或技能大赛人数", "教师参加省级教学或技能大赛人数,省级技能大赛一等奖获得人数,省级技能大赛二等奖获得人数,省级技能大赛三等奖获得人数");
			dest = dest.replace("教师参加市级教学或技能大赛人数", "教师参加市级教学或技能大赛人数,市级技能大赛一等奖获得人数,市级技能大赛二等奖获得人数,市级技能大赛三等奖获得人数");
			break;
		case "internship":
			dest = dest.replace("企业对学生顶岗实习考核结果", "企业对学生顶岗实习考核结果(优秀)比例,企业对学生顶岗实习考核结果(良好)比例,企业对学生顶岗实习考核结果(合格)比例,企业对学生顶岗实习考核结果(不合格)比例");
			break;
		case "partybulid":
			dest = dest.replace("获优秀表彰的党员数", "获国家级优秀表彰的党员数,获省级优秀表彰的党员数,获市级优秀表彰的党员数");
			dest = dest.replace("获优秀表彰的党组织数", "获国家级优秀表彰的党组织数,获省级优秀表彰的党组织数,获市级优秀表彰的党组织数");
			break;
		default:
			break;
		}
		return dest;
	}
	
	public String conpressTarget(String source, String target) {
		String dest = target;
		switch (source) {
		case "size":
			dest = dest.replace("总建筑面积", "建筑面积");
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*用房面积[\\u0391-\\uFFE5]*\"", "");
			dest = dest.replace(",\"心理咨询室建筑面积\"", "");
			dest = dest.replace(",\"学生宿舍面积\"", "");
			break;
		case "equitment":
			dest = dest.replace("固定资产总值", "资产值");
			dest = dest.replace(",\"教学设备资产值\"", "");
			dest = dest.replace(",\"实训设备资产值\"", "");
			break;
		case "teachers":
			dest = dest.replaceFirst("[\u0391-\uFFE5]*专任教师数[\\u0391-\\uFFE5]*", "first");
			dest = dest.replaceAll(",\"(\\d+.)?\\d*[\u0391-\uFFE5]*专任教师数[\\u0391-\\uFFE5]*\"", "rest");
			dest = dest.replace("first", "专任教师数");
			dest = dest.replace("rest", "");
            break;
		case "studentquality":
			dest = dest.replaceFirst("[\u0391-\uFFE5]*学生操行考核[\\u0391-\\uFFE5]*", "first");
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*学生操行考核[\\u0391-\\uFFE5]*\"", "rest");
			dest = dest.replace("first", "学生操行考核比例");
			dest = dest.replace("rest", "");
			
			dest = dest.replaceFirst("[\u0391-\uFFE5]*文明风采大赛.*\\)", "first");
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*文明风采大赛.*\\)", "rest");
			dest = dest.replace("first", "学生参加文明风采大赛获奖人数");
			dest = dest.replace("rest", "");
			
			dest = dest.replaceFirst("[\u0391-\uFFE5]*国家级技能竞赛[\\u0391-\\uFFE5]*", "first");
			dest = dest.replaceFirst("[\u0391-\uFFE5]*省级技能竞赛[\\u0391-\\uFFE5]*", "second");
			dest = dest.replaceFirst("[\u0391-\uFFE5]*市级技能竞赛[\\u0391-\\uFFE5]*", "third");
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*技能竞赛[\\u0391-\\uFFE5]*\"", "rest");
			dest = dest.replace("first", "参与国家级技能竞赛获奖人数");
			dest = dest.replace("second", "参与省级技能竞赛获奖人数");
			dest = dest.replace("third", "参与市级技能竞赛获奖人数");
			dest = dest.replace("rest", "");
			break;
		case "experience":
			dest = dest.replaceFirst("[\u0391-\uFFE5]*理论学习满意度-[\\u0391-\\uFFE5]*", "first");
			dest = dest.replaceFirst("[\u0391-\uFFE5]*专业学习满意度-[\\u0391-\\uFFE5]*", "second");
			dest = dest.replaceFirst("[\u0391-\uFFE5]*实习实训满意度-[\\u0391-\\uFFE5]*", "third");
			dest = dest.replaceFirst("[\u0391-\uFFE5]*校园文化与社团活动满意度-[\\u0391-\\uFFE5]*", "fourth");
			dest = dest.replaceFirst("[\u0391-\uFFE5]*生活满意度-[\\u0391-\\uFFE5]*", "fifth");
			dest = dest.replaceFirst("[\u0391-\uFFE5]*校园安全满意度-[\\u0391-\\uFFE5]*", "sixth");
			dest = dest.replaceFirst("[\u0391-\uFFE5]*毕业生对学校满意度-[\\u0391-\\uFFE5]*", "seventh");
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*满意度-[\\u0391-\\uFFE5]*\"", "rest");	
			dest = dest.replace("first", "理论学习满意度");
			dest = dest.replace("second", "专业学习满意度");
			dest = dest.replace("third", "实习实训满意度");
			dest = dest.replace("fourth", "校园文化与社团活动满意度");
			dest = dest.replace("fifth", "生活满意度");
			dest = dest.replace("sixth", "校园安全满意度");
			dest = dest.replace("seventh", "毕业生对学校满意度");
			dest = dest.replace("rest", "");
			break;
		case "employquality":
			dest = dest.replaceFirst("[\u0391-\uFFE5]*服务比例[\\u0391-\\uFFE5]*", "first");
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*服务比例[\\u0391-\\uFFE5]*\"", "rest");
			dest = dest.replace("first", "企业服务比例");
			dest = dest.replace("rest", "");
			
			dest = dest.replaceFirst("[\u0391-\uFFE5]*产业就业比例[\\u0391-\\uFFE5]*", "first");
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*产业就业比例[\\u0391-\\uFFE5]*\"", "rest");
			dest = dest.replace("first", "产业就业比例");
			dest = dest.replace("rest", "");
			
			dest = dest.replaceFirst("[\u0391-\uFFE5]*就业合同比例[\\u0391-\\uFFE5]*", "first");
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*就业合同比例[\\u0391-\\uFFE5]*\"", "rest");
			dest = dest.replace("first", "签订就业合同比例");
			dest = dest.replace("rest", "");
		break;
		case "majorlayout":
			dest = dest.replaceFirst("[\u0391-\uFFE5]*产类专业数[\\u0391-\\uFFE5]*", "first");
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*产类专业数[\\u0391-\\uFFE5]*\"", "rest");
			dest = dest.replace("first", "产业专业数");
			dest = dest.replace("rest", "");
			break;
		case "qualityassure":
			dest = dest.replaceFirst("[\u0391-\uFFE5]*教师教学质量考核-[\\u0391-\\uFFE5]*", "first");
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*教师教学质量考核-[\\u0391-\\uFFE5]*\"", "rest");
			dest = dest.replace("first", "教师教学质量考核比例");
			dest = dest.replace("rest", "");
			
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*获得人数[\\u0391-\\uFFE5]*\"", "");
			break;
		case "educationtrain":
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*获得人数[\\u0391-\\uFFE5]*\"", "");
			break;
		case "internship":
			dest = dest.replaceFirst("[\u0391-\uFFE5]*实习考核结果.*\\)比例", "first");
			dest = dest.replaceAll(",\"[\\u0391-\\uFFE5]*实习考核结果.*\\)比例\"", "rest");
			dest = dest.replace("first", "企业对学生顶岗实习考核结果");
			dest = dest.replace("rest", "");
			break;
		case "partybulid":
			dest = dest.replaceFirst("[\u0391-\uFFE5]*优秀表彰的党员数[\\u0391-\\uFFE5]*", "first");
			dest = dest.replaceFirst("[\u0391-\uFFE5]*优秀表彰的党组织数[\\u0391-\\uFFE5]*", "second");
			dest = dest.replaceAll(",\"[\u0391-\uFFE5]*优秀表彰[\\u0391-\\uFFE5]*\"", "rest");
			dest = dest.replace("first", "获优秀表彰的党员数");
			dest = dest.replace("second", "获优秀表彰的党组织数");
			dest = dest.replace("rest", "");
			break;
		default:
			break;
		}
		return dest;
	}
	
	@RequestMapping("getSchool")
	public void getSchool(HttpServletRequest request, HttpServletResponse response) {
		String arealist = request.getParameter("arealist"), typelist = request.getParameter("typelist");
		if (arealist == null || typelist == null) {
			return;
		}
		//System.out.println(arealist);
		//System.out.println(typelist);
		String[] area = arealist.trim().split(",");
		String[] type = typelist.trim().split(",");
		Map<String, String> schoolMap;
		List<Map<String, String>> schoolList = new ArrayList<>();
		for (int i = 0; i < type.length; i++) {
			for (int j = 0; j < area.length; j++) {
				List<String> tempList = this.chartAnalysisService.getSchoolList(area[j], type[i]);
				if (tempList != null) {
					Iterator<String> iterator = tempList.iterator();
					while (iterator.hasNext()) {
						String school = (String) iterator.next();
						schoolMap = new HashMap<>();
						if (area[j].equals("")) {
							schoolMap.put("name", this.chartAnalysisService.getSchoolName(school));
						}else {
							schoolMap.put("name", "("+area[j].replaceAll("\\d+", "")+"市)"+ this.chartAnalysisService.getSchoolName(school));
						}
						schoolMap.put("type", type[i]);
						schoolList.add(schoolMap);
					}
				}
			}
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(JSONArray.fromObject(schoolList).toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
