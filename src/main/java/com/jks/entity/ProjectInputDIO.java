package com.jks.entity;

import java.math.BigDecimal;

public class ProjectInputDIO {//导出学生素质时的数据统一传输对象
	private int id;
	
	private String admcode;
	
	private String year;
	
	private String city;
	
	private String type;
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	public ProjectInputDIO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectInputDIO(ProjectInput stud) {
		super();
		this.id = stud.getId();
		this.admcode = stud.getAdmcode();
		this.year = stud.getYear();
		this.city = stud.getCity();
		if (stud.getType()==0) {
			this.type = "中央专项资金";
		}else if(stud.getType()==1){
			this.type = "省级专项资金";
		}else{
			this.type = "市级专项资金";
		}		
		this.name = stud.getName();
		this.funds = stud.getFunds();
		this.audit = stud.getAudit();
	}

	@Override
	public String toString() {
		return "ProjectInputDIO [id=" + id + ", admcode=" + admcode + ", year="
				+ year + ", city=" + city + ", type=" + type + ", name=" + name
				+ ", funds=" + funds + ", audit=" + audit + "]";
	}
	
}
