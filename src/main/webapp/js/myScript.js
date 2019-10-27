var schools = new Array();
var targets = new Array();
var years = new Array();
var areas = new Array();
var types = new Array();

var fieldName = new Array();
var fieldName1 = new Array();
var fieldName2 = new Array();
var fieldName3 = new Array();
var useDiv = new Array();
var unit = "";

var schoollist = "";
var targetlist = "";
var yearlist = "";
var arealist = "";
var typelist = "";


var columnData = "";
var pieData = "";
var lineData = "";
var categories = "";

var count = 0;

function getArea() {
    $.ajax({
        url: "getArea",
        type: "POST",
        data: {
            name: name,
        },
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        success: function (data) {
            for (var tmp in data) {
                $('#arealist').multiSelect('addOption', { value: data[tmp], text: data[tmp] });
            }
            var area = $("#area").val().split(",");
            $("#area").val("");
            $('#arealist').multiSelect('select', area);
        },
        error: function () {
            alert("获取地区名称失败。");
        }
    });
}

function getType() {
    
    $('#typelist').multiSelect('addOption', { value: '公办', text: '公办', nested: '办学性质' });
    $('#typelist').multiSelect('addOption', { value: '民办', text: '民办', nested: '办学性质' });
    $('#typelist').multiSelect('addOption', { value: '混合制', text: '混合制', nested: '办学性质' });
    $('#typelist').multiSelect('addOption', { value: '一般', text: '一般', nested: '办学水平' });
    $('#typelist').multiSelect('addOption', { value: '国示校', text: '国示校', nested: '办学水平' });
    $('#typelist').multiSelect('addOption', { value: '国重校', text: '国重校', nested: '办学水平' });
    $('#typelist').multiSelect('addOption', { value: '省重校', text: '省重校', nested: '办学水平' });
    $('#typelist').multiSelect('addOption', { value: '教育行政部', text: '教育行政部', nested: '办学主体' });
    $('#typelist').multiSelect('addOption', { value: '人社部门', text: '人社部门', nested: '办学主体' });
    $('#typelist').multiSelect('addOption', { value: '行业', text: '行业', nested: '办学主体' });
    var target = $("#type").val().split(",");
    //console.log(target);
    $("#type").val("");
    $('#typelist').multiSelect('select', target);
}
function getYear() {

    var myDate = new Date();
    //  alert(myDate.getFullYear());
    for (var i = myDate.getFullYear(); i >=2015; i--) {
        $('#yearlist').multiSelect('addOption', { value: i, text: i });
    }
    var year = $("#year").val().split(",");
    $("#year").val("");
    $('#yearlist').multiSelect('select', year);
}
function getSchool() {
	
    setCondition();
  
    $.ajax({
        url: "getSchool",
        type: "POST",
        data: {
            arealist: arealist,
            typelist: typelist
        },
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "text",
        success: function (data) {
            var jsonData = $.parseJSON(data);
            if (types.length != 0) {
            	$('#schoollist option').each(function(){
            		this.remove();
            	});
            	$('#schoollist').multiSelect('refresh');
                for (var i = 0; i < jsonData.length; i++) {
                	//console.log(jsonData[i]);
                    switch (jsonData[i].type) {
                        case "公办":
                            $('#schoollist').multiSelect('addOption', { value: jsonData[i].name, text: jsonData[i].name, nested: "办学性质-公办" });
                            break;
                        case "民办":
                            $('#schoollist').multiSelect('addOption', { value: jsonData[i].name, text: jsonData[i].name, nested: "办学性质-民办" });
                            break;
                        case "混合制":
                            $('#schoollist').multiSelect('addOption', { value: jsonData[i].name, text: jsonData[i].name, nested: "办学性质-混合制" });
                            break;
                        case "一般":
                            $('#schoollist').multiSelect('addOption', { value: jsonData[i].name, text: jsonData[i].name, nested: "办学水平-一般" });
                            break;
                        case "国示校":
                            $('#schoollist').multiSelect('addOption', { value: jsonData[i].name, text: jsonData[i].name, nested: "办学水平-国示校" });
                            break;
                        case "国重校":
                            $('#schoollist').multiSelect('addOption', { value: jsonData[i].name, text: jsonData[i].name, nested: "办学水平-国重校" });
                            break;
                        case "省重校":
                            $('#schoollist').multiSelect('addOption', { value: jsonData[i].name, text: jsonData[i].name, nested: "办学水平-省重校" });
                            break;
                        case "教育行政部":
                            $('#schoollist').multiSelect('addOption', { value: jsonData[i].name, text: jsonData[i].name, nested: "办学主体-教育行政部" });
                            break;
                        case "人社部门":
                            $('#schoollist').multiSelect('addOption', { value: jsonData[i].name, text: jsonData[i].name, nested: "办学主体-人社部门" });
                            break;
                        case "行业":
                            $('#schoollist').multiSelect('addOption', { value: jsonData[i].name, text: jsonData[i].name, nested: "办学主体-行业" });
                            break;
                    }

                }
            } else {
                for (var i = 0; i < jsonData.length; i++) {
                   
                    $('#schoollist').multiSelect('addOption', { value: jsonData[i].name, text: jsonData[i].name, nested: "任意" });
                }
            }
            var school = $("#school").val().split(",");
            $("#school").val("");
            $('#schoollist').multiSelect('select', school);
        },
        error: function () {
            arealist = "";
            alert("获取学校名称失败。");
        }
    });

}
function getTarget() {
    var name = $("#model option:selected").val();
    //alert(name);
    $.ajax({
        url: "getTarget?" + encodeURIComponent(name),
        type: "POST",
        data: {
            name: name,
        },
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        success: function (data) {
            //alert(data);
            for (var tmp in data) {
                $('#targetlist').multiSelect('addOption', { value: data[tmp], text: data[tmp] });
            }
            var target = $("#target").val().split(",");
            $("#target").val("");
            $('#targetlist').multiSelect('select', target);
        },
        error: function () {
            alert("获取指标名称失败。");
        }
    });
}

function changeType(){
	count = (count + 1) % 3;
	document.getElementById('container'+count).style.display='block';
	document.getElementById('container'+((count + 1) % 3)).style.display='none';
	document.getElementById('container'+((count + 2) % 3)).style.display='none';
}

function setCondition() {
    yearlist = $("#year").val();
    years = yearlist.split(',');

    arealist = $("#area").val();
    areas = arealist.split(',');

    typelist = $("#type").val();
    types = typelist.split(',');

    targetlist = $("#target").val();
    targets = targetlist.split(',');

    schoollist = $("#school").val();
    schools = schoollist.split(',');
    
}

function selectChange() {
	sessionStorage.value = $("#model option:selected").val();
	var href = window.location.href, action;
	if (href.indexOf("get") >= 0) {
		action = href.substring(href.indexOf("get"));
		action = action.replace("get", "");
		action = action.replace("Chart", "");
		window.location.href = action.toLowerCase()
	}
}

$(document).ready(function () {
    $("#model option[value='" + sessionStorage.value + "']").attr("selected", true);
    $("#type").val(sessionStorage.type);
    if (window.location.href.indexOf('get') < 0) {
		sessionStorage.removeItem('type');
	}
    
    $('#schoollist').multiSelect({
        selectableOptgroup: true,
        afterSelect: function (value) {
            if ($("#school").val() == '') {
                $("#school").val(value);
            } else {
                $("#school").val($("#school").val() + "," + value);
            }
        },
        afterDeselect: function (value) {
        		$("#school").val($("#school").val().replace(',' + value, ''));
				$("#school").val($("#school").val().replace(value , ''));
				if ($("#school").val().indexOf(',') == 0) {
					$("#school").val($("#school").val().substring(1));
				}
        }
    });
    $('#targetlist').multiSelect({
    	afterSelect: function (value) {
            if ($("#target").val() == '') {
                $("#target").val(value);
            } else {
                $("#target").val($("#target").val() + "," + value);
            }
        },
        afterDeselect: function (value) {
        		$("#target").val($("#target").val().replace(',' + value, ''));
				$("#target").val($("#target").val().replace(value , ''));
				if ($("#target").val().indexOf(',') == 0) {
					$("#target").val($("#target").val().substring(1));
				}
        }
    });
    $('#yearlist').multiSelect({
       
        afterSelect: function (value) {
            if ($("#year").val() == '') {
                $("#year").val(value);
                //  years.push(value);
            } else {
                $("#year").val($("#year").val() + "," + value);
                //  years.push(value);
            }
        },
        afterDeselect: function (value) {
        		$("#year").val($("#year").val().replace(',' + value, ''));
				$("#year").val($("#year").val().replace(value , ''));
				if ($("#year").val().indexOf(',') == 0) {
					$("#year").val($("#year").val().substring(1));
				}
        }
    });
    $('#arealist').multiSelect({
    	afterSelect: function (value) {
            if ($("#area").val() == '') {
                $("#area").val(value);
            } else {
                $("#area").val($("#area").val() + "," + value);
            }
        },
        afterDeselect: function (value) {
        		$("#area").val($("#area").val().replace(',' + value, ''));
				$("#area").val($("#area").val().replace(value , ''));
				if ($("#area").val().indexOf(',') == 0) {
					$("#area").val($("#area").val().substring(1));
				}
        }
    });
    $('#typelist').multiSelect({
        selectableOptgroup: true,
        afterSelect: function (value) {
            if ($("#type").val() == '') {
                $("#type").val(value);
            } else {
                $("#type").val($("#type").val() + "," + value);
            }
            sessionStorage.type = $("#type").val();
        },
        afterDeselect: function (value) {
        		$("#type").val($("#type").val().replace(',' + value, ''));
				$("#type").val($("#type").val().replace(value , ''));
				if ($("#type").val().indexOf(',') == 0) {
					$("#type").val($("#type").val().substring(1));
				}
        }
    });
});