
<div class="container" ng-init="getEventList('${userId}');">
<h3 class="text-center">Events List</h3>
	<form>


		 <div class="col-md-2 col-md-offset-10 padding-0" style="margin-bottom: 5px;">
		 <input ng-model="search"  ng-show="eventList.length!=0" class="form-control" placeholder="Search">
			</div> 

			<table class="table table-bordered" id="eventView">
				<thead class="headbg">
					<tr>
					     <th>Event Name</th>
					     <th>Event Address</th>
						 <th>Event Desc</th>
						 <th>Event Agenda </th>
					     <th>Event Date</th>
						 <th>Status</th>
						 <th>Action</th>
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0" ng-repeat="event in eventList | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit ">
					<td>{{event.eventName}}</td>
					<td>{{event.eventAddress}}</td>
					<td>{{event.eventDesc}}</td>
				    <td>{{event.eventAgenda}}</td>
				    <td>{{event.eventDate | date: 'yyyy-MM-dd'}}</td>
					<td>{{event.status}}</td>
					<td>
						<a ng-click="eventViewDetails(event.eventId)"title="eventViewDetails">
							<i class="fa fa-eye-slash icons"> </i>
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
