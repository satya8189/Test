<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
<c:set var="userId" value="${USER.userId}" scope="session" />
	<a ng-click="cancelAgendaEdit(agendo.eventId)"> <i class="glyphicon glyphicon-chevron-left"></i>
 </a>
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15">Edit
			Agendo</div>
		<div class="panel-body text-center">
			<form name="agendaForm"
				ng-submit="agendaForm.$valid && updateAgendo(agendo)" novalidate>
				<div class="row">
					<div class="col-md-12">
					<!-- {{agendo.agenTitle}} -->
						<div class="form-group col-md-6">
							<input type="hidden" ng-model="agendo.userId" value="${userId}"
								ng-init="agendo.userId=${userId}"> <label class="flot-left"/>
								Agenda Name<span style="color:red;">*</span></label>
							 <input type="text" class="input-text form-control " 
								 id="agendaName" ng-model="agendo.agenTitle" placeholder="AgenTitle" name="agenTitle" required>
							<span ng-if="agendaForm.$submitted" ng-messages="agendaForm.agenTitle.$error" ng-messages-include="errors">
															 </span>
						</div>
					</div>
				<hr/>
				<div>&nbsp;</div>
				<button type="submit" class="btn button  save margin-2"
					 ng-click="validateHiddenFields()">Update</button>
			</form>
		</div>
	</div>
</div>
