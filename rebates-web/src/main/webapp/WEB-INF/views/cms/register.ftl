<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/semantic.min.css" />
	</head>
	<body>
		<header>
			CMS系统
		</header>
		<div class="width80">
			<!--面包屑-->
			<div class="ui large breadcrumb">
			  <a class="section">CMS</a>
			  <i class="right chevron icon divider"></i>
			  <a class="active section">注册</a>
			  <!--<i class="right chevron icon divider"></i>
			  <div class="active section">新建</div>-->
			</div>
			
			<div class="ui middle aligned center aligned grid">
				<div class="column">
					<form class="ui large form">
						<div class="ui stacked segment">
							<div class="inline field">
								<label>用户名：</label>
								<div class="ui left icon input">
									<i class="user icon"></i>
									<input type="text" placeholder="E-mail address" name="email">
								</div>
							</div>
							<div class="inline field">
								<label>手机：</label>
								<div class="ui left icon input">
									<i class="phone icon"></i>
									<input type="text" placeholder="phone" name="email">
								</div>
							</div>
							<div class="inline field">
								<label>邮箱：</label>
								<div class="ui left icon input">
									<i class="mail icon"></i>
									<input type="text" placeholder="E-mail address" name="email">
								</div>
							</div>
							<div class="inline field">
								<label>密码：</label>
								<div class="ui left icon input">
									<i class="lock icon"></i>
									<input type="password" placeholder="Password" name="password">
								</div>
							</div>
							<div class="inline field">
								<label>确认密码：</label>
								<div class="ui left icon input">
									<i class="lock icon"></i>
									<input type="password" placeholder="Password" name="password">
								</div>
							</div>
							<!--<div class="ui fluid large teal submit button">注册</div>-->
							<button class="ui green button">注册</button>
						</div>
						<div class="ui error message"></div>
					</form>
					<!--<div class="ui message">
						New to us?
						<a href="#">Sign Up</a>
					</div>
					<div class="actions">
					    <div class="ui button blue">保存</div>
					    <div class="ui button blue">取消</div>
					</div>-->
				</div>
			</div>
		</div>
	</body>
</html>
