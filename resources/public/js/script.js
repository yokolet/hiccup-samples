var myApp = angular.module('myApp', ['ui.bootstrap']);

myApp.controller('PaginationCtrl', function($scope, $http) {
    $scope.totalItems = 60;
    $scope.currentPage = 3;

    $scope.displayPartial = function(page_number) {
        $http.get('pages/'+page_number).success(function(data) {
            $scope.partial = data;
        });
    };
});
