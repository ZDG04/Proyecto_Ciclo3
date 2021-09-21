package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
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
		 
		String n,cr,u,p;
		int ce;
		boolean f;
		UsuarioDTO usdto;
		UsuarioDAO usdao;
		UsuarioDTO recgdato;
		
		// Crear Usuario
		if(request.getParameter("btncre")!=null) {
		ce=Integer.parseInt(request.getParameter("ced"));
		n=request.getParameter("nom");
		cr=request.getParameter("cor");
		u=request.getParameter("usu");
		p=request.getParameter("pass");
		
		usdto=new UsuarioDTO(ce, n, cr, u, p);
		usdao=new UsuarioDAO();
		f=usdao.crearusuario(usdto);
		if(f==true) {
			JOptionPane.showMessageDialog(null, "Usuario Registrado");
			response.sendRedirect("usuarios.jsp");		
		}
		else {
			JOptionPane.showMessageDialog(null,"Usuario No Registrado");
			response.sendRedirect("usuarios.jsp");
		}
		}
		
		if(request.getParameter("btncon")!=null) {
			// Consultar Usuario
			int doc;
			
			ce=Integer.parseInt(request.getParameter("ced"));	
			usdto=new UsuarioDTO(ce);
			usdao=new UsuarioDAO();
			recgdato=usdao.consultarusuario(usdto);
			
			doc=recgdato.getCedula();
			n=recgdato.getNombre();
			cr=recgdato.getCorreo();
			u=recgdato.getUsuario();
			p=recgdato.getPassword();
			
			response.sendRedirect("usuarios.jsp?do="+doc+"&&nomb="+n
					+"&&crr="+cr+"&&usua="+u+"&&pas="+p);
					
			}
			
			if(request.getParameter("btnact")!=null) {
			// Actualizar Usuario
			boolean dat;
				
			ce=Integer.parseInt(request.getParameter("ced"));
			n=request.getParameter("nom");
			cr=request.getParameter("cor");
			u=request.getParameter("usu");
			p=request.getParameter("pass");
			usdto=new UsuarioDTO(ce, n, cr, u, p);
			usdao=new UsuarioDAO();
			dat=usdao.actualizarusuario(usdto);
			if (dat==true) {
				JOptionPane.showMessageDialog(null,"Usuario Actualizado");
				response.sendRedirect("usuarios.jsp");	
			}
			else {
				JOptionPane.showMessageDialog(null,"Usuario No Fue Actualizado");
				response.sendRedirect("usuarios.jsp");
			}
			}
			
			if(request.getParameter("btnbor")!=null) {
			// Borrar Usuario
				int y;
				ce=Integer.parseInt(request.getParameter("ced"));	
				usdto=new UsuarioDTO(ce);
				usdao=new UsuarioDAO();	
				y=usdao.borrarusuario(usdto);
				if(y>0) {
					JOptionPane.showMessageDialog(null,"Usuario Eliminado"); 
					response.sendRedirect("usuarios.jsp");			
				}
				else {
					JOptionPane.showMessageDialog(null,"Usuario No Fue Eliminado");
					response.sendRedirect("usuarios.jsp");
				}		
			  }
			}

		}
	