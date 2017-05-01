
<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body data-layout="fixed">
<jsp:include  page="menu.jsp" />
	<div id="main">
			<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-home"></i> Tender - View Tender</h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="Dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Tender<span class="divider">/</span></li>
						<li class='active'>View Tender</li>
					</ul>
				</div>
			</div>

			<div class="container-fluid" id="content-area">
				
					
										<div class="row-fluid">
											<div class="span12">
												<div class="box">
													<div class="box-head">
														<i class="icon-table"></i>
														<span>View Tender</span>
													</div>
													<div class="box-body box-body-nopadding">
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>Tender Name</th>
																	<th>Category</th>
																	<th>Subcategory</th>
																	<th>Description</th>
																	
																</tr>
															</thead>
															<tbody>
															<c:forEach items="${sessionScope.search4}" var="se">
																<tr>
																	<td>${se.tender_Name}</td>
																	<td>${se.categoryVO.category_Name}</td>
																	<td>${se.subCategoryVO.subCategory_Name}</td>
																	<td>${se.tender_Description}</td>
																	
																		
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
									<script src="js/eakroko.min.js"></script>
									</body>

								</html>