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
<!-- 最新版本的 Bootstrap 核心 CSS 文件 --> 
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<!-- 可选的 Bootstrap 主题文件（一般不用引入） --> 
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous"> 
<link href="<%=basePath%>/css/sjcj.css" rel="stylesheet" type="text/css">  
<script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>/js/jquery.placeholder.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 --> 
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<script type="text/javascript">
window.onload=function(){
	//设置年份的选择
	var myDate= new Date();
	var startYear=myDate.getFullYear();//起始年份
	var endYear=myDate.getFullYear()-30;//结束年份
	var obj=document.getElementById('year');
	for (var i=startYear;i>=endYear;i--)
	{
	obj.options.add(new Option(i,i));
	}	
};

function findYear(){ 
	$('#tn').val($('#type option:selected').text());
	
    var form = document.getElementById("myForm");    
    form.action = "<%=basePath%>dataSumAndAvg/getDataSumAndAvg";    
    form.method="post";    
    form.submit();   
}

</script>
</head>
<body>
<!-- 顶部 -->
<%@ include file="/page/top.jsp" %>  
<!--左边导航栏-->
<%@ include file="/page/aLeft.jsp" %> 
<!--右边内容区-->
<div id="id_11">

<div class="id_12" >
<form  id="myForm" method="post">
<div class="id_14">
                <div>                               					          						
					<span id="ctl00_content_Label1">选择内容</span>
					
					<select class="id_28" id="type" name="type">
						<c:choose>
							<c:when test="${typeCode eq '1'}">
								<option value="1">基本情况</option>
							</c:when>
							<c:when test="${typeCode eq null}">
								<option value="1">基本情况</option>
							</c:when>
							<c:otherwise>
								<option value="${typeCode}"><%=session.getAttribute("tn") %></option>
							</c:otherwise>
						</c:choose>							
								<option value="1">基本情况</option>
								<option value="2">学生发展</option>
								<option value="3">质量保障措施</option>
								<option value="4">校企合作</option>
								<option value="5">社会贡献</option>
								<option value="6">举办者履职</option>
								<option value="7">党建工作</option>
																						
					</select>
					<input type="hidden" id="tn"  name="tn"/>
					
					<span id="ct">年份</span>
					<select class="id_28" id="year" name="year" >						
							<c:if test="${yearCode!=null}">
								<option value="${yearCode}">${yearCode}</option>
							</c:if>															
					</select>
																			
					<input type="submit" onclick="findYear()" value="查询"  class="id_31" />
			</div>
 	  </div>
</form>		
</div>
<!--表格区-->
<div class="id_21">
           <div class="id_13"><span>学生发展</span><i></i><a>学生素质总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
    <thead>
					<tr>
						<!-- <th style="text-align:center;">选择</th> -->
						<th style="text-align:center;">学校名称</th>
						<th style="text-align:center;">年份</th>
						<th style="text-align:center;">专职德育工作人员</th>
						<th style="text-align:center;">各级德育课题立项数</th>
						<th style="text-align:center;">省级优秀毕业生数</th>
						<th style="text-align:center;">积极申请入党学生数</th>
						<th style="text-align:center;">社会志愿服务活动人次</th>
						<th style="text-align:center;">学生社团数量</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty studentQualitySumListPageInfo }">
						<c:forEach items="${studentQualitySumListPageInfo.list}" var="stud">
							<tr class="id_24">
								<td>${stud.admcode}</td>
								<td>${stud.year}</td>
								<td><fmt:formatNumber type="number" value="${stud.fulltimemoral }" maxFractionDigits="0" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${stud.moraltask }" maxFractionDigits="0" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${stud.provgoodgrade }" maxFractionDigits="0" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${stud.joinpraty }" maxFractionDigits="0" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${stud.socailvolun }" maxFractionDigits="0" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${stud.studentorgan }" maxFractionDigits="0" groupingUsed="false"/></td>
								
								<td width="150">								
									<a href="<%=basePath%>dataSumAndAvgDetail/getStudSum?admcode=${stud.admcode}&year=${stud.year}" class="id_23">更多</a>
							    </td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQuality=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQuality=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQuality=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQuality=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQuality=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQuality=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>

</div>       
</div>

<div class="id_21">
	<table class="id_22">	
	</table>
</div>

<div class="id_21">
           <div class="id_13"><span>学生发展</span><i></i><a>学生素质平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
    <thead>
					<tr>
						<!-- <th style="text-align:center;">选择</th> -->
						<th style="text-align:center;">学校名称</th>
						<th style="text-align:center;">年份</th>
						<th style="text-align:center;">专职德育工作人员</th>
						<th style="text-align:center;">各级德育课题立项数</th>
						<th style="text-align:center;">省级优秀毕业生数</th>
						<th style="text-align:center;">积极申请入党学生数</th>
						<th style="text-align:center;">社会志愿服务活动人次</th>
						<th style="text-align:center;">学生社团数量</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty studentQualityAvgListPageInfo }">
						<c:forEach items="${studentQualityAvgListPageInfo.list}" var="studAvg">
							<tr class="id_24">
								<td>${studAvg.admcode}</td>
								<td>${studAvg.year}</td>
								
								<td><fmt:formatNumber type="number" value="${studAvg.fulltimemoral }" maxFractionDigits="2" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${studAvg.moraltask }" maxFractionDigits="2" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${studAvg.provgoodgrade }" maxFractionDigits="0" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${studAvg.joinpraty }" maxFractionDigits="2" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${studAvg.socailvolun }" maxFractionDigits="2" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${studAvg.studentorgan }" maxFractionDigits="2" groupingUsed="false"/></td>

								
								<td width="150">								
									<a href="<%=basePath%>dataSumAndAvgDetail/getStudAvg?admcode=${studAvg.admcode}&year=${studAvg.year}" class="id_23">更多</a>
							    </td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQualityAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQualityAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQualityAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQualityAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQualityAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnStudentQualityAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>

</div>       
</div>

<div class="id_21">
	<table class="id_22">	
	</table>
</div>

<div class="id_21">
           <div class="id_13"><span>学生发展</span><i></i><a>在校体验平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
					<tr>
						<!-- <th style="text-align:center;">选择</th> -->
						<th style="text-align:center;">学校名称</th>
						<th style="text-align:center;">年份</th>
						<th style="text-align:center;">理论学习满意度-非常满意</th>
						<th style="text-align:center;">专业学习满意度-非常满意</th>
						<th style="text-align:center;">实习实训满意度-非常满意</th>
						<th style="text-align:center;">校园文化与社团活动满意度-非常满意</th>
						<th style="text-align:center;">生活满意度-非常满意</th>
						<th style="text-align:center;">校园安全满意度-非常满意</th>
						<th style="text-align:center;">毕业生对学校满意度-非常满意</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty experienceAvgListPageInfo }">
						<c:forEach items="${experienceAvgListPageInfo.list}" var="expAvg">
							<tr class="id_24">
								<td>${expAvg.admcode}</td>
								<td>${expAvg.year}</td>
								<td>${expAvg.theorybest}</td>
								<td>${expAvg.majorbest}</td>
								<td>${expAvg.internshipbest}</td>
								<td>${expAvg.campusbest}</td>
								<td>${expAvg.lifebest}</td>
								<td>${expAvg.safetybest}</td>
								<td>${expAvg.graduatebest}</td>

								
								<td width="150">						
									<a href="<%=basePath%>dataSumAndAvgDetail/getExpAvg?admcode=${expAvg.admcode}&year=${expAvg.year}" class="id_23">更多</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnExperienceAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnExperienceAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnExperienceAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnExperienceAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnExperienceAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnExperienceAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
	</ul>
</nav>
</div>

</div>       
</div>

<div class="id_21">
	<table class="id_22">	
	</table>
</div>

<div class="id_21">
           <div class="id_13"><span>学生发展</span><i></i><a>就业质量总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
					<tr>
						<!-- <th style="text-align:center;">选择</th> -->
						<th style="text-align:center;">学校名称</th>
						<th style="text-align:center;">年份</th>
						<th style="text-align:center;">初次就业月平均收入</th>
						<th style="text-align:center;">参军人数</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty employQualitySumListPageInfo }">
						<c:forEach items="${employQualitySumListPageInfo.list}" var="emp">
							<tr class="id_24">
								<td>${emp.admcode}</td>
								<td>${emp.year}</td>
								<td>${emp.firstemploymonincome}</td>
								<td><fmt:formatNumber type="number" value="${emp.soldier}" maxFractionDigits="0" groupingUsed="false"/></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQuality=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQuality=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQuality=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQuality=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQuality=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQuality=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>

</div>       
</div>

<div class="id_21">
	<table class="id_22">	
	</table>
</div>

<div class="id_21">
           <div class="id_13"><span>学生发展</span><i></i><a>就业质量平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
					<tr>
						<!-- <th style="text-align:center;">选择</th> -->
						<th style="text-align:center;">学校名称</th>
						<th style="text-align:center;">年份</th>
						<th style="text-align:center;">毕业生初次就业率</th>
						<th style="text-align:center;">专业对口就业率</th>
						<th style="text-align:center;">顶岗实习半年以上稳定率</th>
						<th style="text-align:center;">初次就业月平均收入</th>
						<th style="text-align:center;">自主创业率</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty employQualityAvgListPageInfo }">
						<c:forEach items="${employQualityAvgListPageInfo.list}" var="empAvg">
							<tr class="id_24">
								<td>${empAvg.admcode}</td>
								<td>${empAvg.year}</td>
								<td>${empAvg.employratefirst}</td>
								<td>${empAvg.coupartemployrate}</td>
								<td>${empAvg.sixmonthsteadrate}</td>
								<td>${empAvg.firstemploymonincome}</td>
								<td>${empAvg.venturerate}</td>

								<td width="150">
									<a href="<%=basePath%>dataSumAndAvgDetail/getEmpAvg?admcode=${empAvg.admcode}&year=${empAvg.year}" class="id_23">更多</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQualityAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQualityAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQualityAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQualityAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQualityAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEmployQualityAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>

</div>       
</div>


		</div>
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