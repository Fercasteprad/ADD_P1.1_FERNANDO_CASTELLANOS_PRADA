<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dam2.dii.p11.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Saludo</title>
</head>
<body>
    <div class="centrar">
        <h1> Hola 
        <%
        Usuario user = (Usuario) request.getAttribute("usuario");
        String nombre = user.getNombre();
        %>
        <%= nombre %>
        </h1>
    </div>
    
</body>
</html>