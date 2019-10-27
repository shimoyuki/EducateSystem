<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据采集系统</title>

<link href="<%=basePath%>css/sjcj.css" rel="stylesheet" type="text/css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" type="text/css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css"
	type="text/css">
<link rel="stylesheet" href="<%=basePath%>css/bootstrapValidator.min.css"
	type="text/css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.placeholder.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/teac.js"></script>
<script type="text/javascript">
window.onload=function(){

		$("input").attr("readonly",true);		
		$("select").attr("disabled",true);		
		 
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
				<span>基本情况</span><i></i><a href="">教师队伍平均值</a>
			</div>
		</div>
		<!--表格区-->
		<div id="id_25" style="border: none;">
			<form id="formTeac" action="<%=basePath%>teac/modifyTeac?id=${teac.id }"
				method="post">
				<div class="id_26" style="float: left" >
					<table class="id_27">
						<tbody>
							<tr>
								<th scope="row">地区</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="admcode"
											value="${teac.admcode }" readonly="readonly">
									</div></td>
							</tr>
							<tr>
								<th scope="row">年份</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="year"
											value="${teac.year }" readonly="readonly">
									</div></td>
							</tr>
							<tr>
								<th scope="row">教职工总人数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="staffnum"
											value="<fmt:formatNumber type="number" value="${teac.staffnum }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">教职工编制数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="staffadmin"
											value="<fmt:formatNumber type="number" value="${teac.staffadmin }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">在编教职工数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="staffprepjob"
											value="<fmt:formatNumber type="number" value="${teac.staffprepjob }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="fulltime"
											value="<fmt:formatNumber type="number" value="${teac.fulltime }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">其中公共基础课专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="basiccourse"
											value="<fmt:formatNumber type="number" value="${teac.basiccourse }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">其中专业课专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="course"
											value="<fmt:formatNumber type="number" value="${teac.course }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">行业企业兼职教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control"
											name="industryenterprise" value="<fmt:formatNumber type="number" value="${teac.industryenterprise }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">本科以下学历专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="undergraless"
											value="<fmt:formatNumber type="number" value="${teac.undergraless }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">本科学历专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="undergra"
											value="<fmt:formatNumber type="number" value="${teac.undergra }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">具有研究生学历或学位的专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="fullpostgrad"
											value="<fmt:formatNumber type="number" value="${teac.fullpostgrad }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">高级职称专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="subhighmore"
											value="<fmt:formatNumber type="number" value="${teac.subhighmore }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">中级职称专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control"
											name="intermediategrade" value="<fmt:formatNumber type="number" value="${teac.intermediategrade }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">初级职称专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="juniortitle"
											value="<fmt:formatNumber type="number" value="${teac.juniortitle }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">未评职称专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="noconferteac"
											value="<fmt:formatNumber type="number" value="${teac.noconferteac }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="id_26" style="float: left" >
					<table class="id_27">
						<tbody>
							<tr>
								<th scope="row">35岁及以下专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="threefiveless"
											value="<fmt:formatNumber type="number" value="${teac.threefiveless }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">36～45岁专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control"
											name="threesixfourfive" value="<fmt:formatNumber type="number" value="${teac.threesixfourfive }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">46～55岁专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="foursixfivefive"
											value="<fmt:formatNumber type="number" value="${teac.foursixfivefive }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">56岁及以上专任教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="fivesixmore"
											value="<fmt:formatNumber type="number" value="${teac.fivesixmore }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">男教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="male"
											value="<fmt:formatNumber type="number" value="${teac.male }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">女教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="female"
											value="<fmt:formatNumber type="number" value="${teac.female }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">双师型教师数</th>
								<td><div class="form-group">
										<input type="text" id="lessThanSN" class="form-control"
											name="doubleteac" value="<fmt:formatNumber type="number" value="${teac.doubleteac }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">公共基础课教师平均每周课时数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="fullclasshour"
											value="<fmt:formatNumber type="number" value="${teac.fullclasshour}" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">专业课教师平均每周课时数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="courseclasshour"
											value="<fmt:formatNumber type="number" value="${teac.courseclasshour }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">行业企业兼职教师课时总量</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="induenterhour"
											value="<fmt:formatNumber type="number" value="${teac.induenterhour }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">持有心理咨询证书的教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control"
											name="counselcertificate" value="<fmt:formatNumber type="number" value="${teac.counselcertificate }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">专职心理咨询教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="fulltimecounsel"
											value="<fmt:formatNumber type="number" value="${teac.fulltimecounsel }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">市(州)级以上学科带头人教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control"
											name="citydiscipleader" value="<fmt:formatNumber type="number" value="${teac.citydiscipleader }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
							<tr>
								<th scope="row">省特级教师数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="provsuper"
											value="<fmt:formatNumber type="number" value="${teac.provsuper }" maxFractionDigits="2" groupingUsed="false"/>">
									</div></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="id_29" style="clear:both">
					<input class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=1&year=${teac.year }'" value="返回">													  							
				</div>
			</form>
		</div>
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