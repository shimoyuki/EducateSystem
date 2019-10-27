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
<script type="text/javascript" src="<%=basePath%>js/internship.js"></script>
<script language="javascript" type="text/javascript">
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
<div class="id_13"><span>校企合作</span><i></i><a href="#">实习情况</a></div>
<div class="id_14">
<!-- <a href="#" class="id_15"></a>
<a href="#" class="id_16"></a>
<a href="#" class="id_17"></a>
<div class="id_18"><input type="text" class="id_19" placeholder="请输入年份查询"><input type="submit" value="" class="id_20"></div> -->
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form id="formInternship" action="<%=basePath%>internship/updateInternship" method="post" >
<div class="id_26" style="float:left">
<table class="id_27">
    <tbody>
   <input type="hidden" name="id" value="${internship.id}"/>
    <tr>
		<th scope="row">年份</th>
		<td><div class="form-group">
			<input type="text" class="form-control" name="year" value="${internship.year }" readonly="readonly">
			</div>
		</td>				
    </tr>
    <tr >
      <th scope="row">校外学生实训基地数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="offcampttrainbase" value="${internship.offcampttrainbase }"></div></td>
    </tr>
    <tr>
      <th scope="row">生均认识实习时长（天）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="kownduration" value="${internship.kownduration }"></div></td>
    </tr>
    <tr>
      <th scope="row">生均跟岗实习时长（天）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="postduration" value="${internship.postduration }"></div></td>
    </tr>
    <tr>
      <th scope="row">生均顶岗实习时长（天）</th>
      <td>
      <div class="form-group">
      	<select class="form-control" name="displaceduration">
 			<option value="90" <c:if test="${internship.displaceduration==90 }"> selected="selected"</c:if>>三个月</option>  
    		<option value="180" <c:if test="${internship.displaceduration==180 }"> selected="selected"</c:if>>半年</option>
    		<option value="365" <c:if test="${internship.displaceduration==365 }"> selected="selected"</c:if>>一年</option> 
      	</select>
     </div>
     </td>
    </tr>
    
    <tr >
      <th scope="row">学生跟岗实习对口率</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stupostpartradio" value="${internship.stupostpartradio }"></div></td>
    </tr>
    <tr >
      <th scope="row">学生顶岗实习对口率</th>
      <td><div class="form-group"><input type="text" class="form-control" name="studispartradio" value="${internship.studispartradio }"></div></td>
    </tr>
  </tbody>
    </table>
</div>
<div class="id_26" style="float:left">
<table class="id_27">
      <tbody>
    <tr >
      <th scope="row">企业对学生顶岗实习考核结果（优秀）比例	</th>
      <td><div class="form-group"><input type="text" class="form-control" name="enterpassessdisopt" value="${internship.enterpassessdisopt }"></div></td>
    </tr>
    <tr >
      <th scope="row">企业对学生顶岗实习考核结果（良好）比例</th>
      <td><div class="form-group"><input type="text" class="form-control" name="enterpassessdisgood" value="${internship.enterpassessdisgood }"></div></td>
    </tr>
    <tr >
      <th scope="row">企业对学生顶岗实习考核结果（合格）比例</th>
      <td><div class="form-group"><input type="text" class="form-control" name="enterpassessdisinter" value="${internship.enterpassessdisinter }"></div></td>
    </tr>
    <tr >
      <th scope="row">企业对学生顶岗实习考核结果（不合格）比例</th>
      <td><div class="form-group"><input type="text" class="form-control" name="enterpassessdisbad" value="${internship.enterpassessdisbad }"></div></td>
    </tr>
    <tr >
      <th scope="row">合作企业接收学生就业比例</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpemploystud" value="${internship.coopenterpemploystud }"></div></td>
    </tr>
    
  </tbody>
    </table>
    </div>
    <div class="id_29" style="clear:both">
   		<c:if test="${detailFlag==0}">                                                
			<input class="id_31" id="submit" class="id_31" type="submit" value="提交">
			<input class="id_31" type="button" onclick="location.href='<%=basePath%>internship/getInternshipList'" value="返回">
		</c:if>
		<c:if test="${detailFlag==1}">                                                
			<input class="id_31" type="button" onclick="location.href='<%=basePath%>internship/getInternshipList'" value="返回">
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