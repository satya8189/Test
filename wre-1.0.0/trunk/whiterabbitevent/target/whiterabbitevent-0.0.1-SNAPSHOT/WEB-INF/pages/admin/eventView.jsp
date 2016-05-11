	
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
		<a href="#/eventCreate"
			class="btn btn-default pull-right button btn-color">Create
			Event</a>
	</form>
	<div class="header-none">Event List</div>
	<div class="panel">
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="eventList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table" id="eventView">
				<thead>
					<tr>
					     <th>EventAddress</th>
					     <th>EventAgenda </th>
						 <th>Event Name</th>
						 <th> EventDesc</th>
						  <th>EventDate</th>
						 <th>Status</th>
						
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0"ng-repeat="event in eventList ">
				    <td >{{event.eventAddress}}</td>
					<td >{{event.eventAgenda}}</td>
					<td >{{event.eventName}}</td>
					<td >{{event.eventDesc}}</td>
				    <td >{{event.eventDate | date: 'yyyy-MM-dd'}}</td>
					<td >{{event.status}}</td>
			<td>
					
				<a ng-click="editEvent(event.eventId)" title="Edit Event">
							<span class="glyphicon glyphicon-pencil icons"> </span>
						</a>
							
						<a ng-click="navigateToEventViewDetails(event.eventId)"title="eventViewDetails">
							<i class="fa fa-eye-slash icons"> </i>
						</a>
						
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
</div>
