<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>
	The Student is confirmed: ${student.firstName} ${student.lastName} 
	<br><br>
	You are COuntry: ${student.country}
	<br><br>
	Your Favorite Language is: ${student.favoriteLanguage}
	<br><br>
	OperatingSystem is: 

	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}" >
			<li>${temp}</li>
		</c:forEach>
		
	</ul>

</body>
</html>