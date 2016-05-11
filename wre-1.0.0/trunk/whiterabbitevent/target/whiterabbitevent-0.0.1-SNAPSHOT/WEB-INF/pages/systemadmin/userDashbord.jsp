<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="firstName" value="${user.firstName}" scope="session" />
<c:set var="lastName" value="${user.lastName}" scope="session" />
<html lang="en">
<head>
   <title>
careduo
</title>
<script>
$('.nav a').on('click', function(){
    $(".btn-navbar").click(); //bootstrap 2.x
    $(".navbar-toggle").click() //bootstrap 3.x by Richard
})
</script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
  
<script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="resources/css/dataTables.bootstrap.css">
<link rel="stylesheet" href="resources/css/datatableStyle.css">
<script src="resources/js/jquery.dataTables.js"></script>
  <script type="text/javascript" src="http://cdn.amcharts.com/lib/3/amcharts.js"></script>
	<script type="text/javascript" src="http://cdn.amcharts.com/lib/3/pie.js"></script>
	<script type="text/javascript" src="http://cdn.amcharts.com/lib/3/themes/chalk.js"></script>
	
	<!-- file upload -->
	<script type="text/javascript" src="resources/js/ng-file-upload.js"></script>
	<script type="text/javascript" src="resources/js/ng-file-upload-shim.js"></script>
	<!-- toaster required files -->
  <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
	
	<script type="text/javascript" src="resources/js/multiselect/select2.js"></script>
	<script type="text/javascript"  src="resources/js/multiselect/select2.min.js"></script>
	 <link rel="stylesheet" href="resources/js/multiselect/select2.min.css">

	<!-- used for pie chart start-->
  <script type="text/javascript" src="http://www.google.com/jsapi"></script>
  
  <!-- used for pie chart end-->
  	<script src="resources/js/angular/angular.js"></script>
		<script src="resources/js/angular/angular.min.js"></script>
		<script src="resources/js/angular/angular-route.js"></script>
		<script src="resources/js/angular/angular-route.min.js"></script>
		<script src="resources/js/angular/angular-messages.js"></script>
		<script src="resources/js/angular/angular-messages.min.js"></script>
		 <script src="https://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="resources/js/navigationjs/systemAdminNavigation.js"></script>
<script src="resources/js/services.js"></script>

<!-- System Admin -->
<script src="resources/js/systemadmin/SysAdminHomeController.js"></script>
<script src="resources/js/systemadmin/SubAdminCreateController.js"></script>
<script src="resources/js/systemadmin/SubAdminEditController.js"></script>
<script src="resources/js/systemadmin/subAdminViewDetailsController.js"></script>
<script src="resources/js/systemadmin/systemAdminUploadLogoController.js"></script>
<script src="resources/js/systemadmin/SystemAdminSettingsController.js"></script>
<script src="resources/js/amcharts.js"></script>
 
<!-- Organization -->
<script src="resources/js/systemadmin/OrgViewController.js"></script>
<script src="resources/js/systemadmin/OrgCreateController.js"></script>
<script src="resources/js/systemadmin/OrgEditController.js"></script>
<script src="resources/js/systemadmin/OrgViewDetails.js"></script>
<script src="resources/js/systemadmin/StudentViewController.js"></script>


<!-- Payment -->
<script src="resources/js/systemadmin/PaymentViewController.js"></script>

<!-- practice -->
<script src="resources/js/systemadmin/PracticeViewController.js"></script>
<script src="resources/js/systemadmin/PracticeEditController.js"></script>
<script src="resources/js/systemadmin/PracticeCreateController.js"></script>
<script src="resources/js/systemadmin/InsuranceViewController.js"></script>
<script src="resources/js/systemadmin/AcceptedInsuranceViewController.js"></script>
<script src="resources/js/systemadmin/ServiceProvidedViewController.js"></script>
<script src="resources/js/systemadmin/PracticeViewDetailsController.js"></script>
<script src="resources/js/systemadmin/PracticeLookupViewController.js"></script>
<script src="resources/js/systemadmin/PracticeLookupFullviewController.js"></script>
<script src="resources/js/systemadmin/PracticeImageUploadController.js"></script>
<script src="resources/js/systemadmin/OrgPracticeViewController.js"></script>
<!-- Insurance -->
<script src="resources/js/systemadmin/InsurancePlansController.js"></script>
<script src="resources/js/systemadmin/InsurancePlansViewController.js"></script>
<script src="resources/js/systemadmin/InsurancePlansEditController.js"></script>
<script src="resources/js/systemadmin/InsuranceCreateController.js"></script>
<script src="resources/js/systemadmin/InsuranceEditController.js"></script>
<script src="resources/js/systemadmin/InsurancePlansCreateController.js"></script>

 
 <!-- Request -->
 <script src="resources/js/systemadmin/PracticeRequestController.js"></script>
 <script src="resources/js/systemadmin/OrgRequestViewController.js"></script>
  <script src="resources/js/systemadmin/UserRequestController.js"></script>
  <script src="resources/js/systemadmin/ApproveUserRequestController.js"></script>
  <script src="resources/js/systemadmin/RequestDetailsViewController.js"></script>
 
 <!-- Dashboard -->
 <script src="resources/js/systemadmin/DentistsViewController.js"></script>
 
  <script src="resources/js/systemadmin/RequetUploadsController.js"></script>
 
 <script src="resources/js/filters.js"></script>
 <script src="resources/js/directives.js"></script>
  <script src="resources/js/download.service.js"></script>
  
   <script src="resources/js/angular/angular-idle.js"></script>
    <script src="resources/js/angular/angular-idle.min.js"></script>
 
		<script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.10.0.js" type="text/javascript"></script>
<script type="text/javascript"> 

function stopRKey(evt) { 
  var evt = (evt) ? evt : ((event) ? event : null); 
  var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null); 
  if ((evt.keyCode == 13) && (node.type=="text"))  {return false;} 
} 

document.onkeypress = stopRKey; 

</script>
		
  <style>
       #map-canvas {
         height: 400px;
  margin: 0px;
  padding: 0px;
  width: 400px;
      }
    </style>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>
    
 

  
</head>

  <body >
 
     <!-- Header Starts-->   
    <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
       <a class="navbar-brand" href="#">
        <img src="${pageContext.request.contextPath}/resources/images/logo.png" class="img-responsive"/>
     
        </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
   
      
        <ul class="nav navbar-nav navbar-right header-hide">
        <!-- <li><a class="navbar-links" href="sysadmin/claimView">Claim View</a></li> -->
        <li><a class="navbar-links" href="#/dashBoard" id="dashboard">Dashboard</a></li>
        <li><a class="navbar-links" href="#/orgView" id="organization">Organization</a></li>
        <li><a class="navbar-links" href="#/practiceView" id="practice">Practices</a></li>
        <li><a class="navbar-links" href="#/organisationRequestView" id="requests">Requests</a></li>
        <li><a class="navbar-links" href="#/insuranceView" id="insurances">Insurances</a></li>
        <li><a class="navbar-links" href="#/paymentView" id="payments">Payments</a></li>
         <li><a class="navbar-links" href="#/studentView" id="payments">Students</a></li>
        <li><a class="navbar-links" href="#">
            <span class="glyphicon glyphicon-bell" />
            </a></li>
        <li><a class="navbar-links" href="#/settings" id="settings">
           <span class="glyphicon glyphicon-wrench" />
            </a></li>
          <li >
          <table><tr><td style="  padding-top: 8px;">
          <c:if test="${user.logoPath !=null}">
          <img src="${user.logoPath}" width="40" height="40" class="logout-img"/>
          </c:if>
          <c:if test="${user.logoPath ==null}">
          <img src="${pageContext.request.contextPath}/resources/images/user_icon.png" width="40" height="40" class="logout-img"/>
          </c:if></td>
          <td class=" wrap" style="  padding-top: 8px;">
          
            <span class="text-capitalize" >${firstName} ${lastName}</span>
              <br/> 	
            <span>
            <a class="logout-link" href="/careduo/logout">
            Logout
            </a>
            </span>
          </td></tr></table>
          </li>
  
      </ul>
      
      
      
      <!--Duplicate header  -->
        <ul class="nav navbar-nav navbar-right hide-nav">
        <!-- <li><a class="navbar-links" href="sysadmin/claimView">Claim View</a></li> -->
        <li><a class="navbar-links" data-toggle="collapse" data-target=".navbar-collapse" href="#/dashBoard" id="dashboard">Dashboard</a></li>
        <li><a class="navbar-links" data-toggle="collapse" data-target=".navbar-collapse"  href="#/orgView" id="organization">Organization</a></li>
        <li><a class="navbar-links" data-toggle="collapse" data-target=".navbar-collapse" href="#/practiceView" id="practice">Practices</a></li>
        <li><a class="navbar-links" data-toggle="collapse" data-target=".navbar-collapse" href="#/organisationRequestView" id="requests">Requests</a></li>
        <li><a class="navbar-links" data-toggle="collapse" data-target=".navbar-collapse" href="#/insuranceView" id="insurances">Insurances</a></li>
        <li><a class="navbar-links" data-toggle="collapse" data-target=".navbar-collapse" href="#/paymentView" id="payments">Payments</a></li>
            <li><a class="navbar-links" data-toggle="collapse" data-target=".navbar-collapse" href="#/studentView" id="payments">Students</a></li>
        <li><a class="navbar-links" data-toggle="collapse" data-target=".navbar-collapse" href="#">
            <span class="glyphicon glyphicon-bell" />
            </a></li>
        <li><a class="navbar-links" data-toggle="collapse" data-target=".navbar-collapse" href="#/settings" id="settings">
           <span class="glyphicon glyphicon-wrench" />
            </a></li>
          <li >
          <table><tr><td style="  padding-top: 8px;">
          <c:if test="${user.logoPath !=null}">
          <img src="${user.logoPath}" width="40" height="40" class="logout-img"/>
          </c:if>
          <c:if test="${user.logoPath ==null}">
          <img src="${pageContext.request.contextPath}/resources/images/user_icon.png" width="40" height="40" class="logout-img"/>
          </c:if></td>
          <td class=" wrap" style="  padding-top: 8px;">
          
            <span class="text-capitalize" >${firstName} ${lastName}</span>
              <br/> 	
            <span>
            <a class="logout-link" href="/careduo/logout">
            Logout
            </a>
            </span>
          </td></tr></table>
          </li>
  
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

    <!--Header ends-->
         <ng-view></ng-view>
         
    </body>
	




</html>




