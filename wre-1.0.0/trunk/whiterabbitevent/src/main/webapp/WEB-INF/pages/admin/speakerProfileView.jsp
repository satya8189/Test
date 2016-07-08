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
	<h3 class="text-center">Speaker Profile View</h3>
	<div class="panel">
		<div class="panel-body ">
		<div class="col-md-2  padding-0">
		 <a ng-click="cancelSpeakerProfileView(eventId)"> <i
		class="fa fa-angle-left back"></i>
		</a> 
		<a ng-click="navigateToSpeakerrCreate(eventId)" class="btn btn-primary button btn-color margin-b-8">Create Speaker</a>
		</div>
		 <div class="col-md-2 col-md-offset-8 padding-0">
		 <input ng-model="search"  ng-show="speakersList.length!=0" class="form-control" placeholder="Search">
			</div> 
			
			<table class="table table-bordered " id="viewSponsors">
				<thead class="headbg">
					<tr>
					
						<th>Speaker Name</th>
						<th>Location</th>
						<th>Title</th>
						<th>Description</th>
						<th>Rating</th>
						<th>Action</th>
					</tr>
				</thead>
				<tr ng-show="filteredSize!=0" ng-repeat="sp in filtered = speakersList | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit">
					
					<td>{{sp.speakerName}}</td>
					<td>{{sp.location}}</td>
					<td>{{sp.title}}</td>
					<td>{{sp.description}}</td>
					<td>{{sp.rating}}</td>
					<td>
						<a ng-click="editSpeaker(sp.speakerId)" title="edit">
							<i class="glyphicon glyphicon-pencil"> </i>
						</a>
						<a ng-click="viewSpeakerImage(sp.speakerId)" title="view">
							<i class="glyphicon glyphicon-eye-open"> </i>
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
</div>