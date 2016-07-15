<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-8 col-md-offset-2 margin-top-5">
	<a ng-click="navigateToEventViewDetails(event)" class="btn btn-primary backbtn">Back 
	</a>

	<c:set var="eventId" value="${event.eventId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">
			Details</div>
		<div class="panel-body new-body">
			<form name="eventCreateForm"
				ng-submit="updateEvent(event)"
				novalidate>
				<div>&nbsp;</div>
				<div class="row">
					<div class="col-md-12 padding-35">

						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{event.eventName}}</label><br/><span class="color-ccc">Event Name: </span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{event.eventDesc}}</label><br/><span class="color-ccc">EventDesc:</span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{event.eventAgenda}}</label><br/><span class="color-ccc">EventAgenda:</span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{event.eventAddress}}</label><br/><span class="color-ccc">EventAddress:</span>
						</div>
						</div>
					</div>
					<div>&nbsp;</div> 
					</form> 
		</div>
		</div>
<div>&nbsp;</div>
