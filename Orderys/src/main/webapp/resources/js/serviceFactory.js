orderysApp.factory('dataFactory', ['$http', function ($http) {
	
	  return {
	      getUser: function(result, userId) {
	        return $http.get('user/' + userId);
	      },
	      getAllBusiness: function(result) {
		      return $http.get('business/');
		    },
				getBusiness: function(result, buisnessID) {
					return $http.get('business/' + buisnessID);
				},
				getProducts: function(result, buisnessID) {
					return $http.get('business/' + buisnessID + '/product');
			 	}
	   };
	}]); 