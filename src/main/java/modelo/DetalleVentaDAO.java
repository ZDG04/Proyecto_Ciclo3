package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;
import modelo.DetalleVentaDTO;

public class DetalleVentaDAO {

	
	PreparedStatement ps=null;
	ResultSet res=null;
	Conexion con= new Conexion();
	Connection cnn=con.conexionbd();

	
	public boolean Inserta_Cliente(DetalleVentaDTO det){

		boolean resultado=false;
		
		try{
			
			ps =cnn.prepareStatement("Insert Into detalle_ventas(cantidad_producto,codigo_producto,codigo_venta,valor_venta,valor_iva, valor_total)   value(?,?,?,?,?,?);");
			ps.setInt(1, det.getCantidadproducto());
			ps.setLong(2, det.getCodigoproducto());
			ps.setLong(3, det.getCodigoventa());
			ps.setDouble(4, det.getValortotal());
			ps.setDouble(5, det.getValoriva());
			ps.setDouble(6, det.getValortotal());
			resultado=ps.executeUpdate()>0;
		//}
		}catch(SQLException ex){
		 JOptionPane.showMessageDialog(null, "Error al Insertar" +ex);
		}
		return resultado;
		}  	
	
	
	
	
}
