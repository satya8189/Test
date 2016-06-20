<%@include file="error-messages.jsp" %>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12">
	<a ng-click="cancelCreateSponcor(sponsor.eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	
	<c:set var="userId" value="${user.userId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-5 headbg">Create Sponsor</div>
		<div class="panel-body text-center">
			<form name="orgCreateForm"	ng-submit="orgCreateForm.$valid && saveSponsor(sponsor)"  enctype="multipart/form-data" novalidate>
				<div>&nbsp;</div>
				<div class="row">
					<div class="col-md-12">
						<div class=" form-group col-md-6">
							<label class="flot-left">Sponsor Name <span style="color:red;">*</span></label> 
							<input type="text" class="input-text form-control" id="sponcorName"
								placeholder="Sponsor Name" ng-model="sponsor.sponcorName" name="sponcorName" required> 
                         	<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.sponcorName.$error" ng-messages-include="errors" style="color:red">
		  						</span>
						</div>
					
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">Sponsor Description<span style="color:red;">*</span></label> 
								<input type="text" class="input-text form-control" name="sponcorDesc"
								placeholder="Sponsor Description" ng-model="sponsor.sponcorDesc"  required> 
                         		<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.sponcorDesc.$error" ng-messages-include="errors" style="color:red">
						</div>
					</div>
					
				<div class="col-md-12">
					<div class="form-group col-md-6" id="uploadDiv">
						<label class="flot-left">Upload File </label> <input type="file"
							class="form-control form-group" name="file" id="file"
							onchange="angular.element(this).scope().setFiles(this)">
					</div>
				</div>
					
				</div>
				<div>&nbsp;</div>

				<button type="submit" class="btn button btn-primary save margin-2">Save</button>
<div>&nbsp;</div>
			</form>

		</div>
	</div>
</div>
