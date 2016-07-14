
 <body>
  <c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<c:set var="eventId" value="${event.eventId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">

<div class="container margin-top-5">
 <div class="col-md-4 padding-0">
	<a ng-click="cancelSocialMediaView(eventId)" class="btn btn-primary backbtn">Back
		
	</a>
	
	
	<a ng-click="createSocialMedia(eventId)" class="btn btn-primary  button btn-color buttonbg" ng-hide="roleId==100">Create SocialMedia</a>
	</div>
		 <div class="col-md-2 col-md-offset-6 padding-0">
		 <input ng-model="search"  ng-show="sponsorsList.length!=0" class="form-control" placeholder="Search">
			</div> 
			
			<table class="table table-bordered" id="viewSocialMedia">
				<thead class="headbg">
					<tr>
						<th>Name</th>
						<th>URL</th>
						<th ng-hide="roleId==100">Action</th>
					</tr>
				</thead>
				 <tr ng-show="filteredSize!=0" ng-repeat="sm in filtered = socialmediaList | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit ">  
					<td>{{sm.name}}</td>
					<td>{{sm.url}}</td>
					<td>
						<a ng-click="editSocialMedia(sm.socialId)" title="edit" ng-hide="roleId==100">
							<i class="glyphicon glyphicon-pencil"> </i>
						</a>
						
						<a ng-click="deleteSocialMedia(sm.socialId)" title="delete" ng-hide="roleId==100">
							<i class="glyphicon glyphicon-trash"> </i>
						</a>
					</td>
				</tr>
				<tr class="res-table" ng-show="filteredSize==0">
					<td colspan="6">
						No records found..
					</td>
				</tr>
				
			</table>
			<div ng-show="filteredListSize!=0" class="col-md-12 text-center">
					<pagination class="pagination-sm" page="currentPage" max-size="noOfPages"
								total-items="totalItems" items-per-page="entryLimit"
						 boundary-links="true">
				    </pagination>
			</div>
			 </div>
</div>
