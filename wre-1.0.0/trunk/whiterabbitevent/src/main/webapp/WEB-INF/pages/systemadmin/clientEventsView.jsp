<style>
@media (min-width: 992px){
.col-md-offset-9 {
    margin-left: 74%;
}

</style>
<toaster-container></toaster-container>

<div>

	<div class="col-md-12 space-hid">&nbsp;</div>
</div>
	<form>
	
	<div class="col-md-12">
	
	<div class="panel">
		<div class="panel-body">
			<div class="col-md-3">
			<a ng-click="cancelClientEventView()"> <i
		class="fa fa-angle-left back"></i>
	</a> 
		</div>	
		
			<div class="col-md-2 col-md-offset-9 text-left" ng-show="eventList.length > 0">
				<input ng-model="search" class="form-control full-right" placeholder="Search"
					ng-hide="eventList.length==0"></div>
					<div class="col-md-1 padding-0 "> 	<button ng-click="navigateClientEventCreate()" class=" btn btn-primary pull-left"
			>Create
			Event</button></div>
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table table-bordered" id="eventView">
				<thead class="headbg">
					<tr>
						<th>Event Name</th>
						<th> EventDesc</th>
						<th>EventAgenda </th>
						<th>EventAddress</th>
						<th>EventTime</th>
						<th>Action</th>
						
					</tr>
				</thead>
				<tr ng-show="filteredSize!=0" ng-repeat="event in filtered = eventList | filter:search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit">
					<td>{{event.eventName}}</td>
					<td>{{event.eventDesc}}</td>
					<td>{{event.eventAgenda}}</td>
					<td>{{event.eventAddress}}</td>
					<td>{{event.eventTime}}</td>
					<td>
					<a ng-click="navigatetoEventEdit(event.eventId)"title="eventEdit"> <span
							class="glyphicon glyphicon-pencil margin-2 icons"> </span></a>
							
							<a ng-click="eventView(event.eventId)"title="eventViewDetails">
								<i class="fa fa-eye-slash icons"> </i>
							</a>
							
							<a ng-click="serviceListView(event.eventId)" title="view service list">
								<i class="glyphicon glyphicon-eye-open"> </i>
							</a>
				
					
					</td>
				</tr>
				<tr ng-show="filteredSize==0">
						<td colspan="8">No records found..</td>
					</tr>
				
			</table>
			
				<div ng-show="filteredListSize!=0" class="col-md-12 text-center">
									
										<pagination class="pagination-sm" page="currentPage" max-size="noOfPages"
												total-items="totalItems" items-per-page="entryLimit"
												 boundary-links="true"></pagination>
									</div>
			
		</div>
	</div>
	
	</form>
</div>
