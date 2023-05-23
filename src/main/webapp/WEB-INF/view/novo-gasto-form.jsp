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
	<form action="entrada?acao=AdicionaGasto" method="post">
		  <div class="form-group">
		    <label for="dataRegistro">Data</label>
		    <input type="date" class="form-control" name="dataRegistro" value= required>
		  </div>
		  <div class="form-group">
		    <label for="valor">Valor</label>
		    <input type="number" class="form-control" name="valor" step="any" value= required>
		  </div>
		  <div class="form-group">
		    <label for="categoria">Categoria</label>
		    <select class="form-control" name="categoria" required>
		      <option selected="selected"></option>
		      <option>Outros</option>
			  <option>Casa</option>
			  <option>Contas</option>
              <option>Estudos</option>
              <option>Mercado</option>
              <option>Refeição</option>
              <option>Roupas</option>
              <option>Saúde</option>
              <option>Transporte</option>
              <option>Viagem</option>
		    </select>
		  </div>
		  <div class="form-group">
		    <label for="descricao">Descrição</label>
		    <textarea class="form-control" name="descricao" rows="2"></textarea>
		<input class="btn btn-success" type="submit" value="Adicionar">
		<button type="button" class="btn btn-danger" onclick="location.href='entrada?acao=ListaGastos'">Cancelar</button></td>
		  </div>
	</form>
	</div>
	<%@ include file="footer.jsp" %>	
</body>
</html>