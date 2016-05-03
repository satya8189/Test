
'use strict';


var dentalconsult = {};


var App = angular.module('dentalconsult',  ['ngRoute','ngMessages','dentalconsult.filters', 'dentalconsult.services', 'dentalconsult.directives','ui.bootstrap','dentalconsult.donwload','ngIdle']);

/// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider,$Scope) {

  //practice
    $routeProvider.when('/myPracticeView', {
        templateUrl: 'cd/practiceadmin/mypracticeview',
        controller: MyPracticeViewController
    });
    
    $routeProvider.when('/myPracticeView/:userId/:practiceId', {
        templateUrl: 'cd/practiceadmin/mypracticeview',
        controller: MyPracticeViewController
    });
    
   $routeProvider.when('/myPracticeCreate/:userId/:practiceId', {
        templateUrl: 'cd/practiceadmin/myPracticeCreate',
        controller: MyPracticeCreateController
    });
   
   $routeProvider.when('/myPracticeEdit/:userId/:parentPracticeId/:practiceId', {
       templateUrl: 'cd/practiceadmin/myPracticeEditView',
       controller: MyPracticeEditController
   });
   
   $routeProvider.when('/myPracticeAcceptedIns/:userId/:parentPracticeId/:practiceId', {
       templateUrl: 'cd/practiceadmin/myAcceptedInsView',
       controller: MyPracticeAcceptedInsController
   });
  
   $routeProvider.when('/myPracticeServicesProvided/:userId/:parentPracticeId/:practiceId', {
       templateUrl: 'cd/practiceadmin/myServicesProvided',
       controller: MyPraticeServicesProvidedController
   });
   
   $routeProvider.when('/myPracticeUploadImages/:userId/:parentPracticeId/:practiceId', {
	      templateUrl: 'cd/practiceadmin/myPracticeUploadImages',
	      controller: MyPracticeUploadImagesController 
	  });
   
   $routeProvider.when('/inviteUserEmail', {
       templateUrl: 'cd/practiceadmin/navigateToinviteUserByEmail',
       controller: InviteUserEmailController
   });
   
   
   /*practice admin userView    */
   $routeProvider.when('/userView/:userId/:practiceId', {
       templateUrl: 'cd/practiceadmin/practiceAdminUserView',
       controller: PracticeAdminUserViewController
   });
   
   
   $routeProvider.when('/practiceAdminUserCreate/:userId/:practiceId', {
       templateUrl: 'cd/practiceadmin/practiceAdminUserCreate',
       controller:PracticeAdminUserCreateController
   });
   //for lookup
   $routeProvider.when('/myTeamLookup/:userId/:practiceId', {
	    templateUrl: 'cd/practiceadmin/myTeamLookup',
	    controller: MyTeamLookupController
	});
   
   //for lookup
   $routeProvider.when('/myTeamLookup/:userId/:practiceId/:npiNumber/:userType', {
	    templateUrl: 'cd/practiceadmin/myTeamLookup',
	    controller: MyTeamLookupController
	});
   
   $routeProvider.when('/myTeamLookupView/:myUserId/:practiceId/:roleUserId/:roleId', {
	    templateUrl: 'cd/practiceadmin/myTeamLookupView',
	    controller: MyTeamLookupViewController
	});
   
   /*Practice Admin Settings*/
   $routeProvider.when('/practiceAdminSettings/:userId/:practiceId', {
       templateUrl: 'cd/practiceadmin/settings',
       controller: PracticeAdminSettingsController
   });
   
   $routeProvider.when('/practiceAdminUploadLogo/:userId/:practiceId', {
       templateUrl: 'cd/practiceadmin/practiceAdminLogo',
       controller: PracticeAdminUploadLogoController
   });
   
   $routeProvider.when('/roleSettings/:userId/:practiceId', {
       templateUrl: 'cd/practiceadmin/roleSettings',
       controller: SelfRolesController
   });
   
   $routeProvider.when('/myConnectionsView/:userId', {
       templateUrl: 'cd/practiceadmin/myConnectionsView',
       controller: MyConnectionsViewController
   });
   
   $routeProvider.when('/inviteUser/:userId', {
       templateUrl: 'cd/practiceadmin/inviteUserPage',
       controller: InviteUserController
   });
   
   $routeProvider.when('/doctorProfileView/:userId', {
       templateUrl: 'cd/practiceadmin/doctorProfileView',
       controller: DoctorProfileViewController
   });
   
   
   $routeProvider.when('/myConnectionsViewRequest/:userId/:connectionStatus', {
       templateUrl: 'cd/practiceadmin/myConnectionsViewRequest',
       controller: MyConnectionsViewRequestController
   });

   /* PracticeAdmin Insurance Navigations*/
   /* Insurance view list*/
   $routeProvider.when('/practiceAdminInsuranceView/:userId/:practiceId',{
 	  templateUrl: 'cd/practiceadmin/practiceAdminInsuranceView',
       controller: PracticeAdminInsuranceViewController
	 });
	 /* PracticeAdmin Insurance Create*/
	 $routeProvider.when('/createInsuranceByPracticeAdmin/:userId/:practiceId', {
	     templateUrl: 'cd/practiceadmin/createInsuranceByPracticeAdmin',
	     controller: PracticeAdminInsuranceCreateController
	 });
	 /* PracticeAdmin InsuranceEdit*/
	 $routeProvider.when('/insuranceEdit/:userId/:practiceId/:insId', {
	     templateUrl: 'cd/practiceadmin/insuranceEditByPracticeAdmin',
	     controller: PracticeAdminInsuranceEditController
	 });
	 /*PracticeAdmin InsurancePlanCreate */
	 $routeProvider.when('/insurancePlansCreate/:insId/:insName/:userId/:practiceId', {
	     templateUrl: 'cd/practiceadmin/insurancePlansCreate',
	     controller: PracticeAdminInsurancePlansCreateController
	 });
	 
	 /* PracticeAdmin InsurancePlansView By InsId */
	 $routeProvider.when('/practiceAdminInsurancePlanView/:insId/:insuStatus', {
	     templateUrl: 'cd/practiceadmin/insurancePlansViewDetails',
	     controller: PracticeAdminInsurancePlansViewController
	 });
	 
	 /*PracticeAdmin InsurancePlanEdit By InsId InsOrgName */
	 $routeProvider.when('/insurancePlansEdit/:insPlanId/:plans/:userId', {
	     templateUrl: 'cd/sysadmin/insurancePlansEdit',
	     controller: PracticeAdminInsurancePlanEditController
	 });
	 
	 /*PracticeAdmin InsurancePlanEdit By InsId InsOrgName */
	 $routeProvider.when('/insurancePlanEdit/:insPlanId/:plans/:insId/:insuStatus', {
	     templateUrl: 'cd/sysadmin/insurancePlansEdit',
	     controller: PracticeAdminInsurancePlanEditController
	 });
	 
	 /* PracticeAdmin InsurancePlans View*/
	 $routeProvider.when('/insurancePlans/:userId', {
	     templateUrl: 'cd/practiceadmin/insurancePlansViewByPracticeAdmin',
	     controller: PracticeAdminAllInsurancePlansController
	 });
	 
	 $routeProvider.when('/paymentView/:userId/:practiceId', {
	       templateUrl: 'cd/payment/paymentView',
	       controller:PaymentViewController
	   });
	 
	 /* End of PracticeAdmin Insurance Navigations*/
   
   
    $routeProvider.otherwise({redirectTo: "/myPracticeView"});
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
