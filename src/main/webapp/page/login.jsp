<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据采集系统</title>
<link href="css/sjcj.css" rel="stylesheet" />
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('input, textarea').placeholder();
	});
	function SubmitKeyClick(button) {
		if (event.keyCode == 13) {
			event.keyCode = 9;
			event.returnValue = false;
			document.all[button].click();
		}
	}
	function del(){
		$("#username").val("");
		$("#password").val("");
	}
</script>
</head>
<body class="lg_bg">
	<form action="login" method="post" id="login_form">
		<div class="lg_01">
			<div class="lg_02">
				<div class="lg_03"></div>
				<div class="lg_05">
					<ul>
						<li class="lg_07">USER&nbsp;LOGIN</li>
						<c:if test="${'0' eq isNull }">
							<span>账号不存在</span>
						</c:if>
						<c:if test="${'0' eq isError }">
							<span>密码错误</span>
						</c:if>
						<li><input type="text" class="lg_08" id="username"
							<c:choose>
								<c:when test="${cookie.loginName!=null }">value="${cookie.loginName.value}"</c:when>
								<c:otherwise>value=""</c:otherwise>
							</c:choose>
							name="username" placeholder="请输入用户名"></li>

						<li><input type="password" class="lg_09" id="password" 
							<c:choose>
								<c:when test="${cookie.loginPwd!=null }">value="${cookie.loginPwd.value}"</c:when>
								<c:otherwise>value=""</c:otherwise>
							</c:choose>
							name="password" autocomplete="off" placeholder="请输入密码"></li>
						<li class="lg_12">
							<input type="checkbox" id="checkbox_01" name="chk" class="chk_1" ${cookie.loginName!=null?"checked":"" }> 
							<label for="checkbox_01"></label> 
							<span>记住用户名和密码
							<a href="page/operate.jsp" style="list-style: none; margin-left: 60px; text-decoration: none; font-size: 12px; color: #fff;">操作说明</a>
							</span>
						</li>
							
						<li><input class="lg_13" type="button" value="重新填写" onclick="del()">
							<input class="lg_14" type="submit" value="登录系统"></li>
					</ul>
				</div>
			</div>
		</div>
	</form>
</body>
</html>