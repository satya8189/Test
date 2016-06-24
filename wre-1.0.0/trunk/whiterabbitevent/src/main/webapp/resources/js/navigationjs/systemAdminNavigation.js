


'use strict';


var whiterabbitevent = {};


var App = angular.module('whiterabbitevent',  ['ngRoute','wre.services','ngMessages','wre.filters','ui.bootstrap']);

/// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider,$Scope) {

	 $routeProvider.when('/clientsView', {
	        templateUrl:'systemadmin/clientsView',
	        controller:ClientsViewController
	    });
	 
	 $routeProvider.when('/createClient', {
	        templateUrl:'systemadmin/createClient',
	        controller:ClientCreateController
	    });
	 
	 $routeProvider.when('/clientEventsView/:clientId', {
         templateUrl:'systemadmin/navigateEventList',
         controller:ClientEventViewController
     });
	 
	 $routeProvider.when('/clientEventsCreate/:clientId',{
		 templateUrl:'systemadmin/navigateToEventCreate',
		 controller:ClientEventCreateController
	 });
	
	 $routeProvider.when('/clientEventEdit/:eventId',{
		 templateUrl:'systemadmin/navigatetoClientEventEdit',
		 controller:ClientEventEditController
	 });
	 
	 
	 //EventViewController
	 $routeProvider.when('/eventView/:eventId',{
		 templateUrl:'systemadmin/eventView',
		 controller:EventViewController
	 });
	 
	 //serviceList view...../serviceListView
	 $routeProvider.when('/serviceListView/:eventId',{
		 templateUrl:'systemadmin/serviceListView',
		 controller: ServiceViewController
	 });
	  
	
    $routeProvider.otherwise({redirectTo: '/clientsView'});
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
    