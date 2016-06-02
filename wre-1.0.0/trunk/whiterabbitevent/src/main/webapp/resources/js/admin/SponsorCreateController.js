var SponsorCreateController = function($scope, $http, $location, $routeParams,ngNotifier) {
	$scope.sponsor={};
			    
		$scope.$on("$routeChangeSuccess", function() {
		
			//alert("navigated...");
				
			$scope.sponsor.eventId=$routeParams.eventId;
		
			//alert("event ID--------"+$routeParams.eventId);
		
	});

		
		
		$scope.saveSponsor= function(sponsor){
			alert("save sponsor");
			
			var fd = new FormData();
			//alert("video");

			  // Take the first selected file
			    fd.append("file", file.files[0]);
			    fd.append("eventId",sponsor.eventId);
			    fd.append("type","sponsor");
			    fd.append("sponcorDesc",sponsor.sponcorDesc);
			    fd.append("sponcorName",sponsor.sponcorName);
			    
			    alert("data--"+fd);
			    $http.post('admin/sponsorSave',fd, {
			     withCredentials : true,
			     headers : {
			      'Content-Type' : undefined
			     },
			     transformRequest : angular.identity
			    }).success(function(data) {
			    	//alert("video success");
			    	ngNotifier.notify("Created  Successfully !");
			    	$location.path("/sponsorPageView/"+sponsor.eventId);
			    }).error(function(data) {
			    // alert("dsfsfds");
			    });
		

	};

			
			

		
		$scope.cancelCreateSponcor= function(eventId){
			$scope.eventId=eventId;
			//alert("getting back to sponsorListVeiw..."+eventId);
			$location.path("/sponsorPageView/"+eventId);
		};

}


	
	

