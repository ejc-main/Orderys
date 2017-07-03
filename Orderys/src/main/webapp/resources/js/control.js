
var usr = document.getElementById("userId").value;

var order = {items : []};


orderysApp.controller('profileController', 
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

orderysApp.controller('menuController', 
function($scope, $http, dataFactory) {
			
			$scope.allBusiness; 
			$scope.currentBusiness;
			$scope.menuItems;
			$scope.order = order;
			
			dataFactory.getAllBusiness().success(function (data) {
				$scope.allBusiness = data;
			});
			
			dataFactory.getBuisness(id).success(function (data) {
				$scope.currentBusiness = data;
			});
			
			dataFactory.getProduct($scope.currentBusiness.id).success(function (data) {
				$scope.menuItems = data;
			});
			
			$scope.addToOrder = function(index){
				
				var item = $scope.menuItems[index];
				
				$scope.order.push({
					
					id : item.id;
					name : item.name;
					price : item.productPrice;
					
				});
				
			}
			
			$scope.removeFromOrder(index)
			{
				$scope.order.splice(index,1);
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