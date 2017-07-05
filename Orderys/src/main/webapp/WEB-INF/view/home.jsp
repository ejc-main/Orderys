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
			<div class="col-xs-3" ng-controller="navController">
				<input type="hidden" id="userId" value="${user.id}">
				<!--Profile pic and username -->
				<div class="thumbnail" style ="height:120px">
					<img src="https://s3.amazonaws.com/revature-orderys/MainLogo.png" alt="Profile Picture" style="width:100px;height:100px;">
					<div class="caption">
						<h4 style="text-align:center" >{{User.firstName }} {{User.lastName }}</h4>
					</div>
				</div>
				<!-- Switch view for manager -->
				<div>
    			<ul class="nav nav-pills" ng-if="isManager()">
 					 	<li role="presentation"><a href='#customer'>Customer</a></li>
  					<li role="presentation"><a href='#employee'>Employee</a></li>
  					<li role="presentation"><a href='#manager'>Manager</a></li>
					</ul>
				</div>
				<!-- Switch view for employees -->

				<div ng-if="isEmployee()">
					<ul class="nav nav-pills">
						<li role="presentation"><a href='#customer'>Customer</a></li>
						<li role="presentation"><a href='#employee'>Employee</a></li>
					</ul>
				</div>
				<br>
				
				<div ng-if="isCustomer()">
				<a href='#customer' style="text-decoration: none">
				<button class="button">Home</button>
				</a>
				<br>
				<br>
				</div>

				<a href='#profile'style="text-decoration: none">
					<button class="button">Profile</button>
				</a>

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
			
			
		</div>
	</div>

	<%@ include file="footer.jspf" %>
	
	<%@ include file="scripts.jspf" %>

</body>
</html>