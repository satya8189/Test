
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>

<c:set var="userId" value="${USER.userId}" scope="session" />

<form name="createEvent" ng-submit="saveEvent(event,${userId})" novalidate>

<div class="container">
	<a href="#/eventView"> <i class="fa fa-angle-left back"></i>
	</a>
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15">Create Event</div>
  <div class="panel-body text-center">
    <div class="row">
	<div class="col-md-12">
	  
	  <div class="form-group col-md-6" >
          <label class="flot-left">Event_Name <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="event_Name" placeholder="Event_Name"  ng-model="event.eventName" 
      name="insurenceOrgName"   required>
      </div>
      </div>
	 </div>
	 

</div>
    <div>&nbsp;</div>
<input type="submit" value="Save" class="btn button save margin-2" ng-click="submitted=true"/>
</div>
</div>

</form>
