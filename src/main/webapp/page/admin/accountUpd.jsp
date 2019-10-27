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
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>css/bootstrapValidator.min.css" type="text/css">
<script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/account.js"></script>
<script type="text/javascript">
window.onload=function(){
	$.ajax({
        url: "<%=basePath%>dataQuery/getSchoolNameList",            
        success: function (data) {          
        	eval(data);  
        	$.each(data, function(index, element) {
        		if(element.schoolname==$("#sname").val())
        		 	$("#schoolname1").append("<option value='"+element.schoolname+"' selected='selected'>"+element.schoolname+"</option>");   
        		else
        			$("#schoolname1").append("<option value='"+element.schoolname+"'>"+element.schoolname+"</option>");
            });	 
        	
            $("#schoolname1 option").each(function () {                    
                var text = $(this).text();               
                if ($("#schoolname1 option:contains('" + text + "')").length > 1)
                    $("#schoolname1 option:contains('" + text + "'):gt(0)").remove();
            });                    
        },        
        error: function(){alert("error!!!");}        
    });
}

</script>
</head>
<body>
<%@ include file="/page/top.jsp" %>  
<!--左边导航栏-->
<%@ include file="/page/aLeft.jsp" %> 
<!--右边内容区-->
<div id="id_11">
<!--添加删除修改-->
<div class="id_12">
<div class="id_13"><span>系统管理</span><i></i><a href="<%=basePath%>account/getAccountList">账号管理</a></div>
<div class="id_14">
</div>
</div>
<!--表格区-->
<div class="id_21">
<form action="<%=basePath%>account/updateAccount" id="accountForm" method="post">
<div class="id_26" style="float:left">
<table class="id_27">
    <tbody>
    <input type="hidden" name="id" value="${user.id}"/>
    <input id="sname" type="text" name="schoolname" value="${user.schoolname }" style="display:none">
    <tr>
      <th scope="row">账号</th>
      <td><div class="form-group"><input type="text" class="form-control" name="usercode" value="${user.usercode}"> </div></td>
    </tr>
 
    <tr >
      <th scope="row">新密码</th>
      <td><div class="form-group"><input type="password" class="form-control" name="password" > </div></td>
    </tr>
    <tr>
      <th scope="row">权限</th>
      <td><div class="form-group">
      	<select id="level" name="level" class="form-control" onchange="change(this.value)">  
    		<option value="1"  <c:if test="${user.level==1 }"> selected="selected"</c:if>>普通用户</option>  
    		<option value="2"  <c:if test="${user.level==2 }"> selected="selected"</c:if>>审核人员</option>
    		<option value="3"  <c:if test="${user.level==3 }"> selected="selected"</c:if>>市州管理员</option>
    		<option value="4"  <c:if test="${user.level==4 }"> selected="selected"</c:if>>管理员</option>
	 	</select>
	  </div></td>
    </tr>
  
     <tr id="tr1" <c:if test="${3 eq user.level }"> style="display: none"</c:if>>
      <th scope="row">学校名称</th>
      <td><div class="form-group">
	      	<select id="schoolname1" name="schoolname" class="form-control">  
	    		
		 	</select>
	 	 </div>
	  </td>
    </tr>
     <tr id="tr2" <c:if test="${3 ne user.level }">style="display: none"</c:if>>
      <th scope="row">地区</th>
      <td><div class="form-group">
	      	<select id="schoolname2" name="schoolname" class="form-control">  
	    		<option value="成都" <c:if test="${user.schoolname=='成都' }"> selected="selected"</c:if>>成都</option>   
	    		<option value="自贡" <c:if test="${user.schoolname=='自贡' }"> selected="selected"</c:if>>自贡</option>  
	    		<option value="攀枝花" <c:if test="${user.schoolname=='攀枝花' }"> selected="selected"</c:if>>攀枝花</option>  
	    		<option value="泸州" <c:if test="${user.schoolname=='泸州' }"> selected="selected"</c:if>>泸州</option>  
	    		<option value="德阳" <c:if test="${user.schoolname=='德阳' }"> selected="selected"</c:if>>德阳</option>  
	    		<option value="绵阳" <c:if test="${user.schoolname=='绵阳' }"> selected="selected"</c:if>>绵阳</option>  
	    		<option value="广元" <c:if test="${user.schoolname=='广元' }"> selected="selected"</c:if>>广元</option>  
	    		<option value="遂宁" <c:if test="${user.schoolname=='遂宁' }"> selected="selected"</c:if>>遂宁</option>  
	    		<option value="内江" <c:if test="${user.schoolname=='内江' }"> selected="selected"</c:if>>内江</option>  
	    		<option value="乐山" <c:if test="${user.schoolname=='乐山' }"> selected="selected"</c:if>>乐山</option>  
	    		<option value="南充" <c:if test="${user.schoolname=='南充' }"> selected="selected"</c:if>>南充</option>  
	    		<option value="宜宾" <c:if test="${user.schoolname=='宜宾' }"> selected="selected"</c:if>>宜宾</option>  
	    		<option value="广安" <c:if test="${user.schoolname=='广安' }"> selected="selected"</c:if>>广安</option>  
	    		<option value="巴中" <c:if test="${user.schoolname=='巴中' }"> selected="selected"</c:if>>巴中</option>  
	    		<option value="雅安" <c:if test="${user.schoolname=='雅安' }"> selected="selected"</c:if>>雅安</option>  
	    		<option value="眉山" <c:if test="${user.schoolname=='眉山' }"> selected="selected"</c:if>>眉山</option>  
	    		<option value="资阳" <c:if test="${user.schoolname=='资阳' }"> selected="selected"</c:if>>资阳</option>  
	    		<option value="阿坝州" <c:if test="${user.schoolname=='阿坝州' }"> selected="selected"</c:if>>阿坝州</option>  
	    		<option value="甘孜州" <c:if test="${user.schoolname=='甘孜州' }"> selected="selected"</c:if>>甘孜州</option>  
	    		<option value="凉山" <c:if test="${user.schoolname=='凉山' }"> selected="selected"</c:if>>凉山</option>  
	    		<option value="凉山州" <c:if test="${user.schoolname=='凉山州' }"> selected="selected"</c:if>>凉山州</option>  
		 	</select>
	 	 </div>
	  </td>
    </tr>
  </tbody>
</table>
   <div  >  			
		<c:if test="${detailFlag==0}">                                                
			<input class="id_31" id="submit" class="id_31" type="submit" value="提交">
			<input class="id_31" type="button" onclick="location.href='<%=basePath%>account/getAccountList'" value="返回">
		</c:if>
		<c:if test="${detailFlag==1}">                                                
			<input class="id_31" type="button" onclick="location.href='<%=basePath%>account/getAccountList'" value="返回">
		</c:if>
	</div>
</div>

</form>
</div>
</div>

<script>
function change(value) {
    if (value == "3") {    	
        $("#tr1").hide();
        $("#tr2").show();
    } else {
        $("#tr2").hide();
        $("#tr1").show();
    }
}
total = document.documentElement.clientHeight;
colHeight = total-document.getElementById("id_05").offsetTop;
document.getElementById("id_05").style.height=colHeight+"px";
document.getElementById("id_11").style.height=colHeight+"px";
document.getElementById("id_content").style.height=colHeight+"px";
</script>
</body>
</html>