<%@include file="error-messages.jsp"%>
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
			<form name="sponcorEditForm" ng-submit="sponcorEditForm.$valid && updateSponsor(sponcor)"	novalidate>
						
					<div class="col-md-12">
						<div class="col-md-2">
							<label>Sponsor Name</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="sponsorName"
								ng-model="sponcor.sponcorName" name="sponcorName"
								required>
							<span ng-if="sponcorEditForm.$submitted" ng-messages="sponcorEditForm.sponcorName.$error" ng-messages-include="errors"></span>
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
								<span ng-if="sponcorEditForm.$submitted" ng-messages="sponcorEditForm.sponcorDesc.$error" ng-messages-include="errors"></span>
						</div>
					</div>
					
					
						<div class="col-md-6">
					<div class="form-group col-md-6" id="uploadDiv">
						<label class="flot-left">Upload File </label> <input type="file"
							class="form-control form-group" name="file" id="file"
							onchange="angular.element(this).scope().setFiles(this)">
						
					</div>
				</div>
				<button type="submit" class="btn button  save margin-2">Update</button>
			</form>

		</div>
	</div>
	