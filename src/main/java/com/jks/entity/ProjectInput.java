package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProjectInput {
	
	private int id;
	
	private String admcode;
	
	private String year;
	
	private String city;
	
	private int type;
	
	private String typeName;
	
	private String name;
	
	private BigDecimal funds;		
		
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getFunds() {
		return funds;
	}

	public void setFunds(BigDecimal funds) {
		this.funds = funds;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "ProjectInput [id=" + id + ", admcode=" + admcode + ", year="
				+ year + ", city=" + city + ", type=" + type + ", typeName="
				+ typeName + ", name=" + name + ", funds=" + funds + ", audit="
				+ audit + "]";
	}
	
	public static List<ProjectInput> sum(List<ProjectInput> projectInputList) {
		if (projectInputList == null) {
			return projectInputList;
		}
		List<ProjectInput> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<ProjectInput> itProjectInput = projectInputList.iterator();
		boolean exist;
		while (itProjectInput.hasNext()) {
			exist = false;
			ProjectInput projectInput = (ProjectInput) itProjectInput.next();
			for(int i = 0; i < sumList.size(); i ++){
				ProjectInput sum = sumList.get(i);
				if (sum.getYear().equals(projectInput.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);					
					sum.setFunds(sum.funds.add(projectInput.funds));			
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(projectInput);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			}
		
		return sumList;
	}
	
	public static List<ProjectInput> avg(List<ProjectInput> projectInputList) {
		if (projectInputList == null) {
			return projectInputList;
		}
		List<ProjectInput> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<ProjectInput> itProjectInput = projectInputList.iterator();
		boolean exist;
		while (itProjectInput.hasNext()) {
			exist = false;
			ProjectInput projectInput = (ProjectInput) itProjectInput.next();
			for(int i = 0; i < avgList.size(); i ++){
				ProjectInput avg = avgList.get(i);
				if (avg.getYear().equals(projectInput.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setFunds(avg.funds.add(projectInput.funds));
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(projectInput);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			ProjectInput avg = (ProjectInput) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示							
			avg.setFunds(avg.funds.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
		}
		
		return avgList;
	}

	
}
