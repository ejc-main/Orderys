<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Orderys</title>
	<link rel="shortcut icon" href="https://s3.amazonaws.com/revature-orderys/favicon.ico">
	<link rel="icon" sizes="16x16 32x32 64x64" href="https://s3.amazonaws.com/revature-orderys/favicon.ico">
	<link rel="icon" type="image/png" sizes="196x196" href="https://s3.amazonaws.com/revature-orderys/favicon-192.png">
	<link rel="icon" type="image/png" sizes="160x160" href="https://s3.amazonaws.com/revature-orderys/favicon-160.png">
	<link rel="icon" type="image/png" sizes="96x96" href="https://s3.amazonaws.com/revature-orderys/favicon-96.png">
	<link rel="icon" type="image/png" sizes="64x64" href="https://s3.amazonaws.com/revature-orderys/favicon-64.png">
	<link rel="icon" type="image/png" sizes="32x32" href="https://s3.amazonaws.com/revature-orderys/favicon-32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="https://s3.amazonaws.com/revature-orderys/favicon-16.png">
	<link rel="apple-touch-icon" href="https://s3.amazonaws.com/revature-orderys/favicon-57.png">
	<link rel="apple-touch-icon" sizes="114x114" href="https://s3.amazonaws.com/revature-orderys/favicon-114.png">
	<link rel="apple-touch-icon" sizes="72x72" href="https://s3.amazonaws.com/revature-orderys/favicon-72.png">
	<link rel="apple-touch-icon" sizes="144x144" href="https://s3.amazonaws.com/revature-orderys/favicon-144.png">
	<link rel="apple-touch-icon" sizes="60x60" href="https://s3.amazonaws.com/revature-orderys/favicon-60.png">
	<link rel="apple-touch-icon" sizes="120x120" href="https://s3.amazonaws.com/revature-orderys/favicon-120.png">
	<link rel="apple-touch-icon" sizes="76x76" href="https://s3.amazonaws.com/revature-orderys/favicon-76.png">
	<link rel="apple-touch-icon" sizes="152x152" href="https://s3.amazonaws.com/revature-orderys/favicon-152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="https://s3.amazonaws.com/revature-orderys/favicon-180.png">
	<meta name="msapplication-TileColor" content="#FFFFFF">
	<meta name="msapplication-TileImage" content="https://s3.amazonaws.com/revature-orderys/favicon-144.png">
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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/orderys-app.css"/>
</head>
<body>
	<div class="container">
		<%@ include file="banner.jspf" %>
		<!--Main content-->
		<div class="row">
			<!--Not used on login-->
			<div class="col-xs-1"></div>
			
			<!-- Displays login form -->
			<div class="col-xs-5">
				<!-- Login -->
				<div>
					<!-- Login header -->
					<div class="row" style="background-color:#212121; color:#efecec; padding-left:20px">
					<h3>Login</h3>
					</div>
					<c:if test="${not empty loginError}">
						<div class="alert alert-danger alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							${loginError}
						</div>
					</c:if>
					<!-- Login Form -->
					<div class="row" style="padding-left:20px">
						<form name="loginForm" action="login" method="post">
							<h4>Email</h4>
							<input type="email" name="email" placeholder="Email" required="required">
							<br>
							<h4>Password</h4>
							<input type="password" name="password" placeholder="Password" required="required">
							<br>
							<br>
							<button type="submit" class="button">Login</button>
							<!--<input type="submit" class="button" value="Login">-->
						</form>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<!-- Registration -->
				<div>
					<!-- Registration header -->
					<div class="row" style="background-color:#212121; color:#efecec; padding-left:20px">
						<h3>Register</h3>
					</div>
					<c:if test="${not empty registrationError}">
						<div class="alert alert-danger alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							${registrationError}
						</div>
					</c:if>
					<!-- Registration Form -->
					<div class="row" style="padding-left:20px; border-left:solid black 2px">
						<form name="registerForm" action="register" method="post">
							<h4>First Name</h4>
							<input type="text" name="firstname" placeholder="First Name" required="required">
							<br>
							<h4>Last Name</h4>
							<input type="text" name="lastname" placeholder="Last Name" required="required">
							<br>
							<h4>Email</h4>
							<input type="email" name="email" placeholder="Email" required="required">
							<br>
							<h4>Password</h4>
							<input type="password" name="password" placeholder="Password" required="required">
							<br>
							<br>
							<button type="submit" class="button">Register</button>
							<!--<input type="submit" class="button" value="Create Account">-->
						</form>
					</div>
				</div>
			</div>
			<!-- not used on login -->
			<div class="col-xs-1"></div>
		</div>

	</div>

	<%@ include file="footer.jspf" %>

</body>

</html>