	
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
	<a ng-click="cancelSponsorPageView(eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	<!-- {{4+5}} --> 
	<div class="panel">
	<form>
	<a ng-click="navigateToSponsorCreate(eventId)" class="btn btn-default pull-left button btn-color">Create Sponsor</a>
	</form>
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="sponsorsList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table" id="viewSponsors">
				<thead>
					<tr>
						<th>Sponsor Name</th>
						<th>SponsorDescription</th>
						<th>Action</th>
					</tr>
				</thead>
				 <tr ng-show="filteredSize!=0"
				ng-repeat="sp in filtered = sponsorsList | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit ">  
				
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
				
				<!-- <tr  ng-show="filteredSize!=0">
					<td colspan="6" align="center">
					<pagination page="currentPage" max-size="noOfPages" total-items="totalItems" items-per-page="entryLimit"></pagination>
					</td>
				</tr> -->
				<!-- 
				<tr>
					<td colspan="6" align="center">
					
					
					<ul class="pagination">
 						  <li class="pull-left">
  					<button type="button" class="btn btn-primary" ng-disabled="currentPage == 0"
 									ng-click="currentPage=currentPage-1">PREV</button>
						</li>
 						<li>
 							<span>Page {{currentPage}} of {{ noOfPages }}</span>
 						</li>
 						 <li class="pull-right">
 						<button  class="btn btn-primary" type="button"
 								ng-disabled="currentPage >= noOfPages"
 									ng-click="currentPage = currentPage+1">NEXT </button>
						</li> 
					</ul>
						</td>
					
				</tr> -->
				
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


 <!--
 
 
 <div ng-repeat="sp in sponsorsList | filter:q | itemsPerPage: pageSize" current-page="currentPage">{{ sp.sponcorName }}</div>
 
 
 <dir-pagination-controls boundary-links="true" on-page-change="pageChangeHandler(newPageNumber)" 
 		template-url="resources/js/dirPagination/dirPagination.tpl.html"></dir-pagination-controls>
 
  -->