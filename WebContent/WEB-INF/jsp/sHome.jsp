<!DOCTYPE html>

<%@page import="java.util.UUID"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Active MQ send Message</title>

<!-- Bootstrap Core CSS -->
<link href="css/bt/mb/css/bootstrap.min.css" rel="stylesheet">
<link href="css/bt/mb/css/dataTables.bootstrap.css" rel="stylesheet">
<link href="css/bt/mb/css/summernote.css" rel="stylesheet">
<link href="css/bt/mb/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="css/bt/mb/css/bootstrap-datepicker3.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<!--     <link href="css/datatable/demo_page.css" rel="stylesheet" -->
<!-- 	type="text/css" /> -->
<!-- <link href="css/datatable/demo_table_jui.css" rel="stylesheet" -->
<!-- 	type="text/css" /> -->
<!--     <link href="css/bt/mb/css/menu.css" rel="stylesheet"> -->

<!--     <link href="css/blog-home.css" rel="stylesheet"> -->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- jQuery -->
<script src="js/bt/mb/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bt/mb/js/bootstrap.min.js"></script>

<script src="js/bt/mb/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script src="js/bt/mb/js/dataTables.bootstrap.js" type="text/javascript"></script>
<script src="js/bt/mb/js/summernote.min.js" type="text/javascript"></script>
<script src="js/bt/mb/js/bootstrap-datepicker.en-GB.min.js"
	type="text/javascript"></script>
<script src="js/bt/mb/js/bootstrap-datepicker.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		//alert("11111");
		//$('.datepicker').datepicker({})
		//alert(2222);
// 		$('#sMessage').summernote({
// 			height : 200
// 		});

	});
</script>



</head>
<%
String sTabs = (String) request.getAttribute("TABS");
String sPageTitle = (String) request.getAttribute("TITLE");
String sMessage = (String) request.getAttribute("MESSAGE");
String sMessageStatus = (String) request.getAttribute("MESSAGE_STATUS");
if (sTabs == null || sTabs.trim().equals("")) {
	sTabs = "stActiveMQ.jsp";
}
if (sPageTitle == null || sPageTitle.trim().equals("")) {
	sPageTitle = "Send To Active MQ";
}
if (sMessage == null || sMessage.trim().equals("")) {
	sMessage = " ";
}
%>
<body>
<nav class="navbar navbar-default ">
</nav>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img
					src="images/home/logo.png" alt="SEND MESSAGE" height="35"
					width="150" style="top: 0px;">
				</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="showActiveMQ.do">Home</a></li>
					<li><a href="showActiveMQ.do">ActiveMQ</a></li>
					<li><a href="showWLSMessage.do">WebLogic</a></li>
					<li><a href="#pricing">IBM MQ</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container body-content">
	
	
	<div class="row">
		<%
			if (sMessageStatus != null) {
				if (sMessageStatus.equals("SUCCESS")) {
		%>
		<div class="panel panel-success col-md-6">
			<div class="panel-heading">
			<div class="panel-title text-center"><%=sMessage%></div>
			</div>

		</div>
		<%
			} else if (sMessageStatus.equals("FAILED")) {
		%>
		<div class="panel panel-danger col-md-6">
<div class="panel-heading">
			<div class="panel-title text-center"><%=sMessage%></div>
			</div>

		</div>
		<%
			}
			}
		%>

		
	</div>
	
		<div class="row">

			<div class="panel panel-primary col-md-6">
				<div class="panel-heading">
					<div class="panel-title text-center"><%= sPageTitle%></div>
				</div>
				<div class="panel-body ">
					<jsp:include page="<%=sTabs%>" />
				</div>
			</div>

		</div>
	</div>
</body>
</html>