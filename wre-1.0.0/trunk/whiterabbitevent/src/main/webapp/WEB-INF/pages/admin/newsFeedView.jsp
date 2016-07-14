
<c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<c:set var="eventId" value="${event.eventId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">

<div class="container margin-top-5">
	<h3 class="text-center">News Feed List </h3>
	
	 
	<form>
	<div class="col-md-4  padding-0">
	<a ng-click="cancelNewsFeedView(eventId)" class="btn btn-primary backbtn">Back
		
	</a>
	<a ng-click="newsFeedCreate(eventId)" class="btn btn-primary button btn-color buttonbg" ng-hide="roleId==100">Create NewsFeed</a>
		</div>
		 <div class="col-md-2 col-md-offset-6 padding-0">
		 <input ng-model="search"  ng-show="newsList.length!=0" class="form-control" placeholder="Search">
			</div> 
			
			<table class="table table-bordered" id="eventView">
				<thead class="headbg">
					<tr>
					     <th>News Title</th>
					     <th>News Descriptin </th>
						 <th>News Date</th>
						  <th ng-hide="roleId==100">Action</th>
						
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0"ng-repeat="news in newsList | filter : search | startFrom: (currentPage-1)*entryLimit | limitTo:entryLimit">
				    <td >{{news.newsTitle}}</td>
					<td >{{news.newsDesc}}</td>
					<td >{{news.newsDate | date: 'yyyy-MM-dd'}}</td>
					
			<td>
					
				<a ng-click="newsFeedEdit(news.newsFeedId)" title="edit" ng-hide="roleId==100">
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
							items-per-page="entryLimit" class="pagination-sm" boundary-links="true"></pagination>
					</div>
				</div>
			
			
			
		</div>
	</div>
	</form>
</div>
