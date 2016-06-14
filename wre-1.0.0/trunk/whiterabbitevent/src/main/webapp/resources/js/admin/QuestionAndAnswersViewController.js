
var QuestionAndAnswersViewController = function($scope,$location, $http, $routeParams) {
	
	$scope.eventId=$routeParams.eventId;
	
	$scope.$on("$routeChangeSuccess",function(){
		
		$http.get('admin/getParticipantsList?eventId='+$scope.eventId).success(function(pList){
			
			$scope.participantsList= pList;
			
			//alert("got participants.Length.."+$scope.participantsList.length);
			
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
			$scope.totalItems = $scope.participantsList.length;
			$scope.entryLimit = 5; // items per page
			$scope.noOfPages = Math.ceil($scope.totalItems
					/ $scope.entryLimit);
		

			// $watch search to update pagination
			$scope.$watch('search', function(newVal, oldVal) {
				$scope.filtered = filterFilter(
						$scope.participantsList, newVal);
				$scope.totalItems = $scope.filtered.length;
				$scope.noOfPages = Math.ceil($scope.totalItems
						/ $scope.entryLimit);
				$scope.currentPage = 1;
			}, true);

			// ===================================*/

		}).error(function() {
				ngNotifier.error("Error getting participants..");
		});

	});
	
	$scope.cancelQuestionAndAnswerView = function(eventId){
		//location.href = "#/eventViewDetails/" + eventId;
		$location.path("/eventViewDetails/"+eventId);
	};
	
	
	$scope.viewQuestionAndAnswers = function(participantId)
	{
		location.href='#/ViewParticipantAnswers/'+$scope.eventId+'/'+participantId;
	};
	
};