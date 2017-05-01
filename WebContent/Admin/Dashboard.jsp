<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>



<body>
<jsp:include  page="menu.jsp" />
	<div id="main">			
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-home"></i> Dashboard</h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li class='active'>Dashboard</li>
					</ul>
				</div>
			</div>
		
		<div class="container-fluid" id="content-area">
				
					
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
																	<th>Tender Name</th>
																	<th>Company Name</th>
																	
																	
																</tr>
															</thead>
															<tbody>
															<c:forEach items="${sessionScope.de}" var="de1">
																<tr>
																	<td>${de1.tenderVO.tender_Name}</td>
																	
																	<td>${de1.userVO.first_Name}</td>
																																			
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
														<span>Tender-Allocated Company</span>
													</div>
													<div class="box-body box-body-nopadding">
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>Tender Name</th>
																	<th>Company Name</th>
																	
																	
																</tr>
															</thead>
															<tbody>
															<c:forEach items="${sessionScope.searchz}" var="se">
																<tr>
																	<td>${se.tenderVO.tender_Name}</td>
																	
																	<td>${se.uservo.first_Name}</td>
																																			
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