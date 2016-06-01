
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>



<form name="createEvent" ng-submit="updateQuestion(question)" novalidate>

<div class="container">
		<a ng-click="cancelAgendoView"> <i
		class="fa fa-angle-left back"></i>
	</a>
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15"></div>
  <div class="panel-body text-center">
  
  
  
     <div>
	 <label >QuestionType <span style="color:red;">*</span></label> 
      {{question.appIdentifierName}}
	 </div> 
   
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Question <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_Name" placeholder="Question"  ng-model="question.question" 
      name="Question"   required>
      </div>
      </div>
	 </div>
	
	 <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">OptionA <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_DescName" placeholder="optionA"  ng-model="question.optionA" 
      name="Agendo_DescName"   required>
      </div>
      </div>
	 </div>
	 
	 <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">OptionB <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenStartTime" placeholder="OptionB"  ng-model="question.optionB" 
      name="agenStartTime"   required>
      </div>
      </div>
	 </div>
	 
	  <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">OptionC <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenStartTime" placeholder="OptionC"  ng-model="question.optionC" 
      name="agenEndTime"   required>
      </div>
      </div>
	 </div>
	 
	  <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">OptionD <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenBy" placeholder="OptionD"  ng-model="question.optionD" 
      name="agenBy"   required>
      </div>
      </div>
	 </div>
	 
	   <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Answer <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenBy" placeholder="Answer"  ng-model="question.answer" 
      name="answer"   required>
      </div>
      </div>
	 </div>
	 
	 

</div>
    <div>&nbsp;</div>
<input type="submit" value="Update" class="btn button save margin-2" ng-click="submitted=true"/>
</div>
</div>

</form>
