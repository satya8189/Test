

var NewsFeedEditController = function($scope,$routeParams,$http,$location,ngNotifier) {
	
	$scope.news={};

	$scope.$on('$routeChangeSuccess', function() {
		$http.get('admin/newsEditDetails?newsFeedId='+$routeParams.newsFeedId).success(function(news) {
			$scope.news=news;
					
				});
	});
        
        
    	$scope.updateNews = function(news) {
			
		$http.post('news/update',news).success(function(status) {
			
			$location.path("/newsFeedView/"+news.eventId);
			ngNotifier.notify("NewsFeed Updated Successfully.!");

					});
	};
  
	
	$scope.navigateToNewsFeedView= function(eventId)
	{
		//alert("news feed view.."+eventId);
		$location.path("/newsFeedView/"+eventId);
	};

};
