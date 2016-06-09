	
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
	<a ng-click="cancelQuestionAndAnswerView(eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	<!-- {{4+5}}  -->
	<div class="panel">
		<div class="panel-body">
		 <div class="col-md-2 col-md-offset-10 padding-0">
		 <input ng-model="search"  ng-show="participantsList.length!=0" class="form-control" placeholder="Search">
			</div> 
			<div class="col-md-12 space-hid">&nbsp;</div>
			<table class="table" id="viewParticipants">
				<thead>
					<tr>
						<th>First Name</th>
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


 