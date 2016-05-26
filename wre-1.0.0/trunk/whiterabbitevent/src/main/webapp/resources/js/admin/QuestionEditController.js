var QuestionEditController = function($scope, $http, $routeParams,$location) {
	alert("QuestionEditController");
	$scope.question={};

	$scope.$on('$routeChangeSuccess', function() {
		alert("question Id "+$routeParams.questionId);
		alert("eventID "+$routeParams.eventId);
		$http.get('admin/questionEditDetails?questionId='+$routeParams.questionId).success(function(question) {
			
			$scope.question=question;
			alert("hggj-----"+$scope.question.appIdentifierName);
					
				});
	});
        
        
    	$scope.updateQuestion = function(question) {
    		alert("updateQuestion");
		
		$http.post('question/update',question).success(function(status) {
		alert("	updateQuestion");
			$location.path("/questionView/"+question.eventId);
			


					});
		
		
		

	};
        

};

