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
	
	<security:authorize access="hasRole('MANAGER')">
	
	<!-- Add a link to point to/leader..this is for manager -->	
	<p>
		<a href="${pageContext.request.contextPath}/leaders"> LeaderShip Meeting</a>
			(only for Manager peeps)
	</p>
	</security:authorize>
	<hr>
	
	<security:authorize access="hasRole('ADMIN')">
	
		<!-- display user name and role -->
	
	<!-- Add a link to point to/Admin..this is for Admin -->
	<p>
		<a href="${pageContext.request.contextPath}/systems"> ItSYSTEM MEETING</a>
			(only for Admin peeps)
	</p>
	
	</security:authorize>
	<hr>
	<hr>
		
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