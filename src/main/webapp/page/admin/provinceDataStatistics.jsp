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
function findYear(){ 
	$('#tn').val($('#type option:selected').text());
	
    var form = document.getElementById("myForm");    
    form.action = "<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList";    
    form.method="post";    
    form.submit();   
}

function download(){
    var form = document.getElementById("myForm");    
    form.action="<%=basePath%>provinceDataStatistics/download";    
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
								<option value="8">文件查询</option>															
					</select>
					<input type="hidden" id="tn"  name="tn"/>
																																		
					<input type="submit" onclick="findYear()" value="查询"  class="id_31" />
                    <c:if test="${typeCode!=8}">
                    <input type="submit" onclick="download()" value="导出"  class="id_31" />
                    </c:if>
			</div>
 	  </div>
</form>		
</div>
<!--表格区-->
<c:if test="${typeCode eq '1'}">
<div class="id_21">
           <div class="id_13"><span>基本情况</span><i></i><a>规模</a></div>
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
          <th style="text-align:center;">审核</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty sizePageInfo }">  
                <c:forEach items="${sizePageInfo.list}" var="size">  
                   <tr class="id_24">  
                        <td>${size.admcode}</td>  
                        <td>${size.year}</td>
                        <td>${size.area}</td>
                        <td>${size.ownPropArea}</td>
                        <td>${size.totalArea}</td>
                        <td>${size.totalStudent}</td>
                        <td>${size.annualGraduate}</td>
                        <td>${size.majors}</td>                                                                
                        <td>${size.audit=="0"?"未审核":"已审核"}</td>
                                                                                                             
                        <td>                        
                            <a href="<%=basePath%>size/getSize?id=${size.id}&detailFlag=3" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>   
</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSize=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${sizePageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSize=${sizePageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${sizePageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==sizePageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=sizePageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSize=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${sizePageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSize=${sizePageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSize=${sizePageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>基本情况</span><i></i><a>设施设备</a></div>
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
          <th style="text-align:center;">审核</th>          
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty equitmentPageInfo }">  
                <c:forEach items="${ equitmentPageInfo.list }" var="equitment">  
                   <tr class="id_24"> 
                        <td>${equitment.admcode}</td>  
                        <td>${equitment.year}</td>                      
                        <td>${equitment.totalAssertWorth}</td>
                        <td>${equitment.teacEquitWorth}</td>
                        <td>${equitment.trainEquitWorth}</td>
                        <td>${equitment.libBooks}</td>
                        <td>${equitment.yearBooks}</td>                      
                        <c:if test="${equitment.audit==0}">                     
                             <td>未审核</td>
                        </c:if>
                        <c:if test="${equitment.audit==1}">
                             <td>已审核</td>
                        </c:if>                                          
                         <td>
                        <a href="<%=basePath%>Equitment/getEquitment?id=${equitment.id}&detailFlag=3" class="id_23">更多</a>  
                        </td>
                     </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
   </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEquitment=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${equitmentPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEquitment=${equitmentPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${equitmentPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==equitmentPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=equitmentPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEquitment=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${equitmentPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEquitment=${equitmentPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEquitment=${equitmentPageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>基本情况</span><i></i><a>教师队伍</a></div>
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
						<th style="text-align:center;">审核</th>
						<th style="text-align:center;">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty teachersPageInfo }">
					<c:forEach items="${ teachersPageInfo.list }" var="teac"> 
							<tr class="id_24">								
								<td>${teac.admcode}</td>
								<td>${teac.year}</td>
								<td>${teac.staffnum}</td>
								<td>${teac.staffprepjob}</td>
								<td>${teac.fulltime}</td>
								<td>${teac.basiccourse}</td>
								<td>${teac.course}</td>
								<td>${teac.industryenterprise}</td>

								<c:if test="${teac.audit==0}">
									<td width="100">未审核
									<c:if test="${level eq 2 }">
										<a href="#" name="${teac.id}"
											class="audit">通过</a>
									</c:if>
									</td>
								</c:if>
								<c:if test="${teac.audit==1}">
									<td width="100">已审核</td>
									<c:if test="${level eq 2 }">
										<td>通过</td>
									</c:if>
								</c:if>
								<td width="150">
									 <a href="<%=basePath%>teac/showTeacDetail?id=${teac.id}&detailFlag=3" class="id_23">更多</a>
							   </td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnTeachers=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${teachersPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnTeachers=${teachersPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${teachersPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==teachersPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=teachersPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnTeachers=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${teachersPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnTeachers=${teachersPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnTeachers=${teachersPageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>基本情况</span><i></i><a>信息化建设</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
					<tr>
						<th style="text-align:center;">学校名称</th>
						<th style="text-align:center;">年份</th>
						
						<th style="text-align:center;">校园网络出口总带宽(bps)</th>
						<th style="text-align:center;">校园网主干带宽(bps)</th>
						<th style="text-align:center;">教学用计算机台数</th>
						<th style="text-align:center;">生均教学用计算机台数</th>
						<th style="text-align:center;">审核</th>
						<th style="text-align:center;">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty informationPageInfo }">
					 <c:forEach items="${ informationPageInfo.list }" var="info">						
							<tr class="id_24">								
								<td>${info.admcode}</td>
								<td>${info.year}</td>
								
								<td>${info.networknum}</td>
								<td>${info.networkmain}</td>
								<td>${info.teaccomputer}</td>
								<td>${info.teaccompstu}</td>
								<c:if test="${info.audit==0}">
									<td width="100">未审核
									<c:if test="${level eq 2 }">
										<a href="#" name="${info.id}"
											class="audit">通过</a>
									</c:if>
									</td>
								</c:if>
								<c:if test="${info.audit==1}">
									<td width="100">已审核</td>
									<c:if test="${level eq 2 }">
										<td>通过</td>
									</c:if>
								</c:if>
								<td width="150">
									 <a href="<%=basePath%>info/showInfoDetail?id=${info.id}&detailFlag=3" class="id_23">更多</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnInformation=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${informationPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnInformation=${informationPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${informationPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==informationPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=informationPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnInformation=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${informationPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnInformation=${informationPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnInformation=${informationPageInfo.pages}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>

</div>       
</div>

<div class="id_21">
	<table class="id_22">	
	</table>
</div>
</c:if>

<c:if test="${typeCode eq 2}">
<div class="id_21">
           <div class="id_13"><span>学生发展</span><i></i><a>学生素质</a></div>
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
						<th style="text-align:center;">接受心理咨询的学生占比</th>
						<th style="text-align:center;">毕业率</th>
						<th style="text-align:center;">审核</th>
						<th style="text-align:center;">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty studentQualityPageInfo }">
						<c:forEach items="${studentQualityPageInfo.list}" var="stud">
							<tr class="id_24">
								<td>${stud.admcode}</td>
								<td>${stud.year}</td>
								<td>${stud.fulltimemoral}</td>
								<td>${stud.moraltask}</td>
								<td>${stud.provgoodgrade}</td>
								<td>${stud.joinpraty}</td>
								<td>${stud.pyhconselper}</td>
								<td>${stud.gradrate}</td>

								<c:if test="${stud.audit==0}">
									<td width="100">未审核</td>
								</c:if>
								<c:if test="${stud.audit==1}">
									<td width="100">已审核</td>
								</c:if>
								
								<td width="150">								
									<a href="<%=basePath%>stud/showStudDetail?id=${stud.id}&detailFlag=3" class="id_23">更多</a>
							    </td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnStudentQuality=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${studentQualityPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnStudentQuality=${studentQualityPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${studentQualityPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==studentQualityPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=studentQualityPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnStudentQuality=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${studentQualityPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnStudentQuality=${studentQualityPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnStudentQuality=${studentQualityPageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>学生发展</span><i></i><a>在校体验</a></div>
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
						<th style="text-align:center;">审核</th>
						<th style="text-align:center;">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty experiencePageInfo }">
						<c:forEach items="${experiencePageInfo.list}" var="exp">
							<tr class="id_24">
								<td>${exp.admcode}</td>
								<td>${exp.year}</td>
								<td>${exp.theorybest}</td>
								<td>${exp.majorbest}</td>
								<td>${exp.internshipbest}</td>
								<td>${exp.campusbest}</td>
								<td>${exp.lifebest}</td>
								<td>${exp.safetybest}</td>
								<td>${exp.graduatebest}</td>

								<c:if test="${exp.audit==0}">
									<td width="100">未审核</td>
								</c:if>
								<c:if test="${exp.audit==1}">
									<td width="100">已审核</td>
								</c:if>
								
								<td width="150">						
									<a href="<%=basePath%>exp/showExpDetail?id=${exp.id}&detailFlag=3" class="id_23">更多</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnExperience=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${experiencePageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnExperience=${experiencePageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${experiencePageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==experiencePageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=experiencePageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnExperience=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${experiencePageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnExperience=${experiencePageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnExperience=${experiencePageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>学生发展</span><i></i><a>就业质量</a></div>
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
						<th style="text-align:center;">审核</th>
						<th style="text-align:center;">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty employQualityPageInfo }">
						<c:forEach items="${employQualityPageInfo.list}" var="emp">
							<tr class="id_24">
								<td>${emp.admcode}</td>
								<td>${emp.year}</td>
								<td>${emp.employratefirst}</td>
								<td>${emp.coupartemployrate}</td>
								<td>${emp.sixmonthsteadrate}</td>
								<td>${emp.firstemploymonincome}</td>
								<td>${emp.venturerate}</td>

								<c:if test="${emp.audit==0}">
									<td width="100">未审核</td>
								</c:if>
								<c:if test="${emp.audit==1}">
									<td width="100">已审核</td>
								</c:if>
								<td width="150">
									<a href="<%=basePath%>emp/showEmpDetail?id=${emp.id}&detailFlag=3" class="id_23">更多</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEmployQuality=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${employQualityPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEmployQuality=${employQualityPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${employQualityPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==employQualityPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=employQualityPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEmployQuality=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${employQualityPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEmployQuality=${employQualityPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEmployQuality=${employQualityPageInfo.pages}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>

</div>       
</div>

<div class="id_21">
	<table class="id_22">	
	</table>
</div>
</c:if>

<c:if test="${typeCode eq 3}">
<div class="id_21">
           <div class="id_13"><span>质量保证措施</span><i></i><a>专业布局</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">一产类专业数</th>
          <th style="text-align:center;">二产类专业数</th>
          <th style="text-align:center;">三产类专业数</th>
         
          <th style="text-align:center;">审核</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty majorLayoutPageInfo }">  
                <c:forEach items="${majorLayoutPageInfo.list}" var="majorLayout">  
                    <tr class="id_24">  
                        <td>${majorLayout.admcode}</td>  
                        <td>${majorLayout.year}</td>                       
                        <td>${majorLayout.oneIndu}</td>
                        <td>${majorLayout.twoIndu}</td>
                        <td>${majorLayout.threeIndu}</td>
                                                                                                         
                        <td>${majorLayout.audit=="0"?"未审核":"已审核"}</td>                       
                                                                                   
                        <td>                  
                            <a href="<%=basePath%>majorLayout/getMajorLayoutDetail?id=${majorLayout.id}&detailFlag=3" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnMajorLayout=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${majorLayoutPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnMajorLayout=${majorLayoutPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${majorLayoutPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==majorLayoutPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=majorLayoutPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnMajorLayout=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${majorLayoutPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnMajorLayout=${majorLayoutPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnMajorLayout=${majorLayoutPageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>质量保证措施</span><i></i><a>课程开设</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>       
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">已制定课程标准数</th>
          <th style="text-align:center;">牵头开发国家共建共享计划课程数</th>
          <th style="text-align:center;">教师参编公开出版的教材数</th>    
          <th style="text-align:center;">审核</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty MajorNumPageInfo }">  
                <c:forEach items="${MajorNumPageInfo.list}" var="majorNum">  
                    <tr class="id_24">  
                        <td>${majorNum.admcode}</td>  
                        <td>${majorNum.year}</td>                       
                        <td>${majorNum.classCriter}</td>
                        <td>${majorNum.leadNatShareMajor}</td>
                        <td>${majorNum.textTeacEditMajor}</td>                                                                                                 
                        <td>${majorNum.audit=="0"?"未审核":"已审核"}</td>
                                                                                      
                        <td>                      
                            <a href="<%=basePath%>majorNum/getMajorNum?id=${majorNum.id}&detailFlag=3" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnMajorNum=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${MajorNumPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnMajorNum=${MajorNumPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${MajorNumPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==MajorNumPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=MajorNumPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnMajorNum=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${MajorNumPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnMajorNum=${MajorNumPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnMajorNum=${MajorNumPageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>质量保证措施</span><i></i><a>质量保证</a></div>
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
          <th style="text-align:center;">审核</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty qualityAssurancePageInfo }">  
                <c:forEach items="${qualityAssurancePageInfo.list}" var="qualityAssurance">  
                   <tr class="id_24">  
                        <td>${qualityAssurance.admcode}</td>  
                        <td>${qualityAssurance.year}</td>                       
                        <td>${qualityAssurance.leaderListen}</td>
                        <td>${qualityAssurance.leaderTalk}</td>
                        <td>${qualityAssurance.stateSkillWinTime}</td>
                        <td>${qualityAssurance.provinSkillWinTime}</td>                                                                                                   
                        <td>${qualityAssurance.audit=="0"?"未审核":"已审核"}</td>
                                                                                                               
                        <td>                        
                            <a href="<%=basePath%>qualityAssurance/getQualityAssurance?id=${qualityAssurance.id}&detailFlag=3" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnQualityAssurance=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${qualityAssurancePageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnQualityAssurance=${qualityAssurancePageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${qualityAssurancePageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==qualityAssurancePageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=qualityAssurancePageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnQualityAssurance=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${qualityAssurancePageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnQualityAssurance=${qualityAssurancePageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnQualityAssurance=${qualityAssurancePageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>质量保证措施</span><i></i><a>教师培养培训</a></div>
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
          <th style="text-align:center;">审核</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty educationTrainPageInfo }">  
                <c:forEach items="${educationTrainPageInfo.list}" var="educationTrain">  
                   <tr class="id_24">  
                        <td>${educationTrain.admcode}</td>  
                        <td>${educationTrain.year}</td>                       
                        <td>${educationTrain.stateTrainFullTea}</td>
                        <td>${educationTrain.distTrainFullTea}</td>
                        <td>${educationTrain.cityTrainFullTea}</td>
                        <td>${educationTrain.provinTrainFullTea}</td>                                                                                                   
                        <td>${educationTrain.audit=="0"?"未审核":"已审核"}</td>
                                                                                        
                        <td>                      
                            <a href="<%=basePath%>educationTrain/getEducationTrain?id=${educationTrain.id}&detailFlag=3" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEducationTrain=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${educationTrainPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEducationTrain=${educationTrainPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${educationTrainPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==educationTrainPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=educationTrainPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEducationTrain=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${educationTrainPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEducationTrain=${educationTrainPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnEducationTrain=${educationTrainPageInfo.pages}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>

</div>       
</div>

<div class="id_21">
	<table class="id_22">	
	</table>
</div>
</c:if>

<c:if test="${typeCode eq 4}">
<div class="id_21">
           <div class="id_13"><span>校企合作</span><i></i><a>合作情况</a></div>
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
          <th style="text-align:center;">审核</th>          
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty schoolenterprisePageInfo }">  
                <c:forEach items="${ schoolenterprisePageInfo.list }" var="schoolenterprise">  
                    <tr class="id_24">  
                        <td>${schoolenterprise.admcode}</td>  
                        <td>${schoolenterprise.year}</td>                       
                        <td>${schoolenterprise.majornum}</td>
                        <td>${schoolenterprise.coopagreeenterp}</td>
                        <td>${schoolenterprise.coopagreemajor}</td>
                        <td>${schoolenterprise.coopenterpjointeachmajor}</td>
                        <td>${schoolenterprise.coopenterpjointeachteacher}</td>
                        <td>${schoolenterprise.coopenterpjointeachclass}</td>
                        <c:if test="${schoolenterprise.audit==0}">                     
                             <td>未审核</td>
                        </c:if>
                        <c:if test="${schoolenterprise.audit==1}">
                             <td>已审核</td>
                        </c:if>                                          
                        <td>                     
                            <a href="<%=basePath%>schoolenterprise/getSchoolenterprise?id=${schoolenterprise.id}&detailFlag=3" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSchoolenterprise=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${schoolenterprisePageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSchoolenterprise=${schoolenterprisePageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${schoolenterprisePageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==schoolenterprisePageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=schoolenterprisePageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSchoolenterprise=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${schoolenterprisePageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSchoolenterprise=${schoolenterprisePageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSchoolenterprise=${schoolenterprisePageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>校企合作</span><i></i><a>学生实习情况</a></div>
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
          <th style="text-align:center;">审核</th>          
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty internshipPageInfo }">  
                <c:forEach items="${ internshipPageInfo.list }" var="schoolenterprise">  
                    <tr class="id_24">  
                        <td>${schoolenterprise.admcode}</td>  
                        <td>${schoolenterprise.year}</td>                       
                        <td>${schoolenterprise.offcampttrainbase}</td>
                        <td>${schoolenterprise.kownduration}</td>
                        <td>${schoolenterprise.postduration}</td>
                        <td>${schoolenterprise.displaceduration}</td>
                        <td>${schoolenterprise.stupostpartradio}</td>
                        <td>${schoolenterprise.studispartradio}</td>
                        <c:if test="${schoolenterprise.audit==0}">                     
                             <td>未审核</td>
                        </c:if>
                        <c:if test="${schoolenterprise.audit!=0}">
                             <td>已审核</td>
                        </c:if>                                        
                        <td>                         	
                            <a href="<%=basePath%>internship/getInternship?id=${schoolenterprise.id}&detailFlag=3" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnInternship=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${internshipPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnInternship=${internshipPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${internshipPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==internshipPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=internshipPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnInternship=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${internshipPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnInternship=${internshipPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnInternship=${internshipPageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>校企合作</span><i></i><a>集团化办学情况</a></div>
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
          <th style="text-align:center;">审核</th>          
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty groupschoolPageInfo }">  
                <c:forEach items="${ groupschoolPageInfo.list }" var="groupschool">  
                   <tr class="id_24">  
                        <td>${groupschool.admcode}</td>  
                        <td>${groupschool.year}</td>                        
                        <td>${groupschool.leadvocedugroup}</td>
                        <td>${groupschool.joinleadvocedugroupscho}</td>
                        <td>${groupschool.joinvocedugroup}</td>
                        <td>${groupschool.joinleadvocedugroupenterp}</td>
                        <td>${groupschool.joinleadvocedugroupmajor}</td>
                        
                        <c:if test="${groupschool.audit==0}">                     
                             <td>未审核</td>
                        </c:if>
                        <c:if test="${groupschool.audit==1}">
                             <td>已审核</td>
                        </c:if>                                          
                        <td>                        
                            <a href="<%=basePath%>group/getGroupSchool?id=${groupschool.id}&detailFlag=3" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnGroupschool=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${groupschoolPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnGroupschool=${groupschoolPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${groupschoolPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==groupschoolPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=groupschoolPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnGroupschool=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${groupschoolPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnGroupschool=${groupschoolPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnGroupschool=${groupschoolPageInfo.pages}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>

</div>       
</div>

<div class="id_21">
	<table class="id_22">	
	</table>
</div>
</c:if>

<c:if test="${typeCode eq 5}">
<div class="id_21">
           <div class="id_13"><span>社会贡献</span><i></i><a>技术技能人才培养</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
     <thead>
        <tr>      
          				<th style="text-align:center;">学校名称</th>       
         				<th style="text-align:center;">年份</th>
          				<th style="text-align:center;">为当地主要产业培养技术技能人才数</th>
						<th style="text-align:center;">为当地培训技术技能人才数</th>
						<th style="text-align:center;">产生的经济效益和社会效益（万元）</th>
						<th style="text-align:center;">学校师生参与当地产业发展或结构调整技术攻关人数</th>
						<th style="text-align:center;">审核</th>
						<th style="text-align:center;"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty skillTrainPageInfo }">
						<c:forEach items="${skillTrainPageInfo.list}" var="skiTra">
							<tr class="id_24">
								<td>${skiTra.admcode}</td>
								<td>${skiTra.year}</td>
								<td>${skiTra.localfoster}</td>
								<td>${skiTra.localtrain}</td>
								<td>${skiTra.ecnomicsocial}</td>
								<td>${skiTra.trackproblemnum}</td>

								<c:if test="${skiTra.audit==0}">
									<td width="100">未审核</td>
								</c:if>
								<c:if test="${skiTra.audit==1}">
									<td width="100">已审核</td>
								</c:if>
								<td width="150">								
									<a href="<%=basePath%>skiTra/showSkiTraDetail?id=${skiTra.id}&detailFlag=3" class="id_23">更多</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSkillTrain=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${skillTrainPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSkillTrain=${skillTrainPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${skillTrainPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==skillTrainPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=skillTrainPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSkillTrain=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${skillTrainPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSkillTrain=${skillTrainPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSkillTrain=${skillTrainPageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>社会贡献</span><i></i><a>社会服务</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
    			 <thead>
        			<tr>      
          				<th style="text-align:center;">学校名称</th>       
         				<th style="text-align:center;">年份</th>
          				<th style="text-align:center;">培训企业员工数</th>
						<th style="text-align:center;">培训残疾人人数</th>
						<th style="text-align:center;">培训失业人员人数</th>
						<th style="text-align:center;">培训农民工人数</th>
						<th style="text-align:center;">培训退役士兵人数</th>
						<th style="text-align:center;">技能鉴定项目人次</th>
						<th style="text-align:center;">审核</th>
						<th style="text-align:center;"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty socialServicePageInfo }">
						<c:forEach items="${socialServicePageInfo.list}" var="social">
							<tr class="id_24">
							    <td>${social.admcode}</td>
								<td>${social.year}</td>
								<td>${social.trainstaff}</td>
								<td>${social.trainunabled}</td>
								<td>${social.trainunemstaff}</td>
								<td>${social.trainfarmer}</td>
								<td>${social.trainretiresoldier}</td>
								<td>${social.skillidentnum}</td>

								<c:if test="${social.audit==0}">
									<td width="100">未审核</td>
								</c:if>
								<c:if test="${social.audit==1}">
									<td width="100">已审核</td>
								</c:if>
								<td width="150">			
									<a href="<%=basePath%>social/showSocialDetail?id=${social.id}&detailFlag=3" class="id_23">更多</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSocialService=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${socialServicePageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSocialService=${socialServicePageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${socialServicePageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==socialServicePageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=socialServicePageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSocialService=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${socialServicePageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSocialService=${socialServicePageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnSocialService=${socialServicePageInfo.pages}&types=${typeCode}">末页</a></li> 
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
           <div class="id_13"><span>社会贡献</span><i></i><a>对口支援</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
    			 <thead>
        			<tr>      
          				<th style="text-align:center;">学校名称</th>       
         				<th style="text-align:center;">年份</th>
          				<th style="text-align:center;">对口帮扶对象单位数</th>
						<th style="text-align:center;">扶贫对象数</th>
						<th style="text-align:center;">资金扶贫（万元）</th>
						<th style="text-align:center;">服务人数</th>
						<th style="text-align:center;">审核</th>
						<th style="text-align:center;"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty counpaSuppPageInfo }">
						<c:forEach items="${counpaSuppPageInfo.list}" var="coun">
							<tr class="id_24">
								<td>${coun.admcode}</td>
								<td>${coun.year}</td>
								<td>${coun.helpobject}</td>
								<td>${coun.poverreductarget}</td>
								<td>${coun.fund}</td>
								<td>${coun.servicenum}</td>

								<c:if test="${coun.audit==0}">
									<td width="100">未审核</td>
								</c:if>
								<c:if test="${coun.audit==1}">
									<td width="100">已审核</td>
								</c:if>
								<td width="150">								
									<a href="<%=basePath%>coun/showCounDetail?id=${coun.id}&detailFlag=3" class="id_23">更多</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnCounpaSupp=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${counpaSuppPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnCounpaSupp=${counpaSuppPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${counpaSuppPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==counpaSuppPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=counpaSuppPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnCounpaSupp=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${counpaSuppPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnCounpaSupp=${counpaSuppPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnCounpaSupp=${counpaSuppPageInfo.pages}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>

</div>       
</div>

<div class="id_21">
	<table class="id_22">	
	</table>
</div>
</c:if>

<c:if test="${typeCode eq 6}">
<div class="id_21">
           <div class="id_13"><span>举办者履职</span><i></i><a>经费</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1" id="ctl00_content_GridView3" style="border-collapse:collapse;">
      <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">中央财政投入经费（万元）</th>
          <th style="text-align:center;">地方财政投入经费（万元）</th>
          <th style="text-align:center;">生均拨款（元）</th>  
          <th style="text-align:center;">审核</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty fundsPageInfo }">  
                <c:forEach items="${fundsPageInfo.list}" var="funds">  
                    <tr class="id_24">  
                        <td>${funds.admcode}</td>  
                        <td>${funds.year}</td>                       
                        <td>${funds.centerFund}</td>
                        <td>${funds.localFund}</td>
                        <td>${funds.appropriation}</td>                                                                                                   
                        <td>${funds.audit=="0"?"未审核":"已审核"}</td>
                        <td>                       
                            <a href="<%=basePath%>funds/getFundsDetail?id=${funds.id}&detailFlag=3" class="id_23">更多</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
   </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnFunds=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${fundsPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnFunds=${fundsPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>
		
		
		<c:forEach items="${fundsPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==fundsPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=fundsPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnFunds=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${fundsPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnFunds=${fundsPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnFunds=${fundsPageInfo.pages}&types=${typeCode}">末页</a></li> 
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
<div class="id_13"><span>举办者履职</span><i></i><a>政策措施</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1" id="ctl00_content_GridView3" style="border-collapse:collapse;">
      <thead>
        <tr>      
          <th style="text-align:center;">学校名称</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">年度新增教师编制数</th>
          <th style="text-align:center;">审核</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty policyPageInfo }">  
                <c:forEach items="${policyPageInfo.list}" var="policy">  
                    <tr class="id_24"> 
                        <td>${policy.admcode}</td>  
                        <td>${policy.year}</td>                       
                        <td>${policy.teacher}</td>                                                                                                                      
                        <td>${policy.audit=="0"?"未审核":"已审核"}</td>                                                                                                            
                        <td>                      
                        <a href="<%=basePath%>policy/getPolicyDetail?id=${policy.id}&detailFlag=3" class="id_23">更多</a>  
                        </td>  
                     </tr>               
                </c:forEach>  
            </c:if>  
      </tbody>
   </table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnPolicy=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${policyPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnPolicy=${policyPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>
		
		
		<c:forEach items="${policyPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==policyPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=policyPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnPolicy=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${policyPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnPolicy=${policyPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnPolicy=${policyPageInfo.pages}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>            
	</div>
</div>

<div class="id_21">
	<table class="id_22">	
	</table>
</div>
</c:if>

<c:if test="${typeCode eq 7}">
<div class="id_21">
           <div class="id_13"><span>党建工作</span><i></i><a>学校党建工作</a></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
    			 <thead>
        			<tr>      
          				<th style="text-align:center;">学校名称</th>       
         				<th style="text-align:center;">年份</th>
          				<th style="text-align:center;">学校党员总数</th>
						<th style="text-align:center;">党支部数</th>
						<th style="text-align:center;">学生党员数</th>
						<th style="text-align:center;">党务工作人员培训人次</th>
						<th style="text-align:center;">审核</th>
						<th style="text-align:center;"></th>					
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty partybulidPageInfo }">
						<c:forEach items="${partybulidPageInfo.list}" var="partybulid">
							<tr class="id_24">
								<td>${partybulid.admcode}</td>
								<td>${partybulid.year}</td>
								<td>${partybulid.partymember}</td>
								<td>${partybulid.branchnum}</td>
								<td>${partybulid.stupartynum}</td>
								<td>${partybulid.partyworktrain}</td>
								<c:if test="${partybulid.audit==0}">
									<td width="100">未审核</td>
								</c:if>
								<c:if test="${partybulid.audit==1}">
									<td width="100">已审核</td>
								</c:if>
								<td width="150">								
									<a href="<%=basePath%>partybulid/getPartyBulid?id=${partybulid.id}&detailFlag=3" class="id_23">更多</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnPartybulid=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${partybulidPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnPartybulid=${partybulidPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${partybulidPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==partybulidPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=partybulidPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnPartybulid=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${partybulidPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnPartybulid=${partybulidPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnPartybulid=${partybulidPageInfo.pages}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>

</div>       
</div>

<div class="id_21">
	<table class="id_22">	
	</table>
</div>
</c:if>

<c:if test="${typeCode eq 8}">
<div class="id_21">
           <div class="id_13"><span>上传文件</span></div>
<div>
<table cellspacing="0" rules="all" class="id_22" border="1"  style="border-collapse:collapse;">
    			 <thead>
        			<tr>      
          				<th style="text-align:center;">学校名称</th>       
         				<th style="text-align:center;">文件名</th>
          				<th style="text-align:center;">上传时间</th>
						<th style="text-align:center;">文件模块</th>					
						<th style="text-align:center;">审核</th>
						<th style="text-align:center;"></th>					
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty fileInfoPageInfo }">
						<c:forEach items="${fileInfoPageInfo.list}" var="fileInfo">
							<tr class="id_24">
								<td>${fileInfo.writer}</td>
								<td>${fileInfo.name}</td>
								<td>${fileInfo.writetime}</td>
								<td>${fileInfo.source}</td>
								
								<c:if test="${fileInfo.audit==0}">
									<td width="100">未审核</td>
								</c:if>
								<c:if test="${fileInfo.audit==1}">
									<td width="100">已审核</td>
								</c:if>
								<td width="150">								
									<a href="<%=basePath%>file/download?id=${fileInfo.id}"  class="id_23">查看</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnFileInfo=1&types=${typeCode}">首页</a></li> 
		
		<c:if test="${fileInfoPageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnFileInfo=${fileInfoPageInfo.pageNum-1}&types=${typeCode}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>		
		
		<c:forEach items="${fileInfoPageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==fileInfoPageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=fileInfoPageInfo.pageNum}">
			<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnFileInfo=${pageNum}&types=${typeCode}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${fileInfoPageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnFileInfo=${fileInfoPageInfo.pageNum+1}&types=${typeCode}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList?pnFileInfo=${fileInfoPageInfo.pages}&types=${typeCode}">末页</a></li> 
	</ul> 
</nav>
</div>

</div>       
</div>
</c:if>
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