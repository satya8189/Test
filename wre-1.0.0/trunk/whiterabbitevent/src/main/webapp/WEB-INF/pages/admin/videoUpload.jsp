
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>

<form name="createEvent" ng-submit="createEvent.$valid && uploadVideo(video)"  enctype="multipart/form-data" >

<div class="container">
	<a ng-click="cancelUploadVideo(video.eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15">Create Document</div>
  <div class="panel-body text-center">
  
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Video Name <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_Name" placeholder="Document"  ng-model="video.name" 
      name="gallery"   required>
      </div>
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.gallery.$error" ng-messages-include="errors"></span>
      </div>
	 </div>
	 
	 
	 <div class="col-md-6">
						<div class="form-group col-md-6" 
							id="uploadDiv">
							<label class="flot-left">Upload File </label> 
							<input type="file" class="form-control form-group" name="file" id="file" onchange="angular.element(this).scope().setFiles(this)">
							<!--  <input type="file" name="file" class="form-control form-group" onchange="angular.element(this).scope().uploadFile(this.files)"/> -->
						</div>
					</div>
	
	 
</div>
    <div>&nbsp;</div>
<input type="submit" value="Save" class="btn button save margin-2" ng-click="submitted=true"/>
</div>
</div>

</form>
