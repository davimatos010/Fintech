<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.fintech.utils.DateParser" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contexto" value="Investimentos"></c:set>
<c:set var="comando" value="Editar"></c:set>
<c:set var="parsedDataInicio" value="${DateParser.LocalDateToString(investimento.dataInicio, 'yyyy-MM-dd')}"></c:set>
<c:set var="parsedDataFinal" value="${DateParser.LocalDateToString(investimento.dataFinal, 'yyyy-MM-dd')}"></c:set>

<c:url value="entrada?acao=EditaInvestimento" var="formAction"></c:url>
<c:url value="entrada?acao=ListaInvestimentos" var="cancelar"></c:url>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@ include file="../header.jsp" %>
		<title>Editar - Investimento</title>
	</head>
	<body>
		<%@ include file="../registros/comp-investimento-form.jsp" %>
	</body>
</html>