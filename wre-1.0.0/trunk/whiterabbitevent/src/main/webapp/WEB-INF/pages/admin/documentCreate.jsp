<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<%@include file="error-messages.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>



<form name="createEvent" ng-submit="createEvent.$valid && createDocument(document)" enctype="multipart/form-data" novalidate>
<h3 class="text-center">Create Document</h3>
<div class="col-md-12">
	<a ng-click="cancelDocumentCreate(document.eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Create Document</div>
  <div class="panel-body panelbody-bg">
   <div>&nbsp;</div>
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Document_Name <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_Name" placeholder="Document"  ng-model="document.name" 
      name="gallery"   required>
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.gallery.$error" ng-messages-include="errors" style="color:red">
		  						</span>

</div>
      
						<div class="form-group col-md-6 "	id="uploadDiv">
     		  				<label class="flot-left">Upload a Document </label>
							<input class="input-text form-control" id="file" ng-model="filename" valid-file name="file" required type="file" accept="application/*"/>
							<span style="color:red" ng-if="createEvent.file.$invalid" ng-show="createEvent.$submitted">Please select a file to upload</span>
							<!-- <span ng-if="createEvent.file.$invalid" ng-messages="createEvent.file.$file" ng-messages-include="errors" style="color:red"></span> -->
			  			</div>
					</div>
	</div>
    <div>&nbsp;</div>
    <div class="text-center">
<input type="submit" value="Save" class="btn button btn-primary save margin-2" ng-click="submitted=true"/>
 
 </div>
 <div>&nbsp;</div>
</div>
</div>

</form>
