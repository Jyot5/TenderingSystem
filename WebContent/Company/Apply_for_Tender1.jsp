<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>

<body data-layout="fixed">
<jsp:include  page="menu.jsp" />
	 
		
<div id="main">
			<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-home"></i> Tender - Apply for Tender</h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="Dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Tender<span class="divider">/</span></li>
						<li class='active'>Apply for Tender</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-list-ul"></i>
								<span>Apply for Tender</span>
							</div>
							<div class="box-body box-body-nopadding">
								
								<form action="<%=request.getContextPath()%>/ApplyTenderController" method="POST" class='form-horizontal form-bordered form-validate' id="bb">
									
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
										<label for="textfield" class="control-label">EMD DD NO</label>
										<div class="controls">
											<input type="text" name="ddno" id="textfield" class="input-xlarge" data-rule-required="true" data-rule-minlength="2">
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">EMD DD Date</label>
										<div class="controls">
											<input type="text" name="dddate" id="textfield" class="input-xlarge" data-rule-required="true" data-rule-minlength="2">
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Amount</label>
										<div class="controls">
											<input type="text" name="amount" id="textfield" class="input-xlarge" data-rule-required="true" data-rule-minlength="2">
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