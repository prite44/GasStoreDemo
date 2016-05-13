'use strict';
App.factory('SignupService', [
		'$http',
		'$q',
		function($http, $q) {

			return {
				//fetchAllData
				Signup : function(signup) {
					return $http.post('/signup/create',signup)
					.then(function(response) {
						return response.data;
					}, function(errResponse) {
						return $q.reject(errResponse);
					});	
				},
				findUserName : function(username) {
					return $http.put('/signup/checkuser/' +username)
							.then(function(response) {
								
								return response.data;
							}, function(errResponse) {
								
								return $q.reject(errResponse);
							});
				}
			};

		} ]);
