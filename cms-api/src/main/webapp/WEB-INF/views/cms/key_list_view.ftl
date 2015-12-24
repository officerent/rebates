<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="${resource("/css/index.css")}" />
		<link rel="stylesheet" href="${resource("/css/semantic.min.css")}" />
	</head>

	<body>
		<header>
			CMS系统
		</header>
		<div class="width80">

		<div>
			<div class="ui huge breadcrumb " style="margin-top: 20px;">
				<input type="hidden" name="channelName" value="${channelName!''}" id="channelNameId">
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
				  <div class="active section">Key列表</div>
			</div>
			
			<div class="ui divider"></div>
			<div class="ui form ">
			      <div class="actions">
			        <a href="${route("/cms/tonewkey.html?channelName=${channelName!''}")}">
			      		<div class="ui right floated  button green" >新建c-key</div>
			      	</a>
			      </div>
			</div>
			
			<table class="ui inline green  table">
				<tbody>
					<tr>
						<td colspan="5"> 
							<!--<button class="ui green button">首页</button>
							<button class="ui green button">列表页</button>-->
							<label>Tag：</label>
								<input type="hidden" placeholder="Search..." id="searchTagId" value="">
								<a class="tiny ui inverted searchTag green active button" data-tagId="">All-Tag</a>
							<#if tagList??>
				  	 			<#list tagList as tag> 
				  	 				<a class="tiny ui inverted searchTag ${tag.color!"red"} button" data-tagId="${tag.tagId!''}">${tag.name!''}</a>
				  	 			</#list>
				  	 		</#if>
				  	 			<!--
				  	 			<a class="ui inverted violet button">Violet</a>
								  <a class="ui inverted orange button">Orange</a>
								  <a class="ui inverted yellow button">Yellow</a>
								  <a class="ui inverted olive button">Olive</a>
								  <a class="ui inverted green button">Green</a>
								  <a class="ui inverted teal button">Teal</a>
								  <a class="ui inverted blue button">Blue</a>
								  <a class="ui inverted violet button">Violet</a>
								  <a class="ui inverted purple button">Purple</a>
								  <a class="ui inverted pink button">Pink</a>
								  <a class="ui inverted brown button">褐色</a>
				  	 			-->
							  
						</td>
					</tr>

					<tr>
						<td> 
							<label>名称：</label>
							<div class="ui input focus">
								<input type="text" placeholder="Search..." id="searchNameId" value="">
							</div>
						</td>
						<td> <label>Key：</label>
							<div class="ui input focus">
								<input type="text" placeholder="Search..."  id="searchKeyId" value="">
							</div>
						</td>
						<td> 
							<div class="field">
								<label>类型：</label>
								<select class="ui dropdown" id="searchTypeId">
								  <option value="">请选择类型</option>
								  <option value="HTML">HTML</option>
								  <option value="JSON">JSON</option>
								  <option value="INT">INT</option>
								  <option value="STRING">STRING</option>
								  <option value="BOOLEAN">BOOLEAN</option>
								</select>
							</div>
						</td>
						<td> 
							<div class="field">
								<label>状态：</label>
								<select class="ui dropdown" id="searchEnableId">
								  <option value="">请选择状态</option>
								  <option value="0">未生效</option>
								  <option value="1">已生效</option>
								</select>
							</div>
						</td>
						<td>
							<button class="ui green inverted button" id="searchListId">搜索</button>
						</td>
					</tr>
				</tbody>
			</table>
		
		</div>

		<div>
			<table class="ui green celled table" id="listKeyViewId" >
				<thead>
					<tr>
						<th>c-key</th>
						<th>名称</th>
						<th>描述</th>
						<th>状态</th>
						<th style="width: 8%;">启用/禁用</th>
						<th>操作</th>
					</tr>
				</thead>
				
				<tbody >
					<#if pageData??>
					<#if pageData.listData??>
				  	 	<#list pageData.listData as key>  
					  	 	<tr>
					  	 		<td>
					  	 			<a href="${route("/cms/toupdatekey.html?channelName=${channelName!''}&keyId=${key.keyId}")}">${key.cmsKey!''}</a>
					  	 			<#if key.tagName ??>
					  	 				<a class="mini ui inverted ${key.tagColor!"green"} active button">${key.tagName!''}</a>
					  	 			</#if>
					  	 		</td>
								<td>
									<!--
										<div class="ui ribbon label">First</div>
									-->
									${key.name!''} 
								</td>
								<td>
									<#if key.description??>
										<#if key.description?length gt 25 >
											${key.description[0..25]}...
										<#else>
											${key.description!''}
										</#if>
									</#if>
								</td>
								<td>
									<#if key.enabled??>
										<#if key.enabled==0>
											未生效
										<#else>
											已生效
										</#if>
									</#if>
								</td>
								<td>
									<div class="ui toggle checkbox">
										<#if key.enabled??>
											<#if key.enabled==1>
												<input type="checkbox" name="public" checked="checked" data-id="${key.keyId}">
											<#else>
												<input type="checkbox" name="public" data-id="${key.keyId}">
											</#if>
										<#else>
											<input type="checkbox" name="public" data-id="${key.keyId}">
										</#if>
										<label>&nbsp</label>
									</div>
								</td>
								<td>
									<a class="ui green button" href="${route("/cmsvalue/getvalue?channel_name=${channelName!''}&cms_key=${key.cmsKey!''}")}">编辑</a>
								</td>
							</tr>
				  	   </#list>
				 	</#if>
				 	<#else>
				 		<tr>
				 			<td colspan="6" style="text-align:center;height:100px;">
				 				暂无数据
				 			</td>
				 		</tr>
					</#if>
				</tbody>
				<tfoot>
				    <tr><th colspan="6">
				    	<#if pageData??>
				    		<#assign totalPage = pageData.pageTotal>
					      <div class="ui right floated pagination menu">
					      		<#if pageData.pageNum gt 1>
						      		<#if totalPage gt 1 >
						      			<a class="icon item leftpage">
								          <i class="left chevron icon"></i>
								        </a>
						      		</#if>
					      		</#if>
				 				<#list 1..totalPage as num>
								 <#if pageData.pageNum == num >
								   		<a class="item keypage green active"  data-page="${num}">${num}</a>
								   <#else>
								   		<a class="item keypage"  data-page="${num}">${num}</a>
								 </#if>
							   </#list>
				 			
					      		<#if totalPage gt pageData.pageNum>
						      		<#if totalPage gt 1 >
						      			<a class="icon item rightpage">
								          <i class="right chevron icon"></i>
								        </a>
						      		</#if>
					      		</#if>
					      </div>
				      </#if>
				    </th>
				  </tr>
				</tfoot>
			</table>
		</div>
		</div>
		<script src="${resource("/js/jquery.js")}" ></script>
		
		<script>
			
			$(function(){
				var channelName = $("#channelNameId").val();
				
				function listpage(pageNum){
					var searchName = $("#searchNameId").val();
					var searchKey = $("#searchKeyId").val().trim();
					var searchType = $("#searchTypeId").val().trim();
					var searchEnabled = $("#searchEnableId").val();
					var searchTagId = $("#searchTagId").val();
					var param = {
						pageNum:pageNum,
						channelName:channelName,
						name:searchName,
						cmsKey:searchKey,
						keyType:searchType,
						enabled:searchEnabled,
						tagId:searchTagId
					}; 
					
					$.ajax({
					  	type: 'POST',
					  	url: "${route("/cms/pagekeylist.html")}",
					  	data: param,
					  	dataType: "html",
					  	success: function(e){
					  	
					  		$("#listKeyViewId").html("");
					  		$("#listKeyViewId").html(e);
					  		
					  		clickPage();
					  		switchPage();
					  		checkBoxClick();
					  	}
					});	
				}
				
				$(".keypage").on("click",function(o){
					var obj = $(this);
					var pageNum = obj.attr("data-page");
					//分页查询
					listpage(pageNum);
					//样式变化
					$(".keypage").each(function(){
						var _sub = $(this);
						if(_sub.hasClass("active")){
							_sub.removeClass("active");
							_sub.removeClass("green");
						}
					});
					obj.addClass("green");
					obj.addClass("active");
					 
				});
			
				function clickPage(){
					$(".keypage").on("click",function(o){
						var obj = $(this);
						var pageNum = obj.attr("data-page");
						//分页查询
						listpage(pageNum);
						//样式变化
						$(".keypage").each(function(){
							var _sub = $(this);
							if(_sub.hasClass("active")){
								_sub.removeClass("active");
								_sub.removeClass("green");
							}
						});
						obj.addClass("green");
						obj.addClass("active");
						 
					});
				}
				
				$("#searchListId").on("click",function(){
					var searchName = $("#searchNameId").val();
					var searchKey = $("#searchKeyId").val().trim();
					var searchType = $("#searchTypeId").val().trim();
					var searchEnabled = $("#searchEnableId").val();
					var searchTagId = $("#searchTagId").val();
					var param = {
						pageNum:1,
						channelName:channelName,
						name:searchName,
						cmsKey:searchKey,
						keyType:searchType,
						enabled:searchEnabled,
						tagId:searchTagId
					}
					//console.log(param);
					//return ;
					$.ajax({
					  	type: 'POST',
					  	url: "${route("/cms/searchkeylist.html")}",
					  	data: param,
					  	dataType: "html",
					  	success: function(e){
					  		//console.log(e);
					  		$("#listKeyViewId").html("");
					  		$("#listKeyViewId").html(e);
					  		
					  		clickPage();
					  		switchPage();
					  		checkBoxClick();
					  	}
					});	
				});
				
				function switchPage(){
					//前一页
					$(".leftpage").on("click",function(){
						var nowPage = $(".keypage.green.active").attr("data-page");
						var upPage = parseInt(nowPage)-1;
						listpage(upPage);
					});
					//后一页
					$(".rightpage").on("click",function(){
						var nowPage = $(".keypage.green.active").attr("data-page");
						var nextPage = parseInt(nowPage)+1;
						listpage(nextPage);
					});
				}
				switchPage();
				
				function checkBoxClick(){
					$(".toggle.checkbox").on("click",function(){
						var _this = $(this).children(":first");
						var flag = $(_this).is(":checked");
						var keyId = $(_this).attr("data-id");
						var enabledSub = 0;
						if(flag){
							enabledSub=1;
						}
						var searchName = $("#searchNameId").val();
						var searchKey = $("#searchKeyId").val().trim();
						var searchType = $("#searchTypeId").val().trim();
						var searchEnabled = $("#searchEnableId").val();
						var searchTagId = $("#searchTagId").val();
						var param = {
							pageNum:1,
							channelName:channelName,
							name:searchName,
							cmsKey:searchKey,
							keyType:searchType,
							enabled:searchEnabled,
							keyId:keyId,
							enabledSub:enabledSub,
							tagId:searchTagId
						}
						console.log(param);
						//return;
						$.ajax({
						  	type: 'POST',
						  	url: "${route("/cms/modifykeystatus.html")}",
						  	data: param,
						  	dataType: "html",
						  	success: function(e){
						  		//console.log(e);
						  		$("#listKeyViewId").html("");
						  		$("#listKeyViewId").html(e);
						  		
						  		clickPage();
						  		switchPage();
						  		checkBoxClick();
						  	}
						});	
						console.log(flag);
						console.log(_this);
					});
					
					
				}
				checkBoxClick();
				
				
				$(".searchTag").on("click",function(){
					var obj = $(this);
					$(".searchTag").each(function(){
						var _sub = $(this);
						if(_sub.hasClass("active")){
							_sub.removeClass("active");
						}
					});
					obj.addClass("active");
					$("#searchTagId").val(obj.attr("data-tagId"));
					
					listpage(1);
				});
				
			});
			
			
			
			
		</script>
	</body>
</html>