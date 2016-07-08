<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12">
	<a ng-click="cancelSpeakerEdtit(eventId)"> <i class="fa fa-angle-left back"></i>
	</a>
<c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">

	<c:set var="eventId" value="${event.eventId}" scope="session"/>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">
			Details</div>
		<div class="panel-body text-center">
			<form name="eventCreateForm" ng-submit="updateEvent(event)"
				novalidate>
				<div>&nbsp;</div>
				<div class="row">
					
					<div class="col-md-12 padding-35">
						<div class="col-md-12">
							<img src="{{speaker.url}}" width="200" height="200"/><br/>
							<!-- {{speaker.url}} -->
						</div>
						
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0">{{speaker.speakerName}}</label> <br/><span class="color-ccc">Speaker Name </span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{speaker.description}}</label><br/><span class="color-ccc"> Description  </span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{speaker.location}}</label><br/><span class="color-ccc"> Location  </span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{speaker.title}}</label><br/><span class="color-ccc"> Title  </span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{speaker.rating}}</label><br/><span class="color-ccc"> Rating </span>
						</div>						
					</div>
				</div>
				<div>&nbsp;</div>
			</form>
			</div>
		</div>
		<div>&nbsp;</div>
		</div>
<div>&nbsp;</div>

