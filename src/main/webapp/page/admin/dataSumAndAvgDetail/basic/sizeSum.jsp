<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>css/bootstrapValidator.min.css" type="text/css">
<script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/size.js"></script>
<script type="text/javascript">
window.onload=function(){
	
		$("input").attr("readonly",true);		
		$("select").attr("disabled",true);		
		 
}
</script>
</head>
<body>
<%@ include file="/page/top.jsp" %> 
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
<div class="id_13"><span>基本情况</span><i></i><a href="">规模总和</a></div>
<div class="id_14">
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form action="<%=basePath%>size/updateSize" id="sizeForm" method="post">
<div class="id_26" style="float:left">
<table class="id_27">
    <tbody>
     <tr>
      <th scope="row">地区</th>
      <td><div class="form-group"><input type="text" class="form-control" name="admcode" value="${size.admcode}"> </div></td>
    </tr>
    <tr>
      <th scope="row">年份</th>     
      <td><div class="form-group">
      	<input type="text"  id="year"   name="year" class="form-control" readonly="readonly"  value="${size.year}"/>
	 </div></td>
    </tr>    
    <tr>
      <th scope="row">学校占地面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="area" value="${size.area}"> </div></td>
    </tr>
    <tr>
      <th scope="row">自有产权占地面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="ownPropArea" value="${size.ownPropArea}"> </div></td>
    </tr>
    <tr >
      <th scope="row">总建筑面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="totalArea" value="${size.totalArea}"> </div></td>
    </tr>
    <tr >
      <th scope="row">学校自有产权建筑面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schOwnConArea" value="${size.schOwnConArea}"> </div></td>
    </tr>
    <tr >
      <th scope="row">生均建筑面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stuArea" value="${size.stuArea}"> </div></td>
    </tr>
    <tr >
      <th scope="row">教学及辅助用房面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="teaAuxArea" value="${size.teaAuxArea}"> </div></td>
    </tr>
    <tr >
      <th scope="row">校内实训用房面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="trainArea" value="${size.trainArea}"> </div></td>
    </tr>
    <tr >
      <th scope="row">心理咨询室建筑面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="psyArea" value="${size.psyArea}"> </div></td>
    </tr>
    <tr >
      <th scope="row">学生宿舍面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="dormArea" value="${size.dormArea}"> </div></td>
    </tr>
    <tr >
      <th scope="row">生均宿舍面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="dormPerArea" value="${size.dormPerArea}"> </div></td>
    </tr>
  </tbody>
    </table>
</div>
<div class="id_26" style="float:left">
<table class="id_27">
      <tbody>
    
   
   <tr>
      <th scope="row">在校生数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="totalStudent" value=<fmt:formatNumber type="number" value="${size.totalStudent}" maxFractionDigits="0" groupingUsed="false"/>> </div></td>
    </tr>
    <tr>
      <th scope="row">毕业生数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="annualGraduate" value=<fmt:formatNumber type="number" value="${size.annualGraduate}" maxFractionDigits="0" groupingUsed="false"/>> </div></td>
    </tr>
    <tr>
      <th scope="row">当年招生总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="enrollment" value=<fmt:formatNumber type="number" value="${size.enrollment}" maxFractionDigits="0" groupingUsed="false"/>> </div></td>
    </tr>
    <tr>
      <th scope="row">专业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="majors" value=<fmt:formatNumber type="number" value="${size.majors}" maxFractionDigits="0" groupingUsed="false"/>> </div></td>
    </tr>
  </tbody>
    </table>
    </div>
    <div class="id_29" style="clear:both">  
    	<input class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=1&year=${size.year }'" value="返回">													  							
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