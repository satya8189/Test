	
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
<a ng-click="cancelOrganization()"> <i
		class="fa fa-angle-left back"></i>
	</a>
	
<form>
	
			
			
							
			<a ng-click="navigateagendoCreate(eventId)"title="eventViewDetails">agendoCreate
							<i class="fa fa-eye-slash icons"> </i>
				</a>
				
				
			<!-- 				 
			<a href="#/agendoCreate"
			class="btn btn-default pull-right button btn-color">Create
			AgendoCreate</a>
				</a>
			 -->	

	
	<div class="header-none">Event List</div>
	<div class="panel">
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="agendoList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table" id="eventView">
				<thead>
					<tr>
					     <th>AgenTitle</th>
					     <th>AgenDesc </th>
						 <th>AgenStartTime</th>
						  <th>AgenEndTime</th>
						 <th>AgenBy</th>
						  <th>Action</th>
						
						
						 
						
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0"ng-repeat="event in agendoList ">
				    <td >{{event.agenTitle}}</td>
					<td >{{event.agenDesc}}</td>
					<td >{{event.agenStartTime}}</td>
					<td >{{event.agenEndTime}}</td>
					<td >{{event.agenBy}}</td>
					
					<td>
					
				<a ng-click="agendoEdit(event.agenId)"title="agendoEdit">
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
