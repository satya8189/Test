/**
 * 
 */
var ClientEventCreateController = function($scope, $http, $routeParams,$location,ngNotifier) {
	
	
	$scope.usersList = {};
	$scope.servicesList = {};
	$scope.event ={};
	$scope.event.clientId=$routeParams.clientId;
	
	$scope.$on('$routeChangeSuccess', function() {
	$http.get('systemadmin/getUsersList?clientId='+$routeParams.clientId).success(function(usersList){
        $scope.usersList = usersList;
    });
	
	$http.get('systemadmin/servicesList').success(function(servicesList){
		$scope.servicesList = servicesList ;
	});
	
	});
	
	
	$scope.saveEvent = function(event){
		$http.post('systemadmin/saveEvent',event).success(function(event){
			ngNotifier.notify("Event Created Successfully !");
			$location.path("/clientEventsView/"+event.clientId);
			
		}).error(function() {
			alert("sdfsdf");
			ngNotifier.notify("Event not Created Successfully !");
		});
	};
	
	$scope.cancelClientEvent = function(){
		$location.path("/clientEventsView/"+$routeParams.clientId);
	}
	
};

