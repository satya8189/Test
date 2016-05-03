'use strict';

/* Directives */

var AppDirectives = angular.module('dentalconsult.directives', []);

AppDirectives.directive('appVersion', ['version', function (version) {
    return function (scope, elm, attrs) {
        elm.text(version);
    };
}]);

/*this is used for map*/
AppDirectives.directive('chart', function() {
	return {
	    restrict: 'A',
	    link: function($scope, elm, attrs) {
	      $scope.$watch('chart', function() {
	    	  
	    	  
	    	  var type = 4;
	          var chart = '';
	          if (type == '1') {
	            chart = new google.visualization.LineChart(elm[0]);
	          } else if (type == '2') {
	            chart = new google.visualization.BarChart(elm[0]);
	          } else if (type == '3') {
	            chart = new google.visualization.ColumnChart(elm[0]);
	          } else if (type == '4') {
	            chart = new google.visualization.PieChart(elm[0]);
	          }
	        chart.draw($scope.chart.data, $scope.chart.options);
	      },true);
	    }
	  };
});