
<div class="col-md-8 col-md-offset-2">
	<a ng-click="cancelCreateSponcor(sponsor.eventId)" class="btn btn-primary backbtn margin-top-5">
Back
	</a>
	
	<c:set var="userId" value="${user.userId}" scope="session" />
	<div class="panel">
		<div class="panel-heading text-center font-size-20 padding-5 headbg">Create Sponsor</div>
		<div class="panel-body  panelbody-bg">
			<form name="orgCreateForm"	ng-submit="orgCreateForm.$valid && saveSponsor(sponsor)"  enctype="multipart/form-data" novalidate>
				<div>&nbsp;</div>
				<div class="row">
					<div class="col-md-12">
						<div class=" form-group col-md-6">
							<label class="flot-left">Sponsor Name <span style="color:red;">*</span></label> 
							<input type="text" class="input-text form-control" id="sponcorName"
								placeholder="Sponsor Name" ng-model="sponsor.sponcorName" name="sponcorName" required> 
                         	<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.sponcorName.$error" ng-messages-include="errors" style="color:red">
		  						</span>
						</div>
					
						<div class="form-group col-md-6" ng-init="minlength=10">
							<label class="flot-left">Sponsor Description<span style="color:red;">*</span></label> 
								<input type="text" class="input-text form-control" name="sponcorDesc"
								placeholder="Sponsor Description" ng-model="sponsor.sponcorDesc"  required> 
                         		<span ng-if="orgCreateForm.$submitted" ng-messages="orgCreateForm.sponcorDesc.$error" ng-messages-include="errors" style="color:red">
						</div>
				
				
				<div class="form-group col-md-6 "	id="uploadDiv">
     		  				<label class="flot-left">Upload a Document </label>
							<input class="input-text form-control" id="file" ng-model="filename" valid-file name="file" required type="file" accept="image/*"/>
							<span style="color:red" ng-if="orgCreateForm.file.$invalid" ng-show="orgCreateForm.$submitted">Please select a file to upload</span>
							<!-- <span ng-if="createEvent.file.$invalid" ng-messages="createEvent.file.$file" ng-messages-include="errors" style="color:red"></span> -->
			  	</div>
			</div>
		<div>&nbsp;</div>
								<div class=" form-group col-md-12 text-center">
				<button type="submit" class="btn button btn-primary save margin-2">Save</button>
				</div>
				
			<div>&nbsp;</div>
			</form>

		</div>
	</div>
</div>
