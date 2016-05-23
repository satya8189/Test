var EventViewDetailsController = function($scope,$routeParams,$http,$location) {
	$scope.eventList = {};

	$scope.$on("$routeChangeSuccess", function () {
		$scope.eventId=$routeParams.eventId;
		
			
			 $http.get('admin/eventdetailsList?eventId='+$scope.eventId).success(function(eventList){
				
				    $scope.eventList = eventList;
				   
				    });
				 });

	$scope.serviceDetails = function(event){
	
		if(event.serviceId=="2"){
	location.href="#/agendoDetails/"+event.eventId;
		}
		else if(event.serviceId=="3"){
			location.href="#/newsFeedView/"+event.eventId;	
			
		}else if(event.serviceId=="4"){
			location.href="#/galleryView/"+event.eventId;	
			
		}else if(event.serviceId=="1"){
			location.href="#/detailsView/"+event.eventId;	
			
		}else if(event.serviceId=="17"){
			
			location.href="#/invite/"+event.eventId;	
			
			
			
		}else if(event.serviceId=="6"){
			alert('document condiation');
			location.href="#/videoView/"+event.eventId;	
			
			
		}else if(event.serviceId=="7"){
			alert('document condiation');
			location.href="#/documentView/"+event.eventId;	
			
	};
	};
	
	
};
