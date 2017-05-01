 <!doctype html>
 <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head></head>
<body data-layout="fixed">
<jsp:include  page="menu.jsp" />

	
<div id="main">

		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-home"></i> Tender - Search Tender</h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="Dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Tender<span class="divider">/</span></li>
						<li class='active'>Search Tender</li>
					</ul>
				</div>
			</div>

			<div class="container-fluid" id="content-area">
				
					
										<div class="row-fluid">
											<div class="span12">
												<div class="box">
													<div class="box-head">
														<i class="icon-table"></i>
														<span>Search Tender</span>
													</div>
													<div class="box-body box-body-nopadding">
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>Tender Name</th>
																	<th>Category Name</th>
																	<th>SubCategory Name</th>
																	<th>Date</th>
																	<th>City</th>
																	<th>Area</th>
																	<th>Approx amount</th>
																	
																</tr>
															</thead>
															<tbody>
																<c:forEach items="${sessionScope.search3}" var="ser">
																<tr>
																	<td>${ser.tenderVO.tender_Name}</td>
																	<td>${ser.categoryVO.category_Name }</td>
																	<td>${ser.subCategoryVO.subCategory_Name}</td>
																	<td>${ser.submission}</td>
																	<td>${ser.cityVO.city_Name}</td>
																	<td>${ser.areaVO.area_Name}</td>
																	<td>${ser.approx_Amount}</td>
																	
																		
																</tr>
															</c:forEach>		
															<c:remove var="ser" scope="session"/>
															
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