var AgendoCreateController = function($scope, $http, $location, $routeParams) {
	
		$scope.agendo = {};
		$scope.agendo.eventId=$routeParams.eventId;
		
		alert("huuu");
		$scope.saveAgendo = function(agendo,userId) {
			alert("hi)----"+userId);
			$scope.agendo=agendo;
			$scope.agendo.userId=userId;
			alert("sdf");
		
		$http.post('admin/createAgendo',$scope.agendo).success(function(status) {
			alert("jjj");
		$location.path("/agendoDetails/"+$routeParams.eventId);


					});
		

	};

	$scope.cancelEvent = function() {
		$location.path("/agendoViewDetails");

	};

	};	



		

		
		

	
