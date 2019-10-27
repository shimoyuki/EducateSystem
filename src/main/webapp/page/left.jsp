<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('input, textarea').placeholder();
	});
	$(function() {
		$(".id_10");
		$(".id_08").click(function() {
			$(this).toggleClass("open").next().slideToggle("fast");
		});
	});
</script>
<!--左边导航栏-->
<div id="id_content">
	<div id="id_05">
		<div class="id_06">
			<div class="id_07"></div>
			<p>
				<%=session.getAttribute("schoolname")%>
			</p>
		</div>
		<a href="#" class="id_08"><div class="icon_01"></div>
			<span>基本情况</span></a>
		<div class="id_10">
			<a href="<%=session.getAttribute("base")%>/size/getSizeList">规模</a>
			<a
				href="<%=session.getAttribute("base")%>/Equitment/getEquitmentList">设施设备</a>
			<a href="<%=session.getAttribute("base")%>/teac/showTeacInfo">教师队伍</a>
			<a href="<%=session.getAttribute("base")%>/info/getInformation">信息化建设</a>
		</div>
		<a href="#" class="id_08"><div class="icon_02"></div>
			<span>学生发展</span></a>
		<div class="id_10">
			<a href="<%=session.getAttribute("base")%>/stud/showStudInfo">学生素质</a>
			<a href="<%=session.getAttribute("base")%>/exp/showExpInfo">在校体验</a>
			<a href="<%=session.getAttribute("base")%>/emp/showEmpInfo">就业质量</a>
		</div>
		<a href="#" class="id_08"><div class="icon_03"></div>
			<span>质量保障措施</span></a>
		<div class="id_10">
			<a
				href="<%=session.getAttribute("base")%>/majorLayout/getMajorLayoutList">专业布局</a>
			<a href="<%=session.getAttribute("base")%>/majorNum/getMajorNumList">课程开设</a>
			<a
				href="<%=session.getAttribute("base")%>/qualityAssurance/getQualityAssuranceList">质量保证</a>
			<a
				href="<%=session.getAttribute("base")%>/educationTrain/getEducationTrainList">教师培养培训</a>
		</div>
		<a href="#" class="id_08"><div class="icon_04"></div>
			<span>校企合作</span></a>
		<div class="id_10">
			<a
				href="<%=session.getAttribute("base")%>/schoolenterprise/getSchoolenterpriseList">合作情况</a>
			<a
				href="<%=session.getAttribute("base")%>/internship/getInternshipList">学生实习情况</a>
			<a href="<%=session.getAttribute("base")%>/group/getGroupSchoolList">集团化办学情况</a>
		</div>
		<a href="#" class="id_08"><div class="icon_05"></div>
			<span>社会贡献</span></a>
		<div class="id_10">
			<a href="<%=session.getAttribute("base")%>/skiTra/showSkiTraInfo">技术技能人才培养</a>
			<a href="<%=session.getAttribute("base")%>/social/showSocialInfo">社会服务</a>
			<a href="<%=session.getAttribute("base")%>/coun/showCounInfo">对口支援</a>
		</div>
		<a href="#" class="id_08"><div class="icon_04"></div>
			<span>举办者履职</span></a>
		<div class="id_10">
			<a href="<%=session.getAttribute("base")%>/funds/getFundsList">经费</a>
			<a href="<%=session.getAttribute("base")%>/policy/getPolicyList">政策措施</a>
		</div>
		<a href="#" class="id_08"><div class="icon_06"></div>
			<span>党建工作</span></a>
		<div class="id_10">
			<a
				href="<%=session.getAttribute("base")%>/partybulid/getPartyBulidList">学校党建工作</a>
		</div>
		<a href="#" class="id_08"><div class="icon_07"></div>
			<span>资料上传</span></a>
		<div class="id_10_f">
			<a
				href="<%=session.getAttribute("base")%>/file/getFileList?source=moralwork">德育工作经验措施</a>
			<a
				href="<%=session.getAttribute("base")%>/file/getFileList?source=student">学生思想政治状况</a>
			<a
				href="<%=session.getAttribute("base")%>/file/getFileList?source=outstanding">优秀毕业生典型案例</a>
			<a
				href="<%=session.getAttribute("base")%>/file/getFileList?source=quality">质量监控体系建设</a>
			<a
				href="<%=session.getAttribute("base")%>/file/getFileList?source=grouprun">学校集团化办学</a>
			<a
				href="<%=session.getAttribute("base")%>/file/getFileList?source=culture">传统文化地方特色教育活动开展情况</a>
			<a
				href="<%=session.getAttribute("base")%>/file/getFileList?source=help">对口帮扶(扶贫)情况</a>
			<a
				href="<%=session.getAttribute("base")%>/file/getFileList?source=innovation">特色创新</a>
			<a
				href="<%=session.getAttribute("base") %>/file/getFileList?source=partybuild">党建工作</a>
			<a
				href="<%=session.getAttribute("base") %>/file/getFileList?source=problem">主要问题和改进措施</a>
		</div>
	</div>
