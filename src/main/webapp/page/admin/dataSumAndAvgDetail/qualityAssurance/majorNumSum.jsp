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
<script type="text/javascript" src="<%=basePath%>js/majorNum.js"></script>
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
<div class="id_13"><span>质量保障措施</span><i></i><a href="">开设课程总和</a></div>
<div class="id_14">
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form action="<%=basePath%>majorNum/updateMajorNum" id="majorNumForm"  method="post">
<div class="id_26" style="float:left">
<table class="id_27">
    <tbody>
     <tr>
      <th scope="row">年份</th>     
      <td><div class="form-group">
      	 <input ype="text"  id="year"   name="admcode" class="form-control" readonly="readonly" value="${majorNum.admcode}">
	 </div></td>
    </tr>
    <tr>
      <th scope="row">年份</th>     
      <td><div class="form-group">
      	 <input ype="text"  id="year"   name="year" class="form-control" readonly="readonly" value="${majorNum.year}">
	 </div></td>
    </tr>
    <tr >
      <th scope="row">已制定课程标准数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="classCriter" value="${majorNum.classCriter}"></div></td>      
    </tr>
    <tr>
      <th scope="row">牵头开发国家共建共享计划课程数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="leadNatShareMajor" value="${majorNum.leadNatShareMajor}"></div></td>
    </tr>
    <%-- <tr>
      <th scope="row">校企联合开发课程数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schoolEnterMajor" value="${majorNum.schoolEnterMajor}"></div></td>
    </tr> --%>
    <tr >
      <th scope="row">教师参编公开出版的教材数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="textTeacEditMajor" value="${majorNum.textTeacEditMajor}"></div></td>
    </tr>
    <%-- <tr >
      <th scope="row">规划教材使用比</th>
      <td><div class="form-group"><input type="text" class="form-control" name="statePlanText" value="${majorNum.statePlanText}"></div></td>
    </tr> --%>
    <tr >
      <th scope="row">校本教材开发数量</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schMajorMater" value="${majorNum.schMajorMater}"></div></td>
    </tr>
    <%-- <tr >
      <th scope="row">各专业课程学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="classHour" value="${majorNum.classHour}"></div></td>
    </tr>
    <tr >
      <th scope="row">各专业专业课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="majorHour" value="${majorNum.majorHour}"></div></td>
    </tr>
    <tr >
      <th scope="row">其中专业核心课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="majorBHour" value="${majorNum.majorBHour}"></div></td>
    </tr>
    <tr >
      <th scope="row">其中专业技能课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="majorCHour" value="${majorNum.majorCHour}"></div></td>
    </tr>
    <tr >
      <th scope="row">其中顶岗实习课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="dispClass" value="${majorNum.dispClass}"></div></td>
    </tr> --%>
  </tbody>
    </table>
</div>
<%-- <div class="id_26" style="float:left">
<table class="id_27">
   <tbody>
    <tr >
      <th scope="row">各专业公共基础课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="bCClassHour" value="${majorNum.bCClassHour}"></div></td>
    </tr>
    <tr >
      <th scope="row">其中语文课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="chinese" value="${majorNum.chinese}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中德育课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="moral" value="${majorNum.moral}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中数学课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="math" value="${majorNum.math}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中外语课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="english" value="${majorNum.english}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中体育健康课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="sports" value="${majorNum.sports}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中公共艺术课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="art" value="${majorNum.art}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中计算机应用课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="computer" value="${majorNum.computer}"></div></td>
    </tr>
    <tr>
      <th scope="row">其中历史课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="history" value="${majorNum.history}"></div></td>
   </tr>
  </tbody>
    </table> 
    </div>--%>
    <div class="id_29" style="clear:both">  					
		<input class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=3&year=${majorNum.year }'" value="返回"> 										  							
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