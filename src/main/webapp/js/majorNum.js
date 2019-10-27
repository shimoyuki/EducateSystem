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
	
	fieldsMajorNumForm = {};
	
	fieldsMajorNumForm.classCriter = reqDig;
	fieldsMajorNumForm.leadNatShareMajor = reqDig;
	/*fieldsMajorNumForm.schoolEnterMajor = reqDig;	*/
	fieldsMajorNumForm.textTeacEditMajor = reqDig;
	fieldsMajorNumForm.statePlanText = reqPer;	
	fieldsMajorNumForm.schMajorMater = reqDig;	
	/*fieldsMajorNumForm.classHour =reqDig;	
	fieldsMajorNumForm.majorHour = reqDig;
	fieldsMajorNumForm.majorBHour = sumUpTo(['majorCHour', 'dispClass'], 'majorHour', '其余专业课学时总数', '各专业专业课学时总数');
	fieldsMajorNumForm.majorCHour = sumUpTo(['majorBHour', 'dispClass'], 'majorHour', '其余专业课学时总数', '各专业专业课学时总数');
	fieldsMajorNumForm.dispClass = sumUpTo(['majorCHour', 'majorBHour'], 'majorHour', '其余专业课学时总数', '各专业专业课学时总数');	
	fieldsMajorNumForm.bCClassHour = reqDig;
	fieldsMajorNumForm.chinese = sumUpTo(['moral', 'math','english','sports','art','computer','history'], 'bCClassHour', '其余公共基础课学时总数', '各专业公共基础课学时总数');	
	fieldsMajorNumForm.moral = sumUpTo(['chinese', 'math','english','sports','art','computer','history'], 'bCClassHour', '其余公共基础课学时总数', '各专业公共基础课学时总数');
	fieldsMajorNumForm.math = sumUpTo(['chinese', 'moral','english','sports','art','computer','history'], 'bCClassHour', '其余公共基础课学时总数', '各专业公共基础课学时总数');
	fieldsMajorNumForm.english = sumUpTo(['chinese', 'moral','math','sports','art','computer','history'], 'bCClassHour', '其余公共基础课学时总数', '各专业公共基础课学时总数');
	fieldsMajorNumForm.sports = sumUpTo(['chinese', 'moral','math','english','art','computer','history'], 'bCClassHour', '其余公共基础课学时总数', '各专业公共基础课学时总数');
	fieldsMajorNumForm.art = sumUpTo(['chinese', 'moral','math','english','sports','computer','history'], 'bCClassHour', '其余公共基础课学时总数', '各专业公共基础课学时总数');
	fieldsMajorNumForm.computer = sumUpTo(['chinese', 'moral','math','english','sports','art','history'], 'bCClassHour', '其余公共基础课学时总数', '各专业公共基础课学时总数');
	fieldsMajorNumForm.history = sumUpTo(['chinese', 'moral','math','english','sports','art','computer'], 'bCClassHour', '其余公共基础课学时总数', '各专业公共基础课学时总数');
*/
		
	$(document).ready(function() {
		$('#majorNumForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {/*输入框不同状态，显示图片的样式*/
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : fieldsMajorNumForm
		}).on('success.form.bv', function(e) {//点击提交之后
			// Prevent form submission
			e.preventDefault();
			// Get the form instance
			var $form = $(e.target);
			console.log($form);
			// Get the BootstrapValidator instance
			var bv = $form.data('bootstrapValidator');
		
			$.ajax({
				url : $form.attr('action'),
				type : "POST",
				dataType : "json",
				data :$form.serialize(),
				success : function(data) {
					if (data.result == "success") {
						alert("保存成功！");
						window.location.href = "getMajorNumList";
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