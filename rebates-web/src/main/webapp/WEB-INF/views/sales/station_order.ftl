<#include "../web_common/_layout.ftl" />

<@layoutHead>

</@layoutHead>
<@layoutBody classBody="wrapkit-sidebar-left wrapkit-sidebar-lg bg-grd-dark wrapkit-sidebar-horizontal" >

</@layoutBody>
<main class="wrapkit-wrapper" id="wrapper" data-init-layout="true">

    <!-- ============================================
    MAIN CONTENT SECTION
    =============================================== -->
    <section class="content-wrapper" role="main" data-init-content="true">
        <div class="content">

            <div class="content-body">
                <div class="panel fade in panel-default panel-fill" data-fill-color="true" data-init-panel="true">
                    <div class="panel-body">
                        <form class="form-inline">
                            选择项目：
                            <div class="form-group">
                                <label class="select">
                                    <select id="projectId">
                                        <#list project as p>
                                            <option value="${p.projectId!''}" >${p.projectName!''}</option>
                                        </#list>
                                    </select>
                                </label>
                            </div><!-- /form-group -->
                            选择入驻时间：
                            <div class="form-group" >
                               <label class="select">
                                   <input id="startTime" onclick="validatepicker(this)" data-date-format="yyyy-MM-dd" class="form-control date form_date validate[required]" name="startTime" placeholder="开始时间" value="${startTime!''}"/>
                               </label>
                            </div><!-- /form-group -->
                            入驻时长：
                            <div class="form-group" style="width: 100px">
                                <label class="select">
                                    <select id="month">
                                        <option value="0">0</option>
                                        <option value="1" selected="selected">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                </label>
                            </div><!-- /form-group -->
                            （月）
                            <div class="form-group" style="width: 100px">
                                <label class="select">
                                    <select id="week">
                                        <option value="0" selected="selected">0</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                </label>
                            </div><!-- /form-group -->
                            （周）
                        </form>
                    </div><!-- /.panel-body -->
                </div><!-- /.panel -->


                <div class="table-responsive">

                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>选择</th>
                            <th>产品名称</th>
                            <th>价格</th>
                        </tr>
                        </thead>
                        <tbody id ="productList">
                            <#if productList??>
                                <#list productList as product>
                                    <tr>
                                        <td name='roomId'><input type="checkbox" name="selectRoom" value="${product.productId!""}"/></td>
                                        <td>${product.title!""}</td>
                                        <td>￥${product.finalPrice!""}/${product.priceTypeStr!""}</td>
                                    </tr>
                                </#list>
                            </#if>
                        </tbody>
                    </table>
                </div><!-- /.table-responsive -->
                </div><!-- /.cols -->
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-info" type="submit" style="left: 35%;">
                        提交
                    </button>
                    <button class="btn" type="reset" onclick="javascript:history.go(-1)">
                        返回
                    </button>
                </div>
            </div><!-- /.content-body -->


            <!-- Template Setups -->
            <div class="modal fade" id="templateSetup">
                <div class="modal-dialog">
                    <!-- modal-content -->
                    <div class="modal-content"></div>
                </div><!-- /.modal-dialog -->
            </div><!-- /.templateSetup -->

        </div><!-- /.content -->
    </section><!-- /MAIN -->



    <!-- ============================================
    FOOTER SECTION
    =============================================== -->
    <footer class="footer-wrapper footer-default" role="contentinfo" data-init-footer="true">
        <div class="footer">
            <div class="pull-right text-muted"><small>Currently v1.0</small></div>
            <div>&copy;<em id="currentYear"></em>  XL</div>
        </div>
    </footer><!-- /.FOOTER -->

</main>
<@layoutFooter>
<script>
    var date = new Date;
    $("#currentYear").append(date.getFullYear());

    $("#projectId").on("change",function(){

    });

    function getProductList(projectId,checkInDate,checkOutDate){
        var formDate = {
            projectId:projectId,
            checkInDate:checkInDate,
            checkOutDate:checkOutDate
        }
        $.ajax({
            url:"${path}/ajax/soho3q/product_list",
            type:"get",
            dataType:'json',
            data:formDate,
            success:function(data){
                if(data.errCode==0){
                    var list = data.result;
                    $("#productList").empty();
                    var str = "";
                    for(var i = 0;i<list.length;i++){
                        str += "<tr><td name='roomId'>"+list[i].productId+"</td><td>"+list[i].title+"</td><td>￥"+list[i].finalPrice+"/"+list[i].priceTypeStr+"</td></tr>";
                    }
                    $("#productList").append(str);
                }else{
                    var key ={
                        "106":"请填写账号密码",
                        "112":"账户已存在",
                        "unknow":"#"+data.errCode
                    }
                    if(key[data.errCode]) message=key[data.errCode];
                    else message=key.unknow;
                    alert(message);
                }
            },
            error:function (xhr, type, exception) {
                alert(type, "Failed");
            }
        });
    }
</script>
</@layoutFooter>