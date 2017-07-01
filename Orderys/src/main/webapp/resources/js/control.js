orderysApp.controller('profileController', 
function($scope, $http, dataFactory) {
	$scope.userId = 1;
	$scope.getUser = function() {
		$http.get('user/' + $scope.userId)
			.then(
				function(res) {
					$scope.user.firstname = res;
				},
				function(res) {
					console.log('error');
				}
			);
	};
});