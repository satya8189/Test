


'use strict';


var whiterabbitevent = {};


var App = angular.module('whiterabbitevent',  ['ngRoute']);

/// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider,$Scope) {

	/*eventView*/
    $routeProvider.when('/eventView/:userId', {
        templateUrl:'admin/eventView',
        controller:EventViewController
    });
    
    
    /*creatEvent*/
    $routeProvider.when('/eventCreate', {
        templateUrl:'admin/eventCreate',
        controller:EventCreateController
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
    
    