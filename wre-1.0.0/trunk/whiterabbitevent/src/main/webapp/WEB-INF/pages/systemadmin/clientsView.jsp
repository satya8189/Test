	
<script>
	$(".link-active").removeClass("link-active");
	$("#client").addClass("link-active");	
</script>
<style>
@media (min-width: 992px){
.col-md-offset-9 {
    margin-left: 73%;
}

</style>


<div class="col-md-12">
	<form>
	
		
	
	<div class="panel">
		<div class="panel-body">
		 
			<div class="col-md-2 col-md-offset-9 text-left " >
				<input ng-model="search" class="form-control" placeholder="Search" ng-show="clientList.length > 0"></div>
					<div class="col-md-1 padding-0 "><a href="#/createClient"
			class="btn  pull-left button btn btn-primary">Create
			Client</a></div>
					<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table table-bordered" id="clientView">
				<thead class="headbg">
					<tr>
						<th>ClientName</th>
						<th>ClientAddress</th>
						<th> ClientDescription</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tr ng-show="filteredSize!=0" ng-repeat="client in filtered = clientList | filter:search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit">
					<td >{{client.clientName}}</td>
					<td >{{client.address}}</td>
					<td >{{client.description}}</td>
					<td >{{client.status}}</td>
					
					<td>
					<a ng-click="navigateToEventView(client.clientId)" title="View Events">
							<span class="glyphicon glyphicon-eye-open icons"> </span>
						</a>		
						
						
					</td>	
				</tr>
				<tr ng-show="filteredSize==0">
						<td colspan="8">No records found..</td>
					</tr>
				
				<tr ng-show="filteredListSize!=0">
										<td colspan="6" align="center">
										<pagination class="pagination-sm" page="currentPage" max-size="noOfPages"
												total-items="totalItems" items-per-page="entryLimit"
												 boundary-links="true"></pagination></td>
									</tr>
				
			</table>
			
			
		</div>
	</div>
		</form>
</div>



	






