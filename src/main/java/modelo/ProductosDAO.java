package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ProductosDAO {

	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	
	
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
	
}
