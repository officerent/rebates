<#include "common/base.ftl">
<html><!--<![endif]--><head>
    <title>SOHO3Q 首页</title>
    <meta name="keywords" content="返利">
    <meta name="description" content="返利">
    <link rel="shortcut icon" href="${path}/wrap/web/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${path}/wrap/web/css/common.css">
    <link rel="stylesheet" href="${path}/wrap/web/css/dy_style.css">
    <link rel="stylesheet" href="${path}/wrap/web/css/lxy_style.css">
    <link href="${path}/wrap/web/css/WdataPicker.css" rel="stylesheet" type="text/css">

    <!--[if lt IE 9]>
    <script src="${path}/wrap/web/js/html5.js"></script>
    <script src="${path}/wrap/web/js/respond.src.js"></script>
    <![endif]-->
    <script>if(/*@cc_on!@*/false && document.documentMode === 10) document.documentElement.className+=' ie10';</script><!-- 添加IE10+Class -->

    <script src="${path}/wrap/web/js/jquery.js"></script>
    <script src="${path}/wrap/web/js/common.js"></script>
    <script src="${path}/wrap/web/js/WdataPicker.js"></script>

    <script src="${path}/wrap/web/js/jquery.validate.js" type="text/javascript"></script>



    <!--页面内引用文件-->
    <script type="text/javascript" src="${path}/wrap/web/js/index-banner.js"></script>
    <script type="text/javascript" src="${path}/wrap/web/js/index.js"></script>


</head>



<body class="int">

<!--头部 start -->
<header class="header">
    <aside class="top"><a href="${path}/index.html" class="goto-p"></a>
        <div class="warp">
            <nav class="nav">
                <ul class="warp">
                    <li><i></i><a href="${path}/index.html">首页</a></li>
                    <li><i></i><a href="${path}/wrap/web/faq.do">我的订单</a></li>
                    <li><i></i><a onclick="openAuction()" href="###">常见问题</a></li>
                    <li><i></i><a target="_blank" href="${path}/sales/fix_product.html">购买固定工位</a></li>
                    <li><i></i><a target="_blank" href="${path}/wrap/web/crowdSourcing/sales.html?ajax=true">购买漫游券</a></li>
                </ul>
            </nav>
            <span class="phone"><i>400-815-9888</i></span>
            <a href="${path}/wrap/user/login.ftl" class="login">登录</a>
        </div>
    </aside>
</header>



<script type="text/javascript">
    if('zh_CN'=='zh_CN'){
        $("body").attr("class","int");
    }else if('zh_CN'=='en_US'){
        $("body").attr("class","int en");
    }else {
        $("body").attr("class","int");
    }

    $(function(){
        //领取优惠活动
        $(document).on("click",".new-in-b2 .lab ul li:first-child + li a,.member-bak1 .user-r2 .xbox dd a",function(e){
            getregpakage();
        });

    });


    function getregpakage(){
        var localObj = window.location;
        var contextPath = localObj.protocol+"//"+localObj.host;
        var flag = 'Y';
        var checkurl=contextPath+'${path}/wrap/web/onlineAction.do?actionType=checkSession&ajax=true';
        $.ajax({
            type: "POST",
            url: checkurl,
            dataType: "json",
            success: function(json){
                flag=json.success;
                if("N"==flag){
                    window.parent.location.href=contextPath+"${path}/wrap/web/views/user/registration.jsp";
                }else{
                    var url = '${path}/wrap/auth/memberCenterWeb.do?actionType=getCashCoupon&ajax=true';
                    $.ajax({
                        type: "POST",
                        url: url,
                        data:{
                            cashCouponCategory : 'RED_ENVELOPE'
                        },
                        success: function(callbakData){
                            var json=eval("("+callbakData+")");
                            if(json.errorFlag == 'forward'){
                                window.location.href='${path}/wrap/web/views/user/registration.jsp';
                            }else if(json.errorFlag == 'true'){
                                $("body").append(json.errorMessage);
                                $(".tpis-5tb").css("background","none");
                            }else{
                                alert(json.errorMessage);
                                return;
                            }
                        }
                    });
                }
            }
        });
    }
</script>













<script type="text/javascript">
    jQuery(document).ready(function() {
        $("#PROJECT_ID").val('');
        $("#projectNameLabel").html("办公位置");
        $("#PROJECT_OFFICE").text('办公位置');
        $("#bespeakDate").val("来访日期");
        $("#bespeakTime").val("来访时间");
        $("#bespeakVisitorName").val("姓名");
        $("#bespeakVisitorTelephone").val("手机");


        //获取项目图中选择的项目


        /**
         $("#bespeakDate").each(function(i) {
			    $(this).focus(function(){
					WdatePicker({
						skin:'whyGreen'
						,minDate:"%y-%M-%d",
						onpicked:function(){}
						});
				});
			});
         */
        /**
         $(".dateselect1").each(function(i) {
			    $(this).focus(function(){
					WdatePicker({
						skin:'whyGreen'
						//,minDate:"%y-%M-%d",
						,minDate:"2015-02-01",
						lang:'zh-cn',
						onpicked:function(){
							$("#leaseStartDate").val($(this).val());
						}
						});
				});
			});
         $(".dateselect2").each(function(i) {
		        $(this).focus(function(){
		    		WdatePicker({
		    			skin:'whyGreen'
		    			//,minDate:"%y-%M-%d",
		    			,minDate:"2015-02-01",
		    			lang:'zh-cn',
		    			onpicked:function(){
		    				$("#leaseEndDate").val($(this).val());
		    			}
		    			});
		    	});
		    });
         */
            //筛选事件；
        $(document).on("click",".down-select dd .list .nr span",function(e){
            $(this).addClass("on").siblings().removeClass("on");
            e.preventDefault();
            e.stopPropagation();
            $(this).parent().parent().find("input").val($(this).text());
            //alert($("#siteNum").val()+"=="+$("#stationType").val()+"=="+$("#promotion").val());
        });


        /**
         $(document).on("click",".child-box a",function(){
				$("#week_").val($(this).data("val"));
				getLeaseEndDate();
			});
         */
            //手动填写的周期
        $(document).on("click",".data-selt01 .other-chidl .b a",function(){
            var value=$(this).parent().find("input").val();
            $("#week_").val(value);
            getLeaseEndDate();
        });
        $(document).on("click",".tab_list .tab_a",function(){
            $(this).addClass("on").siblings().removeClass("on");
            var ii=$(this).index();
            $(this).parents(".tab_list").find(".tab_b").eq(ii).show().siblings().hide();
            //$("#PROJECT_DATA").val('办公位置');//防止出现用户来回选tab页，导致可以进入
            //$("#PROJECT_ID").val("");
            //$("#projectNameLabel").text('办公位置');
            //$("#M_0060_Visit_Time").html("来访时间");
            //$("#PROJECT_OFFICE").text('办公位置');
        });


        /**
         var projectIdValue = $("#PROJECT_ID").val();
         $("#PROJECT_ID").val('');
         if(projectIdValue=='' || projectIdValue==null || projectIdValue.length==0 ){
					$('#bespeakDateDiv').children().remove();
					var bespeakdivcon = '<input type="text" class="select-data"  id="bespeakDate" value="来访日期" onfocus="if(this.value == '+"\'来访日期\'"+') { this.value ='+"\'\'"+' }" onblur="if(this.value == '+"\'\'"+') { this.value ='+"\'来访日期\'"+' }" name="bespeakDate" onclick="WdatePicker({el:'+"\'bespeakDate\'"+',readOnly:true,dateFmt:'+"\'yyyy-MM-dd\'"+",minDate:"+"\'%y-%M-%d\'";
					bespeakdivcon+=",disabledDates:['^20[0-9][0-9]']";
					bespeakdivcon+='})\">';
					bespeakdivcon+='<i class="icon"></i>';
					$('#bespeakDateDiv').html(bespeakdivcon);  //不能看房日期设置
			}
         */

        $("#queding").click(function(){
            $(".data-selt01 dd").hide();
            getLeaseEndDate();
        });

        $("#quxiao").click(function(){
            $("#week_").val("");
            $("#month_").val("");

            $("#enterDateMonth").text('入驻周期');
            $("#enterDate").text('');

            $("#Enter_Date").val('入驻周期');
            $("#Enter_Date_Month").val('入驻周期');

            $(".data-selt01 .zhangbing a").css("background","#fff");
            $(".data-selt01 .zhangbing a").css("color","#ff9e2c");

            $(".data-selt01 .zhangbing1 a").css("background","#fff");
            $(".data-selt01 .zhangbing1 a").css("color","#ff9e2c");
            //$("#span_").text("");
            $("leaseEndDate").val("");
        });
    });

    function getLeaseEndDate(){
        var week_=$("#week_").val();
        var month_=$("#month_").val();

        var leaseStartDate=$("#leaseStartDate").val();
        if(leaseStartDate=='起始时间'){
            return false;
        }
        if(week_=='' && month_=='')return false;
        if(week_=='0' && month_=='0'){
            alert("入住月数和周数不能同时为0，请重现选择入组周期！");
            $("#enterDate").text('入驻周期');
            $("#week_").val('0');
            $("#input_enter").val("");
            $("#Enter_Date").val('入驻周期');

            $("#enterDateMonth").text('入驻周期');
            $("#month_").val('0');
            $("#input_enter").val("");
            $("#Enter_Date_Month").val('入驻周期');

            $("#leaseEndDate").val("");
            $("#span_").text('结束时间');
            return false;
        }


        if(!checkNumber(week_) && !checkNumber(month_)){
            $("#enterDate").text('入驻周期');
            $("#week_").val('入驻周期');
            $("#input_enter").val("");
            $("#Enter_Date").val('入驻周期');

            $("#enterDateMonth").text('入驻周期');
            $("#month_").val('入驻周期');
            $("#input_enter").val("");
            $("#Enter_Date_Month").val('入驻周期');

            alert('请选择入驻周期');
            return false;
        }
        $("#Enter_Date").val(week_);
        $("#Enter_Date_Month").val(month_);
        $.ajax({
            type: "POST",
            url: '${path}/wrap/web/onlineAction.do?actionType=getEndDate&ajax=true',
            data:{
                week_:week_,
                month_:month_,
                leaseStartDate:leaseStartDate
            },
            success: function(param){
                var json=eval("("+param+")");
                if(json.key=="true"){
                    $("#leaseEndDate").val(json.endDate);
                    $("#span_").text(leaseStartDate+' 到 '+json.endDate);
                }else{
                    alert(json.message);
                }
            }
        });
    }
    function booking(){
        var porjectName=$("#PROJECT_DATA").val();
        var startDate = $("#Start_Date").val();
        var enterDate = $("#Enter_Date").val();
        var enterDateMonth = $("#Enter_Date_Month").val();
        var leaseEndDate = $("#leaseEndDate").val();
        if('办公位置'==porjectName){
            alert('请选择办公位置');
            return;
        }
        if('起始时间'==startDate){
            alert('请选择起始时间');
            return;
        }
        if('入驻周期'== enterDate && '入驻周期'== enterDateMonth){
            alert('请选择入驻周期');
            return;
        }

        var projectId=$("#PROJECT_ID").val();
//			$("#ul1_cf").attr("action","${path}/wrap/web/onlineAction.do?actionType=viewProjectDetail&PROJECT_ID="+projectId).submit();
        $("#ul1_cf").attr("action","${path}/wrap/web/onlineAction.do?actionType=showProducts&PROJECT_ID="+projectId).submit();
    }

    //预约看房
    function bookingHouse(){

        var projectId=$("#PROJECT_ID").val();
        var projectName=$("#projectNameLabel").html();
        var bespeakDate = $("#bespeakDate").val();
        var bespeakTime = $("#bespeakTime").val();
        var bespeakVisitorName = $("#bespeakVisitorName").val();
        var bespeakVisitorTelephone = $("#bespeakVisitorTelephone").val();
        var url = '${path}/wrap/web/lookingHouseBespeak.do?actionType=create&ajax=true';
        if("办公位置"==projectName || projectId==null || projectId=='' || projectId.length==0){
            alert("请选择办公位置");
            return false;
        }
        if("来访日期"==bespeakDate || bespeakDate=='' || bespeakDate==null || bespeakDate.length==0){
            alert("请选择您要预约的日期");
            return;
        }

        var arr = bespeakDate.split("-");
        var starttime = new Date(arr[0], arr[1], arr[2]);
        var starttimes = starttime.getTime();
        var endtime=new Date('2015','02','01');
        var endtimes=endtime.getTime();
        if(starttimes<endtimes){
            alert("BOK00022");
            $("#bespeakDate").val('来访日期');
            return;
        }

        if("来访时间"==bespeakTime || bespeakTime=='' || bespeakTime==null || bespeakTime.length==0){
            alert("请选择您要预约的时间");
            return;
        }
        if("姓名"==bespeakVisitorName || bespeakVisitorName=='' || bespeakVisitorName==null || bespeakVisitorName.length==0 ){
            alert("请填写您的姓名");
            return;
        }

        if("手机"==bespeakVisitorTelephone){
            alert("请填写您的手机号码");
            return;
        }else{
            if(!isPhone(bespeakVisitorTelephone)){
                alert("请填写正确的手机号码");
                return;
            }
        }
        $.ajax({
            type: "POST",
            url: url,
            data:{
                projectId:projectId,
                bespeakDate:bespeakDate,
                bespeakVisitorName:bespeakVisitorName,
                bespeakVisitorTelephone:bespeakVisitorTelephone,
                bespeakTime : bespeakTime
            },
            success: function(param){
                var json=eval("("+param+")");
                if(json.error){
                    alert(json.message);
                }else{
                    $("body").append('<div class="img-5tb"><div class="box"><a style="cursor: pointer;" class="close"></a><dl><dt></dt><dd><h2>您已预约成功！</h2><p>如有问题请咨询<em>400-815-9888</em></p></dd></dl></div></div>')
                    $(document).on("click",".img-5tb",function(){
                        $(".img-5tb").remove();
                        $('#PROJECT_ID').val('');
                        $("#projectNameLabel").html("办公位置");
                        $("#M_0060_Visit_Time").html("来访时间");
                        $("#bespeakTime").val('');
                        $('#bespeakDate').val("来访日期");
                        $('#bespeakVisitorName').val("姓名");
                        $('#bespeakVisitorTelephone').val("手机");
                    })
                }
            }
        });

    }



    function setProjectId(projectId,projectName){
        var oldProjectId = $("#PROJECT_ID").val();
        $("#PROJECT_ID").val(projectId);
        $("#PROJECT_DATA").val(projectName);
        if(oldProjectId != projectId){
            getNobookingDate(projectId);
        }
    }

    //获取不看房日期
    function getNobookingDate(projectId){
        $.ajax({
            type: "POST",
            url: '${path}/wrap/web/lookingHouseBespeak.do?actionType=getNobookingDate&ajax=true&projectId='+projectId,
            success: function(param){
                var json=eval("("+param+")");
                setNobookingDate(json.days,json.noBookingDateRange);
            }
        });
    }

    //设置不看房日期
    function setNobookingDate(days,noBookingDateRange){
        $('#bespeakDateDiv').children().remove();
        var bespeakdivcon = '<input type="text" class="select-data"  id="bespeakDate" value="来访日期" onfocus="if(this.value == '+"\'来访日期\'"+') { this.value ='+"\'\'"+' }" onblur="if(this.value == '+"\'\'"+') { this.value ='+"\'来访日期\'"+' }" name="bespeakDate" onclick="WdatePicker({el:'+"\'bespeakDate\'"+',readOnly:true,dateFmt:'+"\'yyyy-MM-dd\'"+",minDate:"+"\'%y-%M-%d\'";
        bespeakdivcon+=",disabledDates:["+days+"],maxDate:"+noBookingDateRange+",lang:'zh-cn'";
        bespeakdivcon+='})\">';
        bespeakdivcon+='<i class="icon"></i>';
        $('#bespeakDateDiv').html(bespeakdivcon);  //不能看房日期设置
    }

    //手机格式校验
    function isPhone(str){
        var myreg = /^[1][0-9]{10}$/;
        if(!myreg.test(str)){
            return false;
        }else{
            return true;
        }
    }
    function checkNumber(num){
        var patrn = /^(-|\+)?\d+(\.\d+)?$/;
        if (patrn.test(num)){
            return true;
        } else {
            return false;
        }
    }

    function selectDateThis(el){
        if($("#PROJECT_ID").val()==""){
            alert("请选择办公位置");
            $(el).blur();
        }else{
            WdatePicker({el:'bespeakDate',readOnly:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'});
        }
    }

    function selectLeaseStartDateThis(el){
        WdatePicker({
            skin:'whyGreen'
            ,minDate:"%y-%M-%d",
            //minDate:"2015-02-01",
            lang:'zh-cn',
            maxDate:'2016-6-11',
            onpicked:function(){
                $("#leaseStartDate").val($(this).val());
                $("#Start_Date").val($(this).val());
            }
        });
    }

    //获取预约时间（数据字典）
    function setBespeakTimeValue(bespeakTime){
        $('#bespeakTime').val(bespeakTime);
    }

    function selectPeriodStay(obj){
        $("#week_").val($(obj).data("val"));
        $("#Enter_Date").val($(obj).data("val"));
        $("#enterDate").text($(obj).attr("data-val") + '周');
        getLeaseEndDate();
    }

    function selectPeriodStayMonth(obj){
        //alert("asdas111");
        $("#month_").val($(obj).data("val"));
        $("#Enter_Date_Month").val($(obj).data("val"));
        $("#enterDateMonth").text($(obj).attr("data-val") + '月');
        getLeaseEndDate();
    }



    function getregpakage(){
        var localObj = window.location;
        var contextPath = localObj.protocol+"//"+localObj.host;
        var flag = 'Y';
        var checkurl=contextPath+'${path}/wrap/web/onlineAction.do?actionType=checkSession&ajax=true';
        $.ajax({
            type: "POST",
            url: checkurl,
            dataType: "json",
            success: function(json){
                flag=json.success;
                if("N"==flag){
                    window.parent.location.href=contextPath+"${path}/wrap/web/views/user/registration.jsp";
                }else{
                    var url = '${path}/wrap/auth/memberCenterWeb.do?actionType=getCashCoupon&ajax=true';
                    $.ajax({
                        type: "POST",
                        url: url,
                        data:{
                            cashCouponCategory : 'RED_ENVELOPE'
                        },
                        success: function(callbakData){
                            var json=eval("("+callbakData+")");
                            if(json.errorFlag == 'forward'){
                                window.location.href='${path}/wrap/web/views/user/registration.jsp';
                            }else if(json.errorFlag == 'true'){
                                $("body").append(json.errorMessage);
                                $(".tpis-5tb").css("background","none");
                            }else{
                                alert(json.errorMessage);
                                return;
                            }
                        }
                    });
                }
            }
        });
    }
</script>


<div class="banner-search" style="top: 663px;">
    <div class="warp tab_list">
        <div class="tab_t">
            <!-- <span class="tab_a_links"><a title="红包使用截止日期为3月15日" onclick="getregpakage()">抢红包立减<em>500</em>元</a><i></i></span>  -->

            <span class="tab_a  on">在线订位<i></i></span>

            <span class="tab_a">预约参观<i></i></span>
        </div>
        <div class="tab-nr">

            <div class="tab_b" style="display: block;">
                <form action="" method="post" id="ul1_cf">
                    <ul class="ul1 ul2 cf ">
                        <li class="i1">
                            <dl class="select-box">
                                <dt data-val="0"><b id="PROJECT_OFFICE">办公位置</b><i class="ico"></i></dt>
                                <dd>

                                    <a style="cursor: pointer;" onclick="setProjectId(&#39;2c90bf4e49d12cbb0149d14b00f50006&#39;,&#39;望京SOHO&#39;)">望京SOHO</a>

                                    <a style="cursor: pointer;" onclick="setProjectId(&#39;402825824f600c7d014f698089ef2bee&#39;,&#39;丹棱SOHO&#39;)">丹棱SOHO</a>

                                    <a style="cursor: pointer;" onclick="setProjectId(&#39;402825824e303945014e3d84dff80ade&#39;,&#39;中关村SOHO&#39;)">中关村SOHO</a>

                                    <a style="cursor: pointer;" onclick="setProjectId(&#39;402884ac4a52541b014a529612a20011&#39;,&#39;银河SOHO&#39;)">银河SOHO</a>

                                    <a style="cursor: pointer;" onclick="setProjectId(&#39;402884ac4a52541b014a52b29603002a&#39;,&#39;光华路SOHO2&#39;)">光华路SOHO2</a>

                                    <a style="cursor: pointer;" onclick="setProjectId(&#39;2c90bf4e49d12cbb0149d1506a270007&#39;,&#39;SOHO复兴广场&#39;)">SOHO复兴广场</a>

                                    <a style="cursor: pointer;" onclick="setProjectId(&#39;402884ac4a52541b014a52b77b4e0031&#39;,&#39;外滩SOHO&#39;)">外滩SOHO</a>

                                    <a style="cursor: pointer;" onclick="setProjectId(&#39;402825824e77ddd6014e8b46b9db1b0c&#39;,&#39;SOHO东海广场&#39;)">SOHO东海广场</a>

                                    <a style="cursor: pointer;" onclick="setProjectId(&#39;40282582526410c601527d52840d5013&#39;,&#39;凌空SOHO&#39;)">凌空SOHO</a>

                                    <a style="cursor: pointer;" onclick="setProjectId(&#39;402884ac4a52541b014a52bf86060038&#39;,&#39;虹口SOHO&#39;)">虹口SOHO</a>

                                </dd>
                            </dl>
                            <input type="hidden" id="PROJECT_DATA" name="PROJECT_DATA" value="办公位置">
                            <input class="select-hidden" type="hidden" id="PROJECT_ID" name="PROJECT_ID" value="">
                        </li>

                        <li class="data-down">
                            <input class="select-data dateselect1" placeholder="起始时间" type="text" value="起始时间" onblur="if(this.value == &quot;&quot;){ this.value = &quot;&quot; }else{getLeaseEndDate()}" onfocus="if(this.value == &quot;&quot;) { this.value = &quot;&quot; }" onclick="selectLeaseStartDateThis(this)" readonly="" id="leaseStartDate" name="leaseStartDate"><i class="icon"></i>
                            <input type="hidden" id="Start_Date" name="Start_Date" value="起始时间">
                        </li>

                        <li class="i3">
                            <dl class="data-selt01">
                                <dt>
                                    <span id="enterDateMonth">入驻周期</span>
                                    <span id="enterDate"></span>
                                    <i class="ico"></i>
                                </dt>
                                <dd>
                                    <input type="hidden" id="month_" name="month_" value="">
                                    <div class="zhangbing">
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="1">1 月</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="2">2 月</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="3">3 月</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="4">4 月</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="5">5 月</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="6">6 月</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="7">7 月</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="8">8 月</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="9">9 月</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="10">10月</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="11">11月</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStayMonth(this)" data-val="12">12月</a>
                                    </div>
                                    <input type="hidden" id="week_" name="week_" value="">
                                    <div class="zhangbing1">
                                        <a style="cursor: pointer;" onclick="selectPeriodStay(this)" data-val="1">1 周</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStay(this)" data-val="2">2 周</a>
                                        <a style="cursor: pointer;" onclick="selectPeriodStay(this)" data-val="3">3 周</a>
                                    </div>
                                    <div class="child-btn">
                                        <a href="http://www.soho3q.com/entry/web/index.jsp#" id="queding">确定</a>
                                        <a href="http://www.soho3q.com/entry/web/index.jsp#" id="quxiao">取消</a>
                                    </div>
                                    <!--
                                    <div class="other-chidl">
                                        <span class="n">其他</span>
                                        <div class="b">
                                            <input type="text" id="input_enter">
                                            <i class="i">周</i>
                                            <a style="cursor: pointer;" class="sub">确定</a>
                                        </div>
                                    </div>
                                     -->
                                </dd>
                            </dl>
                            <input type="hidden" id="Enter_Date_Month" name="Enter_Date_Month" value="入驻周期">
                            <input type="hidden" id="Enter_Date" name="Enter_Date" value="入驻周期">
                        </li>

                        <li class="i4">
                            <span class="p" id="span_">结束时间</span>
                            <input name="leaseEndDate" id="leaseEndDate" value="" type="hidden">
                        </li>

                        <li class="i5">
                            <a style="cursor: pointer;" onclick="booking()">立即订位</a>
                        </li>


                    </ul></form>
            </div>


            <div class="tab_b" style="display: none;">
                <ul class="ul1 cf ">
                    <li class="i1">
                        <dl class="select-box">
                            <dt data-val="0"><b id="projectNameLabel">办公位置</b><i class="ico"></i></dt>
                            <dd>




                                <a style="cursor: pointer;" onclick="setProjectId(&#39;2c90bf4e49d12cbb0149d14b00f50006&#39;,&#39;望京SOHO&#39;)">望京SOHO</a>

                                <a style="cursor: pointer;" onclick="setProjectId(&#39;402825824f600c7d014f698089ef2bee&#39;,&#39;丹棱SOHO&#39;)">丹棱SOHO</a>

                                <a style="cursor: pointer;" onclick="setProjectId(&#39;402825824e303945014e3d84dff80ade&#39;,&#39;中关村SOHO&#39;)">中关村SOHO</a>

                                <a style="cursor: pointer;" onclick="setProjectId(&#39;402884ac4a52541b014a529612a20011&#39;,&#39;银河SOHO&#39;)">银河SOHO</a>

                                <a style="cursor: pointer;" onclick="setProjectId(&#39;402884ac4a52541b014a52b29603002a&#39;,&#39;光华路SOHO2&#39;)">光华路SOHO2</a>

                                <a style="cursor: pointer;" onclick="setProjectId(&#39;2c90bf4e49d12cbb0149d1506a270007&#39;,&#39;SOHO复兴广场&#39;)">SOHO复兴广场</a>

                                <a style="cursor: pointer;" onclick="setProjectId(&#39;402884ac4a52541b014a52b77b4e0031&#39;,&#39;外滩SOHO&#39;)">外滩SOHO</a>

                                <a style="cursor: pointer;" onclick="setProjectId(&#39;402825824e77ddd6014e8b46b9db1b0c&#39;,&#39;SOHO东海广场&#39;)">SOHO东海广场</a>

                                <a style="cursor: pointer;" onclick="setProjectId(&#39;40282582526410c601527d52840d5013&#39;,&#39;凌空SOHO&#39;)">凌空SOHO</a>

                                <a style="cursor: pointer;" onclick="setProjectId(&#39;402884ac4a52541b014a52bf86060038&#39;,&#39;虹口SOHO&#39;)">虹口SOHO</a>

                            </dd>
                        </dl>
                        <input class="select-hidden" type="hidden" id="projectId" name="projectId">
                        <input class="select-hidden" type="hidden" id="PROJECT_ID" name="PROJECT_ID" value="">
                    </li>
                    <li class="data-down">
                        <div id="bespeakDateDiv">
                            <input class="select-data" id="bespeakDate" name="bespeakDate" type="text" value="来访日期" onblur="if(this.value == &#39;&#39;) { this.value = &#39;来访日期&#39; }" onfocus="if(this.value == &#39;来访日期&#39;) { this.value = &#39;&#39; }" onclick="selectDateThis(this)" readonly=""><i class="icon"></i>
                        </div>
                    </li>
                    <li>
                        <dl class="select-box">
                            <dt data-val="0">
                                <b id="M_0060_Visit_Time">来访时间</b><i class="ico"></i>
                            </dt>
                            <dd>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;08:00&#39;)">08:00</a>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;09:00&#39;)">09:00</a>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;10:00&#39;)">10:00</a>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;11:00&#39;)">11:00</a>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;12:00&#39;)">12:00</a>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;14:00&#39;)">14:00</a>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;15:00&#39;)">15:00</a>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;16:00&#39;)">16:00</a>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;17:00&#39;)">17:00</a>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;18:00&#39;)">18:00</a>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;19:00&#39;)">19:00</a>

                                <a href="http://www.soho3q.com/entry/web/index.jsp#" onclick="setBespeakTimeValue(&#39;20:00&#39;)">20:00</a>

                            </dd>
                            <input class="select-hidden" type="hidden" value="来访时间" id="bespeakTime">
                        </dl>
                    </li>
                    <li class="i21"><input class="select-data" type="text" value="姓名" id="bespeakVisitorName" name="bespeakVisitorName" onblur="if(this.value == &#39;&#39;) { this.value = &#39;姓名&#39; }" onfocus="if(this.value == &#39;姓名&#39;) { this.value = &#39;&#39; }">
                    </li>
                    <li class="i22">
                        <input class="select-data" type="text" value="手机" id="bespeakVisitorTelephone" name="bespeakVisitorTelephone" onblur="if(this.value == &#39;&#39;) { this.value = &#39;手机&#39; }" onfocus="if(this.value == &#39;手机&#39;) { this.value = &#39;&#39; }">
                    </li>
                    <li class="i5">
                        <a style="cursor: pointer;" onclick="bookingHouse()">立即预约</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>



<div class="in-banner" style="height: 708px; top: 50px;">
    <div class="banner-warp">

        <div class="bon left">
            <a href="javascript:;"></a>
            <div class="blist">




















































            </div>
        </div>

        <div class="bon right">
            <a href="javascript:;"></a>
            <div class="blist" style="left: 50px;">

                <!--
                <dl>


                              <dt><img src="images/home_banner_lzy09.jpg" width="163" height="108"></dt>
                              <dd><b></b><i> 抢红包立减</i></dd>




                </dl>
            -->




                <dl class="safety-area" style="display: none;">
                    <dt>
                        <img src="./SOHO3Q 首页_files/1441512391071.jpg" width="163" height="108">
                    </dt>
                    <dd>
                        <b></b><i> </i>
                    </dd>
                </dl>






                <dl class="safety-area">
                    <dt>
                        <img src="./SOHO3Q 首页_files/1422504362164.jpg" width="163" height="108">
                    </dt>
                    <dd>
                        <b></b><i> </i>
                    </dd>
                </dl>







                <dl style="display: none;">
                    <dt>
                        <img src="./SOHO3Q 首页_files/1422504390480.jpg" width="163" height="108">
                    </dt>
                    <dd>
                        <b></b><i>这里，共享的不仅是空间</i>
                    </dd>
                </dl>






                <dl style="display: none;">
                    <dt>
                        <img src="./SOHO3Q 首页_files/1422504408412.jpg" width="163" height="108">
                    </dt>
                    <dd>
                        <b></b><i>新风PM2.5过滤 提供洁净室内空气</i>
                    </dd>
                </dl>






                <dl style="display: none;">
                    <dt>
                        <img src="./SOHO3Q 首页_files/1422504433555.jpg" width="163" height="108">
                    </dt>
                    <dd>
                        <b></b><i> 可以只租一个办公桌</i>
                    </dd>
                </dl>






                <dl style="display: none;">
                    <dt>
                        <img src="./SOHO3Q 首页_files/1422504455798.jpg" width="163" height="108">
                    </dt>
                    <dd>
                        <b></b><i>可以租一间办公室</i>
                    </dd>
                </dl>






                <dl style="display: none;">
                    <dt>
                        <img src="./SOHO3Q 首页_files/1422504475736.jpg" width="163" height="108">
                    </dt>
                    <dd>
                        <b></b><i>可以只租一周</i>
                    </dd>
                </dl>



            </div>
        </div>


        <div class="hide">
            <!--
             <span></span>
             -->


            <span class=""></span>

            <span class=""></span>

            <span class=""></span>

            <span class=""></span>

            <span class=""></span>

            <span class="on"></span>

            <span class=""></span>

        </div>

    </div>
</div>

<section class="main" style="top: 708px;">
    <div class="main-index">
        <div class="q3-box">

        </div>







        <div class="new-in-b4">
            <ul class="cf">
                <li>
                    <a href="http://www.soho3q.com/entry/web/index.do?page=facilities"></a>
                    <div class="img">
                        <img src="./SOHO3Q 首页_files/indx_21.jpg" width="115" height="115">
                    </div>
                    <h2>3Q设施</h2>

                    <article>
                        SOHO 3Q为用户提供完善的配套<br>服务，例如：会议室、免费WiFi、免费咖啡等
                    </article> <i class="icon"></i>

                </li>
                <li>
                    <a href="http://www.soho3q.com/entry/web/faq.do"></a>
                    <div class="img">
                        <img src="./SOHO3Q 首页_files/indx_23.jpg" width="115" height="115">
                    </div>
                    <h2>常见问题</h2>

                    <article>
                        什么是SOHO 3Q办公空间，如何预约<br>怎么签合同等
                    </article> <i class="icon"></i>
                </li>
                <li>
                    <a href="http://www.soho3q.com/entry/web/index.do?page=down"></a>
                    <div class="img">
                        <img src="./SOHO3Q 首页_files/indx_25.jpg" width="115" height="115">
                    </div>
                    <h2>客户端下载</h2>
                    <article>
                        方便用户下载客户端进行3Q办公位置的选择和在线定位，成为我们的用户后您还可以获取更多服务。
                    </article> <i class="icon"></i>
                </li>
            </ul>
        </div>
    </div>
</section>








<!--底部 start-->
<footer class="footer" style="top: 708px;">
    <div class="warp">
        <div class="left-f">
            <a href="http://www.soho3q.com/entry/web/index.do?page=about">关于我们</a><i>|</i>
            <a href="http://www.soho3q.com/entry/web/index.do?page=job">招聘信息</a><i>|</i>
            <a href="http://www.soho3q.com/entry/web/index.do?page=policy">隐私政策</a><i>|</i>
            <a href="http://www.soho3q.com/entry/web/index.do?page=statement">法律声明</a><i>|</i>
            <a href="http://www.soho3q.com/entry/web/index.do?page=contact">联系我们</a></div>
        <div class="copy">© 2012-2014 SOHO中国 版权所有　<a href="http://www.miitbeian.gov.cn/publish/query/indexFirst.action" target="_blank" style="color: yellow;">京ICP备14061435号</a>　</div>
        <div class="share">
            <span>分享：</span>
            <a href="javascript:;" class="s1 weibo" data-tit="SOHO 3Q分享"></a>
            <!--  <a href="javascript:;" class="s2 tqweibo" data-tit="SOHOChina分享"></a> -->
            <!--  <a href="javascript:;" class="s3 qq" data-tit="SOHOChina分享"></a> -->
            <a href="javascript:;" class="s4 weixina" data-img="/entry/web/upload/1855537519.png"></a>
            <!-- <a href="javascript:;" class="s5 baidu" data-tit="SOHOChina分享"></a> -->
        </div>

    </div>
</footer>
<!--end-->

<div lang="zh-cn" style="position: absolute; z-index: 100006; display: none; top: 376px; left: 240.797px;"><iframe hidefocus="true" width="9" height="7" frameborder="0" border="0" scrolling="no" src="about:blank" style="width: 282px; height: 316px;"></iframe></div></body></html>