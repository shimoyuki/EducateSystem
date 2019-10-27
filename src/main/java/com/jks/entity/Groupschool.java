package com.jks.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Groupschool {
    private Integer id;

    private String admcode;

    private String year;

    private String city;

    private Float  leadvocedugroup;

    private Float joinleadvocedugroupscho;

    private Float joinleadvocedugroupmajor;

    private Float joinvocedugroup;

    private Float joinleadvocedugroupenterp;

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

	public Float getLeadvocedugroup() {
		return leadvocedugroup;
	}

	public void setLeadvocedugroup(Float leadvocedugroup) {
		this.leadvocedugroup = leadvocedugroup;
	}

	public Float getJoinleadvocedugroupscho() {
		return joinleadvocedugroupscho;
	}

	public void setJoinleadvocedugroupscho(Float joinleadvocedugroupscho) {
		this.joinleadvocedugroupscho = joinleadvocedugroupscho;
	}

	public Float getJoinleadvocedugroupmajor() {
		return joinleadvocedugroupmajor;
	}

	public void setJoinleadvocedugroupmajor(Float joinleadvocedugroupmajor) {
		this.joinleadvocedugroupmajor = joinleadvocedugroupmajor;
	}

	public Float getJoinvocedugroup() {
		return joinvocedugroup;
	}

	public void setJoinvocedugroup(Float joinvocedugroup) {
		this.joinvocedugroup = joinvocedugroup;
	}

	public Float getJoinleadvocedugroupenterp() {
		return joinleadvocedugroupenterp;
	}

	public void setJoinleadvocedugroupenterp(Float joinleadvocedugroupenterp) {
		this.joinleadvocedugroupenterp = joinleadvocedugroupenterp;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	@Override
	public String toString() {
		return "Groupschool [id=" + id + ", admcode=" + admcode + ", year=" + year + ", city=" + city + ", leadvocedugroup="
				+ leadvocedugroup + ", joinleadvocedugroupscho=" + joinleadvocedugroupscho + ", joinleadvocedugroupmajor=" + joinleadvocedugroupmajor + ", joinvocedugroup=" + joinvocedugroup
				+ ", joinleadvocedugroupenterp=" + joinleadvocedugroupenterp + ", audit=" + audit + "]";
	}
    
    public static List<Groupschool> sum(List<Groupschool> groupList) {
		if (groupList == null) {
			return groupList;
		}
		List<Groupschool> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Groupschool> itGroup = groupList.iterator();
		boolean exist;
		while (itGroup.hasNext()) {
			exist = false;
			Groupschool groupschool = (Groupschool) itGroup.next();
			for(int i = 0; i < sumList.size(); i ++){
				Groupschool sum = groupList.get(i);
				if (sum.getYear().equals(groupschool.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);			
					sum.setLeadvocedugroup(sum.leadvocedugroup+groupschool.leadvocedugroup);
					sum.setJoinleadvocedugroupscho(sum.joinleadvocedugroupscho+groupschool.joinleadvocedugroupscho);
					sum.setJoinleadvocedugroupmajor(sum.joinleadvocedugroupmajor+groupschool.joinleadvocedugroupmajor);
					sum.setJoinvocedugroup(sum.joinvocedugroup+groupschool.joinvocedugroup);
					sum.setJoinleadvocedugroupenterp(sum.joinleadvocedugroupenterp+groupschool.joinleadvocedugroupenterp);
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(groupschool);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			
		}
		
		return sumList;
	}
    public static List<Groupschool> avg(List<Groupschool> groupList) {
		if (groupList == null) {
			return groupList;
		}
		List<Groupschool> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Groupschool> itGroup = groupList.iterator();
		boolean exist;
		while (itGroup.hasNext()) {
			exist = false;
			Groupschool groupschool = (Groupschool) itGroup.next();
			for(int i = 0; i < avgList.size(); i ++){
				Groupschool avg = avgList.get(i);
				if (avg.getYear().equals(groupschool.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setLeadvocedugroup(avg.leadvocedugroup+groupschool.leadvocedugroup);
					avg.setJoinleadvocedugroupscho(avg.joinleadvocedugroupscho+groupschool.joinleadvocedugroupscho);
					avg.setJoinleadvocedugroupmajor(avg.joinleadvocedugroupmajor+groupschool.joinleadvocedugroupmajor);
					avg.setJoinvocedugroup(avg.joinvocedugroup+groupschool.joinvocedugroup);
					avg.setJoinleadvocedugroupenterp(avg.joinleadvocedugroupenterp+groupschool.joinleadvocedugroupenterp);
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(groupschool);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			Groupschool avg = (Groupschool) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
		
			avg.setLeadvocedugroup(avg.leadvocedugroup/addendNum.get(i));
			avg.setJoinleadvocedugroupscho(avg.joinleadvocedugroupscho/addendNum.get(i));
			avg.setJoinleadvocedugroupmajor(avg.joinleadvocedugroupmajor/addendNum.get(i));
			avg.setJoinvocedugroup(avg.joinvocedugroup/addendNum.get(i));
			avg.setJoinleadvocedugroupenterp(avg.joinleadvocedugroupenterp/addendNum.get(i));
		}
		
		return avgList;
	}
}