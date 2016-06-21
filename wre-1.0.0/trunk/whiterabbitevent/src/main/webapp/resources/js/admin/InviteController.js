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
		//to check the input contains 10digits along with comma and continues
		//alert(/^(\d{10},)*\d{10}$/.test(invite.phone));
		
		if(invite.phone.length<10)
			{
			ngNotifier.notifyError("must have 10 digits");
			}
		else if(/^(\d{10},)*\d{10}$/.test(invite.phone)){
			//send the nos to db else notify error
			$http.post('admin/invite',invite).success(function(success) {
				ngNotifier.notify("Record Created Successfully !");
			//$location.path("/agendoViewDetails/"+$routeParams.eventId);
			$location.path("/inviteList/"+invite.eventId);
			});
			
		}else{
		ngNotifier.notifyError("Please enter valid input");
		}
		
		
		
/*	$http.post('admin/invite',invite).success(function(success) {
		ngNotifier.notify("Record Created Successfully !");

	//$location.path("/agendoViewDetails/"+$routeParams.eventId);
	$location.path("/inviteList/"+invite.eventId);
					});*/
	};
	
	$scope.inviteList = function(eventId) {
		$location.path("/inviteList/"+eventId);

		};

	$scope.cancelInviteView = function(eventId){
		
		$location.path("/eventViewDetails/"+eventId);
		
	};
		
};	


	
	


		

		
		

	
