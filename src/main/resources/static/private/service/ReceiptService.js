'use strict';
App.factory('OrderService', [
		'$http',
		'$q',
		function($http, $q) {

			return {
				//fetchAllProducts
				fetchAllProducts : function() {
					return $http.get('/inventory/findAll').then(function(response) {
						return response.data;
					}, function(errResponse) {
						console.error('Error while fetching users');
						return $q.reject(errResponse);
					});
				},
				//fetchAllCustomer
				fetchAllCustomers : function(){
					return $http.get('/customer/findAll').then(function(response) {
						return response.data;
					}, function(errResponse) {
						console.error('Error while fetching users');
						return $q.reject(errResponse);
					});
				},
				ProcessOrder : function(Json){
					return $http.post('/receipt/process',Json)
					.then(function(response) {
						return response.data;
					}, function(errResponse) {
						return $q.reject(errResponse);
					});					
				}
			};

		} ]);
