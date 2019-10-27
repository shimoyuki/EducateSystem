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
<script type="text/javascript" src="<%=basePath%>js/partybulid.js"></script>
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
<div class="id_13"><span>党建工作</span><i></i><a href="<%=basePath%>partybulid/getPartyBulidList">学校党建工作</a></div>
<div class="id_14">
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form action="<%=basePath%>partybulid/savePartyBulid" id="partybulidForm" method="post">
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
      <th scope="row">学校党员总数</th>
      <td><div class="form-group">
      	<input type="text" class="form-control" name="partymember" >
	  </div></td>
    </tr>
    <tr>
      <th scope="row">党支部数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="branchnum" > </div></td>
    </tr>
    <tr>
      <th scope="row">学生党员数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stupartynum" > </div></td>
    </tr>
    <tr >
      <th scope="row">党务工作人员培训人次</th>
      <td><div class="form-group"><input type="text" class="form-control" name="partyworktrain" > </div></td>
    </tr>
    <tr >
      <th scope="row">党组织开展党员教育培训次数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="partytain" > </div></td>
    </tr>
    <tr >
      <th scope="row">入党积极分子培训人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="partyactivisttrainnum" > </div></td>
    </tr>
    <tr >
      <th scope="row">入党积极分子培训次数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="partyactivisttraintime" > </div></td>
    </tr>
    <tr >
      <th scope="row">发展党员人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="developpartynum" > </div></td>
    </tr>
    <tr >
      <th scope="row">党报党刊订阅数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="subscribnum" > </div></td>
    </tr>
  </tbody>
    </table>
</div>
<div class="id_26" style="float:left">
<table class="id_27">
      <tbody>
    <tr >
      <th scope="row">受党纪政治处分党员数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="punish" > </div></td>
    </tr>
    <tr>
      <th scope="row">获国家级优秀表彰的党员数</th>
     
      <td><div class="form-group">
      	<input type="text" class="form-control" name="stateper" >
	  </div></td>
    </tr>
    <tr>
      <th scope="row">获省级优秀表彰的党员数</th>
     
      <td><div class="form-group">
      	<input type="text" class="form-control" name="provinper" >
	  </div></td>
    </tr>
    <tr>
      <th scope="row">获市级优秀表彰的党员数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="cityper" > </div></td>
    </tr>
    <tr>
      <th scope="row">获国家级优秀表彰的党组织数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="stateorgan" > </div></td>
    </tr>
    <tr>
      <th scope="row">获省级优秀表彰的党组织数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="provinorgan" > </div></td>
    </tr>
    <tr>
      <th scope="row">获市级优秀表彰的党组织数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="cityorgan" > </div></td>
    </tr>
    
  </tbody>
    </table> 
    </div>   
    <div class="id_29" style="clear:both">
    	<input  id="submit" class="id_31" type="submit" value="提交">
		<input class="id_31" type="button" onclick="location.href='<%=basePath%>partybulid/getPartyBulidList'" value="返回">
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