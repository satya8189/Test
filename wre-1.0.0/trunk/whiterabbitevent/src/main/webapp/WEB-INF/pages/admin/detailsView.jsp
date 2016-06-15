<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-12">
	<a ng-click="navigateToEventViewDetails(eventId)"> <i class="glyphicon glyphicon-chevron-left"></i>
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
					<table class="col-md-8 padding-35">

					<tr>		
						<td class="col-md-2">
							<label>Event Name: {{event.eventName}}</label>
						</td>
						</tr><tr>
						<td class="col-md-2">
							<label>EventDesc: {{event.eventDesc}}</label>
						</td>
						</tr>
						<tr>
						<td class="col-md-2">
							<label>EventAgenda: {{event.eventAgenda}}</label>
						</td>
						</tr>
						<tr>
						<td class="col-md-2">
							<label>EventAddress: {{event.eventAddress}}</label>
						</td>
						</tr>
						<tr>
						<td class="col-md-2">
							<label>EventDate: {{event.eventDate}}</label>
						</td>
						</tr>
						
						<td class="col-md-2">
							<label>EventDate: {{event.eventTime}}</label>
						</td>
						</tr>
						</table>
						
					</div>

				</div>
				</form>
			</div>
				<div>&nbsp;</div>
				<button type="submit" class="btn button  save margin-2"
					ng-click="editDetailsView(eventId)">Edit</button>
		</div>
	</div>
</div>
