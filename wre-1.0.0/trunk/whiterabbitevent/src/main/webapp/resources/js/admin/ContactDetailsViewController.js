var ContactDetailsViewController=function($scope, $http, $location, $routeParams,ngNotifier,$route){
	$scope.contact={};
	$scope.contact.eventId=$routeParams.eventId;
	
	$scope.$on("$routeChangeSuccess",function()
			{
			
			$scope.eventId=$routeParams.eventId;
			
			$http.get('admin/ViewContactDetails?eventId='+$routeParams.eventId).success(
					function(contact){
						$scope.contactList=contact;
						$scope.contactId=contact.contactId;
						$scope.eventId= contact.eventId;

						if($scope.contactList.length<1)
							{
								$scope.contactList={};
							}
					});
			});
		
	
	$scope.navigateToEventViewDetails= function(eventId)
	{
		$location.path("/eventViewDetails/"+eventId);
	};
	
	
	$scope.editContactDetails= function(contactId){
		$location.path("/editContatctDetails/"+contactId);
	};
	
	
	$scope.updateContactDetails = function(contact){
		$http.post('admin/updateContactDetails',contact).success(function() {
			$location.path("/contactDetailsView/"+contact.eventId);
				ngNotifier.notify("Contact Details updated successfully.!");
				}).error(function() {
				ngNotifier.error("error in updating contact details.!");
			});
				
	};	
	
	$scope.saveContactDetails = function(contact){
		
		$http.post('admin/saveContactDetails',contact).success(function() {
				$location.path("/contactDetailsView/"+contact.eventId);
				$route.reload();
				//$location.path("/eventViewDetails/"+contact.eventId);
				ngNotifier.notify("Contact Details updated successfully.!");
				
				}).error(function() {
				ngNotifier.error("error in updating contact details.!");
			});
				
	};	
	
	
};