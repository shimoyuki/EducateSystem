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
<script type="text/javascript" src="<%=basePath%>js/funds.js"></script>
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

var reg = /(^0$)|(^[0-9]\d*(\.\d{1,2})?$)/;
function checkNull(id,flag){
	var num = document.getElementById(id).value;	
	if(num==null||num==''){
		if(flag==1){
			alert("项目名称不可为空！");
		}
		if(flag==2){
			alert("项目金额不可为空！");
		}
	}else{
		if(flag==2){
			if(!reg.test(num)){
				alert("项目金额须为小数位数不超过两位的数字！");
			}
		}
	}
	
}

var  count = 0;	
function addTable() {
	
    var table = $("#FormView1_Table2");   
    var tr = $("<tr id=" + count + "></tr>");  
    var s1 = $("<td style='border: none'><select id='select" + count + "' name='select" + count + "' style='border: none' class='id_37'><option>-请选择-</option><option value='0'>中央专项资金</option><option value='1'>省级专项资金</option><option value='2'>市级专项资金</option></select></td>");    
    var td1 = $("<td style='border: none'> <input type='text' onblur=\"checkNull('name" + count + "','1')\" id='name" + count + "' name='name" + count + "' class='id_34'/></td>");
    var td2 = $("<td style='border: none'> <input type='text' onblur=\"checkNull('funds" + count + "','2')\" id='funds" + count + "' name='funds" + count + "' class='id_34'/></td>");
    var bt = $("<td style='border: none'><button type='button' id='button1' name='button1' onclick=\"deleteTable(" + count + ")\" class='id_31' style='border: none'>-</button></td>");
  
    s1.appendTo(tr);
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

function saveFunds(){
	
	var year = document.getElementById("year").value;
	var centerFund = document.getElementById("centerFund").value;
	var localFund = document.getElementById("localFund").value;
	var debt = document.getElementById("debt").value;
	var loan = document.getElementById("loan").value;
	var appropriation = document.getElementById("appropriation").value;
	var teacInputRadio = document.getElementById("teacInputRadio").value;
	/* var teacherTrain = document.getElementById("teacherTrain").value; */
	var teachChange = document.getElementById("teachChange").value;
	var fundBudget = document.getElementById("fundBudget").value;
	var tableObj={			
			type:"",
			name:"",
			funds:""			
	};	
	
	var a = JSON.parse("{\"data\":[]}");
	
	var rows = document.getElementById("FormView1_Table2").rows.length;	
	
	if(rows > 1){
		
	for (var i = 1; i < rows; i++){
	
		tableObj = new Object();
		
		tableObj.type = document.getElementById("FormView1_Table2").rows[i].cells[0].getElementsByTagName("select")[0].value;
		
		tableObj.name = document.getElementById("FormView1_Table2").rows[i].cells[1].getElementsByTagName("input")[0].value;
		
		tableObj.funds = document.getElementById("FormView1_Table2").rows[i].cells[2].getElementsByTagName("input")[0].value;
		
		if(tableObj.type=='-请选择-'||tableObj.type==null){
			alert("资金项目类型不可为空！");
			//window.location.reload();
			return;
		}else if(tableObj.name==''||tableObj.name==null){
			alert("项目名称不可为空！");
			//window.location.reload();
			return;
		}else if(tableObj.funds==''||tableObj.funds==null){
			alert("项目金额不可为空！");
			//window.location.reload();
			return;
		}else if(!reg.test(tableObj.funds)){
			alert("项目金额须为小数位数不超过两位的数字！");
			//window.location.reload();
			return;			
		}else{
			a.data.push(tableObj);
		}					
	}
	
	var params=JSON.stringify(a);
	 
	 $.ajax({
        url: "<%=basePath%>funds/saveFundsTable",
        type: "post",
        datatype: "json",
        //contentType:"application/x-www-form-urlencoded",
        data: {
        		params:params,
        		year:year,
        		centerFund:centerFund,
        		localFund:localFund,
        		debt:debt,
        		loan:loan,
        		appropriation:appropriation,
        		teacInputRadio:teacInputRadio,
        		/* teacherTrain:teacherTrain, */
        		teachChange:teachChange,
        		fundBudget:fundBudget
        	  },
        success: function (data){
	              	if("success" == data.result){  
	      	            alert("保存成功");  
	      	            $(window).attr('location','<%=basePath%>funds/getFundsList');
	      	        }else{  
	      	            alert(data.result); 
	      	            $('#fundsForm').bootstrapValidator('disableSubmitButtons', false);
	      	        }  
	              },
	    error: function(){alert("error!!!");}
    }); 
	}else{
		$.ajax({
	        url: "<%=basePath%>funds/saveFundsTable",
	        type: "post",
	        datatype: "json",
	        //contentType:"application/x-www-form-urlencoded",
	        data: {
	        		year:year,
	        		centerFund:centerFund,
	        		localFund:localFund,
	        		debt:debt,
	        		loan:loan,
	        		appropriation:appropriation,
	        		teacInputRadio:teacInputRadio,
	        		/* teacherTrain:teacherTrain, */
	        		teachChange:teachChange,
	        		fundBudget:fundBudget
	        	  },
	      success: function (data){
	              	if("success" == data.result){  
	      	            alert("保存成功"); 
	      	          	$(window).attr('location','<%=basePath%>funds/getFundsList');		      	         
	      	        }else{  
	      	           alert(data.result);
	      	          $('#fundsForm').bootstrapValidator('disableSubmitButtons', false);
	      	        }  
	              },
	      error: function(){alert("error!!!");}
	    });
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
<div class="id_13"><span>举办者履职</span><i></i><a href="<%=basePath%>funds/getFundsList">经费</a></div>
<div class="id_14">
</div>
</div>
<!--表格区-->
<div id="id_25" style="border: none;">
<form action="" id="fundsForm" method="post">
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
      <th scope="row">中央财政投入经费（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" id="centerFund" name="centerFund"></div></td>      
    </tr>
    <tr>
      <th scope="row">地方财政投入经费（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" id="localFund"  name="localFund"></div></td>
    </tr>
    <tr>
      <th scope="row">学校负债总额（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" id="debt"  name="debt"></div></td>
    </tr>
    <tr >
      <th scope="row">贷款总额（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" id="loan"  name="loan"></div></td>
    </tr>
  </tbody>
    </table>
</div>
<div class="id_26" style="float:left">
<table class="id_27">
      <tbody>
    <tr >
      <th scope="row">生均拨款（元）</th>
      <td><div class="form-group"><input type="text" class="form-control" id="appropriation"  name="appropriation"></div></td>
    </tr>
    <tr >
      <th scope="row">日常教学经费投入比例</th>
      <td><div class="form-group"><input type="text" class="form-control" id="teacInputRadio"  name="teacInputRadio"></div></td>
    </tr>
    <!-- <tr>
      <th scope="row">当年教师培训经费（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" id="teacherTrain"  name="teacherTrain"></div></td>
    </tr> -->
    <tr>
      <th scope="row">教学改革经费（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" id="teachChange"  name="teachChange"></div></td>
    </tr>
    <tr>
      <th scope="row">教科研经费（万元）</th>
      <td><div class="form-group"><input type="text" class="form-control" id="fundBudget"  name="fundBudget"></div></td>
    </tr>
  </tbody>
    </table>
    </div>

	 <div class="id_32" style="float: left; border: none">
	         <h5><span id="FormView1_Label2"></span>添加项目投入</h5>                   
	            <div>
	                   <button id="Button1" type="button" onclick="addTable()" class="id_31">+</button>
	                     
	               <table id="FormView1_Table2" border="0">
					<tr>
						<td valign="middle" style="border-width:0px;">资金项目类型</td>
						<td valign="middle" style="border-width:0px;">项目名称</td>
						<td valign="middle" style="border-width:0px;">项目金额（万元）</td>
					</tr>
					</table>					
	             </div>
	      </div>
	
	<div class="id_29" style="clear:both">
		<input class="id_31" type="submit"  value="提交">
		<input class="id_31" type="button" onclick="location.href='<%=basePath%>funds/getFundsList'" value="返回">
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