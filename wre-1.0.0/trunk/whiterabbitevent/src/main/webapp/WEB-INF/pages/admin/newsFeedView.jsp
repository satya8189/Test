	
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

<div class="col-md-12">
	
	<a ng-click="cancelNewsFeedView(eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	 
	<form>
	<div class="panel">
	<a ng-click="newsFeedCreate(eventId)" class="btn btn-primary pull-left button btn-color buttonbg">Create NewsFeed</a>
		<div class="panel-body">
			<div class="header-none" align="center">News List</div>
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="newsList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table table-bordered" id="eventView">
				<thead class="headbg">
					<tr>
					     <th>NewsTitle</th>
					     <th>NewsDesc </th>
						 <th>NewsDate</th>
						  <th>Action</th>
						
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0"ng-repeat="news in newsList | filter : search | startFrom: (currentPage-1)*entryLimit | limitTo:entryLimit">
				    <td >{{news.newsTitle}}</td>
					<td >{{news.newsDesc}}</td>
					<td >{{news.newsDate | date: 'yyyy-MM-dd'}}</td>
					
			<td>
					
				<a ng-click="newsFeedEdit(news.newsFeedId)"title="newsFeedEdit">
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
