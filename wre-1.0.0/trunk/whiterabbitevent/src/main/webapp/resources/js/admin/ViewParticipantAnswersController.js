var ViewParticipantAnswersController=function($scope,$http,$routeParams,$location){
	
	$scope.eventId=$routeParams.eventId;
	
	
	$scope.$on("$routeChangeSuccess",function(){
		alert("working in ViewParticipantAnswersController eventId--"+$scope.eventId+"partcipant...id...."+$routeParams.participantId);
		//get participant answers for those eventid and participantid
		$http.get('admin/getViewParticipantAnswers?eventId='+$scope.eventId+'&&participantId='+$routeParams.participantId).success(function(sqaList){
			
			$scope.partcipantQuestionAnswerList= sqaList;
			
			// =================================
			// create empty search model (object) to trigger
			// $watch on update
			$scope.search = null;

			/*
			 * $scope.resetFilters = function () { // needs to
			 * be a function or it won't trigger a $watch
			 * $scope.search = {}; };
			 */

			// pagination controls
			$scope.currentPage = 1;
			$scope.totalItems = $scope.partcipantQuestionAnswerList.length;
			$scope.entryLimit = 5; // items per page
			$scope.noOfPages = Math.ceil($scope.totalItems
					/ $scope.entryLimit);
		

			// $watch search to update pagination
			$scope.$watch('search', function(newVal, oldVal) {
				$scope.filtered = filterFilter(
						$scope.partcipantQuestionAnswerList, newVal);
				$scope.totalItems = $scope.filtered.length;
				$scope.noOfPages = Math.ceil($scope.totalItems
						/ $scope.entryLimit);
				$scope.currentPage = 1;
			}, true);

			// ===================================*/
			
		}).error(function(){
			alert("error getting participant answers");
		});
		
		
	});
	
	$scope.cancelParticipantAnswersView = function(){
		$location.path("/QuestionAndAnswersView/"+$scope.eventId);
	};
};