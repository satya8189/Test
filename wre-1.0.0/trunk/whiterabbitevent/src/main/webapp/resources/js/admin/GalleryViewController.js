var GalleryViewController = function($scope, $routeParams, $http, $location,ngNotifier) {
	$scope.galaryList = {};

	$scope.eventId = {};

	$scope.galary = {};

	$scope.$on("$routeChangeSuccess", function() {

		$scope.eventId = $routeParams.eventId;

		$http.get('admin/galaryList?eventId=' + $routeParams.eventId
						+ "&type=image").success(function(galaryList) {

			$scope.galaryList = galaryList;

		});
	});

	$scope.deleteGallery = function(galary) {
		//		alert("deleteGallery"+galary.glaryItemId);
		$http.get('admin/deleteGallery?glaryItemId='+galary.glaryItemId).success(
				function() {

			//		alert("deleteGallery-------------"+galary.eventId);
					$http.get('admin/galaryList?eventId=' +galary.eventId
									+ "&type=image").success(
							function(galaryList) {
								ngNotifier.notify("Gallery deleted successfully.!");
								$scope.galaryList = galaryList;

							});
				});
					
				
	};
	
	//galleryCreate(eventId)
	$scope.galleryCreate = function(eventId) {
		$location.path("/galleryCreate/" + eventId);

	};
	
	$scope.cancelGalleryView = function(eventId)
	{
		//alert("Getting Back to SponsorPageViewView"+eventId);
		location.href="#/eventViewDetails/"+eventId;
	};
	

};