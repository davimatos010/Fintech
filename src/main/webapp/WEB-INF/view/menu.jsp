<nav class="navbar navbar-expand-lg bg-body-secondary" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">FINTECH</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
      	<c:choose>
        	<c:when test="${contexto == 'Dashboard'}">
      			<a class="nav-link active" aria-current="page" href="#">Dashboard</a>
      	</c:when>
        	<c:otherwise>
      			<a class="nav-link" href="#">Dashboard</a>
        	</c:otherwise>
        </c:choose>
        
        <c:choose>
        	<c:when test="${contexto == 'Gastos'}">
        		<a class="nav-link active" aria-current="page" href="entrada?acao=ListaGastos">Gastos</a>
        	</c:when>
        	<c:otherwise>
        		<a class="nav-link" href="entrada?acao=ListaGastos">Gastos</a>
        	</c:otherwise>
        </c:choose>
        
        <c:choose>
        	<c:when test="${contexto == 'Receitas'}">
        		<a class="nav-link active" aria-current="page" href="entrada?acao=ListaReceitas">Receitas</a>
        	</c:when>
        	<c:otherwise>
        		<a class="nav-link" href="entrada?acao=ListaReceitas">Receitas</a>
        	</c:otherwise>
        </c:choose>
        
        <c:choose>
        	<c:when test="${contexto == 'Investimentos'}">
        		<a class="nav-link active" aria-current="page" href="#">Investimentos</a>
        	</c:when>
        	<c:otherwise>
        		<a class="nav-link" href="#">Investimentos</a>
        	</c:otherwise>
        </c:choose>
      </div>
    </div>
  </div>
</nav>