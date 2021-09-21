package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ClienteDAO;
import modelo.ClienteDTO;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
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
		String n,d,t, cr;
		int ce ;
		boolean f;
		ClienteDTO clidto;
		ClienteDAO clidao;
		ClienteDTO recgdato;
		
		//Crear Usuario
		
		if(request.getParameter("btncre")!=null) {
			ce=Integer.parseInt(request.getParameter("ced"));
			n=request.getParameter("nom");
			d=request.getParameter("dir");
			t=request.getParameter("tel");
			cr=request.getParameter("cor");
			
			clidto=new ClienteDTO(ce, n, d, t, cr);
			clidao=new ClienteDAO();
			f=clidao.crearCliente(clidto);
			if(f==true) {
				JOptionPane.showMessageDialog(null, "Cliente Registrado");
				response.sendRedirect("clientes.jsp");		
			}
			else {
				JOptionPane.showMessageDialog(null,"Cliente No Registrado");
				response.sendRedirect("clientes.jsp");
			}
			}
			
		if(request.getParameter("btncon")!=null) {
			// Consultar Cliente
			int doc;
			
			ce=Integer.parseInt(request.getParameter("ced"));	
			clidto=new ClienteDTO(ce);
			clidao=new ClienteDAO();
			recgdato=clidao.consultarCliente(clidto);
			
			doc=recgdato.getCedula();
			n=recgdato.getNombre();
			d=recgdato.getDireccion();
			t=recgdato.getTelefono();
			cr=recgdato.getCorreo();
			
			response.sendRedirect("clientes.jsp?do="+doc+"&&nomb="
			+n+"&&dirr="+d+"&&tele="+t+"&&core="+cr);
			}
			
			if(request.getParameter("btnact")!=null) {
			// Actualizar Cliente
			boolean dat;
				
			ce=Integer.parseInt(request.getParameter("ced"));
			n=request.getParameter("nom");
			d=request.getParameter("dir");
			t=request.getParameter("tel");
			cr=request.getParameter("cor");
			clidto=new ClienteDTO(ce, n, d, t, cr);
			clidao=new ClienteDAO();
			dat=clidao.actualizarCliente(clidto);
			if (dat==true) {
				JOptionPane.showMessageDialog(null,"Cliente Actualizado");
				response.sendRedirect("clientes.jsp");	
			}
			else {
				JOptionPane.showMessageDialog(null,"Cliente No Fue Actualizado");
				response.sendRedirect("clientes.jsp");
			}
			}
			
			if(request.getParameter("btnbor")!=null) {
			// Borrar Cliente
				int y;
				ce=Integer.parseInt(request.getParameter("ced"));	
				clidto=new ClienteDTO(ce);
				clidao=new ClienteDAO();	
				y=clidao.borrarCliente(clidto);
				if(y>0) {
					JOptionPane.showMessageDialog(null,"Cliente Eliminado"); 
					response.sendRedirect("clientes.jsp");			
				}
				else {
					JOptionPane.showMessageDialog(null,"Cliente No Fue Eliminado");
					response.sendRedirect("clientes.jsp");
				}
				
			}
		}

		}
	