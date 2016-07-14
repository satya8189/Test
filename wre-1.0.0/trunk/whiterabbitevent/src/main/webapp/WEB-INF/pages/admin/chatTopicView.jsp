
<toaster-container></toaster-container>
<c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<c:set var="eventId" value="${event.eventId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">
<div class="container margin-top-5">
	
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
	
	
	 


		 			 <div class="col-md-4 padding-0">
		 	<a ng-click="navigateToEventViewDetails(eventId)" class="btn btn-primary backbtn">Back
	</a>
	<a ng-click="navigateChatTopicCreate(eventId)" class="btn btn-primary " ng-hide="roleId==100">CreateChatTopic</a></div>
			 <div class="col-md-2 col-md-offset-6 padding-0">
		 <input ng-model="search"  ng-show="chatList.length!=0" ng-show="chatList.length > 0" class="form-control" placeholder="Search">
		 	</div> 
		 	

			<table class="table table-bordered" id="eventView">
				<thead class="headbg">
					<tr>
					    
					     <th>ChatTopicName </th>
						 
						  <th ng-hide="roleId==100">Action</th>
						
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0" ng-repeat="chat in chatList | filter:search | startFrom : (currentPage-1)*entryLimit | limitTo : entryLimit">
				   
					<td >{{chat.chatTopicName}}</td>
					
					
					<td>
					<a ng-click="navigateToChatEdit(chat.chatTopicId)" title="edit" ng-hide="roleId==100">
							<span class="glyphicon glyphicon-pencil margin-2 icons"> </span>
						</a>
					<a	title="delete" ng-click="deleteChat(chat.chatTopicId)"  ng-hide="roleId==100">
							<span class="glyphicon glyphicon-trash margin-2 red"> </span>
					</a>		
					</td>	
					
				</tr>	
					<tr ng-show="filteredSize==0">
				<td>
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
			

	</form>

</div>