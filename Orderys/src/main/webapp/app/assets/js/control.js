orderysApp.controller('buisnessCtrl', 
function($scope, $http, dataFactory) {
	
	$scope.results = dataFactory.getData(
			//Passed in the Callback Function
			function(response){
				console.log(response.data)
				$scope.result = response.data;
			});
	
});