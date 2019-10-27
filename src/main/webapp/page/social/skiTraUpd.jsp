<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript" src="<%=basePath%>js/social.js"></script>
<script type="text/javascript">
var isNull = "-1";
var  count = 0;	
  $(function() {
  $("input[name='skillname']").each(function(){
    count++;
  });
  });
function addTable() {
    var table = $("#FormView1_Table1");   
    var tr = $("<tr id=" + count + "></tr>");   
    var td1 = $("<td><div class='form-group'><input type='text' id='name" + count + "' name='name' class='form-control'/></div></td>");
    var bt = $("<td><button type='button' id='button1' name='button1' onclick=\"deleteTable(" + count + ")\" class='id_31' style='border: none'>-</button></td>");
    var td4 = $("<td> <input style='display:none' type='text' id='id" + count + "' name='id' class='id_34' value='" + isNull+ "'/></td>");

		td1.appendTo(tr);
		bt.appendTo(tr);
		td4.appendTo(tr);
		tr.appendTo(table);
		
		count++;
	}

	function deleteTable(count) {
		var id =$("#id"+count).val();
		var tr = $("#" + count + "");
		if (id != isNull) {
			$.ajax({
				url : "<%=basePath%>skiTra/deleteSkill",
    	        type: "get",
    	        datatype: "json",    	
    	        data: {id:id}
    	    }); 
    }
    
    tr.remove();       
}
	window.onload=function(){
		var flag = ${detailFlag};
		if(flag==1||flag==2||flag==3||flag==4){
			$("input").attr("readonly",true);		
			$("select").attr("disabled",true);		
		};	 
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
				<span>社会贡献</span><i></i><a href="<%=basePath%>skiTra/showSkiTraInfo">技术技能人才培养</a>
			</div>
		</div>
		<!--表格区-->
		<form id="formSkiTra" action="<%=basePath%>skiTra/modifySkiTra?id=${skiTra.id }"
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
											<th scope="row">年份</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="year"
														value="${skiTra.year }" readonly="readonly">
												</div></td>
										</tr>
										<tr>
											<th scope="row">为当地主要产业培养技术技能人才数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="localfoster"
														value="<fmt:formatNumber type="number" value="${skiTra.localfoster }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">为当地培训技术技能人才数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="localtrain"
														value="<fmt:formatNumber type="number" value="${skiTra.localtrain }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">产生的经济效益和社会效益（万元）</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="ecnomicsocial"
														value="${skiTra.ecnomicsocial }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">学校师生参与当地产业发展或结构调整技术攻关人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="trackproblemnum"
														value="<fmt:formatNumber type="number" value="${skiTra.trackproblemnum }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_26" style="float: left;">
								<div>
								<c:if test="${detailFlag == 0  }">
								<h5>
									<span id="FormView1_Label1"></span>承担、参与改进或推广技术名称
								</h5>
									<button id="Button1" type="button" onclick="addTable()"
										class="id_31">+</button>
										</c:if>

									<table id="FormView1_Table1" border="0">
										<tr>
											<td valign="middle" style="border-width:0px;">技术名称 </td>
										</tr>
										<c:if test="${!empty skillList }">
											<c:forEach items="${skillList}" var="skill" varStatus="status">
												<tr id="${status.count-1}">
													<td><div class="form-group">
															<input type="text" id="skillname${status.count-1}"
																name="name" value="${skill.name }"
																class="form-control" />
														</div></td>	
													<c:if test="${detailFlag == 0  }">
														<td><button type="button" id="button1" name="button1"
																onclick="deleteTable(${status.count - 1})" class="id_31"
																style="border: none">-</button></td>
																<td><input style="display:none" type="text"
															id="id${status.count-1}" name="id" class="id_34" value="${skill.id }" /></td>
													</c:if>
												</tr>
											</c:forEach>
										</c:if>
									</table>
								</div>
							</div>
							<div class="id_29" style="clear:both">
								<c:if test="${detailFlag==0}">                                                
									<input class="id_31" id="submit" class="id_31" type="submit" value="提交">
									<input class="id_31" type="button" onclick="location.href='<%=basePath%>skiTra/showSkiTraInfo'" value="返回">
								</c:if>
								<c:if test="${detailFlag==1}">                                                
									<input class="id_31" type="button" onclick="location.href='<%=basePath%>skiTra/showSkiTraInfo'" value="返回">
								</c:if>
								<c:if test="${detailFlag==2}">
									<input class="id_31" type="button" onclick="location.href='<%=basePath%>dataQuery/getDataQueryList'" value="返回"> 
								</c:if>
								<c:if test="${detailFlag==3}">
									<input class="id_31" type="button" onclick="location.href='<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList'" value="返回"> 
								</c:if>	
								<c:if test="${detailFlag==4}">
									<input class="id_31" type="button" onclick="location.href='<%=basePath%>cityDataStatistics/getCityDataStatisticsList'" value="返回"> 
								</c:if>		
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