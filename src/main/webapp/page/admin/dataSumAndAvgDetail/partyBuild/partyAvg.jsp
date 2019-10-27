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
<script type="text/javascript" src="<%=basePath%>js/partybulid.js"></script>
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
<div class="id_13"><span>党建工作</span><i></i><a href="">学校党建工作平均值</a></div>
<div class="id_14">
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form action="<%=basePath%>partybulid/updatePartyBulid" id="partybulidForm" method="post">
<div class="id_26" style="float:left">
<table class="id_27">
    <tbody>
    <input type="hidden" name="id" value="${partybulid.id}"/>
    <tr>
      <th scope="row">地区</th>
      <td><div class="form-group">
      	<input id="year" class="form-control" name="admcode" value="${partybulid.admcode }" type="text" readonly="readonly" />
	 </div></td>
    </tr>
    <tr>
      <th scope="row">年份</th>
      <td><div class="form-group">
      	<input id="year" class="form-control" name="year" value="${partybulid.year }" type="text" readonly="readonly" />
      
	 </div></td>
    </tr>
    <tr >
      <th scope="row">学校党员总数</th>
      <td><div class="form-group">
      	<input type="text" class="form-control" name="partymember" value="${partybulid.partymember }">
	  </div></td>
    </tr>
    <tr>
      <th scope="row">党支部数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="branchnum" value="${partybulid.branchnum }"> </div></td>
    </tr>
    <tr>
      <th scope="row">学生党员数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stupartynum" value="${partybulid.stupartynum }"> </div></td>
    </tr>
    <tr >
      <th scope="row">党务工作人员培训人次</th>
      <td><div class="form-group"><input type="text" class="form-control" name="partyworktrain" value="${partybulid.partyworktrain }"> </div></td>
    </tr>
    <tr >
      <th scope="row">党组织开展党员教育培训次数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="partytain" value="${partybulid.partytain }"> </div></td>
    </tr>
    <tr >
      <th scope="row">入党积极分子培训人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="partyactivisttrainnum" value="${partybulid.partyactivisttrainnum }"> </div></td>
    </tr>
    <tr >
      <th scope="row">入党积极分子培训次数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="partyactivisttraintime" value="${partybulid.partyactivisttraintime }"> </div></td>
    </tr>
    <tr >
      <th scope="row">发展党员人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="developpartynum" value="${partybulid.developpartynum }"> </div></td>
    </tr>
    <tr >
      <th scope="row">党报党刊订阅数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="subscribnum" value="${partybulid.subscribnum }"> </div></td>
    </tr>
  </tbody>
    </table>
</div>
<div class="id_26" style="float:left">
<table class="id_27">
      <tbody>
    <tr >
      <th scope="row">受党纪政治处分党员数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="punish" value="${partybulid.punish }"> </div></td>
    </tr>
    <tr>
      <th scope="row">获国家级优秀表彰的党员数</th>
     
      <td><div class="form-group">
      	<input type="text" class="form-control" name="stateper" value="${partybulid.stateper }" >
	  </div></td>
    </tr>
    <tr>
      <th scope="row">获省级优秀表彰的党员数</th>
     
      <td><div class="form-group">
      	<input type="text" class="form-control" name="provinper" value="${partybulid.provinper }">
	  </div></td>
    </tr>
    <tr>
      <th scope="row">获市级优秀表彰的党员数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="cityper" value="${partybulid.cityper }"> </div></td>
    </tr>
    <tr>
      <th scope="row">获国家级优秀表彰的党组织数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stateorgan" value="${partybulid.stateorgan }"> </div></td>
    </tr>
    <tr>
      <th scope="row">获省级优秀表彰的党组织数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="provinorgan" value="${partybulid.provinorgan }"> </div></td>
    </tr>
    <tr>
      <th scope="row">获市级优秀表彰的党组织数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="cityorgan" value="${partybulid.cityorgan }"> </div></td>
    </tr>
    
  </tbody>
    </table>  
    </div>  
   <div class="id_29" style="clear:both">
   <input id="back" class="id_31" type="button" onclick="location.href='<%=basePath%>dataSumAndAvg/getDataSumAndAvg?type=7&year=${partybulid.year }'" value="返回">	
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