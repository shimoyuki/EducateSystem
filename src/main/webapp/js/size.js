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
						if ((parseFloat(value)-parseFloat(otherbox))<0) {
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
 * 当前值应小于等于比较对象，值类型为decimal
 * @param box 比较对象<input>的name
 * @param tip 提示信息
 * @returns {___anonymous_staffprepjob}
 */
function toThan(box,tip) {
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
						if ((parseFloat(value)-parseFloat(otherbox))<=0) {
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
						if (parseInt(value)<=parseInt(otherbox)) {
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
						if (parseFloat(value) < parseFloat(otherbox)&&parseFloat(value) < parseFloat(otherbox1)) {
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
	
	function sumUpTo(pbox, tbox, tp, tt) {
		var obj = {
			validators : {
				notEmpty : {
					message : '必填项'
				},
				regexp: {
	                regexp: /(^0$)|(^[0-9]\d*(\.\d{1,2})?$)/,
	                message: '需为小数位数不能超过两位的数字'
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
							sum += parseFloat(part[i]);
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
		};
		return obj;
	}
	
	fields = {};
	
	fields.area = reqNum;
	fields.ownPropArea = toThan('area', '应小于等于学校占地面积');
	fields.totalArea = reqNum;
	
	fields.schOwnConArea = toThan('area', '应小于等于学校总建筑面积');
	fields.stuArea = toLessThan('area', '应小于学校总建筑面积');
	
	fields.teaAuxArea = toLessThan('area', '应小于学校总建筑面积');
	fields.trainArea = toLessThan('area', '应小于学校总建筑面积');
	fields.psyArea = toLessThan('area', '应小于学校总建筑面积');
	fields.dormArea = toLessThan('area', '应小于学校总建筑面积');
	
	fields.dormPerArea = toLessThanTwo('area','dormArea', '应小于总建筑面积、小于学生宿舍面积');
	
	fields.totalStudent = reqDig;
	fields.annualGraduate = toLessThanInt('totalStudent', '应小于等于在校生数');	
	fields.enrollment = toLessThanInt('totalStudent', '应小于等于在校生数');
	fields.majors = reqDig;
	fields.threeConsol = reqPer;

	
	
	$(document).ready(function() {
		$('#sizeForm').bootstrapValidator({
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
						window.location.href = "getSizeList";
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