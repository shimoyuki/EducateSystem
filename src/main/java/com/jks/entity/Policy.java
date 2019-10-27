package com.jks.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Policy {
	
	private int id;
	
	private String admcode;
	
	private String year;
	
	private String city;
	
	private int teacher;
	
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

	public int getTeacher() {
		return teacher;
	}

	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}

	public int getAudit() {
		return audit;
	}

	public void setAudit(int audit) {
		this.audit = audit;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", admcode=" + admcode + ", year=" + year
				+ ", city=" + city + ", teacher=" + teacher + ", audit="
				+ audit + "]";
	}
	
	public static List<Policy> sum(List<Policy> policyList) {
		if (policyList == null) {
			return policyList;
		}
		List<Policy> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Policy> itPolicy = policyList.iterator();
		boolean exist;
		while (itPolicy.hasNext()) {
			exist = false;
			Policy policy = (Policy) itPolicy.next();
			for(int i = 0; i < sumList.size(); i ++){
				Policy sum = sumList.get(i);
				if (sum.getYear().equals(policy.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);					
					sum.setTeacher(sum.teacher+policy.teacher);		
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(policy);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			}
		
		return sumList;
	}
	
	public static List<Policy> avg(List<Policy> policyList) {
		if (policyList == null) {
			return policyList;
		}
		List<Policy> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Policy> itPolicy = policyList.iterator();
		boolean exist;
		while (itPolicy.hasNext()) {
			exist = false;
			Policy policy = (Policy) itPolicy.next();
			for(int i = 0; i < avgList.size(); i ++){
				Policy avg = avgList.get(i);
				if (avg.getYear().equals(policy.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setTeacher(avg.teacher+policy.teacher);
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(policy);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			Policy avg = (Policy) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示							
			avg.setTeacher(avg.teacher/addendNum.get(i));
		}
		
		return avgList;
	}

	
}
