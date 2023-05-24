		<%@ include file="../menu.jsp" %>
		<div class="container">
			<form action="${formAction}" method="post">
				<div class="form-group">
					<label for="dataRegistro">Data</label>
		    		<input type="date" class="form-control" name="dataRegistro" required value="${(comando == 'Editar') ? parsedDate : ''}">	
		  		</div>
		  		<div class="form-group">
		    		<label for="valor">Valor</label>
		    		<input type="number" class="form-control" name="valor" step="any" value="${(comando == 'Editar') ? registro.valor : ''}" required>
		  		</div>
		  		<c:if test="${contexto == 'Gastos'}">
		  		<div class="form-group">
		    		<label for="categoria">Categoria</label>
		    		<select class="form-control" name="categoria" required>
		      			<option selected="selected">${registro.categoria}</option>
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
		  		</c:if>
		  		<div class="form-group">
		    		<label for="descricao">Descrição</label>
		    		<textarea class="form-control" name="descricao" rows="2">${(comando == 'Editar') ? registro.descricao : ''}</textarea>
					<input type="hidden" name="id" value="${registro.codigo}">
					<input class="btn btn-primary" type="submit" value="${comando}">
					<button type="button" class="btn btn-danger" onclick="location.href='${cancelar}'">Cancelar</button></td>
		  		</div>
			</form>
		</div>
		<%@ include file="../footer.jsp" %>