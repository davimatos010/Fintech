<%@ include file="../menu.jsp" %>
		<div class="container">
			<form action="${formAction}" method="post">
				<div class="form-group">
					<label for="dataInicio">Data</label>
		    		<input type="date" class="form-control" name="dataInicio" required value="${(comando == 'Editar') ? parsedDataInicio : ''}">	
		  		</div>
		  		<div class="form-group">
		    		<label for="valor">Valor</label>
		    		<input type="number" class="form-control" name="valor" step="any" value="${(comando == 'Editar') ? investimento.valor : ''}" required>
		  		</div>
		  		<div class="form-group">
		  			<label for="taxa">Taxa</label>
		  			<input type="number" class="form-control" name="taxa" step="any" value="${(comando == 'Editar') ? investimento.taxa : ''}">
		  		</div>
		  		<div class="form-group">
		  			<label for="instituicaoFinanceira">Instituição Financeira</label>
		  			<input type="text" class="form-control" name="instituicaoFinanceira" value="${(comando == 'Editar') ? investimento.instituicaoFinanceira : ''}">
		  		</div>
		  		<div class="form-group">
		  			<label for="tipo">Tipo</label>
		  			<select class="form-control" name="tipo" required>
		  				<option selected="selected">${investimento.tipo.nome}</option>
		  				<option>Renda Fixa</option>
		  				<option>Renda Variável</option>
		  			</select>
		  		</div>
		  		<div class="form-group">
		  			<label for="descricao">Descrição</label>
		  			<input type="text" class="form-control" name="descricao" value="${(comando == 'Editar') ? investimento.descricao : ''}"></select>
		  		</div>
		  		<div class="form-group">
		  			<label for="dataFinal">Vencimento</label>
		  			<input type="date" class="form-control" name="dataFinal" value="${(comando == 'Editar') ? parsedDataFinal : ''}">
		  			<input type="hidden" name="id" value="${investimento.codigo}">
					<input class="btn btn-primary" type="submit" value="${comando}">
					<button type="button" class="btn btn-danger" onclick="location.href='${cancelar}'">Cancelar</button>
		  		</div>
			</form>
		</div>
		<%@ include file="../footer.jsp" %>