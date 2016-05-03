
'use strict';


var dentalconsult = {};


var App = angular.module('dentalconsult',  ['ngRoute','ngMessages','dentalconsult.filters', 'dentalconsult.services', 'dentalconsult.directives','ui.bootstrap','dentalconsult.donwload','ngIdle']);

/// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider,$Scope) {


    $routeProvider.when('/myReferralsView', {
        templateUrl: 'cd/officemanager/referralsview',
        controller: ReferralsViewController
    });
    
   
    $routeProvider.otherwise({redirectTo: "/myReferralsView"});
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
