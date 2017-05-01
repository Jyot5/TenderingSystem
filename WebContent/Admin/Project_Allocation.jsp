<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body>
<jsp:include  page="menu.jsp" />
	<div id="main">			
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-file-alt"></i> Tender - Project Allocation </h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Tender<span class="divider">/</span></li>
						<li class='active'>Project Allocation</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-list-ul"></i>
								<span>Project Allocation</span>
							</div>
							<div class="box-body box-body-nopadding">
								
								<form action="<%=request.getContextPath()%>/ProjectAllocationController" method="POST" class='form-horizontal form-bordered form-validate' id="bb">
									<div class="control-group">
										<label for="textfield" class="control-label">Project Name</label>
										<div class="controls">
											<select name="tender_Id" id="tender_Id" data-rule-required="true">
												<c:forEach items="${sessionScope.tender_list}" var="list">
												<option value="${list.tender_Id}">${list.tender_Name}</option>
												</c:forEach>

											</select>
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Govt Employee</label>
										<div class="controls">
											<select name="govt_Id" id="govt_Id" data-rule-required="true">
												<c:forEach items="${sessionScope.govt_list}" var="list">
												<option value="${list.g_id}">${list.uname}</option>
												</c:forEach>

											</select>

										</div>
									</div>
									
									<div class="form-actions">
										<input type="submit" class="button button-basic-blue" value="Submit">
										<button type="button" class="button button-basic">Cancel</button>
									</div>
									<input type="hidden" name="flag" value="insert"/>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</body>

</html>