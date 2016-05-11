<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<a ng-click="cancelEvent()"> <i class="fa fa-angle-left back"></i>
	</a>

	<c:set var="eventId" value="${event.eventId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15">Create
			Event</div>
		<div class="panel-body text-center">
			<form name="eventCreateForm"
				ng-submit="saveEvent(event,eventCreateForm.$valid,${eventId})"
				novalidate>
				<div class="row">
					<div class="col-md-12">

						<div class="form-group col-md-6">
							<input type="hidden" ng-model="event.eventId" value="${eventId}"
								ng-init="event.eventId=${eventId}"> <label
								class="flot-left">Event name <span style="color: red;">*</span></label>
							<input type="text" class="input-text form-control "
								id="eventName" ng-model="event.eventName" ng-maxlength="98"
								ng-minlength="3" placeholder="Event name" name="orgName"
								required /> <span ng-if="eventCreateForm.$submitted"
								ng-messages="eventCreateForm.eventName.$error"
								ng-messages-include="errors">
								<p ng-message="minlength">Event name contains atleast 3
									letters.</p>
							</span>

                   </div>
						

					

						

						
					

						
						

					

						

				
						
						
					</div>
				</div>
				<div>&nbsp;</div>

				<button type="submit" class="btn button  save margin-2"
					ng-click="validateHiddenFields()">Save</button>

			</form>

		</div>
	</div>
</div>
