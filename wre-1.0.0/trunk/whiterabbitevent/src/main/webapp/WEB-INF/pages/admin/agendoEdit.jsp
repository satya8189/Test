<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel{
border: 1px solid #588CC0;
}

</style>
<div class="container"> 
<jsp:include page="error-messages.jsp"></jsp:include>
<c:set var="userId" value="${USER.userId}" scope="session" />
	<a ng-click="cancelAgendaEdit(agendo.eventId)" class="btn btn-primary backbtn margin-top-5"> Back
 </a>

	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg">Edit
			Agenda</div>
		<div class="panel-body new-body">
			<form name="agendaForm"
				ng-submit="agendaForm.$valid && updateAgendo(agendo)" novalidate>
	
	
					<!-- {{agendo.agenTitle}} -->
						<div class="form-group col-md-4">
							<input type="hidden" ng-model="agendo.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left"/>
								Agenda Name<span style="color:red;">*</span></label>
							 <input type="text" class="input-text form-control " 
								 id="agendaName" ng-model="agendo.agenTitle" placeholder="AgenTitle" name="agenTitle" required>
							<span ng-if="agendaForm.$submitted" ng-messages="agendaForm.agenTitle.$error" ng-messages-include="errors" style="color:red;">
															 </span>
						</div>
						
						
	  <div class="form-group col-md-4" >
          <label class="flot-left">Agenda_DescName <span style="color:red;">*</span></label>
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
     
	 
	  <div class="form-group col-md-6" >
          <label class="flot-left">AgenEndTime <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenStartTime" placeholder="AgenEndTime"  ng-model="agendo.agenEndTime" 
      name="agenEndTime"   required>
      <span ng-if="agendaForm.$submitted" ng-messages="agendaForm.agenEndTime.$error" ng-messages-include="errors" style="color:red;">
      </span>
      </div>

	  <div class="form-group col-md-6" >
          <label class="flot-left">AgenBy <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="agenBy" placeholder="AgenBy"  ng-model="agendo.agenBy" 
      name="agenBy"   required>
      <span ng-if="agendaForm.$submitted" ng-messages="agendaForm.agenBy.$error" ng-messages-include="errors" style="color:red;">
      </span>
      </div>


     
				<div>&nbsp;</div>
				<div class="text-center col-md-12">
				<button type="submit" class="btn btn-primary"
					 ng-click="validateHiddenFields()">Update</button>
					 </div>
			  
			</form>

 </div>
 </div>
 </div>