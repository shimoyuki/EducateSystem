package com.jks.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

;

public class MajorStu {	
	
	private int id;
	
	private String admcode;
	
	private String year;	
	
	private String city;
	
	private String induName;
	
	private String name;
	
	private int firstGradeSum;
	
	private int secGradeSum;
	
	private int thirdGradeSum;
	
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

	public int getAudit() {
		return audit;
	}

	public void setAudit(int audit) {
		this.audit = audit;
	}

	public String getInduName() {
		return induName;
	}

	public void setInduName(String induName) {
		this.induName = induName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFirstGradeSum() {
		return firstGradeSum;
	}

	public void setFirstGradeSum(int firstGradeSum) {
		this.firstGradeSum = firstGradeSum;
	}

	public int getSecGradeSum() {
		return secGradeSum;
	}

	public void setSecGradeSum(int secGradeSum) {
		this.secGradeSum = secGradeSum;
	}

	public int getThirdGradeSum() {
		return thirdGradeSum;
	}

	public void setThirdGradeSum(int thirdGradeSum) {
		this.thirdGradeSum = thirdGradeSum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "MajorStu [id=" + id + ", admcode=" + admcode + ", year=" + year
				+ ", city=" + city + ", induName=" + induName + ", name="
				+ name + ", firstGradeSum=" + firstGradeSum + ", secGradeSum="
				+ secGradeSum + ", thirdGradeSum=" + thirdGradeSum + ", audit="
				+ audit + "]";
	}
	
	public static List<MajorStu> sum(List<MajorStu> majorStuList) {
		if (majorStuList == null) {
			return majorStuList;
		}
		List<MajorStu> sumList = new ArrayList<>();
		List<Integer> addendStu = new ArrayList<>();
		Iterator<MajorStu> itMajorStu = majorStuList.iterator();
		boolean exist;
		while (itMajorStu.hasNext()) {
			exist = false;
			MajorStu majorStu = (MajorStu) itMajorStu.next();
			for(int i = 0; i < sumList.size(); i ++){
				MajorStu sum = sumList.get(i);
				if (sum.getYear().equals(majorStu.getYear())) {
					addendStu.set(i, addendStu.get(i)+1);
					sum.setFirstGradeSum(sum.firstGradeSum+majorStu.firstGradeSum);
					sum.setSecGradeSum(sum.secGradeSum+majorStu.secGradeSum);
					sum.setThirdGradeSum(sum.thirdGradeSum+majorStu.thirdGradeSum);							
					exist = true;				
				}
			}
			if (!exist) {
				sumList.add(majorStu);
				addendStu.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			}
		
		return sumList;
	}
	
	public static List<MajorStu> avg(List<MajorStu> majorStuList) {
		if (majorStuList == null) {
			return majorStuList;
		}
		List<MajorStu> avgList = new ArrayList<>();
		List<Integer> addendStu = new ArrayList<>();
		Iterator<MajorStu> itMajorStu = majorStuList.iterator();
		boolean exist;
		while (itMajorStu.hasNext()) {
			exist = false;
			MajorStu majorStu = (MajorStu) itMajorStu.next();
			for(int i = 0; i < avgList.size(); i ++){
				MajorStu avg = avgList.get(i);
				if (avg.getYear().equals(majorStu.getYear())) {
					addendStu.set(i, addendStu.get(i)+1);
					avg.setFirstGradeSum(avg.firstGradeSum+majorStu.firstGradeSum);
					avg.setSecGradeSum(avg.secGradeSum+majorStu.secGradeSum);
					avg.setThirdGradeSum(avg.thirdGradeSum+majorStu.thirdGradeSum);	
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(majorStu);
				addendStu.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			MajorStu avg = (MajorStu) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			avg.setFirstGradeSum(avg.firstGradeSum/addendStu.get(i));
			avg.setSecGradeSum(avg.secGradeSum/addendStu.get(i));
			avg.setThirdGradeSum(avg.thirdGradeSum/addendStu.get(i));							
			}
		
		return avgList;
	}
	
}
