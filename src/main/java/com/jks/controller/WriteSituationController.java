package com.jks.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jks.entity.WriteSituation;
import com.jks.service.WriteSituationService;

@Controller
@RequestMapping("/writeSituation")
public class WriteSituationController {
	@Autowired
	private WriteSituationService writeSituationService;
	
	@RequestMapping("/getWriteSituation")
	public String getWriteSituation(@RequestParam(value = "pn", defaultValue = "1") Integer pagenum,
									HttpServletRequest request,Model model){
		
		
		Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
		String year = (String) param.get("year");
		String schoolName = (String) param.get("schoolName");
		String years = (String) param.get("years");
		String schoolNames = (String) param.get("schoolNames");
		
		param.remove("year");
		param.remove("schoolName");
		param.remove("years");
		param.remove("schoolNames");
		
		String s = null,y;		
		
		if(null==year&&(null==schoolName||"".equals(schoolName))){
			if(schoolNames!=null){
				try {
					s = new String(schoolNames.getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}else{
				s=schoolNames;
			}
			y=years;
		}else{
			s=schoolName;
			y=year;
		}
		
		if(null==y||"".equals(y)){
			Date date = new Date();
			DateFormat format=new SimpleDateFormat("yyyy");
			y = format.format(date);
		}
		
		PageHelper.startPage(pagenum, 12);
		List<WriteSituation> writeSituation = writeSituationService.getWriteSituationNull(s);
		
		List<WriteSituation> writeSituations = writeSituationService.getWriteSituation(y,s);
		
		for(int i=0;i<writeSituation.size();i++){
			for(int j=0;j<writeSituations.size();j++){
				if(writeSituation.get(i).getSchoolName().equals(writeSituations.get(j).getSchoolName())){
					writeSituation.set(i, writeSituations.get(j));
				}
			}
			
			int zero = 0, one = 0, empty = 0;			
			
			if(0==writeSituation.get(i).getCounpasuppAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getCounpasuppAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getEducationAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getEducationAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getEmployqualityAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getEmployqualityAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getEquitmentAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getEquitmentAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getExperienceAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getExperienceAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getFundsAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getFundsAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getGroupschoolAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getGroupschoolAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getInformationAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getInformationAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getInternshipAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getInternshipAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getMajorlayoutAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getMajorlayoutAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getMajornumAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getMajornumAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getPartybulidAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getPartybulidAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getPolicyAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getPolicyAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getQualityassureAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getQualityassureAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getSchoolenterpriseAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getSchoolenterpriseAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getSizeAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getSizeAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getSkilltrainAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getSkilltrainAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getSocialserviceAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getSocialserviceAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getStudentqualityAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getStudentqualityAudit()){
				one++;
			}else{
				empty++;
			}
			
			if(0==writeSituation.get(i).getTeachersAudit()){
				zero++;
			}else if(1<=writeSituation.get(i).getTeachersAudit()){
				one++;
			}else{
				empty++;
			}
			
			writeSituation.get(i).setZero(zero);
			writeSituation.get(i).setOne(one);
			writeSituation.get(i).setEmptys(empty);
			writeSituation.get(i).setYear(y);
		}
			
		PageInfo writeSituationPageInfo = new PageInfo(writeSituation, 5);	
		model.addAttribute("writeSituationPageInfo", writeSituationPageInfo);
		model.addAttribute("schoolName", s);
		model.addAttribute("year", y);
		
		return "/admin/writeSituation";		
	}
	
	@RequestMapping("/getWriteSituationDetail")
	public String getWriteSituationDetail(Model model,String schoolName,String year){
		try {
			schoolName = new String(schoolName.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		List<WriteSituation> writeSituation = writeSituationService.getWriteSituation(year,schoolName);	
		
		if(CollectionUtils.isNotEmpty(writeSituation)){			
			model.addAttribute("writeSituation", writeSituation.get(0));
		}else if(CollectionUtils.isEmpty(writeSituation)){				
			WriteSituation writeSituations = new WriteSituation(); 
			writeSituations.setSchoolName(schoolName);
			writeSituations.setYear(year);
			model.addAttribute("writeSituation", writeSituations);
		}
				
		return "/admin/writeSituationDetail";
		
	}

}
