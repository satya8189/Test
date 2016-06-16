var NetworkingEditController = function($scope, $http, $routeParams,$location,ngNotifier) {
	$scope.eventId={};
	$scope.networking={};
	$scope.$on('$routeChangeSuccess', function() {
		$http.get('admin/participantEdit?participantId='+$routeParams.participantId+'&&eventId='+$routeParams.eventId).success(function(networking) {
			$scope.networking=networking;
			$scope.eventId=$routeParams.eventId;
			//alert("eventId.."+eventId);
			
			

				});
	});
        
        
    	$scope.updateNetworking = function(networking) {
		
		$http.post('participant/update',networking).success(function() {
		//alert("participant/update");
			$location.path("/networkingView/"+$routeParams.eventId);
			ngNotifier.notify("Updated successfully.!");
					});
		};
		
		//get back..cancelNetworkingEdit
		$scope.cancelNetworkingEdit= function(eventId){
			//alert("getting back.."+eventId);
			$location.path("/networkingView/"+eventId);
		} ;
	
};

