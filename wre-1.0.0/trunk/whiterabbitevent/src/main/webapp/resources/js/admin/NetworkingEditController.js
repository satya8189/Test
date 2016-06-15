var NetworkingEditController = function($scope, $http, $routeParams,$location,ngNotifier) {
	
	alert("NetworkingEditController");
	$scope.networking={};

	$scope.$on('$routeChangeSuccess', function() {
		alert("participateId "+$routeParams.participantId);
		$http.get('admin/participantEdit?participantId='+$routeParams.participantId).success(function(networking) {
			
			$scope.networking=networking;
			alert("hggj-----"+$scope.networking.firstName);
					
				});
	});
        
        
    	$scope.updateNetworking = function(networking) {
    		alert("updateNetworking");
		
		$http.post('participant/update',networking).success(function(status) {
		alert("	participant/update");
			$location.path("/networkingView/"+networking.eventId);
			


					});
		
		
	};
	
};

