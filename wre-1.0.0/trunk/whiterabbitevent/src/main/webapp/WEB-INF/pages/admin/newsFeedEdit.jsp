<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
<c:set var="userId" value="${USER.userId}" scope="session" />
	<a href="#/orgView" id="organization" > <i class="fa fa-angle-left back"></i>
 </a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15">Edit
			News</div>
		<div class="panel-body text-center">
			<form name="agendoEditForm"
				ng-submit="updateNews(news)" novalidate>
				
				
				<div class="row">
					<div class="col-md-12">
{{agendo.agenTitle}}
						<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left">News
								name <span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="orgName" ng-model="news.newsDesc" ng-maxlength="98" ng-minlength="3" 
								placeholder="AgenTitle" name="agenTitle" required>
							
							<span ng-if="orgEditForm.$submitted" ng-messages="orgEditForm.orgName.$error" ng-messages-include="errors">
								<p ng-message="minlength">AgenTitle name  contains atleast 3 letters.</p>
							 </span>
							  	

						</div>
						

				</div>
				<hr />
				
				<div>&nbsp;</div>

				<button type="submit" class="btn button  save margin-2"
					 ng-click="validateHiddenFields()">Update</button>
					 
					 
			</form>
			
		</div>
	</div>
</div>
