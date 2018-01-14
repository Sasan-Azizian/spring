<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
	<hr>
		<!-- display user name and role -->
		<p>
		User:<security:authentication property="principal.username"/>
		<br><br>
		Role(s):<security:authentication property="principal.authorities"/>
		</p>
	</hr>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>

</body>

</html>