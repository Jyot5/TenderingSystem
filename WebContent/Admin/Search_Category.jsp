<!doctype html>

<html>
<head>

</head>
<body>
<%@include file="menu.jsp" %>
	<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-home"></i>Category - Search Category</h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Category<span class="divider">/</span></li>
						<li class='active'>Search Category</li>
					</ul>
				</div>
			</div>
			<c:if test="${deleteflag eq 'false'}">Please delete related records</c:if>
			        <c:remove var="deleteflag" scope="session"/>
			<div class="container-fluid" id="content-area">
				
					
										<div class="row-fluid">
											<div class="span12">
												<div class="box">
													<div class="box-head">
														<i class="icon-table"></i>
														<span>Search Category</span>
													</div>
													
													<form action="<%=request.getContextPath()%>/CategoryController" method="GET" id="bb">
													<div class="box-body box-body-nopadding">
														
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>Category Name</th>
																	<th>Description</th>
																	<th>Edit</th>
																	<th>Delete</th>
																	
																</tr>
															</thead>
															
															<tbody>
															<c:forEach items="${sessionScope.search1}" var="se">
																<tr>
																	<td>${se.category_Name}</td>
																	<td>${se.category_Description}</td>
																	<td><a href="<%=request.getContextPath()%>/CategoryController?flag=edit&id=${se.category_ID}">Edit</a></td>
																	<td><a href="<%=request.getContextPath()%>/CategoryController?flag=delete&id=${se.category_ID}">Delete</a></td>	
																</tr>
															</c:forEach>	
															<c:remove var="se" scope="session"/>	
															
																</tbody>
															</table>
														</div>
														<input type="hidden" name="flag" value="search"/>
														</form>
													</div>
												</div>
											</div>
											</div>											
										</div>
									</div>
<script src="js/eakroko.min.js"></script> 
																	</body>

								</html>