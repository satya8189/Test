var AgendoCreateController = function($scope, $http, $location, $routeParams,ngNotifier) {
	$scope.agendo = {};

	//saveAgendo(agendo)
	$scope.agendo.eventId=$routeParams.eventId;
	
	$scope.saveAgendo = function(agendo) {
		
		
		
	$http.post('admin/createAgendo',agendo).success(function(success) {
				ngNotifier.notify("Record Created Successfully !");
	$location.path("/agendoDetails/"+agendo.eventId);
	
					});
	
};

  $scope.cancelAgendoView = function() {
   $location.path("/agendoDetails/"+agendo.eventId);
	};
	

	$scope.cancelCreateAgenda = function(eventId){
		
		$location.path("/agendoDetails/"+eventId);
	};

	
};	


	
	


		

		
		

	
