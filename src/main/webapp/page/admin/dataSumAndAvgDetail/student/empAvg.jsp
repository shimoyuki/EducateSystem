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
				<span>学生发展</span><i></i><a>就业质量平均值</a>
			</div>
		</div>
		<!--表格区-->
		<form id="formEmp" action="<%=basePath%>emp/modifyEmp?id=${emp.id }"
			method="post">
			<table class="abc" cellspacing="0" border="0"
				style="border-collapse:collapse;">
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
														value="${emp.admcode}">
												</div></td>
										</tr>
										<tr>
											<th scope="row">年份</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="year"
														value="${emp.year }" readonly="readonly">
												</div></td>
										</tr>
										<tr>
											<th scope="row">毕业生初次就业率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="employratefirst" value="${emp.employratefirst }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业对口就业率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="coupartemployrate" value="${emp.coupartemployrate }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">顶岗实习半年以上稳定率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="sixmonthsteadrate" value="${emp.sixmonthsteadrate }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">初次就业月平均收入</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="firstemploymonincome"
														value="${emp.firstemploymonincome }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">自主创业率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="venturerate"
														value="${emp.venturerate }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到国有企业事业单位服务比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="stateown"
														value="${emp.stateown }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到民营企业服务比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="privateown"
														value="${emp.privateown }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到外资企业服务比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="foreignown"
														value="${emp.foreignown }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到第一产业就业比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="one"
														value="${emp.one }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到第二产业就业比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="two"
														value="${emp.two }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到第三产业就业比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="three"
														value="${emp.three }">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										<tr>
											<th scope="row">参军人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="soldier"
														value="<fmt:formatNumber type="number" value="${emp.soldier }" maxFractionDigits="2" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">高考统招升学学生数占毕业生总数比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="collegeentance" value="${emp.collegeentance }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">对口单招升学学生数占毕业生总数比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="couterpart"
														value="${emp.couterpart }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">签订一年及以内就业合同比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="oneyearinner"
														value="${emp.oneyearinner }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">签订一年以上就业合同比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="oneyearouter"
														value="${emp.oneyearouter }">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_29" style="clear:both">
								<input id="back" class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=2&year=${emp.year }'" value="返回">
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