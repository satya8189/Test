
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:set var="eventId" value="${event.eventId}" scope="session" /> --%>

<div class="container">
	<a ng-click="cancelSponsorEdtit(eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15">
		Edit Sponsor	Details</div>
		<div class="panel-body text-center">
			<form name="sponcorEditForm" ng-submit="updateSponsor(sponcor)"	novalidate>
				
				<div class="col-md-12">

						<div class="col-md-2">
							<label>Event Id</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="eventId" ng-model="sponcor.eventId" name="EventName"
								readonly>
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="col-md-2">
							<label>Sponsor Id</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="sponcorId"
								placeholder="Sponsor Id" ng-model="sponcor.sponcorId" name="sponcorId"
								required>
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="col-md-2">
							<label>Sponsor Name</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="sponsorName"
								ng-model="sponcor.sponcorName" name="sponcorName"
								required>
						</div>
					</div>
					
						<div class="col-md-12">

						<div class="col-md-2">
							<label>Sponsor Description</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="sponcorDesc"
								ng-model="sponcor.sponcorDesc" name="sponcorDesc"
								required>
						</div>
					</div>
				<button type="submit" class="btn button  save margin-2">Update</button>
			</form>

		</div>
	</div>
	