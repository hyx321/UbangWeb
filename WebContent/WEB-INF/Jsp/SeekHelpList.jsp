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
		<script src="<%=request.getContextPath()%>/Js/Transaction.js"></script>
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
						
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">信息
								 <span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="/ubang/User/GetAllUsersAdmin">用户信息</a></li>
								<li><a href="/ubang/User/GetAllManagerAdmin">管理员信息</a></li>
							</ul>
						</li>
						
						<li class="active">
							<a href="#1" data-toggle="tab">求助信息</a>
						</li>
					</ul>
					<!-- 导航内容 -->
					<div class="tab-content">
							<div class="tab-pane active " id="1">
							
								<!-- 添加栏 -->
								<div class="col-md-12 column">
									<nav class="navbar " role="navigation">
															
										<form role="form" class="navbar-form navbar-left" >
											<div class="form-group">
													<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">进度分类 
														<span class="caret"></span>
													</button>
													<ul class="dropdown-menu" role="menu">		
														<li><a href="#" onclick="sort('全部')">全部</a></li>
														<li class="divider"></li>								
														<li><a href="#" onclick="sort('未开始')">未开始</a></li>
														<li class="divider"></li>
														<li><a href="#" onclick="sort('进行中')">进行中</a></li>
														<li class="divider"></li>
														<li><a href="#" onclick="sort('结束')">结束</a></li>
													</ul>
											</div>
										
										</form>
										
										<form class="navbar-form navbar-right " role="search">
											<div class="form-group">
												<input type="text" class="form-control"  placeholder="输入用户名或者昵称"/>
											</div> 
											<button type="submit" class="btn btn-default">查找</button>
										</form>
										
									</nav>
								</div>
										
							<!-- 仓库信息的表格 -->
							<table class="table table-striped table-bordered  col-md-12" id="reportTable">					
								<thead>
									<tr>
										<th class="text-center">ID</th>
										<th class="text-center">状态</th>
										<th class="text-center">求助人</th>
										<th class="text-center">求助类型</th>
										<th class="text-center">求助内容</th>
										<th class="text-center">求助时间</th>
										<th class="text-center">删除</th>
									</tr>
								</thead>
								<c:forEach items="${seekHelps}" var="item">
								
									<tbody>				
										<c:if test="${item.status == '未开始'}">
											<tr class="text-center warning">
										</c:if>	
										
										<c:if test="${item.status == '进行中'}">
											<tr class="text-center success" onclick="showHelping(${item.id})" data-toggle="modal" data-target="#helpingModal">
										</c:if>	 
										
										<c:if test="${item.status == '结束'}">
											<tr class="text-center active" onclick="show(${item.id})" data-toggle="modal" data-target="#updateModal">
										</c:if>	
											<td>${item.id}</td>
											<c:if test="${item.is_urgent == 1}">
												<td class="danger">${item.status}</td>
											</c:if>	
											<c:if test="${item.is_urgent == 0}">
												<td>${item.status}</td>
											</c:if>	
											<td>${item.name}</td>
											<td>${item.type}</td>
											<td>${item.content}</td>
											<td>${item.create_time}</td>		
											<td><button class="btn " onclick="updated(${item.id})" data-toggle="modal" data-target="#deleteModal">删除</button></td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="TransactionModal/CommodityModal.jsp"%>
		<%@ include file="TransactionModal/updateModal.jsp"%>
		<%@ include file="TransactionModal/deleteModal.jsp"%>
		<%@ include file="TransactionModal/helpingModal.jsp"%>
		<!-- bootstrap的底部jsp -->
		<%@ include file="comment/bootstrapBottom.jsp"%>
	</body>

</html>