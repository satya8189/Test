var EventCreateController = function($scope, $http, $location) {
	$scope.event = {};
	$scope.saveEvent = function(event,userId) {
	event.userId=userId;
		$http.post('admin/saveEvent', event)
				.success(
						function(status) {
							if (status) {
								ngNotifier
										.notify("Event Name already available !");
							} else {
								ngNotifier
										.notify("Event Created successfully !");
								$location.path("admin/eventView");
							}

						}).error(function() {
					ngNotifier.notifyError("Event not created !");
				});
	

};

$scope.cancelEvent = function() {
	$location.path("/eventView");

};

};	



	

	
	
