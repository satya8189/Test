<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<a ng-click="cancelEvent()"> <i class="fa fa-angle-left back"></i>
	</a>

	<c:set var="eventId" value="${event.eventId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15">
			Details</div>
		<div class="panel-body text-center">
			<form name="eventCreateForm"
				ng-submit="updateEvent(event)"
				novalidate>
				<div class="row">
					<div class="col-md-8">

						<div class="col-md-2">
							<label>Event Name: {{event.eventName}}</label>
						</div>
						
						<div class="col-md-2">
							<label>EventDesc: {{event.eventDesc}}</label>
						</div>
						
						
						<div class="col-md-2">
							<label>EventAgenda: {{event.eventAgenda}}</label>
						</div>
						
						<div class="col-md-2">
							<label>EventAddress: {{event.eventAddress}}</label>
						</div>
						
						
					</div>

				</div>
				

				

				
				
				
						

				</div>
				<div>&nbsp;</div>

				<button type="submit" class="btn button  save margin-2"
					ng-click="editDetailsView(eventId)">Edit</button>
					
					

			</form>

		</div>
	</div>
</div>
