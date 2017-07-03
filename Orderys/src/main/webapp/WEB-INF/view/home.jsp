<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Orderys</title>
	<%@ include file="resources.jspf" %>
</head>
<body ng-app="orderysApp">
	<div class="container">
		<%@ include file="banner.jspf" %>
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
 					 	<li role="presentation"><a href="#/customer">Customer</a></li>
  					<li role="presentation"><a href="#/employee">Employee</a></li>
  					<li role="presentation" class = "active"><a href="#/manager">Manager</a></li>
					</ul>
				</div>
				<!-- Switch view for employees -->
				<div>
					<ul class="nav nav-pills" ng-if="isEmployee()">
						<li role="presentation"><a href="#/customer">Customer</a></li>
						<li role="presentation" class="active"><a href="#/employee">Employee</a></li>
					</ul>
				</div>
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
				<form action="logout" method="post">
					<button type="submit" class="button">Logout</button>
				</form>
			</div>

			<main id="router-outlet" ng-view></main>

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
					<li style="padding:5px">
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

	<%@ include file="footer.jspf" %>
	
	<%@ include file="scripts.jspf" %>

</body>
</body>
</html>