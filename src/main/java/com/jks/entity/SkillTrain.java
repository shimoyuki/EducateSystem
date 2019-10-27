package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SkillTrain {
    private Integer id;

    private String admcode;

    private String year;

    private String city;

    private Float localfoster;

    private Float localtrain;

    private Float trackproblemnum;

    private BigDecimal ecnomicsocial;

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

    public Float getLocalfoster() {
        return localfoster;
    }

    public void setLocalfoster(Float localfoster) {
        this.localfoster = localfoster;
    }

    public Float getLocaltrain() {
        return localtrain;
    }

    public void setLocaltrain(Float localtrain) {
        this.localtrain = localtrain;
    }

    public Float getTrackproblemnum() {
        return trackproblemnum;
    }

    public void setTrackproblemnum(Float trackproblemnum) {
        this.trackproblemnum = trackproblemnum;
    }

    public BigDecimal getEcnomicsocial() {
        return ecnomicsocial;
    }

    public void setEcnomicsocial(BigDecimal ecnomicsocial) {
        this.ecnomicsocial = ecnomicsocial;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
    
    @Override
	public String toString() {
		return "SkillTrain [id=" + id + ", admcode=" + admcode + ", year="
				+ year + ", city=" + city + ", localfoster=" + localfoster
				+ ", localtrain=" + localtrain + ", trackproblemnum="
				+ trackproblemnum + ", ecnomicsocial=" + ecnomicsocial
				+ ", audit=" + audit + "]";
	}
    
	public static List<SkillTrain> sum(List<SkillTrain> skiTraList) {
		if (skiTraList == null) {
			return skiTraList;
		}
		List<SkillTrain> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<SkillTrain> itSkillTrain = skiTraList.iterator();
		boolean exist;
		while (itSkillTrain.hasNext()) {
			exist = false;
			SkillTrain skiTra = (SkillTrain) itSkillTrain.next();
			for(int i = 0; i < sumList.size(); i ++){
				SkillTrain sum = sumList.get(i);
				if (sum.getYear().equals(skiTra.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					
					sum.setLocalfoster(sum.localfoster + skiTra.localfoster);
					sum.setLocaltrain(sum.localtrain + skiTra.localtrain);
					sum.setTrackproblemnum(sum.trackproblemnum + skiTra.trackproblemnum);
					sum.setEcnomicsocial(sum.ecnomicsocial.add(skiTra.ecnomicsocial));
					
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(skiTra);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
		}
		
		return sumList;
	}
	
	public static List<SkillTrain> avg(List<SkillTrain> skiTraList) {
		if (skiTraList == null) {
			return skiTraList;
		}
		List<SkillTrain> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<SkillTrain> itSkillTrain = skiTraList.iterator();
		boolean exist;
		while (itSkillTrain.hasNext()) {
			exist = false;
			SkillTrain skiTra = (SkillTrain) itSkillTrain.next();
			for(int i = 0; i < avgList.size(); i ++){
				SkillTrain avg = avgList.get(i);
				if (avg.getYear().equals(skiTra.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					
					avg.setLocalfoster(avg.localfoster + skiTra.localfoster);
					avg.setLocaltrain(avg.localtrain + skiTra.localtrain);
					avg.setTrackproblemnum(avg.trackproblemnum + skiTra.trackproblemnum);
					avg.setEcnomicsocial(avg.ecnomicsocial.add(skiTra.ecnomicsocial));
					
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(skiTra);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			SkillTrain avg = (SkillTrain) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			
			avg.setLocalfoster(avg.localfoster/addendNum.get(i));
			avg.setLocaltrain(avg.localtrain/addendNum.get(i));
			avg.setTrackproblemnum(avg.trackproblemnum/addendNum.get(i));
			avg.setEcnomicsocial(avg.ecnomicsocial.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			
		}
		
		return avgList;
	}
}