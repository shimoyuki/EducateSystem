
function toEqual(box,tip) {
		var obj = {
			verbose : false,
			validators : {
				notEmpty : {
					message : '必填项'
				},
				
				callback : {
					message : tip,
					callback : function(value, validator, $field) {
						var otherbox = validator.getFieldElements(box).val();//获得另一个的值
						if (otherbox == '') {
							return false;
						}
						if (value==otherbox) {
							//validator.updateStatus(box, validator.STATUS_VALID, 'callback');
							return true;
						}else{
							return false;
						}
						
					}
				}
			}
		};
		return obj;
	}

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
		};
	
	/**
	 * 必填数字项
	 */
	var req = {
			verbose : false,
			validators : {
				notEmpty : {
					message : '必填项'
				}
			}
		};	
	
	fields = {};
	fields.usercode = req;
	fields.password = req;
	//fields.password = toEqualThan('area', '应小于学校占地面积');
	fields.passwordAgain = toEqual('password', '两次密码不一致');

	$(document).ready(function() {
		$('#accountForm').bootstrapValidator({
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
			$.post($form.attr('action'), $form.serialize(), function(result) {
				//do something...
				alert("保存成功！");
				window.location.href = "getAccountList";
			});
		});
				
	});