<#include "base.ftl">
    <!-- ============================================
    SIDEBAR SECTION
    =============================================== -->
<style>
    .soho-orange{
        background-color:#FF9011
    }
</style>
<aside class="sidebar soho-orange" role="complementary" data-init-sidebar="true">
    <!-- /navigation -->
    <div class="nav-wrapper">
        <ul class="nav nav-left nav-tabs nav-contrast-light" role="navigation">
            <li class="nav-item ${index !''}" role="presentation">
                <a href="${path}/web/index.html"><h2><i class="fa fa-fw"></i>首页</h2></a>
            </li>
            <li class="nav-item ${order !''}" role="presentation">
                <a href="${path}/sales/order_list.html?size=20&number=0"><h2><i class="fa fa-fw"></i>我的订单</h2></a>
            </li>
            <li class="nav-item ${question !''}" role="presentation">
                <a href="${path}/question/question_list.html"><h2><i class="fa fa-fw"></i>常见问题</h2></a>
            </li>
            <li class="nav-item ${station !''}" role="presentation">
                <a href="${path}/sales/station_order.html"><h2><i class="fa fa-fw"></i>购买固定工位</h2></a>
            </li>
            <li class="nav-item ${coupon !''}" role="presentation">
                <a href="${path}/sales/coupon_order.html"><h2><i class="fa fa-fw"></i>购买漫游券</h2></a>
            </li>
        </ul>
        <div class="nav-ctrl btn-group hide">
            <a class="btn hover-teal btn-icon btn-xs">
                <span class="icon-arrow-left"></span>
            </a>
            <a class="btn hover-teal btn-icon btn-xs">
                <span class="icon-arrow-right"></span>
            </a>
        </div>
        <div class="nav-fake-padding bg-dark hide">

        </div>
    </div>
    <div class="sidebar-resize-handler hide"></div>
</aside>
<script>

</script>