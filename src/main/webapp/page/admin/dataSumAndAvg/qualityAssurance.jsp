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
           <div class="id_13"><span>质量保证措施</span><i></i><a>专业布局总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">一产类专业数</th>
          <th style="text-align:center;">二产类专业数</th>
          <th style="text-align:center;">三产类专业数</th>         
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty majorLayoutSumListPageInfo }">  
                <c:forEach items="${majorLayoutSumListPageInfo.list}" var="majorLayout">  
                    <tr class="id_24">  
                        <td>${majorLayout.admcode}</td>  
                        <td>${majorLayout.year}</td>                       
                        <td>${majorLayout.oneIndu}</td>
                        <td>${majorLayout.twoIndu}</td>
                        <td>${majorLayout.threeIndu}</td>                                                                                                   
                                                                                                                            
                        <td>                  
                            <a href="<%=basePath%>dataSumAndAvgDetail/getMajorLayoutSum?admcode=${majorLayout.admcode}&year=${majorLayout.year}" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayout=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayout=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayout=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayout=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayout=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayout=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>质量保证措施</span><i></i><a>专业布局平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">一产类专业数</th>
          <th style="text-align:center;">二产类专业数</th>
          <th style="text-align:center;">三产类专业数</th>         
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty majorLayoutAvgListPageInfo }">  
                <c:forEach items="${majorLayoutAvgListPageInfo.list}" var="majorLayoutAvg">  
                    <tr class="id_24">  
                        <td>${majorLayoutAvg.admcode}</td>  
                        <td>${majorLayoutAvg.year}</td>                       
                        <td>${majorLayoutAvg.oneIndu}</td>
                        <td>${majorLayoutAvg.twoIndu}</td>
                        <td>${majorLayoutAvg.threeIndu}</td>
                                                                                                   
                                                                                                                            
                        <td>                  
                            <a href="<%=basePath%>dataSumAndAvgDetail/getMajorLayoutAvg?admcode=${majorLayoutAvg.admcode}&year=${majorLayoutAvg.year}" class="id_23">更多</a>  
                        </td> 
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayoutAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayoutAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayoutAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayoutAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayoutAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorLayoutAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>质量保证措施</span><i></i><a>课程开设总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">已制定课程标准数</th>
          <th style="text-align:center;">牵头开发国家共建共享计划课程数</th>
          <th style="text-align:center;">教师参编公开出版的教材数</th>  
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty majorNumSumListPageInfo }">  
                <c:forEach items="${majorNumSumListPageInfo.list}" var="majorNum">  
                    <tr class="id_24">  
                        <td>${majorNum.admcode}</td>  
                        <td>${majorNum.year}</td>                       
                        <td>${majorNum.classCriter}</td>
                        <td>${majorNum.leadNatShareMajor}</td>
                        <td>${majorNum.textTeacEditMajor}</td>                                                                                                    
                                                                  
                        <td>                      
                            <a href="<%=basePath%>dataSumAndAvgDetail/getMajorNumSum?admcode=${majorNum.admcode}&year=${majorNum.year}" class="id_23">更多</a>  
                        </td> 
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNum=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNum=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNum=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNum=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNum=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNum=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>质量保证措施</span><i></i><a>课程开设平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">已制定课程标准数</th>
          <th style="text-align:center;">牵头开发国家共建共享计划课程数</th>
          <th style="text-align:center;">教师参编公开出版的教材数</th>  
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty majorNumAvgListPageInfo }">  
                <c:forEach items="${majorNumAvgListPageInfo.list}" var="majorNumAvg">  
                    <tr class="id_24">  
                        <td>${majorNumAvg.admcode}</td>  
                        <td>${majorNumAvg.year}</td>                       
                        <td>${majorNumAvg.classCriter}</td>
                        <td>${majorNumAvg.leadNatShareMajor}</td>
                        <td>${majorNumAvg.textTeacEditMajor}</td>                                                                                                    
                                                                  
                        <td>                      
                            <a href="<%=basePath%>dataSumAndAvgDetail/getMajorNumAvg?admcode=${majorNumAvg.admcode}&year=${majorNumAvg.year}" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNumAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNumAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNumAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNumAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNumAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnMajorNumAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>质量保证措施</span><i></i><a>质量保证总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">校领导听课人均课时数</th>
          <th style="text-align:center;">校领导上课课人均课时数</th>
          <th style="text-align:center;">参加国家级技能大赛人数</th>
          <th style="text-align:center;">参加省级技能大赛人数</th>         
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty qualityAssuranceSumListPageInfo }">  
                <c:forEach items="${qualityAssuranceSumListPageInfo.list}" var="qualityAssurance">  
                   <tr class="id_24">  
                        <td>${qualityAssurance.admcode}</td>  
                        <td>${qualityAssurance.year}</td>                       
                        <td>${qualityAssurance.leaderListen}</td>
                        <td>${qualityAssurance.leaderTalk}</td>
                        <td>${qualityAssurance.stateSkillWinTime}</td>
                        <td>${qualityAssurance.provinSkillWinTime}</td>                                                                                                                         
                                                                                                               
                        <td>                        
                            <a href="<%=basePath%>dataSumAndAvgDetail/getQualityAssuranceSum?admcode=${qualityAssurance.admcode}&year=${qualityAssurance.year}" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssurance=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssurance=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssurance=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssurance=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssurance=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssurance=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>质量保证措施</span><i></i><a>质量保证平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">校领导听课人均课时数</th>
          <th style="text-align:center;">校领导上课课人均课时数</th>
          <th style="text-align:center;">参加国家级技能大赛人数</th>
          <th style="text-align:center;">参加省级技能大赛人数</th>         
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty qualityAssuranceAvgListPageInfo }">  
                <c:forEach items="${qualityAssuranceAvgListPageInfo.list}" var="qualityAssuranceAvg">  
                   <tr class="id_24">  
                        <td>${qualityAssuranceAvg.admcode}</td>  
                        <td>${qualityAssuranceAvg.year}</td>                       
                        <td>${qualityAssuranceAvg.leaderListen}</td>
                        <td>${qualityAssuranceAvg.leaderTalk}</td>
                        <td>${qualityAssuranceAvg.stateSkillWinTime}</td>
                        <td>${qualityAssuranceAvg.provinSkillWinTime}</td>                                                                                                                         
                                                                                                               
                        <td>                        
                            <a href="<%=basePath%>dataSumAndAvgDetail/getQualityAssuranceAvg?admcode=${qualityAssuranceAvg.admcode}&year=${qualityAssuranceAvg.year}" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssuranceAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssuranceAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssuranceAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssuranceAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssuranceAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnQualityAssuranceAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>质量保证措施</span><i></i><a>教师培养培训总和</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">参加国家级培训专任教师数</th>
          <th style="text-align:center;">参加区县级培训专任教师数</th>
          <th style="text-align:center;">参加市级培训专任教师数</th>
          <th style="text-align:center;">参加省级培训专任教师数</th>   
          
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty educationTrainSumListPageInfo }">  
                <c:forEach items="${educationTrainSumListPageInfo.list}" var="educationTrain">  
                   <tr class="id_24">  
                        <td>${educationTrain.admcode}</td>  
                        <td>${educationTrain.year}</td>                       
                        <td>${educationTrain.stateTrainFullTea}</td>
                        <td>${educationTrain.distTrainFullTea}</td>
                        <td>${educationTrain.cityTrainFullTea}</td>
                        <td>${educationTrain.provinTrainFullTea}</td>                                                                                                   
                                                                                        
                        <td>                      
                           <a href="<%=basePath%>dataSumAndAvgDetail/getEducationTrainSum?admcode=${educationTrain.admcode}&year=${educationTrain.year}" class="id_23">更多</a>  
                        </td>   
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrain=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrain=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrain=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrain=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrain=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrain=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>质量保证措施</span><i></i><a>教师培养培训平均值</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">参加国家级培训专任教师数</th>
          <th style="text-align:center;">参加区县级培训专任教师数</th>
          <th style="text-align:center;">参加市级培训专任教师数</th>
          <th style="text-align:center;">参加省级培训专任教师数</th>   
          
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty educationTrainAvgListPageInfo }">  
                <c:forEach items="${educationTrainAvgListPageInfo.list}" var="educationTrainAvg">  
                   <tr class="id_24">  
                        <td>${educationTrainAvg.admcode}</td>  
                        <td>${educationTrainAvg.year}</td>                       
                        <td>${educationTrainAvg.stateTrainFullTea}</td>
                        <td>${educationTrainAvg.distTrainFullTea}</td>
                        <td>${educationTrainAvg.cityTrainFullTea}</td>
                        <td>${educationTrainAvg.provinTrainFullTea}</td>                                                                                                   
                                                                                        
                        <td>                      
                            <a href="<%=basePath%>dataSumAndAvgDetail/getEducationTrainAvg?admcode=${educationTrainAvg.admcode}&year=${educationTrainAvg.year}" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrainAvg=1&years=${yearCode}&types=${typeCode}">首页</a></li> 
				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrainAvg=1&years=${yearCode}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>			
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrainAvg=1&years=${yearCode}&types=${typeCode}">1</a></li>		
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrainAvg=2&years=${yearCode}&types=${typeCode}">2</a></li>
		
			 				
		<li> 
			<a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrainAvg=2&years=${yearCode}&types=${typeCode}" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span> 
			</a> 
		</li>
				
		<li><a href="<%=basePath%>dataSumAndAvg/getDataSumAndAvg?pnEducationTrainAvg=2&years=${yearCode}&types=${typeCode}">末页</a></li> 
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