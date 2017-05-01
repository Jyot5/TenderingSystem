<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body>
<jsp:include  page="menu.jsp" />
	<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-file-alt"></i> Add Street </h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Location<span class="divider">/</span></li>
						<li class='active'>Add Street</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-list-ul"></i>
								<span>Add Street</span>
							</div>
							<div class="box-body box-body-nopadding">
								
								<form action="<%=request.getContextPath()%>/StreetController" method="POST" class='form-horizontal form-bordered form-validate' id="bb">
								<div class="control-group">
										<label for="textfield" class="control-label">Select City</label>
										<div class="controls">
											<select name="City_ID" id="City_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.City_list}" var="list1">
												<option value="${list1.city_ID}">${list1.city_Name}</option>
												</c:forEach>

											</select>
																						
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Select Area</label>
										<div class="controls">
											<select name="Area_ID" id="Area_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.Area_list}" var="list2">
												<option value="${list2.area_ID}">${list2.area_Name}</option>
												</c:forEach>

											</select>
											
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Street Name</label>
										<div class="controls">
											<input type="text" name="street_Name" id="textfield" class="input-xlarge" data-rule-required="true" data-rule-minlength="2">
										</div>
									</div>
									
									<div class="control-group">
										<label for="emailfield" class="control-label">Description</label>
										<div class="controls">
											<textarea name="StreetDesc" id="textarea" class="input-block-level" data-rule-required="true" data-rule-minlength="10"></textarea>
										</div>
									</div>
									
									<div class="form-actions">
										<input type="submit" class="button button-basic-blue" value="Submit">
										<button type="button" class="button button-basic">Cancel</button>
									</div>
									<input type=hidden name=flag value="insert">
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