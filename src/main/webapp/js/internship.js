/**
 * 当前值应小于比较对象
 * @param box 比较对象<input>的name
 * @param tip 提示信息
 * @returns {___anonymous_staffprepjob}
 */
function toLessThan(box,tip) {
		var obj = {
			verbose : false,
			validators : {
				notEmpty : {
					message : '必填项'
				},
				numeric : {
					message : '值必须是数字'
				},
				callback : {
					message : tip,
					callback : function(value, validator, $field) {
						var otherbox = validator.getFieldElements(box).val();//获得另一个的值
						if (otherbox == '') {
							return false;
						}
						if (parseInt(value) < parseInt(otherbox)) {
							//validator.updateStatus(box, validator.STATUS_VALID, 'callback');
							return true;
						}
						return false;
					}
				}
			}
		}
		return obj
}
function sumUpTo(pbox, tp) {
	var obj = {
		validators : {
			notEmpty : {
				message : '必填项'
			},
			regexp: {
                regexp: /(^0(\.\d{1,2}%)?$)|(^1$)|(^100(\.0{1,2})?%$)|(^[1-9]\d?(\.\d{1,2})?%$)/,
                message: '请输入小数位数不超过两位的百分数'
            },
			callback : {
				message : '与'+tp+'之和应等于1',
				callback : function(value, validator, $field) {
					var part = [], i, sum;
					if(value.indexOf("%") >=0){
						sum = parseFloat(value.substring(0, value.length - 1));
					}else{
						sum = parseFloat(value);
					}
					for(i = 0; i < pbox.length; i++){
						part[i] = validator.getFieldElements(pbox[i]).val();//获得其余加项的值
						}
					for(i = 0; i < pbox.length; i++){
						if (part[i] == '') {
							return true;
						}
						if(part[i].indexOf("%") >=0){
							sum += parseFloat(part[i].substring(0, part[i].length - 1));
						}else{
							sum += parseFloat(part[i]);
						}
						}
					if (Math.abs(sum - 100) < 0.001) {//和为100%
						for(i = 0; i < pbox.length; i++){
							validator.updateStatus(pbox[i], validator.STATUS_VALID, null);//更新相关状态
							}
						return true;
					}
					return false;
				}
			}
		}
	}
	return obj
}

/**
 * 必填项
 */
var required = {
		verbose : false,
		validators : {
			notEmpty : {
				message : '必填项'
			},
			numeric : {
				message : '值必须是数字'
			}
		}
}

/**
 * 必填项
 */
var required2 = {
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
 * 必填百分数项
 */
var reqPer = {
		verbose : false,
		validators : {
			notEmpty : {
				message : '必填项'
			},
			regexp: {
                regexp: /(^0$)|(^1$)|(^100(\.0{1,2})?%$)|(^[1-9]\d?(\.\d{1,2})?%$)/,
                message: '值必须是小数位数不超过两位的百分数'
            }
		}
	}


fields = {};
fields.offcampttrainbase = required
fields.kownduration = required
fields.postduration = required
fields.stupostpartradio = reqPer
fields.studispartradio = reqPer
fields.enterpassessdisopt = sumUpTo(['enterpassessdisgood', 'enterpassessdisinter', 'enterpassessdisbad'], '其它学生顶岗实习考核结果比例')
fields.enterpassessdisgood = sumUpTo(['enterpassessdisopt', 'enterpassessdisinter', 'enterpassessdisbad'], '其它学生顶岗实习考核结果比例')
fields.enterpassessdisinter = sumUpTo(['enterpassessdisopt', 'enterpassessdisgood', 'enterpassessdisbad'], '其它学生顶岗实习考核结果比例')
fields.enterpassessdisbad = sumUpTo(['enterpassessdisopt', 'enterpassessdisgood', 'enterpassessdisinter'], '其它学生顶岗实习考核结果比例')
fields.coopenterpemploystud = reqPer

$(document).ready(function() {
	$('#formInternship').bootstrapValidator({
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
					alert("保存成功！");
					window.location.href = "getInternshipList";
				} else {
					alert(data.result);
					$('#formInternship').bootstrapValidator('disableSubmitButtons', false); 
					$("#submit").attr("disabled", false);
				}
			},
			error : function(res) {
				alert(res.responseText);
			}
		});
	});
});
