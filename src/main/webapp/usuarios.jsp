<%@page import="controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.png" type="image/png" />
    <title>Usuarios - Tienda Grupo 4</title>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/formularios.css">

</head>

<body>
<%
//Conexion con=new Conexion();
//con.conexionbd();

String ce="",n="",cr="",u="",p="";

if(request.getParameter("do")!=null){
ce=request.getParameter("do");
n=request.getParameter("nomb");
cr=request.getParameter("crr");
u=request.getParameter("usua");
p=request.getParameter("pas");
}

%>

    <header class="cont_header" id="cont">
        <div class="titulo-logo">
            <div class="logo" id="logo"></div>
        </div>
        <nav class="cont_nav">
            <ul>
               <li><a href="menu.jsp">inicio</a></li>
                <li><a href="usuarios.jsp">usuarios</a></li>
                <li><a href="clientes.jsp">clientes</a></li>
                <li><a href="proveedores.jsp">proveedores</a></li>
                <li><a href="productos.jsp">productos</a></li>
                <li><a href="ventas.jsp">ventas</a></li>
                <li><a href="reportes.jsp">reportes</a></li>
            </ul>
        </nav>
        <h1>USUARIOS</h1>
    </header>

<main>
    <section class="secb1 secb">
        
    </section>

    <section class="secb2">
        <fieldset class="formulariou">
            <form action="ServletUsuario" method="post">
                <input type="text" name="ced" placeholder="Cédula"             value="<%=ce%>">
                <input type="text" name="nom" placeholder="Nombre Completo"    value="<%=n%>">
                <input type="text" name="cor" placeholder="Correo Electrónico" value="<%=cr%>">
                <input type="text" name="usu" placeholder="Usuario"            value="<%=u%>">
                <input type="password" name="pass" placeholder="Contraseña"    value="<%=p%>">
                <input type="submit" name="btncon" value="CONSULTAR">
                <input type="submit" name="btncre" value="CREAR">
                <input type="submit" name="btnact" value="ACTUALIZAR">
                <input type="submit" name="btnbor" value="BORRAR">
            </form>
        </fieldset>
      
    </section>
    
</main>
</body>

<footer>
    <section class="secpie">
        <span class="textopie">
            <p>
                Este es un Software para gestionar transacciones comerciales de una tienda genérica,
                desarrollado para el ministerio TIC y la Universidad el Bosque como proyecto del ciclo 3 tomando la
                línea gráfica de <a href="https://uasqua.com/" target="_blank">uasqua.com</a></p>
        </span>
        <button name="" type="button" class="botonpie">Políticas</button>
        </a>
    </section>

    <section class="secpie1 secpie">
        <span class="centro">
            <p>
                <img src="img/logo-ueb-blanco.png">
                <img src="img/logo-MinTIC.png" width="80%">
            </p>
        </span>
    </section>

    <section class="secpie centro">
        <h2>
            Creado por:
        </h2>
        <br>
        <span class="textopie">
            <p>
                <a href="https://github.com/CLAUPL28" target="_blank">Claudia Patricia Perez Lopez</a><br>
                <a href="https://github.com/ZDG04" target="_blank">Zarith Dorelly Gomez Vargas</a><br>
                <a href="https://github.com/QUIROZIN20" target="_blank">Hugo Andres Quiroz Zamora</a><br>
                <a href="https://github.com/Jhun-K" target="_blank">David Jhun Kim Cubides</a><br>
                <a href="https://reiz.co/" target="_blank">Juan Carlos Rodríguez Martínez</a>
            </p>
        </span>
    </section>
</footer>

</html>