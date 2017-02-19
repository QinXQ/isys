/**
 * Created by Q on 2017/2/19.
 */
var visitorModule=angular.module('visitorModule',[])

/*controller*/
visitorModule.controller('visitorCtrl',['$scope','visitorService',function ($scope,visitorService) {
    $scope.test=function () {
        console.log("test angular.")
        $scope.testHttp()
    }

    $scope.testHttp=function () {
        visitorService.test1();
    }
}])

/*service*/
visitorModule.service('visitorService',['$http',function ($http) {
    var service={
        test1:function () {
            $http.get(contextPath+'/test').then(function (response) {
                console.log(response)
            })
        },
        test2:function () {
            console.log("test http.")
        }
    }
    return service;
}])