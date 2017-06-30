orderysApp.factory('dataFactory', function($http) {
	
    //var url = '../example-data.json'
    var result = '../example-data.json';
    
    var factory = result;
    
    factory.getData =  function(callback) {
           // $http.get(url).then(callback);
            return result;
    };
    
    return factory;
    
});