<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Login</title>
  </head>
  <body>
  
  <%
  if(session.getAttribute("logged") != null){
	  request.getRequestDispatcher("logado.jsp").forward(request, response);
  }
  
  %>
    <div style = "display: flex; justify-content: center; margin-top: 250px;" >
      <form action="Auth" method="POST">
        <label>Name: </label><input name="nome" type="text" /> 
        <br>
        <br>
        <label>Pass: </label><input name="senha" type="password" />
        <br>
        <br>
        <input type="submit" value="Enviar" />
      </form>
    </div>
  </body>
</html>
