orderysApp.factory('dataFactory', ['$http', function ($http) {
	
	  return {
	      getUser: function(result, userId) {
	        return $http.get('user/' + userId);
	      },
<<<<<<< HEAD
	      getAllBusiness: function () {
		        return $http.get('business/')
		      },
		  getProduct: function (buisnessID) {
				 	return $http.get('business/' + buisnessID + '/product')
=======
	      getAllBusiness: function(result) {
		      return $http.get('business/');
		    },
				getBusiness: function(result, buisnessID) {
					return $http.get('business/' + buisnessID);
				},
				getProducts: function(result, buisnessID) {
					return $http.get('business/' + buisnessID + '/product');
>>>>>>> cca60e70ffd98ceda84d33d222e877b8736eca08
			 	}
	   };
	}]); 