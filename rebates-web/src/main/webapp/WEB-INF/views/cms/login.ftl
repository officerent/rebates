<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0" name="viewport">
	<title>Login Example - Semantic</title>
	<link rel="stylesheet" href="css/index.css" />
	<link href="dist/components/reset.css" type="text/css" rel="stylesheet">
	<link href="dist/components/site.css" type="text/css" rel="stylesheet">
	<link href="dist/components/container.css" type="text/css" rel="stylesheet">
	<link href="dist/components/grid.css" type="text/css" rel="stylesheet">
	<link href="dist/components/header.css" type="text/css" rel="stylesheet">
	<link href="dist/components/image.css" type="text/css" rel="stylesheet">
	<link href="dist/components/menu.css" type="text/css" rel="stylesheet">
	<link href="dist/components/divider.css" type="text/css" rel="stylesheet">
	<link href="dist/components/segment.css" type="text/css" rel="stylesheet">
	<link href="dist/components/form.css" type="text/css" rel="stylesheet">
	<link href="dist/components/input.css" type="text/css" rel="stylesheet">
	<link href="dist/components/button.css" type="text/css" rel="stylesheet">
	<link href="dist/components/list.css" type="text/css" rel="stylesheet">
	<link href="dist/components/message.css" type="text/css" rel="stylesheet">
	<link href="dist/components/icon.css" type="text/css" rel="stylesheet">
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/semantic.js"></script>	
	<script type="text/javascript" src="js/form.js"></script>
	<script type="text/javascript" src="js/transition.js"></script>
	<!--<script src="assets/library/jquery.min.js">-->
	<!--<script src="dist/components/form.js">
	<script src="dist/components/transition.js">
	<style type="text/css">
	<script>-->
	<script>

	  $(document)
	    .ready(function() {
	      $('.ui.form')
	        .form({
	          fields: {
	            email: {
	              identifier  : 'email',
	              rules: [
	                {
	                  type   : 'empty',
	                  prompt : 'Please enter your e-mail'
	                },
	                {
	                  type   : 'email',
	                  prompt : 'Please enter a valid e-mail'
	                }
	              ]
	            },
	            password: {
	              identifier  : 'password',
	              rules: [
	                {
	                  type   : 'empty',
	                  prompt : 'Please enter your password'
	                },
	                {
	                  type   : 'length[6]',
	                  prompt : 'Your password must be at least 6 characters'
	                }
	              ]
	            }
	          }
	        })
	      ;
	    });
	  
	</script>
</head>
<body>
		<header>
			CMS系统
		</header>
		<div class="width80">
			<div class="ui middle aligned center aligned grid">
				<div class="column">
					<h2 class="ui teal image header">
						<img class="image" src="img/logo.png">
						<div class="content"> Log-in to your account </div>
					</h2>
					<form class="ui large form">
						<div class="ui stacked segment">
							<div class="field">
								<div class="ui left icon input">
									<i class="user icon"></i>
									<input type="text" placeholder="E-mail address" name="email">
								</div>
							</div>
							<div class="field">
								<div class="ui left icon input">
									<i class="lock icon"></i>
									<input type="password" placeholder="Password" name="password">
								</div>
							</div>
							<div class="ui fluid large teal submit button">Login</div>
						</div>
						<div class="ui error message"></div>
					</form>
					<div class="ui message">
						New to us?
						<a href="#">Sign Up</a>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>