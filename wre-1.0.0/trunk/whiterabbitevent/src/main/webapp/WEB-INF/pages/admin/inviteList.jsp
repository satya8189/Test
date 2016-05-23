	
<script>
	$(".link-active").removeClass("link-active");
	$("#event").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}
.panel-body {
  padding: 13px 50px ;
}
</style>
<toaster-container></toaster-container>

<div class="container">
	<form>
	
	<div class="header-none">Invite List</div>
	<div class="panel">
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="inviteList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table" id="eventView">
				<thead>
					<tr>
					     <th>FirstName</th>
					     <th>LastName </th>
						 <th>Email</th>
						 <th> Phone</th>
						 <th> Status</th>
						
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0"ng-repeat="invite in inviteList ">
				    <td >{{invite.firstName}}</td>
					<td >{{invite.lastName}}</td>
					<td >{{invite.email}}</td>
					<td >{{invite.phone}}</td>
				    <td >{{invite.status}}</td>
			<td>
					
				
				
				
						
					</td>
				</tr>
				<tr ng-show="filteredSize==0">
				<td colspan="6">
				No records found..
				</td>
				</tr>
				<tr ng-show="filteredSize!=0">
					<td colspan="6" align="center">
						<pagination page="currentPage" max-size="noOfPages" total-items="totalItems" 
							items-per-page="entryLimit" class="pagination-sm" boundary-links="true"></pagination>
					</td>
				</tr>
			</table>
			
			
		</div>
	</div>
	</form>
</div>
