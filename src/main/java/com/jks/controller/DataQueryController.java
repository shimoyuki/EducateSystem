package com.jks.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import com.jks.entity.QualityAssurance;
import com.jks.entity.SchoolInfo;
import com.jks.entity.Schoolenterprise;
import com.jks.entity.Size;
import com.jks.entity.SkillTrain;
import com.jks.entity.SocialService;
import com.jks.entity.StudentQuality;
import com.jks.entity.Teachers;
import com.jks.entity.User;
import com.jks.service.DataQueryService;
import com.jks.service.GetCityListService;
import com.jks.service.QuerySchoolInfoService;

@Controller
@RequestMapping("/dataQuery")
public class DataQueryController {
	@Autowired
	private DataQueryService dataQueryService;
	@Autowired
	private GetCityListService getCityListService;
	@Autowired
	private QuerySchoolInfoService querySchoolInfoService;

	@RequestMapping("/getDataQueryList")
	public String getDataQueryList(Model model, HttpServletRequest request,
			@RequestParam(value = "pnSize", defaultValue = "1") Integer pnSize,
			@RequestParam(value = "pnEquitment", defaultValue = "1") Integer pnEquitment,
			@RequestParam(value = "pnTeachers", defaultValue = "1") Integer pnTeachers,
			@RequestParam(value = "pnInformation", defaultValue = "1") Integer pnInformation,
			@RequestParam(value = "pnStudentQuality", defaultValue = "1") Integer pnStudentQuality,
			@RequestParam(value = "pnExperience", defaultValue = "1") Integer pnExperience,
			@RequestParam(value = "pnEmployQuality", defaultValue = "1") Integer pnEmployQuality,
			@RequestParam(value = "pnMajorLayout", defaultValue = "1") Integer pnMajorLayout,
			@RequestParam(value = "pnMajorNum", defaultValue = "1") Integer pnMajorNum,
			@RequestParam(value = "pnQualityAssurance", defaultValue = "1") Integer pnQualityAssurance,
			@RequestParam(value = "pnEducationTrain", defaultValue = "1") Integer pnEducationTrain,
			@RequestParam(value = "pnSchoolenterprise", defaultValue = "1") Integer pnSchoolenterprise,
			@RequestParam(value = "pnInternship", defaultValue = "1") Integer pnInternship,
			@RequestParam(value = "pnGroupschool", defaultValue = "1") Integer pnGroupschool,
			@RequestParam(value = "pnSkillTrain", defaultValue = "1") Integer pnSkillTrain,
			@RequestParam(value = "pnSocialService", defaultValue = "1") Integer pnSocialService,
			@RequestParam(value = "pnCounpaSupp", defaultValue = "1") Integer pnCounpaSupp,
			@RequestParam(value = "pnFunds", defaultValue = "1") Integer pnFunds,
			@RequestParam(value = "pnPolicy", defaultValue = "1") Integer pnPolicy,
			@RequestParam(value = "pnPartybulid", defaultValue = "1") Integer pnPartybulid,
			@RequestParam(value = "pnFileInfo", defaultValue = "1") Integer pnFileInfo) {
		HttpSession session = request.getSession();

		Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
		String city = (String) param.get("city");
		String admcode = (String) param.get("schoolName");
		String query = (String) param.get("query");
		String citys = (String) param.get("citys");
		String admcodes = (String) param.get("schoolNames");
		String querys = (String) param.get("querys");

		String sn = (String) param.get("sn");
		String cn = (String) param.get("cn");
		String qn = (String) param.get("qn");

		String x, y, z, q;

		param.remove("city");
		param.remove("schoolName");
		param.remove("query");
		param.remove("citys");
		param.remove("schoolNames");
		param.remove("querys");
		param.remove("sn");
		param.remove("cn");
		param.remove("qn");

		if (sn != null && sn != "") {
			session.setAttribute("sn", sn);
		}

		if (cn != null && cn != "") {
			session.setAttribute("cn", cn);
		}

		if (qn != null && qn != "") {
			session.setAttribute("qn", qn);
		}

		if (city == null && admcode == null) {
			x = admcodes;

			if (citys == null || citys == "") {
				y = citys;
			} else {
				y = dataQueryService.getUserByAdmcode(citys).getSchoolname();
			}

			z = citys;

			q = querys;
		} else {
			x = admcode;

			if (city == null || city == "") {
				y = city;
			} else {
				y = dataQueryService.getUserByAdmcode(city).getSchoolname();
			}

			z = city;

			q = query;
		}

		PageHelper.startPage(pnSize, 12);
		List<Size> size = dataQueryService.getSizeList(x, y);
		PageInfo sizePageInfo = new PageInfo(size, 5);
		model.addAttribute("sizePageInfo", sizePageInfo);

		PageHelper.startPage(pnEquitment, 12);
		List<Equitment> equitment = dataQueryService.getEquitmentList(x, y);
		PageInfo equitmentPageInfo = new PageInfo(equitment, 5);
		model.addAttribute("equitmentPageInfo", equitmentPageInfo);

		PageHelper.startPage(pnTeachers, 12);
		List<Teachers> teachers = dataQueryService.getTeachersList(x, y);
		PageInfo teachersPageInfo = new PageInfo(teachers, 5);
		model.addAttribute("teachersPageInfo", teachersPageInfo);

		PageHelper.startPage(pnInformation, 12);
		List<Information> information = dataQueryService.getInformationList(x, y);
		PageInfo informationPageInfo = new PageInfo(information, 5);
		model.addAttribute("informationPageInfo", informationPageInfo);

		PageHelper.startPage(pnStudentQuality, 12);
		List<StudentQuality> studentQuality = dataQueryService.getStudentQualityList(x, y);
		PageInfo studentQualityPageInfo = new PageInfo(studentQuality, 5);
		model.addAttribute("studentQualityPageInfo", studentQualityPageInfo);

		PageHelper.startPage(pnExperience, 12);
		List<Experience> experience = dataQueryService.getExperienceList(x, y);
		PageInfo experiencePageInfo = new PageInfo(experience, 5);
		model.addAttribute("experiencePageInfo", experiencePageInfo);

		PageHelper.startPage(pnEmployQuality, 12);
		List<EmployQuality> employQuality = dataQueryService.getEmployQualityList(x, y);
		PageInfo employQualityPageInfo = new PageInfo(employQuality, 5);
		model.addAttribute("employQualityPageInfo", employQualityPageInfo);

		PageHelper.startPage(pnMajorLayout, 12);
		List<MajorLayout> majorLayout = dataQueryService.getMajorLayoutList(x, y);
		PageInfo majorLayoutPageInfo = new PageInfo(majorLayout, 5);
		model.addAttribute("majorLayoutPageInfo", majorLayoutPageInfo);

		PageHelper.startPage(pnMajorNum, 12);
		List<MajorNum> majorNum = dataQueryService.getMajorNumList(x, y);
		PageInfo MajorNumPageInfo = new PageInfo(majorNum, 5);
		model.addAttribute("MajorNumPageInfo", MajorNumPageInfo);

		PageHelper.startPage(pnQualityAssurance, 12);
		List<QualityAssurance> qualityAssurance = dataQueryService.getQualityAssuranceList(x, y);
		PageInfo qualityAssurancePageInfo = new PageInfo(qualityAssurance, 5);
		model.addAttribute("qualityAssurancePageInfo", qualityAssurancePageInfo);

		PageHelper.startPage(pnEducationTrain, 12);
		List<EducationTrain> educationTrain = dataQueryService.getEducationTrainList(x, y);
		PageInfo educationTrainPageInfo = new PageInfo(educationTrain, 5);
		model.addAttribute("educationTrainPageInfo", educationTrainPageInfo);

		PageHelper.startPage(pnSchoolenterprise, 12);
		List<Schoolenterprise> schoolenterprise = dataQueryService.getSchoolenterpriseList(x, y);
		PageInfo schoolenterprisePageInfo = new PageInfo(schoolenterprise, 5);
		model.addAttribute("schoolenterprisePageInfo", schoolenterprisePageInfo);

		PageHelper.startPage(pnInternship, 12);
		List<Internship> internship = dataQueryService.getInternshipList(x, y);
		PageInfo internshipPageInfo = new PageInfo(internship, 5);
		model.addAttribute("internshipPageInfo", internshipPageInfo);

		PageHelper.startPage(pnGroupschool, 12);
		List<Groupschool> groupschool = dataQueryService.getGroupschoolList(x, y);
		PageInfo groupschoolPageInfo = new PageInfo(groupschool, 5);
		model.addAttribute("groupschoolPageInfo", groupschoolPageInfo);

		PageHelper.startPage(pnSkillTrain, 12);
		List<SkillTrain> skillTrain = dataQueryService.getSkillTrainList(x, y);
		PageInfo skillTrainPageInfo = new PageInfo(skillTrain, 5);
		model.addAttribute("skillTrainPageInfo", skillTrainPageInfo);

		PageHelper.startPage(pnSocialService, 12);
		List<SocialService> socialService = dataQueryService.getSocialServiceList(x, y);
		PageInfo socialServicePageInfo = new PageInfo(socialService, 5);
		model.addAttribute("socialServicePageInfo", socialServicePageInfo);

		PageHelper.startPage(pnCounpaSupp, 12);
		List<CounpaSupp> counpaSupp = dataQueryService.getCounpaSuppList(x, y);
		PageInfo counpaSuppPageInfo = new PageInfo(counpaSupp, 5);
		model.addAttribute("counpaSuppPageInfo", counpaSuppPageInfo);

		PageHelper.startPage(pnFunds, 12);
		List<Funds> funds = dataQueryService.getFundsList(x, y);
		PageInfo fundsPageInfo = new PageInfo(funds, 5);
		model.addAttribute("fundsPageInfo", fundsPageInfo);

		PageHelper.startPage(pnPolicy, 12);
		List<Policy> policy = dataQueryService.getPolicyList(x, y);
		PageInfo policyPageInfo = new PageInfo(policy, 5);
		model.addAttribute("policyPageInfo", policyPageInfo);

		PageHelper.startPage(pnPartybulid, 12);
		List<Partybulid> partybulid = dataQueryService.getPartybuildList(x, y);
		PageInfo partybulidPageInfo = new PageInfo(partybulid, 5);
		model.addAttribute("partybulidPageInfo", partybulidPageInfo);

		PageHelper.startPage(pnFileInfo, 12);
		List<FileInfo> fileInfo = dataQueryService.getFileInfoList(x, y);
		for (int i = 0; i < fileInfo.size(); i++) {
			String source = fileInfo.get(i).getSource();
			if (source.equals("culture")) {
				fileInfo.get(i).setSource("传统文化（地方特色）教育活动开展情况");
			} else if (source.equals("grouprun")) {
				fileInfo.get(i).setSource("学校集团化办学");
			} else if (source.equals("help")) {
				fileInfo.get(i).setSource("对口帮扶（扶贫）情况");
			} else if (source.equals("innovation")) {
				fileInfo.get(i).setSource("特色创新");
			} else if (source.equals("moralwork")) {
				fileInfo.get(i).setSource("德育工作经验措施");
			} else if (source.equals("outstanding")) {
				fileInfo.get(i).setSource("优秀毕业生典型案例");
			} else if (source.equals("partybuild")) {
				fileInfo.get(i).setSource("党建工作");
			} else if (source.equals("problem")) {
				fileInfo.get(i).setSource("主要问题和改进措施");
			} else if (source.equals("quality")) {
				fileInfo.get(i).setSource("质量监控体系建设");
			} else if (source.equals("student")) {
				fileInfo.get(i).setSource("学生思想政治状况");
			} else {
				fileInfo.get(i).setSource("未知");
			}
		}
		PageInfo fileInfoPageInfo = new PageInfo(fileInfo, 5);
		model.addAttribute("fileInfoPageInfo", fileInfoPageInfo);

		model.addAttribute("schoolNameCode", x);
		model.addAttribute("cityCode", z);
		model.addAttribute("queryCode", q);
		model.addAttribute("sn", sn);
		model.addAttribute("cn", cn);
		model.addAttribute("qn", qn);

		return "/admin/dataQuery";
	}

	/**
	 * 查找城市名称
	 * 
	 * @param request,response
	 */
	@RequestMapping("/getCityList")
	public void getCityList(HttpServletResponse response) {
		response.setContentType("application/json; charset=utf-8");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");

		List<User> user = getCityListService.getCityList();

		JSONArray jsonArray = JSONArray.fromObject(user);
		String jsonString = jsonArray.toString();

		try {

			response.getWriter().write(jsonString);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 查找学校名称
	 * 
	 * @param request,response
	 */
	@RequestMapping("/getSchoolNameList")
	public void getSchoolNameList(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json; charset=utf-8");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");

		List<SchoolInfo> schoolInfo = querySchoolInfoService.findByArea("");

		JSONArray jsonArray = JSONArray.fromObject(schoolInfo);
		String jsonString = jsonArray.toString();

		try {

			response.getWriter().write(jsonString);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
