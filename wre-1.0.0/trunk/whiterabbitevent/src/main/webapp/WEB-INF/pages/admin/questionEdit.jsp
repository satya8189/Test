<%@include file="error-messages.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>

<form name="questionEditForm" ng-submit="questionEditForm.$valid && updateQuestion(question)"  ng-show="question.appIdentifierId!=201" novalidate>
<div class="col-md-12">
<h3 class="text-center">Edit Question Details</h3>
		<a ng-click="cancelQuestionEdit(question.eventId)"> 
			<i class="fa fa-angle-left back"></i>
		</a>
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Edit Question Details</div>
  <div class="panel-body new-body">
     <div class="text-center">
	 <label> QuestionType <span style="color:red ;">*</span></label> 
      {{question.appIdentifierName}}
	 </div> 
    <div>&nbsp;</div>
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Question <span style="color:red;">*</span></label>
      		<input type="text" class="input-text form-control" id="agendo_Name" placeholder="Question"  ng-model="question.question" 
      		name="Question"   required>
      		<span ng-if="questionEditForm.$submitted" ng-messages="questionEditForm.Question.$error" ng-messages-include="errors" style="color:red">
      </div>
     
	  <div class="form-group col-md-6">
          <label class="flot-left">OptionA <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_DescName" placeholder="optionA"  ng-model="question.optionA" 
      name="Agendo_DescName"   required>
      	<span ng-if="questionEditForm.$submitted" ng-messages="questionEditForm.Agendo_DescName.$error" ng-messages-include="errors" style="color:red">
      </div>
      </div>
	 
	<div class="col-md-12">
	  <div class="form-group col-md-6">
          <label class="flot-left">OptionB <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenStartTime" placeholder="OptionB"  ng-model="question.optionB" 
      name="agenStartTime"   required>
      <span ng-if="questionEditForm.$submitted" ng-messages="questionEditForm.agenStartTime.$error" ng-messages-include="errors" style="color:red">
      </div>
     
	  <div class="form-group col-md-6">
          <label class="flot-left">OptionC <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenStartTime" placeholder="OptionC"  ng-model="question.optionC" 
      name="agenEndTime"   required>
      <span ng-if="questionEditForm.$submitted" ng-messages="questionEditForm.agenEndTime.$error" ng-messages-include="errors" style="color:red">
      </div>
    </div>
	<div class="col-md-12">
	  <div class="form-group col-md-6">
          <label class="flot-left">OptionD <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenBy" placeholder="OptionD"  ng-model="question.optionD" 
      name="agenBy"   required>
      <span ng-if="questionEditForm.$submitted" ng-messages="questionEditForm.agenBy.$error" ng-messages-include="errors" style="color:red">
      </div>
      
      <div class="form-group col-md-6" >
          <label class="flot-left">Answer <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenBy" placeholder="Answer"  ng-model="question.answer" 
      name="answer"   required>
      <span ng-if="questionEditForm.$submitted" ng-messages="questionEditForm.answer.$error" ng-messages-include="errors" style="color:red">
      </div>
      </div>
	 </div>
	 <div>&nbsp;</div>
    <div class="text-center">
<input type="submit" value="Update" class="btn button btn-primary save margin-2" ng-click="submitted=true"/>
</div>
 <div>&nbsp;</div>
</div>
</div>
</div>
</form>







<form name="questionEditForm" ng-submit="questionEditForm.$valid && updateQuestion(question)" ng-show="question.appIdentifierId==201" novalidate>

<div class="col-md-12">
		<a ng-click="cancelQuestionEdit(question.eventId)"> 
			<i class="fa fa-angle-left back"></i>
		</a>
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Edit Question Details</div>
  <div class="panel-body text-center">
     <div>
	 <label >QuestionType <span style="color:red;">*</span></label> 
      {{question.appIdentifierName}}
	 </div> 
    <div>&nbsp;</div>
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Question <span style="color:red;">*</span></label>
      		<input type="text" class="input-text form-control" id="agendo_Name" placeholder="Question"  ng-model="question.question" 
      		name="Question"   required>
      		<span ng-if="questionEditForm.$submitted" ng-messages="questionEditForm.Question.$error" ng-messages-include="errors" style="color:red">
      </div>
      
      <div class="form-group col-md-6" >
          <label class="flot-left">Answer <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenBy" placeholder="Answer"  ng-model="question.answer" 
      name="answer"   required>
      <span ng-if="questionEditForm.$submitted" ng-messages="questionEditForm.answer.$error" ng-messages-include="errors" style="color:red">
      </div>
      </div>
	 </div>
	 <div>&nbsp;</div>
    <div class="text-center">
<input type="submit" value="Update" class="btn button btn-primary save margin-2" ng-click="submitted=true"/>
</div>
 <div>&nbsp;</div>
</div>
</div>
</div>
</form>
