var SpeakerCreateController=function($scope, $http, $routeParams,$location,ngNotifier){
	$scope.speaker={};
	$scope.$on("$routeChangeSuccess", function(){
		$scope.speaker.eventId=$routeParams.eventId;
			//alert("working in speaker create..."+$routeParams.eventId);
		
	});
	
	$scope.cancelCreateSpeaker = function(eventId){
		//alert("getting back to speaker view"+eventId);
		$location.path("/speakerProfileView/"+eventId);
	};
	
	 $scope.saveSpeaker= function(speaker){
		 //alert("dfdsf");
		 var fd = new FormData();
			//alert("video");

			  // Take the first selected file
			    fd.append("file", file.files[0]);
			   

			    fd.append("eventId",speaker.eventId);
			    fd.append("type","speaker");
			    fd.append("speakerName",speaker.speakerName);
			    fd.append("location",speaker.location);
			    
			    fd.append("title",speaker.title);
			    fd.append("description",speaker.description);
			    
			    fd.append("rating",speaker.rating);
			    
			   // alert("data--"+fd);
			    $http.post('admin/speakerSave',fd, {
			     withCredentials : true,
			     headers : {
			      'Content-Type' : undefined
			     },
			     transformRequest : angular.identity
			    }).success(function(data) {
			    	//alert("video success");
			    	ngNotifier.notify("Created  Successfully !");
			    	$location.path("/speakerProfileView/"+speaker.eventId);
			    }).error(function(data) {
			    // alert("dsfsfds");
			    });
		
	 };

};