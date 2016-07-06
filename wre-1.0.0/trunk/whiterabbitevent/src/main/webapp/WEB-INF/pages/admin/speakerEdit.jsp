<%@include file="error-messages.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}
</style>

<div class="col-md-12">
<h3 class="text-center">Edit Speaker Details</h3>
	<a ng-click="cancelSpeakerEdtit(eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-30 padding-15 headbg">
			Edit Speaker Details
		</div>
		<div class="panel-body new-body">
			<form name="orgCreateForm" ng-submit="orgCreateForm.$valid && updateSpeaker(speaker)"	novalidate>
				<div>&nbsp;</div>
					
					<div class="col-md-12">
						<div class="col-md-6 form-group">
							<label>Speaker Name</label>
							<input type="text" class="input-text form-control" id="speakerName"
								ng-model="speaker.speakerName" name="speakerName"
								required>
							<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.speakerName.$error" ng-messages-include="errors">
		  						</span>
						</div>
						
						<div class="col-md-6 form-group">
							<label>Description</label>
								<input type="text" class="input-text form-control" id="description"
								ng-model="speaker.description" name="description"
								required>
								<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.description.$error" ng-messages-include="errors">
		  						</span>
						</div>
						
						</div>
						<div class="col-md-12">
						<div class="col-md-6 form-group">
							<label>Location</label>
						
							<input type="text" class="input-text form-control" id="Location"
								ng-model="speaker.location" name="location"
								required>
								<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.location.$error" ng-messages-include="errors">
		  						</span>
						</div>
						
						<div class="col-md-6 form-group">
							<label>Title</label>
							<input type="text" class="input-text form-control" id="title"
								ng-model="speaker.title" name="Title"
								required>
								<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.Title.$error" ng-messages-include="errors">
		  						</span>
						</div>
						</div>
						
						<div class="col-md-12">
						<div class="col-md-6 form-group">
							<label>Rating</label>
							<input type="text" class="input-text form-control" id="speakerDesc"
								ng-model="speaker.rating" name="speakerDesc"
								required>
								<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.speakerDesc.$error" ng-messages-include="errors">
		  						</span>
						</div>
						
					<div class="form-group col-md-6" id="uploadDiv">
						<label class="flot-left">Upload File </label> <input type="file"
							class="form-control form-group" name="file" id="file"
							onchange="angular.element(this).scope().setFiles(this)">
					</div>
				</div>
				<div class="text-center">
				<button type="submit" class="btn button btn-primary save margin-2">Update</button>
				</div>
				<div>&nbsp;</div>
			</form>
			</div>
		</div>
	</div>
	</div>