
<jsp:include page="error-messages.jsp"></jsp:include>
<c:set var="userId" value="${USER.userId}" scope="session" />

<form name="agendaForm" ng-submit="agendaForm.$valid && saveAgendo(agendo)" novalidate>

<div class="col-md-8 col-md-offset-2 margin-top-5">

	<a ng-click="cancelCreateAgenda(agendo.eventId)"
		 class="btn btn-primary backbtn"> Back
	</a>
	
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Create Agendo</div>
  <div class="panel-body new-body">
 
	<div class="col-md-12">
	  <div class="form-group col-md-4" >
          <label class="flot-left">Agendo_Name <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_Name" placeholder="Agendo_Name"  ng-model="agendo.agenTitle" 
      name="AgendaTitle"   required>
      <span ng-if="agendaForm.$submitted" ng-messages="agendaForm.AgendaTitle.$error" ng-messages-include="errors" style="color:red;">
		  </span>
      </div>
     
	  <div class="form-group col-md-4" >
          <label class="flot-left">Agendo_DescName <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agendo_DescName" placeholder="Agendo_DescName"  ng-model="agendo.agenDesc" 
      name="Agendo_DescName"   required>
      <span ng-if="agendaForm.$submitted" ng-messages="agendaForm.Agendo_DescName.$error" ng-messages-include="errors" style="color:red;">
      </span>
      </div>
	 
	
	  <div class="form-group col-md-4" >
          <label class="flot-left">AgenStartTime <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenStartTime" placeholder="AgenStartTime"  ng-model="agendo.agenStartTime" 
      name="agenStartTime"   required>
      <span ng-if="agendaForm.$submitted" ng-messages="agendaForm.agenStartTime.$error" ng-messages-include="errors" style="color:red;">
      </span>
      </div>
     
	  <div class="form-group col-md-4" >
          <label class="flot-left">AgenEndTime <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenStartTime" placeholder="AgenEndTime"  ng-model="agendo.agenEndTime" 
      name="agenEndTime"   required>
      <span ng-if="agendaForm.$submitted" ng-messages="agendaForm.agenEndTime.$error" ng-messages-include="errors" style="color:red;">
      </span>
      </div>
	
	 
	  <div class="form-group col-md-4" >
          <label class="flot-left">AgenBy <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenBy" placeholder="AgenBy"  ng-model="agendo.agenBy" 
      name="agenBy"   required>
      <span ng-if="agendaForm.$submitted" ng-messages="agendaForm.agenBy.$error" ng-messages-include="errors " style="color:red;">
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
</div> 
</form>
