(function($){
        $.fn.serializeCoun = function(){
            var jsonData1 = {};
            var serializeArray = this.serializeArray();
            // 先转换成{"id": ["12","14"], "name": ["aaa","bbb"], "pwd":["pwd1","pwd2"]}这种形式
            $(serializeArray).each(function () {
                if (jsonData1[this.name]) {
                    if ($.isArray(jsonData1[this.name])) {
                        jsonData1[this.name].push(this.value);
                    } else {
                        jsonData1[this.name] = [jsonData1[this.name], this.value];
                    }
                } else {
                    jsonData1[this.name] = this.value;
                }
            });
            // 再转成[{"id": "12", "name": "aaa", "pwd":"pwd1"},{"id": "14", "name": "bb", "pwd":"pwd2"}]的形式
            var vCount = 0;
            // 计算json内部的数组最大长度
            for(var item in jsonData1){
                var tmp = $.isArray(jsonData1[item]) ? jsonData1[item].length : 1;
                vCount = (tmp > vCount) ? tmp : vCount;
            }

            //将动态输入项整合为list
                var  jsonList = new Array(), jsonTemp, jsonObj;
                for(var i = 0; i < vCount; i++){
                    jsonTemp = {};
                    for(var item in jsonData1) {
                    	if(item=='skillname' || item == 'projectname' || item == 'id'){
                        if (vCount > 1) {
                        	jsonTemp[item] = jsonData1[item][i];
						}else{
							jsonTemp[item] = jsonData1[item];
						}
                    	}
                    }
                    if(!$.isEmptyObject(jsonTemp)){
                    	jsonList.push(jsonTemp);
                    }
                }
                jsonObj = {};
                jsonObj['list'] = jsonList;
                //其它数据
                jsonTemp = {};
                for(var item in jsonData1) {
                	if(item !='skillname' && item != 'projectname' && item != 'id'){
                    jsonTemp[item] = jsonData1[item];
                	}
                }
                jsonObj['main'] = jsonTemp;
                
                return JSON.stringify(jsonObj);
        };
    })(jQuery);

(function($){
    $.fn.serializeSkill = function(){
        var jsonData1 = {};
        var serializeArray = this.serializeArray();
        // 先转换成{"id": ["12","14"], "name": ["aaa","bbb"], "pwd":["pwd1","pwd2"]}这种形式
        $(serializeArray).each(function () {
            if (jsonData1[this.name]) {
                if ($.isArray(jsonData1[this.name])) {
                    jsonData1[this.name].push(this.value);
                } else {
                    jsonData1[this.name] = [jsonData1[this.name], this.value];
                }
            } else {
                jsonData1[this.name] = this.value;
            }
        });
        // 再转成[{"id": "12", "name": "aaa", "pwd":"pwd1"},{"id": "14", "name": "bb", "pwd":"pwd2"}]的形式
        var vCount = 0;
        // 计算json内部的数组最大长度
        for(var item in jsonData1){
            var tmp = $.isArray(jsonData1[item]) ? jsonData1[item].length : 1;
            vCount = (tmp > vCount) ? tmp : vCount;
        }

        //将动态输入项整合为list
            var  jsonList = new Array(), jsonTemp, jsonObj;
            for(var i = 0; i < vCount; i++){
                jsonTemp = {};
                for(var item in jsonData1) {
                	if(item=='name' || item == 'id'){
                    if (vCount > 1) {
                    	jsonTemp[item] = jsonData1[item][i];
					}else{
						jsonTemp[item] = jsonData1[item];
					}
                	}
                }
                if(!$.isEmptyObject(jsonTemp)){
                	jsonList.push(jsonTemp);
                }
            }
            jsonObj = {};
            jsonObj['list'] = jsonList;
            //其它数据
            jsonTemp = {};
            for(var item in jsonData1) {
            	if(item !='name' && item != 'id'){
                jsonTemp[item] = jsonData1[item];
            	}
            }
            jsonObj['main'] = jsonTemp;
            
            return JSON.stringify(jsonObj);
    };
})(jQuery);

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
		}
	
	/**
	 * 必填数字项
	 */
	var reqNum = {
			verbose : false,
			validators : {
				notEmpty : {
					message : '必填项'
				},
				numeric : {
					message : '值必须是数字'
				},
				regexp: {
	                regexp: /(^0(\.\d{1,2})?$)|(^[1-9]\d*(\.\d{1,2})?$)/,
	                message: '需为小数位数不能超过两位的数字'
	            }
			}
		}
	
	skiTraFields = {};
	skiTraFields.localfoster = reqDig
	skiTraFields.localtrain = reqDig
	skiTraFields.ecnomicsocial = reqNum
	skiTraFields.trackproblemnum = reqDig

	socialFields = {};
	socialFields.trainstaff = reqDig
	socialFields.trainunabled = reqDig
	socialFields.trainunemstaff = reqDig
	socialFields.trainfarmer = reqDig
	socialFields.trainretiresoldier = reqDig
	socialFields.skillidentnum = reqNum
	socialFields.teachserve = reqNum

	counFields = {};
	counFields.helpobject = reqDig
	counFields.poverreductarget = reqDig
	counFields.fund = reqNum
	counFields.servicenum = reqDig

	$(document).ready(function() {
	$('#formSkiTra').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {/*输入框不同状态，显示图片的样式*/
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : skiTraFields
	}).on('success.form.bv', function(e) {//点击提交之后
		// Prevent form submission
		e.preventDefault();
		// Get the form instance
		var $form = $(e.target);
		console.log($form);
		// Get the BootstrapValidator instance
		var bv = $form.data('bootstrapValidator');
		// Use Ajax to submit form data 提交至form标签中的action，result自定义
		var jsonStr = $("#formSkiTra").serializeSkill();
		console.log("jsonStr:\r\n" + jsonStr);
		$.ajax({
			url : $form.attr('action'),
			type : "POST",
			contentType : 'application/json;charset=utf-8', //设置请求头信息
			dataType : "json",
			data : jsonStr,
			success : function(data) {
				if (data.result == "success") {
					window.location.href = "showSkiTraInfo";
				} else {
					alert(data.result);
					//$('#formSkiTra').bootstrapValidator('disableSubmitButtons', false); 
					$("#submit").attr("disabled", false);
				}
			},
			error : function(res) {
				alert(res.responseText);
			}
		});
	});

	$('#formSocial').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {/*输入框不同状态，显示图片的样式*/
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : socialFields
	}).on('success.form.bv', function(e) {//点击提交之后
		// Prevent form submission
		e.preventDefault();
		// Get the form instance
		var $form = $(e.target);
		console.log($form);
		// Get the BootstrapValidator instance
		var bv = $form.data('bootstrapValidator');
		// Use Ajax to submit form data 提交至form标签中的action，result自定义
		$.ajax({
			url : $form.attr('action'),
			type : "POST",
			dataType : "json",
			data :$form.serialize(),
			success : function(data) {
				if (data.result == "success") {
					window.location.href = "showSocialInfo";
				} else {
					alert(data.result);
					//$('#formSocial').bootstrapValidator('disableSubmitButtons', false); 
					$("#submit").attr("disabled", false);
				}
			},
			error : function(res) {
				alert(res.responseText);
			}
		});
	});

	$('#formCoun').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {/*输入框不同状态，显示图片的样式*/
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : counFields
	}).on('success.form.bv', function(e) {//点击提交之后
		// Prevent form submission
		e.preventDefault();
		// Get the form instance
		var $form = $(e.target);
		console.log($form);
		// Get the BootstrapValidator instance
		var bv = $form.data('bootstrapValidator');
		// Use Ajax to submit form data 提交至form标签中的action，result自定义
		var jsonStr = $("#formCoun").serializeCoun();
		console.log("jsonStr:\r\n" + jsonStr);
		$.ajax({
			url : $form.attr('action'),
			type : "POST",
			contentType : 'application/json;charset=utf-8', //设置请求头信息
			dataType : "json",
			data : jsonStr,
			success : function(data) {
				if (data.result == "success") {
					window.location.href = "showCounInfo";
				} else {
					alert(data.result);
					//$('#formCoun').bootstrapValidator('disableSubmitButtons', false); 
					$("#submit").attr("disabled", false);
				}
			},
			error : function(res) {
				alert(res.responseText);
			}
		});
	});

});