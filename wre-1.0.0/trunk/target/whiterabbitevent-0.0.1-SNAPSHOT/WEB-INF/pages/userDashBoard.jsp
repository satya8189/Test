<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="firstName" value="${user.firstName}" scope="session" />
<c:set var="lastName" value="${user.lastName}" scope="session" />
<head>
<title>DashBoard</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script src="http://code.angularjs.org/1.2.13/angular.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular-route.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular-animate.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/practiceStyles.css" />

<script src="resources/js/angular/angular.js"></script>
<script src="resources/js/navigationjs/practiceAdminNavigation.js"></script>
<style>
        .centered {
    text-align: center;
}
.centered > div {
    float: none;
    display: inline-block;
 
}
</style>
</head>
<body>

	<!-- Header Starts-->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img
					src="${pageContext.request.contextPath}/resources/images/logo.png"
					class="img-responsive" />

				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-right" 
				id="bs-example-navbar-collapse-1">
				<ul>
					<li>
						<table>
							<tr>
								<td style="padding-top: 8px;"><c:if
										test="${user.logoPath !=null}">
										<img src="${user.logoPath}" width="40" height="40"
											class="logout-img" />
									</c:if> <c:if test="${user.logoPath ==null}">
										<img
											src="${pageContext.request.contextPath}/resources/images/logo.png"
											width="40" height="40" class="logout-img" />
									</c:if></td>
								<td class="wrap" style="padding-top: 8px;text-transform: capitalize;"><span>${firstName}
										${lastName}</span> <br /> <span> <a class="logout-link"
										href="/careduo/logout"> Logout </a>
								</span></td>
							</tr>
						</table>
					</li>

				</ul>



			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="container">
		<div class="panel-body text-center">
			<div class="row centered">
				<c:forEach items="${practiceAdminDetails}" var="user" >
					<c:if test='${user.userRole eq "Practice Admin"}'>

						<div class="col-md-3" style="padding-top: 10px">
							<div class="padashboard">
								<div class="form-group">
									<b class="f18" style="text-transform: capitalize;">${user.practiceName}</b><br />
								</div>
								<div class="form-group">
									<font class="f12" style="text-transform: capitalize;">${user.firstName} ,${user.speciality}</font><br />
								</div>
								<span class="font-size-18">Access Careduo as</span><br />
								<div class="form-group">
									<a
										href="/careduo/cd/practiceadmin/dashbord?practiceId=${user.practiceId}&roleId=${user.roleId}"
										class="btn btn-default button save margintop20 dangerb">
										${user.userRole} </a>
								</div>
							</div>
							<div class="bottom"></div>
						</div>
					

					</c:if>
				</c:forEach>
			</div>


			<div class="row centered" style="margin-top: 4%;">
				<c:forEach items="${practiceAdminDetails}" var="user">
					<c:if
						test='${user.userRole eq "Office Manager" || user.userRole eq "General Dentist" || user.userRole eq "Special Dentist"}'>

						<div class="col-md-3" style="padding-top: 10px">
							<div class="padashboard1">
								<div class="form-group">
									<b class="f18" style="text-transform: capitalize;">${user.practiceName}</b><br />
								</div>
								<div class="form-group">
									<font class="f12"  style="text-transform: capitalize;">${user.firstName} ,${user.speciality}</font><br />
								</div>
								<span class="font-size-18">Access Careduo as</span><br />

								<div class="form-group">
									<c:if test='${user.userRole eq "Office Manager"}'>
										<a href="#"
											class="btn btn-default button save margintop20 ombutton">
											${user.userRole} </a>
									</c:if>
									<c:if test='${user.userRole eq "General Dentist"}'>
										<a href="#"
											class="btn btn-default button save margintop20 gdbutton">
											${user.userRole} </a>
									</c:if>
									<c:if test='${user.userRole eq "Special Dentist"}'>
										<a href="#"
											class="btn btn-default button save margintop20 spbutton">
											${user.userRole} </a>
									</c:if>
								</div>

							</div>
							<div class="bottom"></div>
						</div>

					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>