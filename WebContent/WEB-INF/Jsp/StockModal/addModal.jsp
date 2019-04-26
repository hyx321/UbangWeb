<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">添加商品信息</h4>
					</div>
					<div class="modal-body">
						<!-- 修改信息的表单 -->
						<form class="form-horizontal" role="form">
						<!-- 姓名栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">名称</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"  name="addStockName" id="addStockName" placeholder="请输入商品名称">
								</div>
							</div>
						<!-- 密码栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">产地</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="addStockOrigin" id="addStockOrigin" placeholder="请输入商品产地">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">供应商</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="addStockSupp" id="addStockSupp" placeholder="请输入商品供应商">
								</div>
							</div>
						<!-- 地址栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">数量</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="addStockCount" id="addStockCount" placeholder="请输入商品数量">
								</div>
							</div>
						<!-- 入库时间栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">入库时间</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="addStockDate" id="addStockDate" placeholder="请输入商品入库时间">
								</div>
							</div>
						<!-- 经办人栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">经办人</label>
								<div class="col-sm-10">
									<input type="text" class="form-control form-control dropdown-toggle"  readonly="true" data-toggle="dropdown" " name="addStockOpe" id="addStockOpe" placeholder="请选择商品经办人">
									<ul class="dropdown-menu">
											<c:forEach items="${StaffName}" var="name">
												<li>
													<li><a href="#" onclick=setAddStockOpe("${name.name}");>${name.name}</a>
												</li>
											</c:forEach>
										</ul> 
								</div>
							</div>
						<!-- 描述栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">描述</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="addStockRem" id="addStockRem" placeholder="请输入商品描述">
								</div>
							</div>
						</form>
					</div>
					<!-- 按钮 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					
						<button type="button" class="btn btn-primary" id="update" onclick="AddStock()">添加</button>
					</div>
				</div>		
			</div>
		</div>