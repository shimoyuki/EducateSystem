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
				<span>基本情况</span><i></i><a>技术技能人才培养总和</a>
			</div>
		</div>
		<!--表格区-->
		<form id="formSkiTra" action="<%=basePath%>skiTra/modifySkiTra?id=${skiTra.id }"
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
														value="${skiTra.admcode}">
												</div></td>
										</tr>
									<tr>
											<th scope="row">年份</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="year"
														value="${skiTra.year }" readonly="readonly">
												</div></td>
										</tr>
										<tr>
											<th scope="row">为当地主要产业培养技术技能人才数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="localfoster"
														value="<fmt:formatNumber type="number" value="${skiTra.localfoster }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">为当地培训技术技能人才数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="localtrain"
														value="<fmt:formatNumber type="number" value="${skiTra.localtrain }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">产生的经济效益和社会效益（万元）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="ecnomicsocial"
														value="${skiTra.ecnomicsocial }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学校师生参与当地产业发展或结构调整技术攻关人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="trackproblemnum"
														value="<fmt:formatNumber type="number" value="${skiTra.trackproblemnum }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_29" style="clear:both">
								<input id="back" class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=5&year=${skiTra.year }'" value="返回">
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