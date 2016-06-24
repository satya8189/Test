var VenueLayoutController=function($scope,$location,$http,$routeParams,ngNotifier,$route){
	$scope.upload={};
	//$socpe.eventId={};
	$scope.$on("$routeChangeSuccess",function(){
		
		$scope.upload.eventId=$routeParams.eventId;
		//$scope.eventId=$routeParams.eventId;
		
		
	});
	
	$scope.uploadLayout = function() {
		var fd = new FormData();

		  // Take the first selected file
		    fd.append("file", file.files[0]);
		    fd.append("eventId",$scope.upload.eventId);
		    fd.append("type","layout");
		   
		    $http.post('admin/uploadVenuLayout',fd, {
		     withCredentials : true,
		     headers : {
		      'Content-Type' : undefined
		     },
		     transformRequest : angular.identity
		    }).success(function(data) {
		    	ngNotifier.notify("Record Created Successfully !");
		    	$route.reload();
		    	//$window.location.reload();
		    }).error(function() {
				//ngNotifier.notifyError("Please choose Required file !");
			});

	};
//cancelUploadLayout

$scope.cancelUploadLayout = function(eventId)
{
	//alert("getting back to eventViewDetails---"+eventId);
	$location.path("/eventViewDetails/"+eventId);
};

	
};