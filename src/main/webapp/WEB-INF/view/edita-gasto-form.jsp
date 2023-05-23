<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.fintech.utils.DateParser" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="header.jsp" %>
<title>Gastos - Editar</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="container">
	<form action="entrada?acao=EditaGasto" method="post">
		  <div class="form-group">
		    <label for="dataRegistro">Data</label>
		    <input type="date" class="form-control" name="dataRegistro" value=${DateParser.LocalDateTimeToString(gasto.dataRegistro, "yyyy-MM-dd")} required>
		  </div>
		  <div class="form-group">
		    <label for="valor">Valor</label>
		    <input type="number" class="form-control" name="valor" step="any" value="${gasto.valor}" required>
		  </div>
		  <div class="form-group">
		    <label for="categoria">Categoria</label>
		    <select class="form-control" name="categoria" required>
		      <option selected="selected">${gasto.categoria}</option>
		      <option>Outros</option>
			  <option>Casa</option>
			  <option>Contas</option>
              <option>Estudos</option>
              <option>Mercado</option>
              <option>Refei��o</option>
              <option>Roupas</option>
              <option>Sa�de</option>
              <option>Transporte</option>
              <option>Viagem</option>
		    </select>
		  </div>
		  <div class="form-group">
		    <label for="descricao">Descri��o</label>
		    <textarea class="form-control" name="descricao" rows="2">${gasto.descricao}</textarea>
		<input type="hidden" name="id" value="${gasto.codigo}">
		<input class="btn btn-primary" type="submit" value="Editar">
		<button type="button" class="btn btn-danger" onclick="location.href='entrada?acao=ListaGastos'">Cancelar</button></td>
		  </div>
	</form>
	</div>
	<%@ include file="footer.jsp" %>	
</body>
</html>