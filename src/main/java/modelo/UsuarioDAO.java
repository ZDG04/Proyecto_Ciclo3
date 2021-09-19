package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class UsuarioDAO {
	
Conexion con=new Conexion();
Connection cnn=con.conexionbd();
PreparedStatement ps;
ResultSet rs;
UsuarioDTO usu;

public boolean crearusuario(UsuarioDTO us) {
	int x=0;
	boolean dato=false;
	try {
		ps=cnn.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?,?)");
		ps.setInt(1, us.getCedula());
		ps.setString(2, us.getNombre());
		ps.setString(3, us.getCorreo());
		ps.setString(4, us.getUsuario());
		ps.setString(5, us.getPassword());
		x=ps.executeUpdate();
		if(x>0) {
			dato=true;
		}
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"Error al insertar"+ e);
		
	}
	
	return dato;
	
}

public UsuarioDTO consultarusuario(UsuarioDTO us) {

	try {
		ps=cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
		ps.setInt(1, us.getCedula());
		rs=ps.executeQuery();
		if(rs.next()) {
			usu=new UsuarioDTO(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return usu;
}

public int borrarusuario(UsuarioDTO us) {
	
	int x=0;
	try {
		ps=cnn.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?");
		ps.setInt(1, us.getCedula());
		x=ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return x;
}

public boolean  actualizarusuario(UsuarioDTO us) {
	
	boolean dat=false;
	int x;
	
	try {
		ps=cnn.prepareStatement("UPDATE usuarios SET nombre_usuario=?, email_usuario=?, usuario=?, password_usuario=? WHERE cedula_usuario=?");
		ps.setString(1, us.getNombre());
		ps.setString(2, us.getCorreo());
		ps.setString(3, us.getUsuario());
		ps.setString(4, us.getPassword());
		ps.setInt(5, us.getCedula());
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
	

