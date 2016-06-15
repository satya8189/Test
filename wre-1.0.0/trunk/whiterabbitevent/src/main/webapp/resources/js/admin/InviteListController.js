var InviteListController = function($scope,$routeParams,$http, $location) {
	$scope.inviteList = {};
		
		$scope.$on("$routeChangeSuccess", function () {
			
			$scope.eventId=$routeParams.eventId;
			//alert("hi--------"+$routeParams.eventId);
				
		  $http.get('admin/inviteDetails?eventId='+$routeParams.eventId).success(function(inviteList){
			  //alert("admin/inviteDetails");
			  	$scope.eventId=$routeParams.eventId;
				$scope.inviteList = inviteList;
				
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
				$scope.totalItems = $scope.inviteList.length;
				$scope.entryLimit = 5; // items per page
				$scope.noOfPages = Math.ceil($scope.totalItems
						/ $scope.entryLimit);
			

				// $watch search to update pagination
				$scope.$watch('search', function(newVal, oldVal) {
					$scope.filtered = filterFilter(
							$scope.inviteList, newVal);
					$scope.totalItems = $scope.filtered.length;
					$scope.noOfPages = Math.ceil($scope.totalItems
							/ $scope.entryLimit);
					$scope.currentPage = 1;
				}, true);

				// ===================================*/

		
		 });
		  
		  $scope.cancelInviteListView = function(eventId){
				//alert("getting back.."+eventId);
				$location.path("/invite/"+eventId);
				
			};
		  
		
	});
		
		
		
		
		
	};
