orderysApp.controller('profileController', 
function($scope, $http, dataFactory) {
	$scope.userId = 1;
	$scope.getUser = function() {
		$http.get('user/' + $scope.userId)
			.then(
				function(res) {
					console.log(res.firstName);
					console.log(res);
					console.log(res.data.firstName);
					$scope.firstname = res.data.firstName;
				},
				function(res) {
					console.log(res.firstName);
					console.log(res);
					console.log(res.data.firstName);
					console.log('error');
				}
			);
	};
});