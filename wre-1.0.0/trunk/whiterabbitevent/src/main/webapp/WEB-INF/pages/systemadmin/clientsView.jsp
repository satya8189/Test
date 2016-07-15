	
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


<div class="container">
	<form>
	<h3 class="text-center">Clients List</h3>
		
	
	
		 <div class="col-md-2  padding-0">
		
	<a href="#/createClient"
			class="btn  pull-left button btn btn-primary margin-b-8">Create
			Client</a></div>
		 <div class="col-md-2 col-md-offset-8 padding-0">
		<input ng-model="search" class="form-control" placeholder="Search" ng-show="clientList.length > 0"></div>
		 	
		
				
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
				</table>
				<div ng-show="filteredListSize!=0">
										<div colspan="6" align="center">
										<pagination class="pagination-sm" page="currentPage" max-size="noOfPages"
												total-items="totalItems" items-per-page="entryLimit"
												 boundary-links="true"></pagination></div>
									</div>
				
			
			
		
		</div>
	
		</form>
</div>


	






