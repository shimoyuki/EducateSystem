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
						if (parseFloat(value) < parseFloat(otherbox)) {
							//validator.updateStatus(box, validator.STATUS_VALID, 'callback');
							return true;
						}
						return false;
					}
				}
			}
		};
		return obj;
}

/**
 * 当前值应小于比较对象
 * @param box 比较对象<input>的name
 * @param tip 提示信息
 * @returns {___anonymous_staffprepjob}
 */
function toLessThanDig(box,tip) {
		var obj = {
			verbose : false,
			validators : {
				notEmpty : {
					message : '必填项'
				},
				digits : {
					message : '值必须是整数'
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
		};
		return obj;
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
};

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
};


fields = {};
fields.totalAssertWorth = required;
fields.teacEquitWorth = toLessThan('totalAssertWorth', '应小于固定资产总值');
fields.trainEquitWorth = toLessThan('totalAssertWorth', '应小于固定资产总值');
fields.yearTeacEquitWorth = required;
fields.yearTrainEquitWorth = required;
fields.stuTracEquitWorth = toLessThan('teacEquitWorth', '应小于教学设备资产值');
fields.stuTrainEquitWorth = toLessThan('trainEquitWorth', '应小于实训设备资产值');
fields.traPracWorkPe = required;

fields.inTrainBase = required2;
fields.outTrainBase = required2;
fields.libBooks = required2;
fields.libBooksElec = required2;
fields.yearBooks = toLessThanDig('libBooks', '应小于图书馆纸质图书藏书量');
fields.readSeats = required2;
fields.stuBook = toLessThan('libBooks', '应小于图书馆纸质图书藏书量');
fields.subScribs = required2;
fields.elecBooks = required2;
fields.elecSeats = required2;


$(document).ready(function() {
	$('#formequit').bootstrapValidator({
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
					window.location.href = "getEquitmentList";
				} else {
					alert(data.result);
					$("#submit").attr("disabled", false);
				}
			},
			error : function(res) {
				alert(res.responseText);
				$("#submit").attr("disabled", false);
			}
		});
	});
});
