var EditDetailsViewController = function($scope, $http, $location, $routeParams) {
	
	$scope.event={};

			    
		$scope.$on("$routeChangeSuccess", function() {
		
		$http.get('admin/Viewdetails?eventId='+$routeParams.eventId).success(function(event) {
			$scope.event=event;
					
				});
	});
		
		$scope.updateEvent = function(event) {
			
			
			$http.post('details/update',event).success(function(status) {
				
				
		
			
				location.href="#/detailsView/"+event.eventId;
				
				


						});
			

		};
	      
	  

};
