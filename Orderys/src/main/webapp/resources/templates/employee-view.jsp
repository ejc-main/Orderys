<html>
<head>

<!-- For me to see and adjust page layout not for actual site -->

<meta charset="ISO-8859-1">
<title>Orderys</title>
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
	<meta name="msapplication-TileColor" content="#FFFFFF">
	<meta name="msapplication-TileImage" content="https://s3.amazonaws.com/revature-orderys/favicon-144.png">
	<!--<meta name="msapplication-config" content="https://s3.amazonaws.com/revature-orderys/browserconfig.xml">-->

	<meta charset="ISO-8859-1">
	<title>Orderys</title>


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

	<!-- AngularJS CDN, put in projects that use Angular -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/orderys-app.css"/>
</head>
<body>


	<div class="container">
		
	<!--Web site Banner -->
		<div class="row" style="border-bottom-style: solid; border-width: 5px;  border-color: #212121;">
			<img src = "https://s3.amazonaws.com/revature-orderys/Main+Banner.png" alt="Orderys" style="width:400px;height:116px;"/>
		</div>
		
		<!--Main content-->
		<div class="row">
		
		
			<!--Side bar left -->
			<div class="col-xs-3">
				
				<!--Profile pic and username -->
				<div class="thumbnail" style ="height:120px">
      				<img src="https://s3.amazonaws.com/revature-orderys/MainLogo.png" alt="Profile Picture" style="width:100px;height:100px;">
      					<div class="caption">
        					<h4 style="text-align:center">User Name</h4>
      					</div>
    			</div>
    			
				<!-- Switch view for manager -->
    			<ul class="nav nav-pills"> 
  					<li role="presentation" ><a href="#">Manager</a></li>
  					<li role="presentation" class = "active"><a href="#">Employee</a></li>
 					 <li role="presentation"><a href="#">Customer</a></li>
				</ul>
				
				<!-- 
				<!-- Switch view for employees
				<ul class="nav nav-pills"> 
  					<li role="presentation" class="active"><a href="#">Employee</a></li>
 					 <li role="presentation"><a href="#">Customer</a></li>
				</ul>
				 -->
				
				<br>
				<button class="button">Current Orders</button>
				<br>
				<br>
				<button class="button">Completed Orders</button>
				<br>
				<br>
				<!--<button class="button">extra</button>
				<br>
				<br> -->
				<form action="logout">
				<button type="submit" class="button">Logout</button>
				</form>
				
			</div>
			
			<!-- main content for page -->
			<div class="col-xs-6">
			
			<h3>Orders</h3>
			
			<!-- list of orders -->
			<ul style="height:300px;overflow:auto;padding-right:20px">
			
				<li>
				<br>
				<p> order item</p>
				<p> current time/expected time</p>
				
				<div class="progress">
  					<div class="progress-bar" role="progressbar" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100" style="width: 10%;">
    				<span class="sr-only">10% Complete</span>
  					</div>
				</div>
				
				<br>
				
				</li>
				
				<li>
				<br>
				<p> order item</p>
				<p> current time/expected time</p>
				
				<div class="progress">
  					<div class="progress-bar" role="progressbar" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100" style="width: 10%;">
    				<span class="sr-only">10% Complete</span>
  					</div>
				</div>
				
				<br>		
			</ul>
			
			</div>
			
			<!-- side bar right -->
			<div class="col-xs-3">
			
			<!-- List of stations -->
			<ul style="height:300px;overflow:auto;"">
			
			<li>
			<br>
			<button class="button">Station Name</button>
			<br>
			</li>
			
			<li>
			<br>
			<button class="button">Station Name</button>
			<br>
			</li>
			
			<li>
			<br>
			<button class="button">Station Name</button>
			<br>
			</li>
			
			<li>
			<br>
			<button class="button">Station Name</button>
			<br>
			</li>
			
			</ul>
			
			</div>
			
		</div>

	</div>

	<!-- footer for page -->
	<div class="footer">
		<h4></h4>
	</div>

</body>

</html>