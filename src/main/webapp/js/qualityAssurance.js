/**
 * 当前值与pbox的值之和应等于1
 * @param pbox 其余求和<input>的name属性的数组
 * @param tp 提示信息
 * @returns {___anonymous_undergraless}
 */
function sumUpToOne(pbox, tp) {
	var obj = {
		validators : {
			notEmpty : {
				message : '必填项'
			},
			regexp: {
                regexp: /(^0$)|(^1$)|(^100(\.0{1,2})?%$)|(^[0-9]\d?(\.\d{1,2})?%$)/,
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
					if (sum == 100) {//和为100%
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
 * 当前值与pbox的值之和应小于等于tbox的值
 * @param pbox 其余求和<input>的name属性的数组
 * @param tbox 表示总和的<input>的name属性
 * @param tp 提示信息
 * @param tt 提示信息
 * @returns {___anonymous_undergraless}
 */
function sumNotMore(pbox, tbox, tp, tt) {
	var obj = {
		validators : {
			notEmpty : {
				message : '必填项'
			},
			digits : {
				message : '值必须是整数'
			},
			
			callback : {
				message : '与'+tp+'之和应小于等于'+tt,
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
					if (sum <= parseInt(total)) {
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
	 * 必填百分数项
	 */
	var reqPerEmpty = {
			verbose : false,
			validators : {
				regexp: {
					regexp: /(^0(\.\d{1,2}%)?$)|(^1$)|(^100(\.0{1,2})?%$)|(^[1-9]\d?(\.\d{1,2})?%$)/,
	                message: '值必须是小数位数不超过两位的百分数'
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
	
	fieldsQualityAssuranceForm = {};
	
	fieldsQualityAssuranceForm.leaderListen = reqNum;
	fieldsQualityAssuranceForm.leaderTalk = reqNum;
	fieldsQualityAssuranceForm.schoolWell = sumUpToOne(['schoolGood', 'schoolBad'], '其它教师教学质量考核比例');
	fieldsQualityAssuranceForm.schoolGood = sumUpToOne(['schoolWell', 'schoolBad'], '其它教师教学质量考核比例');
	fieldsQualityAssuranceForm.schoolBad = sumUpToOne(['schoolWell', 'schoolGood'], '其它教师教学质量考核比例');
	fieldsQualityAssuranceForm.stateClass = reqDig;
	fieldsQualityAssuranceForm.provinClass = reqDig;
	fieldsQualityAssuranceForm.cityClass = reqDig;
	fieldsQualityAssuranceForm.chinese = reqPerEmpty;
	fieldsQualityAssuranceForm.math = reqPerEmpty;
	fieldsQualityAssuranceForm.english = reqPerEmpty;
	fieldsQualityAssuranceForm.stateSkillWinTime = reqDig;
	fieldsQualityAssuranceForm.stateFirstAward = sumNotMore(['stateSecondAward', 'stateThridAward'], 'stateSkillWinTime', '其余等级获奖总人数', '学生参加国家级技能大赛人数');
	fieldsQualityAssuranceForm.stateSecondAward = sumNotMore(['stateFirstAward', 'stateThridAward'], 'stateSkillWinTime', '其余等级获奖总人数', '学生参加国家级技能大赛人数');
	fieldsQualityAssuranceForm.stateThridAward = sumNotMore(['stateSecondAward', 'stateFirstAward'], 'stateSkillWinTime', '其余等级获奖总人数', '学生参加国家级技能大赛人数');
	fieldsQualityAssuranceForm.provinSkillWinTime = reqDig;
	fieldsQualityAssuranceForm.provinFirstAward = sumNotMore(['provinSecondAward', 'provinThirdAward'], 'provinSkillWinTime', '其余等级获奖总人数', '学生参加省级技能大赛人数');
	fieldsQualityAssuranceForm.provinSecondAward = sumNotMore(['provinFirstAward', 'provinThirdAward'], 'provinSkillWinTime', '其余等级获奖总人数', '学生参加省级技能大赛人数');
	fieldsQualityAssuranceForm.provinThirdAward = sumNotMore(['provinSecondAward', 'provinFirstAward'], 'provinSkillWinTime', '其余等级获奖总人数', '学生参加省级技能大赛人数');
	fieldsQualityAssuranceForm.citySkillWinTime = reqDig;
	fieldsQualityAssuranceForm.cityFirstAward = sumNotMore(['cityThirdAward', 'citySecondAward'], 'citySkillWinTime', '其余等级获奖总人数', '学生参加市级技能大赛人数');
	fieldsQualityAssuranceForm.citySecondAward = sumNotMore(['cityFirstAward', 'cityThirdAward'], 'citySkillWinTime', '其余等级获奖总人数', '学生参加市级技能大赛人数');
	fieldsQualityAssuranceForm.cityThirdAward = sumNotMore(['citySecondAward', 'cityFirstAward'], 'citySkillWinTime', '其余等级获奖总人数', '学生参加市级技能大赛人数');
		
	$(document).ready(function() {	
		$('#qualityAssuranceForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {/*输入框不同状态，显示图片的样式*/
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : fieldsQualityAssuranceForm
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
				data :$form.serialize().split("&").filter(function(str){return !str.endsWith("=")}).join("&"),
				success : function(data) {
					if (data.result == "success") {
						alert("保存成功！");
						window.location.href = "getQualityAssuranceList";
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