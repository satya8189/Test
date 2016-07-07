	
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
#none{
display:none;
}
</style>

<div class="cal-md-12" ng-init="getEventList('${userId}');">
	<form>
	<div class="header-none" align="center">Events List</div>
	<div class="panel">
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="eventList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
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
			
		</div>
	</div>
	</form>
</div>
