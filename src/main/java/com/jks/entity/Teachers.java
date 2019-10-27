package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Teachers {
    private Integer id;

    private String admcode;

    private String year;

    private String city;

    private Float staffnum;

    private Float staffadmin;

    private Float staffprepjob;

    private Float fulltime;

    private Float basiccourse;

    private Float course;

    private Float industryenterprise;

    private Float undergraless;

    private Float undergra;

    private Float fullpostgrad;

    private Float subhighmore;

    private Float intermediategrade;

    private Float juniortitle;

    private Float noconferteac;

    private Float threefiveless;

    private Float threesixfourfive;

    private Float foursixfivefive;

    private Float fivesixmore;

    private Float male;

    private Float female;

    private Float doubleteac;

    private BigDecimal courseclasshour;

    private Float induenterhour;

    private Float counselcertificate;

    private Float fulltimecounsel;

    private Float citydiscipleader;

    private Float provsuper;

    private BigDecimal fullclasshour;
    
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

    public Float getStaffnum() {
        return staffnum;
    }

    public void setStaffnum(Float staffnum) {
        this.staffnum = staffnum;
    }

    public Float getStaffadmin() {
        return staffadmin;
    }

    public void setStaffadmin(Float staffadmin) {
        this.staffadmin = staffadmin;
    }

    public Float getStaffprepjob() {
        return staffprepjob;
    }

    public void setStaffprepjob(Float staffprepjob) {
        this.staffprepjob = staffprepjob;
    }

    public Float getFulltime() {
        return fulltime;
    }

    public void setFulltime(Float fulltime) {
        this.fulltime = fulltime;
    }

    public Float getBasiccourse() {
        return basiccourse;
    }

    public void setBasiccourse(Float basiccourse) {
        this.basiccourse = basiccourse;
    }

    public Float getCourse() {
        return course;
    }

    public void setCourse(Float course) {
        this.course = course;
    }

    public Float getIndustryenterprise() {
        return industryenterprise;
    }

    public void setIndustryenterprise(Float industryenterprise) {
        this.industryenterprise = industryenterprise;
    }

    public Float getUndergraless() {
        return undergraless;
    }

    public void setUndergraless(Float undergraless) {
        this.undergraless = undergraless;
    }

    public Float getUndergra() {
        return undergra;
    }

    public void setUndergra(Float undergra) {
        this.undergra = undergra;
    }

    public Float getFullpostgrad() {
        return fullpostgrad;
    }

    public void setFullpostgrad(Float fullpostgrad) {
        this.fullpostgrad = fullpostgrad;
    }

    public Float getSubhighmore() {
        return subhighmore;
    }

    public void setSubhighmore(Float subhighmore) {
        this.subhighmore = subhighmore;
    }

    public Float getIntermediategrade() {
        return intermediategrade;
    }

    public void setIntermediategrade(Float intermediategrade) {
        this.intermediategrade = intermediategrade;
    }

    public Float getJuniortitle() {
        return juniortitle;
    }

    public void setJuniortitle(Float juniortitle) {
        this.juniortitle = juniortitle;
    }

    public Float getNoconferteac() {
        return noconferteac;
    }

    public void setNoconferteac(Float noconferteac) {
        this.noconferteac = noconferteac;
    }

    public Float getThreefiveless() {
        return threefiveless;
    }

    public void setThreefiveless(Float threefiveless) {
        this.threefiveless = threefiveless;
    }

    public Float getThreesixfourfive() {
        return threesixfourfive;
    }

    public void setThreesixfourfive(Float threesixfourfive) {
        this.threesixfourfive = threesixfourfive;
    }

    public Float getFoursixfivefive() {
        return foursixfivefive;
    }

    public void setFoursixfivefive(Float foursixfivefive) {
        this.foursixfivefive = foursixfivefive;
    }

    public Float getFivesixmore() {
        return fivesixmore;
    }

    public void setFivesixmore(Float fivesixmore) {
        this.fivesixmore = fivesixmore;
    }

    public Float getMale() {
        return male;
    }

    public void setMale(Float male) {
        this.male = male;
    }

    public Float getFemale() {
        return female;
    }

    public void setFemale(Float female) {
        this.female = female;
    }

    public Float getDoubleteac() {
        return doubleteac;
    }

    public void setDoubleteac(Float doubleteac) {
        this.doubleteac = doubleteac;
    }

    public BigDecimal getCourseclasshour() {
        return courseclasshour;
    }

    public void setCourseclasshour(BigDecimal courseclasshour) {
        this.courseclasshour = courseclasshour;
    }

    public Float getInduenterhour() {
        return induenterhour;
    }

    public void setInduenterhour(Float induenterhour) {
        this.induenterhour = induenterhour;
    }

    public Float getCounselcertificate() {
        return counselcertificate;
    }

    public void setCounselcertificate(Float counselcertificate) {
        this.counselcertificate = counselcertificate;
    }

    public Float getFulltimecounsel() {
        return fulltimecounsel;
    }

    public void setFulltimecounsel(Float fulltimecounsel) {
        this.fulltimecounsel = fulltimecounsel;
    }

    public Float getCitydiscipleader() {
        return citydiscipleader;
    }

    public void setCitydiscipleader(Float citydiscipleader) {
        this.citydiscipleader = citydiscipleader;
    }

    public Float getProvsuper() {
        return provsuper;
    }

    public void setProvsuper(Float provsuper) {
        this.provsuper = provsuper;
    }

    public BigDecimal getFullclasshour() {
        return fullclasshour;
    }

    public void setFullclasshour(BigDecimal fullclasshour) {
        this.fullclasshour = fullclasshour;
    }
    
    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
    
    @Override
	public String toString() {
		return "Teachers [id=" + id + ", admcode=" + admcode + ", year=" + year
				+ ", city=" + city + ", staffnum=" + staffnum + ", staffadmin="
				+ staffadmin + ", staffprepjob=" + staffprepjob + ", fulltime="
				+ fulltime + ", basiccourse=" + basiccourse + ", course="
				+ course + ", industryenterprise=" + industryenterprise
				+ ", undergraless=" + undergraless + ", undergra=" + undergra
				+ ", fullpostgrad=" + fullpostgrad + ", subhighmore="
				+ subhighmore + ", intermediategrade=" + intermediategrade
				+ ", juniortitle=" + juniortitle + ", noconferteac="
				+ noconferteac + ", threefiveless=" + threefiveless
				+ ", threesixfourfive=" + threesixfourfive
				+ ", foursixfivefive=" + foursixfivefive + ", fivesixmore="
				+ fivesixmore + ", male=" + male + ", female=" + female
				+ ", doubleteac=" + doubleteac + ", fullclasshour="
				+ fullclasshour + ", courseclasshour=" + courseclasshour
				+ ", induenterhour=" + induenterhour + ", counselcertificate="
				+ counselcertificate + ", fulltimecounsel=" + fulltimecounsel
				+ ", citydiscipleader=" + citydiscipleader + ", provsuper="
				+ provsuper + ", audit=" + audit + "]";
	}
	
	public static List<Teachers> sum(List<Teachers> teachersList) {
		if (teachersList == null) {
			return teachersList;
		}
		List<Teachers> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Teachers> itTeachers = teachersList.iterator();
		boolean exist;
		while (itTeachers.hasNext()) {
			exist = false;
			Teachers teachers = (Teachers) itTeachers.next();
			for(int i = 0; i < sumList.size(); i ++){
				Teachers sum = sumList.get(i);
				if (sum.getYear().equals(teachers.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					sum.setStaffnum(sum.staffnum+teachers.staffnum);
					sum.setStaffadmin(sum.staffadmin+teachers.staffadmin);
					sum.setStaffprepjob(sum.staffprepjob+teachers.staffprepjob);
					sum.setFulltime(sum.fulltime+teachers.fulltime);
					sum.setBasiccourse(sum.basiccourse+teachers.basiccourse);
					sum.setCourse(sum.course+teachers.course);
					sum.setIndustryenterprise(sum.industryenterprise+teachers.industryenterprise);
					sum.setUndergraless(sum.undergraless+teachers.undergraless);
					sum.setUndergra(sum.undergra+teachers.undergra);
					sum.setFullpostgrad(sum.fullpostgrad+teachers.fullpostgrad);
					sum.setSubhighmore(sum.subhighmore+teachers.subhighmore);
					sum.setIntermediategrade(sum.intermediategrade+teachers.intermediategrade);
					sum.setJuniortitle(sum.juniortitle+teachers.juniortitle);
					sum.setNoconferteac(sum.noconferteac+teachers.noconferteac);
					sum.setThreefiveless(sum.threefiveless+teachers.threefiveless);
					sum.setThreesixfourfive(sum.threesixfourfive+teachers.threesixfourfive);
					sum.setFoursixfivefive(sum.foursixfivefive+teachers.foursixfivefive);
					sum.setFivesixmore(sum.fivesixmore+teachers.fivesixmore);
					sum.setMale(sum.male+teachers.male);
					sum.setFemale(sum.female+teachers.female);
					sum.setDoubleteac(sum.doubleteac+teachers.doubleteac);
					sum.setFullclasshour(sum.fullclasshour.add(teachers.fullclasshour));
					sum.setCourseclasshour(sum.courseclasshour.add(teachers.courseclasshour));
					sum.setInduenterhour(sum.induenterhour+teachers.induenterhour);
					sum.setCounselcertificate(sum.counselcertificate+teachers.counselcertificate);
					sum.setFulltimecounsel(sum.fulltimecounsel+teachers.fulltimecounsel);
					sum.setCitydiscipleader(sum.citydiscipleader+teachers.citydiscipleader);
					sum.setProvsuper(sum.provsuper+teachers.provsuper);
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(teachers);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
		}
		
		return sumList;
	}
	
	public static List<Teachers> avg(List<Teachers> teachersList) {
		if (teachersList == null) {
			return teachersList;
		}
		List<Teachers> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Teachers> itTeachers = teachersList.iterator();
		boolean exist;
		while (itTeachers.hasNext()) {
			exist = false;
			Teachers teachers = (Teachers) itTeachers.next();
			for(int i = 0; i < avgList.size(); i ++){
				Teachers avg = avgList.get(i);
				if (avg.getYear().equals(teachers.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setStaffnum(avg.staffnum+teachers.staffnum);
					avg.setStaffadmin(avg.staffadmin+teachers.staffadmin);
					avg.setStaffprepjob(avg.staffprepjob+teachers.staffprepjob);
					avg.setFulltime(avg.fulltime+teachers.fulltime);
					avg.setBasiccourse(avg.basiccourse+teachers.basiccourse);
					avg.setCourse(avg.course+teachers.course);
					avg.setIndustryenterprise(avg.industryenterprise+teachers.industryenterprise);
					avg.setUndergraless(avg.undergraless+teachers.undergraless);
					avg.setUndergra(avg.undergra+teachers.undergra);
					avg.setFullpostgrad(avg.fullpostgrad+teachers.fullpostgrad);
					avg.setSubhighmore(avg.subhighmore+teachers.subhighmore);
					avg.setIntermediategrade(avg.intermediategrade+teachers.intermediategrade);
					avg.setJuniortitle(avg.juniortitle+teachers.juniortitle);
					avg.setNoconferteac(avg.noconferteac+teachers.noconferteac);
					avg.setThreefiveless(avg.threefiveless+teachers.threefiveless);
					avg.setThreesixfourfive(avg.threesixfourfive+teachers.threesixfourfive);
					avg.setFoursixfivefive(avg.foursixfivefive+teachers.foursixfivefive);
					avg.setFivesixmore(avg.fivesixmore+teachers.fivesixmore);
					avg.setMale(avg.male+teachers.male);
					avg.setFemale(avg.female+teachers.female);
					avg.setDoubleteac(avg.doubleteac+teachers.doubleteac);
					avg.setFullclasshour(avg.fullclasshour.add(teachers.fullclasshour));
					avg.setCourseclasshour(avg.courseclasshour.add(teachers.courseclasshour));
					avg.setInduenterhour(avg.induenterhour+teachers.induenterhour);
					avg.setCounselcertificate(avg.counselcertificate+teachers.counselcertificate);
					avg.setFulltimecounsel(avg.fulltimecounsel+teachers.fulltimecounsel);
					avg.setCitydiscipleader(avg.citydiscipleader+teachers.citydiscipleader);
					avg.setProvsuper(avg.provsuper+teachers.provsuper);
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(teachers);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			Teachers avg = (Teachers) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			avg.setStaffnum(avg.staffnum/addendNum.get(i));
			avg.setStaffadmin(avg.staffadmin/addendNum.get(i));
			avg.setStaffprepjob(avg.staffprepjob/addendNum.get(i));
			avg.setFulltime(avg.fulltime/addendNum.get(i));
			avg.setBasiccourse(avg.basiccourse/addendNum.get(i));
			avg.setCourse(avg.course/addendNum.get(i));
			avg.setIndustryenterprise(avg.industryenterprise/addendNum.get(i));
			avg.setUndergraless(avg.undergraless/addendNum.get(i));
			avg.setUndergra(avg.undergra/addendNum.get(i));
			avg.setFullpostgrad(avg.fullpostgrad/addendNum.get(i));
			avg.setSubhighmore(avg.subhighmore/addendNum.get(i));
			avg.setIntermediategrade(avg.intermediategrade/addendNum.get(i));
			avg.setJuniortitle(avg.juniortitle/addendNum.get(i));
			avg.setNoconferteac(avg.noconferteac/addendNum.get(i));
			avg.setThreefiveless(avg.threefiveless/addendNum.get(i));
			avg.setThreesixfourfive(avg.threesixfourfive/addendNum.get(i));
			avg.setFoursixfivefive(avg.foursixfivefive/addendNum.get(i));
			avg.setFivesixmore(avg.fivesixmore/addendNum.get(i));
			avg.setMale(avg.male/addendNum.get(i));
			avg.setFemale(avg.female/addendNum.get(i));
			avg.setDoubleteac(avg.doubleteac/addendNum.get(i));
			avg.setFullclasshour(avg.fullclasshour.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setCourseclasshour(avg.courseclasshour.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setInduenterhour(avg.induenterhour/addendNum.get(i));
			avg.setCounselcertificate(avg.counselcertificate/addendNum.get(i));
			avg.setFulltimecounsel(avg.fulltimecounsel/addendNum.get(i));
			avg.setCitydiscipleader(avg.citydiscipleader/addendNum.get(i));
			avg.setProvsuper(avg.provsuper/addendNum.get(i));
		}
		
		return avgList;
	}
}