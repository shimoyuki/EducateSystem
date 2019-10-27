<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>css/sjcj.css" rel="stylesheet" type="text/css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css"
	type="text/css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=basePath%>css/bootstrapValidator.min.css" type="text/css">
<script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/majorLayout.js"></script>
</head>
<body>
	<%@ include file="/page/top.jsp"%>
	<c:choose>
		<c:when test="${level eq '4'}">
			<!--左边导航栏-->
			<%@ include file="/page/aLeft.jsp"%>
		</c:when>
		<c:otherwise>
			<!--左边导航栏-->
			<%@ include file="/page/left.jsp"%>
		</c:otherwise>
	</c:choose>
	<!--右边内容区-->
	<div id="id_11">
		<!--添加删除修改-->
		<div class="id_12">
			<div class="id_13">
				<span>质量保障措施</span><i></i><a
					href="">专业布局总和</a>
			</div>
			<div class="id_14"></div>
		</div>
		<!--表格区-->
		<div id="id_25" style="border: none;">
			<form action="" id="majorLayoutForm">
				<div class="id_26" style="float: left">
					<table class="id_27">
						<tbody>
							<tr>
								<th scope="row">地区</th>
								<td><div class="form-group">
										<input type="text" id="year" name="admcode" class="form-control"
											readonly="readonly" value="${majorLayout.admcode}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">年份</th>
								<td><div class="form-group">
										<input type="text" id="year" name="year" class="form-control"
											readonly="readonly" value="${majorLayout.year}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">一产类专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="oneIndu"
											readonly="readonly" id="oneIndu" value="${majorLayout.oneIndu}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">二产类专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="twoIndu"
											readonly="readonly" id="twoIndu" value="${majorLayout.twoIndu}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">三产类专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="threeIndu"
											readonly="readonly" id="threeIndu" value="${majorLayout.threeIndu}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">围绕地方支柱产业的专业开设数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="localPillar"
											readonly="readonly" id="localPillar" value="${majorLayout.localPillar}">
									</div></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="id_26" style="float: left">
					<table class="id_27">
						<tbody>
							<%-- <tr>
								<th scope="row">省级重点专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="provinceMore"
											readonly="readonly" id="provinceMore" value="${majorLayout.provinceMore}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">国示校重点建设专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="staUniKeyMajor"
											readonly="readonly" id="staUniKeyMajor" value="${majorLayout.staUniKeyMajor}">
									</div></td>
							</tr> --%>
							<tr>
								<th scope="row">新增专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="newMajor"
											readonly="readonly" id="newMajor" value="${majorLayout.newMajor}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">停办专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="stopMajor"
											readonly="readonly" id="stopMajor" value="${majorLayout.stopMajor}">
									</div></td>
							</tr>
						</tbody>
					</table>
					</div>
					
					
					<div class="id_29" style="clear:both">  					
						<input class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=3&year=${majorLayout.year }'" value="返回"> 										  							
					</div>
				
			</form>

		</div>

	</div>

	<script>
total = document.documentElement.clientHeight;
colHeight = total-document.getElementById("id_05").offsetTop;
document.getElementById("id_05").style.height=colHeight+"px";
document.getElementById("id_11").style.height=colHeight+"px";
document.getElementById("id_content").style.height=colHeight+"px";
</script>
</body>
</html>