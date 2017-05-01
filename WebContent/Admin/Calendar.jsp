<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body>
<jsp:include  page="menu.jsp" />
	<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-calendar"></i> Calendar</h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li class='active'>Calendar</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-calendar"></i>
								<span>Calendar</span>
							</div>
							<div class="box-body box-body-nopadding">
								<div class="calendar"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</body>

</html>

