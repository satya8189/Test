/**
 * 
 */
 var ClientEventEditController = function($scope,$routeParams,$http,$location,ngNotifier){
	 $scope.servicesList = {};
	 $scope.array = [];
	 $scope.eventId =$routeParams.eventId; 
	$scope.$on('$routeChangeSuccess', function() {
		
	 $http.get('systemadmin/servicesList').success(function(servicesList){
			$scope.servicesList = servicesList ;

		});
	 
	 $http.get('systemadmin/editEvent?eventId='+$routeParams.eventId).success(function(event) {
		   $scope.event=event;
		 
		   
		    });
	 
	 $scope.updateEvent = function(event){
	 $http.post('systemadmin/updateEvent',event).success(function(){
		 $scope.event = event;
		 ngNotifier.notify("ClientEvent Updated Successfully !");
		 $location.path("/clientEventsView/"+event.clientId);
		 
	}).error(function(){
		ngNotifier.notify("ClientEvent Not Updated Successfully !");
	});
	 
	 
	 }
	 
	 $scope.cancelClientEventEdit = function(event){
		 $scope.event = event;
		 $location.path("/clientEventsView/"+event.clientId);
	 }
 });
	 
 }