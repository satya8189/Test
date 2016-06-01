/**
 * 
 */

var ClientEventViewController = function($scope, $http, $routeParams, $location,filterFilter) {

	$scope.eventList = {};
	$scope.clientId = $routeParams.clientId;
	$scope.filteredSize;
	$scope.$on("$routeChangeSuccess", function() {
		$http.get('systemadmin/eventList?clientId=' + $scope.clientId).success(
				function(eventList) {
					$scope.eventList = eventList;
					
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
					
						$scope.filtered = filterFilter($scope.eventList, newVal);
						$scope.totalItems = $scope.filtered.length;
						$scope.noOfPages = 5;
						$scope.currentPage = 1;
						$scope.filteredSize=$scope.filtered.length;
					}, true);
				});
	});

	$scope.navigateClientEventCreate = function() {
		$location.path('/clientEventsCreate/'+$scope.clientId);
	};
	
	$scope.navigatetoEventEdit = function(eventId){
		$location.path('/clientEventEdit/'+eventId);
	};

	$scope.cancelClientEventView = function() {
		$location.path("/clientsView");
	}
};