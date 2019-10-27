<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
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
<script type="text/javascript" src="<%=basePath%>js/educationTrain.js"></script>
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
}
</script>
</head>
<body>
<%@ include file="/page/top.jsp" %>  
<!--左边导航栏-->
<%@ include file="/page/left.jsp" %>
<!--右边内容区-->
<div id="id_11">
<!--添加删除修改-->
<div class="id_12">
<div class="id_13"><span>质量保障措施</span><i></i><a href="<%=basePath%>educationTrain/getEducationTrainList">教师培养培训</a></div>
<div class="id_14">
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form action="<%=basePath%>educationTrain/saveEducationTrain"  id="educationTrainForm" method="post">
<div class="id_26" style="float:left">
<table class="id_27">
    <tbody>
    <tr>
      <th scope="row">年份</th>
      <td><div class="form-group">
      	<select id="year" name="year"  class="form-control">     
	 	</select>
	  </div></td>
    </tr>
    <tr >
      <th scope="row">参加区县级培训专任教师数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="distTrainFullTea"> </div></td>      
    </tr>
    <tr>
      <th scope="row">参加区县级培训人均课时数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="distTrainHour" > </div></td>
    </tr>
    <tr>
      <th scope="row">参加市级培训专任教师数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="cityTrainFullTea" > </div></td>
    </tr>
    <tr >
      <th scope="row">参加市级培训人均课时数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="cityTrainHour" > </div></td>
    </tr>
    <tr >
      <th scope="row">参加省级培训专任教师数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="provinTrainFullTea" > </div></td>
    </tr>
    <tr >
      <th scope="row">参加省级培训人均课时数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="provinTrainHour" > </div></td>
    </tr>
    <tr >
      <th scope="row">参加国家级培训专任教师数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="stateTrainFullTea" > </div></td>
    </tr>
    <tr >
      <th scope="row">参加国家级培训人均课时数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="stateTrainHour" > </div></td>
    </tr>
    <tr >
      <th scope="row">参加国外培训专任教师数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="stateOuterTrain" > </div></td>
    </tr>
    <tr >
      <th scope="row">参加国外培训人均课时数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="stateOuterHour" > </div></td>
    </tr>
    <tr >
      <th scope="row">参加境外培训专任教师数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="abroadTrain" > </div></td>
    </tr>
     <tr >
      <th scope="row">参加境外培训人均课时数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="abroadHour" > </div></td>
    </tr>
  </tbody>
    </table>
</div>
<div class="id_26" style="float:left">
<table class="id_27">
      <tbody>
    <tr >
      <th scope="row">教师参加学历提升获得毕业证书人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="diploma" > </div></td>
    </tr>
    <tr >
      <th scope="row">用于教师培养培训经费占学校公用经费的比例</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="tainFundPer" > </div></td>
    </tr>
    <tr >
      <th scope="row">教师参加国家级教学或技能大赛人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="stateSkillWinTime" > </div></td>
    </tr>
    <tr >
      <th scope="row">其中一等奖获得人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="stateFirstAward" > </div></td>
    </tr>
    <tr>
      <th scope="row">其中二等奖获得人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="stateSecondAward" > </div></td>
    </tr>
    <tr>
      <th scope="row">其中三等奖获得人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="stateThridAward" > </div></td>
    </tr>
    <tr>
      <th scope="row">教师参加省级教学或技能大赛人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="provinSkillWinTime" > </div></td>
    </tr>
    <tr >
      <th scope="row">其中一等奖获得人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="provinFirstAward" > </div></td>
    </tr>
    <tr>
      <th scope="row">其中二等奖获得人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="provinSecondAward" > </div></td>
    </tr>
    <tr>
      <th scope="row">其中三等奖获得人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="provinThirdAward" > </div></td>
    </tr>
    <tr>
      <th scope="row">教师参加市级教学或技能大赛人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="citySkillWinTime" > </div></td>
    </tr>
    <tr >
      <th scope="row">其中一等奖获得人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="cityFirstAward" > </div></td>
    </tr>
    <tr>
      <th scope="row">其中二等奖获得人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="citySecondAward" > </div></td>
    </tr>
    <tr>
      <th scope="row">其中三等奖获得人数</th>
      <td><div class="form-group"><input type="text"  class="form-control" name="cityThirdAward" > </div></td>
    </tr>
  </tbody>
    </table>
    </div>
	<div class="id_29" style="clear:both">
		<input id="submit" class="id_31" type="submit" value="提交">
		<input class="id_31" type="button" onclick="location.href='<%=basePath%>educationTrain/getEducationTrainList'" value="返回">
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