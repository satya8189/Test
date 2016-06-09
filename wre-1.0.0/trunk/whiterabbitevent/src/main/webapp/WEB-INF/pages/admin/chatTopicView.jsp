	
<script>
	$(".link-active").removeClass("link-active");
	$("#event").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}
.panel-body {
  /* padding: 13px 50px ; */
}
</style>
<toaster-container></toaster-container>

<!-- <div class="container-fluid">
 <a ng-click="cancelAgendoView(eventId)"> <i
		class="glyphicon glyphicon-chevron-left"></i>
	</a>  -->
	
<form>
<div class="alert-bg" ng-show="alert">
		<div class="alert alert-danger alert-dismissible" role="alert">
			<button type="button" class="close" ng-click="alert=false"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<i class="fa fa-frown-o font-size-25"></i> <span class="position-rel"
				style="top: -3px"> Do you want to Delete?
				<div class="small-screen">&nbsp;</div> <a
				class="confirm-btn model-show" ng-click="deleteInsurance(reject)">Yes</a>
				<a class="confirm-btn" href="" ng-click="alert=false">No</a>
			</span>
		</div>
	</div>
	<a ng-click="navigateChatTopicCreate(eventId)" class="btn btn-default pull-left button btn-color">CreateChatTopic</a>
	
	 
	 			
	
	<div class="panel">
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="chatList.length!=0" class="form-control" placeholder="Search"">
		 	</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table" id="eventView">
				<thead>
					<tr>
					     <th>ChatId</th>
					     <th>ChatTopicName </th>
						 
						  <th>Action</th>
						
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0" ng-repeat="chat in chatList | filter:search | startFrom : (currentPage-1)*entryLimit | limitTo : entryLimit">
				    <td >{{chat.chatTopicId}}</td>
					<td >{{chat.chatTopicName}}</td>
					
					
					<td>
					<a ng-click="navigateToChatEdit(chat.chatTopicId)" title="EditChatTopicDetails">
							<span class="glyphicon glyphicon-pencil margin-2 icons"> </span>
						</a>
					<a
						title="DeleteChatTopic" ng-click="deleteChat(chat.chatTopicId)">
							<span class="glyphicon glyphicon-trash margin-2 red"> </span>
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

