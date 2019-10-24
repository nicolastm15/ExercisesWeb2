<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if (request.getSession().getAttribute("logged") == null){
	request.getRequestDispatcher("form.jsp").forward(request, response);	
};
%>
<div style = "display: flex; justify-content: center; margin-top: 180px;" >
	<form method = "POST" action = "Logout">
		<input type = "number" name = "investimento"/>
		<br>
		<br>
		<input type = "submit" name = "botao" value = "Investir"/>
		<h1>O total investido foi: </h1>
		<br>
		<h2>
			<% if(request.getServletContext().getAttribute("carrinho" + session.getAttribute("logged")) == null){
				request.getServletContext().setAttribute("carrinho" + session.getAttribute("logged"), "");			
			}
			out.println(request.getServletContext().getAttribute("carrinho" + session.getAttribute("logged").toString()).toString());
			%>
		</h2>
		<br>		
		<h1>Seu dinheiro já rendeu: </h1>
		<br>		
		<h2></h2>
		<br>		
		<input type = "submit" name = "botao" value = "Sair"/>
	</form>
</div>
</body>
</html>