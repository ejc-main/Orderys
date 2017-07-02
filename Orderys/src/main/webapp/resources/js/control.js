orderysApp.controller('profileController', 
function($scope, $http, dataFactory) {
	// $scope.userId = 1;
	
	dataFactory.getUser($scope.userId).success(function (data) {
		console.log(data);
		$scope.User = data;
	});
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