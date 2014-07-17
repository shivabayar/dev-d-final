<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="images/favicon.png">

  <title>Dev-D</title>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,400italic,700,800' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Raleway:300,200,100' rel='stylesheet' type='text/css'>

  <!-- Bootstrap core CSS -->
  <link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="js/jquery.gritter/css/jquery.gritter.css" />

	<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <![endif]-->
  <link rel="stylesheet" type="text/css" href="js/jquery.nanoscroller/nanoscroller.css" />
  <link rel="stylesheet" type="text/css" href="js/jquery.easypiechart/jquery.easy-pie-chart.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery.select2/select2.css" />
  <link rel="stylesheet" type="text/css" href="js/bootstrap.slider/css/slider.css" />
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />	
	// <!-- <script type="text/javascript" src="https://www.google.com/jsapi"></script>
	// <script type="text/javascript" src="js/jira_status_pie_chart.js"></script>
	// <script type="text/javascript" src="js/commit_trend.js"></script>
	// <script type="text/javascript" src="js/work_burndown.js"></script>
	// <script type="text/javascript" src="js/pull_request.js"></script>
 //  <script type="text/javascript" src="js/ajax/get_commit_trend_data.js"></script>
 //  <script type="text/javascript" src="js/ajax/get_alert_data.js"></script> -->
  </head>
  </head>

  <body>

  <!-- Fixed navbar -->
  <div id="head-nav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="fa fa-gear"></span>
        </button>
        <a  class="navbar-brand"  href="#"><span>Dev-D</span></a>
      </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#about">About</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Contact <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
      <li class="dropdown-submenu"><a href="#">Sub menu</a>
        <ul class="dropdown-menu">
          <li><a href="#">Action</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          </ul>
      </li>              
      </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Large menu <b class="caret"></b></a>
      <ul class="dropdown-menu col-menu-2">
        <li class="col-sm-6 no-padding">
          <ul>
          <li class="dropdown-header"><i class="fa fa-group"></i>Users</li>
          <li><a href="#">Action</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          <li class="dropdown-header"><i class="fa fa-gear"></i>Config</li>
          <li><a href="#">Action</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li> 
          </ul>
        </li>
        <li  class="col-sm-6 no-padding">
          <ul>
          <li class="dropdown-header"><i class="fa fa-legal"></i>Sales</li>
          <li><a href="#">New sale</a></li>
          <li><a href="#">Register a product</a></li>
          <li><a href="#">Register a client</a></li> 
          <li><a href="#">Month sales</a></li>
          <li><a href="#">Delivered orders</a></li>
          </ul>
        </li>
      </ul>
          </li>
        </ul>
    <ul class="nav navbar-nav navbar-right user-nav">
      <li class="dropdown profile_menu">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img alt="Avatar" src="images/avatar2.jpg" />Jeff Hanneman <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">My Account</a></li>
          <li><a href="#">Profile</a></li>
          <li><a href="#">Messages</a></li>
          <li class="divider"></li>
          <li><a href="#">Sign Out</a></li>
        </ul>
      </li>
    </ul>			
    <ul class="nav navbar-nav navbar-right not-nav">
      <li class="button dropdown">
        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class=" fa fa-comments"></i></a>
        <ul class="dropdown-menu messages">
          <li>
            <div class="nano nscroller">
              <div class="content">
                <ul>
                  <li>
                    <a href="#">
                      <img src="images/avatar2.jpg" alt="avatar" /><span class="date pull-right">13 Sept.</span> <span class="name">Daniel</span> I'm following you, and I want your money! 
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <img src="images/avatar_50.jpg" alt="avatar" /><span class="date pull-right">20 Oct.</span><span class="name">Adam</span> is now following you 
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <img src="images/avatar4_50.jpg" alt="avatar" /><span class="date pull-right">2 Nov.</span><span class="name">Michael</span> is now following you 
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <img src="images/avatar3_50.jpg" alt="avatar" /><span class="date pull-right">2 Nov.</span><span class="name">Lucy</span> is now following you 
                    </a>
                  </li>
                </ul>
              </div>
            </div>
            <ul class="foot"><li><a href="#">View all messages </a></li></ul>           
          </li>
        </ul>
      </li>
      <li class="button dropdown">
        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-globe"></i><span class="bubble">2</span></a>
        <ul class="dropdown-menu">
          <li>
            <div class="nano nscroller">
              <div class="content">
                <ul>
                  <li><a href="#"><i class="fa fa-cloud-upload info"></i><b>Daniel</b> is now following you <span class="date">2 minutes ago.</span></a></li>
                  <li><a href="#"><i class="fa fa-male success"></i> <b>Michael</b> is now following you <span class="date">15 minutes ago.</span></a></li>
                  <li><a href="#"><i class="fa fa-bug warning"></i> <b>Mia</b> commented on post <span class="date">30 minutes ago.</span></a></li>
                  <li><a href="#"><i class="fa fa-credit-card danger"></i> <b>Andrew</b> killed someone <span class="date">1 hour ago.</span></a></li>
                </ul>
              </div>
            </div>
            <ul class="foot"><li><a href="#">View all activity </a></li></ul>           
          </li>
        </ul>
      </li>
      <li class="button"><a href="javascript:;" class="speech-button"><i class="fa fa-microphone"></i></a></li>				
    </ul>

      </div><!--/.nav-collapse -->
    </div>
  </div>

		<div id="cl-wrapper">
		<div class="cl-sidebar">
			<div class="cl-toggle">
        <i class="fa fa-bars"></i>
      </div>
			<div class="cl-navblock">
        <div class="menu-space">
          <div class="content">
            <div class="side-user">
              <div class="avatar"><img src="images/avatar1_50.jpg" alt="Avatar" /></div>
              <div class="info">
                <a href="#">Shivraj</a>
                <img src="images/state_online.png" alt="Status" /> <span>Online</span>
              </div>
            </div>
            <div class="header" style="margin-left:20px;">
              <h3>Alerts</h3>
            </div>
            <div style="margin-left:20px;" id="alerts-info"> <!--alerts div for displaying alert-->
              
            </div>
            <div style="margin-left:20px;" class="header">
              <h3>Activity</h3>
            </div>
            <div style="margin-left:20px;" id="activity-info"> <!--alerts div for displaying alert-->
              
              
            </div>
          </div>
        </div>
        <div class="text-right collapse-button" style="padding:7px 9px;">
          <input type="text" class="form-control search" placeholder="Search..." />
          <button id="sidebar-collapse" class="btn btn-default" style=""><i style="color:#fff;" class="fa fa-angle-left"></i></button>
        </div>
			</div>
		</div>
		
		<div class="container-fluid" id="pcont">
			<div class="page-head">
				<h2>Charts</h2>
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li><a href="#">Charts</a></li>
				  <li class="active">General</li>
				</ol>
			</div>		
		<div class="cl-mcont">
			<div class="row">
				<div class="col-sm-6 col-md-6">
					<div class="block-flat">
						<div class="header">
							<h3>Git Commit Trend</h3>
						</div>
						<!-- <div class="content">
							<div id="site_statistics" style="height: 180px; padding: 0px; position: relative;"></div>
						</div> -->
						 <div id="commit_trend" style="width: 450px; height: 300px;"></div>
					</div>
				
					<div class="block-flat">
						<div class="header">
							<h3>JIRA Task Status</h3>
						</div>
						<!-- <div class="content overflow-hidden">
							<div id="piec" style="height: 300px; padding: 0px; position: relative;">
							</div>
						</div> -->
						<div id="jira_status_pie_chart" style="width: 450px; height: 300px;"></div>
					</div>
				</div>
				
				<div class="col-sm-6 col-md-6">

					<div class="block-flat">
						<div class="header">							
							<h3>Bar Chart</h3>
						</div>
						<!-- <div class="content">
							<div id="site_statistics2" style="height: 180px; padding: 0px; position: relative;"></div>							
						</div> -->
						<div id="pull_request" style="width: 450px; height: 300px;"></div>
					</div>

					<div class="block-flat">
						<div class="header">							
							<h3>Work Burn-down chart</h3>
						</div>
						<!-- <div class="content full-width">
							<div id="chart3-legend" class="legend-container"></div>
							<div id="chart3" style="height: 260px;"></div>							
						</div> -->
						<div id="work_burndown" style="width: 450px; height: 300px;"></div>
					</div>
				</div>			
			</div>
		 </div>
		</div> 
		
	</div>

  <script src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="js/behaviour/general.js"></script>
  <script src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
  <script src="js/jquery.select2/select2.min.js" type="text/javascript"></script>
  <script src="js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.gritter/js/jquery.gritter.js"></script>

    <script type="text/javascript">
      $(document).ready(function(){
        //initialize the javascript
        App.init();
        App.charts();
      });
    </script>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
      <!-- // <script src="js/behaviour/voice-commands.js"></script> -->
  <script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.resize.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.labels.js"></script>
  <!-- google charts -->
  <script type="text/javascript" src="https://www.google.com/jsapi"></script>
  <script type="text/javascript" src="js/jira_status_pie_chart.js"></script>
  <script type="text/javascript" src="js/commit_trend.js"></script>
  <script type="text/javascript" src="js/work_burndown.js"></script>
  <script type="text/javascript" src="js/pull_request.js"></script>
  <!-- ajax calls -->
  <script type="text/javascript" src="js/ajax/get_commit_trend_data.js"></script>
  <script type="text/javascript" src="js/ajax/get_alert_data.js"></script>
  <script type="text/javascript" src="js/ajax/get_activity_data.js"></script>
  </body>
</html>
