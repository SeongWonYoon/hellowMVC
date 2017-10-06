<%@page isELIgnored="false" %>	

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%-- JSP Expression Language --%>
	<Ul>
		<li>Id : ${customer.id}</li>
		<li>Name : ${customer.name }</li>
		<li>Email : ${customer.email }</li>
	</Ul>

	<%-- JSTL --%>
	<table>
		<c:forEach var="customer" items="${customers}">
		<tr>
			<td> ${customer.id } </td>
			<td> ${customer.name } </td>
			<td> ${customer.email } </td>
		</tr>
		</c:forEach>
	</table>


</body>
</html>