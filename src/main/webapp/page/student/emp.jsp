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
<!-- 最新版本的 Bootstrap 核心 CSS 文件 --> 
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<!-- 可选的 Bootstrap 主题文件（一般不用引入） --> 
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous"> 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 --> 
<link href="<%=basePath%>/css/sjcj.css" rel="stylesheet" type="text/css">  
<script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>/js/jquery.placeholder.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript">
	function query() {
		var inputYear = document.getElementById("year");
		if(inputYear != null){
		year = inputYear.value;
		if (year == null || year == ""
				|| (year != "" && !/^[1-9][0-9]{3,}$/.test(year))) {
			alert("请输入正确的年份！");
			return false;
		}
		}
		$("#formTitle").attr("action", "<%=basePath%>emp/showEmpInfo");
		$("#formTitle").submit();
		return true;
	}
	
	function del(id){  //使用ajax完成删除操作
	$.ajax({
				data : {
				id: id
				},
				type : "get",
				dataType : 'json',
				url : "<%=basePath%>emp/deleteEmp",
				error : function(data) {
					alert("删除出错");
				},
				success : function(data) {
					if (data.result == "success") {
						window.location.reload();
					} else {
						alert("删除出错");
					}
				}
			});
}
	
	$(function() {//使用ajax完成审核通过操作
		$(".audit").click(function() {
		$addr = $(this);
			$.ajax({
				data : {
				id:  $addr.attr("name")
				},
				type : "get",
				dataType : 'json',
				url : "<%=basePath%>emp/audit",
				error : function(data) {
					alert("修改出错");
				},
				success : function(data) {
					if (data.result == "success") {
						window.location.reload();
					} else {
						alert("修改出错");
					}
				}
			});
		});
	});
</script>
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
			<form id="formTitle" action="<%=basePath%>emp/download" method="get">
				<div class="id_14">
					<c:if test="${level < 3}">
						<div class="id_18">
							<input type="text" id="year" class="id_19" name="year"
								value="${year }" placeholder="请输入年份查询"> <input
								class="id_20" onclick="query()">
						</div>
					</c:if>
					<c:if test="${level eq 3}">
						<span>年份</span>
						<select class="id_28" name="year">
							<option value="">全部</option>
							<c:forEach var="i" begin="0" end="50">
								<option value="${curYear-i}"
									<c:if test="${(curYear-i) eq year }">selected="selected"</c:if>>${curYear-i}</option>
							</c:forEach>
						</select>
						<span>学校</span>
						<select class="id_28" name="admcode">
							<option value="">全部</option>
							<c:forEach items="${admMap}" var="item">
								<option value="${item.key}" <c:if test="${item.key eq admcode }">selected="selected"</c:if>> ${item.value}</option>
							</c:forEach>
						</select>
						<input class="id_31" onclick="query()" value="查询">
				</c:if>
				<c:if test="${level eq 1}">
					<a href="<%=basePath%>emp/download?year=${year}" >下载</a>
					<a href="<%=basePath%>emp/addEmp" class="id_16"></a>
				</c:if>
				<c:if test="${level eq 3 || level eq 2}">
					<input type="submit" class="id_31" value="导出">
				</c:if>
			</div>
			</form>
		</div>
		<!--表格区-->
		<div class="id_21">
			<table class="id_22">
				<thead>
					<tr>
						<!-- <th style="text-align:center;">选择</th> -->
						<th style="text-align:center;">招生代码</th>
						<th style="text-align:center;">年份</th>
						<th style="text-align:center;">毕业生初次就业率</th>
						<th style="text-align:center;">专业对口就业率</th>
						<th style="text-align:center;">顶岗实习半年以上稳定率</th>
						<th style="text-align:center;">初次就业月平均收入</th>
						<th style="text-align:center;">自主创业率</th>
						<th style="text-align:center;">审核</th>
						<th style="text-align:center;">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty empList }">
						<c:forEach items="${empList}" var="emp">
							<tr class="id_24">
								<td>${emp.admcode}</td>
								<td>${emp.year}</td>
								<td>${emp.employratefirst}</td>
								<td>${emp.coupartemployrate}</td>
								<td>${emp.sixmonthsteadrate}</td>
								<td>${emp.firstemploymonincome}</td>
								<td>${emp.venturerate}</td>
								<td>${emp.audit=="0"?"未审核":"已审核"}</td>

								<c:if test="${emp.audit==0}">
								<td>
									<c:if test="${level eq 2 }">
										<a href="#" name="${emp.id}" class="audit">通过</a>
									</c:if>
								</td>
								</c:if>
								<c:if test="${emp.audit==1}">
								<td>
									<c:if test="${level eq 2 }">
										通过
									</c:if>
								</td>
								</c:if>
								<td>
								<c:if test="${level eq 1 }">
								    <c:if test="${emp.audit==0}">
										<a href="<%=basePath%>emp/updateEmp?id=${emp.id}&detailFlag=0" class="id_23">修改</a>
										<a href="javascript:if(confirm('确认要删除吗？'))del('${emp.id }')" class="id_23">删除</a>
									</c:if>
									<c:if test="${emp.audit==1}">
										<a href="javascript:void()" class="id_23" style="background:#CCCCCC">修改</a>
										<a href="javascript:void()" class="id_23" style="background:#CCCCCC">删除</a>
									</c:if>
								</c:if>
								<a href="<%=basePath%>emp/showEmpDetail?id=${emp.id}&detailFlag=1" class="id_23">更多</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div style="float:right;">
			<nav aria-label="Page navigation">
			<ul class="pagination">

				<li><a
					href="<%=basePath%>emp/showEmpInfo?pageNum=1&year=${year}&admcode=${admcode}">首页</a></li>

				<c:if test="${pageInfo.hasPreviousPage}">
					<li><a
						href="<%=basePath%>emp/showEmpInfo?pageNum=${empPage.prePage}&year=${year}&admcode=${admcode}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>


				<c:forEach items="${empPage.navigatepageNums}" var="pageNum">
					<c:if test="${pageNum==empPage.pageNum}">
						<li class="active"><a href="#" onclick="return false;">${pageNum}</a></li>
					</c:if>
					<c:if test="${pageNum!=empPage.pageNum}">
						<li><a
							href="<%=basePath%>emp/showEmpInfo?pageNum=${pageNum}&year=${year}&admcode=${admcode}">${pageNum}</a></li>
					</c:if>
				</c:forEach>

				<c:if test="${pageInfo.hasNextPage}">
					<li><a
						href="<%=basePath%>emp/showEmpInfo?pageNum=${empPage.nextPage}&year=${year}&admcode=${admcode}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>

				<li><a
					href="<%=basePath%>emp/showEmpInfo?pageNum=${empPage.pages}&year=${year}&admcode=${admcode}">末页</a></li>
			</ul>
			</nav>
		</div>

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