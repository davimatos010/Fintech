<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contexto" value="Dashboard"></c:set>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="br.com.fintech.utils.DateParser" %>
<!DOCTYPE html>
<html>
<!-- Montserrat Font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

<!-- Material Icons -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
<link rel="stylesheet" href="resources/css/homeStyle.css">
	<head>
		<meta charset="ISO-8859-1">
		<title>Fintech  - ${contexto}</title>
		<%@ include file="../header.jsp" %>
	</head>
	<body>
	<%@ include file="../menu.jsp" %>
	
      <!-- Header -->
      <header class="header">

      </header>
      <!-- End Header -->

      <!-- Main -->
      <main class="main-container">
        <div class="main-title">
          <h2>INÍCIO</h2>
        </div>

        <div class="main-cards">

          <div class="card">
            <div class="card-inner">
              <h4>ULTIMO GASTO</h4>
              <span class="material-icons-outlined">currency_exchange</span>
            </div>
            <h3>${DateParser.LocalDateTimeToString(dashboard.ultimoGasto.dataRegistro, "dd/MM/yyyy")}</h3>
            <h1><fmt:formatNumber value="${dashboard.ultimoGasto.valor}" type="currency" /></h1>
          </div>

          <div class="card">
            <div class="card-inner">
              <h4>ULTIMO RECEBIMENTO</h4>
              <span class="material-icons-outlined">wallet</span>
            </div>
            <h3>${DateParser.LocalDateTimeToString(dashboard.ultimoRecebimento.dataRegistro, "dd/MM/yyyy")}</h3>
            <h1><fmt:formatNumber value="${dashboard.ultimoRecebimento.valor}" type="currency"/></h1>
          </div>

          <div class="card">
            <div class="card-inner">
              <h4>MEU SALDO</h4>
              <span class="material-icons-outlined">savings</span>
            </div>
            <h1><fmt:formatNumber value="${dashboard.saldo}" type="currency"/></h1>
          </div>

          <div class="card">
            <div class="card-inner">
              <h4>INVESTIMENTOS</h4>
              <span class="material-icons-outlined">fact_check</span>
            </div>
            <h1><fmt:formatNumber value="${dashboard.somaInvestimentos}" type="currency"/></h1>
          </div>
          </div>
          <div class="icon-logo">
            <svg xmlns="http://www.w3.org/2000/svg" width="80" height="80" fill="currentColor" class="bi bi-cash-stack" viewBox="0 0 16 16">
              <path d="M1 3a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1H1zm7 8a2 2 0 1 0 0-4 2 2 0 0 0 0 4z"/>
              <path d="M0 5a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V5zm3 0a2 2 0 0 1-2 2v4a2 2 0 0 1 2 2h10a2 2 0 0 1 2-2V7a2 2 0 0 1-2-2H3z"/>
            </svg>
            <h4 class="title">Fintech</h4>
          </div>
          
      </main>

      <!-- End Main -->
	<%@ include file="../footer.jsp"%>
	</body>
</html>