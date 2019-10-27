<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="<%=basePath%>js/equitment.js"></script>
<script language="javascript" type="text/javascript">
function updateEquitment(){  
    var form = document.forms[0];  
    form.action = "<%=basePath%>Equitment/updateEquitment";  
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
	var startYear=myDate.getFullYear()-50;//起始年份
	var endYear=myDate.getFullYear()+50;//结束年份
	var obj=document.getElementById('year');
	for (var i=startYear;i<=endYear;i++)
	{
	obj.options.add(new Option(i,i));
	}
	obj.options[obj.options.length-51].selected=1;	
}
</script>
</head>
<body>
<%@ include file="/page/top.jsp"%>
<!--左边导航栏-->
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
<div class="id_13"><span>基本情况</span><i></i><a href="#">设施设备</a></div>
<div class="id_14">
<!-- <a href="#" class="id_15"></a>
<a href="#" class="id_16"></a>
<a href="#" class="id_17"></a>
<div class="id_18"><input type="text" class="id_19" placeholder="请输入年份查询"><input type="submit" value="" class="id_20"></div> -->
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form id="formequit" action="<%=basePath %>/Equitment/updateEquitment" name="sizeForm">
<div class="id_26" style="float:left">
<table class="id_27">
    <tbody>
    <input type="hidden" name="id" value="${equitment.id}"/>
    <tr>
      <th scope="row">年份</th>     
      <td><div class="form-group">
      	<input type="text"  id="year"   name="year" class="form-control" readonly="readonly"  value="${equitment.year}"/>
	 </div></td>
    </tr>
    <tr >
      <th scope="row">固定资产总值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="totalAssertWorth" value="${equitment.totalAssertWorth}"></div></td>
    </tr>
    <tr>
      <th scope="row">教学设备资产值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="teacEquitWorth" value="${equitment.teacEquitWorth}"></div></td>
    </tr>
    <tr>
      <th scope="row">实训设备资产值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="trainEquitWorth" value="${equitment.trainEquitWorth}"></div></td>
    </tr>
    <tr>
      <th scope="row">年新增教学设备资产值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="yearTeacEquitWorth" value="${equitment.yearTeacEquitWorth}"></div></td>
    </tr>
    <tr >
      <th scope="row">年新增实训设备资产值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="yearTrainEquitWorth" value="${equitment.yearTrainEquitWorth}"></div></td>
    </tr>
    <tr >
      <th scope="row">生均教学设备资产值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stuTracEquitWorth" value="${equitment.stuTracEquitWorth}"></div></td>
    </tr>
    <tr >
      <th scope="row">生均实训设备资产值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stuTrainEquitWorth"  value="${equitment.stuTrainEquitWorth}"></div></td>
    </tr>
    <tr >
      <th scope="row">生均实训实习工位数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="traPracWorkPe"  value="${equitment.traPracWorkPe}"></div></td>
    </tr>
    
  </tbody>
    </table>
</div>
<div class="id_26" style="float:left">
<table class="id_27">
      <tbody>
    <tr >
      <th scope="row">校内实训基地数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="inTrainBase" value="${equitment.inTrainBase}"></div></td>
    </tr>
    <tr >
      <th scope="row">校外实训基地数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="outTrainBase" value="${equitment.outTrainBase}"></div></td>
    </tr>
    <tr >
      <th scope="row">图书馆纸质图书藏书量（册）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="libBooks" value="${equitment.libBooks}"></div></td>
    </tr>
    <tr >
      <th scope="row">图书馆电子图书藏书量（册）	</th>
      <td><div class="form-group"><input type="text" class="form-control" name="libBooksElec" value="${equitment.libBooksElec}"></div></td>
    </tr>
    <tr >
      <th scope="row">年度新增图书（册）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="yearBooks" value="${equitment.yearBooks}"></div></td>
    </tr>
    <tr >
      <th scope="row">阅览室座位数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="readSeats" value="${equitment.readSeats}"></div></td>
    </tr>
    <tr >
      <th scope="row">生均图书（册）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stuBook" value="${equitment.stuBook}"></div></td>
    </tr>
    <tr >
      <th scope="row">期刊订阅种类数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="subScribs" value="${equitment.subScribs}"></div></td>
    </tr>
    <tr >
      <th scope="row">电子图书数（册）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="elecBooks" value="${equitment.elecBooks}"></div></td>
    </tr>
    <tr >
      <th scope="row">电子阅览室座位数	（个）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="elecSeats" value="${equitment.elecSeats}"></div></td>
    </tr>
  </tbody>
    </table>
    </div>
    <div class="id_29" style="clear:both">
    <c:if test="${detailFlag==0}">                                                
			<input class="id_31" id="submit" class="id_31" type="submit" value="提交">
			<input class="id_31" type="button" onclick="location.href='<%=basePath%>Equitment/getEquitmentList'" value="返回">
		</c:if>
		<c:if test="${detailFlag==1}">                                                
			<input class="id_31" type="button" onclick="location.href='<%=basePath%>Equitment/getEquitmentList'" value="返回">
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