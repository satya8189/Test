var SponsorCreateController = function($scope, $http, $location, $routeParams,ngNotifier) {
			    
		$scope.$on("$routeChangeSuccess", function() {
		
			//alert("navigated...");
				
			$scope.eventId=$routeParams.eventId;
		
			//alert("event ID--------"+$routeParams.eventId);
		
	});

		
		$scope.saveSponsor= function(sponsor){
			//$scope.userId=userId;
			$scope.sponsor.eventId=$routeParams.eventId;
			
			//alert("sponsordata===="+sponsor.eventId+"=="+sponsor.sponcorName+"==="+sponsor.sponcorDesc);
			
			$http.post('admin/sponsorSave',sponsor).success(function() {
					
				}).success(function() {
					$location.path("/sponsorPageView/"+sponsor.eventId);
						ngNotifier.notify("sponsor saved successfully....!");
			}).error(function() {
				alert("error in ading sponsor");
			});
		};
		
		$scope.cancelCreateSponcor= function(eventId){
			$scope.eventId=eventId;
			//alert("getting back to sponsorListVeiw..."+eventId);
			$location.path("/sponsorPageView/"+eventId);
		};

};	


	
	

