<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="form-group">
    <div>
	<label class="col-sm-3 control-label">ชื่อร้านลูกค้า</label>
	</div>
	<div class="col-sm-10">
		<input type="text" class="form-control" name="name"
			ng-model="contacts.selectProduct.shopname" required />
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">ชื่อเจ้าของร้าน</label>
	<div class="col-sm-10">
		<input type="text" name="email" class="form-control"
			ng-model="contacts.selectProduct.hostname" required />
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">จังหวัด</label>
	<div class="col-sm-10">
		<input type="text" class="form-control" name="photo"
			ng-model="contacts.selectProduct.province" />
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">ที่อยู่</label>
	<div class="col-sm-10">
		<textarea name="address" ng-model="contacts.selectProduct.address"
										id="address" class="form-control" rows="5"></textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">โทรศัพท์</label>
	<div class="col-sm-10">
		<input type="text" class="form-control" name="photo"
			ng-model="contacts.selectProduct.tel" />
	</div>



</div>