package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QualityAssurance {
	
	private int id;
	
	private String admcode;
	
	private String year;
	
	private String city;
	
	private BigDecimal leaderListen;
	
	private BigDecimal leaderTalk;
	
	private String schoolWell;
	
	private String schoolGood;
	
	private String schoolBad;
	
	private int stateClass;
	
	private int provinClass;
	
	private int cityClass;
	
	private String chinese;
	
	private String math;
	
	private String english;

	private int stateSkillWinTime;

	private int stateFirstAward;

	private int stateSecondAward;

	private int stateThridAward;

	private int provinSkillWinTime;

	private int provinFirstAward;

	private int provinSecondAward;

	private int provinThirdAward;

	private int citySkillWinTime;

	private int cityFirstAward;

	private int citySecondAward;

	private int cityThirdAward;

	private int audit;	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdmcode() {
		return admcode;
	}

	public void setAdmcode(String admcode) {
		this.admcode = admcode;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public BigDecimal getLeaderListen() {
		return leaderListen;
	}

	public void setLeaderListen(BigDecimal leaderListen) {
		this.leaderListen = leaderListen;
	}

	public BigDecimal getLeaderTalk() {
		return leaderTalk;
	}

	public void setLeaderTalk(BigDecimal leaderTalk) {
		this.leaderTalk = leaderTalk;
	}

	public String getSchoolWell() {
		return schoolWell;
	}

	public void setSchoolWell(String schoolWell) {
		this.schoolWell = schoolWell;
	}

	public String getSchoolGood() {
		return schoolGood;
	}

	public void setSchoolGood(String schoolGood) {
		this.schoolGood = schoolGood;
	}

	public String getSchoolBad() {
		return schoolBad;
	}

	public void setSchoolBad(String schoolBad) {
		this.schoolBad = schoolBad;
	}

	public int getStateClass() {
		return stateClass;
	}

	public void setStateClass(int stateClass) {
		this.stateClass = stateClass;
	}

	public int getProvinClass() {
		return provinClass;
	}

	public void setProvinClass(int provinClass) {
		this.provinClass = provinClass;
	}

	public int getCityClass() {
		return cityClass;
	}

	public void setCityClass(int cityClass) {
		this.cityClass = cityClass;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public int getStateSkillWinTime() {
		return stateSkillWinTime;
	}

	public void setStateSkillWinTime(int stateSkillWinTime) {
		this.stateSkillWinTime = stateSkillWinTime;
	}

	public int getStateFirstAward() {
		return stateFirstAward;
	}

	public void setStateFirstAward(int stateFirstAward) {
		this.stateFirstAward = stateFirstAward;
	}

	public int getStateSecondAward() {
		return stateSecondAward;
	}

	public void setStateSecondAward(int stateSecondAward) {
		this.stateSecondAward = stateSecondAward;
	}

	public int getStateThridAward() {
		return stateThridAward;
	}

	public void setStateThridAward(int stateThridAward) {
		this.stateThridAward = stateThridAward;
	}

	public int getProvinSkillWinTime() {
		return provinSkillWinTime;
	}

	public void setProvinSkillWinTime(int provinSkillWinTime) {
		this.provinSkillWinTime = provinSkillWinTime;
	}

	public int getProvinFirstAward() {
		return provinFirstAward;
	}

	public void setProvinFirstAward(int provinFirstAward) {
		this.provinFirstAward = provinFirstAward;
	}

	public int getProvinSecondAward() {
		return provinSecondAward;
	}

	public void setProvinSecondAward(int provinSecondAward) {
		this.provinSecondAward = provinSecondAward;
	}

	public int getProvinThirdAward() {
		return provinThirdAward;
	}

	public void setProvinThirdAward(int provinThirdAward) {
		this.provinThirdAward = provinThirdAward;
	}

	public int getCitySkillWinTime() {
		return citySkillWinTime;
	}

	public void setCitySkillWinTime(int citySkillWinTime) {
		this.citySkillWinTime = citySkillWinTime;
	}

	public int getCityFirstAward() {
		return cityFirstAward;
	}

	public void setCityFirstAward(int cityFirstAward) {
		this.cityFirstAward = cityFirstAward;
	}

	public int getCitySecondAward() {
		return citySecondAward;
	}

	public void setCitySecondAward(int citySecondAward) {
		this.citySecondAward = citySecondAward;
	}

	public int getCityThirdAward() {
		return cityThirdAward;
	}

	public void setCityThirdAward(int cityThirdAward) {
		this.cityThirdAward = cityThirdAward;
	}

	public int getAudit() {
		return audit;
	}

	public void setAudit(int audit) {
		this.audit = audit;
	}

	@Override
	public String toString() {
		return "QualityAssurance [id=" + id + ", admcode=" + admcode
				+ ", year=" + year + ", city=" + city + ", leaderListen="
				+ leaderListen + ", leaderTalk=" + leaderTalk + ", schoolWell="
				+ schoolWell + ", schoolGood=" + schoolGood + ", schoolBad="
				+ schoolBad + ", stateClass=" + stateClass + ", provinClass="
				+ provinClass + ", cityClass=" + cityClass + ", chinese="
				+ chinese + ", math=" + math + ", english=" + english
				+ ", stateSkillWinTime=" + stateSkillWinTime
				+ ", stateFirstAward=" + stateFirstAward
				+ ", stateSecondAward=" + stateSecondAward
				+ ", stateThridAward=" + stateThridAward
				+ ", provinSkillWinTime=" + provinSkillWinTime
				+ ", provinFirstAward=" + provinFirstAward
				+ ", provinSecondAward=" + provinSecondAward
				+ ", provinThirdAward=" + provinThirdAward
				+ ", citySkillWinTime=" + citySkillWinTime
				+ ", cityFirstAward=" + cityFirstAward + ", citySecondAward="
				+ citySecondAward + ", cityThirdAward=" + cityThirdAward
				+ ", audit=" + audit + "]";
	}
	
	public static List<QualityAssurance> sum(List<QualityAssurance> qualityAssuranceList) {
		if (qualityAssuranceList == null) {
			return qualityAssuranceList;
		}
		List<QualityAssurance> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<QualityAssurance> itQualityAssurance = qualityAssuranceList.iterator();
		boolean exist;
		while (itQualityAssurance.hasNext()) {
			exist = false;
			QualityAssurance qualityAssurance = (QualityAssurance) itQualityAssurance.next();
			for(int i = 0; i < sumList.size(); i ++){
				QualityAssurance sum = sumList.get(i);
				if (sum.getYear().equals(qualityAssurance.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);					
					sum.setLeaderListen(sum.leaderListen.add(qualityAssurance.leaderListen));
					sum.setLeaderTalk(sum.leaderTalk.add(qualityAssurance.leaderTalk));					
					String sumSchoolWell = sum.schoolWell.replace("%", ""),
						   qualityAssuranceSchoolWell = qualityAssurance.schoolWell.replace("%", "");
					sum.setSchoolWell((Float.parseFloat(sumSchoolWell)+Float.parseFloat(qualityAssuranceSchoolWell))+"");
					String sumSchoolGood = sum.schoolGood.replace("%", ""),
						   qualityAssuranceSchoolGood = qualityAssurance.schoolGood.replace("%", "");
					sum.setSchoolGood((Float.parseFloat(sumSchoolGood)+Float.parseFloat(qualityAssuranceSchoolGood))+"");
					String sumSchoolBad = sum.schoolBad.replace("%", ""),
						   qualityAssuranceSchoolBad = qualityAssurance.schoolBad.replace("%", "");
					sum.setSchoolBad((Float.parseFloat(sumSchoolBad)+Float.parseFloat(qualityAssuranceSchoolBad))+"");
					sum.setStateClass(sum.stateClass+qualityAssurance.stateClass);
					sum.setProvinClass(sum.provinClass+qualityAssurance.provinClass);
					sum.setCityClass(sum.cityClass+qualityAssurance.cityClass);
					if(null!=sum.chinese&&null!=qualityAssurance.chinese){
					String sumChinese = sum.chinese.replace("%", ""),
						   qualityAssuranceChinese = qualityAssurance.chinese.replace("%", "");
					sum.setChinese((Float.parseFloat(sumChinese)+Float.parseFloat(qualityAssuranceChinese))+"");
					}else{
						sum.setChinese(null!=sum.chinese?sum.chinese.replace("%", ""):(null!=qualityAssurance.chinese?qualityAssurance.chinese.replace("%", ""):"0"));
					}
					if(null!=sum.math&&null!=qualityAssurance.math){
					String sumMath = sum.math.replace("%", ""),
						   qualityAssuranceMath = qualityAssurance.math.replace("%", "");
					sum.setMath((Float.parseFloat(sumMath)+Float.parseFloat(qualityAssuranceMath))+"");
					}else{
						sum.setMath(null!=sum.math?sum.math.replace("%", ""):(null!=qualityAssurance.math?qualityAssurance.math.replace("%", ""):"0"));
					}
					if(null!=sum.english&&null!=qualityAssurance.english){
					String sumEnglish = sum.english.replace("%", ""),
						   qualityAssuranceEnglish = qualityAssurance.english.replace("%", "");
					sum.setEnglish((Float.parseFloat(sumEnglish)+Float.parseFloat(qualityAssuranceEnglish))+"");
					}else{
						sum.setEnglish(null!=sum.english?sum.english.replace("%", ""):(null!=qualityAssurance.english?qualityAssurance.english.replace("%", ""):"0"));
					}
					sum.setStateSkillWinTime(sum.stateSkillWinTime+qualityAssurance.stateSkillWinTime);
					sum.setStateFirstAward(sum.stateFirstAward+qualityAssurance.stateFirstAward);
					sum.setStateSecondAward(sum.stateSecondAward+qualityAssurance.stateSecondAward);
					sum.setStateThridAward(sum.stateThridAward+qualityAssurance.stateThridAward);
					sum.setProvinSkillWinTime(sum.provinSkillWinTime+qualityAssurance.provinSkillWinTime);
					sum.setProvinFirstAward(sum.provinFirstAward+qualityAssurance.provinFirstAward);
					sum.setProvinSecondAward(sum.provinSecondAward+qualityAssurance.provinSecondAward);
					sum.setProvinThirdAward(sum.provinThirdAward+qualityAssurance.provinThirdAward);
					sum.setCitySkillWinTime(sum.citySkillWinTime+qualityAssurance.citySkillWinTime);
					sum.setCityFirstAward(sum.cityFirstAward+qualityAssurance.cityFirstAward);
					sum.setCitySecondAward(sum.citySecondAward+qualityAssurance.citySecondAward);
					sum.setCityThirdAward(sum.cityThirdAward+qualityAssurance.cityThirdAward);
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(qualityAssurance);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			sumList.get(i).setSchoolWell(new BigDecimal(Float.parseFloat(sumList.get(i).getSchoolWell().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			sumList.get(i).setSchoolGood(new BigDecimal(Float.parseFloat(sumList.get(i).getSchoolGood().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			sumList.get(i).setSchoolBad(new BigDecimal(Float.parseFloat(sumList.get(i).getSchoolBad().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			if (null != sumList.get(i).getChinese()) {
				sumList.get(i).setChinese(new BigDecimal(Float.parseFloat(sumList.get(i).getChinese().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			}
			if (null != sumList.get(i).getMath()) {
				sumList.get(i).setMath(new BigDecimal(Float.parseFloat(sumList.get(i).getMath().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			}
			if (null != sumList.get(i).getEnglish()) {
				sumList.get(i).setEnglish(new BigDecimal(Float.parseFloat(sumList.get(i).getEnglish().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			}
		}
		
		return sumList;
	}
	
	public static List<QualityAssurance> avg(List<QualityAssurance> qualityAssuranceList) {
		if (qualityAssuranceList == null) {
			return qualityAssuranceList;
		}
		List<QualityAssurance> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<QualityAssurance> itQualityAssurance = qualityAssuranceList.iterator();
		boolean exist;
		while (itQualityAssurance.hasNext()) {
			exist = false;
			QualityAssurance qualityAssurance = (QualityAssurance) itQualityAssurance.next();
			for(int i = 0; i < avgList.size(); i ++){
				QualityAssurance avg = avgList.get(i);
				if (avg.getYear().equals(qualityAssurance.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setLeaderListen(avg.leaderListen.add(qualityAssurance.leaderListen));
					avg.setLeaderTalk(avg.leaderTalk.add(qualityAssurance.leaderTalk));					
					String avgSchoolWell = avg.schoolWell.replace("%", ""),
						   qualityAssuranceSchoolWell = qualityAssurance.schoolWell.replace("%", "");
					avg.setSchoolWell((Float.parseFloat(avgSchoolWell)+Float.parseFloat(qualityAssuranceSchoolWell))+"");
					String avgSchoolGood = avg.schoolGood.replace("%", ""),
						   qualityAssuranceSchoolGood = qualityAssurance.schoolGood.replace("%", "");
					avg.setSchoolGood((Float.parseFloat(avgSchoolGood)+Float.parseFloat(qualityAssuranceSchoolGood))+"");
					String avgSchoolBad = avg.schoolBad.replace("%", ""),
						   qualityAssuranceSchoolBad = qualityAssurance.schoolBad.replace("%", "");
					avg.setSchoolBad((Float.parseFloat(avgSchoolBad)+Float.parseFloat(qualityAssuranceSchoolBad))+"");
					avg.setStateClass(avg.stateClass+qualityAssurance.stateClass);
					avg.setProvinClass(avg.provinClass+qualityAssurance.provinClass);
					avg.setCityClass(avg.cityClass+qualityAssurance.cityClass);
					if(null!=avg.chinese&&null!=qualityAssurance.chinese){
					String avgChinese = avg.chinese.replace("%", ""),
						   qualityAssuranceChinese = qualityAssurance.chinese.replace("%", "");
					avg.setChinese((Float.parseFloat(avgChinese)+Float.parseFloat(qualityAssuranceChinese))+"");
					}else{
						avg.setChinese(null!=avg.chinese?avg.chinese.replace("%", ""):(null!=qualityAssurance.chinese?qualityAssurance.chinese.replace("%", ""):"0"));
					}
					if(null!=avg.math&&null!=qualityAssurance.math){
					String avgMath = avg.math.replace("%", ""),
						   qualityAssuranceMath = qualityAssurance.math.replace("%", "");
					avg.setMath((Float.parseFloat(avgMath)+Float.parseFloat(qualityAssuranceMath))+"");
					}else{
						avg.setMath(null!=avg.math?avg.math.replace("%", ""):(null!=qualityAssurance.math?qualityAssurance.math.replace("%", ""):"0"));
					}
					if(null!=avg.english&&null!=qualityAssurance.english){
					String avgEnglish = avg.english.replace("%", ""),
						   qualityAssuranceEnglish = qualityAssurance.english.replace("%", "");
					avg.setEnglish((Float.parseFloat(avgEnglish)+Float.parseFloat(qualityAssuranceEnglish))+"");					
					}else{
						avg.setEnglish(null!=avg.english?avg.english.replace("%", ""):(null!=qualityAssurance.english?qualityAssurance.english.replace("%", ""):"0"));
					}
					avg.setStateSkillWinTime(avg.stateSkillWinTime+qualityAssurance.stateSkillWinTime);
					avg.setStateFirstAward(avg.stateFirstAward+qualityAssurance.stateFirstAward);
					avg.setStateSecondAward(avg.stateSecondAward+qualityAssurance.stateSecondAward);
					avg.setStateThridAward(avg.stateThridAward+qualityAssurance.stateThridAward);
					avg.setProvinSkillWinTime(avg.provinSkillWinTime+qualityAssurance.provinSkillWinTime);
					avg.setProvinFirstAward(avg.provinFirstAward+qualityAssurance.provinFirstAward);
					avg.setProvinSecondAward(avg.provinSecondAward+qualityAssurance.provinSecondAward);
					avg.setProvinThirdAward(avg.provinThirdAward+qualityAssurance.provinThirdAward);
					avg.setCitySkillWinTime(avg.citySkillWinTime+qualityAssurance.citySkillWinTime);
					avg.setCityFirstAward(avg.cityFirstAward+qualityAssurance.cityFirstAward);
					avg.setCitySecondAward(avg.citySecondAward+qualityAssurance.citySecondAward);
					avg.setCityThirdAward(avg.cityThirdAward+qualityAssurance.cityThirdAward);
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(qualityAssurance);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			QualityAssurance avg = (QualityAssurance) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示							
			avg.setLeaderListen(avg.leaderListen.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setLeaderTalk(avg.leaderTalk.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));								
			avg.setSchoolWell(new BigDecimal(Float.parseFloat(avg.getSchoolWell().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");			
			avg.setSchoolGood(new BigDecimal(Float.parseFloat(avg.getSchoolGood().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");		
			avg.setSchoolBad(new BigDecimal(Float.parseFloat(avg.getSchoolBad().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			avg.setStateClass(avg.stateClass/addendNum.get(i));
			avg.setProvinClass(avg.provinClass/addendNum.get(i));
			avg.setCityClass(avg.cityClass/addendNum.get(i));		
			if (null != avg.getChinese()) {
				avg.setChinese(new BigDecimal(Float.parseFloat(avg.getChinese().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			}
			if (null != avg.getMath()) {
				avg.setMath(new BigDecimal(Float.parseFloat(avg.getMath().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			}
			if (null != avg.getEnglish()) {
				avg.setEnglish(new BigDecimal(Float.parseFloat(avg.getEnglish().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			}
			avg.setStateSkillWinTime(avg.stateSkillWinTime/addendNum.get(i));
			avg.setStateFirstAward(avg.stateFirstAward/addendNum.get(i));
			avg.setStateSecondAward(avg.stateSecondAward/addendNum.get(i));
			avg.setStateThridAward(avg.stateThridAward/addendNum.get(i));
			avg.setProvinSkillWinTime(avg.provinSkillWinTime/addendNum.get(i));
			avg.setProvinFirstAward(avg.provinFirstAward/addendNum.get(i));
			avg.setProvinSecondAward(avg.provinSecondAward/addendNum.get(i));
			avg.setProvinThirdAward(avg.provinThirdAward/addendNum.get(i));
			avg.setCitySkillWinTime(avg.citySkillWinTime/addendNum.get(i));
			avg.setCityFirstAward(avg.cityFirstAward/addendNum.get(i));
			avg.setCitySecondAward(avg.citySecondAward/addendNum.get(i));
			avg.setCityThirdAward(avg.cityThirdAward/addendNum.get(i));
		}
		
		return avgList;
	}
}

