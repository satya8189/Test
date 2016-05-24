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
		//alert("updating...."+speaker.description);
		$http.post('admin/updateSpeaker',speaker).success(function(){
			//alert("updated.....");
			$location.path("/speakerProfileView/"+speaker.eventId);
				ngNotifier.notify("speaker updated.!");
		}).error(function(){
				ngNotifier.error("error updating speaker.!");
		});
		
		
	};
};