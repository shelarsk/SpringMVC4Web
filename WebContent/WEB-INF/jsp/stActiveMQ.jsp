<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<label>Identification Name</label>
		<form:input class="form-control validate[required]" type="text"
			name="sIdentificationName" id="sIdentificationName"
			path="sIdentificationName" />
	</div>
	<div class="form-group validation-content">
		<label>Application Name</label>
		<form:input class="form-control validate[required]" type="text"
			name="sApplicationName" id="sApplicationName"
			path="sApplicationName" />
	</div>
	<div class="form-group validation-content">
		<label>Application NARID </label>
		<form:input class="form-control validate[required]" type="text"
			name="sApplicationNARID" id="sApplicationNARID"
			path="sApplicationNARID" />
	</div>
	
	<div class="form-group validation-content">
		<label>Destination Name</label>
		<form:input class="form-control validate[required]" type="text"
			name="sSessionQueueName" id="sSessionQueueName"
			path="sSessionQueueName" />
	</div>
	<div class="form-group validation-content">
		<label>Service Provider</label>
		<form:select class="form-control validate[required]"
			name="sServiceProvider" id="sServiceProvider" path="sServiceProvider">
			<form:option value="ActiveMQ">Apache ActiveMQ</form:option>
			<form:option value="WebLoagic">Oracle WebLoagic</form:option>
			<form:option value="WebsphereMQ">IBM WebsphereMQ</form:option>
		</form:select>
	</div>
	<div class="form-group validation-content">
		<label>Destination Type</label>
		<form:select class="form-control validate[required]"
			name="sDestinatinType" id="sDestinatinType" path="sDestinatinType">
			<form:option value="Queue">Queue</form:option>
			<form:option value="Topic">Topic</form:option>
		</form:select>
	</div>
	<div class="form-group validation-content">
		<label>Connection Factory</label>
		<form:input class="form-control validate[required]" type="text"
			name="sConnectionFactory" id="sConnectionFactory"
			path="sConnectionFactory" />
		* e.g. - vm://localhost
	</div>

	<div class="form-group validation-content">
		<label>Destination Name</label>
		<form:input class="form-control validate[required]" type="text"
			name="sSessionQueueName" id="sSessionQueueName"
			path="sSessionQueueName" />
	</div>

<!-- 	<div class="form-group validation-content"> -->
		<div class="row">
		<label>Extra Configuration </label> <br>
		<c:forEach items="${screenView.pSubAddributesList}" var="contact"
			varStatus="status">
		
            <div class="form-group col-xs-6">                
                <input id="pSubAddributesList[${status.index}].key" class="form-control input-group-lg reg_name" type="text" name="pSubAddributesList[${status.index}].key" placeholder="Property"/>               
            </div>
              <div class="form-group col-xs-6">                
                <input id="pSubAddributesList[${status.index}].val" class="form-control input-group-lg reg_name" type="text" name="pSubAddributesList[${status.index}].val" placeholder="Value"/>               
            </div>

       
<%-- 				${status.count} --%>
<%-- 				<input name="pSubAddributesList[${status.index}].key" class="form-control validate[required]" type="text" --%>
<%-- 					value="${contact.key}" /> --%>
<%-- 				<input name="pSubAddributesList[${status.index}].val" class="form-control validate[required]" type="text" --%>
<%-- 					value="${contact.val}" />	</br>		 --%>
		
		</c:forEach>
		 </div>

<!-- 	</div> -->


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
