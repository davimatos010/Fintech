<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="entrada?acao=Cadastro" var="cadastrar"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Fintech - Cadastro</title>
		<%@ include file="../header.jsp" %>
	</head>
	<body style="background-color:#e0dadc;">
		<div class="container-fluid">
			<div class="login-box shadow p-3 mb-5 bg-white rounded" style="width: 100%; left: 50%; position: fixed; top: 50%; transform: translate(-50%, -50%); max-width: 320px;">
				<h1 class="text-center mb-3">Fintech</h1>
				<form action="${cadastrar}" method="post">
					<div class="mb-2 p-2">
						<label for="nome" class="form-mail mb-2">Nome</label>
						<input type="text" class="form-control" name="nome" required>
					</div>
					<div class="mb-2 p-2">
						<label for="dataNascimento" class="form-mail mb-2">Data de nascimento</label>
						<input type="date" class="form-control" name="dataNascimento" required>
					</div>
					<div class="mb-2 p-2">
						<label for="genero" class="form-mail mb-2">Gênero</label>
						<select class="form-control" name="genero" required>
							<option>Outros</option>
							<option>Feminino</option>
							<option>Masculino</option>
						</select>
					</div>
					<div class="mb-2 p-2">
						<label for="email" class="form-mail mb-2">Email</label>
						<input type="email" class= "form-control" name="email" required>
					</div>
					<div class="mb-2 p-2">
						<label for="senha" class="form-mail mb-2">Senha</label>
						<input type="password" class="form-control" name="senha" required>
					</div>
					<div class="d-grid gap-2">
						<input class="btn btn-success" type="submit" value="Cadastrar">
					</div>
				</form>
			</div>
		</div>

	</body>
</html>