package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.DataSumAndAvgDao;
import com.jks.entity.CounpaSupp;
import com.jks.entity.EducationTrain;
import com.jks.entity.EmployQuality;
import com.jks.entity.Equitment;
import com.jks.entity.Experience;
import com.jks.entity.Funds;
import com.jks.entity.Groupschool;
import com.jks.entity.Information;
import com.jks.entity.Internship;
import com.jks.entity.MajorLayout;
import com.jks.entity.MajorNum;
import com.jks.entity.Partybulid;
import com.jks.entity.Policy;
import com.jks.entity.QualityAssurance;
import com.jks.entity.Schoolenterprise;
import com.jks.entity.Size;
import com.jks.entity.SkillTrain;
import com.jks.entity.SocialService;
import com.jks.entity.StudentQuality;
import com.jks.entity.Teachers;
import com.jks.service.DataSumAndAvgService;

@Service
@Transactional
public class DataSumAndAvgServiceImpl implements DataSumAndAvgService{
	@Resource  
    private DataSumAndAvgDao dataSumAndAvgDao;
	
	@Override
	public List<String> getAreaList() {
		return dataSumAndAvgDao.getAreaList();
	}

	@Override
	public List<Size> getAvgSize(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCitySize(year, city).size()+city);
		return Size.avg(dataSumAndAvgDao.getCitySize(year, city));
	}
	
	@Override
	public List<Size> getSumSize(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCitySize(year, city).size()+city);
		return Size.sum(dataSumAndAvgDao.getCitySize(year, city));
	}


	@Override
	public List<Equitment> getAvgEquitment(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityEquitment(year, city).size()+city);
		return Equitment.avg(dataSumAndAvgDao.getCityEquitment(year, city));
	}

	@Override
	public List<Equitment> getSumEquitment(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityEquitment(year, city).size()+city);
		return Equitment.sum(dataSumAndAvgDao.getCityEquitment(year, city));
	}


	@Override
	public List<Teachers> getAvgTeachers(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityTeachers(year, city).size()+city);
		return Teachers.avg(dataSumAndAvgDao.getCityTeachers(year, city));
	}

	@Override
	public List<Teachers> getSumTeachers(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityTeachers(year, city).size()+city);
		return Teachers.sum(dataSumAndAvgDao.getCityTeachers(year, city));
	}


	@Override
	public List<Information> getAvgInformation(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityInformation(year, city).size()+city);
		return Information.avg(dataSumAndAvgDao.getCityInformation(year, city));
	}

	@Override
	public List<Information> getSumInformation(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityInformation(year, city).size()+city);
		return Information.sum(dataSumAndAvgDao.getCityInformation(year, city));
	}


	@Override
	public List<StudentQuality> getAvgStudentQuality(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityStudentQuality(year, city).size()+city);
		return StudentQuality.avg(dataSumAndAvgDao.getCityStudentQuality(year, city));
	}

	@Override
	public List<StudentQuality> getSumStudentQuality(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityStudentQuality(year, city).size()+city);
		return StudentQuality.sum(dataSumAndAvgDao.getCityStudentQuality(year, city));
	}


	@Override
	public List<Experience> getAvgExperience(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityExperience(year, city).size()+city);
		return Experience.avg(dataSumAndAvgDao.getCityExperience(year, city));
	}

	@Override
	public List<Experience> getSumExperience(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityExperience(year, city).size()+city);
		return Experience.sum(dataSumAndAvgDao.getCityExperience(year, city));
	}


	@Override
	public List<EmployQuality> getAvgEmployQuality(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityEmployQuality(year, city).size()+city);
		return EmployQuality.avg(dataSumAndAvgDao.getCityEmployQuality(year, city));
	}

	@Override
	public List<EmployQuality> getSumEmployQuality(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityEmployQuality(year, city).size()+city);
		return EmployQuality.sum(dataSumAndAvgDao.getCityEmployQuality(year, city));
	}


	@Override
	public List<MajorLayout> getAvgMajorLayout(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityMajorLayout(year, city).size()+city);
		return MajorLayout.avg(dataSumAndAvgDao.getCityMajorLayout(year, city));
	}

	@Override
	public List<MajorLayout> getSumMajorLayout(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityMajorLayout(year, city).size()+city);
		return MajorLayout.sum(dataSumAndAvgDao.getCityMajorLayout(year, city));
	}

	@Override
	public List<MajorNum> getAvgMajorNum(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityMajorNum(year, city).size()+city);
		return MajorNum.avg(dataSumAndAvgDao.getCityMajorNum(year, city));
	}

	@Override
	public List<MajorNum> getSumMajorNum(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityMajorNum(year, city).size()+city);
		return MajorNum.sum(dataSumAndAvgDao.getCityMajorNum(year, city));
	}


	@Override
	public List<QualityAssurance> getAvgQualityAssurance(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityQualityAssurance(year, city).size()+city);
		return QualityAssurance.avg(dataSumAndAvgDao.getCityQualityAssurance(year, city));
	}

	@Override
	public List<QualityAssurance> getSumQualityAssurance(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityQualityAssurance(year, city).size()+city);
		return QualityAssurance.sum(dataSumAndAvgDao.getCityQualityAssurance(year, city));
	}


	@Override
	public List<EducationTrain> getAvgEducationTrain(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityEducationTrain(year, city).size()+city);
		return EducationTrain.avg(dataSumAndAvgDao.getCityEducationTrain(year, city));
	}

	@Override
	public List<EducationTrain> getSumEducationTrain(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityEducationTrain(year, city).size()+city);
		return EducationTrain.sum(dataSumAndAvgDao.getCityEducationTrain(year, city));
	}


	@Override
	public List<Schoolenterprise> getAvgSchoolenterprise(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCitySchoolenterprise(year, city).size()+city);
		return Schoolenterprise.avg(dataSumAndAvgDao.getCitySchoolenterprise(year, city));
	}

	@Override
	public List<Schoolenterprise> getSumSchoolenterprise(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCitySchoolenterprise(year, city).size()+city);
		return Schoolenterprise.sum(dataSumAndAvgDao.getCitySchoolenterprise(year, city));
	}


	@Override
	public List<Internship> getAvgInternship(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityInternship(year, city).size()+city);
		return Internship.avg(dataSumAndAvgDao.getCityInternship(year, city));
	}

	@Override
	public List<Internship> getSumInternship(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityInternship(year, city).size()+city);
		return Internship.sum(dataSumAndAvgDao.getCityInternship(year, city));
	}


	@Override
	public List<Groupschool> getAvgGroupschool(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityGroupschool(year, city).size()+city);
		return Groupschool.avg(dataSumAndAvgDao.getCityGroupschool(year, city));
	}

	@Override
	public List<Groupschool> getSumGroupschool(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityGroupschool(year, city).size()+city);
		return Groupschool.sum(dataSumAndAvgDao.getCityGroupschool(year, city));
	}

	@Override
	public List<SkillTrain> getAvgSkillTrain(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCitySkillTrain(year, city).size()+city);
		return SkillTrain.avg(dataSumAndAvgDao.getCitySkillTrain(year, city));
	}

	@Override
	public List<SkillTrain> getSumSkillTrain(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCitySkillTrain(year, city).size()+city);
		return SkillTrain.sum(dataSumAndAvgDao.getCitySkillTrain(year, city));
	}


	@Override
	public List<SocialService> getAvgSocialService(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCitySocialService(year, city).size()+city);
		return SocialService.avg(dataSumAndAvgDao.getCitySocialService(year, city));
	}
	
	@Override
	public List<SocialService> getSumSocialService(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCitySocialService(year, city).size()+city);
		return SocialService.sum(dataSumAndAvgDao.getCitySocialService(year, city));
	}


	@Override
	public List<CounpaSupp> getAvgCounpaSupp(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityCounpaSupp(year, city).size()+city);
		return CounpaSupp.avg(dataSumAndAvgDao.getCityCounpaSupp(year, city));
	}

	@Override
	public List<CounpaSupp> getSumCounpaSupp(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityCounpaSupp(year, city).size()+city);
		return CounpaSupp.sum(dataSumAndAvgDao.getCityCounpaSupp(year, city));
	}


	@Override
	public List<Funds> getAvgFunds(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityFunds(year, city).size()+city);
		return Funds.avg(dataSumAndAvgDao.getCityFunds(year, city));
	}

	@Override
	public List<Funds> getSumFunds(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityFunds(year, city).size()+city);
		return Funds.sum(dataSumAndAvgDao.getCityFunds(year, city));
	}

	@Override
	public List<Policy> getAvgPolicy(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityPolicy(year, city).size()+city);
		return Policy.avg(dataSumAndAvgDao.getCityPolicy(year, city));
	}

	@Override
	public List<Policy> getSumPolicy(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityPolicy(year, city).size()+city);
		return Policy.sum(dataSumAndAvgDao.getCityPolicy(year, city));
	}

	@Override
	public List<Partybulid> getAvgPartybulid(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityPartybulid(year, city).size()+city);
		return Partybulid.avg(dataSumAndAvgDao.getCityPartybulid(year, city));
	}

	@Override
	public List<Partybulid> getSumPartybulid(String year, String city) {
		System.out.println(dataSumAndAvgDao.getCityPartybulid(year, city).size()+city);
		return Partybulid.sum(dataSumAndAvgDao.getCityPartybulid(year, city));
	}

	



}
