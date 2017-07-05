
// var usr = document.getElementById("userId").value;

// var currB;

// var order = {items : []};


orderysApp.controller('navController', function($scope, $rootScope, $http, dataFactory) {
	$scope.User = {};

	dataFactory.getCurrentUser().then(function(res) {
		$rootScope.User = res.data;
		$scope.User = $rootScope.User;
		if ($rootScope.User.role === "MANAGER") {
			dataFactory.getManagedBusiness($rootScope.User.id).then(function(res) {
				if (res.data.name) {
					$rootScope.managedBusiness = res.data;
					$scope.managedBusiness = $rootScope.managedBusiness;
					dataFactory.getStations($rootScope.managedBusiness.id).then(function(res) {
						$rootScope.managedBusiness.stations = res.data;
					});
					dataFactory.getProducts($rootScope.managedBusiness.id).then(function(res) {
						$rootScope.managedBusiness.menu = res.data; // this might be wrong
					});
					dataFactory.getEmployees($rootScope.managedBusiness.id).then(function(res) {
						$rootScope.managedBusiness.employees = res.data;
					});
				}
			})
		}
	});
	
	// dataFactory.getUser(usr).success(function (data) {
	// 	$rootScope.user = data;
	// 	$rootScope.user = data;
	// 	console.log(data);
	// });
	
	
	console.log($rootScope.User);
	
	$scope.isManager = function() {
	   
		if($rootScope.User === undefined)
		{
			return false;
		}
		
		var role = $rootScope.User.role;
		
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
		
		if($rootScope.User === undefined)
		{
			return false;
		}
		
		var role = $rootScope.User.role;
		
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
		
		if($rootScope.User === undefined)
		{
			return false;
		}
		
		var role = $rootScope.User.role;
		
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

orderysApp.controller('cHomeController', function($scope, $rootScope, $http, dataFactory) {
		
		$scope.allBusiness = {businessList : []};
		$scope.userData = { user : {} };
		
		// console.log(usr);
		
		// dataFactory.getUser(usr)
		// .then((successResponse) => 
		// { $scope.userData.user = successResponse.data})
		
		dataFactory.getAllBusinesses()
		.then((successResponse) => 
		{ $scope.allBusiness.businessList = successResponse.data; })
		
		
		$scope.setB = function(index){
			
			currB = $scope.allBusiness.businessList[index];
		}
        
		console.log($scope.allBusiness);
		console.log($scope.userData);
		
		
});

orderysApp.controller('menuController', function($scope, $rootScope, $route, $routeParams, $http, dataFactory) {
			
			$scope.business = {};
			$scope.stations = {};
			$scope.menu = [];
			
			
			dataFactory.getBusiness($routeParams.businessId).then(function(res) {
				$scope.business = res.data;
				dataFactory.getStations($routeParams.businessId).then(function(res) {
					$scope.stations = res.data;
				});
				dataFactory.getProducts($routeParams.businessId).then(function(res) {
					$scope.menu = res.data; // this might be wrong
				});
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
			
});

orderysApp.controller('profileController', function($scope, $rootScope, $http, dataFactory) {
			
			$scope.User;
			
			// dataFactory.getUser(usr).success(function (data) {
			// 	$scope.User = data;
			// });
			
			
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

orderysApp.controller('ePageController', function($scope, $rootScope, $http, dataFactory) {
		
});

orderysApp.controller('mPageController', function($scope, $rootScope, $http, dataFactory) {

		$scope.submitMenuItem = function() {
			
			dataFactory.addProduct($rootScope.managedBusiness.id, newProduct).then(function(res) {
				$rootScope.managedBusiness.menu.push(res.data);
			});
		};
		$scope.submitStation = function() {
			$scope.newStation.business = $rootScope.managedBusiness;
			dataFactory.addStation($rootScope.managedBusiness.id, newStation).then(function(res) {
				$rootScope.managedBusiness.stations.push(res.data);
			});
		};
		$scope.offerJob = function() {
			dataFactory.addEmployee($rootScope.managedBusiness.id, newHire).then(function(res) {
				$rootScope.managedBusiness.employees.push(res.data);
			});
		};
		
});