var ClientsViewController = function($scope, $http,filterFilter,$location) {
	
	
	$scope.clientList={};
	$scope.filteredSize;
	$scope.$on('$routeChangeSuccess', function() {
	
	$http.get('systemadmin/clientList').success(function(clientList){
	    $scope.clientList = clientList;
	    
	 // create empty search model (object) to trigger $watch on update
		$scope.search =null;

		$scope.resetFilters = function () {
			// needs to be a function or it won't trigger a $watch
			$scope.search =null;
		};

		// pagination controls
		$scope.currentPage = 1;
		$scope.totalItems = $scope.clientList.length;
		$scope.entryLimit = 8; // items per page
		$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

		// $watch search to update pagination
		$scope.$watch('search', function (newVal, oldVal) {
		
			$scope.filtered = filterFilter($scope.clientList, newVal);
			$scope.totalItems = $scope.filtered.length;
			$scope.noOfPages = 5;
			$scope.currentPage = 1;
			$scope.filteredSize=$scope.filtered.length;
		}, true);
	  	});
	});
	
	

	
	
	
	$scope.navigateToEventView=function(clientId){
		$location.path('/clientEventsView/'+ clientId);
	};
	
 };