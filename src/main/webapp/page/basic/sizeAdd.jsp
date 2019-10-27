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
<script type="text/javascript" src="<%=basePath%>js/size.js"></script>
<script type="text/javascript">

	window.onload = function() {
		//设置年份的选择
		var myDate = new Date();
		var startYear = myDate.getFullYear();//起始年份
		var endYear = myDate.getFullYear() - 30;//结束年份
		var obj = document.getElementById('year');
		for (var i = startYear; i >= endYear; i--) {
			obj.options.add(new Option(i, i));
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
<div class="id_13"><span>基本情况</span><i></i><a href="<%=basePath%>size/getSizeList">规模</a></div>
<div class="id_14">
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">

<form action="<%=basePath%>size/saveSize" id="sizeForm" method="post">
<div id="t1" class="id_26" style="float:left">
<table class="id_27">
    <tbody>
    <tr>
      <th scope="row">年份</th>
      <td><div class="form-group">
      	<select id="year" name="year" class="form-control" >     
	 	</select>
	 </div></td>
    </tr>
    <tr >
      <th scope="row">办学性质</th>
      <td><div class="form-group">
      	<select id="schoolRun" name="schoolRun" class="form-control">  
    		<option value="0">公办</option>  
    		<option value="1">民办</option>
    		<option value="2">混合制</option>    
	 	</select>
	  </div></td>
    </tr>
    <tr>
      <th scope="row">学校占地面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="area" > </div></td>
    </tr>
    <tr>
      <th scope="row">自有产权占地面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="ownPropArea" > </div></td>
    </tr>
    <tr >
      <th scope="row">总建筑面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="totalArea" > </div></td>
    </tr>
    <tr >
      <th scope="row">学校自有产权建筑面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schOwnConArea" > </div></td>
    </tr>
    <tr >
      <th scope="row">生均建筑面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stuArea" > </div></td>
    </tr>
    <tr >
      <th scope="row">教学及辅助用房面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="teaAuxArea" > </div></td>
    </tr>
    <tr >
      <th scope="row">校内实训用房面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="trainArea" > </div></td>
    </tr>
    <tr >
      <th scope="row">心理咨询室建筑面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="psyArea" > </div></td>
    </tr>
    <!-- <tr >
      <th scope="row">行政办公用房面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="adminOfficeArea" > </div></td>
    </tr> -->
    <tr >
      <th scope="row">学生宿舍面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="dormArea" > </div></td>
    </tr>
    <tr >
      <th scope="row">生均宿舍面积（㎡）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="dormPerArea" > </div></td>
    </tr>
  </tbody>
    </table>
</div>
<div class="id_26" style="float:left">
<table class="id_27">
      <tbody>
    <tr >
      <th scope="row">办学水平</th>
      <!-- <td><input type="text" class="form-control" name="schoolLevel"></td> -->
      <td><div class="form-group">
      	<select id="schoolLevel" name="schoolLevel" class="form-control">  
    		<option value="0">一般</option>  
    		<option value="1">国示校</option>
    		<option value="2">国重校</option>
			<option value="3">省重校</option>   
	 	</select>
	  </div></td>
    </tr>
    <tr>
      <th scope="row">办学主体</th>
      <!-- <td><input type="text" class="form-control" name="schoolSubject"></td> -->
      <td><div class="form-group">
      	<select id="schoolSubject" name="schoolSubject" class="form-control">  
    		<option value="0">教育行政部</option>  
    		<option value="1">人社部门</option>
    		<option value="2">行业</option>
	 	</select>
	  </div></td>
    </tr>
    <tr>
      <th scope="row">在校生数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="totalStudent" > </div></td>
    </tr>
    <tr>
      <th scope="row">毕业生数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="annualGraduate" > </div></td>
    </tr>
    <tr>
      <th scope="row">当年招生总数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="enrollment" > </div></td>
    </tr>
    <tr>
      <th scope="row">专业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="majors" > </div></td>
    </tr>
    <tr>
      <th scope="row">巩固率</th>
      <td><div class="form-group"><input type="text" class="form-control" name="threeConsol" > </div></td>
    </tr>
  </tbody>
    </table> 
    </div>   
    <div class="id_29" style="clear:both">
    	<input  id="submit" class="id_31" type="submit" value="提交">
		<input class="id_31" type="button" onclick="location.href='<%=basePath%>size/getSizeList'" value="返回">
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