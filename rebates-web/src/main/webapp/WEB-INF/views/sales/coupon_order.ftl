<#include "../web_common/_layout.ftl" />

<@layoutHead>

    <#assign coupon="active" />
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
                            <div class="form-group col-sm-2">
                                <label>
                                    选择券种类：
                                </label>
                                <label class="select">
                                    <select id="coupon" onchange="reacquireCoupon();">
                                    <#list couponList as c>
                                        <option value="${c.couponId!''}-${c.price!''}-${c.productType!''}">${c.name!''}</option>
                                    </#list>
                                    </select>
                                </label>
                            </div>
                            <div class="form-group col-md-1"></div>
                            <div class="form-group col-md-3">
                                <div class="form-group">
                                    <label class="col-sm-6 control-label">
                                        选择数量：
                                    </label>
                                    <label >
                                        <span onclick="plusCoupon();" class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                        <input id="number" name="number" style="width: 100px;" onblur="inputCoupon();" value="1"/>
                                        <span onclick="minusCoupon();" class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                                    </label>
                                </div>
                            </div>
                            <!-- /form-group -->
                            <div class="form-group col-md-3">
                                <div class="form-group">
                                    <label class="col-sm-10 control-label">
                                        商品单价:
                                    </label>
                                    <label >
                                        <span aria-hidden="true" id="price"></span>/张
                                    </label>
                            </div>

                            <!-- /form-group -->
                        </form>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->


                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6">
                        <div class="form-group" id="selectCouponList" style="display: none">
                            <label class="col-sm-3 control-label">
                                选择赠送工位券<span class="text-danger">*</span>
                            </label>

                            <div class="col-md-9">
                                <div class="row" id="selectCoupon">

                                </div>
                                </br>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">
                                手机号<span class="text-danger">*</span>
                            </label>

                            <div class="col-md-9">
                                <input name="customerMobile" type="text" class="form-control validate[required]"/>
                                </br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">
                                姓名<span class="text-danger">*</span>
                            </label>

                            <div class="col-md-9">
                                <input name="customerName" type="text" class="form-control validate[required]"/>
                                </br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">
                                公司名称<span class="text-danger">*</span>
                            </label>

                            <div class="col-md-9">
                                <input name="customerCompany" type="text" class="form-control "/>
                                </br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">
                                支付宝账号(返利到该支付宝)<span class="text-danger">*</span>
                            </label>

                            <div class="col-md-9">
                                <input name="customerAlipay" type="text" class="form-control validate[required]"/>
                                </br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-12 control-label">
                                预计支付金额: &nbsp;<span id="payAmount">0</span>
                            </label>
                            </br>
                        </div>
                    </div>
                    <div class="col-md-3">

                    </div>
                </div>
                </br>
                <div class="col-md-offset-3 col-md-9">
                    <a id="confirmButton" type="hidden" data-toggle="modal" data-target="#customModal3">
                    </a>
                    <button onclick="confirmInformation()" class="btn btn-info" style="left: 35%;">
                        确认信息
                    </button>
                    <button class="btn" type="reset" onclick="javascript:history.go(-1)">
                        返回
                    </button>
                </div>
            </div>
            <!-- /.content-body -->

            <!-- customModal3 -->
            <div class="modal" id="customModal3" data-transition="flipYIn" tabindex="-1" role="dialog"
                 aria-labelledby="customModal3Label" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header soho-orange">
                            <h4 class="modal-title">
                                <a href="#" data-dismiss="modal" class="pull-right" title="Continue shopping"
                                   data-toggle="tooltip" data-container="body">
                                    <i class="icon-basket-loaded"></i>
                                </a>我的返利
                            </h4>
                        </div>
                        <div class="panel-body">
                            <p class="fa-2x pull-right"><strong><sup id="confirmName"></sup></strong>
                            </p>

                            <p class="lead">用户名:</p>
                            <p class="fa-2x pull-right"><strong><sup id="confirmMobile"></sup></strong>
                            </p>

                            <p class="lead">手机号:</p>
                            <p class="fa-2x pull-right"><strong><sup id="confirmCompanyName"></sup></strong>
                            </p>

                            <p class="lead">公司名称:</p>
                            <p class="fa-2x pull-right"><strong><sup id="confirmAlipay"></sup></strong>
                            </p>

                            <p class="lead">支付宝账号:</p>
                            <p class="fa-2x pull-right"><strong><sup>¥</sup><sup id="confirmTotalAmount"></sup></strong>
                            </p>

                            <p class="lead">预计总金额:</p>

                            <p class="text-muted">请确认你的返利</p>
                        </div>
                        <table class="table no-margin">
                            <tbody id="confirmList">

                            </tbody>
                        </table>
                        <div class="modal-footer">
                            <a href="#" onclick="submitOrder();" class="btn soho-orange btn-nofill">提交订单</a>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->

            <!-- Template Setups -->
            <div class="modal fade" id="templateSetup">
                <div class="modal-dialog">
                    <!-- modal-content -->
                    <div class="modal-content"></div>
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.templateSetup -->

        </div>
        <!-- /.content -->
    </section>
    <!-- /MAIN -->


    <!-- ============================================
    FOOTER SECTION
    =============================================== -->
    <footer class="footer-wrapper footer-default" role="contentinfo" data-init-footer="true">
        <div class="footer">
            <div class="pull-right text-muted">
                <div class="pull-right text-muted"><small>京ICP备16037216号</small></div>
            </div>
            <div>&copy;<em id="currentYear"></em> XL</div>
        </div>
    </footer>
    <!-- /.FOOTER -->

</main>
<@layoutFooter>
<script id="couponRadio" type="text/html">
    <div class="col-md-3">

    </div>
    <div class="col-md-6">
        <div class="form-group">
            {{each couponList as c}}
            <div class="radio">
                <label><input type="radio" name="giftCouponId" value="{{c.couponId}}">{{c.name}}</label>
            </div>
            {{/each}}
        </div>
    </div>
    <div class="col-md-3">

    </div>
</script>
<script>
    var date = new Date;
    $("#currentYear").append(date.getFullYear());

    //订单实体
    var createCouponOrder = {
        customerMobile: "",
        customerName: "",
        customerCompany: "",
        customerAlipay: "",
        couponOrderItems: []
    }

    var couponOrderItems = {
        couponId: 0,
        amount: 0,
        price: 0,
        giftCouponId: 0
    }

    /**
     * 确认信息页,对象装载
     */
    function confirmInformation() {
        var title = $("#coupon").find("option:selected").text();
        var totalAmount = getAmountValue("payAmount");
        var customerMobile = getValueByName("customerMobile");
        var customerName = getValueByName("customerName");
        var customerCompany = getValueByName("customerCompany");
        var customerAlipay = getValueByName("customerAlipay");
        var giftCoupon = "";
        createCouponOrder.customerAlipay = customerAlipay;
        createCouponOrder.customerCompany = customerCompany;
        createCouponOrder.customerMobile = customerMobile;
        createCouponOrder.customerName = customerName;
        createCouponOrder.couponOrderItems.splice(0,createCouponOrder.couponOrderItems.length);
        var coupon = getValueById("coupon");
        var couponArray = coupon.split("-");
        var number = getValueById("number");
        if(couponArray[2] != ""){
            couponOrderItems.couponId = couponArray[0];
            couponOrderItems.price = couponArray[1];
        }else{
            giftCoupon = $('input[name="giftCouponId"][checked]');
            if(giftCoupon.length == 0){
                messageBox("提示信息","请至少选择一种赠品");
                return;
            }
            couponOrderItems.couponId = couponArray[0];
            couponOrderItems.price = couponArray[1];
            couponOrderItems.giftCouponId = giftCoupon.val();
        }
        couponOrderItems.amount = number;
        createCouponOrder.couponOrderItems.push(couponOrderItems);

        $("#confirmButton").click();
        var str = "";
        var list = createCouponOrder.couponOrderItems;
        for(var i = 0; i<list.length ; i++){
            var content = list[i].price + "/张" + " * " + list[i].amount +"(张)";
            var price = list[i].price * (parseInt(list[i].amount));
            str += '<tr>' +
                    '<td>' + title + '</td>' +
                    '<td>¥' + content + '</td>' +
                    '<td class="text-muted"><strong>¥' + price + '</strong></td>' +
                    '</tr>';
        }
        if(couponArray[2] == ""){
            str += '<tr>' +
                    '<td>赠送</td>' +
                    '<td>' + giftCoupon.text() + '</td>' +
                    '<td class="text-muted"><strong>1张</strong></td>' +
                    '</tr>';
        }
        setAmountValue("confirmTotalAmount", parseInt(totalAmount));
        setAmountValue("confirmName", createCouponOrder.customerName);
        setAmountValue("confirmMobile", createCouponOrder.customerMobile);
        setAmountValue("confirmCompanyName", createCouponOrder.customerCompany);
        setAmountValue("confirmAlipay", createCouponOrder.customerAlipay);
        $("#confirmList").empty();
        $("#confirmList").append(str);
    }

    function submitOrder() {
        $.ajax({
            url: "${path}/ajax/order/create",
            type: "post",
            dataType: 'json',
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify(createOrder),
            success: function (data) {
                if(data.errCode == 0){
                    window.location.href="${path}/question/tip.html?url=sales/coupon_order.html&manager=";
                }
            },
            error: function (xhr, type, exception) {
                alert(type, "Failed");
            }
        })
    }

    /**
     * 错误提示
     */
    function alertMessage(code) {
        var key = {
            "106": "请填写账号密码",
            "104": "请重新登录账户",
            "112": "账户已存在",
            "unknow": "#" + code
        }
        if (key[code]) message = key[code];
        else message = key.unknow;
        if (code == 0) {
            alert("恭喜您已成功下单");
        } else {
            alert(message);
        }
    }

    $(function(){
        reacquireCoupon();
    });

    /**
     * 选择工位券
     */
    function reacquireCoupon() {
        var couponArray = $("#coupon").val().split("-");
        setValueById("number", 1);
        setAmountValue("payAmount", couponArray[1]);
        setAmountValue("price", couponArray[1]);
        if(couponArray[2] == null || couponArray[2] ==""){
            $("#selectCouponList").prop("style","");
            $("#selectCoupon").empty();
            getCouponList();
        }else{
            $("#selectCouponList").prop("style","display: none");
        }
    }

    /**
     *  获取数值
     */
    function getAmountValue(id) {
        var amount = $("#" + id).text();
        if (amount != null && amount != "" && amount != 0) {
            return parseFloat(amount);
        } else {
            return 0;
        }
    }

    /**
     * 设置数值
     */
    function setAmountValue(id, value) {
        var amount = $("#" + id);
        amount.empty();
        if (value != undefined && value != null && value != "") {
            amount.append(value);
        } else {
            amount.append(0);
        }
    }

    //    点击加号
    function plusCoupon() {
        var number = parseInt($("#number").val());
        number++;
        $("#number").val(number);
        sumTotal();
    }

    //    点击减号
    function minusCoupon() {
        var number = parseInt($("#number").val());
        if (number > 0) {
            number--;
        } else {
            alert("工位数不能小于零");
        }
        $("#number").val(number);
        sumTotal();
    }

    //    手动输入
    function inputCoupon() {
        var number = parseInt($("#number").val());
        if (number >= 0){
            $("#number").val(number);
        } else {
            $("#number").val(0);
            alert("工位数不能小于零,并且不能大于剩余工位数");
        }
        sumTotal();
    }

    function getCouponList() {
        $.ajax({
            url: "${path}/ajax/soho3q/coupon_list",
            type: "get",
            dataType: 'json',
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                if (data.errCode == 0) {
                    var couponArray = {
                        couponList:[],
                    };
                    var arrayCoupon = data.data;
                    for (var i = 0; i < arrayCoupon.length; i++) {
                        var coupon = arrayCoupon[i];
                        if(coupon.productType == "ROOM" || coupon.productType == "OPEN_STATION"){
                            couponArray.couponList.push(coupon);
                        }
                    }
                    var html = template('couponRadio', couponArray);
                    $("#selectCoupon").append(html);
                } else {
                    alertMessage(data.errCode);
                }
            },
            error: function (xhr, type, exception) {
                alert(type, "Failed");
            }
        })
    }

    function sumTotal() {
        var sumTotalAmount = 0;
        var price = parseFloat(getAmountValue("price"));
        var number = parseInt(getValueById("number"));
        sumTotalAmount = (price * number).toFixed(2);
        setAmountValue("payAmount", sumTotalAmount);
    }

    function checkedItem(value, status) {
        if (status == "cancel") {
            $("input[type='checkbox'][name='selectRoom']").each(
                    function () {
                        var checkBoxValue = $(this).val();
                        if (checkBoxValue == value) {
                            $(this).prop("checked", false);
                        }
                    }
            );
        } else {
            $("input[type='checkbox'][name='selectRoom']").each(
                    function () {
                        var checkBoxValue = $(this).val();
                        if (checkBoxValue == value) {
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
    function changeDate(startTime, month, day) {
        var now = new Date(startTime);
        // now.setDate(startTime);
        now.setMonth(now.getMonth() + parseInt(month))
        now.setDate(now.getDate() + parseInt(day));
        return $.format.date(now, "yyyy-MM-dd");
    }

</script>
</@layoutFooter>

