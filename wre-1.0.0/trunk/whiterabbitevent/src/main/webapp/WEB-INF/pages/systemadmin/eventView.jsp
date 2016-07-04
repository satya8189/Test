<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12">
	<a ng-click="navigateToEventViewDetails(event)"> <i class="fa fa-angle-left back"></i>
	</a>

	<c:set var="eventId" value="${event.eventId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">
			Details</div>
		<div class="panel-body text-center">
			<form name="eventCreateForm"
				ng-submit="updateEvent(event)"
				novalidate>
				<div>&nbsp;</div>
				<div class="row">
					<div class="col-md-12 padding-35">

						<div class="col-md-12">
							<label>Event Name: {{event.eventName}}</label>
						</div>
						<div class="col-md-12">
							<label>EventDesc: {{event.eventDesc}}</label>
						</div>
						<div class="col-md-12">
							<label>EventAgenda: {{event.eventAgenda}}</label>
						</div>
						<div class="col-md-12">
							<label>EventAddress: {{event.eventAddress}}</label>
						</div>
						</div>
					</div>
					<div>&nbsp;</div> 
					</form> 
		</div>
		</div>
<div>&nbsp;</div>
