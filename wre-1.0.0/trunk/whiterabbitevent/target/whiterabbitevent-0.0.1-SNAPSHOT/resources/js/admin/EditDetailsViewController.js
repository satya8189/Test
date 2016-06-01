var EditDetailsViewController = function($scope, $http, $location, $routeParams,ngNotifier) {
	
	$scope.event={};

			    
		$scope.$on("$routeChangeSuccess", function() {
		
		$http.get('admin/Viewdetails?eventId='+$routeParams.eventId).success(function(event) {
			$scope.event=event;
					
				});
	});
		
		$scope.updateEvent = function(event) {
			$http.post('details/update',event).success(
					function() {
						location.href="#/detailsView/"+event.eventId;
						ngNotifier.notify("Event Updated Successfully.!");
				}).error(function(){
					ngNotifier.error("Error in updating.!");
				});
			};
	      
	  
			$scope.navigateToDetailsView = function(eventId)
			{
				//alert("Getting back to detailsView."+eventId);
				$location.path("/detailsView/"+eventId);
			};

};
