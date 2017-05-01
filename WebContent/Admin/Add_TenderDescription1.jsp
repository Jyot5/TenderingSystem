<!doctype html>

<html>
<body>
<%@include file="menu.jsp" %>
	<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-file-alt"></i> Tender - Add Tender Description </h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Tender<span class="divider">/</span></li>
						<li class='active'>Add Tender Description</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-list-ul"></i>
								<span>Add Tender Description</span>
							</div>
							<div class="box-body box-body-nopadding">
								 
								<form action="<%=request.getContextPath()%>/TenderDescController" method="POST" class='form-horizontal form-bordered form-validate' id="bb">
									
									<div class="control-group">
										<label for="textfield" class="control-label">Tender Name</label>
										<div class="controls">
										
											 <c:forEach items="${sessionScope.tendername}" var="l">
											 
											 
										 <input type="text" name="tendername" value="${l.tender_Name}" readonly="readonly"/>
										<input type="text" name="idt" value="${l.tender_Id}" readonly="readonly"/>
										
										  	</c:forEach>
										  	
										  	
										  	 
										</div>
									</div>
									
									<div class="control-group">
										<label for="textfield" class="control-label">Select Category</label>
										<div class="controls">
											<select name="Cat_ID" id="Cat_ID" data-rule-required="true">
												 <c:forEach items="${sessionScope.edit1}" var="list">
												<option value="${list.category_ID}">${list.category_Name}</option>
												</c:forEach>
 
											</select>

										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Select SubCategory</label>
										<div class="controls">
											<select name="SubCat_ID" id="SubCat_ID" data-rule-required="true">
 											<c:forEach items="${sessionScope.edit2}" var="list">
												<option value="${list.subCategory_ID}">${list.subCategory_Name}</option>
												</c:forEach> 

											</select>
										</div>
									</div>
									
									<div class="control-group">
										<label for="digitsfield" class="control-label">Earnest Money(Rs.)</label>
										<div class="controls">
											<input type="text" placeholder="Only digits" name="earnest_Money" id="digitsfield" data-rule-minlength="2" data-rule-digits="true" data-rule-required="true">
										</div>
									</div>
									<div class="control-group">
										<label for="digitsfield" class="control-label">Maximum Amount(Rs.)</label>
										<div class="controls">
											<input type="text" placeholder="Only digits" name="maxamt" id="digitsfield" data-rule-minlength="2" data-rule-digits="true" data-rule-required="true">
										</div>
									</div>
									<div class="control-group">
										<label for="digitsfield" class="control-label">Minimum Amount(Rs.)</label>
										<div class="controls">
											<input type="text" placeholder="Only digits" name="minamt" id="digitsfield" data-rule-minlength="2" data-rule-digits="true" data-rule-required="true">
										</div>
									</div>
									
									<div class="control-group">
										<label for="digitsfield" class="control-label">Time limit of Project</label>
										<div class="controls">
											Year   <input type="text" placeholder="Only digits" name="year" id="digitsfield" data-rule-digits="true" data-rule-required="true">
											Month  <input type="text" placeholder="Only digits" name="month" id="digitsfield" data-rule-digits="true" data-rule-required="true">
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Location</label>
										<div class="controls">City
											<select name="City_ID" id="City_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.edit3}" var="list1">
												<option value="${list1.city_ID}">${list1.city_Name}</option>
												</c:forEach>

											</select>
														
										</div>
										<div class="controls">Area
											<select name="Area_ID" id="Area_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.edit4}" var="list2">
												<option value="${list2.area_ID}">${list2.area_Name}</option>
												</c:forEach>

											</select>
										</div>
										<div class="controls">Street
											<select name="Street_ID" id="Street_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.edit6}" var="list1">
												<option value="${list1.street_ID}">${list1.street_Name}</option>
												</c:forEach>

											</select>
										</div>
										<div class="control-group">
										<label for="datefield" class="control-label">Last Date of Submission <small>YYYY-MM-DD</small></label>
										<div class="controls">
											<input type="text" placeholder="Only numbers" name="submission" id="datefield" data-rule-dateISO="true" data-rule-required="true">
										</div>
									</div>
									</div>
									
									
									<div class="form-actions">
										<input type="submit" class="button button-basic-blue" value="Submit">
										<button type="button" class="button button-basic">Cancel</button>
									</div>
									<input type="hidden" name="flag" value="insert">
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