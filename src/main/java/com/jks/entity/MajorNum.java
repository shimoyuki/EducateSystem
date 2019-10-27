package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MajorNum {
	
	private int id;
	
	private String admcode;
	
	private String year;
	
	private String city;
	
	private int classCriter;
	
	private int leadNatShareMajor;
	
	/*private int schoolEnterMajor;*/
	
	private int textTeacEditMajor;
	
	private String statePlanText;
	
	private int schMajorMater;
	
	/*private int classHour;
	
	private int majorHour;
	
	private int majorBHour;
	
	private int majorCHour;
	
	private int dispClass;
	
	private int bCClassHour;
	
	private int chinese;
	
	private int moral;
	
	private int math;
	
	private int english;
	
	private int sports;
	
	private int art;
	
	private int computer;
	
	private int history;*/
	
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

	public int getClassCriter() {
		return classCriter;
	}

	public void setClassCriter(int classCriter) {
		this.classCriter = classCriter;
	}

	public int getLeadNatShareMajor() {
		return leadNatShareMajor;
	}

	public void setLeadNatShareMajor(int leadNatShareMajor) {
		this.leadNatShareMajor = leadNatShareMajor;
	}

	/*public int getSchoolEnterMajor() {
		return schoolEnterMajor;
	}

	public void setSchoolEnterMajor(int schoolEnterMajor) {
		this.schoolEnterMajor = schoolEnterMajor;
	}*/

	public int getTextTeacEditMajor() {
		return textTeacEditMajor;
	}

	public void setTextTeacEditMajor(int textTeacEditMajor) {
		this.textTeacEditMajor = textTeacEditMajor;
	}

	public String getStatePlanText() {
		return statePlanText;
	}

	public void setStatePlanText(String statePlanText) {
		this.statePlanText = statePlanText;
	}

	public int getSchMajorMater() {
		return schMajorMater;
	}

	public void setSchMajorMater(int schMajorMater) {
		this.schMajorMater = schMajorMater;
	}

	/*public int getClassHour() {
		return classHour;
	}

	public void setClassHour(int classHour) {
		this.classHour = classHour;
	}

	public int getMajorHour() {
		return majorHour;
	}

	public void setMajorHour(int majorHour) {
		this.majorHour = majorHour;
	}

	public int getMajorBHour() {
		return majorBHour;
	}

	public void setMajorBHour(int majorBHour) {
		this.majorBHour = majorBHour;
	}

	public int getMajorCHour() {
		return majorCHour;
	}

	public void setMajorCHour(int majorCHour) {
		this.majorCHour = majorCHour;
	}

	public int getDispClass() {
		return dispClass;
	}

	public void setDispClass(int dispClass) {
		this.dispClass = dispClass;
	}

	public int getbCClassHour() {
		return bCClassHour;
	}

	public void setbCClassHour(int bCClassHour) {
		this.bCClassHour = bCClassHour;
	}

	public int getChinese() {
		return chinese;
	}

	public void setChinese(int chinese) {
		this.chinese = chinese;
	}

	public int getMoral() {
		return moral;
	}

	public void setMoral(int moral) {
		this.moral = moral;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getSports() {
		return sports;
	}

	public void setSports(int sports) {
		this.sports = sports;
	}

	public int getArt() {
		return art;
	}

	public void setArt(int art) {
		this.art = art;
	}

	public int getComputer() {
		return computer;
	}

	public void setComputer(int computer) {
		this.computer = computer;
	}

	public int getHistory() {
		return history;
	}

	public void setHistory(int history) {
		this.history = history;
	}*/

	public int getAudit() {
		return audit;
	}

	public void setAudit(int audit) {
		this.audit = audit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "MajorNum [id=" + id + ", admcode=" + admcode + ", year=" + year
				+ ", city=" + city + ", classCriter=" + classCriter
				+ ", leadNatShareMajor=" + leadNatShareMajor
				+ ", textTeacEditMajor=" + textTeacEditMajor
				+ ", statePlanText=" + statePlanText + ", schMajorMater="
				+ schMajorMater +  ", audit=" + audit + "]";
	}
	
	
	public static List<MajorNum> sum(List<MajorNum> majorNumList) {
		if (majorNumList == null) {
			return majorNumList;
		}
		List<MajorNum> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<MajorNum> itMajorNum = majorNumList.iterator();
		boolean exist;
		while (itMajorNum.hasNext()) {
			exist = false;
			MajorNum majorNum = (MajorNum) itMajorNum.next();
			for(int i = 0; i < sumList.size(); i ++){
				MajorNum sum = sumList.get(i);
				if (sum.getYear().equals(majorNum.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					sum.setClassCriter(sum.classCriter+majorNum.classCriter);
					sum.setLeadNatShareMajor(sum.leadNatShareMajor+majorNum.leadNatShareMajor);
					/*sum.setSchoolEnterMajor(sum.schoolEnterMajor+majorNum.schoolEnterMajor);*/
					sum.setTextTeacEditMajor(sum.textTeacEditMajor+majorNum.textTeacEditMajor);					
					String sumStatePlanText = sum.statePlanText.replace("%", ""),
						   majorNumStatePlanText = majorNum.statePlanText.replace("%", "");
					sum.setStatePlanText((Float.parseFloat(sumStatePlanText)+Float.parseFloat(majorNumStatePlanText))+"");
					sum.setSchMajorMater(sum.schMajorMater+majorNum.schMajorMater);
					/*sum.setClassHour(sum.classHour+majorNum.classHour);
					sum.setMajorHour(sum.majorHour+majorNum.majorHour);
					sum.setMajorBHour(sum.majorBHour+majorNum.majorBHour);
					sum.setMajorCHour(sum.majorCHour+majorNum.majorCHour);
					sum.setDispClass(sum.dispClass+majorNum.dispClass);
					sum.setbCClassHour(sum.bCClassHour+majorNum.bCClassHour);
					sum.setChinese(sum.chinese+majorNum.chinese);
					sum.setMoral(sum.moral+majorNum.moral);
					sum.setMath(sum.math+majorNum.math);
					sum.setEnglish(sum.english+majorNum.english);
					sum.setSports(sum.sports+majorNum.sports);
					sum.setArt(sum.art+majorNum.art);
					sum.setComputer(sum.computer+majorNum.computer);
					sum.setHistory(sum.history+majorNum.history);*/
					exist = true;				
				}
			}
			if (!exist) {
				sumList.add(majorNum);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			sumList.get(i).setStatePlanText(new BigDecimal(Float.parseFloat(sumList.get(i).getStatePlanText().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
		}
		
		return sumList;
	}
	
	public static List<MajorNum> avg(List<MajorNum> majorNumList) {
		if (majorNumList == null) {
			return majorNumList;
		}
		List<MajorNum> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<MajorNum> itMajorNum = majorNumList.iterator();
		boolean exist;
		while (itMajorNum.hasNext()) {
			exist = false;
			MajorNum majorNum = (MajorNum) itMajorNum.next();
			for(int i = 0; i < avgList.size(); i ++){
				MajorNum avg = avgList.get(i);
				if (avg.getYear().equals(majorNum.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setClassCriter(avg.classCriter+majorNum.classCriter);
					avg.setLeadNatShareMajor(avg.leadNatShareMajor+majorNum.leadNatShareMajor);
				/*	avg.setSchoolEnterMajor(avg.schoolEnterMajor+majorNum.schoolEnterMajor);*/
					avg.setTextTeacEditMajor(avg.textTeacEditMajor+majorNum.textTeacEditMajor);					
					String avgStatePlanText = avg.statePlanText.replace("%", ""),
						   majorNumStatePlanText = majorNum.statePlanText.replace("%", "");
					avg.setStatePlanText((Float.parseFloat(avgStatePlanText)+Float.parseFloat(majorNumStatePlanText))+"");
					avg.setSchMajorMater(avg.schMajorMater+majorNum.schMajorMater);
					/*avg.setClassHour(avg.classHour+majorNum.classHour);
					avg.setMajorHour(avg.majorHour+majorNum.majorHour);
					avg.setMajorBHour(avg.majorBHour+majorNum.majorBHour);
					avg.setMajorCHour(avg.majorCHour+majorNum.majorCHour);
					avg.setDispClass(avg.dispClass+majorNum.dispClass);
					avg.setbCClassHour(avg.bCClassHour+majorNum.bCClassHour);
					avg.setChinese(avg.chinese+majorNum.chinese);
					avg.setMoral(avg.moral+majorNum.moral);
					avg.setMath(avg.math+majorNum.math);
					avg.setEnglish(avg.english+majorNum.english);
					avg.setSports(avg.sports+majorNum.sports);
					avg.setArt(avg.art+majorNum.art);
					avg.setComputer(avg.computer+majorNum.computer);
					avg.setHistory(avg.history+majorNum.history);*/
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(majorNum);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			MajorNum avg = (MajorNum) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			avg.setClassCriter(avg.classCriter/addendNum.get(i));
			avg.setLeadNatShareMajor(avg.leadNatShareMajor/addendNum.get(i));
			/*avg.setSchoolEnterMajor(avg.schoolEnterMajor/addendNum.get(i));*/
			avg.setTextTeacEditMajor(avg.textTeacEditMajor/addendNum.get(i));								
			avg.setStatePlanText(new BigDecimal(Float.parseFloat(avg.getStatePlanText().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			avg.setSchMajorMater(avg.schMajorMater/addendNum.get(i));
			/*avg.setClassHour(avg.classHour/addendNum.get(i));
			avg.setMajorHour(avg.majorHour/addendNum.get(i));
			avg.setMajorBHour(avg.majorBHour/addendNum.get(i));
			avg.setMajorCHour(avg.majorCHour/addendNum.get(i));
			avg.setDispClass(avg.dispClass/addendNum.get(i));
			avg.setbCClassHour(avg.bCClassHour/addendNum.get(i));
			avg.setChinese(avg.chinese/addendNum.get(i));
			avg.setMoral(avg.moral/addendNum.get(i));
			avg.setMath(avg.math/addendNum.get(i));
			avg.setEnglish(avg.english/addendNum.get(i));
			avg.setSports(avg.sports/addendNum.get(i));
			avg.setArt(avg.art/addendNum.get(i));
			avg.setComputer(avg.computer/addendNum.get(i));
			avg.setHistory(avg.history/addendNum.get(i));	*/	
			}
		
		return avgList;
	}
}
