<nav class="navbar navbar-expand-lg bg-body-secondary" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">FINTECH</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav mr-auto">
      	<c:choose>
        	<c:when test="${contexto == 'Dashboard'}">
	        	<li class="nav=item">
	      			<a class="nav-link active" aria-current="page" href="entrada?acao=Dashboard">Dashboard</a>
	      		</li>
      		</c:when>
	        <c:otherwise>
	        	<li class="nav=item">
	      			<a class="nav-link" href="entrada?acao=Dashboard">Dashboard</a>
	      		</li>
	        </c:otherwise>
        </c:choose>
        
        <c:choose>
        	<c:when test="${contexto == 'Gastos'}">
	        	<li class="nav=item">
	        		<a class="nav-link active" aria-current="page" href="entrada?acao=ListaGastos">Gastos</a>
	        	</li>
        	</c:when>
        	<c:otherwise>
	        	<li class="nav=item">
	        		<a class="nav-link" href="entrada?acao=ListaGastos">Gastos</a>
	        	</li>
        	</c:otherwise>
        </c:choose>
        
        <c:choose>
        	<c:when test="${contexto == 'Receitas'}">
	        	<li class="nav=item">
	        		<a class="nav-link active" aria-current="page" href="entrada?acao=ListaReceitas">Receitas</a>
	        	</li>
        	</c:when>
        	<c:otherwise>
	        	<li class="nav=item">
	        		<a class="nav-link" href="entrada?acao=ListaReceitas">Receitas</a>
	        	</li>
        	</c:otherwise>
        </c:choose>
        
        <c:choose>
        	<c:when test="${contexto == 'Investimentos'}">
	        	<li class="nav=item">
	        		<a class="nav-link active" aria-current="page" href="entrada?acao=ListaInvestimentos">Investimentos</a>
	        	</li>
        	</c:when>
        	<c:otherwise>
	        	<li class="nav=item">
	        		<a class="nav-link" href="entrada?acao=ListaInvestimentos">Investimentos</a>
	        	</li>
        	</c:otherwise>
        </c:choose>
	        <li class="navbar-text ms-5">
		        	<em> Olá, ${usuarioLogado.nome}!</em>
		    </li>
        </ul>
        <ul class="navbar-nav ms-auto me-2">
	        <li class="nav=item">
	        	<a class="nav-link active" href="entrada?acao=Logout">Sair</a>
	        </li>
        </ul>
      
    </div>
  </div>
</nav>