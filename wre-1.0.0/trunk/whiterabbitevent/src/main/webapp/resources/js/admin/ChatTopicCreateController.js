var ChatTopicCreateController = function($scope,$http, $location, $routeParams,ngNotifier){
	$scope.chat = {};
	
	$scope.chat.eventId = $routeParams.eventId ;
	
	$scope.saveChatTopic = function(chat){
		
		$http.post("admin/saveChatTopic",chat).success(function(success){
		
			 ngNotifier.notify("ChatTopic created Successfully !");
			 $location.path("/navigateToChatList/"+chat.eventId);
		}).error(function() {
			 ngNotifier.notify("ChatTopic Not Created Successfully !");
		});
		
	};
	$scope.cancelCreateChat = function(){
		
		$location.path("/navigateToChatList/"+$routeParams.eventId);
	}
}