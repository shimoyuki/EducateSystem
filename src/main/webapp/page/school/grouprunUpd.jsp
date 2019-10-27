<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="<%=basePath%>js/jituanhua.js"></script>
<script language="javascript" type="text/javascript">


function updateGroupschool(){  
    var form = document.forms[0];  
    form.action = "<%=basePath%>group/updateGroupschool";  
    form.method="post";  
    form.submit(); 
}


window.onload=function(){
	var flag = ${detailFlag};
	if(flag==1||flag==2||flag==3||flag==4){
		$("input").attr("readonly",true);		
		$("select").attr("disabled",true);		
	};
	
	//设置年份的选择
	var myDate= new Date();
	var year = document.getElementById('yearhidden').value;
	myDate.setFullYear(year);
	var startYear=myDate.getFullYear()-10;//起始年份
	var endYear=myDate.getFullYear();//结束年份
	var obj=document.getElementById('year');
	for (var i=endYear;i>=startYear;i--)
	{
	obj.options.add(new Option(i,i));
	}
	obj.options[obj.options.length-51].selected=1;	
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
<div class="id_13"><span>校企合作</span><i></i><a href="#">集团化办学情况</a></div>
<div class="id_14">
<!-- <a href="#" class="id_15"></a>
<a href="#" class="id_16"></a>
<a href="#" class="id_17"></a>
<div class="id_18"><div class="form-group"><input type="text" class="id_19" placeholder="请输入年份查询"><div class="form-group"><input type="submit" value="" class="id_20"></div> -->
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form id="formjituanhua" action="<%=basePath %>/group/updateGroupschool" name="sizeForm">
<div class="id_26" style="float:left">
<table class="id_27">
    <tbody>
     <input type="hidden" name="id" value="${groupschool.id}"/>
     <tr>
		<th scope="row">年份</th>
		<td><div class="form-group">
			<input type="text" class="form-control" name="year" value="${groupschool.year }" readonly="readonly">
			</div>
		</td>				
    </tr>
    <tr>
      <th scope="row">本校牵头组织的职教集团数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="leadvocedugroup" value="<fmt:formatNumber type="number" value="${groupschool.leadvocedugroup}" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
    <tr>
      <th scope="row">本校参与的职教集团数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="joinvocedugroup" value="<fmt:formatNumber type="number" value="${groupschool.joinvocedugroup}" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
    <tr>
      <th scope="row">参加本校牵头的职教集团学校数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="joinleadvocedugroupscho" value="<fmt:formatNumber type="number" value="${groupschool.joinleadvocedugroupscho}" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
    <tr>
      <th scope="row">参加本校牵头的职教集团企业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="joinleadvocedugroupenterp" value="<fmt:formatNumber type="number" value="${groupschool.joinleadvocedugroupenterp}" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
    <tr>
      <th scope="row">参加本校牵头的职教集团专业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="joinleadvocedugroupmajor" value="<fmt:formatNumber type="number" value="${groupschool.joinleadvocedugroupmajor}" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>  
  </tbody>
    </table>
    
   
    	 <c:if test="${detailFlag==0}">                                                
			<input class="id_31" id="submit" class="id_31" type="submit" value="提交">
			<input class="id_31" type="button" onclick="location.href='<%=basePath%>group/getGroupSchoolList'" value="返回">
		</c:if>
		<c:if test="${detailFlag==1}">                                                
			<input class="id_31" type="button" onclick="location.href='<%=basePath%>group/getGroupSchoolList'" value="返回">
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