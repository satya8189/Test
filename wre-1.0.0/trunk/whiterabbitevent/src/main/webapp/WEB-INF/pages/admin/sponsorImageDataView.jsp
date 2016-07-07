<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12">
	<a ng-click="cancelSponsorEdtit(eventId)"> <i class="fa fa-angle-left back"></i>
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
							<img src="{{sponcor.url}}" width="200" height="200"/><br/>
							<!-- {{sponcor.url}} -->
						</div>
						
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0">{{sponcor.sponcorName}}</label> <br/><span class="color-ccc">Sponsor Name </span>
						</div>
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{sponcor.sponcorDesc}}</label><br/><span class="color-ccc"> Description  </span>
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

