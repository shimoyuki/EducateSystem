<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<script type="text/javascript" src="<%=basePath%>js/admin.js"></script>
</head>
<body>
	<%@ include file="/page/top.jsp"%>
	<%@ include file="/page/aLeft.jsp"%>
	<!--右边内容区-->
	<div majorcode="id_11">
		<!--添加删除修改-->
		<div class="id_12">
			<div class="id_13">
			</div>
		</div>
		<!--表格区-->
		<form id="formMajor" action="<%=basePath%>major/saveMajor"
			method="post">
			<table class="abc" cellspacing="0" border="0"
				style="border-collapse:collapse;">
				<tr>
					<td>
						<div majorcode="id_25" style="border: none;">
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										<tr>
											<th scope="row">专业类名</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="induname">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业代码</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="majorcode">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业名</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="name">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业（技能）方向</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="skill">
												</div></td>
										</tr>
										<tr>
											<th scope="row">对应职业（工种）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="occupation">
												</div></td>
										</tr>
										<tr>
											<th scope="row">基础学制</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="duration">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_29" style="clear:both">
								<c:if test="${!detailFlg}">
									<input id="submit" class="id_31" type="submit"
										value="提交">
								</c:if>
								<input id="reset" class="id_31" type="reset"
									onclick="location.href='showMajorInfo'"
									value="返回">
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