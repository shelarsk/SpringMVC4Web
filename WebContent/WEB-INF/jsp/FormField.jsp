<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>InfoDriver - Form Field Setup Screen</h2>

	<form action="saveFormField.do" method="post">
		<input type="hidden" name="id"> <label for="title">Title</label> <input type="text" id="title" name="title" /> <br>
			<label for="summary">Select Form</label> 			
			<select name="formID" id="formID">
			<c:forEach var="dataSR" items="${formList}">
			<option value="${dataSR.title}">${dataSR.title}</option>
			</c:forEach>
			</select>			
			 <br>
			<label for="name">Name</label> <input type="text" id="name" name="name" /> <br>
			<label for="type">Type</label> <input type="text" id="type" name="type" /> <br>
			<label for="placeholder">Place Holders</label> <input type="text" id="placeholder" name="placeholder" /> <br>			
			 <input type="submit"
			value="Submit" />
	</form>

	<table border="1">
		<c:forEach var="dataSR" items="${dataList}">
			<tr>
				<td>${dataSR.formID}</td>	
				<td>${dataSR.name}</td>
				<td>${dataSR.type}</td>
				<td>${dataSR.placeholder}</td>
				<td><input type="button" value="delete"
					onclick="window.location='deleteFormField.do?title=${dataSR.id}'" /></td>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>