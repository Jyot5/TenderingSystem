<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-home"></i>Tender - Edit Tender</h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Tender<span class="divider">/</span></li>
						<li class='active'>Edit Tender</li>
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
														<span>Edit Tender</span>
													</div>
													<form>
													<div class="box-body box-body-nopadding">
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>Tender Name</th>
																	<th>Edit</th>
																	<th>Delete</th>
																	
																</tr>
															</thead>
															
															<tbody>
															<c:forEach items="${sessionScope.search4}" var="ser">
																<tr>
																	<td>${ser.tender_Name}</td>
																	<td><a href="<%=request.getContextPath()%>/TenderDescController?flag=edit&id=${ser.tenderDescId}">Edit</a></td>
																	<td><a href="<%=request.getContextPath()%>/TenderController?flag=delete&id=${ser.tenderDescId}">Delete</a></td>
																	
																</tr>
															</c:forEach>		
															<c:remove var="ser" scope="session"/>
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
									</body>

								</html>