package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EducationTrain {
	
	private int id;
	
	private String admcode;
	
	private String year;
	
	private String city;
	
	private int distTrainFullTea;
	
	private BigDecimal distTrainHour;
	
	private int cityTrainFullTea;
	
	private BigDecimal cityTrainHour;

	private int provinTrainFullTea;
	
	private BigDecimal provinTrainHour;

	private int stateTrainFullTea;
	
	private BigDecimal stateTrainHour;

	private int stateOuterTrain;
	
	private BigDecimal stateOuterHour;

	private int abroadTrain;
	
	private BigDecimal abroadHour;
	
	private int diploma;
	
	private String tainFundPer;

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

	public int getDistTrainFullTea() {
		return distTrainFullTea;
	}

	public void setDistTrainFullTea(int distTrainFullTea) {
		this.distTrainFullTea = distTrainFullTea;
	}

	public BigDecimal getDistTrainHour() {
		return distTrainHour;
	}

	public void setDistTrainHour(BigDecimal distTrainHour) {
		this.distTrainHour = distTrainHour;
	}

	public int getCityTrainFullTea() {
		return cityTrainFullTea;
	}

	public void setCityTrainFullTea(int cityTrainFullTea) {
		this.cityTrainFullTea = cityTrainFullTea;
	}

	public BigDecimal getCityTrainHour() {
		return cityTrainHour;
	}

	public void setCityTrainHour(BigDecimal cityTrainHour) {
		this.cityTrainHour = cityTrainHour;
	}

	public int getProvinTrainFullTea() {
		return provinTrainFullTea;
	}

	public void setProvinTrainFullTea(int provinTrainFullTea) {
		this.provinTrainFullTea = provinTrainFullTea;
	}

	public BigDecimal getProvinTrainHour() {
		return provinTrainHour;
	}

	public void setProvinTrainHour(BigDecimal provinTrainHour) {
		this.provinTrainHour = provinTrainHour;
	}

	public int getStateTrainFullTea() {
		return stateTrainFullTea;
	}

	public void setStateTrainFullTea(int stateTrainFullTea) {
		this.stateTrainFullTea = stateTrainFullTea;
	}

	public BigDecimal getStateTrainHour() {
		return stateTrainHour;
	}

	public void setStateTrainHour(BigDecimal stateTrainHour) {
		this.stateTrainHour = stateTrainHour;
	}

	public int getStateOuterTrain() {
		return stateOuterTrain;
	}

	public void setStateOuterTrain(int stateOuterTrain) {
		this.stateOuterTrain = stateOuterTrain;
	}

	public BigDecimal getStateOuterHour() {
		return stateOuterHour;
	}

	public void setStateOuterHour(BigDecimal stateOuterHour) {
		this.stateOuterHour = stateOuterHour;
	}

	public int getAbroadTrain() {
		return abroadTrain;
	}

	public void setAbroadTrain(int abroadTrain) {
		this.abroadTrain = abroadTrain;
	}

	public BigDecimal getAbroadHour() {
		return abroadHour;
	}

	public void setAbroadHour(BigDecimal abroadHour) {
		this.abroadHour = abroadHour;
	}

	public int getDiploma() {
		return diploma;
	}

	public void setDiploma(int diploma) {
		this.diploma = diploma;
	}

	public String getTainFundPer() {
		return tainFundPer;
	}

	public void setTainFundPer(String tainFundPer) {
		this.tainFundPer = tainFundPer;
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
		return "EducationTrain [id=" + id + ", admcode=" + admcode + ", year="
				+ year + ", city=" + city + ", distTrainFullTea="
				+ distTrainFullTea + ", distTrainHour=" + distTrainHour
				+ ", cityTrainFullTea=" + cityTrainFullTea + ", cityTrainHour="
				+ cityTrainHour + ", provinTrainFullTea=" + provinTrainFullTea
				+ ", provinTrainHour=" + provinTrainHour
				+ ", stateTrainFullTea=" + stateTrainFullTea
				+ ", stateTrainHour=" + stateTrainHour + ", stateOuterTrain="
				+ stateOuterTrain + ", stateOuterHour=" + stateOuterHour
				+ ", abroadTrain=" + abroadTrain + ", abroadHour=" + abroadHour
				+ ", diploma=" + diploma + ", tainFundPer=" + tainFundPer
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
	
	
	public static List<EducationTrain> sum(List<EducationTrain> educationTrainList) {
		if (educationTrainList == null) {
			return educationTrainList;
		}
		List<EducationTrain> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<EducationTrain> itEducationTrain = educationTrainList.iterator();
		boolean exist;
		while (itEducationTrain.hasNext()) {
			exist = false;
			EducationTrain educationTrain = (EducationTrain) itEducationTrain.next();
			for(int i = 0; i < sumList.size(); i ++){
				EducationTrain sum = sumList.get(i);
				if (sum.getYear().equals(educationTrain.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);					
					sum.setDistTrainFullTea(sum.distTrainFullTea+educationTrain.distTrainFullTea);
					sum.setDistTrainHour(sum.distTrainHour.add(educationTrain.distTrainHour));
					sum.setCityTrainFullTea(sum.cityTrainFullTea+educationTrain.cityTrainFullTea);
					sum.setCityTrainHour(sum.cityTrainHour.add(educationTrain.cityTrainHour));
					sum.setProvinTrainFullTea(sum.provinTrainFullTea+educationTrain.provinTrainFullTea);
					sum.setProvinTrainHour(sum.provinTrainHour.add(educationTrain.provinTrainHour));
					sum.setStateTrainFullTea(sum.stateTrainFullTea+educationTrain.stateTrainFullTea);
					sum.setStateTrainHour(sum.stateTrainHour.add(educationTrain.stateTrainHour));
					sum.setStateOuterTrain(sum.stateOuterTrain+educationTrain.stateOuterTrain);
					sum.setStateOuterHour(sum.stateOuterHour.add(educationTrain.stateOuterHour));
					sum.setAbroadTrain(sum.abroadTrain+educationTrain.abroadTrain);
					sum.setAbroadHour(sum.abroadHour.add(educationTrain.abroadHour));
					sum.setDiploma(sum.diploma+educationTrain.diploma);				
					String sumTainFundPer = sum.tainFundPer.replace("%", ""),
						   educationTrainTainFundPer = educationTrain.tainFundPer.replace("%", "");
					sum.setTainFundPer((Float.parseFloat(sumTainFundPer)+Float.parseFloat(educationTrainTainFundPer))+"");
					sum.setStateSkillWinTime(sum.stateSkillWinTime+educationTrain.stateSkillWinTime);
					sum.setStateFirstAward(sum.stateFirstAward+educationTrain.stateFirstAward);
					sum.setStateSecondAward(sum.stateSecondAward+educationTrain.stateSecondAward);
					sum.setStateThridAward(sum.stateThridAward+educationTrain.stateThridAward);
					sum.setProvinSkillWinTime(sum.provinSkillWinTime+educationTrain.provinSkillWinTime);
					sum.setProvinFirstAward(sum.provinFirstAward+educationTrain.provinFirstAward);
					sum.setProvinSecondAward(sum.provinSecondAward+educationTrain.provinSecondAward);
					sum.setProvinThirdAward(sum.provinThirdAward+educationTrain.provinThirdAward);
					sum.setCitySkillWinTime(sum.citySkillWinTime+educationTrain.citySkillWinTime);
					sum.setCityFirstAward(sum.cityFirstAward+educationTrain.cityFirstAward);
					sum.setCitySecondAward(sum.citySecondAward+educationTrain.citySecondAward);
					sum.setCityThirdAward(sum.cityThirdAward+educationTrain.cityThirdAward);
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(educationTrain);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			sumList.get(i).setTainFundPer(new BigDecimal(Float.parseFloat(sumList.get(i).getTainFundPer().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
		}
		
		return sumList;
	}
	
	public static List<EducationTrain> avg(List<EducationTrain> educationTrainList) {
		if (educationTrainList == null) {
			return educationTrainList;
		}
		List<EducationTrain> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<EducationTrain> itEducationTrain = educationTrainList.iterator();
		boolean exist;
		while (itEducationTrain.hasNext()) {
			exist = false;
			EducationTrain educationTrain = (EducationTrain) itEducationTrain.next();
			for(int i = 0; i < avgList.size(); i ++){
				EducationTrain avg = avgList.get(i);
				if (avg.getYear().equals(educationTrain.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setDistTrainFullTea(avg.distTrainFullTea+educationTrain.distTrainFullTea);
					avg.setDistTrainHour(avg.distTrainHour.add(educationTrain.distTrainHour));
					avg.setCityTrainFullTea(avg.cityTrainFullTea+educationTrain.cityTrainFullTea);
					avg.setCityTrainHour(avg.cityTrainHour.add(educationTrain.cityTrainHour));
					avg.setProvinTrainFullTea(avg.provinTrainFullTea+educationTrain.provinTrainFullTea);
					avg.setProvinTrainHour(avg.provinTrainHour.add(educationTrain.provinTrainHour));
					avg.setStateTrainFullTea(avg.stateTrainFullTea+educationTrain.stateTrainFullTea);
					avg.setStateTrainHour(avg.stateTrainHour.add(educationTrain.stateTrainHour));
					avg.setStateOuterTrain(avg.stateOuterTrain+educationTrain.stateOuterTrain);
					avg.setStateOuterHour(avg.stateOuterHour.add(educationTrain.stateOuterHour));
					avg.setAbroadTrain(avg.abroadTrain+educationTrain.abroadTrain);
					avg.setAbroadHour(avg.abroadHour.add(educationTrain.abroadHour));
					avg.setDiploma(avg.diploma+educationTrain.diploma);				
					String avgTainFundPer = avg.tainFundPer.replace("%", ""),
						   educationTrainTainFundPer = educationTrain.tainFundPer.replace("%", "");
					avg.setTainFundPer((Float.parseFloat(avgTainFundPer)+Float.parseFloat(educationTrainTainFundPer))+"");
					avg.setStateSkillWinTime(avg.stateSkillWinTime+educationTrain.stateSkillWinTime);
					avg.setStateFirstAward(avg.stateFirstAward+educationTrain.stateFirstAward);
					avg.setStateSecondAward(avg.stateSecondAward+educationTrain.stateSecondAward);
					avg.setStateThridAward(avg.stateThridAward+educationTrain.stateThridAward);
					avg.setProvinSkillWinTime(avg.provinSkillWinTime+educationTrain.provinSkillWinTime);
					avg.setProvinFirstAward(avg.provinFirstAward+educationTrain.provinFirstAward);
					avg.setProvinSecondAward(avg.provinSecondAward+educationTrain.provinSecondAward);
					avg.setProvinThirdAward(avg.provinThirdAward+educationTrain.provinThirdAward);
					avg.setCitySkillWinTime(avg.citySkillWinTime+educationTrain.citySkillWinTime);
					avg.setCityFirstAward(avg.cityFirstAward+educationTrain.cityFirstAward);
					avg.setCitySecondAward(avg.citySecondAward+educationTrain.citySecondAward);
					avg.setCityThirdAward(avg.cityThirdAward+educationTrain.cityThirdAward);
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(educationTrain);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			EducationTrain avg = (EducationTrain) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示			
			avg.setDistTrainFullTea(avg.distTrainFullTea/addendNum.get(i));
			avg.setDistTrainHour(avg.distTrainHour.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setCityTrainFullTea(avg.cityTrainFullTea/addendNum.get(i));
			avg.setCityTrainHour(avg.cityTrainHour.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setProvinTrainFullTea(avg.provinTrainFullTea/addendNum.get(i));
			avg.setProvinTrainHour(avg.provinTrainHour.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setStateTrainFullTea(avg.stateTrainFullTea/addendNum.get(i));
			avg.setStateTrainHour(avg.stateTrainHour.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setStateOuterTrain(avg.stateOuterTrain/addendNum.get(i));
			avg.setStateOuterHour(avg.stateOuterHour.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setAbroadTrain(avg.abroadTrain/addendNum.get(i));
			avg.setAbroadHour(avg.abroadHour.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setDiploma(avg.diploma/addendNum.get(i));				
			avg.setTainFundPer(new BigDecimal(Float.parseFloat(avg.getTainFundPer().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
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
