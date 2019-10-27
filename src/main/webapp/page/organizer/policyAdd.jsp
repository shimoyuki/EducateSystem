<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据采集系统</title>
<link href="<%=basePath%>css/sjcj.css" rel="stylesheet" type="text/css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css"
	type="text/css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=basePath%>css/bootstrapValidator.min.css" type="text/css">
<script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/bootstrapValidator.min.js"></script>
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


/**
 * 必填整数项
 */
var reqDig = {
		verbose : false,
		validators : {
			notEmpty : {
				message : '必填项'
			},
			digits : {
				message : '值必须是整数'
			}
		}
	};



fields = {};
fields.teacher = reqDig;

$(document).ready(function() {
	$('#policyForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {/*输入框不同状态，显示图片的样式*/
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : fields
	}).on('success.form.bv', function(e) {//点击提交之后
		// Prevent form submission
		e.preventDefault();
		
		addPolicy();		
	});
			
});

function checkNull(id,flag){
	var num = document.getElementById(id).value;
	if(num==null||num==''){
		if(flag==1){
			alert("区域落实办学自主权政策名称不可为空！");
		}
		if(flag==2){
			alert("提升学校办学水平的政策和制度名称不可为空！");
		}
	}
	
}

var  count = 0;	
function addTable() {
	
    var table = $("#FormView1_Table3");   
    var tr = $("<tr id=" + count + "></tr>");  
    var td1 = $("<td style='border: none'> <input type='text' onblur=\"checkNull('autoRight" + count + "','1')\" id='autoRight" + count + "' name='autoRight" + count + "' class='id_34'/></td>");
    var td2 = $("<td style='border: none'> <input type='text' onblur=\"checkNull('level" + count + "','2')\" id='level" + count + "' name='lLevel" + count + "' class='id_34'/></td>");
    var bt = $("<td style='border: none'><button type='button' id='button1' name='button1' onclick=\"deleteTable(" + count + ")\" class='id_31' style='border: none'>-</button></td>");
   
    td1.appendTo(tr);
    td2.appendTo(tr);
    bt.appendTo(tr);
    tr.appendTo(table);
    
    count++;
}
	
function deleteTable(count) {
    
    var tr = $("#" + count + "");
    tr.remove();        
   
}	

function addPolicy(){
	$('#policyForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {/*输入框不同状态，显示图片的样式*/
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : fields
	}).on('success.form.bv', function(e) {//点击提交之后
		// Prevent form submission
		e.preventDefault();
		// Get the form instance
		var $form = $(e.target);
		console.log($form);
		// Get the BootstrapValidator instance
		var bv = $form.data('bootstrapValidator');
		// Use Ajax to submit form data 提交至form标签中的action，result自定义
				
	});
	var year = document.getElementById("year").value;
	
	var teacher = document.getElementById("teacher").value;
	
	var tableObj={
			autoRight:"",
			level:""			
	};	
	
	var a = JSON.parse("{\"data\":[]}");
	
	var rows = document.getElementById("FormView1_Table3").rows.length;	
	
	if(rows > 1){
		
	for (var i = 1; i < rows; i++){
	
	    tableObj = new Object();
		
		tableObj.autoRight = document.getElementById("FormView1_Table3").rows[i].cells[0].getElementsByTagName("input")[0].value;
		
		tableObj.level = document.getElementById("FormView1_Table3").rows[i].cells[1].getElementsByTagName("input")[0].value;
		
		if(tableObj.autoRight==null||tableObj.autoRight==''){
			alert("区域落实办学自主权政策名称不可为空！");
			//window.location.reload();
			return;
		}else if(tableObj.level==null||tableObj.level==''){
			alert("提升学校办学水平的政策和制度名称不可为空！");
			//window.location.reload();
			return;
		}else{
			a.data.push(tableObj);
		}						
	}
	
	var params=JSON.stringify(a);
	
		 
	 $.ajax({
        url: "<%=basePath%>policy/savePolicyTable",
        type: "post",
        datatype: "json",
        //contentType:"application/x-www-form-urlencoded",
        data: {params:params,
        	   year:year,
        	   teacher:teacher      	
        },
        success: function (data){
        	if("success" == data.result){  
	            alert("保存成功");  
	            $(window).attr('location','<%=basePath%>policy/getPolicyList');		  
	        }else{  
	            alert(data.result);  
	            $('#policyForm').bootstrapValidator('disableSubmitButtons', false);
	        }  
        },
        error: function(){alert("error!!!");}
    }); 
	}else{
		$.ajax({
	        url: "<%=basePath%>policy/savePolicyTable",
	        type: "post",
	        datatype: "json",
	        //contentType:"application/x-www-form-urlencoded",
	        data: {
	        	   year:year,
	        	   teacher:teacher      	
	        },
	        success: function (data){
	        	if("success" == data.result){  
		            alert("保存成功");  
		            $(window).attr('location','<%=basePath%>policy/getPolicyList');
					} else {
						alert(data.result);
						$('#policyForm').bootstrapValidator('disableSubmitButtons', false);
					}
				},
				error : function() {
					alert("error!!!");
				}
			});
		}

	}
</script>

</head>
<body>
	<%@ include file="/page/top.jsp"%>
	<!--左边导航栏-->
	<%@ include file="/page/left.jsp"%>
	<!--右边内容区-->
	<div id="id_11">
		<!--添加删除修改-->
		<div class="id_12">
			<div class="id_13">
				<span>举办者履职</span><i></i><a href="<%=basePath%>policy/getPolicyList">政策措施</a>
			</div>
			<div class="id_14"></div>
		</div>
		<!--表格区-->
		<div id="id_25" style="border: none;">
			<form action="" id="policyForm">
				<div class="id_26" style="float: left">
					<table class="id_27">
						<tbody>
							<tr>
								<th scope="row">年份</th>
								<td><div class="form-group">
										<select id="year" name="year" class="form-control">
										</select>
									</div></td>
							</tr>
							<tr>
								<th scope="row">年度新增教师编制数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="teacher"
											id="teacher">
									</div></td>
							</tr>
						</tbody>
					</table>
					</div>
					<div class="id_32" style="float: left; border: none">
						<h5>
							<span id="FormView1_Label3"></span>添加政策措施名称
						</h5>
						<div>
							<button id="Button1" type="button" onclick="addTable()"
								class="id_31">+</button>

							<table id="FormView1_Table3" border="0">
								<tr>
									<td valign="middle" style="border-width: 0px;">区域落实办学自主权政策名称</td>
									<td valign="middle" style="border-width: 0px;">提升学校办学水平的政策和制度名称</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="id_29" style="clear: both">
						<input class="id_31" type="submit"  value="提交">
						<input class="id_31" type="button"
							onclick="location.href='<%=basePath%>policy/getPolicyList'"
							value="返回">
					</div>
				
			</form>

		</div>
	</div>
	<script>
		total = document.documentElement.clientHeight;
		colHeight = total - document.getElementById("id_05").offsetTop;
		document.getElementById("id_05").style.height = colHeight + "px";
		document.getElementById("id_11").style.height = colHeight + "px";
		document.getElementById("id_content").style.height = colHeight + "px";
	</script>
</body>
</html>