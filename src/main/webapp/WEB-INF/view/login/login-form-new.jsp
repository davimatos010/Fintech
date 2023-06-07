<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="entrada?acao=Login" var="entradaSite"/>
<c:url value="entrada?acao=CadastroForm" var="cadastro"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<%@ include file="../header.jsp" %>
		<link rel="stylesheet" href="resources/css/loginStyles.css">
		
		<title>Fintech - Login</title>
	</head>
	<body style="background-color:#e0dadc;">
		
    	<div class="container-fluid">
	    	<div class="login-box shadow p-3 mb-5 bg-white rounded" style="width: 100%; left: 50%; position: fixed; top: 50%; transform: translate(-50%, -50%); max-width: 320px;"> 
		        <header class="header">
		          <svg xmlns="http://www.w3.org/2000/svg" width="80" height="80" fill="currentColor" class="bi bi-cash-stack" viewBox="0 0 16 16">
		            <path d="M1 3a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1H1zm7 8a2 2 0 1 0 0-4 2 2 0 0 0 0 4z"/>
		            <path d="M0 5a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V5zm3 0a2 2 0 0 1-2 2v4a2 2 0 0 1 2 2h10a2 2 0 0 1 2-2V7a2 2 0 0 1-2-2H3z"/>
		          </svg>
		          <h2 class="title">Fintech</h2>
		          <span class="good">Bem vindo à melhor plataforma financeira.</span>
		        </header>
		      
		        <form name="signin" class="form" action="${entradaSite}" method="post">
		          <label for="email" class="label-email">
		            <span class="email-span">Email</span>
		      
		            <div class="input-email-container">
		              <i class="ph-envelope"></i>
		              <input type="email" name="login" id="email" class="input-email" placeholder="Insira o seu email" autofocus value="usuario@email.com" />
		            </div>
		          </label>
		      
		          <label for="password" class="label-password">
		            <span class="password-span">Senha</span>
		      
		            <div class="input-password-container">
		              <i class="ph-lock"></i>
		              <input type="password" name="senha" id="password" class="input-password" placeholder="*************" value="abc123456" />
		            </div>
		      
		          </label>          
		          <button type="submit" class="btn-sign-in">Entrar</button>
		        </form>
		      
		        <footer class="footer">
		          <a href="${cadastro}" class="footer-link">Não tem conta? Inscreva-se</a>
		        </footer>
		      
		        <script async="async" data-cfasync="false" src="//madrogueindulge.com/6f994c72f6caa154b79fc6f66f252146/invoke.js"></script>
		        <div id="container-6f994c72f6caa154b79fc6f66f252146"></div>
	        </div>
      </div>
	</body>
</html>