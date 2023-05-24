<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.fintech.utils.DateParser" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contexto" value="Gastos"></c:set>
<c:set var="comando" value="Editar"></c:set>
<c:set var="parsedDate" value="${DateParser.LocalDateTimeToString(gasto.dataRegistro, 'yyyy-MM-dd')}"></c:set>

<c:url value="entrada?acao=EditaGasto" var="formAction"></c:url>
<c:url value="entrada?acao=ListaGastos" var="cancelar"></c:url>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@ include file="../header.jsp" %>
		<title>${contexto} - Editar</title>
	</head>
	<body>
		<%@ include file="../registros/comp-registro-form.jsp" %>	
	</body>
</html>