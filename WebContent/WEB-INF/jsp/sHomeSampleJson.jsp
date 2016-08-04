<%@page import="com.gk.util.UIConstants"%>
<%@page import="com.gk.util.RequestConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<head>
<title>Sample Home</title>

<script type="text/javascript">

alert(1);
var dataURL = "<%=RequestConstants.RM_JSON_PREFIX%>" + "<%=RequestConstants.RM_JSON_DT_RECORD_SAMPLE%>";
alert(2);

$(document).ready(function() {
	alert(3);
	
	buildDataTable(null);	
});		
	
</script>
</head>
<%
	Long iStartIndex = (Long) request
			.getAttribute(RequestConstants.RA_KEY_DT_START_INDEX);
	Long iEndIndex = (Long) request
			.getAttribute(RequestConstants.RA_KEY_DT_END_INDEX);
	Long iTotalRecords = (Long) request
			.getAttribute(RequestConstants.RA_KEY_DT_TOTAL_COUNT);

	if (iStartIndex == null)
		iStartIndex = new Long(0);
	if (iEndIndex == null)
		iEndIndex = new Long(0);
	if (iTotalRecords == null)
		iTotalRecords = new Long(0);

	System.out.println("StartIndex JSP:" + iStartIndex);
	System.out.println("StartIndex JSP:" + iEndIndex);
	System.out.println("totalRecords :" + iTotalRecords);
%>

<body>


	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Sample Home</h3>
			<div class="btn-group pull-right">


				<a class="modalButton btn-sm btn-default pull-right"
					data-toggle="modal"
					data-src="<%=RequestConstants.RA_SAMPLE_ACTION_ADD%>"
					data-height=500 data-width=800 data-target="#showPopUpReload"
					data-lable="New" data-Act="showPopUpReload">New </a>

			</div>

		</div>
		<div class="panel-body">
			<form:form name="<%=UIConstants.DT_FORM_ID%>"
				id="<%=UIConstants.DT_FORM_ID%>" method="post" commandName=""
				action="">

				<input type="hidden" name="<%=RequestConstants.RP_DT_HID_START_ID%>"
					id="<%=RequestConstants.RP_DT_HID_START_ID%>"
					value="<%=iStartIndex.longValue()%>">
				<input type="hidden" name="<%=RequestConstants.RP_DT_HID_END_ID%>"
					id="<%=RequestConstants.RP_DT_HID_END_ID%>"
					value="<%=iEndIndex.longValue()%>">
				<input type="hidden" name="<%=RequestConstants.RP_DT_HID_TOTAL_ID%>"
					id="<%=RequestConstants.RP_DT_HID_TOTAL_ID%>"
					value="<%=iTotalRecords.longValue()%>">
				<input type="hidden"
					name="<%=RequestConstants.RP_DT_HID_ACTION_ID%>"
					id="<%=RequestConstants.RP_DT_HID_ACTION_ID%>">
				<input type="hidden" name="<%=RequestConstants.RP_DT_HID_HREF_ID%>"
					id="<%=RequestConstants.RP_DT_HID_HREF_ID%>">
				<div id="<%=UIConstants.DT_DIV_ID%>">
					<div class="table-responsive">
							<!--  DATA TABLE CODE START -->
						<table id="<%=UIConstants.DT_TABLE_ID%>"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th
										style="background-color: #337AB7 !important; color: white !important;">Sr
										No</th>
									<th
										style="background-color: #337AB7 !important; color: white !important;">Code</th>
									<th
										style="background-color: #337AB7 !important; color: white !important;">Name</th>
									<th
										style="background-color: #337AB7 !important; color: white !important;">Mobile</th>
									<th
										style="background-color: #337AB7 !important; color: white !important;">View</th>

								</tr>
							</thead>							
						</table>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	</body>