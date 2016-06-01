var VenueLayoutController=function($scope,$location,$http,$routeParams,ngNotifier){
	$scope.upload={};
	
	$scope.$on("$routeChangeSuccess",function(){
		alert("venuelayoutController..."+$routeParams.eventId);
		
		$scope.upload.eventId=$routeParams.eventId;
		
		
		
		
	});
	
	$scope.uploadLayout = function() {
		alert("uploadLayout");
		
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
		     
		    }).error(function(data) {
		     alert("dsfsfds");
		    });
	

};

//cancelUploadLayout

$scope.cancelUploadLayout = function(eventId)
{
	//alert("getting back to eventViewDetails");
	$location.path("/eventViewDetails/"+eventId);
};




	
};