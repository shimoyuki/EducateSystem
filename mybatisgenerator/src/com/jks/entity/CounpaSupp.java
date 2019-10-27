package com.jks.entity;

import java.math.BigDecimal;

public class CounpaSupp {
    private Integer id;

    private String admcode;

    private String year;

    private String city;

    private Float helpobject;

    private Float poverreductarget;

    private BigDecimal fund;

    private Float servicenum;

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

    public Float getHelpobject() {
        return helpobject;
    }

    public void setHelpobject(Float helpobject) {
        this.helpobject = helpobject;
    }

    public Float getPoverreductarget() {
        return poverreductarget;
    }

    public void setPoverreductarget(Float poverreductarget) {
        this.poverreductarget = poverreductarget;
    }

    public BigDecimal getFund() {
        return fund;
    }

    public void setFund(BigDecimal fund) {
        this.fund = fund;
    }

    public Float getServicenum() {
        return servicenum;
    }

    public void setServicenum(Float servicenum) {
        this.servicenum = servicenum;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
    
    @Override
	public String toString() {
		return "CounpaSupp [id=" + id + ", admcode=" + admcode + ", year="
				+ year + ", city=" + city + ", helpobject=" + helpobject
				+ ", poverreductarget=" + poverreductarget + ", fund=" + fund
				+ ", servicenum=" + servicenum + ", audit=" + audit + "]";
	}
    
	public static List<CounpaSupp> sum(List<CounpaSupp> counList) {
		if (counList == null) {
			return counList;
		}
		List<CounpaSupp> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<CounpaSupp> itCounpaSupp = counList.iterator();
		boolean exist;
		while (itCounpaSupp.hasNext()) {
			exist = false;
			CounpaSupp coun = (CounpaSupp) itCounpaSupp.next();
			for(int i = 0; i < sumList.size(); i ++){
				CounpaSupp sum = sumList.get(i);
				if (sum.getYear().equals(coun.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					
					sum.setHelpobject(sum.helpobject + coun.helpobject);
					sum.setPoverreductarget(sum.poverreductarget + coun.poverreductarget);
					sum.setServicenum(sum.servicenum + coun.servicenum);
					sum.setFund(sum.fund.add(coun.fund));
					
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(coun);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
		}
		
		return sumList;
	}
	
	public static List<CounpaSupp> avg(List<CounpaSupp> counList) {
		if (counList == null) {
			return counList;
		}
		List<CounpaSupp> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<CounpaSupp> itCounpaSupp = counList.iterator();
		boolean exist;
		while (itCounpaSupp.hasNext()) {
			exist = false;
			CounpaSupp coun = (CounpaSupp) itCounpaSupp.next();
			for(int i = 0; i < avgList.size(); i ++){
				CounpaSupp avg = avgList.get(i);
				if (avg.getYear().equals(coun.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					
					avg.setHelpobject(avg.helpobject + coun.helpobject);
					avg.setPoverreductarget(avg.poverreductarget + coun.poverreductarget);
					avg.setServicenum(avg.servicenum + coun.servicenum);
					avg.setFund(avg.fund.add(coun.fund));
					
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(coun);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			CounpaSupp avg = (CounpaSupp) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			
			avg.setHelpobject(avg.helpobject /addendNum.get(i));
			avg.setPoverreductarget(avg.poverreductarget /addendNum.get(i));
			avg.setServicenum(avg.servicenum/addendNum.get(i));
			avg.setFund(avg.fund.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			
		}
		
		return avgList;
	}
}