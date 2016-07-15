
<div class="col-md-8 col-md-offset-2 margin-top-5">

	<a ng-click="navigateToEventViewDetails(contact.eventId)" class="btn btn-primary backbtn margin-top-5"> Back
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">Contact	Details </div>
		<div class="panel-body panelbody-bg"><!-- If empty  -->
			 
			<div ng-show="!contactList.length" >
			<form name="orgCreateForm" ng-submit="orgCreateForm.$valid && saveContactDetails(contact)" 
				novalidate>
					<div>&nbsp;</div>
					<div class="col-md-12">
						<div class="col-md-6 form-group">
							<label>Contact Name</label>
						
							<input type="text" class="input-text form-control" id="contactName"
								placeholder="Contact Name" ng-model="contact.contactName" name="ContactName" required>
								<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.ContactName.$error" ng-messages-include="errors">
		  						</span>
						</div>
					
						<div class="col-md-6 form-group">
							<label>Contact Eamil</label>
						
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
					<div class="text-center">
					<button type="submit" class="btn button btn-primary save margin-2">Update</button>
					</div>
					<div>&nbsp;</div>
			</form>
		</div>
		</div>
		
		<div class="panel-body panelbody-bg">  <!-- Not empty -->
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

