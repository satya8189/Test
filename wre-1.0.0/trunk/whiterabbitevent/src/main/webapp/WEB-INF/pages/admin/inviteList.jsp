
<toaster-container></toaster-container>

<div class="container">
<h3 class="text-center">Invite List</h3>

	<form>
	

		<div class="col-md-4  padding-0">
		<a ng-click="cancelInviteListView(eventId)" class="btn btn-primary backbtn">
Back
	</a>
</div>
		 <div class="col-md-2 col-md-offset-6 padding-0">
		 <input ng-model="search"  ng-show="inviteList.length!=0" class="form-control" placeholder="Search">
			</div> 
			
			<table class="table table-bordered" id="eventView">
				<thead class="headbg">
					<tr>
					     <th>FirstName</th>
					     <th>LastName </th>
						 <th>Email</th>
						 <th> Phone</th>
						 <th> Status</th>
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0" ng-repeat="invite in inviteList | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit">
				    <td >{{invite.firstName}}</td>
					<td >{{invite.lastName}}</td>
					<td >{{invite.email}}</td>
					<td >{{invite.phone}}</td>
				    <td >{{invite.status}}</td>
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
			
			
		</div>
	</div>
	</form>
</div>
