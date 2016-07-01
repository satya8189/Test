var ChatTopicViewDetailsController = function($scope, $http, $location, $routeParams,ngNotifier){
	
	
	$scope.chat = {};
	$scope.$on("$routeChangeSuccess", function() {
		$scope.chatTopicId=$routeParams.chatTopicId;
		
		$http.get('admin/chatTopicDetails?chatTopicId='+$routeParams.chatTopicId).success(function(chat) {
			$scope.chat=chat;
				});
		
	});
	
	$scope.updateChat = function(chat){
		//alert("data....."+chat.eventId+"---"+chat.chatTopicName);
		var fd = new FormData();
	    //Take the first selected file
	    fd.append("file", file.files[0]);
	    fd.append("eventId",chat.eventId);
	    fd.append("chatTopicName",chat.chatTopicName);
	    fd.append("type","chatTopic");
	    //alert("data--"+fd);
	
	$http.post("admin/saveChatTopic", fd, {
	     withCredentials : true,
	     headers : {'Content-Type' : undefined},
	     transformRequest : angular.identity
	     }).success(function(){
			$scope.chat = chat;
			 ngNotifier.notify("ChatTopic Updated Successfully !");
			 $location.path("/navigateToChatList/"+chat.eventId);
			 
		}).error(function(){
			ngNotifier.notify("ChatTopic Not Updated Successfully !");
		});	
	};
	
$scope.cancelUpdateChat = function(chat){
		$location.path("/navigateToChatList/"+chat.eventId);
	};
};