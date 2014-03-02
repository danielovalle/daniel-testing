/**
 * Created by daniel on 3/1/14.
 */

// add a new module
var demoApp = angular.module('demoApp', ['ngRoute']);

demoApp.config(function ($routeProvider) {

    $routeProvider
        .when('/', {
            controller: 'Controller1',
            templateUrl: 'views/view1.html'
        })
        .when('/view2', {
            controller: 'Controller1',
            templateUrl: 'views/view2.html'
        })
        .otherwise( {redirectTo: '/'} );

});

// define a controller and add a property to $scope
function Controller1($scope) {

    $scope.providers = [
        {name:'Jorge', city:'Miami', country:'USA', budget:350},
        {name:'Gonzalo', city:'Anapoima', country:'Colombia', budget:250},
        {name:'Myriam', city:'Bogota', country:'Colombia', budget:150}
    ]

    $scope.addProvider = function() {

        $scope.providers.push(
            {
                name:$scope.newProvider.name,
                city:$scope.newProvider.city,
                country:$scope.newProvider.country,
                budget:$scope.newProvider.budget
            }
        )
    }
}