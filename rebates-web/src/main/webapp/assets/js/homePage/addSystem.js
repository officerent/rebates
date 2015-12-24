var Systems = function(){
	
};
Systems.prototype = {
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
		$(".addSystems").click(function(){
			model.systemsValiDate();
		});
	},
	 /**
	 * 系统验证 
	 */
	systemsValiDate : function(){
		
		$(".systemFrom").validate({
			errorElement: 'div',
			errorClass: 'help-block',
			focusInvalid: false,
			rules:{
				systemName:{
					required: true
				},
				systemUrl:{
					required: true
				},
				files:{
					sysValidate: true
				}
			},
			messages: {
				systemName: {
					required: "请输入系统名称"
				},
				systemUrl:{
					required: "请输入系统URL"
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
		$.validator.addMethod("sysValidate",function(value,element,params){
			/**
			 var f = document.getElementById("uploadFiles").files;  
		        //上次修改时间  
		      alert(f[0].lastModifiedDate);  
		        //名称  
		        alert(f[0].name);  
		        //大小 字节  
		        alert(f[0].size);  
		        //类型  
		        alert(f[0].type);*/ 
			var filename = $("#uploadFiles").val();
			var fileType = filename.toLowerCase().substr(filename.lastIndexOf(".")); 
			if($("#files").html()!=null && $("#files").html()!="" && fileType==".jpg"){
				return true;
			}else{
				return false;
			}
			},"请上传jpg格式的图片");
		
		}
		
};
$(function() {
	var system = new Systems();
	system.init();
});
