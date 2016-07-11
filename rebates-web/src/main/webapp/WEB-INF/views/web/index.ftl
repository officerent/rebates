<#include "../web_common/_layout.ftl" />

<@layoutHead>
    <style>
        .wrapkit-wrapper-extend {
            min-height: 600px;
        }
        .btn-soho-danger {
            color: #ffffff;
            background-color: #FF9011;
            border-color: transparent;
        }
        .font-color {
            color:red;
        }
        .font-size {
            font-size:200%;
        }
    </style>
    <#assign index='active' />
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
                        <h3>返佣排行榜</h3>
                        <table class="table table-condensed">
                            <thead>
                                <tr>
                                    <th>手机号</th>
                                    <th>返佣</th>
                                    <th>成交时间</th>
                                </tr>
                            </thead>
                            <tbody>
                                <#if data ??>
                                    <#list data as d>
                                        <tr>
                                            <td>${d.customerMobile !""}</td>
                                            <td>${d.rebatesAmount !""}元</td>
                                            <td>${d.lastUpdateTime !""}</td>
                                        </tr>
                                    </#list>
                                </#if>
                            </tbody>
                        </table>
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
                            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                            <#--<a class="carousel-control left" href="#myCarousel"-->
                               <#--data-slide="prev">&lsaquo;</a>-->
                            <#--<a class="carousel-control right" href="#myCarousel"-->
                               <#--data-slide="next">&rsaquo;</a>-->
                        </div>

                    </div>
                    <div class="col-md-3">
                        <div class="row">
                            <h2>固定长租 <strong>返利<span><i class="font-size font-color">${ratio.ratio}</i></span></strong></h2>
                            <p>一周起租,选择心仪的3Q中心,直接拎包入驻</p>
                            <a class="btn btn-soho-danger" href="${path}/sales/station_order.html" role="button">去购买，拿返利</a>
                        </div>
                        <div class="row">
                            <h2>灵活短租 <strong>返利<span><i class="font-size font-color">${ratio.ratio}</i></span></strong></h2>
                            <p>按天使用工位,按小时使用会议室,任意3Q中心,随到随用</p>
                            <a class="btn btn-soho-danger" href="${path}/sales/coupon_order.html" role="button">去购买，拿返利</a>
                        </div>
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