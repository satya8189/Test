<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		
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

  <c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<c:set var="eventId" value="${event.eventId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">
<div class="col-md-12">
	<div class="panel">
	<div class="panel-body">
		<div class="col-md-2  padding-0">
		 <a ng-click="cancelSponsorPageView(eventId)"> <i
		class="fa fa-angle-left back"></i>
		</a> 
		<a ng-click="navigateToSponsorCreate(eventId)" class="btn btn-primary button btn-color margin-b-8">Create Sponsor</a>
		</div>
		 <div class="col-md-2 col-md-offset-8 padding-0">
		 <input ng-model="search"  ng-show="sponsorsList.length!=0" class="form-control" placeholder="Search">
			</div> 
			
			
			<table class="table table-bordered" id="viewSponsors">
				<thead class="headbg">
					<tr>
						<th>Sponsor Name</th>
						<th>SponsorDescription</th>
						<th ng-hide="roleId==100">Action</th>
					</tr>
				</thead>
				 <tr ng-show="filteredSize!=0" ng-repeat="sp in filtered = sponsorsList | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit ">  
				
					<td>{{sp.sponcorName}}</td>
					<td>{{sp.sponcorDesc}}</td>
					<td>
						<a ng-click="editSponsor(sp.sponcorId)" title="edit">
							<i class="glyphicon glyphicon-pencil" ng-hide="roleId==100"> </i>
						</a>
						
						<a ng-click="viewSponsorDetails(sp.sponcorId)" title="view">
							<i class="glyphicon glyphicon-eye-open" ng-hide="roleId==100"> </i>
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
					<div  colspan="6" align="center">
						<pagination page="currentPage" max-size="noOfPages" total-items="totalItems" 
							items-per-page="entryLimit" class="pagination" boundary-links="true"></pagination>
					</div>
				</div> 
			
		</div>
 </div>
</div>