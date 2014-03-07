var todoApp = angular.module('todosApp', []);

todoApp.controller('TodosListCtl', function ($scope, $http) {
    $http.get('service/todos').success(function(data) {
        $scope.todos = data;
    });
});