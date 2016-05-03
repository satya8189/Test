(function() {
    'use strict';

    var downloadModule = angular.module('dentalconsult.donwload', []);

    downloadModule.factory('downloadService', ['$q', '$timeout', '$window',
        function($q, $timeout, $window) {
            return {
                download: function(document) {

                    var defer = $q.defer();

                    $timeout(function() {
                            $window.location = 'cd/sysadmin/downloadPracticeAppDoc?documentUrl='+document.documentUrl+'&documentName='+document.documentName;

                        }, 1000)
                        .then(function() {
                            defer.resolve('success');
                        }, function() {
                            defer.reject('error');
                        });
                    return defer.promise;
                }
            };
        }
    ]);
})();

