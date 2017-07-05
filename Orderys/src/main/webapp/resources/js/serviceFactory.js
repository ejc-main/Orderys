orderysApp.factory('dataFactory', ['$http', function ($http) {
	
	  return {
	      getUser: function (userId) {
	        return $http.get('user/' + userId)
	      },
	      getAllBusiness: function () {
		        return $http.get('business/')
		      },
		  getProduct: function (buisnessID) {
				 	return $http.get('business/' + buisnessID + '/product')
			 	}
	   };
	}]); 