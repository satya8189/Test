<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>

<div class="col-md-12">
<c:set var="userId" value="${USER.userId}" scope="session" />
	<a ng-click="cancelNetworkingEdit(eventId)">
		 				<i class="fa fa-angle-left back"></i>
	</a>
				
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">Edit
			Networking</div>
		<div class="panel-body text-center">
			<form name="nEditForm"
				ng-submit="nEditForm.$valid && updateNetworking(networking)" novalidate>
				 <div>&nbsp;</div>
				<div class="col-md-12">
					<div class="form-group col-md-6">
							<input type="hidden" ng-model="networking.userId" value="${userId}"
								ng-init="networking.userId=${userId}"> <label class="flot-left">First
								Name <span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="orgName" ng-model="networking.firstName" ng-maxlength="98" ng-minlength="3" 
								placeholder="FirstName" name="firstName" required>
							
							<span ng-if="nEditForm.$submitted" ng-messages="nEditForm.firstName.$error" ng-messages-include="errors"></span>
					</div>
						

						<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left">Last
								name <span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="NName" ng-model="networking.lastName" placeholder="LastName" name="nName" required>
								<span ng-if="nEditForm.$submitted" ng-messages="nEditForm.nName.$error" ng-messages-include="errors"></span>
						</div>
						</div>
						<div class="col-md-12">
						<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left">Mobile
								<span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="NName" ng-model="networking.phoneNumber" placeholder="Mobile" name="nName" required>
								<span ng-if="nEditForm.$submitted" ng-messages="nEditForm.nName.$error" ng-messages-include="errors"></span>
						</div>
						
						<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left">Email-Id
								<span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="NName" ng-model="networking.emailId" placeholder="Email_id" name="nName" required>
								<span ng-if="nEditForm.$submitted" ng-messages="nEditForm.nName.$error" ng-messages-include="errors"></span>
						</div>
						</div>
						<div class="col-md-12">
						<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left">Status
								<span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="NName" ng-model="networking.status" placeholder="Status" name="nName" required>
								<span ng-if="nEditForm.$submitted" ng-messages="nEditForm.nName.$error" ng-messages-include="errors"></span>
						</div>
							  	
							  	</div>					
							<button type="submit" class="btn button btn-primary save margin-2"
					 ng-click="validateHiddenFields()">Update</button>
					 <div>&nbsp;</div> 
			</form>
		</div>
	</div>
</div>
