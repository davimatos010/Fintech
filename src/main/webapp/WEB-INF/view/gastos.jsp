<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fintech - Gastos</title>
</head>
<body>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
	<div class="container">
		<table class="table">
  <thead>
    <tr>
      <th scope="col">Data</th>
      <th scope="col">Categoria</th>
      <th scope="col">Descrição</th>
      <th scope="col">Valor</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${registros}" var="registro">
	  <c:set var="codigoTipo" value="${registro.tipo.codigo}"></c:set>
	  <c:if test="${codigoTipo == 2}">
	   
	    <tr>
	      <th scope="row"><fmt:formatDate value="${registro.dataRegistro}" pattern="dd/MM/yyyy"/></th>
	      <td>${registro.categoria}</td>
	      <td>${registro.descricao}</td>
	      <td><fmt:formatNumber value="${registro.valor}" type="currency"/></td>
	    </tr>
	   </c:if> 
  </c:forEach>
  </tbody>
</table>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>