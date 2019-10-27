<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">

	$(function() {
		$('input, textarea').placeholder();
	});
	$(function() {
		$(".id_10");
		$(".id_08").click(function() {
			$(this).toggleClass("open").next().slideToggle("fast");
		});
	});
	
</script>
<!--左边导航栏-->
<div id="id_content">
<div id="id_05">
<div class="id_06">
<div class="id_07"></div>
<p>
	<%=session.getAttribute("schoolname") %>
</p>
</div>
<a href="#" class="id_08"><div class="icon_01"></div><span>系统管理</span></a>
<div class="id_10">
<a href="<%=session.getAttribute("base") %>/account/getAccountList">账号管理</a>
<a href="<%=session.getAttribute("base")%>/writeSituation/getWriteSituation">填报情况</a>
</div>
<a href="#" class="id_08"><div class="icon_02"></div><span>基础数据导入</span></a>
<div class="id_10">
<a href="<%=session.getAttribute("base") %>/school/showSchoolInfo">学校信息导入</a>
<a href="<%=session.getAttribute("base") %>/major/showMajorInfo">专业信息导入</a>
</div>
<a href="#" class="id_08"><div class="icon_03"></div><span>数据查询</span></a>
<div class="id_10">
<a href="<%=session.getAttribute("base")%>/dataQuery/getDataQueryList">数据查询</a>
</div>
<a href="#" class="id_08"><div class="icon_04"></div><span>综合分析</span></a>
<div class="id_10">
<a href="<%=session.getAttribute("base")%>/dataSumAndAvg/getDataSumAndAvg">数据分析</a>
<a href="<%=session.getAttribute("base")%>/provinceDataStatistics/getProvinceDataStatisticsList">全省数据统计</a>
<a href="<%=session.getAttribute("base")%>/cityDataStatistics/getCityDataStatisticsList">市州数据统计</a>
<a href="<%=session.getAttribute("base")%>/chartAnalysis/basic">图表分析</a>
</div>

</div>