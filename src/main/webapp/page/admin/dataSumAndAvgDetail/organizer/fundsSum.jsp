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
<script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/funds.js"></script>
<script language="javascript" type="text/javascript">
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
				<span>举办者履职</span><i></i><a href="">经费总和</a>
			</div>
			<div class="id_14"></div>
		</div>
		<!--表格区-->
		<div id="id_25" style="border: none;">
			<form action="" id="fundsForm" method="post">
				<div class="id_26" style="float: left">
					<table class="id_27">
						<tbody>
							<tr>
								<th scope="row">地区</th>
								<td><div class="form-group">
										<input type="text" id="admcode" name="admcode" class="form-control"
											readonly="readonly" value="${funds.admcode}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">年份</th>
								<td><div class="form-group">
										<input type="text" id="year" name="year" class="form-control"
											readonly="readonly" value="${funds.year}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">中央财政投入经费（万元）</th>
								<td><div class="form-group">
										<input type="text" class="form-control" id="centerFund"
											name="centerFund" value="${funds.centerFund}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">地方财政投入经费（万元）</th>
								<td><div class="form-group">
										<input type="text" class="form-control" id="localFund"
											name="localFund" value="${funds.localFund}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">学校负债总额（万元）</th>
								<td><div class="form-group">
										<div class="form-group">
											<input type="text" class="form-control" id="debt" name="debt"
												value="${funds.debt}">
										</div></td>
							</tr>
							<tr>
								<th scope="row">贷款总额（万元）</th>
								<td><div class="form-group">
										<input type="text" class="form-control" id="loan" name="loan"
											value="${funds.loan}">
									</div></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="id_26" style="float: left">
					<table class="id_27">
						<tbody>
							<tr>
								<th scope="row">生均拨款（元）</th>
								<td><div class="form-group">
										<input type="text" class="form-control" id="appropriation"
											name="appropriation" value="${funds.appropriation}">
									</div></td>
							</tr>
							<%-- <tr>
								<th scope="row">当年教师培训经费（万元）</th>
								<td><div class="form-group">
										<input type="text" class="form-control" id="teacherTrain"
											name="teacherTrain" value="${funds.teacherTrain}">
									</div></td>
							</tr> --%>
							<tr>
								<th scope="row">教学改革经费（万元）</th>
								<td><div class="form-group">
										<input type="text" class="form-control" id="teachChange"
											name="teachChange" value="${funds.teachChange}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">教科研经费（万元）</th>
								<td><div class="form-group">
										<input type="text" class="form-control" id="fundBudget"
											name="fundBudget" value="${funds.fundBudget}">
									</div></td>
							</tr>
						</tbody>
					</table>
					</div>
					
					
					<div class="id_29" style="clear:both">
    					<input class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=6&year=${funds.year }'" value="返回">													  							
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