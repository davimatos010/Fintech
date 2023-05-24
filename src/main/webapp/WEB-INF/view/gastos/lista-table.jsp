<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="br.com.fintech.utils.DateParser" %>

<c:set var="contexto" value="Gastos"></c:set>
<c:set var="codigoRegistro" value="2"></c:set>

<c:url value="entrada?acao=NovoGasto" var="botaoAdicionar"></c:url>
<c:url value="entrada?acao=SelecionaGasto&id=" var="botaoEditar"></c:url>
<c:url value="entrada?acao=DeletaGasto&id=" var="botaoDeletar"></c:url>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${contexto} - Lista</title>
		<%@ include file="../header.jsp" %>
	</head>

	<body>
		<%@ include file="../registros/comp-lista-table.jsp" %>
	</body>
</html>