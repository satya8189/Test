
<script type="text/ng-template" id="errors">
    <div ng-message="required" style="color:red;">This field is required </div>
	<div ng-message="pattern" style="color:red;"> Enter valid input </div>
    <div ng-message="minlength" style="color:red;">Enter minimum {{minlength}} characters </div>
	<div ng-message="email" style="color:red;">Enter valid email</div>
	<div ng-message="maxlength" style="color:red;">Maximum length exceeded.</div>
</script>