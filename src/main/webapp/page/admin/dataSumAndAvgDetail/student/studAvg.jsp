<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据采集系统</title>

<link href="<%=basePath%>css/sjcj.css" rel="stylesheet" type="text/css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css"
	type="text/css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=basePath%>css/bootstrapValidator.min.css" type="text/css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.placeholder.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/stud.js"></script>
<script type="text/javascript">
window.onload=function(){		
		$("select").attr("disabled",true);		
		$("input").attr("disabled",true);	
		$("textarea").attr("disabled",true);	
		$("#back").attr("disabled",false);
}
</script>
</head>
<body>
	<%@ include file="/page/top.jsp"%>
	<c:choose>
	<c:when test="${level eq '4'}">
	<!--左边导航栏-->
	<%@ include file="/page/aLeft.jsp" %> 
	</c:when>							
	<c:otherwise>
	<!--左边导航栏-->
	<%@ include file="/page/left.jsp" %>							
	</c:otherwise>
	</c:choose>
	<!--右边内容区-->
	<div id="id_11">
		<!--添加删除修改-->
		<div class="id_12">
			<div class="id_13">
				<span>学生发展</span><i></i><a>学生素质平均值</a>
			</div>
		</div>
		<!--表格区-->
		<form id="formStud"
			action="<%=basePath%>stud/modifyStud?id=${stud.id }" method="post">
			<table class="abc" cellspacing="0" border="0"
				style="border-collapse: collapse;">
				<tr>
					<td>
						<div id="id_25" style="border: none;">
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										<tr>
											<th scope="row">地区</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="admcode"
														value="${stud.admcode}">
												</div></td>
										</tr>
										<tr>
											<th scope="row">年份</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="year"
														value="${stud.year }" readonly="readonly">
												</div></td>
										</tr>
										<tr>
											<th scope="row">省级以上优秀班级数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="goodclass"
														value="<fmt:formatNumber type="number" value="${stud.goodclass }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专职德育工作人员数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="fulltimemoral" value="<fmt:formatNumber type="number" value="${stud.fulltimemoral }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										
										<tr>
											<th scope="row">各级德育课题立项数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="moraltask"
														value="<fmt:formatNumber type="number" value="${stud.moraltask }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">德育课教师数量</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="moralnum"
														value="<fmt:formatNumber type="number" value="${stud.moralnum }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">德育课教师专业对口率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="moralpart"
														value="${stud.moralpart }">
												</div></td>
										</tr>
										<%-- <tr>
											<th scope="row">班级每周德育课课时数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="moralhour"
														value="<fmt:formatNumber type="number" value="${stud.moralhour }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr> --%>
										<tr>
											<th scope="row">德育校本教材开发数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="moraltext"
														value="<fmt:formatNumber type="number" value="${stud.moraltext }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div id="id_25" style="border: none;">
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										<tr>
											<th scope="row">学生操行考核优的比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="assessoptimal" value="${stud.assessoptimal }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生操行考核良的比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="assessgood"
														value="${stud.assessgood }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生操行考核中的比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="assessmiddle"
														value="${stud.assessmiddle }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生操行考核差的比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="assesspoor"
														value="${stud.assesspoor }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">接受心理咨询的学生占比</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="pyhconselper"
														value="${stud.pyhconselper }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">省级优秀毕业生数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="provgoodgrade" value="<fmt:formatNumber type="number" value="${stud.provgoodgrade }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">省级优秀干部数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="provgoodcadre" value="<fmt:formatNumber type="number" value="${stud.provgoodcadre }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">省级优秀三好学生数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="provgoodstud"
														value="<fmt:formatNumber type="number" value="${stud.provgoodstud }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">其他（省级以上）</th>
											<td><div class="form-group">
													<textarea rows="3" class="form-control" name="provother">${stud.provother }</textarea>
												</div></td>
										</tr>
										<tr>
											<th scope="row">年度校园暴力事件次数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="campusviolence" value="<fmt:formatNumber type="number" value="${stud.campusviolence }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生犯罪人次</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="crimerate"
														value="<fmt:formatNumber type="number" value="${stud.crimerate }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">严重违纪学生数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="examdiscip"
														value="<fmt:formatNumber type="number" value="${stud.examdiscip }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">积极申请入团学生数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="joinorgan"
														value="<fmt:formatNumber type="number" value="${stud.joinorgan }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">积极申请入党学生数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="joinpraty"
														value="<fmt:formatNumber type="number" value="${stud.joinpraty }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">社会志愿服务活动人次</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="socailvolun"
														value="<fmt:formatNumber type="number" value="${stud.socailvolun }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">社会实践活动参与次数（生/年）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="socailprac"
														value="${stud.socailprac }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生社团数量</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="studentorgan"
														value="<fmt:formatNumber type="number" value="${stud.studentorgan }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生参与社团人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="organstu"
														value="<fmt:formatNumber type="number" value="${stud.organstu }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										<tr>
											<th scope="row">学生参加文明风采大赛获奖人数（国家级）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="statecivil"
														value="<fmt:formatNumber type="number" value="${stud.statecivil }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生参加文明风采大赛获奖人数（省级）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="provincivil"
														value="<fmt:formatNumber type="number" value="${stud.provincivil }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生参加文明风采大赛获奖人数（市级）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="citycivil"
														value="<fmt:formatNumber type="number" value="${stud.citycivil }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与国家级技能竞赛获得一等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="statefirstaward" value="<fmt:formatNumber type="number" value="${stud.statefirstaward }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与国家级技能竞赛获得二等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="statesecondaward" value="<fmt:formatNumber type="number" value="${stud.statesecondaward }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与国家级技能竞赛获得三等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="statethirdaward" value="<fmt:formatNumber type="number" value="${stud.statethirdaward }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与省级技能竞赛获得一等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="provinfirstaward" value="<fmt:formatNumber type="number" value="${stud.provinfirstaward }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与省级技能竞赛获得二等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="provinsecondaward"
														value="<fmt:formatNumber type="number" value="${stud.provinsecondaward }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与省级技能竞赛获得三等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="provinthirdaward" value="<fmt:formatNumber type="number" value="${stud.provinthirdaward }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与市级技能竞赛获得一等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="cityfirstaward" value="<fmt:formatNumber type="number" value="${stud.cityfirstaward }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与市级技能竞赛获得二等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="citysecondaward" value="<fmt:formatNumber type="number" value="${stud.citysecondaward }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与市级技能竞赛获得三等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="citythirdaward" value="<fmt:formatNumber type="number" value="${stud.citythirdaward }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">一年级巩固率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="oneconsol"
														value="${stud.oneconsol }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">二年级巩固率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="twoconsol"
														value="${stud.twoconsol }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">三年级巩固率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="threeconsol"
														value="${stud.threeconsol }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">文化课合格率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="cultdivipassrate" value="${stud.cultdivipassrate }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">体质测评合格率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="phyassesspassrate"
														value="${stud.phyassesspassrate }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业技能合格率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="profskillpassrate"
														value="${stud.profskillpassrate }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">职业资格证书数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="careercert"
														value="<fmt:formatNumber type="number" value="${stud.careercert }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">双证书获取率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="doubcert"
														value="${stud.doubcert }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">毕业率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="gradrate"
														value="${stud.gradrate }">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_29" style="clear: both">
								<input id="back" class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=2&year=${stud.year }'" value="返回">
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script>
		total = document.documentElement.clientHeight;
		colHeight = total - document.getElementById("id_05").offsetTop;
		document.getElementById("id_05").style.height = colHeight + "px";
		document.getElementById("id_11").style.height = colHeight + "px";
		document.getElementById("id_content").style.height = colHeight + "px";
	</script>
</body>
</html>