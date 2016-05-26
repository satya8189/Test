var DocumentViewController = function($scope,$routeParams,$http,$location) {
$scope.galaryList = {};
//alert("galaryList");
	
	$scope.eventId={};
	
	
	$scope.$on("$routeChangeSuccess", function () {
		
		$scope.eventId=$routeParams.eventId;
		alert("sdfsaf---------------"+$routeParams.eventId);
			
		 $http.get('admin/galaryList?eventId='+$routeParams.eventId+"&type=document").success(function(galaryList){
			 	    $scope.galaryList = galaryList;
				    
				  	});
				 });
	
	
	$scope.deleteGallery = function(document) {
		alert("deleteGallery");

		alert("deleteGallery"+document.glaryItemId);
		$http.get('admin/deleteGallery?glaryItemId='+document.glaryItemId).success(
				function() {

					alert("deleteGallery-------------"+document.eventId);
					$http.get(
							'admin/galaryList?eventId=' +document.eventId
									+ "&type=document").success(
							function(galaryList) {
								$scope.galaryList = galaryList;

							});
				});
					
				
	};
	
	

	//galleryCreate(eventId)
	
	$scope.documentCreate = function(eventId) {
		alert("fsadfasd--------------------------"+eventId);
		$location.path("/documentCreate/"+eventId);

	};


	$scope.goToEventsView = function(eventId)
	{
		alert("fsadfasd--------------------------"+eventId);
		location.href="#/eventViewDetails/"+eventId;
	};
	
	
	
};