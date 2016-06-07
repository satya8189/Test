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
		//alert("dfdsf");
		 var fd = new FormData();
			//alert("video");

			  // Take the first selected file
			    fd.append("file", file.files[0]);
			   

			    fd.append("eventId",sponcor.eventId);
			    fd.append("sponcorId",sponcor.sponcorId);
			    fd.append("type","sponcor");
			    fd.append("sponcorName",sponcor.sponcorName);
			    fd.append("sponcorDesc",sponcor.sponcorDesc);
			    
			    
			    //alert("data--"+fd);
			    $http.post('admin/updateSponsor',fd, {
			     withCredentials : true,
			     headers : {
			      'Content-Type' : undefined
			     },
			     transformRequest : angular.identity
			    }).success(function(data) {
			    	//alert("video success");
			    	ngNotifier.notify("Created  Successfully !");
			     $location.path("/sponsorPageView/"+sponcor.eventId);
			    }).error(function(data) {
			    // alert("dsfsfds");
			    });
			
	};

};