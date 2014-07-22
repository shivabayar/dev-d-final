'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', [
  'ngRoute',
  'myApp.filters',
  'myApp.services',
  'myApp.directives',
  'ui.bootstrap',
  'myApp.controllers'
])
.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
//  $locationProvider.html5Mode(true);
  $routeProvider.
  	when('/view1', {
  		templateUrl: '/assets/partials/view1.html', 
  		controller: 'View1Cntrl'
  			})
  	.when('/partials/:projectId', {
  	    templateUrl: '/assets/partials/view2.html',
  	    controller: 'MyCtrl2'
  	})
  	.
      otherwise({
        redirectTo: '/view1'
      });;
}]);

angular.module('myApp').constant('appSettings', {
  AppURI: 'http://127.0.0.1:9080/'
});
