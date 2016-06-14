<!-- <h3>edit social</h3> -->
 <%@include file="error-messages.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

	<a ng-click="cancelSocialMediaEdtit(eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15">
		Edit SocialMedia Details</div>
		<div class="panel-body text-center">
			<form name="smEditForm" ng-submit="smEditForm.$valid && updateSocialMedia(sm)"	novalidate>
					<div class="col-md-12">
						<div class="col-md-2">
							<label>Name</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="socialMediaName"
								ng-model="sm.name" name="socialMediaName"
								required>
							<span ng-if="smEditForm.$submitted" ng-messages="smEditForm.socialMediaName.$error" ng-messages-include="errors"></span>
						</div>
					</div>
					
						<div class="col-md-12">

						<div class="col-md-2">
							<label>URL</label>
						</div>
						<div class="col-md-2">
							<input type="text" class="input-text form-control" id="URL"
								ng-model="sm.url" name="sponcorDesc"
								required>
								<span ng-if="smEditForm.$submitted" ng-messages="smEditForm.sponcorDesc.$error" ng-messages-include="errors"></span>
						</div>
					</div>
						<button type="submit" class="btn button  save margin-2">Update</button>
			</form>
		</div>
	</div>
	</div>
	