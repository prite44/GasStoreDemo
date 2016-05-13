'use strict';
App.service('ContactService', [ 'SignupService', function(SignupService) {
	var self = {
		'Signup' : function(signup) {
			self.check = false;
			self.isLoading = true;
			SignupService.Signup(signup).then(function(data) {
				console.log("Signup");
			}, function(errResponse) {
				console.error('ระบบเกิดข้อผิดพลาด');
			});
		},
		'CheckUser' : function(Username){
			SignupService.findUserName(Username).then(function(data) {
				self.check = data;
			}, function(errResponse) {
				console.error('ระบบเกิดข้อผิดพลาด');
			});
		}
	};
	return self;

} ]);
App.controller('SignupController', [ '$scope','$window','ContactService',
		function($scope,$window,ContactService) {
            $scope.signup ={};
			$scope.contacts = ContactService;
			$scope.process = function(name){
				if($scope.contacts.check){
					$scope.contacts.Signup(name);
					alert("Registered Successfully");
					$scope.signup ={};
					$window.location.href="/login";
				}
				else
					alert("user have already");
			};
			$scope.CheckUsername = function(user){
				$scope.contacts.CheckUser(user);
			}
		} ]);
