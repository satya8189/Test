/**
 * 
 */
 var ClientEventEditController = function($scope,$routeParams,$http,$location,ngNotifier){
	 $scope.servicesList = {};
	 $scope.eventId =$routeParams.eventId; 
	$scope.$on('$routeChangeSuccess', function() {
		
	 $http.get('systemadmin/servicesList').success(function(servicesList){
		 	alert("servicesList");
			$scope.servicesList = servicesList ;
		});
	 
	 $http.get('systemadmin/editEvent?eventId='+$routeParams.eventId).success(function(event) {
		   $scope.event=event;
		     
		    });
	 
	 $scope.updateEvent = function(event){
	 $http.post('systemadmin/updateEvent',event).success(function(){
		 $scope.event = event;
		 alert("client"+event.clientId);
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