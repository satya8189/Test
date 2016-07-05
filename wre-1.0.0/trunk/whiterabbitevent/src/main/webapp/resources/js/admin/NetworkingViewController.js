var NetworkingViewController = function($scope,$http,$routeParams,$location,filterFilter,$rootScope,ngNotifier) {
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
		
		//method for QR Code generation
		$scope.generateQRCode = function(participant){
			//alert(participant.eventId+"- -"+participant.participantId+"--"+participant.emailId+"--"+participant.status+"---working generateQRCode");
			
			$scope.inviteBean={};
			$scope.inviteBean.eventId=participant.eventId;
			$scope.inviteBean.participantId=participant.participantId;
			$scope.inviteBean.firstName=participant.firstName;
			$scope.inviteBean.lastName=participant.lastName;
			$scope.inviteBean.eventName=$rootScope.eventName;
			$scope.inviteBean.phone=participant.phone;
			
			//participant.eventName='cong';participantId
			//alert($scope.inviteBean.eventName);
			$http.post('admin/generateQRCode',$scope.inviteBean).success(function(data) {
			    	//alert("QR success");
			    	ngNotifier.notify("QR Code Generated  Successfully !");
			    }).error(function(data) {
			    	//alert("QR Fail");
			    	ngNotifier.notifyError("Could not genarate QR Code !");
			    });
			
		};
};


