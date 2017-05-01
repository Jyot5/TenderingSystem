<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body>
<jsp:include  page="menu.jsp" />
	<div id="main">	
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-reorder"></i> User profile</h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						
						<li class='active'>User profile</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-user"></i>
								<span>User profile</span>
							</div>
							<div class="box-body box-body-nopadding">
								<form action="<%=request.getContextPath()%>/UserController" class="form-horizontal form-bordered">
									<div class="control-group">
										<label for="textfield" class="control-label">Username</label>
										<div class="controls">
											<input type="text" name="uname">
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Image</label>
										<div class="controls">
											<div class="fileupload fileupload-new" data-provides="fileupload">
												<iframe src="fileupload.jsp" width="100%" height="250"> </iframe>
												
											</div>
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">First name</label>
										<div class="controls">
											<input type="text" name="fname">
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Last name</label>
										<div class="controls">
											<input type="text" name="lname">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">Gender</label>
										<div class="controls">
											<label class='radio'>
												<input type="radio" name="radio" onclick=\"getAnswer('M') value="Male"> Male
											</label>
											<label class='radio'>
												<input type="radio" name="radio" name="radio" onclick=\"getAnswer('F') value="Female"> Female
											</label>
											
										</div>
									</div>
									
									<div class="control-group">
										<label for="textfield" class="control-label">Email</label>
										<div class="controls">
											<input type="text" name="email">
										</div> 
									</div>
									
									<div class="control-group">
										<label for="textfield" class="control-label">Contact Num</label>
										<div class="controls">
											<input type="text" name="connum">
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Password</label>
										
										<div class="controls">
											<input type="text" name="pwd">
											<!-- <span class="uneditable-input"></span> --> <a href="#" class="button button-basic">Change password</a>
											
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Education</label>
										<div class="controls">
											<input type="text" name="education">
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Designation</label>
										<div class="controls">
											<input type="text" name="designation">
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Department</label>
										<div class="controls">
											<input type="text" name="dept" >
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Birthdate</label>
										<div class="controls">
											<input type="text" name="bday">
										</div>
									</div>
									
										<div class="control-group">
										<label for="textfield" class="control-label">Location</label>
										<div class="controls">Apartment No
										<input type="text" name="aname">
														
										</div>
										
										<div class="controls">City
											<select name="City_ID" id="City_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.city}" var="list1">
												<option value="${list1.city_ID}">${list1.city_Name}</option>
												</c:forEach>

											</select>
														
										</div>
										<div class="controls">Area
											<select name="Area_ID" id="Area_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.area}" var="list2">
												<option value="${list2.area_ID}">${list2.area_Name}</option>
												</c:forEach>

											</select>
										</div>
										<div class="controls">Street
											<select name="Street_ID" id="Street_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.street}" var="list1">
												<option value="${list1.street_ID}">${list1.street_Name}</option>
												</c:forEach>

											</select>
										</div>
									
									</div>
									<div class="form-actions">
										<button type="submit" class="button button-basic-blue">Save changes</button>
										<button type="button" class="button button-basic">Cancel</button>
									</div>
									<input type="hidden" name="flag" value="insert" />
									<input type="hidden" name="utype" value="govt" />
									<input type="hidden" name="status" value="inactive" />
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

