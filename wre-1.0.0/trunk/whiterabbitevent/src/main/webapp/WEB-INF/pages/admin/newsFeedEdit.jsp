<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="col-md-12">
<h3 class="text-center">Edit News</h3>
<c:set var="userId" value="${USER.userId}" scope="session" />
	<a ng-click="navigateToNewsFeedView(news.eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	 
 <jsp:include page="error-messages.jsp"></jsp:include>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">Edit
			News</div>
		<div class="panel-body new-body">
			<form name="nEditForm"
				ng-submit="nEditForm.$valid && updateNews(news)" novalidate>
				<div>&nbsp;</div>
					<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="news.userId=${userId}"> <label class="flot-left">News
								name <span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="orgName" ng-model="news.newsTitle" ng-maxlength="98" ng-minlength="3" 
								placeholder="NewsTitle" name="newsTitle" required >
							
							<span ng-if="nEditForm.$submitted" ng-messages="nEditForm.newsTitle.$error" ng-messages-include="errors" style="color:red;"></span>
					</div>
						

						<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left">News
								Description <span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="NName" ng-model="news.newsDesc" placeholder="NewsDesc" name="nName" required>
								<span ng-if="nEditForm.$submitted" ng-messages="nEditForm.nName.$error" ng-messages-include="errors" style="color:red;"></span>
							  						</div>
							  					<div>&nbsp;</div>
							  					<div class="text-center">	
							<button type="submit" class="btn button btn-primary save margin-2"
					 ng-click="validateHiddenFields()">Update</button>
					 </div>
			</form>
			<div>&nbsp;</div>
		</div>
	</div>
</div>
