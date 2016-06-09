<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-12">
	
</div>
<form name="chatEditForm" ng-submit="chatEditForm.$valid && updateChat(chat)" novalidate>
<div class="form-group">		
						 <label>ChatTopic </label>
							<input type="text" class="input-text form-control " id="chatTopicName" placeholder="ChatTopicName" 
							ng-model="chat.chatTopicName" name="chatTopicName" required/>
							<div ng-if="chatEditForm.$submitted" ng-messages="chatEditForm.chatTopicName.$error" ng-messages-include="errors">
     						 </div>
							</div>
				<div class="form-group col-md-12 text-center">	
					<input type="submit" ng-click="submitted=true" class="btn button btn-info save margin-2" value="Update">
					
					</div>
						</form>