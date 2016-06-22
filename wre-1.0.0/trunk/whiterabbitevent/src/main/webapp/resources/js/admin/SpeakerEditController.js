var SpeakerEditController=function($scope,$http,$routeParams,$location,ngNotifier){
	
	//$scope.$on("$routeChangeSuccess",function(){
	$scope.$on("$routeChangeSuccess", function () {	
			$scope.speakerId = $routeParams.speakerId;
		//alert("working in speakeredit Ctrl..."+$scope.speakerId);
		
		$http.get('admin/getSpeakerBySpeakerId?speakerId='+$routeParams.speakerId).success(
				function(sp) {
					$scope.eventId=sp.eventId;
					$scope.speaker=sp;
					//alert("got speaker by id--"+sp.speakerName);
				}).error(function(){
					ngNotifier.error("error in getting speaker by id");
				});
	});
	
	$scope.cancelSpeakerEdtit = function(eventId)
	{
		//alert("gettting back to speakerView==="+eventId);
		$location.path("/speakerProfileView/"+eventId);
	};
	
	
	$scope.updateSpeaker = function(speaker)
	{
		alert("dfdsf");
		 var fd = new FormData();
			//alert("video");

			  // Take the first selected file
			    fd.append("file", file.files[0]);
			   

			    fd.append("eventId",speaker.eventId);
			    fd.append("speakerId",speaker.speakerId);
			    fd.append("type","speaker");
			    fd.append("speakerName",speaker.speakerName);
			    fd.append("location",speaker.location);
			    
			    fd.append("title",speaker.title);
			    fd.append("description",speaker.description);
			    
			    fd.append("rating",speaker.rating);
			    
			    alert("data--"+fd);
			    $http.post('admin/updateSpeaker',fd, {
			     withCredentials : true,
			     headers : {
			      'Content-Type' : undefined
			     },
			     transformRequest : angular.identity
			    }).success(function(data) {
			    	//alert("video success");
			    	ngNotifier.notify("Created  Successfully !");
			    	$location.path("/speakerProfileView/"+speaker.eventId);
			    }).error(function() {
					ngNotifier.notifyError("Please choose Required file !");
				});

		
	};
};