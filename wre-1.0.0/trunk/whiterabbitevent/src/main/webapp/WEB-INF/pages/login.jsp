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
body
{
    background:#1a3048;
    background-size: cover;
    padding: 0;
    margin: 0;
}

.wrap
{
    width: 100%;
    height: 100%;
    min-height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    z-index: 99;
    top: 150px;
}

p.form-title
{
    font-family: 'Open Sans' , sans-serif;
    font-size: 30px;
    font-weight: 600;
    text-align: center;
    color: #FFFFFF;
    margin-top: 5%;
    text-transform: uppercase;
    letter-spacing: 4px;
}

form
{
    width: 250px;
    margin: 0 auto;
}

form.login input
{
    width: 100%;
    margin: 0;
    padding: 5px 10px;
    background: 0;
    border: 0;
    border-bottom: 1px solid #FFFFFF;
    outline: 0;
    font-style: italic;
    font-size: 12px;
    font-weight: 400;
    letter-spacing: 1px;
    margin-bottom: 5px;
    color: #FFFFFF;
    outline: 0;
}

form.login input[type="submit"]
{
    width: 100%;
    font-size: 14px;
    text-transform: uppercase;
    font-weight: 500;
    margin-top: 16px;
    outline: 0;
    cursor: pointer;
    letter-spacing: 1px;
}

form.login input[type="submit"]:hover
{
    transition: background-color 0.5s ease;
}

form.login .remember-forgot
{
    float: left;
    width: 100%;
    margin: 10px 0 0 0;
}
form.login .forgot-pass-content
{
    min-height: 20px;
    margin-top: 10px;
    margin-bottom: 10px; 
}
form.login label, form.login a
{
    font-size: 12px;
    font-weight: 400;
    color: #FFFFFF;
}

form.login a
{
    transition: color 0.5s ease;
}

form.login a:hover
{
    color: #2ecc71;
}

.pr-wrap
{
    width: 100%;
    height: 100%;
    min-height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    z-index: 999;
    display: none;
}

.show-pass-reset
{
    display: block !important;
}

.pass-reset
{
    margin: 0 auto;
    width: 250px;
    position: relative;
    margin-top: 22%;
    z-index: 999;
    background: #FFFFFF;
    padding: 20px 15px;
}

.pass-reset label
{
    font-size: 12px;
    font-weight: 400;
    margin-bottom: 15px;
}

.pass-reset
{
    width: 100%;
    margin: 5px 0 0 0;
    padding: 5px 10px;
    background: 0;
    border: 0;
    border-bottom: 1px solid #FFFFFF;
    outline: 0;
    font-style: italic;
    font-size: 12px;
    font-weight: 400;
    letter-spacing: 1px;
    margin-bottom: 5px;
    color: #fff;
    outline: 0;
}
.buttonbg{
background-color:#0098CD;
}
.button
{
color:#fff;
background-color:#0098CD;
    width: 100%;
    border: 0;
    font-size: 14px;
    text-transform: uppercase;
    font-weight: 500;
    margin-top: 10px;
    outline: 0;
    cursor: pointer;
    letter-spacing: 1px;
}

.button:hover
{
    transition: background-color 0.5s ease;
}
.posted-by
{
    position: absolute;
    bottom: 26px;
    margin: 0 auto;
    color: #FFF;
    background-color: rgba(0, 0, 0, 0.66);
    padding: 10px;
    left: 45%;
}
.forgot-pass{
color:#fff;
}
.forgot-pass:hover{
color:#fff;
}
</style>
<script>
$(document).ready(function () {
    $('.forgot-pass').click(function(event) {
      $(".pr-wrap").toggleClass("show-pass-reset");
    }); 
    
    $('.pass-reset-submit').click(function(event) {
      $(".pr-wrap").removeClass("show-pass-reset");
    }); 
});
</script>
<!-- <style>
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
</style> -->
</head>
<!--<body  style="background:#181818 !important;  overflow: hidden;">

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
</div> -->
<div class="container">
    <c:if test="${not empty error}">
<div class="alert alert-danger">
   <a href="#" class="close" data-dismiss="alert" aria-label="Close">
      &times;
   </a>
${error}
</div>
</c:if>
    <div class="row">
        <div class="col-md-12">
           
            <div class="wrap">
                <p class="form-title">
                    Login</p>
                    
                <form:form  action="/whiterabbitevent/loginAuthentication" method="post" commandName="userBean" cssClass="clientform" class="login">
                <form:input path="email" class="pass-reset" placeholder="User Name" title="Please  enter your email"/>
                <form:password path="password"  class="pass-reset" placeholder="Password" title="Please  enter your Password"/>
                <input type="submit" value=" Login" class="btn  btn-sm button buttonbg" />
                <div class="remember-forgot">
                    <div class="row">
                       
                        <div class="col-md-6 col-md-offset-6 forgot-pass-content">
                            <a href="javascript:void(0)" class="forgot-pass">Forgot Password</a>
                        </div>
                    </div>
                </div>
                </form:form>
            </div>
        </div>
    </div>
   
</div>


</body>
</html>