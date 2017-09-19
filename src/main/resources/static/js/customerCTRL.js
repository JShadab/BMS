
myApp.controller('customerCTRL', function($scope, $http) {

	$scope.loadCustomerData = function() {
		
		$scope.customers=[];
		
		$http.get('/customer').
		  then(function onSuccess(response) {
			  $scope.customers=response.data;
		  }).catch(function onError(response) {
		   console.log(response);
		  });


	};
	
	
/*$scope.updateCust = function(id) {
		
		
		$http.put('/customer/'+id).
		  then(function onSuccess(response) {

			  $window.open(response.data);
		  }).catch(function onError(response) {
		   console.log(response);
		  });


	};*/
	
	
$scope.deleteCust= function(id) {
		
			
		$http.delete('/customer/'+id).
		  then(function onSuccess(response) {
			  $scope.customers=response.data;
		  }).catch(function onError(response) {
		   console.log(response);
		  });


	};
});