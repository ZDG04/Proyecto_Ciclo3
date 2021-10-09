package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.swing.JOptionPane;

import modelo.DetalleVentaDAO;
import modelo.DetalleVentaDTO;
import modelo.VentasDAO;
import modelo.VentasDTO;
import modelo.ProductosDTO;
import modelo.UsuarioDTO;
import modelo.ProductosDAO;
import modelo.ClienteDAO;
import modelo.ClienteDTO;




/**
 * Servlet implementation class ServletVentas
 */
@WebServlet("/ServletVentas")
public class ServletVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double iva1,iva2,iva3;   
	int  cant1,cant2,cant3;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVentas() {
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
		
		HttpSession sesion=request.getSession();
		if(request.getParameter("confirmar")!=null) {
		int cedula,ced;
		String nom;
	
				
		ClienteDTO listado;
		cedula=Integer.parseInt(request.getParameter("cedula"));
		ClienteDAO clidao=new ClienteDAO();
		ClienteDTO clidto=new ClienteDTO(cedula);
		listado=clidao.consultarCliente(clidto);
		
		sesion.setAttribute("cliente",listado);
		request.getRequestDispatcher("ventas.jsp").forward(request, response);
		
		}
		
		
		if(request.getParameter("producto1")!=null) {
			
			int codpro;
			ProductosDTO listapro1;
			codpro=Integer.parseInt(request.getParameter("codigo1"));
			ProductosDTO podto=new ProductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro1=prodao.consultarproducto(podto);
			iva1= listapro1.getIvacompra() ;
			sesion.setAttribute("produc1",listapro1);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
			
			
			
		} 
		
		if(request.getParameter("producto2")!=null) {
			
			int codpro;
			ProductosDTO listapro2;
			codpro=Integer.parseInt(request.getParameter("codigo2"));
			ProductosDTO podto=new ProductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro2=prodao.consultarproducto(podto);
			iva2= listapro2.getIvacompra() ;
			sesion.setAttribute("produc2",listapro2);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
			
			
		} 
	
		
		if(request.getParameter("producto3")!=null) {
			
			int codpro;
			ProductosDTO listapro3;
			codpro=Integer.parseInt(request.getParameter("codigo3"));
			ProductosDTO podto=new ProductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro3=prodao.consultarproducto(podto);
			iva3= listapro3.getIvacompra();
			sesion.setAttribute("produc3",listapro3);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
			
			
		} 
		
		
		double tot,tot1,tot2,res,res1,res2,totalsiniva,totaliva,totaldesiva;
		UsuarioDTO usdto=null;
	
		sesion.setAttribute("vs",usdto);
		
		if(request.getParameter("venta")!=null) {
		   double total1,total2,total3;
		
		  
			cant1=Integer.parseInt(request.getParameter("can"));
			cant2=Integer.parseInt(request.getParameter("can1"));
			cant3=Integer.parseInt(request.getParameter("can2"));
			
			tot=Double.parseDouble(request.getParameter("precio"));
			tot1=Double.parseDouble(request.getParameter("precio1"));
			tot2=Double.parseDouble(request.getParameter("precio2"));
			
			
			res=cant1*tot;
			res1=cant2*tot1;
			res2=cant3*tot2;
			total1=res*iva1/100;
			total2=res1*iva2/100;
			total3=res2*iva3/100;
			totalsiniva=res+res1+res2;
			totaliva=total1+total2+total3;
			totaldesiva=totalsiniva+totaliva;
			
			
		    
			int i=JOptionPane.showConfirmDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n" );
		    JOptionPane.showMessageDialog(null, "Imprimiendo la factura " +i);
		    if(i==0) {
			    
		    	int cedcli,cedusu;
			    int cc,cu;
			    double iva,tv,vv;
			    boolean ress;
			    
			    cedcli=Integer.parseInt(request.getParameter("cedula"));
			    cedusu=Integer.parseInt(request.getParameter("cu"));
			    iva=totaliva;
			    tv=totalsiniva;
			    vv=totaldesiva;
			    cc=cedcli;
			    cu=cedusu;	
			    
			    VentasDTO ven=new VentasDTO(cc, cu, iva, tv,vv);
			    VentasDAO vendao=new VentasDAO();
			    ress=vendao.insertarventa(ven);
			    
			    if(ress) {
			    JOptionPane.showMessageDialog(null, "Venta registrada");
			    int can;
			    int cv;
			    double iv,dtv,dvv;
			    boolean x;
			    VentasDTO venn;
			    DetalleVentaDTO dd;
			    DetalleVentaDAO dedao;
			    int codpro=Integer.parseInt(request.getParameter("codigo1"));
			    VentasDAO vend=new VentasDAO();
			    venn=vend.consultarcodventa();
			  
			     can=cant1;
			     if(can>0) {
			   
				    cv=venn.getCodigo();
				    iv=ven.getIvaventa();
				    dtv=ven.getTotalventa();
				    dvv=ven.getValorventa();
				    dd=new DetalleVentaDTO(can, cv, codpro, iva, iva,total1);
				    dedao=new DetalleVentaDAO();
				    x=dedao.Inserta_Cliente(dd);
				    	if(x) {
				    		JOptionPane.showMessageDialog(null, "detalle insertado");
				    	}
			     }
			     
			     
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     
			     
			     
			     can=cant2;
			     if(can>0) {
					   
					    cv=venn.getCodigo();
					    iv=ven.getIvaventa();
					    dtv=ven.getTotalventa();
					    dvv=ven.getValorventa();
					    dd=new DetalleVentaDTO(can, cv, codpro, iva, iva,total2);
					    dedao=new DetalleVentaDAO();
					    x=dedao.Inserta_Cliente(dd);
					    	if(x) {
					    		JOptionPane.showMessageDialog(null, "detalle insertado");
					    	}
					     }
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     
			     
			     
			     can=cant3;
			     if(can>0) {
					   
					    cv=venn.getCodigo();
					    iv=ven.getIvaventa();
					    dtv=ven.getTotalventa();
					    dvv=ven.getValorventa();
					    dd=new DetalleVentaDTO(can, cv, codpro, iva, iva,total3);
					    dedao=new DetalleVentaDAO();
					    x=dedao.Inserta_Cliente(dd);
					    if(x) {
					    	JOptionPane.showMessageDialog(null, "detalle insertado");
					    	response.sendRedirect("menuprincipal.jsp");
					    }
				 }
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     
			     
			     
			    }
			    else {
			    	JOptionPane.showMessageDialog(null, "Venta NO registrada");
			    }
			    	
		  }

		
		}	
		
		
	}

}
