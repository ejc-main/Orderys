
var usr = document.getElementById("userId").value;

var currB;

var order = {items : []};


orderysApp.controller('navController', 
function($scope, $http, dataFactory) {
	
	$scope.User;
	
	dataFactory.getUser(usr).success(function (data) {
		$scope.User = data;
	});
	
	
	console.log($scope.User);
	
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
		
		$scope.allBusiness = {businessList : []};
		$scope.userData = { user : {} };
		
		console.log(usr);
		
		dataFactory.getUser(usr)
		.then((successResponse) => 
		{ $scope.userData.user = successResponse.data})
		
		dataFactory.getAllBusiness()
		.then((successResponse) => 
		{ $scope.allBusiness.businessList = successResponse.data; })
		
		
		$scope.setB = function(index){
			
			currB = $scope.allBusiness.businessList[index];
		}
        
		console.log($scope.allBusiness);
		console.log($scope.userData);
		
		
});

orderysApp.controller('menuController', 
function($scope, $http, dataFactory) {
			
			$scope.currentBusiness = currB;
			$scope.menu = {menuItems : []}
			
			
			dataFactory.getProduct($scope.currentBusiness.id)
			.then((successResponse) => 
			{ $scope.menu.menuItems = successResponse.data; })
			
			
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