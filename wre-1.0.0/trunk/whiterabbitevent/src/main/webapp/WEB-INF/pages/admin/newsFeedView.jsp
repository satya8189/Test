	
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
	--<!--  <a href="#/newsFeedCreate"
			class="btn btn-default pull-right button btn-color">Create
			NewsFeed</a>
	  -->
	 
	 	 <a ng-click="newsFeedCreate(eventId)"title="newsFeedCreate">Create News
							<i class="fa fa-eye-slash icons"> </i>
				</a>
				 
	<div class="header-none">News List</div>
	<div class="panel">
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="newsList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table" id="eventView">
				<thead>
					<tr>
					     <th>NewsTitle</th>
					     <th>NewsDesc </th>
						 <th>NewsDate</th>
						  <th>Action</th>
						
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0"ng-repeat="news in newsList ">
				    <td >{{news.newsTitle}}</td>
					<td >{{news.newsDesc}}</td>
					<td >{{news.newsDate | date: 'yyyy-MM-dd'}}</td>
					
			<td>
					
				<a ng-click="newsFeedEdit(news.newsFeedId)"title="newsFeedEdit">
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
	</form>
</div>
