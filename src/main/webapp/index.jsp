<!DOCTYPE html>

<%-- <%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%> --%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="images/favicon.png">
<%
//String username = SecurityContextHolder.getContext().getAuthentication().getName(); 

String username;
if(SecurityContextHolder.getContext() !=  null){

	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if (principal instanceof UserDetails) {
	  username = ((UserDetails)principal).getUsername();
	} else {
	  username = principal.toString();
	}
}
else{
	username=null;
}
%>
<title>Dev-D</title>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,400italic,700,800'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:300,200,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap core CSS -->
<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="js/jquery.gritter/css/jquery.gritter.css" />

<link rel="stylesheet"
	href="fonts/font-awesome-4/css/font-awesome.min.css">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <![endif]-->
<link rel="stylesheet" type="text/css"
	href="js/jquery.nanoscroller/nanoscroller.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery.easypiechart/jquery.easy-pie-chart.css" />
<link rel="stylesheet" type="text/css"
	href="js/bootstrap.switch/bootstrap-switch.css" />
<link rel="stylesheet" type="text/css"
	href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery.select2/select2.css" />
<link rel="stylesheet" type="text/css"
	href="js/bootstrap.slider/css/slider.css" />
<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet" />

</head>

<body>

	<!-- Fixed navbar -->
	<div id="head-nav" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="fa fa-gear"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Dev-D</span></a>
			</div>
			<div class="navbar-collapse collapse">

				<ul class="nav navbar-nav navbar-right user-nav">
					<li class="dropdown profile_menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><img

							alt="Avatar" src="images/avatar2.jpg" /><%username%> <b class="caret"></b></a>
							<ul class="dropdown-menu">
							<!-- <li><a href="#">My Account</a></li>
							<li><a href="#">Profile</a></li>
							<li><a href="#">Messages</a></li>
							<li class="divider"></li> -->
							<li><a href="#">Sign Out</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right not-nav">



				</ul>

			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div id="cl-wrapper">
		<div class="cl-sidebar"> <!--style="width: 450px;" >-->
			<div class="cl-navblock">
				<div class="menu-space">
					<div class="content">
						<div class="side-user">
							<div class="avatar">
								<img src="images/avatar1_50.jpg" alt="Avatar" />
							</div>
							<div class="info">
								<a href="#"></a> 
							</div>
						</div>
						<div class="header" style="margin-left: 20px;">
							<h3>
								<font color=white> Alerts for you </font>
							</h3>
						</div>
						<div style="margin-left: 20px;" id="alerts-info">
							<!--alerts div for displaying alert-->

						</div>
						<div style="margin-left: 20px;" class="header">
							<h3>
								<font color=white> Your Activity </font>
							</h3>
						</div>
						<div style="margin-left: 20px;" id="activity-info">
							<!--alerts div for displaying alert-->


						</div>
					</div>
				</div>
				<div class="text-right collapse-button" style="padding: 7px 9px;">
					
					<button id="sidebar-collapse" class="btn btn-default" style="">
						<i style="color: #fff;" class="fa fa-angle-left"></i>
					</button>
				</div>
			</div>
		</div>

		<div class="container-fluid" id="pcont">
			<div class="page-head">
				<h2>Charts</h2>
				
			</div>
			<div class="cl-mcont">
				<div class="row">
					<div class="col-sm-6 col-md-6">
						<div class="block-flat" ><!--style="width: 550px; height: 400px;">-->
							<div class="header">
								<h3>Git Commit Trend (days ago)</h3>
							</div>
							
							<div id="commit_trend" ></div>
						</div>

						<div class="block-flat" ><!--style="width: 550px; height: 400px;">-->
							<div class="header">
								<h3>Pull Requests (Coming Soon...)</h3>
							</div>
							
							<div id="pull_trend" ></div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script src="js/jquery.js"></script>
	<script type="text/javascript"
		src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript"
		src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="js/behaviour/general.js"></script>
	<script src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript"
		src="js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript"
		src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript"
		src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script src="js/jquery.select2/select2.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.slider/js/bootstrap-slider.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="js/jquery.gritter/js/jquery.gritter.js"></script>

	

	<script type="text/javascript">
      var USER_NAME = '<%username%>'; // 
      $(document).ready(function(){
        //initialize the javascript
        App.init();
      //  App.charts();
      });
    </script>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- // <script src="js/behaviour/voice-commands.js"></script> -->
	<script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script>
	<script type="text/javascript"
		src="js/jquery.flot/jquery.flot.resize.js"></script>
	<script type="text/javascript"
		src="js/jquery.flot/jquery.flot.labels.js"></script>
	<!-- google charts -->
	<script type="text/javascript" src="js/ajax/collects_data.js"></script>
	<script type="text/javascript" src="js/jsapi.js"></script>
	<script type="text/javascript" src="js/ajax/jira_status_pie_chart.js"></script>
	<script type="text/javascript" src="js/ajax/commit_trend.js"></script>
	<script type="text/javascript" src="js/ajax/work_burndown.js"></script>
	<script type="text/javascript" src="js/ajax/pull_trend.js"></script>
	<!-- ajax calls -->
	<script type="text/javascript" src="js/ajax/get_commit_trend_data.js"></script>
	<script type="text/javascript" src="js/ajax/get_activity_data.js"></script>
	<script type="text/javascript" src="js/ajax/get_alert_data.js"></script>
</body>
</html>
