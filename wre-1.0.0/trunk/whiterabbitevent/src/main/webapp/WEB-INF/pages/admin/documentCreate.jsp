
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>



<form name="createEvent" ng-submit="createDocument(document)" enctype="multipart/form-data">

<div class="col-md-12">
	<a ng-click="cancelDocumentCreate(document.eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15">Create Document</div>
  <div class="panel-body text-center">
  
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Document_Name <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_Name" placeholder="Document"  ng-model="document.name" 
      name="gallery"   required>
      </div>
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
