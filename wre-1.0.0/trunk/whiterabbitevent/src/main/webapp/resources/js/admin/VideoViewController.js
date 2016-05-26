var VideoViewController = function($scope,$routeParams,$http,$location) {
$scope.videoList = {};
$scope.eventId={};

	
	$scope.$on("$routeChangeSuccess", function () {
		//alert("1111111111");
		$scope.eventId=$routeParams.eventId;
		
			
		 $http.get('admin/galaryList?eventId='+$routeParams.eventId+"&type=video").success(function(videoList){
			// alert("admin/galaryList");
				    $scope.videoList = videoList;
				    
				  	});
				 });
	
	$scope.deleteGallery = function(video) {
		alert("deleteGallery");

		alert("deleteGallery"+video.glaryItemId);
		$http.get('admin/deleteGallery?glaryItemId='+video.glaryItemId).success(
				function() {

					alert("deleteGallery-------------"+video.eventId);
					$http.get(
							'admin/galaryList?eventId=' +video.eventId
									+ "&type=video").success(
							function(galaryList) {
								$scope.galaryList = galaryList;

							});
				});
					
				
	};
	//videoUpload(eventId)
	
	$scope.videoUpload = function(eventId) {
		$location.path("/videoUpload/"+eventId);

	};

	$scope.navigateToEventsView = function(eventId)
	{
		alert("Getting Back eventId"+eventId);
		location.href="#/eventViewDetails/"+eventId;
	};
	
};