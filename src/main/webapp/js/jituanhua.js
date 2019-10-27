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
		}
		return obj
	}

/**
 * 当前值与pbox的值之和应等于tbox的值
 * @param pbox 另一个求和<input>的name属性
 * @param tbox 表示总和的<input>的name属性
 * @param tp 提示信息
 * @param tt 提示信息
 * @returns {___anonymous_course}
 */
function addUpTo(pbox, tbox, tp, tt) {
	var obj = {
		validators : {
			notEmpty : {
				message : '必填项'
			},
			digits : {
				message : '值必须是整数'
			},
			callback : {
				message : '与'+tp+'之和应等于'+tt,
				callback : function(value, validator, $field) {
					var part = validator.getFieldElements(pbox).val();//获得另一个加项的值
					var total = validator.getFieldElements(tbox).val();//获得加和的值
					//console.log(value+";"+part+";"+total);
					if(total == ''){
						return false;
					}
					if (part == '') {
						return true;
					}
					if (parseInt(value) + parseInt(part) == parseInt(total)) {
						validator.updateStatus(pbox, validator.STATUS_VALID, null);//更新相关状态
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
 * 当前值与pbox的值之和应等于tbox的值
 * @param pbox 其余求和<input>的name属性的数组
 * @param tbox 表示总和的<input>的name属性
 * @param tp 提示信息
 * @param tt 提示信息
 * @returns {___anonymous_undergraless}
 */
function sumUpTo(pbox, tbox, tp, tt) {
	var obj = {
		validators : {
			notEmpty : {
				message : '必填项'
			},
			digits : {
				message : '值必须是整数'
			},
			callback : {
				message : '与'+tp+'之和应等于'+tt,
				callback : function(value, validator, $field) {
					var part = [], i, sum = parseInt(value);
					for(i = 0; i < pbox.length; i++){
						part[i] = validator.getFieldElements(pbox[i]).val();//获得其余加项的值
						}
					//console.log(part);
					var total = validator.getFieldElements(tbox).val();//获得加和的值
					if(total == ''){
						return false;
					}
					for(i = 0; i < pbox.length; i++){
						if (part[i] == '') {
							return true;
						}
						sum += parseInt(part[i]);
						}
					if (sum == parseInt(total)) {
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
 * 课程时间的上下限
 */
	var chLimit = {
		verbose : false,
		validators : {
			notEmpty : {
				message : '必填项'
			},
			numeric : {
				message : '值必须是数字'
			},
			lessThan : {
				value : 84,
				inclusive : true,
				message : '平均课时数最多为84节'
			},
			greaterThan : {
				value : 0,
				inclusive : true,
				message : '平均课时数不能为负'
			}
		}
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
		}
	
	fields = {};
	fields.leadvocedugroup = required
	fields.joinvocedugroup = required
	fields.joinleadvocedugroupscho = required
	fields.joinleadvocedugroupenterp = required
	fields.joinleadvocedugroupmajor = required
	
	
	$(document).ready(function() {
		$('#formjituanhua').bootstrapValidator({
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
						window.location.href = "getGroupSchoolList";
					} else {
						alert(data.result);
						$('#formjituanhua').bootstrapValidator('disableSubmitButtons', false); 
						$("#submit").attr("disabled", false);
					}
				},
				error : function(res) {
					alert(res.responseText);
				}
			});
		});
	});