<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>
<jsp:include page="error-messages.jsp"></jsp:include>
<c:set var="userId" value="${USER.userId}" scope="session" />

<form name="agendaForm" ng-submit="agendaForm.$valid && saveAgendo(agendo)" novalidate>

<div class="col-md-12">
<h3 class="text-center">Agenda Create</h3>
	<a ng-click="cancelCreateAgenda(agendo.eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Create Agenda</div>
  <div class="panel-body new-body">
  <div>&nbsp;</div>
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Agenda Name <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_Name" placeholder="Agendo Name"  ng-model="agendo.agenTitle" 
      name="AgendaTitle"   required>
      <span ng-if="agendaForm.$submitted" ng-messages="agendaForm.AgendaTitle.$error" ng-messages-include="errors" style="color:red;">
		  </span>
      </div>
     
	  <div class="form-group col-md-6" >
          <label class="flot-left">Agenda DescName <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_DescName" placeholder="Agendo DescName"  ng-model="agendo.agenDesc" 
      name="Agendo_DescName"   required>
      <span ng-if="agendaForm.$submitted" ng-messages="agendaForm.Agendo_DescName.$error" ng-messages-include="errors" style="color:red;">
      </span>
      </div>
	 </div> 
	 </div>
	 
	 <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">Agenda StartTime <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenStartTime" placeholder="Agenda StartTime"  ng-model="agendo.agenStartTime" 
      name="agenStartTime"   required>
      <span ng-if="agendaForm.$submitted" ng-messages="agendaForm.agenStartTime.$error" ng-messages-include="errors" style="color:red;">
      </span>
      </div>
     
	  <div class="form-group col-md-6" >
          <label class="flot-left">Agenda EndTime <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenStartTime" placeholder="Agenda EndTime"  ng-model="agendo.agenEndTime" 
      name="agenEndTime"   required>
      <span ng-if="agendaForm.$submitted" ng-messages="agendaForm.agenEndTime.$error" ng-messages-include="errors" style="color:red;">
      </span>
      </div>
	 </div>
	 </div>
	 


    <div>&nbsp;</div>
    <div class="text-center">
<input type="submit" value="Save" class="btn button btn-primary save margin-2" ng-click="submitted=true"/>
</div>
<div>&nbsp;</div>
</div>

</form>
