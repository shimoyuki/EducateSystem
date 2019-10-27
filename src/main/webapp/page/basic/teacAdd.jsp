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
</head>
<body>
	<%@ include file="/page/top.jsp"%>
	<%@ include file="/page/left.jsp"%>
	<!--右边内容区-->
	<div id="id_11">
		<!--添加删除修改-->
		<div class="id_12">
			<div class="id_13">
				<span>基本情况</span><i></i><a href="<%=basePath%>teac/showTeacInfo">教师队伍</a>
			</div>
		</div>
	<!--表格区-->
	<div id="id_25" style="border: none;">
		<form  id="formTeac" action="<%=basePath%>teac/saveTeac" method="post">
			<div class="id_26" style="float: left" >
				<table class="id_27">
					<tbody>
						<tr>
							<th scope="row">年份</th>
							<td><div class="form-group"><select class="form-control" name="year">
									<option value="${curYear }">${curYear }</option>
									<c:forEach var="i" begin="1" end="50">
										<option value="${curYear-i}">${curYear-i}</option>
									</c:forEach>
							</select> <!-- <input type="text" class="form-control" name="year"> --></div></td>
						</tr>
						<tr>
							<th scope="row">教职工总人数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="staffnum"></div></td>
						</tr>
						<tr>
							<th scope="row">教职工编制数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="staffadmin"></div></td>
						</tr>
						<tr>
							<th scope="row">在编教职工数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="staffprepjob"></div></td>
						</tr>
						<tr>
							<th scope="row">专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="fulltime"></div></td>
						</tr>
						<tr>
							<th scope="row">其中公共基础课专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="basiccourse"></div></td>
						</tr>
						<tr>
							<th scope="row">其中专业课专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="course"></div></td>
						</tr>
						<tr>
							<th scope="row">行业企业兼职教师数</th>
							<td><div class="form-group"><input type="text" class="form-control"
								name="industryenterprise"></div></td>
						</tr>
						<tr>
							<th scope="row">本科以下学历专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="undergraless"></div></td>
						</tr>
						<tr>
							<th scope="row">本科学历专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="undergra"></div></td>
						</tr>
						<tr>
							<th scope="row">具有研究生学历或学位的专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="fullpostgrad"></div></td>
						</tr>
						<tr>
							<th scope="row">高级职称专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="subhighmore"></div></td>
						</tr>
						<tr>
							<th scope="row">中级职称专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control"
								name="intermediategrade"></div></td>
						</tr>
						<tr>
							<th scope="row">初级职称专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="juniortitle"></div></td>
						</tr>
						<tr>
							<th scope="row">未评职称专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="noconferteac"></div></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="id_26" style="float: left" >
				<table class="id_27">
					<tbody>
						<tr>
							<th scope="row">35 岁及以下专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="threefiveless"></div></td>
						</tr>
						<tr>
							<th scope="row">36～45岁专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="threesixfourfive"></div></td>
						</tr>
						<tr>
							<th scope="row">46～55岁专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="foursixfivefive"></div></td>
						</tr>
						<tr>
							<th scope="row">56 岁及以上专任教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="fivesixmore"></div></td>
						</tr>
						<tr>
							<th scope="row">男教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="male"></div></td>
						</tr>
						<tr>
							<th scope="row">女教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="female"></div></td>
						</tr>
						<tr>
							<th scope="row">双师型教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="doubleteac"></div></td>
						</tr>
						<tr>
							<th scope="row">公共基础课教师平均每周课时数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="fullclasshour"></div></td>
						</tr>
						<tr>
							<th scope="row">专业课教师平均每周课时数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="courseclasshour"></div></td>
						</tr>
						<tr>
							<th scope="row">行业企业兼职教师课时总量</th>
							<td><div class="form-group"><input type="text" class="form-control" name="induenterhour"></div></td>
						</tr>
						<tr>
							<th scope="row">持有心理咨询证书的教师数</th>
							<td><div class="form-group"><input type="text" class="form-control"
								name="counselcertificate"></div></td>
						</tr>
						<tr>
							<th scope="row">专职心理咨询教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="fulltimecounsel"></div></td>
						</tr>
						<tr>
							<th scope="row">市(州)级以上学科带头人教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="citydiscipleader"></div></td>
						</tr>
						<tr>
							<th scope="row">省特级教师数</th>
							<td><div class="form-group"><input type="text" class="form-control" name="provsuper"></div></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="id_29" style="clear:both">
					<input id="submit" class="id_31" type="submit" value="提交">
					<input id="reset" class="id_31" type="reset"
						onclick="location.href='showTeacInfo'" value="返回">
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