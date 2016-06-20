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
	
	<c:set var="eventId" value="${event.eventId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">
			Details</div>
		<div class="panel-body text-center">
		<div>&nbsp;</div>
				<div class="row">
					<div class="col-md-12">

						<div class="col-md-3">
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
						
						
					</div>

				</div>
				<div>&nbsp;</div>
	<form name="createEvent" ng-submit="saveInvite(invite)" novalidate>
			<a ng-click="inviteList(event.eventId)"title="eventViewDetails" class="btn btn-primary">Invite List
							<i class="fa fa-eye-slash icons"> </i>
				</a>
				<div>&nbsp;</div>
	<div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6 col-md-offset-3" >
	  				
      <label class="flot-left">Mobile Number <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_Name" placeholder="Mobile Number"  ng-model="invite.phone"  
      name="InviteName"   pattern="[0-9]+([\.,][0-9]+)*" title="Numbers only" format required >
      </div>
      </div>
	 </div>
	 <div>&nbsp;</div>
			<input type="submit" value="Submit" ng-click="submitted=true" class="btn btn-primary"/>	
			<div>&nbsp;</div>	
</form>

				

				
			

				

			

		</div>
	</div>

