var SpeakerCreateController=function($scope, $http, $routeParams,$location,ngNotifier){
	
	$scope.$on("$routeChangeSuccess", function(){
		$scope.eventId=$routeParams.eventId;
			//alert("working in speaker create..."+$routeParams.eventId);
		
	});
	
	$scope.cancelCreateSpeaker = function(eventId){
		//alert("getting back to speaker view"+eventId);
		$location.path("/speakerProfileView/"+eventId);
	};
	
	 $scope.saveSpeaker= function(speaker){
			//$scope.userId=userId;
			$scope.speaker.eventId=$routeParams.eventId;
			
			//alert("speakerdata===="+speaker.eventId+"=="+speaker.speakerName+"==="+speaker.desc);
			
			$http.post('admin/speakerSave',speaker).success(function() {
					$location.path("/speakerProfileView/"+speaker.eventId);
				}).success(function(){
					 ngNotifier.notify("speaker created successfully.!");
				}).error(function() {
					ngNotifier.error("error in adding speaker");
			});
		};
	
	
};