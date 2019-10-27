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
						if ((parseFloat(value)-parseFloat(otherbox))<=0 ){
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
                regexp: /(^0$)|(^1$)|(^100(\.0{1,2})?%$)|(^[0-9]\d?(\.\d{1,2})?%$)/,
                message: '值必须是小数位数不超过两位的百分数'
            }
		}
	}


fields = {};
fields.majornum = required2
fields.coopagreeenterp = required2
fields.coopagreemajor = toLessThan('majornum', '应小于等于校企合作覆盖专业数')
fields.coopenterpjointeachmajor = toLessThan('majornum', '应小于等于校企合作覆盖专业数')
fields.coopenterpjointeachteacher = required2
fields.coopenterpjointeachclass = required2
fields.coopenterptext = required2
fields.coopenterpdevelop = required
fields.parttimesalary = required
fields.enterpdonation = required
fields.coopenterpfund = required

fields.coopenterparrivalfund = toLessThan('coopenterpfund', '应小于等于合作企业投入资金总额')
fields.coopenterpequitworth = toLessThan('coopenterpfund', '应小于等于合作企业投入资金总额')
fields.enterpbuildreseadevelop = required2
fields.offschoteachertrainbase = required2
fields.offschoteachbase = required
fields.prodtrainbaseval = required
fields.schoenterpcooporderclassnum = required
fields.schoenterpdevelopcourse = required
fields.fullenterprac = required
fields.fullentertime = required
fields.parttimeclassradio = reqPer
fields.receivepost = reqPer
fields.recruitgradute = reqPer



$(document).ready(function() {
	$('#formhezuo').bootstrapValidator({
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
					window.location.href = "getSchoolenterpriseList";
				} else {
					alert(data.result);					
					$('#formhezuo').bootstrapValidator('disableSubmitButtons', false); 
					$("#submit").attr("disabled", false);
				}
			},
			error : function(res) {
				alert(res.responseText);
			}
		});
	});
});
