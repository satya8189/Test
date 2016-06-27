var EventViewController = function($scope,$routeParams,$http, $location) {
	$scope.event={};
	$scope.$on("$routeChangeSuccess", function() {
		$scope.eventId=$routeParams.eventId;
		var type='web';
		$http.get('admin/Viewdetails?eventId='+$routeParams.eventId+'&type='+type).success(function(event) {
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