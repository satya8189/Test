<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<a ng-click="navigateToDetailsView(event.eventId)"> <i class="glyphicon glyphicon-chevron-left"></i>
	</a>

	<c:set var="eventId" value="${event.eventId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15">
			Details</div>
		<div class="panel-body text-center">
			<form name="eventCreateForm"
				ng-submit="updateEvent(event)"
				novalidate>
				
				<div class="col-md-12">

						<div class="col-md-2">
							<label>Evene Name</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="eventName"
								placeholder="EventName" ng-model="event.eventName" name="EventName"
								required>
						</div>
					</div>
					
					<div class="col-md-12">

						<div class="col-md-2">
							<label>EventDesc</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="eventDesc"
								placeholder="EventDesc" ng-model="event.eventDesc" name="eventDesc"
								required>
						</div>
					</div>
					
					<div class="col-md-12">

						<div class="col-md-2">
							<label>EventAgenda</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="eventAgenda"
								placeholder="eventAgenda" ng-model="event.eventAgenda" name="eventAgenda"
								required>
						</div>
					</div>
					
						<div class="col-md-12">

						<div class="col-md-2">
							<label>EventAddress</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="eventAddress"
								placeholder="EventAddress" ng-model="event.eventAddress" name="eventAddress"
								required>
						</div>
					</div>
			
				<button type="submit" class="btn button  save margin-2"
					ng-click="validateHiddenFields()">update</button>

			</form>

		</div>
	</div>
