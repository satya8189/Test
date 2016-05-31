	
<script>
	$(".link-active").removeClass("link-active");
	$("#event").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}
.panel-body {
  padding: 13px 50px ;q
}
</style>
<toaster-container></toaster-container>

<div class="container">
	  <a ng-click="cancelQuestionsView(eventId)"> <i
		class="glyphicon glyphicon-chevron-left"></i>
	</a> 
	<form>
	
		<a ng-click="questionCreate(eventId)"title="eventViewDetails">Question Create
							<i class="fa fa-eye-slash icons"> </i>
				</a>
	
	<div class="header-none">Question List</div>
	<div class="panel">
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="questionList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table" id="eventView">
				<thead>
					<tr>
					     <th>Question</th>
					      <th>QuestionType</th>
					     <th>Option-A </th>
						 <th>Option-B</th>
						 <th>Option-C</th>
						 <th>Option-D</th>
						 <th>Answer</th>
						 
				   </tr>
				</thead>
				<tr ng-show="filteredSize!=0"ng-repeat="question in questionList ">
				    <td >{{question.question}}</td>
				    <td >{{question.appIdentifierName}}</td>
					<td >{{question.optionA}}</td>
					<td >{{question.optionB}}</td>
					<td >{{question.optionC}}</td>
				    <td >{{question.optionD}}</td>
				    <td >{{question.answer}}</td>
			<td>
					
				<a ng-click="questionEdit(question.questionId)"title="eventViewDetails">
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
