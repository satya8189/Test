<h3>SpeakerProfile View List the Speaker</h3>
	
<script>
	$(".link-active").removeClass("link-active");
	$("#drugs").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}
.panel-body {
  padding: 10px 30px ;
}
</style>
<toaster-container></toaster-container>
<!-- {{4+5}} -->
<body>

<div class="row">
	
	<a ng-click="cancelSpeakerProfileView(eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	
	<div class="panel">
	<form>
	<a ng-click="navigateToSpeakerrCreate(eventId)" class="btn btn-default pull-left button btn-color">Add Speaker</a>
	</form>
		<div class="panel-body ">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="speakersList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table" id="viewSponsors">
				<thead>
					<tr>
						<th>Event Id</th>
						<th>Speaker ID</th>
						<th>Speaker Name</th>
						<th>Location</th>
						<th>Title</th>
						<th>Description</th>
						<th>Rating</th>
						<th>Action</th>
					</tr>
				</thead>
				<tr ng-show="filteredSize!=0" ng-repeat="sp in filtered = speakersList | filter: search ">
				<!-- | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit -->
					<td>{{sp.eventId}}</td>
					<td>{{sp.speakerId}}</td>
					<td>{{sp.speakerName}}</td>
					<td>{{sp.location}}</td>
					<td>{{sp.title}}</td>
					<td>{{sp.description}}</td>
					<td>{{sp.rating}}</td>
					<td>
						<a ng-click="editSpeaker(sp.speakerId)" title="EditSpeaker">
							<i class="glyphicon glyphicon-pencil"> </i>
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
							items-per-page="entryLimit" class="pagination-sm" boundary-links="true">
						</pagination>
					</td>
				</tr>
		</table>
		
		
		<!-- <table class="res-table" ng-show="filteredSize!=0" ng-repeat="sp in filtered = speakersList | filter:search ">
			<tbody>
			<tr>
						<th>Event Id</th>
						<td>{{sp.eventId}}</td>
					
						<th>Speaker ID</th>
						<td>{{sp.speakerId}}</td>
						
						<th>Speaker Name</th>
						<td>{{sp.speakerName}}</td>
					
						<th>Location</th>
						<td>{{sp.location}}</td>
						
						<th>Title</th>
						<td>{{sp.title}}</td>
					
						<th>Description</th>
						<td>{{sp.desc}}</td>
					
					
						<th>Rating</th>
						<td>{{sp.rating}}</td>
					
						<th>Action</th>
						<td>
							<a ng-click="editSpeaker(sp.speakerId)" title="EditSpeaker">
								<span class="glyphicon glyphicon-pencil"> </span>
							</a>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div  class="res-table" ng-show="filteredSize==0">
				No records found..
			</div>
		 -->
		 
		 </div>
 </div>
</div>