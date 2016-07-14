<!-- <h3>edit social</h3> -->
 <%@include file="error-messages.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-8 col-md-offset-2 margin-top-5">

	<a ng-click="cancelSocialMediaEdtit(eventId)" class="btn btn-primary backbtn">Back
		 
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">
		Edit SocialMedia Details</div>
		<div class="panel-body new-body">
			<form name="smEditForm" ng-submit="smEditForm.$valid && updateSocialMedia(sm)"	novalidate>
					<div>&nbsp;</div>
					<div class="col-md-12">
						<div class="col-md-6 form-group">
							<label>Name</label>
						
							<input type="text" class="input-text form-control" id="socialMediaName"
								ng-model="sm.name" name="socialMediaName"
								required>
							<span ng-if="smEditForm.$submitted" ng-messages="smEditForm.socialMediaName.$error" ng-messages-include="errors" style="color:red;"></span>
						</div>
					
					
						

						<div class="col-md-6 form-group">
							<label>URL</label>
						
					
							<input type="text" class="input-text  form-control" id="URL"
								ng-model="sm.url" name="sponcorDesc"
								required>
								<span ng-if="smEditForm.$submitted" ng-messages="smEditForm.sponcorDesc.$error" ng-messages-include="errors" style="color:red;"></span>
						</div>
						
						<!-- <div class="col-md-2">
							<label>Type</label>
						</div>
						<div class="col-md-2">
							<select class="input-text form-control" id="type"
								ng-model="sm.type" name="sponcorDesc"	required>
								<option>Google+</option>
		  						<option>Facebook</option>
		  						<option>Twitter</option>
		  						<option>LinkedIn</option>
		  						<option>Flickr</option>
		  						<option>Instagram</option>
								</select>
								<span ng-if="smEditForm.$submitted" ng-messages="smEditForm.sponcorDesc.$error" ng-messages-include="errors"></span>
						</div>
						 -->
					</div>
					<div>&nbsp;</div>
					<div class="text-center">
						<button type="submit" class="btn button btn-primary save margin-2">Update</button>
			<div>&nbsp;</div>
			</form>
		</div>
	</div>
	</div>
	