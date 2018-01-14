<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>D3 Company Home Page</h2>
	<hr>
	<p>
	Welcome to the D3 company home page-yohooooooo!
	</p>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>

</body>

</html>