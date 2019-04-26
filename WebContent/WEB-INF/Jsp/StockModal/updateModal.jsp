<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>		
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改商品信息</h4>
					</div>
					<div class="modal-body">
						<!-- 修改信息的表单 -->
						<form class="form-horizontal" role="form">
						<!-- ID栏 -->
							<div class="form-group">	
							<label for="firstname" class="col-sm-2 control-label" id="s">ID</label>		
								<div class="col-sm-10 ">
									<input type="text" class="form-control" name="StockNum" id="StockNum" readonly="true" placeholder="请输入ID">
								</div>
							</div>
						<!-- 姓名栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"  name="StockName" id="StockName" placeholder="请输入商品名称">
								</div>
							</div>
						<!-- 密码栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">产地</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="StockOrigin" id="StockOrigin" placeholder="请输入商品产地">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">供应商</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="StockSupp" id="StockSupp" placeholder="请输入商品供应商">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">数量</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="StockCount" id="StockCount" placeholder="请输入商品数量">
								</div>
							</div>
						<!-- 入库时间栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">入库时间</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="StockDate" id="StockDate" placeholder="请输入商品入库时间">
								</div>
							</div>
						<!-- 经办人栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">经办人</label>
								<div class="col-sm-10">
									<input type="text" class="form-control form-control dropdown-toggle"  readonly="true" data-toggle="dropdown"  name="StockOpe" id="StockOpe" placeholder="请选择商品经办人">
									<ul class="dropdown-menu">
											<c:forEach items="${StaffName}" var="name">
												<li>
													<li><a href="#" onclick=setAddStockOpe("${name.name}");>${name.name}</a>
												</li>
											</c:forEach>
										</ul> 
								</div>
							</div>
						</form>
					</div>
					<!-- 按钮 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				
						<button type="button" class="btn btn-primary" id="update" onclick="UpdateStock()">修改</button>
					</div>
				</div>		
			</div>
		</div>