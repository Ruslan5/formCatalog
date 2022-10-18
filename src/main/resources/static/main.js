var app = angular.module("FormCatalog", []);

app.controller("FormController", function($scope, $http) {

    $scope.forms = [];
    $scope.formEntity = {
        id: "",
        lastname: "",
        firstname: "",
        secondname: "",
        birthday: "",
        gender: "",
        profession: ""

    };

    _refreshFormData();

    $scope.submitForm = function() {
        var method = "";
        var url = "";

        if ($scope.formEntity.id === "") {
            method = "POST";
            url = '/form';
        } else {
            method = "PUT";
            url = '/form/' + $scope.formEntity.id;
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.formEntity),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createForm = function() {
        _clearFormData();
    }

    $scope.deleteForm = function(formEntity) {
        $http({
            method: 'DELETE',
            url: '/form/' + formEntity.id
        }).then(_success, _error);
    };

    $scope.editForm = function(formEntity) {
        $scope.formEntity.id = formEntity.id;
        $scope.formEntity.lastname = formEntity.lastname;
        $scope.formEntity.firstname = formEntity.firstname;
        $scope.formEntity.secondname = formEntity.secondname;
        $scope.formEntity.birthday = formEntity.birthday;
        $scope.formEntity.gender = formEntity.gender;
        $scope.formEntity.profession = formEntity.profession;

    };

    function _refreshFormData() {
        $http({
            method: 'GET',
            url: '/form'
        }).then(
            function(res) {
                $scope.forms = res.data;
            },
            function(res) {
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshFormData();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    function _clearFormData() {
        $scope.formEntity.Id = "";
        $scope.formEntity.lastname = "";
        $scope.formEntity.firstname = ""
        $scope.formEntity.secondname = "";
        $scope.formEntity.birthday = "";
        $scope.formEntity.gender = "";
        $scope.formEntity.profession = "";
    };
});
app.$inject = ['$scope'];