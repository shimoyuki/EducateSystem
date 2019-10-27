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
<link href="<%=basePath%>/css/sjcj.css" rel="stylesheet" type="text/css">
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
	<link href="https://static.jianshukeji.com/highcharts/images/favicon.ico" rel="icon">
<link href="<%=basePath%>/css/multi-select.css" rel="stylesheet" type="text/css">
<script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>/js/jquery.placeholder.min.js"></script>
<script src="<%=basePath%>/js/jquery.multi-select.js"></script>
<script src="<%=basePath%>/js/jquery.quicksearch.js"></script>
<script src="<%=basePath%>/js/pagination.js"></script>
<script src="<%=basePath%>/js/pdfobject.js"></script>
<script src="<%=basePath%>/js/myScript.js"></script>
<script src="<%=basePath%>/js/highcharts/highstock.js"></script>
<script src="<%=basePath%>/js/highcharts/modules/exporting.js">
<script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</script>
<script type="text/javascript">
$(document).ready(function () {
	$('#average').attr("checked", false);
	if ("${average}" == "on") {
		$("#average").prop("checked",true);
	}
});
</script>
</head>
<body>
	<%@ include file="/page/top.jsp"%>
	<!--左边导航栏-->
	<%@ include file="/page/aLeft.jsp"%>
	<!--右边内容区-->
	<div id="id_11">
		<div id="hd_menu" align="center"
			style="overflow: auto; text-align: center">
			<ul style="margin: 0 auto;">
				<li><a href="<%=session.getAttribute("base") %>/chartAnalysis/basic"
					style="float: left; list-style: none; margin: 5px 10px 5px 10px; text-decoration: none">基本情况
				</a></li>
				<li><a href="<%=session.getAttribute("base") %>/chartAnalysis/students"
					style="float: left; list-style: none; margin: 5px 10px 5px 10px; text-decoration: none">学生发展
				</a></li>
				<li><a href="<%=session.getAttribute("base") %>/chartAnalysis/quality"
					style="float: left; list-style: none; margin: 5px 10px 5px 10px; text-decoration: none">质量保障措施
				</a></li>
				<li><a href="<%=session.getAttribute("base") %>/chartAnalysis/enterprise"
					style="float: left; list-style: none; margin: 5px 10px 5px 10px; text-decoration: none">校企合作
				</a></li>
				<li><a href="<%=session.getAttribute("base") %>/chartAnalysis/social"
					style="float: left; list-style: none; margin: 5px 10px 5px 10px; text-decoration: none">社会贡献
				</a></li>
				<li><a href="<%=session.getAttribute("base") %>/chartAnalysis/organizer"
					style="float: left; list-style: none; margin: 5px 10px 5px 10px; text-decoration: none">举办者履职
				</a></li>
				<li><a href="<%=session.getAttribute("base") %>/chartAnalysis/partybuild"
					style="float: left; list-style: none; margin: 5px 10px 5px 10px; text-decoration: none">党建工作
				</a></li>
				<li><a href="<%=session.getAttribute("base") %>/chartAnalysis/standard"
					style="float: left; list-style: none; margin: 5px 10px 5px 10px; text-decoration: none">国家有关中职学校设置标准
				</a></li>
			</ul>
		</div>
		<div class="id_12">
			<form id="myForm" method="post"
				action="<%=basePath%>chartAnalysis/getPartyBuildChart">
				<div style="overflow: auto;">
					内容： <select id="model" name="content" class="id_40" onchange="selectChange()">
						<option value="partybulid">学校党建工作</option>
					</select> 
					年份： <input type="text" id="year" name="year" class="id_40" value="${yearlist }"
						onfocus="document.getElementById('light0').style.display='block';"
						onclick="getYear()" /> 
					地区： <input type="text" id="area"
						name="area" class="id_40" value="${arealist }"
						onfocus="document.getElementById('light3').style.display='block';"
						onclick="getArea()" /> 
					指标： <input type="text" id="target"
						name="target" class="id_40" value="${targetlist }"
						onfocus="document.getElementById('light2').style.display='block';"
						onclick="getTarget()" />
				</div>
				<div style="overflow: auto;">
					学校类型： <input type="text" id="type" name="type" class="id_40"
						onfocus="document.getElementById('light4').style.display='block';"
						onclick="getType()" /> 
					学校： <input type="text" id="school"
						name="school" class="id_40" value="${schoollist }"
						onfocus="document.getElementById('light1').style.display='block';"
						onclick="getSchool()" /> <input type="checkbox" id="average" name="average"/> 
					计算省、市、州平均值
					<button type="submit" id="query" class="id_31">查询</button>
					<input type="button" id="changeModel" onclick="changeType()"
						value="切换视图" class="id_31" />
				</div>
			</form>
		</div>
		<!--表格区-->
		<div class="id_21" style="margin-top: 20px">
		<div style="overflow: auto;position:absolute;z-index:1;text-align:center;" id="flow1">
					<div id="light0"
				style="display: none; margin-top:50px; margin-left: 300px; background-color: white; border: 16px solid #0978ad;">
				<select id="yearlist" name="yearlist[]" multiple="multiple">
				</select> <a href="javascript:void(0)"
					onclick="document.getElementById('light0').style.display='none';"
					style="list-style: none; margin-left: 15px; text-decoration: none; font-size: 18px; color: #0978ad;">确定</a>
			</div>
			<div id="light1" style="display: none; margin-top:50px; margin-left: 300px; background-color: white; border: 16px solid #0978ad;">
				<select multiple="multiple" id="schoollist" name="schoollist[]">
					<optgroup label='办学性质-公办'>
					</optgroup>
					<optgroup label='办学性质-民办'>
					</optgroup>
					<optgroup label='办学性质-混合制'>
					</optgroup>
					<optgroup label='办学水平-一般'>
					</optgroup>
					<optgroup label='办学水平-国示校'>
					</optgroup>
					<optgroup label='办学水平-国重校'>
					</optgroup>
					<optgroup label='办学水平-省重校'>
					</optgroup>
					<optgroup label='办学主体-教育行政部'>
					</optgroup>
					<optgroup label='办学主体-人社部门'>
					</optgroup>
					<optgroup label='办学主体-行业'>
					</optgroup>
					<optgroup label='任意'>
					</optgroup>
				</select> <a href="javascript:void(0)"
					onclick="document.getElementById('light1').style.display='none';"
					style="list-style: none; margin-left: 15px; text-decoration: none; font-size: 18px; color: #0978ad;">确定</a>
			</div>
			<div id="light2" style="display: none; margin-top:50px; margin-left: 300px; background-color: white; border: 16px solid #0978ad;">
				<select multiple="multiple" id="targetlist" name="targetlist[]">
				</select> <a href="javascript:void(0)"
					onclick="document.getElementById('light2').style.display='none';"
					style="list-style: none; margin-left: 15px; text-decoration: none; font-size: 18px; color: #0978ad;">确定</a>
			</div>
			<div id="light3" style="display: none; margin-top:50px; margin-left: 300px; background-color: white; border: 16px solid #0978ad;">
				<select multiple="multiple" id="arealist" name="arealist[]">
				</select> <a href="javascript:void(0)"
					onclick="document.getElementById('light3').style.display='none';"
					style="list-style: none; margin-left: 15px; text-decoration: none; font-size: 18px; color: #0978ad;">确定</a>
			</div>
			<div id="light4" style="display: none; margin-top:50px; margin-left: 300px; background-color: white; border: 16px solid #0978ad;">
				<select multiple="multiple" id="typelist" name="typelist[]">
					<optgroup label='办学性质'>
					</optgroup>
					<optgroup label='办学水平'>
					</optgroup>
					<optgroup label='办学主体'>
					</optgroup>
				</select> <a href="javascript:void(0)"
					onclick="document.getElementById('light4').style.display='none';"
					style="list-style: none; margin-left: 15px; text-decoration: none; font-size: 18px; color: #0978ad;">确定</a>
			</div>
					</div>
			<div id="container0" style="float: left; width: 1100px; height: 500px; margin: 5px;" align="center">
			</div>
			<div id="container1" style="float: left; width: 1100px; height: 500px; margin: 5px;;display:none;" align="center">
			</div>
			<div id="container2" style="float: left; width: 1100px; height: 500px; margin: 5px;;display:none;" align="center">
			</div>
			<script type="text/javascript">
				var year = ${year};
				var content = "${content}";
				var target = ${target};
				var targetField = ${targetField};
				var dataList = ${dataList};
				
				$(function() {
					eval(year);
					eval(target);
					eval(targetField);
					eval(dataList);
					if (dataList.length == 0) {
						$('#container0').append("<h3>未查询到相关结果</h3>");
						return;
					}
					//console.log(target);
					//console.log(targetField);
					//console.log(JSON.stringify(dataList));
					for ( var tmp in dataList) {
						for ( var tmps in dataList[tmp]) {
							//console.log(JSON.stringify(dataList[tmp][tmps]));
						}
					}

					var yLabel = {};
					switch (content) {
					case "partybulid":
						yLabel = {text : '人'}
						break;
					default:
						break;
					}
					
					var ctg = new Array(), series = new Array(), serie, data, match, pieSeries = new Array(), pieSerie, pieData;
					for (var i = 0; i < year.length; i++) {
						for (var j = 0; j < target.length; j++) {
							ctg.push(year[i] + '\r\n' + target[j]);
						}
					}
					for (var i = 0; i < year.length; i++) {
						for (var j = 0; j < targetField.length; j++) {
							pieSerie={};
							pieData = new Array();
							for ( var adm in dataList) {
								for ( var per in dataList[adm]) {
									if (dataList[adm][per]['year'] == year[i]) {
										var value = eval('dataList[adm][per]["'+ targetField[j] + '"]');
										if (typeof(value) ==  'string' && value.indexOf("%") >= 0) {
												value = parseFloat(value.substring(0, value.length - 1));
										}
										pieData.push([dataList[adm][per]["admcode"], value]);
										pieSerie['type'] = 'pie';
										pieSerie['name'] = year[i] + '\r\n' + target[j];
										pieSerie['data'] = pieData;
									}
								}
							}
							if (!$.isEmptyObject(pieSerie)) {
								pieSeries.push(pieSerie);
							}
						}
					}
					for ( var adm in dataList) {
						serie = {};
						data = new Array();
						
						for (var i = 0; i < year.length; i++) {
							for (var j = 0; j < targetField.length; j++) {
								match = false;
								for ( var per in dataList[adm]) {
									if (dataList[adm][per]['year'] == year[i]) {
										var value = eval('dataList[adm][per]["'+ targetField[j] + '"]');
										if (typeof(value) ==  'string' && value.indexOf("%") >= 0) {
												value = parseFloat(value.substring(0, value.length - 1));
										}
										data.push(value);
										match = true;
									}
								}
								if (!match) {
									data.push('');
								}
							}
						}
						serie['name'] = dataList[adm][0]['admcode'];
						serie['data'] = data;
						series.push(serie);
					}
					//console.log(ctg);
					//console.log(JSON.stringify(series));
					//console.log(JSON.stringify(pieSeries));
					$('#container0').highcharts({
										chart : {
											type : 'column'
										},
										title : {
											text : '指标分析图'
										},
										xAxis : {
											min : 0,
											max : 5,
											categories : ctg,
											crosshair : true
										},
										yAxis : {
											min : 0,
											title : yLabel
										},
										//设置滚动条    
										scrollbar : {
											enabled : true
										},
										tooltip : {
											headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
											pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' + '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
											footerFormat : '</table>',
											shared : true,
											useHTML : true
										},
										plotOptions : {
											column : {
												pointPadding : 0.2,
												borderWidth : 0,
												dataLabels: {
								                    enabled: true,
								                    formatter: function() {
								                    	if(typeof(this.y)=="undefined"){ 
								                    		return '';
								                    	}
								                    	return '' + (this.y);
								                    }, 
								                }
											}
										},
										series : series
									});
					$('#container1').highcharts({
						title : {
							text : '指标分析图'
						},
						xAxis : {
							min : 0,
							max : 5,
							categories : ctg,
							crosshair : true
						},
						yAxis : {
							min : 0,
							title : yLabel
						},
						//设置滚动条    
						scrollbar : {
							enabled : true
						},
						tooltip : {
							headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
							pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' + '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
							footerFormat : '</table>',
							shared : true,
							useHTML : true
						},
						plotOptions : {
							line : {
								pointPadding : 0.2,
								borderWidth : 0,
								dataLabels: {
				                    enabled: true,
				                    formatter: function() {
				                    	if(typeof(this.y)=="undefined"){ 
				                    		return '';
				                    	}
				                    	return '' + (this.y);
				                    }, 
				                }
							}
						},
						series : series
					});
					for (var i = 0; i < pieSeries.length; i++) {
						$('#container2').append("<div id='piechart" + i + "' style='float: left; min-width: 500px; min-height: 400px; margin: 5px' align='center'></div>");
						$('#piechart'+i).highcharts({
							chart: {
					            plotBackgroundColor: null,
					            plotBorderWidth: null,
					            plotShadow: false
					        },
					        title: {
					            text: '指标分析图',
					        },
					        tooltip: {
					            headerFormat: '{series.name}<br>',
					            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
					        },
					        plotOptions: {
					            pie: {
					                allowPointSelect: true,
					                cursor: 'pointer',
					                dataLabels: {
					                    enabled: true,
					                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
					                    style: {
					                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
					                    }
					                }
					            }
					        },
					        series: [pieSeries[i]]
						});
					}
				});
				</script>
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