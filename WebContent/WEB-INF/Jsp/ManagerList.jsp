<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="net.sf.json.JSONArray"%>
<!DOCTYPE html>
<html>

	<head>

		<title>列出所有人的信息</title>
		<!-- bootstrap顶部的jsp -->
		<%@ include file="comment/bootstrapHead.jsp"%>
		<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>  
		<script src="<%=request.getContextPath()%>/Js/Customer.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/Jquery/jquery-3.2.1.min.js"></script>
	</head>
	
	<body>
		<!-- 标题 -->
		<div class="title">
			<h3 class="text-center">U帮管理系统</h3>
		</div>
		<div class="contain col-md-12">
			<div class="table-responsive col-md-12"><!-- 表格响应式 -->
				<div class="tabbable">	
				<!-- 导航 -->
					<ul class="nav nav-tabs">
						<li>					
							<a href="/ubang/News/GetAllNewsAdmin">资讯信息</a>
						</li>
						<!-- <li class="active">
							<a href="#1" data-toggle="tab">账户信息</a>
						</li> -->
						
						<li class="dropdown active">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#1">
								管理员信息 <span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
									 <li><a href="/ubang/User/GetAllUsersAdmin">用户信息</a></li>
							</ul>
						</li>
						
						<li>
							<!-- <a href="http://119.23.232.90:8080/warehouseBeta/Transaction/TransactionList" >销售信息</a> -->
							 <a href="/ubang/SeekHelp/GetSeekHelpListAdmin" >求助信息</a> 
						</li>
					</ul>
					<!-- 导航内容 -->
					<div class="tab-content">
							<div class="tab-pane active " id="1">
							
							<%@ include file="comment/headline.jsp"%>
										
							<!-- 仓库信息的表格 -->
							<table class="table table-striped table-bordered  col-md-12" id="reportTable">					
								<thead>
									<tr>
										<th class="text-center">ID</th>
										<th class="text-center">姓名</th>
										<th class="text-center">手机号</th>
										<th class="text-center">创建人</th>
										
										<c:if test="${sessionScope.root == '1'}">
											<th class="text-center">重置密码</th>
											<th class="text-center">删除</th>
										</c:if>					
									
									</tr>
								</thead>
								<c:forEach items="${managers}" var="item">
									<tbody>
										<tr class="text-center">
											<td>${item.id}</td>
											<td>${item.name}</td>
											<td>${item.phone}</td>			
											<td>${item.who_create}</td>		
											
											<c:if test="${sessionScope.root == '1'}">
												<td><button class="btn " onclick="updated(${item.id})" data-toggle="modal" data-target="#updateModal">重置密码</button></td>
												<td><button class="btn " onclick="updated(${item.id})" data-toggle="modal" data-target="#updateModal">删除</button></td>
											</c:if>	
											
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="CustomerModal/CommodityModal.jsp"%>
		<%@ include file="CustomerModal/updateModal.jsp"%>
		<%@ include file="CustomerModal/deleteModal.jsp"%>
		<%@ include file="CustomerModal/addModal.jsp"%>
		<!-- bootstrap的底部jsp -->
		<%@ include file="comment/bootstrapBottom.jsp"%>
	</body>

</html>