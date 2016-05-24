var DocumentViewController = function($scope,$routeParams,$http,$location) {
$scope.galaryList = {};
//alert("galaryList");
	
	$scope.eventId={};
	
	
	$scope.$on("$routeChangeSuccess", function () {
		
		$scope.eventId=$routeParams.eventId;
		
			
		 $http.get('admin/galaryList?eventId='+$routeParams.eventId+"&type=document").success(function(galaryList){
			 	    $scope.galaryList = galaryList;
				    
				  	});
				 });
	
	
	

	//galleryCreate(eventId)
	
	$scope.documentCreate = function(eventId) {
		$location.path("/documentCreate/"+eventId);

	};


	$scope.goToEventsView = function(eventId)
	{
		//alert("Getting Back to SponsorPageViewView"+eventId);
		location.href="#/eventViewDetails/"+eventId;
	};
	
	
	
};