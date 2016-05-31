var SponsorEditController=function($scope, $http, $location, $routeParams,ngNotifier){
	
$scope.$on("$routeChangeSuccess", function() {
	$scope.sponsorId=$routeParams.sponcorId;
	
	//alert("navigated to SponsorEditCtrl.."+$scope.sponsorId);
	
	$http.get('admin/getSponsorDataonSponsorId?sponcorId='+$routeParams.sponcorId).success(function(sponcor) {
		//alert("getting data for sponcor edit");
		$scope.eventId=sponcor.eventId;
		$scope.sponcor=sponcor;
		//alert("sponcor edit data=="+sponcor.sponcorId+"--"+sponcor.sponcorName+"--"+sponcor.eventId+"--"+sponcor.sponcorDesc);		
			
			});
		});

	$scope.cancelSponsorEdtit= function(eventId){
		//alert("getting back to sponcor page view--"+eventId);
		$location.path("/sponsorPageView/"+eventId);
		
	};
	
	
	/*updateSponsor(sponcor)*/
	$scope.updateSponsor = function(sponcor){
		//alert("update sponsordata===="+sponcor.eventId+"=="+sponcor.sponcorId+"=="+sponcor.sponcorName+"==="+sponcor.sponcorDesc);
		
		$http.post('admin/updateSponsor',sponcor).success(function() {
				//alert("sponsor updated successfully....!");
				$location.path("/sponsorPageView/"+sponcor.eventId);
				/*			}).success(function() {*/
					ngNotifier.notify("Sponsor updated successfully.!");
			}).error(function() {
				ngNotifier.error("error in updating sponsor.!");
		});
			
	};

};