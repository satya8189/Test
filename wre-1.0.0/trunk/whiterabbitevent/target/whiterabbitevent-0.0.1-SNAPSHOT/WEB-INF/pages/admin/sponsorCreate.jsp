
<h3>sponsor create <!-- {{5+4}} --></h3>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<a ng-click="cancelCreateSponcor(eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	
	<!-- <a ng-click="sponsorPageView/{{eventId}}"> <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	 -->
	<c:set var="userId" value="${user.userId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-5">Create Sponsor</div>
		<div class="panel-body text-center">
			<form name="orgCreateForm"	ng-submit="saveSponsor(sponsor)" novalidate>
				<div class="row">
					<div class="col-md-12">
						<div class=" form-group col-md-6">
							<label class="flot-left">Sponsor Name <span style="color:red;">*</span></label> 
							<input type="text" class="input-text form-control" id="sponcorName"
								placeholder="Sponsor Name" ng-model="sponsor.sponcorName" name="sponcorName" required> 
                         	<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.sponcorName.$error" ng-messages-include="errors">
		  						</span>
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">Sponsor Description<span style="color:red;">*</span></label> 
								<input type="text" class="input-text form-control" name="sponcorDesc"
								placeholder="Sponsor Description" ng-model="sponsor.sponcorDesc"  required> 
                         		<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.sponcorDesc.$error" ng-messages-include="errors">
						</div>
					</div>
				</div>
				<div>&nbsp;</div>

				<button type="submit" class="btn button  save margin-2">Save</button>

			</form>

		</div>
	</div>
</div>
