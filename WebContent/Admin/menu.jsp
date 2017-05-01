<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
	<meta charset="utf8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
	

	<!-- Bootstrap -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Admin/css/bootstrap.min.css">
	<!-- Bootstrap responsive -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Admin/css/bootstrap-responsive.min.css">
	<!-- CSS for Growl like notifications -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Admin/css/jquery.gritter.css">
	<!-- TableTools for dataTables plugin -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Admin/css/TableTools.css">
	<!-- Theme CSS -->
	<!--[if !IE]> -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Admin/css/style.css">
	<!-- <![endif]-->
	<!--[if IE]>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Admin/css/style_ie.css">
	<![endif]-->

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath }/Admin/js/jquery.min.js"></script>
	<!-- smoother animations -->
	<script src="${pageContext.request.contextPath }/Admin/js/jquery.easing.min.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath }/Admin/js/bootstrap.min.js"></script>
	<!-- Scrollable navigation -->
	<script src="${pageContext.request.contextPath }/Admin/js/jquery.nicescroll.min.js"></script>
	<!-- Growl Like notifications -->
	<script src="${pageContext.request.contextPath }/Admin/js/jquery.gritter.min.js"></script>
	<script src="${pageContext.request.contextPath }/Admin/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath }/Admin/js/TableTools.min.js"></script>
	<!-- Form plugin -->
	<script src="${pageContext.request.contextPath }/Admin/js/jquery.form.min.js"></script>
	<!-- Validation plugin -->
	<script src="${pageContext.request.contextPath }/Admin/js/jquery.validate.min.js"></script>
	<!-- Additional methods for validation plugin -->
	<script src="${pageContext.request.contextPath }/Admin/js/additional-methods.min.js"></script>

	<!-- Just for demonstration -->
	<script src="${pageContext.request.contextPath }/Admin/js/demonstration.min.js"></script>
	<!-- Theme framework -->
<!-- 	<script src="${pageContext.request.contextPath }/Admin/js/eakroko.min.js"></script> 
 -->	<!-- Theme scripts -->
	<script src="${pageContext.request.contextPath }/Admin/js/application.min.js"></script>
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/Admin/favicon.ico" />
	<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath }/Admin/apple-touch-icon-precomposed.png" />

</head>

<body data-layout="fixed">
	<div id="top"> 
		<div class="container-fluid">
			<div class="pull-left">
				<a href="#" id="brand"><span></span>Road Tendering System</a>
				
			</div>
			<div class="pull-right">
				<div class="btn-group">
					<a href="#" class="button dropdown-toggle" data-toggle="dropdown"><i class="icon-white icon-user"></i>John Doe<span class="caret"></span></a>
					<div class="dropdown-menu pull-right">
						<div class="right-details">
							<h6>Logged in as</h6>
							<span class="name">John Doe</span>
							<span class="email">john.doe@example.com</span>
							<a href="#" class="highlighted-link">Need help?</a>
							<ul>
								<li>
									<a href="#">Getting started</a>
								</li>
								<li>
									<a href="#">Account settings</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<a href="index.html" class="button">
					<i class="icon-signout"></i>
					Logout
				</a>
			</div>
		</div>
	</div>

	<div id="main">
		<div id="navigation">
			

			<ul class="mainNav" data-open-subnavs="multi">
				<li class='active'>
					<a href="<%=request.getContextPath()%>/ApplyTenderController?flag=searchzz"><i class="icon-home icon-white"></i><span>Dashboard</span></a>
				</li>
				<li>
					<a href="#"><i class="icon-edit icon-white"></i><span>Manage Grade</span><span class="label">2</span></a>
					<ul class="subnav">
						<li>
							<a href="Add_Grade.jsp">Add Grade</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/GradeController?flag=search">Serach Grade</a>
						</li>
						
					</ul>
				</li>
				<li>
					<a href="#"><i class="icon-edit icon-white"></i><span>Manage Location</span><span class="label">6</span></a>
					<ul class="subnav">
						<li>
							<a href="Add_City.jsp">Add City</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/AreaController">Add Area</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/StreetController">Add Street</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/CityController?flag=search">Search City</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/AreaController?flag=search">Search Area</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/StreetController?flag=search">Search Street</a>
						</li>
					
					</ul>
				</li>
				<li>
					<a href="#"><i class="icon-edit icon-white"></i><span>Manage Work Type</span><span class="label">2</span></a>
					<ul class="subnav">
						<li>
							<a href="Add_WorkType.jsp">Add WorkType</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/WorkTypeController?flag=search">Serach WorkType</a>
						</li>
						
					</ul>
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/UserController?flag=search"><i class="icon-edit icon-white"></i><span>Manage Users</span><span class="label"></span></a>
				</li>
					
				<li>
					<a href="#"><i class="icon-edit icon-white"></i><span>Category</span><span class="label">2</span></a>
					<ul class="subnav">
						<li>
							<a href="Add_Category.jsp">Add Category</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/CategoryController?flag=search">Search Category</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#"><i class="icon-edit icon-white"></i><span>SubCategory</span><span class="label">2</span></a>
					<ul class="subnav">
						<li>
							<a href="<%=request.getContextPath()%>/SubCategoryController">Add SubCategory</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/SubCategoryController?flag=search">Search SubCategory</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#"><i class="icon-edit icon-white"></i><span>Tender</span><span class="label">6</span></a>
					<ul class="subnav">
						<li>
							<a href="<%=request.getContextPath()%>/TenderController">Add Tender</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/TenderDescController">Add Tender Description</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/TenderCriteriaController">Add Tender Criteria</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/TenderDescController?flag=search">Search Tender</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/TenderController?flag=search1">Edit Tender</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/ProjectAllocationController">Project Allocation</a>
						</li>
					</ul>
				</li>
				
				<li>
					<a href="#"><i class="icon-edit icon-white"></i><span>Reports</span><span class="label">2</span></a>
					<ul class="subnav">
						<li>
							<a href="Audit_Report.jsp">Audit Report</a>
						</li>
						<li>
							<a href="Working_Report.jsp">Working Report</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/ComplaintController?flag=searcha"><i class="icon-th-list icon-white"></i><span>Complaint</span></a>
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/FeedbackController?flag=searcha"><i class="icon-th-list icon-white"></i><span>Feedback</span></a>
				</li>
				<li>
					<a href="Calendar.jsp"><i class="icon-calendar icon-white"></i><span>Calendar</span></a>
				</li>
				
				
				
						
						<li>
							<a href="<%=request.getContextPath()%>/UserController?flag=load"><i class="icon-edit icon-white"></i><span>User profile</span></a>
						</li>
					
			</ul>
			
		</div>
	</div>
	<script type="text/javascript">

	var _gaq = _gaq || [];
	_gaq.push(['_setAccount', 'UA-38620714-1']);
	_gaq.push(['_trackPageview']);

	(function() {
		var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	})();

	</script>
	</body>
	</html>