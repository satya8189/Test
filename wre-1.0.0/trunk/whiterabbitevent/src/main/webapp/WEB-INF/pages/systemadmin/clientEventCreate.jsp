
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../error-messages.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<toaster-container></toaster-container>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Event Create</title>
<style>
.transprant {
	background: transparent;
	border: none;
}
.panel{
	background-color:#fff;
	 border: 1px solid #588CC0;
	
	}
</style>




</head>

<body>
	<h3 class="text-center">clientEventCreate</h3>
	<div class="col-md-12">
	<div>
		<a ng-click="cancelClientEvent()"> <i
			class="fa fa-angle-left back"></i>
		</a>
	</div>
<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg" >Create
			Event</div>
		<div class="panel-body new-body">
		<form name="ipForm" ng-submit="ipForm.$valid && saveEvent(event)"
			novalidate>
			<div class="form-group col-md-4">

				<label class="flot-left">EventName </label> <input type="text"
					class="input-text form-control " id="eventName"
					placeholder="EventName" ng-model="event.eventName" name="eventName"
					ng-minlength="3" ng-maxlength="50" required />
				<div ng-if="ipForm.$submitted" ng-messages="ipForm.eventName.$error"
					ng-messages-include="errors"></div>
			</div>
			<div class="form-group col-md-4">
				<label class="flot-left">EventDescription</label> <input type="text"
					class="input-text form-control " id="eventDesc"
					placeholder="eventDesc" ng-model="event.eventDesc" name="eventDesc"
					ng-minlength="3" ng-maxlength="50" required />
				<div ng-if="ipForm.$submitted" ng-messages="ipForm.eventDesc.$error"
					ng-messages-include="errors"></div>
			</div>
			<div class="form-group col-md-4">
				<label class="flot-left">EventAddress</label> <input type="text"
					class="input-text form-control " id="eventAddress"
					placeholder="eventAddress" ng-model="event.eventAddress"
					name="eventAddress" required />
				<div ng-if="ipForm.$submitted"
					ng-messages="ipForm.eventAddress.$error"
					ng-messages-include="errors"></div>
			</div>
			<div class="form-group col-md-4">
				<label class="flot-left">EventAgenda</label> <input type="text"
					class="input-text form-control " id="eventAgenda"
					placeholder="eventAgenda" ng-model="event.eventAgenda"
					name="eventAgenda" required />
				<div ng-if="ipForm.$submitted"
					ng-messages="ipForm.eventAgenda.$error"
					ng-messages-include="errors"></div>
			</div>
			<div class="form-group col-md-4">
				<label class="flot-left">EventTime</label> <input type="text"
					class="input-text form-control" id="eventAgenda"
					placeholder="eventTime" ng-model="event.eventTime" name="eventTime"
					required />
				<div ng-if="ipForm.$submitted" ng-messages="ipForm.eventTime.$error"
					ng-messages-include="errors"></div>
			</div>
			<div class="form-group col-md-4">
				<label class="flot-left">EventDate</label> <input type="date"
					class="input-text form-control" id="eventDate"
					placeholder="eventDate" ng-model="event.eventDate" name="eventDate"
					required />
				<div ng-if="ipForm.$submitted" ng-messages="ipForm.eventDate.$error"
					ng-messages-include="errors"></div>
			</div>


			<div class="form-group col-md-4 col-md-offset-4 ">
				<label class="flot-left">Services Provided: </label>
				<div>&nbsp;</div>
				<ul style="list-style:none;height: 200px;overflow: scroll;">
				<li ng-repeat="data in servicesList" >   {{data.serviceName}} <input type="checkbox" class="pull-right" checklist-model="event.services" checklist-value="data.serviceId"></li>
				</ul>
				
				
					
							
				
			</div>

			<div class="form-group col-md-4 col-md-offset-4">
				<label style="visibility: hidden;">User </label>
				<div class="form-control text-center transprant">
					ExistingUser<input type="radio" name="rdboption"
						ng-model="rdboption" ng-value="demo" ng-checked="rdboption==demo" />
					NewUser<input type="radio" ng-model="rdboption" value="demoone"
						name="rdboption">
				</div>
			</div>




			<div ng-show="rdboption=='demoone'">
				<div class="clearfix"></div>
				<div class="form-group col-md-3">
					<label class="flot-left">User Frist Name </label> <input
						type="text" class="input-text form-control " id="userFristName"
						placeholder="UserFristName" ng-model="event.userFristName"
						name="userFristName" 
						ng-class="{'error':submitted &&ipForm.userFristName.$error.required}"
						/>
						<span class="help-inline" ng-show="submitted &&ipForm.userFristName.$error.required" style="color:red;"> Frist Name is required</span>
				</div>
				<div class="form-group col-md-3">
					<label class="flot-left">User Last Name </label> <input type="text"
						class="input-text form-control " id="userLastName"
						placeholder="UserLastName" ng-model="event.userLastName"
						name="UserLastName"
						ng-class="{'error':submitted &&ipForm.UserLastName.$error.required}"
						 />
						<span class="help-inline" ng-show="submitted &&ipForm.UserLastName.$error.required" style="color:red;"> Last Name is required</span>
				</div>
				<div class="form-group col-md-3">
					<label class="flot-left">User EmailId </label> <input type="text"
						class="input-text form-control " id="userEmail"
						placeholder="userEmail" ng-model="event.userEmail"
						name="userEmail" 
						ng-class="{'error':submitted &&ipForm.userEmail.$error.required}"
						 />
						<span class="help-inline" ng-show="submitted &&ipForm.userEmail.$error.required" style="color:red;">User EmailId is required </span>
				</div>
				<div class="form-group col-md-3">
					<label class="flot-left">User PhoneNo </label> <input type="text"
						class="input-text form-control " id="phoneNumber"
						placeholder="phoneNumber" ng-model="event.phoneNumber"
						name="phoneNumber" 
						ng-class="{'error':submitted &&ipForm.phoneNumber.$error.required}"
						/>
		<span class="help-inline" ng-show="submitted &&ipForm.phoneNumber.$error.required" style="color:red;">User PhoneNumber is required </span>

				</div>

			</div>
			<div ng-hide="rdboption=='demoone'" ng-init="rdboption=='demo'">
				<div class="form-group col-md-6">
					<label>User </label> 
					<select id="userId"
						class="form-control js-example-basic-single "
						data-ng-model="event.userId"
						ng-options="userOb.userId as userOb.firstName for userOb in usersList"
						name="firstName">
						<option value="">Select User</option>
					</select>
				</div>
					</div>
			<div class="col-md-12">
<div class="form-group col-md-6 " 
							id="uploadDiv">
							<label class="flot-left">Upload Image </label> 
							<input type="file" class="form-control form-group" name="file" id="file" onchange="angular.element(this).scope().setFiles(this)">
							
						</div>
			
</div>
			<div class="col-md-12">
				<span class="help-inline" id="uploadDivError" style="display: none;color:red;" >Select logo to upload</span> 
			<span class="help-inline" id="extensionDivError" style="display: none;color: red;">only jpeg,png,gif formats are allowed</span>
			</div>

			<div class="form-group col-md-12 text-center">
				<input type="submit" ng-click="submitted=true"
					class="btn btn-primary" value="Save" ng-disabled="disabled">


			</div>
		</form>
	</div>
</div>
</div>
<div>&nbsp;</div>
</body>
</html>