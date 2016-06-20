
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<toaster-container></toaster-container>
<jsp:include page="error-messages.jsp"></jsp:include>
<div class="container-fluid">
	<a ng-click="cancelGalleryCreate(gallery.eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	<form name="createEvent" ng-submit="createEvent.$valid && createGallery(gallery)" enctype="multipart/form-data" novalidate>
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Create Gallery</div>
  <div class="panel-body text-center">
  <div>&nbsp;</div>
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Gallery_Name <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="gallaryName" placeholder="Gallery_Name"  ng-model="gallery.name" 
      name="galleryName"   required>
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.galleryName.$error" ng-messages-include="errors" style="color:red"></span>
      </div>
     
						<div class="form-group col-md-6" 
							id="uploadDiv">
							<label class="flot-left">Upload File </label> 
							<input type="file" class="form-control form-group" name="file" id="file" onchange="angular.element(this).scope().setFiles(this)" required>
							<span ng-if="createEvent.$submitted" ng-messages="createEvent.file.$error" ng-messages-include="errors"></span>
							<!--  <input type="file" name="file" class="form-control form-group" onchange="angular.element(this).scope().uploadFile(this.files)"/> -->
						</div>
					</div>
	 
	</div>
    <div>&nbsp;</div>
<input type="submit" value="Save" class="btn button btn-primary save margin-2" ng-click="submitted=true"/>
<div>&nbsp;</div>
</div>
</div>

</form>
