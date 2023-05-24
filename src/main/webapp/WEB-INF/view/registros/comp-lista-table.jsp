<body>
<%@ include file="../menu.jsp" %>
	<div class="container">
		<table class="table">
  <thead>
    <tr>
      <th scope="col">Data</th>
      <th scope="col">Categoria</th>
      <c:if test="${contexto == 'Gastos'}">
      <th scope="col">Descrição</th>
      </c:if>
      <th scope="col">Valor</th>
      <th scope="col"><button type="button" class="btn btn-success" onclick="location.href='${botaoAdicionar}'">Adicionar</button></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${registros}" var="registro">
	  <c:set var="codigoTipo" value="${registro.tipo.codigo}"></c:set>
	  <c:set var="dataRegistro" value= "${registro.dataRegistro}"></c:set>
	  <c:if test="${codigoTipo == codigoRegistro}">
	   
	    <tr>
	      <th scope="row">${DateParser.LocalDateTimeToString(dataRegistro, "dd/MM/yyyy")}</th>
	      <td>${registro.categoria}</td>
	      <c:if test="${contexto == 'Gastos'}">
	      <td>${registro.descricao}</td>
	      </c:if>
	      <td><fmt:formatNumber value="${registro.valor}" type="currency"/></td>
	      <td><button type="button" class="btn btn-primary" onclick="location.href='${botaoEditar}${registro.codigo}'">Editar</button>
	      <button type="button" class="btn btn-danger" onclick="location.href='${botaoDeletar}${registro.codigo}'">Deletar</button></td>
	    </tr>
	   </c:if> 
  </c:forEach>
  </tbody>
</table>
	</div>
<%@ include file="../footer.jsp"%>