<%@include file="error-messages.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12">
		<a ng-click="cancelInviteView(event.eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	<c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<c:set var="eventId" value="${event.eventId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">
			Details</div>
		<div class="panel-body new-body">
		<div>&nbsp;</div>
				<div class="row">
					<div class="col-md-12">
	
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0"> {{event.eventName}}</label> <br/><span class="color-ccc">Event Name : </span>
						</div>
						
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0">{{event.eventDesc}} </label><br/><span class="color-ccc">Event Desc :</span>
						</div>
						
						
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0">{{event.eventAgenda}} </label> <br/><span class="color-ccc">Event Agenda : </span>
						</div>
						
						<div class="col-md-3 text-center">
							<label class="margin-bottom-0">{{event.eventAddress}} </label><br/><span class="color-ccc">Event Address :</span>
						</div>
					</div>
				</div>
				<div>&nbsp;</div>
		<div class="text-center">
		<form name="createEvent" ng-submit="saveInvite(invite)" novalidate>
			<a ng-click="inviteList(event.eventId)"title="eventViewDetails" class="btn btn-primary">Invite List
							<i class="fa fa-eye-slash icons"> </i>
				</a>
				<div>&nbsp;</div>
	<div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6 col-md-offset-3" ng-hide="roleId==100" >
	  				
      <label class="flot-left">Mobile Number <span style="color:red;" >*</span></label>
       <input type="text" class="input-text form-control" id="agendo_Name" placeholder="Mobile Number"  ng-model="invite.phone" ng-hide="roleId==100" 
      name="Mobile" title="Numbers only" onkeypress="this.value=this.value.replace(/[^\d,]/g,'')" required > 
      
      <span  ng-if="createEvent.$submitted" ng-messages="createEvent.Mobile.$error" ng-messages-include="errors" style="color:red"></span>
      
      </div>
      </div>
	 </div>
	 <div>&nbsp;</div>
			<div class="text-center">
				<input type="submit" value="Submit" ng-click="submitted=true" class="btn btn-primary"/>	
			</div>
			<div>&nbsp;</div>
	</form>
		</div>
	</div>
	</div>

