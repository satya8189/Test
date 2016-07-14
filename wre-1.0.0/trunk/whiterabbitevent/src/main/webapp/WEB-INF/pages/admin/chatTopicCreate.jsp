
<div class="container">
<c:set var="userId" value="${USER.userId}" scope="session" />
<div class="col-md-offset-2 col-md-8 margin-top-5">
	<a ng-click="cancelCreateChat()" class="btn btn-primary backbtn">
	Back
	</a>

	<form name="chatForm"	ng-submit="chatForm.$valid && saveChatTopic(chat)"  enctype="multipart/form-data" novalidate>


<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15 headbg">Create ChatTopic</div>
  <div class="panel-body panelbody-bg">
  <div>&nbsp;</div>
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">ChatTopicName: <span style="color:red;">*</span></label>
      		<input type="text" class="input-text form-control" id="chatTopicName" placeholder="ChatTopicName"  ng-model="chat.chatTopicName" 
      			name="chatTopicName" required>
      	  <span ng-if="chatForm.$submitted" ng-messages="chatForm.chatTopicName.$error" ng-messages-include="errors" style="color:red">
		  		</span>
		 		<div>&nbsp;</div>
	  </div>
	  
	  <div class="form-group col-md-6 "	id="uploadDiv">
     		<label class="flot-left">Upload a Document </label>
			<input class="input-text form-control" id="file" ng-model="filename" valid-file name="file" required type="file" accept="image/*"/>
			<span style="color:red" ng-if="chatForm.file.$invalid" ng-show="chatForm.$submitted">Please select a file to upload</span>
	  </div>  	
	</div>
	</div>
<div class="text-center">
<button type="submit" class="btn button btn-primary save margin-2">Save</button>
<div>&nbsp;</div> 
</div>
      
     
	 </div>
	 </div>
	
	 </form>
	 	 </div>