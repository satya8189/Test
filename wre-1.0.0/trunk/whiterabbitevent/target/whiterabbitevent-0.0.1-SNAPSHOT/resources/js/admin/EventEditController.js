var EventEditController = function($scope, $http, $routeParams, stringService,$location,ngNotifier) {
	
	$scope.$on("$routeChangeSuccess", function() {
		$scope.eventId=$routeParams.eventId;
		$http.get('admin/eventdetails?eventId='+$scope.eventId).success(function(event){
			
		$scope.updateEvent = function(event,isValid,eventId) {
		if(isValid){
		$scope.eventList = {};
			
		$http.get('admin/eventDuplivateCheckWithId?eventName='+event.eventName+"&eventId="+event.eventId).success(function(flag) {
			if(flag){
	            ngNotifier.notify("Event name already availble!");
	           }
			else{
				$scope.event.event=eventId;
				$http.post('event/update', $scope.event).success(function() {
				$scope.event={};
		        ngNotifier.notify("Event details updated successfully .");
		        $location.path("/eventView");
		        
			}).error(function() {
				ngNotifier.notifyError("Event details not updated !");
			});
			};
					});
	};
	
	};
		});
	});
};
	
	
	
	
	



	