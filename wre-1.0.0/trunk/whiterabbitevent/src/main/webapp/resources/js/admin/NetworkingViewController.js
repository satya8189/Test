var NetworkingViewController = function($scope,$http,$routeParams,$location,filterFilter) {
  
		$scope.eventId={};
		$scope.networkList={};
		$scope.$on("$routeChangeSuccess", function () {
		
		 $scope.eventId=$routeParams.eventId;
		 //alert("eventId-----------"+$routeParams.eventId);
			
		 $http.get('admin/ParticipantEventBeanList?eventId='+$routeParams.eventId+'&status=ACTIVE').success(function(eventList){
			//alert(eventList.length);	   
			 $scope.networkList = eventList;
			 
			 
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


