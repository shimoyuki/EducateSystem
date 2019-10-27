package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.DataQueryDao;
import com.jks.entity.CounpaSupp;
import com.jks.entity.EducationTrain;
import com.jks.entity.EmployQuality;
import com.jks.entity.Equitment;
import com.jks.entity.Experience;
import com.jks.entity.FileInfo;
import com.jks.entity.Funds;
import com.jks.entity.Groupschool;
import com.jks.entity.Information;
import com.jks.entity.Internship;
import com.jks.entity.MajorLayout;
import com.jks.entity.MajorNum;
import com.jks.entity.Partybulid;
import com.jks.entity.Policy;
import com.jks.entity.Poor;
import com.jks.entity.QualityAssurance;
import com.jks.entity.Schoolenterprise;
import com.jks.entity.Size;
import com.jks.entity.Skill;
import com.jks.entity.SkillTrain;
import com.jks.entity.SocialService;
import com.jks.entity.StudentQuality;
import com.jks.entity.Teachers;
import com.jks.entity.User;
import com.jks.service.DataQueryService;

@Service
@Transactional
public class DataQueryServiceImpl implements DataQueryService{
	@Resource  
    private DataQueryDao dataQueryDao;
	
	@Override
	public User getUserByAdmcode(String admcode) {
		User user = dataQueryDao.getUserByAdmcode(admcode);
		return user;
	}
	
	@Override
	public List<Size> getSizeList(String admcode, String city) {
		List<Size> size = dataQueryDao.getSizeList( admcode,  city);
		for(int i=0;i<size.size();i++){
			size.get(i).setAdmcode(dataQueryDao.getSchoolName(size.get(i).getAdmcode()));
		}
		return size;
	}

	@Override
	public List<Equitment> getEquitmentList(String admcode, String city) {
		List<Equitment> equitment = dataQueryDao.getEquitmentList( admcode,  city);
		for(int i=0;i<equitment.size();i++){
			equitment.get(i).setAdmcode(dataQueryDao.getSchoolName(equitment.get(i).getAdmcode()));
		}
		return equitment;
	}

	@Override
	public List<Teachers> getTeachersList(String admcode, String city) {
		List<Teachers> teachers =  dataQueryDao.getTeachersList( admcode,  city);
		for(int i=0;i<teachers.size();i++){
			teachers.get(i).setAdmcode(dataQueryDao.getSchoolName(teachers.get(i).getAdmcode()));
		}
		return teachers;
	}

	@Override
	public List<Information> getInformationList(String admcode, String city) {
		List<Information> information = dataQueryDao.getInformationList( admcode,  city);
		for(int i=0;i<information.size();i++){
			information.get(i).setAdmcode(dataQueryDao.getSchoolName(information.get(i).getAdmcode()));
		}
		return information;
	}

	@Override
	public List<StudentQuality> getStudentQualityList(String admcode,String city) {
		List<StudentQuality> studentQuality = dataQueryDao.getStudentQualityList( admcode, city);
		for(int i=0;i<studentQuality.size();i++){
			studentQuality.get(i).setAdmcode(dataQueryDao.getSchoolName(studentQuality.get(i).getAdmcode()));
		}
		return studentQuality;
	}

	@Override
	public List<Experience> getExperienceList(String admcode, String city) {
		List<Experience> experience = dataQueryDao.getExperienceList( admcode,  city);
		for(int i=0;i<experience.size();i++){
			experience.get(i).setAdmcode(dataQueryDao.getSchoolName(experience.get(i).getAdmcode()));
		}
		return experience;
	}

	@Override
	public List<EmployQuality> getEmployQualityList(String admcode, String city) {
		List<EmployQuality> employQuality = dataQueryDao.getEmployQualityList( admcode,  city);
		for(int i=0;i<employQuality.size();i++){
			employQuality.get(i).setAdmcode(dataQueryDao.getSchoolName(employQuality.get(i).getAdmcode()));
		}
		return employQuality;
	}

	@Override
	public List<MajorLayout> getMajorLayoutList(String admcode, String city) {
		List <MajorLayout> majorLayout = dataQueryDao.getMajorLayoutList( admcode,  city);
		for(int i=0;i<majorLayout.size();i++){
			majorLayout.get(i).setAdmcode(dataQueryDao.getSchoolName(majorLayout.get(i).getAdmcode()));
		}
		return majorLayout;
	}

	@Override
	public List<MajorNum> getMajorNumList(String admcode, String city) {
		List<MajorNum> majorNum = dataQueryDao.getMajorNumList( admcode,  city);
		for(int i=0;i<majorNum.size();i++){
			majorNum.get(i).setAdmcode(dataQueryDao.getSchoolName(majorNum.get(i).getAdmcode()));
		}
		return majorNum;
	}

	@Override
	public List<QualityAssurance> getQualityAssuranceList(String admcode,String city) {
		List<QualityAssurance> qualityAssurance = dataQueryDao.getQualityAssuranceList( admcode, city);
		for(int i=0;i<qualityAssurance.size();i++){
			qualityAssurance.get(i).setAdmcode(dataQueryDao.getSchoolName(qualityAssurance.get(i).getAdmcode()));
		}
		return qualityAssurance;
	}

	@Override
	public List<EducationTrain> getEducationTrainList(String admcode,String city) {
		List<EducationTrain> educationTrain = dataQueryDao.getEducationTrainList( admcode, city);
		for(int i=0;i<educationTrain.size();i++){
			educationTrain.get(i).setAdmcode(dataQueryDao.getSchoolName(educationTrain.get(i).getAdmcode()));
		}
		return educationTrain;
	}

	@Override
	public List<Schoolenterprise> getSchoolenterpriseList(String admcode,String city) {
		List<Schoolenterprise> schoolenterprise = dataQueryDao.getSchoolenterpriseList( admcode, city);
		for(int i=0;i<schoolenterprise.size();i++){
			schoolenterprise.get(i).setAdmcode(dataQueryDao.getSchoolName(schoolenterprise.get(i).getAdmcode()));
		}
		return schoolenterprise;
	}

	@Override
	public List<Internship> getInternshipList(String admcode, String city) {
		List<Internship> internship = dataQueryDao.getInternshipList( admcode,  city);
		for(int i=0;i<internship.size();i++){
			internship.get(i).setAdmcode(dataQueryDao.getSchoolName(internship.get(i).getAdmcode()));
		}
		return internship;
	}

	@Override
	public List<Groupschool> getGroupschoolList(String admcode, String city) {
		List<Groupschool> groupschool = dataQueryDao.getGroupschoolList( admcode,  city);
		for(int i=0;i<groupschool.size();i++){
			groupschool.get(i).setAdmcode(dataQueryDao.getSchoolName(groupschool.get(i).getAdmcode()));
		}
		return groupschool;
	}

	@Override
	public List<SkillTrain> getSkillTrainList(String admcode, String city) {
		List<SkillTrain> skillTrain = dataQueryDao.getSkillTrainList( admcode,  city);
		for(int i=0;i<skillTrain.size();i++){
			skillTrain.get(i).setAdmcode(dataQueryDao.getSchoolName(skillTrain.get(i).getAdmcode()));
		}
		return skillTrain;
	}
	
	@Override
	public List<Skill> getSkillList(int id) {
		List<Skill> skill = dataQueryDao.getSkillList(id);
		for(int i=0;i<skill.size();i++){
			skill.get(i).setAdmcode(dataQueryDao.getSchoolName(skill.get(i).getAdmcode()));
		}
		return skill;
	}

	@Override
	public List<SocialService> getSocialServiceList(String admcode, String city) {
		List<SocialService> socialService = dataQueryDao.getSocialServiceList( admcode,  city);
		for(int i=0;i<socialService.size();i++){
			socialService.get(i).setAdmcode(dataQueryDao.getSchoolName(socialService.get(i).getAdmcode()));
		}
		return socialService;
	}

	@Override
	public List<CounpaSupp> getCounpaSuppList(String admcode, String city) {
		List<CounpaSupp> counpaSupp = dataQueryDao.getCounpaSuppList( admcode,  city);
		for(int i=0;i<counpaSupp.size();i++){
			counpaSupp.get(i).setAdmcode(dataQueryDao.getSchoolName(counpaSupp.get(i).getAdmcode()));
		}
		return counpaSupp;
	}
	
	@Override
	public List<Poor> getPoorList(int id) {
		List<Poor> poor = dataQueryDao.getPoorlList(id);
		for(int i=0;i<poor.size();i++){
			poor.get(i).setAdmcode(dataQueryDao.getSchoolName(poor.get(i).getAdmcode()));
		}
		return poor;
	}

	@Override
	public List<Funds> getFundsList(String admcode, String city) {
		List<Funds> funds = dataQueryDao.getFundsList( admcode,  city);
		for(int i=0;i<funds.size();i++){
			funds.get(i).setAdmcode(dataQueryDao.getSchoolName(funds.get(i).getAdmcode()));
		}
		return funds;
	}

	@Override
	public List<Policy> getPolicyList(String admcode, String city) {
		List<Policy> policy = dataQueryDao.getPolicyList( admcode,  city);
		for(int i=0;i<policy.size();i++){
			policy.get(i).setAdmcode(dataQueryDao.getSchoolName(policy.get(i).getAdmcode()));
		}
		return policy;
	}

	@Override
	public List<Partybulid> getPartybuildList(String admcode, String city) {
		List<Partybulid> partybulid = dataQueryDao.getPartybuildList( admcode,  city);
		for(int i=0;i<partybulid.size();i++){
			partybulid.get(i).setAdmcode(dataQueryDao.getSchoolName(partybulid.get(i).getAdmcode()));
		}
		return partybulid;
	}

	@Override
	public List<FileInfo> getFileInfoList(String admcode, String city) {
		List<FileInfo> fileInfo = dataQueryDao.getFileInfoList( admcode,  city);
		for(int i=0;i<fileInfo.size();i++){
			fileInfo.get(i).setWriter(dataQueryDao.getSchoolName(fileInfo.get(i).getWriter()));
		}
		return fileInfo;
	}

	@Override
	public List<String> getSizeYearList() {
		List<String> sizeYear = dataQueryDao.getSizeYearList();
		return sizeYear;
	}

	@Override
	public List<String> getEquitmentYearList() {
		List<String> equitmentYear = dataQueryDao.getEquitmentYearList();
		return equitmentYear;
	}

	@Override
	public List<String> getTeachersYearList() {
		List<String> teachersYear = dataQueryDao.getTeachersYearList();
		return teachersYear;
	}

	@Override
	public List<String> getInformationYearList() {
		List<String> informationYear = dataQueryDao.getInformationYearList();
		return informationYear;
	}

	@Override
	public List<String> getEmployQualityYearList() {
		List<String> employQuality = dataQueryDao.getEmployQualityYearList();
		return employQuality;
	}

	@Override
	public List<String> getExperienceYearList() {
		List<String> experienceYear = dataQueryDao.getExperienceYearList();
		return experienceYear;
	}

	@Override
	public List<String> getStudentQualityYearList() {
		List<String> studentQualityYear = dataQueryDao.getStudentQualityYearList();
		return studentQualityYear;
	}

	@Override
	public List<String> getEducationTrainYearList() {
		List<String> educationTrain = dataQueryDao.getEducationTrainYearList();
		return educationTrain;
	}

	@Override
	public List<String> getQualityAssuranceYearList() {
		List<String> qualityAssuranceYear = dataQueryDao.getQualityAssuranceYearList();
		return qualityAssuranceYear;
	}

	@Override
	public List<String> getMajorNumYearList() {
		List<String> majorNumYear = dataQueryDao.getMajorNumYearList();
		return majorNumYear;
	}

	@Override
	public List<String> getMajorStuYearList() {
		List<String> majorStuYear = dataQueryDao.getMajorStuYearList();
		return majorStuYear;
	}

	@Override
	public List<String> getMajorLayoutYearList() {
		List<String> majorLayoutYear = dataQueryDao.getMajorLayoutYearList();
		return majorLayoutYear;
	}

	@Override
	public List<String> getSkillTrainYearList() {
		List<String> skillTrainYear = dataQueryDao.getSkillTrainYearList();
		return skillTrainYear;
	
	}

	@Override
	public List<String> getSkillYearList() {
		List<String> skillYear = dataQueryDao.getSkillYearList();
		return skillYear;
	
	}

	@Override
	public List<String> getSocialServiceYearList() {
		List<String> socialServiceYear = dataQueryDao.getSocialServiceYearList();
		return socialServiceYear;

	}

	@Override
	public List<String> getCounpaSuppYearList() {
		List<String> counpaSuppYear = dataQueryDao.getCounpaSuppYearList();
		return counpaSuppYear;
	
	}

	@Override
	public List<String> getPoorYearList() {
		List<String> poorYear = dataQueryDao.getPoorYearList();
		return poorYear;
	}

	@Override
	public List<String> getFundsYearList() {
		List<String> fundsYear = dataQueryDao.getFundsYearList();
		return fundsYear;
	}

	@Override
	public List<String> getProjectInputYearList() {
		List<String> projectInputYear = dataQueryDao.getProjectInputYearList();
		return projectInputYear;
	}

	@Override
	public List<String> getPolicyYearList() {
		List<String> policyYear = dataQueryDao.getPolicyYearList();
		return policyYear;
	}

	@Override
	public List<String> getPolicyMeasureYearList() {
		List<String> policyMeasureYear = dataQueryDao.getPolicyMeasureYearList();
		return policyMeasureYear;
	}

	@Override
	public List<String> getPartybulidYearList() {
		List<String> partybulidYear = dataQueryDao.getPartybulidYearList();
		return partybulidYear;
	}

	@Override
	public List<String> getSchoolenterpriseYearList() {
		List<String> schoolenterpriseYear = dataQueryDao.getSchoolenterpriseYearList();
		return schoolenterpriseYear;
	}

	@Override
	public List<String> getGroupschoolYearList() {
		List<String> groupschoolYear = dataQueryDao.getGroupschoolYearList();
		return groupschoolYear;
	}

	@Override
	public List<String> getInternshipYearList() {
		List<String> internshipYear = dataQueryDao.getInternshipYearList();
		return internshipYear;
	}
	
}
