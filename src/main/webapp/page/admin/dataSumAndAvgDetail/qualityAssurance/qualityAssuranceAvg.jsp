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
<link href="<%=basePath%>css/sjcj.css" rel="stylesheet" type="text/css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" type="text/css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>css/bootstrapValidator.min.css" type="text/css">
<script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/qualityAssurance.js"></script>
<script type="text/javascript">
window.onload=function(){
	
		$("input").attr("readonly",true);		
		$("select").attr("disabled",true);		
	 
}
</script>
</head>
<body>
<%@ include file="/page/top.jsp" %>  
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
<div class="id_13"><span>质量保障措施</span><i></i><a href="">质量保证平均值</a></div>
<div class="id_14">
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form action="<%=basePath%>qualityAssurance/updateQualityAssurance" id="qualityAssuranceForm" method="post">
<div class="id_26" style="float:left">
<table class="id_27">
    <tbody>
    <tr>
      <th scope="row">地区</th>     
      <td><div class="form-group">
      	<input ype="text"  id="year"   name="admcode" class="form-control" readonly="readonly" value="${qualityAssurance.admcode}">
	 </div></td>
    </tr>
    <tr>
      <th scope="row">年份</th>     
      <td><div class="form-group">
      	<input ype="text"  id="year"   name="year" class="form-control" readonly="readonly" value="${qualityAssurance.year}">
	 </div></td>
    </tr>
    <tr >
      <th scope="row">校领导人均听课课时数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="leaderListen" value="${qualityAssurance.leaderListen}"></div></td>      
    </tr>
    <tr>
      <th scope="row">校领导人均上课课时数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="leaderTalk" value="${qualityAssurance.leaderTalk}"></div></td>
    </tr>
    <tr>
      <th scope="row">教师教学质量考核-优秀比例</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schoolWell" value="${qualityAssurance.schoolWell}"></div></td>
    </tr>
    <tr >
      <th scope="row">教师教学质量考核-合格比例</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schoolGood" value="${qualityAssurance.schoolGood}"></div></td>
    </tr>
    <tr >
      <th scope="row">教师教学质量考核-不合格比例</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schoolBad" value="${qualityAssurance.schoolBad}"></div></td>
    </tr>
    <tr >
      <th scope="row">国家级课题立项数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stateClass" value="${qualityAssurance.stateClass}"></div></td>
    </tr>
    <tr >
      <th scope="row">省级课题立项数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="provinClass" value="${qualityAssurance.provinClass}"></div></td>
    </tr>
    <tr >
      <th scope="row">市级课题立项数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="cityClass" value="${qualityAssurance.cityClass}"></div></td>
    </tr>
    <tr >
      <th scope="row">市级文化课检测语文合格率</th>
      <td><div class="form-group"><input type="text" class="form-control" name="chinese" value="${qualityAssurance.chinese}"></div></td>
    </tr>
    <tr >
      <th scope="row">市级文化课检测数学合格率</th>
      <td><div class="form-group"><input type="text" class="form-control" name="math" value="${qualityAssurance.math}"></div></td>
    </tr>
    <tr >
      <th scope="row">市级文化课检测英语合格率</th>
      <td><div class="form-group"><input type="text" class="form-control" name="english" value="${qualityAssurance.english}"></div></td>
    </tr>
  </tbody>
    </table>
</div>
<div class="id_26" style="float:left">
<table class="id_27">
      <tbody>
    <tr >
      <th scope="row">学生参加国家级技能大赛人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stateSkillWinTime" value="${qualityAssurance.stateSkillWinTime}"></div></td>
    </tr>
    <tr >
      <th scope="row">其中一等奖获得人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stateFirstAward" value="${qualityAssurance.stateFirstAward}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中二等奖获得人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stateSecondAward" value="${qualityAssurance.stateSecondAward}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中三等奖获得人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stateThridAward" value="${qualityAssurance.stateThridAward}"></div></td>
    </tr>
    <tr>
      <th scope="row">学生参加省级技能大赛人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="provinSkillWinTime" value="${qualityAssurance.provinSkillWinTime}"></div></td>
    </tr>
    <tr >
      <th scope="row">其中一等奖获得人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="provinFirstAward" value="${qualityAssurance.provinFirstAward}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中二等奖获得人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="provinSecondAward" value="${qualityAssurance.provinSecondAward}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中三等奖获得人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="provinThirdAward" value="${qualityAssurance.provinThirdAward}"></div></td>
    </tr>
    <tr>
      <th scope="row">学生参加市级技能大赛人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="citySkillWinTime" value="${qualityAssurance.citySkillWinTime}"></div></td>
    </tr>
    <tr >
      <th scope="row">其中一等奖获得人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="cityFirstAward" value="${qualityAssurance.cityFirstAward}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中二等奖获得人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="citySecondAward" value="${qualityAssurance.citySecondAward}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中三等奖获得人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="cityThirdAward" value="${qualityAssurance.cityThirdAward}"></div></td>
    </tr>
  </tbody>
    </table>
    </div>
    <div class="id_29" style="clear:both">  					
		<input class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=3&year=${qualityAssurance.year }'" value="返回"> 										  							
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