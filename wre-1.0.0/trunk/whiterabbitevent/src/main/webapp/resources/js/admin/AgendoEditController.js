var AgendoEditController = function($scope, $http, $routeParams,$location,ngNotifier) {
	$scope.agendo={};

	$scope.$on('$routeChangeSuccess', function() {
		$http.get('admin/agendoEditDetails?agenId='+$routeParams.agenId).success(function(agendo) {
			$scope.agendo=agendo;
					
				});
	});
        
        
    	$scope.updateAgendo = function(agendo) {
		
		$http.post('agendo/update',agendo).success(function(status) {
			
			$location.path("/agendoDetails/"+agendo.eventId);
			ngNotifier.notify("Agenda Updated Successfully.!");
					});
			};
        
		$scope.cancelAgendaEdit = function(eventId){
			$location.path("/agendoDetails/"+eventId);
			
		};

};

