package com.jks.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Partybulid {
	private Integer id;

	private String admcode;

	private String year;

	private String city;

	private Integer partymember;

	private Integer branchnum;

	private Integer stupartynum;

	private Integer partyworktrain;

	private Integer partytain;

	private Integer partyactivisttrainnum;

	private Integer partyactivisttraintime;

	private Integer developpartynum;

	private Integer subscribnum;

	private Integer punish;

	private Integer stateper;

	private Integer provinper;

	private Integer cityper;

	private Integer stateorgan;

	private Integer provinorgan;

	private Integer cityorgan;

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

	public Integer getPartymember() {
		return partymember;
	}

	public void setPartymember(Integer partymember) {
		this.partymember = partymember;
	}

	public Integer getBranchnum() {
		return branchnum;
	}

	public void setBranchnum(Integer branchnum) {
		this.branchnum = branchnum;
	}

	public Integer getStupartynum() {
		return stupartynum;
	}

	public void setStupartynum(Integer stupartynum) {
		this.stupartynum = stupartynum;
	}

	public Integer getPartyworktrain() {
		return partyworktrain;
	}

	public void setPartyworktrain(Integer partyworktrain) {
		this.partyworktrain = partyworktrain;
	}

	public Integer getPartytain() {
		return partytain;
	}

	public void setPartytain(Integer partytain) {
		this.partytain = partytain;
	}

	public Integer getPartyactivisttrainnum() {
		return partyactivisttrainnum;
	}

	public void setPartyactivisttrainnum(Integer partyactivisttrainnum) {
		this.partyactivisttrainnum = partyactivisttrainnum;
	}

	public Integer getPartyactivisttraintime() {
		return partyactivisttraintime;
	}

	public void setPartyactivisttraintime(Integer partyactivisttraintime) {
		this.partyactivisttraintime = partyactivisttraintime;
	}

	public Integer getDeveloppartynum() {
		return developpartynum;
	}

	public void setDeveloppartynum(Integer developpartynum) {
		this.developpartynum = developpartynum;
	}

	public Integer getSubscribnum() {
		return subscribnum;
	}

	public void setSubscribnum(Integer subscribnum) {
		this.subscribnum = subscribnum;
	}

	public Integer getPunish() {
		return punish;
	}

	public void setPunish(Integer punish) {
		this.punish = punish;
	}

	public Integer getStateper() {
		return stateper;
	}

	public void setStateper(Integer stateper) {
		this.stateper = stateper;
	}

	public Integer getProvinper() {
		return provinper;
	}

	public void setProvinper(Integer provinper) {
		this.provinper = provinper;
	}

	public Integer getCityper() {
		return cityper;
	}

	public void setCityper(Integer cityper) {
		this.cityper = cityper;
	}

	public Integer getStateorgan() {
		return stateorgan;
	}

	public void setStateorgan(Integer stateorgan) {
		this.stateorgan = stateorgan;
	}

	public Integer getProvinorgan() {
		return provinorgan;
	}

	public void setProvinorgan(Integer provinorgan) {
		this.provinorgan = provinorgan;
	}

	public Integer getCityorgan() {
		return cityorgan;
	}

	public void setCityorgan(Integer cityorgan) {
		this.cityorgan = cityorgan;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	@Override
	public String toString() {
		return "PartyBulid [id=" + id + ", admcode=" + admcode + ", year=" + year + ", city=" + city + ", partymember="
				+ partymember + ", branchnum=" + branchnum + ", stupartynum=" + stupartynum + ", partyworktrain="
				+ partyworktrain + ", partytain=" + partytain + ", partyactivisttrainnum=" + partyactivisttrainnum
				+ ", partyactivisttraintime=" + partyactivisttraintime + ", developpartynum=" + developpartynum
				+ ", subscribnum=" + subscribnum + ", punish=" + punish + ", stateper=" + stateper + ", provinper="
				+ provinper + ", cityper=" + cityper + ", stateorgan=" + stateorgan + ", provinorgan=" + provinorgan
				+ ", cityorgan=" + cityorgan + ", audit=" + audit + "]";
	}

	public static List<Partybulid> sum(List<Partybulid> partyList) {
		if (partyList == null) {
			return partyList;
		}
		List<Partybulid> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Partybulid> itParty = partyList.iterator();
		boolean exist;
		while (itParty.hasNext()) {
			exist = false;
			Partybulid partybulid = (Partybulid) itParty.next();
			for (int i = 0; i < sumList.size(); i++) {
				Partybulid sum = sumList.get(i);
				if (sum.getYear().equals(partybulid.getYear())) {
					addendNum.set(i, addendNum.get(i) + 1);
					sum.setPartymember(sum.partymember + partybulid.partymember);
					sum.setBranchnum(sum.branchnum + partybulid.branchnum);
					sum.setStupartynum(sum.stupartynum + partybulid.stupartynum);
					sum.setPartyworktrain(sum.partyworktrain + partybulid.partyworktrain);
					sum.setPartytain(sum.partytain + partybulid.partytain);
					sum.setPartyactivisttrainnum(sum.partyactivisttrainnum + partybulid.partyactivisttrainnum);
					sum.setPartyactivisttraintime(sum.partyactivisttraintime + partybulid.partyactivisttraintime);
					sum.setDeveloppartynum(sum.developpartynum + partybulid.developpartynum);
					sum.setSubscribnum(sum.subscribnum + partybulid.subscribnum);
					sum.setPunish(sum.punish + partybulid.punish);
					sum.setStateper(sum.stateper + partybulid.stateper);
					sum.setProvinper(sum.provinper + partybulid.provinper);
					sum.setCityper(sum.cityper + partybulid.cityper);
					sum.setStateorgan(sum.stateorgan + partybulid.stateorgan);
					sum.setProvinorgan(sum.provinorgan + partybulid.provinorgan);
					sum.setCityorgan(sum.cityorgan + partybulid.cityorgan);
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(partybulid);
				addendNum.add(1);
			}
		}

		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());// 将admcode设为所在城市名，方便统一显示

		}

		return sumList;
	}

	public static List<Partybulid> avg(List<Partybulid> partyList) {
		if (partyList == null) {
			return partyList;
		}
		List<Partybulid> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Partybulid> itParty = partyList.iterator();
		boolean exist;
		while (itParty.hasNext()) {
			exist = false;
			Partybulid partybulid = (Partybulid) itParty.next();
			for(int i = 0; i < avgList.size(); i ++){
				Partybulid avg = avgList.get(i);
				if (avg.getYear().equals(partybulid.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setPartymember(avg.partymember+partybulid.partymember);
					avg.setBranchnum(avg.branchnum+partybulid.branchnum);
					avg.setStupartynum(avg.stupartynum+partybulid.stupartynum);
					avg.setPartyworktrain(avg.partyworktrain+partybulid.partyworktrain);
					avg.setPartytain(avg.partytain+partybulid.partytain);
					avg.setPartyactivisttrainnum(avg.partyactivisttrainnum+partybulid.partyactivisttrainnum);
					avg.setPartyactivisttraintime(avg.partyactivisttraintime+partybulid.partyactivisttraintime);
					avg.setDeveloppartynum(avg.developpartynum+partybulid.developpartynum);
					avg.setSubscribnum(avg.subscribnum+partybulid.subscribnum);
					avg.setPunish(avg.punish+partybulid.punish);
					avg.setStateper(avg.stateper+partybulid.stateper);
					avg.setProvinper(avg.provinper+partybulid.provinper);
					avg.setCityper(avg.cityper+partybulid.cityper);
					avg.setStateorgan(avg.stateorgan+partybulid.stateorgan);
					avg.setProvinorgan(avg.provinorgan+partybulid.provinorgan);
					avg.setCityorgan(avg.cityorgan+partybulid.cityorgan);
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(partybulid);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			Partybulid avg = (Partybulid) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			avg.setPartymember(avg.partymember/addendNum.get(i));
			avg.setBranchnum(avg.branchnum/addendNum.get(i));
			avg.setStupartynum(avg.stupartynum/addendNum.get(i));
			avg.setPartyworktrain(avg.partyworktrain/addendNum.get(i));
			avg.setPartytain(avg.partytain/addendNum.get(i));
			avg.setPartyactivisttrainnum(avg.partyactivisttrainnum/addendNum.get(i));
			avg.setPartyactivisttraintime(avg.partyactivisttraintime/addendNum.get(i));
			avg.setDeveloppartynum(avg.developpartynum/addendNum.get(i));
			avg.setSubscribnum(avg.subscribnum/addendNum.get(i));
			avg.setPunish(avg.punish/addendNum.get(i));
			avg.setStateper(avg.stateper/addendNum.get(i));
			avg.setProvinper(avg.provinper/addendNum.get(i));
			avg.setCityper(avg.cityper/addendNum.get(i));
			avg.setStateorgan(avg.stateorgan/addendNum.get(i));
			avg.setProvinorgan(avg.provinorgan/addendNum.get(i));
			avg.setCityorgan(avg.cityorgan/addendNum.get(i));
		}
		return avgList;
	}
}