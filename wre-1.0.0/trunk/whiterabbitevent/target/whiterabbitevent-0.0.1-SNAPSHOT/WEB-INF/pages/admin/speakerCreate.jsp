<!-- <h3>create speaker here</h3> -->


<!-- <h3>speaker create {{5+4}}</h3> -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<a ng-click="cancelCreateSpeaker(eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	<c:set var="userId" value="${user.userId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-5">Create Speaker</div>
		<div class="panel-body text-center">
			<form name="spCreateForm" ng-submit="spCreateForm.$valid && saveSpeaker(speaker)" novalidate>
				<div class="row">
					
					<div class="col-md-12">
						<div class=" form-group col-md-6">
							<label class="flot-left">Speaker Name <span style="color:red;">*</span></label> 
							<input autofocus="true" type="text" class="input-text form-control" name="speakerName" placeholder="Speaker Name" ng-model="speaker.speakerName" name="speakerName" required> 
                         	<span ng-if="spCreateForm.$submitted" ng-messages="spCreateForm.speakerName.$error" ng-messages-include="errors">
		  							</span>
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">Location<span style="color:red;">*</span></label> 
								<input type="text" class="input-text form-control" name="location"
								placeholder="Location" ng-model="speaker.location"  required> 
                         		<span ng-if="spCreateForm.$submitted" ng-messages="spCreateForm.location.$error" ng-messages-include="errors">
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">Title<span style="color:red;">*</span></label> 
								<input type="text" class="input-text form-control" name="title"
								placeholder="Title" ng-model="speaker.title"  required> 
                         		<span ng-if="spCreateForm.$submitted" ng-messages="spCreateForm.title.$error" ng-messages-include="errors">
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">Description<span style="color:red;">*</span></label> 
								<input type="text" class="input-text form-control" name="description"
								placeholder="Description" ng-model="speaker.description"  required> 
                         		<span ng-if="spCreateForm.$submitted" ng-messages="spCreateForm.description.$error" ng-messages-include="errors">
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">Rating<span style="color:red;">*</span></label> 
							<input type="text" class="input-text form-control" name="rating"
								placeholder="Rating" ng-model="speaker.rating"  required> 
                         	<span ng-if="spCreateForm.$submitted" ng-messages="spCreateForm.rating.$error" ng-messages-include="errors">
						</div>
					</div>
				</div>
				<div>&nbsp;</div>

				<button type="submit" class="btn button  save margin-2">Save</button>

			</form>

		</div>
	</div>
</div>
