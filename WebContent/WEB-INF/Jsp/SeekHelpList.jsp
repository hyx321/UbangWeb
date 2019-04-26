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
			<h1 class="text-center">U帮管理系统</h1>
		</div>
		<div class="contain col-md-12">
			<div class="table-responsive col-md-12"><!-- 表格响应式 -->
				<div class="tabbable">	
				<!-- 导航 -->
					<ul class="nav nav-tabs">
						<li>
							<a href="/ubang/News/newsList">资讯信息</a>
						</li>			
						
						<li>
							<a href="/ubang/User/UserList">用户信息</a>
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
										<th class="text-center">名称</th>
										<th class="text-center">交易数量</th>
										<th class="text-center">交易金额</th>
										<th class="text-center">交易日期</th>
										<th class="text-center">经办人</th>
										<th class="text-center">修改</th>
										<th class="text-center">删除</th>
									</tr>
								</thead>
								<c:forEach items="${itemlist}" var="item">
								
									<tbody>
										<tr class="text-center">
											<td>${item.id}</td>
											<td class="success" onclick="getCommodity(${item.id})" data-toggle="modal" data-target="#CommodityModal">${item.name}</td>
											<td>${item.count}</td>
											<td>${item.money}</td>
											<td>${item.date}</td>
											<td>${item.operator}</td>		
											<td><button class="btn " onclick="updated(${item.id})" data-toggle="modal" data-target="#updateModal">修改</button></td>
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
		<!-- bootstrap的底部jsp -->
		<%@ include file="comment/bootstrapBottom.jsp"%>
	</body>

</html>