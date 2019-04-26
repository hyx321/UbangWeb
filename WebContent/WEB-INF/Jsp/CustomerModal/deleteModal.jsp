		<!-- 模态框（Modal） -->
		<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">删除用户信息</h4>
					</div>
					<div class="modal-body">
						<!-- 修改信息的表单 -->
						<form class="form-horizontal" role="form">
						<!-- ID栏 -->
							<div class="form-group">
								<label for="firstname" class="col-sm-2 control-label" id="s">ID</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteCustomerNum" id="deleteCustomerNum" readonly="true" placeholder="请输入ID">
								</div>
							</div>
						<!-- 姓名栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"  name="deleteCustomerName" id="deleteCustomerName" readonly="true" placeholder="请输入姓名">
								</div>
							</div>
						<!-- 密码栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">银行</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteCustomerBank" id="deleteCustomerBank" readonly="true" placeholder="请输入银行账号">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">电话</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteCustomerTele" id="deleteCustomerTele" readonly="true" placeholder="请输入电话">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">地址</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteCustomerAdd" id="deleteCustomerAdd" readonly="true" placeholder="请输入地址">
								</div>
							</div>
						</form>
					</div>
					<!-- 按钮 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="update" onclick="DeleteCustomer()">删除</button>
					</div>
				</div>		
			</div>
		</div>