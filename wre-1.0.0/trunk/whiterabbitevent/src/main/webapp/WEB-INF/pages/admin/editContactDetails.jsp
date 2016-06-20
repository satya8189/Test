<%@include file="error-messages.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12">
	<a ng-click="cancelEditContactDetails(contact.eventId)"> <i class="fa fa-angle-left back"></i>
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">
			Contact Details
		</div>
		<div class="panel-body text-center">
			<form name="orgCreateForm" ng-submit="orgCreateForm.$valid && updateContactDetails(contact)" 	novalidate>
		<div>&nbsp;</div>
				<div class="col-md-12">
						<div class="col-md-6 form-group">
							<label>Contact Name :</label>
						
							<input type="text" class="input-text form-control" id="contactName"
								placeholder="Contact Name" ng-model="contact.contactName" name="ContactName"
								required>
								<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.ContactName.$error" ng-messages-include="errors">
		  						</span>
								
						</div>
					
						<div class="col-md-6 form-group">
							<label>Contact Eamil :</label>
						
							<input type="text" class="input-text form-control" id="contactEmail"
								placeholder="Contact Email" ng-model="contact.contactEmail" name="contactEmail"
								required>
								
							<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.contactEmail.$error" ng-messages-include="errors">
		  						</span>
						</div>
					</div>
					
					<div class="col-md-12">

						<div class="col-md-6 form-group">
							<label>Mobile Number:</label>
						
							<input type="text" class="input-text form-control" id="contactMobile"
								placeholder="Mobile Number" ng-model="contact.contactMobile" name="contactMobile"
								required>
							<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.contactMobile.$error" ng-messages-include="errors">
		  						</span>
						</div>
					

						<div class="col-md-6 form-group">
							<label>Alternate Mobile Nubmer:</label>
						
							<input type="text" class="input-text form-control" id="contactAlternateMobile"
								placeholder="Alternate Mobile Number" ng-model="contact.contactAlternateMobile" name="contactAlternateMobile"
								required>
							<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.contactAlternateMobile.$error" ng-messages-include="errors">
		  						</span>
						</div>
					</div>
			
				<button type="submit" class="btn button btn-primary save margin-2"
					ng-click="validateHiddenFields()">update</button>
<div>&nbsp;</div>
			</form>
			</div>
		</div>
	</div>
