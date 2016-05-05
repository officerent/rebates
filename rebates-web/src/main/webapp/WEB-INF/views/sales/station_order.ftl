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
                                    <select id="projectId" onchange="reacquireRoom();">
                                        <#list project as p>
                                            <option value="${p.projectId!''}" >${p.projectName!''}</option>
                                        </#list>
                                    </select>
                                </label>
                            </div><!-- /form-group -->
                            选择入驻时间：
                            <div class="form-group" >
                               <label class="select">
                                   <input id="startTime" onclick="validatepicker(this)" onchange="reacquireRoom()" data-date-format="yyyy-MM-dd" class="form-control date form_date validate[required]" name="startTime" placeholder="开始时间" value="${startTime!''}"/>
                               </label>
                            </div><!-- /form-group -->
                            入驻时长：
                            <div class="form-group" style="width: 100px">
                                <label class="select">
                                    <select id="month" onchange="reacquireRoom()">
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
                                    <select id="week" onchange="reacquireRoom()">
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
                            <th>产品剩余数量</th>
                            <th>选择数量</th>
                            <th>价格</th>
                        </tr>
                        </thead>
                        <tbody id ="productList">
                            <#if productList??>
                                <#list productList as product>
                                    <tr>
                                        <td name='roomId'>
                                            <#if product.remainedNum  gt 0 >
                                                <input type="checkbox" name="selectRoom" value="${product.price!""}-${product.finalPrice!""}-${product.deposit!""}-${product.productType!""}-${product.productSubtype!""}-${product.remainedNum!""}"/>
                                            <#else >
                                                <input type="checkbox" name="selectRoom" value="${product.price!""}-${product.finalPrice!""}-${product.deposit!""}-${product.productType!""}-${product.productSubtype!""}-${product.remainedNum!""}" disabled = disabled/>
                                            </#if>
                                        </td>
                                        <td>${product.title!""}</td>
                                        <td>${product.remainedNum!""}</td>
                                        <td>
                                            <#if product.remainedNum  gt 0 >
                                                <span onclick="plus('${product.price!""}-${product.finalPrice!""}-${product.deposit!""}-${product.productType!""}-${product.productSubtype!""}-${product.remainedNum!""}')" class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                                <input id="number-${product.price!""}-${product.finalPrice!""}-${product.deposit!""}-${product.productType!""}-${product.productSubtype!""}-${product.remainedNum!""}" name="number" style="width: 100px;" onblur="input('number-${product.price!""}-${product.finalPrice!""}-${product.deposit!""}-${product.productType!""}-${product.productSubtype!""}-${product.remainedNum!""}');" value = "0"/>
                                                <span onclick="minus('${product.price!""}-${product.finalPrice!""}-${product.deposit!""}-${product.productType!""}-${product.productSubtype!""}-${product.remainedNum!""}')" class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                                            <#else >
                                                暂无工位
                                            </#if>
                                        </td>
                                        <td>￥${product.finalPrice!""}/${product.priceTypeStr!""}</td>
                                    </tr>
                                </#list>
                            </#if>
                        </tbody>
                    </table>
                </div><!-- /.table-responsive -->
                </div><!-- /.cols -->

                <div class = "row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">
                                客户手机号<span class="text-danger">*</span>
                            </label>
                            <div class="col-md-9">
                                <input name="customerMobile" type="text"  class="form-control validate[required]"  />
                                </br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">
                                客户姓名<span class="text-danger">*</span>
                            </label>
                            <div class="col-md-9">
                                <input name="customerName" type="text"  class="form-control validate[required]"  />
                                </br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">
                                客户公司<span class="text-danger">*</span>
                            </label>
                            <div class="col-md-9">
                                <input name="customerCompany" type="text"  class="form-control validate[required]"  />
                                </br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">
                                客户支付宝账号<span class="text-danger">*</span>
                            </label>
                            <div class="col-md-9">
                                <input name="customerAlipay" type="text"  class="form-control validate[required]"  />
                                </br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-12 control-label">
                                押金金额: &nbsp;<span id="depositAmount" >0</span>
                            </label>
                            </br>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-12 control-label">
                                租金金额:&nbsp;<span id="leaseAmount" >0</span>
                            </label>
                            </br>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-12 control-label">
                                总金额:&nbsp;<span id="totalAmount" >0</span>
                            </label>
                            </br>
                        </div>
                    </div>
                    <div class="col-md-3">

                    </div>
                </div>
                </br>
                <div class="col-md-offset-3 col-md-9">
                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#customModal3">
                        确认信息
                    </button>
                    <#--<button class="btn btn-info" type="submit" style="left: 35%;">-->
                        <#--确认-->
                    <#--</button>-->
                    <button class="btn" type="reset" onclick="javascript:history.go(-1)">
                        返回
                    </button>
                </div>
            </div><!-- /.content-body -->

        <!-- customModal3 -->
        <div class="modal" id="customModal3" data-transition="flipYIn" tabindex="-1" role="dialog" aria-labelledby="customModal3Label" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header bg-red">
                        <h4 class="modal-title">
                            <a href="#" data-dismiss="modal" class="pull-right" title="Continue shopping" data-toggle="tooltip" data-container="body">
                                <i class="icon-basket-loaded"></i>
                            </a>My Cart
                        </h4>
                    </div>
                    <div class="panel-body">
                        <p class="fa-2x pull-right"><strong><sup>$</sup>58<sup>.5</sup></strong></p>
                        <p class="lead">Current total</p>
                        <p class="text-muted">Please confirm your order!</p>
                    </div>
                    <table class="table no-margin">
                        <tbody>
                        <tr>
                            <td class="text-center"><div class="fa fa-cutlery text-red"></div></td>
                            <td>Soto Babat</td>
                            <td class="text-muted"><strong><sup>$</sup> 12.5</strong></td>
                        </tr>
                        <tr>
                            <td class="text-center"><div class="icon-cup text-red"></div></td>
                            <td>Jahe Wangi</td>
                            <td class="text-muted"><strong><sup>$</sup> 8.0</strong></td>
                        </tr>
                        <tr>
                            <td class="text-center"><div class="fa fa-cutlery text-red"></div></td>
                            <td>Sate&nbsp;&nbsp;&nbsp;<span class="text-muted" title="Deal added"><i class="icon-tag" aria-label="deal tag"></i> <small>#AUG15</small></span></td>
                            <td class="text-muted"><strong><sup>$</sup> 20.0</strong></td>
                        </tr>
                        <td class="text-center"><div class="fa fa-cutlery text-red"></div></td>
                        <td>Megono</td>
                        <td class="text-muted"><strong><sup>$</sup> 12.0</strong></td>

                        <tr>
                            <td class="text-center"><div class="icon-cup text-red"></div></td>
                            <td>Sop Buah</td>
                            <td class="text-muted"><strong><sup>$</sup> 6.0</strong></td>
                        </tr>
                        <tr>
                        </tr></tbody>
                    </table>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-danger btn-nofill">Confirm Order</a>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

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

    /**
     * 获取项目列表
     * @param projectId 项目id
     * @param checkInDate 开始时间
     * @param checkOutDate 结束时间
     */
    function getProductList(projectId,checkInDate,checkOutDate){
        //清零
        setAmountValue("leaseAmount",0);
        setAmountValue("depositAmount",0);
        setAmountValue("totalAmount",0);
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
                    var list = data.data;
                    $("#productList").empty();
                    var str = "";
                    for(var i = 0;i<list.length;i++){
                        var product = list[i];
                        if(product.remainedNum > 0){
                            str += '<tr>'+
                                    '<td name="roomId"><input type="checkbox" name="selectRoom" value="'+product.price+'-'+product.finalPrice+'-'+product.deposit+'-'+product.productType+'-'+product.productSubtype+'-'+product.remainedNum+'"/></td>'+
                                    '<td>'+product.title+'</td>'+
                                    '<td>'+product.remainedNum+'</td>'+
                                    '<td><span onclick="plus(\''+product.price+'-'+product.finalPrice+'-'+product.deposit+'-'+product.productType+'-'+product.productSubtype+'-'+product.remainedNum+'\')" class="glyphicon glyphicon-plus" aria-hidden="true"></span>'+
                                    '<input id="number-'+product.price+'-'+product.finalPrice+'-'+product.deposit+'-'+product.productType+'-'+product.productSubtype+'-'+product.remainedNum+'" name="number" style="width: 100px;" onblur="input(\'number-'+product.price+'-'+product.finalPrice+'-'+product.deposit+'-'+product.productType+'-'+product.productSubtype+'-'+product.remainedNum+'\');" value = "0"/>'+
                                    '<span onclick="minus(\''+product.price+'-'+product.finalPrice+'-'+product.deposit+'-'+product.productType+'-'+product.productSubtype+'-'+product.remainedNum+'\')" class="glyphicon glyphicon-minus" aria-hidden="true"></span></td>'+
                                    '<td>￥'+product.finalPrice+'/'+product.priceTypeStr+'</td>'+
                                    '</tr>';
                        }else{
                            str += '<tr>'+
                                    '<td name="roomId"><input type="checkbox" name="selectRoom" value="'+product.price+'-'+product.finalPrice+'-'+product.deposit+'-'+product.productType+'-'+product.productSubtype+'-'+product.remainedNum+'" disabled = disabled/></td>'+
                                    '<td>'+product.title+'</td>'+
                                    '<td>'+product.remainedNum+'</td>'+
                                    '<td>暂无工位</td>'+
                                    '<td>￥'+product.finalPrice+'/'+product.priceTypeStr+'</td>'+
                                    '</tr>';
                        }
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

    /**
     * 重新获取房源
     */
    function reacquireRoom(){
        var projectId = $("#projectId").val();
        var startTime = $("#startTime").val();
        var month = $("#month").val();
        var week = $("#week").val();
        var endTime = changeDate(startTime,month,week);
        getProductList(projectId,startTime,endTime);
    }

    /**
     *  获取数值
     */
    function getAmountValue(id){
       var amount = $("#"+id).text();
        if(amount != null && amount != "" && amount !=0){
            return parseFloat(amount);
        }else{
            return 0;
        }
    }

    /**
     * 设置数值
     */
    function setAmountValue(id,value){
        var amount = $("#"+id);
        amount.empty();
        if(value != undefined && value != null && value != ""){
            amount.append(value);
        }else{
            amount.append(0);
        }
    }

//    点击加号
    function plus(id){
        var number = parseInt($("#number-"+id).val());
        var array = id.split("-");
        var remainedNum = parseInt(array[5]);
        if(number < remainedNum){
            number ++;
            checkedItem(id,'checked');
        }else{
            alert("不能超过工位剩余数");
        }
        $("#number-"+id).val(number);
        sumTotal();
    }

//    点击减号
    function minus(id){
        var number = parseInt($("#number-"+id).val());
        if(number > 0){
            number --;
            if(number == 0 ){
                checkedItem(id,'cancel');
            }
        }else{
            checkedItem(id,'cancel');
            alert("工位数不能小于零");
        }
        $("#number-"+id).val(number);
        sumTotal();
    }

//    手动输入
    function input(id){
        var number = parseInt($("#number-"+id).val());
        var array = id.split("-");
        var remainedNum = parseInt(array[5]);
        if(number >= 0 && number <= remainedNum){
            $("#number-"+id).val(number);
            checkedItem(id,'checked');
        }else{
            $("#number-"+id).val(0);
            checkedItem(id,'cancel');
            alert("工位数不能小于零,并且不能大于剩余工位数");
        }

        sumTotal();
    }

    function sumTotal(){
        var sumLeaseAmount = 0;
        var sumDepositAmount = 0;
        var sumTotalAmount = 0;
        $("input[type='checkbox'][name='selectRoom']:checked").each(
                function(){
                    var checkBoxValue = $(this).val();
                    var roomValueArray =  checkBoxValue.split("-");
                    var checkedNumber =  $("#number-"+checkBoxValue).val();
                    sumLeaseAmount += roomValueArray[1] * checkedNumber;
                    sumDepositAmount += roomValueArray[4] * roomValueArray[2];
                }
        );
        sumTotalAmount = sumLeaseAmount + sumDepositAmount;
        setAmountValue("leaseAmount",sumLeaseAmount);
        setAmountValue("depositAmount",sumDepositAmount);
        setAmountValue("totalAmount",sumTotalAmount);
    }

    function checkedItem(value,status){
        if(status == "cancel"){
            $("input[type='checkbox'][name='selectRoom']").each(
                    function(){
                        var checkBoxValue = $(this).val();
                        if(checkBoxValue == value){
                            $(this).prop("checked",false);
                        }
                    }
            );
        }else{
            $("input[type='checkbox'][name='selectRoom']").each(
                    function(){
                        var checkBoxValue = $(this).val();
                        if(checkBoxValue == value){
                            $(this).prop("checked", true);
                        }
                    }
            );
        }
    }


    /**
     * 修改时间方法
     * @param startTime 开始时间
     * @param month 添加月份
     * @param day 添加天数
     */
    function changeDate(startTime,month,day){
        var now = new Date(startTime);
       // now.setDate(startTime);
        now.setMonth(now.getMonth() + parseInt(month))
        now.setDate(now.getDate() +  parseInt(day));
        return $.format.date(now,"yyyy-MM-dd");
    }

</script>
</@layoutFooter>