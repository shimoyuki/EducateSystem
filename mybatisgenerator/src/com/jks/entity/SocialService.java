package com.jks.entity;

import java.math.BigDecimal;

public class SocialService {
    private Integer id;

    private String admcode;

    private String year;

    private String city;

    private Float trainstaff;

    private Float trainunabled;

    private Float trainunemstaff;

    private Float trainfarmer;

    private Float trainretiresoldier;

    private BigDecimal skillidentnum;

    private BigDecimal teachserve;

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

    public Float getTrainstaff() {
        return trainstaff;
    }

    public void setTrainstaff(Float trainstaff) {
        this.trainstaff = trainstaff;
    }

    public Float getTrainunabled() {
        return trainunabled;
    }

    public void setTrainunabled(Float trainunabled) {
        this.trainunabled = trainunabled;
    }

    public Float getTrainunemstaff() {
        return trainunemstaff;
    }

    public void setTrainunemstaff(Float trainunemstaff) {
        this.trainunemstaff = trainunemstaff;
    }

    public Float getTrainfarmer() {
        return trainfarmer;
    }

    public void setTrainfarmer(Float trainfarmer) {
        this.trainfarmer = trainfarmer;
    }

    public Float getTrainretiresoldier() {
        return trainretiresoldier;
    }

    public void setTrainretiresoldier(Float trainretiresoldier) {
        this.trainretiresoldier = trainretiresoldier;
    }

    public BigDecimal getSkillidentnum() {
        return skillidentnum;
    }

    public void setSkillidentnum(BigDecimal skillidentnum) {
        this.skillidentnum = skillidentnum;
    }

    public BigDecimal getTeachserve() {
        return teachserve;
    }

    public void setTeachserve(BigDecimal teachserve) {
        this.teachserve = teachserve;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
    
    @Override
	public String toString() {
		return "SocialService [id=" + id + ", admcode=" + admcode + ", year="
				+ year + ", city=" + city + ", trainstaff=" + trainstaff
				+ ", trainunabled=" + trainunabled + ", trainunemstaff="
				+ trainunemstaff + ", trainfarmer=" + trainfarmer
				+ ", trainretiresoldier=" + trainretiresoldier
				+ ", skillidentnum=" + skillidentnum + ", teachserve="
				+ teachserve + ", audit=" + audit + "]";
	}
    
	public static List<SocialService> sum(List<SocialService> socialList) {
		if (socialList == null) {
			return socialList;
		}
		List<SocialService> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<SocialService> itSocialService = socialList.iterator();
		boolean exist;
		while (itSocialService.hasNext()) {
			exist = false;
			SocialService social = (SocialService) itSocialService.next();
			for(int i = 0; i < sumList.size(); i ++){
				SocialService sum = sumList.get(i);
				if (sum.getYear().equals(social.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					
					sum.setTrainstaff(sum.trainstaff + social.trainstaff);
					sum.setTrainunabled(sum.trainunabled + social.trainunabled);
					sum.setTrainunemstaff(sum.trainunemstaff + social.trainunemstaff);
					sum.setTrainfarmer(sum.trainfarmer + social.trainfarmer);
					sum.setTrainretiresoldier(sum.trainretiresoldier + social.trainretiresoldier);
					sum.setSkillidentnum(sum.skillidentnum.add(social.skillidentnum));
					sum.setTeachserve(sum.teachserve.add(social.teachserve));
					
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(social);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
		}
		
		return sumList;
	}
	
	public static List<SocialService> avg(List<SocialService> socialList) {
		if (socialList == null) {
			return socialList;
		}
		List<SocialService> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<SocialService> itSocialService = socialList.iterator();
		boolean exist;
		while (itSocialService.hasNext()) {
			exist = false;
			SocialService social = (SocialService) itSocialService.next();
			for(int i = 0; i < avgList.size(); i ++){
				SocialService avg = avgList.get(i);
				if (avg.getYear().equals(social.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					
					avg.setTrainstaff(avg.trainstaff + social.trainstaff);
					avg.setTrainunabled(avg.trainunabled + social.trainunabled);
					avg.setTrainunemstaff(avg.trainunemstaff + social.trainunemstaff);
					avg.setTrainfarmer(avg.trainfarmer + social.trainfarmer);
					avg.setTrainretiresoldier(avg.trainretiresoldier + social.trainretiresoldier);
					avg.setSkillidentnum(avg.skillidentnum.add(social.skillidentnum));
					avg.setTeachserve(avg.teachserve.add(social.teachserve));
					
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(social);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			SocialService avg = (SocialService) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			
			avg.setTrainstaff(avg.trainstaff/addendNum.get(i));
			avg.setTrainunabled(avg.trainunabled/addendNum.get(i));
			avg.setTrainunemstaff(avg.trainunemstaff /addendNum.get(i));
			avg.setTrainfarmer(avg.trainfarmer/addendNum.get(i));
			avg.setTrainretiresoldier(avg.trainretiresoldier/addendNum.get(i));
			avg.setSkillidentnum(avg.skillidentnum.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setTeachserve(avg.teachserve.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			
		}
		
		return avgList;
	}
}