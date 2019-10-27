<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link href="../css/sjcj.css" rel="stylesheet" />
<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/jquery.placeholder.min.js"></script>
<script type="text/javascript">
	
	function checkTel() {
		var str = '';
		if ($.trim($('#tel').val()).length == 0) {
			str += '手机号没有输入\n';
			alert(str);
			return false;
		} else {
			var pPhone = /^(1{1}[0-9]{10})|[0-9]{3,4}-[0-9]{7,8}$/;
			if (!pPhone.test($('#tel').val())) {
				str += '手机号码不正确\n';
				alert(str);
				return false;
			}
		}
		return true;
	}
	function checkMail() {
		var str = '';
		if ($.trim($('#mail').val()).length == 0) {
			str += '邮箱没有输入\n';
			alert(str);
			return false;
		} else {
			var mail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			if (!mail.test($('#mail').val())) {
				str += '邮箱不正确\n';
				alert(str);
				return false;
			}
		}
		return true;
	}
	function isConfirm() {
	
		return checkTel()&&checkMail();

	}
</script>
</head>
<body style="background-color:#a0c8d7">
	<form action="<%=basePath %>page/info" method="post" id="info_form">
		 <div style="border: none;position:absolute;left:45%;top:25%;margin:-150px 0 0 -200px;width:600px;height:400px">
		 	<div id="id_25" style="border:none">
		 		 <div class="id_26"  id="left">
		 		 	<table class="id_27">
		 		 		<tbody>
		 		 			 <tr>
		 		 			 	 <th scope="row">姓名</th>
		 		 			 	 <td style="border: none">
		 		 			 	    <input type="text" class="id_28" name="usercode" value="${usercode }" style="display: none">
		 		 			 	 	<input type="text" class="id_28" name="level" value="${level }" style="display: none">
		 		 			 	 	<input type="text" class="id_28" name="name">
		 		 			 	 </td>
		 		 			 </tr>
		 		 			 <tr>
		 		 			 	 <th scope="row">职务</th>
		 		 			 	 <td style="border: none">
		 		 			 	 	<input type="text" class="id_28" name="post">
		 		 			 	 </td>
		 		 			 </tr>
		 		 			 <tr>
		 		 			 	 <th scope="row">职称</th>
		 		 			 	 <td style="border: none">
		 		 			 	 	<input type="text" class="id_28" name="position">
		 		 			 	 </td>
		 		 			 </tr>
		 		 			 <tr>
		 		 			 	 <th scope="row">联系电话</th>
		 		 			 	 <td style="border: none">
		 		 			 	 	<input id="tel" type="text" class="id_28" name="telnumber" onblur="checkTel()">
		 		 			 	 </td>
		 		 			 </tr>
		 		 			 
		 		 			 <tr>
		 		 			 	 <th scope="row">邮箱</th>
		 		 			 	 <td style="border: none">
		 		 			 	 	<input id="mail" type="text" class="id_28" name="mailbox" onblur="checkMail()">
		 		 			 	 	<input id="logincount" type="hidden" class="id_28" name="logincount" value="1">
		 		 			 	 </td>
		 		 			 </tr>
		 		 		</tbody>
		 		 	</table>
		 		 </div>
		 	</div>
		 	<div class="id_29" style="clear: both">
		 		<input class="id_30" type="button" value="取消">
		 		<input class="id_31" type="submit" value="提交" onclick="return isConfirm();">
		 	</div>
		 </div>
	</form>
</body>
</html>