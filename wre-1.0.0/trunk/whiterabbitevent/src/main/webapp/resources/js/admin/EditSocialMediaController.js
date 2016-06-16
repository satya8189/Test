//var EditSocialMediaController=function($scope)
var EditSocialMediaController=function($scope,$location,$http,$routeParams,ngNotifier){
	$scope.eventId={};
	
	$scope.$on("$routeChangeSuccess",function(){
		//alert("getting data.."+$routeParams.socialId);
		 $http.get('admin/getSocialMediaForEdit?socialId='+$routeParams.socialId).success(function(socialList){
			 $scope.sm=socialList;
			 $scope.eventId=socialList.eventId; 
			//alert("check eventId.."+eventId);
		 }).error(function(){
			alert("in error.."); 
		 });
	});
	
	$scope.cancelSocialMediaEdtit = function(eventId){
		//alert("getting back to socialMediaView"+eventId);
		$location.path("/SocialMedia/"+eventId);
	};
	
	//To ..updateSocialMedia
	$scope.updateSocialMedia= function(SocialMedia){
		//alert("update.."+SocialMedia.socialId);
		$http.post('admin/updateSocialMedia',SocialMedia).success(function(){
			//alert("updated...");
			$location.path("/SocialMedia/"+SocialMedia.eventId);
			ngNotifier.notify("Updated Successfully.!");
		});
	};
	
	
};