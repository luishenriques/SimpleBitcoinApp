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
        <th>Lista de Endereços:</th>
      </tr>
    </table>

    <p>
    <form action="enviar">
      Endereço: <input type="Text" value="Endereço"> Valor: <input type="Text" value="valor"> <input type="submit" value="enviar">
    </form>

    <a href="index.html">Voltar</a>

  </div>

</body>
</html>