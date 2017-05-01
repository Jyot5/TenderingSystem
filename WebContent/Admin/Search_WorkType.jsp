<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body>
<jsp:include  page="menu.jsp" />
	<div id="main">			
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-file-alt"></i> Search Work Type </h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Manage WorkType<span class="divider">/</span></li>
						<li class='active'>Search Work Type</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-list-ul"></i>
								<span>Search Work Type</span>
							</div>
							<div class="box-body box-body-nopadding">
								
								<form  id="bb">
													<div class="box-body box-body-nopadding">
														
														<table class="table table-nomargin table-bordered dataTable table-striped table-hover">
															<thead>
																<tr>
																	<th>Work type Name</th>
																	
																	<th>Description</th>
																	<th>Edit</th>
																	<th>Delete</th>
																	
																</tr>
															</thead>
															
															<tbody>
															<c:forEach items="${sessionScope.search1}" var="se">
																<tr>
																	<td>${se.workType_Name}</td>
																	
																	<td>${se.workType_Description}</td>
																	<td><a href="<%=request.getContextPath()%>/WorkTypeController?flag=edit&id=${se.workType_ID}">Edit</a></td>
																	<td><a href="<%=request.getContextPath()%>/WorkTypeController?flag=delete&id=${se.workType_ID}">Delete</a></td>
																		
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
	</div>
	<script src="js/eakroko.min.js"></script>
</body>

</html>