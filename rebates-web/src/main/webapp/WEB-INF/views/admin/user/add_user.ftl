<#include "../../common/base.ftl">
<!DOCTYPE html>
<html class="no-js">
<head>

    
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="initial-scale=1,minimum-scale=1,maximum-scale=1,width=device-width,height=device-height,target-densitydpi=device-dpi,user-scalable=yes">

  <title>添加用户</title>


  <link rel="stylesheet" href="${path}/wrap/styles/bootstrap.css">

  <link rel="stylesheet" href="${path}/wrap/styles/dependencies.css">

  <link rel="stylesheet" href="${path}/wrap/styles/wrapkit.css">

  <link rel="stylesheet" href="${path}/wrap/styles/demo.css">
    <!-- datetimepicker css -->
    <link rel="stylesheet" href="${path}/wrap/styles/bootstrap-datetimepicker.min.css" />
    <!-- 表单验证css样式 -->
    <link rel="stylesheet" href="${path}/wrap/validationengine/css/validationEngine.jquery.css">
</head>

<body>
  <!--[if lt IE 9]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->


    <main class="wrapkit-wrapper" id="wrapper">

	<!-- 头部  -->
 	<#include "../../common/header.ftl">

	<!-- 左边菜单栏 -->
	<#include "../../common/menu.ftl">
	
    <!-- ============================================
    MAIN CONTENT SECTION
    =============================================== -->
  <form id="form1" method="post" action="${path}/admin/user/save_user.html" role="form" class="form-horizontal form-bordered">
    <section class="content-wrapper" role="main">
      <div class="content">
        <div class="content-bar">
          <ul class="breadcrumb breadcrumb-angle">
            <li><a href="#" aria-label="home"><i class="fa fa-home"></i></a></li>
            <li class="active">用户管理</li>
			<li class="active">添加用户</li>
          </ul>
        </div><!-- /.content-bar -->

          <div class="col-md-12">
              <div class="panel" data-fill-color="true">
                  <div class="panel-heading">
                      <h3 class="panel-title">用户基本信息</h3>
                  </div>
                  <div class="panel-body">
            <!--正文内容 开始-->
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                            用户昵称<span class="text-danger">*</span>
                        </label>
                        <div class="col-md-5">
                            <input name="name" id="name" type="text"  class="form-control validate[required]"  />
                            </br>
                        </div>
                    </div>
                      <div class="form-group">
                          <label class="col-sm-3 control-label">
                              用户密码<span class="text-danger">*</span>
                          </label>
                          <div class="col-md-5">
                              <input name="password"  type="password" class="form-control validate[required]"  />
                              </br>
                          </div>
                      </div>
                      <div class="form-group">
                          <label class="col-sm-3 control-label">
                              是否是管理员<span class="text-danger">*</span>
                          </label>
                          <div class="col-md-5">
                              <input name="isNotAdmin" type="checkbox" class="js-switch" data-class-name="switchery switchery-alt" checked="checked" />
                              </br>
                          </div>
                      </div>
                    <br/>
                    <div class="col-md-offset-3 col-md-9">
                        <button class="btn btn-info" type="submit" style="left: 35%;">
                            提交
                        </button>
                        <button class="btn" type="reset" onclick="javascript:history.go(-1)">
                            返回
                        </button>
                    </div>
                  </div><!-- /.content-body -->
                </div>
            </div>

        <!-- Template Setups -->
        <div class="modal fade" id="templateSetup">
          <div class="modal-dialog">
            <!-- modal-content -->
            <div class="modal-content"></div>
          </div><!-- /.modal-dialog -->
        </div><!-- /.templateSetup -->

      </div><!-- /.content -->
    </section><!-- /MAIN -->
  <form>


    <!-- ============================================
    FOOTER SECTION
    =============================================== -->
	<!--
    <footer class="footer-wrapper" role="contentinfo">
      <div class="footer">
        <div class="pull-right text-muted"><small>Currently v1.2</small></div>
        <div>Wrapkit Template  &copy; 2015</div>
      </div>
    </footer>
	--><!-- /.FOOTER -->

  </main><!-- /#MAIN -->


  <!-- VENDORS : jQuery & Bootstrap -->
  <script src="${path}/wrap/scripts/vendor.js"></script>
  <!-- END VENDORS -->

  <!-- DEPENDENCIES : Required plugins -->
  <script src="${path}/wrap/scripts/dependencies.js"></script>
  <!-- END DEPENDENCIES -->

  <!-- WRAPKIT -->
  <script src="${path}/wrap/scripts/wrapkit.js"></script>
  <!-- END WRAPKIT -->

  <!-- WRAPKIT SETUPS -->
  <script src="${path}/wrap/scripts/wrapkit-setup.js"></script>
  <!-- end WRAPKIT SETUPS -->

  <!-- PLUGIN SETUPS: vendors & dependencies setups -->
  <script src="${path}/wrap/scripts/plugin-setups.js"></script>
  <!-- END PLUGIN SETUPS -->


  <!-- COMPONENTS -->
  <script src="${path}/wrap/scripts/dataTables.bootstrap.js"></script>
  <script src="${path}/wrap/scripts/jquery.validate.js"></script>
  <script src="${path}/wrap/scripts/bootbox.js"></script>
  <!-- END COMPONENTS -->

  <!-- DUMMY: Use for demo -->
  <!--
  <script src="/wrap/scripts/demo/table-datatables-extras.js"></script>
  <script src="/wrap/scripts/demo/table-datatables-demo.js"></script>
  -->
  <!-- Google Analytics: change UA-48454066-1 to be your site's ID. -->
  <script>
    (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
      function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
    e=o.createElement(i);r=o.getElementsByTagName(i)[0];
    e.src='//www.google-analytics.com/analytics.js';
    r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
    ga('create','UA-48454066-1');ga('send','pageview');
  </script>
  
  <!-- pageSubmit -->
  <script src="${path}/wrap/scripts/submitSelect.js"></script>

  <script src="${path}/wrap/scripts/date-time/bootstrap-datepicker.min.js"></script>
  <script src="${path}/wrap/scripts/date-time/bootstrap-timepicker.min.js"></script>
  <script src="${path}/wrap/scripts/date-time/moment.min.js"></script>
  <script src="${path}/wrap/scripts/date-time/daterangepicker.min.js"></script>

  <script src="${path}/wrap/scripts/date-time/bootstrap-datetimepicker.js"></script>
  <script src="${path}/wrap/scripts/date-time/locales/bootstrap-datetimepicker.fr.js"></script>

  <script type="text/javascript">
      $('.form_datetime').datetimepicker({
          format: 'yyyy-mm-dd hh:ii',
          autoclose: 1,
          todayBtn:  1
      });
      $('.form_date').datepicker({
          format: 'yyyy-mm-dd',
          autoclose: 1,
          todayBtn:  1
      });
      function validatepicker(obj){
          obj.focus();
          obj.blur();
      };

  </script>

  <script
          src="${path}/wrap/validationengine/js/jquery.validationEngine.js"></script>
  <script
          src="${path}/wrap/validationengine/js/languages/jquery.validationEngine-zh.js"></script>
  <script type="text/javascript">
      $(function(){
          $('#form1').validationEngine({scroll:false,focusFirstField:false});
      });
  </script>
</body>
</html>