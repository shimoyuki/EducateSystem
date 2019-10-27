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
           <div class="id_13"><span>基本情况</span><i></i><a>规模总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
    <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">学校占地面积（平方米）</th>
          <th style="text-align:center;">自有产权占地面积（平方米）</th>
          <th style="text-align:center;">总建筑面积（平方米）</th>
          <th style="text-align:center;">在校生数</th>
          <th style="text-align:center;">毕业生数</th>
          <th style="text-align:center;">专业数</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty sizeSumListPageInfo }">  
                <c:forEach items="${sizeSumListPageInfo.list}" var="size">  
                   <tr class="id_24">  
                        <td>${size.admcode}</td>  
                        <td>${size.year}</td>
                        <td>${size.area}</td>
                        <td>${size.ownPropArea}</td>
                        <td>${size.totalArea}</td>
                        <td><fmt:formatNumber type="number" value="${size.totalStudent}" maxFractionDigits="0" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${size.annualGraduate}" maxFractionDigits="0" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${size.majors}" maxFractionDigits="0" groupingUsed="false"/></td>                                                                
                                                                                                             
                                                                                                             
                        <td>                        
                            <a href="<%=basePath%>dataSumAndAvgDetail/getSizeSum?admcode=${size.admcode}&year=${size.year}" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>   
</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSize=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSize=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSize=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSize=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSize=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSize=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>基本情况</span><i></i><a>规模平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
    <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">学校占地面积（平方米）</th>
          <th style="text-align:center;">自有产权占地面积（平方米）</th>
          <th style="text-align:center;">总建筑面积（平方米）</th>
          <th style="text-align:center;">在校生数</th>
          <th style="text-align:center;">毕业生数</th>
          <th style="text-align:center;">专业数</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty sizeAvgListPageInfo }">  
                <c:forEach items="${sizeAvgListPageInfo.list}" var="sizeAvg">  
                   <tr class="id_24">  
                        <td>${sizeAvg.admcode}</td>  
                        <td>${sizeAvg.year}</td>
                        <td>${sizeAvg.area}</td>
                        <td>${sizeAvg.ownPropArea}</td>
                        <td>${sizeAvg.totalArea}</td>
                        <td><fmt:formatNumber type="number" value="${sizeAvg.totalStudent}" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${sizeAvg.annualGraduate}" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${sizeAvg.majors}" maxFractionDigits="2" groupingUsed="false"/></td>                                                                                     
                                                                                                             
                        <td>                        
                            <a href="<%=basePath%>dataSumAndAvgDetail/getSizeAvg?admcode=${sizeAvg.admcode}&year=${sizeAvg.year}" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>   
</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSizeAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSizeAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSizeAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSizeAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSizeAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSizeAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>基本情况</span><i></i><a>设施设备总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">固定资产总值(万元)</th>
          <th style="text-align:center;">教学设备资产量(万元)</th>
          <th style="text-align:center;">实训设备资产量(万元)</th>
          <th style="text-align:center;">图书馆纸质藏书量(册)</th>
          <th style="text-align:center;">年度新增图数量</th>              
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty equitmentSumListPageInfo }">  
                <c:forEach items="${ equitmentSumListPageInfo.list }" var="equitment">  
                   <tr class="id_24"> 
                        <td>${equitment.admcode}</td>  
                        <td>${equitment.year}</td>                      
                        <td>${equitment.totalAssertWorth}</td>
                        <td>${equitment.teacEquitWorth}</td>
                        <td>${equitment.trainEquitWorth}</td>
                        <td>${equitment.libBooks}</td>
                        <td>${equitment.yearBooks}</td>                      
                                                                
                        <td>
                        <a href="<%=basePath%>dataSumAndAvgDetail/getEquitmentSum?admcode=${equitment.admcode}&year=${equitment.year}" class="id_23">更多</a>    
                        </td>
                     </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
   </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitment=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitment=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitment=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitment=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitment=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitment=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>基本情况</span><i></i><a>设施设备平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">固定资产总值(万元)</th>
          <th style="text-align:center;">教学设备资产量(万元)</th>
          <th style="text-align:center;">实训设备资产量(万元)</th>
          <th style="text-align:center;">图书馆纸质藏书量(册)</th>
          <th style="text-align:center;">年度新增图数量</th>              
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty equitmentAvgListPageInfo }">  
                <c:forEach items="${ equitmentAvgListPageInfo.list }" var="equitmentAvg">  
                   <tr class="id_24"> 
                        <td>${equitmentAvg.admcode}</td>  
                        <td>${equitmentAvg.year}</td>                      
                        <td>${equitmentAvg.totalAssertWorth}</td>
                        <td>${equitmentAvg.teacEquitWorth}</td>
                        <td>${equitmentAvg.trainEquitWorth}</td>
                        <td>${equitmentAvg.libBooks}</td>
                        <td>${equitmentAvg.yearBooks}</td>                      
                                                                
                        <td>
                       <a href="<%=basePath%>dataSumAndAvgDetail/getEquitmentAvg?admcode=${equitmentAvg.admcode}&year=${equitmentAvg.year}" class="id_23">更多</a>    
                        </td>
                     </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
   </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitmentAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitmentAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitmentAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitmentAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitmentAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEquitmentAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>基本情况</span><i></i><a>教师队伍总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
					<tr>
						<!-- <th style="text-align:center;">选择</th> -->
						<th style="text-align:center;">学校名称</th>
						<th style="text-align:center;">年份</th>
						<th style="text-align:center;">教职工总人数</th>
						<th style="text-align:center;">在编教职工数</th>
						<th style="text-align:center;">专任教师数</th>
						<th style="text-align:center;">其中公共基础课专任教师数</th>
						<th style="text-align:center;">其中专业课专任教师数</th>
						<th style="text-align:center;">行业企业兼职教师数</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty teachersSumListPageInfo }">
					<c:forEach items="${ teachersSumListPageInfo.list }" var="teac"> 
							<tr class="id_24">								
								<td>${teac.admcode}</td>
								<td>${teac.year}</td>
								<td><fmt:formatNumber type="number" value="${teac.staffnum}" maxFractionDigits="0" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${teac.staffprepjob}" maxFractionDigits="0" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${teac.fulltime}" maxFractionDigits="0" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${teac.basiccourse}" maxFractionDigits="0" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${teac.course}" maxFractionDigits="0" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${teac.industryenterprise}" maxFractionDigits="0" groupingUsed="false"/></td>

		
								<td width="150">
									 <a href="<%=basePath%>dataSumAndAvgDetail/getTeachersSum?admcode=${teac.admcode}&year=${teac.year}" class="id_23">更多</a>    
                       		    </td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachers=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachers=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachers=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachers=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachers=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachers=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>基本情况</span><i></i><a>教师队伍平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
					<tr>
						<!-- <th style="text-align:center;">选择</th> -->
						<th style="text-align:center;">学校名称</th>
						<th style="text-align:center;">年份</th>
						<th style="text-align:center;">教职工总人数</th>
						<th style="text-align:center;">在编教职工数</th>
						<th style="text-align:center;">专任教师数</th>
						<th style="text-align:center;">其中公共基础课专任教师数</th>
						<th style="text-align:center;">其中专业课专任教师数</th>
						<th style="text-align:center;">行业企业兼职教师数</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty teachersAvgListPageInfo }">
					<c:forEach items="${ teachersAvgListPageInfo.list }" var="teacAvg"> 
							<tr class="id_24">								
							    <td>${teacAvg.admcode}</td>
								<td>${teacAvg.year}</td>
								<td><fmt:formatNumber type="number" value="${teacAvg.staffnum}" maxFractionDigits="2" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${teacAvg.staffprepjob}" maxFractionDigits="2" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${teacAvg.fulltime}" maxFractionDigits="2" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${teacAvg.basiccourse}" maxFractionDigits="2" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${teacAvg.course}" maxFractionDigits="2" groupingUsed="false"/></td>
								<td><fmt:formatNumber type="number" value="${teacAvg.industryenterprise}" maxFractionDigits="2" groupingUsed="false"/></td>

		
								<td width="150">
									  <a href="<%=basePath%>dataSumAndAvgDetail/getTeachersAvg?admcode=${teacAvg.admcode}&year=${teacAvg.year}" class="id_23">更多</a>    
                       		    </td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachersAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachersAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachersAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachersAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachersAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnTeachersAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>基本情况</span><i></i><a>信息化建设总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
					<tr>
						<th style="text-align:center;">学校名称</th>
						<th style="text-align:center;">年份</th>
						<!-- <th style="text-align:center;">服务器台数</th> -->
						<th style="text-align:center;">校园网络出口总带宽(bps)</th>
						<th style="text-align:center;">校园网主干带宽(bps)</th>
						<th style="text-align:center;">教学用计算机台数</th>
						<th style="text-align:center;">生均教学用计算机台数</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty informationSumListPageInfo }">
					 <c:forEach items="${ informationSumListPageInfo.list }" var="info">						
							<tr class="id_24">								
								<td>${info.admcode}</td>
								<td>${info.year}</td>
								<%-- <td>${info.server}</td> --%>
								<td>${info.networknum}</td>
								<td>${info.networkmain}</td>
								<td>${info.teaccomputer}</td>
								<td>${info.teaccompstu}</td>
								
								<td width="150">
									 <a href="<%=basePath%>dataSumAndAvgDetail/getInformationSum?admcode=${info.admcode}&year=${info.year}" class="id_23">更多</a>    
                       		    </td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformation=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformation=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformation=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformation=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformation=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformation=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>基本情况</span><i></i><a>信息化建设平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
					<tr>
						<th style="text-align:center;">学校名称</th>
						<th style="text-align:center;">年份</th>
						<!-- <th style="text-align:center;">服务器台数</th> -->
						<th style="text-align:center;">校园网络出口总带宽(bps)</th>
						<th style="text-align:center;">校园网主干带宽(bps)</th>
						<th style="text-align:center;">教学用计算机台数</th>
						<th style="text-align:center;">生均教学用计算机台数</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty informationAvgListPageInfo }">
					 <c:forEach items="${ informationAvgListPageInfo.list }" var="infoAvg">						
							<tr class="id_24">								
								<td>${infoAvg.admcode}</td>
								<td>${infoAvg.year}</td>
								<%-- <td>${infoAvg.server}</td> --%>
								<td>${infoAvg.networknum}</td>
								<td>${infoAvg.networkmain}</td>
								<td>${infoAvg.teaccomputer}</td>
								<td>${infoAvg.teaccompstu}</td>
								
								<td width="150">
									 <a href="<%=basePath%>dataSumAndAvgDetail/getInformationAvg?admcode=${infoAvg.admcode}&year=${infoAvg.year}" class="id_23">更多</a>    
                       		    </td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformationAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformationAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformationAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformationAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformationAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInformationAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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