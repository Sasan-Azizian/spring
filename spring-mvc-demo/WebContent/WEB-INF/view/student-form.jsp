<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>

</head>

<body>
	<form:form action="processForm" modelAttribute="student">
		First Name:<form:input path="firstName"/>
		<br><br>
		Last Name :<form:input path="lastName"/>
		<br><br>
		Country :
		<form:select path="country">
			<form:option value="Brazil" lable="Brazil"></form:option>
			<form:option value="France" lable="France"></form:option>
			<form:option value="Germany" lable="Germany"></form:option>
			<form:option value="India" lable="India"></form:option>
			<form:option value="Iran" lable="Iran"></form:option>
		</form:select>
		<br><br>
		<input type="submit" value="Submit"/>
	</form:form>

</body>
</html>