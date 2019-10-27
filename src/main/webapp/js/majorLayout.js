/** 当前值应小于几个比较对象之和，值类型为decimal
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
				digits : {
					message : '值必须是整数'
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
						if (parseInt(value) <=(parseInt(otherbox1)+parseInt(otherbox2)+parseInt(otherbox3))) {
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

fieldsMajorLayoutForm = {};

fieldsMajorLayoutForm.oneIndu = reqDig;
fieldsMajorLayoutForm.twoIndu = reqDig;
fieldsMajorLayoutForm.threeIndu = reqDig;

fieldsMajorLayoutForm.localPillar = toLessThan('oneIndu','twoIndu','threeIndu', '应小于等于一二三产业专业和');
fieldsMajorLayoutForm.newMajor = reqDig;
fieldsMajorLayoutForm.stopMajor = toLessThan('oneIndu','twoIndu','threeIndu', '应小于等于一二三产业专业和');




$(document).ready(function() {
	$('#majorLayoutForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {/*输入框不同状态，显示图片的样式*/
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields:fieldsMajorLayoutForm
	}).on('success.form.bv', function(e) {//点击提交之后
		// Prevent form submission
		e.preventDefault();
		
		saveMajorLayout();
	});
			
});