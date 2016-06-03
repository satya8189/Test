/**
 * 
 */
var ClientEventCreateController = function($scope, $http, $routeParams,$location,ngNotifier) {
	
	
	$scope.usersList = {};
	$scope.servicesList = {};
	$scope.event ={};
	$scope.event.clientId=$routeParams.clientId;
	$("#uploadDivError").hide();
    $("#extensionDivError").hide();
	
	$scope.$on('$routeChangeSuccess', function() {
	$http.get('systemadmin/getUsersList?clientId='+$routeParams.clientId).success(function(usersList){
        $scope.usersList = usersList;
    });
	
	$http.get('systemadmin/servicesList').success(function(servicesList){
		$scope.servicesList = servicesList ;
	});
	
	});
	
	
	$scope.saveEvent = function(event){
		var type='event_home';
		$scope.disabled=true;
		$("#uploadDivError").hide();
        $("#extensionDivError").hide();
        var formData=new FormData();
        if(file.files[0]==undefined){
            $scope.disabled=false;
            $("#uploadDivError").show();
        }else{
        	formData.append("file",file.files[0]);
        	if(file.files[0].type=='image/jpeg' || file.files[0].type=='image/jpg'
                || file.files[0].type=='image/png' || file.files[0].type=='image/gif'){
        	$http.post('systemadmin/saveEvent',event).success(function(event){
        		if(file.files[0]!=undefined){
        		$http.post('systemadmin/uploadEventHomeLogo?eventId='+event.eventId+'&type='+type, formData, {
                    transformRequest: function(data, headersGetterFunction) {
                        return data;
                    },
                    headers: { 'Content-Type': undefined }
                    }).success(function(data, status) {   
                            $("#file").val('');
                            $("#uploadDivError").hide();
                            $("#extensionDivError").hide();
                            $('#fileName').val('');
                            $scope.disabled=false;
                            ngNotifier.notify("Logo uploaded successfully !");
                    });
        		
        		}
    			ngNotifier.notify("Event Created Successfully !");
    			$location.path("/clientEventsView/"+event.clientId);
    			
    		}).error(function() {
    			alert("sdfsdf");
    			ngNotifier.notify("Event not Created Successfully !");
    		});
        	}else{
            		$scope.disabled=false;
                    $("#extensionDivError").show();
        	}
        }
		
	};
	
	$scope.cancelClientEvent = function(){
		$location.path("/clientEventsView/"+$routeParams.clientId);
	}
	
};

