
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:set var="eventId" value="${event.eventId}" scope="session" /> --%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12">
	<a ng-click="cancelSpeakerEdtit(eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-30 padding-15 headbg">
			Edit Speaker Details
		</div>
		<div class="panel-body text-center">
			<form name="speakerEditForm" ng-submit="updateSpeaker(speaker)"	novalidate>
				<div>&nbsp;</div>
					
					<div class="col-md-12">
						<div class="col-md-6 form-group">
							<label>Speaker Name</label>
						
						
							<input type="text" class="input-text form-control" id="speakerName"
								ng-model="speaker.speakerName" name="speakerName"
								required>
								</div>
						
					
					<div class="col-md-6 form-group">
							<label>Description</label>
						
					
							<input type="text" class="input-text form-control" id="description"
								ng-model="speaker.description" name="description"
								required>
						</div>
						
						</div>
						<div class="col-md-12">
						<div class="col-md-6 form-group">
							<label>Location</label>
						
						
							<input type="text" class="input-text form-control" id="Location"
								ng-model="speaker.location" name="location"
								required>
						</div>
						
						<div class="col-md-6 form-group">
						
							<label>Title</label>
						
							<input type="text" class="input-text form-control" id="title"
								ng-model="speaker.title" name="Title"
								required>
						</div>
						</div>
						
						<div class="col-md-12">
						<div class="col-md-6 form-group">
							<label>Rating</label>
						
							<input type="text" class="input-text form-control" id="speakerDesc"
								ng-model="speaker.rating" name="speakerDesc"
								required>
						</div>
						
						
						
					<div class="form-group col-md-6" id="uploadDiv">
						<label class="flot-left">Upload File </label> <input type="file"
							class="form-control form-group" name="file" id="file"
							onchange="angular.element(this).scope().setFiles(this)">
						
					</div>
				</div>
				<button type="submit" class="btn button btn-primary save margin-2">Update</button>
				<div>&nbsp;</div>
			</form>
			</div>
		</div>
	</div>
	</div>