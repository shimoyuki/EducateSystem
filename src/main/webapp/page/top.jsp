<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#message").hide();
	});
	function showDialog(id){
		
		$.ajax({  
	        data:"id="+id,  
	        type:"GET",  
	        dataType: "json",  
	        url:"<%=session.getAttribute("base")%>/information",
	        error:function(data){  
	            alert("出错了！！:"+data.msg);  
	        },  
	        success:function(data){  	        	
	        	$("#name").val(data.name);
	        	$("#post").val(data.post);
	        	$("#position").val(data.position);
	        	$("#tel").val(data.telnumber);
	        	$("#mail").val(data.mailbox);
	        }  
	    });
	
		$('#myinfo').modal({
	        keyboard: true
	    });
	}	
	function showPass(){
		$('#mypass').modal({
	        keyboard: true
	    });
	}
	function ain(){
		$("#message").hide();
	}
	function change(id){		
		var oPass=$("#oPass").val();
		var nPass=$("#nPass").val();
		var nPassAgain=$("#nPassAgain").val();		
		if(nPassAgain!=nPass){
			$("#message").show();
			$("#oPass").val("");
    		$("#nPass").val("");
    		$("#nPassAgain").val("");
		}else{
			$.ajax({  
		        data:{
		        	id:id,
		        	oPass:oPass,
		        	nPass:nPass
		        },	
		        type:"POST",  
		        dataType: "text",  
		        url:"<%=session.getAttribute("base")%>/change",        
		        success:function(data){  	        	
		        	if(data=="success"){
		        		alert("修改成功");
		        		$("#oPass").val("");
		        		$("#nPass").val("");
		        		$("#nPassAgain").val("");
		        		$("#mypass").modal("hide");        		
		        	}      		
		        	else
		        		alert("原密码错误");
		        },
		        error:function(data){  
		            alert("出错了！！:"+data.msg);  
		        }
		    });
		}	
	}
	function  changes(){
		alert("888888!");
	}
</script>
<div class="id_01">
	<div class="id_02"></div>
	<div class="id_03">
		
		<a href="javascript:" onclick="showDialog('${sessionScope.username}');"
			class="id_04">个人信息</a> 
		<a href="javascript:" class="id_04" onclick="showPass('${sessionScope.username}');">修改密码</a> 
		<a href="<%=session.getAttribute("base")%>/logout" class="id_04">退出系统</a>
	</div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myinfo" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">个人信息</h4>
			</div>
			<div class="modal-body">
				
					<div id="id_25" style="border: none;">
						<div class="id_26">
							<table class="id_27">
								<tbody>
									<tr>
										<th scope="row">姓名</th>
										<td style="border: none">
											<input id="name" type="text" class="id_28" name="name" readonly="readonly"></td>
									</tr>
									<tr>
										<th scope="row">职务</th>
										<td style="border: none">
											<input id="post" type="text" class="id_28" name="post" readonly="readonly"></td>
									</tr>
									<tr>
										<th scope="row">职称</th>
										<td style="border: none">
											<input id="position" type="text" class="id_28" name="position" readonly="readonly"></td>
									</tr>
									<tr>
										<th scope="row">联系电话</th>
										<td style="border: none">
											<input id="tel" type="text" class="id_28" name="telnumber" readonly="readonly"></td>
									</tr>

									<tr>
										<th scope="row">邮箱</th>
										<td style="border: none">
											<input id="mail" type="text" class="id_28" name="mailbox" readonly="readonly" ></td>
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
<!-- /.modal -->
<!-- 模态框（Modal） -->
<div class="modal fade" id="mypass" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">修改密码</h4>
			</div>
			<div id="message" class="alert alert-success">
				<button data-dismiss="alert" class="close">×</button>确认密码与新密码不一致
			</div>
			<div class="modal-body">
					<div id="id_25" style="border: none;">
						<div class="id_26">
							<table class="id_27">
								<tbody>
									<tr>
										<th scope="row">原密码</th>
										<td style="border: none">
											<input id="oPass" type="password" class="id_28" name="oPass"></td>
									</tr>
									<tr>
										<th scope="row">新密码</th>
										<td style="border: none">
											<input id="nPass" type="password" class="id_28" name="nPass"></td>
									</tr>
									<tr>
										<th scope="row">确认密码</th>
										<td style="border: none">
											<input id="nPassAgain" type="password" class="id_28" name="nPassAgain" onFocus="ain()">																			
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>	
						<button type="button" class="btn btn-primary" onclick="change('${sessionScope.username}');">提交更改</button>				
					</div>
				
			</div>

		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->