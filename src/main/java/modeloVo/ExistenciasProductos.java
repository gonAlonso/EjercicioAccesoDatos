package modeloVo;

public class ExistenciasProductos {
	private String nombre;
	private int stock;
	private double precioCompra;
	private double total;
	
	public ExistenciasProductos(String nombre, int stock, double precioCompra, double total) {
		this.nombre = nombre;
		this.stock = stock;
		this.precioCompra = precioCompra;
		this.total = total;
	}
	public ExistenciasProductos() {
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
