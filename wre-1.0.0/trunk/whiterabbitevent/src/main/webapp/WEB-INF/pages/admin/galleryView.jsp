<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script>
	$(".link-active").removeClass("link-active");
	$("#event").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}

</style>
<toaster-container></toaster-container>
<c:set var="userId" value="${USER.userId}" scope="session" />
<c:set var="roleId" value="${USER.roleId}" scope="session" />
<c:set var="eventId" value="${event.eventId}" scope="session" />
<input type="hidden" ng-init="roleId='${USER.roleId}'" value="${USER.roleId}" ng-model="roleId">
<div class="col-md-12">
	<form>
	<a ng-click="cancelGalleryView(eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
	
	<div class="tab-content">
		<a ng-click="galleryCreate(eventId)" class="btn btn-primary pull-left button btn-color" ng-hide="roleId==100"> Create Gallary</a>
	          <div id="home" class="tab-pane fade in active">
    <div class="header-none text-center">Gallery List</div>	
    <div>&nbsp;</div>		           
                <div class="col-md-12 padding-0">

                  <a class="col-md-3"  ng-repeat="galary in galaryList  ">
                    <div class="content-div">
                      <div class="centerimg">
                      <img src="http://hdwallpapershdpics.com/wp-content/uploads/2015/08/Cool-Tiger-Wallpaper-1920x1080-HD.jpg" 
                      style="width: 20em;margin-left:-2em !important;">
                        </div>
                         <div>&nbsp;</div>
                      <div class="text-content" >

                        <label>Name : {{galary.name}}</label>
                        
                       
                           <button ng-click="deleteGallery(galary)" title="deletgalary" class="btn btn-primary" ng-hide="roleId==100">DeleteGallery
							<i class="fa fa-eye-slash icons"> </i>
				</button>
                        
                    
                        <br/>
                        
                      

                        


                        <!-- <div class="text-right">{{video.duration}}</div>
                       </div>-->
                      </div>
                    </div>
                  </a>

                </div>
              </div>
	</form>
</div>
