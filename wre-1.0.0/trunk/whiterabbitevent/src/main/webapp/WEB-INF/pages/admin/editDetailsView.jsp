<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12">
	<a ng-click="navigateToDetailsView(event.eventId)"> <i class="fa fa-angle-left back"></i>
	</a>
<div>&nbsp;</div>
	<c:set var="eventId" value="${event.eventId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">
			Details</div>
		<div class="panel-body text-center">
			<form name="eventCreateForm"
				ng-submit="updateEvent(event)"
				novalidate>
				<div>&nbsp;</div>
				<div class="col-md-12">

						<div class="col-md-6 form-group">
							<label>Evene Name :</label>
				
							<input type="text" class="input-text form-control" id="eventName"
								placeholder="EventName" ng-model="event.eventName" name="EventName"
								required>
						</div>
					

						<div class="col-md-6 form-group">
							<label>EventDesc :</label>
						
							<input type="text" class="input-text form-control" id="eventDesc"
								placeholder="EventDesc" ng-model="event.eventDesc" name="eventDesc"
								required>
						</div>
					</div>
					
					<div class="col-md-12">

						<div class="col-md-6 form-group">
							<label>EventAgenda :</label>
						
							<input type="text" class="input-text form-control" id="eventAgenda"
								placeholder="eventAgenda" ng-model="event.eventAgenda" name="eventAgenda"
								required>
						</div>
				
						<div class="col-md-6 form-group">
							<label>EventAddress :</label>
						
							<input type="text" class="input-text form-control" id="eventAddress"
								placeholder="EventAddress" ng-model="event.eventAddress" name="eventAddress"
								required>
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