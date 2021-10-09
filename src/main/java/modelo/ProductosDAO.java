package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.ProductosDTO;
import controlador.Conexion;

public class ProductosDAO {

	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	
	
	ResultSet rs=null;
	ProductosDTO prodto;
	
	
	
	
public boolean cargarproductos(String URL) {
	JOptionPane.showMessageDialog(null, "en dao"+URL);
	boolean resul=false;
	
	try {
		ps=cnn.prepareStatement("load data infile '"+URL+"' into table productos fields terminated by ',' lines terminated by '\r\n';");
		resul=ps.executeUpdate()>0;
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Error al registrar el producto" + e);
	}
	return resul;
}

public ProductosDTO consultarproducto(ProductosDTO pro) {
	try {
		ps=cnn.prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
		ps.setInt(1, pro.getCodigoproducto());
		rs=ps.executeQuery();
		if(rs.next()){
		 prodto=new ProductosDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5),rs.getInt(6));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
			  
	return prodto;  
  }


}
