package com.jks.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Internship {
	
    private Integer id;

    private String admcode;

    private String year;

    private String city;

    private String offcampttrainbase;

    private String kownduration;

    private String postduration;

    private String displaceduration;

    private String stupostpartradio;

    private String studispartradio;

    private String enterpassessdisopt;

    private String enterpassessdisgood;

    private String enterpassessdisinter;

    private String enterpassessdisbad;

    private String coopenterpemploystud;

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

    public String getOffcampttrainbase() {
        return offcampttrainbase;
    }

    public void setOffcampttrainbase(String offcampttrainbase) {
        this.offcampttrainbase = offcampttrainbase == null ? null : offcampttrainbase.trim();
    }

    public String getKownduration() {
        return kownduration;
    }

    public void setKownduration(String kownduration) {
        this.kownduration = kownduration == null ? null : kownduration.trim();
    }

    public String getPostduration() {
        return postduration;
    }

    public void setPostduration(String postduration) {
        this.postduration = postduration == null ? null : postduration.trim();
    }

    public String getDisplaceduration() {
        return displaceduration;
    }

    public void setDisplaceduration(String displaceduration) {
        this.displaceduration = displaceduration == null ? null : displaceduration.trim();
    }

    public String getStupostpartradio() {
        return stupostpartradio;
    }

    public void setStupostpartradio(String stupostpartradio) {
        this.stupostpartradio = stupostpartradio == null ? null : stupostpartradio.trim();
    }

    public String getStudispartradio() {
        return studispartradio;
    }

    public void setStudispartradio(String studispartradio) {
        this.studispartradio = studispartradio == null ? null : studispartradio.trim();
    }

    public String getEnterpassessdisopt() {
        return enterpassessdisopt;
    }

    public void setEnterpassessdisopt(String enterpassessdisopt) {
        this.enterpassessdisopt = enterpassessdisopt == null ? null : enterpassessdisopt.trim();
    }

    public String getEnterpassessdisgood() {
        return enterpassessdisgood;
    }

    public void setEnterpassessdisgood(String enterpassessdisgood) {
        this.enterpassessdisgood = enterpassessdisgood == null ? null : enterpassessdisgood.trim();
    }

    public String getEnterpassessdisinter() {
        return enterpassessdisinter;
    }

    public void setEnterpassessdisinter(String enterpassessdisinter) {
        this.enterpassessdisinter = enterpassessdisinter == null ? null : enterpassessdisinter.trim();
    }

    public String getEnterpassessdisbad() {
        return enterpassessdisbad;
    }

    public void setEnterpassessdisbad(String enterpassessdisbad) {
        this.enterpassessdisbad = enterpassessdisbad == null ? null : enterpassessdisbad.trim();
    }

    public String getCoopenterpemploystud() {
        return coopenterpemploystud;
    }

    public void setCoopenterpemploystud(String coopenterpemploystud) {
        this.coopenterpemploystud = coopenterpemploystud == null ? null : coopenterpemploystud.trim();
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
    
    @Override
	public String toString() {
		return "Intership [id=" + id + ", admcode=" + admcode + ", year=" + year + ", city=" + city + ", offcampttrainbase="
				+ offcampttrainbase + ", kownduration=" + kownduration + ", postduration=" + postduration + ", displaceduration=" + displaceduration
				+ ", stupostpartradio=" + stupostpartradio + ", studispartradio=" + studispartradio + ", enterpassessdisopt=" + enterpassessdisopt
				+ ", enterpassessdisgood=" + enterpassessdisgood + ", enterpassessdisinter=" + enterpassessdisinter + ", enterpassessdisbad=" + enterpassessdisbad + ", coopenterpemploystud="
				+ coopenterpemploystud +  ", audit=" + audit + "]";
	}
    public static List<Internship> sum(List<Internship> internList) {
		if (internList == null) {
			return internList;
		}
		List<Internship> sumList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Internship> itIntern = internList.iterator();
		boolean exist;
		while (itIntern.hasNext()) {
			exist = false;
			Internship internship = (Internship) itIntern.next();
			for(int i = 0; i < sumList.size(); i ++){
				Internship sum = sumList.get(i);
				if (sum.getYear().equals(internship.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					
					sum.setOffcampttrainbase(String.valueOf(Integer.parseInt(sum.offcampttrainbase)+Integer.parseInt(internship.offcampttrainbase)));
					sum.setKownduration(String.valueOf(Integer.parseInt(sum.kownduration)+Integer.parseInt(internship.kownduration)));
					sum.setPostduration(String.valueOf(Integer.parseInt(sum.postduration)+Integer.parseInt(internship.postduration)));
					sum.setDisplaceduration(String.valueOf(Integer.parseInt(sum.displaceduration)+Integer.parseInt(internship.displaceduration)));
					
					String sumPostValue = sum.stupostpartradio.replace("%", ""),
					intershipPostValue = internship.stupostpartradio.replace("%", "");
					sum.setStupostpartradio((Float.parseFloat(sumPostValue)+Float.parseFloat(intershipPostValue))+"");
					
					String sumDispartValue = sum.studispartradio.replace("%", ""),
					intershipDispartValue = internship.studispartradio.replace("%", "");
					sum.setStudispartradio((Float.parseFloat(sumDispartValue)+Float.parseFloat(intershipDispartValue))+"");
					
					String sumOptValue = sum.enterpassessdisopt.replace("%", ""),
					intershipOptValue = internship.enterpassessdisopt.replace("%", "");
					sum.setEnterpassessdisopt((Float.parseFloat(sumOptValue)+Float.parseFloat(intershipOptValue))+"");
					
					String sumGoodValue = sum.enterpassessdisgood.replace("%", ""),
					intershipGoodValue = internship.enterpassessdisgood.replace("%", "");
					sum.setEnterpassessdisgood((Float.parseFloat(sumGoodValue)+Float.parseFloat(intershipGoodValue))+"");
									
					String sumInterValue = sum.enterpassessdisinter.replace("%", ""),
					intershipInterValue = internship.enterpassessdisinter.replace("%", "");
					sum.setEnterpassessdisinter((Float.parseFloat(sumInterValue)+Float.parseFloat(intershipInterValue))+"");
					
					String sumBadValue = sum.enterpassessdisbad.replace("%", ""),
					intershipBadValue = internship.enterpassessdisbad.replace("%", "");
					sum.setEnterpassessdisbad((Float.parseFloat(sumBadValue)+Float.parseFloat(intershipBadValue))+"");
					
					String sumCoopValue = sum.coopenterpemploystud.replace("%", ""),
					intershipCoopValue = internship.coopenterpemploystud.replace("%", "");
					sum.setCoopenterpemploystud((Float.parseFloat(sumCoopValue)+Float.parseFloat(intershipCoopValue))+"");
					
					exist = true;
				}
			}
			if (!exist) {
				sumList.add(internship);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < sumList.size(); i++) {
			sumList.get(i).setCity(sumList.get(i).getCity().replaceAll("\\d+", ""));
			sumList.get(i).setAdmcode(sumList.get(i).getCity());//将admcode设为所在城市名，方便统一显示
			//sumList.get(i).setThreeConsol(new BigDecimal(Float.parseFloat(sumList.get(i).getThreeConsol().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			sumList.get(i).setStupostpartradio(new BigDecimal(Float.parseFloat(sumList.get(i).getStupostpartradio().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			sumList.get(i).setStudispartradio(new BigDecimal(Float.parseFloat(sumList.get(i).getStudispartradio().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			sumList.get(i).setEnterpassessdisopt(new BigDecimal(Float.parseFloat(sumList.get(i).getEnterpassessdisopt().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			sumList.get(i).setEnterpassessdisgood(new BigDecimal(Float.parseFloat(sumList.get(i).getEnterpassessdisgood().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			sumList.get(i).setEnterpassessdisinter(new BigDecimal(Float.parseFloat(sumList.get(i).getEnterpassessdisinter().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			sumList.get(i).setEnterpassessdisbad(new BigDecimal(Float.parseFloat(sumList.get(i).getEnterpassessdisbad().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			sumList.get(i).setCoopenterpemploystud(new BigDecimal(Float.parseFloat(sumList.get(i).getCoopenterpemploystud().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
		}
		
		return sumList;
	}
    public static List<Internship> avg(List<Internship> internList) {
		if (internList == null) {
			return internList;
		}
		List<Internship> avgList = new ArrayList<>();
		List<Integer> addendNum = new ArrayList<>();
		Iterator<Internship> itIntern = internList.iterator();
		boolean exist;
		while (itIntern.hasNext()) {
			exist = false;
			Internship internship = (Internship) itIntern.next();
			for(int i = 0; i < avgList.size(); i ++){
				Internship avg = avgList.get(i);
				if (avg.getYear().equals(internship.getYear())) {
					addendNum.set(i, addendNum.get(i)+1);
					avg.setOffcampttrainbase(String.valueOf(Integer.parseInt(avg.offcampttrainbase)+Integer.parseInt(internship.offcampttrainbase)));
					avg.setKownduration(String.valueOf(Integer.parseInt(avg.kownduration)+Integer.parseInt(internship.kownduration)));
					avg.setPostduration(String.valueOf(Integer.parseInt(avg.postduration)+Integer.parseInt(internship.postduration)));
					avg.setDisplaceduration(String.valueOf(Integer.parseInt(avg.displaceduration)+Integer.parseInt(internship.displaceduration)));
					
					String sumPostValue = avg.stupostpartradio.replace("%", ""),
					intershipPostValue = internship.stupostpartradio.replace("%", "");
					avg.setStupostpartradio((Float.parseFloat(sumPostValue)+Float.parseFloat(intershipPostValue))+"");
					
					String sumDispartValue = avg.studispartradio.replace("%", ""),
					intershipDispartValue = internship.studispartradio.replace("%", "");
					avg.setStudispartradio((Float.parseFloat(sumDispartValue)+Float.parseFloat(intershipDispartValue))+"");
					
					String sumOptValue = avg.enterpassessdisopt.replace("%", ""),
					intershipOptValue = internship.enterpassessdisopt.replace("%", "");
					avg.setEnterpassessdisopt((Float.parseFloat(sumOptValue)+Float.parseFloat(intershipOptValue))+"");
					
					String sumGoodValue = avg.enterpassessdisgood.replace("%", ""),
					intershipGoodValue = internship.enterpassessdisgood.replace("%", "");
					avg.setEnterpassessdisgood((Float.parseFloat(sumGoodValue)+Float.parseFloat(intershipGoodValue))+"");
									
					String sumInterValue = avg.enterpassessdisinter.replace("%", ""),
					intershipInterValue = internship.enterpassessdisinter.replace("%", "");
					avg.setEnterpassessdisinter((Float.parseFloat(sumInterValue)+Float.parseFloat(intershipInterValue))+"");
					
					String sumBadValue = avg.enterpassessdisbad.replace("%", ""),
					intershipBadValue = internship.enterpassessdisbad.replace("%", "");
					avg.setEnterpassessdisbad((Float.parseFloat(sumBadValue)+Float.parseFloat(intershipBadValue))+"");
					
					String sumCoopValue = avg.coopenterpemploystud.replace("%", ""),
					intershipCoopValue = internship.coopenterpemploystud.replace("%", "");
					avg.setCoopenterpemploystud((Float.parseFloat(sumCoopValue)+Float.parseFloat(intershipCoopValue))+"");
					exist = true;
				}
			}
			if (!exist) {
				avgList.add(internship);
				addendNum.add(1);
			}
		}
		
		for (int i = 0; i < avgList.size(); i++) {
			Internship avg = (Internship) avgList.get(i);
			avg.setCity(avg.getCity().replaceAll("\\d+", ""));
			avg.setAdmcode(avg.getCity()+"平均值");//将admcode设为所在城市名，方便统一显示
			
			avg.setOffcampttrainbase(String.valueOf(Float.parseFloat(avg.offcampttrainbase)/addendNum.get(i)));
			avg.setKownduration(String.valueOf(Float.parseFloat(avg.kownduration)/addendNum.get(i)));
			avg.setPostduration(String.valueOf(Float.parseFloat(avg.postduration)/addendNum.get(i)));
			avg.setDisplaceduration(String.valueOf(Float.parseFloat(avg.displaceduration)/addendNum.get(i)));
			
			avg.setStupostpartradio(new BigDecimal(Float.parseFloat(avg.getStupostpartradio().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			avg.setStudispartradio(new BigDecimal(Float.parseFloat(avg.getStudispartradio().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			avg.setEnterpassessdisopt(new BigDecimal(Float.parseFloat(avg.getEnterpassessdisopt().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			avg.setEnterpassessdisgood(new BigDecimal(Float.parseFloat(avg.getEnterpassessdisgood().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			avg.setEnterpassessdisinter(new BigDecimal(Float.parseFloat(avg.getEnterpassessdisinter().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			avg.setEnterpassessdisbad(new BigDecimal(Float.parseFloat(avg.getEnterpassessdisbad().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			avg.setCoopenterpemploystud(new BigDecimal(Float.parseFloat(avg.getCoopenterpemploystud().replace("%", ""))/addendNum.get(i)).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
		}
		
		return avgList;
	}
}