<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	
		<script src="${resource("/js/jquery.js")}"></script>
		<script src="${resource("/js/semantic.min.js")}"></script>
	    <link rel="stylesheet" href="${resource("/css/index.css")}" />
		<link rel="stylesheet" href="${resource("/css/semantic.min.css")}" />
		<!-- 富文本unditor -->
		<script type="text/javascript" src="${resource("/ueditor/ueditor.config.js")}"></script>
		<script type="text/javascript" src="${resource("/ueditor/ueditor.all.js")}"></script>
		<script type="text/javascript" src="${resource("/ueditor/lang/zh-cn/zh-cn.js")}"></script>
		<link rel="stylesheet" href="${resource("/ueditor/themes/default/css/ueditor.css")}" />
	</head>
	<body>
		<header>
			CMS系统
		</header>
		
		<div class="width80">
		<!--面包屑-->
		<input type="hidden" id="channel_name" value="${channel_name !''}">
		<input type="hidden" id="cms_key" value="${cms_key !''}">
		<div class="ui huge breadcrumb " style="margin-top: 20px;">
		    <a class="section" href="${route("/cms/keylistview.html?channelName=${channel_name!''}")}">
		    	<#if channel ??>
		    		${channel.description!''}
		    		<input type="hidden" id="cssFile" value="${channel.cssFile!''}">
		    	<#else>
		    		${channel_name!''}
		    	</#if>
		    </a>
		    <i class="right chevron icon divider"></i>
		    <a class="section">${cms_key !''}</a>
			<i class="right chevron icon divider"></i>
		  	<div class="active section">新建/编辑c-value</div>
		</div>
		<div class="ui divider"></div>
		<div class="ui green form segments">
		    <div class="two fields">
		      <label>ContentKey：</label>
		      <div class="field">
		      		${cmsKey.cmsKey !''}
		      </div>
		       <label>Type：</label>
		      <div class="field" >
		        ${cmsKey.keyType !''}
		        <input type="hidden" id="keyType" value="${cmsKey.keyType !''}"/>
		      </div>
		    </div>
		    <div class="fields">
		      <label>名称：</label>
		      <div class="twelve wide field">
		        ${cmsKey.name !''}
		      </div>
		    </div>
		    <div class="fields">
		      <label>描述：</label>
		      <div class="twelve wide field">
		        	${cmsKey.description !''}
		      </div>
		    </div>
	</div>	  
	
	<div class="ui form ">
		<span>匹配规则:按照下面数据优先匹配第一条</span>
	      <div class="actions">
	        <div class="ui right floated  button green " id="add_content">新建 c-value</div>
	      </div>
	   
	</div>
		  <table class="ui green celled table">
			  <thead>
			    <tr>
				    <th>ID</th>
				    <th>语言</th>
				    <th>渠道</th>
				    <th>操作系统</th>
				    <th>业务ID</th>
				    <th>描述</th>
				    <th>c-value</th>
				    <th>操作</th>
			  	</tr>
			  </thead>
			  <tbody>
			  	<#list cmsValue as l>
			  		<tr>
				      <td>${l.valueId !""}</td>
				      <td>${l.language !""}</td>
				      <td>${l.client !""}</td>
				      <td>${l.os !""}</td>
				      <td>${l.businessId !""}</td>
				      <td>${l.description !""}</td>
				      <td>
				      	<button class="ui  floated green button" onClick='showCValueDiv(${l.valueId !""},event)'>查看</button>
				      </td>
				      <td>
				      	<button class="ui  floated button" id="view_history" onClick="getHistoryValue(${l.valueId !""})">历史</button>
				      	<button class="ui  floated button red"  onClick="deleteCValue(${l.valueId !""})">删除</button>
				      </td>
				    </tr>
			  	</#list>
			  </tbody>
			</table>
  		
  		<div class="ui green form segments" id="c_value_div">
  				<input type="hidden" value="" id="valueIdToUp" />
  				<div class="two fields">
  				  <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;描述:</label>
				  <div class="field">
				  		<input type="text" placeholder="策略描述,c-value的描述" title="策略描述，c-value的描述" id="upDescription">
				  </div>
				</div>
				<div class="two fields">
			      <label>C-Value:</label>
			      <div class="field" id="width80">
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
											    initialFrameHeight:400//设置编辑器高度
											});
			        	}
					</script>
			      </div>
			    </div>
			    <div class="width">
			    	<div class="ui centered buttons">
					  <button class="ui button" id="cVlaueCancelButton">取消</button>
					  <div class="or"></div>
					  <button class="ui positive button" id="cVlaueSubmitButton">保存</button>
					</div>
			    </div>
			    
  		</div>
		
		
		
		
			<div class="ui addcontent modal aligned center small">
			  <i class="close icon"></i>
			  <div class="header">
			    	新增 C-value
			  </div>
			  <form class="ui  form">
			  	<div class="inline fields">
				    <div class="field">
				      <label>语言：</label>
				      	<select class="ui dropdown" id="language">
						  <option value="*">通配</option>
						  <option value="zh_CN">中文</option>
						  <option value="en_US">英文</option>
						</select>
				    </div>
				    <div class="field">
				      <label>渠道：</label>
				      <select class="ui dropdown" id="client">
						  <option value="*">通配</option>
						  <option value="Web">Web</option>
						  <option value="H5">H5</option>
						  <option value="APP">APP</option>
						  <option value="WeChat">WeChat</option>
						</select>
				    </div>
				     <div class="field">
				      <label>操作系统：</label>
				      <select class="ui dropdown" id="os">
						  <option value="*">通配</option>
						  <option value="IOS">IOS</option>
						  <option value="Andriod">Andriod</option>
						  <option value="Windows">Windows</option>
						  <option value="Mac">Mac</option>
						</select>
				    </div>
			  	</div>
			  	<div class="inline fields">
				    <div class="field">
				      <label>业务ID：</label>
				      <input type="text" placeholder="" id="businessId">
				    </div>
				    <div class="field">
				      <label>useragent：</label>
				      <input type="text" placeholder="保留字段，占不可用">
				    </div>
			  	</div>
			  </form>
			  <div class="header">
			  </div>
			  <form class="ui  form">
				  <div class="inline fields">
				    <div class="field">
				      <label>描述：</label>
				      <input type="text" placeholder="策略描述,c-value的描述" title="策略描述，c-value的描述" id="description">
				    </div>
			  	  </div>
		  	  </form>
			  <div class="width">
			  	 <div class="ui centered buttons">
				  <button class="ui button" id="addcontentCancelButton">取消</button>
				  <div class="or"></div>
				  <button class="ui positive button" id="addcontentSubmitButton">保存</button>
				</div>
			  </div>
			</div>
			
			
			
			<div class="ui history modal aligned center small">
			  <i class="close icon"></i>
			  <div class="header">
			    	查看修改历史
			  </div>
				 <div class="ui form"> 
				  	<div class="inline fields">
					    <div class="field">
					      <label>修改人：</label>
					      XXXX
					    </div>
					     <div class="field">
					      <label>修改时间：</label>
					      2015-10-10 18:07:06
					    </div>
				  	</div>
				  	<div class="two fields">
				      <label>Content-Value：</label>
				      <div class="field" id="width80">
				        sacaasasd
				      </div>
				    </div>
				  </div>
				  <div class="ui divider"></div>
			  </div>
			</div>
		</div>
	</body>
	
	<script>
	$(function(){
		$('.ui.addcontent.modal').modal('attach events', '#add_content', 'show');
		
		
		//c-value值---div隐藏
		$('#c_value_div').hide();
		
		//新建C-VALUE 取消按钮---隐藏弹框
		$('.ui.addcontent.modal').modal('attach events', '#addcontentCancelButton', 'hide');
		
		//新建C-VALUE 按钮
		$("#addcontentSubmitButton").on('click',function(){
			//TODO： 提交数据
			var channelName=$("#channel_name").val();
			var cmsKey=$("#cms_key").val();
			var language=$("#language").val();
			var client=$("#client").val();
			var os=$("#os").val();
			var businessId=$("#businessId").val();
			var description=$("#description").val();
			//alert("channelName:"+channelName+",cmsKey："+cmsKey+",language:"+language+",client:"+client+",os:"+os+",businessId:");
			//return false;
			var href="${route("/cmsvalue/addvalue")}"+"?channelName="+channelName+"&cmsKey="+cmsKey+"&language="+language+"&client="+client+"&os="+os+"&businessId="+businessId+"&description="+description;
			window.location.href=href;
			//隐藏弹框
			//$('.ui.addcontent.modal').modal('attach events', this, 'hide');
		});
		
		//修改c-value---保存按钮
		$("#cVlaueSubmitButton").on('click',function(){
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
			var channelName=$("#channel_name").val();
			var cmsKey=$("#cms_key").val();
			if(valueId==null || valueId=="" || valueId=="undefined"){
				alert("请选择查看c-value");
				return false;
			}
			if(cValue==null || cValue=="" || cValue=="undefined"){
				alert("请填写详细内容");
				return false;
			}
			var description=$("#upDescription").val();
			//alert(valueId+":"+cValue+":"+channelName+":"+cmsKey);
			var param={};
			param.valueId=valueId;
			param.cmsValue=cValue;
			param.channelName=channelName;
			param.cmsKey=cmsKey;
			param.description=description;
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
		});
		//修改c-value---取消按钮
		$("#cVlaueCancelButton").on('click',function(){
			$("#valueIdToUp").val("");
			if(keyType=="html" || keyType=="HTML"){
				window.ue.setContent("");
			}else{
				$("#cValue").val("");
			}
			$('#c_value_div').hide();
			//去掉选中时的颜色
			$("tr[name=1]").attr("style","");
		});
	});
	
	//c-value值 ----查看按钮
	function showCValueDiv(valueId,event){
		//显示隐藏的value编辑框
		$('#c_value_div').show();
		//上次选中的去掉颜色,本次选中的行上色
		$("tr[name=1]").attr("style","");
		$("#"+valueId).parent().parent().attr("name","1");
		$("#"+valueId).parent().parent().attr("style","background-color:#f2f2f2");
		
		$("#valueIdToUp").val(valueId);
		$.get("${route("/cmsvalue/getcmsvalue")}",{valueId:valueId},function(data) {
			//var ifameHeadHtml=$("#ueditor_0").contents().find("head").html();
			//获取css连接 
			var cssFiles=$("#cssFile").val();
			var cssFileTmp=cssFiles.split(",");
			for(var i=0;i<cssFileTmp.length;i++){
				var cssFile='<link rel="stylesheet" href="'+cssFileTmp[i]+'" />'
				$("#ueditor_0").contents().find("head").append(cssFile);
				//ifameHeadHtml +=cssFile;
			}
			//$("#ueditor_0").contents().find("head").html(ifameHeadHtml);
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
				var description=data.description;
				if(description=="undefined"){
					description="";
				}
				$("#upDescription").val(description);
			 }
		},'json');
		//if(dataValue!=null && dataValue!="" && dataValue!="undefined"){
			//$("#cValue").val(dataValue);
		//}
	}
	//删除c-value---操作-删除按钮
	function deleteCValue(valueId){
		var channelName=$("#channel_name").val();
		var cmsKey=$("#cms_key").val();
		//alert(valueId+"-----"+channelName+"-----------"+cmsKey);
		location.href="${route("/cmsvalue/delvalue")}"+"?valueId="+valueId+"&channelName="+channelName+"&cmsKey="+cmsKey;
	}
	
	//历史按钮
	function getHistoryValue(valueId){
		
	 	$.get("${route("/cmsvalue/gethistoryvalue")}",{valueId:valueId},function(data) {
	 		//清空页面信息
	 		var html="";
	 		$('.ui.history.modal').html(html);
	 		//编辑历史页面
	 		html+='<i class="close icon"></i>';
	 		html+='<div class="header">';
	 		html+='查看修改历史';
	 		html+='</div>';
	 		if(data!=null && data!=""){
			 	for(x in data){ 
			        //x表示是下标，来指定变量，指定的变量可以是数组元素，也可以是对象的属性。 
			        //console.log(data[x]); 
			         html+='<div class="ui form">';
			 		 html+='<div class="inline fields">';
			 		 html+='<div class="field">';
			 		 html+='<label>修改人：</label>';
			 		 html+='<label>'+data[x].updater+'</label>';
			 		 html+='</div>';
			 		 html+='<div class="field">';
			 		 html+='<label>修改时间：</label>';
			 		 html+='<label>'+(new Date(data[x].lastUpdateTime)).format("yyyy-MM-dd hh:mm:ss")+'</label>';
			 		 html+='</div>';
			 		 html+='</div>';
			 		 html+='<div class="two fields">';
			 		 html+='<label>C-Value：</label>';
			 		 html+='<textarea  style="resize: none;width: 800px;height: 400px;">'+data[x].cmsValue+'</textarea>';
			 		 html+='</div>';
			 		 html+='</div>';
			 		 html+='</div>';
			 		 html+='<div class="ui divider">';
			 		 html+='</div>';
			    } 
		 		
	 		}
	 		$('.ui.history.modal').html(html);
	 		//显示隐藏的历史信息
			$('.ui.history.modal').modal('show');
	    },"json");
	}
	
	
/**
 * 时间对象的格式化;
 */
Date.prototype.format = function(format) {
	/*
	 * eg:format="yyyy-MM-dd hh:mm:ss";
	 */
	var o = {
		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(), // day
		"h+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()
		// millisecond
	}

	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4
						- RegExp.$1.length));
	}

	for (var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1
							? o[k]
							: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}
</script>
	
</html>
