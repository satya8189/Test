<!DOCTYPE html>
<html lang="en" ng-app="whiterabbitevent">
<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="firstName" value="${USER.firstName}" scope="session" />
<c:set var="lastName" value="${USER.lastName}" scope="session" />
<c:set var="userId" value="${USER.userId}" scope="session" />
  <title>WHITE RABBIT EVENT</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <!-- For Pagination -->
  	
  	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.9/angular.min.js" type="text/javascript"></script>  
    <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.10.0.js" type="text/javascript"></script> 
	<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />  
		
	
	
  <!-- Pagination Links end -->
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script> 
 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">    
   <!-- <link rel="stylesheet" href="resources/css/bootstrap.min.css"> --> 
	<!-- <script src="resources/js/bootstrap.min.js"></script>-->
    
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        
	<!--     //ngNotifier -->
   <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
   <link rel="stylesheet" href="resources/css/style.css"/>
    
    	<script src="resources/js/angular/angular.js"></script> 
	 <!-- <script src="resources/js/angular/angular.min.js"></script> --> 
		<script src="resources/js/angular/angular-route.js"></script>
		<script src="resources/js/angular/angular-route.min.js"></script>
		<script src="resources/js/angular/angular-messages.js"></script>
		<script src="resources/js/angular/angular-messages.min.js"></script>
     	<script src="resources/js/navigationjs/adminNavigation.js"></script>
		<script src="resources/js/services.js"></script>
<!-- event -->
    <script src="resources/js/admin/EventViewController.js"></script>
    <script src="resources/js/admin/EventCreateController.js"></script>
    <script src="resources/js/admin/EventEditController.js"></script>
    <script src="resources/js/admin/EventViewDetailsController.js"></script>
    <script src="resources/js/admin/AgendoViewController.js"></script>
    <script src="resources/js/admin/AgendoCreateController.js"></script>
    <script src="resources/js/admin/AgendoEditController.js"></script>
    <script src="resources/js/admin/NewsFeedViewController.js"></script>
    <script src="resources/js/admin/NewsFeedEditController.js"></script>
    <script src="resources/js/admin/NewsFeedCreateController.js"></script>
    <script src="resources/js/admin/GalleryViewController.js"></script>
    <script src="resources/js/admin/DetailsViewController.js"></script>
    <script src="resources/js/admin/EditDetailsViewController.js"></script>
    <script src="resources/js/admin/GalleryCreateController.js"></script>
    <script src="resources/js/admin/InviteController.js"></script>
    <script src="resources/js/admin/InviteListController.js"></script>
    <script src="resources/js/admin/QuestionViewController.js"></script>
    
    <script src="resources/js/admin/DocumentViewController.js"></script>
    <script src="resources/js/admin/VideoViewController.js"></script>
    <script src="resources/js/admin/VideoUploadController.js"></script>
    <script src="resources/js/admin/DocumentCreateController.js"></script>
    <script src="resources/js/admin/QuestionCreateController.js"></script>
    <script src="resources/js/admin/QuestionEditController.js"></script>
    <script src="resources/js/admin/QuestionAndAnswersViewController.js"></script>
	<script src="resources/js/admin/ViewParticipantAnswersController.js"></script>    
	    
    <!-- file upload -->
	<script type="text/javascript" src="resources/js/ng-file-upload.js"></script>
	<script type="text/javascript" src="resources/js/ng-file-upload-shim.js"></script>
    
    <!-- Sponsor Page -->
    <script type="text/javascript" src="resources/js/admin/SponsorPageViewController.js"></script>
    <script type="text/javascript" src="resources/js/admin/SponsorCreateController.js"></script>
    <script type="text/javascript" src="resources/js/admin/SponsorEditController.js"></script>
    
    <!-- Speaker scripts -->
    <script type="text/javascript" src="resources/js/admin/SpeakerProfileViewController.js"></script>
    <script type="text/javascript" src="resources/js/admin/SpeakerCreateController.js"></script>
	<script type="text/javascript" src="resources/js/admin/SpeakerEditController.js"></script>
    
    <!-- VenueLayout -->
     <script type="text/javascript" src="resources/js/admin/VenueLayoutController.js"></script>
     
     <!--HELP- Contact -->
     <!-- Help-ContactView -->
    <script src="resources/js/admin/ContactDetailsViewController.js"></script>
     <!-- EditContactDetailsController -->
     <script src="resources/js/admin/EditContactDetailsController.js"></script>
	
	
	 <script type="text/javascript" src="resources/js/admin/ChatTopicListViewController.js"></script>
	<script type="text/javascript" src="resources/js/admin/ChatTopicCreateController.js"></script>
	<script type="text/javascript" src="resources/js/admin/ChatTopicViewDetailsController.js"></script>
     
	<!-- Social Media -->
	<script type="text/javascript" src="resources/js/admin/CreateSocialMediaController.js"></script>
	<script type="text/javascript" src="resources/js/admin/SocialMediaController.js"></script>
	<script type="text/javascript" src="resources/js/admin/EditSocialMediaController.js"></script>
	<script type="text/javascript" src="resources/js/admin/UpdateSocialMediaController.js"></script>
	
    
     <script type="text/javascript" src="resources/js/admin/NetworkingEditController.js"></script>
       <script type="text/javascript" src="resources/js/admin/NetworkingViewController.js"></script>
</head>
<body>
        <!--Heading-->
        <nav class="navbar navbar-default">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
        
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <ul class="nav navbar-nav">
        <li class="head-date"><i class="fa fa-calendar" aria-hidden="true"></i> &nbsp;&nbsp;White Rabbit Events</li>
    
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
       <li class="head-date"> <i class="glyphicon glyphicon-search"></i></li>
           <li class="head-date"> <i class="glyphicon glyphicon-bell"></i></li>
           <li class="head-date"> <i class="glyphicon glyphicon-user"></i></li>
          </ul>
        
      
    </div><!-- /.navbar-collapse -->
</nav>
        <!--Heading Ends-->
        
        <div class="panel head">
      
            
        <div class="panel-body">
            
          <div class="col-md-2 padd-0 menu-bg">
              <ul class="ul">
                  <div class="name">
                <img src="${pageContext.request.contextPath}/resources/images/attractmen.org-libra-men.jpg" width="70px" height="70px" style="border-radius: 50%;">
                      <span style="margin-left: 30px;color: white;">Naveen</span>
                      </div>
                  
                </ul>
            <ul class="ul ">
              <li class="li">Invite</li>
              <li class="li" ><a class="navbar-links" href="#/eventView/${userId}" id="event">Event</a></li>
              <li class="li">Polling</li>
              <li class="li">Schedule</li>
              <li class="li">News Feed</li>
              <li class="li">Document</li>
            	 <li class="li">Gallery</li>
                 <li class="li">Crowd Pics</li>
                 <li class="li">Videos</li>
                 <li class="li">Q&A</li>
                 <li class="li">SUR</li>
              </ul>
            </div>
          <div class="col-md-10">
           <div class="body-content">
             <h3 style="text-align: -webkit-center;"> Invite people toEvents</h3>
       
 			 <ng-view></ng-view>
         </div>
              </div>
            </div>
            </div>
    
</body>
</html>
