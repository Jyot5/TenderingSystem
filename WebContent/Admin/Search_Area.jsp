<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html><head>
<!-- <script src="js/eakroko.min.js"></script>
 --></head>
<body>
<jsp:include  page="menu.jsp" />
	<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-home"></i>Manage Location - Search Area</h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Manage Location<span class="divider">/</span></li>
						<li class='active'>Search Area</li>
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
														<span>Search Area</span>
													</div>
													
													<form  id="bb">
													<div class="box-body box-body-nopadding">
														
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>City Name</th>
																	<th>Area Name</th>
																	<th>Description</th>
																	<th>Edit</th>
																	<th>Delete</th>
																	
																</tr>
															</thead>
															
															<tbody>
															<c:forEach items="${sessionScope.search1}" var="se">
																<tr>
																	<td>${se.cityVO.city_Name}</td>
																	<td>${se.area_Name}</td>
																	<td>${se.area_Desc}</td>
																	<td><a href="<%=request.getContextPath()%>/AreaController?flag=edit&id=${se.area_ID}">Edit</a></td>
																	<td><a href="<%=request.getContextPath()%>/AreaController?flag=delete&id=${se.area_ID}">Delete</a></td>
																		
																</tr>
															</c:forEach>
															<c:remove var="se" scope="session"/>		
															
																</tbody>
															</table>
														</div>
														
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