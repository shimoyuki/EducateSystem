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
				<span>社会贡献</span><i></i><a href="<%=basePath%>social/showSocialInfo">社会服务</a>
			</div>
		</div>
		<!--表格区-->
		<form id="formSocial" action="<%=basePath%>social/modifySocial?id=${social.id }"
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
														value="${social.year }" readonly="readonly">
												</div></td>
										</tr>
										<tr>
											<th scope="row">培训企业员工数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="trainstaff"
														value="<fmt:formatNumber type="number" value="${social.trainstaff }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">培训残疾人人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="trainunabled"
														value="<fmt:formatNumber type="number" value="${social.trainunabled }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">培训失业人员人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="trainunemstaff"
														value="<fmt:formatNumber type="number" value="${social.trainunemstaff }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">培训农民工人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="trainfarmer"
														value="<fmt:formatNumber type="number" value="${social.trainfarmer }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">培训退役士兵人数</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="trainretiresoldier"
														value="<fmt:formatNumber type="number" value="${social.trainretiresoldier }" maxFractionDigits="0" groupingUsed="false"/>">
												</div></td>
										</tr>
										<tr>
											<th scope="row">技能鉴定项目人次</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="skillidentnum"
														value="${social.skillidentnum }">
												</div></td>
										</tr>
										<tr>
											<th scope="row">师生参与当地技术服务人次</th>
											<td><div class="form-group">
													<input type="text" class="form-control" name="teachserve"
														value="${social.teachserve }">
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="id_29" style="clear:both">
								<c:if test="${detailFlag==0}">                                                
									<input class="id_31" id="submit" class="id_31" type="submit" value="提交">
									<input class="id_31" type="button" onclick="location.href='<%=basePath%>social/showSocialInfo'" value="返回">
								</c:if>
								<c:if test="${detailFlag==1}">                                                
									<input class="id_31" type="button" onclick="location.href='<%=basePath%>social/showSocialInfo'" value="返回">
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