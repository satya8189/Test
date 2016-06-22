var QuestionEditController = function($scope, $http, $routeParams,$location, ngNotifier) {
//	alert("QuestionEditController");
	$scope.question={};
	
	$scope.$on('$routeChangeSuccess', function() {
		
		$http.get('admin/questionEditDetails?questionId='+$routeParams.questionId).success(function(question) {
			$scope.question=question;
					
				});
	});
        
	//updateQuestion
    	$scope.updateQuestion = function(question) {
    		//alert("updateQuestion"+question.questionId+"-"+question.question+"--"+question.answer);
    		$http.post('question/update',question).success(function(status) {
    			//alert("updateQuestion");
    			$location.path("/questionView/"+question.eventId);
    			ngNotifier.notify("Question updated successfully.!");
    			});
    };

    $scope.cancelQuestionEdit= function(eventId){
    	//alert("gett back..");
    	$location.path("/questionView/"+eventId);
	};
   

};

