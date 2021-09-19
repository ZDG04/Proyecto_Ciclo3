package modelo;

public class UsuarioDTO {
 private int cedula;
 private String nombre;
 private String correo;
 private String usuario;
 private String password;
 
 
public UsuarioDTO(int cedula, String nombre, String correo, String usuario, String password) {
	this.cedula = cedula;
	this.nombre = nombre;
	this.correo = correo;
	this.usuario = usuario;
	this.password = password;
}


public UsuarioDTO(int cedula) {
	this.cedula = cedula;
}




public int getCedula() {
	return cedula;
}


public void setCedula(int cedula) {
	this.cedula = cedula;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getCorreo() {
	return correo;
}


public void setCorreo(String correo) {
	this.correo = correo;
}


public String getUsuario() {
	return usuario;
}


public void setUsuario(String usuario) {
	this.usuario = usuario;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}
	
 
	
}
