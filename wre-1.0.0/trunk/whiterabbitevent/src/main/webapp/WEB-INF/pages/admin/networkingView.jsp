<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script>
	$(".link-active").removeClass("link-active");
	$("#event").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}

</style>
<toaster-container></toaster-container>
<c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<c:set var="eventId" value="${event.eventId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">
<div class="cal-md-12">
	<form>
	
	<div class="header-none" align="center">EventsParticipant List</div>
	<a ng-click="cancelNetworkingView(eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	
	<div class="panel">
		<div class="panel-body">
		
	
		 <div class="col-md-2 col-md-offset-10 padding-0">
			 <input ng-model="search"  ng-show="networkList.length!=0" class="form-control" placeholder="Search">
		 </div> 
		
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table table-bordered" id="networkView">
				<thead class="headbg">
					<tr> 
					     <th>FirstName</th>
					     <th>LastName</th>
					     <th>Mobile </th>
						 <th>Email</th>
						 <th>Status</th>
						 <!-- <th>Action</th> -->
				   </tr>
				</thead>
				
				<tr ng-show="filteredSize!=0" ng-repeat="event in networkList | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit ">
				    <td >{{event.firstName}}</td>
				     <td >{{event.lastName}}</td>
				     <td >{{event.mobile}}</td>
					  <td >{{event.emailId}}</td>
					 <td>{{event.status}}</td>
					 <!-- <td>
						<a ng-click="networkingEdit(event.participantId)" title="Edit Participant">
							<i class="fa fa-eye-slash icons"> </i>
						</a>
					</td> -->
				</tr>
				<tr ng-show="filteredSize==0">
					<td colspan="6">
						No records found..
					</td>
				</tr>
				</table>
				<div ng-show="filteredSize!=0">
					<div colspan="6" align="center">
						<pagination page="currentPage" max-size="noOfPages" total-items="totalItems" 
							items-per-page="entryLimit" class="pagination-sm" boundary-links="true">
						</pagination>
					</div>
				</div>
			
			
			
		</div>
	</div>
	</form>
</div>
