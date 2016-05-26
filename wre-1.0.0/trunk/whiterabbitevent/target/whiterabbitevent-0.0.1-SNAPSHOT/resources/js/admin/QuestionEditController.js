var QuestionEditController = function($scope, $http, $routeParams,$location) {
	
	$scope.question={};

	$scope.$on('$routeChangeSuccess', function() {
		$http.get('admin/questionEdit?questionEdit='+$routeParams.questionEdit).success(function(question) {
			$scope.question=question;
					
				});
	});
        
        
    	$scope.updateQuestion = function(agendo) {
		
		$http.post('agendo/update',agendo).success(function(status) {
			
			$location.path("/agendoDetails/"+agendo.eventId);
			


					});
		

	};
        

};

