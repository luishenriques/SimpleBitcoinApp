<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Endere�os</title>
<link rel="stylesheet" href="css/simples.css" type="text/css">
</head>
<body>

  <div class="content">

    <table>
      <tr>
        <th>Lista de Endere�os:</th>
      </tr>
      <c:forEach var="e" items="${enderecos}">
        <tr>
          <td>${e}</td>
        </tr>
      </c:forEach>
    </table>

    <form action="novoendereco">
      <input type="submit" value="Criar novo endere�o">
    </form>

    <p>
      <a href="index.html">Voltar</a>
    </p>

  </div>

</body>
</html>