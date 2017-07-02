<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Orderys</title>
	<!-- For me to see and adjust page layout not for actual site -->
	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.js"
		integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
		crossorigin="anonymous">
	</script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="./orderys-app.css">
</head>
<body>
	<div class="container">
		
	<!--Web site Banner -->
		<div class="row" style="border-bottom-style: solid; border-width: 5px;  border-color: #212121;">
			<img src = "./assets/img/Main Banner.png" alt = "Orderys" style="width:400px;height:116px;"/>
		</div>
		
		<!--Main content-->
		<div class="row">
		
			<!--Not used on login-->
			<div class="col-xs-4"></div>
			
			<!-- Displays login form -->
			<div class="col-xs-4">
			
			<!-- Login -->
			<div>
			<!-- Login header -->
			<div class="row" style="background-color:#212121; color:#efecec; padding-left:20px">
			<h3>Login</h3>
			</div>
			
			<!-- Login Form -->
			<div class="row" style="padding-left:20px">
			<form name="loginForm" action="login" method="post">
			
			<h4>Email</h4>
			<input type="text" name="email" placeholder="Email" required="required">
			<br>
			
			<h4>Passsword</h4>
			<input type="password" name="password" placeholder="Password" required="required">
			
			<br>
			<br>
			
			<input type="submit" class="button" value="Login">
			
			</form>
			
			<!-- link to create new user -->
			<a href="createAccount.html" style="color: #212121;">Create an account.</a>
			</div>
			
			
			</div>
			
				<!-- Create user form -->
			<div>
			<!-- Login header -->
			<div class="row" style="background-color:#212121; color:#efecec; padding-left:20px">
			<h3>Create Account</h3>
			</div>
			
			<!-- Login Form -->
			<div class="row" style="padding-left:20px"">
			<form name="loginForm" action="createAccount" method="post">
			
			<h4>First Name</h4>
			<input type="text" name="fName" placeholder="First Name" required="required">
			<br>
			
			<h4>Last Name</h4>
			<input type="text" name="lName" placeholder="Last Name" required="required">
			<br>
			
			<h4>Email</h4>
			<input type="text" name="email" placeholder="Email" required="required">
			<br>
			
			<h4>Passsword</h4>
			<input type="password" name="password" placeholder="Password" required="required">
			
			<br>
			<br>
			
			<input type="submit" class="button" value="Create Account">
			
			</form>
			<!-- link to create new user -->
			<a href="index.html" style="color: #212121;">already have an account? Login.</a>
			
			</div>
			</div>
			
			</div>
			
			<!-- not used on login -->
			<div class="col-xs-4"></div>
			
		</div>

	</div>

	<!-- footer for page -->
	<div class="footer">
		<h4>footer here</h4>
	</div>

</body>

</html>