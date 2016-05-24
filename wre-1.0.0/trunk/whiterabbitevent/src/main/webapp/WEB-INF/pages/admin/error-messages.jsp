<script type="text/ng-template" id="errors">
    <div ng-message="required">This field is required </div>
	<div ng-message="pattern"> Enter valid input </div>
    <div ng-message="minlength">Enter minimum {{minlength}} characters </div>
	<div ng-message="email">Enter valid email</div>
	<div ng-message="maxlength">Maximum length exceeded.</div>
</script>