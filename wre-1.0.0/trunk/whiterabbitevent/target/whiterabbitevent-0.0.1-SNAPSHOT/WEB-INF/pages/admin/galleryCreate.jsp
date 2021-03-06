
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<toaster-container></toaster-container>
<jsp:include page="error-messages.jsp"></jsp:include>
<div class="container-fluid">
	<a ng-click="cancelGalleryCreate(gallery.eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	<form name="createEvent" ng-submit="createEvent.$valid && createGallery(gallery)" enctype="multipart/form-data" novalidate>
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15">Create Gallery</div>
  <div class="panel-body text-center">
  
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Gallery_Name <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="gallaryName" placeholder="Gallery_Name"  ng-model="gallery.name" 
      name="galleryName"   required>
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.galleryName.$error" ng-messages-include="errors"></span>
      </div>
      </div>
	 </div>
	 
	 <div class="col-md-6">
						<div class="form-group col-md-6" 
							id="uploadDiv">
							<label class="flot-left">Upload File </label> 
							<input type="file" class="form-control form-group" name="file" id="file" onchange="angular.element(this).scope().setFiles(this)">
							<span ng-if="createEvent.$submitted" ng-messages="createEvent.file.$error" ng-messages-include="errors"></span>
							<!--  <input type="file" name="file" class="form-control form-group" onchange="angular.element(this).scope().uploadFile(this.files)"/> -->
						</div>
					</div>
	 
	</div>
    <div>&nbsp;</div>
<input type="submit" value="Save" class="btn button save margin-2" ng-click="submitted=true"/>
</div>
</div>

</form>
