<!DOCTYPE html>
<html lang="en">
<html>
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
<body ng-app="orderysApp" ng-controller="profileController">


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
			
			<!-- main content for page -->
			<div class="col-xs-6">
			
			<img src="../assets/img/MainLogo.png" alt="Profile Picture" style="width:100px;height:100px;"/>
			<p>{{User.firstName }} {{User.lastName }}</p>
			<p>{{User.email}}</p>
			<button class="button" data-toggle="modal" data-target="#pUpdate" >Edit</button>
			
			<h5>Past Orders</h5>
			
			<!-- list of orders -->	
			<ul style="height:200px;overflow:auto;padding-right:20px;">
				<li>
				 	<p>Business Name</p>
			 		<p>cost</p>
			 		<button class="button" style="float:right;">Rate</button>
			 		<br>
				</li>
			</ul>
			
			<button class="button" data-toggle="modal" data-target="#cBusiness" >Create a business</button>
			
			</div>
			
			<!-- side bar right -->
			<div class="col-xs-3">
			
			<h3 style="text-align:center">My Order</h3>
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
			<br>
			<button class="button">Checkout</button>
			
			</div>
			
			
		</div>

	</div>

	<!-- footer for page -->
	<div class="footer">
		<h4></h4>
	</div>
	
	
	<!-- Modal for update profile -->
<div class="modal fade" id="pUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Update Info</h4>
      </div>
      <div class="modal-body">
      
      
       <!-- Update user form -->
       <form name="pUpdate">
       
       First Name <input type = "text" name="fName" placeholder=" First Name" style="float:right" required=required> <br><br>
       Last Name <input type = "text" name="lName" placeholder="Last Name" style="float:right" required=required> <br><br>
       Email <input type = "text" name="email" placeholder="Email" style="float:right" required=required> <br><br>
       
       <input type=submit class="button" style="float:right" value="Confirm">
       <br>
       <br>
       
       </form>
      
      </div>
    </div>
  </div>
</div>


	<!-- Modal for update profile -->
<div class="modal fade" id="cBusiness" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Update Info</h4>
      </div>
      <div class="modal-body">
      
      
       <!-- Update user form -->
       <form name="cBusiness" action="user/{{User.id}}" method="post">
       
       Name <input type = "text" name="fName" placeholder=" First Name" style="float:right" required=required> <br><br>
       Address 1 <input type = "text" name="lName" placeholder="Last Name" style="float:right" required=required> <br><br>
       Address 2 <input type = "text" name="email" placeholder="Email" style="float:right"> <br><br>
       City <input type = "text" name="city" placeholder="City" style="float:right" required=required> <br><br>
       State <input type = "text" name="state" placeholder="State" style="float:right" required=required> <br><br>
       Country <input type = "text" name="country" placeholder="Country" style="float:right" required=required> <br><br>
       Zip Code <input type = "number" name="zip" placeholder="Zip Code" style="float:right" required=required> <br><br>
       
       
       <input type=submit class="button" style="float:right" value="Confirm">
       <br>
       <br>
       
       </form>
      
      </div>
    </div>
  </div>
</div>

</body>

</html>