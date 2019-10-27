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
</div>
<!--表格区-->
<div class="id_21">
<span>${writeSituation.schoolName}</span>-<a>${writeSituation.year}年填报情况</a>
<table class="id_22">    		   
     		   <thead>
        			 <tr>      
         				<th style="text-align:center;">规模</th>
		 				<th style="text-align:center;">设施设备</th>
						<th style="text-align:center;">教师队伍</th>
						<th style="text-align:center;">信息化建设</th>
       				 </tr>
      		   </thead>
     		   <tbody>         
					<tr>
						<td>
							<c:if test="${writeSituation.sizeAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.sizeAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.sizeAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.equitmentAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.equitmentAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.equitmentAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.teachersAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.teachersAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.teachersAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.informationAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.informationAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.informationAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>																	
				   </tr>			 
     		   </tbody>
     		   
     		   <thead>
        			 <tr>      
         				<th style="text-align:center;">学生素质</th>
		 				<th style="text-align:center;">在校体验</th>
						<th style="text-align:center;">就业质量</th>						
       				 </tr>
      		   </thead>
     		   <tbody>         
					<tr>
						<td>
							<c:if test="${writeSituation.studentqualityAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.studentqualityAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.studentqualityAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.experienceAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.experienceAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.experienceAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.employqualityAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.employqualityAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.employqualityAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>														
				   </tr>			 
     		   </tbody>
     		   
     		   <thead>
        			 <tr>      
         				<th style="text-align:center;">专业布局</th>
		 				<th style="text-align:center;">课程开设</th>
						<th style="text-align:center;">质量保证</th>
						<th style="text-align:center;">教师培养培训</th>							
       				 </tr>
      		   </thead>
     		   <tbody>         
					<tr>
						<td>
							<c:if test="${writeSituation.majorlayoutAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.majorlayoutAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.majorlayoutAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.majornumAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.majornumAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.majornumAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.qualityassureAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.qualityassureAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.qualityassureAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.educationAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.educationAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.educationAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>														
				   </tr>			 
     		   </tbody>
     		   
     		   <thead>
        			 <tr>      
         				<th style="text-align:center;">合作情况</th>
		 				<th style="text-align:center;">学生实习情况</th>
						<th style="text-align:center;">集团化办学情况</th>							
       				 </tr>
      		   </thead>
     		   <tbody>         
					<tr>
						<td>
							<c:if test="${writeSituation.schoolenterpriseAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.schoolenterpriseAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.schoolenterpriseAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.internshipAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.internshipAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.internshipAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.groupschoolAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.groupschoolAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.groupschoolAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>													
				   </tr>			 
     		   </tbody>
     		   
     		   <thead>
        			 <tr>      
         				<th style="text-align:center;">技术技能人才培养</th>
		 				<th style="text-align:center;">社会服务</th>
						<th style="text-align:center;">对口支援</th>							
       				 </tr>
      		   </thead>
     		   <tbody>         
					<tr>
						<td>
							<c:if test="${writeSituation.skilltrainAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.skilltrainAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.skilltrainAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.socialserviceAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.socialserviceAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.socialserviceAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.counpasuppAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.counpasuppAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.counpasuppAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>													
				   </tr>			 
     		   </tbody>
     		   
     		   <thead>
        			 <tr>      
         				<th style="text-align:center;">经费</th>
		 				<th style="text-align:center;">政策措施</th>						
       				 </tr>
      		   </thead>
     		   <tbody>         
					<tr>
						<td>
							<c:if test="${writeSituation.fundsAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.fundsAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.fundsAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>
						<td>
							<c:if test="${writeSituation.policyAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.policyAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.policyAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>												
				   </tr>			 
     		   </tbody>
     		   
     		   <thead>
        			 <tr>      
         				<th style="text-align:center;">学校党建工作</th>				
       				 </tr>
      		   </thead>
     		   <tbody>         
					<tr>
						<td>
							<c:if test="${writeSituation.partybulidAudit==-1}"><font color=red >未填报</font></c:if>
							<c:if test="${writeSituation.partybulidAudit==0}">未审核</c:if>
							<c:if test="${writeSituation.partybulidAudit>=1}"><font color=blue >已审核</font></c:if>
						</td>												
				   </tr>			 
     		   </tbody>
    </table>
    	<div class="id_29" style="clear:both">							
			<input class="id_31" type="button" onclick="location.href='<%=basePath%>writeSituation/getWriteSituation'" value="返回">
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