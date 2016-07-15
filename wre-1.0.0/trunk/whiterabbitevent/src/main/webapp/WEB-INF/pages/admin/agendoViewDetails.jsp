<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<toaster-container></toaster-container>
<c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">

<div class="container margin-top-5">
	
<form>
		 <div class="col-md-4 padding-0">
 <a ng-click="cancelAgendoView(eventId)" class="btn btn-primary backbtn"> Back
	</a> 
	<a ng-click="navigateagendoCreate(eventId)" class="btn btn-primary" ng-hide="roleId==100">Create </a>
	</div>

		 <div class="col-md-3 col-md-offset-5 padding-0">
		 <input ng-model="search"  ng-show="agendoList.length!=0" class="form-control" placeholder="Search"">
		 	</div> 

			<table class="table table-bordered" id="eventView">
				<thead class="headbg">
					<tr>
					     <th>Title</th>
					     <th>Description </th>
						 <th>Start Time</th>
						  <th>End Time</th>
						 <th>By</th>
						  <th>Action</th>
						
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0" ng-repeat="event in agendoList | filter:search | startFrom : (currentPage-1)*entryLimit | limitTo : entryLimit">
				    <td >{{event.agenTitle}}</td>
					<td >{{event.agenDesc}}</td>
					<td >{{event.agenStartTime}}</td>
					<td >{{event.agenEndTime}}</td>
					<td >{{event.agenBy}}</td>
					
					<td>
					
				<a ng-click="agendoEdit(event.agenId)" title="edit" ng-hide="roleId==100">
							<i class="glyphicon glyphicon-pencil"> </i>
				</a>
					</td>
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
							items-per-page="entryLimit" class="pagination-sm" boundary-links="true"></pagination>
					</div>

	</div>
	</form>
</div>
