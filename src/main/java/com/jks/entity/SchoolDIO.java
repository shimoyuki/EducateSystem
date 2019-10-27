package com.jks.entity;

import java.util.ArrayList;
import java.util.List;

public class SchoolDIO {//导入学校信息时的数据统一传输对象

    private String area;
    
    private String admcode;

    private String schoolname;
    
    private String runcode;
    
    private String major;

    private String schooladdr;

    private String telenumber;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAdmcode() {
		return admcode;
	}

	public void setAdmcode(String admcode) {
		this.admcode = admcode;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getRuncode() {
		return runcode;
	}

	public void setRuncode(String runcode) {
		this.runcode = runcode;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSchooladdr() {
		return schooladdr;
	}

	public void setSchooladdr(String schooladdr) {
		this.schooladdr = schooladdr;
	}

	public String getTelenumber() {
		return telenumber;
	}

	public void setTelenumber(String telenumber) {
		this.telenumber = telenumber;
	}
	
	public SchoolInfo getSchoolInfo(){
		SchoolInfo schoolInfo = new SchoolInfo();
		schoolInfo.setAdmcode(this.getAdmcode());
		schoolInfo.setArea(this.getArea());
		schoolInfo.setSchoolname(this.getSchoolname());
		schoolInfo.setSchooladdr(this.getSchooladdr());
		schoolInfo.setTelenumber(this.getTelenumber());
		switch (this.getRuncode()==null?"":this.getRuncode()) {
		case "省示校":
			schoolInfo.setRuncode("3");
			break;
		case "国重校":
			schoolInfo.setRuncode("2");
			break;
		case "国示校":
			schoolInfo.setRuncode("1");
			break;
		case "一般":
			schoolInfo.setRuncode("0");
			break;
		default:
			schoolInfo.setRuncode("0");
			break;
		}
		return schoolInfo;
	}
	
	public List<MajorSchool> getMajorSchool(){
		List<MajorSchool> msList = new ArrayList<MajorSchool>(); 
		MajorSchool majorSchool;
		String[] majors = this.getMajor().trim().split("、");
		if (majors != null) {
			for (int i = 0; i < majors.length; i++) {
				majorSchool = new MajorSchool();
				majorSchool.setMajorname(majors[i]);
				majorSchool.setAdmcode(this.getAdmcode());
				majorSchool.setSchoolname(this.getSchoolname());
				majorSchool.setMajorcode("");//待查
				msList.add(majorSchool);
			}
		}
		return msList;
	}

	@Override
	public String toString() {
		return "SchoolDIO [area=" + area + ", admcode=" + admcode
				+ ", schoolname=" + schoolname + ", runcode=" + runcode
				+ ", major=" + major + ", schooladdr=" + schooladdr
				+ ", telenumber=" + telenumber + "]";
	}
    
}
