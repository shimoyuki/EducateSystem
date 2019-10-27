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
<script type="text/javascript" src="<%=basePath%>js/majorNum.js"></script>
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
<div class="id_13"><span>质量保障措施</span><i></i><a href="<%=basePath%>majorNum/getMajorNumList">开设课程</a></div>
<div class="id_14">
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form action="<%=basePath%>majorNum/saveMajorNum" id="majorNumForm"  method="post">
<div class="id_26" style="float:left">
<table class="id_27">
    <tbody>
    <tr>
      <th scope="row">年份</th>
      <td><div class="form-group">
      	<select id="year" name="year" class="form-control">     
	 	</select>
	 </div></td>
    </tr>
    <tr >
      <th scope="row">已制定课程标准数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="classCriter"></div></td>      
    </tr>
    <tr>
      <th scope="row">牵头开发国家共建共享计划课程数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="leadNatShareMajor" ></div></td>
    </tr>
    <!-- <tr>
      <th scope="row">校企联合开发课程数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schoolEnterMajor" ></div></td>
    </tr> -->
    <tr >
      <th scope="row">教师参编公开出版的教材数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="textTeacEditMajor" ></div></td>
    </tr>
    <tr >
      <th scope="row">规划教材使用比</th>
      <td><div class="form-group"><input type="text" class="form-control" name="statePlanText" ></div></td>
    </tr>
    <tr >
      <th scope="row">校本教材开发数量</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schMajorMater" ></div></td>
    </tr>
    <!-- <tr >
      <th scope="row">各专业课程学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="classHour" ></div></td>
    </tr>
    <tr >
      <th scope="row">各专业专业课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="majorHour" ></div></td>
    </tr>
    <tr >
      <th scope="row">其中专业核心课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="majorBHour" ></div></td>
    </tr>
    <tr >
      <th scope="row">其中专业技能课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="majorCHour" ></div></td>
    </tr>
    <tr >
      <th scope="row">其中顶岗实习课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="dispClass" ></div></td>
    </tr> -->
  </tbody>
    </table>
</div>
<!-- <div class="id_26" style="float:left">
<table class="id_27">
   <tbody>
    <tr >
      <th scope="row">各专业公共基础课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="bCClassHour" ></div></td>
    </tr>
    <tr >
      <th scope="row">其中语文课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="chinese" ></div></td>
    </tr>
    <tr>
      <th scope="row">其中德育课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="moral" ></div></td>
    </tr>
    <tr>
      <th scope="row">其中数学课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="math" ></div></td>
    </tr>
    <tr>
      <th scope="row">其中外语课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="english" ></div></td>
    </tr>
    <tr>
      <th scope="row">其中体育健康课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="sports" ></div></td>
    </tr>
    <tr>
      <th scope="row">其中公共艺术课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="art" ></div></td>
    </tr>
    <tr>
      <th scope="row">其中计算机应用课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="computer" ></div></td>
    </tr>
    <tr>
      <th scope="row">其中历史课学时总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="history" ></div></td>
   </tr>
   </tbody>
 </table>
 	</div> -->
 	 <div class="id_29" style="clear:both">
    	<input  id="submit" class="id_31" type="submit" value="提交">
		<input class="id_31" type="button" onclick="location.href='<%=basePath%>majorNum/getMajorNumList'" value="返回">
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