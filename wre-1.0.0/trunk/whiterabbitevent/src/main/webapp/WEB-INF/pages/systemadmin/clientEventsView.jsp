<style>
@media (min-width: 992px){
.col-md-offset-9 {
    margin-left: 74%;
}

</style>
<toaster-container></toaster-container>


	<form>
	<h3 class="text-center">ClientEventView</h3>
	<div class="container">
	
	
		<div class="col-md-4  padding-0">
		 <a ng-click="cancelClientEventView()" class="btn btn-primary backbtn">Back 
		
		</a> 
		<a ng-click="navigateClientEventCreate()" class="btn btn-primary button btn-color margin-b-8">Create Event</a>
		</div>
		 <div class="col-md-2 col-md-offset-6 padding-0">
		<input ng-model="search" class="form-control full-right" placeholder="Search"></div>

			
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
					<a ng-click="navigatetoEventEdit(event.eventId)"title="Edit"> <span
							class="glyphicon glyphicon-pencil margin-2 icons"> </span></a>
							
							<a ng-click="eventView(event.eventId)"title="ViewDetails">
								<i class="fa fa-eye-slash icons"> </i>
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
