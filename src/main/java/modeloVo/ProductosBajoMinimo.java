package modeloVo;

import java.util.ArrayList;

public class ProductosBajoMinimo {

	private int codigo;
	private String nombre;
	private double precioCompra;
	private int stock;
	private double precioVenta;
	private String nombreProveedor;
	private String telefono;
	public ProductosBajoMinimo(int codigo, String nombre, double precioCompra, int stock, double precioVenta,
			String nombreProveedor, String telefono) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.stock = stock;
		this.precioVenta = precioVenta;
		this.nombreProveedor = nombreProveedor;
		this.telefono = telefono;
	}
	public ProductosBajoMinimo() {
	}
	public int getCodigo() {
		return this.codigo;
	}
	public void setCodigo(int cod ) {
		this.codigo = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
