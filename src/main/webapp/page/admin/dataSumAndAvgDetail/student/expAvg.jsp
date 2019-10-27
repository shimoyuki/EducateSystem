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
				<span>学生发展</span><i></i><a>在校体验平均值</a>
			</div>
		</div>
		<!--表格区-->
		<form id="formExp" action="<%=basePath%>exp/modifyExp?id=${exp.id }"
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
														value="${exp.admcode}">
												</div></td>
										</tr>
										<tr>
											<th scope="row">年份</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="year"
														value="${exp.year }" readonly="readonly">
												</div></td>
										</tr>
										<tr>
											<th scope="row">理论学习满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="theorybest"
														value="${exp.theorybest }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">理论学习满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="theorygood"
														value="${exp.theorygood }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">理论学习满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="theorybad"
														value="${exp.theorybad }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业学习满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="majorbest"
														value="${exp.majorbest }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业学习满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="majorgood"
														value="${exp.majorgood }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业学习满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="majorbad"
														value="${exp.majorbad }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">实习实训满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="internshipbest" value="${exp.internshipbest }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">实习实训满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="internshipgood" value="${exp.internshipgood }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">实习实训满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="internshipbad" value="${exp.internshipbad }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园文化与社团活动满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="campusbest"
														value="${exp.campusbest }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园文化与社团活动满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="campusgood"
														value="${exp.campusgood }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园文化与社团活动满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="campusbad"
														value="${exp.campusbad }">
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
													<input type="text" class="form-control" name="lifebest"
														value="${exp.lifebest }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">生活满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="lifegood"
														value="${exp.lifegood }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">生活满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="lifebad"
														value="${exp.lifebad }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园安全满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="safetybest"
														value="${exp.safetybest }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园安全满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="safetygood"
														value="${exp.safetygood }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">校园安全满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="safetybad"
														value="${exp.safetybad }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">毕业生对学校满意度-非常满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="graduatebest"
														value="${exp.graduatebest }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">毕业生对学校满意度-基本满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="graduategood"
														value="${exp.graduategood }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">毕业生对学校满意度-不满意</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="graduatebad"
														value="${exp.graduatebad }">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_29" style="clear:both">
								<input id="back" class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=2&year=${exp.year }'" value="返回">	
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