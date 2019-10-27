package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Funds {
	
	private int id;
	
	private String admcode;
	
	private String year;
	
	private String city;
	
	private BigDecimal centerFund;
	
	private BigDecimal localFund;
	
	private BigDecimal debt;
	
	private BigDecimal loan;
	
	private BigDecimal appropriation;
	
	private String teacInputRadio;
	
	/*private BigDecimal teacherTrain;*/
	
	private BigDecimal teachChange;
	
	private BigDecimal fundBudget;
	
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

	public BigDecimal getCenterFund() {
		return centerFund;
	}

	public void setCenterFund(BigDecimal centerFund) {
		this.centerFund = centerFund;
	}

	public BigDecimal getLocalFund() {
		return localFund;
	}

	public void setLocalFund(BigDecimal localFund) {
		this.localFund = localFund;
	}

	public BigDecimal getDebt() {
		return debt;
	}

	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}

	public BigDecimal getLoan() {
		return loan;
	}

	public void setLoan(BigDecimal loan) {
		this.loan = loan;
	}

	public BigDecimal getAppropriation() {
		return appropriation;
	}

	public void setAppropriation(BigDecimal appropriation) {
		this.appropriation = appropriation;
	}

	public String getTeacInputRadio() {
		return teacInputRadio;
	}

	public void setTeacInputRadio(String teacInputRadio) {
		this.teacInputRadio = teacInputRadio;
	}

	/*public BigDecimal getTeacherTrain() {
		return teacherTrain;
	}

	public void setTeacherTrain(BigDecimal teacherTrain) {
		this.teacherTrain = teacherTrain;
	}*/

	public BigDecimal getTeachChange() {
		return teachChange;
	}

	public void setTeachChange(BigDecimal teachChange) {
		this.teachChange = teachChange;
	}

	public BigDecimal getFundBudget() {
		return fundBudget;
	}

	public void setFundBudget(BigDecimal fundBudget) {
		this.fundBudget = fundBudget;
	}

	public int getAudit() {
		return audit;
	}

	public void setAudit(int audit) {
		this.audit = audit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Funds [id=" + id + ", admcode=" + admcode + ", year=" + year
				+ ", city=" + city + ", centerFund=" + centerFund
				+ ", localFund=" + localFund + ", debt=" + debt + ", loan="
				+ loan + ", appropriation=" + appropriation
				+ ", teacInputRadio=" + teacInputRadio +  ", teachChange=" + teachChange
				+ ", fundBudget=" + fundBudget + ", audit=" + audit + "]";
	}
	
	public static List<Funds> sum(List<Funds> fundsList) {
		if (fundsList == null) {
			return fundsList;
		}
		List<Funds> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Funds> itFunds = fundsList.iterator();
		boolean exist;
		while (itFunds.hasNext()) {
			exist = false;
			Funds funds = (Funds) itFunds.next();
			for(int i = 0; i < sumList.size(); i ++){
				Funds sum = sumList.get(i);
				if (sum.getYear().equals(funds.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					sum.setCenterFund(sum.centerFund.add(funds.centerFund));
					sum.setLocalFund(sum.localFund.add(funds.localFund));
					sum.setDebt(sum.debt.add(funds.debt));
					sum.setLoan(sum.loan.add(funds.loan));
					sum.setAppropriation(sum.appropriation.add(funds.appropriation));
					String sumTeacInputRadio = sum.teacInputRadio.replace("%", ""),
						   fundsTeacInputRadio = funds.teacInputRadio.replace("%", "");
					sum.setTeacInputRadio((Float.parseFloat(sumTeacInputRadio)+Float.parseFloat(fundsTeacInputRadio))+"");
					/*sum.setTeacherTrain(sum.teacherTrain.add(funds.teacherTrain));*/
					sum.setTeachChange(sum.teachChange.add(funds.teachChange));
					sum.setFundBudget(sum.fundBudget.add(funds.fundBudget));
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(funds);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			sumList.get(i).setTeacInputRadio(new BigDecimal(Float.parseFloat(sumList.get(i).getTeacInputRadio().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			}		
		return sumList;
	}
	
	public static List<Funds> avg(List<Funds> fundsList) {
		if (fundsList == null) {
			return fundsList;
		}
		List<Funds> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Funds> itFunds = fundsList.iterator();
		boolean exist;
		while (itFunds.hasNext()) {
			exist = false;
			Funds funds = (Funds) itFunds.next();
			for(int i = 0; i < avgList.size(); i ++){
				Funds avg = avgList.get(i);
				if (avg.getYear().equals(funds.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setCenterFund(avg.centerFund.add(funds.centerFund));
					avg.setLocalFund(avg.localFund.add(funds.localFund));
					avg.setDebt(avg.debt.add(funds.debt));
					avg.setLoan(avg.loan.add(funds.loan));
					avg.setAppropriation(avg.appropriation.add(funds.appropriation));
					String avgTeacInputRadio = avg.teacInputRadio.replace("%", ""),
						   fundsTeacInputRadio = funds.teacInputRadio.replace("%", "");
					avg.setTeacInputRadio((Float.parseFloat(avgTeacInputRadio)+Float.parseFloat(fundsTeacInputRadio))+"");
					/*avg.setTeacherTrain(avg.teacherTrain.add(funds.teacherTrain));*/
					avg.setTeachChange(avg.teachChange.add(funds.teachChange));
					avg.setFundBudget(avg.fundBudget.add(funds.fundBudget));
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(funds);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			Funds avg = (Funds) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			avg.setCenterFund(avg.centerFund.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setLocalFund(avg.localFund.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setDebt(avg.debt.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setLoan(avg.loan.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setAppropriation(avg.appropriation.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));		
			avg.setTeacInputRadio(new BigDecimal(Float.parseFloat(avg.getTeacInputRadio().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");						
			/*avg.setTeacherTrain(avg.teacherTrain.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));*/
			avg.setTeachChange(avg.teachChange.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setFundBudget(avg.fundBudget.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));						
		}
		
		return avgList;
	}
	
	
}
