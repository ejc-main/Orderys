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
<body ng-app="orderysApp">
	<div class="container">
		
	<!--Web site Banner -->
		<div class="row" style="border-bottom-style: solid; border-width: 5px;  border-color: #212121;">
			<img src = "https://s3.amazonaws.com/revature-orderys/Main+Banner.png" alt="Orderys" style="width:400px;height:116px;"/>
		</div>
		
		<!--Main content-->
		<div class="row">
		
			<!--Side bar left -->
			<div class="col-xs-3" ng-controller="profileController">
				<input type="hidden" id="userId" value="${user.id}">
				
				<!--Profile pic and username -->
				<div class="thumbnail" style ="height:120px">
      				<img src="https://s3.amazonaws.com/revature-orderys/MainLogo.png" alt="Profile Picture" style="width:100px;height:100px;">
      					<div class="caption">
        					<h4 style="text-align:center" >{{User.firstName }} {{User.lastName }}</h4>
      					</div>
    			</div>
    			
				<!-- Switch view for manager -->
				<div ng-if="isManager()">
    			<ul class="nav nav-pills"> 
  					<li role="presentation" class = "active"><a href="#">Manager</a></li>
  					<li role="presentation"><a href="#">Employee</a></li>
 					 <li role="presentation"><a href="#">Customer</a></li>
				</ul>
				</div>
				
				<!-- Switch view for employees -->
				<div ng-if="isEmployee()">
				<ul class="nav nav-pills"> 
  					<li role="presentation" class="active"><a href="#">Employee</a></li>
 					 <li role="presentation"><a href="#">Customer</a></li>
				</ul>
				</div>
				
				<br>
				<form action="home">
				<button type="submit" class="button">Home</button>
				</form>
				<br>
				<br>
				<form action="profile">
				<button type="submit" class="button">Profile</button>
				</form>
				<br>
				<br>
				<!--  <button class="button">Profile</button>
				<br>
				<br>  -->
				<form action="logout">
				<button type="submit" class="button">Logout</button>
				</form>
				
			</div>
			
			<div ng-controller="menuController">
			<!-- main content for page -->
			<div class="col-xs-6">
			
			<h3 style="text-align:center">{{currentBusiness.name}}</h3>
				
			<h4>Menu</h4>
				
				<!-- Collapseable display for menu items -->
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true" ng-repeat="item in menuItems">
				
				
				<!-- one panel element -->
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="heading{{$index}}">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#collapse{{$index}}" aria-expanded="false"
									aria-controls="collapse{{$index}}">{{item.name}}</a> <p style="float:right">{{item.productPrice}}</p>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="heading{{$index}}">
							<div class="panel-body">
								</div>
									<img alt="Menu Item Pic" src="https://s3.amazonaws.com/revature-orderys/MainLogo.png" style="width:100px;height:100px; float:left">
									<h5>{{item.name}}</h5>
									<p>{{item.description}}</p>
									<p>{{intendedCompletionTime}}</p>
									<p>{{item.productPrice}}</p>
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
							<li style="padding:5px" ng-repeat="item in order">
								<p>food</p>
								<p>cost</p>
								<button class="button">Remove</button> <br>
							</li>
						</ul>

						<p>Tax: amount</p>
						<p>Total: amount</p>
						<button class="button">Checkout</button>

					</div>

				
				</div>
				
				</div>

			</div>

	<!-- footer for page -->
	<div class="footer">
		<h4></h4>
	</div>
	
	<script src ="<%=request.getContextPath()%>/resources/app.js"></script>
	<script src ="<%=request.getContextPath()%>/resources/js/control.js"></script>
	<script src ="<%=request.getContextPath()%>/resources/js/serviceFactory.js"></script>

</body>
</body>
</html>