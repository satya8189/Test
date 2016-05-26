var VenueLayoutController=function($scope,$location,$http,$routeParams){
	
	$scope.$on("$routeChangeSuccess",function(){
		alert("venuelayoutController..."+$routeParams.eventId);
		
	});
	
};