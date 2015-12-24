	function goto_page(page) {
		var total = $("#total").val();
		var number = page;
		var size=$("#pageSize").val();
		var eventId = $("#eventId").val();
		if (total > page && page >= 0) {// 首页和末页不执行
				var dataForm = new FormData();
				dataForm.append("number",number);
				dataForm.append("size",size);
				dataForm.append("eventId",eventId);
						$.ajax({
							type : 'POST',
							url : 'ajax_pic_list.jhtml',
							dataType : 'html',
							data : dataForm,
							contentType: false,
						    processData: false,
							success:function(data){
								$("#picList").empty();
								$("#picList").append(data);
							}
						});
		}
	}
