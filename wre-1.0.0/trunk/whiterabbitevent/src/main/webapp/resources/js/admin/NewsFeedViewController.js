
var NewsFeedViewController = function($scope,$http,$routeParams) {
	$scope.newsList = {};
	
	
	$scope.$on("$routeChangeSuccess", function () {
		
		$scope.eventId=$routeParams.eventId;
		
		
			
	  $http.get('admin/newsList?eventId='+$routeParams.eventId).success(function(newsList){
		 
			
		    $scope.newsList = newsList;
	
	 });
	  
	
});
	
	
	
	
	  $scope.newsFeedEdit = function(newsFeedId){
		  
		location.href="#/newsFeedEdit/"+newsFeedId;
	};
	

	  $scope.newsFeedCreate = function(eventId){
		  alert("--"+eventId);
		location.href="#/newsFeedCreate/"+eventId;
	};
	
};