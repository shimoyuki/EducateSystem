package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentQuality {
	private Integer id;

	private String admcode;

	private String year;

	private String city;

	private Integer moralequit;

	private String phycenter;

	private String advanced;

	private String moralbase;

	private String schoolspirit;

	private String managespirit;

	private String volunteer;

	private String redflag;

	private String otherhonor;

	private Float goodclass;

	private Float fulltimemoral;

	private Float moraltask;

	private Float moralnum;

	private String moralpart;

	private Float moraltext;

	private String assessoptimal;

	private String assessgood;

	private String assessmiddle;

	private String assesspoor;

	private String pyhconselper;

	private Float provgoodgrade;

	private Float provgoodcadre;

	private Float provgoodstud;

	private String provother;

	private Float crimerate;

	private Float campusviolence;

	private Float examdiscip;

	private Float joinorgan;

	private Float joinpraty;

	private Float socailvolun;

	private BigDecimal socailprac;

	private Float studentorgan;

	private Float organstu;

	private Float statecivil;

	private Float provincivil;

	private Float citycivil;

	private Float statefirstaward;

	private Float statesecondaward;

	private Float statethirdaward;

	private Float provinfirstaward;

	private Float provinsecondaward;

	private Float provinthirdaward;

	private Float cityfirstaward;

	private Float citysecondaward;

	private Float citythirdaward;

	private String oneconsol;

	private String twoconsol;

	private String threeconsol;

	private String cultdivipassrate;

	private String phyassesspassrate;

	private String profskillpassrate;

	private Float careercert;

	private String doubcert;

	private String gradrate;

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

	public Integer getMoralequit() {
		return moralequit;
	}

	public void setMoralequit(Integer moralequit) {
		this.moralequit = moralequit;
	}

	public String getPhycenter() {
		return phycenter;
	}

	public void setPhycenter(String phycenter) {
		this.phycenter = phycenter == null ? null : phycenter.trim();
	}

	public String getAdvanced() {
		return advanced;
	}

	public void setAdvanced(String advanced) {
		this.advanced = advanced == null ? null : advanced.trim();
	}

	public String getMoralbase() {
		return moralbase;
	}

	public void setMoralbase(String moralbase) {
		this.moralbase = moralbase == null ? null : moralbase.trim();
	}

	public String getSchoolspirit() {
		return schoolspirit;
	}

	public void setSchoolspirit(String schoolspirit) {
		this.schoolspirit = schoolspirit == null ? null : schoolspirit.trim();
	}

	public String getManagespirit() {
		return managespirit;
	}

	public void setManagespirit(String managespirit) {
		this.managespirit = managespirit == null ? null : managespirit.trim();
	}

	public String getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(String volunteer) {
		this.volunteer = volunteer == null ? null : volunteer.trim();
	}

	public String getRedflag() {
		return redflag;
	}

	public void setRedflag(String redflag) {
		this.redflag = redflag == null ? null : redflag.trim();
	}

	public String getOtherhonor() {
		return otherhonor;
	}

	public void setOtherhonor(String otherhonor) {
		this.otherhonor = otherhonor == null ? null : otherhonor.trim();
	}

	public Float getGoodclass() {
		return goodclass;
	}

	public void setGoodclass(Float goodclass) {
		this.goodclass = goodclass;
	}

	public Float getFulltimemoral() {
		return fulltimemoral;
	}

	public void setFulltimemoral(Float fulltimemoral) {
		this.fulltimemoral = fulltimemoral;
	}

	public Float getMoraltask() {
		return moraltask;
	}

	public void setMoraltask(Float moraltask) {
		this.moraltask = moraltask;
	}

	public Float getMoralnum() {
		return moralnum;
	}

	public void setMoralnum(Float moralnum) {
		this.moralnum = moralnum;
	}

	public String getMoralpart() {
		return moralpart;
	}

	public void setMoralpart(String moralpart) {
		this.moralpart = moralpart == null ? null : moralpart.trim();
	}

	public Float getMoraltext() {
		return moraltext;
	}

	public void setMoraltext(Float moraltext) {
		this.moraltext = moraltext;
	}

	public String getAssessoptimal() {
		return assessoptimal;
	}

	public void setAssessoptimal(String assessoptimal) {
		this.assessoptimal = assessoptimal == null ? null : assessoptimal.trim();
	}

	public String getAssessgood() {
		return assessgood;
	}

	public void setAssessgood(String assessgood) {
		this.assessgood = assessgood == null ? null : assessgood.trim();
	}

	public String getAssessmiddle() {
		return assessmiddle;
	}

	public void setAssessmiddle(String assessmiddle) {
		this.assessmiddle = assessmiddle == null ? null : assessmiddle.trim();
	}

	public String getAssesspoor() {
		return assesspoor;
	}

	public void setAssesspoor(String assesspoor) {
		this.assesspoor = assesspoor == null ? null : assesspoor.trim();
	}

	public String getPyhconselper() {
		return pyhconselper;
	}

	public void setPyhconselper(String pyhconselper) {
		this.pyhconselper = pyhconselper == null ? null : pyhconselper.trim();
	}

	public Float getProvgoodgrade() {
		return provgoodgrade;
	}

	public void setProvgoodgrade(Float provgoodgrade) {
		this.provgoodgrade = provgoodgrade;
	}

	public Float getProvgoodcadre() {
		return provgoodcadre;
	}

	public void setProvgoodcadre(Float provgoodcadre) {
		this.provgoodcadre = provgoodcadre;
	}

	public Float getProvgoodstud() {
		return provgoodstud;
	}

	public void setProvgoodstud(Float provgoodstud) {
		this.provgoodstud = provgoodstud;
	}

	public String getProvother() {
		return provother;
	}

	public void setProvother(String provother) {
		this.provother = provother == null ? null : provother.trim();
	}

	public Float getCrimerate() {
		return crimerate;
	}

	public void setCrimerate(Float crimerate) {
		this.crimerate = crimerate;
	}

	public Float getCampusviolence() {
		return campusviolence;
	}

	public void setCampusviolence(Float campusviolence) {
		this.campusviolence = campusviolence;
	}

	public Float getExamdiscip() {
		return examdiscip;
	}

	public void setExamdiscip(Float examdiscip) {
		this.examdiscip = examdiscip;
	}

	public Float getJoinorgan() {
		return joinorgan;
	}

	public void setJoinorgan(Float joinorgan) {
		this.joinorgan = joinorgan;
	}

	public Float getJoinpraty() {
		return joinpraty;
	}

	public void setJoinpraty(Float joinpraty) {
		this.joinpraty = joinpraty;
	}

	public Float getSocailvolun() {
		return socailvolun;
	}

	public void setSocailvolun(Float socailvolun) {
		this.socailvolun = socailvolun;
	}

	public BigDecimal getSocailprac() {
		return socailprac;
	}

	public void setSocailprac(BigDecimal socailprac) {
		this.socailprac = socailprac;
	}

	public Float getStudentorgan() {
		return studentorgan;
	}

	public void setStudentorgan(Float studentorgan) {
		this.studentorgan = studentorgan;
	}

	public Float getOrganstu() {
		return organstu;
	}

	public void setOrganstu(Float organstu) {
		this.organstu = organstu;
	}

	public Float getStatecivil() {
		return statecivil;
	}

	public void setStatecivil(Float statecivil) {
		this.statecivil = statecivil;
	}

	public Float getProvincivil() {
		return provincivil;
	}

	public void setProvincivil(Float provincivil) {
		this.provincivil = provincivil;
	}

	public Float getCitycivil() {
		return citycivil;
	}

	public void setCitycivil(Float citycivil) {
		this.citycivil = citycivil;
	}

	public Float getStatefirstaward() {
		return statefirstaward;
	}

	public void setStatefirstaward(Float statefirstaward) {
		this.statefirstaward = statefirstaward;
	}

	public Float getStatesecondaward() {
		return statesecondaward;
	}

	public void setStatesecondaward(Float statesecondaward) {
		this.statesecondaward = statesecondaward;
	}

	public Float getStatethirdaward() {
		return statethirdaward;
	}

	public void setStatethirdaward(Float statethirdaward) {
		this.statethirdaward = statethirdaward;
	}

	public Float getProvinfirstaward() {
		return provinfirstaward;
	}

	public void setProvinfirstaward(Float provinfirstaward) {
		this.provinfirstaward = provinfirstaward;
	}

	public Float getProvinsecondaward() {
		return provinsecondaward;
	}

	public void setProvinsecondaward(Float provinsecondaward) {
		this.provinsecondaward = provinsecondaward;
	}

	public Float getProvinthirdaward() {
		return provinthirdaward;
	}

	public void setProvinthirdaward(Float provinthirdaward) {
		this.provinthirdaward = provinthirdaward;
	}

	public Float getCityfirstaward() {
		return cityfirstaward;
	}

	public void setCityfirstaward(Float cityfirstaward) {
		this.cityfirstaward = cityfirstaward;
	}

	public Float getCitysecondaward() {
		return citysecondaward;
	}

	public void setCitysecondaward(Float citysecondaward) {
		this.citysecondaward = citysecondaward;
	}

	public Float getCitythirdaward() {
		return citythirdaward;
	}

	public void setCitythirdaward(Float citythirdaward) {
		this.citythirdaward = citythirdaward;
	}

	public String getOneconsol() {
		return oneconsol;
	}

	public void setOneconsol(String oneconsol) {
		this.oneconsol = oneconsol == null ? null : oneconsol.trim();
	}

	public String getTwoconsol() {
		return twoconsol;
	}

	public void setTwoconsol(String twoconsol) {
		this.twoconsol = twoconsol == null ? null : twoconsol.trim();
	}

	public String getThreeconsol() {
		return threeconsol;
	}

	public void setThreeconsol(String threeconsol) {
		this.threeconsol = threeconsol == null ? null : threeconsol.trim();
	}

	public String getCultdivipassrate() {
		return cultdivipassrate;
	}

	public void setCultdivipassrate(String cultdivipassrate) {
		this.cultdivipassrate = cultdivipassrate == null ? null : cultdivipassrate.trim();
	}

	public String getPhyassesspassrate() {
		return phyassesspassrate;
	}

	public void setPhyassesspassrate(String phyassesspassrate) {
		this.phyassesspassrate = phyassesspassrate == null ? null : phyassesspassrate.trim();
	}

	public String getProfskillpassrate() {
		return profskillpassrate;
	}

	public void setProfskillpassrate(String profskillpassrate) {
		this.profskillpassrate = profskillpassrate == null ? null : profskillpassrate.trim();
	}

	public Float getCareercert() {
		return careercert;
	}

	public void setCareercert(Float careercert) {
		this.careercert = careercert;
	}

	public String getDoubcert() {
		return doubcert;
	}

	public void setDoubcert(String doubcert) {
		this.doubcert = doubcert == null ? null : doubcert.trim();
	}

	public String getGradrate() {
		return gradrate;
	}

	public void setGradrate(String gradrate) {
		this.gradrate = gradrate == null ? null : gradrate.trim();
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	@Override
	public String toString() {
		return "StudentQuality [id=" + id + ", admcode=" + admcode + ", year=" + year + ", city=" + city
				+ ", moralequit=" + moralequit + ", phycenter=" + phycenter + ", advanced=" + advanced + ", moralbase="
				+ moralbase + ", schoolspirit=" + schoolspirit + ", managespirit=" + managespirit + ", volunteer="
				+ volunteer + ", redflag=" + redflag + ", otherhonor=" + otherhonor + ", goodclass=" + goodclass
				+ ", fulltimemoral=" + fulltimemoral + ", moraltask=" + moraltask + ", moralnum=" + moralnum
				+ ", moralpart=" + moralpart + ", moraltext=" + moraltext + ", assessoptimal=" + assessoptimal
				+ ", assessgood=" + assessgood + ", assessmiddle=" + assessmiddle + ", assesspoor=" + assesspoor
				+ ", pyhconselper=" + pyhconselper + ", provgoodgrade=" + provgoodgrade + ", provgoodcadre="
				+ provgoodcadre + ", provgoodstud=" + provgoodstud + ", provother=" + provother + ", crimerate="
				+ crimerate + ", campusviolence=" + campusviolence + ", examdiscip=" + examdiscip + ", joinorgan="
				+ joinorgan + ", joinpraty=" + joinpraty + ", socailvolun=" + socailvolun + ", socailprac=" + socailprac
				+ ", studentorgan=" + studentorgan + ", organstu=" + organstu + ", statecivil=" + statecivil
				+ ", provincivil=" + provincivil + ", citycivil=" + citycivil + ", statefirstaward=" + statefirstaward
				+ ", statesecondaward=" + statesecondaward + ", statethirdaward=" + statethirdaward
				+ ", provinfirstaward=" + provinfirstaward + ", provinsecondaward=" + provinsecondaward
				+ ", provinthirdaward=" + provinthirdaward + ", cityfirstaward=" + cityfirstaward + ", citysecondaward="
				+ citysecondaward + ", citythirdaward=" + citythirdaward + ", oneconsol=" + oneconsol + ", twoconsol="
				+ twoconsol + ", threeconsol=" + threeconsol + ", cultdivipassrate=" + cultdivipassrate
				+ ", phyassesspassrate=" + phyassesspassrate + ", profskillpassrate=" + profskillpassrate
				+ ", careercert=" + careercert + ", doubcert=" + doubcert + ", gradrate=" + gradrate + ", audit="
				+ audit + "]";
	}

	public static List<StudentQuality> sum(List<StudentQuality> studentList) {
		if (studentList == null) {
			return studentList;
		}
		List<StudentQuality> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<StudentQuality> itStudentQuality = studentList.iterator();
		boolean exist;
		while (itStudentQuality.hasNext()) {
			exist = false;
			StudentQuality student = (StudentQuality) itStudentQuality.next();
			for (int i = 0; i < sumList.size(); i++) {
				StudentQuality sum = sumList.get(i);
				if (sum.getYear().equals(student.getYear())) {
					addendNum.set(i, addendNum.get(i) + 1);

					sum.setGoodclass(sum.goodclass + student.goodclass);
					sum.setFulltimemoral(sum.fulltimemoral + student.fulltimemoral);
					sum.setMoraltask(sum.moraltask + student.moraltask);
					sum.setMoralnum(sum.moralnum + student.moralnum);
					sum.setMoralpart(Float.parseFloat(sum.moralpart.replace("%", ""))
							+ Float.parseFloat(student.moralpart.replace("%", "")) + "");
					sum.setMoraltext(sum.moraltext + student.moraltext);
					sum.setAssessoptimal(Float.parseFloat(sum.assessoptimal.replace("%", ""))
							+ Float.parseFloat(student.assessoptimal.replace("%", "")) + "");
					sum.setAssessgood(Float.parseFloat(sum.assessgood.replace("%", ""))
							+ Float.parseFloat(student.assessgood.replace("%", "")) + "");
					sum.setAssessmiddle(Float.parseFloat(sum.assessmiddle.replace("%", ""))
							+ Float.parseFloat(student.assessmiddle.replace("%", "")) + "");
					sum.setAssesspoor(Float.parseFloat(sum.assesspoor.replace("%", ""))
							+ Float.parseFloat(student.assesspoor.replace("%", "")) + "");
					sum.setPyhconselper(Float.parseFloat(sum.pyhconselper.replace("%", ""))
							+ Float.parseFloat(student.pyhconselper.replace("%", "")) + "");
					sum.setProvgoodgrade(sum.provgoodgrade + student.provgoodgrade);
					sum.setProvgoodcadre(sum.provgoodcadre + student.provgoodcadre);
					sum.setProvgoodstud(sum.provgoodstud + student.provgoodstud);
					sum.setCrimerate(sum.crimerate + student.crimerate);
					sum.setCampusviolence(sum.campusviolence + student.campusviolence);
					sum.setExamdiscip(sum.examdiscip + student.examdiscip);
					sum.setJoinorgan(sum.joinorgan + student.joinorgan);
					sum.setJoinpraty(sum.joinpraty + student.joinpraty);
					sum.setSocailvolun(sum.socailvolun + student.socailvolun);
					sum.setSocailprac(sum.socailprac.add(student.socailprac));
					sum.setStudentorgan(sum.studentorgan + student.studentorgan);
					sum.setOrganstu(sum.organstu + student.organstu);
					sum.setStatecivil(sum.statecivil + student.statecivil);
					sum.setProvincivil(sum.provincivil + student.provincivil);
					sum.setCitycivil(sum.citycivil + student.citycivil);
					sum.setStatefirstaward(sum.statefirstaward + student.statefirstaward);
					sum.setStatesecondaward(sum.statesecondaward + student.statesecondaward);
					sum.setStatethirdaward(sum.statethirdaward + student.statethirdaward);
					sum.setProvinfirstaward(sum.provinfirstaward + student.provinfirstaward);
					sum.setProvinsecondaward(sum.provinsecondaward + student.provinsecondaward);
					sum.setProvinthirdaward(sum.provinthirdaward + student.provinthirdaward);
					sum.setCityfirstaward(sum.cityfirstaward + student.cityfirstaward);
					sum.setCitysecondaward(sum.citysecondaward + student.citysecondaward);
					sum.setCitythirdaward(sum.citythirdaward + student.citythirdaward);
					sum.setOneconsol(Float.parseFloat(sum.oneconsol.replace("%", ""))
							+ Float.parseFloat(student.oneconsol.replace("%", "")) + "");
					sum.setTwoconsol(Float.parseFloat(sum.twoconsol.replace("%", ""))
							+ Float.parseFloat(student.twoconsol.replace("%", "")) + "");
					sum.setThreeconsol(Float.parseFloat(sum.threeconsol.replace("%", ""))
							+ Float.parseFloat(student.threeconsol.replace("%", "")) + "");
					sum.setCultdivipassrate(Float.parseFloat(sum.cultdivipassrate.replace("%", ""))
							+ Float.parseFloat(student.cultdivipassrate.replace("%", "")) + "");
					sum.setPhyassesspassrate(Float.parseFloat(sum.phyassesspassrate.replace("%", ""))
							+ Float.parseFloat(student.phyassesspassrate.replace("%", "")) + "");
					sum.setProfskillpassrate(Float.parseFloat(sum.profskillpassrate.replace("%", ""))
							+ Float.parseFloat(student.profskillpassrate.replace("%", "")) + "");
					sum.setCareercert(sum.careercert + student.careercert);
					sum.setDoubcert(Float.parseFloat(sum.doubcert.replace("%", ""))
							+ Float.parseFloat(student.doubcert.replace("%", "")) + "");
					sum.setGradrate(Float.parseFloat(sum.gradrate.replace("%", ""))
							+ Float.parseFloat(student.gradrate.replace("%", "")) + "");

					exist = true;
				}
			}
			if (!exist) {
				sumList.add(student);
				addendNum.add(1);
			}
		}

		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());// 将admcode设为所在城市名，方便统一显示

			sumList.get(i).setMoralpart(
					new BigDecimal(Float.parseFloat(sumList.get(i).moralpart.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");

			sumList.get(i).setAssessoptimal(
					new BigDecimal(Float.parseFloat(sumList.get(i).assessoptimal.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setAssessgood(
					new BigDecimal(Float.parseFloat(sumList.get(i).assessgood.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setAssessmiddle(
					new BigDecimal(Float.parseFloat(sumList.get(i).assessmiddle.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setAssesspoor(
					new BigDecimal(Float.parseFloat(sumList.get(i).assesspoor.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setPyhconselper(
					new BigDecimal(Float.parseFloat(sumList.get(i).pyhconselper.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setOneconsol(
					new BigDecimal(Float.parseFloat(sumList.get(i).oneconsol.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setTwoconsol(
					new BigDecimal(Float.parseFloat(sumList.get(i).twoconsol.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setThreeconsol(
					new BigDecimal(Float.parseFloat(sumList.get(i).threeconsol.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i)
					.setCultdivipassrate(new BigDecimal(
							Float.parseFloat(sumList.get(i).cultdivipassrate.replace("%", "")) / addendNum.get(i))
									.setScale(2, BigDecimal.ROUND_HALF_UP)
							+ "%");
			sumList.get(i)
					.setPhyassesspassrate(new BigDecimal(
							Float.parseFloat(sumList.get(i).phyassesspassrate.replace("%", "")) / addendNum.get(i))
									.setScale(2, BigDecimal.ROUND_HALF_UP)
							+ "%");
			sumList.get(i)
					.setProfskillpassrate(new BigDecimal(
							Float.parseFloat(sumList.get(i).profskillpassrate.replace("%", "")) / addendNum.get(i))
									.setScale(2, BigDecimal.ROUND_HALF_UP)
							+ "%");
			sumList.get(i).setDoubcert(
					new BigDecimal(Float.parseFloat(sumList.get(i).doubcert.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			sumList.get(i).setGradrate(
					new BigDecimal(Float.parseFloat(sumList.get(i).gradrate.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
		}

		return sumList;
	}

	public static List<StudentQuality> avg(List<StudentQuality> studentList) {
		if (studentList == null) {
			return studentList;
		}
		List<StudentQuality> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<StudentQuality> itStudentQuality = studentList.iterator();
		boolean exist;
		while (itStudentQuality.hasNext()) {
			exist = false;
			StudentQuality student = (StudentQuality) itStudentQuality.next();
			for (int i = 0; i < avgList.size(); i++) {
				StudentQuality avg = avgList.get(i);
				if (avg.getYear().equals(student.getYear())) {
					addendNum.set(i, addendNum.get(i) + 1);

					avg.setGoodclass(avg.goodclass + student.goodclass);
					avg.setFulltimemoral(avg.fulltimemoral + student.fulltimemoral);
					avg.setMoraltask(avg.moraltask + student.moraltask);
					avg.setMoralnum(avg.moralnum + student.moralnum);
					avg.setMoralpart(Float.parseFloat(avg.moralpart.replace("%", ""))
							+ Float.parseFloat(student.moralpart.replace("%", "")) + "");
					avg.setMoraltext(avg.moraltext + student.moraltext);
					avg.setAssessoptimal(Float.parseFloat(avg.assessoptimal.replace("%", ""))
							+ Float.parseFloat(student.assessoptimal.replace("%", "")) + "");
					avg.setAssessgood(Float.parseFloat(avg.assessgood.replace("%", ""))
							+ Float.parseFloat(student.assessgood.replace("%", "")) + "");
					avg.setAssessmiddle(Float.parseFloat(avg.assessmiddle.replace("%", ""))
							+ Float.parseFloat(student.assessmiddle.replace("%", "")) + "");
					avg.setAssesspoor(Float.parseFloat(avg.assesspoor.replace("%", ""))
							+ Float.parseFloat(student.assesspoor.replace("%", "")) + "");
					avg.setPyhconselper(Float.parseFloat(avg.pyhconselper.replace("%", ""))
							+ Float.parseFloat(student.pyhconselper.replace("%", "")) + "");
					avg.setProvgoodgrade(avg.provgoodgrade + student.provgoodgrade);
					avg.setProvgoodcadre(avg.provgoodcadre + student.provgoodcadre);
					avg.setProvgoodstud(avg.provgoodstud + student.provgoodstud);
					avg.setCrimerate(avg.crimerate + student.crimerate);
					avg.setCampusviolence(avg.campusviolence + student.campusviolence);
					avg.setExamdiscip(avg.examdiscip + student.examdiscip);
					avg.setJoinorgan(avg.joinorgan + student.joinorgan);
					avg.setJoinpraty(avg.joinpraty + student.joinpraty);
					avg.setSocailvolun(avg.socailvolun + student.socailvolun);
					avg.setSocailprac(avg.socailprac.add(student.socailprac));
					avg.setStudentorgan(avg.studentorgan + student.studentorgan);
					avg.setOrganstu(avg.organstu + student.organstu);
					avg.setStatecivil(avg.statecivil + student.statecivil);
					avg.setProvincivil(avg.provincivil + student.provincivil);
					avg.setCitycivil(avg.citycivil + student.citycivil);
					avg.setStatefirstaward(avg.statefirstaward + student.statefirstaward);
					avg.setStatesecondaward(avg.statesecondaward + student.statesecondaward);
					avg.setStatethirdaward(avg.statethirdaward + student.statethirdaward);
					avg.setProvinfirstaward(avg.provinfirstaward + student.provinfirstaward);
					avg.setProvinsecondaward(avg.provinsecondaward + student.provinsecondaward);
					avg.setProvinthirdaward(avg.provinthirdaward + student.provinthirdaward);
					avg.setCityfirstaward(avg.cityfirstaward + student.cityfirstaward);
					avg.setCitysecondaward(avg.citysecondaward + student.citysecondaward);
					avg.setCitythirdaward(avg.citythirdaward + student.citythirdaward);
					avg.setOneconsol(Float.parseFloat(avg.oneconsol.replace("%", ""))
							+ Float.parseFloat(student.oneconsol.replace("%", "")) + "");
					avg.setTwoconsol(Float.parseFloat(avg.twoconsol.replace("%", ""))
							+ Float.parseFloat(student.twoconsol.replace("%", "")) + "");
					avg.setThreeconsol(Float.parseFloat(avg.threeconsol.replace("%", ""))
							+ Float.parseFloat(student.threeconsol.replace("%", "")) + "");
					avg.setCultdivipassrate(Float.parseFloat(avg.cultdivipassrate.replace("%", ""))
							+ Float.parseFloat(student.cultdivipassrate.replace("%", "")) + "");
					avg.setPhyassesspassrate(Float.parseFloat(avg.phyassesspassrate.replace("%", ""))
							+ Float.parseFloat(student.phyassesspassrate.replace("%", "")) + "");
					avg.setProfskillpassrate(Float.parseFloat(avg.profskillpassrate.replace("%", ""))
							+ Float.parseFloat(student.profskillpassrate.replace("%", "")) + "");
					avg.setCareercert(avg.careercert + student.careercert);
					avg.setDoubcert(Float.parseFloat(avg.doubcert.replace("%", ""))
							+ Float.parseFloat(student.doubcert.replace("%", "")) + "");
					avg.setGradrate(Float.parseFloat(avg.gradrate.replace("%", ""))
							+ Float.parseFloat(student.gradrate.replace("%", "")) + "");

					exist = true;
				}
			}
			if (!exist) {
				avgList.add(student);
				addendNum.add(1);
			}
		}

		for (int i = 0; i < avgList.size(); i++) {
			StudentQuality avg = (StudentQuality) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity() + "平均值");// 将admcode设为所在城市名，方便统一显示

			avg.setGoodclass(avg.goodclass / addendNum.get(i));
			avg.setFulltimemoral(avg.fulltimemoral / addendNum.get(i));
			avg.setMoraltask(avg.moraltask / addendNum.get(i));
			avg.setMoralnum(avg.moralnum / addendNum.get(i));
			avg.setMoralpart(new BigDecimal(Float.parseFloat(avg.moralpart.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setMoraltext(avg.moraltext / addendNum.get(i));
			avg.setAssessoptimal(new BigDecimal(Float.parseFloat(avg.assessoptimal.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setAssessgood(new BigDecimal(Float.parseFloat(avg.assessgood.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setAssessmiddle(new BigDecimal(Float.parseFloat(avg.assessmiddle.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setAssesspoor(new BigDecimal(Float.parseFloat(avg.assesspoor.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setPyhconselper(new BigDecimal(Float.parseFloat(avg.pyhconselper.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setProvgoodgrade(avg.provgoodgrade / addendNum.get(i));
			avg.setProvgoodcadre(avg.provgoodcadre / addendNum.get(i));
			avg.setProvgoodstud(avg.provgoodstud / addendNum.get(i));
			avg.setCrimerate(avg.crimerate / addendNum.get(i));
			avg.setCampusviolence(avg.campusviolence / addendNum.get(i));
			avg.setExamdiscip(avg.examdiscip / addendNum.get(i));
			avg.setJoinorgan(avg.joinorgan / addendNum.get(i));
			avg.setJoinpraty(avg.joinpraty / addendNum.get(i));
			avg.setSocailvolun(avg.socailvolun / addendNum.get(i));
			avg.setSocailprac(avg.socailprac.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setStudentorgan(avg.studentorgan / addendNum.get(i));
			avg.setOrganstu(avg.organstu / addendNum.get(i));
			avg.setStatecivil(avg.statecivil / addendNum.get(i));
			avg.setProvincivil(avg.provincivil / addendNum.get(i));
			avg.setCitycivil(avg.citycivil / addendNum.get(i));
			avg.setStatefirstaward(avg.statefirstaward / addendNum.get(i));
			avg.setStatesecondaward(avg.statesecondaward / addendNum.get(i));
			avg.setStatethirdaward(avg.statethirdaward / addendNum.get(i));
			avg.setProvinfirstaward(avg.provinfirstaward / addendNum.get(i));
			avg.setProvinsecondaward(avg.provinsecondaward / addendNum.get(i));
			avg.setProvinthirdaward(avg.provinthirdaward / addendNum.get(i));
			avg.setCityfirstaward(avg.cityfirstaward / addendNum.get(i));
			avg.setCitysecondaward(avg.citysecondaward / addendNum.get(i));
			avg.setCitythirdaward(avg.citythirdaward / addendNum.get(i));
			avg.setOneconsol(new BigDecimal(Float.parseFloat(avg.oneconsol.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setTwoconsol(new BigDecimal(Float.parseFloat(avg.twoconsol.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setThreeconsol(new BigDecimal(Float.parseFloat(avg.threeconsol.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setCultdivipassrate(
					new BigDecimal(Float.parseFloat(avg.cultdivipassrate.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setPhyassesspassrate(
					new BigDecimal(Float.parseFloat(avg.phyassesspassrate.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setProfskillpassrate(
					new BigDecimal(Float.parseFloat(avg.profskillpassrate.replace("%", "")) / addendNum.get(i))
							.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setCareercert(avg.careercert / addendNum.get(i));
			avg.setDoubcert(new BigDecimal(Float.parseFloat(avg.doubcert.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
			avg.setGradrate(new BigDecimal(Float.parseFloat(avg.gradrate.replace("%", "")) / addendNum.get(i))
					.setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
		}

		return avgList;
	}

}