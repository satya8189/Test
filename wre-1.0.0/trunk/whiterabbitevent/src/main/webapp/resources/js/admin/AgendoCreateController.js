var AgendoCreateController = function($scope, $http, $location, $routeParams) {
	$scope.agendo = {};

	//saveAgendo(agendo)
	$scope.agendo.eventId=$routeParams.eventId;
	
	$scope.saveAgendo = function(agendo) {
		
		
		
	$http.post('admin/createAgendo',agendo).success(function(success) {
		alert("admin/createAgendo");

	//$location.path("/agendoViewDetails/"+$routeParams.eventId);
	$location.path("/agendoDetails/"+agendo.eventId);
	


				});
	

};

$scope.cancelEvent = function() {
	$location.path("/newsFeedView/");

};

};	


	
	


		

		
		

	
