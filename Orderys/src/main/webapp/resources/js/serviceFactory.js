orderysApp.factory('dataFactory', ['$http', function ($http) {
	
	  return {
	      getUser: function (userId) {
	        return $http.get('user/' + userId)
	      },
	      getAllBusiness: function () {
		        return $http.get('business/')
		      },
		  getBusiness: function (buisnessID) {
			 	return $http.get('business/' + buisnessID)
		 	},
		  getProduct: function (buisnessID) {
				 	return $http.get('product/' + buisnessID)
			 	},
		  getOrderItemsUser: function (userId) {
				        return $http.get('orderItemByUser/' + userId)
				      },
	   };
	}]); 