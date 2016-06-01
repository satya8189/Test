/**
 * 
 */
var ClientCreateController = function($scope,$http,$location,ngNotifier){
	
	
	$scope.saveClient = function(client){
		alert("saving");
		$http.post('systemadmin/saveClient',client).success(
		function(){
			alert("save successfully");
			 ngNotifier.notify("Client Created Successfully !");
			$location.path("/clientsView");
		}).
		error(function() {
			ngNotifier.notify("Client Not Created Successfully !");
			alert("demo");
		});
	}
	$scope.cancelEvent = function(){
		$location.path("/clientsView");
	}
} 