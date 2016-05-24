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
                            <div class="form-group col-md-2" >
                                <label>
                                    选择券种类：
                                </label>
                            </div>
                            <div class="form-group  col-md-2">
                                <label class="select">
                                    <select id="coupon" onchange="reacquireCoupon();">
                                        <#list couponList as c>
                                            <option value="${c.couponId!''}-${c.price!''}-${c.productType!''}" >${c.name!''}</option>
                                        </#list>
                                    </select>
                                </label>
                            </div><!-- /form-group -->
                            <div class="form-group col-md-4" >
                                <label>
                                    <input type = "hidden" />
                                </label>
                            </div>
                            <div class="form-group col-md-4" >
                                <label>
                                    <span onclick="plus()" class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                    <input id="number" name="number" style="width: 100px;" onblur="input();" value = "1"/>
                                    <span onclick="minus()" class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                                </label>
                            </div><!-- /form-group -->
                        </form>
                    </div><!-- /.panel-body -->
                </div><!-- /.panel -->
                <div class = "row" id ="selectCoupon">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6" >
                        <div class="form-group">
                            <label>Radios</label>
                            <div class="radio">
                                <label><input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="checked"> Option one is this and that—be sure to include why it's great</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="optionsRadios" id="optionsRadios2" value="option2"> Option two can be something else and selecting it will deselect option one</label>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">

                    </div>
                </div>

            <div class = "row">
                <div class="col-md-3">

                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                            手机号<span class="text-danger">*</span>
                        </label>
                        <div class="col-md-9">
                            <input name="customerMobile" type="text"  class="form-control validate[required]"  />
                            </br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                            姓名<span class="text-danger">*</span>
                        </label>
                        <div class="col-md-9">
                            <input name="customerName" type="text"  class="form-control validate[required]"  />
                            </br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                            公司名称<span class="text-danger">*</span>
                        </label>
                        <div class="col-md-9">
                            <input name="customerCompany" type="text"  class="form-control "  />
                            </br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                            支付宝账号(返利到该支付宝)<span class="text-danger">*</span>
                        </label>
                        <div class="col-md-9">
                            <input name="customerAlipay" type="text"  class="form-control validate[required]"  />
                            </br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-12 control-label">
                            预计支付金额: &nbsp;<span id="payAmount" >0</span>
                        </label>
                        </br>
                    </div>
                </div>
                <div class="col-md-3">

                </div>
            </div>
            </br>
            <div class="col-md-offset-3 col-md-9">
                <a id="confirmButton" type="hidden"  data-toggle="modal" data-target="#customModal3">
                </a>
                <button onclick="confirmInformation()" class="btn btn-info" style="left: 35%;">
                    确认信息
                </button>
                <button class="btn" type="reset" onclick="javascript:history.go(-1)">
                    返回
                </button>
            </div>
        </div><!-- /.content-body -->

        <!-- customModal3 -->
        <div class="modal" id="customModal3" data-transition="flipYIn" tabindex="-1" role="dialog" aria-labelledby="customModal3Label" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-red">
                        <h4 class="modal-title">
                            <a href="#" data-dismiss="modal" class="pull-right" title="Continue shopping" data-toggle="tooltip" data-container="body">
                                <i class="icon-basket-loaded"></i>
                            </a>我的购物车
                        </h4>
                    </div>
                    <div class="panel-body">
                        <p class="fa-2x pull-right"><strong><sup>¥</sup><sup id="confirmTotalAmount"></sup></strong></p>
                        <p class="lead">预计总金额:</p>
                        <p class="text-muted">请确认你的订单</p>
                    </div>
                    <table class="table no-margin">
                        <tbody id="confirmList">

                        </tbody>
                    </table>
                    <div class="modal-footer">
                        <a href="#" onclick="submitOrder();" class="btn btn-danger btn-nofill">提交订单</a>
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

    //订单实体
    var createCouponOrder = {
        customerMobile : "",
        customerName : "",
        customerCompany : "",
        customerAlipay : "",
        couponOrderItems : [

        ]
    }

    var couponOrderItems = {
        couponId : 0,
        amount : 0,
        price : 0,
        giftCouponId : 0
    }

    /**
     * 确认信息页,对象装载
     */
    function confirmInformation(){
        var flag = true;
        var customerMobile = getValueByName("customerMobile");
        var customerName = getValueByName("customerName");
        var customerCompany = getValueByName("customerCompany");
        var customerAlipay = getValueByName("customerAlipay");
        var projectId = getValueById("projectId");
        var projectName = $("#projectId").find("option:selected").text();
        var checkInDate = getValueById("startTime");
        var periodMonth = getValueById("month");
        var periodWeek = getValueById("week");
        var checkOutDate = changeDate(checkInDate,periodMonth,periodWeek);
        var leaseAmount= getAmountValue("leaseAmount");
        var depositAmount = getAmountValue("depositAmount");
        createOrder.customerMobile = customerMobile;
        createOrder.customerName = customerName;
        createOrder.customerCompany = customerCompany;
        createOrder.customerAlipay = customerAlipay;
        createOrder.projectId = projectId;
        createOrder.projectName = projectName;
        createOrder.checkInDate = checkInDate;
        createOrder.checkOutDate = checkOutDate;
        createOrder.periodMonth = periodMonth;
        createOrder.periodWeek = periodWeek;
        createOrder.leaseAmount = leaseAmount;
        createOrder.depositAmount = depositAmount;
        createOrder.orderItems.splice(0,createOrder.orderItems.length);
        $("input[type='checkbox'][name='selectRoom']:checked").each(
                function(){
                    var checkBoxValue = $(this).val();
                    var roomValueArray =  checkBoxValue.split("-");
                    var originalPrice = roomValueArray[0];
                    var finalPrice = roomValueArray[1];
                    var depositPrice = roomValueArray[2];
                    var productType = roomValueArray[3];
                    var productSubType = roomValueArray[4];
                    var bookNum = $("#number-"+checkBoxValue).val();
                    if(bookNum > 0){
                        flag = false;
                        orderItem.projectId = projectId;
                        orderItem.bookNum = bookNum;
                        orderItem.depositPrice = depositPrice;
                        orderItem.finalPrice = finalPrice;
                        orderItem.originalPrice = originalPrice;
                        orderItem.productSubType = productSubType;
                        orderItem.productType = productType;
                        createOrder.orderItems.push(orderItem);
                    }
                }
        );
        if(flag){
            alert("请至少选择一个商品");
        }else{
            $("#confirmButton").click();
            var str = "";
            var stationNumber = 0;
            var depositPrice = parseInt(createOrder.orderItems[0].depositPrice);
            var list = createOrder.orderItems;
            for(var i = 0;i<list.length;i++){
                var title = "";
                if(list[i].productSubType == 1){
                    title = list[i].productSubType + "人办公桌";
                }else{
                    title = list[i].productSubType + "人独立办公室";
                }
                stationNumber += parseInt(list[i].productSubType);
                var content = list[i].finalPrice + "/周*" + parseInt(createOrder.periodMonth) * 4 + parseInt(createOrder.periodWeek) + "*"+list[i].bookNum;
                var price = list[i].finalPrice * (parseInt(createOrder.periodMonth) * 4 + parseInt(createOrder.periodWeek)) * parseInt(list[i].bookNum);
                str +='<tr>'+
                        '<td>'+title+'</td>'+
                        '<td>¥'+content+'</td>'+
                        '<td class="text-muted"><strong>¥'+price+'</strong></td>'+
                        '</tr>';
            }
            str +='<tr>'+
                    '<td>押金</td>'+
                    '<td><sup>¥</sup>'+depositPrice+'/位*'+stationNumber+'</td>'+
                    '<td class="text-muted"><strong>¥'+parseInt(depositPrice) * parseInt(stationNumber)+'</strong></td>'+
                    '</tr>';
            setAmountValue("confirmLeaseAmount",createOrder.leaseAmount);
            setAmountValue("confirmDepositAmount",createOrder.depositAmount);
            setAmountValue("confirmTotalAmount",parseInt(createOrder.leaseAmount)+parseInt(createOrder.depositAmount));
            $("#confirmList").empty();
            $("#confirmList").append(str);
        }

    }

    function submitOrder(){
        $.ajax({
            url:"${path}/ajax/order/create",
            type:"post",
            dataType:'json',
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify(createOrder),
            success:function(data){
                alertMessage(data.errCode);
            },
            error:function(xhr, type, exception){
                alert(type, "Failed");
            }
        })
    }

    /**
     * 错误提示
     */
    function alertMessage(code){
        var key ={
            "106":"请填写账号密码",
            "104":"请重新登录账户",
            "112":"账户已存在",
            "unknow":"#"+code
        }
        if(key[code]) message=key[code];
        else message=key.unknow;
        if(code == 0){
            alert("恭喜您已成功下单");
        }else{
            alert(message);
        }
    }

    /**
     * 选择工位券
     */
    function reacquireCoupon(){
        var couponArray = $("#coupon").val();
        setValueById("number",1);
        setAmountValue("payAmount",couponArray[1]);
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
        var periodMonth = getValueById("month");
        var periodWeek = getValueById("week");
        $("input[type='checkbox'][name='selectRoom']:checked").each(
                function(){
                    var checkBoxValue = $(this).val();
                    var roomValueArray =  checkBoxValue.split("-");
                    var checkedNumber =  $("#number-"+checkBoxValue).val();
                    sumLeaseAmount += roomValueArray[1] * checkedNumber *(parseInt(periodMonth) * 4 + parseInt(periodWeek));
                    sumDepositAmount += roomValueArray[4] * roomValueArray[2] * checkedNumber;
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