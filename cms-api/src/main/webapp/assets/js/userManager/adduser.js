var User = function(){
	
};
User.prototype = {
	/**
	 * 初始化函数
	 */
	init : function(){
		this.initEvent();
	},
	/**
	 * 初始化事件
	 */
	initEvent : function(){
		var model = this;
		$(".addUser").click(function(){
			model.UserValiDate();//调用验证方法
		});
	},
	
	/**
	 * 用户验证 
	 */
	UserValiDate : function(){
		$(".userFrom").validate({
			errorElement: 'div',
			errorClass: 'help-block',
			focusInvalid: false,
			rules:{
				username:{
					required: true
				},
				loginname:{
					required: true
				},
				password:{
					required: true,
					minlength: 6
				},
				email:{
					required: true,
					email: true
				}
			},
			messages: {
				username: {
					required: "请输入用户名称"
				},
				loginname:{
					required: "请输入登录名称"
				},
				password:{
					required: "请输入密码",
					minlength: "密码长度不能小于六位",
					
				},
				email:{
					required: "请输入邮箱账号",
					email: "请输入正确的邮箱账号"
				}
			},
			
			invalidHandler: function (event, validator) { //display error alert on form submit   
				$('.alert-danger', $('.login-form')).show();
			},
			/**添加消息提示颜色*/
			highlight: function (e) {
				$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
			},
	
			success: function (e) {
				$(e).closest('.form-group').removeClass('has-error').addClass('has-info');
				$(e).remove();
			},
			/**错误消息信息的位置*/
			errorPlacement: function (error, element) {
				if(element.is(':checkbox') || element.is(':radio')) {
					var controls = element.closest('div[class*="col-"]');
					if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
					else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
				}
				else if(element.is('.select2')) {
					error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
				}
				else if(element.is('.chosen-select')) {
					error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
				}
				else error.insertAfter(element.parent());
			},
			/**验证成功提交表单*/
			submitHandler: function (form) {
				form.submit();//提交表单
			},
			/**表单验证失败*/
			invalidHandler: function (form) {
				
			}
		});
		
	}
	
	
};
$(function() {
	var user = new User();
	user.init();
});
