<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>
<form name="createEvent" ng-submit="uploadLayout()" enctype="multipart/form-data">

<div class="col-md-12">

<a ng-click="cancelUploadLayout(upload.eventId)"> <i
		class="fa fa-angle-left back"></i>
	</a> 
	
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Upload VenuLayout</div>
  <div class="panel-body text-center">
   <div class="col-md-12">
						<div class="form-group col-md-6 col-md-offset-3" 
							id="uploadDiv">
							<label class="flot-left">Upload File </label> 
							<input type="file" class="form-control form-group" name="file" id="file" onchange="angular.element(this).scope().setFiles(this)">
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

</form>
 <div>&nbsp;</div>