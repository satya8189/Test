<!-- 	<!-- 	
<script>
	$(".link-active").removeClass("link-active");
	$("#sponcor").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}
.panel-body {
  /*padding: 10px 30px ;*/
}
</style>
 <body>
<div class="container-fluid">
	<a ng-click="cancelNetworkingView(eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	<!-- {{4+5}} --> 
<!-- 	<div class="panel">
	<form>
	<a ng-click="navigateToSponsorCreate(eventId)" class="btn btn-default pull-left button btn-color">Create Sponsor</a>
	</form>
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="networkList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table" id="viewnetworkList">
				<thead>
					<tr>
						<th>Sponsor Name</th>
						<th>SponsorDescription</th>
						<th>Action</th>
					</tr>
				</thead>
				 <tr ng-show="filteredSize!=0" ng-repeat="sp in filtered = sponsorsList | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit ">  
				
					<td>{{sp.sponcorName}}</td>
					<td>{{sp.sponcorDesc}}</td>
					<td>
						<a ng-click="editSponsor(sp.sponcorId)" title="EditSponsor">
							<i class="glyphicon glyphicon-pencil"> </i>
						</a>
					</td>
				</tr>
				<tr ng-show="filteredSize==0">
					<td colspan="6">
						No records found..
					</td>
				</tr>
				<tr>
					<td  colspan="6" align="center">
						<pagination page="currentPage" max-size="noOfPages" total-items="totalItems" 
							items-per-page="entryLimit" class="pagination" boundary-links="true"></pagination>
					</td>
						
				</tr> 
			</table>
			
 		<div  class="res-table" ng-show="filteredSize==0">
				No records found..
			</div>
		</div>
 </div>
</div>
 --> 


<script>
	$(".link-active").removeClass("link-active");
	$("#event").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}

</style>
<toaster-container></toaster-container>

<div class="cal-md-12">
	<form>
	
	<div class="header-none" align="center">EventsParticipant List</div>
	<a ng-click="cancelNetworkingView(eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	
	<div class="panel">
		<div class="panel-body">
		
	
		 <div class="col-md-2 col-md-offset-10 padding-0">
			 <input ng-model="search"  ng-show="networkList.length!=0" class="form-control" placeholder="Search">
		 </div> 
		
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table table-bordered" id="networkView">
				<thead class="headbg">
					<tr> 
					     <th>FirstName</th>
					     <th>LastName</th>
					     <th>Mobile </th>
						 <th>Email</th>
						 <th>Status</th>
						 <th>Action</th>
				   </tr>
				</thead>
				
				<tr ng-show="filteredSize!=0" ng-repeat="event in networkList | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit ">
				    <td >{{event.firstName}}</td>
				     <td >{{event.lastName}}</td>
				     <td >{{event.mobile}}</td>
					  <td >{{event.emailId}}</td>
					 <td>{{event.status}}</td>
					  
					<td>
						<a ng-click="networkingEdit(event.participantId)"title="eventViewDetails">
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
							items-per-page="entryLimit" class="pagination-sm" boundary-links="true">
						</pagination>
					</div>
				</div>
			
			
			
		</div>
	</div>
	</form>
</div>
