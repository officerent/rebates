<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="${resource("/css/index.css")}" />
		<link rel="stylesheet" href="${resource("/css/semantic.min.css")}" />
		<script src="${resource("/js/jquery.js")}" ></script>
		<script src="${resource("/js/semantic.min.js")}"" ></script>
	</head>
	<body>
		<header>
			CMS系统
		</header>
		<div class="width80">
			<!--面包屑-->
			<div class="ui huge breadcrumb " style="margin-top: 20px;">
				<a class="section" href="${route("/cms/index.html")}">首页</a>
				<i class="right chevron icon divider"></i>
			    <a class="section" href="${route("/cms/keylistview.html?channelName=${channelName!''}")}">
			    	<#if channel ??>
			    		${channel.description!''}
			    	<#else>
			    		${channelName!''}
			    	</#if>
			    </a>
			    <i class="right chevron icon divider"></i>
			  	<div class="active section">新建Key</div>
			</div>
			
			<div class="ui divider"></div>
			
		<form class="ui keyfrom form" action="${route("/cms/addnewkey.html")}" id="keyForm" method="post">
			<input type="hidden" name="channelName" value="${channelName!''}" id="channelNameId">
			<div class="ui form">
			  <div class="inline field">
			    <span class="y-label">名称:</span>
			    <input type="text" placeholder="name" name="name" id="keyNameId">
			  </div>
			  <div class="inline field">
			    <span class="y-label">Key:</span>
			    <input type="text" placeholder="cmsKey" name="cmsKey" class="cmsKey" id="cmsKeyId">
			  </div>
			  <div class="inline field">
			    <span class="y-label">Type:</span>
				<select class="ui dropdown" name="keyType"  id="keyTypeId">
				  <option value="HTML">HTML</option>
				  <option value="JSON">JSON</option>
				  <option value="INT">INT</option>
				  <option value="STRING">STRING</option>
				  <option value="BOOLEAN">BOOLEAN</option>
				</select>
			  </div>
			  <div class="inline fields">
			      <span class="y-label asdf">描述：</span>
			      <div class="field width80">
			        <textarea name="description">${key.description!''}</textarea>
			      </div>
			    </div>
			     <div class="ui ignored info message width80" style="margin-left: 70px;">
					<p>
						Content<code> c-value </code>的规格需求，请说明在描述里。
					</p>
				   </div>
			</div>
			<div class="ui divider"></div>
			<div class="ui form">
				<div class="inline field">
					<label>Tag:</label>
					<select class="ui dropdown" name="tagId" id="tagId" >
					  <option value="">选择标签</option>
					  <#if tagList??>
					  	 <#list tagList as item>  
					  	 	<option value="${item.tagId!''}">${item.name}</option>
					  	 </#list>
					  </#if>
					</select>
					<p>
						<a href="javaScript:;" id="add_tag">
							<code>创建Tag</code>
						</a>
					</p>
				</div>	
				
			</div>
			</form>
			<div class="width">
				<div class="ui centered buttons">
				  <button class="ui button keycancelButton" id="cancelKeyId">取消</button>
				  <div class="or"></div>
				  <button class="ui positive button keyButton" id="saveKeyId">保存</button>
				</div>
			</div>
			
			<div class="ui modal aligned center small">
			  <i class="close icon"></i>
			  <div class="header">
			    	新建Tag:
			  </div>
			  <form class="ui  form off" action="${route("/cms/addtag.html")}" method="post" id="tagForm">
				  	<input type="hidden" name="channelName" value="${channelName!''}" >
				  	<input type="hidden" name="keyId" >
				  	<div class="inline fields">
					    <div class="field">
					      <label>Tag：</label>
					       <input type="text" placeholder="Tag名称" name="name" id="tagNameId">
					    </div>
				  	</div>
				  	
				  	<div class="inline fields">
					    <div class="field">
					      <label>Color：</label>
					      <input type="hidden" name="color" id="tagColorId" value="red" >
					      <a class="tiny ui inverted violet  button" data-color="violet ">Violet </a>
						  <a class="tiny ui inverted orange button" data-color="orange">Orange</a>
						  <a class="tiny ui inverted yellow button"  data-color="yellow">Yellow</a>
						  <a class="tiny ui inverted olive button"  data-color="olive">Olive</a>
						  <a class="tiny ui inverted green button"  data-color="green">Green</a>
						  <a class="tiny ui inverted teal button"  data-color="teal">Teal</a>
						  <a class="tiny ui inverted blue button" data-color="blue">Blue</a>
						  
					    </div>
				  	</div>
			  	</form>
			  		 
			  		
				  	 
			  	  <div class="width">
				  	<div class="ui centered buttons">
					  <button class="ui button tagcancelButton" id="cancalTagId">取消</button>
					  <div class="or"></div>
					  <button class="ui positive button tagButton" id="saveTagId">保存</button>
					</div>
				  </div>
				  
			</div>
		</div>
	</body>
	
	<script>
		$(function(){
			$('.ui.modal').modal('attach events', '#add_tag', 'show');
			$(".tagcancelButton").on("click",function(){
				var tagName = $("#tagNameId").val("");
				$('.ui.modal').modal('hide');
			});
			$(".tagButton").on("click",function(){
				var tagName = $("#tagNameId").val();
				if(tagName){
					$("#tagForm").submit();
					$('.ui.modal').modal('hide');
				}else{
					alert("Tag名称不能为空！");
				}
			});
			
			$(".inverted").on("click",function(){
				var obj = $(this);
				$(".inverted").each(function(){
					var _sub = $(this);
					if(_sub.hasClass("active")){
						_sub.removeClass("active");
					}
				});
				obj.addClass("active");
				$("#tagColorId").val(obj.attr("data-color"));
				//alert($("#tagColorId").val());
			});
			
			$(".keycancelButton").on("click",function(){
				
				location.href = document.referrer;
				//$('.ui.modal').modal('hide');
			});
			
			$(".keyButton").on("click",function(){
				var keyName = $("#keyNameId").val().trim();
				var cmsKey = $("#cmsKeyId").val().trim();
				var flag = true;
				if(keyName.replace(/(^\s*)|(\s*$)/g, "")==''){
					flag = false;
					alert("名称不能为空！");
					return ;
				}
				if(cmsKey.replace(/(^\s*)|(\s*$)/g, "")==''){
					flag = false;
					alert("key不能为空");
					return ;
				}
				//查询是否存在，并提交
				checkKey(flag);
				
			});
			
			
			function checkKey(flag){
				var channelName = $("#channelNameId").val();
				var cmsKey = $("#cmsKeyId").val().trim();
				var param = {
					channelName:channelName,
					cmsKey:cmsKey
				};
				$.ajax({
				  	type: 'POST',
				  	url: "${route("/cms/selectbykey.html")}",
				  	data: param,
				  	dataType:"json",
				  	success: function(e){
				  		//库中不存在，可用
				  		if(e.status == 0){
							if(flag){
								$("#keyForm").submit();
								$('.ui.modal').modal('hide');
							}else{
								return;
							}
				  		}else{
				  		//库中已经存在，不可用
				  			alert("Key值已经存在，请重新输入！");
				  			return ;
				  		}
				  	}
				});	
			}
			
			
		});
	</script>
</html>
