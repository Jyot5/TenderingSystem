<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
	<meta charset="utf8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
	

	<!-- Bootstrap -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Company/css/bootstrap.min.css">
	<!-- Bootstrap responsive -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Company/css/bootstrap-responsive.min.css">
	<!-- calendar plugin -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Company/css/fullcalendar.css">
	<!-- calendar printable plugin -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Company/css/fullcalendar.print.css" media="print">
	
	<!-- CSS for Growl like notifications -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Company/css/jquery.gritter.css">
	<!-- Theme CSS -->
	<!--[if !IE]> -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Company/css/style.css">
	<!-- <![endif]-->
	<!--[if IE]>
	<link rel="stylesheet" href="css/style_ie.css">
	<![endif]-->

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath }/Company/js/jquery.min.js"></script>
	<!-- smoother animations -->
	<script src="${pageContext.request.contextPath }/Company/js/jquery.easing.min.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath }/Company/js/bootstrap.min.js"></script>
	<!-- Scrollable navigation -->
	<script src="${pageContext.request.contextPath }/Company/js/jquery.nicescroll.min.js"></script>
	<!-- Growl Like notifications -->
	<script src="${pageContext.request.contextPath }/Company/js/jquery.gritter.min.js"></script>
	<!-- Form plugin -->
	<script src="${pageContext.request.contextPath }/Company/js/jquery.form.min.js"></script>
		<script src="${pageContext.request.contextPath }/Company/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath }/Company/js/TableTools.min.js"></script>
	
	<!-- TableTools for dataTables plugin -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/Company/css/TableTools.css">
	
	<!-- Validation plugin -->
	<script src="${pageContext.request.contextPath }/Company/js/jquery.validate.min.js"></script>
	<!-- Additional methods for validation plugin -->
	<script src="${pageContext.request.contextPath }/Company/js/additional-methods.min.js"></script>

	<!-- Just for demonstration -->
	<script src="${pageContext.request.contextPath }/Company/js/demonstration.min.js"></script>
	<!-- Theme framework -->
<!--  	<script src="js/eakroko.min.js"></script> --> 
	<!-- Theme scripts -->
	<script src="${pageContext.request.contextPath }/Company/js/application.min.js"></script>
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/Company/favicon.ico" />
	<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath }/Company/apple-touch-icon-precomposed.png" />

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
					<a href="<%=request.getContextPath()%>/ApplyTenderController?flag=searchaa"><i class="icon-home icon-white"></i><span>Dashboard</span></a>
				</li>
				
				
				
				<li>
					<a href="#"><i class="icon-edit icon-white"></i><span>Tender</span><span class="label">5</span></a>
					<ul class="subnav">
						<li>
							<a href="<%=request.getContextPath()%>/TenderController?flag=search2">View Tender</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/TenderDescController?flag=search4">View Tender Description</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/TenderCriteriaController?flag=search">View Tender Criteria</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/TenderDescController?flag=search3">Search Tender</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/ApplyTenderController">Apply for Tender</a>
						</li>
						
					</ul>
				</li>
				
				<li>
					<a href="#"><i class="icon-edit icon-white"></i><span>Reports</span><span class="label">2</span></a>
					<ul class="subnav">
						<li>
							<a href="View_AuditReport.jsp"> View Audit Report</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/TenderController?flag=loadp"> Post Working Report</a>
						</li>
					</ul>
				</li>
				
				<li>
					<a href="#"><i class="icon-edit icon-white"></i><span>Complaint</span><span class="label">2</span></a>
					<ul class="subnav">
						<li>
							<a href="<%=request.getContextPath()%>/ComplaintController?flag=loadc"> Post Complaint</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/ComplaintController?flag=search"> View Complaint</a>
						</li>
					</ul>
				</li>
				
				<li>
					<a href="#"><i class="icon-edit icon-white"></i><span>Feedback</span><span class="label">2</span></a>
					<ul class="subnav">
						<li>
							<a href="<%=request.getContextPath()%>/FeedbackController"> Post Feedback</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/FeedbackController?flag=search"> View Feedback</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="Calendar.html"><i class="icon-calendar icon-white"></i><span>Calendar</span></a>
				</li>
				
				
			</ul>
			
		</div>
		</div>
		<div class="navi-functions">
		<div class="btn-group btn-group-custom">
			<a href="#" class="button button-square layout-not-fixed notify" rel="tooltip" title="Toggle fixed-nav" data-notify-message="Fixed nav is now {{state}}" data-notify-title="Toggled fixed nav">
				<i class="icon-unlock"></i>
			</a>
			<a href="#" class="button button-square layout-not-fluid notify button-active" rel="tooltip" title="Toggle fixed-layout" data-notify-message="Fixed layout is now {{state}}" data-notify-title="Toggled fixed layout">
				<i class="icon-exchange"></i>
			</a>
			<a href="#" class="button button-square notify notify-inverse layout-no-nav" rel="tooltip" title="Toggle navigation" data-notify-message="Navigation is now {{state}}" data-notify-title="Toggled navigation">
				<i class="icon-arrow-left"></i>
			</a>
			<a href="#" class="button button-square button-active force-last notify-toggle toggle-active notify" rel="tooltip" title="Toggle notification"  data-notify-message="Notifications turned {{state}}" data-notify-title="Toggled notifications">
				<i class="icon-bullhorn"></i>
			</a>
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
