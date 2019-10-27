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
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>js/jquery.placeholder.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<script type="text/javascript">
	function query() {
		var inputYear = document.getElementById("admcode");
		if(inputYear != null){
		admcode = inputYear.value;
		if (admcode == null || admcode == ""
				|| (admcode != "" && !/^[1-9][0-9]{3,}$/.test(admcode))) {
			alert("请输入正确的招生代码！");
			return false;
		}
		}
		$("#formTitle").attr("action", "<%=basePath%>school/showSchoolInfo");
		$("#formTitle").submit();
		return true;
	}
	
	function del(admcode){  //使用ajax完成删除操作
	$.ajax({
				data : {
				admcode: admcode
				},
				type : "get",
				dataType : 'json',
				url : "<%=basePath%>school/deleteSchool",
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
</script>
</head>
<body>
	<%@ include file="/page/top.jsp"%>
	<%@ include file="/page/aLeft.jsp"%>
	<!--右边内容区-->
	<div admcode="id_11">
		<!--添加删除修改-->
		<div class="id_12">
			<div style="float:left;line-height:60px;line-height:30px;padding:10px 0;margin:0 0;">
			<form action="<%=basePath%>school/upload" method="post" enctype="multipart/form-data">
			<input name="uploadFile" type="file" style="display:inline">
			<input onclick="return confirm('上传文件需要一些时间，请耐心等候！');" type="submit" value="上传">
			</form>
			</div>
			<div class="id_14">
				<a href="<%=basePath%>school/addSchool" class="id_16"></a>
				<div class="id_18" style="width: auto;">
					<form id="formTitle" action="<%=basePath%>school/showSchoolInfo"
						method="get">
						<input type="text" admcode="admcode" class="id_19"
							name="admcode" value="${admcode }" placeholder="请输入招生代码查询">
						<input class="id_20" onclick="query()">
					</form>
				</div>
			</div>
		</div>
		<!--表格区-->
		<div class="id_21">
			<table class="id_22">
				<thead>
					<tr>
						<!-- <th style="text-align:center;">选择</th> -->
						<th style="text-align:center;">招生代码</th>
						<th style="text-align:center;">地区</th>
						<th style="text-align:center;">学校名称</th>
						<th style="text-align:center;">学校地址</th>
						<th style="text-align:center;">联系电话</th>
						<th style="text-align:center;">学校类型</th>
						<th style="text-align:center;">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty schoolList }">
						<c:forEach items="${schoolList}" var="school">
							<tr class="id_24">
								<td>${school.admcode}</td>
								<td>${school.area}</td>
								<td>${school.schoolname}</td>
								<td>${school.schooladdr}</td>
								<td>${school.telenumber}</td>
								<td>${school.runcode}</td>

								<td width="100"><a
									href="<%=basePath%>school/updateSchool?admcode=${school.admcode} "
									class="id_23">修改</a> <a
									href="javascript:if(confirm('确认要删除吗？'))del('${school.admcode }')"
									class="id_23">删除</a> </td>
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
					href="<%=basePath%>school/showSchoolInfo?pageNum=1&admcode=${admcode}">首页</a></li>

				<c:if test="${pageInfo.hasPreviousPage}">
					<li><a
						href="<%=basePath%>school/showSchoolInfo?pageNum=${schoolPage.prePage}&admcode=${admcode}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>


				<c:forEach items="${schoolPage.navigatepageNums}" var="pageNum">
					<c:if test="${pageNum==schoolPage.pageNum}">
						<li class="active"><a href="#" onclick="return false;">${pageNum}</a></li>
					</c:if>
					<c:if test="${pageNum!=schoolPage.pageNum}">
						<li><a
							href="<%=basePath%>school/showSchoolInfo?pageNum=${pageNum}&admcode=${admcode}">${pageNum}</a></li>
					</c:if>
				</c:forEach>

				<c:if test="${pageInfo.hasNextPage}">
					<li><a
						href="<%=basePath%>school/showSchoolInfo?pageNum=${schoolPage.nextPage}&admcode=${admcode}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>

				<li><a
					href="<%=basePath%>school/showSchoolInfo?pageNum=${schoolPage.pages}&admcode=${admcode}">末页</a></li>
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