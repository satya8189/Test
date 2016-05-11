var EventViewController = function($scope,$routeParams,$http, $location) {
	
	
	$scope.eventList={};
	$scope.filteredSize;
	$scope.$on("$routeChangeSuccess", function () {
	$scope.userId=$routeParams.userId;
	
		
		 $http.get('admin/eventList?userId='+$scope.userId).success(function(eventList){
			
			    $scope.eventList = eventList;
			    
			 // create empty search model (object) to trigger $watch on update
				$scope.search =null;

				$scope.resetFilters = function () {
					// needs to be a function or it won't trigger a $watch
					$scope.search =null;
				};

				// pagination controls
				$scope.currentPage = 1;
				$scope.totalItems = $scope.eventList.length;
				$scope.entryLimit = 8; // items per page
				$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

				// $watch search to update pagination
				$scope.$watch('search', function (newVal, oldVal) {
					$scope.filtered = filterFilter($scope.orgList, newVal);
					$scope.totalItems = $scope.filtered.length;
					$scope.noOfPages = 5;
					$scope.currentPage = 1;
					$scope.filteredSize=$scope.filtered.length;
				}, true);
			    
			    
			    
			  	});
			 });
	
	$scope.eventViewDetails = function(eventId){
		location.href="#/eventViewDetails/"+eventId;
	};
	
	 };