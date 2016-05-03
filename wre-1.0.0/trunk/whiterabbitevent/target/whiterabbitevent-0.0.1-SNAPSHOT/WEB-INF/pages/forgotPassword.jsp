<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>
Login Page
</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"></link>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"></link>
<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"></link>
    <script>
            // When the document is ready
            $(document).ready(function () {
            	 $('#profilecreatesuccess').delay(1000).fadeOut();
                //validation rules
                //by default it will append a <label class="error> element to the invalid input
                //and will add a "error" class to the input
                $("#forgotform").validate({
             	    	
           	    	  rules: {                   
           	    		  userName: {
           	    			  required: true,
           	    			  email:true
           	    		   }
           	    	  },
           	    		 messages: {
           	    			userName :{
         						required : "Please enter email",
         						email :"Please enter valid email"
         					} 
           	    		 },
           	    		   
           	    		     highlight:function(element){
           	    		    	 $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
           	    		    	 
           	    		     },
           	    		     unhighlight:function(element){
           	    		    	 $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
           	    		    	 
           	    		     }
           	    });
            });
        </script>
         <style type="text/css">
         @media (min-width: 992px)
{
.col-md-offset-4 {
    margin-left: 38.333333%;
}}
.error {
  border-color: red;
	  color: red;
}
.form-control {
  color: black !important;
}
.alert-success{
  background-color: rgb(3, 81, 3) !important;
  background-image:none !important;
}
.alert-success:hover{
  background-color: rgb(3, 81, 3) !important;
  background-image:none !important;
  color:rgb(3, 81, 3) !important;
  border:1pxz solid rgb(3, 81, 3) !important;
}
.close {
  float: right;
  font-size: 14px;
  font-weight: normal;
  line-height: 1;
  color: #fff;
  text-shadow: none;
  filter: none;
  opacity: 1;
}
.close:focus, .close:hover{
text-shadow: none;
  filter: none;
  opacity: 1;
}
.alert{
  top: 2em;
  position: relative;
  left: -2em;
  width: auto;
  text-align: center;
}
.icon{
font-size: 30px;
margin-top: 14px;
}
        </style>
</head>
    <body>
	
	    <c:if test="${not empty success}"> 
<div class="alert alert-success  alert-dismissible close" style="margin-left: 61em;" id="profilecreatesuccess">
<button type="button" class="close" onclick="$('.close').hide();" aria-label="Close">
		       		<span aria-hidden="true">&times;</span>
		       	</button>
		       <i class="fa fa-smile-o font-size-25"></i> 
   
${success}
</div>
</c:if> 


	    <c:if test="${not empty error}"> 
			<div class="alert alert-danger alert-dismissible close" role="alert"  id="profilecreatesuccess">
			
		       <button type="button" class="close" onclick="$('.close').hide();" aria-label="Close">
		       		<span aria-hidden="true">&times;</span>
		       	</button>
		       <i class="fa fa-frown-o font-size-25"  style="margin-right:5px !important;"></i> 
		       
		       <span class="position-rel" style="top:-3px"> ${error}</span>
		       
	     </div>
    </c:if>

	 <!-- Login Form -->
	<form action="/careduo/forgotPassword" Class="lofinform" id="forgotform" method="post"> 
  <div class="col-md-3 col-md-offset-4  col-sm-6 col-sm-offset-3 margin-top-13 text-center">
  <img src="${pageContext.request.contextPath}/resources/images/logo.png" class="img-responsive margin-auto form-group"/>
  <h4 class="text-center form-group margin-top-8">Forgot Password </h4>
  
  <div class="form-group margin-top-8 position-rel" >
      <input type="email" class="form-control padding-right-30" id="userName" name="userName"  placeholder="Email Id">
      <span class="glyphicon glyphicon-user color-ccc login-text-img"></span>
    </div>
	
      <div class="form-group margin-top-8">
	<button type="submit"  class="btn btn-default button width-100">Submit</button>
      </div>
	 Click <a href="/careduo">here</a> to goto login page.
  </div>
        </form>
	</body>
	</html>