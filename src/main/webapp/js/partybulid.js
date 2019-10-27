/**
 * 当前值应小于比较对象，值类型为decimal
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
				regexp: {
	                regexp: /(^0$)|(^[0-9]\d*(\.\d{1,2})?$)/,
	                message: '需为小数位数不能超过两位的数字'
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
 * 当前值应小于比较对象，值类型为int
 * @param box 比较对象<input>的name
 * @param tip 提示信息
 * @returns {___anonymous_staffprepjob}
 */
function toLessThanInt(box,tip) {
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
 * 当前值应小于两个比较对象
 * @param box,box1 比较对象<input>的name
 * @param tip 提示信息
 * @returns {___anonymous_staffprepjob}
 */
function toLessThanTwo(box,box1,tip) {
		var obj = {
			verbose : false,
			validators : {
				notEmpty : {
					message : '必填项'
				},
				regexp: {
	                regexp: /(^0$)|(^[0-9]\d*(\.\d{1,2})?$)/,
	                message: '需为小数位数不能超过两位的数字'
	            },
				callback : {
					message : tip,
					callback : function(value, validator, $field) {
						var otherbox = validator.getFieldElements(box).val();//获得另一个的值
						var otherbox1 = validator.getFieldElements(box1).val();//获得另一个的值
						if (otherbox == ''||otherbox1 == '') {
							return false;
						}
						if (parseInt(value) < parseInt(otherbox)&&parseInt(value) < parseInt(otherbox1)) {
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
	                regexp: /(^0$)|(^[0-9]\d*(\.\d{1,2})?$)/,
	                message: '需为小数位数不能超过两位的数字'
	            }
			}
		};
	
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
					regexp: /(^0(\.\d{1,2}%)?$)|(^1$)|(^100(\.0{1,2})?%$)|(^[1-9]\d?(\.\d{1,2})?%$)/,
	                message: '值必须是小数位数不超过两位的百分数'
	            }
			}
		};
	
	fields = {};
	fields.partymember = reqDig;
	fields.branchnum = reqDig;	
	fields.stupartynum = toLessThan('partymember', '应小于学校党员总数');
	fields.partyworktrain = reqDig;
	fields.partytain = reqDig;
	fields.partyactivisttrainnum = reqDig;
	fields.partyactivisttraintime = reqDig;
	fields.developpartynum = reqDig;
	fields.subscribnum = reqDig;
	fields.punish = toLessThan('partymember', '应小于学校党员总数');	
	fields.stateper = toLessThan('partymember', '应小于学校党员总数');
	fields.provinper = toLessThan('partymember', '应小于学校党员总数');	
	fields.cityper = toLessThan('partymember', '应小于学校党员总数');
	fields.stateorgan = toLessThan('branchnum', '应小于党支部数');
	fields.provinorgan = toLessThan('branchnum', '应小于党支部数');
	fields.cityorgan = toLessThan('branchnum', '应小于党支部数');
	
	$(document).ready(function() {
		$('#partybulidForm').bootstrapValidator({
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
						window.location.href = "getPartyBulidList";
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