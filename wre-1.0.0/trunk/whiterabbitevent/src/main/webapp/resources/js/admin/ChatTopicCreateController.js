var ChatTopicCreateController = function($scope,$http, $location, $routeParams,ngNotifier){
	$scope.chat = {};
	
	$scope.chat.eventId = $routeParams.eventId ;
	
	$scope.saveChatTopic = function(chat){
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
		     
		     }).success(function(success){
			 ngNotifier.notify("ChatTopic created Successfully.!");
			 $location.path("/navigateToChatList/"+chat.eventId);
		}).error(function() {
			 ngNotifier.notify("ChatTopic Not Created Successfully.!");
		});
		
	};
	$scope.cancelCreateChat = function(){
		$location.path("/navigateToChatList/"+$routeParams.eventId);
	};
};