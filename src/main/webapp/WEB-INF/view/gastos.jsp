<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="br.com.fintech.utils.DateParser" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gastos - Lista</title>
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
      <th scope="col"><button type="button" class="btn btn-success" onclick="location.href='entrada?acao=NovoGasto'">Adicionar</button></th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${registros}" var="registro">
	  <c:set var="codigoTipo" value="${registro.tipo.codigo}"></c:set>
	  <c:set var="dataRegistro" value= "${registro.dataRegistro}"></c:set>
	  <c:if test="${codigoTipo == 2}">
	   
	    <tr>
	      <th scope="row">${DateParser.LocalDateTimeToString(dataRegistro, "dd/MM/yyyy")}</th>
	      <td>${registro.categoria}</td>
	      <td>${registro.descricao}</td>
	      <td><fmt:formatNumber value="${registro.valor}" type="currency"/></td>
	      <td><button type="button" class="btn btn-primary" onclick="location.href='entrada?acao=SelecionaGasto&id=${registro.codigo}'">Editar</button>
	      <button type="button" class="btn btn-danger" onclick="location.href='entrada?acao=DeletaGasto&id=${registro.codigo}'">Deletar</button></td>
	    </tr>
	   </c:if> 
  </c:forEach>
  </tbody>
</table>
	</div>
<%@ include file="footer.jsp"%>
</body>
</html>