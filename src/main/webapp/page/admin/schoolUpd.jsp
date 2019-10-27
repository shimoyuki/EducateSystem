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
var isNull = "-1";
var  count = 0;	
  $(function() {
  $("select[name='majorcode']").each(function(){
    count++;
  });
  });
function addTable() {
    var table = $("#FormView1_Table1");   
    var tr = $("<tr id=" + count + "></tr>");   
    var td1 = $("<td><div class='form-group'><select class='form-control' id='majorcode" + count + "' name='majorcode'/></select></div></td>");
    var bt = $("<td><button type='button' id='button1' name='button1' onclick=\"deleteTable(" + count + ")\" class='id_31' style='border: none'>-</button></td>");
    var td4 = $("<td> <input style='display:none' type='text' id='id" + count + "' name='id' class='id_34' value='" + isNull+ "'/></td>");
		td1.appendTo(tr);
		bt.appendTo(tr);
		td4.appendTo(tr);
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
		var id = $("#id" + count).val();
		var tr = $("#" + count + "");
		if (id != isNull) {
			$.ajax({
				url : "<%=basePath%>school/deleteMajorSchool",
    	        type: "get",
    	        datatype: "json",    	
    	        data: {id:id}
    	    }); 
    }
    
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
		<form id="formSchool" action="<%=basePath%>school/modifySchool?admcode=${school.admcode }"
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
											<th scope="row">招生代码</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="admcode"
														value="${school.admcode }" readonly="readonly">
												</div></td>
										</tr>
										<tr>
											<th scope="row">地区</th>
											<td><div class="form-group">
														<select class="form-control" name="area">
														<c:forEach items="${cityList }" var="city">
														<option value="${city }" <c:if test="${school.area eq city }">selected="selected"</c:if>>${city }</option>
														</c:forEach>
													</select>
												</div></td>
										</tr>
										<tr>
											<th scope="row">学校名称</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="schoolname"
														value="${school.schoolname }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学校地址</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="schooladdr"
														value="${school.schooladdr }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">联系电话</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="telenumber"
														value="${school.telenumber }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学校类型</th>
											<td><div class="form-group">
													<select class="form-control" name="runcode">
														<option value="0" <c:if test="${school.runcode eq 0 }">selected="selected"</c:if>>一般</option>
														<option value="1" <c:if test="${school.runcode eq 1 }">selected="selected"</c:if>>国示校</option>
														<option value="2" <c:if test="${school.runcode eq 2 }">selected="selected"</c:if>>国重校</option>
														<option value="3" <c:if test="${school.runcode eq 3 }">selected="selected"</c:if>>省示校</option>
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
								<c:if test="${!detailFlg }">
									<button id="Button1" type="button" onclick="addTable()"
										class="id_31">+</button>
										</c:if>

									<table id="FormView1_Table1" border="0">
										<tr>
											<td valign="middle" style="border-width:0px;">请选择专业名称</td>
										</tr>
										<c:if test="${!empty majSchList }">
											<c:forEach items="${majSchList}" var="majSch" varStatus="status">
												<tr id="${status.count-1}">
													<td><div class="form-group">
															<select class="form-control"
																id="majorcode${status.count-1}" name="majorcode">
																<c:forEach items="${majorMap }" var="major">
																	<option value="${major.key }"
																		<c:if test="${majSch.majorcode eq major.key }">selected="selected"</c:if>>${major.value }</option>
																</c:forEach>
															</select>
														</div></td>
													<c:if test="${!detailFlg }">
														<td><button type="button" id="button1" name="button1"
																onclick="deleteTable(${status.count - 1})" class="id_31"
																style="border: none">-</button></td>
																<td><input style="display:none" type="text"
															id="id${status.count-1}" name="id" class="id_34" value="${majSch.id }" /></td>
													</c:if>
												</tr>
											</c:forEach>
										</c:if>
									</table>
								</div>
							</div>
							<div class="id_29" style="clear:both">
								<c:if test="${!detailFlg}">
									<input id="submit" class="id_31" type="submit" value="提交">
								</c:if>
								<input id="reset" class="id_31" type="reset"
									onclick="location.href='showSchoolInfo'" value="返回">
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