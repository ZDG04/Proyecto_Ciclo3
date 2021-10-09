<%@page import="controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.png" type="image/png" >
    <title>Reportes - Tienda Grupo 4</title>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/formularios.css">

</head>
<body>
<%  
	String ce="",n="",d="",t="",cr="";
	if(request.getParameter("do")!=null){
	ce=request.getParameter("do");
	n=request.getParameter("nomb");
	d=request.getParameter("dirr");
	t=request.getParameter("tele");
	cr=request.getParameter("core");
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
       
    </header>
    <main>
    <section class="secb8 secb">
       <!--  <img src="img/productos.png"> -->
    </section>

    <section class="secb2-1">
    <div class="pro">
    <h2 class="subtitulo stc">Gestión de</h2>
        <h1 class="titulo tc">REPORTES</h1>
        <hr class="hrc">
        <fieldset class="formularioc">
        
        
        
        
        
        
        
        
        
        
        
        
        <form action="PruebaVenta" method="post">
         <section class="ventas1">
                    <table class="tablar">
    <tbody>
        <tr>
            <td class="tdr" >   <input class="botonr" type="submit" name="btncon" value="LISTADO DE USUSARIOS"></td>               
        </tr>
        <tr>
            <td class="tdr">   <input class="botonr" type="submit" name="btncon" value="LISTADO DE CLIENTES"></td>          
        </tr>
        <tr>
           <td class="tdr">   <input class="botonr" type="submit" name="btncon" value="VENTAS POR CLIENTE"></td>

        </tr>        
    </tbody>
    
</table>
               <section class="reportes">    
 <table class="tablar2">
    <tbody>
        <tr>
            <th>Cédula</th>
            <th>Nombre</th>
            <th>Correo Electrónico</th>
            <th>Usuario</th>
            <th>Conraseña</th>
            </td>
                
        </tr>
        <tr>
            <td>1234567890</td>
            <td>Juan</td>
            <td>juan@coreo.com</td>
            <td>juanu</td>
            <td>contrase;a1</td>
        </tr>
        <tr>
            <td>087654321</td>
            <td>Hugo</td>
            <td>hugo@coreo.com</td>
            <td>hugou</td>
            <td>contrase;a2</td>
        </tr>
        <tr>
            <td>1324576890</td>
            <td>Claudia</td>
            <td>claudia@coreo.com</td>
            <td>claudiau</td>
            <td>contrase;a3</td>
        </tr>
       
    </tbody>
    </table>
 </section>
                   

</form>
         
</main>
    
    
   
</body>
<footer class="pata">
    <section class="secpie">
        <span class="textopie">
            <p>
                Este es un Software para gestionar transacciones comerciales de una tienda genérica,
                desarrollado para el ministerio TIC y la Universidad el Bosque como proyecto del ciclo 3 tomando la
                línea gráfica de <a href="https://uasqua.com/" target="_blank">uasqua.com</a></p>
        </span>
        <a href="img/politicas.pdf" target="_blank">
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