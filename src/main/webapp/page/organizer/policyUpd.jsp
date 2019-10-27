<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script language="javascript" type="text/javascript">
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
	
		updatePolicy();		
	});
			
});

var isNull="isNull";
var count=0;
window.onload=function(){
	var id = document.getElementById('id').value;
	
	//生成表格
	$.ajax({
        url: "<%=basePath%>policy/getPolicyMeasure" ,
        type: "POST",
        data: {
        	id:id
        },
        dataType: "json",
        success: function (data) {                   
        	for(count=0;count<data.length;count++){       		
        		 
        		var table = $("#FormView1_Table3");        	    
        	    var tr = $("<tr id=" + count + "></tr>");       	    
        	    var td1 = $("<td style='border: none'> <input type='text' onblur=\"checkNull('autoRight" + count + "','1')\" id='autoRight" + count + "' name='autoRight" + count + "' class='id_34' value='"+data[count].autoRight+"'/></td>");
        	    var td2 = $("<td style='border: none'> <input type='text' onblur=\"checkNull('level" + count + "','2')\" id='level" + count + "' name='level" + count + "' class='id_34' value='"+data[count].level+"'/></td>");
        	    var bt = $("<td style='border: none'><button type='button' id='button1' name='button1' onclick=\"deleteTable(" + count + ")\" class='id_31' style='border: none'>-</button></td>");
        	    var td3 = $("<td style='border: none'> <input style='display:none' type='text' id='id" + count + "' name='id" + count + "' class='id_34' value='"+data[count].id+"' /></td>");
        	           	        	        
        	    td1.appendTo(tr);
        	    td2.appendTo(tr);       	   
        	    bt.appendTo(tr);
        	    td3.appendTo(tr);
        	    tr.appendTo(table);         	          	         	   
        	} 
        },
        error: function () {
            alert("error!!!!!");
        } 
    });
	
};

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

//添加动态Table行
function addTable() {
	
    var table = $("#FormView1_Table3");   
    var tr = $("<tr id=" + count + "></tr>");  
    var td1 = $("<td style='border: none'> <input type='text' onblur=\"checkNull('autoRight" + count + "','1')\" id='autoRight" + count + "' name='autoRight" + count + "' class='id_34'/></td>");
    var td2 = $("<td style='border: none'> <input type='text' onblur=\"checkNull('level" + count + "','2')\" id='level" + count + "' name='level" + count + "' class='id_34'/></td>");
    var bt = $("<td style='border: none'><button type='button' id='button1' name='button1' onclick=\"deleteTable(" + count + ")\" class='id_31' style='border: none'>-</button></td>");
    var td3 = $("<td style='border: none'> <input style='display:none' type='text' id='id" + count + "' name='id" + count + "' class='id_34' value='" + isNull+ "'/></td>");
    
    td1.appendTo(tr);
    td2.appendTo(tr);
    bt.appendTo(tr);
    td3.appendTo(tr);
    tr.appendTo(table);
    
    count++;
    
}

//删除动态Table行
function deleteTable(count) {
    
	var id = document.getElementById("id" + count + "").value;
	var tr = $("#" + count + "");
    if(id!="isNull"){
    	 $.ajax({
    	        url: "<%=basePath%>policy/deletePolicyTable",
    	        type: "post",
    	        datatype: "json",    	
    	        data: {id:id}
    	    }); 
    }
    
    tr.remove();        
    
}

function updatePolicy(){
	var year = document.getElementById("year").value;
	
	var teacher = document.getElementById("teacher").value;
	
	var idform = document.getElementById("id").value;
	
	var tableObj={
			id:"",
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
		
		tableObj.id = document.getElementById("FormView1_Table3").rows[i].cells[3].getElementsByTagName("input")[0].value;
	
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
        url: "<%=basePath%>policy/updatePolicyTable",
        type: "post",
        datatype: "json",
        //contentType:"application/x-www-form-urlencoded",
        data: {
               params:params,
               idform:idform,
               year:year,
     	       teacher:teacher      	
             },
     success: function (data){
     	if("success" == data.result){  
	            alert("保存成功");  
	            $(window).attr('location','<%=basePath%>policy/getPolicyList');
	        }else{  
	            alert("保存失败");  
	        }  
     },
     error: function(){alert("error!!!");}
    }); 
   }else{
		$.ajax({
	        url: "<%=basePath%>policy/updatePolicyTable",
	        type: "post",
	        datatype: "json",
	        //contentType:"application/x-www-form-urlencoded",
	        data: {
	        	   idform:idform,   
	        	   year:year,
	        	   teacher:teacher      	
	              },
	        success: function (data){
	        	if("success" == data.result){  
		            alert("保存成功");  
		            $(window).attr('location','<%=basePath%>policy/getPolicyList');
					} else {
						alert("保存失败");
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
							<input type="hidden" name="id" id="id" value="${policy.id}" />
							<tr>
								<th scope="row">年份</th>
								<td><div class="form-group">
										<input type="text" id="year" name="year" class="form-control"
											readonly="readonly" value="${policy.year}">
									</div></td>
							</tr>
							<tr>
								<th scope="row">年度新增教师编制数</th>
								<td><div class="form-group">
										<input type="text" class="form-control" name="teacher"
											id="teacher" value="${policy.teacher}">
									</div></td>
							</tr>
						</tbody>
					</table>
					</div>
					
					<div class="id_32" style="float: left; border: none">
						<h5>
							<span id="FormView1_Label3"></span>修改政策措施名称
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
					<div class="id_29" style="clear:both">
						<c:if test="${detailFlag==0}">
							<input class="id_31" type="submit" value="提交">
							<input class="id_31" type="button"
								onclick="location.href='<%=basePath%>policy/getPolicyList'"
								value="返回">
						</c:if>
						<c:if test="${detailFlag==1}">
							<input class="id_31" type="button"
								onclick="location.href='<%=basePath%>policy/getPolicyList'"
								value="返回">
						</c:if>
						<c:if test="${detailFlag==2}">
							<input class="id_31" type="button"
								onclick="location.href='<%=basePath%>dataQuery/getDataQueryList'"
								value="返回">
						</c:if>
						<c:if test="${detailFlag==3}">
							<input class="id_31" type="button"
								onclick="location.href='<%=basePath%>provinceDataStatistics/getProvinceDataStatisticsList'"
								value="返回">
						</c:if>
						<c:if test="${detailFlag==4}">
							<input class="id_31" type="button"
								onclick="location.href='<%=basePath%>cityDataStatistics/getCityDataStatisticsList'"
								value="返回">
						</c:if>
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