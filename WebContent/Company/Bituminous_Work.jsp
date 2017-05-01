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
									
									

										<div class="controls">
										
											
												
										 (1)	 
											<label class='checkbox'>
												<input type="checkbox" name="sdbc" value="done"> SDBC
											</label>
											<label class='checkbox'>
												<input type="checkbox" name="bm" value="done"> BM
											</label>
											<label class='checkbox'>
												<input type="checkbox" name="bc" value="done"> BC
											</label>
											<label class='checkbox'>
												<input type="checkbox" name="dbm" value="done"> DBM
												
											</label>
											<br>
											(2)
										<label class='checkbox'>
										<input type="checkbox" name="bt" value="done"> Bituminous Testing</label>
										</div>

		<div class="form-actions">
										<input type="submit" class="button button-basic-blue" value="Submit">
										<button type="button" class="button button-basic">Cancel</button>
									</div>
										<input type="hidden" name="flag" value="bwinsert"/>
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