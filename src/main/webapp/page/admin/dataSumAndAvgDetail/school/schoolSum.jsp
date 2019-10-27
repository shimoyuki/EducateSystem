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
<script type="text/javascript" src="<%=basePath%>js/hezuo.js"></script>
<script language="javascript" type="text/javascript">
window.onload=function(){
		$("input").attr("readonly",true);		
		$("select").attr("disabled",true);	
	
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
function checknum(){
	 var sum=$("#majorsum").val();
	 var input=$("#majornum").val();
	/*  alert("input="+input);
	 alert("sum="+sum);  */
	 if(input-sum>0){	 
		alert("校企合作覆盖专业数应小于学校本年度专业数");
		return false;
	 }		
	 else
		return true;
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
<div class="id_13"><span>校企合作</span><i></i><a href="#">合作情况总和</a></div>
<div class="id_14">
<!-- <a href="#" class="id_15"></a>
<a href="#" class="id_16"></a>
<a href="#" class="id_17"></a>
<div class="id_18"><input type="text" class="id_19" placeholder="请输入年份查询"><input type="submit" value="" class="id_20"></div> -->
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form id="formhezuo" action="<%=basePath%>schoolenterprise/updateschoolenterprise" method="post" name="sizeForm">
<div class="id_26" style="float:left">
<table class="id_27">
    <tbody>
      <input type="hidden" name="id" value="${schoolenterprise.id}"/>
      <tr>
      <th scope="row">地区</th>
      <td>
     	<div class="form-group">
			<input type="text" class="form-control" name="admcode" id="admcode" value="${schoolenterprise.admcode }" readonly="readonly">
		</div>
		</td>
    </tr>
    <tr>
      <th scope="row">年份</th>
      <td>
     	<div class="form-group">
			<input type="text" class="form-control" name="year" id="year" value="${schoolenterprise.year }" readonly="readonly">
		</div>
		</td>
    </tr>
     <tr >
      <th scope="row">校企合作覆盖专业数</th>
      <td>
      	<div class="form-group">
      		<input id="majornum" type="text" class="form-control" name="majornum" value="<fmt:formatNumber type="number" value="${schoolenterprise.majornum }" maxFractionDigits="0" groupingUsed="false"/>" onblur="checknum()">
      		<input id="majorsum" type="hidden" />
      	</div>
      </td>
    </tr>
    <tr>
      <th scope="row">签订合作协议的企业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopagreeenterp" value="<fmt:formatNumber type="number" value="${schoolenterprise.coopagreeenterp }" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
    <tr>
      <th scope="row">签订合作协议的专业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopagreemajor" value="<fmt:formatNumber type="number" value="${schoolenterprise.coopagreemajor }" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
    <tr>
      <th scope="row">合作企业参与教学的专业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpjointeachmajor" value="<fmt:formatNumber type="number" value="${schoolenterprise.coopenterpjointeachmajor }" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
    <tr >
      <th scope="row">合作企业参与教学的教师数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpjointeachteacher" value="<fmt:formatNumber type="number" value="${schoolenterprise.coopenterpjointeachteacher }" maxFractionDigits="0" groupingUsed="false"/>" ></div></td>
    </tr>
    <tr >
      <th scope="row">合作企业参与教学课时数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpjointeachclass" value="<fmt:formatNumber type="number" value="${schoolenterprise.coopenterpjointeachclass }" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
   <%--  <tr >
      <th scope="row">校企合作开发教材数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterptext" value="${schoolenterprise.coopenterptext }"></div></td>
    </tr>
    <tr >
      <th scope="row">校企合作研发成果产值</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpdevelop"  value="${schoolenterprise.coopenterpdevelop }"></div></td>
    </tr>
    <tr >
      <th scope="row">年支付企业兼职教师课酬（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="parttimesalary"  value="${schoolenterprise.parttimesalary }"></div></td>
    </tr>
    <tr >
      <th scope="row">企业捐赠总值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="enterpdonation"  value="${schoolenterprise.enterpdonation }"></div></td>
    </tr> --%>
    <tr >
      <th scope="row">合作企业投入资金总额（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpfund"  value="${schoolenterprise.coopenterpfund }"></div></td>
    </tr>
    <tr >
      <th scope="row">合作企业投入到账资金（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterparrivalfund"  value="${schoolenterprise.coopenterparrivalfund }"></div></td>
    </tr>
    
  </tbody>
    </table>
</div>
<div class="id_26" style="float:left">
<table class="id_27">
      <tbody>
    <tr >
      <th scope="row">合作企业投入设备总值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpequitworth" value="${schoolenterprise.coopenterpequitworth }"></div></td>
    </tr>
     <tr >
      <th scope="row">与企业共建研发中心数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="enterpbuildreseadevelop" value="<fmt:formatNumber type="number" value="${schoolenterprise.enterpbuildreseadevelop }" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
    <tr >
      <th scope="row">校外教师培训基地数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="offschoteachertrainbase" value="<fmt:formatNumber type="number" value="${schoolenterprise.offschoteachertrainbase }" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
    <%-- <tr >
      <th scope="row">校外实践教学基地数量</th>
      <td><div class="form-group"><input type="text" class="form-control" name="offschoteachbase" value="${schoolenterprise.offschoteachbase }"></div></td>
    </tr> --%>
    <tr >
      <th scope="row">生产性实训基地产值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="prodtrainbaseval" value="${schoolenterprise.prodtrainbaseval }"></div></td>
    </tr>
    <tr >
      <th scope="row">校企合作订单班人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schoenterpcooporderclassnum" value="<fmt:formatNumber type="number" value="${schoolenterprise.schoenterpcooporderclassnum }" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
    <tr >
      <th scope="row">校企合作开发课程数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schoenterpdevelopcourse" value="<fmt:formatNumber type="number" value="${schoolenterprise.schoenterpdevelopcourse }" maxFractionDigits="0" groupingUsed="false"/>"></div></td>
    </tr>
    <tr >
      <th scope="row">专任教师企业实习实践人次</th>
      <td><div class="form-group"><input type="text" class="form-control" name="fullenterprac" value="${schoolenterprise.fullenterprac }"></div></td>
    </tr>
    <tr >
      <th scope="row">专任教师人均企业实习实践时间（天）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="fullentertime" value="${schoolenterprise.fullentertime }"></div></td>
    </tr>
    <%-- <tr >
      <th scope="row">专任教师企业实习实践人次</th>
      <td><div class="form-group"><input type="text" class="form-control" name="fullenterprac" value="${schoolenterprise.fullenterprac }"></div></td>
    </tr>
    <tr >
      <th scope="row">专任教师人均企业实习实践时间（天）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="fullentertime" value="${schoolenterprise.fullentertime }"></div></td>
    </tr> --%>
  </tbody>
    </table>
    
</div>
<div class="id_29" style="clear:both">
   <input id="back" class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=4&year=${schoolenterprise.year }'" value="返回">	
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