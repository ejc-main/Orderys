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
	<!--<meta name="msapplication-config" content="https://s3.amazonaws.com/revature-orderys/browserconfig.xml">-->

	<!-- For me to see and adjust page layout not for actual site -->
	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.js"
		integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
		crossorigin="anonymous">
	</script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<!-- AngularJS CDN, put in projects that use Angular -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
	<!--  Routing -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.0/angular-route.js"></script>
	<link rel="stylesheet" type="text/css" href="./orderys-app.css">
</head>
<body ng-app="orderysApp" ng-controller="buisnessCtrl">
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
        					<h4 style="text-align:center">{{ result.exampleCustomer.firstname}}</h4>
      					</div>
    			</div>
    			
				<!-- Switch view for manager -->
    			<ul class="nav nav-pills"> 
  					<li role="presentation" class = "active"><a href="#">Manager</a></li>
  					<li role="presentation"><a href="#">Employee</a></li>
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
				<button class="button">Home</button>
				<br>
				<br>
				<button class="button">Profile</button>
				<br>
				<br>
				<!--  <button class="button">Profile</button>
				<br>
				<br>  -->
				<button class="button">Logout</button>
				
			</div>
			
			<!-- main content for page -->
			<div class="col-xs-6">
			
			<h3 style="text-align:center">Business name</h3>
				
			<h4>Menu</h4>
				
				<!-- Collapseable display for menu items -->
				<!-- may be a tricky one to free marker -->
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				
				
				<!-- one panel element -->
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne" aria-expanded="true"
									aria-controls="collapseOne"> Product name</a> <p style="float:right">Price</p>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								</div>
									<img alt="Menu Item Pic" src="https://s3.amazonaws.com/revature-orderys/MainLogo.png" style="width:100px;height:100px; float:left">
									<h5>Product Name</h5>
									<p>Description</p>
									<p>Estimated wait time</p>
									<p>Price</p>
									<button class="button">Add to Order</button>
									<br>
								</div>
						</div>
					
					
					</div>
				</div>
				
				

					<!-- side bar right -->
					<div class="col-xs-3">

						<h3 style="text-align: center">My Order</h3>
						<br>

						<!-- list of order items -->
						<ul style="height: 200px; overflow: auto;">
							<li>
								<p>food</p>
								<p>cost</p>
								<button class="button">Remove</button> <br>
							</li>
							<li>
								<p>food</p>
								<p>cost</p>
								<button class="button">Remove</button>
							</li>
							<br>
							<li>
								<p>food</p>
								<p>cost</p>
								<button class="button">Remove</button>
							</li>
							<br>
						</ul>

						<p>Tax: amount</p>
						<p>Total: amount</p>
						<br>
						<button class="button">Checkout</button>

					</div>


				</div>

			</div>

	<!-- footer for page -->
	<div class="footer">
		<h4>footer here</h4>
	</div>
	
	<script src ="./app.js"></script>
	<script src ="./assets/js/control.js"></script>
	<script src ="./assets/js/serviceFactory.js"></script>

</body>
</body>
</html>