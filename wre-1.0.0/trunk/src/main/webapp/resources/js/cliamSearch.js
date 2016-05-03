$(document).ready(function() {
					//$('.practicesuccess').delay(1000).fadeOut();
					
					var latitudeAndLongitude = document
							.getElementById("latitudeAndLongitude"), location = {
						latitude : '',
						longitude : ''
					};

					if (navigator.geolocation) {
						navigator.geolocation.getCurrentPosition(showPosition);
					} else {
						latitudeAndLongitude.innerHTML = "Geolocation is not supported by this browser.";
					}

					function showPosition(position) {
						location.latitude = position.coords.latitude;
						location.longitude = position.coords.longitude;

						var geocoder = new google.maps.Geocoder();
						var latLng = new google.maps.LatLng(location.latitude,
								location.longitude);

						if (geocoder) {
							geocoder
									.geocode(
											{
												'latLng' : latLng
											},
											function(results, status) {
												if (status == google.maps.GeocoderStatus.OK) {
													// console.log(results[0].formatted_address);
													// $('#address').html('Address:'+results[0].formatted_address);

													if (results[0]) {
														for (var i = 0; i < results[0].address_components.length; i++) {
															var types = results[0].address_components[i].types;

															for (var typeIdx = 0; typeIdx < types.length; typeIdx++) {
																if (types[typeIdx] == 'postal_code') {
																	$(
																			'.pzipCode')
																			.val(
																					results[0].address_components[i].short_name);
																}
															}
														}
													} else {
														$('.pzipCode')
																.val(
																		results[0].address_components[i].short_name);
													}
												} else {
													$('#address').val(
															'Geocoding failed: '
																	+ status);
													console
															.log("Geocoding failed: "
																	+ status);
												}
											}); // geocoder.geocode()
						}
					} // showPosition

					$("#cliamsearchButton").click(
							function() {
								if ($(".searchName").val() != "") {
									if($(".searchName").val().length<=2){
										$("#profileErrorDiv").attr('style',
										'display:none !important;');
										$("#profileErrorDivlength").attr('style',
										'display:block !important;');
								$("#profileErrorDivlength").attr('style',
										'color:red !important;');
								$(".searchName").addClass("error");
									}else{
									$("#doctorsProfiles").show();
									$("#AdvancedSearchClimProfile").show();
									$("#profileSearchDiv").hide();
									$("#practiceSearchDiv").hide();
									$("#profileSearch").trigger("click");
									}
								} else {
									$("#profileErrorDiv").attr('style',
											'display:block !important;');
									$("#profileErrorDiv").attr('style',
											'color:red !important;');
									$(".searchName").addClass("error");
								}

							});

					$("#practicesearchButton").click(
							function() {
								$("#practiceErrorDiv").attr('style','display:none !important;');
								$("#practiceErrorDivlen").attr('style','display:none !important;');
								if ($(".practiceName").val() != "") {
									if($(".practiceName").val().length<=2){
										$("#practiceErrorDivlen").attr('style',
										'display:block !important;');
										$("#practiceErrorDivlen").attr('style',
										'color:red !important;');
										$(".practiceName").addClass("error");
									}else{
									$("#profileSearchDiv").hide();
									$("#AdvancedSearchClimPractice").show();
									$("#practiceProfiles").show();
									$("#practiceSearchDiv").hide();
									$(".practiceName").removeClass("error");
									$("#practiceSearch").trigger("click");
									}
								} else {
									$("#practiceErrorDiv").attr('style',
											'display:block !important;');
									$("#practiceErrorDiv").attr('style',
											'color:red !important;');
									$(".practiceName").addClass("error");
								}
							});
					
					$(".pcliamSearch")
					.click(
							function() {
								var pzipCode = $(".pzipCode").val();
								var searchName = $(".ssearchName").val();
								var npiNumber = $("#npiNumber").val();
								var zipCode = $(".zipCode").val();
								if(searchName!=""||npiNumber!=""){
									$("#doctorsProfilesSection").empty();
									$("#doctorsProfiles").show();
									$("#AdvancedSearchClimProfile").show();
									$("#profileSearchDiv").hide();
									$("#practiceSearchDiv").hide();
									$("#searchErrorDiv").hide();
								
								$
										.ajax({
											url : "../sysadmin/profilesDetails?opzipCode="+pzipCode+"&name="
													+ searchName
													+ "&npiNumber="
													+ npiNumber+"&zipCode="+zipCode,

											type : "GET",
											success : function(data) {
												if (data.length > 0) {
													$
															.each(
																	data,
																	function(
																			key,
																			value) {
																		var doctorProfileDiv = '<div class="col-md-6">'
																				+ '<input type="hidden"  name="userLookupId" value="'
																				+ value.userLookupId
																				+ '">'
																				+ '<input type="hidden" name="zipCode" value="'
																				+ zipCode
																				+ '">'
																				+ '<div class="row protable" ><div class="col-md-12" style="padding-top: 5px;  height: 50px;"><b><span>Dr.</span>'
																				+value.name
																				+ '</b><font>'
																				+ '</b><br /><span class="fs-10">'
																				+ value.credentialText
																				+ '</span><span>'
																				+ value.authorizedTitle
																				+ '</div><div class="col-md-4">'
																				+ '<span class="fs-10">Phone</span><br /><font>'
																				+ value.phoneNo
																				+ '</font></div><div class="col-md-4">'
																				+ '<span class="fs-10">NPI#</span><br />'
																				+ value.npiNumber
																				+ '</div><div class="col-md-4">'
																				+ '<span class="fs-10">Licence#</span><br />'
																				+ value.licenceNumber
																				+ '</div><div class="col-md-12">'
																				+ '<span class="fs-10">Address</span><br />'
																				+ '<div class="wrap">'
																				+ value.address
																				+ '</div></div>'
																				+ '<div class="col-md-4">'
																				+ '<span class="fs-10">State</span><br />'
																				+ value.stateId
																				+ '</font></div><div class="col-md-4">'
																				+ '<span class="fs-10">City</span><br /><div class="wrap1">'
																				+ value.citiId
																				+ '</div></font></div><div class="col-md-4">'
																				+ '<span class="fs-10">ZIP Code</span><br />'
																				+ value.zipCode
																				+ '</div><div class="col-md-12"><button type="submit" style="  margin-bottom: 10px;" class="probutton pull-right" onclick="cliamProfile('
																				+ ')" style="margin-bottom:20px !important;">Claim</button></div></div></div>';

																		$(
																				"#doctorsProfilesSection")
																				.append(
																						doctorProfileDiv);
																	});
												} else {
													var doctorProfileDiv = '<div class="col-md-12 text-center" style="  height: 37.25em;">'
															+ '<img src="../resources/images/norec.png"></div>';
													$(
															"#doctorsProfilesSection")
															.append(
																	doctorProfileDiv);
												}
											},
											error : function(jqXHR,
													textStatus,
													errorThrown) {
												alert("error:"
														+ textStatus
														+ " exception:"
														+ errorThrown);
											}
										});
								}
								else{
									$("#searchErrorDiv").show();
								}
							});
					
					$(".cliamSearch")
							.click(
									function() {
										$("#doctorsProfilesSection").empty();
										$("#doctorsProfiles").show();
										$("#AdvancedSearchClimProfile").show();
										$("#profileSearchDiv").hide();
										$("#practiceSearchDiv").hide();
										var zipCode = $(".zipCode").val();
										var searchName = $(".searchName").val();
										var npiNumber = $("#npiNumber").val();
										var pzipCode = $(".pzipCode").val();
										$
												.ajax({
													// url:
													// "/careduo/sysadmin/profilesDetails?zipCode="+zipCode+"&name="+searchName+"&npiNumber="+npiNumber,
													url : "../sysadmin/profilesDetails?opzipCode="+pzipCode+"&name="
															+ searchName
															+ "&npiNumber="
															+ npiNumber+"&zipCode="+zipCode,

													type : "GET",
													success : function(data) {
														if (data.length > 0) {
															$
																	.each(
																			data,
																			function(
																					key,
																					value) {
																				var doctorProfileDiv = '<div class="col-md-6">'
																						+ '<input type="hidden"  name="userLookupId" value="'
																						+ value.userLookupId
																						+ '">'
																						+ '<input type="hidden" name="zipCode" value="'
																						+ zipCode
																						+ '">'
																						+ '<div class="row protable" ><div class="col-md-12" style="padding-top: 5px;  height: 70px;"><b><span>Dr.</span>'
																						+value.name
																						+ '</b><font>'
																						+ '</b><br /><span class="fs-10">'
																						+ value.credentialText
																						+ '</span><span>'
																						+ value.authorizedTitle
																						+ '</div><div class="col-md-4">'
																						+ '<span class="fs-10">Phone</span><br /><font>'
																						+ value.phoneNo
																						+ '</font></div><div class="col-md-4">'
																						+ '<span class="fs-10">NPI#</span><br />'
																						+ value.npiNumber
																						+ '</div><div class="col-md-4">'
																						+ '<span class="fs-10">Licence#</span><br />'
																						+ value.licenceNumber
																						+ '</div><div class="col-md-12">'
																						+ '<span class="fs-10">Address</span><br />'
																						+ '<div class="wrap">'
																						+ value.address
																						+ '</div></div>'
																						+ '<div class="col-md-4">'
																						+ '<span class="fs-10">State</span><br />'
																						+ value.stateId
																						+ '</font></div><div class="col-md-4">'
																						+ '<span class="fs-10">City</span><br /><div class="wrap1">'
																						+ value.citiId
																						+ '</div></font></div><div class="col-md-4">'
																						+ '<span class="fs-10">ZIP Code</span><br />'
																						+ value.zipCode
																						+ '</div><div class="col-md-12">'
																						+'<button type="submit" class="probutton pull-right" onclick="cliamProfile('
																						+ value.userLookupId
																						+ ')" style="margin-bottom:20px !important;">Claim</button></div></div></div>';

																				$(
																						"#doctorsProfilesSection")
																						.append(
																								doctorProfileDiv);
																			});
														} else {
															var doctorProfileDiv = '<div class="col-md-12 text-center" style="  height: 28.3em;">'
																	+ '<img src="../resources/images/norec.png"></div>';
															$(
																	"#doctorsProfilesSection")
																	.append(
																			doctorProfileDiv);
														}
													},
													error : function(jqXHR,
															textStatus,
															errorThrown) {
														alert("error:"
																+ textStatus
																+ " exception:"
																+ errorThrown);
													}
												});
									});
$(".ppracticeSearch").click(function(){
	
	var zipCode = $(".zipCode").val();
	var searchName = $("#psearchName").val();
	var npiNumber = $("#pnpiNumber").val();
	var practiceName = $(".ppracticeName").val();
	if(searchName!=""||npiNumber!=""||practiceName!=""){
		$("#searchpracticeErrorDiv").hide();
		$("#practiceProfileSection").empty();
		$("#AdvancedSearchClimPractice").show();
		$("#practiceProfiles").show();
		$("#practiceSearchDiv").hide();
		$("#profileSearchDiv").hide();
	var opzipCode=$(".pzipCode").val();
	$
			.ajax({
				url : "../sysadmin/practicesDetails?opzipCode="+opzipCode+"&name="
						+ searchName
						+ "&npiNumber="
						+ npiNumber
						+ "&practiceName="
						+ practiceName+"&zipCode="+zipCode,
				type : "GET",
				success : function(data) {
					if (data.length > 0) {
						$.each(data,function(key,value) {
							var doctorProfileDiv = '<div class="col-md-6"><div class="row protable" ><div class="col-md-12" style="padding-top: 5px;  height: 70px;"><b>'
									+ '<span class="fs-10">Authorized Name</span><br /><font>'
									+ value.authorizedName
									+ '</b><br /><div class="fs-10">'
									+ value.credentialText
									+ '</div><span style="  font-size: 12px;">'
									+ value.authorizedTitle
									+ '</div><div class="col-md-4">'
									+ '<span class="fs-10">Phone</span><br /><font>'
									+ value.phoneNo
									+ '</font></div><div class="col-md-4">'
									+ '<span class="fs-10">NPI#</span><br />'
									+ value.npiNumber
									+ '</div><div class="col-md-4">'
									+ '<span class="fs-10">Licence#</span><br />'
									+ value.licenceNumber
									+ '</div><div class="col-md-12">'
									+ '<span class="fs-10">Working At</span><br />'
									+ '<div class="wrap">'
									+ value.practiceName
									+ '</div><br><div class="wrap">'
									+ value.address
									+ '</div></div>'
									+ '<div class="col-md-4">'
									+ '<span class="fs-10">State</span><br />'
									+ value.stateId
									+ '</font></div><div class="col-md-4">'
									+ '<span class="fs-10">City</span><br /><div class="wrap1">'
									+ value.citiId
									+ '</div></font></div><div class="col-md-4">'
									+ '<span class="fs-10">ZIP Code</span><br />'
									+ value.zipCode
									+ '</div><div class="col-md-12"><button type="submit" style="  margin-bottom: 10px;" class="probutton pull-right"  onclick="cliamPractice('
									+ value.userLookupId+')" style="margin-bottom:20px !important;">Claim</button></div></div></div>';

								$("#practiceProfileSection").append(doctorProfileDiv);
							});
					} else {
						var doctorProfileDiv = '<div class="col-md-12 text-center" style="  height: 28.3em;">'
								+ '<img src="../resources/images/norec.png"></div>';
						$(
								"#practiceProfileSection")
								.append(
										doctorProfileDiv);
					}
				},
				error : function(jqXHR,textStatus,errorThrown) {
					alert("error:"+ textStatus+ " exception:"+ errorThrown);
				}
			});
	}else{
		$("#searchpracticeErrorDiv").show();
	}
	
});
$(".practiceSearch")
.click(
		function() {
			var zipCode = $(".zipCode").val();
		var searchName = $("#psearchName")
				.val();
		var npiNumber = $("#pnpiNumber").val();
		var practiceName = $(".practiceName")
				.val();
		var opzipCode=$(".pzipCode").val();
		$("#practiceProfileSection").empty();
		$("#AdvancedSearchClimPractice").show();
		$("#practiceProfiles").show();
		$("#practiceSearchDiv").hide();
		$("#profileSearchDiv").hide();
		$
				.ajax({
					url : "../sysadmin/practicesDetails?opzipCode="+opzipCode+"&name="
							+ searchName
							+ "&npiNumber="
							+ npiNumber
							+ "&practiceName="
							+ practiceName+"&zipCode="+zipCode,
					type : "GET",
					success : function(data) {
						if (data.length > 0) {
							$.each(data,function(key,value) {
								var doctorProfileDiv = '<div class="col-md-6"><div class="row protable" ><div class="col-md-12" style="padding-top: 5px;"><b>'
									+ '<span class="fs-10">Authorized Name</span><br /><font>'
									+ value.authorizedName
									+ '</b><br /><span class="fs-10">'
									+ value.credentialText
									+ '</span><span style="  font-size: 12px;">'
									+ value.authorizedTitle
									+ '</div><div class="col-md-4">'
									+ '<span class="fs-10">Phone</span><br /><font>'
									+ value.phoneNo
									+ '</font></div><div class="col-md-4">'
									+ '<span class="fs-10">NPI#</span><br />'
									+ value.npiNumber
									+ '</div><div class="col-md-4">'
									+ '<span class="fs-10">Licence#</span><br />'
									+ value.licenceNumber
									+ '</div><div class="col-md-12">'
									+ '<span class="fs-10">Working At</span><br />'
									+ '<div class="wrap">'
									+ value.practiceName
									+ '</div><br><div class="wrap">'
									+ value.address
									+ '</div></div>'
									+ '<div class="col-md-4">'
									+ '<span class="fs-10">State</span><br />'
									+ value.stateId
									+ '</font></div><div class="col-md-4">'
									+ '<span class="fs-10">City</span><br /><div class="wrap1">'
									+ value.citiId
									+ '</div></font></div><div class="col-md-4">'
									+ '<span class="fs-10">ZIP Code</span><br />'
									+ value.zipCode
									+ '</div><div class="col-md-12"><button type="submit" class="probutton pull-right"  onclick="cliamPractice('
									+ value.userLookupId+')" style="margin-bottom:20px !important;">Claim</button></div></div></div>';

									$("#practiceProfileSection").append(doctorProfileDiv);
								});
						} else {
							var doctorProfileDiv = '<div class="col-md-12 text-center" style="  height: 28.3em;">'
									+ '<img src="../resources/images/norec.png"></div>';
							$(
									"#practiceProfileSection")
									.append(
											doctorProfileDiv);
						}
					},
					error : function(jqXHR,textStatus,errorThrown) {
						alert("error:"+ textStatus+ " exception:"+ errorThrown);
					}
				});
	});

	$("#right").click(function() {
		$('#profileErrorDiv').hide();
		$('#practiceErrorDiv').hide();
		$('.orderLine1').removeClass("error");
		$('.orderLine1').val('');
		$("#profileSearchDiv").show();
		$("#practiceSearchDiv").show();
		$("#AdvancedSearchClimProfile").hide();
		$(".popuppractice_div").hide();
		$(".popupprofile_div").hide();
	});
	
	$("#left").click(function() {
		$('#profileErrorDiv').hide();
		$('#practiceErrorDiv').hide();
		$('.orderLine1').removeClass("error");
		$('.orderLine1').val('');
		$(".popuppractice_div").hide();
		$(".popupprofile_div").hide();
		$("#profileSearchDiv").show();
		$("#practiceSearchDiv").show();
		$("#AdvancedSearchClimPractice").hide();
	});

	$("#cliamForm").validate({
			// Specify the validation rules
		rules : {
			phoneNo : {
				required:true,
				pfoo:true
			},
			userEmail : {
				required : true,
				email : true,
			},

		},

		// Specify the validation error messages
		messages : {
			phoneNo : {
				required : "please enter phone number ",
				pfoo:"Enter valid phone number"
			},
			userEmail : {
				required : "please enter email",
				email : "Please enter a valid email address",
			}
		},

		submitHandler : function(form) {
			var pid=$("#userLookupId").val();
			var puserEmail =$("#userEmail").val();
			var pphoneNo =	$("#phoneNo").val();
			
			$.ajax({
				url : "../sysadmin/claimProfile?userLookupId="+pid+"&userEmail="+puserEmail+"&phoneNo="+pphoneNo,
				type : "POST",
				success : function(data) {
					$("#userEmail").val('');
					$("#userEmail").val('');
					$(".practicesuccess").fadeIn(1000).delay(10000).fadeOut("slow");
					//$(".practicesuccess").show();
					$("#message").html(data);
					$(".popupprofile_div").hide();
				}
			});
			
		}
	});
	

	$("#cliamPracticeForm").validate({

			// Specify the validation rules
		rules : {
			pphoneNo : {
				required : true,
				pfoo:true
			},
			puserEmail : {
				required : true,
				email : true,
			},

		},

		// Specify the validation error messages
		messages : {
			pphoneNo : {
				required : "please enter phone number ",
				pfoo:"Enter valid phone number"
			},
			puserEmail : {
				required : "please enter email",
				email : "Please enter a valid email address",
			}
		},

		submitHandler : function(form) {
			
			var pid=$("#practiceuserLookupId").val();
			var puserEmail =$("#puserEmail").val();
			var pphoneNo =	$("#pphoneNo").val();
			
			$.ajax({
				url : "../sysadmin/claimPractice?userLookupId="+pid+"&userEmail="+puserEmail+"&phoneNo="+pphoneNo,
				type : "POST",
				success : function(data) {
					$("#puserEmail").val('');
					$("#pphoneNo").val('');
					$(".practicecreatesuccess").fadeIn(1000).delay(10000).fadeOut("slow");
					//$(".practicecreatesuccess").show();
					$("#prmessage").html(data);
					$(".popuppractice_div").hide();
				}
			});
			
		}
	});
	$.validator.addMethod("pfoo", function(value, element) {
		 return this.optional(element) || value == value.match(/^(?:\s*\+)?[\d\s\-()]+$/);
    });
	
	/*$.validator.addMethod("emailfoo", function(value, element) {
		 return this.optional(element) || value == value.match(/^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/);
   });*/
	
	

	$(".profileClose").click(function() {
		$(".popupprofile_div").hide();
	});

	$(".practiceClose").click(function() {
		$(".popuppractice_div").hide();
	});

	$('.carousel').carousel({
		interval : 5000
	// changes the speed
	});

});
function cliamProfile(lookupId) {
	$(".popupprofile_div").css({"position":"relative", "top":$(window).scrollTop()});
	$("#userLookupId").val(lookupId);
	$(".popupprofile_div").show();
}

function cliamPractice(lookupId) {
	$(".popuppractice_div").css({"position":"relative", "top":$(window).scrollTop()});
	$("#practiceuserLookupId").val(lookupId);
	$(".popuppractice_div").show();
}
