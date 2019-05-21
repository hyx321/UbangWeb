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
							<label for="firstname" class="col-sm-2 control-label" id="s">求助者</label>		
								<div class="col-sm-10 ">
									<input type="text" class="form-control" name=""recourse"" id="recourse" readonly="true" placeholder="请输入ID">
								</div>
							</div>
						<!-- 姓名栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">求助类型</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"  name="type" id="type" readonly="true" placeholder="请输入商品名称">
								</div>
							</div>
						<!-- 密码栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">求助时间</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="recourse_create_time" id="recourse_create_time" readonly="true" placeholder="请输入商品交易数量">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">求助内容</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="content" id="content" readonly="true" placeholder="请输入商品交易金额">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">帮助者</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="helper" id="helper" readonly="true" placeholder="请输入商品交易日期">
								</div>
							</div>
						<!-- 经办人栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">帮助开始时间</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name=""helper_create_time"" id="helper_create_time" readonly="true" placeholder="请输入商品交易日期">
								</div>
							</div>
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">帮助结束时间</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="helper_end_time" id="helper_end_time" readonly="true" placeholder="请输入商品交易日期">
								</div>
							</div>
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">评分</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="rating" id="rating" readonly="true" placeholder="请输入商品交易日期">
								</div>
							</div>
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">评分内容</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="description" id="description" readonly="true"  placeholder="请输入商品交易日期">
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