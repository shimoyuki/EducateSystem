/**
 * 当前值与pbox的值之和应等于1
 * @param pbox 其余求和<input>的name属性的数组
 * @param tp 提示信息
 * @returns {___anonymous_undergraless}
 */
function sumUpTo(pbox, tp) {
	var obj = {
		validators : {
			notEmpty : {
				message : '必填项'
			},
			regexp: {
                regexp: /(^0(\.\d{1,2}%)?$)|(^1$)|(^100(\.0{1,2})?%$)|(^[1-9]\d?(\.\d{1,2})?%$)/,
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
					if (Math.abs(sum - 100) < 0.001) {//和为100%
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
 * 当前值与pbox的值之和应小于等于1
 * @param pbox 其余求和<input>的name属性的数组
 * @param tp 提示信息
 * @returns {___anonymous_undergraless}
 */
function noMoreThan(pbox, tp) {
	var obj = {
		validators : {
			notEmpty : {
				message : '必填项'
			},
			regexp: {
                regexp: /(^0(\.\d{1,2}%)?$)|(^1$)|(^100(\.0{1,2})?%$)|(^[1-9]\d?(\.\d{1,2})?%$)/,
                message: '请输入小数位数不超过两位的百分数'
            },
			callback : {
				message : '与'+tp+'之和应小于等于1',
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
					if (sum <= 100) {//和小于100%
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
	                regexp: /(^0(\.\d{1,2})?$)|(^[1-9]\d*(\.\d{1,2})?$)/,
	                message: '需为小数位数不能超过两位的数字'
	            }
			}
		}
	
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
		}
	
	fields = {};
	fields.goodclass = reqDig
	fields.fulltimemoral = reqDig
	fields.moraltask = reqDig
	fields.moralnum = reqDig
	fields.moralpart = reqPer
	fields.moralhour = reqDig
	fields.moraltext = reqDig
	fields.assessoptimal = sumUpTo(['assessgood', 'assessmiddle', 'assesspoor'], '其它学生操行考核结果比例')
	fields.assessgood = sumUpTo(['assessoptimal', 'assessmiddle', 'assesspoor'], '其它学生操行考核结果比例')
	fields.assessmiddle = sumUpTo(['assessoptimal', 'assessgood', 'assesspoor'], '其它学生操行考核结果比例')
	fields.assesspoor = sumUpTo(['assessoptimal', 'assessgood', 'assessmiddle'], '其它学生操行考核结果比例')
	fields.pyhconselper = reqPer
	fields.provgoodgrade = reqDig
	fields.provgoodcadre = reqDig
	fields.provgoodstud = reqDig
	fields.campusviolence = reqDig
	fields.crimerate = reqDig
	fields.examdiscip = reqDig
	fields.joinorgan = reqDig
	fields.joinpraty = reqDig
	fields.socailvolun = reqDig
	fields.socailprac = reqNum
	fields.studentorgan = reqDig
	fields.organstu = reqDig
	fields.statecivil = reqDig
	fields.provincivil = reqDig
	fields.citycivil = reqDig
	fields.statefirstaward = reqDig
	fields.statesecondaward = reqDig
	fields.statethirdaward = reqDig
	fields.provinfirstaward = reqDig
	fields.provinsecondaward = reqDig
	fields.provinthirdaward = reqDig
	fields.cityfirstaward = reqDig
	fields.citysecondaward = reqDig
	fields.citythirdaward = reqDig
	fields.oneconsol = reqPer
	fields.twoconsol = reqPer
	fields.threeconsol = reqPer
	fields.cultdivipassrate = reqPer
	fields.phyassesspassrate = reqPer
	fields.profskillpassrate = reqPer
	fields.careercert = reqDig
	fields.doubcert = reqPer
	fields.gradrate = reqPer

	expFields = {};
	expFields.theorybest = sumUpTo(['theorygood', 'theorybad'], '其它理论学习满意度')
	expFields.theorygood = sumUpTo(['theorybest', 'theorybad'], '其它理论学习满意度')
	expFields.theorybad = sumUpTo(['theorygood', 'theorybest'], '其它理论学习满意度')
	
	expFields.majorbest = sumUpTo(['majorgood', 'majorbad'], '其它专业学习满意度')
	expFields.majorgood = sumUpTo(['majorbest', 'majorbad'], '其它专业学习满意度')
	expFields.majorbad = sumUpTo(['majorgood', 'majorbest'], '其它专业学习满意度')
	
	expFields.internshipbest = sumUpTo(['internshipgood', 'internshipbad'], '其它实习实训满意度')
	expFields.internshipgood = sumUpTo(['internshipbest', 'internshipbad'], '其它实习实训满意度')
	expFields.internshipbad = sumUpTo(['internshipgood', 'internshipbest'], '其它实习实训满意度')
	
	expFields.campusbest = sumUpTo(['campusgood', 'campusbad'], '其它校园文化与社团活动满意度')
	expFields.campusgood = sumUpTo(['campusbest', 'campusbad'], '其它校园文化与社团活动满意度')
	expFields.campusbad = sumUpTo(['campusgood', 'campusbest'], '其它校园文化与社团活动满意度')
	
	expFields.lifebest = sumUpTo(['lifegood', 'lifebad'], '其它生活满意度')
	expFields.lifegood = sumUpTo(['lifebest', 'lifebad'], '其它生活满意度')
	expFields.lifebad = sumUpTo(['lifegood', 'lifebest'], '其它生活满意度')
	
	expFields.safetybest = sumUpTo(['safetygood', 'safetybad'], '其它校园安全满意度')
	expFields.safetygood = sumUpTo(['safetybest', 'safetybad'], '其它校园安全满意度')
	expFields.safetybad = sumUpTo(['safetygood', 'safetybest'], '其它校园安全满意度')
	
	expFields.graduatebest = sumUpTo(['graduategood', 'graduatebad'], '其它毕业生对学校满意度')
	expFields.graduategood = sumUpTo(['graduatebest', 'graduatebad'], '其它毕业生对学校满意度')
	expFields.graduatebad = sumUpTo(['graduategood', 'graduatebest'], '其它毕业生对学校满意度')
	
	empFields = {};
	empFields.employratefirst = reqPer
	empFields.coupartemployrate = reqPer
	empFields.sixmonthsteadrate = reqPer
	empFields.firstemploymonincome = reqNum
	empFields.venturerate = reqPer
	
	empFields.stateown = noMoreThan(['privateown', 'foreignown'], '到其它类型企业服务比例')
	empFields.privateown = noMoreThan(['stateown', 'foreignown'], '到其它类型企业服务比例')
	empFields.foreignown = noMoreThan(['stateown', 'privateown'], '到其它类型企业服务比例')
	
	empFields.one = noMoreThan(['two', 'three'], '其它类型产业就业比例')
	empFields.two = noMoreThan(['one', 'three'], '其它类型产业就业比例')
	empFields.three = noMoreThan(['one', 'two'], '其它类型产业就业比例')
	
	empFields.soldier = reqDig
	empFields.collegeentance = reqPer
	empFields.couterpart = reqPer
	
	empFields.oneyearinner = noMoreThan(['oneyearouter'], '其它类型就业合同比例')
	empFields.oneyearouter = noMoreThan(['oneyearinner'], '其它类型就业合同比例')

	
	$(document).ready(function() {
		$('#formStud').bootstrapValidator({
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
						window.location.href = "showStudInfo";
					} else {
						alert(data.result);
						//$('#formStud').bootstrapValidator('disableSubmitButtons', false); 
						$("#submit").attr("disabled", false);
					}
				},
				error : function(res) {
					alert(res.responseText);
				}
			});
		});
		
		$('#formExp').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {/*输入框不同状态，显示图片的样式*/
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : expFields
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
						window.location.href = "showExpInfo";
					} else {
						alert(data.result);
						//$('#formExp').bootstrapValidator('disableSubmitButtons', false); 
						$("#submit").attr("disabled", false);
					}
				},
				error : function(res) {
					alert(res.responseText);
				}
			});
		});
		
		$('#formEmp').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {/*输入框不同状态，显示图片的样式*/
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : empFields
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
						window.location.href = "showEmpInfo";
					} else {
						alert(data.result);
						//$('#formEmp').bootstrapValidator('disableSubmitButtons', false); 
						$("#submit").attr("disabled", false);
					}
				},
				error : function(res) {
					alert(res.responseText);
				}
			});
		});
		
	});