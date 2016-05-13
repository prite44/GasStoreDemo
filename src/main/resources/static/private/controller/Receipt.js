'use strict';
App.service('ContactService', [
		'OrderService',
		'toaster',
		function(OrderService, toaster) {
			var self = {
				'addProduct' : function(product) {
					this.products.push(product);
				},
				'page' : 1,
				'hasMore' : true,
				'isLoading' : false,
				'selectCustomer' : null,
				'customers' : [],
				'products' : [],
				// loadproducts;
				'loadAllproducts' : function() {
					self.hasMore = false;
					self.isLoading = true;
					OrderService.fetchAllProducts().then(function(data) {
						self.hasMore = true;
						self.isLoading = false;
						console.log("Susscess find all data");
						self.products = data;
					}, function(errResponse) {
						console.error('ระบบเกิดข้อผิดพลาด');
					});

				},
				// loadcustomer
				'loadAllCustomer' : function() {
					OrderService.fetchAllCustomers().then(function(data) {
						self.hasMore = true;
						self.isLoading = false;
						console.log("Susscess find all data");
						self.customers = data;
					}, function(errResponse) {
						console.error('ระบบเกิดข้อผิดพลาด');
					});
				},
				'updateContact' : function(product) {
					OrderService.updateProduct(product).then(
							function(data) {
								toaster.pop('success', 'แก้ไขสินค้า : '
										+ product.shopname + '  เรียบร้อย');
								console.log("Update data");
								self.loadAllproducts();
							}, function(errResponse) {
								console.error('ระบบเกิดข้อผิดพลาด');
							});

				},
				'DeleteContact' : function(product) {
					OrderService.remove(product).then(
							function(data) {
								toaster.pop('success', 'ลบสินค้า : '
										+ product.shopname + ' เรียบร้อย');
								self.loadAllproducts();
							}, function(errResponse) {
								console.error('ระบบเกิดข้อผิดพลาด');
							});
				},
				'CreateContact' : function(customer) {
					OrderService.create(customer).then(
							function(data) {
								self.loadAllproducts();
								toaster.pop('success', 'เพิ่มสินค้า : '
										+ customer.shopname + ' เรียบร้อย');
							}, function(errResponse) {
								console.error('ระบบเกิดข้อผิดพลาด');
							})
				},
				'ProcessOrder' : function(json) {
					OrderService.ProcessOrder(json).then(function(data) {
						alert("บันทึกสำเร็จ")
						toaster.pop('success', 'บันทึกสำเร็จ');
						
					}, function(errResponse) {
						console.error('ระบบเกิดข้อผิดพลาด');
					})
				}
			};
			self.loadAllproducts();
			self.loadAllCustomer();
			return self;

		} ]);
App.controller('orderhead', [
		'$scope',
		'ContactService',
		'toaster',
		function($scope, ContactService, toaster) {
			$scope.customers = ContactService.customers;
			$scope.products = ContactService.products;
			$scope.genorder = new Date();
			$scope.orderdate = new Date();
			$scope.reportorder = {
				'orderid' : $scope.genorder,
				'orderdate' : $scope.genorder
			};
			$scope.optionlevel = ContactService.optionlevel;
			$scope.ordercustomer = {
				'orderid' : $scope.genorder,
				'orderdate' : $scope.genorder,
				'id' : '',
				'shopname' : '',
				'shopaddress' : '',
				'level' : ''
			}
			$scope.orderproduct = [];
			$scope.JsonOrder = [];

			$scope.selectCustomer = function(Customer) {
				$scope.ordercustomer.id = $scope.genorder;
				$scope.ordercustomer.id = $scope.reportorder.orderdate;
				$scope.ordercustomer.id = Customer.id;
				$scope.ordercustomer.shopname = Customer.shopname;
				$scope.ordercustomer.shopaddress = Customer.address
						+ ' จังหวัด ' + Customer.province;
				$scope.ordercustomer.level = Customer.level;
				$('#CustomerModal').modal('hide');
			}
			$scope.SelectProduct = function(product) {
				alert(product.name);
			}
			$scope.sensitiveSearch = function(customer) {
				if ($scope.search) {
					return customer.shopname.indexOf($scope.search) == 0
							|| customer.province.indexOf($scope.search) == 0
							|| customer.province.indexOf($scope.search);
				}
				return true;
			};
			$scope.sensitiveSearchProduct = function(product) {
				if ($scope.search) {
					return product.name.indexOf($scope.search) == 0;
				}
				return true;
			};
			// service;
			$scope.contacts = ContactService;
			$scope.loadMore = function() {
				console.log("Load more!!");
			};
			$scope.chkprice = function(level) {
				angular.forEach($scope.orderproduct, function(value, index) {
					alert($filter('findobj')($scope.contacts.products,
							value.name, level));
				})
			};
			$scope.toggleSelection = function(product) {
				// alert($scope.ordercustomer.level);
				var price = product.price;
				if ($scope.orderproduct == "") {
					$scope.orderproduct.push({
						'name' : product.name,
						'quality' : 1,
						'price' : price
					});
				} else {
					var check = true;
					var idx;
					angular.forEach($scope.orderproduct,
							function(value, index) {
								// alert(index);
								if (value.name == product.name) {
									idx = index;
									check = false;
								}
							})
					// alert(idx);
					if (check) {
						$scope.orderproduct.push({
							'name' : product.name,
							'quality' : 1,
							'price' : price
						});
					} else {
						$scope.orderproduct.splice(idx, 1);
					}
				}
				/*
				 * var idx = $scope.orderproduct.indexOf(product); if (idx > -1) {
				 * $scope.orderproduct.splice(idx, 1); }
				 *  // is newly selected else {
				 * $scope.orderproduct.push(product);debugger; }
				 */
			};
			$scope.checkbox = function(product) {
				var check = false;
				angular.forEach($scope.orderproduct, function(value, index) {
					// alert(index);
					if (value.name == product.name) {
						check = true;
					}
				})
				return check;
			};
			$scope.checklevel = function(level) {
				if (level == "") {
					return true;
				} else {
					return false;
				}
			}
			$scope.removeItem = function(index) {
				$scope.orderproduct.splice(index, 1);
			};
			$scope.total = function() {
				var total = 0;
				angular.forEach($scope.orderproduct, function(value) {
					total += value.quality * value.price;
				})
				return total;
			};
			$scope.printorder = function() {
				//alert($scope.orderproduct);
				var dateid = new Date($scope.ordercustomer.orderid);
				var dateString = dateid.format("ddyymmhhss");
				$scope.recipt = {};
				$scope.recipt ={
					'orderid' : dateString,
					'shopid' : $scope.ordercustomer.id,
					'shopname' : $scope.ordercustomer.shopname,
					'shopaddress' : $scope.ordercustomer.shopaddress,
					'OrderList' : $scope.orderproduct
				};
				$scope.contacts.ProcessOrder($scope.recipt);
				$scope.ordercustomer={};
				$scope.orderproduct={};
			};
			$scope.checkoutprocess = function() {
				// alert($scope.orderproduct);
				if ($scope.orderproduct == "") {
					return true;
				} else {
					return false;
				}
			};

			//
		} ]);

App.controller('OrderListDetail', function($scope, ContactService) {
	$scope.contacts = ContactService;
	$scope.optionlevel = $scope.contacts.optionlevel;
	$scope.update = function(product) {
		$scope.contacts.updateContact(product);
	};
	$scope.remove = function(product) {
		$scope.contacts.selectProduct = null;
		$scope.contacts.DeleteContact(product);
	};
	$scope.checkupdate = function(id) {
		if (id == undefined) {
			return true;
		} else {
			return false;
		}
	};
});
