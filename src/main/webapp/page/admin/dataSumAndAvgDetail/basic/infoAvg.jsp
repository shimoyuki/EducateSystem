<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script type="text/javascript" src="<%=basePath%>js/info.js"></script>
<script type="text/javascript">
window.onload=function(){
	
		$("input").attr("readonly",true);
		$("#back").attr("disabled",false);
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
				<span>基本情况</span><i></i><a href="">信息化建设平均值</a>
			</div>
		</div>
	<!--表格区-->
	<div id="id_25" style="border: none;">
		<form  id="formInfo" action="<%=basePath%>info/modifyInfo?id=${info.id }" method="post">		
			<div class="id_26" style="float: left" >
				<table class="id_27">
					<tbody>
						<tr>
      						<th scope="row">地区</th>
     						 <td><div class="form-group"><input type="text" class="form-control" name="admcode" value="${info.admcode}"> </div></td>
   						</tr>
						<tr>
							<th scope="row">年份</th>
							<td><div class="form-group">
								<input type="text" class="form-control" name="year" value="${info.year }" readonly="readonly">
						</tr>
						<%-- <tr>
							<th scope="row">服务器台数</th>
							<td><div class="form-group">
								<input type="text" class="form-control" name="server" value="${info.server }"></div></td>
						</tr> --%>
						<tr>
							<th scope="row">校园网络出口总带宽(Mbps)</th>
							<td><div class="form-group">
							<input type="text" class="form-control" name="networknum" value="${info.networknum }"></div></td>
						</tr>
						<tr>
							<th scope="row">校园网主干带宽(Mbps)</th>
							<td><div class="form-group">
							<input type="text" class="form-control" name="networkmain" value="${info.networkmain }"></div></td>
						</tr>
						<tr>
							<th scope="row">生均数字教学视频资源量（小时/生）</th>
							<td><div class="form-group">
							<input type="text" class="form-control" name="videostu" value="${info.videostu }"></div></td>
						</tr>
						<%-- <tr>
							<th scope="row">网络多媒体教室数</th>
							<td><div class="form-group">
							<input type="text" class="form-control" name="netmulrooms" value="${info.netmulrooms }"></div></td>
						</tr>
						<tr>
							<th scope="row">上网课程总量</th>
							<td><div class="form-group">
							<input type="text" class="form-control" name="onlinecourse" value="${info.onlinecourse }"></div></td>
						</tr> --%>
						<tr>
							<th scope="row">生均电子图书总量（册/生）</th>
							<td><div class="form-group">
							<input type="text" class="form-control" name="elecbookstu" value="${info.elecbookstu }"></div></td>
						</tr>
						<tr>
							<th scope="row">教学用计算机台数</th>
							<td><div class="form-group">
							<input type="text" class="form-control" name="teaccomputer" value="${info.teaccomputer }"></div></td>
						</tr>
						<tr>
							<th scope="row">生均教学用计算机台数</th>
							<td><div class="form-group">
							<input type="text" class="form-control" name="teaccompstu" value="${info.teaccompstu }"></div></td>
						</tr>						
					</tbody>
				</table>
			</div>
			<div class="id_29" style="clear:both">  					
				<input class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=1&year=${info.year }'" value="返回"> 										  							
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