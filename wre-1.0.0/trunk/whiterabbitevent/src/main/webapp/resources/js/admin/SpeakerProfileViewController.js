var SpeakerProfileViewController = function($scope, $http, $location, $routeParams,ngNotifier)
	{
			    
		$scope.$on("$routeChangeSuccess",function() {
			$scope.eventId=$routeParams.eventId;
			//alert("event ID---++"+$routeParams.eventId);
			$http.get('admin/speakersList?eventId='+$routeParams.eventId).success(
			function(sList) {
				//alert("got the data from controller");
				$scope.speakersList=sList;
				
				// create empty search model (object) to trigger $watch on update
				/*$scope.search =null;

				$scope.resetFilters = function () {
					// needs to be a function or it won't trigger a $watch
					$scope.search =null;
				};

				// pagination controls
				$scope.currentPage = 1;
				$scope.totalItems = $scope.speakersList.length;
				$scope.entryLimit = 8; // items per page
				$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

				// $watch search to update pagination
				$scope.$watch('search', function (newVal, oldVal) {
					$scope.filtered = filterFilter($scope.speakersList, newVal);
					$scope.totalItems = $scope.filtered.length;
					$scope.noOfPages = 5;
					$scope.currentPage = 1;
					$scope.filteredSize=$scope.filtered.length;
				}, true);
*/			    
				
				
				});
			});
		
		$scope.cancelSpeakerProfileView= function(eventId)
		{
			//alert("getting back to dashboard");
			$location.path("/eventViewDetails/"+eventId);
		};
		
		$scope.navigateToSpeakerrCreate= function(eventId)
		{
			//alert("going to create speaker");
			$location.path("/speakerCreate/"+eventId);
		};
		
		$scope.editSpeaker= function(speakerId)
		{
			$scope.speakerId=speakerId;
				//alert("working speakerEdit..."+speakerId);
			$location.path("/editSpeaker/"+speakerId);
		};
};	