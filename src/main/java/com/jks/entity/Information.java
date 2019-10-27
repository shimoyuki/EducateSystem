package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Information {
    
    private Integer id;

    private String admcode;

    private String year;

    private String city;

    private Integer educateinfo;

    /*private Integer server;*/

    private Integer networknum;

    private Integer networkmain;

    private BigDecimal videostu;

    /*private Integer netmulrooms;

    private Integer onlinecourse;*/

    private BigDecimal elecbookstu;

    private Integer teaccomputer;

    private BigDecimal teaccompstu;

    private Integer collaboration;

    private Integer portalsite;

    private Integer educatemanage;

    private Integer classinfo;

    private Integer classvideo;

    private Integer learnapp;

    private Integer sharedapp;

    private Integer audit;

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
        this.admcode = admcode == null ? null : admcode.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getEducateinfo() {
        return educateinfo;
    }

    public void setEducateinfo(Integer educateinfo) {
        this.educateinfo = educateinfo;
    }

   /* public Integer getServer() {
        return server;
    }

    public void setServer(Integer server) {
        this.server = server;
    }*/

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

   /* public Integer getNetmulrooms() {
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

    public Integer getCollaboration() {
        return collaboration;
    }

    public void setCollaboration(Integer collaboration) {
        this.collaboration = collaboration;
    }

    public Integer getPortalsite() {
        return portalsite;
    }

    public void setPortalsite(Integer portalsite) {
        this.portalsite = portalsite;
    }

    public Integer getEducatemanage() {
        return educatemanage;
    }

    public void setEducatemanage(Integer educatemanage) {
        this.educatemanage = educatemanage;
    }

    public Integer getClassinfo() {
        return classinfo;
    }

    public void setClassinfo(Integer classinfo) {
        this.classinfo = classinfo;
    }

    public Integer getClassvideo() {
        return classvideo;
    }

    public void setClassvideo(Integer classvideo) {
        this.classvideo = classvideo;
    }

    public Integer getLearnapp() {
        return learnapp;
    }

    public void setLearnapp(Integer learnapp) {
        this.learnapp = learnapp;
    }

    public Integer getSharedapp() {
        return sharedapp;
    }

    public void setSharedapp(Integer sharedapp) {
        this.sharedapp = sharedapp;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
    
    @Override
	public String toString() {
		return "Information [id=" + id + ", admcode=" + admcode + ", year=" + year + ", city=" + city + ", educateinfo="
				+ educateinfo +  ", networknum=" + networknum + ", networkmain=" + networkmain
				+ ", videostu=" + videostu + ", elecbookstu=" + elecbookstu + ", teaccomputer=" + teaccomputer + ", teaccompstu=" + teaccompstu + ", collaboration="
				+ collaboration + ", portalsite=" + portalsite + ", educatemanage=" + educatemanage + ", classinfo="
				+ classinfo + ", classvideo=" + classvideo + ", learnapp=" + learnapp + ", sharedapp="
				+ sharedapp + ", audit=" + audit+ "]";
				
	}

	public static List<Information> sum(List<Information> infoList) {
		if (infoList == null) {
			return infoList;
		}
		List<Information> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Information> itInfo = infoList.iterator();
		boolean exist;
		while (itInfo.hasNext()) {
			exist = false;
			Information Information = (Information) itInfo.next();
			for(int i = 0; i < sumList.size(); i ++){
				Information sum = sumList.get(i);
				if (sum.getYear().equals(Information.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					/*sum.setServer(sum.server+Information.server);*/
					sum.setNetworknum(sum.networknum+Information.networknum);
					sum.setNetworkmain(sum.networkmain+Information.networkmain);
					sum.setVideostu(sum.videostu.add(Information.videostu));
					/*sum.setNetmulrooms(sum.netmulrooms+Information.netmulrooms);
					sum.setOnlinecourse(sum.onlinecourse+Information.onlinecourse);*/
					sum.setElecbookstu(sum.elecbookstu.add(Information.elecbookstu));
					sum.setTeaccomputer(sum.teaccomputer+Information.teaccomputer);
					sum.setTeaccompstu(sum.teaccompstu.add(Information.teaccompstu));
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(Information);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			
		}
		
		return sumList;
	}
	
	public static List<Information> avg(List<Information> InformationList) {
		if (InformationList == null) {
			return InformationList;
		}
		List<Information> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Information> itInfo = InformationList.iterator();
		boolean exist;
		while (itInfo.hasNext()) {
			exist = false;
			Information Information = (Information) itInfo.next();
			for(int i = 0; i < avgList.size(); i ++){
				Information avg = avgList.get(i);
				if (avg.getYear().equals(Information.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					/*avg.setServer(avg.server+Information.server);*/
					avg.setNetworknum(avg.networknum+Information.networknum);
					avg.setNetworkmain(avg.networkmain+Information.networkmain);
					avg.setVideostu(avg.videostu.add(Information.videostu));
					/*avg.setNetmulrooms(avg.netmulrooms+Information.netmulrooms);
					avg.setOnlinecourse(avg.onlinecourse+Information.onlinecourse);*/
					avg.setElecbookstu(avg.elecbookstu.add(Information.elecbookstu));
					avg.setTeaccomputer(avg.teaccomputer+Information.teaccomputer);
					avg.setTeaccompstu(avg.teaccompstu.add(Information.teaccompstu));
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(Information);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			Information avg = (Information) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			/*avg.setServer(avg.server/addendNum.get(i));*/
			avg.setNetworknum(avg.networknum/addendNum.get(i));
			avg.setNetworkmain(avg.networkmain/addendNum.get(i));
			avg.setVideostu(avg.videostu.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			/*avg.setNetmulrooms(avg.netmulrooms/addendNum.get(i));
			avg.setOnlinecourse(avg.onlinecourse/addendNum.get(i));*/
			avg.setElecbookstu(avg.elecbookstu.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setTeaccomputer(avg.teaccomputer/addendNum.get(i));
			avg.setTeaccompstu(avg.teaccompstu.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
		}
		
		return avgList;
	}
}