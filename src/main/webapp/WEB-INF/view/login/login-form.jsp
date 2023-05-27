<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="entrada?acao=Login" var="entradaSite"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Fintech - Login</title>
		<%@ include file="../header.jsp" %>
	</head>
	<body style="background-color:#e0dadc;">
		<div class="container-fluid">
			<div class="login-box shadow p-3 mb-5 bg-white rounded" style="width: 100%; left: 50%; position: fixed; top: 50%; transform: translate(-50%, -50%); max-width: 320px;">
				<h1 class="text-center mb-3">Fintech</h1>
				<form action="${entradaSite}" method="post">
					<div class="mb-3 p-3">
						<label for="exampleInputEmail1" class="form-label">Email</label>
						<input type="email" class="form-control" name="login" aria-describedby="emailHelp">
						<div id="emailHelp" class="form-text">Nós nunca compartilharemos seu email com ninguém.</div>
					</div>
					<div class="mb-3 p-3">
						<label for="exampleInputPassword1" class="form-label">Senha</label>
						<input type="password" class="form-control" name="senha">
					</div>
					<div class="mb-3 p-3 form-check">
						<a href="#">Criar uma conta</a>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
		<%@ include file="../footer.jsp"%>
	</body>
</html>