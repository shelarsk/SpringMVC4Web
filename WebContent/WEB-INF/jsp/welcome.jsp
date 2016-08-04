<!DOCTYPE html>

<%@page import="java.util.UUID"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Blog Home - Start Bootstrap Template</title>

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
		$('.datepicker').datepicker({})
		//alert(2222);
		$('#xmlMessage').summernote({
			height : 200
		});

	});
</script>



</head>
<body>
	<div class="container body-content">
		<div class="row">
			<div class="col-lg-6">

				<form role="form">
					<div class="form-group validation-content">
						<label>Name</label> <input value=""
							class="form-control validate[required]" type="text" name="name"
							id="name" /> * e.g. - 3DCash Dev
					</div>
					<div class="form-group validation-content">
						<label>URL</label> <input value=""
							class="form-control validate[required]" type="text" name="url"
							id="url" /> * e.g - t3://xxx:9999
					</div>

					<div class="form-group validation-content">
						<label>Request Queue</label> <input value=""
							class="form-control validate[required]" type="text"
							name="requestQueue" id="name" /> *e.g - GM3DCash.CFMJMSQueue
					</div>

					<div class="form-group validation-content">
						<label>Queue Connection Factory</label> <input value=""
							class="form-control validate[required]" type="text"
							name="queueConnectinFactory" id="name" />
						*GM3DCash.JMSConnectionFactory
					</div>
					<div class="form-group validation-content">
						<label>JNDI Factory</label> <input value=""
							class="form-control validate[required]" type="text"
							name="jndiFactory" id="name" /> *
						weblogic.jndi.WLInitialContextFactory
					</div>
					<div class="form-group validation-content">
						<label>Security Credential</label> <input value=""
							class="form-control validate[required]" type="text"
							name="securityCredential" id=""securityCredential"" /> * eg- 3DCASH_User
					</div>
					<div class="form-group validation-content">
						<label>Security Priciple</label> <input value=""
							class="form-control validate[required]" type="text"
							name="securityPriciple" id="securityPriciple" /> * eg- 3DCASH_User
					</div>
					<div class="form-group validation-content">
						<label>XML Message</label>
						<textarea value="" class="form-control validate[required]"
							name="xmlMessage" id="xmlMessage"></textarea>
					</div>

					<button type="submit" class="btn btn-default">Submit</button>
				</form>

			</div>
		</div>
	</div>
</body>
</html>