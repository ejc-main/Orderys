orderysApp.factory('dataFactory', ['$http', function ($http) {
	
	  return {
	      getUser: function(userId) {
	        return $http.get('user/' + userId);
	      },
				updateAccount: function(userId, updates) {
					return $http.post('user/' + userId, updates);
				},
				getOrders: function(userId) {
					return $http.get('user/' + userId + '/order');
				},
				placeOrder: function(userId, order) {
					return $http.post('user/' + userId + '/order', order);
				},
				cancelOrder: function(userId, orderId, cancelling) {
					return $http.post('user/' + userId + '/order/' + orderId, cancelling);
				},
	      getAllBusinesses: function() {
		      return $http.get('business');
		    },
				addBusiness: function(business) {
					return $http.post('business', business);
				},
				getBusiness: function(buisnessID) {
					return $http.get('business/' + buisnessID);
				},
				getStations: function(businessId) {
					return $http.get('business/' + businessId + '/station');
				},
				addStation: function(businessId, station) {
					return $http.post('business/' + businessId + '/station', station);
				},
				getActiveOrderItems: function(businessId) {
					return $http.get('business/' + businessId + '/orderItem');
				},
				getProducts: function(buisnessID) {
					return $http.get('business/' + buisnessID + '/product');
			 	},
				addProduct: function(businessId, product) {
					return $http.post('business/' + businessId + '/product', product);
				},
				updateProduct: function(businessId, productId, updates) {
					return $http.post('business/' + businessId + '/product/' + productId, updates)
				},
				getEmployees: function(businessId) {
					return $http.get('business/' + businessId + '/employee');
				},
				addEmployee: function(businessId, emailForm) {
					return $http.post('business/' + businessId + '/employee', {}, { params: emailForm });
				},
				getCompletedOrderItems: function(businessId, employeeId) {
					return $http.get('business/' + businessId + '/employee/' + employeeId + '/orderItem');
				},
				completeOrderItem: function(businessId, employeeId, orderItem) {
					return $http.post('business/' + businessId + '/employee/' + employeeId + '/orderItem', orderItem);
				}
	   };
	}]); 