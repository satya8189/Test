	
<script>
	$(".link-active").removeClass("link-active");
	$("#event").addClass("link-active");	
</script>
<style>
.panel{
margin-bottom:0px !important;
}
.panel-body {
  padding: 13px 50px ;
}
</style>
<toaster-container></toaster-container>

<div class="container">
	<form>
	
					
			<a ng-click="galleryCreate(eventId)"title="eventViewDetails">GaleryCreate
							<i class="fa fa-eye-slash icons"> </i>
				</a>
				
				     
	
	<div class="header-none">Gallery List</div>
	<div class="tab-content">
              <div id="home" class="tab-pane fade in active">
               
                <div class="col-md-12 padding-0">

                  <a class="col-md-3"  ng-repeat="galary in galaryList  ">
                    <div class="content-div">
                      <div class="centerimg">
                      <img src="http://hdwallpapershdpics.com/wp-content/uploads/2015/08/Cool-Tiger-Wallpaper-1920x1080-HD.jpg" 
                      style="width: 20em;margin-left:-2em !important;">
                        </div>
                      <div class="text-content" >

                        <label>Name : {{galary.name}}</label>
                        
                        
                           <button ng-click="deleteGallery(galary)" title="deletgalary">DeleteGallery
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
