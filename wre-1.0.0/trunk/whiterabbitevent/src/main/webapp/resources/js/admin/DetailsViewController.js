var DetailsViewController = function($scope, $http, $location, $routeParams) {
	$scope.event={};

	$scope.$on("$routeChangeSuccess", function() {
		$scope.eventId=$routeParams.eventId;
		//alert("data"+$scope.eventId);
		
		$http.get('admin/Viewdetails?eventId='+$routeParams.eventId).success(function(event) {
			$scope.event=event;
					
				});
	});
			  
		$scope.editDetailsView = function(eventId) {
		//	$scope.eventId=eventId;
			$location.path("/editDetailsView/"+eventId);
		};
		
		$scope.navigateToEventViewDetails= function(eventId)
		{
			$location.path("/eventViewDetails/"+eventId);
		};
	
	
	
};