<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="br.com.fintech.utils.DateParser" %>

<c:set var="contexto" value="Investimentos"></c:set>

<c:url value="entrada?acao=NovoInvestimento" var="botaoAdicionar"></c:url>
<c:url value="entrada?acao=SelecionaInvestimento&id=" var="botaoEditar"></c:url>
<c:url value="entrada?acao=DeletaInvestimento&id=" var="botaoDeletar"></c:url>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${contexto} - Lista</title>
		<%@ include file="../header.jsp" %>
	</head>

	<body>
		<%@ include file="../menu.jsp" %>
			<div class="container">
				<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Data</th>
		      <th scope="col">Valor</th>
		      <th scope="col">Taxa</th>
		      <th scope="col">Instituição</th>
		      <th scope="col">Tipo</th>
		      <th scope="col">Descrição</th>
		      <th scope="col">Vencimento</th>
		      
		      <th scope="col"><button type="button" class="btn btn-success" onclick="location.href='${botaoAdicionar}'">Adicionar</button></th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${investimentos}" var="investimento">
			  <c:set var="codigoTipo" value="${investimento.tipo.codigo}"></c:set>
			   
			    <tr>
			      <th scope="row">${DateParser.LocalDateToString(investimento.dataInicio, "dd/MM/yyyy")}</th>
			      <td><fmt:formatNumber value="${investimento.valor}" type="currency"/></td>
			      <td><fmt:formatNumber value="${investimento.taxa}" type="percent" maxFractionDigits ="2" /></td>
			      <td>Banco</td>
			      <td>${investimento.tipo.codigo== 3 ? 'Renda fixa' : 'Renda variável'}</td>
			      <td>${investimento.descricao}</td>
			      <td>${(investimento.dataInicio != null) ? DateParser.LocalDateToString(investimento.dataFinal, "dd/MM/yyyy") : null}</td>
			      <td><button type="button" class="btn btn-primary" onclick="location.href='${botaoEditar}${registro.codigo}'">Editar</button>
			      <button type="button" class="btn btn-danger" onclick="location.href='${botaoDeletar}${registro.codigo}'">Deletar</button></td>
			    </tr>
		  </c:forEach>
		  </tbody>
		</table>
			</div>
		<%@ include file="../footer.jsp"%>
	</body>
</html>