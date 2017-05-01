<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>

<body data-layout="fixed">
<jsp:include  page="menu.jsp" />
<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-home"></i> Tender - View Tender Criteria </h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="Dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Tender<span class="divider">/</span></li>
						<li class='active'>View Tender Criteria</li>
					</ul>
				</div>
			</div>

			<div class="container-fluid" id="content-area">
				
					
										<div class="row-fluid">
											<div class="span12">
												<div class="box">
													<div class="box-head">
														<i class="icon-table"></i>
														<span>View Tender Criteria</span>
													</div>
													<div class="box-body box-body-nopadding">
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>Tender Name</th>
																	<th>Grade</th>
																	<th>Minimum Turnover</th>
																	<th>Minimum Bank Balance</th>
																	<th>Individual Work Exp</th>
																	<th>Parternorship Work Exp</th>
																</tr>
															</thead>
															<tbody>
																	<c:forEach items="${sessionScope.search3}" var="se">
																<tr>
																	<td>${se.tenderVO.tender_Name}</td>
																	
																	<td>${se.gradeVO.grade_Name}</td>
																	<td>${se.minimumTurnover}</td>
																	<td>${se.minimumBankBalance}</td>
																	<td>${se.individualWE}</td>
																	<td>${se.partnershipWE}</td>	
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
<script src="js/eakroko.min.js"></script>
								</body>

								</html>