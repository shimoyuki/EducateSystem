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
<script type="text/javascript">
var  count = 0;	
function addTable() {
    var table = $("#FormView1_Table1");   
    var tr = $("<tr id=" + count + "></tr>");   
     var td1 = $("<td><div class='form-group'><select class='form-control' id='majorcode" + count + "' name='majorcode'/></select></div></td>");
    var bt = $("<td><button type='button' id='button1' name='button1' onclick=\"deleteTable(" + count + ")\" class='id_31' style='border: none'>-</button></td>");
  
    td1.appendTo(tr);
    bt.appendTo(tr);
    tr.appendTo(table);
     $.ajax({
		    url: "<%=basePath%>school/getMajorMap",
			type : "POST",
			success : function(data) {
				//alert(data);
				var Data = eval('('+data+')');
				$.each(Data, function(key, value) { 
					//console.log("<option value='"+key+"'>" + value + "</option>");
					$("#majorcode" + count).append("<option value='"+key+"'>" + value + "</option>"); 
					}); 
				count++;
			},
			error : function(res) {
				alert(res.responseText);
			}
		});
}

function deleteTable(count) {
    
    var tr = $("#" + count + "");
    tr.remove();        
   
}
</script>
</head>
<body>
	<%@ include file="/page/top.jsp"%>
	<%@ include file="/page/aLeft.jsp"%>
	<!--右边内容区-->
	<div id="id_11">
		<!--添加删除修改-->
		<div class="id_12">
			<div class="id_13">
			</div>
		</div>
		<!--表格区-->
		<form id="formSchool" action="<%=basePath%>school/saveSchool" method="post">
			<table class="abc" cellspacing="0" border="0"
				style="border-collapse:collapse;">
				<tr>
					<td>
						<div id="id_25" style="border: none;">
							<div class="id_26" style="float: left">
								<table class="id_27">
									<tbody>
										<tr>
											<th scope="row">招生代码</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="admcode">
												</div></td>
										</tr>
										<tr>
											<th scope="row">地区</th>
											<td><div class="form-group">
													<select class="form-control" name="area">
														<c:forEach items="${cityList }" var="city">
															<option value="${city }">${city }</option>
														</c:forEach>
													</select>
												</div></td>
										</tr>
										<tr>
											<th scope="row">学校名称</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="schoolname">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学校地址</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="schooladdr">
												</div></td>
										</tr>
										<tr>
											<th scope="row">联系电话</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="telenumber">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学校类型</th>
											<td><div class="form-group">
													<select class="form-control" name="runcode">
														<option value="0">一般</option>
														<option value="1">国示校</option>
														<option value="2">国重校</option>
														<option value="3">省示校</option>
													</select>
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_26" style="float: left;">
								<h3>
									<span id="FormView1_Label1"></span>添加专业
								</h3>
								<div>
									<button id="Button1" type="button" onclick="addTable()"
										class="id_31">+</button>

									<table id="FormView1_Table1" border="0">
										<tr>
											<td valign="middle" style="border-width:0px;">请选择专业名称 </td>
										</tr>
									</table>
								</div>
							</div>
							<div class="id_29" style="clear:both">
								<c:if test="${!detailFlg}">
									<input id="submit" class="id_31" type="submit" value="提交">
								</c:if>
								<input id="reset" class="id_31" type="reset"
									onclick="location.href='showSchoolInfo'"
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