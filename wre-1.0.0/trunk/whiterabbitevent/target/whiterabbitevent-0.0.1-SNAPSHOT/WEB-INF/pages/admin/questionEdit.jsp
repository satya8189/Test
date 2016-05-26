<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
<c:set var="userId" value="${USER.userId}" scope="session" />
	<a href="#/orgView" id="organization" > <i class="fa fa-angle-left back"></i>
 </a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15">Edit
			Question</div>
		<div class="panel-body text-center">
			<form name="agendoEditForm"
				ng-submit="updateQuestion(question)" novalidate>
				
				

					
					
					
					<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="news.userId=${userId}"> <label class="flot-left">Question
								 <span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="question" ng-model="question.question" ng-maxlength="98" ng-minlength="3" 
								placeholder="Question" name="question" required>
							
							<span ng-if="orgEditForm.$submitted" ng-messages="orgEditForm.orgName.$error" ng-messages-include="errors">
								<p ng-message="minlength">NewsDesc name  contains atleast 3 letters.</p>
							 </span>
							  	

						</div>
						

						<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left">Option-A
								 <span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="orgName" ng-model="question.optionA" ng-maxlength="98" ng-minlength="3" 
								placeholder="OptionA" name="newsDesc" required>
							
							<span ng-if="orgEditForm.$submitted" ng-messages="orgEditForm.orgName.$error" ng-messages-include="errors">
								<p ng-message="minlength">NewsDesc name  contains atleast 3 letters.</p>
							 </span>
							  	

						</div>
						
						<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left">Option-B
								 <span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="orgName" ng-model="question.optionB" ng-maxlength="98" ng-minlength="3" 
								placeholder="OptionB" name="newsDesc" required>
							
							<span ng-if="orgEditForm.$submitted" ng-messages="orgEditForm.orgName.$error" ng-messages-include="errors">
								<p ng-message="minlength">NewsDesc name  contains atleast 3 letters.</p>
							 </span>
							  	

						</div>
						
						<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left">Option-C
								 <span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="orgName" ng-model="question.optionC" ng-maxlength="98" ng-minlength="3" 
								placeholder="NewsDesc" name="newsDesc" required>
							
							<span ng-if="orgEditForm.$submitted" ng-messages="orgEditForm.orgName.$error" ng-messages-include="errors">
								<p ng-message="minlength">NewsDesc name  contains atleast 3 letters.</p>
							 </span>
							  	

						</div>
						<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left">Option-D
								 <span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="orgName" ng-model="question.optionD" ng-maxlength="98" ng-minlength="3" 
								placeholder="Option-C" name="newsDesc" required>
							
							<span ng-if="orgEditForm.$submitted" ng-messages="orgEditForm.orgName.$error" ng-messages-include="errors">
								<p ng-message="minlength">NewsDesc name  contains atleast 3 letters.</p>
							 </span>
							  	

						</div>
						
						<div class="form-group col-md-6">
							<input type="hidden" ng-model="news.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left">Question
								 <span style="color:red;">*</span></label> <input type="text" class="input-text form-control " 
								 id="orgName" ng-model="question.answer" ng-maxlength="98" ng-minlength="3" 
								placeholder="NewsDesc" name="newsDesc" required>
							
							<span ng-if="orgEditForm.$submitted" ng-messages="orgEditForm.orgName.$error" ng-messages-include="errors">
								<p ng-message="minlength">NewsDesc name  contains atleast 3 letters.</p>
							 </span>
							  	

						</div>
						
						
						</div>
						
						
						
						

				
				
				
	

				<button type="submit" class="btn button  save margin-2"
					 ng-click="validateHiddenFields()">Update</button>
					 
					 
			</form>
			
		</div>
	</div>
</div>
