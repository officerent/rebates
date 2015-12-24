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
			  	<button class="ui floated button red delButton" style="margin-left: 400px;"  onClick="delCmsKey()">删除</button>
			</div>
			
			<div class="ui divider"></div>
			
		<form class="ui keyfrom form" action="${route("/cms/updatekey.html")}" id="keyForm" method="post">
			<input type="hidden" name="channelName" value="${channelName!''}" id="channelNameId" >
			<input type="hidden" name="keyId" value="${key.keyId!''}">
			<div class="ui form">
			  <div class="inline field">
			    <span class="y-label">名称:</span>
			    <input type="text" placeholder="name" name="name" value="${key.name!''}" id="keyNameId">
			  </div>
			  <div class="inline field">
			    <span class="y-label">Key:</span>
			    <input type="text" placeholder="cmsKey" name="cmsKey" value="${key.cmsKey!''}" id="cmsKeyId" disabled >
			  </div>
			  <input type="hidden" id="hkeyTypeId" value="${key.keyType!''}">
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
					<input type="hidden" id="htagId" value="${key.tagId!''}">
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
			  <form class="ui  form" action="${route("/cms/addtag.html")}" method="post" id="tagForm">
				  	<input type="hidden" name="channelName" value="${channelName!''}">
				  	<input type="hidden" name="keyId" value="${key.keyId}">
				  	<div class="inline fields">
					    <div class="field">
					      <label>Tag：</label>
					       <input type="text" placeholder="Tag名称" name="name" id="tagNameId">
					    </div>
				  	</div>
				  	<div class="inline fields">
					    <div class="field">
					      <label>Color：</label>
					      <a class="tiny ui inverted red button" value="red">Red</a>
						  <a class="tiny ui inverted orange button" value="orange">Orange</a>
						  <a class="tiny ui inverted yellow button"  value="yellow">Yellow</a>
						  <a class="tiny ui inverted olive button"  value="olive">Olive</a>
						  <a class="tiny ui inverted green button"  value="green">Green</a>
						  <a class="tiny ui inverted teal button"  value="teal">Teal</a>
						  <a class="tiny ui inverted blue button" value="blue">Blue</a>
						  
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
			
			//默认值
			var keyType = $("#hkeyTypeId").val();
			if(keyType){
				$("#keyTypeId").find("option[value='"+keyType+"']").attr("selected",true);
			}
			var tagId = $("#htagId").val();
			if(tagId){
				$("#tagId").find("option[value='"+tagId+"']").attr("selected",true);
			}
			
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
				//提交
				if(flag){
					$("#keyForm").submit();
					$('.ui.modal').modal('hide');
				}else{
					return;
				}
			});
			
		});
		
		function delCmsKey(){
			var key_id=${key.keyId!''};
			var channel_name="${channelName!''}";
			var href="${route("/cms/delkey")}?KeyId="+key_id+"&channelName="+channel_name;
			console.info(href);
			window.location.href=href;
		}
	</script>
</html>
