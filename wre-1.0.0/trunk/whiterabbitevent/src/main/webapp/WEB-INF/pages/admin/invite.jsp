<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
		<a ng-click="cancelInviteView(event.eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	
	<c:set var="eventId" value="${event.eventId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15">
			Details</div>
		<div class="panel-body text-center">
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
				
	<form name="createEvent" ng-submit="saveInvite(invite)" novalidate>
			<a ng-click="inviteList(event.eventId)"title="eventViewDetails">Invite List
							<i class="fa fa-eye-slash icons"> </i>
				</a>
	<div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
	  				
      <label class="flot-left">Mobile Number <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_Name" placeholder="Mobile Number"  ng-model="invite.phone" 
      name="InviteName"   required>
      </div>
      </div>
	 </div>
			<input type="submit" value="Submit" ng-click="submitted=true"/>		
</form>

				

				
			

				

			

		</div>
	</div>

