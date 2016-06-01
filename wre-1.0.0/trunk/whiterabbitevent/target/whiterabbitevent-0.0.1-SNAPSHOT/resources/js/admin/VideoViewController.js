var VideoViewController = function($scope,$routeParams,$http,$location,ngNotifier) {
$scope.videoList = {};
$scope.eventId={};

	
	$scope.$on("$routeChangeSuccess", function () {
		$scope.eventId=$routeParams.eventId;
		
			
		 $http.get('admin/galaryList?eventId='+$routeParams.eventId+"&type=video").success(function(videoList){
				    $scope.videoList = videoList;
				    
				  	});
				 });
	
	$scope.deleteGallery = function(video) {
		
		//alert("deleteGallery"+video.glaryItemId);
		$http.get('admin/deleteGallery?glaryItemId='+video.glaryItemId).success(
				function() {

				//	alert("deleteGallery-------------"+video.eventId);
					$http.get(
							'admin/galaryList?eventId=' +video.eventId
									+ "&type=video").success(
							function(videoList) {
								ngNotifier.notify("Video Deleted Successfully.!");
								$scope.videoList = videoList;
								
							});
				});
					
				
	};
	//videoUpload(eventId)
	$scope.videoUpload = function(eventId) {
		$location.path("/videoUpload/"+eventId);

	};

	$scope.navigateToEventsView = function(eventId)
	{
		
		location.href="#/eventViewDetails/"+eventId;
	};
	
};