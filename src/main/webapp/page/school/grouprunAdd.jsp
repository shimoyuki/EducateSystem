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
<link href="<%=basePath%>css/sjcj.css" rel="stylesheet" type="text/css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" type="text/css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css"
	type="text/css">
<link rel="stylesheet" href="<%=basePath%>css/bootstrapValidator.min.css"
	type="text/css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.placeholder.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jituanhua.js"></script>
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
</script>

</head>
<body>
<%@ include file="/page/top.jsp"%>
<%@ include file="/page/left.jsp"%>
<!--右边内容区-->
<div id="id_11">
<!--添加删除修改-->
<div class="id_12">
<div class="id_13"><span>校企合作</span><i></i><a href="#">集团化办学情况</a></div>
<div class="id_14">
<!-- <a href="#" class="id_15"></a>
<a href="#" class="id_16"></a>
<a href="#" class="id_17"></a>
<div class="id_18"><input type="text" class="id_19" placeholder="请输入年份查询"><input type="submit" value="" class="id_20"></div>
 --></div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form  id="formjituanhua" action="<%=basePath %>/group/saveGroupSchool" name="sizeForm">
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
      <th scope="row">本校牵头组织的职教集团数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="leadvocedugroup" ></div></td>
    </tr>
    <tr>
      <th scope="row">本校参与的职教集团数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="joinvocedugroup" ></div></td>
    </tr>
    <tr>
      <th scope="row">参加本校牵头的职教集团学校数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="joinleadvocedugroupscho" ></div></td>
    </tr>
    <tr>
      <th scope="row">参加本校牵头的职教集团企业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="joinleadvocedugroupenterp" ></div></td>
    </tr>
    <tr >
      <th scope="row">参加本校牵头的职教集团专业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="joinleadvocedugroupmajor" ></div></td>
    </tr>
    
  </tbody>
</table>
    
    <input type="submit" class="id_31" value="提交">
	<input type="button" class="id_31" onclick="location.href='<%=basePath%>group/getGroupSchoolList'" value="返回">
	
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