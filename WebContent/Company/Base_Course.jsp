<!doctype html>
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
								<span>Base Course</span>
							</div>
							<div class="box-body box-body-nopadding">
								
								<form action="<%=request.getContextPath()%>/WorkingReportController" method="POST" class='form-horizontal form-bordered form-validate' id="bb">
									
									<%String s=request.getParameter("gname");
									//Long l=Long.valueOf(request.getParameter(Tender_ID));
										System.out.println(s);														
									%>

										<div class="controls">
										
											
												
										 <b>(1)WBM </b>
											<label class='checkbox'>
												<input type="checkbox" name="sampling" value="done"> Sampling 
											</label>
											Testing
											<label class='checkbox'>
												Laboratory Testing<input type="checkbox" name="lt" value="done"> 
											</label>
											<label class='checkbox'>
												 Field Testing<input type="checkbox" name="ft" value="done">
											</label>
											
											 <b>(2)WMM </b>
											<label class='checkbox'>
												<input type="checkbox" name="sampling2" value="done"> Sampling 
											</label>
											Testing
											<label class='checkbox'>
												Laboratory Testing<input type="checkbox" name="lt2" value="done"> 
											</label>
											<label class='checkbox'>
												 Field Testing<input type="checkbox" name="ft2" value="done">
											</label>
											</div>
		<div class="form-actions">
										<input type="submit" class="button button-basic-blue" value="Submit">
										<button type="button" class="button button-basic">Cancel</button>
									</div>
										<input type="hidden" name="flag" value="bcinsert"/>
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