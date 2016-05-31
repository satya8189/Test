var SponsorPageViewController = function($scope, $http, $location,
		$routeParams, ngNotifier, filterFilter) {
	$scope.$on("$routeChangeSuccess", function() {
		$scope.eventId = $routeParams.eventId;

		$http.get('admin/sponsorsList?eventId=' + $routeParams.eventId)
				.success(
						function(sList) {

							$scope.sponsorsList = sList;

														
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
							$scope.totalItems = $scope.sponsorsList.length;
							$scope.entryLimit = 5; // items per page
							$scope.noOfPages = Math.ceil($scope.totalItems
									/ $scope.entryLimit);
						

							// $watch search to update pagination
							$scope.$watch('search', function(newVal, oldVal) {
								$scope.filtered = filterFilter(
										$scope.sponsorsList, newVal);
								$scope.totalItems = $scope.filtered.length;
								$scope.noOfPages = Math.ceil($scope.totalItems
										/ $scope.entryLimit);
								$scope.currentPage = 1;
							}, true);

							// ===================================*/

						}).error(function() {
					ngNotifier.error("Error getting sponsors..");
				});

	});

	// navigateToSponsorCreate
	$scope.navigateToSponsorCreate = function(eventId) {
		$scope.eventId = eventId;
		// alert("navigating to createSponsor"+eventId);
		$location.path("/sponsorCreate/" + eventId);

	};

	// cancelSponsorPageView
	$scope.cancelSponsorPageView = function(eventId) {
		// alert("Getting Back to SponsorPageViewView"+eventId);
		location.href = "#/eventViewDetails/" + eventId;
	};

	$scope.editSponsor = function(sponcorId) {
		// alert("working=="+sponcorId);
		$location.path("/editSponsor/" + sponcorId);

	};

};