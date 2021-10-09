package modelo;

public class ProductosDTO {
	
	private int codigoproducto;
	private String nombreproducto;
	private double preciocompra;
	private double ivacompra;
	private double precioventa;
	private int nitproveedor;
	
	
	
	
	public ProductosDTO(int codigoproducto, String nombreproducto, double preciocompra, double ivacompra,
			double precioventa, int nitproveedor) {
	
		this.codigoproducto = codigoproducto;
		this.nombreproducto = nombreproducto;
		this.preciocompra = preciocompra;
		this.ivacompra = ivacompra;
		this.precioventa = precioventa;
		this.nitproveedor = nitproveedor;
	}




	public ProductosDTO(int codigoproducto) {
		this.codigoproducto = codigoproducto;
	}




	public int getCodigoproducto() {
		return codigoproducto;
	}
	public void setCodigoproducto(int codigoproducto) {
		this.codigoproducto = codigoproducto;
	}
	public double getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}
	public int getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public String getNombreproducto() {
		return nombreproducto;
	}
	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}
	public double getPreciocompra() {
		return preciocompra;
	}
	public void setPreciocompra(double preciocompra) {
		this.preciocompra = preciocompra;
	}
	public double getPrecioventa() {
		return precioventa;
	}
	public void setPrecioventa(double precioventa) {
		this.precioventa = precioventa;
	}


	
}
