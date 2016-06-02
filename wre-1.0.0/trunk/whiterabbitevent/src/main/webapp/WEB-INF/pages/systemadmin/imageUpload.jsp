
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>



<form name="createEvent" ng-submit="uploadImage()" enctype="multipart/form-data">

<div class="container">

<a ng-click="cancelUploadLayout(eventId)"> <i
		class="glyphicon glyphicon-chevron-left"></i>
	</a> 
	
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15">Upload Image</div>
  <div class="panel-body text-center">
  
   
	 
	 <div class="col-md-6">
						<div class="form-group col-md-6" 
							id="uploadDiv">
							<label class="flot-left">Upload Image </label> 
							<input type="file" class="form-control form-group" name="file" id="file" onchange="angular.element(this).scope().setFiles(this)">
							
						</div>
					</div>
	</div>
    <div>&nbsp;</div>
<input type="submit" value="Save" class="btn button save margin-2" ng-click="submitted=true"/>
</div>
</div>

</form>

<div>&nbsp;</div>
                        <div class="col-md-10 col-md-offset-1">
                                <div>&nbsp;</div>
                                <div class="heading-with-icon">Workspace Images</div>
                                <div>&nbsp;</div>
                                <div class="upload-image  col-md-3"
                                        ng-repeat="image in eventImages">
                                        <img src="{{image.url}}" class="img-responsive margin-auto"
                                                style="height: 150px;width:120px;" /> <a
                                                class="glyphicon glyphicon-trash upload"
                                                ng-click="deletePracticeImage(image)"></a>
                                </div>
                        </div>
