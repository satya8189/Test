var DocumentCreateController = function($scope, $http, $location, $routeParams,ngNotifier) {
	$scope.file={};
	$scope.document={};
	$scope.document.eventId=$routeParams.eventId;
	
	
		$scope.createDocument = function(document) {
			
			var fd = new FormData();
			//alert("hi");

			  // Take the first selected file
			    fd.append("file", file.files[0]);
			    fd.append("eventId",document.eventId);
			    fd.append("name",document.name);
			    fd.append("type","document");
			    $http.post('admin/createGallery',fd, {
			     withCredentials : true,
			     headers : {
			      'Content-Type' : undefined
			     },
			     transformRequest : angular.identity
			    }).success(function(data) {
			  //  	alert("success");
			    	ngNotifier.notify("Record Created Successfully !");
			     $location.path("/documentView/"+document.eventId);
			    }).error(function() {
					ngNotifier.notifyError("Please choose file !");
				});

	};

	$scope.cancelDocumentCreate = function(eventId) {
		$location.path("/documentView/"+eventId);

	};

	};	


		

		


		
		


			

			
			

		







	

	


	
	


		

		
		

	
