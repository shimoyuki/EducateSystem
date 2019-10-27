/**
 * 当前值应小于几个比较对象之和，值类型为decimal
 * @param box 比较对象<input>的name
 * @param tip 提示信息
 * @returns {___anonymous_staffprepjob}
 */
function toLessThan(box1,box2,box3,tip){
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
						var otherbox1 = validator.getFieldElements(box1).val();//获得另一个的值
						var otherbox2 = validator.getFieldElements(box2).val();//获得另一个的值
						var otherbox3 = validator.getFieldElements(box3).val();//获得另一个的值
						if((otherbox1 == ''||otherbox1 == null)&&(otherbox2 == ''||otherbox2 == null)&&(otherbox3 == ''||otherbox3 == null)){
							return false;
						}
						if ((parseFloat(value)-(parseFloat(otherbox1)+parseFloat(otherbox2)+parseFloat(otherbox3)))<=0) {
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
	
	fieldsFundsForm= {};
	
	fieldsFundsForm.centerFund = reqNum;
	fieldsFundsForm.localFund = reqNum;
	fieldsFundsForm.debt = reqNum;
	fieldsFundsForm.loan = reqNum;
	fieldsFundsForm.appropriation = reqNum;
	fieldsFundsForm.teacInputRadio = reqPer;
	/*fieldsFundsForm.teacherTrain = toLessThan('centerFund','localFund','loan','应小于投入经费和贷款之和');*/
	fieldsFundsForm.teachChange = toLessThan('centerFund','localFund','loan','应小于等于投入经费和贷款之和');
	fieldsFundsForm.fundBudget = toLessThan('centerFund','localFund','loan','应小于等于投入经费和贷款之和');
	

	
	
	$(document).ready(function() {
		$('#fundsForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {/*输入框不同状态，显示图片的样式*/
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields: fieldsFundsForm
		}).on('success.form.bv', function(e) {//点击提交之后
			// Prevent form submission
			e.preventDefault();
			
			saveFunds();		
		});
				
	});