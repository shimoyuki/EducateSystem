package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Size {
	
	private int id;
	
	private String admcode;
	
	private String year;
	
	private String city;
	
	private String schoolRun;
	
	private String schoolLevel;
	
	private String schoolSubject;
	
	private BigDecimal area;
	
	private BigDecimal ownPropArea;
	
	private BigDecimal totalArea;
	
	private BigDecimal schOwnConArea;
	
	private BigDecimal stuArea;
	
	private BigDecimal teaAuxArea;
	
	private BigDecimal trainArea;
	
	private BigDecimal psyArea;
	
	/*private BigDecimal adminOfficeArea;*/
	
	private BigDecimal dormArea;
	
	private BigDecimal dormPerArea;
	
	private float enrollment;
	
	private float annualGraduate;
	
	private float totalStudent;
	
	private float majors;
	
	private String threeConsol;
	
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

	public String getSchoolRun() {
		return schoolRun;
	}

	public void setSchoolRun(String schoolRun) {
		this.schoolRun = schoolRun;
	}

	public String getSchoolLevel() {
		return schoolLevel;
	}

	public void setSchoolLevel(String schoolLevel) {
		this.schoolLevel = schoolLevel;
	}

	public String getSchoolSubject() {
		return schoolSubject;
	}

	public void setSchoolSubject(String schoolSubject) {
		this.schoolSubject = schoolSubject;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getOwnPropArea() {
		return ownPropArea;
	}

	public void setOwnPropArea(BigDecimal ownPropArea) {
		this.ownPropArea = ownPropArea;
	}

	public BigDecimal getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(BigDecimal totalArea) {
		this.totalArea = totalArea;
	}

	public BigDecimal getSchOwnConArea() {
		return schOwnConArea;
	}

	public void setSchOwnConArea(BigDecimal schOwnConArea) {
		this.schOwnConArea = schOwnConArea;
	}

	public BigDecimal getStuArea() {
		return stuArea;
	}

	public void setStuArea(BigDecimal stuArea) {
		this.stuArea = stuArea;
	}

	public BigDecimal getTeaAuxArea() {
		return teaAuxArea;
	}

	public void setTeaAuxArea(BigDecimal teaAuxArea) {
		this.teaAuxArea = teaAuxArea;
	}

	public BigDecimal getTrainArea() {
		return trainArea;
	}

	public void setTrainArea(BigDecimal trainArea) {
		this.trainArea = trainArea;
	}

	public BigDecimal getPsyArea() {
		return psyArea;
	}

	public void setPsyArea(BigDecimal psyArea) {
		this.psyArea = psyArea;
	}

	public BigDecimal getDormArea() {
		return dormArea;
	}

	public void setDormArea(BigDecimal dormArea) {
		this.dormArea = dormArea;
	}

	public BigDecimal getDormPerArea() {
		return dormPerArea;
	}

	public void setDormPerArea(BigDecimal dormPerArea) {
		this.dormPerArea = dormPerArea;
	}

	public float getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(float enrollment) {
		this.enrollment = enrollment;
	}

	public float getAnnualGraduate() {
		return annualGraduate;
	}

	public void setAnnualGraduate(float annualGraduate) {
		this.annualGraduate = annualGraduate;
	}

	public float getTotalStudent() {
		return totalStudent;
	}

	public void setTotalStudent(float totalStudent) {
		this.totalStudent = totalStudent;
	}

	public float getMajors() {
		return majors;
	}

	public void setMajors(float majors) {
		this.majors = majors;
	}

	public String getThreeConsol() {
		return threeConsol;
	}

	public void setThreeConsol(String threeConsol) {
		this.threeConsol = threeConsol;
	}

	public int getAudit() {
		return audit;
	}

	public void setAudit(int audit) {
		this.audit = audit;
	}

	@Override
	public String toString() {
		return "Size [id=" + id + ", admcode=" + admcode + ", year=" + year + ", city=" + city + ", schoolRun="
				+ schoolRun + ", schoolLevel=" + schoolLevel + ", schoolSubject=" + schoolSubject + ", area=" + area
				+ ", ownPropArea=" + ownPropArea + ", totalArea=" + totalArea + ", schOwnConArea=" + schOwnConArea
				+ ", stuArea=" + stuArea + ", teaAuxArea=" + teaAuxArea + ", trainArea=" + trainArea + ", psyArea="
				+ psyArea + ", dormArea=" + dormArea + ", dormPerArea="
				+ dormPerArea + ", enrollment=" + enrollment + ", annualGraduate=" + annualGraduate + ", totalStudent="
				+ totalStudent + ", majors=" + majors + ", threeConsol=" + threeConsol + ", audit=" + audit
				+ "]";
	}

	public static List<Size> sum(List<Size> sizeList) {
		if (sizeList == null) {
			return sizeList;
		}
		List<Size> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Size> itSize = sizeList.iterator();
		boolean exist;
		while (itSize.hasNext()) {
			exist = false;
			Size size = (Size) itSize.next();
			for(int i = 0; i < sumList.size(); i ++){
				Size sum = sumList.get(i);
				if (sum.getYear().equals(size.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					sum.setArea(sum.area.add(size.area));
					sum.setOwnPropArea(sum.ownPropArea.add(size.ownPropArea));
					sum.setTotalArea(sum.totalArea.add(size.totalArea));
					sum.setSchOwnConArea(sum.schOwnConArea.add(size.schOwnConArea));
					sum.setStuArea(sum.stuArea.add(size.stuArea));
					sum.setTeaAuxArea(sum.teaAuxArea.add(size.teaAuxArea));
					sum.setTrainArea(sum.trainArea.add(size.trainArea));
					sum.setPsyArea(sum.psyArea.add(size.psyArea));
					/*sum.setAdminOfficeArea(sum.adminOfficeArea.add(size.adminOfficeArea));*/
					sum.setDormArea(sum.dormArea.add(size.dormArea));
					sum.setDormPerArea(sum.dormPerArea.add(size.dormPerArea));
					sum.setEnrollment(sum.enrollment+size.enrollment);
					sum.setAnnualGraduate(sum.annualGraduate+size.annualGraduate);
					sum.setTotalStudent(sum.totalStudent+size.totalStudent);
					sum.setMajors(sum.majors+size.majors);
					String sumTCValue = sum.threeConsol.replace("%", ""),
							sizeTCValue = size.threeConsol.replace("%", "");
					sum.setThreeConsol((Float.parseFloat(sumTCValue)+Float.parseFloat(sizeTCValue))+"");
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(size);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			sumList.get(i).setThreeConsol(new BigDecimal(Float.parseFloat(sumList.get(i).getThreeConsol().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
		}
		
		return sumList;
	}
	
	public static List<Size> avg(List<Size> sizeList) {
		if (sizeList == null) {
			return sizeList;
		}
		List<Size> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Size> itSize = sizeList.iterator();
		boolean exist;
		while (itSize.hasNext()) {
			exist = false;
			Size size = (Size) itSize.next();
			for(int i = 0; i < avgList.size(); i ++){
				Size avg = avgList.get(i);
				if (avg.getYear().equals(size.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setArea(avg.area.add(size.area));
					avg.setOwnPropArea(avg.ownPropArea.add(size.ownPropArea));
					avg.setTotalArea(avg.totalArea.add(size.totalArea));
					avg.setSchOwnConArea(avg.schOwnConArea.add(size.schOwnConArea));
					avg.setStuArea(avg.stuArea.add(size.stuArea));
					avg.setTeaAuxArea(avg.teaAuxArea.add(size.teaAuxArea));
					avg.setTrainArea(avg.trainArea.add(size.trainArea));
					avg.setPsyArea(avg.psyArea.add(size.psyArea));
					/*avg.setAdminOfficeArea(avg.adminOfficeArea.add(size.adminOfficeArea));*/
					avg.setDormArea(avg.dormArea.add(size.dormArea));
					avg.setDormPerArea(avg.dormPerArea.add(size.dormPerArea));
					avg.setEnrollment(avg.enrollment+size.enrollment);
					avg.setAnnualGraduate(avg.annualGraduate+size.annualGraduate);
					avg.setTotalStudent(avg.totalStudent+size.totalStudent);
					avg.setMajors(avg.majors+size.majors);
					String sumTCValue = avg.threeConsol.replace("%", ""),
							sizeTCValue = size.threeConsol.replace("%", "");
					avg.setThreeConsol((Float.parseFloat(sumTCValue)+Float.parseFloat(sizeTCValue))+"");
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(size);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			Size avg = (Size) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			avg.setArea(avg.area.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setOwnPropArea(avg.ownPropArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setTotalArea(avg.totalArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setSchOwnConArea(avg.schOwnConArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setStuArea(avg.stuArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setTeaAuxArea(avg.teaAuxArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setTrainArea(avg.trainArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setPsyArea(avg.psyArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			/*avg.setAdminOfficeArea(avg.adminOfficeArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));*/
			avg.setDormArea(avg.dormArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setDormPerArea(avg.dormPerArea.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setEnrollment(avg.enrollment/addendNum.get(i));
			avg.setAnnualGraduate(avg.annualGraduate/addendNum.get(i));
			avg.setTotalStudent(avg.totalStudent/addendNum.get(i));
			avg.setMajors(avg.majors/addendNum.get(i));
			avg.setThreeConsol(new BigDecimal(Float.parseFloat(avg.getThreeConsol().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
		}
		
		return avgList;
	}
}
