(function($){
        $.fn.serializeSchool = function(){
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
            var vSchoolt = 0;
            // 计算json内部的数组最大长度
            for(var item in jsonData1){
                var tmp = $.isArray(jsonData1[item]) ? jsonData1[item].length : 1;
                vSchoolt = (tmp > vSchoolt) ? tmp : vSchoolt;
            }

            //将动态输入项整合为list
                var  jsonList = new Array(), jsonTemp, jsonObj;
                for(var i = 0; i < vSchoolt; i++){
                    jsonTemp = {};
                    for(var item in jsonData1) {
                    	if(item=='majorcode' || item == 'id'){
                        if (vSchoolt > 1) {
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
                	if(item !='majorcode' && item != 'id'){
                    jsonTemp[item] = jsonData1[item];
                	}
                }
                jsonObj['main'] = jsonTemp;
                
                return JSON.stringify(jsonObj);
        };
    })(jQuery);

/**
	 * 必填项
	 */
	var required = {
			verbose : false,
			validators : {
				notEmpty : {
					message : '必填项'
				}
			}
		}
	
	fields = {};
	fields.majorcode = required
	fields.name = required
	fields.induname = required
	fields.skill = required
	fields.occupation = required
	fields.duration = required
	
	schoolFields = {};
	schoolFields.admcode = required
	schoolFields.schoolname = required
	schoolFields.schooladdr = required
	schoolFields.telenumber = required
	
	$(document).ready(function() {
		$('#formMajor').bootstrapValidator({
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
			$.ajax({
				url : $form.attr('action'),
				type : "POST",
				dataType : "json",
				data :$form.serialize(),
				success : function(data) {
					if (data.result == "success") {
						window.location.href = "showMajorInfo";
					} else {
						alert(data.result);
					}
				},
				error : function(res) {
					alert(res.responseText);
				}
			});
		});
		
		$('#formSchool').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {/*输入框不同状态，显示图片的样式*/
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : schoolFields
		}).on('success.form.bv', function(e) {//点击提交之后
			// Prevent form submission
			e.preventDefault();
			// Get the form instance
			var $form = $(e.target);
			console.log($form);
			// Get the BootstrapValidator instance
			var bv = $form.data('bootstrapValidator');
			// Use Ajax to submit form data 提交至form标签中的action，result自定义
			var jsonStr = $("#formSchool").serializeSchool();
			console.log("jsonStr:\r\n" + jsonStr);
			$.ajax({
				url : $form.attr('action'),
				type : "POST",
				contentType : 'application/json;charset=utf-8', //设置请求头信息
				dataType : "json",
				data : jsonStr,
				success : function(data) {
					if (data.result == "success") {
						window.location.href = "showSchoolInfo";
					} else {
						alert(data.result);
					}
				},
				error : function(res) {
					alert(res.responseText);
				}
			});
		});
		
	});