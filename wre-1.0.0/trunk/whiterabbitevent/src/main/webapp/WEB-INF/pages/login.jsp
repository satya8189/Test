<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script>
history.pushState({ page: 1 }, "title 1", "#nbb");
window.onhashchange = function (event) {
window.location.hash = "nbb";
};
</script>
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet"></link>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"></link>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"></link>
<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery.validate.min.js"></script>
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"></link>
<script>
  $( document ).ready(function() {
	    $(".clientform").validate({
	    	  rules: {                   
	    		  userEmail: {
	    			  required: true,
	    			  email:true
	    		   },  
	    		   userPassword:{
	    			   required:true,
	    			   minlength:5,
	    			   maxlength:15
	    		   },
	    		   
	    		     highlight:function(element){
	    		    	 $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	    		    	 
	    		     },
	    		     unhighlight:function(element){
	    		    	 $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
	    		    	 
	    		     }
	    	  }
	    });
	});
</script>
<style>
@media (min-width: 1200px){
.container {
width: 350px !important;
}}

 .form-control::-webkit-input-placeholder { color: #ccc; }
 .panel {
 border-radius: 27px !important;
  margin-top: 50%;
  box-shadow: none !important;
  border: 1px solid #fff !important;
  width: 142%;
  margin-left: -52px;
}
.form-control {
  box-shadow: none !important;
  border-radius: 0px !important;
  width: 90% !important;
  margin-left: 21px;
}
label.error
{
margin-left: 24px;

}
</style>
</head>
<body  style="background:#181818 !important;  overflow: hidden;">

<div class="container">
<div class="panel">
<div class="h3 text-center" style="margin-top: 5%;padding-bottom: 16px;">Login</div>
    <%-- <c:if test="${not empty error}"> --%>
    <c:if test="${error ne '' && error ne null}">
		<div class="alert alert-danger">
   			<a href="#" class="close" data-dismiss="alert" aria-label="Close">
      		&times;${error}
   			</a>
		</div>
	</c:if>
<form:form  action="/whiterabbitevent/loginAuthentication" method="post" commandName="userBean" cssClass="clientform">
<div class="form-group">
  <form:input path="email"  placeholder="User Name" class="form-control " title="Please  enter your email"/>
</div>
<div class="form-group">
  <form:password path="password" class="form-control"  placeholder="Password" title="Please  enter your Password"/>
<a href="/wwec/admin/forgotPassword" class="pull-right" style="  margin-right: 25px">Forgot Password</a>
</div><br/>
<div class="form-group text-center">
<input type="submit" value="Login" class="btn btn-success" />
</div>
</form:form>
</div>
</div>
</body>
</html>