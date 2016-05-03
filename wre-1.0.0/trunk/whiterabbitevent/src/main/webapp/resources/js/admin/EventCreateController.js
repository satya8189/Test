var EventCreateController = function($scope, $http, $location) {
	$scope.event = {};
	
	$scope.$on('$routeChangeSuccess', function() {
		
		
	$scope.saveEvent = function(event, eventId) {
		$scope.event.eventId=eventId;
		
				$http.post('admin/eventsave', event).success(function(eventId) {
					
				
					
				
				
		});
	};
	
	});
	
	};
					



	

	
	
