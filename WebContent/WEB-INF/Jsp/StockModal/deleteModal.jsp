		<!-- 模态框（Modal） -->
		<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">删除商品信息</h4>
					</div>
					<div class="modal-body">
						<!-- 修改信息的表单 -->
						<form class="form-horizontal" role="form">
						<!-- ID栏 -->
							<div class="form-group">
								<label for="firstname" class="col-sm-2 control-label" id="s">ID</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteStockNum" id="deleteStockNum" readonly="true" placeholder="请输入ID">
								</div>
							</div>
						<!-- 姓名栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">名称</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"  name="deleteStockName" id="deleteStockName" readonly="true" placeholder="请输入商品名称">
								</div>
							</div>
						<!-- 密码栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">产地</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteStockOrigin" id="deleteStockOrigin" readonly="true" placeholder="请输入商品产地">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">供应商</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteStockSupp" id="deleteStockSupp" readonly="true" placeholder="请输入商品供应商">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">数量</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteStockCount" id="deleteStockCount" readonly="true" placeholder="请输入商品数量">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">入库时间</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteStockDate" id="deleteStockDate" readonly="true" placeholder="请输入商品入库时间">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">经办人</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteStockOpe" id="deleteStockOpe" readonly="true" placeholder="请输入商品经办人">
								</div>
							</div>
						</form>
					</div>
					<!-- 按钮 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						
						<button type="button" class="btn btn-primary" id="update" onclick="DeleteStock()">删除</button>
					</div>
				</div>		
			</div>
		</div>