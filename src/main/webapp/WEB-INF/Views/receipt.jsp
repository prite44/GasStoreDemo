
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../Views/templates/header.jsp" %>



<script src="/private/app/myRecipt.js"></script>
<script src="/private/controller/Receipt.js"></script>
<script src="/private/service/ReceiptService.js"></script>
<script src="/public/lib/DateFormate.js"></script>

<div class="container main-content" ng-app="myOrder">


	<toaster-container></toaster-container>
	<div class="row">
		<div ng-controller="orderhead">
			<div class="col-md-12">
				<form class="form-inline well well-sm">
					<b>Receipt</b>

				</form>

			</div>

			<div class="col-md-4">
				<table class="table table-bordered" infinite-scroll="loadMore()"
					infinite-scroll-distance="1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<center>
								<b>รายละเอียดใบเสร็จ</b>
							</center>
							<button class="btn btn-info pull-right" data-toggle="modal"
								data-target="#CustomerModal">ค้นหาลูกค้า</button>




							<div class="clearfix"></div>

						</div>
						<div class="panel-body">
							<p>
								เลขที่ใบเสร็จ : <input class="form-control input-sm"
									id="inputsm" type="text"
									ng-model="ordercustomer.orderid | date:'ddyymmhhss'" readonly>
							</p>
							<p>
								วันที่ออกใบเสร็จ : <input class="form-control input-sm"
									id="dateorder" type="text"
									ng-model="ordercustomer.orderdate | date:'dd-mm-yyyy'" readonly>
							</p>
							<p>
								ชื่อร้านลูกค้า : <input class="form-control input-sm"
									id="inputsm" type="text" ng-model="ordercustomer.shopname">
							</p>
							<p>
								ที่อยู่ :
								<textarea name="address" ng-model="ordercustomer.shopaddress"
									id="address" class="form-control" rows="3"></textarea>
							</p>
						</div>
						<div class="panel-footer">
						<p>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						<button class="btn btn-warning" ng-click="printorder()" ng-disabled="checkoutprocess()"><span class="glyphicon glyphicon glyphicon-print"></span> ออกใบเสร็จ</button>
						</p>
						
				</table>
			</div>
			<!-- ModalCustomer -->
			<div class="modal fade" id="CustomerModal" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<center>
								<h3 class="modal-title">ข้อมูลลูกค้า</h3>
							</center>
							<div class="form-group">
								<input type="text" class="form-control" id="name"
									ng-model="search" placeholder="ค้นหาชื่อ ร้าน,ค้นหา จังหวัด" />
							</div>

						</div>
						<div class="modal-body">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>ชื่อลูกค้า</th>
										<th>จังหวัด</th>
									</tr>
								</thead>
								<tbody>
									<tr
										ng-repeat="customer in filteredCustomer = (contacts.customers | filter:sensitiveSearch)"
										ng-click="selectCustomer(customer)">
										<td>{{customer.shopname}}</td>
										<td>{{customer.province}}</td>
									</tr>
								</tbody>
							</table>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">ยกเลิก</button>
						</div>
						</form>
					</div>
				</div>
			</div>
			<!--  -->





			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<center>
							<b>รายการสินค้า</b>
						</center>
						<button class="btn btn-info pull-right" data-toggle="modal"
							ng-disabled="checklevel(ordercustomer.level)" data-target="#ProductModal" >เลือกสินค้า</button>
						<div class="clearfix"></div>

					</div>
					<div class="panel-body">
						<table class="table  table-bordered table-striped">
							<tr>

								<th width="30">รายการ</th>
								<th style="width: 138px;"><center>ชื่อ</center></th>
								<th><center>จำนวน</center></th>
								<th><center>ราคาต่อชิ้น</center></th>
								<th><center style="width: 100px;">รวม</center></th>
								<th></th>
							</tr>
							<tr ng:repeat="orders in orderproduct">
								<td>{{$index+1}}</td>
								<td>{{orders.name}}</td>
								<td><input type="number" ng-model="orders.quality"
									ng-required class="input-mini"></td>
								<td><input type="number" ng:model="orders.price"
									ng:required class="input-mini"></td>
								<td><center>{{orders.quality * orders.price}}</center></td>
								<td><a href ng:click="removeItem($index)"><span class="glyphicon glyphicon glyphicon-trash"></span></a></td></tr>
						</table>
						<tabl e class="table">
						<tr>

								<th width="30"></th>
								<th style="width: 138px;"><center></center></th>
								<th><center></center></th>
								<th><center></center></th>
								<th><center>ราคาทั้งหมด  {{total()}} บาท</center></th>
								<th></th>
							</tr>
						</table>
					</div>

				</div>
			</div>

			<!-- ModalCustomer -->
			<div class="modal fade" id="ProductModal" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<center>
								<h3 class="modal-title">รายการสินค้า</h3>
							</center>
							<div class="form-group">
								<input type="text" class="form-control" id="name"
									ng-model="search" placeholder="สินค้า" />
							</div>

						</div>
						<div class="modal-body">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>เลือก</th>
										<th>ชื่อสินค้า</th>
										<th>จำนวนที่เหลือ</th>
									</tr>
								</thead>
								<tbody>
									<tr
										ng-repeat="product in filteredProdust = (contacts.products | filter:sensitiveSearchProduct)">
										<td><input id="{{product.name}}" type="checkbox"
											value="{{product.name}}" ng-checked="checkbox(product)"
											ng-click="toggleSelection(product)" /></td>
										<td>{{product.name}}</td>
										<td>{{product.quality}}</td>
									</tr>
								</tbody>
							</table>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">ยกเลิก</button>
						</div>
						</form>
					</div>
				</div>
			</div>
			<!--  -->
		</div>
	</div>
	<script type="text/javascript">
	$('#dateorder').datepicker({
        format: "dd/mm/yyyy"
    });  
	</script>
