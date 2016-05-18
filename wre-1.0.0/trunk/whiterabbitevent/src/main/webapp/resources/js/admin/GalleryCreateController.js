var GalleryCreateController = function($scope, $http, $location, $routeParams) {
	
	$scope.gallery = {};

	
	$scope.gallery.eventId=$routeParams.eventId;
	alert("adfasf-------"+$routeParams.eventId);
	
	$scope.createGallery = function(gallery) {
		
		
		
	$http.post('admin/createGallery',gallery).success(function(success) {
		alert("admin/createGallery");

	//$location.path("/agendoViewDetails/"+$routeParams.eventId);
	$location.path("/galleryView/"+gallery.eventId);
	


				});
	

};

$scope.cancelEvent = function() {
	$location.path("/newsFeedView/");

};

};	


	

	


	
	


		

		
		

	
