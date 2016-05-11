var EventViewDetailsController = function($scope,$routeParams,$http,$location) {
	$scope.eventList = {};

	$scope.$on("$routeChangeSuccess", function () {
		$scope.eventId=$routeParams.eventId;
		
			
			 $http.get('admin/eventdetailsList?eventId='+$scope.eventId).success(function(eventList){
				
				    $scope.eventList = eventList;
				   
				    });
				 });

	$scope.serviceDetails = function(event){
		if(event.serviceId=="2"){
	location.href="#/agendoDetails/"+event.eventId;
		}
		else if(event.serviceId=="3"){
			location.href="#/newsFeedView/"+event.eventId;	
			
		}
			
		
	};
	
	
};