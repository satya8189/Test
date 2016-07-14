

<toaster-container></toaster-container>

<form name="createEvent" ng-submit="createEvent.$valid && uploadImage()" enctype="multipart/form-data" novalidate>
<div class="container">
<div class="col-md-6 col-md-offset-3">

<a ng-click="cancelUploadLayout(eventId)" class="btn btn-primary backbtn"> 
Back
</a> 
	
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Event Images Upload</div>
  <div class="panel-body  panelbody-bg">
   <div>&nbsp;</div>
	 <div class="col-md-12">
		<div class="form-group col-md-6 col-md-offset-3" 
				id="uploadDiv">
			<label >Upload Image </label> 
				<!-- <input type="file" class="form-control form-group" name="file" id="file" onchange="angular.element(this).scope().setFiles(this)"> -->
				<input class="input-text form-control" id="file" ng-model="filename" valid-file name="file" required type="file" accept="image/*"/>
				<span style="color:red" ng-if="createEvent.file.$invalid" ng-show="createEvent.$submitted">Please select a file to upload</span>
		</div>
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

<div>&nbsp;</div>
             	<div class="col-md-12">
                 <div>&nbsp;</div>
                   <div class="viewheading"><span class="headingspan">Uploaded Images View</span></div>
                     
                         <div class="upload-image  col-md-3" ng-if="eventImages.length>0" ng-repeat="image in eventImages">
                                 <!-- URL: {{image.url}} -->
                                 <img src="{{image.url}}" class="img-responsive margin-auto"
                                         style="height: 150px; width:150px;"/> 
                                 <a class="glyphicon glyphicon-trash upload" ng-click="deleteGallery(image)"></a>
                         </div>
                         <div ng-if="eventImages.length==0" class="text-center">
                              <div class="col-md-12">&nbsp;</div>
                         	<h4>No images uploaded yet.</h4>
                         </div>
                 </div>