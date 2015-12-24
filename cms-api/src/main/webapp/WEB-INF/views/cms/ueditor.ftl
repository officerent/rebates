<script src="${resource("/js/jquery.js")}"></script>
<script src="${resource("/js/semantic.min.js")}"></script>
<link rel="stylesheet" href="${resource("/css/index.css")}" />
<link rel="stylesheet" href="${resource("/css/semantic.min.css")}" />
<!-- 富文本unditor -->
<script type="text/javascript" src="${resource("/ueditor/ueditor.config.js")}"></script>
<script type="text/javascript" src="${resource("/ueditor/ueditor.all.js")}"></script>
<script type="text/javascript" src="${resource("/ueditor/lang/zh-cn/zh-cn.js")}"></script>
<link rel="stylesheet" href="${resource("/ueditor/themes/default/css/ueditor.css")}" />





<div class="ui green form segments" id="c_value_div">
	<div class="two fields">
	     <label>Content-Value：</label>
	     <div class="field" id="width80">
 			<input type="hidden" value="${valueId!'' }" id="valueIdToUp" />
			<input type="hidden" value="${keyType!'' }" id="keyType" />
			<textarea id="cValue"></textarea>
			<!-- 富文本编辑器 --设置 --  keyType为html----->
			<script type="text/javascript">
				var keyType=$("#keyType").val();
				if(keyType=="html" || keyType=="HTML"){
					//var editor = new UE.ui.Editor();
				    //editor.render("cValue");
				    //1.2.4以后可以使用一下代码实例化编辑器
				    window.ue=UE.getEditor('cValue',{
									    allowDivTransToP: false,
									    initialFrameHeight:300//设置编辑器高度
									});
				}
			</script>
		 </div>
	</div>
 	<div class="width">
    	<div class="ui centered buttons">
		  <button class="ui button" id="cVlaueCancelButton" onClick="cVlaueCancelButtonClick()">取消</button>
		  <div class="or"></div>
		  <button class="ui positive button" id="cVlaueSubmitButton" onClick="cVlaueSubmitButtonClick()">保存</button>
		</div>
    </div>
</div>

<script>

	//修改c-value---取消按钮
	function  cVlaueCancelButtonClick(){
		var keyType=$("#keyType").val();
		if(keyType=="html" || keyType=="HTML"){
			window.ue.setContent("");
		}else{
			$("#cValue").val("");
		}
		$('#c_value_div').hide();
		//去掉选中时的颜色
		$("tr[name=1]",parent.document).attr("style","");
	}
	
	//修改c-value---保存按钮
	function cVlaueSubmitButtonClick(){
			var valueId=$("#valueIdToUp").val();
			var keyType=$("#keyType").val();
			var cValue='';
        	if(keyType=="html" || keyType=="HTML"){
        		//获取html内容，返回: <p>hello</p>
			    var html = window.ue.getContent();
			    //获取纯文本内容，返回: hello
			    var txt = window.ue.getContentTxt();
			     cValue=html;
        	}else{
        		 cValue=$("#cValue").val();
        	}
        	//alert(cValue);
			var channelName=$("#channel_name",parent.document).val();
			var cmsKey=$("#cms_key",parent.document).val();
			if(valueId==null || valueId=="" || valueId=="undefined"){
				alert("请选择查看c-value");
				return false;
			}
			if(cValue==null || cValue=="" || cValue=="undefined"){
				alert("请填写详细内容");
				return false;
			}
			//alert(valueId+":"+cValue+":"+channelName+":"+cmsKey);
			var param={};
			param.valueId=valueId;
			param.cmsValue=cValue;
			param.channelName=channelName;
			param.cmsKey=cmsKey;
			
			console.info(param);
			//return false;
			$.ajax({
             type: "post",
             url: "${route("/cmsvalue/updatevalue")}",
             data: param,
             dataType: "json",
             success: function(data){
                         if(data=="0"){
                         	alert("修改失败");
                         }
                         if(data=="1"){
                         	location.href="${route("/cmsvalue/getvalue")}"+"?channel_name="+channelName+"&cms_key="+cmsKey;
                         }
                      }
         });
		//location.href="${route("/cmsvalue/updatevalue")}"+"?valueId="+valueId+"&cmsValue="+cValue+"&channelName="+channelName+"&cmsKey="+cmsKey;
	}
</script>

<script>
	$(function(){
		$.get("${route("/cmsvalue/getcmsvalue")}",{valueId:${valueId!'' }},function(data) {
				alert($("#ueditor_0").contents().find("head").html());
				var ifameHeadHtml=$("#ueditor_0").contents().find("head").html();
				ifameHeadHtml +='<link rel="stylesheet" href="${resource("/css/index.css")}" />';
				ifameHeadHtml +='<link rel="stylesheet" href="${resource("/css/semantic.min.css")}" />';
				$("#ueditor_0").contents().find("head").html(ifameHeadHtml);
				alert($("#ueditor_0").contents().find("head").html());
			if(data!=null && data!=""){
			 	var dataValue=data.cmsValue;
			 	if(dataValue=="undefined"){
					dataValue="";
				}
				var keyType=$("#keyType").val();
				if(keyType=="html" || keyType=="HTML"){
					setTimeout(function(){
                		window.ue.setContent(dataValue);
                	},10);
				}else{
					$("#cValue").val(dataValue);
				}
				
			 }
		},'json');
	});
</script>