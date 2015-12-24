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
										<#if key.enabled==1>
											<input type="checkbox" name="public" checked="checked" data-id="${key.keyId}">
										<#else>
											<input type="checkbox" name="public"  data-id="${key.keyId}">
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