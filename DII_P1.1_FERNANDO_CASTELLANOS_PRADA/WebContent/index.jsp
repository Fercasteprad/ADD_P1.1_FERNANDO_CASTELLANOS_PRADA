<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
    <div class ="centrar">
        <form action="<%=request.getContextPath()%>/Form" method="get">
            <input class="barras" type ="text" id="name" name="nombre" placeholder="Introduce usuario"><br>
            <input class="barras" type ="password" id= "pass01" name="pass" placeholder="Introduce contraseña"><br>
            <input class="barras" type ="password" id = "pass02" name="pass2" placeholder="Introduce de nuevo la contraseña"><br>
            <div class ="centrar">
                <input id="boton" type ="submit" name="boton" placeholder="Enviar">
            </div>    
        </form>
    </div>
     
      
</body>
</html>
