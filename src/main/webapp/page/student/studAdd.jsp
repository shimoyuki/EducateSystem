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
				<span>学生发展</span><i></i><a href="<%=basePath%>stud/showStudInfo">学生素质</a>
			</div>
		</div>
		<!--表格区-->
		<form id="formStud" action="<%=basePath%>stud/saveStud" method="post">
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
															<option value="${curYear-i}">${curYear-i}</option>
														</c:forEach>
													</select>
												</div></td>
										</tr>
										<tr>
											<th scope="row">德育教材配备是否使用国家规化教材</th>
											<td><div class="form-group">
													<input type="radio" name="moralequit" value="1">是 <input
														type="radio" name="moralequit" value="0" checked="checked">否
												</div></td>
										</tr>
										<tr>
											<th scope="row">是否设立了心理辅导中心或心理咨询室</th>
											<td><div class="form-group">
													<input type="radio" name="phycenter" value="1">是 <input
														type="radio" name="phycenter" value="0" checked="checked" checked="checked">否
												</div></td>
										</tr>
										<tr>
											<th scope="row">德育先进单位</th>
											<td>
												<div class="form-group">
													<input type="radio" name="advanced" value="0">国家级
													<input type="radio" name="advanced" value="1">省级
													<input type="radio" name="advanced" value="2">市级
													<input type="radio" name="advanced" value="3" checked="checked">无
												</div>
											</td>
										</tr>
										<tr>
											<th scope="row">教育部德育实验基地</th>
											<td><div class="form-group">
													<input type="radio" name="moralbase" value="1">是
													<input type="radio" name="moralbase" value="0" checked="checked">否
												</div></td>
										</tr>
										<tr>
											<th scope="row">四川省校风示范校</th>
											<td><div class="form-group">
													<input type="radio" name="schoolspirit" value="1">是
													<input type="radio" name="schoolspirit" value="0" checked="checked">否
												</div></td>
										</tr>
										<tr>
											<th scope="row">四川省中等职业学校内务管理示范校</th>
											<td><div class="form-group">
													<input type="radio" name="managespirit" value="1">是
													<input type="radio" name="managespirit" value="0" checked="checked">否
												</div></td>
										</tr>
										<tr>
											<th scope="row">青年志愿者先进集体</th>
											<td><div class="form-group">
													<input type="radio" name="volunteer" value="1">是
													<input type="radio" name="volunteer" value="0" checked="checked">否
												</div></td>
										</tr>
										<tr>
											<th scope="row">红旗团委</th>
											<td><div class="form-group">
													<input type="radio" name="redflag" value="1">是
													<input type="radio" name="redflag" value="0" checked="checked">否
												</div></td>
										</tr>
										<tr>
											<th scope="row">其他德育相关荣誉(市级及以上)</th>
											<td><div class="form-group">
													<textarea rows="3"  class="form-control" name="otherhonor"></textarea>
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										<tr>
											<th scope="row">省级以上优秀班级数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="goodclass">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专职德育工作人员数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="fulltimemoral">
												</div></td>
										</tr>
										<tr>
											<th scope="row">各级德育课题立项数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="moraltask">
												</div></td>
										</tr>
										<tr>
											<th scope="row">德育课教师数量</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="moralnum">
												</div></td>
										</tr>
										<tr>
											<th scope="row">德育课教师专业对口率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="moralpart">
												</div></td>
										</tr>
										<tr>
											<th scope="row">德育校本教材开发数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="moraltext">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div id="id_25" style="border: none;">
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										<tr>
											<th scope="row">学生操行考核优的比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="assessoptimal">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生操行考核良的比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="assessgood">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生操行考核中的比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="assessmiddle">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生操行考核差的比例</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="assesspoor">
												</div></td>
										</tr>
										<tr>
											<th scope="row">接受心理咨询的学生占比</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="pyhconselper">
												</div></td>
										</tr>
										<tr>
											<th scope="row">省级优秀毕业生数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="provgoodgrade">
												</div></td>
										</tr>
										<tr>
											<th scope="row">省级优秀干部数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="provgoodcadre">
												</div></td>
										</tr>
										<tr>
											<th scope="row">省级优秀三好学生数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="provgoodstud">
												</div></td>
										</tr>
										<tr>
											<th scope="row">其他（省级以上）</th>
											<td><div class="form-group">
													<textarea rows="3"  class="form-control" name="provother"></textarea>
												</div></td>
										</tr>
										<tr>
											<th scope="row">年度校园暴力事件次数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="campusviolence">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生犯罪人次</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="crimerate">
												</div></td>
										</tr>
										<tr>
											<th scope="row">严重违纪学生数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="examdiscip">
												</div></td>
										</tr>
										<tr>
											<th scope="row">积极申请入团学生数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="joinorgan">
												</div></td>
										</tr>
										<tr>
											<th scope="row">积极申请入党学生数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="joinpraty">
												</div></td>
										</tr>
										<tr>
											<th scope="row">社会志愿服务活动人次</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="socailvolun">
												</div></td>
										</tr>
										<tr>
											<th scope="row">社会实践活动参与次数（生/年）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="socailprac">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生社团数量</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="studentorgan">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生参与社团人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="organstu">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										<tr>
											<th scope="row">学生参加文明风采大赛获奖人数（国家级）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="statecivil">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生参加文明风采大赛获奖人数（省级）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="provincivil">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学生参加文明风采大赛获奖人数（市级）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="citycivil">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与国家级技能竞赛获得一等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="statefirstaward">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与国家级技能竞赛获得二等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="statesecondaward">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与国家级技能竞赛获得三等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="statethirdaward">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与省级技能竞赛获得一等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="provinfirstaward">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与省级技能竞赛获得二等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="provinsecondaward">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与省级技能竞赛获得三等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="provinthirdaward">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与市级技能竞赛获得一等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="cityfirstaward">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与市级技能竞赛获得二等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="citysecondaward">
												</div></td>
										</tr>
										<tr>
											<th scope="row">参与市级技能竞赛获得三等奖人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="citythirdaward">
												</div></td>
										</tr>
										<tr>
											<th scope="row">一年级巩固率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="oneconsol">
												</div></td>
										</tr>
										<tr>
											<th scope="row">二年级巩固率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="twoconsol">
												</div></td>
										</tr>
										<tr>
											<th scope="row">三年级巩固率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="threeconsol">
												</div></td>
										</tr>
										<tr>
											<th scope="row">文化课合格率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="cultdivipassrate">
												</div></td>
										</tr>
										<tr>
											<th scope="row">体质测评合格率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="phyassesspassrate">
												</div></td>
										</tr>
										<tr>
											<th scope="row">专业技能合格率</th>
											<td><div class="form-group">
													<input type="text" class="form-control"
														name="profskillpassrate">
												</div></td>
										</tr>
										<tr>
											<th scope="row">职业资格证书数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="careercert">
												</div></td>
										</tr>
										<tr>
											<th scope="row">双证书获取率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="doubcert">
												</div></td>
										</tr>
										<tr>
											<th scope="row">毕业率</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="gradrate">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_29" style="clear:both">
								<input id="submit" class="id_31" type="submit" value="提交">
								<input id="reset" class="id_31" type="reset"
									onclick="location.href='showStudInfo'" value="返回">
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