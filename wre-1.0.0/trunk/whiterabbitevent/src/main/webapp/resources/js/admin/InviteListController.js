var InviteListController = function($scope,$routeParams,$http, $location) {
	$scope.inviteList = {};
	alert("adfsaf");
		
		
		$scope.$on("$routeChangeSuccess", function () {
			
			$scope.eventId=$routeParams.eventId;
			alert("hi--------"+$routeParams.eventId);
			
			
				
		  $http.get('admin/inviteDetails?eventId='+$routeParams.eventId).success(function(inviteList){
			  alert("admin/inviteDetails");
			 
				
			    $scope.inviteList = inviteList;
		
		 });
		  
		
	});
		
		
		
		
		
	};
