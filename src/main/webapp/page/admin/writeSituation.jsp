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
<!-- 最新的 Bootstrap 核心 JavaScript 文件 --> 
<link href="<%=basePath%>/css/sjcj.css" rel="stylesheet" type="text/css">  
<script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>/js/jquery.placeholder.min.js"></script>
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
	
    var form = document.getElementById("myForm");    
    form.action = "<%=basePath%>writeSituation/getWriteSituation";    
    form.method="post";    
    form.submit();  
}
 

</script>
</head>
<body>
<%@ include file="/page/top.jsp" %>	  
<!--左边导航栏-->
<%@ include file="/page/aLeft.jsp" %> 
<!--右边内容区-->
<div id="id_11">
<!--添加删除修改-->
<div class="id_12">
			<div class="id_13">
				<span>系统管理</span><i></i><a href="<%=basePath%>writeSituation/getWriteSituation">填报情况</a>
			</div>
			<form id="myForm" method="POST">
				<div class="id_14">
                <div>
                    <span id="ctl00_content_Label1">年份</span>
							<select class="id_28" id="year" name="year" >						
								<c:if test="${year != ''&&year != null}">
									<option value="${year}">${year}</option>
								</c:if>						
							</select>
					<span id="ctl00_content_Label2">学校</span>
					  <c:if test="${schoolName eq null||schoolName eq ''}">
						<input type="text" class="id_28" id="schoolName" name="schoolName" placeholder="请输入学校名称查询">
					  </c:if>
					  <c:if test="${schoolName != null&&schoolName != ''}">
						<input type="text" class="id_28" id="schoolName" name="schoolName" value="${schoolName}">
					  </c:if>													
					<input type="submit" onclick="find()" value="查询"  class="id_31" />      
			    </div>
 	          </div>			
			</form>
</div>
<!--表格区-->
<div class="id_21">
<table class="id_22">
      <thead>
        			<tr>      
         				<th style="text-align:center;">学校名称</th>
		 				<th style="text-align:center;">年份</th>
						<th style="text-align:center;">未填报</th>
						<th style="text-align:center;">未审核</th>
						<th style="text-align:center;">已审核</th>
						<th style="text-align:center;">操作</th>
       				 </tr>
      </thead>
      <tbody>
           <c:if test="${!empty writeSituationPageInfo }">  
                <c:forEach items="${writeSituationPageInfo.list}" var="writeSituation">
							<tr>
								<td>${writeSituation.schoolName}</td>
								<td>${writeSituation.year}</td>
								<td>${writeSituation.emptys}/20</td>
								<td>${writeSituation.zero}/20</td>
								<td>${writeSituation.one}/20</td>
								<td>
								<a href="<%=basePath%>writeSituation/getWriteSituationDetail?year=${writeSituation.year}&schoolName=${writeSituation.schoolName}"
									class="id_23">更多</a>
								</td>
							</tr>
				</c:forEach>
            </c:if> 
      </tbody>
    </table>
</div>

<%-- <div style="float:left;" >
当前记录数${writeSituationPageInfo.pageNum}页，总${writeSituationPageInfo.pages}页,总${writeSituationPageInfo.total}条记录
</div>  --%> 

<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>writeSituation/getWriteSituation?pn=1&years=${year}&schoolNames=${schoolName}">首页</a></li> 
		
		<c:if test="${writeSituationPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>writeSituation/getWriteSituation?pn=${writeSituationPageInfo.pageNum-1}&years=${year}&schoolNames=${schoolName}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>
				
		<c:forEach items="${writeSituationPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==writeSituationPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=writeSituationPageInfo.pageNum}">
			<li><a href="<%=basePath%>writeSituation/getWriteSituation?pn=${pageNum}&years=${year}&schoolNames=${schoolName}">${pageNum}</a></li> 
			</c:if>
		</c:forEach> 
		
		<c:if test="${writeSituationPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>writeSituation/getWriteSituation?pn=${writeSituationPageInfo.pageNum+1}&years=${year}&schoolNames=${schoolName}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>writeSituation/getWriteSituation?pn=${writeSituationPageInfo.pages}&years=${year}&schoolNames=${schoolName}">末页</a></li> 
	</ul> 
</nav>
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