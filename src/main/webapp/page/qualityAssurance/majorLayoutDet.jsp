<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>css/sjcj.css" rel="stylesheet" type="text/css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css"
	type="text/css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=basePath%>css/bootstrapValidator.min.css" type="text/css">
<script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/majorLayout.js"></script>
<script language="javascript" type="text/javascript">
var isNull="isNull";
var count=0;
window.onload=function(){
	var id = document.getElementById('id').value;
		
	//生成表格
	$.ajax({
        url: "<%=basePath%>majorLayout/getMajorStutList",
					type : "POST",
					data : {
						id : id
					},
					dataType : "json",
					success : function(data) {
						for (count = 0; count < data.length; count++) {

							var table = $("#FormView1_Table1");
							var tr = $("<tr id=" + count + "></tr>");
							var s1 = $("<td style='border: none'><select disabled='disabled' id='select"
									+ count
									+ "' onchange=\"onchangeyb(this,"
									+ count
									+ ")\" name='select"
									+ count
									+ "' style='border: none' class='id_37'><option>"
									+ data[count].induName
									+ "</option></select></td>");
							var s2 = $("<td style='border: none'><select disabled='disabled' id='selects" + count + "' name='selects" + count + "' style='border: none' class='id_37'><option>"
									+ data[count].name
									+ "</option></select></td>");
							var td1 = $("<td style='border: none'> <input disabled='disabled' type='text' onblur=\"checkNull('firstGradeSum"
									+ count
									+ "','1')\" id='firstGradeSum"
									+ count
									+ "' name='firstGradeSum"
									+ count
									+ "' class='id_34' value='"
									+ data[count].firstGradeSum + "'/></td>");
							var td2 = $("<td style='border: none'> <input disabled='disabled' type='text' onblur=\"checkNull('secGradeSum"
									+ count
									+ "','2')\" id='secGradeSum"
									+ count
									+ "' name='secGradeSum"
									+ count
									+ "' class='id_34' value='"
									+ data[count].secGradeSum + "'/></td>");
							var td3 = $("<td style='border: none'><input disabled='disabled' type='text' onblur=\"checkNull('thirdGradeSum"
									+ count
									+ "','3')\" id='thirdGradeSum"
									+ count
									+ "' name='thirdGradeSum"
									+ count
									+ "' class='id_34' value='"
									+ data[count].thirdGradeSum + "'/></td>");
							var td4 = $("<td style='border: none'> <input style='display:none' type='text' id='id" + count + "' name='id" + count + "' class='id_34' value='"+data[count].id+"' /></td>");

							s1.appendTo(tr);
							s2.appendTo(tr);
							td1.appendTo(tr);
							td2.appendTo(tr);
							td3.appendTo(tr);
							td4.appendTo(tr);
							tr.appendTo(table);
						}
					},
					error : function() {
						alert("error!!!!!");
					}
				});
		$("input").attr("readonly", true);
		$("select").attr("disabled", true);
	};
</script>
</head>
<body>
	<%@ include file="/page/top.jsp"%>
	<c:choose>
		<c:when test="${level eq '4'}">
			<!--左边导航栏-->
			<%@ include file="/page/aLeft.jsp"%>
		</c:when>
		<c:otherwise>
			<!--左边导航栏-->
			<%@ include file="/page/left.jsp"%>
		</c:otherwise>
	</c:choose>
	<!--右边内容区-->
	<div id="id_11">
		<!--添加删除修改-->
		<div class="id_12">
			<div class="id_13">
				<span>质量保障措施</span><i></i><a
					href="<%=basePath%>majorLayout/getMajorLayoutList">专业布局</a>
			</div>
			<div class="id_14"></div>
		</div>
		<!--表格区-->
		<div id="id_25" style="border: none;">
			<form action="" id="majorLayoutForm">
				<div class="id_26" style="float: left">
					<table class="id_27">
						<tbody>
							<input type="hidden" name="id" id="id" value="${majorLayout.id}" />
							<tr>
								<th scope="row">年份</th>
								<td><div class="form-group">
										<input type="text" id="year" name="year" class="form-control"
											readonly="readonly" value="${majorLayout.year}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">一产类专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="oneIndu"
											id="oneIndu" value="${majorLayout.oneIndu}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">二产类专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="twoIndu"
											id="twoIndu" value="${majorLayout.twoIndu}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">三产类专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="threeIndu"
											id="threeIndu" value="${majorLayout.threeIndu}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">围绕地方支柱产业的专业开设数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="localPillar"
											id="localPillar" value="${majorLayout.localPillar}">
									</div></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="id_26" style="float: left">
					<table class="id_27">
						<tbody>
							<%-- <tr>
								<th scope="row">省级重点专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="provinceMore"
											id="provinceMore" value="${majorLayout.provinceMore}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">国示校重点建设专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="staUniKeyMajor"
											id="staUniKeyMajor" value="${majorLayout.staUniKeyMajor}">
									</div></td>
							</tr> --%>
							<tr>
								<th scope="row">新增专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="newMajor"
											id="newMajor" value="${majorLayout.newMajor}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">停办专业数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="stopMajor"
											id="stopMajor" value="${majorLayout.stopMajor}">
									</div></td>
							</tr>
						</tbody>
					</table>
					</div>
					<div class="id_32" style="float: left; border: none">

						<h5>
							<span id="FormView1_Label1"></span>专业人数详情
						</h5>
		
						<div>
							<table id="FormView1_Table1" border="0">
								<tr>
									<td valign="middle" style="border-width: 0px;">请选择专业类</td>
									<td valign="middle" style="border-width: 0px;">请选择专业名称</td>
									<td valign="middle" style="border-width: 0px;">一年级人数</td>
									<td valign="middle" style="border-width: 0px;">二年级人数</td>
									<td valign="middle" style="border-width: 0px;">三年级人数</td>
								</tr>
							</table>
		
						</div>
					</div>
					
					<div class="id_29" style="clear:both">
						<c:if test="${detailFlag==2}">
							<input class="id_31"
								onclick="location.href='<%=basePath%>dataQuery/getDataQueryList'"
								value="返回">
						</c:if>
						<c:if test="${detailFlag==3}">
							<input class="id_31"
								onclick="location.href='<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList'"
								value="返回">
						</c:if>
						<c:if test="${detailFlag==4}">
							<input class="id_31"
								onclick="location.href='<%=basePath%>cityDataStatistics/getCityDataStatisticsList'"
								value="返回">
						</c:if>
						<c:if test="${detailFlag==1}">
							<input class="id_31"
								onclick="javascript:location.href='<%=basePath%>majorLayout/getMajorLayoutList'"
								value="返回">
						</c:if>
					</div>
				
			</form>

		</div>

	</div>

	<script>
total = document.documentElement.clientHeight;
colHeight = total-document.getElementById("id_05").offsetTop;
document.getElementById("id_05").style.height=colHeight+"px";
document.getElementById("id_11").style.height=colHeight+"px";
document.getElementById("id_content").style.height=colHeight+"px";
</script>
</body>
</html>