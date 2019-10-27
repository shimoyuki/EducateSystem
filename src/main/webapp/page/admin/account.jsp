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
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<link href="<%=basePath%>/css/sjcj.css" rel="stylesheet" type="text/css">
<script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>/js/jquery.placeholder.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script type="text/javascript">
function findAccount(){
    var form = document.getElementById("myForm");    
    form.action = "<%=basePath%>account/getAccountList";    
    form.method="post";    
    form.submit();  
}
function del(id){  
    $.get("<%=basePath%>account/delAccount?id=" + id,function(data){  
        if("success" == data.result){  
            //alert("删除成功");  
            window.location.reload();  
        }else{  
            alert("删除失败");  
        }  
    });  
}
function show(id){	
	$.ajax({  
        data:"id="+id,  
        type:"GET",  
        dataType: "json",  
        url:"<%=basePath%>/information",
        error:function(data){
        	$("#accname").val("");
        	$("#accpost").val("");
        	$("#accposition").val("");
        	$("#acctel").val("");
        	$("#accmail").val("");
        	$("#acccount").val("");
        },  
        success:function(data){  	        	
        	$("#accname").val(data.name);
        	$("#accpost").val(data.post);
        	$("#accposition").val(data.position);
        	$("#acctel").val(data.telnumber);
        	$("#accmail").val(data.mailbox);
        	$("#acccount").val(data.logincount);
        }  
    });

	$('#accountinfo').modal({
        keyboard: true
    });
}	
</script>
</head>
<body>
	<%@ include file="/page/top.jsp"%>
	<!--左边导航栏-->
	<%@ include file="/page/aLeft.jsp"%>
	<!--右边内容区-->
	<div id="id_11">
		<!--添加删除修改-->
		<div class="id_12">
			<div class="id_13">
				<span>系统管理</span><i></i><a href="<%=basePath%>account/getAccountList">账号管理</a>
			</div>
			<form id="myForm" method="POST">
				<div class="id_14">
					<a href="<%=basePath%>account/toAddAccount" class="id_16"></a>
					<div class="id_18">
						<c:if test="${account eq null||account eq ''}">
							<input type="text" class="id_19" id="account" name="account"
								placeholder="请输入账号查询">
						</c:if>
						<c:if test="${account != null&&account != ''}">
							<input type="text" class="id_19" id="account" name="account"
								value="${account}">
						</c:if>
						<input type="submit" value="" class="id_20" onclick="findAccount()">
					</div>
				</div>
			</form>
		</div>
		<div class="id_12_half">
			<div style="float:left;margin-left:15px"> 
				已分配账号总数/已使用账号总数：${userCount}/${infoCount}
			</div>
			<div style="float:left;margin-left:15px"> 
				磁盘总量/占用磁盘总量：${totalspace}/${totalsize}
			</div>
		</div>
		<!--表格区-->
		<div class="id_21">
			<table class="id_22">
				<thead>
					<tr>
						<th style="text-align:center;">账号</th>
						<th style="text-align:center;">密码</th>
						<th style="text-align:center;">权限</th>
						<th style="text-align:center;">所属单位</th>
						<th style="text-align:center;">${s}</th>
						<th style="text-align:center;">${y}</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty pageInfo }">
						<c:forEach items="${pageInfo.list}" var="user">
							<tr>
								<td>${user.usercode}</td>
								<td>******</td>
								<td>
									<c:choose> 
									<c:when test="${1 eq user.level}">
										普通用户
									</c:when>
									<c:when test="${2 eq user.level }">
										审核人员
									</c:when>
									<c:when test="${3 eq user.level }">
										市州管理员
									</c:when>
									<c:otherwise>
										管理员
									</c:otherwise>
									</c:choose>
								</td>
								<td>${user.schoolname}</td>

								<td><c:if test="${level eq 4}">
								
										<a href="<%=basePath%>account/getAccount?id=${user.id}&detailFlag=0"
											class="id_23">修改</a>
										<a href="javascript:del('${user.id }')" onclick="return confirm('确定删除?');" class="id_23">删除</a>
									</c:if> <a href="javascript:" onclick="show('${user.usercode }');" class="id_23">详细信息</a> </td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody> 
			</table>
		</div>

		<div style="float: right;">
			<nav aria-label="Page navigation">
			<ul class="pagination">
				<li><a
					href="<%=basePath%>account/getAccountList?pn=1&accounts=${account}">首页</a></li>

				<c:if test="${pageInfo.hasPreviousPage}">
					<li><a
						href="<%=basePath%>account/getAccountList?pn=${pageInfo.pageNum-1}&accounts=${account}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>


				<c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
					<c:if test="${pageNum==pageInfo.pageNum}">
						<li class="active"><a href="#">${pageNum}</a></li>
					</c:if>
					<c:if test="${pageNum!=pageInfo.pageNum}">
						<li><a
							href="<%=basePath%>account/getAccountList?pn=${pageNum}&accounts=${account}">${pageNum}</a></li>
					</c:if>
				</c:forEach>

				<c:if test="${pageInfo.hasNextPage}">
					<li><a
						href="<%=basePath%>account/getAccountList?pn=${pageInfo.pageNum+1}&accounts=${account}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>

				<li><a
					href="<%=basePath%>account/getAccountList?pn=${pageInfo.pages}&accounts=${account}">末页</a></li>
			</ul>
			</nav>
		</div>


	</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="accountinfo" tabindex="-1" role="dialog"
	aria-labelledby="accountModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="accountModalLabel">个人信息</h4>
			</div>
			<div class="modal-body">
				
					<div id="id_25" style="border: none;">
						<div class="id_26">
							<table class="id_27">
								<tbody>
									<tr>
										<th scope="row">姓名</th>
										<td style="border: none">
											<input id="accname" type="text" class="id_28" name="name" readonly="readonly"></td>
									</tr>
									<tr>
										<th scope="row">职务</th>
										<td style="border: none">
											<input id="accpost" type="text" class="id_28" name="post" readonly="readonly"></td>
									</tr>
									<tr>
										<th scope="row">职称</th>
										<td style="border: none">
											<input id="accposition" type="text" class="id_28" name="position" readonly="readonly"></td>
									</tr>
									<tr>
										<th scope="row">联系电话</th>
										<td style="border: none">
											<input id="acctel" type="text" class="id_28" name="telnumber" readonly="readonly"></td>
									</tr>
									<tr>
										<th scope="row">邮箱</th>
										<td style="border: none">
											<input id="accmail" type="text" class="id_28" name="mailbox" readonly="readonly" ></td>
									</tr>
									
									<tr>
										<th scope="row">登录次数</th>
										<td style="border: none">
											<input id="acccount" type="text" class="id_28" name="logincount" readonly="readonly" ></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>					
					</div>
			
			</div>

		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
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