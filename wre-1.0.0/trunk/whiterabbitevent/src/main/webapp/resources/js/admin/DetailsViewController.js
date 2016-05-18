var DetailsViewController = function($scope, $http, $location, $routeParams) {
	$scope.event={};
	
			    
		$scope.$on("$routeChangeSuccess", function() {
		$scope.eventId=$routeParams.eventId;
		alert("jooo--------"+$routeParams.eventId);
		$http.get('admin/Viewdetails?eventId='+$routeParams.eventId).success(function(event) {
			$scope.event=event;
					
				});
	});
		
				    
			  
		$scope.editDetailsView = function(eventId) {
			
			$location.path("/editDetailsView/"+eventId);

		};
	
	
	
	
};