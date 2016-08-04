<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>InfoDriver - Form Setup Screen</h2>

	<form action="saveForm.do" method="post">
		<input type="hidden" name="id"> <label for="title">Title</label> <input type="text" id="title" name="title" /> <br>
			<label for="summary">Summary</label> <input type="text" id="summary" name="summary" />  <br>
			<label for="detail">Details</label> <input type="text" id="detail" name="detail" /> <br>
			<label for="startDate">Start Date</label> <input type="text" id="startDate" name="startDate" /> <br>
			<label for="endDate">End Date</label> <input type="text" id="endDate" name="endDate" /> <br>
			<label for="requestedBy">Requested By</label> <input type="text" id="requestedBy" name="requestedBy" /> <br>
			<label for="contact">Contact</label> <input type="text" id="contact" name="contact" /> <br>
			 <input type="submit"
			value="Submit" />
	</form>

	<table border="1">
		<c:forEach var="dataSR" items="${dataList}">
			<tr>
				<td>${dataSR.title}</td>	
				<td>${dataSR.summary}</td>
				<td>${dataSR.detail}</td>
				<td>${dataSR.startDate}</td>
				<td>${dataSR.endDate}</td>
				<td>${dataSR.requestedBy}</td>
				<td>${dataSR.contact}</td>
				<td><input type="button" value="delete"
					onclick="window.location='deleteNotification.do?title=${dataSR.title}'" /></td>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>