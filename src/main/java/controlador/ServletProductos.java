package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.ProductosDAO;

/**
 * Servlet implementation class ServletProductos
 */
@WebServlet("/ServletProductos")
@MultipartConfig
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Part inform= request.getPart("archivo");
		 String Url="C:\\\\Users\\\\klaud\\\\eclipse-workspace\\\\ProyectoCiclo3\\\\src\\\\main\\\\webapp\\\\documentos\\\\";
		 
		   if(request.getParameter("btncargue")!=null) {
			   
			 try {  
			 InputStream  file= inform.getInputStream();
			 
			 File copia=new File(Url+"productos.csv");
			 FileOutputStream escribir=new FileOutputStream(copia);
			 int num=file.read();
			 while(num !=-1) {
				 
				 escribir.write(num);
				 num=file.read();
			 }
			 
			 file.close();
			 escribir.close();
			 
			 boolean x;
			 JOptionPane.showMessageDialog(null,"Se cargo el archivo correctamente");
			 
			 ProductosDAO proddao=new ProductosDAO(); 
			 x=proddao.cargarproductos(Url+"productos.csv");
			 if(x) {
				 JOptionPane.showMessageDialog(null,"Datos cargados en la BD");
				 response.sendRedirect("productos.jsp");
			 }
			 
			 else
			 {
				 JOptionPane.showMessageDialog(null,"No se cargaron los datos");
				 response.sendRedirect("productos.jsp");
			 }	 
			 }catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Error al cargar el archivo"+e);
				 response.sendRedirect("productos.jsp");
			 }
		   }

		   }
}

		
		
		
		
		
		
		
		
		
		
	