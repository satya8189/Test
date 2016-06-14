var ChatTopicViewDetailsController = function($scope, $http, $location, $routeParams,ngNotifier){
	
	
	$scope.chat = {};
	$scope.$on("$routeChangeSuccess", function() {
		$scope.chatTopicId=$routeParams.chatTopicId;
		
		$http.get('admin/chatTopicDetails?chatTopicId='+$routeParams.chatTopicId).success(function(chat) {
			$scope.chat=chat;
				});
		
	});
	
	$scope.updateChat = function(chat){
		$http.post('admin/chatTopicUpdate',chat).success(function(){
			$scope.chat = chat;
			 ngNotifier.notify("ChatTopic Updated Successfully !");
			 $location.path("/navigateToChatList/"+chat.eventId);
			 
		}).error(function(){
			ngNotifier.notify("ChatTopic Not Updated Successfully !");
		});	
	}
	
$scope.cancelUpdateChat = function(chat){
		
		$location.path("/navigateToChatList/"+chat.eventId);
	}
}