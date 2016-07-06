<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12">
	<a ng-click="navigateToEventViewDetails(eventId)"> <i class="fa fa-angle-left back"></i>
	</a>
<c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">

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

							
						<!-- <div class="col-md-3">
							<label>Event Name: {{event.eventName}}</label>
						</div>
						<div class="col-md-3">
							<label>EventDesc: {{event.eventDesc}}</label>
						</div>
						<div class="col-md-3">
							<label>EventAgenda: {{event.eventAgenda}}</label>
						</div>
						<div class="col-md-3">
							<label>EventAddress: {{event.eventAddress}}</label>
						</div>
						
						<div class="col-md-3">
							<label>EventDate: {{event.eventDate}}</label>
						</div>
						<div class="col-md-3">
							<label>EventTime: {{event.eventTime}}</label>
						</div>
						 -->
						 
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0">{{event.eventName}}</label> <br/><span class="color-ccc">Event Name </span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{event.eventDesc}}</label><br/><span class="color-ccc">Event Desc : </span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{event.eventAgenda}} </label> <br/><span class="color-ccc">Event Agenda : </span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0">  {{event.eventAddress}}</label><br/><span class="color-ccc">Event Address : </span>
						</div>
						<hr>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{event.eventDate}}</label> <br/><span class="color-ccc">Event Date : </span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{event.eventTime}} </label><br/><span class="color-ccc">Event Time : </span>
						</div>
						
					</div>
				</div>
				
				<div>&nbsp;</div>
				<div class="text-center">
				<button type="submit" class="btn button btn-primary save margin-2"
					ng-click="editDetailsView(eventId)" ng-hide="roleId==100">Edit</button>
					</div>
					<div>&nbsp;</div>
					</form>
			</div>
		</div>
		<div>&nbsp;</div>
		</div>
	</div>
<div>&nbsp;</div>

