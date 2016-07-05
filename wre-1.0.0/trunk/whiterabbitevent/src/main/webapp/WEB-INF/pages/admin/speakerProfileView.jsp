<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
	<style>
	.buttontop{
	position: relative;
    top: 10px;
	}
	
	</style>
<script>
	$(".link-active").removeClass("link-active");
	$("#drugs").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}
.panel-body {
  /* padding: 10px 30px ; */
}
</style>
<toaster-container></toaster-container>
<!-- {{4+5}} --> 
<body>
<c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<c:set var="eventId" value="${event.eventId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">
<div class="col-md-12">
	
	<a ng-click="cancelSpeakerProfileView(eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	
	<div class="panel">
	<form>
	<a ng-click="navigateToSpeakerrCreate(eventId)" class="btn btn-primary pull-left button btn-color buttonbg" ng-hide="roleId==100">Create Speaker</a>
	</form>
		<div class="panel-body ">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="speakersList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table table-bordered " id="viewSponsors">
				<thead class="headbg">
					<tr>
					
						<th>Speaker Name</th>
						<th>Location</th>
						<th>Title</th>
						<th>Description</th>
						<th>Rating</th>
						<th ng-hide="roleId==100">Action</th>
					</tr>
				</thead>
				<tr ng-show="filteredSize!=0" ng-repeat="sp in filtered = speakersList | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit">
					
					<td>{{sp.speakerName}}</td>
					<td>{{sp.location}}</td>
					<td>{{sp.title}}</td>
					<td>{{sp.description}}</td>
					<td>{{sp.rating}}</td>
					<td>
						<a ng-click="editSpeaker(sp.speakerId)" title="edit" ng-hide="roleId==100">
							<i class="glyphicon glyphicon-pencil"> </i>
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