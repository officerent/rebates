<#include "base.ftl">
    <!-- ============================================
    SIDEBAR SECTION
    =============================================== -->

<aside class="sidebar sidebar-orange" role="complementary" data-init-sidebar="true">
    <!-- /navigation -->
    <div class="nav-wrapper">
        <ul class="nav nav-left nav-tabs nav-contrast-light" role="navigation">
            <li class="nav-item ${index !''}" role="presentation">
                <a href="${path}/web/index.html">首页</a>
            </li>
            <li class="nav-item ${order !''}" role="presentation">
                <a href="${path}/sales/order_list.html">我的订单</a>
            </li>
            <li class="nav-item ${question !''}" role="presentation">
                <a href="${path}/web/question.html">常见问题</a>
            </li>
            <li class="nav-item ${station !''}" role="presentation">
                <a href="${path}/sales/station_order.html">购买固定工位</a>
            </li>
            <li class="nav-item ${coupon !''}" role="presentation">
                <a href="${path}/sales/coupon_order.html">购买漫游券</a>
            </li>
        </ul>
        <div class="nav-ctrl btn-group hide"><a class="btn hover-teal btn-icon btn-xs"><span class="icon-arrow-left"></span></a><a class="btn hover-teal btn-icon btn-xs"><span class="icon-arrow-right"></span></a></div><div class="nav-fake-padding bg-dark hide"></div></div>
    <div class="sidebar-resize-handler hide"></div>
</aside>
<script>

</script>