<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

				<form:form role="form" action="sendActiveMQ.do" method="post"
					commandName="screenView">


					<div class="form-group validation-content">
						<label>Connection Factory</label>
						<form:input class="form-control validate[required]" type="text"
							name="sConnectionFactory" id="sConnectionFactory"
							path="sConnectionFactory" />
						* e.g. - vm://localhost
					</div>
					<div class="form-group validation-content">
						<label>Destination Type</label>
						<form:select class="form-control validate[required]"
							name="sDestinatinType" id="sDestinatinType"
							path="sDestinatinType">
							<form:option value="Queue">Queue</form:option>
							<form:option value="Topic">Topic</form:option>
						</form:select>
					</div>

					<div class="form-group validation-content">
						<label>Destination Name</label>
						<form:input class="form-control validate[required]" type="text"
							name="sSessionQueueName" id="sSessionQueueName"
							path="sSessionQueueName" />

					</div>
<!-- 					<div class="form-group validation-content"> -->
<!-- 						<label>Topic Name</label> -->
<%-- 						<form:input class="form-control validate[required]" type="text" --%>
<%-- 							name="sSessionTopicName" id="sSessionTopicName" --%>
<%-- 							path="sSessionTopicName" /> --%>
<!-- 					</div> -->
					<div class="form-group validation-content">
						<label>XML Message</label>
						<form:textarea class="form-control validate[required]" type="text"
							name="sMessage" id="sMessage" path="sMessage" />
					</div>
					<button type="submit" class="btn btn-primary center-block">Submit</button>
				</form:form>
