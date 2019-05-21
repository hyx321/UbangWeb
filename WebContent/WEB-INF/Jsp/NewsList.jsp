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
				<h3 class="text-center">U帮管理系统</h3>
		</div>
		<div class="contain col-md-12">
			<div class="table-responsive col-md-12"><!-- 表格响应式 -->
				<div class="tabbable">	
				<!-- 导航 -->
					<ul class="nav nav-tabs">
						<li class="active">
							<a href="#1" data-toggle="tab">资讯信息</a>
						</li>			
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">基础信息
								 <span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="/ubang/User/GetAllUsersAdmin">用户信息</a></li>
								<li><a href="/ubang/User/GetAllManagerAdmin">管理员信息</a></li>
							</ul>
						</li>
						
						<li>
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
										<th class="text-center">城市</th>
										<th class="text-center">技术</th>
										<th class="text-center">职位</th>
										<th class="text-center">公司</th>
										<th class="text-center">月薪</th>
										<th class="text-center">工作经验</th>
										<th class="text-center">学位</th>
										<th class="text-center">招收人数</th>
										<th class="text-center">发布日期</th>
										<th class="text-center">修改</th>
										<th class="text-center">删除</th>
									</tr>
								</thead>
								<c:forEach items="${newslist}" var="item">
								
									<tbody>
										<tr class="text-center">
											<td>${item.city}</td>
											<td>${item.job_type}</td>
											<td>${item.job_position}</td>
											<td>${item.job_company}</td>
											<td>${item.job_salary}</td>
											<td>${item.job_require_exp}</td>
											<td>${item.job_require_degree}</td>
											<td>${item.job_require_num}</td>
											<td>${item.job_require_time}</td>
											<td><button class="btn " onclick="updated(${item.id})" data-toggle="modal" data-target="#updateModal">修改</button></td>
											<td><button class="btn " onclick="updated(${item.id})" data-toggle="modal" data-target="#deleteModal">删除</button></td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
								
							<div class="container" style="text-align:center;" >							
								  <ul class="pagination">
								    <li><a href="#">«</a></li>
								    <li class="active" onclick="updated(${item.id})" ><a href="#">1</a></li>
								    <li onclick="updated(${item.id})" ><a href="#">2</a></li>
								    <li onclick="updated(${item.id})" ><a href="#">3</a></li>
								    <li onclick="updated(${item.id})" ><a href="#">4</a></li>
								    <li onclick="updated(${item.id})" ><a href="#">5</a></li>
								    <li onclick="updated(${item.id})" ><a href="#">6</a></li>
								    <li onclick="updated(${item.id})" ><a href="#">»</a></li>
								  </ul>
							</div>
							
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