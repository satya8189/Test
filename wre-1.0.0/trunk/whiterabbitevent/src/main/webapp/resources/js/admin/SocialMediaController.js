var SocialMediaController=function($scope,$location,$http,$routeParams,ngNotifier,$route){
	
	$scope.eventId={};
	$scope.filteredSize;
	$scope.$on("$routeChangeSuccess",function(){
		$scope.eventId=$routeParams.eventId;
		
		//alert("in SocialMediaController"+eventId);
		
		/*$http.get('admin/getSocialMediaList?eventId='+eventId).success(function()//socialMediaList)
		*/
		$http.get('admin/getSocialMediaList?eventId='+$routeParams.eventId).success(function(sMList) {
			//alert("got social media list."+sMList.length);
			$scope.socialmediaList=sMList;
			if(sMList.length==0)
				{
					$scope.filteredSize=0;
				}
			// =================================
			// create empty search model (object) to trigger
			// $watch on update
			$scope.search = null;

			/*
			 * $scope.resetFilters = function () { // needs to
			 * be a function or it won't trigger a $watch
			 * $scope.search = {}; };
			 */

			// pagination controls
			$scope.currentPage = 1;
			$scope.totalItems = $scope.socialmediaList.length;
			$scope.entryLimit = 5; // items per page
			$scope.noOfPages = Math.ceil($scope.totalItems
					/ $scope.entryLimit);
		

			// $watch search to update pagination
			$scope.$watch('search', function(newVal, oldVal) {
				$scope.filtered = filterFilter(
						$scope.socialmediaList, newVal);
				$scope.totalItems = $scope.filtered.length;
				$scope.noOfPages = Math.ceil($scope.totalItems
						/ $scope.entryLimit);
				$scope.currentPage = 1;
				$scope.filteredSize=$scope.filtered.length;
			}, true);

			// ===================================*/
			alert(filteredSize);
		});
	});
	
	//to create socialmedia....
	$scope.createSocialMedia= function(eventId){
		//alert("createsocialMedia.."+eventId);
		$location.path("/createSocialMedia/"+eventId);
	};
	
	$scope.editSocialMedia = function(socialId){
		//alert("edit social media.."+socialId);
		$location.path("/editSocialMedia/"+socialId);
		//location.href="#/editSocialMedia/"+socialId;
		};
	
		// cancelSponsorPageView
	$scope.cancelSocialMediaView = function(eventId) {
		// alert("Getting Back to SponsorPageViewView"+eventId);
		location.href = "#/eventViewDetails/" + eventId;
		};

	$scope.deleteSocialMedia= function(socialId){
		//alert("delete socialMedia.."+ socialId);
		$http.post('admin/deleteSocialMedia?socialId='+socialId).success(function(){
			//alert("deleting.");
			$route.reload();
			ngNotifier.notify("Deleted Successfully.!");
		});
	};
};