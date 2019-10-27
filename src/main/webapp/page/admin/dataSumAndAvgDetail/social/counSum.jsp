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
<script type="text/javascript" src="<%=basePath%>js/social.js"></script>
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
				<span>基本情况</span><i></i><a>对口支援总和</a>
			</div>
		</div>
		<!--表格区-->
		<form id="formCoun" action="<%=basePath%>coun/modifyCoun?id=${coun.id }"
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
														value="${coun.admcode}">
												</div></td>
										</tr>
										<tr>
											<th scope="row">年份</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="year"
														value="${coun.year }" readonly="readonly">
												</div></td>
										</tr>
										<tr>
											<th scope="row">对口帮扶对象单位数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="helpobject"
														value="<fmt:formatNumber type="number" value="${coun.helpobject }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">扶贫对象数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="poverreductarget"
														value="<fmt:formatNumber type="number" value="${coun.poverreductarget }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">资金扶贫（万元）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="fund"
														value="${coun.fund }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">服务人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="servicenum"
														value="<fmt:formatNumber type="number" value="${coun.servicenum }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_29" style="clear:both">
								<input id="back" class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=5&year=${coun.year }'" value="返回">	
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