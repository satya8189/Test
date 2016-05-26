var NewsFeedCreateController = function($scope, $http, $location, $routeParams,ngNotifier) {
	$scope.news = {};
	$scope.$on("$routeChangeSuccess", function () {
		$scope.news.eventId=$routeParams.eventId;
	});


	$scope.saveNews = function(news) {
	
	$http.post('admin/saveNews',news).success(function(success) {
		//alert("admin/saveNews");
		ngNotifier.notify("Record Created Successfully !");
	
	$location.path("/newsFeedView/"+news.eventId);
				});

};


	$scope.navigateToNewsFeedView = function(eventId)
	{
		//alert("gettting back.."+eventId);
		$location.path("/newsFeedView/"+eventId);
		};

};	


	
	


		

		
		

	
