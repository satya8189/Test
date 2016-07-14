


  <c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<c:set var="eventId" value="${event.eventId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">
<div class="container">
	<h3 class="text-center margin-top-5">Question And Answers View</h3>

		<div class="col-md-2  padding-0">
		<a ng-click="cancelQuestionAndAnswerView(eventId)" class="btn btn-primary backbtn">
		 Back
	</a>
	</div>
		 <div class="col-md-2 col-md-offset-8 padding-0">
		 
		 <input ng-model="search"  ng-show="participantsList.length!=0" class="form-control" placeholder="Search">
			</div> 
			
			
			<table class="table table-bordered" id="viewParticipants">
				<thead class="headbg">
					<tr>
						<th>Participant Name</th>
						<th>Action</th>
					</tr>
				</thead>
				 <tr ng-show="filteredSize!=0" ng-repeat="participant in filtered = participantsList | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit ">  
				
					<td>{{participant.firstName}}</td>
					
					<td>
						<a ng-click="viewQuestionAndAnswers(participant.participantId)" title="View Question and Answers">
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
				<div>
					<div  colspan="6" align="center">
						<pagination page="currentPage" max-size="noOfPages" total-items="totalItems" 
							items-per-page="entryLimit" class="pagination" boundary-links="true"></pagination>
					</div>
						
				</div> 

		</div>



 