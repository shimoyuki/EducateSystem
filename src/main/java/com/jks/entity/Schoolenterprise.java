package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Schoolenterprise {
    private Integer id;

    private String admcode;

    private String year;

    private String city;

    private Float majornum;

    private Float coopagreeenterp;

    private Float coopagreemajor;

    private Float coopenterpjointeachmajor;

    private Float coopenterpjointeachteacher;

    private Float coopenterpjointeachclass;

   private BigDecimal coopenterpfund;

    private BigDecimal coopenterparrivalfund;

    private BigDecimal coopenterpequitworth;

    private Float enterpbuildreseadevelop;

    private Float offschoteachertrainbase;

    private BigDecimal prodtrainbaseval;

    private Float schoenterpcooporderclassnum;

    private Float schoenterpdevelopcourse;

    private BigDecimal fullenterprac;

    private BigDecimal fullentertime;

    private String parttimeclassradio;

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

    public Float getMajornum() {
        return majornum;
    }

    public void setMajornum(Float majornum) {
        this.majornum = majornum;
    }

    public Float getCoopagreeenterp() {
        return coopagreeenterp;
    }

    public void setCoopagreeenterp(Float coopagreeenterp) {
        this.coopagreeenterp = coopagreeenterp;
    }

    public Float getCoopagreemajor() {
        return coopagreemajor;
    }

    public void setCoopagreemajor(Float coopagreemajor) {
        this.coopagreemajor = coopagreemajor;
    }

    public Float getCoopenterpjointeachmajor() {
        return coopenterpjointeachmajor;
    }

    public void setCoopenterpjointeachmajor(Float coopenterpjointeachmajor) {
        this.coopenterpjointeachmajor = coopenterpjointeachmajor;
    }

    public Float getCoopenterpjointeachteacher() {
        return coopenterpjointeachteacher;
    }

    public void setCoopenterpjointeachteacher(Float coopenterpjointeachteacher) {
        this.coopenterpjointeachteacher = coopenterpjointeachteacher;
    }

    public Float getCoopenterpjointeachclass() {
        return coopenterpjointeachclass;
    }

    public void setCoopenterpjointeachclass(Float coopenterpjointeachclass) {
        this.coopenterpjointeachclass = coopenterpjointeachclass;
    }

    public BigDecimal getCoopenterpfund() {
        return coopenterpfund;
    }

    public void setCoopenterpfund(BigDecimal coopenterpfund) {
        this.coopenterpfund = coopenterpfund;
    }

    public BigDecimal getCoopenterparrivalfund() {
        return coopenterparrivalfund;
    }

    public void setCoopenterparrivalfund(BigDecimal coopenterparrivalfund) {
        this.coopenterparrivalfund = coopenterparrivalfund;
    }

    public BigDecimal getCoopenterpequitworth() {
        return coopenterpequitworth;
    }

    public void setCoopenterpequitworth(BigDecimal coopenterpequitworth) {
        this.coopenterpequitworth = coopenterpequitworth;
    }

    public Float getEnterpbuildreseadevelop() {
        return enterpbuildreseadevelop;
    }

    public void setEnterpbuildreseadevelop(Float enterpbuildreseadevelop) {
        this.enterpbuildreseadevelop = enterpbuildreseadevelop;
    }

    public Float getOffschoteachertrainbase() {
        return offschoteachertrainbase;
    }

    public void setOffschoteachertrainbase(Float offschoteachertrainbase) {
        this.offschoteachertrainbase = offschoteachertrainbase;
    }

    public BigDecimal getProdtrainbaseval() {
        return prodtrainbaseval;
    }

    public void setProdtrainbaseval(BigDecimal prodtrainbaseval) {
        this.prodtrainbaseval = prodtrainbaseval;
    }

    public Float getSchoenterpcooporderclassnum() {
        return schoenterpcooporderclassnum;
    }

    public void setSchoenterpcooporderclassnum(Float schoenterpcooporderclassnum) {
        this.schoenterpcooporderclassnum = schoenterpcooporderclassnum;
    }

    public Float getSchoenterpdevelopcourse() {
        return schoenterpdevelopcourse;
    }

    public void setSchoenterpdevelopcourse(Float schoenterpdevelopcourse) {
        this.schoenterpdevelopcourse = schoenterpdevelopcourse;
    }

    public BigDecimal getFullenterprac() {
        return fullenterprac;
    }

    public void setFullenterprac(BigDecimal fullenterprac) {
        this.fullenterprac = fullenterprac;
    }

    public BigDecimal getFullentertime() {
        return fullentertime;
    }

    public void setFullentertime(BigDecimal fullentertime) {
        this.fullentertime = fullentertime;
    }

    public String getParttimeclassradio() {
        return parttimeclassradio;
    }

    public void setParttimeclassradio(String parttimeclassradio) {
        this.parttimeclassradio = parttimeclassradio == null ? null : parttimeclassradio.trim();
    }

   public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
    
    @Override
	public String toString() {
		return "Schoolenterprise [id=" + id + ", admcode=" + admcode + ", year=" + year + ", city=" + city
				+ ", majornum=" + majornum + ", coopagreeenterp=" + coopagreeenterp + ", coopagreemajor="
				+ coopagreemajor + ", coopenterpjointeachmajor=" + coopenterpjointeachmajor
				+ ", coopenterpjointeachteacher=" + coopenterpjointeachteacher + ", coopenterpjointeachclass="
				+ coopenterpjointeachclass + ", coopenterpfund=" + coopenterpfund + ", coopenterparrivalfund="
				+ coopenterparrivalfund + ", coopenterpequitworth=" + coopenterpequitworth
				+ ", enterpbuildreseadevelop=" + enterpbuildreseadevelop + ", offschoteachertrainbase="
				+ offschoteachertrainbase + ", prodtrainbaseval=" + prodtrainbaseval + ", schoenterpcooporderclassnum="
				+ schoenterpcooporderclassnum + ", schoenterpdevelopcourse=" + schoenterpdevelopcourse
				+ ", fullenterprac=" + fullenterprac + ", fullentertime=" + fullentertime + ", parttimeclassradio="
				+ parttimeclassradio + ", audit=" + audit + "]";
	}

	public static List<Schoolenterprise> sum(List<Schoolenterprise> schoolList) {
		if (schoolList == null) {
			return schoolList;
		}
		List<Schoolenterprise> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Schoolenterprise> itSchool = schoolList.iterator();
		boolean exist;
		while (itSchool.hasNext()) {
			exist = false;
			Schoolenterprise schoolenterprise = (Schoolenterprise) itSchool.next();
			for(int i = 0; i < sumList.size(); i ++){
				Schoolenterprise sum = sumList.get(i);
				if (sum.getYear().equals(schoolenterprise.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					sum.setMajornum(sum.majornum+schoolenterprise.majornum);
					sum.setCoopagreeenterp(sum.coopagreeenterp+schoolenterprise.coopagreeenterp);
					sum.setCoopagreemajor(sum.coopagreemajor+schoolenterprise.coopagreemajor);
					sum.setCoopenterpjointeachmajor(sum.coopenterpjointeachmajor+schoolenterprise.coopenterpjointeachmajor);
					sum.setCoopenterpjointeachteacher(sum.coopenterpjointeachteacher+schoolenterprise.coopenterpjointeachteacher);
					sum.setCoopenterpjointeachclass(sum.coopenterpjointeachclass+schoolenterprise.coopenterpjointeachclass);
					sum.setCoopenterpfund(sum.coopenterpfund.add(schoolenterprise.coopenterpfund));
					sum.setCoopenterparrivalfund(sum.coopenterparrivalfund.add(schoolenterprise.coopenterparrivalfund));
					sum.setCoopenterpequitworth(sum.coopenterpequitworth.add(schoolenterprise.coopenterpequitworth));
					sum.setEnterpbuildreseadevelop(sum.enterpbuildreseadevelop+schoolenterprise.enterpbuildreseadevelop);
					sum.setOffschoteachertrainbase(sum.offschoteachertrainbase+schoolenterprise.offschoteachertrainbase);
					sum.setProdtrainbaseval(sum.prodtrainbaseval.add(schoolenterprise.prodtrainbaseval));
					sum.setSchoenterpcooporderclassnum(sum.schoenterpcooporderclassnum+schoolenterprise.schoenterpcooporderclassnum);
					sum.setSchoenterpdevelopcourse(sum.schoenterpdevelopcourse+schoolenterprise.schoenterpdevelopcourse);
					sum.setFullenterprac(sum.fullenterprac.add(schoolenterprise.fullenterprac));
					sum.setFullentertime(sum.fullentertime.add(schoolenterprise.fullentertime));
					
					String sumPTValue = sum.parttimeclassradio.replace("%", ""),
					schoolPTValue = schoolenterprise.parttimeclassradio.replace("%", "");
					sum.setParttimeclassradio((Float.parseFloat(sumPTValue)+Float.parseFloat(schoolPTValue))+"");
					
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(schoolenterprise);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			
		}
		
		return sumList;
	}
    public static List<Schoolenterprise> avg(List<Schoolenterprise> schoolList) {
		if (schoolList == null) {
			return schoolList;
		}
		List<Schoolenterprise> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Schoolenterprise> itSchool = schoolList.iterator();
		boolean exist;
		while (itSchool.hasNext()) {
			exist = false;
			Schoolenterprise schoolenterprise = (Schoolenterprise) itSchool.next();
			for(int i = 0; i < avgList.size(); i ++){
				Schoolenterprise avg = avgList.get(i);
				if (avg.getYear().equals(schoolenterprise.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setMajornum(avg.majornum+schoolenterprise.majornum);
					avg.setCoopagreeenterp(avg.coopagreeenterp+schoolenterprise.coopagreeenterp);
					avg.setCoopagreemajor(avg.coopagreemajor+schoolenterprise.coopagreemajor);
					avg.setCoopenterpjointeachmajor(avg.coopenterpjointeachmajor+schoolenterprise.coopenterpjointeachmajor);
					avg.setCoopenterpjointeachteacher(avg.coopenterpjointeachteacher+schoolenterprise.coopenterpjointeachteacher);
					avg.setCoopenterpjointeachclass(avg.coopenterpjointeachclass+schoolenterprise.coopenterpjointeachclass);
					avg.setCoopenterpfund(avg.coopenterpfund.add(schoolenterprise.coopenterpfund));
					avg.setCoopenterparrivalfund(avg.coopenterparrivalfund.add(schoolenterprise.coopenterparrivalfund));
					avg.setCoopenterpequitworth(avg.coopenterpequitworth.add(schoolenterprise.coopenterpequitworth));
					avg.setEnterpbuildreseadevelop(avg.enterpbuildreseadevelop+schoolenterprise.enterpbuildreseadevelop);
					avg.setOffschoteachertrainbase(avg.offschoteachertrainbase+schoolenterprise.offschoteachertrainbase);
					avg.setProdtrainbaseval(avg.prodtrainbaseval.add(schoolenterprise.prodtrainbaseval));
					avg.setSchoenterpcooporderclassnum(avg.schoenterpcooporderclassnum+schoolenterprise.schoenterpcooporderclassnum);
					avg.setSchoenterpdevelopcourse(avg.schoenterpdevelopcourse+schoolenterprise.schoenterpdevelopcourse);
					avg.setFullenterprac(avg.fullenterprac.add(schoolenterprise.fullenterprac));
					avg.setFullentertime(avg.fullentertime.add(schoolenterprise.fullentertime));
					
					String sumPTValue = avg.parttimeclassradio.replace("%", ""),
					schoolPTValue = schoolenterprise.parttimeclassradio.replace("%", "");
					avg.setParttimeclassradio((Float.parseFloat(sumPTValue)+Float.parseFloat(schoolPTValue))+"");
					
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(schoolenterprise);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			Schoolenterprise avg = (Schoolenterprise) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setMajornum(avg.majornum/addendNum.get(i));
			avg.setCoopagreeenterp(avg.coopagreeenterp/addendNum.get(i));
			avg.setCoopagreemajor(avg.coopagreemajor/addendNum.get(i));
			avg.setCoopenterpjointeachmajor(avg.coopenterpjointeachmajor/addendNum.get(i));
			avg.setCoopenterpjointeachteacher(avg.coopenterpjointeachteacher/addendNum.get(i));
			avg.setCoopenterpjointeachclass(avg.coopenterpjointeachclass/addendNum.get(i));
			avg.setCoopenterpfund(avg.coopenterpfund.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setCoopenterparrivalfund(avg.coopenterparrivalfund.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setCoopenterpequitworth(avg.coopenterpequitworth.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setEnterpbuildreseadevelop(avg.enterpbuildreseadevelop/addendNum.get(i));
			avg.setOffschoteachertrainbase(avg.offschoteachertrainbase/addendNum.get(i));
			avg.setProdtrainbaseval(avg.prodtrainbaseval.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setSchoenterpcooporderclassnum(avg.schoenterpcooporderclassnum/addendNum.get(i));
			avg.setSchoenterpdevelopcourse(avg.schoenterpdevelopcourse/addendNum.get(i));
			avg.setFullenterprac(avg.fullenterprac.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setFullentertime(avg.fullentertime.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setParttimeclassradio(new BigDecimal(Float.parseFloat(avg.getParttimeclassradio().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			}
		
		return avgList;
	}
}