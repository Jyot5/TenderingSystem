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
						<li>Report<span class="divider">/</span></li>
						<li class='active'>Post Working Report</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-list-ul"></i>
								<span>Post Working Report</span>
							</div>
							<div class="box-body box-body-nopadding">
								
								<form action="#" method="POST" class='form-horizontal form-bordered form-validate' id="bb">
									<div class="control-group">
										<label for="textfield" class="control-label">Select Project</label>
										<div class="controls">
											<select name="Tender_ID" id="Tender_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.Tender_list}" var="list">
												<option value="${list.tender_Id}">${list.tender_Name}</option>
												</c:forEach>
												
											</select>
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Assigned Govt. Employee</label>
										<div class="controls">
											<input type="text" name="gname" id="textfield" class="input-xlarge" data-rule-required="true" data-rule-minlength="2">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">Work Done:</label>
										
										

										<div class="controls">
										
										<a href="SubGrade.jsp">SubGrade</a><br>
										<a href="SubBase_Course.jsp">SubBase Course</a><br>
										<a href="Base_Course.jsp">Base Course</a><br>
										<a href="Bituminous_Work.jsp">Bituminous Work</a><br>
											
										</div>
									</div>
									
									<div class="form-actions">
										<input type="submit" class="button button-basic-blue" value="Submit">
										<button type="button" class="button button-basic">Cancel</button>
									</div>
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