<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="sbAdmin/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="sbAdmin/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="sbAdmin/dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="sbAdmin/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="sbAdmin/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="sbAdmin/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
     <!-- Custom Datatable -->
     <link href="css/bt/mb/css/dataTables.bootstrap.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    <!-- jQuery -->
    <script src="sbAdmin/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="sbAdmin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="sbAdmin/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="sbAdmin/bower_components/raphael/raphael-min.js"></script>
    <script src="sbAdmin/bower_components/morrisjs/morris.min.js"></script>
<!--     <script src="sbAdmin/js/morris-data.js"></script> -->

    <!-- Custom Theme JavaScript -->
    <script src="sbAdmin/dist/js/sb-admin-2.js"></script>
    
     <!-- Custom Datatable -->
     
     <script src="js/bt/mb/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
	

</head>
<%

String jspMenuPath = (String) request.getAttribute("JSP_MENU_PATH");

if (jspMenuPath == null || jspMenuPath.trim().equals(""))
	jspMenuPath = "BSMenu.jsp";
	
String jspPath = (String) request.getAttribute("JSP_PATH");

	if (jspPath == null || jspPath.trim().equals(""))
		jspPath = "dashboard.jsp";

%>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
       	 <!-- HEADER : START -->       
           <jsp:include page="BSheader.jsp" />
            <!-- /.navbar-header -->            
 		 <!-- HEADER : END -->   
 		  <!-- MENU : START -->       
            <jsp:include page="<%=jspMenuPath%>" />
             <!-- MENU : END -->  
        </nav>

        <div id="page-wrapper">          
           <!--  MAIN PAGE - START -->
           
         <jsp:include page="<%=jspPath%>" />
            
            <!--  MAIN PAGE - END -->
            
        </div>
        <!-- /#page-wrapper -->
         <!--  MODAL INCLUDE - START -->
 		<jsp:include page="BSModal.jsp" />
 		<!--  MODAL INCLUDE - END -->
    </div>
    <!-- /#wrapper -->

    
    
    <script type="text/javascript">
	var mainTable;

	$(document)
			.ready(
					function() {
						
						alert("sjgdksahfkahdkashdkashdakh");

						var startIndex = 0;
						var endIndex = 0;
						var totRec = 0;

						if (document.getElementById("hidstart") != null)
							startIndex = document.getElementById("hidstart").value;
						if (document.getElementById("hidend") != null)
							endIndex = document.getElementById("hidend").value;
						if (document.getElementById("hidtot") != null)
							totRec = document.getElementById("hidtot").value;

						var displayInfo = "Showing " + startIndex + " to "
								+ endIndex + " of " + totRec + " entries";

						if (startIndex == 0 || endIndex == 0 || totRec == 0)
							displayInfo = "Showing _START_ to _END_ of _TOTAL_ entries";

						$("#companies").dataTable({
							"sPaginationType" : "full_numbers",
							"bJQueryUI" : true,
							"oLanguage" : {
								"sInfo" : displayInfo
							}
						});

// 						$(this).rightClick(function(e) {
// 							//alert("Sorry, you do not have permission to right click on this page.");
// 							return false;
// 						});

						//tooltip

						var changeTooltipPosition = function(event) {
							var tooltipX = event.pageX - 8;
							var tooltipY = event.pageY + 8;
							$('div.tooltip').css({
								top : tooltipY,
								left : tooltipX
							});
						};

						var showTooltip = function(event) {
							//var tooltipVal = $('#divtooltip').text();		
							//$('div.tooltip').remove();
							//$('<div id="divtooltip" class="tooltip"><p>' + tooltipVal + '</p></div>').appendTo('body');		
							changeTooltipPosition(event);
						};

						var hideTooltip = function() {
							$('div.tooltip').remove();
						};

						$("span#hint,#companies").bind({
							mousemove : changeTooltipPosition,
							mouseenter : showTooltip,
							mouseleave : hideTooltip
						});

						$("span#hint,#" + "jsonDataTable").bind({
			   mousemove : changeTooltipPosition,
			   mouseenter : showTooltip,
			   mouseleave: hideTooltip
		});		
		
	});
	
	function validateTableNextPrevSetSubmit(ahref)
	{	
		
		var cName = ahref.className;
		
		if (cName.indexOf('ui-state-disabled') > 0)
			return false;
		
		if (document.getElementById('form') != null)
		{			
			if (document.getElementById('hidaction') != null)
				document.getElementById('hidaction').value = ahref.id;
					
			$(("#"+ahref.id)).prop("disabled", true).addClass("ui-state-disabled");				
			
			if (getPopupRecordUpdate() == null)
			{
				(document.getElementById('form')).submit();
				return true;
			}
			
			buildDataTable(ahref.id);
			return true;
		}
	}	
	
	function setToolTipValue(ttval)
	{	
		$('div.tooltip').remove();
		$('<div id="divtooltip" class="tooltip"><p>' + formatText(ttval) + '</p></div>').appendTo('body');	
	}
	
	function formatText(sText)
	{

		sText = $.trim(sText);
		var character = '';
		var result = '';

		for ( var i = 0; i < sText.length; i++) {

			character = sText.charAt(i);

			if (character == '&')
				result = result + '&amp;';
			else if (character == '<')
				result = result + '&lt;';
			else if (character == '>')
				result = result + '&gt;';
			else if (character == '\"')
				result = result + '&quot;';
			else if (character == '\'')
				result = result + '&#039;';
			else
				result = result + character;
		}
		return result;
	}
	
	function buildDataTable(action)
	{
		alert("inside buildDataTable");
		alert(dataURL);
		var ajaxSource = getDataTableURL(dataURL, action);		
		alert("ajaxSource "+ajaxSource);
		/*$.post(indexSource, {}, function(data) {

			var indexData = JSON.parse(data);
			setDataTableIndex(indexData);

		});*/

		if (action != null && mainTable != null) {			
			mainTable.fnDestroy();
			mainTable = null;			
		}	

		$('#jsonDataTable').DataTable( {
	        "processing": true,
	        "serverSide": true,
	        "ajax": {
	            "url": ajaxSource,
	            "type": "POST"
	        }
// 		,
// 	        "columns": [
// 	            { "data": "first_name" },
// 	            { "data": "last_name" },
// 	            { "data": "position" },
// 	            { "data": "office" },
// 	            { "data": "start_date" },
// 	            { "data": "salary" }
// 	        ]
	    } );
// 		mainTable =  $('#jsonDataTable').DataTable( {
// 	        "processing": true,
// 	        "serverSide": true,
// 	        "ajax": ajaxSource
// 	    } );
			
			
// 			$("#" + "jsonDataTable").dataTable({
// 			"sPaginationType" : "full_numbers",
// 			"bJQueryUI" : true,		
// 			"ajax": ajaxSource,
//             "sAjaxSource": ajaxSource,
//             "sServerMethod" : "POST"	
// 		});
		
	}
	
	function getDataTableURL(url, action)
	{
		var startIndex = 0;
		var endIndex = 0;
		var totRec = 0;
		
		if(document.getElementById("hidstart") != null)
			startIndex = document.getElementById("hidstart").value;
		if(document.getElementById("hidend") != null)
			endIndex = document.getElementById("hidend").value;
		if(document.getElementById("hidtot") != null)
			totRec = document.getElementById("hidtot").value;
		
		var dtURL = (url + "?hidstart=" + startIndex + "&hidend=" + endIndex + "&hidtot=" + totRec);
		
		if (action != null && action != "refresh")
		{
			dtURL = dtURL + "&hidaction=" + action
		}
		
		return dtURL; 	
	}
	
   function sleep(sec)
   {	  
	  var i = 0;
	  var curr = new Date();            	              	  
 	  var end = new Date(curr.getFullYear(), curr.getMonth(), curr.getDate(), curr.getHours(), curr.getMinutes(), (curr.getSeconds() + sec));
 	  while (new Date() < end) { i++; }
 	  
 	  if (i == 0 && sec >= 1)
 		  sleep(sec);
   }
   
   function setPopupRecordUpdateToDefault()
   {
	   if (document.getElementById("hidPopupUpdate") != null)
	   {
		   document.getElementById("hidPopupUpdate").value = 'false';
	   }
   }
   
   function getPopupRecordUpdate()
   {
	   if (document.getElementById("hidPopupUpdate") != null)
	   {
		   return document.getElementById("hidPopupUpdate").value;
	   }
	   
	   return null;
   }
   
   function setScreenComboBoxData(url, comboBoxObject, keyColumnIndex, valueColumnIndex)
	{
		 $(".someSpinnerImage").show();
	        $.getJSON(url, function(options) {
	        	$(".someSpinnerImage").hide();
	            var dropdown2 = comboBoxObject;
	            $('>option', dropdown2).remove(); // Clean old options first.
	            if (options) {	           
	            	$.each(options.output, function( i, outputArray ) {
	            		dropdown2.append($('<option/>').val(outputArray[keyColumnIndex]).text(outputArray[valueColumnIndex]));
	                });
	            } else {
	                dropdown2.append($('<option/>').val("Select").text("Please Select"));
	            }
	        });
	}
	
</script>

</body>

</html>
