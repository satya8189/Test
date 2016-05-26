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
</style>

</head>
<body>
<div class="container-fluid">
<div class="row">
<div ng-repeat=" event in eventList">

						<div class="col-md-3" style="padding-top: 10px"><a ng-click="serviceDetails(event)">
							<div class="padashboard">
					<i class="fa fa-calendar" aria-hidden="true"></i>
									<h4 class="f18" style="text-transform: capitalize;">{{event.serviceName}}</h4>
							
								
                             </div>
							</div>
							<div class="bottom"></div>
							
						</div>
				</div>		
						
					

</div>
</body>
</html>