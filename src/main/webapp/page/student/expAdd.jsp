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
				<span>学生发展</span><i></i><a href="<%=basePath%>exp/showExpInfo">在校体验</a>
			</div>
		</div>
		<!--表格区-->
		<form id="formExp" action="<%=basePath%>exp/saveExp" method="post">
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
																<c:if test="${exp.year == (curYear-i) }">selected="selected"</c:if>>${curYear-i}</option>
														</c:forEach>
													</select>
												</div></td>
										</tr>
										<tr>
											<th scope="row">理论学习满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="theorybest">
												</div></td>
										</tr>
										<tr>
											<th scope="row">理论学习满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="theorygood">
												</div></td>
										</tr>
										<tr>
											<th scope="row">理论学习满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="theorybad">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业学习满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="majorbest">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业学习满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="majorgood">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业学习满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="majorbad">
												</div></td>
										</tr>
										<tr>
											<th scope="row">实习实训满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="internshipbest">
												</div></td>
										</tr>
										<tr>
											<th scope="row">实习实训满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="internshipgood">
												</div></td>
										</tr>
										<tr>
											<th scope="row">实习实训满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="internshipbad">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园文化与社团活动满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="campusbest">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园文化与社团活动满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="campusgood">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园文化与社团活动满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="campusbad">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										<tr>
											<th scope="row">生活满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="lifebest">
												</div></td>
										</tr>
										<tr>
											<th scope="row">生活满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="lifegood">
												</div></td>
										</tr>
										<tr>
											<th scope="row">生活满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="lifebad">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园安全满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="safetybest">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园安全满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="safetygood">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园安全满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="safetybad">
												</div></td>
										</tr>
										<tr>
											<th scope="row">毕业生对学校满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="graduatebest">
												</div></td>
										</tr>
										<tr>
											<th scope="row">毕业生对学校满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="graduategood">
												</div></td>
										</tr>
										<tr>
											<th scope="row">毕业生对学校满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="graduatebad">
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
									onclick="location.href='showExpInfo'" value="返回">
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