		<!-- 模态框（Modal） -->
		<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">删除交易信息</h4>
					</div>
					<div class="modal-body">
						<!-- 修改信息的表单 -->
						<form class="form-horizontal" role="form">
						<!-- ID栏 -->
							<div class="form-group">
								<label for="firstname" class="col-sm-2 control-label" id="s">ID</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteTranNum" id="deleteTranNum" readonly="true" placeholder="请输入ID">
								</div>
							</div>
						<!-- 姓名栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">名称</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"  name="deleteTranName" id="deleteTranName" readonly="true" placeholder="请输入商品名称">
								</div>
							</div>
						<!-- 密码栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">交易数量</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteTranCount" id="deleteTranCount" readonly="true" placeholder="请输入商品交易数量">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">交易金额</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteTranMoney" id="deleteTranMoney" readonly="true" placeholder="请输入交易金额">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">交易日期</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteTranDate" id="deleteTranDate" readonly="true" placeholder="请输入商品交易日期">
								</div>
							</div>		
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">经办人</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="deleteTranOpe" id="deleteTranOpe" readonly="true" placeholder="请输入商品经办人">
								</div>
							</div>
						</form>
					</div>
					<!-- 按钮 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						
						<button type="button" class="btn btn-primary" id="update" onclick="DeleteTran()">删除</button>
					</div>
				</div>		
			</div>
		</div>