/**
 * 
 */
var ClientCreateController = function($scope,$http,$location,ngNotifier){
	
	
	$scope.saveClient = function(client){
		
		$http.post('systemadmin/saveClient',client).success(
		function(){
			
			 ngNotifier.notify("Client Created Successfully !");
			$location.path("/clientsView");
		}).
		error(function() {
			ngNotifier.notify("Client Not Created Successfully !");
			
		});
	};
	
	$scope.cancelEvent = function(){
		$location.path("/clientsView");
	};
} ;