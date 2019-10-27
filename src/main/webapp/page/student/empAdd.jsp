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
<script type="text/javascript" src="<%=basePath%>js/stud.js"></script>
</head>
<body>
	<%@ include file="/page/top.jsp"%>
	<%@ include file="/page/left.jsp"%>
	<!--右边内容区-->
	<div id="id_11">
		<!--添加删除修改-->
		<div class="id_12">
			<div class="id_13">
				<span>学生发展</span><i></i><a href="<%=basePath%>emp/showEmpInfo">就业质量</a>
			</div>
		</div>
		<!--表格区-->
		<form id="formEmp" action="<%=basePath%>emp/saveEmp" method="post">
			<table class="abc" cellspacing="0" border="0"
				style="border-collapse:collapse;">
				<tr>
					<td>
						<div id="id_25" style="border: none;">
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										<tr>
											<th scope="row">年份</th>
											<td><div class="form-group">
													<select class="form-control" name="year">
														<option value="${curYear }">${curYear }</option>
														<c:forEach var="i" begin="1" end="50">
															<option value="${curYear-i}"
																<c:if test="${emp.year == (curYear-i) }">selected="selected"</c:if>>${curYear-i}</option>
														</c:forEach>
													</select>
												</div></td>
										</tr>
										<tr>
											<th scope="row">毕业生初次就业率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="employratefirst">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业对口就业率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="coupartemployrate">
												</div></td>
										</tr>
										<tr>
											<th scope="row">顶岗实习半年以上稳定率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="sixmonthsteadrate">
												</div></td>
										</tr>
										<tr>
											<th scope="row">初次就业月平均收入</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="firstemploymonincome">
												</div></td>
										</tr>
										<tr>
											<th scope="row">自主创业率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="venturerate">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到国有企业事业单位服务比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="stateown">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到民营企业服务比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="privateown">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到外资企业服务比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="foreignown">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到第一产业就业比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="one">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到第二产业就业比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="two">
												</div></td>
										</tr>
										<tr>
											<th scope="row">到第三产业就业比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="three">
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
													<input type="text" class="form-control" name="soldier">
												</div></td>
										</tr>
										<tr>
											<th scope="row">高考统招升学学生数占毕业生总数比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="collegeentance">
												</div></td>
										</tr>
										<tr>
											<th scope="row">对口单招升学学生数占毕业生总数比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="couterpart">
												</div></td>
										</tr>
										<tr>
											<th scope="row">签订一年及以内就业合同比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="oneyearinner">
												</div></td>
										</tr>
										<tr>
											<th scope="row">签订一年以上就业合同比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="oneyearouter">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_29" style="clear:both">
								<c:if test="${!detailFlg}">
									<input id="submit" class="id_31" type="submit" value="提交">
								</c:if>
								<input id="reset" class="id_31" type="reset"
									onclick="location.href='showEmpInfo'" value="返回">
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