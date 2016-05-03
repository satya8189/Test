


'use strict';


var whiterabbitevent = {};


var App = angular.module('whiterabbitevent',  ['ngRoute']);

/// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider,$Scope) {

	/*eventView*/
    $routeProvider.when('/eventView', {
        templateUrl:'admin/eventView',
        controller:EventViewController
    });
    
 
	/*eventsave*/
    $routeProvider.when('/eventsave', {
        templateUrl:'admin/eventsave',
        controller:EventCreateController
    });
    
	/*eventEdit*/
    $routeProvider.when('/eventEdit/:eventId', {
        templateUrl:'admin/eventEdit',
        controller:EventEditController
    });

    
    $routeProvider.otherwise({redirectTo: '/eventView'});
}]);
    
    