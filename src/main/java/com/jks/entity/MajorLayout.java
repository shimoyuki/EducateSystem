package com.jks.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MajorLayout {
	
	private int id;
	
	private String admcode;
	
	private String year;
	
	private String city;
	
	private int oneIndu;
	
	private int twoIndu;
	
	private int threeIndu;
	
	private int localPillar;
	
	/*private int provinceMore;
	
	private int staUniKeyMajor;*/
	
	private int newMajor;
	
	private int stopMajor;
	
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
	public int getOneIndu() {
		return oneIndu;
	}
	public void setOneIndu(int oneIndu) {
		this.oneIndu = oneIndu;
	}
	public int getTwoIndu() {
		return twoIndu;
	}
	public void setTwoIndu(int twoIndu) {
		this.twoIndu = twoIndu;
	}
	public int getThreeIndu() {
		return threeIndu;
	}
	public void setThreeIndu(int threeIndu) {
		this.threeIndu = threeIndu;
	}
	public int getLocalPillar() {
		return localPillar;
	}
	public void setLocalPillar(int localPillar) {
		this.localPillar = localPillar;
	}
	/*public int getProvinceMore() {
		return provinceMore;
	}
	public void setProvinceMore(int provinceMore) {
		this.provinceMore = provinceMore;
	}
	public int getStaUniKeyMajor() {
		return staUniKeyMajor;
	}
	public void setStaUniKeyMajor(int staUniKeyMajor) {
		this.staUniKeyMajor = staUniKeyMajor;
	}*/
	public int getNewMajor() {
		return newMajor;
	}
	public void setNewMajor(int newMajor) {
		this.newMajor = newMajor;
	}
	public int getStopMajor() {
		return stopMajor;
	}
	public void setStopMajor(int stopMajor) {
		this.stopMajor = stopMajor;
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
	@Override
	public String toString() {
		return "MajorLayout [id=" + id + ", admcode=" + admcode + ", year="
				+ year + ", city=" + city + ", oneIndu=" + oneIndu
				+ ", twoIndu=" + twoIndu + ", threeIndu=" + threeIndu
				+ ", localPillar=" + localPillar 		 
				+ ", newMajor=" + newMajor + ", stopMajor=" + stopMajor
				+ ", audit=" + audit + "]";
	}
	
	public static List<MajorLayout> sum(List<MajorLayout> majorLayoutList) {
		if (majorLayoutList == null) {
			return majorLayoutList;
		}
		List<MajorLayout> sumList = new ArrayList<>();
		List<Integer> addendLayout = new ArrayList<>();
		Iterator<MajorLayout> itMajorLayout = majorLayoutList.iterator();
		boolean exist;
		while (itMajorLayout.hasNext()) {
			exist = false;
			MajorLayout majorLayout = (MajorLayout) itMajorLayout.next();
			for(int i = 0; i < sumList.size(); i ++){
				MajorLayout sum = sumList.get(i);
				if (sum.getYear().equals(majorLayout.getYear())) {
					addendLayout.set(i, addendLayout.get(i)+1);
					sum.setOneIndu(sum.oneIndu+majorLayout.oneIndu);
					sum.setTwoIndu(sum.twoIndu+majorLayout.twoIndu);
					sum.setThreeIndu(sum.threeIndu+majorLayout.threeIndu);
					sum.setLocalPillar(sum.localPillar+majorLayout.localPillar);
					/*sum.setProvinceMore(sum.provinceMore+majorLayout.provinceMore);
					sum.setStaUniKeyMajor(sum.staUniKeyMajor+majorLayout.staUniKeyMajor);*/
					sum.setNewMajor(sum.newMajor+majorLayout.newMajor);
					sum.setStopMajor(sum.stopMajor+majorLayout.stopMajor);				
					exist = true;				
				}
			}
			if (!exist) {
				sumList.add(majorLayout);
				addendLayout.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			}
		
		return sumList;
	}
	
	public static List<MajorLayout> avg(List<MajorLayout> majorLayoutList) {
		if (majorLayoutList == null) {
			return majorLayoutList;
		}
		List<MajorLayout> avgList = new ArrayList<>();
		List<Integer> addendLayout = new ArrayList<>();
		Iterator<MajorLayout> itMajorLayout = majorLayoutList.iterator();
		boolean exist;
		while (itMajorLayout.hasNext()) {
			exist = false;
			MajorLayout majorLayout = (MajorLayout) itMajorLayout.next();
			for(int i = 0; i < avgList.size(); i ++){
				MajorLayout avg = avgList.get(i);
				if (avg.getYear().equals(majorLayout.getYear())) {
					addendLayout.set(i, addendLayout.get(i)+1);
					avg.setOneIndu(avg.oneIndu+majorLayout.oneIndu);
					avg.setTwoIndu(avg.twoIndu+majorLayout.twoIndu);
					avg.setThreeIndu(avg.threeIndu+majorLayout.threeIndu);
					avg.setLocalPillar(avg.localPillar+majorLayout.localPillar);
					/*avg.setProvinceMore(avg.provinceMore+majorLayout.provinceMore);
					avg.setStaUniKeyMajor(avg.staUniKeyMajor+majorLayout.staUniKeyMajor);*/
					avg.setNewMajor(avg.newMajor+majorLayout.newMajor);
					avg.setStopMajor(avg.stopMajor+majorLayout.stopMajor);
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(majorLayout);
				addendLayout.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			MajorLayout avg = (MajorLayout) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			avg.setOneIndu(avg.oneIndu/addendLayout.get(i));
			avg.setTwoIndu(avg.twoIndu/addendLayout.get(i));
			avg.setThreeIndu(avg.threeIndu/addendLayout.get(i));
			avg.setLocalPillar(avg.localPillar/addendLayout.get(i));
			/*avg.setProvinceMore(avg.provinceMore/addendLayout.get(i));
			avg.setStaUniKeyMajor(avg.staUniKeyMajor/addendLayout.get(i));*/
			avg.setNewMajor(avg.newMajor/addendLayout.get(i));
			avg.setStopMajor(avg.stopMajor/addendLayout.get(i));					
			}
		
		return avgList;
	}
	
}
