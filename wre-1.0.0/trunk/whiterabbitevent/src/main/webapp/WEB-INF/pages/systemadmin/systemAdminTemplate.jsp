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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">    
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
  <link rel="stylesheet" href="resources/css/style.css"/>
  
  <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
  <script src="resources/js/angular/angular.js"></script>
  <script src="resources/js/angular/angular.min.js"></script> 
  <script src="resources/js/angular/angular-route.js"></script>
  <script src="resources/js/angular/angular-route.min.js"></script>
  <script src="resources/js/angular/angular-messages.js"></script>
  <script src="resources/js/angular/angular-messages.min.js"></script>
  <script src="resources/js/ui-bootstrap-angularjs.js"></script> 
   
     <script src="resources/js/navigationjs/systemAdminNavigation.js"></script>
     <script src="resources/js/services.js"></script>
      <script src="resources/js/filters.js"></script>
 
     
    <!-- Client -->
    <script src="resources/js/systemadmin/ClientsViewController.js"></script>
    <script src="resources/js/systemadmin/ClientCreateController.js"></script>
    <script src="resources/js/systemadmin/ClientEventViewController.js"></script>
     <script src="resources/js/systemadmin/ClientEventCreateController.js"></script>
     <script src="resources/js/systemadmin/ClientEventEditController.js"></script>
     
      
  	<script type="text/javascript" src="resources/js/multiselect/select2.js"></script>
	<script type="text/javascript"  src="resources/js/multiselect/select2.min.js"></script>
	 <link rel="stylesheet" href="resources/js/multiselect/select2.min.css">
 
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
       <li class="head-date"> <span class="glyphicon glyphicon-search"></span></li>
           <li class="head-date"> <span class="glyphicon glyphicon-bell"></span></li>
           <li class="head-date"> <span class="glyphicon glyphicon-user"></span></li>
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
                      <span style="margin-left: 30px;">Naveen</span>
                      </div>
                  
                </ul>
            <ul class="ul ">
              <li class="li">Invite</li>
              <li class="li" ><a class="navbar-links" href="#/clientsView" id="client">Clients</a></li>
              <li class="li">Polling</li>
              <li class="li">Schedule</li>
              <li class="li">News Feed</li>
              <li class="li">Document Sharing</li>
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
        
    
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
</body>
</html>
