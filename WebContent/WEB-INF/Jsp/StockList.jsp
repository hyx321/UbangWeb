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
		<script src="<%=request.getContextPath()%>/Js/Stock.js"></script>
		
		<script type="text/javascript" src="<%=request.getContextPath()%>/Jquery/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/Jquery/bootstrap-datepicker.js"></script>
		<link href="<%=request.getContextPath()%>/css/datepicker.css" rel="stylesheet" type="text/css"/> 
	
	</head>
	
	<body>

		<!-- 标题 -->
		<div class="title">
			<h1 class="text-center">企业进销存系统</h1>
		</div>
		<div class="contain col-md-12">
			<div class="table-responsive col-md-12"><!-- 表格响应式 -->
				<div class="tabbable">	
				<!-- 导航 -->
					<ul class="nav nav-tabs">
						<li class="active">
							<a href="#1" data-toggle="tab">仓库信息</a>
						</li>			
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">基础信息
								 <span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="/warehouseBeta/Customer/CustomerList">客户信息</a></li>
								<li><a href="/warehouseBeta/Staff/StaffList">员工信息</a></li>
							</ul>
						</li>
						
						<li>
							<a href="/warehouseBeta/Transaction/TransactionList" >销售信息</a>
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
										<th class="text-center">名称</th>
										<th class="text-center">产地</th>
										<th class="text-center">供应商</th>
										<th class="text-center">数量</th>
										<th class="text-center">入库时间</th>
										<th class="text-center">经办人</th>
										<th class="text-center">修改</th>
										<th class="text-center">删除</th>
									</tr>
								</thead>
								<c:forEach items="${itemlist}" var="item">
								
									<tbody>
										<tr class="text-center">
											<td>${item.id}</td>
											<td>${item.name}</td>
											<td>${item.origin}</td>
											<td>${item.supplier}</td>
											<td>${item.count}</td>
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
		<%@ include file="StockModal/updateModal.jsp"%>
		<%@ include file="StockModal/deleteModal.jsp"%>
		<%@ include file="StockModal/addModal.jsp"%>
		<!-- bootstrap的底部jsp -->
		<%@ include file="comment/bootstrapBottom.jsp"%>
	</body>

</html>