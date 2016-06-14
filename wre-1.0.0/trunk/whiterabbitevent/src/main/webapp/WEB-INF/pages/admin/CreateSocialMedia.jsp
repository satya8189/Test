<%@include file="error-messages.jsp" %>
 <div class="col-md-12">
	<a ng-click="cancelCreateSocialMedia(sm.eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-5">Create SocialMedia</div>
		<div class="panel-body text-center">
			<form name="orgCreateForm"	ng-submit="orgCreateForm.$valid && saveSocialMedia(sm)" novalidate>
				<div class="row">
					<div class="col-md-12">
						<div class=" form-group col-md-6">
							<label class="flot-left">Name<span style="color:red;">*</span></label> 
							<input type="text" class="input-text form-control" id="sponcorName"
								placeholder="WebName" ng-model="sm.name" name="smName" required> 
                         	<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.smName.$error" ng-messages-include="errors">
		  						</span>
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">URL<span style="color:red;">*</span></label> 
								<input type="text" class="input-text form-control" name="url"
								placeholder="URL" ng-model="sm.url"  required> 
                         		<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.url.$error" ng-messages-include="errors">
						</div>
					</div>
				</div>
				<div>&nbsp;</div>
				<button type="submit" class="btn button  save margin-2">Save</button>
			</form>
		</div>
	</div>
</div>
