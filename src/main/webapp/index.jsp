<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.png" type="image/png">
    <title>Login - Tienda Grupo 4</title>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/formularios.css">
</head>    


<body>
    <header class="cont_header" id="cont">
        <div class="titulo-logo">
            <div class="logo" id="logo"></div>
        </div>
        <h1>Bievenidos a nuestra tienda</h1>        
    </header>
    <fieldset class="formulariol">
         <form action="ControladorLogin" method="POST">
            
            <input type="text" name="usu" placeholder="Usuario">
            <input type="password" name="pass" placeholder="Contraseña">
            <input type="submit" name="boton_enviar" value="INGRESAR">
            <input type="submit" name="btn" value="CANCELAR">
            
        </form>
    </fieldset>
    <section class="espaciologin">
    </section>
    
    <footer>

    </footer>
</body>

</html>