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
	<link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/revature-orderys/orderys-app.css">
</head>
<body ng-app="testApp">
	<div class="container" ng-controller="dummyCtrl">
		<input type="email" placeholder="Email address" ng-model="email">
		<input type="password" placeholder="Password" ng-model="password">
		<input type="text" placeholder="First name" ng-model="firstname">
		<input type="text" placeholder="Last name" ng-model="lastname">

		<button ng-click="postUser()">Add User</button>

		<input type="number" placeholder="User ID" ng-model="userId">
		<button ng-click="getUser()"></button>
		
		

	</div>
	<script>
		var testApp = angular.module('testApp', []);
		testApp.controller('dummyCtrl', function($scope, $http) {
			$scope.getUser = function() {
				$http.get('user/' + $scope.userId)
					.then(function(res) {}, function(res) {});
			};
			$scope.postUser() = function() {
				$http.post('user').then()
			}
		});
	</script>
</body>

</html>