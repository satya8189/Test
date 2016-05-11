var AgendoViewController = function($scope,$routeParams,$http,$location) {
	$scope.agendoList = {};
	$scope.eventId={};
	
	$scope.$on("$routeChangeSuccess", function () {
		
		$scope.eventId=$routeParams.eventId;
			
		 $http.get('admin/agendoDetails?eventId='+$routeParams.eventId).success(function(agendoList){
			 alert("agendoDetailsAgendoViewController");
				
				    $scope.agendoList = agendoList;
				    alert("size--"+agendoList.length);
			
				    
				  	});
				 });
	
	
	
	$scope.navigateagendoCreate = function(eventId) {
		alert("hi--------"+eventId);
		$location.path("/agendoCreate/"+eventId);

	};
	
	$scope.agendoEdit = function(agenId){
		
		location.href="#/agendoEdit/"+agenId;
	};
	
	
	
};