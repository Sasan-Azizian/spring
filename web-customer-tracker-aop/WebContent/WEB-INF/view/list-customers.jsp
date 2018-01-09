<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Customers</title>

<!-- reference our style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	

	<div id="wrapper">
		<div id="header">
			<h2>CRM - CUsrome Relationship MAnager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- add buttom custome -->
			<input type="button" value="Add Customer"  
					onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"
			/>
			
			<!-- Add search box -->
			<form:form action="search" method="POST">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
            
            
			
		<!-- add html table here.. -->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			
			<!-- loop over print our customer -->
			<c:forEach var="tempCustomer" items="${customers}">
				
				<!-- constract and "update" link with customer id -->
				<c:url var="updateLink" value="/cust/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				
				<!-- constract and "DELETE" link with customer id -->
				<c:url var="deleteLink" value="/cust/delete">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
			
				<tr>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
					<td>
						<!-- display the update link -->
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
								 onclick="if(!(confirm('Are you sure for deleting this customer?'))) return false">Delete</a>
						
					</td>
					
				</tr>
			</c:forEach>
		 </table>
		</div>
	</div>
</body>
</html>