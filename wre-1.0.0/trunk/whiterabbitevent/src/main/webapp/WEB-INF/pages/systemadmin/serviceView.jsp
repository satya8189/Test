<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.2/css/font-awesome.min.css">
<style>

.padashboard{
padding:20px;
text-align:center;
background: #fff;
box-shadow: 0 2px 4px 0 rgba(0,0,0,0.16),0 2px 10px 0 rgba(0,0,0,0.12)!important;
}
.padashboard .fa{
font-size:30px;
}
.padashboard h4{
font-size:20px;
 margin: 0px;
padding: 10px 0px 0px;
}
img{
height: 58px;
width: 58px;
}
</style>

</head>
<body>

<div class="row">
	<div ng-repeat=" service in serviceList">
						<div class="col-md-3 col-sm-6 col-xs-12" style="padding-top: 10px">
						<a ng-click="serviceDetails(service)">
							<div class="padashboard">
								<img src="resources/images/agenda.png" ng-if="service.serviceName=='Agenda'"/>
								<img src="resources/images/details.png" ng-if="service.serviceName=='Details'"/>
								<img src="resources/images/gallery.png" ng-if="service.serviceName=='Gallery'"/>
								<img src="resources/images/invite.png" ng-if="service.serviceName=='Invite'"/>
								<img src="resources/images/layout.png" ng-if="service.serviceName=='Venue layout'"/>
								<img src="resources/images/messageboard.png" ng-if="service.serviceName=='Message Board'"/>
								<img src="resources/images/network.png" ng-if="service.serviceName=='Networking'"/>
								<img src="resources/images/newsfeed.png" ng-if="service.serviceName=='NewsFeed'"/>
								<img src="resources/images/Q&A.png" ng-if="service.serviceName=='Q&A'"/>
								<img src="resources/images/QR.png" ng-if="service.serviceName=='QR Code'"/>
								<img src="resources/images/social.png" ng-if="service.serviceName=='Social Media'"/>
								<img src="resources/images/documentsharing.png" ng-if="service.serviceName=='Document'"/>
								<img src="resources/images/speaker.png" ng-if="service.serviceName=='Speaker profile'"/>
								<img src="resources/images/sponcers.png" ng-if="service.serviceName=='Sponsor page'"/>
								<img src="resources/images/surveys.png" ng-if="service.serviceName=='Surveys'"/>
								<img src="resources/images/network.png" ng-if="service.serviceName=='Chat'"/>
								<img src="resources/images/Q&A.png" ng-if="service.serviceName=='Help'"/>
								<img src="resources/images/video.png" ng-if="service.serviceName=='Videos'"/>
								<img src="resources/images/video.png" ng-if="service.serviceName=='EventImage'"/>
								
								 <h4 class="f18" style="text-transform: capitalize;">{{service.serviceName}}</h4> 
							 </div>
							</div>
							<div class="bottom"></div>
	</div>
</div>		
</body>
</html>