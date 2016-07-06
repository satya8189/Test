
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../error-messages.jsp"></jsp:include>
<toaster-container></toaster-container>


<div class="col-md-12">
	<a ng-click="cancelEvent()"> <i class="fa fa-angle-left back"></i>
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg" >Create
			Client</div>
		<div class="panel-body new-body">
			<form name="ClientCreateForm"
				ng-submit="ClientCreateForm.$valid && saveClient(client)" novalidate>
				<br/>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group col-md-6">
							 <label>Client name </label>
							<input type="text" class="input-text form-control "
								id="clientName" ng-model="client.clientName" 
								 placeholder="ClientName" name="clientName" ng-minlength="3"  ng-maxlength="50" required />
								<div ng-if="ClientCreateForm.$submitted" ng-messages="ClientCreateForm.clientName.$error" ng-messages-include="errors">
								
     						 </div>
     						 </div>
     						 <div class="form-group col-md-6">
								 <label>Client Address </label>
							<input type="text" class="input-text form-control " id="address" placeholder="address" 
							ng-model="client.address" name="address" ng-minlength="3"  ng-maxlength="70"  required/>
							<div ng-if="ClientCreateForm.$submitted" ng-messages="ClientCreateForm.address.$error" ng-messages-include="errors">
							</div>
							</div>
							</div>
							<div class="col-md-12">
							<div class="form-group col-md-6">
							 <label
								class="flot-left">Description <span style="color: red;">*</span></label>
							<input type="text" class="input-text form-control" id ="description" placeholder="description"
							ng-model="client.description" name="description" ng-minlength="3"  ng-maxlength="50" required />
							<div ng-if="ClientCreateForm.$submitted" ng-messages="ClientCreateForm.description.$error" ng-messages-include="errors">
     						 </div>
     						 </div>
							<div class="form-group col-md-6">
							 <label
								class="flot-left">EmailId <span style="color: red;">*</span></label>
							<input type="email" class="input-text form-control" id ="emailId" placeholder="EmailId"
							ng-model="client.emailId" name="description" ng-minlength="3"  ng-maxlength="50" required />
							<div ng-if="ClientCreateForm.$submitted" ng-messages="ClientCreateForm.emailId.$error" ng-messages-include="errors">
     						 </div>
     						 </div>
     						 </div>
     						 <div class="col-md-12">
							<div class="form-group col-md-6">
							<label>FristName <span style="color: red;">*</span></label>
							<input type="text" class="input-text form-control" id ="firstName" placeholder="fristname"
							ng-model="client.firstName" name="firstName" ng-minlength="3"  ng-maxlength="50" required />
							<div ng-if="ClientCreateForm.$submitted" ng-messages="ClientCreateForm.firstName.$error" ng-messages-include="errors"></div>
							</div>
							<div class="form-group col-md-6">
							<label
								class="flot-left">LastName <span style="color: red;">*</span></label>
							<input type="text" class="input-text form-control" id ="lastName" placeholder="lastName"
							ng-model="client.lastName" name="lastName"   ng-maxlength="50" required/>
							<div ng-if="ClientCreateForm.$submitted" ng-messages="ClientCreateForm.lastName.$error" ng-messages-include="errors"></div>
							</div>
							<div class="form-group col-md-6">
							<label
								class="flot-left">PhoneNumber <span style="color: red;">*</span></label>
							<input type="text" class="input-text form-control" id ="phoneNo" placeholder="phoneNo"
							ng-model="client.phoneNo" name="phoneNo" ng-pattern="/^(?:\s*\+)?[\d\s\-()]+$/" ng-minlength="10" required />
							<div ng-if="ClientCreateForm.$submitted" ng-messages="ClientCreateForm.phoneNo.$error" ng-messages-include="errors"></div>
							</div>
                   </div>
                   
					</div>
				
				
<div class="text-center">
				<input type="submit" ng-click="submitted=true" class="btn button  btn btn-primary save margin-2" value="Save">
</div>
<div>&nbsp;</div>
			</form>
			</div>
</div>
<br/>
		</div>
	
