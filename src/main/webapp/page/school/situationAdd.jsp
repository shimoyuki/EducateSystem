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
<script type="text/javascript" src="<%=basePath%>js/hezuo.js"></script>
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
	
	$.ajax({  
        data:{
        	num:$("#majornum").val(),
        	year:$("#year").val()
        },	
        type:"GET",  
        dataType: "json",  
        url:"<%=basePath%>schoolenterprise/checkmajor",
        error:function(data){ 
            alert("出错了！");  
        },  
        success:function(data){ 
        	//alert(data.result);
        	$("#majorsum").val(data.result);
        }  
    }); 
};

function checknum(){
	 var sum=$("#majorsum").val();
	 var input=$("#majornum").val();
	/*  alert("input="+input);
	 alert("sum="+sum); */
	 if(input-sum>0){	 
		alert("校企合作覆盖专业数应小于等于学校本年度专业数");
		return false;
	 }		
	 else
		return true;
} 
</script>

</head>
<body>
<%@ include file="/page/top.jsp" %>
<%@ include file="/page/left.jsp"%>
<!--右边内容区-->
<div id="id_11">
<!--添加删除修改-->
<div class="id_12">
<div class="id_13"><span>校企合作</span><i></i><a href="#">合作情况</a></div>
<div class="id_14">
<!-- <a href="#" class="id_15"></a>
<a href="#" class="id_16"></a>
<a href="#" class="id_17"></a>
<div class="id_18"><input type="text" class="id_19" placeholder="请输入年份查询"><input type="submit" value="" class="id_20"></div>
 --></div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form  id="formhezuo" action="<%=basePath %>/schoolenterprise/saveSchoolenterprise" method="post" name="sizeForm">
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
      <th scope="row">校企合作覆盖专业数</th>
      <td><div class="form-group">
      		<input id="majornum" type="text" class="form-control" name="majornum" onblur="checknum()">
      		<input id="majorsum" type="hidden">
      		
      	  </div>
      </td>
    </tr>
    <tr>
      <th scope="row">签订合作协议的企业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopagreeenterp" ></div></td>
    </tr>
    <tr>
      <th scope="row">签订合作协议的专业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopagreemajor" ></div></td>
    </tr>
    <tr>
      <th scope="row">合作企业参与教学的专业数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpjointeachmajor" ></div></td>
    </tr>
    <tr >
      <th scope="row">合作企业参与教学的教师数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpjointeachteacher" ></div></td>
    </tr>
    <tr >
      <th scope="row">合作企业参与教学课时数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpjointeachclass" ></div></td>
    </tr>
    <tr >
      <th scope="row">合作企业投入资金总额（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpfund"  ></div></td>
    </tr>
    <tr >
      <th scope="row">合作企业投入到账资金（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterparrivalfund"  ></div></td>
    </tr>
  </tbody>
    </table>
</div>
<div class="id_26" style="float:left">
<table class="id_27">
      <tbody>
    <tr >
      <th scope="row">合作企业投入设备总值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="coopenterpequitworth" ></div></td>
    </tr>
    <tr >
      <th scope="row">与企业共建研发中心数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="enterpbuildreseadevelop" ></div></td>
    </tr>
    <tr >
      <th scope="row">校外教师培训基地数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="offschoteachertrainbase" ></div></td>
    </tr>
    <tr >
      <th scope="row">生产性实训基地产值（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="prodtrainbaseval" ></div></td>
    </tr>
    <tr >
      <th scope="row">校企合作订单班人数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schoenterpcooporderclassnum" ></div></td>
    </tr>
    <tr >
      <th scope="row">校企合作开发课程数</th>
      <td><div class="form-group"><input type="text" class="form-control" name="schoenterpdevelopcourse" ></div></td>
    </tr>
    <tr >
      <th scope="row">专任教师企业实习实践人次</th>
      <td><div class="form-group"><input type="text" class="form-control" name="fullenterprac" ></div></td>
    </tr>
    <tr >
      <th scope="row">专任教师人均企业实习实践时间（天）</th>
      <td><div class="form-group"><input type="text" class="form-control" name="fullentertime" ></div></td>
    </tr>
    <tr >
      <th scope="row">企业兼职教师专业课课时占比</th>
      <td><div class="form-group"><input type="text" class="form-control" name="parttimeclassradio" ></div></td>
    </tr>
  </tbody>
    </table>
    </div>
	<div class="id_29" style="clear:both">
		<input type="submit" class="id_31" value="提交" onclick="return checknum();">
		<input type="button" class="id_31" onclick="location.href='<%=basePath%>schoolenterprise/getSchoolenterpriseList'" value="返回">
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