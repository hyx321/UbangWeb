<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>		
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改交易信息</h4>
					</div>
					<div class="modal-body">
						<!-- 修改信息的表单 -->
						<form class="form-horizontal" role="form">
						<!-- ID栏 -->
							<div class="form-group">	
							<label for="firstname" class="col-sm-2 control-label" id="s">ID</label>		
								<div class="col-sm-10 ">
									<input type="text" class="form-control" name="TranNum" id="TranNum" readonly="true" placeholder="请输入ID">
								</div>
							</div>
						<!-- 姓名栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">名称</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"  name="TranName" id="TranName" placeholder="请输入商品名称">
								</div>
							</div>
						<!-- 密码栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">交易数量</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="TranCount" id="TranCount" placeholder="请输入商品交易数量">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">交易金额</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="TranMoney" id="TranMoney" placeholder="请输入商品交易金额">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">交易日期</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="TranDate" id="TranDate" placeholder="请输入商品交易日期">
								</div>
							</div>
						<!-- 经办人栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">经办人</label>
								<div class="col-sm-10">
									<input type="text" class="form-control form-control dropdown-toggle"  readonly="true" data-toggle="dropdown" " name="TranOpe" id="TranOpe" placeholder="请选择商品经办人">
									<ul class="dropdown-menu">
											<c:forEach items="${StaffName}" var="name">
												<li>
													<li><a href="#" onclick=setAddTranOpe("${name.name}");>${name.name}</a>
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
				
						<button type="button" class="btn btn-primary" id="update" onclick="UpdateTran()">修改</button>
					</div>
				</div>		
			</div>
		</div>