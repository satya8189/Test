<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="error-messages.jsp" %>
<style>
.panel{
border: 1px solid #588CC0;
}
span{
	color: red;
}
</style>
<div class="col-md-12">

	<a ng-click="navigateToEventViewDetails(contact.eventId)"> <i class="fa fa-angle-left back"></i>
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">Contact	Details </div>
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
					
					<button type="submit" class="btn button  save margin-2">Update</button>
			</form>
		</div>
		</div>
		
		<div class="panel-body text-center">  <!-- Not empty -->
			<!-- <form name="orgCreateForm" ng-submit="orgCreateForm.$valid && updateContactDetails(contact)"	novalidate> -->
			<div ng-repeat="contact in filtered =  contactList" ng-show="filteredSize!=0"><!-- labels  {{5+4}} -->
			<div class="row">
				<div>&nbsp;</div>
					<div class="col-md-12">
					
						<div class="col-md-3">
							<label>Contact Name  : </label>
						
							<labe>{{contact.contactName}}</labe>
						</div>
					
						<div class="col-md-3">
							<label>Contact Eamil  :</label>
						
							<label>{{contact.contactEmail}}</labe>
						</div>
				
					
				

						<div class="col-md-3">
							<label>Mobile Number  :</label>
						
							<label>{{contact.contactMobile}}</labe>
						</div>
					
						<div class="col-md-3">
							<label>Alternate Mobile Nubmer  :</label>
						
							<label>{{contact.contactAlternateMobile}}</labe>
						</div>
					<!-- <div class="col-mf-12">
					<button type="submit" class="btn button btn-primary save margin-2"	ng-click="editContactDetails(contact.contactId)">Edit</button>
					</div> -->
					</div>
					<div>&nbsp;</div>
			<!-- </form> -->
		</div>
		</div>
	</div>
</div>
</div>

