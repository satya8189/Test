var GalleryCreateController = function($scope, $http, $location, $routeParams,ngNotifier) {
	
	$scope.gallery = {};
	$scope.file={};
	$scope.gallery.eventId=$routeParams.eventId;
	
	
	$scope.createGallery = function(gallery) {
		
		var fd = new FormData();

		  // Take the first selected file
		    fd.append("file", file.files[0]);
		    fd.append("eventId",gallery.eventId);
		    fd.append("name",gallery.name);
		    fd.append("type","image");
		    $http.post('admin/createGallery',fd, {
		     withCredentials : true,
		     headers : {
		      'Content-Type' : undefined
		     },
		     transformRequest : angular.identity
		    }).success(function(data) {
		    	ngNotifier.notify("Record Created Successfully !");
		     $location.path("/galleryView/"+gallery.eventId);
		    }).error(function(data) {
		     alert("dsfsfds");
		    });
	

};

$scope.cancelEvent = function() {
	$location.path("/newsFeedView/");

};

};	


	

	


	
	


		

		
		

	
