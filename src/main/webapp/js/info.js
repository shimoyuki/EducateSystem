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
				digits : {
					message : '值必须是整数'
				}
			}
		};
	var required2= {
			verbose : false,
			validators : {
				notEmpty : {
					message : '必填项'
				}
			}
		};
	fields = {};
	fields.networknum = required;
	fields.networkmain = required;
	fields.videostu = required2;
	fields.elecbookstu = required2;
	fields.teaccomputer = required;
	fields.teaccompstu = toLessThan('teaccomputer', '应小于教学用计算机台数');
	
	$(document).ready(function() {
		$('#formInfo').bootstrapValidator({
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
						window.location.href = "getInformation";
					} else {
						alert(data.result);
						$("#submit").attr("disabled", false);
					}
				},
				error : function(res) {
					alert(res.responseText);
				}
			});
		});
	});