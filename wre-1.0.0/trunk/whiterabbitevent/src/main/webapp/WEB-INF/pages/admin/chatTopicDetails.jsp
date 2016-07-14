
<div class="col-md-8 col-md-offset-2 margin-top-5">
	<a ng-click="cancelUpdateChat(chat)" class="btn btn-primary backbtn">
Back
	</a>
	
<form name="chatEditForm" ng-submit="chatEditForm.$valid && updateChat(chat)" enctype="multipart/form-data" novalidate>
<div class="panel">	
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Edit ChatTopic</div>	
  <div class="panel-body text-center">
  <div>&nbsp;</div>
  <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
		 <label>ChatTopic </label>
			<input type="text" class="input-text form-control" id="chatTopicName" placeholder="ChatTopicName" 
			ng-model="chat.chatTopicName" name="chatTopicName" required/>
			<div ng-if="chatEditForm.$submitted" ng-messages="chatEditForm.chatTopicName.$error" ng-messages-include="errors" style="color:red;">
 				</div>
		</div>			
		<div class="form-group col-md-6 "	id="uploadDiv">
     		<label class="flot-left">Upload an Image </label>
			<input class="input-text form-control" id="file" ng-model="filename" valid-file name="file" required type="file" accept="image/*"/>
			<span style="color:red" ng-if="chatEditForm.file.$invalid" ng-show="chatEditForm.$submitted">Please select a file to upload</span>
  		</div>
	</div>
  </div>
  
  <div class="text-center">
	<div class="form-group col-md-12 text-center">	
		<div>&nbsp;</div>
		<button type="submit" class="btn button btn-primary save margin-2">Update</button>
	</div>
  </div>
  
 </div>
</div>
</form>