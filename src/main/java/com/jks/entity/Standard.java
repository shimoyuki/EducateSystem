package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Standard {
	
	private String admcode;

    private String year;
	
    private String city;
    
	private Integer student = 0;
	
	private Integer teacher = 0;
	
	private BigDecimal tsRatio = new BigDecimal(0);
	
	private BigDecimal doubleTeacher = new BigDecimal(0);
	
	private BigDecimal partTimeTeacher = new BigDecimal(0);
	
	private BigDecimal area = new BigDecimal(0);
	
	private BigDecimal stuArea = new BigDecimal(0);
	
	private BigDecimal buildArea = new BigDecimal(0);
	
	private BigDecimal stuBuildArea = new BigDecimal(0);
	
	private BigDecimal stuBook = new BigDecimal(0);
	
	private BigDecimal computer = new BigDecimal(0);

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

	public Integer getStudent() {
		return student;
	}

	public void setStudent(Integer student) {
		this.student = student == null ? 0 : student;
	}

	public Integer getTeacher() {
		return teacher;
	}

	public void setTeacher(Integer teacher) {
		this.teacher = teacher  == null ? 0 : teacher;
	}

	public BigDecimal getTsRatio() {
		return tsRatio;
	}

	public void setTsRatio(BigDecimal tsRatio) {
		this.tsRatio = tsRatio == null ? new BigDecimal(0) : tsRatio.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getDoubleTeacher() {
		return doubleTeacher;
	}

	public void setDoubleTeacher(BigDecimal doubleTeacher) {
		this.doubleTeacher = doubleTeacher == null ? new BigDecimal(0) : doubleTeacher.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getPartTimeTeacher() {
		return partTimeTeacher;
	}

	public void setPartTimeTeacher(BigDecimal partTimeTeacher) {
		this.partTimeTeacher = partTimeTeacher == null ? new BigDecimal(0) : partTimeTeacher.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area == null ? new BigDecimal(0) : area.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getStuArea() {
		return stuArea;
	}

	public void setStuArea(BigDecimal stuArea) {
		this.stuArea = stuArea == null ? new BigDecimal(0) : stuArea.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getBuildArea() {
		return buildArea;
	}

	public void setBuildArea(BigDecimal buildArea) {
		this.buildArea = buildArea == null ? new BigDecimal(0) : buildArea.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getStuBuildArea() {
		return stuBuildArea;
	}

	public void setStuBuildArea(BigDecimal stuBuildArea) {
		this.stuBuildArea = stuBuildArea == null ? new BigDecimal(0) : stuBuildArea.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getStuBook() {
		return stuBook;
	}

	public void setStuBook(BigDecimal stuBook) {
		this.stuBook = stuBook == null ? new BigDecimal(0) : stuBook.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getComputer() {
		return computer;
	}

	public void setComputer(BigDecimal computer) {
		this.computer = computer == null ? new BigDecimal(0) : computer.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public String toString() {
		return "Standard [student=" + student + ", teacher=" + teacher + ", tsRatio=" + tsRatio + ", doubleTeacher="
				+ doubleTeacher + ", partTimeTeacher=" + partTimeTeacher + ", area=" + area + ", stuArea=" + stuArea
				+ ", buildArea=" + buildArea + ", stuBuildArea=" + stuBuildArea + ", stuBook=" + stuBook + ", computer="
				+ computer + "]";
	}
	
	public static List<Standard> sum(List<Standard> standardList) {
		if (standardList == null) {
			return standardList;
		}
		List<Standard> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Standard> itStandard = standardList.iterator();
		boolean exist;
		while (itStandard.hasNext()) {
			exist = false;
			Standard standard = (Standard) itStandard.next();
			for(int i = 0; i < sumList.size(); i ++){
				Standard sum = sumList.get(i);
				if (sum.getYear().equals(standard.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					
					sum.setStudent(sum.student+standard.student);
					sum.setTeacher(sum.teacher+standard.teacher);
					sum.setTsRatio(sum.tsRatio.add(standard.tsRatio));
					sum.setDoubleTeacher(sum.doubleTeacher.add(standard.doubleTeacher));
					sum.setPartTimeTeacher(sum.partTimeTeacher.add(standard.partTimeTeacher));
					sum.setArea(sum.area.add(standard.area));
					sum.setStuArea(sum.stuArea.add(standard.stuArea));
					sum.setBuildArea(sum.buildArea.add(standard.buildArea));
					sum.setStuBuildArea(sum.stuBuildArea.add(standard.stuBuildArea));
					sum.setStuBook(sum.stuBook.add(standard.stuBook));
					sum.setComputer(sum.computer.add(standard.computer));
					
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(standard);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
		}
		
		return sumList;
	}
	
	public static List<Standard> avg(List<Standard> standardList) {
		if (standardList == null) {
			return standardList;
		}
		List<Standard> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Standard> itStandard = standardList.iterator();
		boolean exist;
		while (itStandard.hasNext()) {
			exist = false;
			Standard standard = (Standard) itStandard.next();
			for(int i = 0; i < avgList.size(); i ++){
				Standard avg = avgList.get(i);
				if (avg.getYear().equals(standard.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);

					avg.setStudent(avg.student+standard.student);
					avg.setTeacher(avg.teacher+standard.teacher);
					avg.setTsRatio(avg.tsRatio.add(standard.tsRatio));
					avg.setDoubleTeacher(avg.doubleTeacher.add(standard.doubleTeacher));
					avg.setPartTimeTeacher(avg.partTimeTeacher.add(standard.partTimeTeacher));
					avg.setArea(avg.area.add(standard.area));
					avg.setStuArea(avg.stuArea.add(standard.stuArea));
					avg.setBuildArea(avg.buildArea.add(standard.buildArea));
					avg.setStuBuildArea(avg.stuBuildArea.add(standard.stuBuildArea));
					avg.setStuBook(avg.stuBook.add(standard.stuBook));
					avg.setComputer(avg.computer.add(standard.computer));
					
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(standard);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			Standard avg = (Standard) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			
			avg.setStudent(avg.student/addendNum.get(i));
			avg.setTeacher(avg.teacher/addendNum.get(i));
			avg.setTsRatio(avg.tsRatio.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setDoubleTeacher(avg.doubleTeacher.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setPartTimeTeacher(avg.partTimeTeacher.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setArea(avg.area.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setStuArea(avg.stuArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setBuildArea(avg.buildArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setStuBuildArea(avg.stuBuildArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setStuBook(avg.stuBook.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setComputer(avg.computer.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			
		}
		
		return avgList;
	}
}
