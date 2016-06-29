<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script>
	$(".link-active").removeClass("link-active");
	$("#event").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}
.panel-body {
  /* padding: 13px 50px ; */
}
</style>
<toaster-container></toaster-container>
<c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<c:set var="eventId" value="${event.eventId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">
<div class="container">
	<a ng-click="navigateToEventsView(eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
<div class="header-none" align="center">VideoView</div>
	<div class="tab-content">
              <div id="home" class="tab-pane fade in active">
            	<a ng-click="videoUpload(eventId)" class="btn btn-primary pull-left button btn-color" ng-hide="roleId==100">Upload Video</a> 
            	  
                <div class="col-md-12 padding-0">
			
                  <a class="col-md-3"  ng-repeat="video in videoList">
                    <div class="content-div">
                      <div class="centerimg">
                      <img src="satya.png"  class="img-responsive" >
                        </div>
                          <div>&nbsp;</div>
                      <div class="text-content" >

                        <label>Name : {{video.name}}</label>
                           
                           <button ng-click="deleteGallery(video)" title="deletgalary" class="btn btn-primary" ng-hide="roleId==100">Delete Video
							<!-- <i class="fa fa-eye-slash icons"> </i> -->
				</button>
                        
                    
                        
                      </div>
                    </div>
                  </a>
			</div>
         </div>
      </div>
     
</div>
