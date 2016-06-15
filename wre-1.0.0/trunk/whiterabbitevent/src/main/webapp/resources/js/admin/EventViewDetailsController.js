var EventViewDetailsController = function($scope,$routeParams,$http,$location) {
	$scope.serviceList = {};

	$scope.$on("$routeChangeSuccess", function () {
		$scope.eventId=$routeParams.eventId;
		
			
			 $http.get('admin/eventdetailsList?eventId='+$scope.eventId).success(function(serviceList){
				
				    $scope.serviceList = serviceList;
				    
				   
				    });
				 });

	$scope.serviceDetails = function(event){
	
		if(event.serviceId=="2"){
	location.href="#/agendoDetails/"+event.eventId;
		}
		else if(event.serviceId=="3"){
			//alert("newsFeedView-----"+event.eventId);
			location.href="#/newsFeedView/"+event.eventId;	
			
		}else if(event.serviceId=="4"){
			location.href="#/galleryView/"+event.eventId;	
			
		}else if(event.serviceId=="1"){
			location.href="#/detailsView/"+event.eventId;	
			
		}else if(event.serviceId=="17"){
			
			location.href="#/invite/"+event.eventId;	
			
		}else if(event.serviceId=="6"){
			location.href="#/videoView/"+event.eventId;	
			
			
		}else if(event.serviceId=="7"){
			location.href="#/documentView/"+event.eventId;	
		
		}else if(event.serviceId=="16"){
			location.href="#/questionView/"+event.eventId;	
		
		}else if(event.serviceId=="15"){
			location.href="#/sponsorPageView/"+event.eventId;
			
		}else if(event.serviceId=="14"){
			//alert("kk");
			location.href="#/speakerProfileView/"+event.eventId;
		}else if(event.serviceId=="13"){
			//alert("kk");
			location.href="#/venueLayout/"+event.eventId;
			
		}else if(event.serviceId=="8"){
			//alert("kk");
			location.href="#/QuestionAndAnswersView/"+event.eventId;
		
		}else if(event.serviceId=="19"){
			//alert("serviceId..."+event.serviceId+"&&service.eventId=="+event.eventId);
			location.href="#/contactDetailsView/"+event.eventId;
		
		}else if(event.serviceId=="18"){
			//alert("serviceId..."+event.eventId);
			location.href="#/navigateToChatList/"+event.eventId;

		}else if(event.serviceId=="11"){
			//alert("serviceId..SocialMedia.."+event.eventId);
			location.href="#/SocialMedia/"+event.eventId;
			
			//networking
	    }else if(event.serviceId=="12"){
		location.href="#/networkingView/"+event.eventId;

	};

	};
	
	
};
