var VideoUploadController = function($scope, $http, $location, $routeParams,ngNotifier) {
		$scope.file={};
		$scope.video={};
		
		$scope.video.eventId=$routeParams.eventId;
		//alert("adfasf-------"+$routeParams.eventId);
		
$scope.uploadVideo = function(video) {
			
			var fd = new FormData();
			//alert("video");

			  // Take the first selected file
			    fd.append("file", file.files[0]);
			    fd.append("eventId",video.eventId);
			    fd.append("name",video.name);
			    fd.append("type","video");
			    $http.post('admin/createGallery',fd, {
			     withCredentials : true,
			     headers : {
			      'Content-Type' : undefined
			     },
			     transformRequest : angular.identity
			    }).success(function(data) {
			    	//alert("video success");
			    	ngNotifier.notify("video Uploaded Successfully !");
			     $location.path("/videoView/"+video.eventId);
			    }).error(function(data) {
			    // alert("dsfsfds");
			    });
		

	};

	$scope.cancelUploadVideo = function(eventId)
	{
		//alert("getting back=="+eventId);
		location.href="#/videoView/"+eventId;
	};

	/*$scope.navigateToEventsView = function(eventId)
	{
		alert("Getting Back eventId"+eventId);
		location.href="#/eventViewDetails/"+eventId;
	};*/

	
};	


