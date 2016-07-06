<%@include file="error-messages.jsp" %>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
 <div class="col-md-12">
 <h3 class="text-center">Create SocialMedia</h3>
	<a ng-click="cancelCreateSocialMedia(sm.eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-5 headbg">Create SocialMedia</div>
		<div class="panel-body new-body">
			<form name="orgCreateForm"	ng-submit="orgCreateForm.$valid && saveSocialMedia(sm)" novalidate>
				<div>&nbsp;</div>
				<div class="row">
					<div class="col-md-12">
						<div class=" form-group col-md-6">
							<label class="flot-left">Name<span style="color:red;">*</span></label> 
							<input type="text" class="input-text form-control" id="sponcorName"
								placeholder="WebName" ng-model="sm.name" name="smName" required> 
                         	<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.smName.$error" ng-messages-include="errors" style="color:red;">
		  						</span>
						</div>
					
						<div class=" form-group col-md-6">
							<label class="flot-left">Type<span style="color:red;">*</span></label> 
						<!-- 	<input type="text" class="input-text form-control" id="sponcorName"
								placeholder="WebName" ng-model="sm.name" name="smName" required> 
                         	<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.smName.$error" ng-messages-include="errors">
		  						</span> -->
		  						<select name="smtype" class="input-text form-control" ng-model="sm.type" id="smtype" required>
		  							<option>Google+</option>
		  							<option>Facebook</option>
		  							<option>Twitter</option>
		  							<option>LinkedIn</option>
		  							<option>Flickr</option>
		  							<option>Instagram</option>
		  						</select> 
		  						<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.smtype.$error" ng-messages-include="errors" style="color:red;"></span>
						</div>
					</div>
					
					<div class="col-md-12">
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">URL<span style="color:red;">*</span></label> 
								<input type="text" class="input-text form-control" name="url"
								placeholder="URL" ng-model="sm.url"  required> 
                         		<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.url.$error" ng-messages-include="errors" style="color:red;">
						</div>
					</div>
				</div>
				<div>&nbsp;</div>
				<div class="text-center">
				<button type="submit" class="btn button btn-primary save margin-2">Save</button>
				</div>
			<div>&nbsp;</div>
			</form>
		</div>
	</div>
</div>
