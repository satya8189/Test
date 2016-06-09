/**
 * 
 */

var ChatTopicListViewController = function($scope,$routeParams,$http,$location,ngNotifier,$route){
	$scope.chatTopicId = $routeParams.chatTopicId;
	$scope.eventId={};
	$scope.$on("$routeChangeSuccess", function () {
	
		
	
			$scope.eventId = $routeParams.eventId;
		$http.get('admin/chatTopicList?eventId='+$routeParams.eventId).success(function(chatList){
			$scope.chatList = chatList;
			
			// create empty search model (object) to trigger $watch on update
			$scope.search = null;

			$scope.resetFilters = function () {
			// needs to be a function or it won't trigger a $watch
			$scope.search = {};
			};

			// 	pagination controls
			$scope.currentPage = 1;
			$scope.totalItems = $scope.chatList.length;
			$scope.entryLimit = 5; // items per page
			$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

			// $watch search to update pagination
			$scope.$watch('search', function (newVal, oldVal) {
			$scope.filtered = filterFilter($scope.chatList, newVal);
			$scope.totalItems = $scope.filtered.length;
			$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);
			$scope.currentPage = 1;
			}, true);
		});
		
	});
	
	$scope.navigateChatTopicCreate = function(eventId){
		$location.path("/chatTopicCreate/"+eventId);
		
	}

	$scope.navigateToChatEdit = function(chatTopicId){
		$location.path("/chatTopicView/"+chatTopicId);
	}
	
	$scope.deleteChat = function(chatTopicId) {
		$http.get('admin/deleteChatTopic?chatTopicId='+chatTopicId).success(
				function() {
					ngNotifier.notify("ChatTopic deleted successfully!");
					$route.reload();
					$scope.chatList = chatList;
					
				}).error(function() {
			ngNotifier.notifyError("ChatTopic not deleted !");
		});
	};

	
	}