<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>CMS系统</title>
		<link rel="stylesheet" href="${resource("/css/index.css")}" />
		<link rel="stylesheet" href="${resource("/css/semantic.min.css")}" />
	</head>
	<body>
		<header>
			CMS系统
		</header>
		<div class="width80 mt50">
			<div></div>
			<div class="ui ignored positive message ">
				SOHO 3Q 快速、稳定的内容发布平台。 
			</div>
			<div class="ui three column grid ">
				<#if channelList??>
			  	 <#list channelList as item>  
			  	 	<div class="column">
			  	 		<a href="${route("/cms/keylistview.html?channelName=${item.name}")}">
						    <div class="ui segment center aligned y-index-menu-back${item_index+1}">
						    	<div class="y-index-menu ">
						    		${item.description!''}
						    	</div>
						    </div>
					    </a>
					</div>
			  	 </#list>
			  </#if>
			  
			  
			</div>
		</div>
	</body>
</html>
