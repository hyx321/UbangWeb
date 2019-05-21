<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>		
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="helpingModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">帮助信息</h4>
					</div>
					<div class="modal-body">
						<!-- 修改信息的表单 -->
						<form class="form-horizontal" role="form">
						<!-- ID栏 -->
							<div class="form-group">	
							<label for="firstname" class="col-sm-2 control-label" id="s">求助者</label>		
								<div class="col-sm-10 ">
									<input type="text" class="form-control" name="recourse_helping" id="recourse_helping" readonly="true" placeholder="请输入ID">
								</div>
							</div>
						<!-- 姓名栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">求助类型</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"  name="type_helping" id="type_helping" readonly="true" placeholder="请输入商品名称">
								</div>
							</div>
						<!-- 密码栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">求助时间</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="recourse_create_time_helping" id="recourse_create_time_helping" readonly="true" placeholder="请输入商品交易数量">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">求助内容</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="content_helping" id="content_helping" readonly="true" placeholder="请输入商品交易金额">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">帮助者</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="helper_helping" id="helper_helping" readonly="true" placeholder="请输入商品交易日期">
								</div>
							</div>
						<!-- 经办人栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">帮助开始时间</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="helper_create_time_helping" id="helper_create_time_helping" readonly="true" placeholder="请输入商品交易日期">
								</div>
							</div>
									
						</form>
					</div>
					<!-- 按钮 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			
					</div>
				</div>		
			</div>
		</div>