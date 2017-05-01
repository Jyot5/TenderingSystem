<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body>
<jsp:include  page="menu.jsp" />
	<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-home"></i>Manage Users</h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						
						<li class='active'>Manage Users</li>
					</ul>
				</div>
			</div>

			<div class="container-fluid" id="content-area">
				
					
										<div class="row-fluid">
											<div class="span12">
												<div class="box">
													<div class="box-head">
														<i class="icon-table"></i>
														<span>Manage Users</span>
													</div>
													<div class="box-body box-body-nopadding">
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>First Name</th>
																	<th>Last Name</th>
																	<th>Type</th>
																	<th>Status</th>
																	
																</tr>
															</thead>
															<tbody>
															<c:forEach items="${sessionScope.search1}" var="se">
																<tr>
																	<td>${se.first_Name}</td>
																	<td>${se.last_Name}</td>
																	<td>${se.user_Type}</td>
																	<td>${se.user_Status}</td>	
																</tr>
															</c:forEach>	
															<c:remove var="se" scope="session"/>	
															
																					</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
											</div>
										</div>
									</div>
																	</body>

								</html>