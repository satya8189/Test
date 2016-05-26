var QuestionViewController = function($scope,$routeParams,$http, $location) {
	$scope.questionList={};
	$scope.eventId={};
	alert("khkjh"+$scope.eventId);
	
	$scope.$on("$routeChangeSuccess", function () {
		
		$scope.eventId=$routeParams.eventId;
		alert("adfs"+$routeParams.eventId);
			
		 $http.get('admin/questionList?eventId='+$routeParams.eventId).success(function(questionList){
			
				alert("admin/questionList");
				    $scope.questionList = questionList;
				    alert("admin/questionList-------------------------");
				    
			
				    
				  	});
				 });
	
$scope.questionCreate = function(eventId) {
		
		$location.path("/questionCreate/"+eventId);

	};
	
	 $scope.questionEdit= function(questionId){
		  
			location.href="#/questionEdit/"+questionId;
		};
		
	
	
	
	
	
	
	
};