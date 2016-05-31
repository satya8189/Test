var AgendoViewController = function($scope,$routeParams,$http,$location) {
	$scope.agendoList = {};
	$scope.eventId={};
	
	$scope.$on("$routeChangeSuccess", function () {
		
		$scope.eventId=$routeParams.eventId;
			
		 $http.get('admin/agendoDetails?eventId='+$routeParams.eventId).success(function(agendoList){
				    $scope.agendoList = agendoList;
			
				  //=================================
					// create empty search model (object) to trigger $watch on update
						$scope.search = null;

						/*$scope.resetFilters = function () {
						// needs to be a function or it won't trigger a $watch
						$scope.search = {};
						};*/

						// 	pagination controls
						$scope.currentPage = 1;
						$scope.totalItems = $scope.agendoList.length;
						$scope.entryLimit = 5; // items per page
						$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

						// $watch search to update pagination
						$scope.$watch('search', function (newVal, oldVal) {
						$scope.filtered = filterFilter($scope.agendoList, newVal);
						$scope.totalItems = $scope.filtered.length;
						$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);
						$scope.currentPage = 1;
						}, true);
				    //===================================*/
				    
				  	});
				 });
	
	
	
	$scope.navigateagendoCreate = function(eventId) {
		
		$location.path("/agendoCreate/"+eventId);

	};
	
	$scope.agendoEdit = function(agenId){
		
		location.href="#/agendoEdit/"+agenId;
	};
	
	$scope.cancelAgendoView = function(eventId)
	{
		//alert("getting back to eventViewDetails");
		$location.path("/eventViewDetails/"+eventId);
	};
	
	
};