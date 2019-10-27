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
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<!-- 可选的 Bootstrap 主题文件（一般不用引入） --> 
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous"> 
<link href="<%=basePath%>/css/sjcj.css" rel="stylesheet" type="text/css">  
<script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>/js/jquery.placeholder.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 --> 
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<script type="text/javascript">
window.onload=function(){
	//设置年份的选择
	var myDate= new Date();
	var startYear=myDate.getFullYear();//起始年份
	var endYear=myDate.getFullYear()-30;//结束年份
	var obj=document.getElementById('year')
	for (var i=startYear;i>=endYear;i--)
	{
	obj.options.add(new Option(i,i));
	}
	
	$.ajax({
        url: "<%=basePath%>size/getSchoolNameList",            
        success: function (data) {          
        	eval(data);  
            for (var tmp in data) {
                $("#schoolName").append("<option value='" + data[tmp].admcode + "'>" + data[tmp].schoolname + "</option>"); 
            }
           
            $("#schoolName option").each(function () {                    
                var text = $(this).text();
                
                if ($("#schoolName option:contains('" + text + "')").length > 1)
                    $("#schoolName option:contains('" + text + "'):gt(0)").remove();
            })                    
        },        
        error: function(){alert("error!!!");}        
    });
	
}


function del(id,admcode,year){
	if(confirm('确认要删除?')){		
        	 $.get("<%=basePath%>majorLayout/delMajorLayout?id=" + id+"&"+"admcode=" + admcode+"&"+"year="+year,function(data){
        	        if("success" == data.result){  
        	            //alert("删除成功");  
        	            window.location.reload();  
        	        }else{  
        	            alert("删除失败");  
        	        }  
        	    });      
	}
}

function findYear(){ 
	var inputYear = document.getElementById("year");
	if(inputYear != null){
	year = inputYear.value;
	if (year != "" && !/^[1-9][0-9]{3,}$/.test(year)){
		alert("请输入正确的年份！");
		return false;
		}
	}
	$('#sn').val($('#schoolName option:selected').text());
    var form = document.getElementById("myForm");    
    form.action = "<%=basePath%>majorLayout/getMajorLayoutList";    
    form.method="post";    
    form.submit();   
}

function download(){
    var form = document.getElementById("myForm");    
    form.action="<%=basePath%>majorLayout/download";    
    form.method="post";    
    form.submit();  
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
<div class="id_13"><span>质量保障措施</span><i></i><a href="<%=basePath%>majorLayout/getMajorLayoutList">专业布局</a></div>
<c:if test="${level < 3}">
<form  id="myForm" method="POST">
<div class="id_14">
	<c:if test="${level eq 2}">
		<input type="submit" onclick="download()" value="导出"  class="id_31" />
	</c:if>
	<c:if test="${level eq 1}">
		<a href="<%=basePath%>majorLayout/download?year=${year}" >下载</a>
		<a href="<%=basePath%>majorLayout/toAddMajorLayout" class="id_16"></a>
	</c:if>
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
<form  id="myForm" method="post">
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
                    <input type="submit" onclick="download()" value="导出"  class="id_31" />
			</div>
 	  </div>
</form>
</c:if>		
</div>
<!--表格区-->
<div class="id_21">
<table class="id_22">
      <thead>
        <tr>      
          <th style="text-align:center;">招生代码</th>
          <th style="text-align:center;">年份</th>
          <th style="text-align:center;">一产类专业数</th>
          <th style="text-align:center;">二产类专业数</th>
          <th style="text-align:center;">三产类专业数</th>
          <th style="text-align:center;">审核</th>
          <c:if test="${level eq 2 }">
          <th style="text-align:center;">操作</th>
          </c:if>
        </tr>
      </thead>
      <tbody>
           <c:if test="${!empty pageInfo }">  
                <c:forEach items="${pageInfo.list}" var="majorLayout">  
                   <c:if test="${(majorLayout.audit==1&&level eq 3)||level eq 2||level eq 1}">  
                    <tr>  
                        <td>${majorLayout.admcode}</td>  
                        <td>${majorLayout.year}</td>                       
                        <td>${majorLayout.oneIndu}</td>
                        <td>${majorLayout.twoIndu}</td>
                        <td>${majorLayout.threeIndu}</td>                                                                                                       
                        <td>${majorLayout.audit=="0"?"未审核":"已审核"}</td>
                        
                        <c:if test="${level eq 2 }">
                        	<c:if test="${majorLayout.audit==0}">
                        		<td>
                        			<a href="<%=basePath%>majorLayout/updateAudit?id=${majorLayout.id}&detailFlag=0" class="audit">通过</a>
                        		</td>
                        	</c:if>
                        	<c:if test="${majorLayout.audit==1}">
                        		<td>通过</td>                      		                    		
                        	</c:if>                       
                        </c:if>
                                                                
                        <td>
                        <c:if test="${level eq 1 }">
                          <c:if test="${majorLayout.audit==0}">   
                            <a href="<%=basePath%>majorLayout/getMajorLayout?id=${majorLayout.id}&detailFlag=0" class="id_23">修改</a>  
                            <a href="javascript:del('${majorLayout.id }','${majorLayout.admcode }','${majorLayout.year }')" onclick="return confirm('确定删除?');" class="id_23">删除</a>
                          </c:if>
                          <c:if test="${majorLayout.audit==1}">   
                            <a href="#" class="id_23_1">修改</a>  
                            <a href="#" class="id_23_1">删除</a>
                          </c:if>
                         </c:if>
                            <a href="<%=basePath%>majorLayout/getMajorLayoutDetail?id=${majorLayout.id}&detailFlag=1" class="id_23">更多</a>  
                        </td>  
                    </tr>
                  </c:if>               
                </c:forEach>  
            </c:if>  
      </tbody>
    </table>
</div>

<%-- <div style="float:left;" >
当前记录数${pageInfo.pageNum}页，总${pageInfo.pages}页,总${pageInfo.total}条记录
</div> --%> 

<div style="float:right;">
<nav aria-label="Page navigation"> 
	<ul class="pagination">
		<li><a href="<%=basePath%>majorLayout/getMajorLayoutList?pn=1&years=${year}&schoolNames=${schoolName}">首页</a></li> 
		
		<c:if test="${pageInfo.hasPreviousPage}">
			<li> 
			<a href="<%=basePath%>majorLayout/getMajorLayoutList?pn=${pageInfo.pageNum-1}&years=${year}&schoolNames=${schoolName}" aria-label="Previous"> 
				<span aria-hidden="true">&laquo;</span> 
			</a> 
		</li>
		</c:if>
		
		
		<c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
			<c:if test="${pageNum==pageInfo.pageNum}">
			<li class="active"><a href="#">${pageNum}</a></li>
			</c:if>
			<c:if test="${pageNum!=pageInfo.pageNum}">
			<li><a href="<%=basePath%>majorLayout/getMajorLayoutList?pn=${pageNum}&years=${year}&schoolNames=${schoolName}">${pageNum}</a></li>
			</c:if>
		</c:forEach> 
		
		<c:if test="${pageInfo.hasNextPage}">
			<li> 
				<a href="<%=basePath%>majorLayout/getMajorLayoutList?pn=${pageInfo.pageNum+1}&years=${year}&schoolNames=${schoolName}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span> 
				</a> 
			</li>
		</c:if>
		
		<li><a href="<%=basePath%>majorLayout/getMajorLayoutList?pn=${pageInfo.pages}&years=${year}&schoolNames=${schoolName}">末页</a></li> 
	</ul> 
</nav>
</div>


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