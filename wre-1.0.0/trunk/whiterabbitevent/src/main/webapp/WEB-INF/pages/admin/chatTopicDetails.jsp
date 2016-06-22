<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="error-messages.jsp" %>
<div class="col-md-12">
	<a ng-click="cancelUpdateChat(chat)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	 </div>
<form name="chatEditForm" ng-submit="chatEditForm.$valid && updateChat(chat)" novalidate>

<div class="panel">	
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Edit ChatTopic</div>	
  <div class="panel-body text-center">
  <div>&nbsp;</div>
  <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
						 <label>ChatTopic </label>
							<input type="text" class="input-text form-control " id="chatTopicName" placeholder="ChatTopicName" 
							ng-model="chat.chatTopicName" name="chatTopicName" required/>
							<div ng-if="chatEditForm.$submitted" ng-messages="chatEditForm.chatTopicName.$error" ng-messages-include="errors" style="color:red;">
     						 </div>
							</div>
						<div>&nbsp;</div>
		 </div>
		  </div>
		  <div class="text-center">
				<div class="form-group col-md-12 text-center">	
					<input type="submit" ng-click="submitted=true" class="btn button btn-info save margin-2" value="Update">
					
					</div>
					</div>
					</div>
					</div>
						</form>