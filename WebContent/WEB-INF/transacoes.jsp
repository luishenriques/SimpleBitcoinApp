<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Endereços</title>
<link rel="stylesheet" href="css/simples.css" type="text/css">
</head>
<body>

  <div class="content">
    
    <table>
      <tr>
        <th colspan="4">Lista de Transações</th>
      </tr>
      <tr>
        <th>Data</th><th>Endereço</th><th>Valor</th><th>Confirmações</th>
      </tr>
      <c:forEach var="e" items="${transacoes}">
        <tr>
          <td>${e.data}</td><td>${e.endereco}</td><td>${e.valor}</td><td>${e.confirmacoes}</td>
        </tr>
      </c:forEach>
    </table>
  <p>
    <a href="index.html">Voltar</a>
  </p>
</div>
</body>
</html>