
var NewsFeedViewController = function($scope,$http,$routeParams) {
	$scope.newsList = {};
	alert("hi");
	
	$scope.$on("$routeChangeSuccess", function () {
		$scope.newsFeedId=$routeParams.newsFeedId;
		alert("newsFeedId "+$scope.newsFeedId);
		
			
	  $http.get('admin/newsList?newsFeedId='+$routeParams.newsFeedId).success(function(newsList){
		 alert("admin/newsList"),
			
		    $scope.newsList = newsList;
	
	 });
	  
	  $scope.newsFeedEdit = function(newsFeedId){
			location.href="#/newsFeedEdit/"+newsFeedId;
		};
		
});
};
