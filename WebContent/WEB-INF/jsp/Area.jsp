<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>InfoDriver - Area Configuration Screen</h2>

		<form action="saveArea.do" method="post">
			<input type="hidden" name="id">
			<label for="name">Area Name</label>
			<input type="text" id="name" name="name"/>
			<input type="submit" value="Submit"/>
		</form>

	<table border="1">
		<c:forEach var="dataSR" items="${areaList}">
			<tr>
				<td>${dataSR.name}</td><td><input type="button" value="delete" onclick="window.location='deleteArea.do?name=${dataSR.name}'"/></td>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>