
var NewsFeedViewController = function($scope,$http,$routeParams) {
	alert("NewsFeedViewController");
	$scope.inviteList = {};
	
	
	$scope.$on("$routeChangeSuccess", function () {
		
		$scope.eventId=$routeParams.eventId;
			
	  $http.get('admin/newsList?eventId='+$routeParams.eventId).success(function(newsList){
		      $scope.newsList = newsList;
	
		    //=================================
				// create empty search model (object) to trigger $watch on update
					$scope.search = null;

					/*$scope.resetFilters = function () {
					// needs to be a function or it won't trigger a $watch
					$scope.search = {};
					};*/

					// 	pagination controls
					$scope.currentPage = 1;
					$scope.totalItems = $scope.newsList.length;
					$scope.entryLimit = 5; // items per page
					$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

					// $watch search to update pagination
					$scope.$watch('search', function (newVal, oldVal) {
					$scope.filtered = filterFilter($scope.newsList, newVal);
					$scope.totalItems = $scope.filtered.length;
					$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);
					$scope.currentPage = 1;
					}, true);
			    //===================================*/
		      
	 });
	  
	
});
	
	  $scope.newsFeedEdit = function(newsFeedId){
		  
		location.href="#/newsFeedEdit/"+newsFeedId;
	};
	

	  $scope.newsFeedCreate = function(eventId){
		 // alert("--"+eventId);
		  location.href="#/newsFeedCreate/"+eventId;
	};
	
	$scope.cancelNewsFeedView = function(eventId)
	{
		location.href="#/eventViewDetails/"+eventId;
		
	};
	
};
