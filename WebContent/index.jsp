<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>

		<link href="<c:url value="css/style.css"/>" rel="stylesheet">
		<title>所有信息</title>
		<%@ include file="WEB-INF/Jsp/comment/bootstrapHead.jsp" %>
		<script type="text/javascript" src="Jquery/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="Jquery/bootstrap-datepicker.js"></script>
		<script src="Js/Login.js"></script> 
		
		<!-- 登入事件问题 -->
		<script type="text/javascript">
			$(function(){
					Account.Login.LoginHandler()
				})
		</script>
		
		<!-- 点击触发Modal事件
		<script type="text/javascript">
			function click(){		
				if(event.button==0){
			    	$("#addModal").modal();
				}			  
			}
			document.onmousedown = click;
		</script> -->
		
		<!-- 刚打开页面就跳出Modal -->
		<script>
			$(document).ready(function(){
				$("#addModal").modal({
						backdrop:false,
						keyboard: false
					});
		  });
		</script>
		
	</head>
	
	<body>
	
	<!-- 	背景图的轮播 -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="1500"> 
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div id="1" class="item active">
				<img src="/ubang/images/background1.jpg" >
			</div>
			<div id="2" class="item">
				<img src="/ubang/images/background2.jpg" >
			</div>
			<div id="3" class="item">
				<img src="/ubang/images/background3.jpg" >
			</div>
			<div id="4" class="item">
				<img src="/ubang/images/background4.jpg" >
			</div>
		</div>
	</div>
	
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">U帮管理系统</h4>
				</div>
				<div class="modal-body">
					<!-- 修改信息的表单 -->
					<form class="form-horizontal" role="form">
					<!-- 姓名栏 -->
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"  name="inputYourName" id="inputYourName" placeholder="请输入用户名或者手机号">
							</div>
						</div>
					<!-- 密码栏 -->
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" name="inputPassword" id="inputPassword" placeholder="请输入密码">
							</div>
						</div>	
					<!-- 选项栏 -->
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-9 ">
								<div class="row">
									<div class="checkbox col-sm-offset-2 col-sm-5">
										<label>
											<input type="checkbox" > 记住密码
										</label>	
									</div>
									<button type="button" class="btn btn-link col-sm-3" >忘记密码</button>
								</div>
							</div>
						</div>
				
					</form>
				</div>
				<!-- 按钮 -->
				<div class="modal-footer">
				
					<button type="button" class="btn btn-primary" id="enter">登入</button>
				</div>
			</div>		
		</div>
	</div>
	
	<%@ include file="WEB-INF/Jsp/comment/bootstrapBottom.jsp" %>
	</body>

</html>