var NetworkingViewController = function($scope,$http,$routeParams,$location,filterFilter) {
  	$scope.eventId={};
		$scope.networkList={};
		$scope.filteredSize;
		$scope.$on("$routeChangeSuccess", function () {
		 $scope.eventId=$routeParams.eventId;
	//	 alert("eventId-----------"+$routeParams.eventId);
			
		 $http.get('admin/ParticipantEventBeanList?eventId='+$routeParams.eventId+'&status=ACTIVE').success(function(eventList){
			 $scope.networkList = eventList;
			 if(eventList.length==0)
				{
					$scope.filteredSize=0;
				}
			// =================================
				// create empty search model (object) to trigger
				// $watch on update
				$scope.search = null;

				// pagination controls
				$scope.currentPage = 1;
				$scope.totalItems = $scope.networkList.length;
				$scope.entryLimit = 5; // items per page
				$scope.noOfPages = Math.ceil($scope.totalItems
						/ $scope.entryLimit);
			
				// $watch search to update pagination
				$scope.$watch('search', function(newVal, oldVal) {
					$scope.filtered = filterFilter(
							$scope.networkList, newVal);
					$scope.totalItems = $scope.filtered.length;
					$scope.noOfPages = Math.ceil($scope.totalItems
							/ $scope.entryLimit);
					$scope.currentPage = 1;
					$scope.filteredSize=$scope.filtered.length;
				}, true);

				// ===================================*/
				
				  	});
				 });
		
		//networkingEdit
        $scope.networkingEdit = function(participantId){
        	//alert("participant id.."+participantId);
			location.href="#/networkingEdit/"+participantId+"/"+$routeParams.eventId;
		};
		
		$scope.cancelNetworkingView= function(eventId){
			//alert("getting back.."+eventId);
			$location.path("/eventViewDetails/"+eventId);
		} ;
		
};


