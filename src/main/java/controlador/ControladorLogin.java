package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class ControladorLogin
 */
@WebServlet("/ControladorLogin")
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String USUARIO = "admininicial";
	private final String PASSWORD = "admin123456";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogin() {
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
		// TODO Auto-generated method stub
		//doGet(request, response)
		String usuario, password;
		usuario = request.getParameter("usu");
		password = request.getParameter("pass");
		
		if ( request.getParameter("boton_enviar") != null ) {
			if ( usuario.equals(USUARIO) ) {
				if ( password.equals(PASSWORD) ) {
					JOptionPane.showMessageDialog(null, "Bienvenido al programa");
					response.sendRedirect("menu.jsp");
				} else {
					JOptionPane.showMessageDialog(null, "Datos no validos.");
					response.sendRedirect("index.jsp");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Datos no validos.");
				response.sendRedirect("index.jsp");
			}
		}
	}

}
