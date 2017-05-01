<!doctype html>

<html>
<body>
<%@include file="menu.jsp" %>
	<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-file-alt"></i>Edit Tender </h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Tender<span class="divider">/</span></li>
						<li class='active'>Edit Tender</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-list-ul"></i>
								<span>Edit Tender</span>
							</div>
							<div class="box-body box-body-nopadding">
								<c:forEach items="${sessionScope.edit}" var="list">
								<form action="<%=request.getContextPath()%>/TenderDescController" method="POST" class='form-horizontal form-bordered form-validate' id="bb">
								
								<div class="control-group">
										<label for="textfield" class="control-label">Tender Name</label>
										<div class="controls">
										
											 <c:forEach items="${sessionScope.tendername}" var="l">
											 
											 
										 <input type="text" name="tendername" value="${l.tender_Name}" readonly="readonly"/>
										 <input type="text" name="idt" value="${list.tenderDescId}" readonly="readonly"/> 
										  <input type="text" name="idu" value="${l.tender_Id}" readonly="readonly"/> 
										
										  	</c:forEach>
										  	
										  	
										  	 
										</div>
									</div>
								
								
								<div class="control-group">
										<label for="textfield" class="control-label">Select Category</label>
										<div class="controls">
											<select name="Cat_ID" id="Cat_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.edit1}" var="list1">
													<c:if test="${list.categoryVO.category_ID==list1.category_ID}">
													<option selected="selected" value="${list1.category_ID}" >${list1.category_Name}</option>
													</c:if>
													<c:if test="${list.categoryVO.category_ID!=list1.category_ID}">
													<option value="${list1.category_ID}" >${list1.category_Name}</option>
													</c:if>
												</c:forEach>
												<c:remove var="list1" scope="session"/>

											</select>
										</div>
									</div>
									
									<div class="control-group">
										<label for="textfield" class="control-label">Select SubCategory</label>
										<div class="controls">
											<select name="SubCat_ID" id="SubCat_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.edit2}" var="list2">
													<c:if test="${list.subCategoryVO.subCategory_ID==list2.subCategory_ID}">
													<option selected="selected" value="${list2.subCategory_ID}" >${list2.subCategory_Name}</option>
													</c:if>
													<c:if test="${list.subCategoryVO.subCategory_ID!=list2.subCategory_ID}">
													<option value="${list2.subCategory_ID}" >${list2.subCategory_Name}</option>
													</c:if>
												</c:forEach>
												<c:remove var="list2" scope="session"/>

											</select>
										</div>
									</div>
									
																		
									<div class="control-group">
										<label for="textfield" class="control-label">Select City</label>
										<div class="controls">
											<select name="City_ID" id="City_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.edit3}" var="list3">
													<c:if test="${list.cityVO.city_ID==list3.city_ID}">
													<option selected="selected" value="${list3.city_ID}" >${list3.city_Name}</option>
													</c:if>
													<c:if test="${list.cityVO.city_ID!=list3.city_ID}">
													<option value="${list3.city_ID}" >${list3.city_Name}</option>
													</c:if> 
												</c:forEach>
												<c:remove var="list3" scope="session"/>


											</select>
										</div>
									</div>
									
									<div class="control-group">
										<label for="textfield" class="control-label">Select Area</label>
										<div class="controls">
											<select name="Area_ID" id="Area_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.edit4}" var="list4">
													<c:if test="${list.areaVO.area_ID==list4.area_ID}">
													<option selected="selected" value="${list4.area_ID}" >${list4.area_Name}</option>
													</c:if>
													<c:if test="${list.areaVO.area_ID!=list4.area_ID}">
													<option value="${list4.area_ID}" >${list4.area_Name}</option>
													</c:if> 
												</c:forEach>
												<c:remove var="list4" scope="session"/>


											</select>
										</div>
									</div>
									
									<div class="control-group">
										<label for="textfield" class="control-label">Select Street</label>
										<div class="controls">
											<select name="Street_ID" id="Street_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.edit6}" var="list6">
													<c:if test="${list.streetVO.street_ID==list6.street_ID}">
													<option selected="selected" value="${list6.street_ID}" >${list6.street_Name}</option>
													</c:if>
													<c:if test="${list.streetVO.street_ID!=list6.street_ID}">
													<option value="${list6.street_ID}" >${list6.street_Name}</option>
													</c:if> 
												</c:forEach>
												<c:remove var="list6" scope="session"/>


											</select>
										</div>
									</div>
									
									<div class="control-group">
										<label for="textfield" class="control-label">Earnest Money</label>
										<div class="controls">
											<input type="text" name="EM" id="digitsfield" placeholder="Only digits" class="input-xlarge" data-rule-digits="true" data-rule-required="true" data-rule-minlength="2" value="${list.earnest_Money}">
										</div>
									</div>
									
									<div class="control-group">
										<label for="digitsfield" class="control-label">Maximum Amount(Rs.)</label>
										<div class="controls">
											<input type="text" placeholder="Only digits" name="maxamt" id="digitsfield" data-rule-digits="true" data-rule-required="true" data-rule-minlength="2" value="${list.max_Amount}">
										</div>
									</div>
									<div class="control-group">
										<label for="digitsfield" class="control-label">Minimum Amount(Rs.)</label>
										<div class="controls">
											<input type="text" placeholder="Only digits" name="minamt" id="digitsfield" data-rule-digits="true" data-rule-minlength="2" data-rule-required="true" value="${list.min_Amount}">
										</div>
									</div>
									
									<div class="control-group">
										<label for="digitsfield" class="control-label">Time limit of Project</label>
										<div class="controls">
											Year   <input type="text" placeholder="Only digits" name="year2" id="digitsfield" data-rule-digits="true" data-rule-required="true" value="${list.year}">
											Month  <input type="text" placeholder="Only digits" name="month2" id="digitsfield" data-rule-digits="true" data-rule-required="true" value="${list.month}">
										</div>
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
									<input type="hidden" name="flag" value="update">
								</form>
								</c:forEach>
								<c:remove var="list" scope="session"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	</body>

</html>