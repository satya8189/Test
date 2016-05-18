var GalleryViewController = function($scope,$routeParams,$http,$location) {
	$scope.galaryList = {};
	
	$scope.eventId={};
	
	
	$scope.$on("$routeChangeSuccess", function () {
		
		$scope.eventId=$routeParams.eventId;
		
			
		 $http.get('admin/galaryList?eventId='+$routeParams.eventId).success(function(galaryList){
			 alert("admin/galaryList");
			
				
				    $scope.galaryList = galaryList;
				    
			
				    
				  	});
				 });
	
	
	

	//galleryCreate(eventId)
	
	$scope.galleryCreate = function(eventId) {
	$location.path("/galleryCreate/"+eventId);

	};


	
	
	
	
};