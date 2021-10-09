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
    <title>Ventas - Tienda Grupo 4</title>
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
    <section class="secb7 secb">
       <!--  <img src="img/productos.png"> -->
    </section>

    <section class="secb2-1">
    <div>
    <h2 class="subtitulo stc">Gestión de</h2>
        <h1 class="titulo tc">VENTAS</h1>
        <hr class="hrc">
        <fieldset class="formularioc">
        
        
        
         <form action="ServletVentas" method="post">
         <section class="ventas1">
                    <input type="text" name="cedula" value="${cliente.getCedula()}" placeholder="Cédula">
                    <input type="text" name="nombre" value="${cliente.getNombre()}" placeholder="Nombre">
                    <input type="submit" name="confirmar" value="CONSULTAR" >
                    </section>
               <section class="ventas2">    
<table>
    <tbody>
        <tr>
            <th class="codigov">Código</th>
            <th class="consultarv"></th>
            <th class="nombrev">Nombre</th>
            <th class="cantidadv">Cantidad</th>
            <th class="preciov">Precio</th>
        </tr>


        <tr>
            <td><input type="text" name="codigo1" value="${produc1.getCodigoproducto()}"  ></td>
            <td> <input type="submit" name="producto1" value="CONSULTAR" class="botonv" ></td>
            <td> <input type="text" class="nombre" name="n2" value="${produc1.getNombreproducto()}"  ></td>
            <td> <input type="text" class="cantidad cant"  id="cantidad" name="can"   ></td>
            <td> <input type="text" class="pre" id="pre" name="precio" value="${produc1.getPrecioventa()}"  ></td>
                
        </tr>
        <tr>
            <td><input type="text" name="codigo2" value="${produc2.getCodigoproducto()}"  ></td>
            <td> <input type="submit" name="producto2" value="CONSULTAR" class="botonv" ></td>
            <td> <input type="text" class="nombre" name="n2" value="${produc2.getNombreproducto()}"  ></td>
            <td> <input type="text" class="cantidad1 cant"  id="cantidad1" name="can1"  ></td>
            <td> <input type="text" class="pre"  id="pre1" name="precio1" value="${produc2.getPrecioventa()}"  ></td>

        </tr>
        <tr>
           <td><input type="text" name="codigo3" value="${produc3.getCodigoproducto()}"  ></td>
            <td> <input type="submit" name="producto3" value="CONSULTAR" class="botonv" ></td>
            <td> <input type="text" class="nombre" name="n2" value="${produc3.getNombreproducto()}"  ></td>
            <td> <input type="text" class="cantidad2 cant" id="cantidad2" name="can2" ></td>
            <td> <input type="text" class="pre"  id="pre2" name="precio2" value="${produc3.getPrecioventa()}"  ></td>

        </tr>
        
        <tr><td class="ult" colspan="5"><input type="submit" name="venta" value="ENVIAR"></td></tr>
        
    </tbody>
    
</table>
   
	<input type="text" name="cu" value="${vs.getCedula_Usuario()}"  >
	
	 
 </section>
                   

</form>
        
        
        
        
        
        
        
        
        
            <!-- <form action="ServletCliente" method="post">
                <input type="text" name="nom" placeholder="Nombre del Archivo"     value = "<%=n%>">
                <input type="submit" name="btncon" value="EXAMINAR">
                <input type="submit" name="btncre" value="CARGAR"> -->

            </form>
        </fieldset>
      </div>
    </section>
    
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