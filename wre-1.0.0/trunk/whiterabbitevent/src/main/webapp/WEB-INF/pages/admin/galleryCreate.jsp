

<div class="col-md-8 col-md-offset-2 margin-top-5">

	<a ng-click="cancelGalleryCreate(gallery.eventId)" class="btn btn-primary backbtn">
		Back
	</a>
	
<form name="createEvent" ng-submit="createEvent.$valid && createGallery(gallery)" enctype="multipart/form-data" novalidate>
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Create Gallery</div>
  <div class="panel-body panelbody-bg">
  <div>&nbsp;</div>
    <div class="row">
	<div class="col-md-12">
			  <div class="form-group col-md-6" >
		        	<label class="flot-left">Gallery_Name <span style="color:red;">*</span></label>
		      		<input type="text" class="input-text form-control" id="gallaryName" placeholder="Gallery_Name"  ng-model="gallery.name" 
		      			name="galleryName"   required>
		      		<span ng-if="createEvent.$submitted" ng-messages="createEvent.galleryName.$error" ng-messages-include="errors" style="color:red"></span>
		      </div>
     		  
     		  <div class="form-group col-md-6 "	id="uploadDiv">
     		  		<label class="flot-left">Upload Image </label>
					<input class="input-text form-control" id="file" ng-model="filename" valid-file name="file" required type="file" accept="image/x-png, image/gif, image/jpeg"/>
					<span style="color:red" ng-if="createEvent.file.$invalid" ng-show="createEvent.$submitted">Please select a file to upload</span>
					<!-- <span ng-if="createEvent.file.$invalid" ng-messages="createEvent.file.$file" ng-messages-include="errors" style="color:red"></span> -->
			  </div>
					
    <div>&nbsp;</div>
    <div class="text-center">
<input type="submit" value="Save" class="btn button btn-primary save margin-2" ng-click="submitted=true"/>
</div>
<div>&nbsp;</div>
</div>
</div>
</div>
</div>
</form>
