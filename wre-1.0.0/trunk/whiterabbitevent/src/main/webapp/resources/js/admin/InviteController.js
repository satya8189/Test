var InviteController = function($scope, $http, $location, $routeParams,ngNotifier) {
	
	$scope.invite={};
	$scope.event={};
	$scope.invite.eventId=$routeParams.eventId;
	
	$scope.$on("$routeChangeSuccess", function() {
	
	$http.get('admin/Viewdetails?eventId='+$routeParams.eventId).success(function(event) {
		$scope.event=event;
				
			});
});
	
	$scope.saveInvite = function(invite) {
	$http.post('admin/invite',invite).success(function(success) {
		ngNotifier.notify("Record Created Successfully !");

	//$location.path("/agendoViewDetails/"+$routeParams.eventId);
	$location.path("/inviteList/"+invite.eventId);
	


				});
	};
	
	$scope.inviteList = function(eventId) {
		$location.path("/inviteList/"+eventId);

		};

	$scope.cancelInviteView = function(eventId){
		alert("cancelInviteView---"+eventId);
		
	};
		
};	


	
	


		

		
		

	
