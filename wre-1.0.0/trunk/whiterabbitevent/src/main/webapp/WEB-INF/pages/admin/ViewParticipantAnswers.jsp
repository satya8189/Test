	
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

  
<div class="col-md-12">
	<a ng-click="cancelParticipantAnswersView(eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	<!-- {{4+5}}  -->
	<div class="panel">
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="partcipantQuestionAnswerList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table table-bordered" id="viewParticipantsQuestionAnswers">
				<thead class="headbg">
					<tr>
						<th>Question</th>
						<th>Exact Answer</th>
						<th>Participant Answer</th>
					</tr>
				</thead>
				 <tr ng-show="filteredSize!=0" ng-repeat="pqa in filtered = partcipantQuestionAnswerList | filter: search | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit ">  
					<td>{{pqa.surveyQuestion.question}}</td> 
					<td>{{pqa.answer}}</td>
					<td>{{pqa.participantAnswer}}</td>
					
					<!-- <td>
						<a ng-click="viewQuestionAndAnswers(participant.participantId)" title="View Question and Answers">
							<i class="glyphicon glyphicon-eye-open"> </i>
						</a>
					</td> -->
				</tr>
				<tr ng-show="partcipantQuestionAnswerList.length==0">
				<td colspan="6">
				No records found..
				</td>
				</tr>
				</table>
				<div ng-show="filteredSize!=0">
					<div  colspan="6" align="center">
						<pagination page="currentPage" max-size="noOfPages" total-items="totalItems" 
							items-per-page="entryLimit" class="pagination" boundary-links="true"></pagination>
					</div>
				</div>
		</div>
 </div>
</div>


 