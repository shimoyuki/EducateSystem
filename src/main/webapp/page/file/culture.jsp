<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据采集系统</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<link href="<%=basePath%>/css/sjcj.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${App_Path}/js/jquery-1.7.1.js"></script>
<script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>/js/jquery.placeholder.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
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
        url: "<%=basePath%>file/getSchoolNameList",            
        success: function (data) {          
        	eval(data);  
            for (var tmp in data) {
                $("#schoolName").append("<option value='" + data[tmp].admcode + "'>" + data[tmp].schoolname + "</option>"); 
            }
           
            $("#schoolName option").each(function () {                    
                var text = $(this).text();
                
                if ($("#schoolName option:contains('" + text + "')").length > 1)
                    $("#schoolName option:contains('" + text + "'):gt(0)").remove();
            });                    
        },        
        error: function(){alert("error!!!");}        
    });
}
	function del(id){  
	    $.get("<%=basePath%>file/del?id=" + id,function(data){  
	        if("success" == data.result){  
	            alert("删除成功");  
	            window.location.reload();  
	        }else{  
	            alert("删除失败");  
	        }  
	    });  
	}
	function findYear(){   
		$('#sn').val($('#schoolName option:selected').text());	
   	 	var form = document.getElementById("myForm");  
	    form.action = "<%=basePath%>file/getFileList?source=culture";
		form.method = "post";
		form.submit();
	}
	$(function() {//使用ajax完成审核通过操作
		$(".audit").click(function() {
		$addr = $(this);
			$.ajax({
				data : {
				id:  $addr.attr("name")
				},
				type : "get",
				dataType : 'json',
				url : "<%=basePath%>file/audit",
				error : function(data) {
					alert("删除出错");
				},
				success : function(data) {
					if (data.result == "success") {
						window.location.reload();
					} else {
						alert("修改出错");
					}
				}
			});
		});
	});
</script>
</head>
<body>
<%@ include file="/page/top.jsp"%>
	<!--左边导航栏-->
	<%@ include file="/page/left.jsp"%>
	<!--右边内容区-->
	<div id="id_11">
		<c:if test="${not empty FileMore}">
			<div id="message" class="alert alert-success">
				<button data-dismiss="alert" class="close">×</button>${FileMore}
			</div>
		</c:if>
		<c:if test="${not empty FileLess}">
			<div id="message" class="alert alert-success">
				<button data-dismiss="alert" class="close">×</button>${FileLess}
			</div>
		</c:if>
		<c:if test="${not empty FileExsited}">
			<div id="message" class="alert alert-success">
				<button data-dismiss="alert" class="close">×</button>${FileExsited}
			</div>
		</c:if>
		<div class="id_12">
			<div class="id_13">
				<span>资料上传</span><i></i><a href="#">传统文化（地方特色）教育活动开展情况</a>
			</div>
			<c:if test="${level < 3}">
			<form id="myForm" method="POST">
			<div class="id_14">
				<div class="id_18">			
					<c:if test="${year eq null||year eq ''}">
				  		<input type="text" class="id_19" id="year" name="year" placeholder="请输入年份查询">
				  	</c:if>
				  	<c:if test="${year != null&&year != ''}">
				  		<input type="text" class="id_19" id="year" name="year" value="${year}">
				  	</c:if>			
						<input type="submit" value="" class="id_20" onclick="findYear()">	
				</div>
			</div>
			</form>
			</c:if>	
			<c:if test="${level eq 3}">
			<form  id="myForm">
			<div class="id_14">
                <div>
                    <span id="ctl00_content_Label1">年份</span>
							<select class="id_28" id="year" name="year" >
							<c:choose>
							<c:when test="${year eq ''}">
								<option value="">全部</option>
							</c:when>
							<c:when test="${year eq null}">
								<option value="">全部</option>
							</c:when>
							<c:otherwise>
								<option value="${year}">${year}</option>
							</c:otherwise>
							</c:choose>
								<option value="">全部</option>
							</select>
							 <span id="ctl00_content_Label2">学校</span>
							<select class="id_28" id="schoolName" name="schoolName">
							<c:choose>
							<c:when test="${schoolName eq ''}">
								<option value="">全部</option>
							</c:when>
							<c:when test="${schoolName eq null}">
								<option value="">全部</option>
							</c:when>
							<c:otherwise>
								<option value="${schoolName}"><%=session.getAttribute("sn") %></option>
							</c:otherwise>
							</c:choose>	
								<option value="">全部</option>							
							</select>
							<input type="hidden" id="sn"  name="sn" />
							<input type="submit" onclick="findYear()" value="查询"  class="id_31" />
                
					</div>
 	  			</div>
			</form>
			</c:if>				  
			<div class="id_12">
				<div>	
					<c:if test="${level eq 1 }">		
					<form action="<%=basePath%>file/upload"  method="post" enctype="multipart/form-data">
					   <div style="float:left;height:60px;margin:15px 8px 0">
					   		<input style="display:none" name="source" value="culture" />
		           			<input type="file" name="file"/>   
					   </div>
					   <div style="float:left;height:60px;margin:15px 8px 0">
					   		<input type="submit" class="button" value="上 传" />
					   </div>
		            	
		            </form>  
		            </c:if>
	            </div>
            </div>  
     	
			<!--表格区-->
			
			<div class="id_21">
				<table class="id_22">
					<thead>
						<tr>
							<th style="text-align:center;">招生代码</th>
							<th style="text-align:center;">文件名</th>
							<th style="text-align:center;">上传时间</th>
							<th style="text-align:center;">审核</th>
							<c:if test="${level eq 2 }">
          					<th style="text-align:center;">操作</th>
         				    </c:if>
						</tr>
					</thead>
					<tbody>
						<c:if test="${!empty pageInfo }">
							<c:forEach items="${pageInfo.list}" var="fileinfo">
								<tr>
									<td>${fileinfo.writer}</td>
									<td>${fileinfo.name}</td>
									<td>${fileinfo.writetime}</td>									
									<td>${fileinfo.audit=="0"?"未审核":"已审核"}</td>
									<c:if test="${fileinfo.audit==0}">
										
											<c:if test="${level eq 2 }">
												<td>
													<a href="#" name="${fileinfo.id}" class="audit">通过</a>
												</td>
											</c:if>
										
									</c:if>
									<c:if test="${fileinfo.audit==1}">
										
										<c:if test="${level eq 2 }">
											<td>通过</td>
										</c:if>
									</c:if>
									<td>
									<a href="<%=basePath%>file/download?id=${fileinfo.id} " class="id_23">下载</a>
									<c:if test="${level eq 1 }">
										<c:if test="${fileinfo.audit==0}">
											<a href="javascript:del('${fileinfo.id }')" class="id_23">删除</a>
										</c:if>
										<c:if test="${fileinfo.audit==1}">
											<a href="javascript:void()" class="id_23" style="background:#CCCCCC">删除</a>
										</c:if>
									</c:if>										 
									</td>
									
								</tr>
							</c:forEach>
						</c:if>
						
					</tbody>
				</table>
			</div>
			<div style="float: right;">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="<%=basePath%>file/getFileList?source=culture&pn=1">首页</a></li>

					<c:if test="${pageInfo.hasPreviousPage}">
						<li><a href="<%=basePath%>file/getFileList?source=culture&pn=${pageInfo.pageNum-1}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:if>

					<c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
						<c:if test="${pageNum==pageInfo.pageNum}">
							<li class="active">
								<a href="#">${pageNum}</a>
							</li>
						</c:if>
						<c:if test="${pageNum!=pageInfo.pageNum}">
							<li>
								<a href="<%=basePath%>file/getFileList?source=culture&pn=${pageNum}">${pageNum}</a>
							</li>
						</c:if>
					</c:forEach>

					<c:if test="${pageInfo.hasNextPage}">
						<li>
							<a href="<%=basePath%>file/getFileList?source=culture&pn=${pageInfo.pageNum+1}" aria-label="Next">
							 <span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>

					<li><a href="<%=basePath%>file/getFileList?source=culture&pn=${pageInfo.pages}">末页</a></li>
				</ul>
				</nav>
			</div>
		
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