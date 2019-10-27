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
           <div class="id_13"><span>校企合作</span><i></i><a>合作情况总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">校企合作覆盖专业数</th>
          <th style="text-align:center;">签订合作协议的企业数</th>
          <th style="text-align:center;">签订合作协议的专业数</th>
          <th style="text-align:center;">合作企业参与教学的专业数</th>
          <th style="text-align:center;">合作企业参与教学的教师数</th>   
          <th style="text-align:center;">合作企业参与教学课时数</th>              
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty schoolenterpriseSumListPageInfo }">  
                <c:forEach items="${schoolenterpriseSumListPageInfo.list}" var="schoolenterprise">  
                    <tr class="id_24">  
                        <td>${schoolenterprise.admcode}</td>  
                        <td>${schoolenterprise.year}</td>   
                        
                         <td><fmt:formatNumber type="number" value="${schoolenterprise.majornum }" maxFractionDigits="0" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${schoolenterprise.coopagreeenterp }" maxFractionDigits="0" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${schoolenterprise.coopagreemajor }" maxFractionDigits="0" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${schoolenterprise.coopenterpjointeachmajor }" maxFractionDigits="0" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${schoolenterprise.coopenterpjointeachteacher }" maxFractionDigits="0" groupingUsed="false"/></td>                    
                        <td><fmt:formatNumber type="number" value="${schoolenterprise.coopenterpjointeachclass }" maxFractionDigits="0" groupingUsed="false"/></td>
                                                                
                        <td>                     
                            <a href="<%=basePath%>dataSumAndAvgDetail/getSchoolEnterpriseSum?admcode=${schoolenterprise.admcode}&year=${schoolenterprise.year}" class="id_23">更多</a>
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterprise=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterprise=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterprise=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterprise=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterprise=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterprise=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>校企合作</span><i></i><a>合作情况平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">校企合作覆盖专业数</th>
          <th style="text-align:center;">签订合作协议的企业数</th>
          <th style="text-align:center;">签订合作协议的专业数</th>
          <th style="text-align:center;">合作企业参与教学的专业数</th>
          <th style="text-align:center;">合作企业参与教学的教师数</th>   
          <th style="text-align:center;">合作企业参与教学课时数</th>              
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty schoolenterpriseAvgListPageInfo }">  
                <c:forEach items="${schoolenterpriseAvgListPageInfo.list}" var="schoolenterpriseAvg">  
                    <tr class="id_24">  
                        <td>${schoolenterpriseAvg.admcode}</td>  
                        <td>${schoolenterpriseAvg.year}</td>                       
                        
                         <td><fmt:formatNumber type="number" value="${schoolenterpriseAvg.majornum }" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${schoolenterpriseAvg.coopagreeenterp }" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${schoolenterpriseAvg.coopagreemajor }" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${schoolenterpriseAvg.coopenterpjointeachmajor }" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${schoolenterpriseAvg.coopenterpjointeachteacher }" maxFractionDigits="2" groupingUsed="false"/></td>                    
                        <td><fmt:formatNumber type="number" value="${schoolenterpriseAvg.coopenterpjointeachclass }" maxFractionDigits="2" groupingUsed="false"/></td>
                                                                
                        <td>                     
                            <a href="<%=basePath%>dataSumAndAvgDetail/getSchoolEnterpriseAvg?admcode=${schoolenterpriseAvg.admcode}&year=${schoolenterpriseAvg.year}" class="id_23">更多</a>
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterpriseAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterpriseAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterpriseAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterpriseAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterpriseAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnSchoolenterpriseAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>校企合作</span><i></i><a>学生实习情况总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">校外学生实训基地数</th>
          <th style="text-align:center;">平均认识实习时长</th>
          <th style="text-align:center;">平均跟岗实习时长</th>
          <th style="text-align:center;">平均顶岗实习时长</th>
                         
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty internshipSumListPageInfo }">  
                <c:forEach items="${internshipSumListPageInfo.list}" var="schoolenterprise">  
                    <tr class="id_24">  
                        <td>${schoolenterprise.admcode}</td>  
                        <td>${schoolenterprise.year}</td>                       
                        <td>${schoolenterprise.offcampttrainbase}</td>
                        <td>${schoolenterprise.kownduration}</td>
                        <td>${schoolenterprise.postduration}</td>                      
                        <td>${schoolenterprise.displaceduration}</td>
                                                                            
                        <%-- <td>                         	
                        <a href="<%=basePath%>dataSumAndAvgDetail/getInternshipSum?admcode=${schoolenterprise.admcode}&year=${schoolenterprise.year}" class="id_23">更多</a>
                        </td> --%>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternship=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternship=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternship=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternship=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternship=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternship=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>校企合作</span><i></i><a>学生实习情况平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">校外学生实训基地数</th>
          <th style="text-align:center;">平均认识实习时长</th>
          <th style="text-align:center;">平均跟岗实习时长</th>
          <th style="text-align:center;">平均顶岗实习时长</th>
          <th style="text-align:center;">学生跟岗实习对口率</th>   
          <th style="text-align:center;">学生顶岗实习对口率</th>                        
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty internshipAvgListPageInfo }">  
                <c:forEach items="${ internshipAvgListPageInfo.list }" var="schoolenterpriseAvg">  
                    <tr class="id_24">  
                        <td>${schoolenterpriseAvg.admcode}</td>  
                        <td>${schoolenterpriseAvg.year}</td>                       
                        <td><fmt:formatNumber type="number" value="${schoolenterpriseAvg.offcampttrainbase }" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${schoolenterpriseAvg.kownduration }" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${schoolenterpriseAvg.postduration }" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${schoolenterpriseAvg.displaceduration }" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td>${schoolenterpriseAvg.stupostpartradio}</td>
                        <td>${schoolenterpriseAvg.studispartradio}</td>                                                           
                        <td>                         	
                            <a href="<%=basePath%>dataSumAndAvgDetail/getInternshipAvg?admcode=${schoolenterpriseAvg.admcode}&year=${schoolenterpriseAvg.year}" class="id_23">更多</a>
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternshipAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternshipAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternshipAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternshipAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternshipAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnInternshipAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>校企合作</span><i></i><a>集团化办学情况总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">本校牵头组织的职教集团数</th>
          <th style="text-align:center;">参加本校牵头的职教集团学校数</th>
          <th style="text-align:center;">本校参与的职教集团数</th>
          <th style="text-align:center;">参加本校牵头的职教集团企业数</th>
          <th style="text-align:center;">参加本校牵头的职教集团专业数</th>             
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty groupschoolSumListPageInfo }">  
                <c:forEach items="${groupschoolSumListPageInfo.list}" var="groupschool">  
                   <tr class="id_24">  
                        <td>${groupschool.admcode}</td>  
                        <td>${groupschool.year}</td>                        
                        
                        <td><fmt:formatNumber type="number" value="${groupschool.leadvocedugroup}" maxFractionDigits="0" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${groupschool.joinleadvocedugroupscho}" maxFractionDigits="0" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${groupschool.joinvocedugroup}" maxFractionDigits="0" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${groupschool.joinleadvocedugroupenterp}" maxFractionDigits="0" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${groupschool.joinleadvocedugroupmajor}" maxFractionDigits="0" groupingUsed="false"/></td>
                                                                                        
                        <td>                        
                             <a href="<%=basePath%>dataSumAndAvgDetail/getGroupSchoolSum?admcode=${groupschool.admcode}&year=${groupschool.year}" class="id_23">更多</a>
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschool=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschool=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschool=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschool=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschool=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschool=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>校企合作</span><i></i><a>集团化办学情况平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">本校牵头组织的职教集团数</th>
          <th style="text-align:center;">参加本校牵头的职教集团学校数</th>
          <th style="text-align:center;">本校参与的职教集团数</th>
          <th style="text-align:center;">参加本校牵头的职教集团企业数</th>
          <th style="text-align:center;">参加本校牵头的职教集团专业数</th>             
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty groupschoolAvgListPageInfo }">  
                <c:forEach items="${ groupschoolAvgListPageInfo.list }" var="groupschoolAvg">  
                   <tr class="id_24">  
                        <td>${groupschoolAvg.admcode}</td>  
                        <td>${groupschoolAvg.year}</td>                        
                        
                        <td><fmt:formatNumber type="number" value="${groupschoolAvg.leadvocedugroup}" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${groupschoolAvg.joinleadvocedugroupscho}" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${groupschoolAvg.joinvocedugroup}" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${groupschoolAvg.joinleadvocedugroupenterp}" maxFractionDigits="2" groupingUsed="false"/></td>
                        <td><fmt:formatNumber type="number" value="${groupschoolAvg.joinleadvocedugroupmajor}" maxFractionDigits="2" groupingUsed="false"/></td>
                                                                                        
                        <td>                        
                            <a href="<%=basePath%>dataSumAndAvgDetail/getGroupSchoolAvg?admcode=${groupschoolAvg.admcode}&year=${groupschoolAvg.year}" class="id_23">更多</a>
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschoolAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschoolAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschoolAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschoolAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschoolAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnGroupschoolAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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