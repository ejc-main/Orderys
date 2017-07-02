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
				
				<!-- all modals located at bottom of page -->
				<br>
					<!-- Button trigger modal -->
				<button type="button" class="button" data-toggle="modal" data-target="#menuCreate" style="width:200px">
  					Add Menu Item
				</button>
				<br>
				<br>
				<!-- Button trigger modal -->
				<button type="button" class="button" data-toggle="modal" data-target="#stationCreate" style="width:200px">
  					Add Station
				</button>
				<br>
				<br>
				<!-- Button trigger modal -->
				<button type="button" class="button" data-toggle="modal" data-target="#eCreate" style="width:200px">
  					Add Employee
				</button>
				<br>
				<br>
				<form action="/logout">
				<button type="submit" class="button">Logout</button>
				</form>
				
			</div>
			
			<!-- main content for page -->
			<div class="col-xs-6">
			
			<!-- list of menu items -->
			<ul  style="height:300px;overflow:auto;">
			
			<!-- one menu item on manager side -->
			<li style="border-bottom:1px solid black;">
			
			<img src="https://s3.amazonaws.com/revature-orderys/MainLogo.png" alt="Profile Picture" style="width:100px;height:100px;">
			<h5>Product Name</h5>
			<p>Description</p>
			<p>Estimated wait time</p>
			<p>Price</p>
			
			<select>
			<!-- default taht it starts on -->
				<option disabled selected>Change Station</option>
				
 				<option value="station1">Station 1</option>
  				<option value="station2">Station 2</option>
  				<option value="station3">Station 3</option>
			</select>
			<button class="button">Update</button>
			<button class="button">Delete</button>
			<br>
			<br>
			</li>
			
			</ul>
			
			
			</div>
			
			<!-- side bar right -->
			<div class="col-xs-3">
			
			<!-- List of stations -->
			<ul style="height:300px;overflow:auto;">
			
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
	
	
	<!-- modals -->

<!-- Modal for menu itme creation -->
<div class="modal fade" id="menuCreate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Create Menu Item</h4>
      </div>
      <div class="modal-body">
      
      <!-- Create menu item form -->
        <form name="menuItemCreate">
        
        	<img name="uploadedImg" alt="Menu Item Pic" src="https://s3.amazonaws.com/revature-orderys/MainLogo.png" style="width:150px;height:150px; float:left">
			Product Name <input type = "text" name="pName" placeholder="Product Name" style="float:right" required=required> <br><br>
			Description <input type = "text" name="discription" placeholder="Discription" style="float:right" required=required> <br><br>
			Estimated wait time <input type = "text" name="time" placeholder="00:00" style="float:right" required=required> <br><br>
			Price <input type = "text" name="price" placeholder="00.00" C required=required> <br><br>
			
			<button class="button">Upload Image</button>
			
			<select>
			<!-- default taht it starts on -->
				<option disabled selected>Change Station</option>
				
				
 				<option value="station1">Station 1</option>
  				<option value="station2">Station 2</option>
  				<option value="station3">Station 3</option>
			</select>
			<input type="submit" class="button" style="float:right" value="Confirm">
			<br>
			<br>
        
        </form>
      </div>
    </div>
  </div>
</div>


<!-- Modal for menu station creation -->
<div class="modal fade" id="stationCreate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Add Station</h4>
      </div>
      <div class="modal-body">
      
      <!-- Create station form -->
       <form name="stationCreate">
       
       Name <input type = "text" name="sName" placeholder="Name"  style="float:right" required=required> <br><br>
       
       <input type=submit class="button" style="float:right" value="Confirm">
       <br>
       <br>
       
       </form>
      </div>
    </div>
  </div>
</div>

<!-- Modal for menu employee creation -->
<div class="modal fade" id="eCreate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Add Employee</h4>
      </div>
      <div class="modal-body">
      
      
       <!-- Create employee form -->
       <form name="eCreate">
       
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

</body>

</html>