
'use strict';


var dentalconsult = {};


var App = angular.module('dentalconsult',  ['ngRoute','ngMessages','dentalconsult.filters', 'dentalconsult.services', 'dentalconsult.directives','ui.bootstrap','dentalconsult.donwload','ngIdle']);

/// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider,$Scope) {

	/*dashboard*/
    $routeProvider.when('/dashBoard', {
        templateUrl: 'cd/sysadmin/home',
        controller: SysAdminHomeController
    });
    $routeProvider.when('/settings', {
        templateUrl: 'cd/sysadmin/settings',
        controller: SystemAdminSettingsController
    });
    $routeProvider.when('/uploadLogo', {
        templateUrl: 'cd/sysadmin/uploadLogo',
        controller: systemAdminUploadLogoController
    });

    /*requestview*/
    $routeProvider.when('/organisationRequestView', {
        templateUrl: 'cd/admin/organisationRequestView',
        controller: OrgRequestViewController
    });
    $routeProvider.when('/practiceRequestView', {
        templateUrl: 'cd/sysadmin/practicerequestview',
        controller: PracticeRequestController
    });
    
      $routeProvider.when('/userRequestView', {
        templateUrl: 'cd/sysadmin/userrequestview',
        controller: UserRequestController
    });
      $routeProvider.when('/approveUserRequest/:requestId', {
          templateUrl: 'cd/sysadmin/userApproveREquest',
          controller: ApproveUserRequestController
      });
      $routeProvider.when('/requestDetails/:requestId', {
          templateUrl: 'cd/sysadmin/requestDetailsView',
          controller: RequestDetailsViewController
      });
      
    /*payment*/
    $routeProvider.when('/paymentView', {
        templateUrl: 'cd/sysadmin/paymentview',
        controller: PaymentViewController
    });
    
    /*insurance and insurance plans*/
    $routeProvider.when('/insuranceView', {
        templateUrl: 'cd/sysadmin/insuranceview',
        controller: InsuranceViewController
    });
    $routeProvider.when('/insurancePlans', {
        templateUrl: 'cd/sysadmin/insurancePlans',
        controller: InsurancePlansController
    });
    $routeProvider.when('/insurancePlansCreate/:insId/:insName', {
        templateUrl: 'cd/sysadmin/insurancePlansCreate',
        controller: InsurancePlansCreateController
    });
   $routeProvider.when('/insurancePlansView/:insId', {
        templateUrl: 'cd/sysadmin/insurancePlansView',
        controller: InsurancePlansViewController
    });
    
    $routeProvider.when('/insurancePlansEdit/:insPlanId/:plans', {
        templateUrl: 'cd/sysadmin/insurancePlansEdit',
        controller: InsurancePlansEditController
    });
    $routeProvider.when('/createInsurance', {
        templateUrl: 'cd/systadmin/createInsurance',
        controller: InsuranceCreateController
    });
    
    $routeProvider.when('/insuranceEdit/:insId', {
        templateUrl: 'cd/sysadmin/insuranceEdit',
        controller: InsuranceEditController
    });
    
    /*organization*/
    $routeProvider.when('/orgView', {
        templateUrl: 'cd/sysadmin/orgview',
        controller: OrgViewController
    });
     $routeProvider.when('/orgCreate', {
        templateUrl: 'cd/sysadmin/orgcreate',
        controller: OrgCreateController
    });
     $routeProvider.when('/orgRequestCreate/:requestId', {
         templateUrl: 'cd/sysadmin/orgcreate',
         controller: OrgCreateController
     });
     
    $routeProvider.when('/orgEdit/:orgId', {
        templateUrl: 'cd/sysadmin/orgedit',
        controller: OrgEditController
    });
    

    /*practice*/
    $routeProvider.when('/practiceView', {
        templateUrl: 'cd/sysadmin/practiceview',
        controller: PracticeViewController
    });
    $routeProvider.when('/practiceCreate/:orgId/:viewName', {
        templateUrl: 'cd/sysadmin/practiceCreate',
        controller: PracticeCreateController
    });
    $routeProvider.when('/practiceEdit/:practiceId/:orgId/:viewName', {
        templateUrl: 'cd/sysadmin/practiceEdit',
        controller: PracticeEditController
    });
    $routeProvider.when('/acceptedInsuranceView/:practiceId/:orgId/:viewName', {
        templateUrl: 'cd/sysadmin/acceptedInsuranceView',
        controller: AcceptedInsuranceViewController
    });
    $routeProvider.when('/serviceProvidedView/:practiceId/:orgId/:viewName', {
        templateUrl: 'cd/sysadmin/serviceProvidedView',
        controller: ServiceProvidedViewController
    });
    $routeProvider.when('/practiceViewDetails/:practiceId/:orgId/:viewName', {
        templateUrl: 'cd/sysadmin/practiceViewDetails',
        controller:PracticeViewDetailsController
    });
    
    $routeProvider.when('/orgPracticeView/:orgId', {
        templateUrl: 'cd/sysadmin/orgPracticeView',
        controller:OrgPracticeViewController
    });
    
    $routeProvider.when('/practiceLookup', {
    templateUrl: 'cd/systemadmin/practiceLookup',
    controller: PracticeLookupViewController
    });
    
    $routeProvider.when('/practicefullview/:lookupId', {
        templateUrl: 'cd/systemadmin/practicefullview',
        controller: PracticeLookupFullviewController
    });
    
    $routeProvider.when('/practiceImageUpload/:practiceId/:orgId/:viewName', {
        templateUrl: 'cd/practice/practiceImageUpload',
        controller: PracticeImageUploadController
    });
    
    $routeProvider.when('/dentistsListView/:userType/:stateId/:cityId/:zipCode/:totalCount', {
        templateUrl: 'cd/sysadmin/getDentistsView',
        controller: DentistsViewController
    });
    
      $routeProvider.when('/subadmin', {
        templateUrl: 'cd/sysadmin/createSubAdmin',
        controller: SubAdminCreateController
    });
    $routeProvider.when('/subAdminEdit/:userId', {
        templateUrl: 'cd/sysadmin/editSubAdmin',
        controller: SubAdminEditController
    });
    $routeProvider.when('/subAdminView/:userId', {
        templateUrl: 'cd/sysadmin/subAdminView',
        controller: subAdminViewDetailsController
    });
    $routeProvider.when('/uploadPracticeCreate/:requestId', {
        templateUrl: 'cd/sysadmin/getuploadPracticeCreate',
        controller: RequetUploadsController
    });
    $routeProvider.when('/ogranizationViewDetails/:orgId', {
        templateUrl: 'cd/sysadmin/ogranizationViewDetails',
        controller:OrgViewDetails
    });
        
    
    $routeProvider.otherwise({redirectTo: '/dashBoard'});
}]);


App.filter('startFrom', function () {
	return function (input, start) {
		if (input) {
			start = +start;
			return input.slice(start);
		}
		return [];
	};
});

App.run(function($rootScope) {
	  var lastDigestRun = new Date();
	  
	  $rootScope.$watch(function detectIdle() {
	    var now = new Date();
	    if (now - lastDigestRun >100*60*60) {
	       // logout here, like delete cookie, navigate to login ...
	    	  window.location.href ="/careduo/sessionLogout";
	    }
	    lastDigestRun = now;
	  });
	  
});

google.load('visualization', '1', {packages: ['corechart']});
google.setOnLoadCallback(function() {
  angular.bootstrap(document.body, ['dentalconsult']);
});
    
    