<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../error-messages.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ClientEventEdit</title>





</head>
<body>
<h3 class="text-center">ClientEventEdit</h3>
<div class="col-md-12">
	<a ng-click="cancelClientEventEdit(event)"> <i
		class="fa fa-angle-left back"></i>
	</a>

	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-15 headbg" >Create
			Client</div>
		<div class="panel-body new-body">
<form name="ipForm" ng-submit="ipForm.$valid && updateEvent(event)" 
 novalidate >

<div>&nbsp;</div>
<div class="">
<div class="form-group col-md-4 col-md-offset-4">
<label >Services Provided </label>
	
							
				<label ng-repeat="data in servicesList">
  <input type="checkbox" checklist-model="event.services" checklist-value="data.serviceId"> {{data.serviceName}}
</label>			
							

						</div> 
						<div class="col-md-6">
						<div class="form-group">		
						 <label>EventName </label>
							<input type="text" class="input-text form-control " id="eventName" placeholder="EventName" 
							ng-model="event.eventName" name="eventName" required/>
							<div ng-if="ipForm.$submitted" ng-messages="ipForm.eventName.$error" ng-messages-include="errors">
     						 </div>
							</div>
							<div class="form-group">	
						<label class="flot-left">EventDescription<span style="color: red;">*</span></label>
						<input type="text" class="input-text form-control " id="eventDesc" placeholder="eventDesc" 
							ng-model="event.eventDesc" name="eventDesc" required/>
							<div ng-if="ipForm.$submitted" ng-messages="ipForm.eventDesc.$error" ng-messages-include="errors">
     						 </div>
     						 </div>
   	    						 
  <div class="form-group">
  <label>EventAddress</label>
						<input type="text" class="input-text form-control " id="eventAddress" placeholder="eventAddress" 
							ng-model="event.eventAddress" name="eventAddress" required/>
							<div ng-if="ipForm.$submitted" ng-messages="ipForm.eventAddress.$error" ng-messages-include="errors">
     						 </div>
     						 </div>
     						  </div>
     						 
     		<div class="col-md-6">				
   				 
	 <div class="form-group">						
						<label>EventAgenda</label>
						<input type="text" class="input-text form-control " id="eventAgenda" placeholder="eventAgenda" 
							ng-model="event.eventAgenda" name="eventAgenda" required/>
							<div ng-if="ipForm.$submitted" ng-messages="ipForm.eventAgenda.$error" ng-messages-include="errors">
     						 </div>
     						 </div>
  
  
  <div class="form-group">
 <label> EventTime</label>
						<input type="text" class="input-text form-control" id="eventTime" placeholder="eventTime" 
							ng-model="event.eventTime" name="eventTime" required/>
							<div ng-if="ipForm.$submitted" ng-messages="ipForm.eventTime.$error" ng-messages-include="errors">
     						 </div>
						</div> 
						
  
  <div class="form-group">
  <label>EventDate</label>
						<input type="text" class="input-text form-control" id="eventDate" placeholder="eventDate" 
							ng-model="event.eventDate" name="eventDate" required/> 
							<div ng-if="ipForm.$submitted" ng-messages="ipForm.eventTime.$error" ng-messages-include="errors">
     						 </div>
     						 </div>
  
  
  
</div>
							
						
<div class="form-group col-md-12 text-center">	
					<input type="submit" ng-click="submitted=true" class="btn button btn-info save margin-2" value="Update">
					
					</div>
					</form>
					
					</div>
					</div>
					<div>&nbsp;</div>
					
</body>
</html>