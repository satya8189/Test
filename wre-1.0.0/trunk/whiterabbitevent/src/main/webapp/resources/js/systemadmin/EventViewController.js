var EventViewController = function($scope,$routeParams,$http, $location) {
	$scope.event={};
	$scope.$on("$routeChangeSuccess", function() {
		$scope.eventId=$routeParams.eventId;
		
		$http.get('admin/Viewdetails?eventId='+$routeParams.eventId).success(function(event) {
			$scope.event=event;
					
				});
	});
			  
		$scope.editDetailsView = function(eventId) {
		//	$scope.eventId=eventId;
			$location.path("/editDetailsView/"+eventId);
		};
		
		$scope.navigateToEventViewDetails= function(event)
		{
			 $scope.event = event;
			 $location.path("/clientEventsView/"+event.clientId);
		};
	
	
		$scope.imageUpload= function(eventId)
		{
			$location.path("/imageUpload/"+eventId);
		};
		
	 };