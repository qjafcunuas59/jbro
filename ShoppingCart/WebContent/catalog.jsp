<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List,com.hinnoya.shoppingcart.view.home.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<h1>Catalog</h1>
	<table border="1">
		<tr>
			<td>Name</td>
			<td>Price</td>
			<td>Caddie</td>
		</tr>
		<%
			List<Product> products = (List<Product>) request.getAttribute("products");
			for (Product product : products) {
		%>
		<tr>
			<td><%=product.getName()%></td>
			<td><%=product.getPrice()%>€</td>
			<td><a
				href="CatalogController?action=caddie&id=<%=product.getId()%>">Add</a></td>
		</tr>

		<%
			}
		%>

	</table>

</body>
</html>