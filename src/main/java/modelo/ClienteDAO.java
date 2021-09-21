package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ClienteDAO {

	Conexion con = new Conexion();
	Connection cnn = con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	ClienteDTO cli;

public boolean crearCliente(ClienteDTO cli) {
	int x=0;
	boolean dato=false;
	try {
		ps=cnn.prepareStatement("INSERT INTO clientes VALUES (?,?,?,?,?)");
		ps.setInt(1, cli.getCedula());
		ps.setString(2, cli.getNombre());
		ps.setString(3, cli.getDireccion());
		ps.setString(4, cli.getTelefono());
		ps.setString(5, cli.getCorreo());
		x=ps.executeUpdate();
		if(x>0) {
			dato=true;
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"Error al insertar"+ e);
		
	}
	
	return dato;
	
}
public ClienteDTO consultarCliente(ClienteDTO cli) {
	try {
		ps=cnn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
		ps.setInt(1, cli.getCedula());
		rs=ps.executeQuery();
		if(rs.next()) {
			cli=new ClienteDTO(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return cli;
}

public int borrarCliente(ClienteDTO cli) {
	
	int x=0;
	try {
		ps=cnn.prepareStatement("DELETE FROM clientes WHERE cedula_cliente=?");
		ps.setInt(1, cli.getCedula());
		x=ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return x;
}

public boolean  actualizarCliente(ClienteDTO cli) {
	
	boolean dat=false;
	int x;
	
	try {
		ps=cnn.prepareStatement("UPDATE clientes SET nombre_cliente=?, direccion_cliente=?, telefono_cliente=?, email_cliente=? WHERE cedula_cliente=?");
		ps.setString(1, cli.getNombre());
		ps.setString(2, cli.getDireccion());
		ps.setString(3, cli.getTelefono());
		ps.setString(4, cli.getCorreo());
		ps.setInt(5, cli.getCedula());
		x=ps.executeUpdate();		
		if(x>0) {
			dat=true;
		}
				
	} catch (SQLException e) {
			e.printStackTrace();
	}
	
return dat;
}
}
	