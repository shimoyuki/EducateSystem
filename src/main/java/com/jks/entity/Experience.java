package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Experience {
    private Integer id;

    private String admcode;

    private String year;

    private String city;

    private String theorybest;

    private String theorygood;

    private String theorybad;

    private String majorbest;

    private String majorgood;

    private String majorbad;

    private String internshipbest;

    private String internshipgood;

    private String internshipbad;

    private String campusbest;

    private String campusgood;

    private String campusbad;

    private String lifebest;

    private String lifegood;

    private String lifebad;

    private String safetybest;

    private String safetygood;

    private String safetybad;

    private String graduatebest;

    private String graduategood;

    private String graduatebad;

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

    public String getTheorybest() {
        return theorybest;
    }

    public void setTheorybest(String theorybest) {
        this.theorybest = theorybest == null ? null : theorybest.trim();
    }

    public String getTheorygood() {
        return theorygood;
    }

    public void setTheorygood(String theorygood) {
        this.theorygood = theorygood == null ? null : theorygood.trim();
    }

    public String getTheorybad() {
        return theorybad;
    }

    public void setTheorybad(String theorybad) {
        this.theorybad = theorybad == null ? null : theorybad.trim();
    }

    public String getMajorbest() {
        return majorbest;
    }

    public void setMajorbest(String majorbest) {
        this.majorbest = majorbest == null ? null : majorbest.trim();
    }

    public String getMajorgood() {
        return majorgood;
    }

    public void setMajorgood(String majorgood) {
        this.majorgood = majorgood == null ? null : majorgood.trim();
    }

    public String getMajorbad() {
        return majorbad;
    }

    public void setMajorbad(String majorbad) {
        this.majorbad = majorbad == null ? null : majorbad.trim();
    }

    public String getInternshipbest() {
        return internshipbest;
    }

    public void setInternshipbest(String internshipbest) {
        this.internshipbest = internshipbest == null ? null : internshipbest.trim();
    }

    public String getInternshipgood() {
        return internshipgood;
    }

    public void setInternshipgood(String internshipgood) {
        this.internshipgood = internshipgood == null ? null : internshipgood.trim();
    }

    public String getInternshipbad() {
        return internshipbad;
    }

    public void setInternshipbad(String internshipbad) {
        this.internshipbad = internshipbad == null ? null : internshipbad.trim();
    }

    public String getCampusbest() {
        return campusbest;
    }

    public void setCampusbest(String campusbest) {
        this.campusbest = campusbest == null ? null : campusbest.trim();
    }

    public String getCampusgood() {
        return campusgood;
    }

    public void setCampusgood(String campusgood) {
        this.campusgood = campusgood == null ? null : campusgood.trim();
    }

    public String getCampusbad() {
        return campusbad;
    }

    public void setCampusbad(String campusbad) {
        this.campusbad = campusbad == null ? null : campusbad.trim();
    }

    public String getLifebest() {
        return lifebest;
    }

    public void setLifebest(String lifebest) {
        this.lifebest = lifebest == null ? null : lifebest.trim();
    }

    public String getLifegood() {
        return lifegood;
    }

    public void setLifegood(String lifegood) {
        this.lifegood = lifegood == null ? null : lifegood.trim();
    }

    public String getLifebad() {
        return lifebad;
    }

    public void setLifebad(String lifebad) {
        this.lifebad = lifebad == null ? null : lifebad.trim();
    }

    public String getSafetybest() {
        return safetybest;
    }

    public void setSafetybest(String safetybest) {
        this.safetybest = safetybest == null ? null : safetybest.trim();
    }

    public String getSafetygood() {
        return safetygood;
    }

    public void setSafetygood(String safetygood) {
        this.safetygood = safetygood == null ? null : safetygood.trim();
    }

    public String getSafetybad() {
        return safetybad;
    }

    public void setSafetybad(String safetybad) {
        this.safetybad = safetybad == null ? null : safetybad.trim();
    }

    public String getGraduatebest() {
        return graduatebest;
    }

    public void setGraduatebest(String graduatebest) {
        this.graduatebest = graduatebest == null ? null : graduatebest.trim();
    }

    public String getGraduategood() {
        return graduategood;
    }

    public void setGraduategood(String graduategood) {
        this.graduategood = graduategood == null ? null : graduategood.trim();
    }

    public String getGraduatebad() {
        return graduatebad;
    }

    public void setGraduatebad(String graduatebad) {
        this.graduatebad = graduatebad == null ? null : graduatebad.trim();
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

	@Override
	public String toString() {
		return "Experience [id=" + id + ", admcode=" + admcode + ", year="
				+ year + ", city=" + city + ", theorybest=" + theorybest
				+ ", theorygood=" + theorygood + ", theorybad=" + theorybad
				+ ", majorbest=" + majorbest + ", majorgood=" + majorgood
				+ ", majorbad=" + majorbad + ", internshipbest="
				+ internshipbest + ", internshipgood=" + internshipgood
				+ ", internshipbad=" + internshipbad + ", campusbest="
				+ campusbest + ", campusgood=" + campusgood + ", campusbad="
				+ campusbad + ", lifebest=" + lifebest + ", lifegood="
				+ lifegood + ", lifebad=" + lifebad + ", safetybest="
				+ safetybest + ", safetygood=" + safetygood + ", safetybad="
				+ safetybad + ", graduatebest=" + graduatebest
				+ ", graduategood=" + graduategood + ", graduatebad="
				+ graduatebad + ", audit=" + audit + "]";
	}
    
	public static List<Experience> sum(List<Experience> experienceList) {
		if (experienceList == null) {
			return experienceList;
		}
		List<Experience> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Experience> itExperience = experienceList.iterator();
		boolean exist;
		while (itExperience.hasNext()) {
			exist = false;
			Experience experience = (Experience) itExperience.next();
			for (int i = 0; i < sumList.size(); i++) {
				Experience sum = sumList.get(i);
				if (sum.getYear().equals(experience.getYear())) {
					addendNum.set(i, addendNum.get(i) + 1);

					sum.setTheorybest(Float.parseFloat(sum.theorybest.replace("%", ""))
							+ Float.parseFloat(experience.theorybest.replace("%", "")) + "");
					sum.setTheorygood(Float.parseFloat(sum.theorygood.replace("%", ""))
							+ Float.parseFloat(experience.theorygood.replace("%", "")) + "");
					sum.setTheorybad(Float.parseFloat(sum.theorybad.replace("%", ""))
							+ Float.parseFloat(experience.theorybad.replace("%", "")) + "");
					
					sum.setMajorbest(Float.parseFloat(sum.majorbest.replace("%", ""))
							+ Float.parseFloat(experience.majorbest.replace("%", "")) + "");
					sum.setMajorgood(Float.parseFloat(sum.majorgood.replace("%", ""))
							+ Float.parseFloat(experience.majorgood.replace("%", "")) + "");
					sum.setMajorbad(Float.parseFloat(sum.majorbad.replace("%", ""))
							+ Float.parseFloat(experience.majorbad.replace("%", "")) + "");
					
					sum.setInternshipbest(Float.parseFloat(sum.internshipbest.replace("%", ""))
							+ Float.parseFloat(experience.internshipbest.replace("%", "")) + "");
					sum.setInternshipgood(Float.parseFloat(sum.internshipgood.replace("%", ""))
							+ Float.parseFloat(experience.internshipgood.replace("%", "")) + "");
					sum.setInternshipbad(Float.parseFloat(sum.internshipbad.replace("%", ""))
							+ Float.parseFloat(experience.internshipbad.replace("%", "")) + "");
					
					sum.setCampusbest(Float.parseFloat(sum.campusbest.replace("%", ""))
							+ Float.parseFloat(experience.campusbest.replace("%", "")) + "");
					sum.setCampusgood(Float.parseFloat(sum.campusgood.replace("%", ""))
							+ Float.parseFloat(experience.campusgood.replace("%", "")) + "");
					sum.setCampusbad(Float.parseFloat(sum.campusbad.replace("%", ""))
							+ Float.parseFloat(experience.campusbad.replace("%", "")) + "");
					
					sum.setLifebest(Float.parseFloat(sum.lifebest.replace("%", ""))
							+ Float.parseFloat(experience.lifebest.replace("%", "")) + "");
					sum.setLifegood(Float.parseFloat(sum.lifegood.replace("%", ""))
							+ Float.parseFloat(experience.lifegood.replace("%", "")) + "");
					sum.setLifebad(Float.parseFloat(sum.lifebad.replace("%", ""))
							+ Float.parseFloat(experience.lifebad.replace("%", "")) + "");
					
					sum.setSafetybest(Float.parseFloat(sum.safetybest.replace("%", ""))
							+ Float.parseFloat(experience.safetybest.replace("%", "")) + "");
					sum.setSafetygood(Float.parseFloat(sum.safetygood.replace("%", ""))
							+ Float.parseFloat(experience.safetygood.replace("%", "")) + "");
					sum.setSafetybad(Float.parseFloat(sum.safetybad.replace("%", ""))
							+ Float.parseFloat(experience.safetybad.replace("%", "")) + "");
					
					sum.setGraduatebest(Float.parseFloat(sum.graduatebest.replace("%", ""))
							+ Float.parseFloat(experience.graduatebest.replace("%", "")) + "");
					sum.setGraduategood(Float.parseFloat(sum.graduategood.replace("%", ""))
							+ Float.parseFloat(experience.graduategood.replace("%", "")) + "");
					sum.setGraduatebad(Float.parseFloat(sum.graduatebad.replace("%", ""))
							+ Float.parseFloat(experience.graduatebad.replace("%", "")) + "");
					
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(experience);
				addendNum.add(1);
			}
		}

		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());// 将admcode设为所在城市名，方便统一显示

			sumList.get(i).setTheorybest(new BigDecimal(Float.parseFloat(sumList.get(i).theorybest.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setTheorygood(new BigDecimal(Float.parseFloat(sumList.get(i).theorygood.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setTheorybad(new BigDecimal(Float.parseFloat(sumList.get(i).theorybad.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			
			sumList.get(i).setMajorbest(new BigDecimal(Float.parseFloat(sumList.get(i).majorbest.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setMajorgood(new BigDecimal(Float.parseFloat(sumList.get(i).majorgood.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setMajorbad(new BigDecimal(Float.parseFloat(sumList.get(i).majorbad.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			
			sumList.get(i).setInternshipbest(new BigDecimal(Float.parseFloat(sumList.get(i).internshipbest.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setInternshipgood(new BigDecimal(Float.parseFloat(sumList.get(i).internshipgood.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setInternshipbad(new BigDecimal(Float.parseFloat(sumList.get(i).internshipbad.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			
			sumList.get(i).setCampusbest(new BigDecimal(Float.parseFloat(sumList.get(i).campusbest.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setCampusgood(new BigDecimal(Float.parseFloat(sumList.get(i).campusgood.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setCampusbad(new BigDecimal(Float.parseFloat(sumList.get(i).campusbad.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			
			sumList.get(i).setLifebest(new BigDecimal(Float.parseFloat(sumList.get(i).lifebest.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setLifegood(new BigDecimal(Float.parseFloat(sumList.get(i).lifegood.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setLifebad(new BigDecimal(Float.parseFloat(sumList.get(i).lifebad.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			
			sumList.get(i).setSafetybest(new BigDecimal(Float.parseFloat(sumList.get(i).safetybest.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setSafetygood(new BigDecimal(Float.parseFloat(sumList.get(i).safetygood.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setSafetybad(new BigDecimal(Float.parseFloat(sumList.get(i).safetybad.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			
			sumList.get(i).setGraduatebest(new BigDecimal(Float.parseFloat(sumList.get(i).graduatebest.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setGraduategood(new BigDecimal(Float.parseFloat(sumList.get(i).graduategood.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setGraduatebad(new BigDecimal(Float.parseFloat(sumList.get(i).graduatebad.replace("%", "")) / addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
		}

		return sumList;
	}

	public static List<Experience> avg(List<Experience> experienceList) {
		return Experience.sum(experienceList);
	}
}