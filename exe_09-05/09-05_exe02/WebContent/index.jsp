<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
  </head>
  <body>
    <form action="Serv1" method="POST">
      <input type="submit" />
    </form>
    <br />
    <br />
    <form action="Serv2" method="POST">
      <input type="submit" />
    </form>
    <br />
    <br />
    <form action="Serv3" method="POST">
      <input type="submit" />
    </form>
    <br>
    <br>
    <h1><% 
    	out.println(session.getAttribute("lista").toString());
    	 %>
    </h1>
  </body>
</html>
