<%@include file="error-messages.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12 margin-top-5">

	<a ng-click="navigateToDetailsView(event.eventId)" class="btn btn-primary backbtn"> Back
	</a>

	
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">
			Details</div>
		<div class="panel-body new-body">
			<form name="eventCreateForm"
				ng-submit="eventCreateForm.$valid && updateEvent(event)"
				novalidate>
				<div>&nbsp;</div>
				<div class="col-md-12">

						<div class="col-md-6 form-group">
							<label>Evene Name :</label>
				
							<input type="text" class="input-text form-control" id="eventName"
								placeholder="EventName" ng-model="event.eventName" name="EventName"
								required>
								<span ng-if="eventCreateForm.$submitted" ng-messages="eventCreateForm.EventName.$error" ng-messages-include="errors" style="color:red"></span>
						</div>
					

						<div class="col-md-6 form-group">
							<label>Event Desc :</label>
						
							<input type="text" class="input-text form-control" id="eventDesc"
								placeholder="EventDesc" ng-model="event.eventDesc" name="eventDesc"
								required>
								<span ng-if="eventCreateForm.$submitted" ng-messages="eventCreateForm.eventDesc.$error" ng-messages-include="errors" style="color:red"></span>
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="col-md-6 form-group">
							<label>Event Agenda :</label>
						
							<input type="text" class="input-text form-control" id="eventAgenda"
								placeholder="eventAgenda" ng-model="event.eventAgenda" name="eventAgenda"
								required>
								<span ng-if="eventCreateForm.$submitted" ng-messages="eventCreateForm.eventAgenda.$error" ng-messages-include="errors" style="color:red"></span>
						</div>
				
						<div class="col-md-6 form-group">
							<label>Event Address :</label>
						
							<input type="text" class="input-text form-control" id="eventAddress"
								placeholder="EventAddress" ng-model="event.eventAddress" name="eventAddress"
								required>
							<span ng-if="eventCreateForm.$submitted" ng-messages="eventCreateForm.eventAddress.$error" ng-messages-include="errors" style="color:red"></span>
						</div>
					</div>
					<div>&nbsp;</div>
			<div class="text-center">
				<button type="submit" class="btn button btn-primary save margin-2"
					ng-click="validateHiddenFields()">update</button>
</div>
<div>&nbsp;</div>
			</form>

		</div>
	</div>
	<div>&nbsp;</div>