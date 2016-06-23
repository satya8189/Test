	
<script>
	$(".link-active").removeClass("link-active");
	$("#event").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}
.buttonbg1{
position: relative;
    top: 30px;
}
</style>
<toaster-container></toaster-container>

<div class="col-md-12">
	  <a ng-click="cancelQuestionsView(eventId)"> <i
		class="fa fa-angle-left back"></i>
	</a> 
	<form>
	
		<a ng-click="questionCreate(eventId)"title="eventViewDetails" class="btn btn-primary buttonbg1">Question Create
				<i class="fa fa-eye-slash icons "> </i>			 
				</a>
	
	<div class="header-none text-center">Question List</div>
	<div class="panel">
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="questionList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
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
						 <th>Action</th>
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
						<a ng-click="questionEdit(question.questionId)"title="eventViewDetails">
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
