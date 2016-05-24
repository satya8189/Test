var AgendoViewController = function($scope,$routeParams,$http,$location) {
	$scope.agendoList = {};
	$scope.eventId={};
	
	$scope.$on("$routeChangeSuccess", function () {
		
		$scope.eventId=$routeParams.eventId;
			
		 $http.get('admin/agendoDetails?eventId='+$routeParams.eventId).success(function(agendoList){
			
				
				    $scope.agendoList = agendoList;
				    // create empty search model (object) to trigger $watch on update
					$scope.search =null;
			
				    
				  	});
				 });
	
	
	
	$scope.navigateagendoCreate = function(eventId) {
		
		$location.path("/agendoCreate/"+eventId);

	};
	
	$scope.agendoEdit = function(agenId){
		
		location.href="#/agendoEdit/"+agenId;
	};
	
	$scope.cancelAgendoView = function(eventId)
	{
		//alert("getting back to eventViewDetails");
		$location.path("/eventViewDetails/"+eventId);
	};
	
	
};