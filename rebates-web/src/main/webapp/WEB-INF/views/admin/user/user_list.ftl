<#include "../common/base.ftl">
<!DOCTYPE html>
<html class="no-js">
<head>

    
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="initial-scale=1,minimum-scale=1,maximum-scale=1,width=device-width,height=device-height,target-densitydpi=device-dpi,user-scalable=yes">

  <title>用户列表</title>


  <link rel="stylesheet" href="${path}/wrap/styles/bootstrap.css">

  <link rel="stylesheet" href="${path}/wrap/styles/dependencies.css">

  <link rel="stylesheet" href="${path}/wrap/styles/wrapkit.css">

  <link rel="stylesheet" href="${path}/wrap/styles/demo.css">

    <!-- datetimepicker css -->
    <link rel="stylesheet" href="${path}/wrap/styles/bootstrap-datetimepicker.min.css" />
</head>

<body>
  <!--[if lt IE 9]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->


    <main class="wrapkit-wrapper" id="wrapper">

	<!-- 头部  -->
 	<#include "../common/header.ftl">

	<!-- 左边菜单栏 -->
	<#include "../common/menu.ftl">
	
    <!-- ============================================
    MAIN CONTENT SECTION
    =============================================== -->
  <form id="form1" method="post">
    <section class="content-wrapper" role="main">
      <div class="content">
          <div class="content-bar">
              <ul class="breadcrumb breadcrumb-angle">
                  <li><a href="#" aria-label="home"><i class="fa fa-home"></i></a></li>
                  <li class="active">用户管理</li>
                  <li class="active">用户列表</li>
              </ul>
          </div><!-- /.content-bar -->


        <div class="content-body">
              	<!--正文内容 开始-->
            <div class="col-md-12">
                <h3>用户列表</h3>
                <div class="row">
                    <div class="col-md-12">
                        <a class="btn btn-success mb-1x mr-1x" href="${path}/admin/user/add_user.html">添加用户</a>
                    </div>
                </div>    
                <div class="panel fade in panel-default panel-fill" data-fill-color="true" data-init-panel="true">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label">姓名:</label>
                                    <div class="col-md-4">
                                        <div class="input-group input-group-in">
                                            <input name="name" class="form-control" value = "${name!''}"/>                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"></label>
                                    <div class="col-md-4">
                                        <button class="btn btn-success mb-1x mr-1x">搜索</button>
                                    </div>
                                </div>
                            </div><!-- /panel-body -->
                        </div>
                        </br>
                    </div>
                </div>
                <div class="table-responsive">

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>用户名</th>
                                <th>角色</th>
                                <th>状态</th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        <#list data as d >
                        <tr class="odd" role="row">
                            <td>${d.name!''}</td>
                            <td>
                                <#if d.isAdmin==1>
                                    管理员
                                <#else>
                                    用户
                                </#if>
                            </td>
                            <td>
                                <#if d.status==0>
                                    正常
                                </#if>
                                <#if d.status==1>
                                    冻结
                                </#if>
                                <#if d.status==2>
                                    删除
                                </#if>
                            </td>
                            <td>${d.createTime?date}</td>
                            <td>${d.lastUpdateTime?date}</td>
                            <td>
                                <a class="btn btn-info mb-1x mr-1x" href="${path}/admin/user/modify_user.html?userId=${d.userId}">修改</a>
                                <a class="btn btn-success mb-1x mr-1x" href="${path}/admin/user/update_status.html?userId=${d.userId}&status=0">恢复正常</a>
		                        <a class="btn btn-warning mb-1x mr-1x" href="${path}/admin/user/update_status.html?userId=${d.userId}&status=1">冻结</a>
		                        <a class="btn btn-danger mb-1x mr-1x" href="${path}/admin/user/update_status.html?userId=${d.userId}&status=2">删除</a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div><!-- /.table-responsive -->
            </div><!-- /.cols -->
		        <!--正文内容 结束-->
            <#include "../common/page.ftl">
		   </div><!-- /.panel -->
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
  <script src="${path}/wrap/scripts/demo/table-datatables-extras.js"></script>
  <#--<script src="${path}/wrap/scripts/demo/table-datatables-demo.js"></script>-->
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
  <script src="${path}/wrap/submitSelect.js"></script>

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
</body>
</html>