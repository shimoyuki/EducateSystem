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
           <div class="id_13"><span>举办者履职</span><i></i><a>经费总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1" id="ctl00_content_GridView3" style="border-collapse:collapse;">
      <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">中央财政投入经费（万元）</th>
          <th style="text-align:center;">地方财政投入经费（万元）</th>
          <th style="text-align:center;">生均拨款（元）</th>  
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty fundsSumListPageInfo }">  
                <c:forEach items="${fundsSumListPageInfo.list}" var="funds">  
                    <tr class="id_24">  
                        <td>${funds.admcode}</td>  
                        <td>${funds.year}</td>                       
                        <td>${funds.centerFund}</td>
                        <td>${funds.localFund}</td>
                        <td>${funds.appropriation}</td>                                                                                                   
                                                                                                       
                        <td>                       
                            <a href="<%=basePath%>dataSumAndAvgDetail/getFundsSum?admcode=${funds.admcode}&year=${funds.year}" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
   </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFunds=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFunds=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFunds=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFunds=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFunds=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFunds=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>举办者履职</span><i></i><a>经费平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1" id="ctl00_content_GridView3" style="border-collapse:collapse;">
      <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">中央财政投入经费（万元）</th>
          <th style="text-align:center;">地方财政投入经费（万元）</th>
          <th style="text-align:center;">生均拨款（元）</th>  
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty fundsAvgListPageInfo}">  
                <c:forEach items="${fundsAvgListPageInfo.list}" var="fundsAvg">  
                    <tr class="id_24">  
                        <td>${fundsAvg.admcode}</td>  
                        <td>${fundsAvg.year}</td>                       
                        <td>${fundsAvg.centerFund}</td>
                        <td>${fundsAvg.localFund}</td>
                        <td>${fundsAvg.appropriation}</td>                                                                                                   
                                                                                                       
                        <td>                       
                            <a href="<%=basePath%>dataSumAndAvgDetail/getFundsAvg?admcode=${fundsAvg.admcode}&year=${fundsAvg.year}" class="id_23">更多</a>  
                        </td>   
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
   </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFundsAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFundsAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFundsAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFundsAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFundsAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnFundsAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
<div class="id_13"><span>举办者履职</span><i></i><a>政策措施总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1" id="ctl00_content_GridView3" style="border-collapse:collapse;">
      <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">年度新增教师编制数</th>         
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty policySumListPageInfo }">  
                <c:forEach items="${policySumListPageInfo.list}" var="policy">  
                    <tr class="id_24"> 
                        <td>${policy.admcode}</td>  
                        <td>${policy.year}</td>                       
                        <td>${policy.teacher}</td>                                                                                                                                                                                                                                                        
                        
                     </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
   </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicy=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicy=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicy=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicy=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicy=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicy=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
<div class="id_13"><span>举办者履职</span><i></i><a>政策措施平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1" id="ctl00_content_GridView3" style="border-collapse:collapse;">
      <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">年度新增教师编制数</th>         
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty policyAvgListPageInfo }">  
                <c:forEach items="${policyAvgListPageInfo.list}" var="policyAvg">  
                    <tr class="id_24"> 
                        <td>${policyAvg.admcode}</td>  
                        <td>${policyAvg.year}</td>                       
                        <td>${policyAvg.teacher}</td>                                                                                                                                                                                                                                                        
                         
                     </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
   </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicyAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicyAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicyAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicyAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicyAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnPolicyAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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