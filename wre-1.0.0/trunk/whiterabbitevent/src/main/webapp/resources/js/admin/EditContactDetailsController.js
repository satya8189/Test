var EditContactDetailsController= function($scope, $http, $location, $routeParams,ngNotifier){
	
	$scope.$on("$routeChangeSuccess", function(){
		//alert("working...."+$routeParams.contactId);

		$http.get('admin/getContactDetailsForEdit?contactId='+$routeParams.contactId).success(
				//function(contactDetailsList){
				function(contactDetails){
					$scope.contact= contactDetails;
					//alert("contact name==="+contactDetails.contactName);
					//$scope.eventId=contactDetails.eventId;
					//alert(contactDetailsList.length);
				});
		});
	
	$scope.cancelEditContactDetails= function(eventId)
	{
		//alert("back to contactDetailsView"+eventId);
		$location.path("/contactDetailsView/"+eventId);
	};
	
	$scope.updateContactDetails = function(contact){
		
		$http.post('admin/updateContactDetails',contact).success(function() {
		//	alert("Contact Details Updated successfully....!");
			$location.path("/contactDetailsView/"+contact.eventId);
				ngNotifier.notify("Contact Details updated successfully.!");
				}).error(function() {
				ngNotifier.error("error in updating contact details.!");
			});
				
	};	
				
};