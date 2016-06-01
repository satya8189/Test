var QuestionViewController = function($scope,$routeParams,$http, $location) {
	$scope.questionList={};
	$scope.eventId={};
	
	$scope.$on("$routeChangeSuccess", function () {
		
		$scope.eventId=$routeParams.eventId;
		//alert("adfs"+$routeParams.eventId);
			
		 $http.get('admin/questionList?eventId='+$routeParams.eventId).success(function(questionList){
			
				//alert("admin/questionList");
				    $scope.questionList = questionList;
				  //  alert("admin/questionList-------------------------");
				    

					  //=================================
						// create empty search model (object) to trigger $watch on update
							$scope.search = null;

							/*$scope.resetFilters = function () {
							// needs to be a function or it won't trigger a $watch
							$scope.search = {};
							};*/

							// 	pagination controls
							$scope.currentPage = 1;
							$scope.totalItems = $scope.questionList.length;
							$scope.entryLimit = 5; // items per page
							$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

							// $watch search to update pagination
							$scope.$watch('search', function (newVal, oldVal) {
							$scope.filtered = filterFilter($scope.questionList, newVal);
							$scope.totalItems = $scope.filtered.length;
							$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);
							$scope.currentPage = 1;
							}, true);
					    //===================================*/
					    
			
				    
				  	});
				 });
	
$scope.questionCreate = function(eventId) {
		//alert("question create"+eventId);
		$location.path("/questionCreate/"+eventId);

	};
	
	
	 $scope.questionEdit= function(questionId){
		  //alert("question id "+questionId);
		  //alert("event id"+$routeParams.eventId);
		  $location.path("/questionEdit/"+$routeParams.eventId+"/"+questionId);
		};
		
	
	
	
		$scope.cancelQuestionsView = function(eventId)
		{
			//alert("getting back to eventViewDetails"+eventId);
			$location.path("/eventViewDetails/"+eventId);
		};
		
	
	
};