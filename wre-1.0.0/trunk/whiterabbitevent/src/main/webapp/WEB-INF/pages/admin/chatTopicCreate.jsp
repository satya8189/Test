<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>
<jsp:include page="error-messages.jsp"></jsp:include>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<c:set var="userId" value="${USER.userId}" scope="session" />
<div class="col-md-12">
	<a ng-click="cancelCreateChat()">
		 <i class="fa fa-angle-left back"></i>
	</a>
	 </div>
	<div>&nbsp;</div>
<form name="chatForm" ng-submit="chatForm.$valid && saveChatTopic(chat)" novalidate>


<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Create ChatTopic</div>
  <div class="panel-body text-center">
  <div>&nbsp;</div>
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">ChatTopicName: <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="chatTopicName" placeholder="ChatTopicName"  ng-model="chat.chatTopicName" 
      name="chatTopicName"   required>
      <span ng-if="chatForm.$submitted" ng-messages="chatForm.chatTopicName.$error" ng-messages-include="errors" style="color:red">
		  </span>
		 <div>&nbsp;</div>
		 </div>
		  </div>
	 </div>
		<div class="text-center">
<input type="submit" value="Save" class="btn button btn-primary save margin-2" ng-click="submitted=true"/>
<div>&nbsp;</div> 
</div>
      
     
	 </div>
	 </div>
	
	 </form>