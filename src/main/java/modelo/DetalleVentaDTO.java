package modelo;

public class DetalleVentaDTO {

	private int cantidadproducto;
	private int codigoventa;
	private int codigoproducto;
	private int codigodetalleventa;
	private double valortotal;
	private double valorventa;
	private double valoriva;
	
	
	
	
	public DetalleVentaDTO(int cantidadproducto, int codigoventa, int codigoproducto, int codigodetalleventa,
			double valortotal, double valorventa, double valoriva) {
		super();
		this.cantidadproducto = cantidadproducto;
		this.codigoventa = codigoventa;
		this.codigoproducto = codigoproducto;
		this.codigodetalleventa = codigodetalleventa;
		this.valortotal = valortotal;
		this.valorventa = valorventa;
		this.valoriva = valoriva;
	}
	
	
	
	
	public DetalleVentaDTO(int cantidadproducto, int codigoventa, int codigoproducto, double valortotal,
			double valorventa, double valoriva) {
		super();
		this.cantidadproducto = cantidadproducto;
		this.codigoventa = codigoventa;
		this.codigoproducto = codigoproducto;
		this.valortotal = valortotal;
		this.valorventa = valorventa;
		this.valoriva = valoriva;
	}








	public int getCodigodetalleventa() {
		return codigodetalleventa;
	}
	public void setCodigodetalleventa(int codigodetalleventa) {
		this.codigodetalleventa = codigodetalleventa;
	}
	public int getCantidadproducto() {
		return cantidadproducto;
	}
	public void setCantidadproducto(int cantidadproducto) {
		this.cantidadproducto = cantidadproducto;
	}
	public int getCodigoventa() {
		return codigoventa;
	}
	public void setCodigoventa(int codigoventa) {
		this.codigoventa = codigoventa;
	}
	public int getCodigoproducto() {
		return codigoproducto;
	}
	public void setCodigoproducto(int codigoproducto) {
		this.codigoproducto = codigoproducto;
	}
	public double getValortotal() {
		return valortotal;
	}
	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}
	public double getValorventa() {
		return valorventa;
	}
	public void setValorventa(double valorventa) {
		this.valorventa = valorventa;
	}
	public double getValoriva() {
		return valoriva;
	}
	public void setValoriva(double valoriva) {
		this.valoriva = valoriva;
	}
	
	
	
}
