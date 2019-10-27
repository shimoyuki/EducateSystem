package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Equitment {
	
	private int id;
	
	private String admcode;
	
	private String year;
	
	private String city;
	
	private BigDecimal totalAssertWorth;
	
	private BigDecimal teacEquitWorth;
	
	private BigDecimal trainEquitWorth;
	
	private BigDecimal yearTeacEquitWorth;
	
	private BigDecimal yearTrainEquitWorth;
	
	private BigDecimal stuTracEquitWorth;
	
	private BigDecimal stuTrainEquitWorth;
	
	private BigDecimal traPracWorkPe;
	
	private int inTrainBase;
	
	private int outTrainBase;
	
	private int libBooks;
	
	private int libBooksElec;
	
	private int yearBooks;
	
	private int readSeats;
	
	private BigDecimal stuBook;
	
	private int subScribs;
	
	private int elecBooks;
	
	private int elecSeats;
	
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	public BigDecimal getTotalAssertWorth() {
		return totalAssertWorth;
	}

	public void setTotalAssertWorth(BigDecimal totalAssertWorth) {
		this.totalAssertWorth = totalAssertWorth;
	}

	public BigDecimal getTeacEquitWorth() {
		return teacEquitWorth;
	}

	public void setTeacEquitWorth(BigDecimal teacEquitWorth) {
		this.teacEquitWorth = teacEquitWorth;
	}

	public BigDecimal getTrainEquitWorth() {
		return trainEquitWorth;
	}

	public void setTrainEquitWorth(BigDecimal trainEquitWorth) {
		this.trainEquitWorth = trainEquitWorth;
	}

	public BigDecimal getYearTeacEquitWorth() {
		return yearTeacEquitWorth;
	}

	public void setYearTeacEquitWorth(BigDecimal yearTeacEquitWorth) {
		this.yearTeacEquitWorth = yearTeacEquitWorth;
	}

	public BigDecimal getYearTrainEquitWorth() {
		return yearTrainEquitWorth;
	}

	public void setYearTrainEquitWorth(BigDecimal yearTrainEquitWorth) {
		this.yearTrainEquitWorth = yearTrainEquitWorth;
	}

	public BigDecimal getStuTracEquitWorth() {
		return stuTracEquitWorth;
	}

	public void setStuTracEquitWorth(BigDecimal stuTracEquitWorth) {
		this.stuTracEquitWorth = stuTracEquitWorth;
	}

	public BigDecimal getStuTrainEquitWorth() {
		return stuTrainEquitWorth;
	}

	public void setStuTrainEquitWorth(BigDecimal stuTrainEquitWorth) {
		this.stuTrainEquitWorth = stuTrainEquitWorth;
	}

	public BigDecimal getTraPracWorkPe() {
		return traPracWorkPe;
	}

	public void setTraPracWorkPe(BigDecimal traPracWorkPe) {
		this.traPracWorkPe = traPracWorkPe;
	}

	public int getInTrainBase() {
		return inTrainBase;
	}

	public void setInTrainBase(int inTrainBase) {
		this.inTrainBase = inTrainBase;
	}

	public int getOutTrainBase() {
		return outTrainBase;
	}

	public void setOutTrainBase(int outTrainBase) {
		this.outTrainBase = outTrainBase;
	}

	public int getLibBooks() {
		return libBooks;
	}

	public void setLibBooks(int libBooks) {
		this.libBooks = libBooks;
	}

	public int getLibBooksElec() {
		return libBooksElec;
	}

	public void setLibBooksElec(int libBooksElec) {
		this.libBooksElec = libBooksElec;
	}

	public int getYearBooks() {
		return yearBooks;
	}

	public void setYearBooks(int yearBooks) {
		this.yearBooks = yearBooks;
	}

	public int getReadSeats() {
		return readSeats;
	}

	public void setReadSeats(int readSeats) {
		this.readSeats = readSeats;
	}

	public BigDecimal getStuBook() {
		return stuBook;
	}

	public void setStuBook(BigDecimal stuBook) {
		this.stuBook = stuBook;
	}

	public int getSubScribs() {
		return subScribs;
	}

	public void setSubScribs(int subScribs) {
		this.subScribs = subScribs;
	}

	public int getElecBooks() {
		return elecBooks;
	}

	public void setElecBooks(int elecBooks) {
		this.elecBooks = elecBooks;
	}

	public int getElecSeats() {
		return elecSeats;
	}

	public void setElecSeats(int elecSeats) {
		this.elecSeats = elecSeats;
	}

	public int getAudit() {
		return audit;
	}

	public void setAudit(int audit) {
		this.audit = audit;
	}
	
	@Override
	public String toString() {
		return "Equitment [id=" + id + ", admcode=" + admcode + ", year=" + year + ", city=" + city + ", totalAssertWorth="
				+ totalAssertWorth + ", teacEquitWorth=" + teacEquitWorth + ", trainEquitWorth=" + trainEquitWorth + ", yearTeacEquitWorth=" + yearTeacEquitWorth
				+ ", yearTrainEquitWorth=" + yearTrainEquitWorth + ", stuTracEquitWorth=" + stuTracEquitWorth + ", stuTrainEquitWorth=" + stuTrainEquitWorth
				+ ", traPracWorkPe=" + traPracWorkPe + ", inTrainBase=" + inTrainBase + ", outTrainBase=" + outTrainBase + ", libBooks="
				+ libBooks + ", libBooksElec=" + libBooksElec + ", yearBooks=" + yearBooks + ", readSeats="
				+ readSeats + ", stuBook=" + stuBook + ", subScribs=" + subScribs + ", elecBooks="
				+ elecBooks + ", elecSeats=" + elecSeats + ", audit=" + audit+ "]";
	}
	public static List<Equitment> sum(List<Equitment> equitList) {
		if (equitList == null) {
			return equitList;
		}
		List<Equitment> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Equitment> itEquit = equitList.iterator();
		boolean exist;
		while (itEquit.hasNext()) {
			exist = false;
			Equitment equitment = (Equitment) itEquit.next();
			for(int i = 0; i < sumList.size(); i ++){
				Equitment sum = sumList.get(i);
				if (sum.getYear().equals(equitment.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					sum.setTotalAssertWorth(sum.totalAssertWorth.add(equitment.totalAssertWorth));
					sum.setTeacEquitWorth(sum.teacEquitWorth.add(equitment.teacEquitWorth));
					sum.setTrainEquitWorth(sum.trainEquitWorth.add(equitment.trainEquitWorth));
					sum.setYearTeacEquitWorth(sum.yearTeacEquitWorth.add(equitment.yearTeacEquitWorth));
					sum.setYearTrainEquitWorth(sum.yearTrainEquitWorth.add(equitment.yearTrainEquitWorth));
					sum.setStuTracEquitWorth(sum.stuTracEquitWorth.add(equitment.stuTracEquitWorth));
					sum.setStuTrainEquitWorth(sum.stuTrainEquitWorth.add(equitment.stuTrainEquitWorth));
					sum.setTraPracWorkPe(sum.traPracWorkPe.add(equitment.traPracWorkPe));
					sum.setInTrainBase(sum.inTrainBase+equitment.inTrainBase);
					sum.setOutTrainBase(sum.outTrainBase+equitment.outTrainBase);
					sum.setLibBooks(sum.libBooks+equitment.libBooks);
					sum.setLibBooksElec(sum.libBooksElec+equitment.libBooksElec);
					sum.setYearBooks(sum.yearBooks+equitment.yearBooks);
					sum.setReadSeats(sum.readSeats+equitment.readSeats);
					sum.setStuBook(sum.stuBook.add(equitment.stuBook));
					sum.setSubScribs(sum.subScribs+equitment.subScribs);
					sum.setElecBooks(sum.elecBooks+equitment.elecBooks);
					sum.setElecSeats(sum.elecSeats+equitment.elecSeats);
					
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(equitment);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			
		}
		
		return sumList;
	}
	public static List<Equitment> avg(List<Equitment> equitList) {
		if (equitList == null) {
			return equitList;
		}
		List<Equitment> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Equitment> itEquit = equitList.iterator();
		boolean exist;
		while (itEquit.hasNext()) {
			exist = false;
			Equitment equitment = (Equitment) itEquit.next();
			for(int i = 0; i < avgList.size(); i ++){
				Equitment avg = avgList.get(i);
				if (avg.getYear().equals(equitment.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setTotalAssertWorth(avg.totalAssertWorth.add(equitment.totalAssertWorth));
					avg.setTeacEquitWorth(avg.teacEquitWorth.add(equitment.teacEquitWorth));
					avg.setTrainEquitWorth(avg.trainEquitWorth.add(equitment.trainEquitWorth));
					avg.setYearTeacEquitWorth(avg.yearTeacEquitWorth.add(equitment.yearTeacEquitWorth));
					avg.setYearTrainEquitWorth(avg.yearTrainEquitWorth.add(equitment.yearTrainEquitWorth));
					avg.setStuTracEquitWorth(avg.stuTracEquitWorth.add(equitment.stuTracEquitWorth));
					avg.setStuTrainEquitWorth(avg.stuTrainEquitWorth.add(equitment.stuTrainEquitWorth));
					avg.setTraPracWorkPe(avg.traPracWorkPe.add(equitment.traPracWorkPe));
					avg.setInTrainBase(avg.inTrainBase+equitment.inTrainBase);
					avg.setOutTrainBase(avg.outTrainBase+equitment.outTrainBase);
					avg.setLibBooks(avg.libBooks+equitment.libBooks);
					avg.setLibBooksElec(avg.libBooksElec+equitment.libBooksElec);
					avg.setYearBooks(avg.yearBooks+equitment.yearBooks);
					avg.setReadSeats(avg.readSeats+equitment.readSeats);
					avg.setStuBook(avg.stuBook.add(equitment.stuBook));
					avg.setSubScribs(avg.subScribs+equitment.subScribs);
					avg.setElecBooks(avg.elecBooks+equitment.elecBooks);
					avg.setElecSeats(avg.elecSeats+equitment.elecSeats);
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(equitment);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			Equitment avg = (Equitment) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			avg.setTotalAssertWorth(avg.totalAssertWorth.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setTeacEquitWorth(avg.teacEquitWorth.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setTrainEquitWorth(avg.trainEquitWorth.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setYearTeacEquitWorth(avg.yearTeacEquitWorth.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setYearTrainEquitWorth(avg.yearTrainEquitWorth.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setStuTracEquitWorth(avg.stuTracEquitWorth.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setStuTrainEquitWorth(avg.stuTrainEquitWorth.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setTraPracWorkPe(avg.traPracWorkPe.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setInTrainBase(avg.inTrainBase/addendNum.get(i));
			avg.setOutTrainBase(avg.outTrainBase/addendNum.get(i));
			avg.setLibBooks(avg.libBooks/addendNum.get(i));
			avg.setLibBooksElec(avg.libBooksElec/addendNum.get(i));
			avg.setYearBooks(avg.yearBooks/addendNum.get(i));
			avg.setReadSeats(avg.readSeats/addendNum.get(i));
			avg.setStuBook(avg.stuBook.divide(new BigDecimal(addendNum.get(i)), 2, BigDecimal.ROUND_HALF_UP));
			avg.setSubScribs(avg.subScribs/addendNum.get(i));
			avg.setElecBooks(avg.elecBooks/addendNum.get(i));
			avg.setElecSeats(avg.elecSeats/addendNum.get(i));
			
		}
		
		return avgList;
	}
}
