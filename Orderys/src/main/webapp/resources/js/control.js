orderysApp.controller('profileController', 
function($scope, $http, dataFactory) {
	
	$scope.userId;
	$scope.User;
	
	dataFactory.getUser($scope.userId).success(function (data) {
		console.log(data);
		$scope.User = data;
	});
	
	$scope.isManager = function() {
	   
		var role = $scope.User.role;
		
		if(role.equals("MANAGER"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	$scope.isEmployee = function() {
		   
		var role = $scope.User.role;
		
		if(role.equals("EMPLOYEE"))
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