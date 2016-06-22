var ImageUploadController = function($scope, $http, $location, $routeParams,ngNotifier) {
	$scope.image = {};
	$scope.file={};
	$scope.image.eventId=$routeParams.eventId;
	$scope.eventImages={};
	

	$scope.$on("$routeChangeSuccess", function() {
		//alert($routeParams.eventId);
		var type="event_images";
		 $http.get('admin/getEventImages?eventId='+$routeParams.eventId+'&type='+type).success(function(eventImages){
			    $scope.eventImages = eventImages;
			   // alert($scope.eventImages.length);
 	 });
	});
	
	$scope.uploadImage = function() {
		
		var fd = new FormData();
         var type="event_images";
		  // Take the first selected file
		    fd.append("file", file.files[0]);
		    fd.append("eventId",$routeParams.eventId);
		    fd.append("type","event_images");
		    $http.post('admin/uploadEventImage',fd, {
		     withCredentials : true,
		     headers : {
		      'Content-Type' : undefined
		     },
		     transformRequest : angular.identity
		    }).success(function(data) {
		    	ngNotifier.notify("Record Created Successfully !");
		    	 $http.get('admin/getEventImages?eventId='+$routeParams.eventId+'&type='+type).success(function(eventImages){
					    $scope.eventImages = eventImages;
					    //alert($scope.eventImages.length);
		    	 });
		    }).error(function(data) {
		    });
	

};

$scope.cancelUploadLayout = function(eventId){
	$location.path("/eventView/"+$routeParams.eventId)
	
}

$scope.cancelGalleryCreate= function(eventId) {
	$location.path("/galleryView/"+eventId);

};

};	


	



		

		
		

	
