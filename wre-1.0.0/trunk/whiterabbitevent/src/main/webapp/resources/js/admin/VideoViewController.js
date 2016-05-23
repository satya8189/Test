var VideoViewController = function($scope,$routeParams,$http,$location) {
$scope.videoList = {};
	
	$scope.eventId={};
	
	
	$scope.$on("$routeChangeSuccess", function () {
		alert("1111111111");
		$scope.eventId=$routeParams.eventId;
		
			
		 $http.get('admin/galaryList?eventId='+$routeParams.eventId+"&type=video").success(function(videoList){
			 alert("admin/galaryList");
			
				
				    $scope.videoList = videoList;
				    
			
				    
				  	});
				 });
	
	
	

	//videoUpload(eventId)
	
	$scope.videoUpload = function(eventId) {
	$location.path("/videoUpload/"+eventId);

	};


	
	
	
	
};