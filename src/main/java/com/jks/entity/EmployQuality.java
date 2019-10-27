package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployQuality {
	private Integer id;

	private String admcode;

	private String year;

	private String city;

	private String employratefirst;

	private String coupartemployrate;

	private String sixmonthsteadrate;

	private BigDecimal firstemploymonincome;

	private String venturerate;

	private String stateown;

	private String privateown;

	private String foreignown;

	private String one;

	private String two;

	private String three;

	private Float soldier;

	private String collegeentance;

	private String couterpart;

	private String oneyearinner;

	private String oneyearouter;

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

	public String getEmployratefirst() {
		return employratefirst;
	}

	public void setEmployratefirst(String employratefirst) {
		this.employratefirst = employratefirst == null ? null : employratefirst.trim();
	}

	public String getCoupartemployrate() {
		return coupartemployrate;
	}

	public void setCoupartemployrate(String coupartemployrate) {
		this.coupartemployrate = coupartemployrate == null ? null : coupartemployrate.trim();
	}

	public String getSixmonthsteadrate() {
		return sixmonthsteadrate;
	}

	public void setSixmonthsteadrate(String sixmonthsteadrate) {
		this.sixmonthsteadrate = sixmonthsteadrate == null ? null : sixmonthsteadrate.trim();
	}

	public BigDecimal getFirstemploymonincome() {
		return firstemploymonincome;
	}

	public void setFirstemploymonincome(BigDecimal firstemploymonincome) {
		this.firstemploymonincome = firstemploymonincome;
	}

	public String getVenturerate() {
		return venturerate;
	}

	public void setVenturerate(String venturerate) {
		this.venturerate = venturerate == null ? null : venturerate.trim();
	}

	public String getStateown() {
		return stateown;
	}

	public void setStateown(String stateown) {
		this.stateown = stateown == null ? null : stateown.trim();
	}

	public String getPrivateown() {
		return privateown;
	}

	public void setPrivateown(String privateown) {
		this.privateown = privateown == null ? null : privateown.trim();
	}

	public String getForeignown() {
		return foreignown;
	}

	public void setForeignown(String foreignown) {
		this.foreignown = foreignown == null ? null : foreignown.trim();
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one == null ? null : one.trim();
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two == null ? null : two.trim();
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three == null ? null : three.trim();
	}

	public Float getSoldier() {
		return soldier;
	}

	public void setSoldier(Float soldier) {
		this.soldier = soldier;
	}

	public String getCollegeentance() {
		return collegeentance;
	}

	public void setCollegeentance(String collegeentance) {
		this.collegeentance = collegeentance == null ? null : collegeentance.trim();
	}

	public String getCouterpart() {
		return couterpart;
	}

	public void setCouterpart(String couterpart) {
		this.couterpart = couterpart == null ? null : couterpart.trim();
	}

	public String getOneyearinner() {
		return oneyearinner;
	}

	public void setOneyearinner(String oneyearinner) {
		this.oneyearinner = oneyearinner == null ? null : oneyearinner.trim();
	}

	public String getOneyearouter() {
		return oneyearouter;
	}

	public void setOneyearouter(String oneyearouter) {
		this.oneyearouter = oneyearouter == null ? null : oneyearouter.trim();
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	@Override
	public String toString() {
		return "EmployQuality [id=" + id + ", admcode=" + admcode + ", year=" + year + ", city=" + city
				+ ", employratefirst=" + employratefirst + ", coupartemployrate=" + coupartemployrate
				+ ", sixmonthsteadrate=" + sixmonthsteadrate + ", firstemploymonincome=" + firstemploymonincome
				+ ", venturerate=" + venturerate + ", stateown=" + stateown + ", privateown=" + privateown
				+ ", foreignown=" + foreignown + ", one=" + one + ", two=" + two + ", three=" + three + ", soldier="
				+ soldier + ", collegeentance=" + collegeentance + ", couterpart=" + couterpart + ", oneyearinner="
				+ oneyearinner + ", oneyearouter=" + oneyearouter + ", audit=" + audit + "]";
	}

	public static List<EmployQuality> sum(List<EmployQuality> employList) {
		if (employList == null) {
			return employList;
		}
		List<EmployQuality> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<EmployQuality> itEmployQuality = employList.iterator();
		boolean exist;
		while (itEmployQuality.hasNext()) {
			exist = false;
			EmployQuality employ = (EmployQuality) itEmployQuality.next();
			for (int i = 0; i < sumList.size(); i++) {
				EmployQuality sum = sumList.get(i);
				if (sum.getYear().equals(employ.getYear())) {
					addendNum.set(i, addendNum.get(i) + 1);

					sum.setEmployratefirst(Float.parseFloat(sum.employratefirst.replace("%", ""))
							+ Float.parseFloat(employ.employratefirst.replace("%", "")) + "");
					sum.setCoupartemployrate(Float.parseFloat(sum.coupartemployrate.replace("%", ""))
							+ Float.parseFloat(employ.coupartemployrate.replace("%", "")) + "");
					sum.setSixmonthsteadrate(Float.parseFloat(sum.sixmonthsteadrate.replace("%", ""))
							+ Float.parseFloat(employ.sixmonthsteadrate.replace("%", "")) + "");
					sum.setFirstemploymonincome(sum.firstemploymonincome.add(employ.firstemploymonincome));
					sum.setVenturerate(Float.parseFloat(sum.venturerate.replace("%", ""))
							+ Float.parseFloat(employ.venturerate.replace("%", "")) + "");
					sum.setStateown(Float.parseFloat(sum.stateown.replace("%", ""))
							+ Float.parseFloat(employ.stateown.replace("%", "")) + "");
					sum.setPrivateown(Float.parseFloat(sum.privateown.replace("%", ""))
							+ Float.parseFloat(employ.privateown.replace("%", "")) + "");
					sum.setForeignown(Float.parseFloat(sum.foreignown.replace("%", ""))
							+ Float.parseFloat(employ.foreignown.replace("%", "")) + "");
					sum.setOne(Float.parseFloat(sum.one.replace("%", ""))
							+ Float.parseFloat(employ.one.replace("%", "")) + "");
					sum.setTwo(Float.parseFloat(sum.two.replace("%", ""))
							+ Float.parseFloat(employ.two.replace("%", "")) + "");
					sum.setThree(Float.parseFloat(sum.three.replace("%", ""))
							+ Float.parseFloat(employ.three.replace("%", "")) + "");
					sum.setSoldier(sum.soldier + employ.soldier);
					sum.setCollegeentance(Float.parseFloat(sum.collegeentance.replace("%", ""))
							+ Float.parseFloat(employ.collegeentance.replace("%", "")) + "");
					sum.setCouterpart(Float.parseFloat(sum.couterpart.replace("%", ""))
							+ Float.parseFloat(employ.couterpart.replace("%", "")) + "");
					sum.setOneyearinner(Float.parseFloat(sum.oneyearinner.replace("%", ""))
							+ Float.parseFloat(employ.oneyearinner.replace("%", "")) + "");
					sum.setOneyearouter(Float.parseFloat(sum.oneyearouter.replace("%", ""))
							+ Float.parseFloat(employ.oneyearouter.replace("%", "")) + "");

					exist = true;
				}
			}
			if (!exist) {
				sumList.add(employ);
				addendNum.add(1);
			}
		}

		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());// 将admcode设为所在城市名，方便统一显示

			sumList.get(i).setEmployratefirst(
					new BigDecimal(Float.parseFloat(sumList.get(i).employratefirst.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i)
					.setCoupartemployrate(new BigDecimal(
							Float.parseFloat(sumList.get(i).coupartemployrate.replace("%", "")) / addendNum.get(i))
									.setScale(2, BigDecimal.ROUND_HALF_UP)
							+ "%");
			sumList.get(i)
					.setSixmonthsteadrate(new BigDecimal(
							Float.parseFloat(sumList.get(i).sixmonthsteadrate.replace("%", "")) / addendNum.get(i))
									.setScale(2, BigDecimal.ROUND_HALF_UP)
							+ "%");
			sumList.get(i).setVenturerate(
					new BigDecimal(Float.parseFloat(sumList.get(i).venturerate.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setStateown(
					new BigDecimal(Float.parseFloat(sumList.get(i).stateown.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setPrivateown(
					new BigDecimal(Float.parseFloat(sumList.get(i).privateown.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setForeignown(
					new BigDecimal(Float.parseFloat(sumList.get(i).foreignown.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i)
					.setOne(new BigDecimal(Float.parseFloat(sumList.get(i).one.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i)
					.setTwo(new BigDecimal(Float.parseFloat(sumList.get(i).two.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i)
					.setThree(new BigDecimal(Float.parseFloat(sumList.get(i).three.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setCollegeentance(
					new BigDecimal(Float.parseFloat(sumList.get(i).collegeentance.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setCouterpart(
					new BigDecimal(Float.parseFloat(sumList.get(i).couterpart.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setOneyearinner(
					new BigDecimal(Float.parseFloat(sumList.get(i).oneyearinner.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setOneyearouter(
					new BigDecimal(Float.parseFloat(sumList.get(i).oneyearouter.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
		}

		return sumList;
	}

	public static List<EmployQuality> avg(List<EmployQuality> employList) {
		if (employList == null) {
			return employList;
		}
		List<EmployQuality> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<EmployQuality> itEmployQuality = employList.iterator();
		boolean exist;
		while (itEmployQuality.hasNext()) {
			exist = false;
			EmployQuality employ = (EmployQuality) itEmployQuality.next();
			for (int i = 0; i < avgList.size(); i++) {
				EmployQuality avg = avgList.get(i);
				if (avg.getYear().equals(employ.getYear())) {
					addendNum.set(i, addendNum.get(i) + 1);

					avg.setEmployratefirst(Float.parseFloat(avg.employratefirst.replace("%", ""))
							+ Float.parseFloat(employ.employratefirst.replace("%", "")) + "");
					avg.setCoupartemployrate(Float.parseFloat(avg.coupartemployrate.replace("%", ""))
							+ Float.parseFloat(employ.coupartemployrate.replace("%", "")) + "");
					avg.setSixmonthsteadrate(Float.parseFloat(avg.sixmonthsteadrate.replace("%", ""))
							+ Float.parseFloat(employ.sixmonthsteadrate.replace("%", "")) + "");
					avg.setFirstemploymonincome(avg.firstemploymonincome.add(employ.firstemploymonincome));
					avg.setVenturerate(Float.parseFloat(avg.venturerate.replace("%", ""))
							+ Float.parseFloat(employ.venturerate.replace("%", "")) + "");
					avg.setStateown(Float.parseFloat(avg.stateown.replace("%", ""))
							+ Float.parseFloat(employ.stateown.replace("%", "")) + "");
					avg.setPrivateown(Float.parseFloat(avg.privateown.replace("%", ""))
							+ Float.parseFloat(employ.privateown.replace("%", "")) + "");
					avg.setForeignown(Float.parseFloat(avg.foreignown.replace("%", ""))
							+ Float.parseFloat(employ.foreignown.replace("%", "")) + "");
					avg.setOne(Float.parseFloat(avg.one.replace("%", ""))
							+ Float.parseFloat(employ.one.replace("%", "")) + "");
					avg.setTwo(Float.parseFloat(avg.two.replace("%", ""))
							+ Float.parseFloat(employ.two.replace("%", "")) + "");
					avg.setThree(Float.parseFloat(avg.three.replace("%", ""))
							+ Float.parseFloat(employ.three.replace("%", "")) + "");
					avg.setSoldier(avg.soldier + employ.soldier);
					avg.setCollegeentance(Float.parseFloat(avg.collegeentance.replace("%", ""))
							+ Float.parseFloat(employ.collegeentance.replace("%", "")) + "");
					avg.setCouterpart(Float.parseFloat(avg.couterpart.replace("%", ""))
							+ Float.parseFloat(employ.couterpart.replace("%", "")) + "");
					avg.setOneyearinner(Float.parseFloat(avg.oneyearinner.replace("%", ""))
							+ Float.parseFloat(employ.oneyearinner.replace("%", "")) + "");
					avg.setOneyearouter(Float.parseFloat(avg.oneyearouter.replace("%", ""))
							+ Float.parseFloat(employ.oneyearouter.replace("%", "")) + "");

					exist = true;
				}
			}
			if (!exist) {
				avgList.add(employ);
				addendNum.add(1);
			}
		}

		for (int i = 0; i < avgList.size(); i++) {
			EmployQuality avg = (EmployQuality) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity() + "平均值");// 将admcode设为所在城市名，方便统一显示

			avg.setEmployratefirst(
					new BigDecimal(Float.parseFloat(avg.employratefirst.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setCoupartemployrate(
					new BigDecimal(Float.parseFloat(avg.coupartemployrate.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setSixmonthsteadrate(
					new BigDecimal(Float.parseFloat(avg.sixmonthsteadrate.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setFirstemploymonincome(
					avg.firstemploymonincome.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setVenturerate(new BigDecimal(Float.parseFloat(avg.venturerate.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setStateown(new BigDecimal(Float.parseFloat(avg.stateown.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setPrivateown(new BigDecimal(Float.parseFloat(avg.privateown.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setForeignown(new BigDecimal(Float.parseFloat(avg.foreignown.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setOne(new BigDecimal(Float.parseFloat(avg.one.replace("%", "")) / addendNum.get(i)).setScale(2,
					BigDecimal.ROUND_HALF_UP) + "%");
			avg.setTwo(new BigDecimal(Float.parseFloat(avg.two.replace("%", "")) / addendNum.get(i)).setScale(2,
					BigDecimal.ROUND_HALF_UP) + "%");
			avg.setThree(new BigDecimal(Float.parseFloat(avg.three.replace("%", "")) / addendNum.get(i)).setScale(2,
					BigDecimal.ROUND_HALF_UP) + "%");
			avg.setSoldier(avg.soldier / addendNum.get(i));
			avg.setCollegeentance(
					new BigDecimal(Float.parseFloat(avg.collegeentance.replace("%", "")) / addendNum.get(i)).setScale(2,
							BigDecimal.ROUND_HALF_UP) + "%");
			avg.setCouterpart(new BigDecimal(Float.parseFloat(avg.couterpart.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setOneyearinner(new BigDecimal(Float.parseFloat(avg.oneyearinner.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setOneyearouter(new BigDecimal(Float.parseFloat(avg.oneyearouter.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
		}

		return avgList;
	}
}