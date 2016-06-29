<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>

<jsp:include page="error-messages.jsp"></jsp:include>
<c:set var="userId" value="${USER.userId}" scope="session" />

<form name="createEvent" ng-submit="createEvent.$valid && questionCreate(question)" novalidate>

<div class="col-md-12">
		<div class="col-md-12">
	  <a ng-click="cancelQuestionCreate(question.eventId)"> <i
		class="fa fa-angle-left back"></i>
	</a>
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Create Question</div>
  <div class="panel-body text-center">
  <div>&nbsp;</div>
     <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-12" >
	 <label >QuestionTypes <span style="color:red;">*</span></label> 
       <select id="appIdentifierId"
       class="form-control js-example-basic-single " 
       data-ng-model="question.appIdentifierId"
       ng-options="question.appIdentifierId as question.identifierName for question in appList"
       name="identifierName">
       <option value="">Question Types</option>
       </select>
	 </div> 
   </div>
    
	  <div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Question <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_Name" placeholder="Question"  ng-model="question.question" 
      name="Question"   required/>
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.Question.$error" ng-messages-include="errors" style="color:red">
		  </span>
      </div>
     
	  <div class="form-group col-md-6" ng-show="question.appIdentifierId!=201">
          <label class="flot-left">OptionA <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_DescName" placeholder="optionA"  ng-model="question.optionA" 
      name="Agendo_DescName"   required>
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.Agendo_DescName.$error" ng-messages-include="errors"style="color:red">
		  </span>
      </div>
      </div>
	
	 <div class="col-md-12">
	  <div class="form-group col-md-6" ng-show="question.appIdentifierId!=201">
          <label class="flot-left">OptionB <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenStartTime" placeholder="OptionB"  ng-model="question.optionB" 
      name="agenStartTime"   required>
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.agenStartTime.$error" ng-messages-include="errors"style="color:red">
		  </span>
      </div>
    
	
	  <div class="form-group col-md-6" ng-show="question.appIdentifierId!=201">
          <label class="flot-left">OptionC <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenStartTime" placeholder="OptionC"  ng-model="question.optionC" 
      name="agenEndTime"   required>
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.agenEndTime.$error" ng-messages-include="errors"style="color:red">
		  </span>
      </div>
      </div>
	 
	  <div class="col-md-12">
	  <div class="form-group col-md-6" ng-show="question.appIdentifierId!=201">
          <label class="flot-left">OptionD <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenBy" placeholder="OptionD"  ng-model="question.optionD" 
      name="agenBy"   required>
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.agenBy.$error" ng-messages-include="errors"style="color:red">
		  </span>
      </div>

	 
	  <div class="form-group col-md-6" >
          <label class="flot-left">Answer <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenBy" placeholder="Answer" ng-model="question.answer" 
      name="answer"><!--    required> -->
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.answer.$error" ng-messages-include="errors" style="color:red">
		  </span>
      </div>
      </div>
	 
</div>
    <div>&nbsp;</div>
<input type="submit" value="Save" class="btn button btn-primary save margin-2" ng-click="submitted=true"/>
<div>&nbsp;</div>
</div>
</div>

</form>
<div>&nbsp;</div>
