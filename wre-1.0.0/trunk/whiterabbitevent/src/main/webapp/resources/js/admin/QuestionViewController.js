var QuestionViewController = function($scope,$routeParams,$http, $location) {
	$scope.questionList={};
	$scope.eventId={};
	
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
		  alert("question id "+questionId);
		  alert("event id"+$routeParams.eventId);
		  $location.path("/questionEdit/"+$routeParams.eventId+"/"+questionId);
		};
		
	
	
	
		$scope.cancelQuestionView = function(eventId)
		{
			//alert("getting back to eventViewDetails");
			$location.path("/eventViewDetails/"+eventId);
		};
		
	
	
};