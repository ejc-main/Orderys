
// var usr = document.getElementById("userId").value;

// var currB;

// var order = {items : []};


orderysApp.controller('navController', function($scope, $http, dataFactory) {
	$scope.User;

	dataFactory.getCurrentUser().then(function(res) {
		$scope.User = res.data;
		if ($scope.User.role === "MANAGER") {
			dataFactory.getManagedBusiness($scope.User.id).then(function(res) {
				if (res.data.name) {
					$scope.managedBusiness = res.data;
					dataFactory.getStations($scope.managedBusiness.id).then(function(res) {
						$scope.managedBusiness.stations = res.data;
					});
					dataFactory.getProducts($scope.managedBusiness.id).then(function(res) {
						$scope.managedBusiness.menu = res.data; // this might be wrong
					});
					dataFactory.getEmployees($scope.managedBusiness.id).then(function(res) {
						$scope.managedBusiness.employees = res.data;
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

orderysApp.controller('cHomeController', function($scope, $http, dataFactory) {
	$scope.User;
	$scope.allBusiness;

	dataFactory.getCurrentUser().then(function(res) {
		$scope.User = res.data;
	});
	dataFactory.getAllBusinesses().then(function(res) {
		$scope.allBusiness = res.data;
	});
		
		
		
		// console.log(usr);
		
		// dataFactory.getUser(usr)
		// .then((successResponse) => 
		// { $scope.userData.user = successResponse.data})
		
		dataFactory.getAllBusinesses().then(function(res) {
			$scope.allBusiness.businessList = res.data;
		});
		
});

orderysApp.controller('menuController', function($scope, $route, $routeParams, $http, dataFactory) {
	$scope.User;
	
	dataFactory.getCurrentUser().then(function(res) {
		$scope.User = res.data;
	});
			
			$scope.order = {
				paymentMethod : null,
				orderItems: []
			};
			
			
			dataFactory.getBusiness($routeParams.businessId).then(function(res) {
				$scope.business = res.data;
				dataFactory.getProducts($routeParams.businessId).then(function(res) {
					$scope.business.menu = res.data; // this might be wrong
				});
			});
			
			
			// $scope.addToOrder = function(index){
				
			// 	var item = $scope.menuItems[index];
				
			// 	$scope.order.push({
					
			// 		id : item.id,
			// 		name : item.name,
			// 		price : item.productPrice
					
			// 	});
				
			// }
			
			// $scope.removeFromOrder(index)
			// {
			// 	$scope.order.splice(index,1);
			// }
			
});

orderysApp.controller('profileController', function($scope, $http, dataFactory) {
	$scope.User = {};
	$scope.newBusiness = {
		name: null,
		streetAddress1: null,
		streetAddress2: null,
		city: null,
		state: null,
		country: null,
		zip: null
	};
	
	dataFactory.getCurrentUser().then(function(res) {
		$scope.User = res.data;
	});
			
	$scope.createBusiness = function() {
		dataFactory.addBusiness($scope.newBusiness).then(function(res) {
			console.log(res.data);
		});
	}

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

orderysApp.controller('ePageController', function($scope, $http, dataFactory) {
	$scope.User;

	dataFactory.getCurrentUser().then(function(res) {
		$scope.User = res.data;
		
	});
		
});

orderysApp.controller('mPageController', function($scope, $http, dataFactory) {
	$scope.User = {};
	$scope.managedBusiness = {};

	dataFactory.getCurrentUser().then(function(res) {
		$scope.User = res.data;
		if ($scope.User.role === "MANAGER") {
			dataFactory.getManagedBusiness($scope.User.id).then(function(res) {
				if (res.data.name) {
					$scope.managedBusiness = res.data;
					$scope.managedBusiness = $scope.managedBusiness;
					dataFactory.getStations($scope.managedBusiness.id).then(function(res) {
						$scope.managedBusiness.stations = res.data;
					});
					dataFactory.getProducts($scope.managedBusiness.id).then(function(res) {
						$scope.managedBusiness.menu = res.data; // this might be wrong
					});
					dataFactory.getEmployees($scope.managedBusiness.id).then(function(res) {
						$scope.managedBusiness.employees = res.data;
					});
				}
			});
		}
	});

		$scope.submitMenuItem = function() {
			// console.log(newProduct);
			dataFactory.addProduct($scope.managedBusiness.id, $scope.newProduct).then(function(res) {
				$scope.managedBusiness.menu.push(res.data);
			});
		};
		$scope.submitStation = function() {
			$scope.newStation.business = $scope.managedBusiness;
			dataFactory.addStation($scope.managedBusiness.id, $scope.newStation).then(function(res) {
				$scope.managedBusiness.stations.push(res.data);
			});
		};
		$scope.offerJob = function() {
			dataFactory.addEmployee($scope.managedBusiness.id, $scope.newHire).then(function(res) {
				$scope.managedBusiness.employees.push(res.data);
			});
		};
		
});