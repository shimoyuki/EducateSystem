package com.jks.entity;

import java.math.BigDecimal;

public class InformationDTO {
	private Integer id;

    private String admcode;

    private String year;

    private String city;

    private String educateinfo;

   /* private Integer server;*/

    private Integer networknum;

    private Integer networkmain;

    private BigDecimal videostu;

   /* private Integer netmulrooms;

    private Integer onlinecourse;*/

    private BigDecimal elecbookstu;

    private Integer teaccomputer;

    private BigDecimal teaccompstu;

    private String collaboration;

    private String portalsite;

    private String educatemanage;

    private String classinfo;

    private String classvideo;

    private String learnapp;

    private String sharedapp;

    
    public InformationDTO() {
		super();
	}

	public InformationDTO(Information info) {
		super();
		
		this.id = info.getId();
		this.admcode = info.getAdmcode();
		this.year = info.getYear();
		this.city = info.getCity();
		
		/*this.server = info.getServer();*/
		this.networknum = info.getNetworknum();
		this.networkmain = info.getNetworkmain();
		this.videostu = info.getVideostu();
		/*this.netmulrooms = info.getNetmulrooms();
		this.onlinecourse = info.getOnlinecourse();*/
		this.elecbookstu = info.getElecbookstu();
		this.teaccomputer = info.getTeaccomputer();
		this.teaccompstu = info.getTeaccompstu();
			
		this.educateinfo =  (info.getEducateinfo()==1)?"是":"否";
		this.collaboration = (info.getCollaboration()==1)?"是":"否";
		this.portalsite = (info.getPortalsite()==1)?"是":"否";
		this.educatemanage = (info.getEducatemanage()==1)?"是":"否";
		this.classinfo = (info.getClassinfo()==1)?"是":"否";
		this.classvideo = (info.getClassvideo()==1)?"是":"否";
		this.learnapp = (info.getLearnapp()==1)?"是":"否";
		this.sharedapp = (info.getSharedapp()==1)?"是":"否";
		this.audit = info.getAudit();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getEducateinfo() {
		return educateinfo;
	}

	public void setEducateinfo(String educateinfo) {
		this.educateinfo = educateinfo;
	}

	/*public Integer getServer() {
		return server;
	}

	public void setServer(Integer server) {
		this.server = server;
	}
*/
	public Integer getNetworknum() {
		return networknum;
	}

	public void setNetworknum(Integer networknum) {
		this.networknum = networknum;
	}

	public Integer getNetworkmain() {
		return networkmain;
	}

	public void setNetworkmain(Integer networkmain) {
		this.networkmain = networkmain;
	}

	public BigDecimal getVideostu() {
		return videostu;
	}

	public void setVideostu(BigDecimal videostu) {
		this.videostu = videostu;
	}

	/*public Integer getNetmulrooms() {
		return netmulrooms;
	}

	public void setNetmulrooms(Integer netmulrooms) {
		this.netmulrooms = netmulrooms;
	}

	public Integer getOnlinecourse() {
		return onlinecourse;
	}

	public void setOnlinecourse(Integer onlinecourse) {
		this.onlinecourse = onlinecourse;
	}*/

	public BigDecimal getElecbookstu() {
		return elecbookstu;
	}

	public void setElecbookstu(BigDecimal elecbookstu) {
		this.elecbookstu = elecbookstu;
	}

	public Integer getTeaccomputer() {
		return teaccomputer;
	}

	public void setTeaccomputer(Integer teaccomputer) {
		this.teaccomputer = teaccomputer;
	}

	public BigDecimal getTeaccompstu() {
		return teaccompstu;
	}

	public void setTeaccompstu(BigDecimal teaccompstu) {
		this.teaccompstu = teaccompstu;
	}

	public String getCollaboration() {
		return collaboration;
	}

	public void setCollaboration(String collaboration) {
		this.collaboration = collaboration;
	}

	public String getPortalsite() {
		return portalsite;
	}

	public void setPortalsite(String portalsite) {
		this.portalsite = portalsite;
	}

	public String getEducatemanage() {
		return educatemanage;
	}

	public void setEducatemanage(String educatemanage) {
		this.educatemanage = educatemanage;
	}

	public String getClassinfo() {
		return classinfo;
	}

	public void setClassinfo(String classinfo) {
		this.classinfo = classinfo;
	}

	public String getClassvideo() {
		return classvideo;
	}

	public void setClassvideo(String classvideo) {
		this.classvideo = classvideo;
	}

	public String getLearnapp() {
		return learnapp;
	}

	public void setLearnapp(String learnapp) {
		this.learnapp = learnapp;
	}

	public String getSharedapp() {
		return sharedapp;
	}

	public void setSharedapp(String sharedapp) {
		this.sharedapp = sharedapp;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	private Integer audit;
}
