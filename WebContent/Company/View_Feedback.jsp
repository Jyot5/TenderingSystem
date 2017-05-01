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
						<li>Feedback<span class="divider">/</span></li>
						<li class='active'>View Feedback</li>
					</ul>
				</div>
			</div>

			<div class="container-fluid" id="content-area">
				
					
										<div class="row-fluid">
											<div class="span12">
												<div class="box">
													<div class="box-head">
														<i class="icon-table"></i>
														<span>View Feedback</span>
													</div>
													<div class="box-body box-body-nopadding">
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>Project Name</th>
																	<th>From</th>
																	<th>Subject</th>
																	<th>Feedback</th>
																</tr>
															</thead>
															<tbody>
															<c:forEach items="${sessionScope.search1}" var="se">
																<tr>
																	<td>${se.tenderVO.tender_Name}</td>
																	<td>${se.userVO.First_Name}</td>
																	
																	<td>${se.sub}</td>
																	<td>${se.msg}</td>
																	
																		
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
</div>									</div>
											<script src="js/eakroko.min.js"></script>
																	</body>

								</html>