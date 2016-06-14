var CreateSocialMediaController=function($scope,$routeParams,$location,$http,ngNotifier){
	
	$scope.sm={};

	$scope.$on("$routeChangeSuccess", function () {
		$scope.sm.eventId=$routeParams.eventId;
		//alert("createsocialmedia...."+$scope.sm.eventId);
	});
	
	
	//alert("working CreateSocialMediaController"+$routeParams.eventId);
	$scope.cancelCreateSocialMedia=  function(eventId){
		//alert("getting back.."+eventId);
		$location.path("/SocialMedia/"+eventId);
	};
	
	
	
	$scope.saveSocialMedia= function(socialMedia){
		//alert("saveSocialMedia.."+socialMedia.eventId);
		$http.post('admin/saveSocialMedia',socialMedia).success(function(){
			//alert("saved..");
			ngNotifier.notify("SocialMedia saved Successfully.!");
			$location.path("/SocialMedia/"+socialMedia.eventId);
		});
	};
};