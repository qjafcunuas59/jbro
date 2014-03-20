<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List,com.hinnoya.shoppingcart.view.home.Product,com.hinnoya.shoppingcart.view.home.Caddie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<h1>Caddie</h1>
	<table border="1">
		<tr>
			<td>Name</td>
			<td>Price</td>
			<td>Remove</td>
		</tr>
		<%
			Caddie cad = (Caddie) session.getAttribute("caddie");
		        if (cad == null) {
		        	cad = new Caddie();
		        }
		        for (Product product : cad.getProducts()) {
		%>
		<tr>
			<td><%=product.getName()%></td>
			<td><%=product.getPrice()%>€</td>
			<td><a
				href="CaddieController?action=remove&id=<%=product.getId()%>">Remove</a></td>
		</tr>

		<%
			}
		%>
		<tr>
			<td>TOTAL</td>
			<td colspan="2"><%=cad.getPrice()%>€</td>

		</tr>

	</table>

	<jsp:useBean id="caddie" scope="session"
		class="com.hinnoya.shoppingcart.view.home.Caddie"></jsp:useBean>
	<jsp:getProperty property="price" name="caddie" />

</body>
</html>