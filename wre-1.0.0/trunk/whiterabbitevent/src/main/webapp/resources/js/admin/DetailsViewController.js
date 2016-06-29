var DetailsViewController = function($scope, $http, $location, $routeParams) {
	$scope.event={};
	$scope.eventId=$routeParams.eventId;
	//alert("eventId"+$scope.eventId);
	
	$scope.$on("$routeChangeSuccess", function() {
	
		/*$http.get('admin/Viewdetails?eventId='+$routeParams.eventId).success(function(event) {
			$scope.event=event;
				alert("data.."+event.eventName);	
				});*/
		$http.get('admin/Viewdetails?eventId='+$routeParams.eventId+'&&type='+"web").success(function(event) {
			$scope.event=event;
				//alert("data.."+event.eventName);	
				});
	});
			  
		$scope.editDetailsView = function(eventId) {
		//	$scope.eventId=eventId;
			//alert("editDetailsView..eventId"+eventId);
			$location.path("/editDetailsView/"+eventId);
		};
		
		$scope.navigateToEventViewDetails= function(eventId)
		{
			$location.path("/eventViewDetails/"+eventId);
		};
	
	
	
};