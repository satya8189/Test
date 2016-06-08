<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-12">

	<a ng-click="navigateToEventViewDetails(contact.eventId)"> <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15">Contact	Details </div>
		<div class="panel-body text-center"><!-- If empty  -->
			 
			<div ng-show="!contactList.length" >
			<form name="orgCreateForm" ng-submit="orgCreateForm.$valid && saveContactDetails(contact)" 
				novalidate>
					
					<div class="col-md-12">
						<div class="col-md-2">
							<label>Contact Name</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="contactName"
								placeholder="Contact Name" ng-model="contact.contactName" name="ContactName" required>
								<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.ContactName.$error" ng-messages-include="errors">
		  						</span>
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="col-md-2">
							<label>Contact Eamil</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="contactEmail"
								placeholder="Contact Email" ng-model="contact.contactEmail" name="contactEmail"
								required>
								
							<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.contactEmail.$error" ng-messages-include="errors">
		  						</span>
						</div>
					</div>
					
					<div class="col-md-12">

						<div class="col-md-2">
							<label>Mobile Number:</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="contactMobile"
								placeholder="Mobile Number" ng-model="contact.contactMobile" name="contactMobile"
								required>
							<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.contactMobile.$error" ng-messages-include="errors">
		  						</span>
						</div>
					</div>
						<div class="col-md-12">
						<div class="col-md-2">
							<label>Alternate Mobile Nubmer:</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="contactAlternateMobile"
								placeholder="Alternate Mobile Number" ng-model="contact.contactAlternateMobile" name="contactAlternateMobile"
								required>
							<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.contactAlternateMobile.$error" ng-messages-include="errors">
		  						</span>
						</div>
					</div>
					<button type="submit" class="btn button  save margin-2"	ng-click="validateHiddenFields()">Update</button>
			</form>
		</div>
		</div>
		
		<div class="panel-body text-center">  <!-- Not empty -->
			<!-- <form name="orgCreateForm" ng-submit="orgCreateForm.$valid && updateContactDetails(contact)"	novalidate> -->
			<div ng-repeat="contact in filtered =  contactList" ng-show="filteredSize!=0"><!-- labels  {{5+4}} -->
					<div class="col-md-12">
					
						<div class="col-md-2">
							<label>Contact Name : </label>
						</div>
						<div class="col-md-2">
							<labe>{{contact.contactName}}</labe>
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="col-md-2">
							<label>Contact Eamil</label>
						</div>
						<div class="col-md-2">
							<label>{{contact.contactEmail}}</labe>
						</div>
					</div>
					
					<div class="col-md-12">

						<div class="col-md-2">
							<label>Mobile Number:</label>
						</div>
						<div class="col-md-2">
							<label>{{contact.contactMobile}}</labe>
						</div>
					</div>
						<div class="col-md-12">
						<div class="col-md-2">
							<label>Alternate Mobile Nubmer:</label>
						</div>
						<div class="col-md-2">
							<label>{{contact.contactAlternateMobile}}</labe>
						</div>
					</div>
					<button type="submit" class="btn button  save margin-2"	ng-click="editContactDetails(contact.contactId)">Edit</button>
			<!-- </form> -->
		</div>
		</div>
	</div>
</div>
