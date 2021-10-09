package modelo;

public class VentasDTO {

	
	private int codigo;
	private int cedula;
	private int cedula_Usuario;
	private double ivaventa;
	private double totalventa;
	private double valorventa;
	
	
	public VentasDTO( int cedula, int cedula_Usuario, double ivaventa, double totalventa,
			double valorventa) {
				
		this.cedula = cedula;
		cedula_Usuario = cedula_Usuario;
		this.ivaventa = ivaventa;
		this.totalventa = totalventa;
		this.valorventa = valorventa;
	}


	
	
	
	
	
	
	
	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public VentasDTO(int codigo, int cedula, int cedula_Usuario, double ivaventa, double totalventa, double valorventa) {
		super();
		this.codigo = codigo;
		this.cedula = cedula;
		cedula_Usuario = cedula_Usuario;
		this.ivaventa = ivaventa;
		this.totalventa = totalventa;
		this.valorventa = valorventa;
	}



	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public int getCedula_Usuario() {
		return cedula_Usuario;
	}
	public void setCedula_Usuario(int cedula_Usuario) {
		cedula_Usuario = cedula_Usuario;
	}
	public double getIvaventa() {
		return ivaventa;
	}
	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}
	public double getTotalventa() {
		return totalventa;
	}
	public void setTotalventa(double totalventa) {
		this.totalventa = totalventa;
	}
	public double getValorventa() {
		return valorventa;
	}
	public void setValorventa(double valorventa) {
		this.valorventa = valorventa;
	}
	
		
}
