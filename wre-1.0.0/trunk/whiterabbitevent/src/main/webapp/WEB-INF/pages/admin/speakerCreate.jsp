<%@include file="error-messages.jsp"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12">
	<a ng-click="cancelCreateSpeaker(speaker.eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	<c:set var="userId" value="${user.userId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-5 headbg">Create Speaker</div>
		<div class="panel-body text-center">
			<form name="spCreateForm" ng-submit="spCreateForm.$valid && saveSpeaker(speaker)"  enctype="multipart/form-data" novalidate>
				<div class="row">
					<div>&nbsp;</div>
					<div class="col-md-12">
						<div class=" form-group col-md-6">
							<label class="flot-left">Speaker Name <span style="color:red;">*</span></label> 
							<input autofocus="true" type="text" class="input-text form-control" name="speakerName" placeholder="Speaker Name" ng-model="speaker.speakerName" name="speakerName" required> 
                         	<span ng-if="spCreateForm.$submitted" ng-messages="spCreateForm.speakerName.$error" ng-messages-include="errors" style="color:red">
		  							</span>
						</div>
					
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">Location<span style="color:red;">*</span></label> 
								<input type="text" class="input-text form-control" name="location"
								placeholder="Location" ng-model="speaker.location"  required> 
                         		<span ng-if="spCreateForm.$submitted" ng-messages="spCreateForm.location.$error" ng-messages-include="errors"style="color:red">
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">Title<span style="color:red;">*</span></label> 
								<input type="text" class="input-text form-control" name="title"
								placeholder="Title" ng-model="speaker.title"  required> 
                         		<span ng-if="spCreateForm.$submitted" ng-messages="spCreateForm.title.$error" ng-messages-include="errors"style="color:red">
						</div>
					
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">Description<span style="color:red;">*</span></label> 
								<input type="text" class="input-text form-control" name="description"
								placeholder="Description" ng-model="speaker.description"  required> 
                         		<span ng-if="spCreateForm.$submitted" ng-messages="spCreateForm.description.$error" ng-messages-include="errors"style="color:red">
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">Rating<span style="color:red;">*</span></label> 
							<input type="text" class="input-text form-control" name="rating"
								placeholder="Rating" ng-model="speaker.rating"  required> 
                         	<span ng-if="spCreateForm.$submitted" ng-messages="spCreateForm.rating.$error" ng-messages-include="errors"style="color:red">
						</div>
				
				
				
				<div class="col-md-6">
					<!-- <div class="form-group col-md-6" id="uploadDiv">
						<label class="flot-left">Upload File </label> <input type="file"
							class="form-control form-group" name="file" id="file"
							onchange="angular.element(this).scope().setFiles(this)">
					</div>
					 -->
					<div class="form-group col-md-6 "	id="uploadDiv">
     		  				<label class="flot-left">Upload  File </label>
							<input class="input-text form-control" id="file" ng-model="filename" valid-file name="file" required type="file" accept="application/*"/>
							<span style="color:red" ng-if="spCreateForm.file.$invalid" ng-show="spCreateForm.$submitted">Please select a file to upload</span>
							<!-- <span ng-if="createEvent.file.$invalid" ng-messages="createEvent.file.$file" ng-messages-include="errors" style="color:red"></span> -->
			  		</div>
				</div>
				<div>&nbsp;</div>
				<div class="text-center">
					<button type="submit" class="btn button btn-primary save margin-2">Save</button>
				</div>
				<div>&nbsp;</div>
			</form>

		</div>
	</div>
</div>
