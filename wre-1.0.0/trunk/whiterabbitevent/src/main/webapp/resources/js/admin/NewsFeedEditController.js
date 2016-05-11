

var NewsFeedEditController = function($scope,$routeParams,$http,$location) {
	$scope.news = {};

	$scope.$on("$routeChangeSuccess", function () {
		
alert("fdsfdsf");
			
		 $http.get('admin/newsEditDetails?newsFeedId=1').success(function(news){
			 alert("agendoDetailsAgendoViewController");
				


				    
				  	});
				 });
	
	
	

	
};