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
						if (parseInt(value) <= parseInt(otherbox)) {
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
	};
	return obj;
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
	};
	return obj;
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
			},
			regexp: {
				regexp: /(^0(\.\d{1,2})?$)|(^[1-9]\d*(\.\d{1,2})?$)/,
                message: '需为小数位数不能超过两位的数字'
            }
		}
	};

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
	
	fields = {};
	fields.fullclasshour = chLimit;
	fields.courseclasshour = chLimit;
	fields.staffnum = required;
	fields.staffadmin = required;
	fields.induenterhour = required;
	
	fields.staffprepjob = toLessThan('staffnum', '应小于等于教职工总人数');
	fields.fulltime = toLessThan('staffnum', '应小于等于教职工总人数');
	fields.doubleteac = toLessThan('fulltime', '应小于等于专任教师数');
	fields.counselcertificate = toLessThan('fulltime', '应小于等于专任教师数');
	fields.fulltimecounsel = toLessThan('counselcertificate', '应小于等于持有心理咨询证书的教师数');
	fields.citydiscipleader = toLessThan('fulltime', '应小于等于专任教师数');
	fields.provsuper = toLessThan('fulltime', '应小于等于专任教师数');
	fields.industryenterprise = toLessThan('fulltime', '应小于等于专任教师数');
	
	fields.course = addUpTo('basiccourse', 'fulltime', '公共课教师数', '专任教师数');
	fields.basiccourse = addUpTo('course', 'fulltime', '专业课教师数', '专任教师数');
	fields.male = addUpTo('female', 'fulltime', '女教师数', '专任教师数');
	fields.female = addUpTo('male', 'fulltime', '男教师数', '专任教师数');
	
	fields.undergraless = sumUpTo(['undergra', 'fullpostgrad'], 'fulltime', '其余学历教师数', '专任教师数');
	fields.undergra = sumUpTo(['undergraless', 'fullpostgrad'], 'fulltime', '其余学历教师数', '专任教师数');
	fields.fullpostgrad = sumUpTo(['undergra', 'undergraless'], 'fulltime', '其余学历教师数', '专任教师数');
	fields.subhighmore = sumUpTo(['intermediategrade', 'juniortitle', 'noconferteac'], 'fulltime', '其余职称教师数', '专任教师数');
	fields.intermediategrade = sumUpTo(['subhighmore', 'juniortitle', 'noconferteac'], 'fulltime', '其余职称教师数', '专任教师数');
	fields.juniortitle = sumUpTo(['subhighmore', 'intermediategrade', 'noconferteac'], 'fulltime', '其余职称教师数', '专任教师数');
	fields.noconferteac = sumUpTo(['subhighmore', 'intermediategrade', 'juniortitle'], 'fulltime', '其余职称教师数', '专任教师数');
	fields.threefiveless = sumUpTo(['threesixfourfive', 'foursixfivefive', 'fivesixmore'], 'fulltime', '其余年龄教师数', '专任教师数');
	fields.threesixfourfive = sumUpTo(['threefiveless', 'foursixfivefive', 'fivesixmore'], 'fulltime', '其余年龄教师数', '专任教师数');
	fields.foursixfivefive = sumUpTo(['threefiveless', 'threesixfourfive', 'fivesixmore'], 'fulltime', '其余年龄教师数', '专任教师数');
	fields.fivesixmore = sumUpTo(['threefiveless', 'threesixfourfive', 'foursixfivefive'], 'fulltime', '其余年龄教师数', '专任教师数');
	
	$(document).ready(function() {
		$('#formTeac').bootstrapValidator({
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
						window.location.href = "showTeacInfo";
					} else {
						alert(data.result);
						//$('#formTeac').bootstrapValidator('disableSubmitButtons', false); 
						$("#submit").attr("disabled", false);
					}
				},
				error : function(res) {
					alert(res.responseText);
				}
			});
		});
	});