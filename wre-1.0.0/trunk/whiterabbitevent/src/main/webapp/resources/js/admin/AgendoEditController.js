var AgendoEditController = function($scope, $http, $routeParams,$location) {
	$scope.agendo={};

	$scope.$on('$routeChangeSuccess', function() {
		$http.get('admin/agendoEditDetails?agenId='+$routeParams.agenId).success(function(agendo) {
					alert('success');
				});
	});
        
        
    	$scope.updateAgendo = function(agendo) {
			alert("kkk");
		$http.post('agendo/update',agendo).success(function(status) {
			alert("adfasf");
			$location.path("/agendoDetails/"+agendo.eventId);
			alert("agendoDetails");


					});
		

	};
        

};

