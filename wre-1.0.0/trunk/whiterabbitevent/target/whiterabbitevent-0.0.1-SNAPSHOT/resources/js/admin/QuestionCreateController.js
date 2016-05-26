var QuestionCreateController = function($scope,$http, $location, $routeParams,ngNotifier) {
	$scope.question = {};
	$scope.appList = {};

	$scope.question.eventId=$routeParams.eventId;
	$scope.$on('$routeChangeSuccess', function() {
		$http.get('admin/appList?appId=1001').success(function(appList) {
			$scope.appList=appList;
					
				});
	});
       
	
	$scope.questionCreate = function(question) {
		
		
		
	$http.post('admin/questionCreate',question).success(function(success) {
		

	ngNotifier.notify("Record Created Successfully !");
	$location.path("/questionView/"+question.eventId);
	
	
	

				});
	

};

};	


	
	


		

		
		

	
