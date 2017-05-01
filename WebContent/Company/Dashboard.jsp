<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>

<body data-layout="fixed">
<jsp:include  page="menu.jsp" />
		<div id="main">
			<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-home"></i> Dashboard</h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="Dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li class='active'>Dashboard</li>
					</ul>
				</div>
				
				<div class="container-fluid" id="content-area">
				
					
										<div class="row-fluid">
											<div class="span12">
												<div class="box">
													<div class="box-head">
														<i class="icon-table"></i>
														<span>Company-Alloted Tender</span>
													</div>
													<div class="box-body box-body-nopadding">
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>Company Name</th>
																	<th>Tender Name</th>
																	
																	
																</tr>
															</thead>
															<tbody>
															<c:forEach items="${sessionScope.searchaa1}" var="sa1">
																<tr>
																	
																	<td>${sa1.userVO.first_Name}</td>
																	<td>${sa1.tenderVO.tender_Name}</td>																		
																</tr>
															</c:forEach>
															<c:remove var="se" scope="session"/>
																					</tbody>
																					
															</table>
														</div>
													</div>
												</div>
											</div>

											<div class="row-fluid">
											<div class="span12">
												<div class="box">
													<div class="box-head">
														<i class="icon-table"></i>
														<span>Company-Applied Tender</span>
													</div>
													<div class="box-body box-body-nopadding">
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>Company Name</th>
																	<th>Tender Name</th>
																	
																	
																</tr>
															</thead>
															<tbody>
															<c:forEach items="${sessionScope.searchaa2}" var="sa1">
																<tr>
																	
																	<td>${sa1.uservo.first_Name}</td>
																	<td>${sa1.tenderVO.tender_Name}</td>																		
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
	</div>
	</body>

</html>