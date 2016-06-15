var NetworkingViewController = function($scope,$http,$routeParams,$location) {
   $scope.eventId={};
	$scope.eventList={};
	$scope.$on("$routeChangeSuccess", function () {
		
		$scope.eventId=$routeParams.eventId;
		alert("eventId-----------"+$routeParams.eventId);
			
		 $http.get('admin/ParticipantEventBeanList?eventId='+$routeParams.eventId+'&status=ACTIVE').success(function(eventList){
			alert(eventList.length);	   
			 $scope.eventList = eventList;
				  	});
				 });
	
	//networkingEdit

        $scope.networkingEdit = function(participantId){
        	alert("sdf"+participantId);
			
			location.href="#/networkingEdit/"+participantId;
		};
		
		
		
};


