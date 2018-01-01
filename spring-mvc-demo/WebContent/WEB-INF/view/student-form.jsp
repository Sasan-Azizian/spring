<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>

</head>

<body>
	<form:form action="processForm" modelAttribute="student">
		First Name:<form:input path="firstName"/>
		<br><br>
		Last Name (*):<form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		<br><br>
		Country :
		<form:select path="country">
			<form:options items="${student.countryOptionjs}" />
			
		</form:select>
		<br><br>
		Favorite Language:
			Java <form:radiobutton path="favoriteLanguage" value="Java"/>
			Spring <form:radiobutton path="favoriteLanguage" value="Spring"/>
			J2EE <form:radiobutton path="favoriteLanguage" value="J2EE"/>
			C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		<br><br>
		
		Linux <form:checkbox   path="operatingSystem"  value="Linux"/>	
		Mac Os <form:checkbox  path="operatingSystem"  value="Mac"/>	
		Windows <form:checkbox  path="operatingSystem"  value="Ms Win"/>	
		
		<br><br>
		<input type="submit" value="Submit"/>
	</form:form>

</body>
</html>