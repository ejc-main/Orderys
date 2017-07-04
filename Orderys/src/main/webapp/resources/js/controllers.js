
var usr = document.getElementById("userId").value;

var order = {items : []};


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
	
	$scope.isCustomer = function() {
		
		if($scope.User === undefined)
		{
			return false;
		}
		
		var role = $scope.User.role;
		
		if(role == "CUSTOMER")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
});

orderysApp.controller('cHomeController', 
		function($scope, $http, dataFactory) {
		
		$scope.allBusiness;
		$scope.userData;
		
		console.log(usr);
		
		dataFactory.getUser(usr).success(function (data) {
			$scope.userData = data;
		});
		
		dataFactory.getAllBusiness().success(function (data) {
			$scope.allBusiness = data;
		});
		
		//console.log($scope.allBusiness);
		console.log($scope.User);
		
		
});

orderysApp.controller('menuController', 
function($scope, $http, dataFactory) {
			
			$scope.currentBusiness;
			$scope.menuItems;
			$scope.order = order;
			
			
			dataFactory.getBusiness(1).success(function (data) {
				$scope.currentBusiness = data;
			});
			
			dataFactory.getProduct($scope.currentBusiness.id).success(function (data) {
				$scope.menuItems = data;
			});
			
			$scope.addToOrder = function(index){
				
				var item = $scope.menuItems[index];
				
				$scope.order.push({
					
					id : item.id,
					name : item.name,
					price : item.productPrice
					
				});
				
			}
			
			$scope.removeFromOrder(index)
			{
				$scope.order.splice(index,1);
			}
			
			console.log($scope.currentBusiness);
			
});

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
			
});

orderysApp.controller('ePageController', 
		function($scope, $http, dataFactory) {
		
});

orderysApp.controller('mPageController', 
		function($scope, $http, dataFactory) {
		
		
});