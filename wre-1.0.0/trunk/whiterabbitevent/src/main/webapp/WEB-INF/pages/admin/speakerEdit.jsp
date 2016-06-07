
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:set var="eventId" value="${event.eventId}" scope="session" /> --%>

<div class="container-fluid">
	<a ng-click="cancelSpeakerEdtit(eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-30 padding-15">
			Edit Speaker Details
		</div>
		<div class="panel-body text-center">
			<form name="speakerEditForm" ng-submit="updateSpeaker(speaker)"	novalidate>
				
					
					<div class="col-md-6">
						<div class="col-md-3">
							<label>Speaker Name</label>
						</div>
						<div class="col-md-5">
							<input type="text" class="input-text form-control" id="speakerName"
								ng-model="speaker.speakerName" name="speakerName"
								required>
						</div>
					</div>
					
						<div class="col-md-6">
						<div class="col-md-3">
							<label>Description</label>
						</div>
						<div class="col-md-5">
							<input type="text" class="input-text form-control" id="description"
								ng-model="speaker.description" name="description"
								required>
						</div>
						</div>
						
						<div class="col-md-6">
						<div class="col-md-3">
							<label>Location</label>
						</div>
						<div class="col-md-5">
							<input type="text" class="input-text form-control" id="Location"
								ng-model="speaker.location" name="location"
								required>
						</div>
						</div>
						
						<div class="col-md-6">
						<div class="col-md-3">
							<label>Title</label>
						</div>
						<div class="col-md-5">
							<input type="text" class="input-text form-control" id="title"
								ng-model="speaker.title" name="Title"
								required>
						</div>
						</div>
						
						<div class="col-md-6">
						<div class="col-md-3">
							<label>Rating</label>
						</div>
						<div class="col-md-5">
							<input type="text" class="input-text form-control" id="speakerDesc"
								ng-model="speaker.rating" name="speakerDesc"
								required>
						</div>
						</div>
						
						
						<div class="col-md-6">
					<div class="form-group col-md-6" id="uploadDiv">
						<label class="flot-left">Upload File </label> <input type="file"
							class="form-control form-group" name="file" id="file"
							onchange="angular.element(this).scope().setFiles(this)">
						
					</div>
				</div>
				<button type="submit" class="btn button  save margin-2">Update</button>
			</form>
			</div>
		</div>
	</div>
	</div>