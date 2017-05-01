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
								<form action="<%=request.getContextPath()%>/TenderCriteriaController" method="POST" class='form-horizontal form-bordered form-validate' id="bb">
								
								<div class="control-group">
										<label for="textfield" class="control-label">Tender Name</label>
										<div class="controls">
										
											 <c:forEach items="${sessionScope.tendername}" var="l">
											 
											 
										 <input type="text" name="tendername" value="${l.tender_Name}" readonly="readonly"/>
										 <input type="text" name="idt" value="${list.tenderCriteriaId}" readonly="readonly"/> 
										  <input type="text" name="idu" value="${l.tender_Id}" readonly="readonly"/> 
										
										  	</c:forEach>
										  	
										  	
										  	 
										</div>
									</div>
								
								
								<div class="control-group">
															
																		
									<div class="control-group">
										<label for="textfield" class="control-label">Select Grade</label>
										<div class="controls">
											<select name="grade_ID" id="grade_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.edit11}" var="list3">
													<c:if test="${list.gradeVO.grade_ID==list3.grade_ID}">
													<option selected="selected" value="${list3.grade_ID}" >${list3.grade_Name}</option>
													</c:if>
													<c:if test="${list.gradeVO.grade_ID!=list3.grade_ID}">
													<option value="${list3.grade_ID}" >${list3.grade_Name}</option>
													</c:if> 
												</c:forEach>
												<c:remove var="list3" scope="session"/>


											</select>
										</div>
									</div>
									
									
									<div class="control-group">
										<label for="digitsfield" class="control-label">Minimum Amount (Rs.)</label>
										<div class="controls">
											<input type="text" placeholder="Only digits" name="minamount" id="digitsfield" data-rule-digits="true" data-rule-required="true" value="${list.minamount}">
										</div>
									</div>
									
									<div class="control-group">
										<label for="digitsfield" class="control-label">Minimum Turnover (Rs.)</label>
										<div class="controls">
											<input type="text" placeholder="Only digits" name="minimumturnover" id="digitsfield" data-rule-digits="true" data-rule-required="true" value="${list.minimumTurnover}">
										</div>
									</div>
									
									<div class="control-group">
										<label for="digitsfield" class="control-label">Work Experience <small>No. Of Projects</small></label>
										<div class="controls">
											Individual   <input type="text" placeholder="Only digits" name="individualWE" id="digitsfield" data-rule-digits="true" data-rule-required="true" value="${list.individualWE}">
											In Partnership  <input type="text" placeholder="Only digits" name="partnershipWE" id="digitsfield" data-rule-digits="true" data-rule-required="true" value="${list.partnershipWE}">
										</div>
									</div>
									
									<div class="control-group">
										<label for="textfield" class="control-label">Description</label>
										<div class="controls">
											<textarea name="Description" id="textarea" class="input-block-level" data-rule-required="true" data-rule-minlength="10">${list.description}"</textarea>
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
	</div>
	</body>

</html>