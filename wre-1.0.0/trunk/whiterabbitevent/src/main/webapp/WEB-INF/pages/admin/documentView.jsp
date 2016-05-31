	
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
	<form>
	<a ng-click="goToEventsView(eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	<div class="tab-content"><div class="header-none" align="center">DocumentView</div>
              <div id="home" class="tab-pane fade in active">
               <a ng-click="documentCreate(eventId)" class="btn btn-default pull-left button btn-color">Create Document</a>
                <div class="col-md-12 padding-0">

                  <a class="col-md-3"  ng-repeat="document in galaryList">
                    <div class="content-div">
                      <div class="centerimg">
                      <img src="satya.png"  class="img-responsive" >
                        </div>
                      <div class="text-content" >

                        <label>Name : {{document.name}}</label>
                        <br/>

                          <button ng-click="deleteGallery(document)" title="deletgalary">Delete Document
							<i class="fa fa-eye-slash icons"> </i>
				</button>


                        
                      </div>
                    </div>
                  </a>

                </div>
              </div>
              </div>
	</form>
</div>
