orderysApp.factory('dataFactory', ['$http', function ($http) {
	
	  return {
	      getUser: function (userId) {
	        return $http.get('user/' + userId)
	      }
	   };
	}]); 