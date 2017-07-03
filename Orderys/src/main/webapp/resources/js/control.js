
var usr = document.getElementById("userId").value;


orderysApp.controller('navController', 
function($scope, $http, dataFactory) {
	
	$scope.User;
	
	
	dataFactory.getUser(usr).success(function (data) {
		$scope.User = data;
	});
	
	$scope.isManager = function() {
	   
		if($scope.User === undefined)
		{
			return false;
		}
		
		var role = $scope.User.role;
		
		if(role == "MANAGER")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	$scope.isEmployee = function() {
		
		if($scope.User === undefined)
		{
			return false;
		}
		
		var role = $scope.User.role;
		
		if(role == "EMPLOYEE")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
});


/*$scope.getUser = function() {
	$http.get('user/' + $scope.userId)
		.then(
			function(res) {
				console.log(res.firstName);
				console.log(res);
				console.log(res.data.firstName);
				$scop.firstname = res.data.firstName;
				$scope.lastname = res.data.lastName
			},
			function(res) {
				console.log(res.firstName);
				console.log(res);
				console.log(res.data.firstName);
				console.log('error');
			}
		);
};*/