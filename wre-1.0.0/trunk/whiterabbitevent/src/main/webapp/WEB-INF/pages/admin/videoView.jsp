	
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

<div class="container">
	<a ng-click="navigateToEventsView(eventId)">
		 <i class="fa fa-angle-left back"></i>
	</a>
<div class="header-none" align="center">VideoView</div>
	<div class="tab-content">
              <div id="home" class="tab-pane fade in active">
            	<a ng-click="videoUpload(eventId)" class="btn btn-primary pull-left button btn-color">Upload Video</a> 
            	  
                <div class="col-md-12 padding-0">
			
                  <a class="col-md-3"  ng-repeat="video in videoList">
                    <div class="content-div">
                      <div class="centerimg">
                      <img src="satya.png"  class="img-responsive" >
                        </div>
                          <div>&nbsp;</div>
                      <div class="text-content" >

                        <label>Name : {{video.name}}</label>
                           
                           <button ng-click="deleteGallery(video)" title="deletgalary" class="btn btn-primary">Delete Video
							<!-- <i class="fa fa-eye-slash icons"> </i> -->
				</button>
                        
                    
                        
                      </div>
                    </div>
                  </a>
			</div>
         </div>
      </div>
     
</div>
