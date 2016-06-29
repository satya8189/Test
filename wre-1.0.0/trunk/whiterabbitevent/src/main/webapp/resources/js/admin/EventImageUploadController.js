var EventImageUploadController = function($scope, $http, $location, $routeParams,ngNotifier) {
	$scope.image = {};
	$scope.file={};
	$scope.image.eventId=$routeParams.eventId;
	$scope.eventImages={};
	$scope.eventId=$routeParams.eventId;
	
	$scope.$on("$routeChangeSuccess", function() {
		var type="event_images";
		 $http.get('admin/getEventImages?eventId='+$routeParams.eventId+'&type='+type).success(function(eventImages){
			    $scope.eventImages = eventImages;
		 });
		 
		$http.get('admin/Viewdetails?eventId='+$routeParams.eventId+'&&type='+"web").success(function(event) {
				$scope.event=event;
				//alert("data.."+event.eventName);	
		});

	});
	
		$scope.uploadImage = function() {
		var fd = new FormData();
		var type = "event_images";
		// Take the first selected file
		fd.append("file", file.files[0]);
		fd.append("eventId", $routeParams.eventId);
		fd.append("type", "event_images");
		$http.post('admin/uploadEventImage', fd, {
			withCredentials : true,
			headers : {
				'Content-Type' : undefined
			},
			transformRequest : angular.identity
		}).success(
				function(data) {
					ngNotifier.notify("Event Image created Successfully !");
					$http.get('admin/getEventImages?eventId='+ $routeParams.eventId + '&type=' + type)
							.success(function(eventImages) {
								$scope.eventImages = eventImages;
							});
				}).error(function(data) {
		});
	};

	$scope.deleteGallery = function(galary) {
		// alert("deleteGallery"+galary.glaryItemId);
		$http.post('admin/deleteEventImage', galary).success(function() {
					ngNotifier.notify("Event Image deleted successfully.!");
					var type="event_images";
					$http.get('admin/getEventImages?eventId='+$routeParams.eventId +'&type='+type)
							.success(function(eventImages) {
								$scope.eventImages = eventImages;
							});
				});
	};

$scope.cancelUploadLayout = function(eventId){
	//$location.path("/eventView/"+$routeParams.eventId);....
	$location.path("/eventViewDetails/"+$routeParams.eventId);
};

$scope.cancelGalleryCreate= function(eventId) {
	$location.path("/galleryView/"+eventId);

};

};	


	



		

		
		

	
