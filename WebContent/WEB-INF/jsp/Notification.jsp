<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>InfoDriver - Notification Screen</h2>

	<form action="saveNotification.do" method="post">
		<input type="hidden" name="id"> <label for="title">Title</label> <input type="text" id="title" name="title" /> 
			<label for="summary">Summary</label> <input type="text" id="summary" name="summary" /> 
			<label for="detail">Details</label> <input type="text" id="detail" name="detail" /> <input type="submit"
			value="Submit" />
	</form>

	<table border="1">
		<c:forEach var="dataSR" items="${dataList}">
			<tr>
				<td>${dataSR.title}</td><td>${dataSR.summary}</td><td>${dataSR.detail}</td><td><input type="button" value="delete" onclick="window.location='deleteNotification.do?title=${dataSR.title}'"/></td>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>