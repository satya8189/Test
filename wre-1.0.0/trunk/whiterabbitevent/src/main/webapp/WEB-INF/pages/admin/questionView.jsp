
<toaster-container></toaster-container>
 <c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<c:set var="eventId" value="${event.eventId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">
<h3 class="text-center">Question List</h3>
<div class="container">

	<form>
			 <div class="col-md-4 padding-0">
			 	  <a ng-click="cancelQuestionsView(eventId)" class="btn btn-primary backbtn"> 
Back
	</a> 
		<a ng-click="questionCreate(eventId)"title="eventViewDetails" class="btn btn-primary buttonbg1" ng-hide="roleId==100">Question Create
		 
				</a>
</div>
		 <div class="col-md-2 col-md-offset-6 padding-0">
		 <input ng-model="search"  ng-show="questionList.length!=0" class="form-control" placeholder="Search">
			</div> 

			<table class="table table-bordered" id="eventView">
				<thead class="headbg">
					<tr>
					     <th>Question</th>
					     <th>QuestionType</th>
					     <th>Option-A </th>
						 <th>Option-B</th>
						 <th>Option-C</th>
						 <th>Option-D</th>
						 <th>Answer</th>
						 <th ng-hide="roleId==100">Action</th>
						</tr>
				</thead>
				<tr ng-show="filteredSize!=0" ng-repeat="question in questionList  | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit">
				    <td>{{question.question}}</td>
				    <td>{{question.appIdentifierName}}</td>
					<td>{{question.optionA}}</td>
					<td>{{question.optionB}}</td>
					<td>{{question.optionC}}</td>
				    <td>{{question.optionD}}</td>
				    <td>{{question.answer}}</td>
					<td>
						<a ng-click="questionEdit(question.questionId)" title="edit" ng-hide="roleId==100">
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
