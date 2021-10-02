package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProveedorDAO;
import modelo.ProveedorDTO;


/**
 * Servlet implementation class ServletProveedor
 */
@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProveedor() {
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
		
		String np,t,d,c;
		int nit;
		boolean f;
		ProveedorDTO prodto;
		ProveedorDAO prodao;
		ProveedorDTO recgdato;
		
		// CREAR PROVEEDOR
		if(request.getParameter("btncre")!=null) {
		nit=Integer.parseInt(request.getParameter("nit"));
		np=request.getParameter("nomp");
		d=request.getParameter("dir");
		t=request.getParameter("tel");
		c=request.getParameter("ciu");
		
		prodto=new ProveedorDTO(nit, np, d, t, c);
		prodao=new ProveedorDAO();
		f=prodao.crearproveedor(prodto);
		if(f==true) {
			JOptionPane.showMessageDialog(null, "Proveedor Registrado");
			response.sendRedirect("proveedores.jsp");		
		}
		else {
			JOptionPane.showMessageDialog(null,"Proveedor No Registrado");
			response.sendRedirect("proveedores.jsp");
		}
		}
		
		if(request.getParameter("btncon")!=null) {
			// CONSULTAR PROVEEDOR
			int doc;
			
			nit=Integer.parseInt(request.getParameter("nit"));	
			prodto=new ProveedorDTO(nit);
			prodao=new ProveedorDAO();
			recgdato=prodao.consultarproveedor(prodto);
			
			doc=recgdato.getNit();
			np=recgdato.getNombre();
			d=recgdato.getDireccion();
			t=recgdato.getTelefono();
			c=recgdato.getCiudad();
			
			response.sendRedirect("proveedores.jsp?nit="+nit+"&&nomp="+np
					+"&&dir="+d+"&&tel="+t+"&&ciu="+c);
					
			}
			
			if(request.getParameter("btnact")!=null) {
			// ACTUALIZAR PROVEEDOR
			boolean dat;
				
			nit=Integer.parseInt(request.getParameter("nit"));
			np=request.getParameter("nomp");
			d=request.getParameter("dir");
			t=request.getParameter("tel");
			c=request.getParameter("ciu");
			prodto=new ProveedorDTO(nit, np, d, t, c);
			prodao=new ProveedorDAO();
			dat=prodao.actualizarproveedor(prodto);
			if (dat==true) {
				JOptionPane.showMessageDialog(null,"Proveedor Actualizado");
				response.sendRedirect("proveedores.jsp");	
			}
			else {
				JOptionPane.showMessageDialog(null,"Proveedor No Fue Actualizado");
				response.sendRedirect("proveedores.jsp");
			}
			}
			
			if(request.getParameter("btnbor")!=null) {
			// BORRAR PROVEEDOR
				int y;
				nit=Integer.parseInt(request.getParameter("nit"));	
				prodto=new ProveedorDTO(nit);
				prodao=new ProveedorDAO();	
				y=prodao.borrarproveedor(prodto);
				if(y>0) {
					JOptionPane.showMessageDialog(null,"Proveedor Eliminado"); 
					response.sendRedirect("proveedores.jsp");			
				}
				else {
					JOptionPane.showMessageDialog(null,"Proveedor No Fue Eliminado");
					response.sendRedirect("proveedores.jsp");
				}		
			  }
			}

		}
	