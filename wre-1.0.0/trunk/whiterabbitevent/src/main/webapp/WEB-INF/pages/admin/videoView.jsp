	
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
	
					
			<a ng-click="videoUpload(eventId)"title="eventViewDetails">VideoUpload
							<i class="fa fa-eye-slash icons"> </i>
				</a>
	
	<div class="header-none">VideoView</div>
	<div class="tab-content">
              <div id="home" class="tab-pane fade in active">
               
                <div class="col-md-12 padding-0">

                  <a class="col-md-3"  ng-repeat="upload in videoList">
                    <div class="content-div">
                      <div class="centerimg">
                      <img src="satya.png"  class="img-responsive" >
                        </div>
                      <div class="text-content" >

                        <label>Name : {{upload.name}}</label>
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