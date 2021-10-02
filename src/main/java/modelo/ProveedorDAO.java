package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ProveedorDAO {
	
Conexion con=new Conexion();
Connection cnn=con.conexionbd();
PreparedStatement ps;
ResultSet rs;
ProveedorDTO pro;

public boolean crearproveedor(ProveedorDTO pr) {
	int x=0;
	boolean dato=false;
	try {
		ps=cnn.prepareStatement("INSERT INTO Proveedores VALUES (?,?,?,?,?)");
		ps.setInt(1, pr.getNit());
		ps.setString(2, pr.getNombre());
		ps.setString(3, pr.getDireccion());
		ps.setString(4, pr.getTelefono());
		ps.setString(5, pr.getCiudad());
		
		x=ps.executeUpdate();
		if(x>0) {
			dato=true;
		}
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"Error al insertar"+ e);
		
	}
	
	return dato;
	
}

public ProveedorDTO consultarproveedor(ProveedorDTO pr) {

	try {
		ps=cnn.prepareStatement("SELECT * FROM Proveedores WHERE nitproveedor=?");
		ps.setInt(1, pr.getNit());
		rs=ps.executeQuery();
		if(rs.next()) {
			pro=new ProveedorDTO(rs.getInt(1),rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return pro;
}

public int borrarproveedor(ProveedorDTO pr) {
	
	int x=0;
	try {
		ps=cnn.prepareStatement("DELETE FROM Proveedores WHERE nitproveedor=?");
		ps.setInt(1, pr.getNit());
		x=ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return x;
}

public boolean  actualizarproveedor(ProveedorDTO pr) {
	
	boolean dat=false;
	int x;
	
	try {
		ps=cnn.prepareStatement("UPDATE Proveedores SET nombre_proveedor=?, direccion_proveedor=?, telefono_proveedor=?, ciudad_proveedor=? WHERE nitproveedor=?");
		ps.setString(1, pr.getNombre());
		ps.setString(2, pr.getDireccion());
		ps.setString(3, pr.getTelefono());
		ps.setString(4, pr.getCiudad());
		ps.setInt(5, pr.getNit());
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
	

