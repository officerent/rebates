<#include "./web_common/_layout.ftl" />

<@layoutHead>
    <style>
        .wrapkit-wrapper-extend {
            min-height: 600px;
        }
    </style>
</@layoutHead>
<@layoutBody mainClass="wrapkit-wrapper-extend" classBody="wrapkit-sidebar-left wrapkit-sidebar-lg bg-grd-dark wrapkit-sidebar-horizontal" >

</@layoutBody>
    <main class="wrapkit-wrapper wrapkit-wrapper-extend" id="wrapper" data-init-layout="true">

    <!-- ============================================
    MAIN CONTENT SECTION
    =============================================== -->
    <section class="content-wrapper wrapkit-wrapper-extend" role="main" data-init-content="true">
        <div class="content">

            <div class="content-body">
                <div class="row">
                    <div class="col-md-3">
                        <h1>返佣排行榜</h1>
                        <ol>
                            <#if data ??>
                                <#list data as d>
                                    <#switch index>
                                        <#case 0>
                                            <li class="bg-danger"><h4>${d.customerMobile !""} 返佣  ${d.rebatesAmount !""}元</h4></li>
                                            <#break>
                                        <#case 1>
                                            <li class="bg-warning"><h4>${d.customerMobile !""} 返佣  ${d.rebatesAmount !""}元</h4></li>
                                            <#break>
                                        <#case 2>
                                            <li class="bg-info"><h4>${d.customerMobile !""} 返佣  ${d.rebatesAmount !""}元</h4></li>
                                            <#break>
                                        <#default>
                                            <li><h4>${d.customerMobile !""} 返佣  ${d.rebatesAmount !""}元</h4></li>
                                    </#switch>
                                <#else>
                                    <p>天上掉钱的好事,居然没人来,Unbelievable</p>
                                </#list>
                            </#if>
                        </ol>
                    </div>
                    <div class="col-md-6">
                        <div id="myCarousel" class="carousel slide">
                            <!-- 轮播（Carousel）指标 -->
                            <ol class="carousel-indicators">
                                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                <li data-target="#myCarousel" data-slide-to="1"></li>
                                <li data-target="#myCarousel" data-slide-to="2"></li>
                            </ol>
                            <!-- 轮播（Carousel）项目 -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="${path}/wrap/images/rebate/1.jpg" alt="First slide">
                                </div>
                                <div class="item">
                                    <img src="${path}/wrap/images/rebate/2.jpg" alt="Second slide">
                                </div>
                                <div class="item">
                                    <img src="${path}/wrap/images/rebate/3.jpg" alt="Third slide">
                                </div>
                            </div>
                            <!-- 轮播（Carousel）导航 -->
                            <a class="carousel-control left" href="#myCarousel"
                               data-slide="prev">&lsaquo;</a>
                            <a class="carousel-control right" href="#myCarousel"
                               data-slide="next">&rsaquo;</a>
                        </div>

                    </div>
                    <div class="col-md-3">
                        <h1>长期工位</h1>
                        <p>友情提示:一次最少购买一周工位的使用权,唯一的遗憾购买后不能随意在3Q各大中心随意切换</p>
                        <a class="btn btn-warning" href="${path}/sales/station_order.html" role="button">立即购买长期工位</a>
                        <h1>一天工位</h1>
                        <p>友情提示:在没有进入过3Q的各位客官,首先请先购买会员使用权哦,会获赠一天的工位券,或者一小时的会议室券,让您体验入住.
                            如果感觉3Q环境适宜,妹子靓丽,那么可以购买一天工位券或者一个小时会议室券,继续享受在北京以及上海,体验着想去哪就去哪的灵活办公哦</p>
                        <a class="btn btn-warning" href="${path}/sales/coupon_order.html" role="button">立即购买一天工位</a>

                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">

                    </div>
                    <div class="col-md-6">

                    </div>
                </div>
            </div><!-- /.content-body -->




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
</script>

<!--轮播图-->
<script>
    $('.carousel').carousel({
        interval: 3000
    });
</script>
</@layoutFooter>